package org.netbeans.modules.php.blade.editor.model;

import java.util.ArrayList;
import java.util.Collection;
import org.netbeans.api.annotations.common.CheckForNull;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.blade.editor.index.api.IndexedElement;
import org.openide.filesystems.FileObject;

/**
 * related with blade index model which is not used
 * 
 * @author bhaidu
 */
public class BladeModelElement {

    private IndexedElement element;
    private OffsetRange range;
    private OffsetRange scope;

    public BladeModelElement(IndexedElement handle, OffsetRange range, OffsetRange scope) {
        this.element = handle;
        this.range = range;
        this.scope = scope;
    }

    public String getName() {
        return getHandle().getName();
    }

    public BladeElementType getType() {
        return getHandle().getType();
    }

    public FileObject getFile() {
        return getHandle().getFileObject();
    }

    /**
     * range of the element itself.
     */
    public OffsetRange getRange() {
        return range;
    }

    /**
     * range of the element scope.
     *
     * null means no scope
     */
    @CheckForNull
    public OffsetRange getScope() {
        return scope;
    }

    void setScope(OffsetRange scope) {
        this.scope = scope;
    }

    public IndexedElement getHandle() {
        return element;
    }

    public static Collection<IndexedElement> toHandles(Collection<BladeModelElement> elements) {
        Collection<IndexedElement> handles = new ArrayList<>();
        for (BladeModelElement e : elements) {
            handles.add(e.getHandle());
        }
        return handles;
    }

    public int getOffset() {
        if (getRange() != null) {
            return getRange().getStart();
        }
        return 0;
    }
}
