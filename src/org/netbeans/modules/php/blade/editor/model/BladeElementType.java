package org.netbeans.modules.php.blade.editor.model;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO maybe it can be simplified
 * 
 * @author bhaidu
 */
public enum BladeElementType {

    /**
     * 
     */
    YIELD("yield"),
    CLASS("class");
    
    private static Map<String, BladeElementType> CODES_TO_ELEMENTS;
    
    private String indexCode;

    private BladeElementType(String indexCode) {
        this.indexCode = indexCode;
    }
    
    public String getIndexCode() {
        return indexCode;
    }
    
    public boolean isOfTypes(BladeElementType... types) {
        for(BladeElementType type : types) {
            if(type == this) {
                return true;
            }
        }
        return false;
    }
    
    public static BladeElementType forIndexCode(String indexCode) {
        if(CODES_TO_ELEMENTS == null) {
            CODES_TO_ELEMENTS = new HashMap<>();
            for(BladeElementType et : values()) {
                CODES_TO_ELEMENTS.put(et.getIndexCode(), et);
            }
        }
        return CODES_TO_ELEMENTS.get(indexCode);
    }
}
