/*
 */
package org.netbeans.modules.php.blade.project;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.netbeans.api.project.Project;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author bhaidu
 */
public class ProjectUtils {

    private static final String LARAVEL_VIEW_PATH = "resources/views";

    public static List<FileObject> getCustomViewsRoots(Project project) {
        List<FileObject> list = new ArrayList<>();
        String[] views = BladeProjectProperties.getInstance(project).getViewsPathList();
        views = Arrays.stream(views).filter(s -> !s.isEmpty()).toArray(String[]::new);
        Arrays.sort(views, (String s1, String s2) -> {
            //clear empty configs
            if (s1 == null || s2 == null) {
                return 0;
            }
            return s2.length() - s1.length();// comparision
        });

        if (views.length > 0) {
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
        } else {
            //fallback to default
            FileObject defaultLaravelPath = project.getProjectDirectory().getFileObject(LARAVEL_VIEW_PATH);
            if (defaultLaravelPath != null) {
                list.add(defaultLaravelPath);
            }
        }

        return list;
    }
}
