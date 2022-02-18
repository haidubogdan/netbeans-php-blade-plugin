package org.netbeans.modules.php.blade.editor.parsing.astnodes;

public class DirectiveWithArgument extends InlineDirectiveStatement implements StructureModelItem {
    public DirectiveWithArgument(int start, int end, DirectiveName directive, ArgumentExpression argument) {
        super(start, end, directive, argument);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getDirectiveName().getName(); //NOI18N
    }

}