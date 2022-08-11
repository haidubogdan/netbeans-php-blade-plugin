package org.netbeans.modules.php.blade.editor.formatter;

import org.netbeans.modules.php.blade.editor.lexer.*;
import java.io.File;
import java.io.StringReader;
import java.util.List;
import java_cup.runtime.Symbol;
import org.junit.Test;
import org.netbeans.api.editor.document.LineDocumentUtils;
import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.junit.NbTestCase;
import org.netbeans.modules.csl.api.GsfLanguage;
import org.netbeans.modules.csl.core.LanguageRegistry;
import org.netbeans.modules.csl.spi.GsfUtilities;
import org.netbeans.modules.php.blade.editor.BladeLanguage;
import org.netbeans.modules.php.blade.editor.parsing.ASTBladeParser;
import org.netbeans.modules.php.blade.editor.parsing.ASTBladeScanner;
import org.netbeans.modules.php.blade.editor.parsing.ParsingUtils;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeProgram;
import org.netbeans.php.blade.api.test.BladeTestBase;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.text.FilterDocument;

/**
 *
 * @author bhaidu
 */
public class FormatVisitorTest extends BladeTestBase {

    public FormatVisitorTest(String testName) {
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

    protected String createResult(BaseDocument doc, TokenSequence<?> ts, List<FormatToken> formatTokens) throws Exception {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < formatTokens.size()) {
            FormatToken tokenF = formatTokens.get(index);
            ts.move(tokenF.getOffset());
            ts.moveNext();
            if (ts.token() != null) {
                TokenId tokenId = ts.token().id();
                CharSequence text = ts.token().text();
                result.append(ts.index());
                result.append(" ");
                result.append(tokenId.name());
                result.append(" ");
                result.append(BladeLexerUtils.replaceLinesAndTabs(text.toString()));
                result.append("\n");
            }
//            int newLineIndex = 0;
//            int indentOffset = 0;
//            
//            while (tokenF.getOldText()!= null && newLineIndex < tokenF.getOldText().length() && 
//                    tokenF.getOldText().charAt(newLineIndex) == '\n'){
//                newLineIndex++;
//                indentOffset++;
//            }
            int textLength = 0;
            if (tokenF.getOldText()!= null){
                textLength = tokenF.getOldText().length();
            }
            result.append("\t");
            int lineNr = LineDocumentUtils.getLineStart(doc, tokenF.getOffset());
            result.append(" - offset line - ");
            result.append(lineNr);
            if (textLength > 0){
                int lineNrEnd = LineDocumentUtils.getLineStart(doc, tokenF.getOffset() + textLength);
                if (lineNrEnd != lineNr){
                    result.append("(");
                    result.append(lineNrEnd);
                    result.append(")");
                }
            }
            result.append(" - ");
            result.append(tokenF.getId());
            result.append(" - ");
            result.append(tokenF.getOffset());
            result.append(" <<");
            result.append(tokenF.getOldText());
            result.append(">>");
            result.append("\n");
            index++;
        }

        return result.toString();
    }

    protected String getTestResult(String filename) throws Exception {
        File filePath = new File(getDataDir(), "testfiles/" + filename + ".php");
        String content = BladeLexerUtils.getFileContent(filePath);
        TokenSequence<? extends BladeTokenId> ts = BladeLexerUtils.seqForText(content, BladeTokenId.language());
        System.out.print("\n---Format scan for <<" + filename + ">>\n\n");
        ParsingUtils parsingUtils = new ParsingUtils();
        FileObject fo = FileUtil.toFileObject(filePath);

//        FakeFileObject file = parsingUtils.createFileObject(content);
//        BaseDocument doc = (BaseDocument) parsingUtils.openDocument(fo);
        BaseDocument doc = getDocument(content, BladeLanguage.BLADE_MIME_TYPE, BladeTokenId.language());
        TokenFormatter.DocumentOptions docOptions = new TokenFormatter.DocumentOptions(doc);
        FormatVisitor formatVisitor = new FormatVisitor(doc, docOptions, 0, 0, doc.getLength());
        ASTBladeScanner scanner = new ASTBladeScanner(new StringReader(content));
        ASTBladeParser parser = new ASTBladeParser(scanner);
        Symbol root = parser.parse();
        if (root == null) {
            return null;
        }
        BladeProgram program = (BladeProgram) root.value;
        formatVisitor.scan(program);
        List<FormatToken> formatTokens = formatVisitor.getFormatTokens();

        return createResult(doc, ts, formatTokens);
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

    @Test
    public void testIf() throws Exception {
        performTest("format/if.blade");
    }

    @Test
    public void testIfSimple() throws Exception {
        performTest("format/if_simple.blade");
    }

    public BaseDocument getDocument(String s, final String mimeType, final Language language) {
        try {
            BaseDocument doc = new BaseDocument(true, mimeType) {
                @Override
                public boolean isIdentifierPart(char ch) {
                    if (mimeType != null) {
                        org.netbeans.modules.csl.core.Language l = LanguageRegistry.getInstance().getLanguageByMimeType(mimeType);
                        if (l != null) {
                            GsfLanguage gsfLanguage = l.getGsfLanguage();
                            if (gsfLanguage != null) {
                                return gsfLanguage.isIdentifierChar(ch);
                            }
                        }
                    }

                    return super.isIdentifierPart(ch);
                }
            };

            //doc.putProperty("mimeType", mimeType);
            doc.putProperty(org.netbeans.api.lexer.Language.class, language);

            doc.insertString(0, s, null);

            return doc;
        } catch (Exception ex) {
            fail(ex.toString());
            return null;
        }
    }
}
