package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 * @each statement
 * @each('view.name', $jobs, 'job')
 * @each('view.name', $jobs, 'job', 'view.empty')
 * 
 * 
 * @author bhaidu
 */
public class BladeEachStatement extends InlineDirectiveStatement {

    public BladeEachStatement(int start, int end, DirectiveName directive, ArgumentExpression label) {
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
