package org.netbeans.modules.php.blade.editor.parser;

import org.netbeans.api.annotations.common.NonNull;
import org.netbeans.api.annotations.common.NullAllowed;
import org.netbeans.modules.csl.api.Severity;
import org.netbeans.modules.csl.spi.DefaultError;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class BladeError extends DefaultError implements org.netbeans.modules.csl.api.Error.Badging {

    public BladeError(@NullAllowed String key, @NonNull String displayName, @NullAllowed String description, @NonNull FileObject file, @NonNull int start, @NonNull int end, @NonNull Severity severity) {
        super(key, displayName, description, file, start, end, severity);
    }

    @Override
    public boolean showExplorerBadge() {
        return true;
    }

}
