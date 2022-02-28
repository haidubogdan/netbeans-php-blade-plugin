package org.netbeans.modules.php.blade.editor.formatter;

import org.netbeans.api.annotations.common.CheckForNull;
import org.netbeans.api.annotations.common.NonNull;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;

/**
 *
 * @author bhaidu
 */
public class FormatToken {

    public enum Kind {

        TEXT,
        HTML_TEXT,
        UNBREAKABLE_SEQUENCE_START,
        UNBREAKABLE_SEQUENCE_END,
        OPEN_TAG,
        CLOSE_TAG,
        INIT_TAG, // special tag, that will contain some initional information
        HTML,
        INDENT,
        WHITESPACE,
        WHITESPACE_INDENT,
        WHITESPACE_AFTER_DIRECTIVE_ARGUMENT,
        WHITESPACE_DIRECTIVE_AFTER_HTML,
        WHITESPACE_DECREMENT_INDENT,
        WHITESPACE_BEFORE_DIRECTIVE_ENDTAG,
        WHITESPACE_BEFORE_DIRECTIVE_ENDTAG_INLINE,
        WHITESPACE_BEFORE_DIRECTIVE_TAG,
        WHITESPACE_BEFORE_DIRECTIVE_TAG_INSIDE_HTML_TAG,
        WHITESPACE_BEFORE_DIRECTIVE_ELSE,
        WHITESPACE_AFTER_DIRECTIVE_ENDTAG,
        WHITESPACE_BEFORE_ECHO_VAR,
        WHITESPACE_AFTER_ECHO_VAR,
        WHITESPACE_BEFORE_DIRECTIVE_PAREN,
        WHITESPACE_AFTER_DIRECTIVE_PAREN,
        WHITESPACE_AFTER_HTML,
        WHITESPACE_BEFORE_HTML,
        WHITESPACE_HTML,
        WHITESPACE_BEFORE_INCLUDE_TAG,
        WHITESPACE_BEFORE_DIRECTIVE_START_TAG,
        WHITESPACE_BEFORE_DIRECTIVE_START_TAG_INLINE,
        WHITESPACE_BEFORE_ECHO,
        WHITESPACE_AFTER_ECHO,
        WHITESPACE_BEFORE_BLADE_PHP,
        WHITESPACE_BEFORE_BLADE_PHP_BODY,
        WHITESPACE_BEFORE_BLADE_COMMENT,
        WHITESPACE_AFTER_BLADE_COMMENT,
        LINE_COMMENT,
        COMMENT,
        COMMENT_START,
        COMMENT_END;
    }

    private int offset;
    private Kind id;
    private boolean whitespace;
    private boolean breakable;
    private String oldText;

    public FormatToken(Kind id, int offset) {
        this(id, offset, null);
    }

    public FormatToken(Kind id, int offset, String oldText) {
        this.offset = offset;
        this.id = id;
        this.oldText = oldText;
        this.whitespace = isWhitespace(id);
        this.breakable = true;
    }

    public Kind getId() {
        return id;
    }

    public int getOffset() {
        return offset;
    }

    public boolean isBreakable() {
        return breakable;
    }

    public String getOldText() {
        return oldText;
    }

    public boolean isWhitespace() {
        return whitespace;
    }

    private boolean isWhitespace(Kind kind) {
        return kind != Kind.TEXT
                && kind != Kind.UNBREAKABLE_SEQUENCE_START
                && kind != Kind.UNBREAKABLE_SEQUENCE_END
                && kind != Kind.INDENT && kind != Kind.LINE_COMMENT
                && kind != Kind.COMMENT
                && kind != Kind.COMMENT_START
                && kind != Kind.COMMENT_END
                && kind != Kind.INIT_TAG
                && kind != Kind.HTML;
    }

    public static class InitToken extends FormatToken {

        boolean hasHTML;

        public InitToken() {
            super(Kind.INIT_TAG, 0);
            hasHTML = false;
        }

        public boolean hasHTML() {
            return hasHTML;
        }

        public void setHasHTML(boolean hasHTML) {
            this.hasHTML = hasHTML;
        }
    }

    public static class IndentToken extends FormatToken {

        private int delta;

        public IndentToken(int offset, int delta) {
            super(Kind.INDENT, offset, null);
            this.delta = delta;
        }

        public int getDelta() {
            return delta;
        }
    }
    
    public static class WsDirectiveToken extends FormatToken {

        private String directive;

        public WsDirectiveToken(Kind ws, int offset, String directive) {
            super(ws, offset, null);
            this.directive = directive;
        }

        public String getDirective() {
            return directive;
        }
    }
    
    public static class PhpBladeToken extends FormatToken {

        private String text;

        public PhpBladeToken(Kind ws, int offset, String text) {
            super(ws, offset, null);
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
    
    public static class WsPhpToken extends FormatToken {

        private String directive;

        public WsPhpToken(Kind ws, int offset, String directive) {
            super(ws, offset, null);
            this.directive = directive;
        }

        public String getDirective() {
            return directive;
        }
    }
    
    public static class HtmlIndentToken extends FormatToken {

        private int delta;

        public HtmlIndentToken(int offset, int delta) {
            super(Kind.INDENT, offset, null);
            this.delta = delta;
        }

        public int getDelta() {
            return delta;
        }
    }

}
