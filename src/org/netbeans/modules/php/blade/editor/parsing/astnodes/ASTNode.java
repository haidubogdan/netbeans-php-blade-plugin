package org.netbeans.modules.php.blade.editor.parsing.astnodes;

import org.netbeans.modules.php.blade.editor.parsing.astnodes.Visitor;

/**
 *
 * @author bhaidu
 */
public abstract class ASTNode {

    private int startOffset;
    private int endOffset;
    //private ASTNode parent = null;

    public ASTNode(int start, int end) {
        assert start >= 0;
        assert end >= start;

        this.startOffset = start;
        this.endOffset = end;
    }

    public final int getStartOffset() {
        return startOffset;
    }

    public final int getEndOffset() {
        return endOffset;
    }

    public final void setSourceRange(int startOffset, int endOffset) {
        if (startOffset >= 0 && endOffset < 0) {
            throw new IllegalArgumentException();
        }
        if (startOffset < 0 && endOffset != 0) {
            throw new IllegalArgumentException();
        }
        assert startOffset >= 0;
        assert endOffset >= startOffset;

        this.startOffset = startOffset;
        this.endOffset = endOffset;
    }

    public abstract void accept(Visitor visitor);
}
