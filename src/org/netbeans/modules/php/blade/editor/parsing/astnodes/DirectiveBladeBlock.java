package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public class DirectiveBladeBlock extends DirectiveStatement  {
    private Block body;
    
    public DirectiveBladeBlock(int start, int end, DirectiveName directive, Block body) {
        super(start, end, directive);
        this.body = body;
    }

    public Block getBody() {
        return body;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
