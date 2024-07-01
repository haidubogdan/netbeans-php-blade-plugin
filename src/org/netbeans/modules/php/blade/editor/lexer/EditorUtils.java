/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.lexer;

import javax.swing.text.Document;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;

/**
 *
 * @author bogdan
 */
public class EditorUtils {

    public static TokenSequence<PHPTokenId> getTokenSequence(Document doc, int offset) {
        BaseDocument baseDoc = (BaseDocument) doc;
        TokenSequence<PHPTokenId> tokenSequence = null;
        baseDoc.readLock();
        try {
            TokenHierarchy<Document> hierarchy = TokenHierarchy.get(baseDoc);
            tokenSequence = hierarchy.tokenSequence(PHPTokenId.language());
        } finally {
            baseDoc.readUnlock();
        }
        if (tokenSequence != null) {
            tokenSequence.move(offset);
            tokenSequence.moveNext();
        }
        return tokenSequence;

    }
}
