package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class ArgumentExpression extends Expression {

    private Expression mainArg;
    private Expression parameter;

    public ArgumentExpression(Expression mainArg, int start, int end, Expression parameter) {
        super(start, end);
        this.mainArg = mainArg;
        this.parameter = parameter;
    }

    public ArgumentExpression(Expression mainArg, int start, int end) {
        this(mainArg, start, end, null);
    }

    public Expression getMainArgument() {
        return mainArg;
    }

    public Expression getParameter() {
        return parameter;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
