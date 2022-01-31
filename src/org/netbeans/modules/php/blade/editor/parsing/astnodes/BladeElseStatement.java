package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @if (condexpr)
 *   statement
 * @else
 *   ...
 * @endif
 * @author bhaidu
 */
public class BladeElseStatement extends BladeConstDirectiveStatement implements StructureModelItem {

    public BladeElseStatement(int start, int end, DirectiveName directive) {
        super(start, end, directive);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "@else"; //NOI18N
    }

}
