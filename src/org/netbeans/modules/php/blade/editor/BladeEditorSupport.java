package org.netbeans.modules.php.blade.editor;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.StyledDocument;
import org.netbeans.core.api.multiview.MultiViews;
import org.openide.cookies.EditCookie;
import org.openide.cookies.EditorCookie;
import org.openide.cookies.OpenCookie;
import org.openide.cookies.SaveCookie;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileObject;
import org.openide.nodes.Node.Cookie;
import org.openide.text.CloneableEditor;
import org.openide.text.CloneableEditorSupport;
import org.openide.text.DataEditorSupport;
import org.openide.util.UserCancelException;
import org.openide.windows.CloneableOpenSupport;

/**
 *
 * @author bhaidu
 */
public class BladeEditorSupport extends DataEditorSupport implements OpenCookie, EditCookie, EditorCookie.Observable {

    private static final String DOCUMENT_SAVE_ENCODING = "Document_Save_Encoding";
    private static final String UTF_8_ENCODING = "UTF-8";

    /** SaveCookie for this support instance. The cookie is adding/removing
     * data object's cookie set depending on if modification flag was set/unset.
     * It also invokes beforeSave() method on the BladeDataObject to give it
     * a chance to eg. reflect changes in 'charset' attribute
     * */
    private final SaveCookie saveCookie = new SaveCookie() {

        /** Implements <code>SaveCookie</code> interface. */
        @Override
        public void save() throws IOException {
            try {
                saveDocument();
            } catch (UserCancelException uce) {
                //just ignore
            }
        }
    };

    /** Constructor. */
    BladeEditorSupport(BladeDataObject obj) {
        super(obj, null, new Environment(obj));
        setMIMEType(obj.getPrimaryFile().getMIMEType());
    }

    @Override
    protected Pane createPane() {
        return (CloneableEditorSupport.Pane) MultiViews.createCloneableMultiView(BladeLanguage.BLADE_MIME_TYPE, getDataObject());
    }

    @Override
    protected boolean asynchronousOpen() {
        return true;
    }

    @Override
    public void saveDocument() throws IOException {
        updateEncoding();
        super.saveDocument();
// DataObject.setModified() already called as part of super.saveDocument(). The save action is now asynchronous
// in the IDE and super.saveDocument() checks for possible extra document modifications performed during save
// and sets the DO.modified flag accordingly.
//        BladeEditorSupport.this.getDataObject().setModified(false);
    }

    void updateEncoding() throws UserCancelException {
        //try to find encoding specification in the editor content
        String documentContent = getDocumentText();
//        String feqEncoding = FileEncodingQuery.getEncoding(getDataObject().getPrimaryFile()).name();
        
        //FEQ cannot be run in saveFromKitToStream since document is locked for writing,
        //so setting the FEQ result to document property
        Document document = getDocument();
        if (document != null) {
            //document.putProperty(DOCUMENT_SAVE_ENCODING, finalEncoding);
        }
    }


    private String getDocumentText() {
        String text = "";
        try {
            StyledDocument doc = getDocument();
            if (doc != null) {
                text = doc.getText(doc.getStartPosition().getOffset(), doc.getLength());
            }
        } catch (BadLocationException e) {
            Logger.getLogger("global").log(Level.WARNING, null, e);
        }
        return text;
    }

    private BladeDataObject getTplDO() {
        return (BladeDataObject) getDataObject();
    }

    private boolean isSupportedEncoding(String encoding) {
        boolean supported;
        try {
            supported = java.nio.charset.Charset.isSupported(encoding);
        } catch (java.nio.charset.IllegalCharsetNameException e) {
            supported = false;
        }
        return supported;
    }

    public void open() {

        super.open();
    }

   /**
     * @inheritDoc
     */
    @Override
    protected void saveFromKitToStream(StyledDocument doc, EditorKit kit, OutputStream stream) throws IOException, BadLocationException {
        String foundEncoding = (String) doc.getProperty(DOCUMENT_SAVE_ENCODING);
        String usedEncoding = foundEncoding != null ? foundEncoding : UTF_8_ENCODING;
        final Charset c = Charset.forName(usedEncoding);
        final Writer w = new OutputStreamWriter(stream, c);
        try {
            kit.write(w, doc, 0, doc.getLength());
        } finally {
            w.close();
        }
    }

    @Override
    protected StyledDocument createStyledDocument(EditorKit kit) {
        StyledDocument doc = super.createStyledDocument(kit);

        // see TplKit.createDefaultDocument;
        Runnable postInitRunnable = (Runnable) doc.getProperty("postInitRunnable"); //NOI18N
        if (postInitRunnable != null) {
            postInitRunnable.run();
        }

        return doc;
    }

    /**
     * Overrides superclass method. Adds adding of save cookie if the document has been marked modified.
     * @return true if the environment accepted being marked as modified
     *    or false if it has refused and the document should remain unmodified
     */
    @Override
    protected boolean notifyModified() {
        if (!super.notifyModified()) {
            return false;
        }
        addSaveCookie();
        return true;
    }

    /** Overrides superclass method. Adds removing of save cookie. */
    @Override
    protected void notifyUnmodified() {
        super.notifyUnmodified();
        removeSaveCookie();
    }

    /** Helper method. Adds save cookie to the data object. */
    private void addSaveCookie() {
        BladeDataObject obj = (BladeDataObject) getDataObject();

        // Adds save cookie to the data object.
        if (obj.getCookie(SaveCookie.class) == null) {
            obj.getCookieSet0().add(saveCookie);
            obj.setModified(true);
        }
    }

    /** Helper method. Removes save cookie from the data object. */
    private void removeSaveCookie() {
        BladeDataObject obj = (BladeDataObject) getDataObject();

        // Remove save cookie from the data object.
        Cookie cookie = obj.getCookie(SaveCookie.class);

        if (cookie != null && cookie.equals(saveCookie)) {
            obj.getCookieSet0().remove(saveCookie);
            obj.setModified(false);
        }
    }

    /** Nested class. Environment for this support. Extends <code>DataEditorSupport.Env</code> abstract class. */
    private static class Environment extends DataEditorSupport.Env {

        private static final long serialVersionUID = 3035543158452715818L;

        /** Constructor. */
        public Environment(BladeDataObject obj) {
            super(obj);
        }

        /** Implements abstract superclass method. */
        @Override
        protected FileObject getFile() {
            return getDataObject().getPrimaryFile();
        }

        /** Implements abstract superclass method.*/
        @Override
        protected FileLock takeLock() throws IOException {
            return ((BladeDataObject) getDataObject()).getPrimaryEntry().takeLock();
        }

        /**
         * Overrides superclass method.
         * @return text editor support (instance of enclosing class)
         */
        @Override
        public CloneableOpenSupport findCloneableOpenSupport() {
            return getDataObject().getCookie(BladeEditorSupport.class);
        }
    } // End of nested Environment class.

    /** A method to create a new component. Overridden in subclasses.
     * @return the {@link BladeEditor} for this support
     */
    @Override
    protected CloneableEditor createCloneableEditor() {
        return new BladeEditor(this);
    }

    public static class BladeEditor extends CloneableEditor {

        public BladeEditor() {
        }

        /** Creates new editor */
        public BladeEditor(BladeEditorSupport s) {
            super(s);
            initialize();
        }

        private void initialize() {
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            super.readExternal(in);
            initialize();
        }
    }
}
