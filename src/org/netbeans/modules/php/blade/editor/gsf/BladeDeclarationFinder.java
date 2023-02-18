package org.netbeans.modules.php.blade.editor.gsf;

import java.util.ArrayList;
import java.util.Collection;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.text.Document;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.api.project.Project;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.api.DeclarationFinder;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.HtmlFormatter;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.spi.indexing.support.QuerySupport;
import org.netbeans.modules.php.blade.editor.index.BladeIndexSupport;
import static org.netbeans.modules.php.blade.editor.BladeSyntax.DIRECTIVES_WITH_VIEW_PATH;
import org.netbeans.modules.php.blade.editor.index.api.BladeIndex;
import org.netbeans.modules.php.blade.editor.index.api.IndexedElement;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.editor.model.Model;
import org.netbeans.modules.php.blade.editor.model.api.BladeElement;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parsing.ParsingUtils;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.netbeans.modules.php.editor.CodeUtils;
import org.netbeans.modules.php.editor.api.ElementQuery;
import org.netbeans.modules.php.editor.api.ElementQueryFactory;
import org.netbeans.modules.php.editor.api.NameKind;
import org.netbeans.modules.php.editor.api.QuerySupportFactory;
import org.netbeans.modules.php.editor.api.elements.ClassElement;
import org.netbeans.modules.php.editor.api.elements.ElementFilter;
import org.netbeans.modules.php.editor.api.elements.FunctionElement;
import org.netbeans.modules.php.editor.api.elements.MethodElement;
import org.netbeans.modules.php.editor.api.elements.PhpElement;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;
import org.netbeans.modules.php.editor.parser.PHPParseResult;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.netbeans.modules.php.editor.csl.DeclarationFinderImpl;
import org.netbeans.modules.php.editor.model.Occurence;
import org.netbeans.modules.php.editor.model.OccurencesSupport;
import org.netbeans.modules.php.editor.parser.astnodes.ClassName;
import org.netbeans.modules.php.editor.parser.astnodes.Expression;
import org.netbeans.modules.php.editor.parser.astnodes.FunctionInvocation;
import org.netbeans.modules.php.editor.parser.astnodes.Identifier;
import org.netbeans.modules.php.editor.parser.astnodes.MethodInvocation;
import org.netbeans.modules.php.editor.parser.astnodes.Scalar;
import org.netbeans.modules.php.editor.parser.astnodes.Statement;

/**
 *
 * @author bhaidu
 */
public class BladeDeclarationFinder implements DeclarationFinder {

    static enum DeclarationType {
        INCLUDE, SECTION, PHP, NONE
    }

    @Override
    public OffsetRange getReferenceSpan(Document doc, int caretOffset) {
        final BaseDocument docx = (BaseDocument) doc;
        TokenHierarchy<Document> th = TokenHierarchy.get(doc);
        docx.readLock();
        OffsetRange range = OffsetRange.NONE;
        try {
            //BaseDocument doc = (BaseDocument)document;
            TokenSequence<? extends BladeTokenId> ts = BladeLexerUtils.getBladeMarkupTokenSequence(doc, caretOffset);

            if (ts == null) {
                return OffsetRange.NONE;
            }

            ts.move(caretOffset);

            if (!ts.moveNext() && !ts.movePrevious()) {
                return OffsetRange.NONE;
            }

            // Determine whether the caret position is right between two tokens
            boolean isBetween = (caretOffset == ts.offset());

            range = getReferenceSpan(ts, th, caretOffset);

            if ((range == OffsetRange.NONE) && isBetween) {
                // The caret is between two tokens, and the token on the right
                // wasn't linkable. Try on the left instead.
                if (ts.movePrevious()) {
                    range = getReferenceSpan(ts, th, caretOffset);
                }
            }
        } finally {
            docx.readUnlock();
        }

        return range;
    }

    private OffsetRange getReferenceSpan(TokenSequence<?> ts,
            TokenHierarchy<Document> th, int lexOffset) {
        Token<?> token = ts.token();
        BladeTokenId id = (BladeTokenId) token.id();
        String text = token.text().toString().trim();
        int tokeLength = ts.offset() + token.length();

        if (BladeTokenId.T_PHP == id || BladeTokenId.T_BLADE_PHP == id) {
            TokenSequence<? extends PHPTokenId> tsPhp = BladeLexerUtils.getPhpTokenSequence(th, lexOffset);
            Token<?> tokenPhp = tsPhp.token();
            if (tokenPhp != null) {
                TokenId phpId = tokenPhp.id();
                if (phpId.equals(PHPTokenId.PHP_STRING) || phpId.equals(PHPTokenId.PHP_VARIABLE)) {
                    return new OffsetRange(tsPhp.offset(), tsPhp.offset() + tokenPhp.length());
                }
            }
        } else if (BladeTokenId.BLADE_PHP_EMBEDDED_TOKEN.contains(id)) {
            TokenSequence<? extends PHPTokenId> tsPhp = BladeLexerUtils.getPhpTokenSequence(th, lexOffset);
            Token<? extends PHPTokenId> tokenPhp = tsPhp.token();
            if (tokenPhp != null) {
                PHPTokenId tokenPhpId = tokenPhp.id();
                switch (tokenPhpId) {
                    case PHP_CONSTANT_ENCAPSED_STRING:
                    case PHP_STRING:
                        return new OffsetRange(tsPhp.offset(), tsPhp.offset() + tokenPhp.length());
                }
            }
        }

        return OffsetRange.NONE;
    }

    @Override
    public DeclarationLocation findDeclaration(ParserResult info, int carretOffset) {
        final Document document = info.getSnapshot().getSource().getDocument(false);
        if (document == null) {
            return DeclarationLocation.NONE;
        }
        final BaseDocument doc = (BaseDocument) document;
        BladeParserResult parseResult = (BladeParserResult) info;
        doc.readLock();
        try {
            //have a occurence support
            DeclarationContext context = getContext(carretOffset, doc);
            if (context == null || context.getPathValue().isEmpty()) {
                return DeclarationLocation.NONE;
            }
            DeclarationLocation locations = DeclarationLocation.NONE;

            switch (context.getDeclarationType()) {
                case INCLUDE: {
                    locations = findBladeViewsLocation(parseResult, context.getPathValue(), carretOffset);
                    break;
                }
                case SECTION: {
                    locations = findYieldPathLocation(parseResult, context.getPathValue(), carretOffset);
                    break;
                }
                case PHP: {
                    FileObject fo = parseResult.getSnapshot().getSource().getFileObject();
                    locations = PhpTypeCompletionProvider.getInstance().getItems(fo, context.getPathValue(), parseResult, carretOffset);
                    break;
                }
            }

            if (locations != DeclarationLocation.NONE) {
                return locations;
            }
        } finally {
            doc.readUnlock();
        }

        return DeclarationLocation.NONE;
    }

    private DeclarationContext getContext(int carretOffset, BaseDocument doc) {
        TokenSequence<? extends BladeTokenId> ts = BladeLexerUtils.getBladeMarkupTokenSequence(doc, carretOffset);
        String pathValue = "";
        if (ts != null) {
            ts.move(carretOffset);
            if (!ts.moveNext()) {
                ts.movePrevious();
            }
            do {
                Token<? extends BladeTokenId> token = ts.token();
                if (token == null) {
                    break;
                }
                TokenId tokenId = token.id();
                String ttText = token.text().toString().trim();
                if (BladeTokenId.BLADE_PHP_EMBEDDED_TOKEN.contains(tokenId)) {
                    TokenHierarchy<Document> th = TokenHierarchy.get(doc);
                    TokenSequence<? extends PHPTokenId> tsPhp = BladeLexerUtils.getPhpTokenSequence(th, carretOffset);
                    Token<?> tokenPhp = tsPhp.token();
                    if (tokenPhp != null) {
                        PHPTokenId tokenPhpId = (PHPTokenId) tokenPhp.id();
                        switch (tokenPhpId) {
                            case PHP_CONSTANT_ENCAPSED_STRING:
                                pathValue = tokenPhp.text().toString();
                                pathValue = pathValue.substring(1, pathValue.length() - 1);
                                break;
                            case PHP_STRING:
                                pathValue = tokenPhp.text().toString();
                        }
                        if (tokenId.equals(BladeTokenId.T_BLADE_PHP_ECHO)) {
                            return new DeclarationContext(pathValue, DeclarationType.PHP);
                        }
                    }
                } else if (BladeTokenId.T_PHP == tokenId || BladeTokenId.T_BLADE_PHP == tokenId) {
                    TokenHierarchy<Document> th = TokenHierarchy.get(doc);
                    TokenSequence<? extends PHPTokenId> tsPhp = BladeLexerUtils.getPhpTokenSequence(th, carretOffset);
                    Token<?> tokenPhp = tsPhp.token();
                    if (tokenPhp != null) {
                        TokenId phpId = tokenPhp.id();
                        String textPhp = tokenPhp.text().toString().trim();
                        if (phpId.equals(PHPTokenId.PHP_STRING) || phpId.equals(PHPTokenId.PHP_VARIABLE)) {
                            return new DeclarationContext(textPhp, DeclarationType.PHP);
                        }
                    }
                } else if (DIRECTIVES_WITH_VIEW_PATH.contains(ttText)) {
                    return new DeclarationContext(pathValue, DeclarationType.INCLUDE);
                } else if (ttText.equals("@section")) {
                    //TODO use token??
                    return new DeclarationContext(pathValue, DeclarationType.SECTION);
                } else if (BladeTokenId.T_BLADE_DIRECTIVE.equals(tokenId)) {
                    //stop statements
                    break;
                }
            } while (ts.movePrevious());
        }
        return null;
    }

    public static final class PhpTypeCompletionProvider {

        private static final PhpTypeCompletionProvider INSTANCE = new PhpTypeCompletionProvider();
        private Set<ClassElement> cachedElements;

        private PhpTypeCompletionProvider() {
        }

        public static PhpTypeCompletionProvider getInstance() {
            return INSTANCE;
        }

        /*
        * FOR PHP ??
         */
        public DeclarationLocation getItems(FileObject sourceFile, String prefix, BladeParserResult info, int carretOffset) {
            DeclarationLocation alternatives = DeclarationLocation.NONE;
            PHPParseResult phpResult = (info.getProgram() != null) ? info.getProgram().getPhpParserResult() : null;
            if (phpResult == null) {
                return DeclarationLocation.NONE;
            }
            String phpText = phpResult.getSnapshot().getText().toString();
            //phpResult.get
            final org.netbeans.modules.php.editor.model.Model model = phpResult.getModel(org.netbeans.modules.php.editor.model.Model.Type.COMMON);
            OccurencesSupport occurencesSupport = model.getOccurencesSupport(carretOffset);
            Occurence underCaret = occurencesSupport.getOccurence();
            if (underCaret != null) {
                Collection<? extends PhpElement> gotoDeclarations = underCaret.gotoDeclarations();
                if (gotoDeclarations == null || gotoDeclarations.isEmpty()) {
                    return DeclarationLocation.NONE;
                }
                PhpElement declaration = gotoDeclarations.iterator().next();
                FileObject declarationFo = declaration.getFileObject();
                if (declarationFo == null) {
                    return DeclarationLocation.NONE;
                }
                return new DeclarationLocation(declarationFo, declaration.getOffset(), declaration);
            } else {
                //todo add a visitor ?
                PhpElementsVisitor visitor = new PhpElementsVisitor(carretOffset, prefix);
                phpResult.getProgram().accept(visitor);
                org.netbeans.modules.php.editor.parser.astnodes.ASTNode nodeFound = visitor.getNodeFound();
                if (nodeFound == null) {
                    return DeclarationLocation.NONE;
                }

                Project project = BladeProjectProperties.getProject();
                FileObject files[] = project.getProjectDirectory().getChildren();
                for (FileObject file : files) {
                    if (file.isFolder()) {
                        continue;
                    }
                    if (file.getExt().equals("php")) {
                        ParsingUtils parsingUtils = new ParsingUtils();
                        parsingUtils.parseFileObject(file);
                        ElementQuery.Index phpIndexQuery = ElementQueryFactory.createIndexQuery(QuerySupportFactory.get(parsingUtils.getParserResult()));

                        if (nodeFound instanceof Identifier) {
                            Set<ClassElement> classes = phpIndexQuery.getClasses(NameKind.create(prefix, QuerySupport.Kind.PREFIX));
                            for (ClassElement classElement : classes) {
                                if (!CodeUtils.isSyntheticTypeName(classElement.getName())) {
                                    FileObject fo = classElement.getFileObject();
                                    DeclarationLocation declLocation = new DeclarationLocation(
                                            fo, classElement.getOffset());

                                    AlternativeLocation al = new BladeAlternativeLocation(classElement, declLocation);
                                    if (alternatives == DeclarationLocation.NONE) {
                                        alternatives = al.getLocation();
                                    }
                                    alternatives.addAlternative(al);
                                }
                            }
                        } else if (nodeFound instanceof MethodInvocation) {
                            Set<MethodElement> functions = phpIndexQuery.getMethods(NameKind.create(prefix, QuerySupport.Kind.PREFIX));
                            for (MethodElement functionElement : functions) {
                                if (!CodeUtils.isSyntheticTypeName(functionElement.getName())) {
                                    FileObject fo = functionElement.getFileObject();
                                    DeclarationLocation declLocation = new DeclarationLocation(
                                            fo, functionElement.getOffset());

                                    AlternativeLocation al = new BladeAlternativeLocation(functionElement, declLocation);
                                    if (alternatives == DeclarationLocation.NONE) {
                                        alternatives = al.getLocation();
                                    }
                                    alternatives.addAlternative(al);
                                }
                            }
                        } else if (nodeFound instanceof FunctionInvocation) {
                            Set<FunctionElement> functions = phpIndexQuery.getFunctions(NameKind.create(prefix, QuerySupport.Kind.PREFIX));
                            for (FunctionElement functionElement : functions) {
                                if (!CodeUtils.isSyntheticTypeName(functionElement.getName())) {
                                    FileObject fo = functionElement.getFileObject();
                                    DeclarationLocation declLocation = new DeclarationLocation(
                                            fo, functionElement.getOffset());

                                    AlternativeLocation al = new BladeAlternativeLocation(functionElement, declLocation);
                                    if (alternatives == DeclarationLocation.NONE) {
                                        alternatives = al.getLocation();
                                    }
                                    alternatives.addAlternative(al);
                                }
                            }
                        }
                        break;
                    }
                }
            }

            return alternatives;
        }

        private synchronized Set<ClassElement> getElements(FileObject fileObject) {
            if (cachedElements == null) {
                ElementQuery.Index indexQuery = ElementQueryFactory.createIndexQuery(QuerySupportFactory.get(fileObject));
                cachedElements = indexQuery.getClasses(NameKind.empty());
            }
            return cachedElements;
        }

        public synchronized void clearCache() {
            cachedElements = null;
        }

    }

    private DeclarationLocation findYieldPathLocation(BladeParserResult info, String pathValue, int carretOffset) {
        Model model = info.getModel();

        if (model != null) {
            org.netbeans.modules.php.blade.editor.model.OccurencesSupport occurencesSupport = model.getOccurencesSupport(info, carretOffset);
            org.netbeans.modules.php.blade.editor.model.api.Occurence underCaret = occurencesSupport.getOccurence(BladeElement.Kind.YIELD);
            if (underCaret != null) {
                DeclarationLocation alternatives = DeclarationLocation.NONE;
                for (BladeElement element : underCaret.getAllDeclarations()) {
                    int offset = element.getOffsetRange() != null ? element.getOffsetRange().getStart() : 0;
                    DeclarationLocation declLocation = new DeclarationLocation(
                            element.getFileObject(), offset);
                    YieldElement elem = new YieldElement(pathValue);
                    AlternativeLocation al = new BladeAlternativeLocation(elem, declLocation);
                    if (alternatives == DeclarationLocation.NONE) {
                        alternatives = al.getLocation();
                    }
                    alternatives.addAlternative(al);
                }
                return alternatives;
            }

        }

        return DeclarationLocation.NONE;
    }

    private DeclarationLocation findBladeViewsLocation(BladeParserResult info, String pathValue, int carretOffset) {
        Model model = info.getModel();
        PathElement elem = new PathElement(pathValue);
        DeclarationLocation alternatives = DeclarationLocation.NONE;
        if (model != null) {
            org.netbeans.modules.php.blade.editor.model.OccurencesSupport occurencesSupport = model.getOccurencesSupport(info, carretOffset);
            org.netbeans.modules.php.blade.editor.model.api.Occurence underCaret = occurencesSupport.getOccurence(BladeElement.Kind.VIEW_PATH);
            if (underCaret != null) {
                for (BladeElement element : underCaret.getAllDeclarations()) {
                    DeclarationLocation declLocation = new DeclarationLocation(
                            element.getFileObject(), 0);
                    AlternativeLocation al = new BladeAlternativeLocation(elem, declLocation);
                    if (alternatives == DeclarationLocation.NONE) {
                        alternatives = al.getLocation();
                    }
                    alternatives.addAlternative(al);
                }
                return alternatives;
            }
        }

        return DeclarationLocation.NONE;
    }

    public static class BladeAlternativeLocation implements AlternativeLocation {

        private ElementHandle modelElement;
        private DeclarationLocation declaration;

        public BladeAlternativeLocation(ElementHandle modelElement, DeclarationLocation declaration) {
            this.modelElement = modelElement;
            this.declaration = declaration;
        }

        @Override
        public ElementHandle getElement() {
            return modelElement;
        }

        @Override
        public String getDisplayHtml(HtmlFormatter formatter) {
            formatter.reset();
            //ElementKind ek = modelElement.getKind();
            formatter.appendText(modelElement.getName());

            if (declaration.getFileObject() != null) {
                formatter.appendText(" in ");
                formatter.appendText(FileUtil.getFileDisplayName(declaration.getFileObject()));
            }

            return formatter.getText();
        }

        @Override
        public DeclarationLocation getLocation() {
            return declaration;
        }

        @Override
        public int compareTo(AlternativeLocation o) {
            BladeAlternativeLocation i = (BladeAlternativeLocation) o;
            return this.modelElement.getName().compareTo(i.modelElement.getName());
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 89 * hash + (this.modelElement != null ? this.modelElement.hashCode() : 0);
            hash = 89 * hash + (this.declaration != null ? this.declaration.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final BladeAlternativeLocation other = (BladeAlternativeLocation) obj;
            if (this.modelElement != other.modelElement && (this.modelElement == null || !this.modelElement.equals(other.modelElement))) {
                return false;
            }
            if (this.declaration != other.declaration && (this.declaration == null || !this.declaration.equals(other.declaration))) {
                return false;
            }
            return true;
        }
    }

    public class PathElement implements ElementHandle {

        private final String name;

        public PathElement(String name) {
            //we can add a file object from element
            this.name = name;
        }

        @Override
        public FileObject getFileObject() {
            return null;
        }

        @Override
        public String getMimeType() {
            return BladeLanguage.BLADE_MIME_TYPE;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getIn() {
            return "";
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.FILE;
        }

        @Override
        public Set<Modifier> getModifiers() {
            return new HashSet<>();
        }

        @Override
        public boolean signatureEquals(ElementHandle eh) {
            return false;
        }

        @Override
        public OffsetRange getOffsetRange(ParserResult pr) {
            return OffsetRange.NONE;
        }
    }

    public class YieldElement implements ElementHandle {

        private final String name;

        public YieldElement(String name) {
            //we can add a file object from element
            this.name = name;
        }

        @Override
        public FileObject getFileObject() {
            return null;
        }

        @Override
        public String getMimeType() {
            return BladeLanguage.BLADE_MIME_TYPE;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getIn() {
            return "";
        }

        @Override
        public ElementKind getKind() {
            return ElementKind.TAG;
        }

        @Override
        public Set<Modifier> getModifiers() {
            return new HashSet<>();
        }

        @Override
        public boolean signatureEquals(ElementHandle eh) {
            return false;
        }

        @Override
        public OffsetRange getOffsetRange(ParserResult pr) {
            return OffsetRange.NONE;
        }
    }

    public class DeclarationContext {

        private DeclarationType declarationType = DeclarationType.NONE;
        private String pathValue = "";

        DeclarationContext(String pathValue, DeclarationType type) {
            this.pathValue = pathValue;
            this.declarationType = type;
        }

        public String getPathValue() {
            return pathValue;
        }

        public DeclarationType getDeclarationType() {
            return declarationType;
        }
    }

    /**
     * declaration php visitor
     */
    public static class PhpElementsVisitor extends org.netbeans.modules.php.editor.parser.astnodes.visitors.DefaultVisitor {

        private int offset;
        private String prefix;
        private org.netbeans.modules.php.editor.parser.astnodes.ASTNode nodeFound;

        public PhpElementsVisitor(int offset, String prefix) {
            this.offset = offset;
            this.prefix = prefix;
        }

        @Override
        public void scan(org.netbeans.modules.php.editor.parser.astnodes.ASTNode node) {
            if (node != null && nodeFound == null) {
                super.scan(node);
            }
        }

        @Override
        public void visit(Identifier node) {
            if (matches(node, node.getName())) {
                nodeFound = node;
            }
        }

        @Override
        public void visit(ClassName node) {
            if (matches(node, node.getName().toString())) {
                nodeFound = node;
            }
        }

        @Override
        public void visit(MethodInvocation node) {
            if (matches(node, node.getMethod().toString())) {
                nodeFound = node;
            }
        }

        @Override
        public void visit(FunctionInvocation node) {
            if (matches(node, node.getFunctionName().getName().toString())) {
                nodeFound = node;
            }
        }

        private boolean matches(org.netbeans.modules.php.editor.parser.astnodes.ASTNode node, String name) {
            return node.getStartOffset() <= offset && node.getEndOffset() >= offset && name.replace("\\", "").equals(prefix);
        }

        public org.netbeans.modules.php.editor.parser.astnodes.ASTNode getNodeFound() {
            return nodeFound;
        }
    }
}
