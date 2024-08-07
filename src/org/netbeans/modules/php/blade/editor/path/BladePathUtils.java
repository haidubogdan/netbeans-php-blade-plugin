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
package org.netbeans.modules.php.blade.editor.path;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.netbeans.spi.project.ui.support.ProjectConvertors;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author bogdan
 */
public class BladePathUtils {

    public static final String LARAVEL_VIEW_PATH = "resources/views"; //NOI18N
    public static final String BLADE_EXT = ".blade.php"; //NOI18N

    /**
     * first we need to extract the root folder of view after we apply a generic
     * path sanitize for blade paths (ex "my.path" -> "my/path.blade.php")
     *
     * @param contextFile
     * @param viewPath
     * @return List<FileObject>
     */
    public static List<FileObject> findFileObjectsForBladeViewPath(FileObject contextFile, String viewPath) {
        List<FileObject> fileViewAssociationList = new ArrayList<>();
        Project project = ProjectConvertors.getNonConvertorOwner(contextFile);

        if (project == null) {
            return fileViewAssociationList;
        }

        HashSet<FileObject> viewRoots = getDefaultRoots(project);
        viewRoots.addAll(getCustomViewsRoots(project, contextFile));

        if (viewRoots.isEmpty()) {
            return fileViewAssociationList;
        }

        String sanitizedBladePath = viewPathToFilePath(viewPath); //NOI18N

        for (FileObject viewRoot : viewRoots) {
            FileObject includedFile = viewRoot.getFileObject(sanitizedBladePath, true);

            if (includedFile != null && includedFile.isValid()) {
                fileViewAssociationList.add(includedFile);
            }
        }

        return fileViewAssociationList;
    }

    public static FileObject findFileObjectForBladeViewPath(FileObject contextFile, String viewPath) {
        FileObject res = null;
        Project project = ProjectConvertors.getNonConvertorOwner(contextFile);

        if (project == null) {
            return res;
        }

        HashSet<FileObject> viewRoots = getDefaultRoots(project);
        viewRoots.addAll(getCustomViewsRoots(project, contextFile));

        if (viewRoots.isEmpty()) {
            return res;
        }

        String sanitizedBladePath = viewPathToFilePath(viewPath);

        for (FileObject viewRoot : viewRoots) {
            FileObject includedFile = viewRoot.getFileObject(sanitizedBladePath, true);

            if (includedFile != null && includedFile.isValid()) {
                return includedFile;
            }
        }

        return res;
    }

    /**
     *
     *
     * @param contextFile
     * @param prefixViewPath
     * @return List<FileObject>
     */
    public static List<FileObject> getParentChildrenFromPrefixPath(FileObject contextFile,
            String prefixViewPath) {
        List<FileObject> list = new ArrayList<>();
        //this should be a fallback
        Project project = ProjectConvertors.getNonConvertorOwner(contextFile);

        if (project == null) {
            return list;
        }

        HashSet<FileObject> viewRoots = getDefaultRoots(project);
        viewRoots.addAll(getCustomViewsRoots(project, contextFile));

        if (viewRoots.isEmpty()) {
            return list;
        }

        String unixPath = prefixViewPath.replace(".", "/");
        int relativeSlash;

        //fix issues with lastIndexOf search
        relativeSlash = unixPath.lastIndexOf("/");

        HashSet<FileObject> filteredViewRoots = new HashSet<>();
        
        Map<String, FileObject> relativeFilePathMap = new HashMap<>();
        
        if (relativeSlash > 0) {
            //filter only relative folders
            for (FileObject rootFolder : viewRoots) {
                FileObject relativeViewRoot = rootFolder.getFileObject(unixPath.substring(0, relativeSlash));

                if (relativeViewRoot != null && relativeViewRoot.isValid()) {
                    relativeFilePathMap.put(unixPath, relativeViewRoot);
                }
            }
        } else {
            //include all root folders
            filteredViewRoots = viewRoots;
        }

        String relativePrefixToCompare;

        if (relativeSlash > 0) {
            //extract the path name prefix
            relativePrefixToCompare = unixPath.substring(relativeSlash+1, unixPath.length());
        } else {
            //root reference
            relativePrefixToCompare = unixPath;
        }

        if (unixPath.endsWith("/")) {
            //add children
            for (FileObject rootFolder : filteredViewRoots) {
                list.addAll(Arrays.asList(rootFolder.getChildren()));
            }
            for (Map.Entry<String, FileObject> entry : relativeFilePathMap.entrySet()){
                list.addAll(Arrays.asList(entry.getValue().getChildren()));
            }
        } else {
            //filter by filename in relative context
            for (FileObject rootFolder : filteredViewRoots) {
                for (FileObject file : rootFolder.getChildren()) {
                    String filePath = file.getPath().replace(rootFolder.getPath() + "/", "");
                    if (filePath.startsWith(relativePrefixToCompare)) {
                        list.add(file);
                    }
                }
            }
            
            for (Map.Entry<String, FileObject> entry : relativeFilePathMap.entrySet()){
                for (FileObject file : entry.getValue().getChildren()) {
                    if (file.getName().startsWith(relativePrefixToCompare)){
                        list.add(file);
                    }
                }
            }
        }

        //empty list
        viewRoots.clear();
        return list;
    }

    public static List<FileObject> getCustomViewsRoots(Project project, FileObject contextFile) {
        List<FileObject> list = new ArrayList<>();

        String[] views = BladeProjectProperties.getInstance(project).getViewsPathList();

        if (views.length > 0) {
            views = Arrays.stream(views).filter(s -> !s.isEmpty()).toArray(String[]::new);
            Arrays.sort(views, (String s1, String s2) -> {
                //clear empty configs
                if (s1 == null || s2 == null) {
                    return 0;
                }
                return s2.length() - s1.length();// comparision
            });
            for (String view : views) {
                if (view.length() == 0) {
                    continue;
                }
                File viewPath = new File(view);
                if (!viewPath.exists()) {
                    continue;
                }

                list.add(FileUtil.toFileObject(viewPath));
            }
        }
        return list;
    }

    public static String toBladeViewPath(FileObject file) {
        String path = null;
        Project project = ProjectUtils.getMainOwner(file);

        if (project == null) {
            return path;
        }

        String filePath = file.getPath();
        FileObject defaultLaravelPath = project.getProjectDirectory().getFileObject(LARAVEL_VIEW_PATH);

        if (defaultLaravelPath != null) {
            //belongs to the default folder
            String viewFolderPath = defaultLaravelPath.getPath();
            if (filePath.startsWith(viewFolderPath)) {
                String bladePath = BladePathUtils.toBladeViewPath(filePath.replace(viewFolderPath, ""));
                //starting slash
                if (bladePath.startsWith(".")) {
                    bladePath = bladePath.substring(1, bladePath.length());
                }
                return bladePath;
            }
        }

        String[] viewFolders = BladeProjectProperties.getInstance(project).getViewsPathList();

        for (String viewFolder : viewFolders) {
            if (viewFolder.length() == 0) {
                continue;
            }
            File viewPath = new File(viewFolder);
            if (!viewPath.exists()) {
                continue;
            }

            //we need to keep the same format
            FileObject viewFile = FileUtil.toFileObject(viewPath);
            String viewFileAbsPath = viewFile.getPath();
            if (filePath.startsWith(viewFileAbsPath)) {
                String relativePath = filePath.replace(viewFileAbsPath, "");
                if (!relativePath.startsWith("/")) {
                    //it doesn't belong to the folder
                    continue;
                }
                return BladePathUtils.toBladeViewPath(relativePath.substring(1));
            }
        }

        return path;
    }
    
    public static String getRelativeProjectPath(FileObject currentFile){
        Project projectOwner = ProjectConvertors.getNonConvertorOwner(currentFile);
        if (projectOwner == null){
            return "";
        }
        
        String dirPath = projectOwner.getProjectDirectory().getPath();
        String relativePath = currentFile.getPath().replace(dirPath, "");

        //only if we found the relative project path
        if (currentFile.getPath().length() > relativePath.length()){
            return relativePath;
        }
        
        return "";
    }
    
    public static String toBladeViewPath(String filePath){
        return filePath.replace(BLADE_EXT, "").replace("/", ".");
    }
    
    public static String viewPathToFilePath(String viewPath){
        return viewPath.replace(".", "/") + BLADE_EXT;
    }
    
    public static HashSet<FileObject> getDefaultRoots(Project project){
        HashSet<FileObject> defaultList = new HashSet<>();
        FileObject defaultViewsRoot = project.getProjectDirectory().getFileObject(LARAVEL_VIEW_PATH);
        
        if (defaultViewsRoot != null && defaultViewsRoot.isValid()){
            defaultList.add(defaultViewsRoot);
        }
        
        return defaultList;
    }
    
    public static String toBladeToProjectFilePath(String path){
        return LARAVEL_VIEW_PATH + "/" + viewPathToFilePath(path);
    }
}
