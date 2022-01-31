package org.netbeans.modules.php.blade.refactoring;

import java.util.Collection;
import javax.swing.text.Document;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.openide.filesystems.FileObject;
import org.openide.nodes.Node;

/**
 *
 * @author bhaidu
 */
public abstract class BladeElementContext {

    public abstract boolean isRefactoringAllowed();

    public abstract String getElementName();

    public abstract FileObject getFileObject();

    public static abstract class AbstractFileContext extends BladeElementContext {

        private FileObject fo;

        public AbstractFileContext(FileObject fo) {
            this.fo = fo;
        }

        @Override
        public FileObject getFileObject() {
            return fo;
        }

        @Override
        public String getElementName() {
            return getFileObject().getName();
        }
    }

    public static class Folder extends AbstractFileContext {

        public Folder(FileObject folder) {
            super(folder);
        }

        @Override
        public boolean isRefactoringAllowed() {
            return true;
        }
    }

    public static class File extends AbstractFileContext {

        private Collection<BladeParserResult> results;

        public File(FileObject fileObject, Collection<BladeParserResult> result) {
            super(fileObject);
            this.results = result;
        }

        public Collection<BladeParserResult> getParserResults() {
            return results;
        }

        @Override
        public boolean isRefactoringAllowed() {
            return true;
        }
    }

    public static class Editor extends BladeElementContext {

        private int caretOffset;
        private int selectionFrom, selectionTo;
        private Node element;
        private BladeParserResult result;
        private Snapshot topLevelSnapshot;

        public Editor(BladeParserResult result, Snapshot topLevelSnapshot, int caretOffset, int selectionFrom, int selectionTo) {
            this.result = result;
            this.caretOffset = caretOffset;
            this.selectionFrom = selectionFrom;
            this.selectionTo = selectionTo;
            this.element = findCurrentElement();
            this.topLevelSnapshot = topLevelSnapshot;

            assert element != null; //at least the root node should always be found
        }

        //XXX make it only caret position sensitive for now
        private Node findCurrentElement() {
            
            return null;
        }

        public Document getDocument() {
            return result.getSnapshot().getSource().getDocument(false);
        }

        public Snapshot getTopLevelSnapshot() {
            return topLevelSnapshot;
        }

        public BladeParserResult getParserResult() {
            return result;
        }

        @Override
        public FileObject getFileObject() {
            return getParserResult().getSnapshot().getSource().getFileObject();
        }

        public int getCaret() {
            return caretOffset;
        }

        public int getSelectionFrom() {
            return selectionFrom;
        }

        public int getSelectionTo() {
            return selectionTo;
        }

        public Node getElement() {
            return element;
        }

//        public Node getSimpleSelectorElement() {
//            return  NodeUtil.getAncestorByType(getElement(), NodeType.simpleSelectorSequence);
//        }
        @Override
        public String getElementName() {
            return "";
        }

        @Override
        public boolean isRefactoringAllowed() {
            return true;
        }
    }
}
