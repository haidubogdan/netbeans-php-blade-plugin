package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class PhpExpression extends Expression {

    private String stringValue;

    public PhpExpression(int start, int end, String value) {
        super(start, end);

        if (value == null) {
            throw new IllegalArgumentException();
        }
        this.stringValue = value;
    }

    /**
     * the scalar value
     * @return scalar value
     */
    public String getStringValue() {
        return this.stringValue;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getStringValue(); //NOI18N
    }

}
