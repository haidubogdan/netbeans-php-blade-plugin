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
public class BladeOptionsCustomizerProvider implements ProjectCustomizer.CompositeCategoryProvider {

    public static final String CUSTOMIZER_IDENT = "Blade Options"; // NOI18N

    @NbBundle.Messages("BladeOptionsCustomizerProvider.name=Blade")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup lkp) {
        return ProjectCustomizer.Category.create(CUSTOMIZER_IDENT, "Blade Options", null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        Project project = context.lookup(Project.class);
        assert project != null;
        
        BladeOptionsPanel panel =  new BladeOptionsPanel(project);
        category.setOkButtonListener(new Listener(panel));
        return panel;
    }

    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "org.netbeans.modules.web.clientproject", // NOI18N
            position = 366)
    public static BladeOptionsCustomizerProvider forHtml5Project() {
        return new BladeOptionsCustomizerProvider();
    }

    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "org-netbeans-modules-php-project", // NOI18N
            position = 401)
    public static ProjectCustomizer.CompositeCategoryProvider forPhpProject() {
        return new BladeOptionsCustomizerProvider();
    }

    private class Listener implements ActionListener {
        private final BladeOptionsPanel panel;
        public Listener(BladeOptionsPanel panel){
           this.panel = panel; 
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            this.panel.storeData();
        }
        
    }
}
