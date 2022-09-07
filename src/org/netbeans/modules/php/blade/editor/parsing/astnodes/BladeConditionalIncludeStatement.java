package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @includeFirst
 * @includeWhen
 * @includeIf
 * @includeUnless
 * 
 * @author bhaidu
 */
public class BladeConditionalIncludeStatement extends InlineDirectiveStatement {

    public BladeConditionalIncludeStatement(int start, int end, DirectiveName directive, ArgumentExpression label) {
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
