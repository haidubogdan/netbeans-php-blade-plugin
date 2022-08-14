package org.netbeans.modules.php.blade.editor.lexer;

import java.io.File;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java_cup.runtime.Symbol;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.junit.NbTestCase;
import org.netbeans.modules.php.blade.editor.parsing.ASTBladeScanner;
import org.netbeans.modules.php.blade.editor.parsing.ASTBladeSymbols;
import org.netbeans.php.blade.api.test.BladeTestBase;

/**
 *
 * @author bhaidu
 */
public class BladeLexerASTTestBase extends BladeTestBase {

    public BladeLexerASTTestBase(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    protected String createResult(ASTBladeScanner scanner) throws Exception {
        StringBuilder result = new StringBuilder();
        Field fields[] = ASTBladeSymbols.class.getDeclaredFields();
        Field scannerFields[] = ASTBladeScanner.class.getDeclaredFields();
        Symbol symbol;
        int index = 0;
        do {
            symbol = scanner.next_token();
            int state = scanner.getState();
            index++;
            result.append("token #");
            result.append(index);
            result.append(" ");
            result.append("state (");
            result.append(state);
            result.append(" ");
            String stateName = indexOf(scannerFields, state);
            result.append(stateName);
            result.append(") ");
            result.append(symbol.sym);
            result.append(" ");
            String fieldName = indexOf(fields, symbol.sym);
            result.append(fieldName);
            result.append(" ");
            if (symbol.value != null) {
                result.append("`");
                result.append(BladeLexerUtils.replaceLinesAndTabs(symbol.value.toString()));
                result.append("`");
            } else {
                result.append("null");
            }
            result.append("\n");
            //symbol.
//            TokenId tokenId = ts.token().id();
//            CharSequence text = ts.token().text();
//            result.append("token #");
//            result.append(ts.index());
//            result.append(" ");
//            result.append(tokenId.name());
//            result.append(" ");
//            result.append(BladeLexerUtils.replaceLinesAndTabs(text.toString()));
//            result.append("\n");
        } while (symbol.sym != ASTBladeSymbols.EOF);

        return result.toString();
    }

    protected String indexOf(Field[] fields, int symbol) {
        for (Field field : fields) {
            String fieldName = field.getName();
            try {
                Object value = field.get(field);
                if (value.equals(symbol)) {
                    return fieldName;
                }
            } catch (Exception ex) {

            }
//            if (field.v)
        }
        return " - undefined -";
    }

    protected String getTestResult(String filename) throws Exception {
        String content = BladeLexerUtils.getFileContent(new File(getDataDir(), "testfiles/" + filename + ".php"));
        ASTBladeScanner scanner = new ASTBladeScanner(new StringReader(content));
        TokenSequence<?> ts = BladeLexerUtils.seqForText(content, BladeTokenId.language());
        System.out.print("\n---AST Lexer scan for <<" + filename + ">>\n\n");
        return createResult(scanner);
    }

    protected void performTest(String filename) throws Exception {
        performTest(filename, null);
    }

    protected String getTestResult(String filename, String caretLine) throws Exception {
        return getTestResult(filename);
    }

    protected void performTest(String filename, String caretLine) throws Exception {
        // parse the file
        String result = getTestResult(filename, caretLine);
        System.out.print(result);
    }
}
