package org.netbeans.modules.php.blade.editor.completion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Document;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.netbeans.api.editor.document.EditorDocumentUtils;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.api.project.Project;
import org.netbeans.lib.editor.codetemplates.api.CodeTemplateManager;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.ResourceUtilities;
import org.netbeans.modules.php.blade.editor.components.AttributeCompletionService;
import org.netbeans.modules.php.blade.editor.components.ComponentsCompletionService;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex.IndexedReferenceId;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexUtils;
import org.netbeans.modules.php.blade.editor.path.PathUtils;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.netbeans.modules.php.blade.syntax.StringUtils;
import org.netbeans.modules.php.blade.syntax.annotation.Directive;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParser.CONTENT_TAG_OPEN;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParser.RAW_TAG_CLOSE;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrUtils;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionProvider;
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
    @MimeRegistration(mimeType = BladeLanguage.MIME_TYPE, service = CompletionProvider.class),
    //nb18 compatibility
    @MimeRegistration(mimeType = "text/html", service = CompletionProvider.class)
})
public class BladeCompletionProvider implements CompletionProvider {

    private static final Logger LOGGER = Logger.getLogger(BladeCompletionProvider.class.getName());

    public enum CompletionType {
        BLADE_PATH,
        YIELD_ID,
        DIRECTIVE,
        HTML_COMPONENT_TAG,
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
            long startTime = 0;
            if (LOGGER.isLoggable(Level.FINE)) {
                startTime = System.currentTimeMillis();
            }
            AbstractDocument adoc = (AbstractDocument) doc;
            try {
                FileObject fo = EditorDocumentUtils.getFileObject(doc);

                if (fo == null || !fo.getMIMEType().equals(BladeLanguage.MIME_TYPE)) {
                    return;
                }

                adoc.readLock();
                AntlrTokenSequence tokens;
                try {
                    String docText = doc.getText(0, doc.getLength());
                    tokens = new AntlrTokenSequence(new BladeAntlrLexer(CharStreams.fromString(docText)));
                } catch (BadLocationException ex) {
                    return;
                } finally {
                    adoc.readUnlock();
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
                    case BLADE_COMMENT:
                    case RAW_TAG_CLOSE:
                        return;
                    case PHP_EXPRESSION:
                        return;
                }

                switch (currentToken.getType()) {
                    case CONTENT_TAG_OPEN:
                    case RAW_TAG_OPEN:
                        completeBladeTags(currentToken.getText(), currentToken, tokens, doc, caretOffset, resultSet);
                        break;
                    case HTML_IDENTIFIER:
                        completeAttributes(currentToken.getText(), caretOffset, resultSet);
                        break;
                    case HTML:
                    case D_UNKNOWN:
                        String nText = currentToken.getText();
                        if (nText.startsWith("@")) {
                            completeDirectives(nText, doc, caretOffset, resultSet);
                        } else if (nText.startsWith("{")) {
                            completeBladeTags(nText, currentToken, tokens, doc, caretOffset, resultSet);
                        } else if ("livewire".startsWith(nText)) {
                            //quick implementation
                            addHtmlTagCompletionItem(nText, "livewire", "livewire", caretOffset, resultSet);
                        }
                        break;
                    case HTML_COMPONENT_PREFIX:
                        String compPrefix = currentToken.getText().length() > 3 ? StringUtils.capitalize(currentToken.getText().substring(3)) : "";
                        completeComponents(compPrefix, fo, caretOffset, resultSet);
                        break;
                    case BL_PARAM_STRING: {
                        String pathName = currentToken.getText().substring(1, currentToken.getText().length() - 1);
                        List<Integer> tokensMatch = Arrays.asList(new Integer[]{
                            D_EXTENDS, D_INCLUDE, D_SECTION, D_HAS_SECTION,
                            D_INCLUDE_IF, D_INCLUDE_WHEN, D_INCLUDE_UNLESS, D_INCLUDE_FIRST,
                            D_EACH, D_PUSH, D_PUSH_IF, D_PREPEND
                        });     //todo 
                        //we should have the stop tokens depending on context
                        List<Integer> tokensStop = Arrays.asList(new Integer[]{HTML, BL_COMMA, BL_PARAM_CONCAT_OPERATOR});
                        Token directiveToken = BladeAntlrUtils.findBackward(tokens, tokensMatch, tokensStop);
                        if (directiveToken == null) {
                            return;
                        }
                        switch (directiveToken.getType()) {
                            case D_EXTENDS:
                            case D_INCLUDE:
                            case D_INCLUDE_IF:
                            case D_INCLUDE_WHEN:
                            case D_INCLUDE_UNLESS:
                            case D_EACH:

                                int lastDotPos;

                                if (pathName.endsWith(".")) {
                                    lastDotPos = pathName.length();
                                } else {
                                    lastDotPos = pathName.lastIndexOf(".");
                                }
                                int pathOffset;

                                if (lastDotPos > 0) {
                                    int dotFix = pathName.endsWith(".") ? 0 : 1;
                                    pathOffset = caretOffset - pathName.length() + lastDotPos + dotFix;
                                } else {
                                    pathOffset = caretOffset - pathName.length();
                                }
                                List<FileObject> childrenFiles = PathUtils.getParentChildrenFromPrefixPath(fo, pathName);
                                for (FileObject file : childrenFiles) {
                                    String pathFileName = file.getName();
                                    if (!file.isFolder()) {
                                        pathFileName = pathFileName.replace(".blade", "");
                                    }
                                    completeBladePath(pathFileName, file, pathOffset, resultSet);
                                }
                                return;
                            case D_SECTION:
                            case D_HAS_SECTION:
                                completeYieldIdFromIndex(pathName, fo, caretOffset, resultSet);
                                return;
                            case D_PUSH:
                            case D_PUSH_IF:
                            case D_PREPEND:
                                completeStackIdFromIndex(pathName, fo, caretOffset, resultSet);
                         }
                        break;
                    }
                    default:
                        break;
                }
            } finally {
                if (LOGGER.isLoggable(Level.FINE)) {
                    long time = System.currentTimeMillis() - startTime;
                    LOGGER.fine(String.format("complete() took %d ms", time));
                }
                resultSet.finish();
            }
        }
    }

    private void completeBladeTags(String tag, Token currentToken,
            AntlrTokenSequence tokens,
            Document doc, int carretOffset, CompletionResultSet resultSet) {

        switch (tag) {
            case "{":
                completeBladeTag(currentToken, doc, "{", "}}", -50, carretOffset, "regular echo", resultSet);
                completeBladeTag(currentToken, doc, "!!", "!!}", -40, carretOffset, "raw echo", resultSet);
                completeBladeTag(currentToken, doc, "{--", "--}}", -30, carretOffset, "comment", resultSet);
                break;
            case "{!":
                completeBladeTag(currentToken, doc, "!", "!!}", -40, carretOffset, "raw echo", resultSet);
                break;
            case "{{":
                completeCloseTag(currentToken, doc, "}}", carretOffset, resultSet);
                break;
            case "{!!":
                completeCloseTag(currentToken, doc, "!!}", carretOffset, resultSet);
                break;
        }
    }

    @SuppressWarnings("rawtypes")
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
            public void filterDirectiveName(String directiveName, FileObject file) {
                if (directiveName.startsWith(prefix)) {
                    resultSet.addItem(DirectiveCompletionBuilder.itemWithArg(
                            startOffset, carretOffset, prefix, directiveName,
                            "custom directive", doc, file));
                }
            }
        });
    }

    private void completeYieldIdFromIndex(String prefixIdentifier, FileObject fo,
            int caretOffset, CompletionResultSet resultSet) {
        BladeIndex bladeIndex;
        Project project = ProjectUtils.getMainOwner(fo);
        int insertOffset = caretOffset - prefixIdentifier.length();
        try {
            bladeIndex = BladeIndex.get(project);
            List<IndexedReferenceId> indexedReferences = bladeIndex.getYieldIds(prefixIdentifier);
            for (IndexedReferenceId indexReference : indexedReferences) {
                addYieldIdCompletionItem(indexReference.getIdenfiier(), indexReference.getOriginFile(),
                        insertOffset, resultSet);
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void completeStackIdFromIndex(String prefixIdentifier, FileObject fo,
            int caretOffset, CompletionResultSet resultSet) {
        BladeIndex bladeIndex;
        Project project = ProjectUtils.getMainOwner(fo);
        int insertOffset = caretOffset - prefixIdentifier.length();
        try {
            bladeIndex = BladeIndex.get(project);
            List<IndexedReferenceId> indexedReferences = bladeIndex.getStacksIndexedReferences(prefixIdentifier);
            for (IndexedReferenceId indexReference : indexedReferences) {
                addYieldIdCompletionItem(indexReference.getIdenfiier(), indexReference.getOriginFile(),
                        insertOffset, resultSet);
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void completeBladeTag(Token curlyStartToken, Document doc, String openTag, String closeTag,
            int caretOffset, int priority, String description, CompletionResultSet resultSet) {
        final String finalCloseTag = closeTag;
        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(closeTag)
                .iconResource(getReferenceIcon())
                .startOffset(caretOffset)
                .leftHtmlText(openTag + " " + closeTag)
                .rightHtmlText(description)
                .sortPriority(priority)
                .onSelect(ctx -> {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(openTag);
                        sb.append(" ");
                        sb.append("${cursor} ");
                        sb.append(finalCloseTag);
                        CodeTemplateManager.get(doc).createTemporary(sb.toString()).insert(ctx.getComponent());
                        if (curlyStartToken.getStopIndex() == (caretOffset - 1)) {
                            doc.insertString(caretOffset, " ", null);
                        }
                    } catch (BadLocationException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                })
                .build();
        resultSet.addItem(item);
    }

    private void completeCloseTag(Token curlyStartToken, Document doc, String closeTag,
            int caretOffset, CompletionResultSet resultSet) {
        final String finalCloseTag = closeTag;
        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(closeTag)
                .iconResource(getReferenceIcon())
                .startOffset(caretOffset)
                .leftHtmlText(closeTag)
                .rightHtmlText(null)
                .onSelect(ctx -> {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(" ");
                        sb.append("${cursor} ");
                        sb.append(finalCloseTag);
                        CodeTemplateManager.get(doc).createTemporary(sb.toString()).insert(ctx.getComponent());
                        if (curlyStartToken.getStopIndex() == (caretOffset - 1)) {
                            doc.insertString(caretOffset, " ", null);
                        }
                    } catch (BadLocationException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                })
                .build();
        resultSet.addItem(item);
    }

    private void completeBladePath(String bladePath, FileObject originFile,
            int caretOffset, CompletionResultSet resultSet) {

        String filePath = originFile.getPath();
        int viewsPos = filePath.indexOf("/views/");

        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(bladePath)
                .iconResource(getReferenceIcon(originFile))
                .startOffset(caretOffset)
                .leftHtmlText(bladePath)
                .rightHtmlText(filePath.substring(viewsPos, filePath.length()))
                .sortPriority(1)
                .build();
        resultSet.addItem(item);
    }

    private void addYieldIdCompletionItem(String identifier, FileObject fo,
            int caretOffset, CompletionResultSet resultSet) {

        String filePath = fo.getPath();
        int viewsPos = filePath.indexOf("/views/");

        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(identifier)
                .iconResource(getReferenceIcon(CompletionType.YIELD_ID))
                .startOffset(caretOffset)
                .leftHtmlText(identifier)
                .rightHtmlText(filePath.substring(viewsPos, filePath.length()))
                .sortPriority(1)
                .build();
        resultSet.addItem(item);
    }

    private void completeComponents(String prefixIdentifier, FileObject fo,
            int caretOffset, CompletionResultSet resultSet) {
//        BladeIndex bladeIndex;
//        Project project = ProjectUtils.getMainOwner(fo);
        int insertOffset = caretOffset - prefixIdentifier.length();
        ComponentsCompletionService componentComplervice = new ComponentsCompletionService();
        Collection<PhpIndexResult> indexedReferences = componentComplervice.queryComponents(prefixIdentifier, fo);

        for (PhpIndexResult indexReference : indexedReferences) {
            addComponentIdCompletionItem(indexReference,
                    insertOffset, resultSet);
            //debuging class properties
            //to move from here
            PhpIndexUtils.queryClassProperties(fo, "type", indexReference.name);
        }

    }

    private void completeAttributes(String prefix, int caretOffset, CompletionResultSet resultSet) {
        int insertOffset = caretOffset;
        AttributeCompletionService attributeCompletionService = new AttributeCompletionService();
        Collection<String> attributes = attributeCompletionService.queryComponents(prefix);

        for (String attribute : attributes) {
            addSimplAttributeItem(prefix, attribute,insertOffset, resultSet);
        }
    }

    private void addHtmlTagCompletionItem(String prefix, String tagName, String plugin,
            int caretOffset, CompletionResultSet resultSet) {
        int insertOffset = caretOffset - prefix.length();
        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(tagName)
                .iconResource(getReferenceIcon(CompletionType.HTML_COMPONENT_TAG))
                .startOffset(insertOffset)
                .leftHtmlText("&lt;" + tagName + "&gt;")
                .rightHtmlText(plugin)
                .sortPriority(1)
                .build();
        resultSet.addItem(item);
    }

    private void addSimplAttributeItem(String prefix, String attributeName, int caretOffset, CompletionResultSet resultSet) {
        int insertOffset = caretOffset - prefix.length();
        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(attributeName)
                //.iconResource(getReferenceIcon(CompletionType.HTML_COMPONENT_TAG))
                .startOffset(insertOffset)
                .leftHtmlText(attributeName)
                //.rightHtmlText(plugin)
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
                .rightHtmlText(indexReference.qualifiedName)
                .sortPriority(1)
                .build();
        resultSet.addItem(item);
    }

    private static String getReferenceIcon() {
        return ResourceUtilities.ICON_BASE + "icons/at.png"; //NOI18N
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

    private static String getReferenceIcon(FileObject file) {
        if (file.isFolder()) {
            return "org/openide/loaders/defaultFolder.gif"; //NOI18N
        }
        return ResourceUtilities.ICON_BASE + "icons/file.png"; //NOI18N
    }

}
