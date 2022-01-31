package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class ASTError extends Statement {

    public ASTError(int start, int end) {
        super(start, end);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
