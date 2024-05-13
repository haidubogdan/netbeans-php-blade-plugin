package org.netbeans.modules.php.blade.editor.refactoring;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import javax.swing.Action;
import javax.swing.JEditorPane;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.modules.editor.NbEditorUtilities;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.refactoring.api.ui.ExplorerContext;
import org.netbeans.modules.refactoring.spi.ui.ActionsImplementationProvider;
import org.netbeans.modules.refactoring.spi.ui.UI;
import org.openide.cookies.*;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;
import org.openide.text.CloneableEditorSupport;
import org.openide.text.NbDocument;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 *
 * @author bogdan
 */
@NbBundle.Messages({"WARN_CannotPerformHere=Cannot perform rename here."})
@org.openide.util.lookup.ServiceProvider(service = org.netbeans.modules.refactoring.spi.ui.ActionsImplementationProvider.class, position = 300)
public class RefactoringActionsProvider extends ActionsImplementationProvider {

    @Override
    @Messages("NM_Unknown=Unknown")
    public void doFindUsages(Lookup lookup) {
        Runnable start = () -> {
            EditorCookie ec = lookup.lookup(EditorCookie.class);

            if (isFromEditor(ec)) {
                JEditorPane c = ec.getOpenedPanes()[0];
                Document doc = c.getDocument();
                AbstractDocument abstractDoc = (doc instanceof AbstractDocument) ? ((AbstractDocument) doc) : null;
                FileObject file = NbEditorUtilities.getFileObject(doc);
                int caretPos = c.getCaretPosition();

                String name = Bundle.NM_Unknown();

                if (abstractDoc != null) {
                    abstractDoc.readLock();
                }
                try {
                    TokenSequence<?> ts = TokenHierarchy.get(doc).tokenSequence();
                    if (ts != null) {
                        ts.move(caretPos);
                        if (ts.moveNext()) {
                            name = ts.token().text().toString();
                        }
                    }
                } finally {
                    if (abstractDoc != null) {
                        abstractDoc.readUnlock();
                    }
                }

                BladePathInfo si = new BladePathInfo(file, name);
                UI.openRefactoringUI(new WhereBladePathUsedRefactoringUIImpl(si),
                        TopComponent.getRegistry().getActivated());
            }
        };
        SwingUtilities.invokeLater(start);
    }

    @Override
    public boolean canCopy(Lookup lookup) {
        boolean isBlade = isBlade(lookup);
        if (!isBlade) {
            return super.canCopy(lookup);
        }
        return true;
    }

    @Override
    public void doCopy(final Lookup lookup) {
        
        final FileObject dir = getTarget(lookup);

        
        //snippet code for multiple file
        //Collection<? extends Node> nodes = new HashSet<Node>(lookup.lookupAll(Node.class));
//        for (Node n : nodes) {
//            DataObject dob = n.getLookup().lookup(DataObject.class);
//            int x = 1;
//        }
        
        //should treat multiple files
        Runnable start = () -> {
            Node node = lookup.lookup(Node.class);
            FileObject file = node.getLookup().lookup(FileObject.class);
            FileObject dirTarget = (dir!= null && dir.isFolder()) ?  dir : file.getParent();

            String name = file.getNameExt();
            String existingFileName = file.getNameExt();
            int counter = 1;
            while(counter < 50 && dirTarget.getFileObject(existingFileName)!= null){
                //shouldn't be the case
                existingFileName = name.substring(0, name.length() - ".blade.php".length()) + "_" + counter + ".blade.php";
                counter++;
            }

            String incrementSuffix = counter > 1 ? "_" + (counter - 1) : "";
            String resultName = existingFileName.substring(0, name.length() - ".blade.php".length()) + incrementSuffix;
            try {
                FileUtil.copyFile(file, dirTarget, resultName, "blade.php");
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
            System.out.println("Copy lookup " + lookup);
        };
        SwingUtilities.invokeLater(start);
    }

    public boolean isBlade(Lookup lookup) {
        boolean ret = false;
        Node node = lookup.lookup(Node.class);

        //hack to identify a blade file ?
        if (node != null && node.getDisplayName().endsWith(".blade.php")) {
            ret = true;
        }
        return ret;
    }

    public static FileObject getTarget(Lookup look) {
        ExplorerContext drop = look.lookup(ExplorerContext.class);
        if (drop == null) {
            return null;
        }
        Node n = drop.getTargetNode();
        if (n == null) {
            return null;
        }
        DataObject dob = n.getCookie(DataObject.class);
        if (dob != null) {
            return dob.getPrimaryFile();
        }
        return null;
    }

    @Override
    public boolean canFindUsages(Lookup lookup) {
        return isBlade(lookup);
    }

    public static boolean isFromEditor(EditorCookie ec) {
        if (ec != null && NbDocument.findRecentEditorPane(ec) != null) {
            TopComponent activetc = TopComponent.getRegistry().getActivated();
            if (activetc instanceof CloneableEditorSupport.Pane) {
                return true;
            }
        }
        return false;
    }

}
