package org.netbeans.modules.php.blade.csl.elements;

import org.netbeans.modules.csl.api.ElementKind;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class PathElement extends NamedElement {

    public PathElement(String name, FileObject file) {
        super(name, file, ElementType.PATH);
    }

    //for better visibility on type searcher
    @Override
    public ElementKind getKind() {
        return ElementKind.PACKAGE;
    }
}
