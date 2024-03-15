
package org.netbeans.modules.php.blade.project;

import java.util.prefs.Preferences;
import org.netbeans.api.editor.mimelookup.MimeLookup;
import org.netbeans.modules.php.blade.editor.BladeLanguage;

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
}
