package org.netbeans.modules.php.blade.editor.completion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.editor.BaseDocument;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.antlr.v4.runtime.Token;
import org.netbeans.api.editor.document.EditorDocumentUtils;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.CodeCompletionContext;
import org.netbeans.modules.csl.api.CodeCompletionHandler2;
import org.netbeans.modules.csl.api.CodeCompletionResult;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.Documentation;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ParameterInfo;
import org.netbeans.modules.csl.spi.DefaultCompletionResult;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.csl.spi.support.CancelSupport;
import org.netbeans.modules.php.blade.csl.elements.DirectiveElement;
import org.netbeans.modules.php.blade.csl.elements.ElementType;
import org.netbeans.modules.php.blade.csl.elements.NamedElement;
import org.netbeans.modules.php.blade.csl.elements.PhpFunctionElement;
import org.netbeans.modules.php.blade.csl.elements.TagElement;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionProposal.CompletionRequest;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexFunctionResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexUtils;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult.FieldAccessReference;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult.Reference;
import org.netbeans.modules.php.blade.editor.preferences.ModulePreferences;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.netbeans.modules.php.blade.syntax.TagList;
import org.netbeans.modules.php.blade.syntax.annotation.Directive;
import org.netbeans.modules.php.blade.syntax.annotation.Tag;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrUtils;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParser.CONTENT_TAG_OPEN;
import org.netbeans.spi.project.ui.support.ProjectConvertors;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class BladeCompletionHandler implements CodeCompletionHandler2 {

    private static final Logger LOGGER = Logger.getLogger(BladeCompletionHandler.class.getName());

    static enum ContextType {
        GENERIC_IDENTIFIER, PHP_FUNCTION, NONE
    }

    @Override
    public CodeCompletionResult complete(CodeCompletionContext completionContext) {
        long startTime = System.currentTimeMillis();
        LOGGER.log(Level.INFO, "Completion requested for {0}", completionContext.getParserResult().getSnapshot().getSource().getFileObject().getPath());
        BaseDocument doc = (BaseDocument) completionContext.getParserResult().getSnapshot().getSource().getDocument(false);
        if (doc == null) {
            LOGGER.info(String.format("complete() no doc found took %d ms", System.currentTimeMillis() - startTime));
            return CodeCompletionResult.NONE;
        }
        
        if (completionContext.getCaretOffset() < 1) {
            LOGGER.info(String.format("complete() wrong caret took %d ms", System.currentTimeMillis() - startTime));
            return CodeCompletionResult.NONE;
        }

        BladeParserResult parserResult = (BladeParserResult) completionContext.getParserResult();

        if (CancelSupport.getDefault().isCancelled()) {
            //no need to think of cancelled?
            LOGGER.info(String.format("complete() cancelled took %d ms", System.currentTimeMillis() - startTime));
            Token currentToken = BladeAntlrUtils.getToken(doc, completionContext.getCaretOffset() - 1);
            String tokenText = currentToken.getText();
            final List<CompletionProposal> completionProposals = new ArrayList<>();
            if (tokenText.startsWith("@")) {
                completeDirectives(completionProposals, completionContext, parserResult, currentToken);
            }
            if (completionProposals.isEmpty()) {
                LOGGER.info(String.format("complete() no result took %d ms", System.currentTimeMillis() - startTime));
                return CodeCompletionResult.NONE;
            }
            return new DefaultCompletionResult(completionProposals, false);
        }



        final List<CompletionProposal> completionProposals = new ArrayList<>();

        Token currentToken = BladeAntlrUtils.getToken(doc, completionContext.getCaretOffset() - 1);

        if (currentToken == null) {
            LOGGER.info(String.format("complete() no token found took %d ms", System.currentTimeMillis() - startTime));
            return CodeCompletionResult.NONE;
        }

        String tokenText = currentToken.getText();

        if (!tokenText.startsWith("@")) {
            switch (currentToken.getType()) {
                case PHP_IDENTIFIER:
                case PHP_NAMESPACE_PATH:
                    completePhpElements(completionProposals, parserResult, completionContext.getCaretOffset(), currentToken);
                    break;
                case PHP_EXPRESSION:
                    completePhpSnippet(completionProposals, completionContext.getCaretOffset(), currentToken);
                    break;
                case PHP_VARIABLE:
                    completeScopedVariables(completionProposals, completionContext, parserResult, currentToken);
                    break;
                case CONTENT_TAG_OPEN:
                case RAW_TAG_OPEN:
                    if (!ModulePreferences.isAutoTagCompletionEnabled()){
                        completeBladeTags(completionProposals, completionContext, parserResult, currentToken);
                    }
                    break;
            }
        } else {
            completeDirectives(completionProposals, completionContext, parserResult, currentToken);
        }

        if (completionProposals.isEmpty()) {
            LOGGER.info(String.format("complete() no result took %d ms", System.currentTimeMillis() - startTime));
            return CodeCompletionResult.NONE;
        }
        //TODO add context
        LOGGER.info(String.format("complete() with result took %d ms", System.currentTimeMillis() - startTime));
        return new DefaultCompletionResult(completionProposals, false);
    }

    //we need a context
    private void completePhpElements(final List<CompletionProposal> completionProposals,
            BladeParserResult parserResult,
            int offset, Token currentToken) {
        String prefix = currentToken.getText();

        if (prefix == null || prefix.length() == 1) {
            return;
        }

        FieldAccessReference fieldAccessReference = parserResult.findFieldAccessRefrence(offset);

        if (fieldAccessReference != null) {
            completeClassConstants(prefix, fieldAccessReference.ownerClass, offset, completionProposals, parserResult);
            completeClassMethods(prefix, fieldAccessReference, offset, completionProposals, parserResult);
            return;
        }

        Reference elementReference = parserResult.findOccuredRefrence(offset);

        if (elementReference == null) {
            completeNamespace(prefix, offset, completionProposals, parserResult);
            completePhpClasses(prefix, offset, completionProposals, parserResult);
            completePhpFunctions(prefix, offset, completionProposals, parserResult);
            completeConstants(prefix, offset, completionProposals, parserResult);
            return;
        }

        switch (elementReference.type) {
            case PHP_CONSTANT:
            case PHP_CLASS:
                completeNamespace(prefix, offset, completionProposals, parserResult);
                completePhpClasses(prefix, offset, completionProposals, parserResult);
                completeConstants(prefix, offset, completionProposals, parserResult);
                break;
            case PHP_NAMESPACE_PATH:
                completeNamespace(prefix, offset, completionProposals, parserResult);

                //we are after '\'
                if (elementReference.namespace != null) {
                    String classQuery = prefix;
                    String namespace = elementReference.namespace;
                    namespace = namespace.substring(0, namespace.length() - 1);
                    //completion offset : subtract prefix length + last slash
                    int offsetNamespace = offset - (prefix.length() + 1);
                    completeNamespacedPhpClasses(classQuery, namespace, offsetNamespace, completionProposals, parserResult);
                } else if (prefix.endsWith("\\")) {
                    String namespace = elementReference.name;
                    completeNamespacedPhpClasses("", namespace, offset, completionProposals, parserResult);
                }
                break;
        }
    }

    private void completePhpClasses(String prefix, int offset,
            final List<CompletionProposal> completionProposals,
            BladeParserResult parserResult) {
        Collection<PhpIndexResult> indexClassResults = PhpIndexUtils.queryClass(
                parserResult.getSnapshot().getSource().getFileObject(), prefix);
        if (indexClassResults.isEmpty()) {
            return;
        }
        CompletionRequest request = completionRequest(prefix, offset);
        for (PhpIndexResult indexResult : indexClassResults) {
            NamedElement classElement = new NamedElement(indexResult.name, indexResult.declarationFile, ElementType.PHP_CLASS);
            completionProposals.add(new BladeCompletionProposal.ClassItem(classElement, request, indexResult.name));
        }
    }

    private void completeNamespacedPhpClasses(String prefix, String namespace,
            int offset, final List<CompletionProposal> completionProposals,
            BladeParserResult parserResult) {
        Collection<PhpIndexResult> indexClassResults = PhpIndexUtils.queryNamespaceClasses(
                prefix, namespace, parserResult.getSnapshot().getSource().getFileObject());
        CompletionRequest request = completionRequest(namespace, offset);
        for (PhpIndexResult indexResult : indexClassResults) {
            NamedElement classElement = new NamedElement(indexResult.name, indexResult.declarationFile, ElementType.PHP_CLASS);
            completionProposals.add(new BladeCompletionProposal.ClassItem(classElement, request, indexResult.name));
        }
    }

    private void completePhpFunctions(String prefix, int offset,
            final List<CompletionProposal> completionProposals,
            BladeParserResult parserResult) {
        Collection<PhpIndexFunctionResult> indexedFunctions = PhpIndexUtils.queryFunctions(
                parserResult.getSnapshot().getSource().getFileObject(), prefix);
        if (indexedFunctions.isEmpty()) {
            return;
        }
        CompletionRequest request = completionRequest(prefix, offset);
        for (PhpIndexFunctionResult indexResult : indexedFunctions) {
            //to be completed
            //might add syntax completion cursor
            String completion = indexResult.name + "()";
            String preview = indexResult.name + indexResult.getParamsAsString();
            NamedElement functionElement = new NamedElement(completion, indexResult.declarationFile, ElementType.PHP_FUNCTION);
            completionProposals.add(new BladeCompletionProposal.FunctionItem(functionElement, request, preview));
        }
    }

    private void completeClassMethods(String prefix, FieldAccessReference fieldAccessReference,
            int offset,
            final List<CompletionProposal> completionProposals,
            BladeParserResult parserResult) {
        Collection<PhpIndexFunctionResult> indexedFunctions = PhpIndexUtils.queryClassMethods(
                parserResult.getSnapshot().getSource().getFileObject(), prefix, fieldAccessReference.ownerClass);
        if (indexedFunctions.isEmpty()) {
            return;
        }
        CompletionRequest request = completionRequest(prefix, offset);
        for (PhpIndexFunctionResult indexResult : indexedFunctions) {
            //to be completed
            //might add syntax completion cursor
            String completion = indexResult.name + "()";
            String preview = indexResult.name + indexResult.getParamsAsString();
            NamedElement functionElement = new NamedElement(completion, indexResult.declarationFile, ElementType.PHP_FUNCTION);
            completionProposals.add(new BladeCompletionProposal.FunctionItem(functionElement, request, preview));
        }
    }

    private void completeNamespace(String prefix, int offset,
            final List<CompletionProposal> completionProposals,
            BladeParserResult parserResult) {
        Project projectOwner = ProjectConvertors.getNonConvertorOwner(parserResult.getSnapshot().getSource().getFileObject());
        if (projectOwner == null) {
            return;
        }
        Collection<PhpIndexResult> indexClassResults = PhpIndexUtils.queryNamespace(
                projectOwner.getProjectDirectory(), prefix);
        if (indexClassResults.isEmpty()) {
            return;
        }
        CompletionRequest request = completionRequest(prefix, offset);
        for (PhpIndexResult indexResult : indexClassResults) {
            NamedElement constantElement = new NamedElement(indexResult.name, indexResult.declarationFile, ElementType.PHP_CONSTANT);
            completionProposals.add(new BladeCompletionProposal.NamespaceItem(constantElement, request, indexResult.name));
        }
    }

    private void completeConstants(String prefix, int offset,
            final List<CompletionProposal> completionProposals,
            BladeParserResult parserResult) {
        Collection<PhpIndexResult> indexClassResults = PhpIndexUtils.queryConstants(
                parserResult.getSnapshot().getSource().getFileObject(), prefix);
        if (indexClassResults.isEmpty()) {
            return;
        }
        CompletionRequest request = completionRequest(prefix, offset);
        for (PhpIndexResult indexResult : indexClassResults) {
            NamedElement constantElement = new NamedElement(indexResult.name, indexResult.declarationFile, ElementType.PHP_CONSTANT);
            completionProposals.add(new BladeCompletionProposal.ConstantItem(constantElement, request, indexResult.name));
        }
    }

    private void completeClassConstants(String prefix, String ownerClass, int offset,
            final List<CompletionProposal> completionProposals,
            BladeParserResult parserResult) {
        Collection<PhpIndexResult> indexClassResults = PhpIndexUtils.queryClassConstants(
                parserResult.getSnapshot().getSource().getFileObject(), prefix, ownerClass);
        if (indexClassResults.isEmpty()) {
            return;
        }
        CompletionRequest request = completionRequest(prefix, offset);
        for (PhpIndexResult indexResult : indexClassResults) {
            NamedElement constantElement = new NamedElement(indexResult.name, indexResult.declarationFile, ElementType.PHP_CONSTANT);
            completionProposals.add(new BladeCompletionProposal.ConstantItem(constantElement, request, indexResult.name));
        }
    }

    /**
     * proxy completion using the original php code completion service
     *
     * @param completionProposals
     * @param offset
     * @param currentToken
     */
    private void completePhpSnippet(final List<CompletionProposal> completionProposals,
            int offset, Token currentToken) {
        PhpCodeCompletionService phpCodeCompletion = new PhpCodeCompletionService();
        for (CompletionProposal proposal : phpCodeCompletion.getCompletionProposal(offset, currentToken)) {
            String proposalPrefix = proposal.getInsertPrefix();
            if (proposalPrefix.startsWith(phpCodeCompletion.prefix)) {
                completionProposals.add(proposal);
            }
        }
    }

    private void completeScopedVariables(final List<CompletionProposal> completionProposals,
            CodeCompletionContext completionContext, BladeParserResult parserResult, Token currentToken) {
        String variablePrefix = currentToken.getText();
        Set<String> scopedVariables = parserResult.findLoopVariablesForScope(completionContext.getCaretOffset());
        FileObject fo = completionContext.getParserResult().getSnapshot().getSource().getFileObject();
        if (scopedVariables != null && !scopedVariables.isEmpty()) {
            CompletionRequest request = new CompletionRequest();
            request.anchorOffset = completionContext.getCaretOffset() - variablePrefix.length();
            request.carretOffset = completionContext.getCaretOffset();
            request.prefix = variablePrefix;
            if ("$loop".startsWith(variablePrefix)) {
                String variableName = "$loop";
                NamedElement variableElement = new NamedElement(variableName, fo, ElementType.VARIABLE);
                completionProposals.add(new BladeCompletionProposal.BladeVariableItem(variableElement, request, variableName));
            }
            for (String variableName : scopedVariables) {
                if (variableName.startsWith(variablePrefix)) {
                    NamedElement variableElement = new NamedElement(variableName, fo, ElementType.VARIABLE);
                    completionProposals.add(new BladeCompletionProposal.VariableItem(variableElement, request, variableName));
                }
            }
        }
    }
    
    /**
     * BLADES
     * 
     * @param completionProposals
     * @param completionContext
     * @param parserResult
     * @param currentToken 
     */
    
    private void completeBladeTags(final List<CompletionProposal> completionProposals,
            CodeCompletionContext completionContext, BladeParserResult parserResult, Token currentToken) {
        String tagStart = currentToken.getText();

        CompletionRequest request = completionRequest(tagStart, completionContext.getCaretOffset());
        TagList tagsContainer = new TagList();
        Tag[] tags = tagsContainer.getTags();
        for (Tag tag : tags) {
            if (tag.openTag().startsWith(tagStart)) {
                TagElement tagElement = new TagElement(tag.closeTag());
                completionProposals.add(new BladeCompletionProposal.BladeTag(tagElement, request, tag));
            }
        }
    }
    
    private void completeDirectives(final List<CompletionProposal> completionProposals,
        CodeCompletionContext completionContext, BladeParserResult parserResult, Token currentToken) {
        String prefix = currentToken.getText();
        DirectiveCompletionList completionList = new DirectiveCompletionList();

        FileObject fo = parserResult.getSnapshot().getSource().getFileObject();
        CompletionRequest request = completionRequest(prefix, completionContext.getCaretOffset());
        for (Directive directive : completionList.getDirectives()) {
                        String directiveName = directive.name();
            if (directiveName.startsWith(prefix)) {
                DirectiveElement directiveEl = new DirectiveElement(directiveName, fo);

                if (directive.params()) {
                    completionProposals.add(new BladeCompletionProposal.DirectiveWithArg(directiveEl, request, directive));
                    if (!directive.endtag().isEmpty()){
                        completionProposals.add(new BladeCompletionProposal.BlockDirectiveWithArg(directiveEl, request, directive));
                    }
                } else {

                    completionProposals.add(new BladeCompletionProposal.InlineDirective(directiveEl, request, directive));
                    if (!directive.endtag().isEmpty()){
                        completionProposals.add(new BladeCompletionProposal.BlockDirective(directiveEl, request, directive));
                    }
                }
            }
        }

        //if (completionProposals.isEmpty()){
            Project project = ProjectUtils.getMainOwner(fo);
                CustomDirectives.getInstance(project).filterAction(new CustomDirectives.FilterCallback() {
                    @Override
                    public void filterDirectiveName(CustomDirectives.CustomDirective directive, FileObject file) {
                        DirectiveElement directiveEl = new DirectiveElement(directive.name, file);
                        if (directive.name.startsWith(prefix)) {
                            CompletionRequest request = completionRequest(prefix, completionContext.getCaretOffset());
                            completionProposals.add(
                                    new BladeCompletionProposal.CustomDirective(
                                            directiveEl,
                                            request,
                                            directive.name
                                    ));
                        }
                    }
            });
        //}
    }

    @Override
    public String document(ParserResult pr, ElementHandle eh) {
        return null;
    }

    @Override
    public ElementHandle resolveLink(String string, ElementHandle eh) {
        return null;
    }

    @Override
    public String getPrefix(ParserResult info, int offset, boolean upToOffset) {
        return null;
    }

    @Override
    public QueryType getAutoQuery(JTextComponent component, String typedText) {
        if (typedText.length() == 0) {
            return QueryType.NONE;
        }

        if (typedText.startsWith("@")){
            return QueryType.ALL_COMPLETION; 
        }

        char lastChar = typedText.charAt(typedText.length() - 1);

        switch (lastChar) {
            case '\n':
                return QueryType.STOP;
            default:
                return QueryType.ALL_COMPLETION;
        }
    }

    @Override
    @SuppressWarnings("rawtypes")
    public String resolveTemplateVariable(String string, ParserResult pr, int i, String string1, Map map) {
        return null;
    }

    @Override
    public Set<String> getApplicableTemplates(Document dcmnt, int i, int i1) {
        return Collections.emptySet();
    }

    @Override
    public ParameterInfo parameters(ParserResult pr, int i, CompletionProposal cp) {
        return new ParameterInfo(new ArrayList<>(), 0, 0);
    }

    /**
     * used also for tooltip in blade mime context
     *
     * @param parserResult
     * @param elementHandle
     * @param cancel
     * @return
     */
    @Override
    public Documentation documentElement(ParserResult parserResult, ElementHandle elementHandle, Callable<Boolean> cancel) {
        Documentation result = null;
        if (elementHandle instanceof PhpFunctionElement) {
            return TooltipDoc.generateFunctionDoc((PhpFunctionElement) elementHandle);
        } else if (elementHandle instanceof DirectiveElement){
            return result;
        } else if (elementHandle instanceof NamedElement) {
            return TooltipDoc.generateDoc((NamedElement) elementHandle);
        }
        return result;
    }
    
    public static CompletionRequest completionRequest(String prefix, int offset){
        CompletionRequest request = new CompletionRequest();
        request.anchorOffset = offset - prefix.length();
        request.carretOffset = offset;
        request.prefix = prefix;
        
        return request;
    }
}
