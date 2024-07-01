package org.netbeans.modules.php.blade.editor;

import java.util.Collection;
import org.openide.util.Parameters;

/**
 *
 * @author bhaidu
 */
public class StringUtils {

    public static String implode(Collection<String> items, String delimiter) {
        Parameters.notNull("items", items);
        Parameters.notNull("delimiter", delimiter);

        if (items.isEmpty()) {
            return ""; // NOI18N
        }

        StringBuilder buffer = new StringBuilder(200);
        boolean first = true;
        for (String s : items) {
            if (!first) {
                buffer.append(delimiter);
            }
            buffer.append(s);
            first = false;
        }
        return buffer.toString();
    }
    
    public static boolean isQuotedString(String text){
        if (text.length() < 2){
            return false;
        }
        return (text.startsWith("'") && text.endsWith("'")) 
                || (text.startsWith("\\\"") && text.endsWith("\\\""));
    }
}
