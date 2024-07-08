/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.indexing;

import java.util.List;
import org.netbeans.modules.csl.api.OffsetRange;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
public class PhpIndexFunctionResult extends PhpIndexResult {

    protected final List<String> params;
    protected final String classNamespace;

    public PhpIndexFunctionResult(String name, FileObject fo,
            PhpIndexFunctionResult.Type type,
            OffsetRange range, String classNamespace, List<String> params) {
        super(name, fo, type, range);
        this.params = params;
        this.classNamespace = classNamespace;
    }

    public String getParamsAsString() {
        if (params == null || params.isEmpty()){
            return "()";
        }
        return "(" + String.join(", ", params) + ")";
    }

    public List<String> getParams(){
        return params;
    }
    
    public String getClassNamespace(){
        return classNamespace;
    }
}
