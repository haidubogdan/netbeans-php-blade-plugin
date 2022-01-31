package org.netbeans.modules.php.blade.refactoring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.refactoring.api.AbstractRefactoring;
import org.netbeans.modules.refactoring.api.Problem;
import org.netbeans.modules.refactoring.api.SingleCopyRefactoring;
import org.netbeans.modules.refactoring.spi.ui.CustomRefactoringPanel;
import org.netbeans.modules.refactoring.spi.ui.RefactoringUI;
import org.netbeans.modules.refactoring.spi.ui.RefactoringUIBypass;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author bhaidu
 */
public class BladeCopyRefactoringUI implements RefactoringUI, RefactoringUIBypass {

    private final AbstractRefactoring refactoring;
    private BladeElementContext context;
    private CopyPanel panel;
    private BladeRefactoringExtraInfo extraInfo;

    public BladeCopyRefactoringUI(BladeElementContext context) {
	this.context = context;
        this.extraInfo = new BladeRefactoringExtraInfo();
        Collection<Object> lookupContent = new ArrayList<>();
        lookupContent.add(context);
        lookupContent.add(extraInfo);
        if(context instanceof BladeElementContext.File ||
                context instanceof BladeElementContext.Folder) {
            //put the fileobject to the lookup only if we are renaming a file or folder
            lookupContent.add(context.getFileObject());
        }
	this.refactoring = new SingleCopyRefactoring(Lookups.fixed(lookupContent.toArray()));
    }

    @Override
    public String getName() {
	return NbBundle.getMessage(BladeCopyRefactoringUI.class, "LBL_Rename"); //NOI18N
    }

    @Override
    public String getDescription() {
	return NbBundle.getMessage(BladeCopyRefactoringUI.class, "LBL_Rename_Descr"); //NOI18N
    }

    @Override
    public boolean isQuery() {
	return false;
    }

    @Override
    public CustomRefactoringPanel getPanel(ChangeListener parent) {
	if (panel == null) {
	    panel = new CopyPanel(context.getElementName(), parent, NbBundle.getMessage(CopyPanel.class, "LBL_Rename"), true, true); //NOI18N
	}

	return panel;
    }

    @Override
    public Problem setParameters() {
	String newName = panel.getNameValue();
	if (refactoring instanceof SingleCopyRefactoring) {
            FileObject targetFile = context.getFileObject();
            String path = targetFile.getParent().getPath();
            java.io.File target = new java.io.File(path);
            try {
                SingleCopyRefactoring copyRefactoring = (SingleCopyRefactoring) refactoring;
                copyRefactoring.setTarget(Lookups.fixed(target.toURI().toURL()));
                copyRefactoring.setNewName(newName);
                //copyRefactoring.
            } catch (Exception ex){
                Exceptions.printStackTrace(ex);
            }
	}
	return refactoring.checkParameters();
    }

    @Override
    public Problem checkParameters() {
        if (refactoring instanceof SingleCopyRefactoring) {
	    
	}
	return refactoring.checkParameters();
    }

    @Override
    public boolean hasParameters() {
	return true;
    }

    @Override
    public AbstractRefactoring getRefactoring() {
	return this.refactoring;
    }

    @Override
    public HelpCtx getHelpCtx() {
	return null;
    }

    @Override
    public boolean isRefactoringBypassRequired() {
	return false; //TODO fix this
    }

    @Override
    public void doRefactoringBypass() throws IOException {
	//TODO implement
    }
}
