package org.netbeans.modules.php.blade.project;

import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.ProjectConvertors;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class ProjectUtils {

    public static Project getMainOwner(FileObject file) {
        Project project = ProjectConvertors.getNonConvertorOwner(file);

        if (project == null) {
            return null;
        }
        
        return project;
    }
    
    public static FileObject getProjectDirectory(FileObject file) {
        Project project = getMainOwner(file);

        if (project == null){
            return null;
        }
        
        return project.getProjectDirectory();
    }
}
