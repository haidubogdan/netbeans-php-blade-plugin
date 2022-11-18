package org.netbeans.modules.php.blade.editor;

import java.io.IOException;
import org.openide.cookies.EditCookie;
import org.openide.cookies.EditorCookie;
import org.openide.cookies.OpenCookie;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.text.DataEditorSupport;
import org.openide.windows.CloneableOpenSupport;

/**
 *
 * @author bhaidu
 */
@MIMEResolver.Registration(
        resource = "../resources/mime-resolver.xml",
        displayName = "BladeLoader",
        position = 1
)
public class BladeEditorSupport extends DataEditorSupport implements OpenCookie, EditCookie, EditorCookie.Observable {

    /**
     * Constructor.
     */
    BladeEditorSupport(BladeDataObject obj) {
        super(obj, null, new Environment(obj));
        Object mimeType = obj.getPrimaryFile().getMIMEType();
        String fileName = obj.getPrimaryFile().getNameExt();
        setMIMEType(obj.getPrimaryFile().getMIMEType());
    }

    /**
     * Nested class. Environment for this support. Extends
     * <code>DataEditorSupport.Env</code> abstract class.
     */
    private static class Environment extends DataEditorSupport.Env {

        private static final long serialVersionUID = 3135543158452715818L;

        /**
         * Constructor.
         */
        public Environment(BladeDataObject obj) {
            super(obj);
        }

        /**
         * Implements abstract superclass method.
         */
        @Override
        protected FileObject getFile() {
            return getDataObject().getPrimaryFile();
        }

        /**
         * Implements abstract superclass method.
         */
        @Override
        protected FileLock takeLock() throws IOException {
            return ((BladeDataObject) getDataObject()).getPrimaryEntry().takeLock();
        }

        /**
         * Overrides superclass method.
         *
         * @return text editor support (instance of enclosing class)
         */
        @Override
        public CloneableOpenSupport findCloneableOpenSupport() {
            return getDataObject().getCookie(BladeEditorSupport.class);
        }
    } // End of nested Environment class.

}
