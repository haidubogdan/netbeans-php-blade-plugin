package org.netbeans.modules.php.blade.csl.elements;

import java.util.HashSet;
import java.util.Set;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class TagElement implements ElementHandle {

    protected final String name;
    protected final ElementType type;

    public TagElement(String name) {
        this.name = name;
        this.type = ElementType.NA;
    }

    @Override
    public FileObject getFileObject() {
        return null;
    }

    @Override
    public String getMimeType() {
        return BladeLanguage.MIME_TYPE;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getIn() {
        return "";
    }

    @Override
    public ElementKind getKind() {
        return ElementKind.TAG;
    }

    @Override
    public Set<Modifier> getModifiers() {
        return new HashSet<>();
    }

    @Override
    public boolean signatureEquals(ElementHandle eh) {
        return false;
    }

    @Override
    public OffsetRange getOffsetRange(ParserResult pr) {
        return OffsetRange.NONE;
    }

    public ElementType getType() {
        return type;
    }
}
