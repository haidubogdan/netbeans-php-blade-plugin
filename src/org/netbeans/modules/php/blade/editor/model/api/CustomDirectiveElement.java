package org.netbeans.modules.php.blade.editor.model.api;

import java.util.Collections;
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
public class CustomDirectiveElement implements ElementHandle {

    private final String name;
    private final FileObject file;

    public CustomDirectiveElement(String name) {
        this.name = name;
        this.file = null;
    }
    
    public CustomDirectiveElement(String name, FileObject file) {
        this.name = name;
        this.file = file;
    }

    @Override
    public FileObject getFileObject() {
        return file;
    }

    @Override
    public String getMimeType() {
        return BladeLanguage.BLADE_MIME_TYPE;
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
        return ElementKind.OTHER;
    }

    @Override
    public Set<Modifier> getModifiers() {
        return Collections.<Modifier>emptySet();  
    }

    @Override
    public boolean signatureEquals(ElementHandle eh) {
        return false;
    }

    @Override
    public OffsetRange getOffsetRange(ParserResult pr) {
        return OffsetRange.NONE;
    }

    public int getOffset() {
        //not implemented
        return 0;
    }
}
