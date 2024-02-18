package org.netbeans.modules.php.blade.editor.completion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.netbeans.editor.BaseDocument;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.antlr.v4.runtime.Token;
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
import org.netbeans.modules.php.blade.csl.elements.ElementType;
import org.netbeans.modules.php.blade.csl.elements.NamedElement;
import org.netbeans.modules.php.blade.csl.elements.PhpFunctionElement;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionItem.CompletionRequest;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexFunctionResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexUtils;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult.FieldAccessReference;
import org.netbeans.modules.php.blade.editor.parser.BladeParserResult.Reference;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrUtils;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import org.netbeans.spi.project.ui.support.ProjectConvertors;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class BladeCompletionHandler implements CodeCompletionHandler2 {

    static enum ContextType {
        GENERIC_IDENTIFIER, PHP_FUNCTION, NONE
    }

    @Override
    public CodeCompletionResult complete(CodeCompletionContext completionContext) {
        BaseDocument doc = (BaseDocument) completionContext.getParserResult().getSnapshot().getSource().getDocument(false);
        if (doc == null) {
            return CodeCompletionResult.NONE;
        }

        if (CancelSupport.getDefault().isCancelled()) {
            return CodeCompletionResult.NONE;
        }

        if (completionContext.getCaretOffset() < 1) {
            return CodeCompletionResult.NONE;
        }

        BladeParserResult parserResult = (BladeParserResult) completionContext.getParserResult();

        final List<CompletionProposal> completionProposals = new ArrayList<>();

        Token currentToken = BladeAntlrUtils.getToken(doc, completionContext.getCaretOffset() - 1);

        if (currentToken == null) {
            return CodeCompletionResult.NONE;
        }

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
        }

        //TODO add context
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
                    int offsetNamespace = offset - (prefix.length() + 1);
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
        CompletionRequest request = new CompletionRequest();
        request.anchorOffset = offset - prefix.length();
        request.carretOffset = offset;
        request.prefix = prefix;
        for (PhpIndexResult indexResult : indexClassResults) {
            NamedElement classElement = new NamedElement(indexResult.name, indexResult.declarationFile, ElementType.PHP_CLASS);
            completionProposals.add(new BladeCompletionItem.ClassItem(classElement, request, indexResult.name));
        }
    }

    private void completeNamespacedPhpClasses(String prefix, String namespace,
            int offset, final List<CompletionProposal> completionProposals,
            BladeParserResult parserResult) {
        Collection<PhpIndexResult> indexClassResults = PhpIndexUtils.queryNamespaceClasses(
                prefix, namespace, parserResult.getSnapshot().getSource().getFileObject());
        CompletionRequest request = new CompletionRequest();
        request.anchorOffset = offset - namespace.length();
        request.carretOffset = offset;
        request.prefix = namespace;
        for (PhpIndexResult indexResult : indexClassResults) {
            NamedElement classElement = new NamedElement(indexResult.name, indexResult.declarationFile, ElementType.PHP_CLASS);
            completionProposals.add(new BladeCompletionItem.ClassItem(classElement, request, indexResult.name));
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
        CompletionRequest request = new CompletionRequest();
        request.anchorOffset = offset - prefix.length();
        request.carretOffset = offset;
        request.prefix = prefix;
        for (PhpIndexFunctionResult indexResult : indexedFunctions) {
            //to be completed
            //might add syntax completion cursor
            String completion = indexResult.name + "()";
            String preview = indexResult.name + indexResult.getParamsAsString();
            NamedElement functionElement = new NamedElement(completion, indexResult.declarationFile, ElementType.PHP_FUNCTION);
            completionProposals.add(new BladeCompletionItem.FunctionItem(functionElement, request, preview));
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
        CompletionRequest request = new CompletionRequest();
        request.anchorOffset = offset - prefix.length();
        request.carretOffset = offset;
        request.prefix = prefix;
        for (PhpIndexFunctionResult indexResult : indexedFunctions) {
            //to be completed
            //might add syntax completion cursor
            String completion = indexResult.name + "()";
            String preview = indexResult.name + indexResult.getParamsAsString();
            NamedElement functionElement = new NamedElement(completion, indexResult.declarationFile, ElementType.PHP_FUNCTION);
            completionProposals.add(new BladeCompletionItem.FunctionItem(functionElement, request, preview));
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
        CompletionRequest request = new CompletionRequest();
        request.anchorOffset = offset - prefix.length();
        request.carretOffset = offset;
        request.prefix = prefix;
        for (PhpIndexResult indexResult : indexClassResults) {
            NamedElement constantElement = new NamedElement(indexResult.name, indexResult.declarationFile, ElementType.PHP_CONSTANT);
            completionProposals.add(new BladeCompletionItem.NamespaceItem(constantElement, request, indexResult.name));
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
        CompletionRequest request = new CompletionRequest();
        request.anchorOffset = offset - prefix.length();
        request.carretOffset = offset;
        request.prefix = prefix;
        for (PhpIndexResult indexResult : indexClassResults) {
            NamedElement constantElement = new NamedElement(indexResult.name, indexResult.declarationFile, ElementType.PHP_CONSTANT);
            completionProposals.add(new BladeCompletionItem.ConstantItem(constantElement, request, indexResult.name));
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
        CompletionRequest request = new CompletionRequest();
        request.anchorOffset = offset - prefix.length();
        request.carretOffset = offset;
        request.prefix = prefix;
        for (PhpIndexResult indexResult : indexClassResults) {
            NamedElement constantElement = new NamedElement(indexResult.name, indexResult.declarationFile, ElementType.PHP_CONSTANT);
            completionProposals.add(new BladeCompletionItem.ConstantItem(constantElement, request, indexResult.name));
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
        Set<String> scopedVariables = parserResult.findVariablesForScope(completionContext.getCaretOffset());
        FileObject fo = completionContext.getParserResult().getSnapshot().getSource().getFileObject();
        if (scopedVariables != null) {
            for (String variableName : scopedVariables) {
                if (variableName.startsWith(variablePrefix)) {
                    NamedElement variableElement = new NamedElement(variableName, fo, ElementType.VARIABLE);
                    CompletionRequest request = new CompletionRequest();
                    request.anchorOffset = completionContext.getCaretOffset() - variablePrefix.length();
                    request.carretOffset = completionContext.getCaretOffset();
                    request.prefix = variablePrefix;
                    completionProposals.add(new BladeCompletionItem.VariableItem(variableElement, request, variableName));
                }
            }
        }
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
        return "";
    }

    @Override
    public QueryType getAutoQuery(JTextComponent component, String typedText) {
        if (typedText.length() == 0) {
            return QueryType.NONE;
        }

        char lastChar = typedText.charAt(typedText.length() - 1);

        switch (lastChar) {
            case '\n':
                return QueryType.STOP;
            default:
                return QueryType.TOOLTIP;
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
        } else if (elementHandle instanceof NamedElement) {
            return TooltipDoc.generateDoc((NamedElement) elementHandle);
        }
        return result;
    }
}
