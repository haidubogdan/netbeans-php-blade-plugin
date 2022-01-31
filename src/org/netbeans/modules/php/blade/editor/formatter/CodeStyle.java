package org.netbeans.modules.php.blade.editor.formatter;

import java.util.prefs.Preferences;
import javax.swing.text.Document;
import org.netbeans.modules.editor.indent.spi.CodeStylePreferences;
import static org.netbeans.modules.php.blade.editor.formatter.FmtOptions.*;

/**
 *
 * @author bhaidu
 */
public class CodeStyle {

    private Preferences preferences;

    private CodeStyle(Preferences preferences) {
        this.preferences = preferences;
    }

    /**
     * For testing purposes only.
     */
    public static CodeStyle get(Preferences prefs) {
        return new CodeStyle(prefs);
    }

    public static CodeStyle get(Document doc) {
        return new CodeStyle(CodeStylePreferences.get(doc).getPreferences());
    }

    // General tabs and indents ------------------------------------------------
    
    public boolean expandTabToSpaces() {
        return preferences.getBoolean(EXPAND_TAB_TO_SPACES,  getDefaultAsBoolean(EXPAND_TAB_TO_SPACES));
    }
    
    public int getTabSize() {
        return preferences.getInt(TAB_SIZE, getDefaultAsInt(TAB_SIZE));
    }

    public int getIndentSize() {
        return preferences.getInt(INDENT_SIZE, getDefaultAsInt(INDENT_SIZE));
    }

    public int getContinuationIndentSize() {
        return preferences.getInt(CONTINUATION_INDENT_SIZE, getDefaultAsInt(CONTINUATION_INDENT_SIZE));
    }

    public int getInitialIndent() {
        return preferences.getInt(INITIAL_INDENT, getDefaultAsInt(INITIAL_INDENT));
    }

    public int getRightMargin() {
        return preferences.getInt(RIGHT_MARGIN, getDefaultAsInt(RIGHT_MARGIN));
    }

    static class beforeDirectiveTagPlacement {

        static beforeDirectiveTagPlacement SAME_LINE;
        static beforeDirectiveTagPlacement NEW_LINE_INDENTED;
        static beforeDirectiveTagPlacement PRESERVE_EXISTING;
        public beforeDirectiveTagPlacement() {
        }
    }

    
    public enum WrapStyle {
        WRAP_ALWAYS,
        WRAP_IF_LONG,
        WRAP_NEVER
    }

}
