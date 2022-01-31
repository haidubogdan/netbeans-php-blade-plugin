package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public interface Visitor {
    public void visit(BladeProgram program);
    public void visit(ASTNode node);
    public void visit(DirectiveBladeBlock node);
    public void visit(BladeSectionStatement node);
    public void visit(BladeYieldStatement node);
    public void visit(BladeExtendsStatement node);
    public void visit(BladeIncludeStatement node);
    public void visit(BladeIfStatement node);
    public void visit(BladeForStatement node);
    public void visit(BladeForeachStatement node);
    public void visit(InLineHtml node);
    public void visit(InLinePhp node);
}
