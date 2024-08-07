/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.php.blade.editor.completion;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Document;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.netbeans.api.editor.document.EditorDocumentUtils;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.ResourceUtilities;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionItem.BladeTag;
import org.netbeans.modules.php.blade.editor.components.AttributeCompletionService;
import org.netbeans.modules.php.blade.editor.components.ComponentsCompletionService;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives.CustomDirective;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexResult;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.netbeans.modules.php.blade.syntax.StringUtils;
import org.netbeans.modules.php.blade.syntax.annotation.Directive;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionProvider;
import static org.netbeans.spi.editor.completion.CompletionProvider.COMPLETION_QUERY_TYPE;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
@MimeRegistrations(value = {
    @MimeRegistration(mimeType = "text/html", service = CompletionProvider.class),
    @MimeRegistration(mimeType = "text/x-blade", service = CompletionProvider.class)
})
public class BladeCompletionProvider implements CompletionProvider {

    private static final Logger LOGGER = Logger.getLogger(BladeCompletionProvider.class.getName());

    public enum CompletionType {
        BLADE_PATH,
        YIELD_ID,
        DIRECTIVE,
        HTML_COMPONENT_TAG
    }

    @Override
    public CompletionTask createTask(int queryType, JTextComponent component) {
        return new AsyncCompletionTask(new BladeCompletionQuery(), component);
    }

    @Override
    public int getAutoQueryTypes(JTextComponent component, String typedText) {
        FileObject fo = EditorDocumentUtils.getFileObject(component.getDocument());
        if (fo == null || !fo.getMIMEType().equals(BladeLanguage.MIME_TYPE)) {
            return 0;
        }

        if (typedText.length() == 0) {
            return 0;
        }

        //don't autocomplete on space, \n, )
        if (typedText.trim().isEmpty()) {
            //TODO this stops raw tags to autocomplete
            return 0;
        }

        char lastChar = typedText.charAt(typedText.length() - 1);
        switch (lastChar) {
            case ')':
            case '\n':
            case '<':
            case '>':
                return 0;
        }
        return COMPLETION_QUERY_TYPE;
    }

    private class BladeCompletionQuery extends AsyncCompletionQuery {

        public BladeCompletionQuery() {
        }

        @Override
        protected void query(CompletionResultSet resultSet, Document doc, int caretOffset) {
            long startTime = System.currentTimeMillis();

            try {
                FileObject fo = EditorDocumentUtils.getFileObject(doc);

                if (fo == null || !fo.getMIMEType().equals(BladeLanguage.MIME_TYPE)) {
                    return;
                }

                AntlrTokenSequence tokens;
                try {
                    String docText = doc.getText(0, doc.getLength());
                    tokens = new AntlrTokenSequence(new BladeAntlrLexer(CharStreams.fromString(docText)));
                } catch (BadLocationException ex) {
                    Exceptions.printStackTrace(ex);
                    return;
                } finally {
                }

                if (tokens.isEmpty()) {
                    return;
                }

                if (caretOffset > 1) {
                    tokens.seekTo(caretOffset - 1);
                } else {
                    tokens.seekTo(caretOffset);
                }

                Token currentToken;

                if (!tokens.hasNext() && tokens.hasPrevious()) {
                    //the carret got too far
                    currentToken = tokens.previous().get();
                } else if (tokens.hasNext()) {
                    currentToken = tokens.next().get();
                } else {
                    return;
                }

                if (currentToken == null) {
                    return;
                }

                if (currentToken.getText().trim().length() == 0) {
                    return;
                }

                switch (currentToken.getType()) {
                    case HTML_IDENTIFIER:
                        completeAttributes(currentToken.getText(), caretOffset, resultSet);
                        break;
                    case HTML:
                        String nText = currentToken.getText();
                        if ("livewire".startsWith(nText)) {
                            //quick implementation
                            //??
                            addHtmlTagCompletionItem(nText, "livewire", "livewire", caretOffset, resultSet);
                        }
                        break;
                    case HTML_COMPONENT_PREFIX:
                        String compPrefix = currentToken.getText().length() > 3 ? StringUtils.kebabToCamel(currentToken.getText().substring(3)) : "";
                        completeComponents(compPrefix, fo, caretOffset, resultSet);
                        break;
                    case D_UNKNOWN_ATTR_ENC:
                        completeDirectives(currentToken.getText(), doc, caretOffset, resultSet);
                        break;
                    default:
                        break;
                }
            } finally {
                long time = System.currentTimeMillis() - startTime;
                if (time > 2000){
                    LOGGER.log(Level.INFO, "Slow completion time detected. {0}ms", time);
                }
                resultSet.finish();
            }
        }
    }

    private void completeDirectives(String prefix, Document doc, int carretOffset, CompletionResultSet resultSet) {
        int startOffset = carretOffset - prefix.length();
        DirectiveCompletionList completionList = new DirectiveCompletionList();

        for (Directive directive : completionList.getDirectives()) {
            String directiveName = directive.name();
            if (directiveName.startsWith(prefix)) {
                if (directive.params()) {
                    resultSet.addItem(DirectiveCompletionBuilder.itemWithArg(
                            startOffset, carretOffset, prefix, directiveName, directive.description(), doc));
                    if (!directive.endtag().isEmpty()) {
                        resultSet.addItem(DirectiveCompletionBuilder.itemWithArg(
                                startOffset, carretOffset, prefix, directiveName, directive.endtag(), directive.description(), doc));
                    }
                } else {
                    resultSet.addItem(DirectiveCompletionBuilder.simpleItem(
                            startOffset, directiveName, directive.description()));
                    if (!directive.endtag().isEmpty()) {
                        resultSet.addItem(DirectiveCompletionBuilder.simpleItem(
                                startOffset, carretOffset, prefix, directiveName, directive.endtag(), directive.description(), doc));
                    }
                }

            }
        }

        FileObject fo = EditorDocumentUtils.getFileObject(doc);
        Project project = ProjectUtils.getMainOwner(fo);

        CustomDirectives.getInstance(project).filterAction(new CustomDirectives.FilterCallback() {
            @Override
            public void filterDirectiveName(CustomDirective customDirective, FileObject file) {
                if (customDirective.name.startsWith(prefix)) {
                    resultSet.addItem(DirectiveCompletionBuilder.itemWithArg(
                            startOffset, carretOffset, prefix, customDirective.name,
                            "custom directive", doc, file));
                }
            }
        });
    }
    
    private void completeComponents(String prefixIdentifier, FileObject fo,
            int caretOffset, CompletionResultSet resultSet) {

        int insertOffset = caretOffset - prefixIdentifier.length();
        ComponentsCompletionService componentComplervice = new ComponentsCompletionService();
        Collection<PhpIndexResult> indexedReferences = componentComplervice.queryComponents(prefixIdentifier, fo);

        for (PhpIndexResult indexReference : indexedReferences) {
            addComponentIdCompletionItem(indexReference,
                    insertOffset, resultSet);
        }

    }

    private void completeAttributes(String prefix, int caretOffset, CompletionResultSet resultSet) {
        int insertOffset = caretOffset;
        AttributeCompletionService attributeCompletionService = new AttributeCompletionService();
        Collection<String> attributes = attributeCompletionService.queryComponents(prefix);

        for (String attribute : attributes) {
            addSimplAttributeItem(prefix, attribute, insertOffset, resultSet);
        }
    }

    //??
    private void addHtmlTagCompletionItem(String prefix, String tagName, String plugin,
            int caretOffset, CompletionResultSet resultSet) {

        int insertOffset = caretOffset - prefix.length();
        BladeTag item = new BladeTag(tagName, insertOffset);
        resultSet.addItem(item);
    }

    private void addSimplAttributeItem(String prefix, String attributeName, int caretOffset, CompletionResultSet resultSet) {
        int insertOffset = caretOffset - prefix.length();
        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(attributeName)
                .startOffset(insertOffset)
                .leftHtmlText(attributeName)
                .sortPriority(1)
                .build();
        resultSet.addItem(item);
    }

    private void addComponentIdCompletionItem(PhpIndexResult indexReference,
            int caretOffset, CompletionResultSet resultSet) {

        String tagName = StringUtils.toKebabCase(indexReference.name);
        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(tagName)
                .iconResource(getReferenceIcon(CompletionType.HTML_COMPONENT_TAG))
                .startOffset(caretOffset)
                .leftHtmlText(tagName)
                .rightHtmlText(indexReference.namespace)
                .sortPriority(1)
                .build();
        resultSet.addItem(item);
    }

    private static String getReferenceIcon(CompletionType type) {
        switch (type) {
            case HTML_COMPONENT_TAG:
                return "org/netbeans/modules/html/custom/resources/custom_html_element.png"; //NOI18N
            case YIELD_ID:
                return ResourceUtilities.ICON_BASE + "icons/layout.png"; //NOI18N
        }
        return ResourceUtilities.ICON_BASE + "icons/at.png";
    }

}
