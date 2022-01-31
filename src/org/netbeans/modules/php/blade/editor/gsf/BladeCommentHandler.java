package org.netbeans.modules.php.blade.editor.gsf;

import org.netbeans.modules.csl.spi.CommentHandler;

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

}
