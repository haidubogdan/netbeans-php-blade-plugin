/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2016 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2016 Sun Microsystems, Inc.
 */
package org.netbeans.modules.php.blade.editor.completion;

import java.io.File;
import org.netbeans.modules.php.blade.editor.model.api.BladePathElement;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.document.LineDocumentUtils;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.netbeans.modules.csl.api.CodeCompletionContext;
import org.netbeans.modules.csl.api.CodeCompletionHandler;
import org.netbeans.modules.csl.api.CodeCompletionHandler2;
import org.netbeans.modules.csl.api.CodeCompletionResult;
import org.netbeans.modules.csl.api.CompletionProposal;
import org.netbeans.modules.csl.api.Documentation;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.api.ParameterInfo;
import org.netbeans.modules.csl.spi.DefaultCompletionResult;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.php.blade.editor.BladeIndexSupport;
import org.netbeans.modules.php.blade.editor.BladeSyntax;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionContextFinder.KeywordCompletionType;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionContextFinder.CompletionContext;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionItem.CompletionRequest;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionItem.SectionCompletionItem;
import org.netbeans.modules.php.blade.editor.index.api.BladeIndex;
import org.netbeans.modules.php.blade.editor.index.api.IndexedElement;
import org.netbeans.modules.php.blade.editor.parsing.ParsingUtils;
import org.netbeans.modules.php.blade.project.CustomDirectives;
import org.netbeans.modules.php.blade.project.CustomDirectives.DirectiveNames;
import org.netbeans.modules.php.editor.csl.PHPLanguage;
import org.openide.filesystems.FileObject;
import org.openide.util.NbBundle;

public class BladeCompletionHandler implements CodeCompletionHandler2 {

    private static final Logger LOGGER = Logger.getLogger(BladeCompletionHandler.class.getSimpleName());
    static final Collection<String> BLADE_KEYWORDS = Arrays.asList(
        "@continue",
        "@csrf",
        "@break",
        "@endfor",
        "@endif",
        "@endforeach",
        "@endsection",
        "@stop",
        "@append",
        "@empty"
    );

    static final Map<String, KeywordCompletionType> BLADE_DIRECTIVES = new HashMap<>();

    static {
        BLADE_DIRECTIVES.put("@yield", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@checked", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@selected", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@disabled", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@required", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@push", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@once", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@pushOnce", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@env", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@extends", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@include", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@includeIf", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@inject", KeywordCompletionType.WITH_ARG); //NOI18N
        BLADE_DIRECTIVES.put("@if", KeywordCompletionType.WITH_ARG_AND_ENDTAG); //NOI18N
        BLADE_DIRECTIVES.put("@for", KeywordCompletionType.WITH_ARG_AND_ENDTAG); //NOI18N
        BLADE_DIRECTIVES.put("@foreach", KeywordCompletionType.WITH_ARG_AND_ENDTAG); //NOI18N
        BLADE_DIRECTIVES.put("@forelse", KeywordCompletionType.WITH_ARG_AND_ENDTAG); //NOI18N
        BLADE_DIRECTIVES.put("@production", KeywordCompletionType.WITH_ARG_AND_ENDTAG); //NOI18N
        BLADE_DIRECTIVES.put("@auth", KeywordCompletionType.WITH_ARG_AND_ENDTAG); //NOI18N
        BLADE_DIRECTIVES.put("@guest", KeywordCompletionType.WITH_ARG_AND_ENDTAG); //NOI18N
        BLADE_DIRECTIVES.put("@switch", KeywordCompletionType.WITH_ARG_AND_ENDTAG); //NOI18N
        BLADE_DIRECTIVES.put("@section", KeywordCompletionType.WITH_ARG_AND_ENDTAG); //NOI18N
        BLADE_DIRECTIVES.put("@can", KeywordCompletionType.WITH_ARG_AND_ENDTAG); //NOI18N
        BLADE_DIRECTIVES.put("@canany", KeywordCompletionType.WITH_ARG_AND_ENDTAG); //NOI18N
        BLADE_DIRECTIVES.put("@cannot", KeywordCompletionType.WITH_ARG_AND_ENDTAG); //NOI18N
        BLADE_DIRECTIVES.put("@php", KeywordCompletionType.WITH_ENDTAG);
    }

    @Override
    public CodeCompletionResult complete(CodeCompletionContext codeCompletionContext) {

        final List<CompletionProposal> completionProposals = new ArrayList<>();
        ParserResult parserResult = codeCompletionContext.getParserResult();

        if (!(parserResult instanceof BladeParserResult)) {
            return CodeCompletionResult.NONE;
        }

        BladeParserResult bladeParserResult = (BladeParserResult) parserResult;
        if (bladeParserResult.getProgram() == null) {
            return CodeCompletionResult.NONE;
        }

        final FileObject fileObject = bladeParserResult.getSnapshot().getSource().getFileObject();
        if (fileObject == null) {
            return CodeCompletionResult.NONE;
        }

        CompletionRequest request = new CompletionRequest();
        request.prefix = codeCompletionContext.getPrefix();
        int caretOffset = codeCompletionContext.getCaretOffset();

        //searching the context 
        //it might be space before @section
        String properPrefix = getPrefix(bladeParserResult, caretOffset, true);
        if (request.prefix.length() == 0) {
            request.prefix = properPrefix;
        }

        request.carretOffset = caretOffset;
        request.anchorOffset = caretOffset - (properPrefix == null ? 0 : properPrefix.length());
        request.parserResult = bladeParserResult;

        //TODO we can move the context finder here and update some values directly
        //we have also get Prefix function
        request.context = BladeCompletionContextFinder.find(request.parserResult, caretOffset);
        BladeIndexSupport sup = BladeIndexSupport.findFor(fileObject);
        if (sup != null) {
            request.index = sup.getIndex();
        }
        doCompletion(completionProposals, request);
        return new DefaultCompletionResult(completionProposals, false);
    }

    private void doCompletion(final List<CompletionProposal> completionProposals, final CompletionRequest request) {
        switch (request.context) {
            case PATH:
                completeBladeViews(completionProposals, request);
                break;
            case SECTION_LABEL:
            //no break
            case SECTION:
                completeYields(completionProposals, request);
                break;
            case DIRECTIVE:
                completeDirectives(completionProposals, request);
                completeKeywords(completionProposals, request);
                completeCustomDirectives(completionProposals, request);
                break;
            case PHP:
            case BLADE_ECHO:    
                if (request.prefix.length() > 0) {
                    completePhp(completionProposals, request);
                }
                break;
            case ALL:
                completeAll(completionProposals, request);
                break;
            case NONE:
                break;
            default:
                completeAll(completionProposals, request);
        }
    }

    private void completeAll(final List<CompletionProposal> completionProposals, final CompletionRequest request) {
        completeDirectives(completionProposals, request);
        completeBladeViews(completionProposals, request);
        completeKeywords(completionProposals, request);
    }

    private void completeDirectives(final List<CompletionProposal> completionProposals, final CompletionRequest request) {
        List<String> defaultDirectives = new ArrayList<>(BLADE_DIRECTIVES.keySet());
        for (String directive : defaultDirectives) {
            if (startsWith(directive, request.prefix)) {
                GeneratedDirectiveElement element = new GeneratedDirectiveElement(directive);
                completionProposals.add(new BladeCompletionItem.DirectiveItem(element, request));
            }
        }
    }
    
    private void completeCustomDirectives(final List<CompletionProposal> completionProposals, final CompletionRequest request){
        Map<FileObject, DirectiveNames> customDirectives = CustomDirectives.getInstance().getCustomDirectives();
        
        if (customDirectives.isEmpty()){
            return;
        }
        
        for (Map.Entry<FileObject, DirectiveNames> entry : customDirectives.entrySet()){
            List<String> directiveNames = entry.getValue().getList();
            for (String directiveName : directiveNames){
                if (startsWith(directiveName, request.prefix)) {
                    GeneratedDirectiveElement element = new GeneratedDirectiveElement(directiveName, entry.getKey());
                    completionProposals.add(new BladeCompletionItem.DirectiveItem(element, request));
                }
            }
        }
    }
    

    private void completeKeywords(final List<CompletionProposal> completionProposals, final CompletionRequest request) {
        for (String keyword : BLADE_KEYWORDS) {
            if (startsWith(keyword, request.prefix)) {
                completionProposals.add(new BladeCompletionItem.KeywordItem(keyword, request));
            }
        }
    }

    private void completeBladeViews(final List<CompletionProposal> completionProposals, final CompletionRequest request) {
        if (request.index == null) {
            return;
        }

        String queryText = "";
        int startInput = -1;
        //we can assume it's a directive
        if (request.prefix.indexOf("@") == 0) {
            startInput = request.prefix.indexOf("\"");
            if (startInput < 0) {
                startInput = request.prefix.indexOf("'");
            }
            if (startInput > 0) { //we are inside quotes
                queryText = request.prefix.substring(startInput + 1, request.prefix.length());
            }
        }
        Collection<IndexedElement> bladeViews;
        if (queryText.isEmpty()) {
            bladeViews = request.index.findAllBladeViewPaths();
        } else {
            bladeViews = request.index.findBladePathsByPrefix(queryText, BladeIndex.MatchType.PREFIX);
        }

        for (IndexedElement bladeView : bladeViews) {
            String path = bladeView.getName();
            FileObject file = bladeView.getFileObject();
            String textToComplete;

            if (startInput > 0) {
                if (queryText.length() > 0 && !path.startsWith(queryText)) {
                    continue;
                }
                textToComplete = request.prefix + path.substring(queryText.length());
            } else {
                textToComplete = request.prefix + "(\"" + path + "\")";
            }
            //TODO adapt completion item to IndexedElement
            BladePathElement element = new BladePathElement(textToComplete, file);
            completionProposals.add(new BladeCompletionItem(element, request, path));
        }
    }

    private void completeYields(final List<CompletionProposal> completionProposals, final CompletionRequest request) {
        if (request.index == null) {
            return;
        }

        String queryText = "";
        int startInput = -1;

        if (request.context == CompletionContext.SECTION_LABEL) {
            startInput = request.prefix.indexOf("\"");
            if (startInput < 0) {
                startInput = request.prefix.indexOf("'");
            }
            if (startInput > 0) { //we are inside quotes
                queryText = request.prefix.substring(startInput + 1, request.prefix.length());
            }
        }

        boolean prefixHasDirective = request.prefix.contains("@section");

        Collection<IndexedElement> yields = request.index.findYieldsByPrefix(queryText, BladeIndex.MatchType.PREFIX);

        for (IndexedElement yield : yields) {
            if (yield.getName().isEmpty()) {
                continue;
            }

            String textToComplete;
            BladePathElement element;

            if (prefixHasDirective) {
                if (startInput > 0) {
                    textToComplete = request.prefix + yield.getName().substring(queryText.length());
                } else {
                    textToComplete = request.prefix + "(\"" + yield.getName() + "\")\n\n@endsection";
                }
            } else {
                textToComplete = yield.getName();
            }
            element = new BladePathElement(textToComplete, yield.getFileObject());
            completionProposals.add(new SectionCompletionItem(element, request));
        }

    }

    /**
     * simulating a php completion in php blade context to fix the issue that
     * the php embedding is not working if we don't have PHP_OPEN tags TODO fix
     * issue with exception
     *
     * @param completionProposals
     * @param request
     */
    private void completePhp(final List<CompletionProposal> completionProposals, final CompletionRequest request) {
        CodeCompletionHandler cc = (new PHPLanguage()).getCompletionHandler();
        ParserResult phpParserResult = request.parserResult.getProgram().getPhpParserResult();
        if (phpParserResult == null){
            return;
        }
        String prefix = cc.getPrefix(phpParserResult, request.carretOffset, true);
        
        if (prefix == null){
            return;
        }
        
        if (prefix.length() == 0){
            prefix = cc.getPrefix(phpParserResult, request.carretOffset - 1, true);
        }
        
        String phpPrefix = prefix;
        
        CodeCompletionContext context = new CodeCompletionContext() {
            @Override
            public int getCaretOffset() {
                return request.carretOffset;
            }

            @Override
            public ParserResult getParserResult() {
                return phpParserResult;
            }

            @Override
            public String getPrefix() {
                return phpPrefix;
            }

            @Override
            public boolean isPrefixMatch() {
                return true;
            }

            @Override
            public QueryType getQueryType() {
                return QueryType.COMPLETION;
            }

            @Override
            public boolean isCaseSensitive() {
                return false;
            }
        };

        CodeCompletionResult completionResult = cc.complete(context);
        List<CompletionProposal> proposals = completionResult.getItems();
        for (CompletionProposal proposal : proposals) {
            completionProposals.add(proposal);
        }


    }

    private void completePhpVariables(final List<CompletionProposal> completionProposals, final CompletionRequest request) {
        //ElementQuery.Index index = request.parserResult.getPhpIndexQuery();
        //index.getAlllFields(PhpElementKind.VARIABLE, NameKind.prefix(""));
        //PHPIndexer.getAllFields();
        ParsingUtils parsingUtils = new ParsingUtils();
        String varPrefix = request.prefix.substring(2, request.prefix.length() - 2);
        parsingUtils.parsePhpText("<?php " + varPrefix);
        ParserResult phpParserResult = parsingUtils.getParserResult();
//        FileScope topScope = parsingUtils.getParserResult().getModel().getFileScope();
//        VariableScope variableScope = parsingUtils.getParserResult().getModel().getVariableScope(10);
//        List<VariableName> allDeclaredVariables = new ArrayList<>(variableScope.getDeclaredVariables());
//        int debug = 3;
//        Model model = request.parserResult.getPhpModel();
//        FileScope topScope = model.getFileScope();
//        Collection<? extends VariableName> list = ModelUtils.getDeclaredVariables(topScope);
//        int debug = 3;
        CodeCompletionHandler cc = (new PHPLanguage()).getCompletionHandler();
        String prefix = cc.getPrefix(parsingUtils.getParserResult(), 6 + varPrefix.length(), true);
        CodeCompletionContext context = new CodeCompletionContext() {
            @Override
            public int getCaretOffset() {
                return request.carretOffset;
            }

            @Override
            public ParserResult getParserResult() {
                return phpParserResult;
            }

            @Override
            public String getPrefix() {
                return prefix;
            }

            @Override
            public boolean isPrefixMatch() {
                return true;
            }

            @Override
            public QueryType getQueryType() {
                return QueryType.COMPLETION;
            }

            @Override
            public boolean isCaseSensitive() {
                return false;
            }
        };
        if (prefix != null) {
            CodeCompletionResult completionResult = cc.complete(context);
            List<CompletionProposal> proposals = completionResult.getItems();
            for (CompletionProposal proposal : proposals) {
                completionProposals.add(proposal);
            }
        }
    }

    private static boolean startsWith(String theString, String prefix) {
        return prefix.length() == 0 ? true : theString.toLowerCase().startsWith(prefix.toLowerCase());
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
        return PrefixResolver.create(info, offset, upToOffset).resolve();
    }

    @Override
    public QueryType getAutoQuery(JTextComponent jtc, String string) {
        if (string.length() == 0) {
            return QueryType.NONE;
        }

        return QueryType.ALL_COMPLETION;
    }

    @Override
    public String resolveTemplateVariable(String string, ParserResult pr, int i, String string1, Map map) {
        return null;
    }

    @Override
    public Set<String> getApplicableTemplates(Document dcmnt, int i, int i1) {
        return Collections.emptySet();
    }

    @Override
    public ParameterInfo parameters(ParserResult pr, int i, CompletionProposal cp) {
        return new ParameterInfo(new ArrayList<String>(), 0, 0);
    }

    @Override
    public Documentation documentElement(ParserResult parserResult, ElementHandle elementHandle, Callable<Boolean> cancel) {
        Documentation result = null;
        
        if (elementHandle instanceof GeneratedDirectiveElement) {
            //correspondence with Bundle.properties must be 1 to 1
            try {
                result = Documentation.create(NbBundle.getMessage(BladeCompletionHandler.class, "TAG_" + elementHandle.getName()),
                        BladeSyntax.getDocumentationUrl());
            } catch (Exception ex) {
                //add a logger info
            }
        } else if (elementHandle instanceof BladePathElement) {
            //we can add the filename
            if (elementHandle.getFileObject() != null) {
                BladePathElement bladeElement = (BladePathElement) elementHandle;
                result = DocRenderer.document(parserResult, bladeElement);
            } else {
                String tooltip = elementHandle.getName();
                result = Documentation.create(String.format("<div align=\"right\"><font size=-1>%s</font></div>", tooltip),
                        BladeSyntax.getDocumentationUrl());
            }
        }
        return result;
    }

    private static final class PrefixResolver {

        //if info will not be implemented we can remove at the end
        private final ParserResult info;
        private final int offset;
        private final boolean upToOffset;
        private BaseDocument doc;
        private String result = "";

        static PrefixResolver create(ParserResult info, int offset, boolean upToOffset) {
            return new PrefixResolver(info, offset, upToOffset);
        }

        private PrefixResolver(ParserResult info, int offset, boolean upToOffset) {
            this.info = info;
            this.offset = offset;
            this.upToOffset = upToOffset;
            this.doc = (BaseDocument) info.getSnapshot().getSource().getDocument(false);
        }

        String resolve() {
            if (doc != null) {
                int lineBegin = LineDocumentUtils.getLineStart(doc, offset);
                try {
                    int lineEnd = LineDocumentUtils.getLineEnd(doc, offset);
                    if (lineBegin != -1 && lineEnd > 0) {
                        String line = doc.getText(lineBegin, lineEnd - lineBegin);
                        int lineOffset = offset - lineBegin;
                        int start = 0;
                        String prefix;
                        prefix = line.substring(start, lineOffset);
                        //find the first directive
                        int lastIndexOfAt = prefix.lastIndexOf('@'); //NOI18N

                        if (lastIndexOfAt >= 0) {
                            prefix = prefix.substring(lastIndexOfAt);
                        } else {
                            prefix = line.substring(start);
                        }
                        result = prefix;
                    }
                } catch (BadLocationException ble) {
                    //Exceptions.printStackTrace(ble);
                }
            }

            return result;
        }
    }

}
