package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class Variable extends Expression {

    private final String variable;

    public Variable(int start, int end, String variable) {
        super(start, end);
        this.variable = variable;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return variable; //NOI18N
    }
}
