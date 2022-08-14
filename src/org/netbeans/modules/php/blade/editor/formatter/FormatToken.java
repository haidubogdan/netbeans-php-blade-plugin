package org.netbeans.modules.php.blade.editor.formatter;

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
        COMMENT_END, 
        WHITESPACE_BEFORE_INLINE_DIRECTIVE_START_TAG,
        WHITESPACE_BEFORE_INLINE_DIRECTIVE_TAG,
        WHITESPACE_BEFORE_INLINE_DIRECTIVE_ENDTAG;
    }

    private int offset;
    private Kind id;
    private boolean whitespace;
    private boolean breakable;
    private String oldText;
    private int line;

    public FormatToken(Kind id, int offset, int line) {
        this(id, offset, null, line);
    }

    public FormatToken(Kind id, int offset, String oldText, int line) {
        this.offset = offset;
        this.id = id;
        this.oldText = oldText;
        this.whitespace = isWhitespace(id);
        this.breakable = true;
        this.line = line;
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

    public int getLine() {
        return line;
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
            super(Kind.INIT_TAG, 0, 0);
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
        private int tokenSpaceCount;

        public IndentToken(int offset, int delta, int line) {
            super(Kind.INDENT, offset, null, line);
            this.delta = delta;
            this.tokenSpaceCount = 0;
        }
        
        public IndentToken(int offset, int delta, int tokenSpaceCount, int line) {
            super(Kind.INDENT, offset, null, line);
            this.delta = delta;
            this.tokenSpaceCount = tokenSpaceCount;
        }

        public int getDelta() {
            return delta;
        }
        
        public int tokenSpaceCount() {
            return tokenSpaceCount;
        }
    }
    
    public static class WsDirectiveToken extends FormatToken {

        private String directive;
        private int wsBefore;

        public WsDirectiveToken(Kind ws, int offset, int wsBefore, String directive, int line) {
            super(ws, offset, null, line);
            this.directive = directive;
            this.wsBefore = wsBefore;
        }

        public String getDirective() {
            return directive;
        }

        public int getWsBefore() {
            return wsBefore;
        }
    }
    
    public static class PhpBladeToken extends FormatToken {

        private String text;

        public PhpBladeToken(Kind ws, int offset, String text, int line) {
            super(ws, offset, null, line);
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
    
    public static class WsPhpToken extends FormatToken {

        private String directive;

        public WsPhpToken(Kind ws, int offset, String directive, int line) {
            super(ws, offset, null, line);
            this.directive = directive;
        }

        public String getDirective() {
            return directive;
        }
    }
    
    public static class HtmlIndentToken extends FormatToken {

        private int delta;

        public HtmlIndentToken(int offset, int delta, int line) {
            super(Kind.INDENT, offset, null, line);
            this.delta = delta;
        }

        public int getDelta() {
            return delta;
        }
    }

    public static class DirectiveIndentToken extends FormatToken {

        private int delta;

        public DirectiveIndentToken(int offset, int delta, int line) {
            super(Kind.INDENT, offset, null, line);
            this.delta = delta;
        }

        public int getDelta() {
            return delta;
        }
    }
}
