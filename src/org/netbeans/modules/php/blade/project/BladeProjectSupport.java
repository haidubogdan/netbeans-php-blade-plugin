package org.netbeans.modules.php.blade.project;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.SourceGroup;
import org.netbeans.spi.project.ProjectServiceProvider;
import org.netbeans.spi.project.ui.ProjectOpenedHook;
/**
 *
 * @author bhaidu
 */
public class BladeProjectSupport extends ProjectOpenedHook implements PreferenceChangeListener{
    private final Project project;
        
    public BladeProjectSupport(Project project) {
        assert project != null;
        this.project = project;
    }
    
    public Project getProject(){
        return project;
    }

    private static BladeProjectSupport create(Project project) {
        BladeProjectSupport support = new BladeProjectSupport(project);
        return support;
    }
    
    @ProjectServiceProvider(service = ProjectOpenedHook.class, projectType = "org-netbeans-modules-php-blade-project") // NOI18N
    public static BladeProjectSupport forBladeProject(Project project) {
        return create(project);
    }
    
    @ProjectServiceProvider(service = ProjectOpenedHook.class, projectType = "org-netbeans-modules-php-project") // NOI18N
    public static BladeProjectSupport forPhpProject(Project project) {
        return create(project);
    }
    
    @ProjectServiceProvider(service = ProjectOpenedHook.class, projectType = "org-netbeans-modules-web-project") // NOI18N
    public static BladeProjectSupport forWebProject(Project project) {
        return create(project);
    }
    
    @Override
    public void preferenceChange(PreferenceChangeEvent evt) {
        //
    }

    @Override
    protected void projectOpened() {
        BladeProjectProperties.getInstance(project);
        //TODO errors while loading properties
        //CustomDirectives.getInstance();
    }

    @Override
    protected void projectClosed() {
        
    }
    
}
