package org.netbeans.modules.php.blade.editor.formatter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.EditorRegistry;
import org.netbeans.api.editor.document.LineDocumentUtils;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.spi.GsfUtilities;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.netbeans.spi.lexer.MutableTextInput;


/**
 * TODO INCOMPLETE CURRENT ISSUES html indent
 *
 * @author bhaidu
 */
public class TokenFormatter {

    protected static final String TEMPLATE_HANDLER_PROPERTY = "code-template-insert-handler";
    private static final String EMPTY_STRING = "";
    private static final Logger LOGGER = Logger.getLogger(TokenFormatter.class.getName());
    // it's for testing
    private static int unitTestCarretPosition = -1;

    public TokenFormatter() {
    }

    protected static void setUnitTestCarretPosition(int unitTestCarretPosition) {
        TokenFormatter.unitTestCarretPosition = unitTestCarretPosition;
    }

    protected static class DocumentOptions {

        public int continualIndentSize;
        public int initialIndent;
        public int indentSize;
        public int indentArrayItems;
        public int margin;
        public int tabSize;
        public int beforeDirectiveTagPlacement;
        public boolean expandTabsToSpaces;

        public DocumentOptions(BaseDocument doc) {
            CodeStyle codeStyle = CodeStyle.get(doc);
            continualIndentSize = codeStyle.getContinuationIndentSize();
            initialIndent = codeStyle.getInitialIndent();
            indentSize = codeStyle.getIndentSize();
            beforeDirectiveTagPlacement = 4;
            margin = codeStyle.getRightMargin();
            tabSize = codeStyle.getTabSize();
            expandTabsToSpaces = codeStyle.expandTabToSpaces();
        }

    }

    public void reformat(final Context formatContext, ParserResult info) {
        final BaseDocument doc = (BaseDocument) formatContext.document();
        final BladeParserResult bladeParseResult = ((BladeParserResult) info);
        final DocumentOptions docOptions = new DocumentOptions(doc);
        
        doc.runAtomic(new Runnable() {
            @Override
            public void run() {
                final AtomicLong start = new AtomicLong(System.currentTimeMillis());
                final boolean templateEdit = GsfUtilities.isCodeTemplateEditing(doc);
                JTextComponent lastFocusedComponent = templateEdit ? EditorRegistry.lastFocusedComponent() : null;
                final int caretOffset = lastFocusedComponent != null
                        ? lastFocusedComponent.getCaretPosition()
                        : unitTestCarretPosition == -1 ? 0 : unitTestCarretPosition;
                FormatVisitor fv = new FormatVisitor(doc, docOptions, caretOffset, formatContext.startOffset(), formatContext.endOffset());
                bladeParseResult.getProgram().accept(fv);
                final List<FormatToken> formatTokens = fv.getFormatTokens();

                if (LOGGER.isLoggable(Level.FINE)) {
                    long end = System.currentTimeMillis();
                    LOGGER.log(Level.FINE, "Creating formating stream took: {0} ms", (end - start.get()));
                }
                if (LOGGER.isLoggable(Level.FINE)) {
                    TokenSequence<? extends BladeTokenId> ts = BladeLexerUtils.getBladeMarkupTokenSequence(doc, 0);
                    if (ts == null) {
                        return;
                    }
                    LOGGER.log(Level.FINE, "Tokens in TS: {0}", ts.tokenCount());
                    LOGGER.log(Level.FINE, "Format tokens: {0}", formatTokens.size());
                }
                
                MutableTextInput mti = (MutableTextInput) doc.getProperty(MutableTextInput.class);
                int indent = docOptions.initialIndent;
                int lastBladeIndent = 0;
                boolean caretInTemplateSolved = false;
                final Deque<Integer> lastDirectiveStartIndent = new ArrayDeque<>();
                int deltaForLastMoveBeforeLineComment = 0;
                int index = 0;
                int newLines;
                //int delta = 0;
                int column = 0;
                int countSpaces;
                String newText = null;
                String oldText;
                //ass all directives are standalone we will need it
                int htmlIndent = 0;
                boolean lastH = false;
                int changeOffset = -1;
                boolean stopReplace = false;

                Whitespace ws;
                FormatToken formatToken;
                FormatToken.IndentToken lastIndentToken = null;
                FormatToken lastFormatToken = null;
                FormatToken lastWhitespaceToken = null;
                try {
                    mti.tokenHierarchyControl().setActive(false);
                    start.set(System.currentTimeMillis());
                    while (index < formatTokens.size()) {
                        formatToken = formatTokens.get(index);
                        FormatToken.Kind id = formatToken.getId();
                        changeOffset = formatToken.getOffset();
                        int spaceCount = 0;
                        int indentValue = 0;
                        int totalIndent = 0;
                        boolean endTag = false;
                        switch (id) {
                            case WHITESPACE:
                                lastWhitespaceToken = formatToken;
                                break;
                            case INDENT:
                                if (formatToken instanceof FormatToken.IndentToken) {
                                    FormatToken.IndentToken indentToken = (FormatToken.IndentToken) formatToken;
                                    lastIndentToken = indentToken;
                                    indentValue = indentToken.getDelta();
                                    indent += indentToken.getDelta();
                                    int xxx = 1;
                                } else if (formatToken instanceof FormatToken.HtmlIndentToken) {
                                    //FormatToken.HtmlIndentToken indentToken = (FormatToken.HtmlIndentToken) formatToken;
                                    //htmlIndent = indentToken.getDelta();
                                }
                                break;
                            case WHITESPACE_BEFORE_DIRECTIVE_ENDTAG:
                                endTag = true;
                            case WHITESPACE_BEFORE_DIRECTIVE_START_TAG:
                            case WHITESPACE_BEFORE_DIRECTIVE_TAG:
                                int indentInsert = indent;
                                if (lastIndentToken != null){
                                    spaceCount = lastIndentToken.tokenSpaceCount();
                                }
                                if (indent > 0 && indent >= spaceCount){
                                    if (endTag){
                                        //indent -= indentValue;
                                    }
                                    insert(changeOffset, delta, new String(new char[indent]).replace("\0", " "));
                                } else {
                                    //might need to replace
                                }
//                                htmlIndent = suggestedIndent(changeOffset);
//                                htmlIndent = 0;
//                                int decrementOffset = 0;
//                                if (id == FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_ENDTAG) {
//                                    decrementOffset = 4;
//                                }
//
//                                if (lastFormatToken != null && lastFormatToken.isWhitespace()) {
//
//                                }
//                                int currentLine = LineDocumentUtils.getLineStart(doc, changeOffset + delta);
//                                if (lastIndentToken != null && lastIndentToken.isWhitespace()) {
//                                    int indentOffset = 0;
//                                    int newLineIndex = 0;
//                                    while (newLineIndex < lastIndentToken.getOldText().length()
//                                            && lastIndentToken.getOldText().charAt(newLineIndex) == '\n') {
//                                        newLineIndex++;
//                                        indentOffset++;
//                                    }
//                                    if (isOnSameLine(changeOffset + delta, lastIndentToken.getOffset() + indentOffset)) {
//                                        String whitespace = lastIndentToken.getOldText();
//                                        if (whitespace != null && whitespace.length() > 1) {
//                                            for (char c : whitespace.toCharArray()) {
//                                                if (c == ' ') {
//                                                    spaceCount++;
//                                                }
//                                            }
//                                        }
//                                        totalIndent = indent + htmlIndent - decrementOffset;
//                                        if (totalIndent > 0) {
//                                            if (spaceCount < totalIndent) {
//                                                insert(changeOffset, delta, new String(new char[totalIndent]).replace("\0", " "));
//                                            } else {
//                                                //might have to replace
//                                                int diffWhitespace = totalIndent - spaceCount;
//                                                if (diffWhitespace > 0) {
//                                                    replace(lastIndentToken.getOffset() + indentOffset, delta, diffWhitespace, new String(new char[diffWhitespace]).replace("\0", " "));
//                                                } else {
//                                                    diffWhitespace = Math.abs(diffWhitespace);
//                                                    //replace(lastIndentToken.getOffset() + indentOffset, delta, diffWhitespace, "");
//                                                }
//                                            }
//                                        } else if (totalIndent == 0) {
//                                            if (spaceCount > 0) {
//                                                //replace(lastIndentToken.getOffset() + indentOffset, delta, spaceCount, "");
//                                            }
//                                        }
//                                    }
//                                } else if (currentLine == 0) {
//                                    //first row
//                                    if (lastWhitespaceToken != null) {
//                                        int diffWhitespace = changeOffset - lastWhitespaceToken.getOffset();
//                                        if (diffWhitespace > 0) {
//                                            //replace(lastWhitespaceToken.getOffset(), delta, diffWhitespace, "");
//                                        }
//                                    }
//                                }
                                break;
                            case WHITESPACE_BEFORE_HTML:
                                 if (lastFormatToken != null && lastFormatToken.getId() == FormatToken.Kind.WHITESPACE_AFTER_ECHO) {
                                     break;
                                }
                                int suggestedIndent = suggestedIndent(changeOffset);
                                if (suggestedIndent < indent){
                                    //blocking html indent until fixes to inline attributes are fixed
                                    //insert(changeOffset - 1, delta, new String(new char[indent]).replace("\0", " "));
                                }
                                break;
                            case WHITESPACE_DECREMENT_INDENT:
                                indent -= 4;
                                break;
                            case WHITESPACE_BEFORE_DIRECTIVE_PAREN:
                                if (lastFormatToken != null
                                        && lastFormatToken.isWhitespace()
                                        && lastFormatToken.getOldText().length() > 0) {
                                    int whitespaceOffset = lastFormatToken.getOffset();
                                    int xxx = 1;
                                    //replace(whitespaceOffset, delta, changeOffset - whitespaceOffset, "");
                                }
                                break;
                            case WHITESPACE_BEFORE_BLADE_PHP:
                                break;
                            case WHITESPACE_BEFORE_BLADE_PHP_BODY:
                                htmlIndent = suggestedIndent(changeOffset);
                                totalIndent = indent + htmlIndent;
                                FormatToken.PhpBladeToken phpFormatToken = (FormatToken.PhpBladeToken) formatToken;
                                String phpCode = phpFormatToken.getText();
                                int endOffset = changeOffset + phpCode.length();
                                int nrLines = LineDocumentUtils.getLineCount(doc, changeOffset, endOffset);
                                try {
                                    int lineIndex = LineDocumentUtils.getLineIndex(doc, changeOffset);
                                    int startLine = LineDocumentUtils.getLineStartFromIndex(doc, lineIndex);
                                    int wordStart = LineDocumentUtils.getWordStart(doc, startLine);
                                    String word = LineDocumentUtils.getWord(doc, wordStart);

                                    for (int i = 0; i < nrLines; i++) {
                                        startLine = LineDocumentUtils.getLineStartFromIndex(doc, lineIndex);

                                        if (LineDocumentUtils.isLineWhitespace(doc, startLine)) {
                                            lineIndex++;
                                            continue;
                                        }

                                        wordStart = LineDocumentUtils.getWordStart(doc, startLine);
                                        word = LineDocumentUtils.getWord(doc, wordStart);
                                        if (word.equals("\n")) {
                                            wordStart = LineDocumentUtils.getNextWordStart(doc, wordStart);
                                            word = LineDocumentUtils.getWord(doc, wordStart);
                                            startLine = wordStart;
                                        }

                                        int diffOffset = totalIndent - word.length();

                                        if (diffOffset > 0 || word.trim().length() > 0) {
                                            String whitespace = new String(new char[diffOffset]).replace("\0", " ");
                                            doc.insertString(wordStart, whitespace, null);
                                            delta += whitespace.length();
                                        }
                                        lineIndex++;
                                    }
                                } catch (BadLocationException ex) {

                                }
                                int xxx = 1;
                                break;
                        }

                        //countSpaces = 3;
                        //replace(formatToken.getOffset(), countSpaces, "  ");
                        lastFormatToken = formatToken;
                        index++;
                    }

                } finally {
                    mti.tokenHierarchyControl().setActive(true);
                }
                if (LOGGER.isLoggable(Level.FINE)) {
                    long end = System.currentTimeMillis();
                    LOGGER.log(Level.FINE, "Applaying format stream took: {0} ms", (end - start.get())); // NOI18N
                }
            }

            private int delta = 0;
            private int indent = 0;
            
            private int suggestedIndent(int changeOffset) {
                Map<Integer, Integer> suggestedLineIndents = (Map<Integer, Integer>) doc.getProperty("AbstractIndenter.lineIndents"); // NOI18N
                try {
                    int lineNumber = LineDocumentUtils.getLineIndex(doc, changeOffset);
                    Integer suggestedIndent = suggestedLineIndents != null
                            ? suggestedLineIndents.get(lineNumber)
                            : Integer.valueOf(0);
                    if (suggestedIndent == null) {
                        suggestedIndent = suggestedLineIndents.get(lineNumber + 1) != null
                                ? suggestedLineIndents.get(lineNumber + 1)
                                : Integer.valueOf(0);
                    }
                    return suggestedIndent;
                } catch (BadLocationException ex) {

                }
                return 0;
            }

            private void replace(int offset, int deltaOffset, int vlength, String newString) {
                try {
                    String oldText = doc.getText(offset + deltaOffset, vlength);
                    if (newString.equals(oldText)) {
                        return;
                    }
                    doc.remove(offset + deltaOffset, vlength);
                    delta -= vlength;
                } catch (BadLocationException ex) {
                    LOGGER.log(Level.INFO, null, ex);
                }
            }

            private void insert(int offset, int deltaOffset, String newString) {
                try {
                    String oldText = doc.getText(offset + deltaOffset, newString.length());
                    if (oldText.length() > 0 && oldText.charAt(0) == '\n') {
                        offset += 1;
                    }
                    delta += newString.length();
                    doc.insertString(offset + deltaOffset, newString, null);
                } catch (BadLocationException ex) {
                    LOGGER.log(Level.INFO, null, ex);
                }
            }

            private boolean isOnSameLine(int offset1, int offset2) {
                int startLine = LineDocumentUtils.getLineStart(doc, offset1);
                int endLine = LineDocumentUtils.getLineStart(doc, offset2);
                return startLine == endLine;
            }
        });
    }

    private static class Whitespace {

        int lines;
        int spaces;

        public Whitespace(int lines, int spaces) {
            this.lines = lines;
            this.spaces = spaces;
        }

    }

}
