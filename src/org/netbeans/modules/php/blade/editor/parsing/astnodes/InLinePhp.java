package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class InLinePhp extends Statement implements StructureModelItem{
    private String phpCode = "";
    public InLinePhp(int start, int end, String phpCode) {
        super(start, end);
        this.phpCode = phpCode;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "@php"; //NOI18N
    }
    
    public String getPhpCode(){
        return phpCode;
    }
}
