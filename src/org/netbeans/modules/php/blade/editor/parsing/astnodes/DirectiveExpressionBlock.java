package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class DirectiveExpressionBlock extends DirectiveStatement {

    protected ArgumentExpression expression;
    private final Block body;

    public DirectiveExpressionBlock(int start, int end, DirectiveName directive, ArgumentExpression expression, Block body) {
        super(start, end, directive);
        this.body = body;
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        this.expression = expression;
    }

    public Block getBody() {
        return body;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public ArgumentExpression getArgumentExpression() {
        return this.expression;
    }

    public Expression getLabel() {
        return this.expression.getMainArgument();
    }

}
