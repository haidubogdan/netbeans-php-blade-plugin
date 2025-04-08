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

import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.directives.CustomDirectives;
import org.netbeans.spi.project.ProjectServiceProvider;
import org.netbeans.spi.project.ui.ProjectOpenedHook;

/**
 *
 * @author bhaidu
 */
public class BladeProjectSupport extends ProjectOpenedHook {

    public static final String APP_PROVIDER_RELATIVE_PATH = "app/Providers/AppServiceProvider.php"; // NOI18N
    private final Project project;

    private BladeProjectProperties bladeProjectProperties;
    private ComponentsSupport componentsSupport;
    private CustomDirectives customDirective;

    private BladeProjectSupport(Project project) {
        assert project != null;
        this.project = project;
    }

    private static BladeProjectSupport create(Project project) {
        return new BladeProjectSupport(project);
    }

    public static BladeProjectSupport getProjectSupport(Project project) {
        assert project != null;
        BladeProjectSupport bps = project.getLookup().lookup(BladeProjectSupport.class);
        if (bps == null) {
            //log
            return create(project);
        }
        return bps;
    }

    @ProjectServiceProvider(service = ProjectOpenedHook.class, projectType = "org-netbeans-modules-php-project") // NOI18N
    public static BladeProjectSupport forPhpProject(Project project) {
        return create(project);
    }

    @ProjectServiceProvider(service = ProjectOpenedHook.class, projectType = "org-netbeans-modules-web-project") // NOI18N
    public static BladeProjectSupport forWebProject(Project project) {
        return create(project);
    }

    @Override
    protected void projectOpened() {
        bladeProjectProperties = BladeProjectProperties.getInstance(project);
        customDirective = CustomDirectives.getInstance(project);
        componentsSupport = ComponentsSupport.getInstance(project);
    }

    @Override
    protected void projectClosed() {
    }

    public BladeProjectProperties getBladeProjectProperties() {
        return bladeProjectProperties;
    }

    public CustomDirectives getCustomDirectives() {
        return customDirective;
    }

    public ComponentsSupport getComponentsSupport() {
        return componentsSupport;
    }
}
