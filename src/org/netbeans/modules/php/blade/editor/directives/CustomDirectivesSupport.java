package org.netbeans.modules.php.blade.editor.directives;

import java.io.IOException;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
public class CustomDirectivesSupport {

    public static final String OFFSET = "offset"; // NOI18N

    public static void setLogReferencePath(FileObject dataFo, String path) {
        try {
            dataFo.setAttribute(OFFSET, path);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
