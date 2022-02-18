package org.netbeans.modules.php.blade.editor.formatter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
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
import org.netbeans.editor.CharSeq;
import org.netbeans.editor.Utilities;
import org.netbeans.modules.csl.spi.GsfUtilities;
import org.netbeans.modules.csl.spi.ParserResult;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
import org.netbeans.spi.lexer.MutableTextInput;
import org.openide.util.Exceptions;

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
                FormatToken lastIndentToken = null;
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
                        switch (id) {
                            case WHITESPACE:
                                lastWhitespaceToken = formatToken;
                                break;
                            case WHITESPACE_INDENT:
                                lastIndentToken = formatToken;
                                break;
                            case INDENT:
                                if (formatToken instanceof FormatToken.IndentToken) {
                                    FormatToken.IndentToken indentToken = (FormatToken.IndentToken) formatToken;
                                    indent += indentToken.getDelta();
                                } else if (formatToken instanceof FormatToken.HtmlIndentToken) {
                                    FormatToken.HtmlIndentToken indentToken = (FormatToken.HtmlIndentToken) formatToken;
                                    htmlIndent = indentToken.getDelta();
                                }
                                break;
                            case WHITESPACE_BEFORE_DIRECTIVE_START_TAG:
                            case WHITESPACE_BEFORE_DIRECTIVE_TAG:
                            case WHITESPACE_BEFORE_DIRECTIVE_ENDTAG:
                                int decrementOffset = 0;
                                if (id == FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_ENDTAG) {
                                    decrementOffset = 4;
                                }

                                if (lastFormatToken != null && lastFormatToken.isWhitespace()) {

                                }
                                int currentLine = LineDocumentUtils.getLineStart(doc, changeOffset + delta);
                                if (lastIndentToken != null && lastIndentToken.isWhitespace()) {
                                    int indentOffset = 0;
                                    int newLineIndex = 0;
                                    while (newLineIndex < lastIndentToken.getOldText().length()
                                            && lastIndentToken.getOldText().charAt(newLineIndex) == '\n') {
                                        newLineIndex++;
                                        indentOffset++;
                                    }
                                    if (isOnSameLine(changeOffset + delta, lastIndentToken.getOffset() + indentOffset)) {
                                        String whitespace = lastIndentToken.getOldText();
                                        if (whitespace != null && whitespace.length() > 1) {
                                            for (char c : whitespace.toCharArray()) {
                                                if (c == ' ') {
                                                    spaceCount++;
                                                }
                                            }
                                        }
                                        int totalIndent = indent + htmlIndent - decrementOffset;
                                        if (totalIndent > 0) {
                                            if (spaceCount < totalIndent) {
                                                insert(changeOffset, delta, new String(new char[totalIndent]).replace("\0", " "));
                                            } else {
                                                //might have to replace
                                                int diffWhitespace = totalIndent - spaceCount;
                                                if (diffWhitespace > 0) {
                                                    replace(lastIndentToken.getOffset() + indentOffset, delta, diffWhitespace, new String(new char[diffWhitespace]).replace("\0", " "));
                                                } else {
                                                    diffWhitespace = Math.abs(diffWhitespace);
                                                    replace(lastIndentToken.getOffset() + indentOffset, delta, diffWhitespace, "");
                                                }
                                            }
                                        } else if (totalIndent == 0) {
                                            if (spaceCount > 0) {
                                                replace(lastIndentToken.getOffset() + indentOffset, delta, spaceCount, "");
                                            }
                                        }
                                    }
                                } else if (currentLine == 0) {
                                    //first row
                                    if (lastWhitespaceToken != null) {
                                        int diffWhitespace = changeOffset - lastWhitespaceToken.getOffset();
                                        if (diffWhitespace > 0) {
                                            replace(lastWhitespaceToken.getOffset(), delta, diffWhitespace, "");
                                        }
                                    }
                                }
                                break;
                            case WHITESPACE_BEFORE_HTML:
                                //can't override the html formatting
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
                                    replace(whitespaceOffset, delta, changeOffset - whitespaceOffset, "");
                                }
                                break;
                            case WHITESPACE_BEFORE_BLADE_PHP:
                            case WHITESPACE_BEFORE_BLADE_PHP_BODY:
                                int xxx = 1;
                                if (lastIndentToken != null && lastIndentToken.isWhitespace()) {
                                    String whitespace = lastIndentToken.getOldText();
                                    if (whitespace != null && whitespace.length() > 1) {
                                        for (char c : whitespace.toCharArray()) {
                                            if (c == ' ') {
                                                spaceCount++;
                                            }
                                        }
                                    }
                                    int totalIndent = indent + htmlIndent;
                                    if (totalIndent > 0) {
                                        if (spaceCount < totalIndent) {
                                            insert(changeOffset, delta, new String(new char[totalIndent]).replace("\0", " "));
                                        } else {
                                            if (lastFormatToken != null
                                                    && lastFormatToken instanceof FormatToken.PhpBladeToken) {
                                                FormatToken.PhpBladeToken phpFormatToken = (FormatToken.PhpBladeToken) lastFormatToken;
                                                if (id.equals(FormatToken.Kind.WHITESPACE_BEFORE_BLADE_PHP_BODY)) {
                                                    String phpCode = phpFormatToken.getText();
//                                                    int startLine = LineDocumentUtils.getLineStart(doc, changeOffset);
                                                    int nrLines = LineDocumentUtils.getLineCount(doc, changeOffset, changeOffset + phpCode.length());
                                                    
                                                    try {
                                                        
                                                        int lineOffset = changeOffset;
                                                        int lineIndex = LineDocumentUtils.getLineIndex(doc, changeOffset);
//                                                        int nextNonNewLine = LineDocumentUtils.getNextNonNewline(doc, changeOffset);
//                                                        String word = LineDocumentUtils.getWord(doc, nextNonNewLine);
                                                        int bodyEnd = LineDocumentUtils.getLineEnd(doc, changeOffset + phpCode.length());
                                                        for (int i = 0; i< nrLines; i++){
                                                            int startLine = LineDocumentUtils.getLineStartFromIndex(doc, lineIndex);
                                                            String word = LineDocumentUtils.getWord(doc, startLine);
                                                            if (word.equals("\n")){
                                                                word = LineDocumentUtils.getWord(doc, startLine + 1);
                                                            }
                                                            lineIndex++;
//                                                            int nextNonNewLine = LineDocumentUtils.getNextNonNewline(doc, lineOffset);
//                                                            int startLine = LineDocumentUtils.getLineStart(doc, lineOffset);
//                                                            int lEnd = LineDocumentUtils.getLineEnd(doc, lineOffset);
//                                                            String word = LineDocumentUtils.getWord(doc, nextNonNewLine);
//                                                            String wordEnd = LineDocumentUtils.getWord(doc, lEnd);
//                                                            lineOffset = lEnd;
//                                                            if (word.length() < totalIndent || word.trim().length() == 0) {
//                                                                insert(startLine, delta, new String(new char[totalIndent]).replace("\0", " "));
//                                                            }
                                                        }
                                                        int sddsds = 1;
                                                    } catch (BadLocationException ex){
                                                        
                                                    }
                                                    
                                                    int indentOffset = 0;
//                                                    int newLineIndex = 0;
//                                                    spaceCount = 0;
//                                                    while (newLineIndex < phpFormatToken.getText().length()
//                                                            && phpFormatToken.getText().charAt(newLineIndex) == '\n') {
//                                                        newLineIndex++;
//                                                        indentOffset++;
//                                                    }
//                                                    if (indentOffset < phpFormatToken.getText().length()) {
//                                                        while (indentOffset < phpFormatToken.getText().length()
//                                                            && phpFormatToken.getText().charAt(indentOffset) == ' ') {
//                                                            spaceCount++;
//                                                        }
//                                                        if (spaceCount < totalIndent) {
//                                                            insert(changeOffset, delta, new String(new char[totalIndent]).replace("\0", " "));
//                                                        }
//                                                    }
                                                    
                                                }
                                            }
                                        }
                                    }
                                }
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
                    if (oldText.charAt(0) == '\n') {
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
        int dddd = 3;
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
