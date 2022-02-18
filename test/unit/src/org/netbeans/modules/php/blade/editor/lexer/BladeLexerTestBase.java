package org.netbeans.modules.php.blade.editor.lexer;

import java.io.File;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.junit.NbTestCase;
import org.netbeans.php.blade.api.test.BladeTestBase;

/**
 *
 * @author bhaidu
 */
public class BladeLexerTestBase extends BladeTestBase {

    public BladeLexerTestBase(String testName) {
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

    protected String createResult(TokenSequence<?> ts) throws Exception {
        StringBuilder result = new StringBuilder();

        while (ts.moveNext()) {
            TokenId tokenId = ts.token().id();
            CharSequence text = ts.token().text();
            result.append("token #");
            result.append(ts.index());
            result.append(" ");
            result.append(tokenId.name());
            result.append(" *");
            result.append(BladeLexerUtils.replaceLinesAndTabs(text.toString()));
            result.append("*\n");
        }
        return result.toString();
    }

    protected String getTestResult(String filename) throws Exception {
        String content = BladeLexerUtils.getFileContent(new File(getDataDir(), "testfiles/" + filename + ".php"));
        TokenSequence<?> ts = BladeLexerUtils.seqForText(content, BladeTokenId.language());
        System.out.print("\n---Lexer scan for <<" + filename + ">>\n\n");
        return createResult(ts);
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
