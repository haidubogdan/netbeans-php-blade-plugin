/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2016 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 */
package org.netbeans.modules.php.blade.project;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;
import org.netbeans.api.editor.mimelookup.MimeLookup;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.openide.util.WeakListeners;

/**
 * TODO delete
 * Based on PHP. Options for Auto Completion.
 */
public final class OptionsUtils {

    private static final AtomicBoolean INITED = new AtomicBoolean(false);

    public static final String ENABLE_FORMATTING = "enable-blade-format"; // NOI18N
    public static final String ENABLE_INDENTATION = "enable-blade-indent"; // NOI18N

    private static Boolean enableFormatting = null;
    private static Boolean enableIndentation = null;

    // default values
    private static Preferences PREFERENCES;

    private static final PreferenceChangeListener PREFERENCES_TRACKER = new PreferenceChangeListener() {
        @Override
        public void preferenceChange(PreferenceChangeEvent evt) {
            String settingName = evt == null ? null : evt.getKey();
            enableFormatting = PREFERENCES.getBoolean(ENABLE_FORMATTING, false);
            enableIndentation = PREFERENCES.getBoolean(ENABLE_INDENTATION, false);
        }
    };

    private OptionsUtils() {
    }

    public static boolean isFormattingEnabled(){
        lazyInit();
        return enableFormatting;
    }

    public static boolean isIndentationEnabled(){
        lazyInit();
        return enableIndentation;
    }
    
    private static void lazyInit() {
        if (INITED.compareAndSet(false, true)) {
            PREFERENCES = MimeLookup.getLookup(BladeLanguage.MIME_TYPE).lookup(Preferences.class);
            PREFERENCES.addPreferenceChangeListener(WeakListeners.create(PreferenceChangeListener.class, PREFERENCES_TRACKER, PREFERENCES));
            PREFERENCES_TRACKER.preferenceChange(null);
        }
    }
}
