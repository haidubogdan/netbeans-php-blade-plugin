
package org.netbeans.modules.php.blade.editor.hints;

/**
 *
 * @author bogdan
 */
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.modules.csl.api.HintsProvider.HintsManager;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.spi.options.AdvancedOption;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.NbBundle;

//@MimeRegistration(service = AdvancedOption.class, mimeType = BladeLanguage.MIME_TYPE, position = 120)
public final class HintsAdvancedOption extends AdvancedOption {

    private OptionsPanelController panelController;

    @Override
    public String getDisplayName() {
        return "BLADE"; // NOI18N
    }

    @Override
    public String getTooltip() {
        return "blade"; // NOI18N
    }

    @Override
    public synchronized OptionsPanelController create() {
        if ( panelController == null ) {
            HintsManager manager = HintsManager.getManagerForMimeType(BladeLanguage.MIME_TYPE);
            assert manager != null;
            panelController = manager.getOptionsController();
        }
        
        return panelController;
    }

    //FROM html
    //TODO: temporary solution, this should be solved on GSF level
    //@MimeRegistration(service = OptionsPanelController.class, mimeType = BladeLanguage.MIME_TYPE, position = 120)
    public static  OptionsPanelController createStatic(){
        return new HintsAdvancedOption().create();
    }
}
