package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class BladeExtendsStatement extends DirectiveExpressionBlock implements DirectiveWithPath { //it is a block because we are thinking to use as a root statement
    private Block body;

    public BladeExtendsStatement(int start, int end, DirectiveName directive,
            ArgumentExpression label,
            Block body, DirectiveEndTag endtag) {
        super(start, end, directive, label, body, endtag);

        if (label == null) {
            throw new IllegalArgumentException();
        }
    }

    public Block getBody() {
        return body;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "@extends " + getLabel().toString(); //NOI18N
    }

}
