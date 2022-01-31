package org.netbeans.modules.php.blade.editor.parsing.astnodes.visitors;

import java.util.LinkedList;
import java.util.List;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.*;

/**
 *
 * @author bhaidu
 */
public class DefaultPathVisitor extends DefaultVisitor {

    // @GuardedBy(path)
    private final List<ASTNode> path = new LinkedList<>();

    /**
     * Reversed order.
     *
     * @return
     */
    public List<ASTNode> getPath() {
        synchronized (path) {
            return new LinkedList<>(path);
        }
    }

    @Override
    public void visit(BladeSectionStatement node) {
        addToPath(node);
        super.visit(node);
        removeFromPath();
    }
    
    @Override
    public void visit(BladeYieldStatement node) {
        addToPath(node);
        super.visit(node);
        removeFromPath();
    }
    
    @Override
    public void visit(InLinePhp node) {
        addToPath(node);
        super.visit(node);
        removeFromPath();
    }

    protected void addToPath(ASTNode node) {
        if (node != null) {
            synchronized (path) {
                path.add(0, node);
            }
        }
    }

    protected void removeFromPath() {
        synchronized (path) {
            path.remove(0);
        }
    }
}
