package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class BladeIncludeStatement extends InlineDirectiveStatement {

    public BladeIncludeStatement(int start, int end, DirectiveName directive, ArgumentExpression label) {
        super(start, end, directive, label);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getDirectiveName().getName() + " " + getLabel().toString(); //NOI18N
    }

}
