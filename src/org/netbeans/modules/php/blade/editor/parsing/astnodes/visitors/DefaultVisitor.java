package org.netbeans.modules.php.blade.editor.parsing.astnodes.visitors;

import org.netbeans.modules.php.blade.editor.parsing.astnodes.*;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.Visitor;

/**
 *
 * @author bhaidu
 */
public class DefaultVisitor implements Visitor {

    public void scan(ASTNode node) {
        if (node != null) {
            node.accept(this);
        }
    }

    public void scan(Iterable<? extends ASTNode> nodes) {
        if (nodes != null) {
            for (ASTNode n : nodes) {
                scan(n);
            }
        }
    }

    @Override
    public void visit(BladeProgram program) {
        scan(program.getStatements());
    }

    @Override
    public void visit(ASTNode node) {
    }

    @Override
    public void visit(DirectiveBladeBlock node) {
        scan(node.getBody().getStatements());
    }

    @Override
    public void visit(BladeSectionStatement node) {
        scan(node.getBody().getStatements());
    }

    @Override
    public void visit(BladeYieldStatement node) {
    }

    @Override
    public void visit(BladeExtendsStatement node) {
    }

    @Override
    public void visit(BladeIncludeStatement node) {
    }
    
    @Override
    public void visit(BladeForeachStatement node) {
    }
    
    @Override
    public void visit(BladeIfStatement node) {
    }
    
    @Override
    public void visit(BladeForStatement node) {
    }
    
    @Override
    public void visit(InLineHtml node) {
    }
    
    @Override
    public void visit(InLinePhp node) {
    }
    
    public void visit(BladeEchoStatement node) {
    }
    
    public void visit(BladeComment node) {
    }
}
