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
package org.netbeans.modules.php.blade.editor.directives;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.api.project.Project;
import org.netbeans.modules.csl.api.DeclarationFinder;
import org.netbeans.modules.php.blade.editor.parser.ParsingUtils;
import org.netbeans.modules.php.blade.editor.path.BladePathUtils;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.netbeans.modules.php.blade.project.BladeProjectSupport;
import static org.netbeans.modules.php.blade.project.BladeProjectSupport.APP_PROVIDER_RELATIVE_PATH;
import static org.netbeans.modules.php.blade.syntax.BladeDirectivesUtils.AT;
import static org.netbeans.modules.php.blade.syntax.BladeDirectivesUtils.DIRECTIVE_ELSE;
import static org.netbeans.modules.php.blade.syntax.BladeDirectivesUtils.DIRECTIVE_UNLESS;
import static org.netbeans.modules.php.blade.syntax.BladeDirectivesUtils.END_DIRECTIVE_PREFIX;
import org.netbeans.modules.php.editor.parser.PHPParseResult;
import org.netbeans.modules.php.editor.parser.astnodes.Expression;
import org.netbeans.modules.php.editor.parser.astnodes.FunctionInvocation;
import org.netbeans.modules.php.editor.parser.astnodes.Scalar;
import org.openide.filesystems.FileChangeAdapter;
import org.openide.filesystems.FileChangeListener;
import org.openide.filesystems.FileEvent;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 * TODO add a factory
 *
 * @author bhaidu
 */
public final class CustomDirectives {

    private final Project project;
    private final Map<FileObject, List<CustomDirective>> customDirectives = new LinkedHashMap<>();

    public List<CustomDirective> customDirectiveList = new ArrayList<>();

    private final FileChangeListener fileChangeListener = new FileChangeListenerImpl();

    private static final Logger LOGGER = Logger.getLogger(CustomDirectives.class.getName());

    public static CustomDirectives getInstance(Project project) {
        return new CustomDirectives(project);
    }

    public static CustomDirectives forProject(Project project) {
        return BladeProjectSupport.getProjectSupport(project)
                .getCustomDirectives();
    }

    private CustomDirectives(Project project) {
        this.project = project;
        extractCustomDirectives();
        LOGGER.log(Level.INFO, "Finished extracting directives. Found ({0})", customDirectives.size()); // NOI18N
    }

    private void extractCustomDirectives() {
        LOGGER.info("Extracting custom directives");
        String[] compilerPathList = BladeProjectProperties.forProject(project).getCompilerPathList();
        FileObject projectDir = project.getProjectDirectory();
        String dirPathName = projectDir.getName();
        FileObject defaultAppProvider = projectDir.getFileObject(APP_PROVIDER_RELATIVE_PATH);

        if (defaultAppProvider != null) {
            extractCustomDirectivesFromFile(defaultAppProvider);
            defaultAppProvider.addFileChangeListener(fileChangeListener);
        }

        if (compilerPathList == null || compilerPathList.length == 0) {
            return;
        }

        for (String path : compilerPathList) {
            if (path.equals("")) { // NOI18N
                continue;
            }

            //if the absolute path doesn't contain the project name
            //we can asume the path is relative
            if (!path.contains(dirPathName)) {
                FileObject providerFo = projectDir.getFileObject(path);
                if (!BladePathUtils.isValidPhpFile(providerFo)) {
                    continue;
                }
                providerFo.addFileChangeListener(fileChangeListener);
                extractCustomDirectivesFromFile(providerFo);
                continue;
            }

            File file = new File(path);
            if (!file.exists()) {
                //do nothing
                continue;
            }

            FileUtil.addRecursiveListener(fileChangeListener, file);
            FileObject fileObj = FileUtil.toFileObject(file);
            extractCustomDirectivesFromFile(fileObj);
        }

    }

    private void rescanFile(FileObject file) {
        extractCustomDirectivesFromFile(file);
    }

    private void extractCustomDirectivesFromFile(FileObject file) {
        ParsingUtils parsingUtils = new ParsingUtils();
        parsingUtils.parseFileObject(file);
        FunctionInvocationVisitor functionInvocationVisitor = new FunctionInvocationVisitor();
        PHPParseResult parserResult = parsingUtils.getParserResult();

        if (parserResult != null && parserResult.getProgram() != null) {
            parserResult.getProgram().accept(functionInvocationVisitor);
            List<CustomDirective> directiveList = functionInvocationVisitor.getDirectives();

            if (directiveList.isEmpty()) {
                return;
            }

            customDirectiveList.addAll(directiveList);
            customDirectives.put(file, directiveList);
        }
    }

    public Map<FileObject, List<CustomDirective>> getCustomDirectives() {
        return customDirectives;
    }

    public void filterAction(FilterCallback callback) {
        for (Map.Entry<FileObject, List<CustomDirective>> entry : customDirectives.entrySet()) {
            if (!entry.getKey().isValid()) {
                continue;
            }

            for (CustomDirective directive : entry.getValue()) {
                callback.filterDirectiveName(directive, entry.getKey());
            }

        }
    }

    public void filterAction(FilterCallbackDeclaration callback) {
        for (Map.Entry<FileObject, List<CustomDirective>> entry : customDirectives.entrySet()) {
            if (!entry.getKey().isValid()) {
                continue;
            }

            for (CustomDirective directive : entry.getValue()) {
                callback.filterDirectiveName(directive, entry.getKey());
            }

        }
    }

    public boolean customDirectiveConfigured(String query) {
        for (CustomDirectives.CustomDirective customDirective : customDirectiveList) {
            if (customDirective.name.equals(query)) {
                return true;
            }
        }
        return false;
    }

    public class DirectiveNames {

        private final List<String> directiveNames;

        public DirectiveNames(List<String> directiveNames) {
            this.directiveNames = directiveNames;
        }

        public List<String> getList() {
            return directiveNames;
        }
    }

    /**
     * we are scanning the php ast nodes to search for the use of directive
     * method the first parameter of the called method will be the custom
     * directive name
     */
    private class FunctionInvocationVisitor extends org.netbeans.modules.php.editor.parser.astnodes.visitors.DefaultVisitor {

        private final String[] validFunctions = new String[]{"directive", "if"}; // NOI18N
        private final List<CustomDirective> directives;

        public FunctionInvocationVisitor() {
            this.directives = new ArrayList<>();
        }

        @Override
        public void scan(org.netbeans.modules.php.editor.parser.astnodes.ASTNode node) {
            if (node != null) {
                super.scan(node);
            }
        }

        @Override
        public void visit(FunctionInvocation node) {
            String functionName = node.getFunctionName().toString();

            if (!Arrays.stream(validFunctions).anyMatch(functionName::equals)) {
                //in case of callback config
                super.visit(node);
                return;
            }
            List<Expression> parameters = node.getParameters();
            Iterator<?> iter = parameters.iterator();
            Expression directiveName = (Expression) iter.next();
            if (directiveName != null && directiveName instanceof Scalar) {
                Scalar name = (Scalar) directiveName;
                String escapedDirectiveName = name.getStringValue().replaceAll("^[\"|\']|[\"|[\']]$", ""); // NOI18N

                //Custom If Statements
                if (functionName.equals("if")) { // NOI18N
                    directives.add(new CustomDirective(AT + escapedDirectiveName, name.getStartOffset(), true));
                    directives.add(new CustomDirective(DIRECTIVE_UNLESS + escapedDirectiveName, name.getStartOffset())); // NOI18N
                    directives.add(new CustomDirective(DIRECTIVE_ELSE + escapedDirectiveName, name.getStartOffset()));
                    directives.add(new CustomDirective(END_DIRECTIVE_PREFIX + escapedDirectiveName, name.getStartOffset()));
                } else {
                    directives.add(new CustomDirective(AT + escapedDirectiveName, name.getStartOffset()));
                }
            }
        }

        public List<CustomDirective> getDirectives() {
            return directives;
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

        @Override
        public void fileDeleted(FileEvent fe) {
            //reset list
            customDirectiveList = new ArrayList<>();
        }

        private void processFile(FileObject file) {
            assert file.isData() : file;
            CustomDirectives.forProject(project).rescanFile(file);
        }

    }

    public static interface FilterCallback {

        public void filterDirectiveName(CustomDirective directive, FileObject file);
    }

    public static abstract class FilterCallbackDeclaration {

        protected DeclarationFinder.DeclarationLocation location;

        public FilterCallbackDeclaration(DeclarationFinder.DeclarationLocation location) {
            this.location = location;
        }

        public void filterDirectiveName(CustomDirective directive, FileObject file) {
        }
    }

    public static class CustomDirective {

        private final String name;
        private final int offset;
        private final boolean isBlockDirective;

        public CustomDirective(String name, int offset) {
            this(name, offset, false);
        }

        public CustomDirective(String name) {
            this(name, 0, false);
        }

        public CustomDirective(String name, int offset, boolean isBlock) {
            this.name = name;
            this.offset = offset;
            this.isBlockDirective = isBlock;
        }

        public String getName() {
            return name;
        }

        public int getOffset() {
            return offset;
        }

        public boolean isBlockDirective() {
            return isBlockDirective;
        }
    }
}
