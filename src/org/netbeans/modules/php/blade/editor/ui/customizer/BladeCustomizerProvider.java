package org.netbeans.modules.php.blade.editor.ui.customizer;

import javax.swing.JComponent;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.ui.options.BladeOptionsPanelController;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.netbeans.modules.php.blade.editor.ui.options.BladePanel;

/**
 *
 * @author bhaidu
 */
public class BladeCustomizerProvider implements ProjectCustomizer.CompositeCategoryProvider{
    public static final String CUSTOMIZER_IDENT = "Blade"; // NOI18N


    @NbBundle.Messages("BladeCustomizerProvider.name=Blade")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup lkp) {
        return ProjectCustomizer.Category.create(CUSTOMIZER_IDENT, "Blade", null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        Project project = context.lookup(Project.class);
        assert project != null;
        return new BladeOptionsPanelController().getComponent(context);
    }
    
    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "org.netbeans.modules.web.clientproject", // NOI18N
            position = 366)
    public static BladeCustomizerProvider forHtml5Project() {
        return new BladeCustomizerProvider();
    }

    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "org-netbeans-modules-php-project", // NOI18N
            position = 401)
    public static ProjectCustomizer.CompositeCategoryProvider forPhpProject() {
        return new BladeCustomizerProvider();
    }
    
}
