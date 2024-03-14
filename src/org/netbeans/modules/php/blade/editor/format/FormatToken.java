package org.netbeans.modules.php.blade.editor.format;

/**
 *
 * @author bhaidu
 */
public class FormatToken {

    public int tokenStart;
    public int indent;
    public int htmlIndent;
    //for directive
    public String directive;

    public FormatToken(int tokenStart, int indent, String directive) {
        this.tokenStart = tokenStart;
        this.indent = indent;
        this.directive = directive;
    }
    
    public FormatToken(int tokenStart, int indent, int htmlIndent, String directive) {
        this.tokenStart = tokenStart;
        this.indent = indent;
        this.directive = directive;
        this.htmlIndent = htmlIndent;
    }

    @Override
    public String toString() {
        return this.directive + ", " + this.indent * 4 + ", " + this.tokenStart;
    }
}
