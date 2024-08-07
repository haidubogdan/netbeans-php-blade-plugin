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

import java.util.HashMap;
import java.util.Map;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.components.annotation.Namespace;
import org.netbeans.modules.php.blade.editor.components.annotation.NamespaceRegister;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bogdan
 */
@NamespaceRegister({
    @Namespace(path = "App\\View\\Components", from_app = true, relativeFilePath = "app/View/Components"),
    @Namespace(path = "App\\Http\\Livewire", from_app = true, relativeFilePath = "app/Http/Livewire"),
    @Namespace(path = "App\\Livewire", from_app = true, relativeFilePath = "app/Livewire"),//from 10
    @Namespace(path = "Illuminate\\Console\\View\\Components"),
    @Namespace(path = "BladeUI\\Icons\\Components", packageName = "blade-ui-kit/blade-icons"),
    @Namespace(path = "BladeUIKit\\Components", packageName = "blade-ui-kit/blade-ui-kit"),
 })
public class ComponentsSupport {

    private static final Map<Project, ComponentsSupport> INSTANCES = new HashMap<>();
    private final Map<FileObject, Namespace> installedComponentNamespace = new HashMap<>();
    private boolean scanned = false;
    public Project project;

    private ComponentsSupport(Project project) {
        this.project = project;
    }

    public static ComponentsSupport getInstance(Project project) {
        if (INSTANCES.containsKey(project)) {
            return INSTANCES.get(project);
        }
        ComponentsSupport instance = new ComponentsSupport(project);
        INSTANCES.put(project, instance);
        return instance;
    }

    public void scanForInstalledComponents() {
        for (Namespace namespace : getRegisteredNamespaces()) {
            FileObject fo;
            if (namespace.from_app()) {
                //check if folder exists
                fo = project.getProjectDirectory().getFileObject(namespace.relativeFilePath());
            } else {
                fo = project.getProjectDirectory().getFileObject("vendor/" + namespace.relativeFilePath());

            }
            if (fo == null || !fo.isValid()) {
                continue;
            }
            installedComponentNamespace.put(fo, namespace);
        }
        scanned = true;
    }

    public boolean isScanned() {
        return scanned;
    }

    public Map<FileObject, Namespace> getInstalledComponentNamespace() {
        return installedComponentNamespace;
    }

    public Namespace[] getRegisteredNamespaces() {
        NamespaceRegister namespaceRegister = this.getClass().getAnnotation(NamespaceRegister.class);
        return namespaceRegister.value();
    }
}
