package org.netbeans.modules.php.blade.csl.elements;

import java.util.List;
import org.netbeans.modules.csl.api.ElementKind;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class PhpFunctionElement extends NamedElement {

    public final List<String> params;

    public PhpFunctionElement(String name, FileObject file,
            ElementType type,
            List<String> params) {
        super(name, file, type);
        this.params = params;
    }

    @Override
    public ElementKind getKind() {
        return ElementKind.METHOD;
    }

    public String getParamsAsString() {
        if (params == null || params.isEmpty()) {
            return "()";
        }
        return "(" + String.join(", ", params) + ")";
    }

    public List<String> getParams() {
        return params;
    }

}
