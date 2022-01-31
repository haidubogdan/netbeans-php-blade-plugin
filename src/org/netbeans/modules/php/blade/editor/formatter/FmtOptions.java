package org.netbeans.modules.php.blade.editor.formatter;

import java.util.HashMap;
import java.util.Map;
import org.netbeans.api.editor.settings.SimpleValueNames;

/**
 *
 * @author bhaidu
 */
public class FmtOptions {

    public static final String EXPAND_TAB_TO_SPACES = SimpleValueNames.EXPAND_TABS;
    public static final String TAB_SIZE = SimpleValueNames.TAB_SIZE;
    public static final String SPACES_PER_TAB = SimpleValueNames.SPACES_PER_TAB;
    public static final String INDENT_SIZE = SimpleValueNames.INDENT_SHIFT_WIDTH;
    public static final String CONTINUATION_INDENT_SIZE = "continuationIndentSize";
    public static final String INITIAL_INDENT = "init.indent"; //NOI18N
    public static final String RIGHT_MARGIN = SimpleValueNames.TEXT_LIMIT_WIDTH;
    private static final String TRUE = "true";      // NOI18N
    private static final String FALSE = "false";    // NOI18N
    private static Map<String, String> defaults;

    static {
        createDefaults();
    }

    private static void createDefaults() {
        String[][] defaultValues = {
            {EXPAND_TAB_TO_SPACES, TRUE}, //NOI18N
            {TAB_SIZE, "8"}, //NOI18N
            {INDENT_SIZE, "4"}, //NOI18N
            {CONTINUATION_INDENT_SIZE, "8"}, //NOI18N
            {RIGHT_MARGIN, "80"}, //NOI18N
            {INITIAL_INDENT, "0"} //NOI18N
        };

        defaults = new HashMap<>();

        for (java.lang.String[] strings : defaultValues) {
            defaults.put(strings[0], strings[1]);
        }
    }

    public static int getDefaultAsInt(String key) {
        return Integer.parseInt(defaults.get(key));
    }

    public static boolean getDefaultAsBoolean(String key) {
        return Boolean.parseBoolean(defaults.get(key));
    }

    public static String getDefaultAsString(String key) {
        return defaults.get(key);
    }
}
