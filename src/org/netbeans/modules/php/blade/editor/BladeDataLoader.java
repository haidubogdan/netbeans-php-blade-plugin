package org.netbeans.modules.php.blade.editor;

import java.io.IOException;
import static org.netbeans.modules.php.blade.editor.BladeDataLoader.ACTIONS;
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
@Registration(position = 10998, displayName = "Blade", mimeType = BladeLanguage.BLADE_MIME_TYPE)
@ActionReferences({
    @ActionReference(id = @ActionID(category = "System", id = "org.openide.actions.OpenAction"), path = ACTIONS, position = 100),
    @ActionReference(id = @ActionID(category = "Edit", id = "org.openide.actions.CutAction"), path = ACTIONS, position = 300, separatorBefore = 200),
    @ActionReference(id = @ActionID(category = "Edit", id = "org.openide.actions.CopyAction"), path = ACTIONS, position = 400),
    @ActionReference(id = @ActionID(category = "Edit", id = "org.openide.actions.PasteAction"), path = ACTIONS, position = 500, separatorAfter = 600),
    @ActionReference(id = @ActionID(category = "System", id = "org.openide.actions.NewAction"), path = ACTIONS, position = 700),
    @ActionReference(id = @ActionID(category = "Edit", id = "org.openide.actions.DeleteAction"), path = ACTIONS, position = 800),
    @ActionReference(id = @ActionID(category = "System", id = "org.openide.actions.RenameAction"), path = ACTIONS, position = 900, separatorAfter = 1000),
    @ActionReference(id = @ActionID(category = "System", id = "org.openide.actions.SaveAsTemplateAction"), path = ACTIONS, position = 1100, separatorAfter = 1200),
    @ActionReference(id = @ActionID(category = "System", id = "org.openide.actions.FileSystemAction"), path = ACTIONS, position = 1300, separatorAfter = 1400),
    @ActionReference(id = @ActionID(category = "System", id = "org.openide.actions.ToolsAction"), path = ACTIONS, position = 1500),
    @ActionReference(id = @ActionID(category = "System", id = "org.openide.actions.PropertiesAction"), path = ACTIONS, position = 1600)
})
public class BladeDataLoader extends UniFileLoader {

    public static final String ACTIONS = "Loaders/" + BladeLanguage.BLADE_MIME_TYPE + "/Actions";

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
