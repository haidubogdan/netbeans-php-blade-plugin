package org.netbeans.modules.php.blade.editor.model;

import org.netbeans.modules.php.blade.editor.parsing.astnodes.DirectiveNamedStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.DirectiveWithPath;
import org.openide.filesystems.FileObject;

/**
 *
 * @author bhaidu
 */
public class DirectiveOccurence extends BaseOccurence {
    public DirectiveOccurence(DirectiveWithPath node, FileObject file){
        super(node, file);
    }
}
