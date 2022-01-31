package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class BladeEchoStatement extends Statement {

    String token;
    Expression expression;

    public BladeEchoStatement(int start, int end, String token, Expression expr) {
        super(start, end);
        this.token = token;
        this.expression = expr;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
