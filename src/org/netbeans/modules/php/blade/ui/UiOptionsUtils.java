package org.netbeans.modules.php.blade.ui;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import org.netbeans.modules.php.blade.api.BladeCompilerPath.Item;
import org.netbeans.modules.php.blade.api.BladeVersion;

/**
 *
 * @author bhaidu
 */
public class UiOptionsUtils {

    private UiOptionsUtils() {
    }

    public static class BladeVersionComboBoxModel extends DefaultComboBoxModel<BladeVersion> {

        //private static final long serialVersionUID = -48789765465878745L;

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
    
    public static String encodeToStrings(Enumeration<String> list) {
        List<String> result = new ArrayList<>();
        while (list.hasMoreElements()) {
            result.add(list.nextElement());
        }

        return String.join("|", result);
    }
    
    public static DefaultListModel<String> createListModel(Iterator<String> it) {
        DefaultListModel<String> model = new DefaultListModel<>();
        while (it.hasNext()) {
            model.addElement(it.next());
        }
        return model;
    }
}
