package org.netbeans.modules.php.blade.editor.types.api;

import java.util.Collection;

/**
 *
 * @author bhaidu
 */
public interface DeclarationScope {

    DeclarationScope getParentScope();

    Collection<? extends DeclarationScope> getChildrenScopes();

    void addDeclaredScope(DeclarationScope scope);
}
