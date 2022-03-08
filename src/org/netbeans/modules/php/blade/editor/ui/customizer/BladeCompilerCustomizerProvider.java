package org.netbeans.modules.php.blade.editor.ui.customizer;

import javax.swing.JComponent;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.ui.options.BladeCompilerPathPanelController;
import org.netbeans.modules.php.blade.editor.ui.options.BladeOptionsPanelController;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.netbeans.modules.php.blade.editor.ui.options.BladeOptionsPanel;

/**
 *
 * @author bhaidu
 */
public class BladeCompilerCustomizerProvider implements ProjectCustomizer.CompositeCategoryProvider{
    public static final String CUSTOMIZER_IDENT = "Blade Compiler Path"; // NOI18N


    @NbBundle.Messages("BladeCompilerCustomizerProvider.name=Blade")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup lkp) {
        return ProjectCustomizer.Category.create(CUSTOMIZER_IDENT, "Blade Compiler Path", null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        Project project = context.lookup(Project.class);
        assert project != null;
        return new BladeCompilerPathPanelController().getComponent(context);
    }
    
    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "org.netbeans.modules.web.clientproject", // NOI18N
            position = 367)
    public static BladeCompilerCustomizerProvider forHtml5Project() {
        return new BladeCompilerCustomizerProvider();
    }

    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "org-netbeans-modules-php-project", // NOI18N
            position = 402)
    public static ProjectCustomizer.CompositeCategoryProvider forPhpProject() {
        return new BladeCompilerCustomizerProvider();
    }
    
}
