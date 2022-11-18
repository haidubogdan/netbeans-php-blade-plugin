package org.netbeans.modules.php.blade.editor;

import java.io.IOException;
import static org.netbeans.modules.php.blade.editor.BladeDataObject.ACTIONS;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject.Registration;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.UniFileLoader;
import org.openide.util.NbBundle;

/**
 *
 * @author bhaidu
 */
//@Registration(position = 10998, displayName = "Blade", mimeType = BladeLanguage.BLADE_MIME_TYPE)
public class BladeDataLoader extends UniFileLoader {


    public BladeDataLoader() {
        super("org.netbeans.modules.php.blade.editor.BladeDataObject"); // NOI18N
    }

    @Override
    protected void initialize() {
        super.initialize();
        getExtensions().addMimeType(BladeLanguage.BLADE_MIME_TYPE); // NOI18N
    }

    @Override
    protected MultiDataObject createMultiObject(final FileObject primaryFile)
            throws DataObjectExistsException, IOException {
        return new BladeDataObject(primaryFile, this);
    }

    /**
     * Get the default display name of this loader.
     *
     * @return default display name
     */
    @Override
    protected String defaultDisplayName() {
        return NbBundle.getMessage(BladeDataLoader.class, "PROP_BladeLoader_Name");
    }

    @Override
    protected String actionsContext() {
        return ACTIONS; // NOI18N
    }
}
