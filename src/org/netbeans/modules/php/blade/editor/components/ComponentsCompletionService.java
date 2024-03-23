package org.netbeans.modules.php.blade.editor.components;

import java.util.Set;

/**
 *
 * @author bhaidu
 */
@NamespaceRegister({
    @Namespace(path="Illuminate\\Console\\View\\Components")
})
public class ComponentsCompletionService {
    private Set<String> cachedElements;
}
