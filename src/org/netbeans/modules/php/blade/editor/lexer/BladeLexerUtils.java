/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.lexer;

import java.util.List;
import javax.swing.text.Document;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;

/**
 *
 * @author bogdan
 */
public class BladeLexerUtils {

    public static TokenSequence<? extends PHPTokenId> getPhpTokenSequence(TokenHierarchy<Document> th, final int offset) {
        return getTokenSequence(th, offset, PHPTokenId.language());
    }

    public static TokenSequence<? extends PHPTokenId> getPhpTokenSequence(final Document document, final int offset) {
        TokenHierarchy<Document> th = TokenHierarchy.get(document);
        return getTokenSequence(th, offset, PHPTokenId.language());
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> TokenSequence<? extends T> getTokenSequence(final TokenHierarchy<?> th,
            final int offset, final Language language) {
        TokenSequence<? extends T> ts = th.tokenSequence(language);
        if (ts == null) {
            List<TokenSequence<?>> list = th.embeddedTokenSequences(offset, true);
            for (TokenSequence t : list) {
                if (t.language() == language) {
                    ts = t;
                    break;
                }
            }
            if (ts == null) {
                list = th.embeddedTokenSequences(offset, false);
                for (TokenSequence t : list) {
                    if (t.language() == language) {
                        ts = t;
                        break;
                    }
                }
            }
        }
        return ts;
    }
}
