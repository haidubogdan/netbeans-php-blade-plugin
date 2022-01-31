package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public abstract class DirectiveStatement extends Statement implements DirectiveNamedStatement {
    private DirectiveName directive;
    
    public DirectiveStatement(int start, int end, DirectiveName directive) {
        super(start, end);
        this.directive = directive;
    }
    
    @Override
    public DirectiveName getDirectiveName(){
        return directive;
    }
}
