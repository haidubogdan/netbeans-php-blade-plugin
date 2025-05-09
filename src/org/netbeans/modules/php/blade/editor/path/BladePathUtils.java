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
import java.util.Set;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.project.BladeProjectProperties;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.netbeans.modules.php.blade.syntax.StringUtils;
import org.netbeans.spi.project.ui.support.ProjectConvertors;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author bogdan
 */
public final class BladePathUtils {

    public static final String LARAVEL_RESOURCES = "resources"; //NOI18N
    public static final String LARAVEL_VIEW_FOLDER = "views"; //NOI18N
    public static final String LARAVEL_VIEW_PATH = LARAVEL_RESOURCES + StringUtils.FORWARD_SLASH + LARAVEL_VIEW_FOLDER;

    public static final String[] BLADE_VIEW_METHODS = new String[]{"view", "render", "make"}; // NOI18N

    public static final Set<String> BLADE_VIEW_METHODS_SET = new HashSet<>(Arrays.asList(BLADE_VIEW_METHODS));

    public static final String PHP_EXTENSION = "php"; // NOI18N

    private BladePathUtils() {

    }

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

        String sanitizedBladePath = viewPathToFilePath(viewPath);

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

        List<FileObject> viewRoots = getDefaultRootsList(project);
        viewRoots.addAll(getCustomViewsRoots(project, contextFile));

        if (viewRoots.isEmpty()) {
            return list;
        }

        String unixPath = prefixViewPath.replace(StringUtils.DOT, StringUtils.FORWARD_SLASH);

        int lastSlash = unixPath.lastIndexOf(StringUtils.FORWARD_SLASH);

        return filterFilesFromRootFolder(viewRoots.toArray(new FileObject[0]), unixPath, lastSlash);
    }

    public static List<FileObject> filterFilesFromRootFolder(FileObject[] viewRoots, String unixPath, int lastSlash) {

        List<FileObject> list = new ArrayList<>();

        if (lastSlash > 0) {
            //filter only relative folders
            return filterFromRelativeSlash(viewRoots, unixPath, lastSlash);
        } else {
            for (FileObject rootFolder : viewRoots) {
                for (FileObject file : rootFolder.getChildren()) {
                    String filePath = file.getPath().replace(rootFolder.getPath() + StringUtils.FORWARD_SLASH, ""); //NOI18N
                    if (filePath.startsWith(unixPath)) {
                        list.add(file);
                    }
                }
            }

        }

        return list;
    }

    public static List<FileObject> filterFromRelativeSlash(FileObject[] viewRoots, String unixPath, int lastSlash) {
        Map<String, FileObject> relativeFilePathMap = new HashMap<>();
        List<FileObject> list = new ArrayList<>();
        boolean folderEnd = unixPath.endsWith(StringUtils.FORWARD_SLASH);
        for (FileObject rootFolder : viewRoots) {
            FileObject relativeViewRoot = rootFolder.getFileObject(unixPath.substring(0, lastSlash));

            if (relativeViewRoot != null && relativeViewRoot.isValid()) {
                relativeFilePathMap.put(unixPath, relativeViewRoot);
            }
        }

        if (folderEnd) {
            for (Map.Entry<String, FileObject> entry : relativeFilePathMap.entrySet()) {
                list.addAll(Arrays.asList(entry.getValue().getChildren()));
            }
        } else {
            String relativePrefixToCompare = unixPath.substring(lastSlash + 1, unixPath.length());
            for (Map.Entry<String, FileObject> entry : relativeFilePathMap.entrySet()) {
                for (FileObject file : entry.getValue().getChildren()) {
                    if (file.getName().startsWith(relativePrefixToCompare)) {
                        list.add(file);
                    }
                }
            }
        }

        return list;
    }

    public static List<FileObject> getCustomViewsRoots(Project project, FileObject contextFile) {
        List<FileObject> list = new ArrayList<>();
        BladeProjectProperties bladeProperties = BladeProjectProperties.forProject(project);
        String[] views = bladeProperties.getViewsFolderPathList();

        if (views.length == 0) {
            return list;
        }

        FileObject projectDir = project.getProjectDirectory();
        String dirPathName = projectDir.getName();

        views = Arrays.stream(views).filter(s -> !s.isEmpty()).toArray(String[]::new);
        Arrays.sort(views, (String s1, String s2) -> {
            //clear empty configs
            if (s1 == null || s2 == null) {
                return 0;
            }
            return s2.length() - s1.length();// comparision
        });
        for (String viewPath : views) {
            if (viewPath.length() == 0) {
                continue;
            }

            //if the absolute path doesn't contain the project name
            //we can asume the path is relative
            if (!viewPath.contains(dirPathName)) {
                FileObject relativeFolder = projectDir.getFileObject(viewPath);
                if (isValidFolder(relativeFolder)) {
                    list.add(relativeFolder);
                }
                continue;
            }
            File viewFile = new File(viewPath);
            if (!viewFile.exists()) {
                continue;
            }

            list.add(FileUtil.toFileObject(viewFile));
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
                String bladePath = BladePathUtils.toBladeViewPath(filePath.replace(viewFolderPath, "")); //NOI18N
                //starting slash
                if (bladePath.startsWith(StringUtils.DOT)) {
                    bladePath = bladePath.substring(1, bladePath.length());
                }
                return bladePath;
            }
        }

        BladeProjectProperties bladeProperties = BladeProjectProperties.forProject(project);
        FileObject projectDir = project.getProjectDirectory();
        String dirPathName = projectDir.getName();

        String[] viewFolders = bladeProperties.getViewsFolderPathList();

        for (String viewFolderPath : viewFolders) {
            if (viewFolderPath.length() == 0) {
                continue;
            }

            FileObject viewFolder;
            //if the absolute path doesn't contain the project name
            //we can asume the path is relative
            if (!viewFolderPath.contains(dirPathName)) {
                viewFolder = projectDir.getFileObject(viewFolderPath);
            } else {
                File viewPathFile = new File(viewFolderPath);
                if (!viewPathFile.exists()) {
                    continue;
                }
                viewFolder = FileUtil.toFileObject(viewPathFile);
            }

            if (!isValidFolder(viewFolder)) {
                continue;
            }
            //we need to keep the same format
            String viewFileAbsPath = viewFolder.getPath();
            if (filePath.startsWith(viewFileAbsPath)) {
                String relativePath = filePath.replace(viewFileAbsPath, ""); //NOI18N
                if (!relativePath.startsWith(StringUtils.FORWARD_SLASH)) {
                    //it doesn't belong to the folder
                    continue;
                }
                return BladePathUtils.toBladeViewPath(relativePath.substring(1));
            }
        }

        return path;
    }

    public static String getRelativeProjectPath(FileObject currentFile) {
        Project projectOwner = ProjectConvertors.getNonConvertorOwner(currentFile);
        if (projectOwner == null) {
            return ""; //NOI18N
        }

        String dirPath = projectOwner.getProjectDirectory().getPath();
        String relativePath = currentFile.getPath().replace(dirPath, ""); //NOI18N

        //only if we found the relative project path
        if (currentFile.getPath().length() > relativePath.length()) {
            return relativePath;
        }

        return ""; //NOI18N
    }

    public static String toBladeViewPath(String filePath) {
        return filePath.replace(BladeLanguage.FILE_EXTENSION_WITH_DOT, "").replace(StringUtils.FORWARD_SLASH, StringUtils.DOT); //NOI18N
    }

    public static String relativeFilePath(File sources, FileObject projectDir) {
        File projectDirFile = FileUtil.toFile(projectDir);
        String absoulteProjectDir = projectDirFile.getAbsolutePath();
        String absoluteFilePath = FileUtil.normalizeFile(sources).getAbsolutePath();
        String unixPath = absoluteFilePath.replace(absoulteProjectDir, "")
                .replace(StringUtils.BACK_DASH, StringUtils.FORWARD_SLASH).replaceAll("^[/]+", "");  //NOI18N
        return unixPath;
    }

    public static String viewPathToFilePath(String viewPath) {
        return viewPath.replace(StringUtils.DOT, StringUtils.FORWARD_SLASH) + BladeLanguage.FILE_EXTENSION_WITH_DOT;
    }

    public static HashSet<FileObject> getDefaultRoots(Project project) {
        HashSet<FileObject> defaultList = new HashSet<>();
        FileObject defaultViewsRoot = project.getProjectDirectory().getFileObject(LARAVEL_VIEW_PATH);

        if (defaultViewsRoot != null && defaultViewsRoot.isValid()) {
            defaultList.add(defaultViewsRoot);
        }

        return defaultList;
    }

    public static List<FileObject> getDefaultRootsList(Project project) {
        ArrayList<FileObject> list = new ArrayList<>();
        FileObject defaultViewsRoot = project.getProjectDirectory().getFileObject(LARAVEL_VIEW_PATH);

        if (defaultViewsRoot != null && defaultViewsRoot.isValid()) {
            list.add(defaultViewsRoot);
        }

        return list;
    }

    public static String toBladeToProjectFilePath(String path) {
        return LARAVEL_VIEW_PATH + StringUtils.FORWARD_SLASH + viewPathToFilePath(path);
    }

    public static String removeViewsFolderFromPath(String filePath) {
        int viewsPos = filePath.indexOf(StringUtils.FORWARD_SLASH + BladePathUtils.LARAVEL_VIEW_FOLDER + StringUtils.FORWARD_SLASH);
        if (viewsPos < 0) {
            return filePath;
        }
        return filePath.substring(viewsPos, filePath.length());
    }

    public static boolean isValidPhpFile(FileObject file) {
        return file != null
                && file.isValid()
                && !file.isFolder()
                && file.getExt().endsWith(PHP_EXTENSION);
    }
    
    public static boolean isValidFolder(FileObject file) {
        return file != null
                && file.isValid()
                && file.isFolder();
    }
}
