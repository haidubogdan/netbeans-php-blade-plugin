package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @if (condexpr)
 *   statement
 *   ...
 * @endif
 * @author bhaidu
 */
public class BladeSwitchStatement extends DirectiveExpressionBlock implements StructureModelItem {
    public BladeSwitchStatement(int start, int end, DirectiveName directive,
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
        return "@switch"; //NOI18N
    }

}
