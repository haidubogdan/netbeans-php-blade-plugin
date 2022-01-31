package org.netbeans.modules.php.blade.editor.parsing.astnodes;

/**
 *
 * @author bhaidu
 */
public interface DirectiveNamedStatement {
    public DirectiveName getDirectiveName();
    public int getStartOffset();
    public int getEndOffset();
}
