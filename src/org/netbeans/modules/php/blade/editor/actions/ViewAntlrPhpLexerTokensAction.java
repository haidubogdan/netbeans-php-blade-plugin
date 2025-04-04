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
import org.netbeans.modules.php.blade.syntax.antlr4.html_components.BladeHtmlAntlrLexer;
import org.netbeans.modules.php.blade.syntax.antlr4.php.BladePhpAntlrLexer;
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
@ActionID(id = "org.netbeans.modules.php.blade.editor.actions.ViewAntlrPhpLexerTokensAction", category = "DebugAntlrActions")
@ActionRegistration(displayName = "AntlrPhpLexer Tokens")
public class ViewAntlrPhpLexerTokensAction extends AbstractAction implements ActionListener {

    Node node;
    private transient JEditorPane viewer;

    public ViewAntlrPhpLexerTokensAction(Node node) {
        this.node = node;
        putValue(NAME, "AntlrPhpLexer Tokens");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileObject fo = node.getLookup().lookup(FileObject.class);
        if (fo == null) {
            return;
        }
        AntlrLexerPreviewComponent comp = new AntlrLexerPreviewComponent(fo);
        comp.open();
        comp.setVisible(true);
    }

    public final class AntlrLexerPreviewComponent extends TopComponent {

        private final FileObject fileObject;

        public AntlrLexerPreviewComponent(FileObject fo) {
            this.fileObject = fo;
            initComponents();
        }

        @Override
        public int getPersistenceType() {
            return TopComponent.PERSISTENCE_NEVER;
        }

        protected void initComponents() {
            setName("Antlr token preview - " + fileObject.getName());
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
                CharStream cs = CharStreams.fromString(String.valueOf(fileObject.asText()));
                BladePhpAntlrLexer lexer = new BladePhpAntlrLexer(cs);
                Vocabulary vocabulary = lexer.getVocabulary();
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                tokens.fill();
                Document doc = viewer.getDocument();

                // Would be better to create some diff and update the changed elemets
                doc.remove(0, doc.getLength());
                StringBuilder result = new StringBuilder();

                for (Token token : tokens.getTokens()) {
                    int tokenId = token.getType();
                    String text = token.getText();
                    result.append("Token #");
                    result.append(tokenId);
                    result.append(" ");
                    result.append(vocabulary.getDisplayName(tokenId));
                    String tokenText = text;
                    if (!tokenText.isEmpty()) {
                        result.append(" ");
                        result.append("[");
                        result.append(token);
                        result.append("]");
                    }
                    result.append("\n");
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
