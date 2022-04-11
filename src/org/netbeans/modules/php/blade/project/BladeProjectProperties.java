/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2013 Oracle and/or its affiliates. All rights reserved.
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
 *
 * Portions Copyrighted 2013 Sun Microsystems, Inc.
 */
package org.netbeans.modules.php.blade.project;

import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;
import javax.swing.DefaultListModel;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.modules.php.blade.api.BladeVersion;
import org.netbeans.modules.php.blade.editor.BladePreferences;
import org.netbeans.modules.php.blade.ui.UiOptionsUtils;
//import org.netbeans.modules.php.blade.editor.actions.ToggleBlockCommentAction;
import org.openide.util.NbPreferences;

/**
 * @todo ADD NEW OPTION VALUES
 *
 * @author Haidu Bogdan
 */
public final class BladeProjectProperties {

    private static final BladeProjectProperties INSTANCE = new BladeProjectProperties();
    private static final String BLADE_VERSION = "blade.version"; // NOI18N
    private static final String COMPILER_PATH_LIST = "compiler.path.list";
    private static final String VIEW_PATH_LIST = "views.path.list";
    private Project project;

    private BladeProjectProperties() {
    }

    public static BladeProjectProperties getInstance(Project project) {
        if (INSTANCE.project == null || INSTANCE.project != project){
            INSTANCE.project = project;
        }
        return INSTANCE;
    }
    
    public static BladeProjectProperties getInstance() {
        return INSTANCE;
    }

    private Preferences getPreferences() {
        if (project != null){
            return ProjectUtils.getPreferences(project, this.getClass(), false);
        }
        return NbPreferences.forModule(this.getClass());
    }

    public BladeVersion getDefaultBladeVersion() {
        String defaultBladeVersion = getPreferences().get(BLADE_VERSION, null);
        if (defaultBladeVersion != null) {
            try {
                return BladeVersion.valueOf(defaultBladeVersion);
            } catch (IllegalArgumentException ex) {
                // ignored
            }
        }
        return BladeVersion.getDefault();
    }

    public void setDefaultBladeVersion(BladeVersion bladeVersion) {
        getPreferences().put(BLADE_VERSION, bladeVersion.name());
    }
    
    public void setCompilerPathList(DefaultListModel<String> list){
        String includePath = UiOptionsUtils.encodeToStrings(list.elements());
        getPreferences().put(COMPILER_PATH_LIST, includePath);
    }
    
    public void setViewsPathList(DefaultListModel<String> list){
        String includePath = UiOptionsUtils.encodeToStrings(list.elements());
        getPreferences().put(VIEW_PATH_LIST, includePath);
    }
    
    public DefaultListModel<String> getModelCompilerPathList(){
        return getModelPathList(COMPILER_PATH_LIST);
    }
    
    public DefaultListModel<String> getModelViewsPathList(){
        return getModelPathList(VIEW_PATH_LIST);
    }
    
    private DefaultListModel<String> getModelPathList(String pathName){
        DefaultListModel<String> model = new DefaultListModel<>();
        String encodedCompilerPathList = getPreferences().get(pathName, null);
        String[] paths;

        if (encodedCompilerPathList != null){
            paths = encodedCompilerPathList.split("\\|", -1);
        } else {
            return model;
        }
        if (paths.length == 0){
            return model;
        }
        
        for (String path : paths){
            model.addElement(path);
        }
        
        return model;
    }
    
    public String[] getCompilerPathList(){
        String encodedCompilerPathList = getPreferences().get(COMPILER_PATH_LIST, null);
        String[] paths = new String[]{};
        if (encodedCompilerPathList != null){
            return encodedCompilerPathList.split("\\|", -1);
        }
        return paths;
    }
    
    public String[] getViewsPathList(){
        String encodedCompilerPathList = getPreferences().get(VIEW_PATH_LIST, null);
        String[] paths = new String[]{};
        if (encodedCompilerPathList != null){
            return encodedCompilerPathList.split("\\|", -1);
        }
        return paths;
    }
    
    public void addPreferenceChangeListener(PreferenceChangeListener preferenceChangeListener) {
        getPreferences().addPreferenceChangeListener(preferenceChangeListener);
    }

    public void removePreferenceChangeListener(PreferenceChangeListener preferenceChangeListener) {
        getPreferences().removePreferenceChangeListener(preferenceChangeListener);
    }

}
