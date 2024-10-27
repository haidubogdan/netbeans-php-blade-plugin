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
package org.netbeans.modules.php.blade.editor.actions;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import javax.swing.AbstractAction;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrColoringLexer;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrColoringLexer.*;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;

/**
 *
 * @author bhaidu
 */
@ActionID(id = "org.netbeans.modules.php.blade.editor.actions.ViewLexerColoringTokens", category = "DebugAntlrActions")
@ActionRegistration(displayName = "LexerColoring Tokens")
public class ViewLexerColoringTokens extends AbstractAction implements ActionListener {

    Node node;
    private transient JEditorPane viewer;

    public ViewLexerColoringTokens(Node node) {
        this.node = node;
        putValue(NAME, "LexerColoring Tokens");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileObject fo = node.getLookup().lookup(FileObject.class);
        if (fo == null) {
            return;
        }
        LexerColoringPreviewComponent comp = new LexerColoringPreviewComponent(fo);
        comp.open();
        comp.setVisible(true);
    }

    public final class LexerColoringPreviewComponent extends TopComponent {

        private final FileObject fileObject;

        public LexerColoringPreviewComponent(FileObject fo) {
            this.fileObject = fo;
            initComponents();
        }

        @Override
        public int getPersistenceType() {
            return TopComponent.PERSISTENCE_NEVER;
        }

        protected void initComponents() {
            setName("Lexer Coloring token preview - " + fileObject.getName());
            setLayout(new BorderLayout());
            viewer = new JEditorPane();
            viewer.setContentType("text/plain");
            viewer.setEditable(false);
            //viewer.addHyperlinkListener(this::linkHandler);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JScrollPane(viewer), BorderLayout.CENTER);
            add(panel);
            Rectangle vis = viewer.getVisibleRect();
            try {
                Document doc = viewer.getDocument();
                BladeLanguage bladeLang = new BladeLanguage();
                Language<BladeTokenId> tokenLanguage =  bladeLang.getLexerLanguage();
                TokenHierarchy<?> hierarchy = TokenHierarchy.create(String.valueOf(fileObject.asText()), tokenLanguage);
                TokenSequence<BladeTokenId> ts = hierarchy.tokenSequence(tokenLanguage);

                // Would be better to create some diff and update the changed elemets
                doc.remove(0, doc.getLength());
                StringBuilder result = new StringBuilder();
                if (ts != null){
                    while (ts.moveNext()) {
                        BladeTokenId tokenId = ts.token().id();
                        CharSequence text = ts.token().text();
                        result.append("Token #");
                        result.append(ts.index());
                        result.append(" ");
                        result.append(tokenId.name());
                        String token = text.toString();
                        if (!token.isEmpty()) {
                            result.append(" ");
                            result.append("[");
                            result.append(token);
                            result.append("]");
                        }
                        result.append("\n");
                    }
                }

                EditorKit kit = viewer.getEditorKit();
                Reader reader = new StringReader(result.toString());
                //doc.
                kit.read(reader, doc, 0);
                viewer.scrollRectToVisible(vis);
            } catch (IOException | BadLocationException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }
}
