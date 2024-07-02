/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.lexer;

import javax.swing.text.Document;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.api.project.Project;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.editor.NbEditorUtilities;
import org.netbeans.modules.php.blade.project.ProjectUtils;
import org.netbeans.modules.php.editor.lexer.PHPTokenId;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;

/**
 *
 * @author bogdan
 */
public class EditorUtils {

    public static TokenSequence<PHPTokenId> getTokenSequence(Document doc, int offset) {
        BaseDocument baseDoc = (BaseDocument) doc;
        TokenSequence<PHPTokenId> tokenSequence = null;
        baseDoc.readLock();
        try {
            TokenHierarchy<Document> hierarchy = TokenHierarchy.get(baseDoc);
            tokenSequence = hierarchy.tokenSequence(PHPTokenId.language());
        } finally {
            baseDoc.readUnlock();
        }
        if (tokenSequence != null) {
            tokenSequence.move(offset);
            tokenSequence.moveNext();
        }
        return tokenSequence;

    }
    
    public static FileObject getFileObjectFromDoc(Document doc) {
        DataObject dObject = NbEditorUtilities.getDataObject(doc);
        if (dObject != null) {
            return dObject.getPrimaryFile().getParent();
        }
        return null;
    }
    
    public static Project getProjectOwner(Document doc) {
        FileObject file = getFileObjectFromDoc(doc);
        if (file == null){
            return null;
        }
        return ProjectUtils.getMainOwner(file);
    }
}
