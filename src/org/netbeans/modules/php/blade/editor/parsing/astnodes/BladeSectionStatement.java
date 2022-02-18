package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 * "@section"
 *
 * @author bhaidu
 */
public class BladeSectionStatement extends DirectiveExpressionBlock implements DirectiveWithPath, StructureModelItem {
    public BladeSectionStatement(int start, int end, DirectiveName directive, ArgumentExpression expression, Block body) {
        super(start, end, directive, expression, body);

        if (expression == null) {
            throw new IllegalArgumentException();
        }
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
