package org.netbeans.modules.php.blade.editor.ui.customizer;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


/**
 *
 * @author bhaidu
 */
public class UiOptionsUtils {

    private UiOptionsUtils() {
    }

    
    public static String encodeToStrings(Enumeration<String> list) {
        List<String> result = new ArrayList<>();
        while (list.hasMoreElements()) {
            result.add(list.nextElement());
        }

        return String.join("|", result);
    }
}
