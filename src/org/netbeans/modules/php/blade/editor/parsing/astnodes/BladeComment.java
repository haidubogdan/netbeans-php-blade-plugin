package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class BladeComment extends Statement {

    private final String content;

    public BladeComment(int start, int end, String content) {
        super(start, end);
        this.content = content;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getContent() {
        return content;
    }
}
