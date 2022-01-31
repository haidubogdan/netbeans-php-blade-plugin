package org.netbeans.modules.php.blade.editor.lexer;

import org.junit.Test;
import org.netbeans.api.lexer.TokenSequence;



/**
 *
 * @author bhaidu
 */
public class BladeLexerIssuesTest extends BladeLexerTestBase {

    public BladeLexerIssuesTest(String testName) {
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
    
    @Test
    public void testInlineIf() throws Exception {
        performTest("issues/inline_if.blade");
    }
    
    @Test
    public void testJavascriptWithDirectivesIf() throws Exception {
        performTest("issues/javascript_with_directives.blade");
    }
    
}
