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
@ActionID(id = "org.netbeans.modules.php.blade.editor.actions.ViewAntlrColoringTokens", category = "DebugAntlrActions")
@ActionRegistration(displayName = "AntlrColoring Tokens")
public class ViewAntlrColoringTokensAction extends AbstractAction implements ActionListener {

    Node node;
    private transient JEditorPane viewer;

    public ViewAntlrColoringTokensAction(Node node) {
        this.node = node;
        putValue(NAME, "AntlrColoring Tokens");
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
            setName("Antlr coloring token preview - " + fileObject.getName());
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
                BladeAntlrColoringLexer lexer = new BladeAntlrColoringLexer(cs);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                tokens.fill();
                Document doc = viewer.getDocument();

                // Would be better to create some diff and update the changed elemets
                doc.remove(0, doc.getLength());
                StringBuilder result = new StringBuilder();

                int lastLine = 0;
                for (Token token : tokens.getTokens()) {
                    if (lastLine != token.getLine()) {
                        lastLine = token.getLine();
                        if (lastLine > 1) {
                            result.append("\n");
                        }
                        result.append("L");
                        result.append(lastLine);
                        result.append(": ").append(lastLine);
                    }
                    switch (token.getType()) {
                        case DIRECTIVE:
                        case D_AT:    
                            result.append(token.getText());
                            break;
                        case HTML_TAG:    
                        case HTML:
                            result.append(" (HTML-");
                            result.append(token.getType());
                            result.append(" ");
                            result.append(token.getText());
                            result.append(" ~)");
                            break;
                        case PHP_EXPRESSION:
                            result.append(" (PHP_EXPRESSION)");
                            result.append(token.getText());
                            break;
                        case BLADE_PHP_ECHO_EXPR:
                            result.append(" (BLADE_PHP_ECHO_EXPR)");
                            result.append(token.getText());
                            break;
                        default:
                            result.append(token.getType());
                    }
                    if (token.getType() > -1) {
                        result.append(" | ");
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
