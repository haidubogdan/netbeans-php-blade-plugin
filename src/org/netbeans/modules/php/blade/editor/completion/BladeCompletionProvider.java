package org.netbeans.modules.php.blade.editor.completion;

import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenSequence;
import static org.netbeans.modules.php.blade.editor.BladeLanguage.BLADE_MIME_TYPE;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;

/**
 *
 * @author bhaidu
 */
@MimeRegistration(mimeType = BLADE_MIME_TYPE, service = CompletionProvider.class)
public class BladeCompletionProvider implements CompletionProvider {

    @Override
    public CompletionTask createTask(int queryType, JTextComponent jtc) {
        return new AsyncCompletionTask(new AsyncCompletionQuery() {

            @Override
            protected void query(CompletionResultSet completionResultSet, Document document, int caretOffset) {
                //test
                completionResultSet.finish();
            }

        }, jtc);
    }

    @Override
    public int getAutoQueryTypes(JTextComponent component, String typedText) {
        //should we lock ??
        ((AbstractDocument) component.getDocument()).readLock();
        try {
            TokenSequence<BladeTokenId> ts = BladeLexerUtils.getBladeTokenSequence(component.getDocument());
            ts.move(component.getCaretPosition());
            if (!ts.moveNext()) {
                return 0;
            }
            Token<? extends BladeTokenId> currentToken = ts.token();
            if (currentToken == null) {
                return 0;
            }
            int toffs = ts.offset();
            String tText = currentToken.text().toString();
            BladeTokenId id = currentToken.id();
            if (id.equals(BladeTokenId.T_BLADE_PHP_EXPRESSION)){
                if (!ts.movePrevious()){
                    return 0;
                }
                Token<? extends BladeTokenId> prevToken = ts.token();
                if (!prevToken.id().equals(BladeTokenId.T_BLADE_LPAREN)){
                    return 0;
                }
                if (!ts.movePrevious()){
                    return 0;
                }
                prevToken = ts.token();
                if (prevToken.id().equals(BladeTokenId.T_BLADE_INCLUDE)){
                    return COMPLETION_QUERY_TYPE;
                }
                return 0;
            }
        } finally {
            ((AbstractDocument) component.getDocument()).readUnlock();
        }

        return 0;
    }
}
