package org.netbeans.modules.php.blade.refactoring;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import org.netbeans.modules.parsing.api.Embedding;
import org.netbeans.modules.parsing.api.ParserManager;
import org.netbeans.modules.parsing.api.ResultIterator;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Source;
import org.netbeans.modules.parsing.api.UserTask;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.common.WebUtils;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.netbeans.modules.refactoring.spi.ui.ActionsImplementationProvider;
import org.netbeans.modules.refactoring.spi.ui.RefactoringUI;
import org.netbeans.modules.refactoring.spi.ui.UI;
import org.openide.cookies.EditorCookie;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.nodes.Node;
import org.openide.text.CloneableEditorSupport;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.Mutex;
import org.openide.util.NbBundle;
import org.openide.util.RequestProcessor;
import org.openide.util.lookup.ServiceProvider;
import org.openide.windows.TopComponent;

/**
 *
 * @author bhaidu
 */
//@ServiceProvider(service = ActionsImplementationProvider.class, position = 1060)
public class BladeActionsImplementationProvider extends ActionsImplementationProvider {
//TODO can implement doFindUsages
    private static final RequestProcessor RP = new RequestProcessor(BladeActionsImplementationProvider.class);
    private static final Logger LOG = Logger.getLogger(BladeActionsImplementationProvider.class.getName());

    public boolean canCopy(Lookup lookup) {
        return true;
    }

    public void doCopy(Lookup selectedNodes) {
        EditorCookie ec = selectedNodes.lookup(EditorCookie.class);
        Runnable task;
        if (isFromEditor(ec)) {
            task = new TextComponentTask(ec) {
                @Override
                protected RefactoringUI createRefactoringUI(BladeElementContext context) {
                    return new BladeCopyRefactoringUI(context);
                }
            };
        } else {
            Collection<? extends Node> nodes = selectedNodes.lookupAll(Node.class);
            assert nodes.size() == 1;
            Node currentNode = nodes.iterator().next();
            task = new NodeToFileTask(currentNode) {
                @Override
                protected RefactoringUI createRefactoringUI(BladeElementContext context) {
                    return new BladeCopyRefactoringUI(context);
                }
            };
        }
        RP.post(task);
    }

    private static boolean isFromEditor(EditorCookie ec) {
        if (ec != null && ec.getOpenedPanes() != null) {
            TopComponent activetc = TopComponent.getRegistry().getActivated();
            if (activetc instanceof CloneableEditorSupport.Pane) {
                return true;
            }
        }
        return false;
    }

    private static abstract class NodeToFileTask extends UserTask implements Runnable {

        private final Node node;
        private BladeElementContext context;
        private FileObject fileObject;

        public NodeToFileTask(Node node) {
            this.node = node;
        }

        @Override
        public void run(ResultIterator resultIterator) throws Exception {
            Collection<BladeParserResult> results = new ArrayList<>();
            Snapshot snapshot = resultIterator.getSnapshot();
            try {
                if (BladeLanguage.BLADE_MIME_TYPE.equals(snapshot.getMimeType())) { //NOI18N
                    results.add((BladeParserResult) resultIterator.getParserResult());
                    return;
                }
                for (Embedding e : resultIterator.getEmbeddings()) {
                    run(resultIterator.getResultIterator(e));
                }
            } finally {
                context = new BladeElementContext.File(fileObject, results);
            }
        }

        //runs in RequestProcessor
        @Override
        public void run() {
            DataObject dobj = node.getLookup().lookup(DataObject.class);
            if (dobj != null) {
                Runnable task;
                fileObject = dobj.getPrimaryFile();

                if (fileObject.isFolder()) {
                    //folder
                    task = new Runnable() {
                        @Override
                        public void run() {
                            UI.openRefactoringUI(createRefactoringUI(new BladeElementContext.Folder(fileObject)));
                        }
                    };
                } else {
                    //blade file
                    Source source = Source.create(fileObject);
                    try {
                        ParserManager.parse(Collections.singletonList(source), this);
                        task = new Runnable() {
                            @Override
                            public void run() {
                                UI.openRefactoringUI(createRefactoringUI(context));
                            }
                        };
                    } catch (ParseException ex) {
                        Exceptions.printStackTrace(ex);
                        return;
                    }
                }

                //switch to EDT
                EventQueue.invokeLater(task);
            }

        }

        protected abstract RefactoringUI createRefactoringUI(BladeElementContext context);
    }

    private static abstract class TextComponentTask extends UserTask implements Runnable {

        private final Document document;
        private final int caretOffset;
        private final int selectionStart;
        private final int selectionEnd;
        private RefactoringUI ui;

        public TextComponentTask(EditorCookie ec) {
            JTextComponent textC = ec.getOpenedPanes()[0];
            this.document = textC.getDocument();
            this.caretOffset = textC.getCaretPosition();
            this.selectionStart = textC.getSelectionStart();
            this.selectionEnd = textC.getSelectionEnd();
        }

        @Override
        public void run(ResultIterator ri) throws ParseException {
            Snapshot topLevelSnapshot = ri.getSnapshot();
            ResultIterator cssri = WebUtils.getResultIterator(ri, BladeLanguage.BLADE_MIME_TYPE);

            if (cssri != null) {
                BladeParserResult result = (BladeParserResult) cssri.getParserResult();
                if (result.getProgram() != null) {
                    //the parser result seems to be quite ok,
                    //in case of serious parse issue the parse root is null
                    BladeElementContext context = new BladeElementContext.Editor(result, topLevelSnapshot, caretOffset, selectionStart, selectionEnd);
                    ui = context.isRefactoringAllowed() ? createRefactoringUI(context) : null;
                }
            }
        }

        //runs in RequestProcessor
        @Override
        public final void run() {
            try {
                Source source = Source.create(document);
                ParserManager.parse(Collections.singleton(source), this);
            } catch (ParseException e) {
                LOG.log(Level.WARNING, null, e);
                return;
            }

            //switch to EDT
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    TopComponent activetc = TopComponent.getRegistry().getActivated();

                    if (ui != null) {
                        UI.openRefactoringUI(ui, activetc);
                    } else {
                        JOptionPane.showMessageDialog(null, NbBundle.getMessage(BladeActionsImplementationProvider.class, "ERR_CannotRefactorLoc"));//NOI18N
                    }
                }
            });
        }

        protected abstract RefactoringUI createRefactoringUI(BladeElementContext context);
    }
}
