package org.netbeans.modules.php.blade.editor.parsing.astnodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bhaidu
 */
public class Block extends Statement {

    private final ArrayList<Statement> statements = new ArrayList<>();
    private Expression inlineText;

    private Block(int start, int end, Statement[] statements) {
        super(start, end);
        this.statements.addAll(Arrays.asList(statements));
    }

    public Block(int start, int end, List<Statement> statements) {
        this(start, end, statements == null ? new Statement[0] : statements.toArray(new Statement[statements.size()]));
    }

    public Block(int start, int end, Expression value) {
        super(start, end);
        this.inlineText = value;
    }

    /**
     * Retrieves the statement parts of this block
     * @return statement parts of this block
     */
    public List<Statement> getStatements() {
        return this.statements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Statement statement : getStatements()) {
            sb.append(statement).append(" "); //NOI18N
        }
        return sb.toString(); //NOI18N
    }

}
