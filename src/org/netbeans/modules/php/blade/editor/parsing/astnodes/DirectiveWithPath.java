package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public interface DirectiveWithPath extends DirectiveNamedStatement {
    public Expression getLabel();
}
