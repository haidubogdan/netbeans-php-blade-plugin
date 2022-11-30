package org.netbeans.modules.php.blade.editor.formatter;

import javax.swing.text.BadLocationException;
import org.netbeans.editor.Utilities;
import org.netbeans.api.editor.document.LineDocumentUtils;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.openide.util.Exceptions;

/**
 * 
 * @author bhaidu
 */
public class IndentationCounter {

    private final BaseDocument doc;

    public IndentationCounter(BaseDocument doc) {
        this.doc = doc;
    }

    public Indentation count(int caretOffset) {
        Indentation result = Indentation.NONE;
        doc.readLock();
        try {
            result = countUnderReadLock(caretOffset);
        } finally {
            doc.readUnlock();
        }
        return result;
    }

    private Indentation countUnderReadLock(int caretOffset) {
        int newIndent = 0;
        try {
            boolean insideString = false;
            TokenSequence<? extends BladeTokenId> ts = BladeLexerUtils.getBladeMarkupTokenSequence(doc, caretOffset);
            int caretLineStart = LineDocumentUtils.getLineStart(doc, LineDocumentUtils.getLineStart(doc, caretOffset) - 1);

            if (ts == null) {
                return Indentation.NONE;
            }

            ts.move(caretOffset);
            ts.moveNext();

            boolean indentStartComment = false;

            boolean movePrevious = false;

            if (ts.token() == null) {
                return Indentation.NONE;
            }

            BladeTokenId id = ts.token().id();

            if (id == BladeTokenId.WHITESPACE && ts.moveNext()) {
               movePrevious = true;
            }
            
            boolean hasArguments = false;
            
            while (ts.movePrevious()) {
                id = ts.token().id();
                if (hasArguments == true & (id == BladeTokenId.T_BLADE_DIRECTIVE || id == BladeTokenId.T_BLADE_SECTION)){
                    newIndent = Utilities.getRowIndent(doc, caretLineStart);
                    break;
                }
            }


        } catch (BadLocationException ex) {
            Exceptions.printStackTrace(ex);
        }
        return new IndentationImpl(newIndent);
    }

    public interface Indentation {

        Indentation NONE = new Indentation() {

            @Override
            public int getIndentation() {
                return 0;
            }

            @Override
            public void modify(Context context) {
            }

        };

        int getIndentation();

        void modify(Context context);

    }

    private static final class IndentationImpl implements Indentation {

        private final int indentation;

        public IndentationImpl(int indentation) {
            this.indentation = indentation;
        }

        @Override
        public int getIndentation() {
            return indentation;
        }

        @Override
        public void modify(final Context context) {
            assert context != null;
            context.document().render(new Runnable() {

                @Override
                public void run() {
                    modifyUnderWriteLock(context);
                }
            });
        }

        private void modifyUnderWriteLock(Context context) {
            if (indentation < 0){
                return;
            }
            try {
                context.modifyIndent(LineDocumentUtils.getLineStart((BaseDocument) context.document(), context.caretOffset()), indentation);
            } catch (BadLocationException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

    }
}
