package org.netbeans.modules.php.blade.editor.components;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.netbeans.api.project.Project;
import org.netbeans.modules.php.blade.editor.cache.QueryCache;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexResult;
import org.netbeans.modules.php.blade.editor.indexing.PhpIndexUtils;
import org.netbeans.spi.project.ui.support.ProjectConvertors;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class ComponentModel {

    private static final Map<Integer, ComponentModel> MODEL_INSTANCE = new WeakHashMap<>();

    protected static ComponentModel getModel(FileObject fo, String prefix) {
        ComponentModel selfModel = new ComponentModel();
        Project projectOwner = ProjectConvertors.getNonConvertorOwner(fo);
        if (projectOwner == null) {
            return null;
        }
        int pathHash = projectOwner.getProjectDirectory().toString().hashCode();
        if (ComponentModel.MODEL_INSTANCE.containsKey(pathHash)) {
            selfModel = MODEL_INSTANCE.get(pathHash);

        } else {
            MODEL_INSTANCE.put(pathHash, selfModel);
        }
        return selfModel;
    }
}
