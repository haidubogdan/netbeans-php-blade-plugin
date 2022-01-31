package org.netbeans.modules.php.blade.editor.parsing;

import java.io.File;
import java.net.URL;
import java.util.Stack;
import java_cup.runtime.Symbol;
import java_cup.runtime.lr_parser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenHierarchy;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.TokenSequence;

import static org.junit.Assert.*;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.*;

/**
 *
 * @author bhaidu
 */
public class ASTBladeParserTest{
    
    public ASTBladeParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testFileParsing() throws Exception {
        performTest("data/testfiles/ast/if_elseif.blade.php");
    }
    
    @Test
    public void testFile1() throws Exception {
        performTest("data/testfiles/ast/test1.blade.php");
    }
    
    protected void performTest(String filename) throws Exception {
        performTest(filename, null);
    }
    
    protected void performTest(String filename, String caretLine) throws Exception {
        // parse the file
        String result = getTestResult(filename);
      }
    protected String getTestResult(String filename) throws Exception {
        // the same <Comment /> is shown twice becase the scanner is used twice
        URL codebase = getClass().getProtectionDomain().getCodeSource().getLocation();
        File testFile = new File(new File(codebase.toURI()), filename);
        //File testFile = new File("data/", filename + ".php");
        StringBuilder result = new StringBuilder();
        if(!testFile.exists()) {
            throw new Exception("File " + testFile.getPath() + " doesn't exist");
        }
        
        String content = getFileContent(testFile);
        ASTBladeScanner scanner = new ASTBladeScanner(new StringReader(content));
//
        Symbol symbol;
        result.append("<testresult testFile='").append(testFile.getName()).append("'>\n");
        result.append("    <scanner>\n");
        do {
            symbol = scanner.next_token();
            result.append("        <token id='").append(getASTScannerTokenName(symbol.sym)).append("' start='");
            result.append(symbol.left).append("' end='").append(symbol.right).append("'>\n");
            result.append("            <text>");
            result.append(getXmlStringValue(content.substring(symbol.left, symbol.right)));
            result.append("</text>\n");
            result.append("        </token>\n");
        } while (symbol.sym != ASTBladeSymbols.EOF);
        result.append("    </scanner>\n");
//
        scanner.reset(new FileReader(testFile));
        ASTBladeParser parser = new ASTBladeParser(scanner);
        Symbol root = parser.parse();
        if (root != null && root.value instanceof ASTNode){
            //System.out.print("Root found!");
            ASTNode rootnode = (ASTNode)root.value;
            //System.out.print(root.value);
            result.append((new PrintASTVisitor()).printTree(rootnode, 1));
            if (root.value instanceof BladeProgram){
                System.out.print("it's a blade program\n");
                BladeProgram program = (BladeProgram) root.value;
                List<Statement> statements = program.getStatements();
                
                if (statements.isEmpty()){
                    System.out.print("no statements found\n");
                }
                for (Statement statement : statements) {
                    //System.out.print(statement.toString() + "\n");
                    if (statement instanceof BladeSectionStatement){
                        BladeSectionStatement st = (BladeSectionStatement) statement;
                        Block body = st.getBody();
                        //System.out.print(body);
                    }
                }
            }
        } else {
            System.out.print("No root");
        }
        result.append("</testresult>\n");
        System.out.print(result);
        return result.toString();
    }
    
    public static String getFileContent (File file) throws Exception{
        StringBuffer sb = new StringBuffer();
        String lineSep = "\n";//NOI18N
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(lineSep);
            line = br.readLine();
        }
        br.close();
        return sb.toString();
    }
    
    public static String getASTScannerTokenName(int id) {
        String name;
        switch (id) {
            case ASTBladeSymbols.T_INLINE_HTML:
                name = "inline_html";
                break;
            case ASTBladeSymbols.T_BLADE_SECTION:
                name = "blade_section";
                break;
            case ASTBladeSymbols.T_BLADE_EXTENDS:
                name = "blade_extends";
                break;    
            case ASTBladeSymbols.T_BLADE_ENDSECTION:
                name = "blade_endsection";
                break;
            case ASTBladeSymbols.T_BLADE_YIELD:
                name = "blade_yield";
                break;     
            case ASTBladeSymbols.T_OPEN_PARENTHESE:
                name = "(";
                break;
            case ASTBladeSymbols.T_CLOSE_PARENTHESE:
                name= ")";
                break;
            case ASTBladeSymbols.T_STRING:
                name = "string";
                break;
            case ASTBladeSymbols.T_PHP_LOOP_EXPRESSION:
                name = "php loop expr";
                break;
            default:
                name="unkown";
        }
        return name;
    }
    
    public static String getXmlStringValue(String input) {
        String escapedString = input;
        escapedString = escapedString.replaceAll("&", "&amp;"); //$NON-NLS-1$ //$NON-NLS-2$
        escapedString = escapedString.replaceAll(">", "&gt;"); //$NON-NLS-1$ //$NON-NLS-2$
        escapedString = escapedString.replaceAll("<", "&lt;"); //$NON-NLS-1$ //$NON-NLS-2$
        escapedString = escapedString.replaceAll("'", "&apos;"); //$NON-NLS-1$ //$NON-NLS-2$
        escapedString = replaceLinesAndTabs(escapedString);
        return escapedString;
    }
    
    public static String replaceLinesAndTabs(String input) {
        String escapedString = input;
        escapedString = escapedString.replaceAll("\n","\\\\n");
        escapedString = escapedString.replaceAll("\r","\\\\r");
        escapedString = escapedString.replaceAll("\t","\\\\t");
        return escapedString;
    }
}
