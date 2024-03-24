package org.netbeans.modules.php.blade.editor.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexUtils;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
@NamespaceRegister({
    @Namespace(path = "App\\View\\Components", from_app=true),
    @Namespace(path = "App\\Http\\Livewire", from_app=true),
    @Namespace(path = "Illuminate\\Console\\View\\Components"),
    @Namespace(path = "BladeUIKit\\Components\\Buttons", packageName="blade-ui-kit/blade-ui-kit"),
    @Namespace(path = "BladeUIKit\\Components\\Layouts", packageName="blade-ui-kit/blade-ui-kit"),
    @Namespace(path = "BladeUIKit\\Components\\Forms\\Inputs", packageName="blade-ui-kit/blade-ui-kit"),
})
public class ComponentsCompletionService {

    private static Set<String> cachedElements;

    public Collection<PhpIndexResult> queryComponents(String prefix, FileObject fo) {
        Collection<PhpIndexResult> results = new ArrayList<>();
        Project project = ProjectUtils.getMainOwner(fo);
        for (Namespace namespace : getNamespaces()){
            if (namespace.from_app()){
                //check if folder exists
                if (project.getProjectDirectory().getFileObject("app/View/Components") == null){
                    continue;
                }
            }
            results.addAll(PhpIndexUtils.queryNamespaceClassesName(prefix, namespace.path(), fo));
        }

        return results;
    }

    public Namespace[] getNamespaces() {
        NamespaceRegister namespaceRegister = this.getClass().getAnnotation(NamespaceRegister.class);
        return namespaceRegister.value();
    }
}
