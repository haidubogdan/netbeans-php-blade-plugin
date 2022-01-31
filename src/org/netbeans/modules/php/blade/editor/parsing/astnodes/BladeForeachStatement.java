package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class BladeForeachStatement extends DirectiveBladeBlock implements StructureModelItem {

    private Expression expression;

    public BladeForeachStatement(int start, int end, DirectiveName directive, Expression expression, Block body) {
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
        return "@foreach"; //NOI18N
    }

}
