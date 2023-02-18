package org.netbeans.modules.php.blade.editor.lexer;

import org.junit.Test;
import org.netbeans.api.lexer.TokenSequence;



/**
 *
 * @author bhaidu
 */
public class BladeASTLexerTest extends BladeLexerASTTestBase {

    public BladeASTLexerTest(String testName) {
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
    
    
//    @Test
//    public void test1() throws Exception {
//        performTest("ast/test1.blade");
//    }
//    
//    @Test
//    public void test2() throws Exception {
//        performTest("ast/test2.blade");
//    }
    
    @Test
    public void testIfElseIf() throws Exception {
        performTest("ast/if_elseif.blade");
    }
}
