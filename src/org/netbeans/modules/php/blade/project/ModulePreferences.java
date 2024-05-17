
package org.netbeans.modules.php.blade.project;

import java.util.prefs.Preferences;
import org.netbeans.api.editor.mimelookup.MimeLookup;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import static org.netbeans.modules.php.blade.project.OptionsUtils.ENABLE_AUTO_TAG_COMPLETION;

/**
 *
 * @author bogdan
 */
public class ModulePreferences {
    public static Preferences getPreferences(){
        return MimeLookup.getLookup(BladeLanguage.MIME_TYPE).lookup(Preferences.class);
    }
    
    public static void setPrefBoolean(String key, boolean value){
        getPreferences().putBoolean(key, value);
    }
    
    public static boolean isAutoTagCompletionEnabled(){
        return ModulePreferences.getPreferences().getBoolean(ENABLE_AUTO_TAG_COMPLETION, false);
    }
}
