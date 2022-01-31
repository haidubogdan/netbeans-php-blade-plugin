package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class BladeConstDirectiveStatement extends DirectiveStatement implements StructureModelItem {
    public BladeConstDirectiveStatement(int start, int end, DirectiveName directive) {
        super(start, end, directive);
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
