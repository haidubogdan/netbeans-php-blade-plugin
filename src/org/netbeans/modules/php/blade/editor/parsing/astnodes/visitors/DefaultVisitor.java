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
    public void visit(DirectiveExpressionBlock node) {
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
        scan(node.getBody().getStatements());
    }

    @Override
    public void visit(BladeIfStatement node) {
        scan(node.getBody().getStatements());
    }

    @Override
    public void visit(BladeForStatement node) {
        scan(node.getBody().getStatements());
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

    @Override
    public void visit(BladeInlineSectionStatement node) {

    }

    @Override
    public void visit(DirectiveWithArgument node) {

    }

    @Override
    public void visit(BladeConditionStatement node) {
        scan(node.getBody().getStatements());
    }

    @Override
    public void visit(BladeElseIfStatement node) {

    }

    @Override
    public void visit(InLineBladePhp node) {
    }
}
