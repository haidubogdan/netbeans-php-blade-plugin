package org.netbeans.modules.php.blade.editor.ui.customizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author bhaidu
 */
public class BladeDirectivesCustomizerProvider implements ProjectCustomizer.CompositeCategoryProvider {

    public static final String CUSTOMIZER_IDENT = "Blade Directives"; // NOI18N

    @NbBundle.Messages("BladeCompilerCustomizerProvider.name=Blade")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup lkp) {
        return ProjectCustomizer.Category.create(CUSTOMIZER_IDENT, "Blade Directives", null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        Project project = context.lookup(Project.class);
        assert project != null;
        
        BladeDirectives panel =  new BladeDirectives(project);
        category.setOkButtonListener(new BladeDirectivesCustomizerProvider.Listener(panel));
        return panel;
    }

    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "org.netbeans.modules.web.clientproject", // NOI18N
            position = 367)
    public static BladeDirectivesCustomizerProvider forHtml5Project() {
        return new BladeDirectivesCustomizerProvider();
    }

    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "org-netbeans-modules-php-project", // NOI18N
            position = 402)
    public static ProjectCustomizer.CompositeCategoryProvider forPhpProject() {
        return new BladeDirectivesCustomizerProvider();
    }

    private class Listener implements ActionListener {

        private final BladeDirectives panel;

        public Listener(BladeDirectives panel) {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.panel.storeData();
        }

    }
}
