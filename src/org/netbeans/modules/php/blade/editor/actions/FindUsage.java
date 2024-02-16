package org.netbeans.modules.php.blade.editor.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.text.JTextComponent;
import org.netbeans.modules.php.blade.editor.path.PathUtils;
import org.netbeans.modules.php.blade.editor.refactoring.BladePathInfo;
import org.netbeans.modules.php.blade.editor.refactoring.WhereBladePathUsedRefactoringUIImpl;
import org.netbeans.modules.refactoring.spi.ui.UI;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.nodes.Node;
import org.openide.windows.TopComponent;

/**
 *
 * @author bogdan
 */
@ActionID(id = "org.netbeans.modules.php.blade.editor.actions.FindUsage", category = "TemplateActions")
@ActionRegistration(displayName = "Template Usages")
public class FindUsage extends AbstractAction implements ActionListener {

    Node node;

    public FindUsage(Node node) {
        this.node = node;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileObject fo = node.getLookup().lookup(FileObject.class);
        String bladePath = PathUtils.toBladePath(fo);
        if (bladePath == null) {
            return;
        }
        BladePathInfo si = new BladePathInfo(fo, bladePath);
        UI.openRefactoringUI(new WhereBladePathUsedRefactoringUIImpl(si),
                TopComponent.getRegistry().getActivated());
    }

}
