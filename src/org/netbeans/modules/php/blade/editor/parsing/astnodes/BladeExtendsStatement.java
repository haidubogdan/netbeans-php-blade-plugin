package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class BladeExtendsStatement extends InlineDirectiveStatement implements DirectiveWithPath { //it is a block because we are thinking to use as a root statement

    public BladeExtendsStatement(int start, int end, DirectiveName directive,
            ArgumentExpression label) {
        super(start, end, directive, label);

        if (label == null) {
            throw new IllegalArgumentException();
        }
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
