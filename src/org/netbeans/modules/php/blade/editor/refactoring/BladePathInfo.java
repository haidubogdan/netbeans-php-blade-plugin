package org.netbeans.modules.php.blade.editor.refactoring;


import java.util.Objects;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class BladePathInfo {

    private final FileObject sourceFile;
    private final String bladePath;

    public BladePathInfo(FileObject sourceFile, String bladePath) {
        this.sourceFile = sourceFile;
        this.bladePath = bladePath;
    }

    public FileObject getSourceFile() {
        return sourceFile;
    }

    public String getBladePath() {
        return bladePath;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.sourceFile);
        hash = 53 * hash + Objects.hashCode(this.bladePath);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BladePathInfo other = (BladePathInfo) obj;
        if (!Objects.equals(this.bladePath, other.bladePath)) {
            return false;
        }
        return Objects.equals(this.sourceFile, other.sourceFile);
    }

}
