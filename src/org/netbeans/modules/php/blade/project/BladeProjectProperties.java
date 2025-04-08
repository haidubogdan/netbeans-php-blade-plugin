/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.php.blade.project;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.prefs.Preferences;
import javax.swing.DefaultListModel;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.modules.php.blade.editor.ui.customizer.UiOptionsUtils;
import org.netbeans.modules.php.blade.syntax.StringUtils;
import org.netbeans.spi.project.support.ant.AntProjectHelper;
import org.netbeans.spi.project.support.ant.EditableProperties;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;
import org.openide.util.Mutex;
import org.openide.util.MutexException;
import org.openide.util.NbPreferences;

/**
 *
 *
 * @author Haidu Bogdan
 */
public final class BladeProjectProperties {

    private final Project project;
    private static final String DIRECTIVE_CUSTOMIZER_PATH_LIST = "directive_customizer.path.list"; // NOI18N
    private static final String VIEW_PATH_LIST = "views.path.list"; // NOI18N
    private static final String BLADE_COMPONENT_CLASS_FOLDER_LIST = "blade_component_class.folder.list"; // NOI18N
    private static final String NON_LARAVEL_DECL_FINDER = "non_laravel.decl.finder"; // NOI18N

    private DefaultListModel<String> directiveCustomizerPathList = new DefaultListModel();
    private DefaultListModel<String> viewsPathList = new DefaultListModel();
    private DefaultListModel<String> bladeComponentsClassFolderList = new DefaultListModel();
    // enable declaration finder outside of framework plugin
    private final AtomicBoolean nonLaravelDeclFinder = new AtomicBoolean(false);
    // the pipe "|" char needs to be escaped
    public static final String ESCAPED_VIEW_PATH_SEPARATOR = "\\|"; // NOI18N
    
    private final EditableProperties editableProperties;

    public BladeProjectProperties(Project project) {
        this.project = project;
        this.editableProperties = getPublicProperties();
        initModelsFromPreferences();
    }

    public static BladeProjectProperties getInstance(Project project) {
        return new BladeProjectProperties(project);
    }

    public static BladeProjectProperties forProject(Project project) {
        return BladeProjectSupport.getProjectSupport(project)
                .getBladeProjectProperties();
    }

    private Preferences getPreferences() {
        if (project != null) {
            return ProjectUtils.getPreferences(project, this.getClass(), false);
        }
        return NbPreferences.forModule(this.getClass());
    }

    private void initModelsFromPreferences() {
        directiveCustomizerPathList = createModelForDirectiveCusomizerPathList();
        viewsPathList = createModelForViewsPathList();
        if (editableProperties.getProperty(NON_LARAVEL_DECL_FINDER) != null) {
            nonLaravelDeclFinder.set(Boolean.parseBoolean(editableProperties.getProperty(NON_LARAVEL_DECL_FINDER)));
        } else {
            nonLaravelDeclFinder.set(getPreferences().getBoolean(NON_LARAVEL_DECL_FINDER, false));
        }
        this.bladeComponentsClassFolderList = createModelForBladeComponentFolderList();
    }

    public void storeDirectiveCustomizerPaths() {
        String includePath = UiOptionsUtils.encodeToStrings(directiveCustomizerPathList.elements());
        getPreferences().put(DIRECTIVE_CUSTOMIZER_PATH_LIST, includePath);
        putPublicProperty(DIRECTIVE_CUSTOMIZER_PATH_LIST, includePath);
    }

    public void storeViewsPaths() {
        String includePath = UiOptionsUtils.encodeToStrings(viewsPathList.elements());
        getPreferences().put(VIEW_PATH_LIST, includePath);
        putPublicProperty(VIEW_PATH_LIST, includePath);
    }

    public void storeBladeComponentsFolder() {
        String includePath = UiOptionsUtils.encodeToStrings(bladeComponentsClassFolderList.elements());
        getPreferences().put(BLADE_COMPONENT_CLASS_FOLDER_LIST, includePath);
        putPublicProperty(BLADE_COMPONENT_CLASS_FOLDER_LIST, includePath);
    }

    public void storeNonLaravelDeclFinderFlag(boolean status) {
        nonLaravelDeclFinder.set(status);
        getPreferences().putBoolean(NON_LARAVEL_DECL_FINDER, status);
        putBooleanProperty(NON_LARAVEL_DECL_FINDER, status);
    }

    public void addDirectiveCustomizerPath(String path) {
        directiveCustomizerPathList.addElement(path);
    }

    public void addViewsPath(String path) {
        viewsPathList.addElement(path);
    }

    public void removeCustomizerPath(int index) {
        directiveCustomizerPathList.remove(index);
    }

    public void removeViewsPath(int index) {
        viewsPathList.remove(index);
    }

    public DefaultListModel<String> createModelForDirectiveCusomizerPathList() {
        return createModelFromPreferences(DIRECTIVE_CUSTOMIZER_PATH_LIST);
    }

    public DefaultListModel<String> createModelForViewsPathList() {
        return createModelFromPreferences(VIEW_PATH_LIST);
    }

    public DefaultListModel<String> getModelForDirectiveCusomizerPathList() {
        return directiveCustomizerPathList;
    }

    public DefaultListModel<String> getModelViewsPathList() {
        return viewsPathList;
    }

    public boolean getNonLaravelDeclFinderFlag() {
        return nonLaravelDeclFinder.get();
    }

    //blade components
    public void addCustomBladeComponentClassFolder(String path) {
        bladeComponentsClassFolderList.addElement(path);
    }

    public void removeCustomBladeComponentClassFolder(int index) {
        bladeComponentsClassFolderList.remove(index);
    }

    public DefaultListModel<String> createModelForBladeComponentFolderList() {
        return createModelFromPreferences(BLADE_COMPONENT_CLASS_FOLDER_LIST);
    }

    public DefaultListModel<String> getModelForBladeComponentsClassFolderList() {
        return bladeComponentsClassFolderList;
    }

    private DefaultListModel<String> createModelFromPreferences(String configName) {
        DefaultListModel<String> model = new DefaultListModel<>();
        String encodedCompilerPathList = getMixedSourceProjectProperty(configName);

        String[] paths;

        if (encodedCompilerPathList != null) {
            paths = encodedCompilerPathList.split(ESCAPED_VIEW_PATH_SEPARATOR, -1);
        } else {
            return model;
        }
        if (paths.length == 0) {
            return model;
        }

        String projectDirectory = project.getProjectDirectory().getPath() + StringUtils.FORWARD_SLASH;

        for (String path : paths) {
            //sanitize for public properties
            String relativePath = path.replace(StringUtils.BACK_DASH, StringUtils.FORWARD_SLASH).replace(projectDirectory, "");
            model.addElement(relativePath);
        }

        return model;
    }

    public String[] getCompilerPathList() {
        String encodedCompilerPathList = getMixedSourceProjectProperty(DIRECTIVE_CUSTOMIZER_PATH_LIST);
        String[] paths = new String[]{};
        if (encodedCompilerPathList != null) {
            return encodedCompilerPathList.split(ESCAPED_VIEW_PATH_SEPARATOR, -1);
        }
        return paths;
    }

    public String[] getViewsFolderPathList() {
        String encodedViewsFolderPathList = getMixedSourceProjectProperty(VIEW_PATH_LIST);
        String[] paths = new String[]{};
        if (encodedViewsFolderPathList != null) {
            return encodedViewsFolderPathList.split(ESCAPED_VIEW_PATH_SEPARATOR, -1);
        }
        return paths;
    }

    public String[] getBladeComponentsClassPathList() {
        String encodedBladeComponentFolderPathList = getMixedSourceProjectProperty(BLADE_COMPONENT_CLASS_FOLDER_LIST);

        String[] paths = new String[]{};
        if (encodedBladeComponentFolderPathList != null) {
            return encodedBladeComponentFolderPathList.split(ESCAPED_VIEW_PATH_SEPARATOR, -1);
        }
        return paths;
    }

    private void putBooleanProperty(String property, boolean value) {
        putPublicProperty(property, String.valueOf(value));
    }

    public void putPublicProperty(String property, String value) {
        editableProperties.setProperty(property, value);
        try {
            storeEditableProperties(project, AntProjectHelper.PROJECT_PROPERTIES_PATH, editableProperties);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private EditableProperties getPublicProperties() {
        AntProjectHelper helper = project.getLookup().lookup(AntProjectHelper.class);
        return helper.getProperties(AntProjectHelper.PROJECT_PROPERTIES_PATH);
    }
    
    private String getMixedSourceProjectProperty(String property) {
        String publicProperty = editableProperties.getProperty(property);
        return publicProperty != null ? publicProperty : getPreferences().get(property, null);
    }

    //save public properties
    private static void storeEditableProperties(final Project prj, final String propertiesPath, final EditableProperties ep)
            throws IOException {
        try {
            ProjectManager.mutex().writeAccess(new Mutex.ExceptionAction<Void>() {
                @Override
                public Void run() throws IOException {
                    FileObject propertiesFo = prj.getProjectDirectory().getFileObject(propertiesPath);
                    if (propertiesFo != null) {
                        OutputStream os = null;
                        try {
                            os = propertiesFo.getOutputStream();
                            ep.store(os);
                        } finally {
                            if (os != null) {
                                os.close();
                            }
                        }
                    }
                    return null;
                }
            });
        } catch (MutexException ex) {
        }
    }
}
