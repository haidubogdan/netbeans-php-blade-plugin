package org.netbeans.modules.php.blade.editor.platform;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;
import org.netbeans.api.annotations.common.StaticResource;
import org.netbeans.api.project.Project;
import org.netbeans.modules.web.clientproject.api.BadgeIcon;
import org.openide.util.lookup.ServiceProvider;
import org.netbeans.modules.web.clientproject.api.platform.PlatformProviders;
import org.netbeans.modules.web.clientproject.spi.CustomizerPanelImplementation;
import org.netbeans.modules.web.clientproject.spi.platform.PlatformProviderImplementation;
import org.netbeans.modules.web.clientproject.spi.platform.PlatformProviderImplementationListener;
import org.netbeans.spi.project.ActionProvider;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;
import org.openide.util.RequestProcessor;

/**
 *
 * @author bhaidu
 */
@ServiceProvider(service = PlatformProviderImplementation.class, path = PlatformProviders.PLATFORM_PATH, position = 100)
public final class BladePlatformProvider implements PlatformProviderImplementation, PropertyChangeListener {

    private static final Logger LOGGER = Logger.getLogger(BladePlatformProvider.class.getName());

    public static final String IDENT = "Blade"; // NOI18N

    static final RequestProcessor RP = new RequestProcessor(BladePlatformProvider.class);
    @StaticResource
    private static final String ICON_PATH = "org/netbeans/modules/php/blade/resources/icon.png"; // NOI18N

    private final BadgeIcon badgeIcon;
    private final PlatformProviderImplementationListener.Support listenerSupport = new PlatformProviderImplementationListener.Support();

    public BladePlatformProvider() {
        badgeIcon = new BadgeIcon(
                ImageUtilities.loadImage(ICON_PATH),
                BladePlatformProvider.class.getResource("/" + ICON_PATH)); // NOI18N
    }

    @Override
    public String getIdentifier() {
        return IDENT;
    }

    @NbBundle.Messages("BladePlatformProvider.name=Blade View")
    @Override
    public String getDisplayName() {
        return Bundle.BladePlatformProvider_name();
    }

    @Override
    public BadgeIcon getBadgeIcon() {
        return badgeIcon;
    }

    @Override
    public boolean isEnabled(Project project) {
        return true;
    }

    @Override
    public List<URL> getSourceRoots(Project project) {
        assert project != null;
        assert isEnabled(project) : "Node.je support must be enabled in this project: " + project.getProjectDirectory().getNameExt();
        return BladeSupport.forProject(project).getSourceRoots();
    }

    @Override
    public ActionProvider getActionProvider(Project project) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CustomizerPanelImplementation> getRunCustomizerPanels(Project prjct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void projectOpened(Project prjct) {
    }

    @Override
    public void projectClosed(Project prjct) {
    }

    @Override
    public void notifyPropertyChanged(Project prjct, PropertyChangeEvent pce) {
    }

    @Override
    public void addPlatformProviderImplementationListener(PlatformProviderImplementationListener listener) {
        listenerSupport.addPlatformProviderImplementationsListener(listener);
    }

    @Override
    public void removePlatformProviderImplementationListener(PlatformProviderImplementationListener listener) {
        listenerSupport.removePlatformProviderImplementationsListener(listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        listenerSupport.firePropertyChanged((Project) evt.getSource(), this,
                new PropertyChangeEvent(this, evt.getPropertyName(), evt.getOldValue(), evt.getNewValue()));
    }

}
