package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @if (condexpr)
 *   statement
 *   ...
 * @endif
 * @author bhaidu
 */
public class BladeElseIfStatement extends InlineDirectiveStatement implements StructureModelItem {
    public BladeElseIfStatement(int start, int end, DirectiveName directive, ArgumentExpression expression) {
        super(start, end, directive, expression);

        if (expression == null) {
            throw new IllegalArgumentException();
        }
        this.expression = expression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "@elseif"; //NOI18N
    }

}
