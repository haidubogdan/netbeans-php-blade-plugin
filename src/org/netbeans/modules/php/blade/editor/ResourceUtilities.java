package org.netbeans.modules.php.blade.editor;

import javax.swing.ImageIcon;
import org.openide.util.ImageUtilities;

/**
 *
 * @author bhaidu
 */
public class ResourceUtilities {

    public static final String ICON_BASE = "org/netbeans/modules/php/blade/resources/"; //NOI18N

    public static ImageIcon loadResourceIcon(String path){
        return ImageUtilities.loadImageIcon(ICON_BASE + path, false);
    }
}
