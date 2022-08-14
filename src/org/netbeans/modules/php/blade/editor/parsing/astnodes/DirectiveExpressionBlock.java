package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class DirectiveExpressionBlock extends DirectiveStatement {

    protected ArgumentExpression expression;
    protected DirectiveEndTag endtag;
    private final Block body;

    public DirectiveExpressionBlock(int start, int end, DirectiveName directive,
            ArgumentExpression expression,
            Block body, DirectiveEndTag endTag) {
        super(start, end, directive);
        this.body = body;
        if (expression == null) {
            throw new IllegalArgumentException();
        }
        this.expression = expression;
        this.endtag = endTag;
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
    
    public DirectiveEndTag getDirectiveEndTag() {
        return this.endtag;
    }

    public Expression getLabel() {
        return this.expression.getMainArgument();
    }

}
