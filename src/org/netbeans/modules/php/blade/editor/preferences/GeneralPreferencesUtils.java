/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.preferences;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;
import org.netbeans.api.editor.mimelookup.MimeLookup;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.openide.util.WeakListeners;


public final class GeneralPreferencesUtils {

    private static final AtomicBoolean INITED = new AtomicBoolean(false);

    public static final String ENABLE_FORMATTING = "enable-blade-format"; // NOI18N
    public static final String ENABLE_INDENTATION = "enable-blade-indent"; // NOI18N
    public static final String ENABLE_AUTO_TAG_COMPLETION = "enable-auto-tag-completion"; // NOI18N

    private static Boolean enableFormatting = null;
    private static Boolean enableIndentation = null;
    private static Boolean enableAutoTagCompletion = null;

    // default values
    private static Preferences PREFERENCES;

    private static final PreferenceChangeListener PREFERENCES_TRACKER = new PreferenceChangeListener() {
        @Override
        public void preferenceChange(PreferenceChangeEvent evt) {
            enableFormatting = PREFERENCES.getBoolean(ENABLE_FORMATTING, false);
            enableIndentation = PREFERENCES.getBoolean(ENABLE_INDENTATION, false);
            enableAutoTagCompletion = PREFERENCES.getBoolean(ENABLE_AUTO_TAG_COMPLETION, true);
        }
    };

    private GeneralPreferencesUtils() {
    }

    public static boolean isFormattingEnabled(){
        lazyInit();
        return enableFormatting;
    }

    public static boolean isIndentationEnabled(){
        lazyInit();
        return enableIndentation;
    }
    
    public static boolean isAutoTagCompletionEnabled(){
        lazyInit();
        return enableAutoTagCompletion;
    }
    
    private static void lazyInit() {
        if (INITED.compareAndSet(false, true)) {
            PREFERENCES = MimeLookup.getLookup(BladeLanguage.MIME_TYPE).lookup(Preferences.class);
            PREFERENCES.addPreferenceChangeListener(WeakListeners.create(PreferenceChangeListener.class, PREFERENCES_TRACKER, PREFERENCES));
            PREFERENCES_TRACKER.preferenceChange(null);
        }
    }
}
