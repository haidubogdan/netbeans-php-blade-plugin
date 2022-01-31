package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class InLineHtml extends Statement {

    private final String content;

    public InLineHtml(int start, int end, String content) {
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
