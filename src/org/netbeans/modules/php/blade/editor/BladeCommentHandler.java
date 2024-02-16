package org.netbeans.modules.php.blade.editor;

import java.util.ArrayList;
import javax.swing.text.Document;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.CommentHandler;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;

/**
 *
 * @author bhaidu
 */
public class BladeCommentHandler extends CommentHandler.DefaultCommentHandler {

    private static final String COMMENT_START_DELIMITER = "{{--"; //NOI18N
    private static final String COMMENT_END_DELIMITER = "--}}"; //NOI18N

    @Override
    public String getCommentStartDelimiter() {
        return COMMENT_START_DELIMITER;
    }

    @Override
    public String getCommentEndDelimiter() {
        return COMMENT_END_DELIMITER;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public int[] getAdjustedBlocks(final Document doc, int from, int to) {
        final int[] bounds = new int[]{from, to};

        Runnable task = new Runnable() {
            @Override
            @SuppressWarnings("rawtypes")
            public void run() {
                TokenHierarchy th = TokenHierarchy.get(doc);
                TokenSequence<?> ts = th.tokenSequence();
                ts.move(from);

                //if (ts.movePrevious()) {
                ts.moveNext();
                //}

                Token<?> token = ts.token();

                if (token != null && token.id() instanceof BladeTokenId) {
                    //handle uncomment
                    switch ((BladeTokenId) token.id()) {
                        case BLADE_COMMENT_START:
                            bounds[0] = ts.offset();

                            while (ts.moveNext()) {
                                if (ts.token().id() == BladeTokenId.BLADE_COMMENT_END) {
                                    bounds[1] = ts.offset() + ts.token().length();
                                    break;
                                }
                            }
                            break;
                        case BLADE_DIRECTIVE:
                            bounds[0] = ts.offset();
                            //not working
                            ts.moveNext();
                            if (ts.token().id() == BladeTokenId.PHP_BLADE_EXPRESSION) {
                                bounds[1] = ts.offset() + ts.token().length();
                            }
                            break;
                    }

                }

            }
        };

        if (doc instanceof BaseDocument) {
            ((BaseDocument) doc).runAtomic(task);
        } else {
            task.run();
        }

        return new int[]{bounds[0], bounds[1]};
    }
}
