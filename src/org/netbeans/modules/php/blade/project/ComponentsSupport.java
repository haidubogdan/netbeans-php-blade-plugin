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

import java.io.File;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.components.ComponentModel;
import org.netbeans.modules.php.blade.editor.components.annotation.Namespace;
import org.netbeans.modules.php.blade.editor.components.annotation.NamespaceRegister;
import org.netbeans.modules.php.blade.editor.parser.ParsingUtils;
import org.netbeans.modules.php.blade.editor.path.BladePathUtils;
import static org.netbeans.modules.php.blade.editor.path.BladePathUtils.BLADE_VIEW_METHODS;
import org.netbeans.modules.php.blade.syntax.StringUtils;
import org.netbeans.modules.php.editor.parser.PHPParseResult;
import org.netbeans.modules.php.editor.parser.astnodes.ASTNode;
import org.netbeans.modules.php.editor.parser.astnodes.ClassDeclaration;
import org.netbeans.modules.php.editor.parser.astnodes.Expression;
import org.netbeans.modules.php.editor.parser.astnodes.FormalParameter;
import org.netbeans.modules.php.editor.parser.astnodes.FunctionInvocation;
import org.netbeans.modules.php.editor.parser.astnodes.MethodDeclaration;
import org.netbeans.modules.php.editor.parser.astnodes.Scalar;
import org.netbeans.modules.php.editor.parser.astnodes.visitors.DefaultVisitor;
import org.openide.filesystems.FileChangeAdapter;
import org.openide.filesystems.FileChangeListener;
import org.openide.filesystems.FileEvent;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Cancellable;
import org.openide.util.RequestProcessor;

/**
 *
 * Laravel Project support for blade components
 * 
 * At the first action request for a blade component tag completion or decl finder the scan for blade components configuration will be triggered.
 * 
 * The usage of ComponentModels collection is to have information about the file and custom attributes
 * 
 * @author bogdan
 */

//list of most common laravel framework directory paths for blade components classes
@NamespaceRegister({
    @Namespace(path = "App\\View\\Components", fromApp = true, relativeFilePath = "app/View/Components"),
    @Namespace(path = "App\\Http\\Livewire", fromApp = true, relativeFilePath = "app/Http/Livewire"),
    @Namespace(path = "App\\Livewire", fromApp = true, relativeFilePath = "app/Livewire"),//from 10
    @Namespace(path = "Illuminate\\Console\\View\\Components"),
    @Namespace(path = "BladeUI\\Icons\\Components", packageName = "blade-ui-kit/blade-icons", relativeFilePath = "blade-ui-kit/blade-icons/src/Components"),
    @Namespace(path = "BladeUIKit\\Components", packageName = "blade-ui-kit/blade-ui-kit", relativeFilePath = "blade-ui-kit/blade-ui-kit/src/Components"),})
public class ComponentsSupport {

    public static final String COMPONENT_TAG_NAME_PREFIX = "x-"; //NOI18N
    public static final String COMPONENT_TAG_PREFIX = "<" + COMPONENT_TAG_NAME_PREFIX; //NOI18N
    public static final int COMPONENT_TAG_PREFIX_LENGTH = COMPONENT_TAG_PREFIX.length();

    private final Map<FileObject, Namespace> installedComponentNamespace = new HashMap<>();
    
    private static final RequestProcessor RP = new RequestProcessor(ComponentsSupport.class);
    private static final AtomicBoolean installationScan = new AtomicBoolean(false);
    private final Project project;

    private final Map<FileObject, ComponentModel> componentClassCollection = new HashMap<>();

    private final FileChangeListener fileChangeListener = new FileChangeListenerImpl();
    
    private ComponentsSupport(Project project) {
        this.project = project;
    }

    public static ComponentsSupport getInstance(Project project) {
        return new ComponentsSupport(project);
    }
        
    public static ComponentsSupport forProject(Project project) {
        return BladeProjectSupport.getProjectSupport(project)
                .getComponentsSupport();
    }

    public void scanForInstalledComponents() {
        for (Namespace namespace : getRegisteredNamespaces()) {
            FileObject fo = null;
            if (namespace.fromApp()) {
                //check if folder exists
                fo = project.getProjectDirectory().getFileObject(namespace.relativeFilePath());
            } else if (namespace.relativeFilePath() != null && namespace.relativeFilePath().length() > 0) {
                fo = project.getProjectDirectory().getFileObject("vendor/" + namespace.relativeFilePath()); // NOI18N

            }
            if (fo == null || !fo.isValid()) {
                continue;
            }
            installedComponentNamespace.put(fo, namespace);
            RP.submit(new ComponentParsingTask(fo, componentClassCollection));
        }

        installationScan.set(true);
    }

    public void scanCustomComponentsFolders() {
        BladeProjectProperties bladeProperties = BladeProjectProperties.forProject(project);
        String componentsFolder[] = bladeProperties.getBladeComponentsClassPathList();
        for (String folder : componentsFolder) {
            if (folder.length() == 0) {
                continue;
            }
            File folderFile = new File(folder);
            if (!folderFile.exists()) {
                continue;
            }
            
            FileObject folderObj = FileUtil.toFileObject(folderFile);
            RP.submit(new ComponentParsingTask(folderObj, componentClassCollection));
            try {
                FileUtil.addRecursiveListener(fileChangeListener, folderFile);
            } catch (IllegalArgumentException ex) {
                //already listening
            }
            
        }
    }

    public void scanBladeComponentsClassFolder(File folder) {
        FileObject folderObj = FileUtil.toFileObject(folder);
        RP.submit(new ComponentParsingTask(folderObj, componentClassCollection));
        try {
            FileUtil.addRecursiveListener(fileChangeListener, folder);
        } catch (IllegalArgumentException ex) {
            //already listening
        }
    }

    public boolean isScanned() {
        return installationScan.get();
    }

    public Map<FileObject, Namespace> getInstalledComponentNamespace() {
        return installedComponentNamespace;
    }

    public Namespace[] getRegisteredNamespaces() {
        NamespaceRegister namespaceRegister = this.getClass().getAnnotation(NamespaceRegister.class);
        return namespaceRegister.value();
    }

    public Map<FileObject, ComponentModel> getComponentClassCollection() {
        return componentClassCollection;
    }

    public ComponentModel findComponentClass(FileObject file) {
        return componentClassCollection.get(file);
    }

    public static String tag2ClassName(String identifier) {
        return identifier.length() > COMPONENT_TAG_PREFIX_LENGTH ? StringUtils.kebabToCamel(identifier.substring(COMPONENT_TAG_PREFIX_LENGTH)) : ""; // NOI18N
    }
    
    public void warmup() {
        if (!isScanned()) {
            scanForInstalledComponents();
            scanCustomComponentsFolders();
        }
    }
    
    private void parseComponentFile(FileObject file, Map<FileObject, ComponentModel> componentCollection) {
        ParsingUtils parsingUtils = new ParsingUtils();
        parsingUtils.parseFileObject(file);
        PHPParseResult result = parsingUtils.getParserResult();
        if (result != null) {
            ComponentModel model = new ComponentModel(file);
            result.getProgram().accept(new ComponentModelVisitor(model));
            if (model.isValid()) {
                componentCollection.put(file, model);
            }
        }
    }

    private final class ComponentParsingTask implements Runnable, Cancellable {

        private final FileObject root;
        private volatile boolean cancelled;
        private volatile Future<Void> future;
        private final Map<FileObject, ComponentModel> componentCollection;

        private ComponentParsingTask(FileObject root, Map<FileObject, ComponentModel> componentCollection) {
            this.root = root;
            this.componentCollection = componentCollection;
        }

        @Override
        public void run() {
            //recursive search
            Enumeration<? extends FileObject> children = root.getChildren(true);
            while (children.hasMoreElements()) {
                FileObject file = children.nextElement();
                if (!BladePathUtils.isValidPhpFile(file)) {
                    continue;
                }
                if (!cancelled) {
                    parseComponentFile(file, componentCollection);
                } else {
                    installationScan.set(false);
                }
            }
        }

        @Override
        public boolean cancel() {
            cancelled = true;
            if (future != null) {
                future.cancel(true);
            }
            return true;
        }
    }

    private class ComponentModelVisitor extends DefaultVisitor {

        private final ComponentModel model;

        public ComponentModelVisitor(ComponentModel model) {
            this.model = model;
        }

        @Override
        public void scan(ASTNode node) {
            if (node != null) {
                super.scan(node);
            }
        }

        @Override
        public void visit(ClassDeclaration node) {
            super.visit(node);
            Expression superClass = node.getSuperClass();
            String superClassName = sanitazeClassName(superClass.toString());
            model.checkClassValidity(superClassName);
        }

        @Override
        public void visit(MethodDeclaration node) {
            if (node.getFunction() == null){
                return;
            }
            String functionName = node.getFunction().getFunctionName().getName();
            if (functionName.equals("__construct")){ // NOI18N
                List<FormalParameter> formalParameters = node.getFunction().getFormalParameters();
                for (FormalParameter parameter : formalParameters){
                    model.addConstructorProperty(parameter);
                }
            } else if (functionName.equals("render")) {
                //scan for view paths
                super.visit(node);
            }
        }
        
        @Override
        public void visit(FunctionInvocation node) {
            String functionName = node.getFunctionName().getName().toString().replace("\\", "");

            if (!Arrays.stream(BLADE_VIEW_METHODS).anyMatch(functionName::equals)) {
                return;
            }
            
            List<Expression> parameters = node.getParameters();
            Iterator<?> iter = parameters.iterator();
            Expression viewPath = (Expression) iter.next();
            if (viewPath != null && viewPath instanceof Scalar) {
                Scalar name = (Scalar) viewPath;
                String escapedViewPath = name.getStringValue().replaceAll("^[\"|\']|[\"|[\']]$", ""); // NOI18N
                model.setViewPath(escapedViewPath);
            }
        }

        @Override
        public void visit(FormalParameter node) {
            //short constructor
            model.addConstructorProperty(node);
        }

        private String sanitazeClassName(String className) {
            return className.replace("\\", ""); // NOI18N
        }
    }

    private final class FileChangeListenerImpl extends FileChangeAdapter {

        @Override
        public void fileFolderCreated(FileEvent fe) {

        }

        @Override
        public void fileChanged(FileEvent fe) {
            processFile(fe.getFile());
        }

        @Override
        public void fileDataCreated(FileEvent fe) {

        }

        private void processFile(FileObject file) {
            assert file.isData() : file;
            parseComponentFile(file, componentClassCollection);
        }

    }
    
}
