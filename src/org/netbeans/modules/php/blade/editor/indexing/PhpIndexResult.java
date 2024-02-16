/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.indexing;

import org.netbeans.modules.csl.api.OffsetRange;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class PhpIndexResult {
    public static enum Type{
        CLASS,
        FUNCTION,
        NAMESPACE,
        CONSTANT
    };

    public String name;
    public FileObject declarationFile;
    public PhpIndexResult.Type type;
    public OffsetRange range;
    
    public PhpIndexResult(String name, FileObject fo,
            PhpIndexResult.Type type,
            OffsetRange range){
        this.name = name;
        this.declarationFile = fo;
        this.type = type;
        this.range = range;
    }
    
    public int getStartOffset(){
        return this.range.getStart();
    }
}
