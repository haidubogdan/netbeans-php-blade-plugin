package org.netbeans.modules.php.blade.editor.parsing;

import org.netbeans.modules.csl.api.Severity;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
@org.netbeans.api.annotations.common.SuppressWarnings({"EI_EXPOSE_REP", "EI_EXPOSE_REP2"})
public class BladeError implements org.netbeans.modules.csl.api.Error.Badging {

    private static final boolean SILENT_ERROR_BADGE = false; //NOI18N
    private final String displayName;
    private final FileObject file;
    private final int startPosition;
    private final int endPosition;
    private final Severity severity;
    private final Object[] parameters;

    public BladeError(String displayName, FileObject file, int startPosition, int endPosition, Severity severity, Object[] parameters) {
        this.displayName = displayName;
        this.file = file;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.severity = severity;
        this.parameters = parameters;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getKey() {
        return "[" + startPosition + "," + endPosition + "]-" + displayName;
    }

    @Override
    public FileObject getFile() {
        return this.file;
    }

    @Override
    public int getStartPosition() {
        return this.startPosition;
    }

    @Override
    public int getEndPosition() {
        return this.endPosition;
    }

    @Override
    public Severity getSeverity() {
        return this.severity;
    }

    @Override
    public Object[] getParameters() {
        return this.parameters;
    }

    @Override
    public boolean isLineError() {
        return true;
    }

    @Override
    public boolean showExplorerBadge() {
        return !SILENT_ERROR_BADGE;
    }
}
