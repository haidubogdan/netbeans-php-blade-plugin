package org.netbeans.modules.php.blade.editor.completion;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
import org.netbeans.lib.editor.codetemplates.api.CodeTemplateManager;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.ResourceUtilities;
import org.netbeans.modules.php.blade.editor.completion.BladeCompletionItem.BladeTag;
import org.netbeans.modules.php.blade.editor.components.AttributeCompletionService;
import org.netbeans.modules.php.blade.editor.components.ComponentsCompletionService;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex.IndexedReferenceId;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexUtils;
import org.netbeans.modules.php.blade.editor.path.PathUtils;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.netbeans.modules.php.blade.syntax.StringUtils;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
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
    @MimeRegistration(mimeType = "text/html", service = CompletionProvider.class),
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
                    default:
                        break;
                }
            } finally {
//                long time = System.currentTimeMillis() - startTime;
                resultSet.finish();
            }
        }
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
            int caretOffset, String type, CompletionResultSet resultSet) {
        final String finalCloseTag = closeTag;
        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(closeTag)
                .iconResource(getReferenceIcon())
                .startOffset(caretOffset)
                .leftHtmlText(closeTag)
                .rightHtmlText(type)
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
        
        BladeCompletionItem item = BladeCompletionItem.createViewPath(
                bladePath, caretOffset, originFile.isFolder(), filePath);
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

    //??
    private void addHtmlTagCompletionItem(String prefix, String tagName, String plugin,
            int caretOffset, CompletionResultSet resultSet) {
        
        int insertOffset = caretOffset - prefix.length();
        BladeTag item = new BladeTag(tagName, insertOffset);
        resultSet.addItem(item);
//        
//        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(tagName)
//                .iconResource(getReferenceIcon(CompletionType.HTML_COMPONENT_TAG))
//                .startOffset(insertOffset)
//                .leftHtmlText("&lt;" + tagName + "&gt;")
//                .rightHtmlText(plugin)
//                .sortPriority(1)
//                .build();
//        resultSet.addItem(item);
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
