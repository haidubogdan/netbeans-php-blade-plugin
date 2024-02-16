package org.netbeans.modules.php.blade.syntax;

/**
 *
 * @author bhaidu
 */
public class StringUtils {

    public static boolean isUpperCase(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)){
                continue;
            }
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }

        return true;
    }
}
