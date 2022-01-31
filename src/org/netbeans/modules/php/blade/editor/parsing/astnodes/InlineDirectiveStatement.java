package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class InlineDirectiveStatement extends DirectiveStatement implements StructureModelItem, DirectiveWithPath {

    Expression label;
    private Variable argument;

    public InlineDirectiveStatement(int start, int end, DirectiveName directive, Expression label) {
        super(start, end, directive);

        if (label == null) {
            throw new IllegalArgumentException();
        }
        this.label = label;
        this.argument = null;
    }

    public InlineDirectiveStatement(int start, int end, DirectiveName directive, Expression label, Variable argument) {
        super(start, end, directive);

        if (label == null) {
            throw new IllegalArgumentException();
        }
        this.label = label;
        this.argument = argument;
    }

    /**
     *
     * @return the label label
     */
    @Override
    public Expression getLabel() {
        return label;
    }

    /**
     *
     * @return the label label
     */
    public Variable getArgument() {
        return argument;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "inlineStatement " + label.toString(); //NOI18N
    }

}
