package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @if (condexpr)
 *   statement
 *   ...
 * @endif
 * @author bhaidu
 */
public class BladeIfStatement extends DirectiveBladeBlock implements StructureModelItem {

    private Expression expression;

    public BladeIfStatement(int start, int end, DirectiveName directive, Expression expression, Block body) {
        super(start, end, directive, body);

        if (expression == null) {
            throw new IllegalArgumentException();
        }
        this.expression = expression;
    }

    /**
     * Returns the expression of this for each statement.
     *
     * @return the expression node
     */
    public Expression getExpression() {
        return this.expression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "@if"; //NOI18N
    }

}
