package org.netbeans.modules.php.blade.editor.hints;

import org.netbeans.modules.csl.api.HintsProvider;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.NbBundle;

/**
 *
 * @author bogdan
 */
public class HintsControllerFactory {

    public HintsControllerFactory() {
    }

    @OptionsPanelController.SubRegistration(
            id = "BladeHints",
            location = "Blade/Hints",
            displayName = "#HintsControllerFactory.name"
    )
    @NbBundle.Messages("HintsControllerFactory.name=Blade Hints")
    public static OptionsPanelController createOptions() {
        HintsProvider.HintsManager manager = HintsProvider.HintsManager.getManagerForMimeType(BladeLanguage.MIME_TYPE);
        assert manager != null;

        return manager.getOptionsController();
    }
}
