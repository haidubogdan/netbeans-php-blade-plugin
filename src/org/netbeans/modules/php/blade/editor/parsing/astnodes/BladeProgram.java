package org.netbeans.modules.php.blade.editor.parsing.astnodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.netbeans.modules.php.editor.parser.PHPParseResult;

/**
 *
 * @author bhaidu
 */
public class BladeProgram extends ASTNode {
    private final ArrayList<Statement> statements = new ArrayList<>();
    private final PHPParseResult phpParserResult;

    private BladeProgram(int start, int end, Statement[] statements, PHPParseResult phpParserResult) {
        super(start, end);
        this.statements.addAll(Arrays.asList(statements));
        this.phpParserResult = phpParserResult;
    }

    public BladeProgram(int start, int end, List<Statement> statements,PHPParseResult phpParserResult) {
        this(start, end, statements.toArray(new Statement[statements.size()]), phpParserResult);
    }

    /**
     * Retrieves the statement list of this program.
     *
     * @return statement parts of this program
     */
    public List<Statement> getStatements() {
        return this.statements;
    }

    public PHPParseResult getPhpParserResult(){
        return phpParserResult;
    }
   
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sbStatements = new StringBuilder();
        for (Statement statement : getStatements()) {
            sbStatements.append(statement).append(" "); //NOI18N
        }
        return sbStatements.toString(); //NOI18N
    }
}
