package org.netbeans.modules.php.blade.editor.lexer;

import org.junit.Test;
import org.netbeans.api.lexer.TokenSequence;



/**
 *
 * @author bhaidu
 */
public class BladeLexerTest extends BladeLexerTestBase {

    public BladeLexerTest(String testName) {
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
    
    public void testHtml() throws Exception {
        TokenSequence<?> ts = BladeLexerUtils.seqForText("<html>", BladeTokenId.language());
        BladeLexerUtils.next(ts, BladeTokenId.T_HTML, "<html>");
    }
//    
//    @Test
//    public void testIf() throws Exception {
//        performTest("if.blade");
//    }
//    
//    @Test
//    public void testBadIf() throws Exception {
//        performTest("if_bad.blade");
//    }
//    
//    @Test
//    public void testIfComplexCondition() throws Exception {
//        performTest("if_complex_condition.blade");
//    }
//    
//    @Test
//    public void testForeach() throws Exception {
//        performTest("foreach.blade");
//    }
//    
//    @Test
//    public void testSection() throws Exception {
//        performTest("section.blade");
//    }
//    
//    @Test
//    public void testYield() throws Exception {
//        performTest("yield.blade");
//    }
//    
//    @Test
//    public void testInclude() throws Exception {
//        performTest("include.blade");
//    }
    
    @Test
    public void testCustomDirective() throws Exception {
        performTest("custom_directive.blade");
    }
//    
//    @Test
//    public void testInlinePhp() throws Exception {
//        performTest("inline_php.blade");
//    }
//    
//    @Test
//    public void testEscapedEchi() throws Exception {
//        performTest("escaped_echo.blade");
//    }
}
