package org.netbeans.modules.php.blade.editor;

import java.io.IOException;
import org.netbeans.api.annotations.common.StaticResource;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.MIMEResolver;
import org.openide.loaders.DataNode;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.SaveAsCapable;
import org.openide.loaders.UniFileLoader;
import org.openide.nodes.Children;
import org.openide.nodes.CookieSet;
import org.openide.nodes.Node.Cookie;
import org.openide.util.NbBundle;
import org.openide.util.UserCancelException;

/**
 *
 * @author bhaidu
 */
@MIMEResolver.Registration(
        resource = "../resources/mime-resolver.xml",
        displayName = "#LBL_Blade_LOADER",
        position = 1
)
@NbBundle.Messages({
    "LBL_Blade_LOADER=Blade template files"
})
public class BladeDataObject extends MultiDataObject implements CookieSet.Factory {
    @StaticResource
    private static final String ICON_LOCATION = "org/netbeans/modules/php/blade/resources/icon.png"; //NOI18N

    private transient BladeEditorSupport bladeEditorSupport;

    public BladeDataObject(FileObject pf, UniFileLoader loader) throws DataObjectExistsException {
        super(pf, loader);
        CookieSet set = getCookieSet();
        set.add(BladeEditorSupport.class, this);
        set.assign(SaveAsCapable.class, new SaveAsCapable() {
            //TO DO STUDY IF RENAMING can be done here
            @Override
            public void saveAs(FileObject folder, String fileName) throws IOException {
                BladeEditorSupport es = getLookup().lookup(BladeEditorSupport.class);
                try {
                    //es.updateEncoding();
                    es.saveAs(folder, fileName);
                } catch (UserCancelException e) {
                    //ignore, just not save anything
                }
            }
        });
    }

    /*package*/ CookieSet getCookieSet0() {
        return getCookieSet();
    }

    @Override
    protected int associateLookup() {
        return 1;
    }

    @Override
    protected org.openide.nodes.Node createNodeDelegate() {
        DataNode n = new BladeDataNode(this, Children.LEAF);
        n.setIconBaseWithExtension(ICON_LOCATION); // NOI18N
        return n;
    }

    @Override
    public <T extends Cookie> T createCookie(Class<T> klass) {
        if (klass.isAssignableFrom(BladeEditorSupport.class)) {
            return klass.cast(getBladeEditorSupport());
        } else {
            return null;
        }
    }

    private synchronized BladeEditorSupport getBladeEditorSupport() {
        if (bladeEditorSupport == null) {
            bladeEditorSupport = new BladeEditorSupport(this);
        }
        return bladeEditorSupport;
    }
}
