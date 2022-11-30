package org.netbeans.modules.php.blade.editor.ui.model;

import javax.swing.DefaultComboBoxModel;
import org.netbeans.modules.php.blade.version.BladeVersion;

/**
 * blade version model
 * 
 * @author bhaidu
 */
public class BladeVersionComboBoxModel extends DefaultComboBoxModel<BladeVersion> {
 
    /**
     * serializable
     */
    private static final long serialVersionUID = -158789765465878745L;

    public BladeVersionComboBoxModel() {
        this(null);
    }

    public BladeVersionComboBoxModel(BladeVersion preselected) {
        super(BladeVersion.values());

        if (preselected != null) {
            setSelectedItem(preselected);
        } else {
            setSelectedItem(BladeVersion.getDefault());
        }
    }
}
