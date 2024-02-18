package org.netbeans.modules.php.blade.editor.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;

import org.netbeans.modules.csl.api.Error;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.api.Snapshot;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.Severity;
import org.netbeans.modules.php.blade.editor.compiler.BladePhpCompiler;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.navigator.BladeStructureItem;
import org.netbeans.modules.php.blade.editor.navigator.BladeStructureItem.DirectiveBlockStructureItem;
import org.netbeans.modules.php.blade.editor.navigator.BladeStructureItem.DirectiveInlineStructureItem;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParser;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParserBaseListener;
import org.netbeans.modules.php.editor.parser.PHPParseResult;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
public class BladeParserResult extends ParserResult {

    public final List<Error> errors = new ArrayList<>();
    public final Map<String, Reference> references = new TreeMap<>();
    private final Map<String, Reference> yieldReferences = new TreeMap<>();
    private final Map<String, Reference> stackReferences = new TreeMap<>();
    public final Map<String, List<OffsetRange>> includeBladeOccurences = new HashMap<>();
    public final Map<OffsetRange, Reference> occurancesForDeclaration = new TreeMap<>();
    public final Map<OffsetRange, String> phpClassOccurences = new TreeMap<>();
    public final Map<OffsetRange, String> phpFunctionOccurences = new TreeMap<>();
    public final Map<OffsetRange, Reference> phpMethodOccurences = new TreeMap<>();
    public final Map<OffsetRange, String> phpConstantOccurences = new TreeMap<>();
    public final Map<OffsetRange, String> phpNamespacePathOccurences = new TreeMap<>();
    public final Map<OffsetRange, Reference> customDirectivesReferences = new TreeMap<>();
    public final Map<OffsetRange, FieldAccessReference> fieldCallType = new TreeMap<>();
    public final Map<OffsetRange, Set<String>> scopedVariables = new TreeMap<>();
    public final List<BladeStructureItem> structure = new ArrayList<>();
    public final List<OffsetRange> folds = new ArrayList<>();

    protected PHPParseResult phpParserResult;

    protected BladeIndex bladeIndex = null;

    volatile boolean finished = false;
    volatile boolean indexLoaded = false;

    public enum ReferenceType {
        YIELD, STACK, SECTION, PUSH, PUSH_IF, PREPEND, INCLUDE, INCLUDE_IF,
        INCLUDE_COND, EXTENDS, EACH, HAS_SECTION,
        SECTION_MISSING, USE, INJECT, CUSTOM_DIRECTIVE,
        PHP_FUNCTION, PHP_CLASS, PHP_METHOD, PHP_CONSTANT, PHP_NAMESPACE, PHP_NAMESPACE_PATH,
        STATIC_FIELD_ACCESS,
        TEMPLATE_PATH,
    }

    public enum ParserContext {
        EXTENDS(BladeAntlrParser.ExtendsContext.class.getSimpleName()),
        INCLUDE(BladeAntlrParser.IncludeContext.class.getSimpleName()),
        INCLUDE_IF(BladeAntlrParser.IncludeIfContext.class.getSimpleName()),
        INCLUDE_COND(BladeAntlrParser.IncludeCondContext.class.getSimpleName()),
        YIELD(BladeAntlrParser.YieldDContext.class.getSimpleName()),
        STACK(BladeAntlrParser.StackContext.class.getSimpleName()),
        SECTION(BladeAntlrParser.SectionContext.class.getSimpleName()),
        SECTION_INLINE(BladeAntlrParser.Section_inlineContext.class.getSimpleName()),
        PUSH(BladeAntlrParser.PushContext.class.getSimpleName()),
        PUSH_IF(BladeAntlrParser.PushIfContext.class.getSimpleName()),
        PREPEND(BladeAntlrParser.PrependContext.class.getSimpleName()),
        HAS_SECTION(BladeAntlrParser.HasSectionContext.class.getSimpleName()),
        SECTION_MISSING(BladeAntlrParser.SectionMissingContext.class.getSimpleName()),
        EACH(BladeAntlrParser.EachContext.class.getSimpleName()),
        USE(BladeAntlrParser.UseDContext.class.getSimpleName()),
        INJECT(BladeAntlrParser.InjectContext.class.getSimpleName());

        String className;

        ParserContext(String className) {
            this.className = className;
        }

        public static ParserContext getValue(String name) {

            for (ParserContext c : ParserContext.values()) {
                if (c.className.equals(name)) {
                    return c;
                }
            }

            return null;
        }
    }

    public BladeParserResult(Snapshot snapshot) {
        super(snapshot);
    }

    protected BladeAntlrParser createParser(Snapshot snapshot) {
        CharStream cs = CharStreams.fromString(String.valueOf(snapshot.getText()));
        BladeAntlrLexer lexer = new BladeAntlrLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BladeAntlrParser ret = new BladeAntlrParser(tokens);
        ret.removeErrorListener(ConsoleErrorListener.INSTANCE);
        return ret;
    }

    public BladeParserResult get() {
        if (!finished) {
            BladeAntlrParser parser = createParser(getSnapshot());
            parser.addErrorListener(createErrorListener());
//            parser.addParseListener(createFoldListener());
            parser.addParseListener(createDeclarationReferencesListener());
            parser.addParseListener(createPhpElementsOccurencesListener());
            parser.addParseListener(createVariableListener());
            parser.addParseListener(createLayoutTreeListener());
            parser.addParseListener(createStructureListener());
            parser.addParseListener(createSemanticsListener());
            evaluateParser(parser);
            BladePhpCompiler phpCompiler = new BladePhpCompiler();
            phpParserResult = phpCompiler.extractPhpContent(
                    this.getSnapshot()).getPhpParserResult();

            if (phpParserResult != null) {
                //double errors for php inline
                this.errors.addAll(phpParserResult.getDiagnostics());
            }

            finished = true;
        }
        return this;
    }

    protected void evaluateParser(BladeAntlrParser parser) {
        parser.file();
    }

    protected ParseTreeListener createDeclarationReferencesListener() {

        return new BladeAntlrParserBaseListener() {

            @Override
            public void exitIdentifiableArgument(BladeAntlrParser.IdentifiableArgumentContext ctx) {
                // ctx.each_path.BL_PARAM_STRING();
                addIdentifiableOccurenceForDeclaration(ctx);
            }

            @Override
            public void exitCustom_directive(BladeAntlrParser.Custom_directiveContext ctx) {
                String directiveName = ctx.getStart().getText();
                OffsetRange range = new OffsetRange(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex() + 1);
                occurancesForDeclaration.put(range, new Reference(ReferenceType.CUSTOM_DIRECTIVE, directiveName, range));
            }

            /**
             * - adds occurences for declaration - stores specific type
             * references
             */
            private void addIdentifiableOccurenceForDeclaration(BladeAntlrParser.IdentifiableArgumentContext ctx) {
                if (ctx.BL_PARAM_STRING() == null) {
                    return;
                }

                String className = ctx.getParent().getClass().getSimpleName();

                if (className.endsWith("WrapperContext")) {
                    className = ctx.getParent().getParent().getClass().getSimpleName();
                }

                ParserContext classType = ParserContext.getValue(className);

                if (classType == null) {
                    return;
                }

                ReferenceType type = getReferenceType(classType);

                if (type == null) {
                    //not handled
                    return;
                }

                Token paramString = ctx.BL_PARAM_STRING().getSymbol();
                String bladeParamText = paramString.getText();
                bladeParamText = bladeParamText.substring(1, bladeParamText.length() - 1);
                OffsetRange range;
                Reference ref;
                if (type.equals(ReferenceType.USE) || type.equals(ReferenceType.INJECT)) {
                    int lastSlashPos = bladeParamText.lastIndexOf("\\");
                    if (lastSlashPos < 0 || lastSlashPos >= bladeParamText.length() - 1) {
                        return;
                    }
                    range = new OffsetRange(paramString.getStartIndex(), paramString.getStopIndex());
                    //extracting the namespace and classname
                    ref = new Reference(type, bladeParamText.substring(lastSlashPos + 1), range, null, bladeParamText.substring(0, lastSlashPos - 1));
                } else {
                    range = new OffsetRange(paramString.getStartIndex(), paramString.getStopIndex());
                    ref = new Reference(type, bladeParamText, range);
                }

                //to add include path ??
                occurancesForDeclaration.put(range, ref);

                //adding references to be indexed
                switch (type) {
                    case YIELD:
                        addYieldReference(ReferenceType.YIELD, bladeParamText, range);
                        break;
                    case STACK:
                        addStackReference(ReferenceType.STACK, bladeParamText, range);
                        break;
                    case INCLUDE:
                    case INCLUDE_IF:
                    case INCLUDE_COND:
                    case EACH:
                        markIncludeBladeOccurrence(bladeParamText, range);
                        break;
                }
            }
        };

    }

    private ParseTreeListener createVariableListener() {
        return new BladeAntlrParserBaseListener() {
            List<ForeachVariables> foreachVariableList = new ArrayList<>();
            int foreachBalance = 0;

            @Override
            public void exitSimple_foreach_expr(BladeAntlrParser.Simple_foreach_exprContext ctx) {
                ForeachVariables foreachVariables = new ForeachVariables();
                foreachVariables.arrayVariable = ctx.loop_array.getText();
                if (ctx.item != null) {
                    foreachVariables.keyVariable = ctx.key.getText();
                    foreachVariables.itemVariable = ctx.item.getText();
                } else {

                    foreachVariables.itemVariable = ctx.key.getText();
                }
                foreachVariableList.add(foreachVariables);
            }

            @Override
            public void enterForeach(BladeAntlrParser.ForeachContext ctx) {
                foreachBalance++;
            }

            @Override
            public void exitForeach(BladeAntlrParser.ForeachContext ctx) {
                if (!foreachVariableList.isEmpty()) {
                    Set<String> varList = new LinkedHashSet<>();
                    for (ForeachVariables foreachVariables : foreachVariableList) {

                        varList.add(foreachVariables.arrayVariable);
                        if (foreachVariables.keyVariable != null) {
                            varList.add(foreachVariables.keyVariable);
                        }
                        varList.add(foreachVariables.itemVariable);

                    }
                    OffsetRange range = new OffsetRange(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex() + 1);
                    scopedVariables.put(range, varList);
                }

                foreachBalance--;
                //reset
                if (foreachBalance < 0) {
                    foreachVariableList.clear();
                }
            }

            @Override
            public void exitForelse(BladeAntlrParser.ForelseContext ctx) {
                if (!foreachVariableList.isEmpty()) {
                    Set<String> varList = new LinkedHashSet<>();
                    for (ForeachVariables foreachVariables : foreachVariableList) {

                        varList.add(foreachVariables.arrayVariable);
                        if (foreachVariables.keyVariable != null) {
                            varList.add(foreachVariables.keyVariable);
                        }
                        varList.add(foreachVariables.itemVariable);

                    }
                    OffsetRange range = new OffsetRange(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex() + 1);
                    scopedVariables.put(range, varList);
                }

                //reset
                foreachVariableList.clear();
            }

            @Override
            public void exitFile(BladeAntlrParser.FileContext ctx) {
                foreachVariableList.clear();
            }
        };
    }

    private ParseTreeListener createPhpElementsOccurencesListener() {
        return new BladeAntlrParserBaseListener() {
            /**
             * handling isolated PHP_IDENTIFIER to reference them as possible
             * constants
             */
            @Override
            public void exitComposed_php_expression(BladeAntlrParser.Composed_php_expressionContext ctx) {
                if (ctx.PHP_IDENTIFIER() != null && ctx.PHP_IDENTIFIER().getSymbol() != null) {
                    String identifierString = ctx.PHP_IDENTIFIER().getSymbol().getText();
                    if (identifierString != null && org.netbeans.modules.php.blade.syntax.StringUtils.isUpperCase(identifierString)) {
                        OffsetRange range = new OffsetRange(ctx.PHP_IDENTIFIER().getSymbol().getStartIndex(), ctx.PHP_IDENTIFIER().getSymbol().getStopIndex() + 1);
                        phpConstantOccurences.put(range, identifierString);
                    }
                }
                if (ctx.PHP_NAMESPACE_PATH() != null && ctx.PHP_NAMESPACE_PATH().getSymbol() != null) {
                    String identifierString = ctx.PHP_NAMESPACE_PATH().getSymbol().getText();
                    if (identifierString != null) {
                        OffsetRange range = new OffsetRange(ctx.PHP_NAMESPACE_PATH().getSymbol().getStartIndex(), ctx.PHP_NAMESPACE_PATH().getSymbol().getStopIndex() + 1);
                        phpNamespacePathOccurences.put(range, identifierString);
                    }
                }
            }

            @Override
            public void exitNamespacePath(BladeAntlrParser.NamespacePathContext ctx) {
                if (ctx.PHP_IDENTIFIER() == null || ctx.PHP_NAMESPACE_PATH() == null) {
                    return;
                }
                String namespace = ctx.PHP_NAMESPACE_PATH().getSymbol().getText();
                Token classIdentifier = ctx.PHP_IDENTIFIER().getSymbol();
                String className = classIdentifier.getText();
                OffsetRange classRange = new OffsetRange(classIdentifier.getStartIndex(), classIdentifier.getStopIndex() + 1);
                OffsetRange range = new OffsetRange(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex() + 1);
                occurancesForDeclaration.put(range, new Reference(ReferenceType.PHP_NAMESPACE_PATH, className, classRange, null, namespace));
            }

            @Override
            public void exitClass_name_reference(BladeAntlrParser.Class_name_referenceContext ctx) {
                if (ctx.class_identifier() == null || ctx.class_identifier().class_name == null) {
                    return;
                }
                Token classIdentifier = ctx.class_identifier().class_name;
                String className = classIdentifier.getText();
                OffsetRange range = new OffsetRange(classIdentifier.getStartIndex(), classIdentifier.getStopIndex() + 1);

                if (ctx.class_identifier().namespace != null) {
                    occurancesForDeclaration.put(range, new Reference(
                            ReferenceType.PHP_CLASS,
                            className, range,
                            null,
                            ctx.class_identifier().namespace.getText())
                    );
                } else {
                    phpClassOccurences.put(range, className);
                }
            }

            @Override
            public void exitClass_instance(BladeAntlrParser.Class_instanceContext ctx) {
                if (ctx.class_identifier() == null || ctx.class_identifier().class_name == null) {
                    return;
                }
                Token classIdentifier = ctx.class_identifier().class_name;
                String className = classIdentifier.getText();
                OffsetRange range = new OffsetRange(classIdentifier.getStartIndex(), classIdentifier.getStopIndex() + 1);
                phpClassOccurences.put(range, className);

                if (ctx.class_identifier().namespace != null) {
                    occurancesForDeclaration.put(range, new Reference(
                            ReferenceType.PHP_CLASS,
                            className, range,
                            null,
                            ctx.class_identifier().namespace.getText())
                    );
                } else {
                    phpClassOccurences.put(range, className);
                }
            }

            //this will be always static
            @Override
            public void exitStatic_direct_class_access(BladeAntlrParser.Static_direct_class_accessContext ctx) {
                if (ctx.class_identifier() == null || ctx.class_identifier().class_name == null) {
                    return;
                }

                Token classIdentifier = ctx.class_identifier().class_name;
                String className = classIdentifier.getText();
                OffsetRange range = new OffsetRange(classIdentifier.getStartIndex(), classIdentifier.getStopIndex() + 1);

                if (ctx.class_identifier().namespace != null) {
                    occurancesForDeclaration.put(range, new Reference(
                            ReferenceType.PHP_CLASS,
                            className, range,
                            null,
                            ctx.class_identifier().namespace.getText())
                    );
                } else {
                    phpClassOccurences.put(range, className);
                }

                OffsetRange callRange = null;
                int start = ctx.PHP_STATIC_ACCESS().getSymbol().getStartIndex();
                String fieldName = null;
                FieldType fieldType = null;
                if (ctx.static_property != null) {
                    //constants
                    callRange = new OffsetRange(start, ctx.static_property.getStopIndex() + 1);
                    fieldName = ctx.static_property.getText();
                    fieldType = FieldType.CONSTANT;
                } else if (ctx.method_call() != null) {
                    //methods
                    callRange = new OffsetRange(start, ctx.method_call().getStop().getStopIndex() + 1);
                    fieldName = ctx.method_call().func_name.getText();
                    fieldType = FieldType.METHOD;
                    OffsetRange functionRange = new OffsetRange(ctx.method_call().func_name.getStartIndex(), ctx.method_call().func_name.getStopIndex() + 1);
                    phpMethodOccurences.put(functionRange, new Reference(ReferenceType.PHP_METHOD, fieldName, range, className));
                }

                if (callRange != null) {
                    FieldAccessReference fieldAccess = new FieldAccessReference(
                            ReferenceType.STATIC_FIELD_ACCESS,
                            className,
                            fieldName,
                            fieldType
                    );
                    fieldCallType.put(callRange, fieldAccess);
                }
            }

            @Override
            public void exitFunction_call(BladeAntlrParser.Function_callContext ctx) {
                if (ctx.func_name == null || ctx.func_name.getText() == null) {
                    return;
                }
                String functionName = ctx.func_name.getText();
                OffsetRange range = new OffsetRange(ctx.func_name.getStartIndex(), ctx.func_name.getStopIndex() + 1);
                phpFunctionOccurences.put(range, functionName);
            }
        };
    }

    private ParseTreeListener createStructureListener() {

        return new BladeAntlrParserBaseListener() {

            final List<BladeStructureItem> lexerStructure = new ArrayList<>();
            int blockBalance = 0;
            String identifier;

            @Override
            public void enterInline_directive(BladeAntlrParser.Inline_directiveContext ctx) {
                identifier = null;
            }

            @Override
            public void exitIdentifiableArgument(BladeAntlrParser.IdentifiableArgumentContext ctx) {
                identifier = null;
                if (ctx.BL_PARAM_STRING() == null) {
                    return;
                }
                identifier = ctx.BL_PARAM_STRING().getText();
            }

            @Override
            public void exitInline_directive(BladeAntlrParser.Inline_directiveContext ctx) {
                ParseTree rootRule = ctx.getChild(0);
                if (rootRule instanceof ParserRuleContext) {
                    ParseTree directive = ((ParserRuleContext) rootRule).getChild(0);
                    if (directive instanceof TerminalNode) {
                        Token directiveToken = ((TerminalNode) directive).getSymbol();
                        if (directiveToken == null) {
                            return;
                        }
                        DirectiveInlineStructureItem inlineElement;
                        String directiveName = directiveToken.getText();

                        if (identifier != null) {
                            inlineElement = new DirectiveInlineStructureItem(directiveName, identifier,
                                    getFileObject(), directiveToken.getStartIndex(), directiveToken.getStopIndex() + 1);
                        } else {
                            inlineElement = new DirectiveInlineStructureItem(directiveName,
                                    getFileObject(), directiveToken.getStartIndex(), directiveToken.getStopIndex() + 1);
                        }

                        if (blockBalance > 0) {
                            lexerStructure.add(inlineElement);
                        } else {
                            structure.add(inlineElement);
                        }

                    }

                }
            }

            @Override
            public void enterBlock_statement(BladeAntlrParser.Block_statementContext ctx) {
                blockBalance++;
            }

            @Override
            public void exitBlock_statement(BladeAntlrParser.Block_statementContext ctx) {
                ParseTree rootRule = ctx.getChild(0);
                blockBalance--;
                if (rootRule instanceof ParserRuleContext) {
                    ParseTree directive = ((ParserRuleContext) rootRule).getChild(0);
                    if (directive instanceof TerminalNode) {
                        Token directiveToken = ((TerminalNode) directive).getSymbol();
                        if (directiveToken == null) {
                            return;
                        }
                        String directiveName = directiveToken.getText();
                        DirectiveBlockStructureItem blockItem = new DirectiveBlockStructureItem(directiveName,
                                getFileObject(), ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex() + 1);

                        blockItem.nestedItems.addAll(lexerStructure);
                        lexerStructure.clear();
                        if (blockBalance > 0 && !directiveName.startsWith("@else")) {
                            lexerStructure.add(blockItem);
                        } else {
                            structure.add(blockItem);
                        }
                        //folds
                        int start = ctx.getStart().getStartIndex() + 1 + directiveName.length();
                        int end = ctx.getStop().getStartIndex();//the start of the close directive

                        if (start > end) {
                            return;
                        }
                        OffsetRange range = new OffsetRange(start, end);
                        if (!folds.contains(range)) {
                            folds.add(range);
                        }
                    }

                }
            }
        };
    }

    private ReferenceType getReferenceType(ParserContext classType) {
        switch (classType) {
            case EACH:
                return ReferenceType.EACH;
            case EXTENDS:
                return ReferenceType.EXTENDS;
            case INCLUDE:
                return ReferenceType.INCLUDE;
            case INCLUDE_IF:
                return ReferenceType.INCLUDE_IF;
            case YIELD:
                return ReferenceType.YIELD;
            case STACK:
                return ReferenceType.STACK;
            case SECTION:
            case SECTION_INLINE:
                return ReferenceType.SECTION;
            case PUSH:
                return ReferenceType.PUSH;
            case PUSH_IF:
                return ReferenceType.PUSH_IF;
            case PREPEND:
                return ReferenceType.PREPEND;
            case HAS_SECTION:
                return ReferenceType.HAS_SECTION;
            case SECTION_MISSING:
                return ReferenceType.SECTION_MISSING;
            case USE:
                return ReferenceType.USE;
            case INJECT:
                return ReferenceType.INJECT;
            default:
                return null;
        }
    }

    /**
     * might move to a model all these processing
     *
     * @param offset
     * @return
     */
    public Reference findOccuredRefrence(int offset) {

        //TODO could do a similar thing and generate the Reference class on loop
        for (Map.Entry<OffsetRange, Reference> entry : occurancesForDeclaration.entrySet()) {
            OffsetRange range = entry.getKey();

            if (offset < range.getStart()) {
                //excedeed the offset range
                break;
            }

            if (range.containsInclusive(offset)) {
                return entry.getValue();
            }
        }

        for (Map.Entry<OffsetRange, String> entry : phpFunctionOccurences.entrySet()) {
            OffsetRange range = entry.getKey();

            if (offset < range.getStart()) {
                //excedeed the offset range
                break;
            }

            if (range.containsInclusive(offset)) {
                return new Reference(ReferenceType.PHP_FUNCTION, entry.getValue(), range);
            }
        }

        for (Map.Entry<OffsetRange, String> entry : phpClassOccurences.entrySet()) {
            OffsetRange range = entry.getKey();

            if (offset < range.getStart()) {
                //excedeed the offset range
                break;
            }

            if (range.containsInclusive(offset)) {
                return new Reference(ReferenceType.PHP_CLASS, entry.getValue(), range);
            }
        }

        for (Map.Entry<OffsetRange, Reference> entry : phpMethodOccurences.entrySet()) {
            OffsetRange range = entry.getKey();

            if (offset < range.getStart()) {
                //excedeed the offset range
                break;
            }

            if (range.containsInclusive(offset)) {
                return entry.getValue();
            }
        }

        for (Map.Entry<OffsetRange, String> entry : phpConstantOccurences.entrySet()) {
            OffsetRange range = entry.getKey();

            if (offset < range.getStart()) {
                //excedeed the offset range
                break;
            }

            if (range.containsInclusive(offset)) {
                return new Reference(ReferenceType.PHP_CONSTANT, entry.getValue(), range);
            }
        }

        for (Map.Entry<OffsetRange, String> entry : phpNamespacePathOccurences.entrySet()) {
            OffsetRange range = entry.getKey();

            if (offset < range.getStart()) {
                //excedeed the offset range
                break;
            }

            if (range.containsInclusive(offset)) {
                return new Reference(ReferenceType.PHP_NAMESPACE_PATH, entry.getValue(), range);
            }
        }

        return null;
    }

    public FieldAccessReference findFieldAccessRefrence(int offset) {
        for (Map.Entry<OffsetRange, FieldAccessReference> entry : fieldCallType.entrySet()) {
            OffsetRange range = entry.getKey();

            if (offset < range.getStart()) {
                //excedeed the offset range
                break;
            }

            if (range.containsInclusive(offset)) {
                return entry.getValue();
            }
        }

        return null;
    }

    protected final void markIncludeBladeOccurrence(String refName, OffsetRange or) {
        includeBladeOccurences.computeIfAbsent(refName, s -> new ArrayList<>()).add(or);
    }

    //not used so far
    public Collection<? extends OffsetRange> findIncludeOccurrence(String refName) {
        ArrayList<OffsetRange> ret = new ArrayList<>();
        if (includeBladeOccurences.containsKey(refName)) {
            ret.addAll(includeBladeOccurences.get(refName));
        }
        return ret;
    }

    public Set<String> findVariablesForScope(int offset) {

        Set<String> variableList = new LinkedHashSet<>();

        for (Map.Entry<OffsetRange, Set<String>> entry : scopedVariables.entrySet()) {
            OffsetRange range = entry.getKey();

            if (offset < range.getStart()) {
                //excedeed the offset range
                break;
            }

            if (range.containsInclusive(offset)) {
                variableList.addAll(entry.getValue());
            }
        }

        if (variableList.isEmpty()) {
            return null;
        }
        return variableList;
    }

    /**
     * to be implemented in the future
     *
     * @return
     */
    protected ParseTreeListener createLayoutTreeListener() {

        return new BladeAntlrParserBaseListener() {
            boolean includeContext = true;

            @Override
            public void enterFile(BladeAntlrParser.FileContext ctx) {

            }

            @Override
            public void enterInclude(BladeAntlrParser.IncludeContext ctx) {
                includeContext = true;
            }

            @Override
            public void exitParamAssign(BladeAntlrParser.ParamAssignContext ctx) {
                String variableName = ctx.BL_PARAM_STRING(0).getSymbol().getText();
                int y = 1;
            }

            @Override
            public void exitInclude(BladeAntlrParser.IncludeContext ctx) {
                includeContext = false;
            }
        };
    }

    private ParseTreeListener createSemanticsListener() {
        return new BladeAntlrParserBaseListener() {
            int ifBalance = 0;
            int ifStart = 0;

            @Override
            public void exitCustom_directive(BladeAntlrParser.Custom_directiveContext ctx) {
                String directiveName = ctx.getStart().getText();
                OffsetRange range = new OffsetRange(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex() + 1);
                customDirectivesReferences.put(range, new Reference(ReferenceType.CUSTOM_DIRECTIVE, directiveName, range));
            }

            @Override
            public void enterIf(BladeAntlrParser.IfContext ctx) {
                ifBalance++;
                ifStart = ctx.getStart().getStartIndex();
            }

            @Override
            public void exitEndif(BladeAntlrParser.EndifContext ctx) {
                ifBalance--;
            }

            @Override
            public void exitFile(BladeAntlrParser.FileContext ctx) {
                if (ifBalance != 0) {
                    errors.add(new BladeError(null, "Unclosed @if", null, getFileObject(), ifStart, ctx.getStart().getStopIndex(), Severity.ERROR));
                }
            }

        };
    }

    public void addYieldReference(ReferenceType type, String yieldId, OffsetRange range) {
        Reference ref = new Reference(type, yieldId, range);
        yieldReferences.put(ref.name, ref);
    }

    public void addStackReference(ReferenceType type, String stackId, OffsetRange range) {
        Reference ref = new Reference(type, stackId, range);
        stackReferences.put(ref.name, ref);
    }

    protected BladeIndex getIndex() {
        if (this.indexLoaded) {
            return bladeIndex;
        }
        Project project = ProjectUtils.getMainOwner(this.getFileObject());

        try {
            bladeIndex = BladeIndex.get(project);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        this.indexLoaded = true;
        return bladeIndex;
    }

    @Override
    protected boolean processingFinished() {
        return finished;
    }

    @Override
    public List<? extends Error> getDiagnostics() {
        return errors;
    }

    @Override
    protected void invalidate() {
        //references.clear();
    }

    public Map<String, Reference> getYieldReferences() {
        return yieldReferences;
    }

    public Map<String, Reference> getStackReferences() {
        return stackReferences;
    }

    public PHPParseResult getPhpParserResult() {
        return phpParserResult;
    }

    protected ANTLRErrorListener createErrorListener() {
        return new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                int errorPosition = 0;
                if (offendingSymbol instanceof Token) {
                    Token offendingToken = (Token) offendingSymbol;
                    errorPosition = offendingToken.getStartIndex();
                }
                errors.add(new BladeError(null, msg, null, getFileObject(), errorPosition, errorPosition, Severity.ERROR));
            }

        };
    }

    public final FileObject getFileObject() {
        return getSnapshot().getSource().getFileObject();
    }

    public static class Reference {

        public final ReferenceType type;
        public final String name;
        public final String ownerClass;
        public final String namespace;
        public final OffsetRange defOffset;

        public Reference(ReferenceType type, String name, OffsetRange defOffset, String ownerClass) {
            this.type = type;
            this.name = name;
            this.defOffset = defOffset;
            this.ownerClass = ownerClass;
            this.namespace = null;
        }

        public Reference(ReferenceType type, String name, OffsetRange defOffset, String ownerClass, String namespace) {
            this.type = type;
            this.name = name;
            this.defOffset = defOffset;
            this.ownerClass = ownerClass;
            this.namespace = namespace;
        }

        public Reference(ReferenceType type, String name, OffsetRange defOffset) {
            this.type = type;
            this.name = name;
            this.defOffset = defOffset;
            this.ownerClass = null;
            this.namespace = null;
        }
    }

    public enum FieldType {
        PROPERTY,
        CONSTANT,
        METHOD;
    }

    public static class FieldAccessReference {

        public final ReferenceType type;
        public final String ownerClass;
        public final String fieldName;
        public final FieldType fieldType;

        public FieldAccessReference(ReferenceType type, String ownerClass, String fieldName, FieldType fieldType) {
            this.type = type;
            this.ownerClass = ownerClass;
            this.fieldName = fieldName;
            this.fieldType = fieldType;
        }
    }

    public class ForeachVariables {

        public String arrayVariable;
        public String keyVariable;
        public String itemVariable;
    }
}
