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

    public static final String BLADE_DIRECTIVES = "Custom Directives"; // NOI18N

    @NbBundle.Messages("BladeCompilerCustomizerProvider.name=Blade Directives")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup lkp) {
        return ProjectCustomizer.Category.create(BLADE_DIRECTIVES, BLADE_DIRECTIVES, null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        Project project = context.lookup(Project.class);
        assert project != null;
        
        BladeDirectives panel =  new BladeDirectives(project);
        category.setOkButtonListener(new BladeDirectivesCustomizerProvider.Listener(panel));
        return panel;
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
