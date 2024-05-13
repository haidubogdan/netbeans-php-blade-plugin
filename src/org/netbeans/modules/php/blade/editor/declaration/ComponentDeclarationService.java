package org.netbeans.modules.php.blade.editor.declaration;

import java.util.ArrayList;
import java.util.Collection;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.components.annotation.Namespace;
import org.netbeans.modules.php.blade.editor.components.annotation.NamespaceRegister;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexUtils;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
@NamespaceRegister({
    @Namespace(path = "App\\View\\Components", from_app = true, relativeFilePath = "app/View/Components"),
    @Namespace(path = "App\\Http\\Livewire", from_app = true, relativeFilePath = "app/Http/Livewire"),
    @Namespace(path = "App\\Livewire", from_app = true, relativeFilePath = "app/Livewire"),//from 10
    @Namespace(path = "Illuminate\\Console\\View\\Components"),
    @Namespace(path = "BladeUIKit\\Components\\Buttons", packageName = "blade-ui-kit/blade-ui-kit"),
    @Namespace(path = "BladeUIKit\\Components\\Layouts", packageName = "blade-ui-kit/blade-ui-kit"),
    @Namespace(path = "BladeUIKit\\Components\\Forms\\Inputs", packageName = "blade-ui-kit/blade-ui-kit"),})
public class ComponentDeclarationService {

    public Collection<PhpIndexResult> queryComponents(String prefix, FileObject fo) {
        Collection<PhpIndexResult> results = new ArrayList<>();
        Project project = ProjectUtils.getMainOwner(fo);

        if (project == null) {
            return results;
        }

        for (Namespace namespace : getNamespaces()) {
            if (namespace.from_app()) {
                //check if folder exists
                if (project.getProjectDirectory().getFileObject(namespace.relativeFilePath()) == null) {
                    continue;
                }
            }
            results.addAll(PhpIndexUtils.queryExactNamespaceClasses(prefix, namespace.path(), fo));
        }

        return results;
    }
    
    public FileObject getComponentResourceFile(String componentId, String classQualifiedName, FileObject sourceFo) {
        if (classQualifiedName.toLowerCase().contains("livewire")){
            return getLivewireComponentResourceFile(componentId, sourceFo);
        }
        
        return null;
    }

    public FileObject getLivewireComponentResourceFile(String componentId, FileObject sourceFo) {
        Project project = ProjectUtils.getMainOwner(sourceFo);
        if (project == null) {
            return null;
        }
        
        FileObject componentResource = project.getProjectDirectory().getFileObject("resources/views/livewire/" + componentId + ".blade.php");

        if (componentResource != null && componentResource.isValid()){
            return componentResource;
        }
        
        return null;
    }

    public Namespace[] getNamespaces() {
        NamespaceRegister namespaceRegister = this.getClass().getAnnotation(NamespaceRegister.class);
        return namespaceRegister.value();
    }
}
