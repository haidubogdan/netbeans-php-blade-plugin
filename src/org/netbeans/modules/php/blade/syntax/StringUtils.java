package org.netbeans.modules.php.blade.syntax;

/**
 *
 * @author bhaidu
 */
public class StringUtils {

    public static boolean isUpperCase(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) {
                continue;
            }
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }

        return true;
    }

    public static String capitalize(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String toKebabCase(String str) {
        return str.replaceAll("([A-Z])", "-$1").toLowerCase().substring(1);
    }

    public static String kebabToCamel(String str) {
        str = str.toLowerCase();
        String[] words = str.split("-");
        String camelCase = words[0];
        for (int i = 1; i < words.length; i++) {
            camelCase += words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        return capitalize(camelCase);
    }
}
