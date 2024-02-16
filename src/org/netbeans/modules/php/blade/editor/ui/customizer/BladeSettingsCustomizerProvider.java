package org.netbeans.modules.php.blade.editor.ui.customizer;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 * Blade settings node
 * 
 * @author bhaidu
 */
public class BladeSettingsCustomizerProvider implements ProjectCustomizer.CompositeCategoryProvider {

    public static final String CUSTOMIZER_IDENT = "Laravel Blade"; // NOI18N

    @NbBundle.Messages("BladeSettingsCustomizerProvider.name=Blade")
    @Override
    public ProjectCustomizer.Category createCategory(Lookup lkp) {
        List<ProjectCustomizer.Category> subcategories = new ArrayList<>();
        BladeOptionsCustomizerProvider optionsCustomizer = new BladeOptionsCustomizerProvider();
        subcategories.add(optionsCustomizer.createCategory(lkp));
        BladeDirectivesCustomizerProvider directiveCustomizer = new BladeDirectivesCustomizerProvider();
        subcategories.add(directiveCustomizer.createCategory(lkp));
        return ProjectCustomizer.Category.create(CUSTOMIZER_IDENT,
                NbBundle.getMessage(BladeSettingsCustomizerProvider.class, "LBL_LaravelBlade"), null,
                subcategories.toArray(new ProjectCustomizer.Category[0]));
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        switch (category.getName()) {
            case BladeOptionsCustomizerProvider.VIEWS_FOLDERS:
                BladeOptionsCustomizerProvider provider = new BladeOptionsCustomizerProvider();
                return provider.createComponent(category, context);
            case BladeDirectivesCustomizerProvider.BLADE_DIRECTIVES:
                BladeDirectivesCustomizerProvider directivesProvider = new BladeDirectivesCustomizerProvider();
                return directivesProvider.createComponent(category, context);
        }

        return new JPanel();
    }

    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "org.netbeans.modules.web.clientproject", // NOI18N
            position = 367)
    public static BladeSettingsCustomizerProvider forHtml5Project() {
        return new BladeSettingsCustomizerProvider();
    }

    @ProjectCustomizer.CompositeCategoryProvider.Registration(
            projectType = "org-netbeans-modules-php-project", // NOI18N
            position = 402)
    public static ProjectCustomizer.CompositeCategoryProvider forPhpProject() {
        return new BladeSettingsCustomizerProvider();
    }

}
