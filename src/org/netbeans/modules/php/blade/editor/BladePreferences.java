package org.netbeans.modules.php.blade.editor;

import java.util.prefs.Preferences;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.openide.util.NbPreferences;

/**
 * se also https://github.com/apache/netbeans/blob/2494ac2a8445c82e92cd7ae491b2d6d58c38f856/webcommon/javascript2.editor/src/org/netbeans/modules/javascript2/editor/JsPreferences.java
 * 
 * this should be project specific TODO rename package ?
 * 
 * @author bhaidu
 */
public class BladePreferences {
    
    private final Project project;
    
      // @GuardedBy("this")
    private Preferences sharedPreferences;
    
    public BladePreferences(Project project) {
        assert project != null;
        this.project = project;
    }
    
//    public static Preferences getPreferences() {
//        return NbPreferences.forModule(BladePreferences.class);
//    }

    public Project getProject() {
        return project;
    }
    
    private synchronized Preferences getPreferences() {
        if (sharedPreferences == null) {
            sharedPreferences = ProjectUtils.getPreferences(project, BladePreferences.class, true);
        }
        return sharedPreferences;
    }
}
