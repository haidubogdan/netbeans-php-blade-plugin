package org.netbeans.modules.php.blade.editor.index.api;

import java.util.Set;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.parsing.spi.indexing.support.IndexResult;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.model.BladeElementType;
import org.netbeans.modules.php.blade.editor.model.api.BladeElement;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class IndexedElement implements BladeElement {

    private final BladeElement.Kind kind;
    private final FileObject fileObject;
    private final String name;
    private final BladeElementType type; 
    private final OffsetRange offsetRange;

    public IndexedElement(FileObject fileObject, String name, BladeElement.Kind kind, OffsetRange offsetRange) {
        this.kind = kind;
        this.fileObject = fileObject;
        this.name = name;
        if (kind.equals(Kind.YIELD)){
            this.type = BladeElementType.YIELD;
        } else {
            this.type = null;
        }
        this.offsetRange = offsetRange;
    }
    
    public static IndexedElement create(IndexResult indexResult, String indexKey, BladeElement.Kind kind) {
        FileObject fo = indexResult.getFile();
        IndexedElement result;
        String name = indexResult.getValue(indexKey);
        result = new IndexedElement(fo, name, kind, new OffsetRange(0, 0));
        return result;
    }
    
    public static IndexedElement create(FileObject fo, String name, BladeElement.Kind kind, OffsetRange range) {
        IndexedElement result;
        result = new IndexedElement(fo, name, kind, range);
        return result;
    }
    
    @Override
    public Set<Modifier> getModifiers() {
        //not appliable
        return null;
    }

    @Override
    public int getOffset() {
        return offsetRange.getStart();
    }

    @Override
    public OffsetRange getOffsetRange() {
        return offsetRange;
    }
    
    public BladeElementType getType(){
        return type;
    }
    
    @Override
    public BladeElement.Kind getBladeKind(){
        return kind;
    }

    @Override
    public FileObject getFileObject() {
        return fileObject;
    }

    @Override
    public String getMimeType() {
        return BladeLanguage.BLADE_MIME_TYPE;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIn() {
        return null;
    }

    @Override
    public ElementKind getKind() {
        return ElementKind.TAG;
    }

    @Override
    public boolean signatureEquals(ElementHandle handle) {
        return false;
    }

    @Override
    public OffsetRange getOffsetRange(ParserResult result) {
        return getOffsetRange();
    }
}
