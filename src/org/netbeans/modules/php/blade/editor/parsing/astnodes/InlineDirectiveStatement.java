package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class InlineDirectiveStatement extends DirectiveStatement implements StructureModelItem, DirectiveWithPath {

    protected ArgumentExpression expression;

    public InlineDirectiveStatement(int start, int end, DirectiveName directive, ArgumentExpression expression) {
        super(start, end, directive);

        if (expression == null) {
            throw new IllegalArgumentException();
        }
        this.expression = expression;
    }

    public ArgumentExpression getArgumentExpression() {
        return this.expression;
    }
    
    /**
     *
     * @return the label label
     */
    @Override
    public Expression getLabel() {
        assert expression != null;
        return expression.getMainArgument();
    }

    /**
     *
     * @return the label label
     */
    public Expression getArgument() {
        assert expression != null;
        return expression.getParameter();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "inlineStatement " + getLabel().toString(); //NOI18N
    }

}
