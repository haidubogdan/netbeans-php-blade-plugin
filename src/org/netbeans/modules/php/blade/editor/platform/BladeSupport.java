package org.netbeans.modules.php.blade.editor.platform;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ActionProvider;
import org.netbeans.spi.project.ProjectServiceProvider;
import org.openide.filesystems.FileChangeAdapter;
import org.openide.filesystems.FileChangeListener;
import org.openide.filesystems.FileEvent;
import org.openide.util.RequestProcessor;
import org.openide.util.WeakListeners;

/**
 *
 * @author bhaidu
 */
public final class BladeSupport {
    static final Logger LOGGER = Logger.getLogger(BladeSupport.class.getName());

    static final RequestProcessor RP = new RequestProcessor(BladeSupport.class);
    
    final Project project;
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    final PreferenceChangeListener optionsListener = new OptionsListener();
    //final PreferenceChangeListener preferencesListener = new PreferencesListener();
//    private final PropertyChangeListener packageJsonListener = new PackageJsonListener();
   // private final FileChangeListener nodeSourcesListener = new NodeSourcesListener();
    //final BladePreferences preferences;
   // private final ActionProvider actionProvider;
   // final NodeJsSourceRoots sourceRoots;
  //  final PackageJson packageJson;
    
    private BladeSupport(Project project) {
        assert project != null;
        this.project = project;
        //actionProvider = new NodeJsActionProvider(project);
        //sourceRoots = new NodeJsSourceRoots(project);
        //preferences = new NodeJsPreferences(project);
        //packageJson = new PackageJson(project.getProjectDirectory());
    }
    
    @ProjectServiceProvider(service = BladeSupport.class, projectType = "org-netbeans-modules-web-clientproject") // NOI18N
    public static BladeSupport create(Project project) {
        BladeSupport support = new BladeSupport(project);
        // listeners
        //BladeSupport bladeSupport = BladeSupport.getInstance();
        //bladeSupport.addPreferenceChangeListener(WeakListeners.create(PreferenceChangeListener.class, support.optionsListener, bladeSupport));
        return support;
    }
    public static BladeSupport forProject(Project project) {
        BladeSupport support = project.getLookup().lookup(BladeSupport.class);
        assert support != null : "BladeSupport should be found in project " + project.getClass().getName() + " (lookup: " + project.getLookup() + ")";
        return support;
    }
/*
    public NodeJsPreferences getPreferences() {
        return preferences;
    }

    public ActionProvider getActionProvider() {
        return actionProvider;
    }

    public List<URL> getSourceRoots() {
        return sourceRoots.getSourceRoots();
    }

    public PackageJson getPackageJson() {
        return packageJson;
    }
*/
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void firePropertyChanged(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(project, propertyName, oldValue, newValue));
    }

    public void fireSourceRootsChanged() {
        //sourceRoots.resetSourceRoots();
        //firePropertyChanged(NodeJsPlatformProvider.PROP_SOURCE_ROOTS, null, null);
    }

    void projectOpened() {
        /*
        FileUtil.addFileChangeListener(nodeSourcesListener, NodeJsUtils.getNodeSources());
        preferences.addPreferenceChangeListener(preferencesListener);
        packageJson.addPropertyChangeListener(packageJsonListener);
        // init node version
        NodeExecutable node = NodeExecutable.forProject(project, false);
        if (node != null) {
            node.getVersion();
        }
*/
    }

    void projectClosed() {
        /*
        FileUtil.removeFileChangeListener(nodeSourcesListener, NodeJsUtils.getNodeSources());
        preferences.removePreferenceChangeListener(preferencesListener);
        packageJson.removePropertyChangeListener(packageJsonListener);
        // cleanup
        packageJson.cleanup();
*/
    }

    //~ Inner classes

    private final class OptionsListener implements PreferenceChangeListener {

        @Override
        public void preferenceChange(PreferenceChangeEvent evt) {
            String projectName = project.getProjectDirectory().getNameExt();
           /*
            if (!preferences.isEnabled()) {
                LOGGER.log(Level.FINE, "Change event in node.js options ignored, node.js not enabled in project {0}", projectName);
                return;
            }*/
            String key = evt.getKey();
            LOGGER.log(Level.FINE, "Processing change event {0} in node.js options in project {1}", new Object[] {key, projectName});
            /*
            if (preferences.isDefaultNode()
                    && (NodeJsOptions.NODE_PATH.equals(key) || NodeJsOptions.NODE_SOURCES_PATH.equals(key))) {
                fireSourceRootsChanged();
            }
*/
        }

    }
    
    private final class NodeSourcesListener extends FileChangeAdapter {

        @Override
        public void fileFolderCreated(FileEvent fe) {
            String projectName = project.getProjectDirectory().getNameExt();
            /*
            if (!preferences.isEnabled()) {
                LOGGER.log(Level.FINE, "File change event in node sources ignored, node.js not enabled in project {0}", projectName);
                return;
            }
            NodeExecutable node = NodeExecutable.forProject(project, false);
            if (node == null) {
                return;
            }
            Version version = node.getVersion();
            if (version == null) {
                return;
            }
            if (fe.getFile().getNameExt().equals(version.toString())) {
                LOGGER.log(Level.FINE, "Processing file change event in node sources in project {0}", projectName);
                fireSourceRootsChanged();
            }
            */
        }

    }

    
    
}
