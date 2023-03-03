/*
 */
package org.netbeans.modules.php.blade.editor.lexer;

import javax.swing.text.Document;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;

/**
 *
 * @author bhaidu
 */
public class TokenSequenceSnapshot {

    private final TokenHierarchy<Document> th;
    private TokenSequence<BladeTokenId> ts = null;

    private TokenSequenceSnapshot(Document doc) {
        this.th = TokenHierarchy.get(doc);
        if (th != null) {
            this.ts = th.tokenSequence(BladeTokenId.language());
        }
    }

    public static TokenSequenceSnapshot loadDocument(Document doc) {
        return new TokenSequenceSnapshot(doc);
    }

    public TokenSequenceSnapshot move(int carretOffset) {
        if (ts != null) {
            ts.move(carretOffset);
        }
        return this;
    }

    public Token<BladeTokenId> current() {
        if (ts != null) {
            if (!ts.moveNext() && !ts.movePrevious()) {
                return null;
            }
            return ts.token();
        }
        return null;
    }

    public Token<BladeTokenId> next() {
        if (ts != null) {
            if (ts.moveNext()) {
                return ts.token();
            }
        }
        return null;
    }

    public Token<BladeTokenId> previous() {
        if (ts != null) {
            if (ts.movePrevious()) {
                return ts.token();
            }
        }
        return null;
    }
}
