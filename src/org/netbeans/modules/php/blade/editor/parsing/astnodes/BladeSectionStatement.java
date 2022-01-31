package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 * "@section"
 *
 * @author bhaidu
 */
public class BladeSectionStatement extends DirectiveBladeBlock implements DirectiveWithPath, StructureModelItem {

    public enum Type {
        INLINE,
        BLOCK
    }

    private Expression label;
    private ParameterExpression parameterExpression;
    private BladeSectionStatement.Type sectionType;

    public BladeSectionStatement(int start, int end, DirectiveName directive, Expression label, Block body, BladeSectionStatement.Type type) {
        this(start, end, directive, label, null, body, type);
    }

    public BladeSectionStatement(int start, int end, DirectiveName directive, Expression label, ParameterExpression parameter, Block body, BladeSectionStatement.Type type) {
        super(start, end, directive, body);

        if (label == null) {
            throw new IllegalArgumentException();
        }
        this.label = label;
        this.sectionType = type;
        this.parameterExpression = parameter;
    }

    /**
     *
     * @return the label label
     */
    @Override
    public Expression getLabel() {
        return label;
    }

    public BladeSectionStatement.Type getSectionType() {
        return sectionType;
    }

    public ParameterExpression getParameterExpression() {
        return parameterExpression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getDirectiveName().getName() + " " + label.toString() + " (" + getSectionType().toString() + ")"; //NOI18N
    }

}
