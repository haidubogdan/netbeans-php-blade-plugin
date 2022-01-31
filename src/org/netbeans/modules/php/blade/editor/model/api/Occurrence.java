package org.netbeans.modules.php.blade.editor.model.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.netbeans.modules.csl.api.OffsetRange;

/**
 *
 * @author bhaidu
 */
public final class Occurrence {

    private final OffsetRange offsetRange;

    private final List<BladeDirective> declarations;
    
    public Occurrence(OffsetRange offsetRange, BladeDirective... declarations) {
        this.offsetRange = offsetRange;
        this.declarations = new ArrayList<>(declarations.length);
        Collections.addAll(this.declarations, declarations);
    }
    
    public OffsetRange getOffsetRange() {
        return offsetRange;
    }

    public Collection<? extends BladeDirective> getDeclarations() {
        return Collections.unmodifiableCollection(declarations);
    }
    
    @Override
    public int hashCode() {
        return offsetRange.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Occurrence other = (Occurrence) obj;
        if (this.offsetRange != other.offsetRange 
                && (this.offsetRange == null || !this.offsetRange.equals(other.offsetRange))) {
            return false;
        }
        return true;
    }
    
}
