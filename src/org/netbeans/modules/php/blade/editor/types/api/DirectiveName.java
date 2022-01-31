package org.netbeans.modules.php.blade.editor.types.api;

import org.netbeans.modules.csl.api.OffsetRange;

/**
 *
 * @author bhaidu
 */
public final class DirectiveName {
    private final String name;

    private final OffsetRange offsetRange;

    public DirectiveName(String name, OffsetRange offsetRange) {
        this.name = name;
        this.offsetRange = offsetRange;
    }

    public DirectiveName(String name, int startOffset) {
        this(name, startOffset >= 0 ? new OffsetRange(startOffset, startOffset + name.length()) : OffsetRange.NONE);
    }

    public String getName() {
        return name;
    }

    public OffsetRange getOffsetRange() {
        return offsetRange;
    }

    @Override
    public String toString() {
        return "DirectiveNameImpl{" + "name=" + name + ", offsetRange=" + offsetRange + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DirectiveName other = (DirectiveName) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.offsetRange != other.offsetRange && (this.offsetRange == null || !this.offsetRange.equals(other.offsetRange))) {
            return false;
        }
        return true;
    }
}
