package org.netbeans.modules.php.blade.editor.components;

import java.util.ArrayList;
import java.util.Collection;
import org.netbeans.modules.php.blade.editor.components.annotation.Attribute;
import org.netbeans.modules.php.blade.editor.components.annotation.AttributeRegister;

/**
 *
 * @author bhaidu
 */
@AttributeRegister({
    @Attribute(name = "class"),
    @Attribute(name = "id"),
    @Attribute(name = "title"),
})
public class AttributeCompletionService {

    public Collection<String> queryComponents(String prefix) {
        Collection<String> results = new ArrayList<>();

        for (Attribute attrName : getAttributes()) {
            if (attrName.name().startsWith(prefix)){
                results.add(attrName.name());
            }
        }

        return results;
    }

    public Attribute[] getAttributes() {
        AttributeRegister attributeRegister = this.getClass().getAnnotation(AttributeRegister.class);
        return attributeRegister.value();
    }
}
