/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.completion;

import org.netbeans.modules.csl.api.Documentation;
import org.netbeans.modules.php.blade.csl.elements.NamedElement;
import org.netbeans.modules.php.blade.csl.elements.PhpFunctionElement;
import org.netbeans.modules.php.blade.editor.path.PathUtils;

/**
 * @TODO update doc representation
 * 
 * @author bogdan
 */
public class TooltipDoc {

    public static Documentation generateDoc(NamedElement elementHandle) {
        Documentation result = null;
        switch (elementHandle.getType()) {
            case PATH:
                String filePath = "";
                if (elementHandle.getFileObject() != null){
                    filePath = PathUtils.getRelativeProjectPath(elementHandle.getFileObject());
                }
                return Documentation.create(String.format("<div align=\"right\"><font size=-1>%s</font></div>", "blade path")
                        + "<div><b>" + filePath + "</b></div>", null);
            case CUSTOM_DIRECTIVE:
                String docInfo = String.format("<div align=\"right\"><font size=-1>%s</font></div>", "custom directive")
                        + "<div>" + elementHandle.getFileObject().getNameExt() + "</div>";
                return Documentation.create(docInfo, null);
        }

        return result;
    }
    
    public static Documentation generateFunctionDoc(PhpFunctionElement elementHandle) {
        String info = "<div align=\"left\"><b>" + elementHandle.getName() + elementHandle.getParamsAsString() + "</b></div>";
        info += "<div>" + elementHandle.getFileObject().getNameExt() + "</div>";
        info += String.format("<div align=\"right\"><font size=-1>%s</font></div>", "php function");
        return Documentation.create(info, null);
    }
}
