package org.netbeans.modules.php.blade.editor.model;

import java.util.Set;
import org.netbeans.modules.csl.api.ElementHandle;
import org.netbeans.modules.csl.api.ElementKind;
import org.netbeans.modules.csl.api.Modifier;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.model.api.BladeElement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.DirectiveWithPath;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
abstract class BaseOccurence implements OccurenceElement {

    private FileObject fileObject;

    protected final String name;
    
    protected final String label;

    private final OffsetRange offsetRange;

    protected BladeElement.Kind kind; //to think of??

    public BaseOccurence(DirectiveWithPath node, FileObject file) {
        this.name = node.getDirectiveName().getName();
        this.label = node.getLabel().toString();
        this.offsetRange = new OffsetRange(node.getStartOffset(), node.getEndOffset());
        this.fileObject = file;
        //TODO move logic in BladeSyntax class
        switch (name){
            case "@includeIf":
            case "@include": {
                kind = BladeElement.Kind.INCLUDE;
                break;
            }
            case "@extends":{
                kind = BladeElement.Kind.EXTEND;
                break;
            }
            case "@yield":{
                kind = BladeElement.Kind.YIELD;
                break;
            }
            case "@section":{
                kind = BladeElement.Kind.SECTION;
                break;
            }
            default:{
                kind = BladeElement.Kind.OTHER;
            }
        }
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
    
    public String getLabel() {
        return label;
    }

    @Override
    public String getIn() {
        return null;
    }

    public final OffsetRange getOffsetRange() {
        return offsetRange;
    }

    public int getOffset() {
        return offsetRange.getStart();
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
    public boolean signatureEquals(ElementHandle handle) {
        //TODO what to do with this??
        return false;
    }

    @Override
    public Set<Modifier> getModifiers() {
        //not required
        return null;
    }

    @Override
    public ElementKind getKind() {
        return ElementKind.TAG;
    }
    
    public BladeElement.Kind getBladeKind(){
        return kind;
    }
}
