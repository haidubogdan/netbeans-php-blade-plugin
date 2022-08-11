package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class DirectiveEndTag extends ASTNode {

    private final String name;

    public DirectiveEndTag(int start, int end, String name) {
        super(start, end);
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }
}
