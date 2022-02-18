package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 * "@section"
 *
 * @author bhaidu
 */
public class BladeInlineSectionStatement extends InlineDirectiveStatement implements DirectiveWithPath, StructureModelItem {
    public BladeInlineSectionStatement(int start, int end, DirectiveName directive, ArgumentExpression label) {
        super(start, end, directive, label);

        if (label == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getDirectiveName().getName() + " " + getLabel().toString() + " - inline"; //NOI18N
    }

}
