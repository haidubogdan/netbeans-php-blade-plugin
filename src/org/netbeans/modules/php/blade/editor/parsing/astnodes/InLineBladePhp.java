package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class InLineBladePhp extends Statement implements StructureModelItem{

    public InLineBladePhp(int start, int end) {
        super(start, end);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "@php"; //NOI18N
    }
}
