package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class ASTErrorExpression extends Expression {

    public ASTErrorExpression(int start, int end) {
        super(start, end);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
