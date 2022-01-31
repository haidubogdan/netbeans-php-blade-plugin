package org.netbeans.modules.php.blade.editor.model;

import java.util.Collections;
import java.util.Set;
import org.netbeans.api.annotations.common.CheckForNull;
import org.netbeans.api.annotations.common.NullAllowed;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.model.api.BladeElement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeSectionStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeYieldStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.DirectiveNamedStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.DirectiveStatement;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Lookup;

/**
 *
 * @author bhaidu
 */
public class BladeElementImpl implements BladeElement {

    private FileObject fileObject;

    protected final String name;

    private final OffsetRange offsetRange;

    private final String mimeType;

    protected Kind kind;
    
    public BladeElementImpl(DirectiveNamedStatement node){
        this.offsetRange = new OffsetRange(node.getStartOffset(), node.getEndOffset());
        this.name = node.getDirectiveName().getName();
        this.fileObject = null;
        this.mimeType = null;
        this.kind = null;
    }
    
    public BladeElementImpl(FileObject fileObject, String name, 
            OffsetRange offsetRange,
            @NullAllowed String mimeType, @NullAllowed String sourceLabel) {
        this.fileObject = fileObject;
        this.name = name;
        if (offsetRange.getStart() > offsetRange.getEnd()) {
            //LOG.log(Level.WARNING, "Suspicious offset range of element at \n", new Throwable());
        }
        this.offsetRange = offsetRange;
        assert mimeType == null
                || isCorrectMimeType(mimeType) : mimeType;
        this.mimeType = mimeType;
        this.kind = null;
    }

    private static boolean isCorrectMimeType(String mt) {
        //TODO maybe implement
        return true;
    }

    @Override
    public ElementKind getKind() {
        return convertBladeKindToElementKind(getBladeKind());
    }

    public Kind getBladeKind(){
        return kind;
    }
    
    @Override
    public FileObject getFileObject() {
        return fileObject;
    }

    protected void setFileObject(FileObject fileObject) {
        this.fileObject = fileObject;
    }

    @Override
    public String getMimeType() {
        if (mimeType != null) {
            return mimeType;
        }
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
    public final OffsetRange getOffsetRange(ParserResult result) {
        int start = result.getSnapshot().getOriginalOffset(offsetRange.getStart());
        if (start < 0) {
            return OffsetRange.NONE;
        }
        int end = result.getSnapshot().getOriginalOffset(offsetRange.getEnd());
        return new OffsetRange(start, end);
    }

    @Override
    public final OffsetRange getOffsetRange() {
        return offsetRange;
    }

    @Override
    public int getOffset() {
        return offsetRange.getStart();
    }

    @Override
    public boolean signatureEquals(ElementHandle handle) {
        return false;
    }

    public boolean isPlatform() {
        FileObject fo = getFileObject();
        if (fo != null) {
            return isInternalFile(fo);
        }
        return false;
    }

    private static boolean isInternalFile(FileObject file) {
        return true;
        /*
        PlatformProvider p = Lookup.getDefault().lookup(PlatformProvider.class);
        if (p == null) {
            return false;
        }
        for (FileObject dir : p.getPlatformStubs()) {
            if (dir.equals(file) || FileUtil.isParentOf(dir, file)) {
                return true;
            }
        }
        return false;
        */
    }

    public static ElementKind convertBladeKindToElementKind(Kind bladeKind) {
        ElementKind result = ElementKind.OTHER;
        switch (bladeKind) {
            case YIELD:
            case SECTION:
            case INCLUDE:
                result = ElementKind.TAG;
                break;
            case VIEW_PATH:
                result = ElementKind.OTHER;
                break;
            default:
                break;
        }
        return result;
    }

    @Override
    public Set<Modifier> getModifiers() {
        //not required
        return null;
    }
}
