package org.netbeans.modules.php.blade.editor.completion;

import org.netbeans.modules.php.blade.syntax.DirectivesList;
import org.netbeans.modules.php.blade.syntax.annotation.Directive;

public final class DirectiveCompletionList {

    public Directive[] getDirectives() {
        DirectivesList listClass = new DirectivesList();
        return listClass.getDirectives();
    }
}
