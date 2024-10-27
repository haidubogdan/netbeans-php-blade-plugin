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

import java.io.IOException;
import java.util.Arrays;
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
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.EditorStringUtils;
import org.netbeans.modules.php.blade.editor.ResourceUtilities;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex.IndexedReferenceId;
import org.netbeans.modules.php.blade.editor.path.BladePathUtils;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
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
//@MimeRegistrations(value = {
//    @MimeRegistration(mimeType = "text/x-php5", service = CompletionProvider.class, position = 102), //    @MimeRegistration(mimeType = "text/x-blade", service = CompletionProvider.class, position = 105),
//}
//)
public class BladePhpCompletionProvider implements CompletionProvider {

    private static final Logger LOGGER = Logger.getLogger(BladePhpCompletionProvider.class.getName());
    public static final String JS_ASSET_FOLDER = "resources/js";
    public static final String CSS_ASSET_FOLDER = "resources/css";

    public enum CompletionType {
        BLADE_PATH,
        YIELD_ID,
        DIRECTIVE,
        HTML_COMPONENT_TAG,
        FOLDER,
        CSS_FILE,
        JS_FILE
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
            long startTime = System.currentTimeMillis();
            doQuery(resultSet, doc, caretOffset);
            long time = System.currentTimeMillis() - startTime;
            if (time > 2000) {
                LOGGER.log(Level.INFO, "Slow completion time detected. {0}ms", time);
            }
            resultSet.finish();
        }
    }

    private void doQuery(CompletionResultSet resultSet, Document doc, int caretOffset) {
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
            
            default:
                break;
        }
    }

    private void completeYieldIdFromIndex(String prefixIdentifier, FileObject fo,
            int caretOffset, CompletionResultSet resultSet) {
        BladeIndex bladeIndex;
        Project project = ProjectUtils.getMainOwner(fo);
        int insertOffset = caretOffset - prefixIdentifier.length();
        try {
            bladeIndex = BladeIndex.get(project);
            List<IndexedReferenceId> indexedReferences = bladeIndex.queryYieldIds(prefixIdentifier);
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
            List<IndexedReferenceId> indexedReferences = bladeIndex.queryStacksIndexedReferences(prefixIdentifier);
            for (IndexedReferenceId indexReference : indexedReferences) {
                addYieldIdCompletionItem(indexReference.getIdenfiier(), indexReference.getOriginFile(),
                        insertOffset, resultSet);
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
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

    private void addAssetPathCompletionItem(String preview, String info,
            int caretOffset, CompletionResultSet resultSet, CompletionType type) {
        CompletionItem item = CompletionUtilities.newCompletionItemBuilder(preview)
                .iconResource(getReferenceIcon(type))
                .startOffset(caretOffset)
                .leftHtmlText(preview)
                .rightHtmlText(info)
                .sortPriority(1)
                .build();
        resultSet.addItem(item);
    }

    private static String getReferenceIcon(CompletionType type) {

        switch (type) {
            case FOLDER:
                return "org/openide/loaders/defaultFolder.gif";
            case CSS_FILE:
                return "org/netbeans/modules/css/visual/resources/style_sheet_16.png";
            case JS_FILE:
                return "org/netbeans/modules/javascript2/editor/resources/javascript.png";
        }
        return ResourceUtilities.ICON_BASE + "icons/layout.png"; //NOI18N

    }

}
