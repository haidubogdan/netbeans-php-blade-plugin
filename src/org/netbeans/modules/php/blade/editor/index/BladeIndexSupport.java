package org.netbeans.modules.php.blade.editor.index;

import java.io.IOException;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.index.api.BladeIndex;
import org.netbeans.modules.php.blade.project.CustomDirectives;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 * triggered on auto complete and declaration finder
 *
 * @author bhaidu
 */
public class BladeIndexSupport {

    private static final Logger LOGGER = Logger.getLogger(BladeIndex.class.getSimpleName());
    private static final WeakHashMap<Project, BladeIndexSupport> INSTANCIES = new WeakHashMap<>();

    private final Project project;
    private final BladeIndex index;

    public BladeIndexSupport(Project project) throws IOException {
        this.project = project;
        this.index = BladeIndex.create(project);
        //init the custom directives for the project
        CustomDirectives.getInstance(project);
    }

    public BladeIndex getIndex() {
        return index;
    }

    public Project getProject() {
        return project;
    }

    /**
     *
     * generating the blade index support for project based on the file owner
     *
     * @param fo
     * @return
     */
    public static BladeIndexSupport findFor(FileObject fo) {
        try {
            Project p = getProjectOwner(fo);

            if (p == null) {
                return null;
            }

            synchronized (INSTANCIES) {
                BladeIndexSupport instance = INSTANCIES.get(p);
                if (instance == null) {
                    instance = new BladeIndexSupport(p);
                    INSTANCIES.put(p, instance);
                }
                return instance;
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

        return null;
    }

    /**
     *
     * @param fo
     * @return
     */
    private static Project getProjectOwner(FileObject fo) {
        Project p = FileOwnerQuery.getOwner(fo);

        if (p == null) {
            return null;
        }

        String projectName = p.getClass().getSimpleName();
        
        if (projectName.equals("PhpProject")){
            return p;
        }

        //might be an internal project from a composer file detection
        FileObject parent = p.getProjectDirectory().getParent();
        p = FileOwnerQuery.getOwner(parent); //getting the parent project
        if (p == null || !(p.getClass().getSimpleName().equals("PhpProject"))) {
            LOGGER.log(Level.WARNING, "project for blade file not found {0}", fo.getPath());
            return null;
        }

        return p;
    }
    
    public static BladeIndexSupport getSupportFromProject(Project project) {
        if (INSTANCIES.containsKey(project)) {
            return INSTANCIES.get(project);
        }
        return null;
    }
    
    public static WeakHashMap<Project, BladeIndexSupport> getInstances() {
        return INSTANCIES;
    }

}
