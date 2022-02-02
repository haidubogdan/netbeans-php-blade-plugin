package org.netbeans.modules.php.blade.editor.common;

import java.util.Map;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class FileReferenceModification {

    private Map<FileObject, String> items; //keys order preserving map
    private boolean absolutePathLink;

    FileReferenceModification(Map<FileObject, String> items, boolean absolutePathLink) {
        this.items = items;
        this.absolutePathLink = absolutePathLink;
    }

    public boolean rename(FileObject file, String newName) {
        if(items.get(file) == null) {
            return false;
        }
        String item = items.get(file);
        if(FileReference.DESCENDING_PATH_ITEM.equals(item)) {
            return false; // ../ path items is not affected by folder rename
        }

        items.put(file, newName); //LinkedHashMap preserves the key orders on put of existing key
        return true;
    }

    public String getModifiedReferencePath() {
        StringBuilder b = new StringBuilder();
        if(absolutePathLink) {
            b.append('/'); //initial slash
        }
        for(FileObject file : items.keySet()) {
            String item = items.get(file);
            b.append(item);
            b.append('/'); //NOI18N
        }
        //remove last slash after filename
        return b.deleteCharAt(b.length() - 1).toString();
    }

}
