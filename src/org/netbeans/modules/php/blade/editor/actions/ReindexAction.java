package org.netbeans.modules.php.blade.editor.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.indexing.BladeIndex;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.awt.DynamicMenuContent;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.util.ContextAwareAction;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 * TODO validate view folder content
 * 
 * @author bogdan
 */
@ActionID(id = "org.netbeans.modules.php.blade.editor.actions.reindex", category = "Folder")
@ActionRegistration(displayName = "#ACT_Reindex_Folder", lazy = false)
@ActionReferences({
    @ActionReference(position = 1900, path = "Loaders/folder/any/Actions"),})
@NbBundle.Messages("ACT_Reindex_Folder=Reindex folder")
public class ReindexAction extends AbstractAction implements ContextAwareAction {

    FileObject folder;

    @Override
    public void actionPerformed(ActionEvent e) {
       if (folder != null){
           BladeIndex.reindexFolder(folder);
       }
    }

    @Override
    public Action createContextAwareInstance(Lookup lkp) {
        FileObject folderNode = lkp.lookup(FileObject.class);
        //experiment for annotation
        DataObject d = lkp.lookup(DataObject.class);
        ReindexAction action = new ReindexAction();
        action.putValue(NAME, "Reindex folder");
        action.putValue(DynamicMenuContent.HIDE_WHEN_DISABLED, true);
        action.setEnabled(false);

        if (folderNode == null) {
            return action;
        }

        Project project = ProjectUtils.getMainOwner(folderNode);

        if (project == null) {
            return action;
        }

        //quick limit
        if (!folderNode.getName().equals("views")) {
            return action;
        }

        action.setEnabled(true);
        action.setFolder(folderNode);
        return action;
    }

    private void setFolder(FileObject folder) {
        this.folder = folder;
    }

}
