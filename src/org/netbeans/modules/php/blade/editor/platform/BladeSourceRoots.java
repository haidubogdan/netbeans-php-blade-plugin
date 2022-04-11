package org.netbeans.modules.php.blade.editor.platform;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import org.netbeans.api.project.Project;

/**
 * TODO
 * to have a source folder from vendor
 * a blade view folder for views, it should be detected automatically in the future it can be part of a framework
 * TODO cacheDir
 * https://github.com/apache/netbeans/blob/c084119009d2e0f736f225d706bc1827af283501/php/php.symfony2/src/org/netbeans/modules/php/symfony2/SymfonyVersion.java
 * 
 * TODO composer dependency
 * https://github.com/apache/netbeans/blob/c084119009d2e0f736f225d706bc1827af283501/php/php.composer/src/org/netbeans/modules/php/composer/ui/PhpModuleExtenderPanel.java
 * 
 * https://github.com/junichi11/cakephp-netbeans/blob/132bb656f9e2caad0bff5b7daa94c8ab084e8cf9/src/org/cakephp/netbeans/modules/CakePhpModule.java
 * 
 * for versioning
 * https://github.com/junichi11/cakephp-netbeans/blob/132bb656f9e2caad0bff5b7daa94c8ab084e8cf9/src/org/cakephp/netbeans/versions/CakeVersion.java
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
