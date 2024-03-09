/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.path;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
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
public class PathUtils {

    private static final String LARAVEL_VIEW_PATH = "resources/views"; //NOI18N
//
//    private static final Map<Project, PathUtils> INSTANCES = new HashMap<>();
//    
//    private final Project project;
//    
//    private PathUtils(Project project) {
//        this.project = project;
//    }
//
//    public static PathUtils getInstance(Project project) {
//        if (INSTANCES.containsKey(project)) {
//            return INSTANCES.get(project);
//        }
//        PathUtils instance = new PathUtils(project);
//        INSTANCES.put(project, instance);
//        return instance;
//    }

    public static FileObject extractRootPath(FileObject currentFile) {
        String currentFilepath = currentFile.getPath();
        int viewRootPos = currentFilepath.lastIndexOf("/views/");
        if (viewRootPos < 0) {
            return null;
        }
        String relativePath = currentFilepath.substring(viewRootPos);
        int currentFileDeep = StringUtils.countMatches(relativePath, "/");
        String relativeRootPath = StringUtils.repeat("../", currentFileDeep) + "views";
        FileObject viewRoot = currentFile.getFileObject(relativeRootPath, true);

        if (viewRoot == null || !viewRoot.isValid()) {
            return null;
        }

        return viewRoot;
    }

    /**
     * first we need to extract the root folder of view after we apply a generic
     * path sanitize for blade paths (ex "my.path" -> "my/path.blade.php")
     *
     * @param contextFile
     * @param bladePath
     * @return List<FileObject>
     */
    public static List<FileObject> findFileObjectsForBladePath(FileObject contextFile, String bladePath) {
        List<FileObject> list = new ArrayList<>();
        Project project = ProjectConvertors.getNonConvertorOwner(contextFile);

        if (project == null) {
            return list;
        }

        List<FileObject> viewRoots = getCustomViewsRoots(project, contextFile);

        if (viewRoots == null || viewRoots.isEmpty()) {
            return list;
        }

        String sanitizedBladePath = bladePath.replace(".", "/") + ".blade.php"; //NOI18N

        for (FileObject viewRoot : viewRoots) {
            FileObject includedFile = viewRoot.getFileObject(sanitizedBladePath, true);

            if (includedFile != null && includedFile.isValid()) {
                list.add(includedFile);
            }
        }

        return list;
    }

    public static FileObject findFileObjectForBladePath(FileObject contextFile, String bladePath) {
        FileObject res = null;
        Project project = ProjectConvertors.getNonConvertorOwner(contextFile);

        if (project == null) {
            return res;
        }

        List<FileObject> viewRoots = getCustomViewsRoots(project, contextFile);

        if (viewRoots == null || viewRoots.isEmpty()) {
            return res;
        }

        String sanitizedBladePath = bladePath.replace(".", "/") + ".blade.php"; //NOI18N

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
     * @param prefixPath
     * @return List<FileObject>
     */
    public static List<FileObject> getParentChildrenFromPrefixPath(FileObject contextFile,
            String prefixPath) {
        List<FileObject> list = new ArrayList<>();
        //this should be a fallback
        Project project = ProjectConvertors.getNonConvertorOwner(contextFile);

        if (project == null) {
            return list;
        }

        List<FileObject> viewRoots = getCustomViewsRoots(project, contextFile);

        if (viewRoots == null || viewRoots.isEmpty()) {
            return list;
        }

        String canonicalPath = prefixPath.replace(".", "/");
        int lastSlash;

        //fix issues with lastIndexOf search
        if (canonicalPath.endsWith("/")) {
            lastSlash = canonicalPath.length();
        } else {
            lastSlash = canonicalPath.lastIndexOf("/");
        }

        int nSlashes = StringUtils.countMatches(canonicalPath, "/");

        List<FileObject> filteredViewRoots = new ArrayList<>();
        
        Map<String, FileObject> relativeFilePathMap = new HashMap<>();
        
        if (lastSlash > 0) {
            for (FileObject rootFolder : viewRoots) {
                FileObject relativeViewRoot = rootFolder.getFileObject(canonicalPath.substring(0, lastSlash));

                if (relativeViewRoot != null && relativeViewRoot.isValid()) {
                    relativeFilePathMap.put(canonicalPath, relativeViewRoot);
                }
            }
            //empty list
            viewRoots.clear();
        } else {
            filteredViewRoots = viewRoots;
        }

        String prefixToCompare;

        if (lastSlash > 0) {
            prefixToCompare = canonicalPath.substring(lastSlash, canonicalPath.length());
        } else {
            prefixToCompare = canonicalPath;
        }

        if (canonicalPath.endsWith("/")) {
            for (FileObject rootFolder : filteredViewRoots) {
                list.addAll(Arrays.asList(rootFolder.getChildren()));
            }
            for (Map.Entry<String, FileObject> entry : relativeFilePathMap.entrySet()){
                list.addAll(Arrays.asList(entry.getValue().getChildren()));
            }
        } else {
            for (FileObject rootFolder : filteredViewRoots) {
                for (FileObject file : rootFolder.getChildren()) {
                    String filePath = file.getPath().replace(rootFolder.getPath(), "");
                    if (filePath.startsWith(prefixToCompare)) {
                        list.add(file);
                    }
                }
            }
            
            if (prefixToCompare.startsWith("/")){
                prefixToCompare = prefixToCompare.substring(1, prefixToCompare.length());
            }
            
            for (Map.Entry<String, FileObject> entry : relativeFilePathMap.entrySet()){
                for (FileObject file : entry.getValue().getChildren()) {
                    if (file.getName().startsWith(prefixToCompare)){
                        list.add(file);
                    }
                }
            }
        }

        return list;
    }

    public static List<FileObject> getCustomViewsRoots(Project project, FileObject contextFile) {
        List<FileObject> list = new ArrayList<>();

        FileObject defaultLaravelPath = project.getProjectDirectory().getFileObject(LARAVEL_VIEW_PATH);

        if (defaultLaravelPath != null) {
            list.add(defaultLaravelPath);
        }

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

//        FileObject estimatedRoot = extractRootPath(contextFile);
//
//        if (estimatedRoot != null) {
//            list.add(estimatedRoot);
//        }
        return list;
    }

    public static String toBladePath(FileObject file) {
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
                String bladePath = filePath.replace(viewFolderPath, "").replace(".blade.php", "").replace("/", ".");
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
                return relativePath.substring(1).replace(".blade.php", "").replace("/", ".");
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
}
