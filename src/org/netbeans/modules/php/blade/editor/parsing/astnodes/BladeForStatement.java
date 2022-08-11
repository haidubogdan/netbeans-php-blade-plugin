package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class BladeForStatement extends DirectiveExpressionBlock implements StructureModelItem {

    public BladeForStatement(int start, int end, DirectiveName directive,
            ArgumentExpression expression,
            Block body, DirectiveEndTag endtag) {
        super(start, end, directive, expression, body, endtag);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "@for"; //NOI18N
    }

}
