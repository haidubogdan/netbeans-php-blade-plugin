
package org.netbeans.modules.php.blade.editor.refactoring;

import javax.swing.event.ChangeListener;
import org.netbeans.modules.refactoring.api.AbstractRefactoring;
import org.netbeans.modules.refactoring.api.Problem;
import org.netbeans.modules.refactoring.api.WhereUsedQuery;
import org.netbeans.modules.refactoring.spi.ui.CustomRefactoringPanel;
import org.netbeans.modules.refactoring.spi.ui.RefactoringUI;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author bogdan
 */
public class WhereBladePathUsedRefactoringUIImpl implements RefactoringUI {
    private final BladePathInfo symbolInformation;

    public WhereBladePathUsedRefactoringUIImpl(BladePathInfo symbolInformation) {
        this.symbolInformation = symbolInformation;
    }

    @Override
    public String getName() {
        return symbolInformation.getBladePath();
    }

    @Override
    @Messages({
        "# {0} - identifier",
        "DESC_Usages=Usages of {0}"
    })
    public String getDescription() {
        return Bundle.DESC_Usages(symbolInformation.getBladePath());
    }

    @Override
    public boolean isQuery() {
        return true;
    }

    @Override
    public CustomRefactoringPanel getPanel(ChangeListener parent) {
        return null;
    }

    @Override
    public Problem setParameters() {
        return null;
    }

    @Override
    public Problem checkParameters() {
        return null;
    }

    @Override
    public boolean hasParameters() {
        return false;
    }

    @Override
    public AbstractRefactoring getRefactoring() {
        return new WhereUsedQuery(Lookups.fixed(symbolInformation));
    }

    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

}
