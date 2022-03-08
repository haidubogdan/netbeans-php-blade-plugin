package org.netbeans.modules.php.blade.editor.platform;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import org.netbeans.api.project.Project;

/**
 *
 * @author bhaidu
 */
public final class BladeSourceRoots {

    private static final Logger LOGGER = Logger.getLogger(BladeSourceRoots.class.getName());

    //public static final String LIB_DIRECTORY = "lib"; // NOI18N

    private final Project project;

    // @GuardedBy("this")
    private List<URL> sourceRoots = null;


    public BladeSourceRoots(Project project) {
        assert project != null;
        this.project = project;
    }

    public synchronized List<URL> getSourceRoots() {
        if (sourceRoots == null) {
            sourceRoots = findSourceRoots();
        }
        return new ArrayList<>(sourceRoots);
    }

    public synchronized void resetSourceRoots() {
        sourceRoots = null;
    }

    private List<URL> findSourceRoots() {
        /*
        File nodeSources = NodeJsUtils.getNodeSources(project);
        if (nodeSources == null) {
            return Collections.emptyList();
        }
        File lib = new File(nodeSources, LIB_DIRECTORY);
        if (!lib.isDirectory()) {
            return Collections.emptyList();
        }
        try {
            URL nodeLib = Utilities.toURI(FileUtil.normalizeFile(lib)).toURL();
            return Collections.singletonList(nodeLib);
        } catch (MalformedURLException ex) {
            LOGGER.log(Level.INFO, null, ex);
            assert false;
        }
        */
        return Collections.emptyList();
    }

}
