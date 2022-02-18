//package org.netbeans.modules.php.blade.editor.formatter;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.List;
//import java.util.StringTokenizer;
//import java.util.concurrent.atomic.AtomicLong;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.text.BadLocationException;
//import javax.swing.text.JTextComponent;
//import org.netbeans.api.editor.EditorRegistry;
//import org.netbeans.api.editor.document.LineDocumentUtils;
//import org.netbeans.api.lexer.TokenSequence;
//import org.netbeans.editor.BaseDocument;
//import org.netbeans.editor.CharSeq;
//import org.netbeans.editor.Utilities;
//import org.netbeans.modules.csl.spi.GsfUtilities;
//import org.netbeans.modules.csl.spi.ParserResult;
//import org.netbeans.modules.editor.indent.spi.Context;
//import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
//import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
//import org.netbeans.modules.php.blade.editor.parsing.BladeParserResult;
//import org.netbeans.spi.lexer.MutableTextInput;
//import org.openide.util.Exceptions;
//
///**
// * TODO INCOMPLETE CURRENT ISSUES html indent
// *
// * @author bhaidu
// */
//public class TokenFormatter1 {
//
//    protected static final String TEMPLATE_HANDLER_PROPERTY = "code-template-insert-handler";
//    private static final String EMPTY_STRING = "";
//    private static final Logger LOGGER = Logger.getLogger(TokenFormatter1.class.getName());
//    // it's for testing
//    private static int unitTestCarretPosition = -1;
//
//    public TokenFormatter1() {
//    }
//
//    protected static void setUnitTestCarretPosition(int unitTestCarretPosition) {
//        TokenFormatter1.unitTestCarretPosition = unitTestCarretPosition;
//    }
//
//    protected static class DocumentOptions {
//
//        public int continualIndentSize;
//        public int initialIndent;
//        public int indentSize;
//        public int indentArrayItems;
//        public int margin;
//        public int tabSize;
//        public int beforeDirectiveTagPlacement;
//        public boolean expandTabsToSpaces;
//
//        boolean wrapNeverKeepLines = Boolean.getBoolean("nb.php.editor.formatting.never.keep.lines"); // NOI18N
//
//        public DocumentOptions(BaseDocument doc) {
//            CodeStyle codeStyle = CodeStyle.get(doc);
//            continualIndentSize = codeStyle.getContinuationIndentSize();
//            initialIndent = codeStyle.getInitialIndent();
//            indentSize = codeStyle.getIndentSize();
//            beforeDirectiveTagPlacement = 4;
//            margin = codeStyle.getRightMargin();
//            tabSize = codeStyle.getTabSize();
//            expandTabsToSpaces = codeStyle.expandTabToSpaces();
//        }
//
//    }
//
//    /**
//     *
//     * @param chs
//     * @return number of new lines in the inputunitTestPane != null ?
//     * unitTestPane.getCaretPosition()
//     */
//    private int countOfNewLines(CharSequence chs) {
//        int count = 0;
//        if (chs != null) {
//            for (int i = 0; i < chs.length(); i++) {
//                if (chs.charAt(i) == '\n') { // NOI18N
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    public void reformat(final Context formatContext, ParserResult info) {
//        final BaseDocument doc = (BaseDocument) formatContext.document();
//        final BladeParserResult bladeParseResult = ((BladeParserResult) info);
//        final DocumentOptions docOptions = new DocumentOptions(doc);
//
//        doc.runAtomic(new Runnable() {
//            @Override
//            public void run() {
//                final AtomicLong start = new AtomicLong(System.currentTimeMillis());
//                final boolean templateEdit = GsfUtilities.isCodeTemplateEditing(doc);
//                JTextComponent lastFocusedComponent = templateEdit ? EditorRegistry.lastFocusedComponent() : null;
//                final int caretOffset = lastFocusedComponent != null
//                        ? lastFocusedComponent.getCaretPosition()
//                        : unitTestCarretPosition == -1 ? 0 : unitTestCarretPosition;
//                FormatVisitor fv = new FormatVisitor(doc, docOptions, caretOffset, formatContext.startOffset(), formatContext.endOffset());
//                bladeParseResult.getProgram().accept(fv);
//                final List<FormatToken> formatTokens = fv.getFormatTokens();
//
//                if (LOGGER.isLoggable(Level.FINE)) {
//                    long end = System.currentTimeMillis();
//                    LOGGER.log(Level.FINE, "Creating formating stream took: {0} ms", (end - start.get()));
//                }
//                if (LOGGER.isLoggable(Level.FINE)) {
//                    TokenSequence<? extends BladeTokenId> ts = BladeLexerUtils.getBladeMarkupTokenSequence(doc, 0);
//                    if (ts == null) {
//                        return;
//                    }
//                    LOGGER.log(Level.FINE, "Tokens in TS: {0}", ts.tokenCount());
//                    LOGGER.log(Level.FINE, "Format tokens: {0}", formatTokens.size());
//                }
//                MutableTextInput mti = (MutableTextInput) doc.getProperty(MutableTextInput.class);
//                int indent = docOptions.initialIndent;
//                int lastBladeIndent = 0;
//                boolean caretInTemplateSolved = false;
//                final Deque<Integer> lastDirectiveStartIndent = new ArrayDeque<>();
//                int deltaForLastMoveBeforeLineComment = 0;
//                int index = 0;
//                int newLines;
//                int delta = 0;
//                int column = 0;
//                int countSpaces;
//                String newText = null;
//                String oldText;
//                //ass all directives are standalone we will need it
//                int htmlIndent = -1;
//                boolean lastH = false;
//                int changeOffset = -1;
//                boolean stopReplace = false;
//                Whitespace ws;
//                FormatToken formatToken;
//
//                try {
//                    mti.tokenHierarchyControl().setActive(false);
//                    start.set(System.currentTimeMillis());
//                    while (index < formatTokens.size()) {
//                        formatToken = formatTokens.get(index);
//                        FormatToken.Kind id = formatToken.getId();
//                        oldText = null; //NOI18N
//                        if (formatToken.isWhitespace()) {
//                            newLines = -1;
//                            countSpaces = 0;
//                            boolean wasARule = false;
//                            boolean indentRule = false;
//                            boolean indentLine = false;
//                            boolean afterDirectiveArgument = false;
//                            CodeStyle.beforeDirectiveTagPlacement lastBracePlacement = CodeStyle.beforeDirectiveTagPlacement.SAME_LINE;
//
//                            changeOffset = formatToken.getOffset();
//
//                            while (index < formatTokens.size() && (formatToken.isWhitespace()
//                                    || formatToken.getId() == FormatToken.Kind.INDENT)) {
//                                id = formatToken.getId();
//                                if (oldText == null && formatToken.getOldText() != null) {
//                                    oldText = formatToken.getOldText();
//                                }
//                                if (formatToken.getId() != FormatToken.Kind.INDENT
//                                        && formatToken.getId() != FormatToken.Kind.WHITESPACE_INDENT
//                                        && formatToken.getId() != FormatToken.Kind.WHITESPACE) {
//                                    wasARule = true;
//                                }
//                                FormatToken.Kind idToken = formatToken.getId();
//                                switch (idToken) {
//                                    case WHITESPACE:
//                                        break;
//                                    case WHITESPACE_BEFORE_DIRECTIVE_START_TAG:
//                                        String text = formatToken.getOldText();
//                                        indentRule = true;
//                                        ws = countWSBeforeAStatement(
//                                                CodeStyle.WrapStyle.WRAP_ALWAYS,
//                                                true,
//                                                column,
//                                                countLengthOfNextSequence(formatTokens, index + 1),
//                                                indent,
//                                                isAfterLineComment(formatTokens, index));
//                                        countSpaces = ws.spaces;
//                                        int debug5 = 3;
//                                        break;
//                                    case WHITESPACE_BEFORE_ECHO:
//                                        if (index > 1) {
//                                            FormatToken prevToken = formatTokens.get(index - 1);
//                                            if (prevToken.isWhitespace()) {
//                                                countSpaces = 1;
//                                            }
//                                        }
//                                        //ws = countWhiteSpaceForPresevingInlineStatements();
//                                        int debug6 = 3;
//                                        break;
//                                    case WHITESPACE_BEFORE_DIRECTIVE_TAG:
//                                        countSpaces = indent;
//                                        if (index > 1) {
//                                            FormatToken prevToken = formatTokens.get(index - 1);
//                                            if (prevToken.isWhitespace()) {
//                                                //count the spaces
//                                                int currentSpaces = countOfSpaces(oldText.replace("\n", ""), 4);
//                                                countSpaces = currentSpaces >= indent ? 4 : indent;
//                                            }
//                                        }
//                                        break;
//                                    case WHITESPACE_BEFORE_DIRECTIVE_ENDTAG:
//                                        countSpaces = indent;
//                                        if (index > 1) {
//                                            FormatToken prevToken = formatTokens.get(index - 1);
//                                            if (prevToken.isWhitespace()) {
//                                                int currentSpaces = countOfSpaces(oldText.replace("\n", ""), 4);
//                                                String[] lines = oldText.split("\r\n|\r|\n");
//                                                newLines = lines.length;
//                                                countSpaces = currentSpaces >= indent ? 4 : indent;
//                                            }
//                                        }
//                                        break;
//                                    case WHITESPACE_BEFORE_DIRECTIVE_ELSE:
//                                        countSpaces = indent;
//                                        if (index > 1) {
//                                            FormatToken prevToken = formatTokens.get(index - 1);
//                                            if (prevToken.isWhitespace()) {
//                                                //count the spaces
//                                                int currentSpaces = countOfSpaces(oldText.replace("\n", ""), 4);
//                                                countSpaces = currentSpaces >= indent ? 0 : indent;
//                                            }
//                                        }
//                                        break;
//                                    case WHITESPACE_DECREMENT_INDENT:
//                                        indent -= docOptions.indentSize;
//                                        countSpaces = indent;
//                                        break;
//                                    case WHITESPACE_INDENT:
//                                        //adds a new line 
//                                        indentLine = true;
//                                        break;
//                                    case INDENT:
//                                        int indentDelta = ((FormatToken.IndentToken) formatToken).getDelta();
//                                        indent += indentDelta;
//                                        lastBladeIndent += indentDelta;
//                                        break;
//                                    case WHITESPACE_BEFORE_DIRECTIVE_PAREN:
//                                        countSpaces = 0;
//                                        break;
//                                    case WHITESPACE_AFTER_HTML:
//                                        //no break
//                                        newLines = 0; ///??
//                                        countSpaces = 4;
//                                        stopReplace = true;
//                                        break;
//                                    case WHITESPACE_BEFORE_DIRECTIVE_START_TAG_INLINE:
//                                        if (index > 1) {
//                                            FormatToken prevToken = formatTokens.get(index - 1);
//                                            if (prevToken.isWhitespace()) {
//                                                countSpaces = 1;
//                                            }
//                                        }
//                                        break;
//                                    case WHITESPACE_BEFORE_DIRECTIVE_ENDTAG_INLINE:
//                                        if (index > 1) {
//                                            FormatToken prevToken = formatTokens.get(index - 1);
//                                            if (prevToken.isWhitespace()) {
//                                                countSpaces = 1;
//                                            }
//                                        }
//                                        break;
//                                }
//                                index++;
//                                if (index < formatTokens.size()) {
//                                    formatToken = formatTokens.get(index);
//                                }
//                            }
//
//                            if (changeOffset > -1) {
//                                if (wasARule) {
//                                    if ((!indentRule || newLines == -1) && indentLine) {
//                                        countSpaces = Math.max(countSpaces, indent);
//                                        newLines = Math.max(1, newLines);
//                                    }
//                                }
//                            } else if (indentLine) {
//                                countSpaces = indent;
//                                newLines = oldText == null ? 1 : countOfNewLines(oldText);
//                                if (index > 1 && index < formatTokens.size()
//                                        && formatTokens.get(index - 2).getId() == FormatToken.Kind.TEXT
//                                        && formatTokens.get(index).getId() == FormatToken.Kind.TEXT
//                                        && "(".equals(formatTokens.get(index - 2).getOldText())
//                                        && ")".equals(formatTokens.get(index).getOldText())) {
//                                    newLines = 0;
//                                }
//                            } else {
//                                boolean isBeginLine = isBeginLine(formatTokens, index - 1);
//                                if (oldText != null) {
//                                    countSpaces = isBeginLine ? indent : oldText.length();
//                                }
//                            }
//
//                            newText = createWhitespace(docOptions, newLines, countSpaces);
//
//                            int realOffset = changeOffset + delta;
//                            if (templateEdit && !caretInTemplateSolved && oldText != null
//                                    && formatContext.startOffset() - 1 <= realOffset
//                                    && realOffset <= formatContext.endOffset() + 1) {
//
//                                int caretPosition = caretOffset + delta;
//                                if (caretPosition == formatContext.endOffset() && oldText.length() > 0 && newText.length() > 0
//                                        && oldText.charAt(0) == ' ' && newText.charAt(0) != ' ' && 0 != countOfNewLines(oldText)) {
//                                    newText = ' ' + newText;   // templates like public, return ...
//                                    caretInTemplateSolved = true;
//                                }
//                            }
//
//                            //decrement
//                            index--;
//                        } else {
//                            switch (formatToken.getId()) {
//                                case INDENT:
//                                    indent += ((FormatToken.IndentToken) formatToken).getDelta();
//                                    lastBladeIndent += ((FormatToken.IndentToken) formatToken).getDelta();
//                                    break;
//                                case HTML:
////                                    changeOffset = formatToken.getOffset();
////                                    ws = countWhiteSpaceForPreserveExistingforDirectiveTagPlacement(oldText, 0);
////                                    newLines = ws.lines;
////                                    countSpaces = ws.spaces;
////                                    newText = createWhitespace(docOptions, newLines, countSpaces);
//
//                                    oldText = null;
//                                    newText = null;
//                                    int debug = 3;
//                                    break;
//                                default:
//                            }
//                        }
//
//                        String debugText = formatToken.getOldText();
//                        String docText2 = "";
//                        try {
//                            docText2 = doc.getText(0, doc.getLength());
//                            int ssss = 3;
//                        } catch (Exception ex){
//                            
//                        }
//                        
//                        FormatToken lastFormatToken = null;
//                        if (index > 1 && index < formatTokens.size()){
//                            lastFormatToken = formatTokens.get(index - 1);
//                        }
//                        
//                        if (!id.equals(FormatToken.Kind.WHITESPACE_BEFORE_HTML) &&
//                                !id.equals(FormatToken.Kind.HTML) && !id.equals(FormatToken.Kind.WHITESPACE_AFTER_HTML)){
//                            if (!stopReplace){    
//                                delta = replaceString(doc, changeOffset, oldText, newText, delta, templateEdit);
//                            } else if (delta > 0) {
//                                delta = replaceString(doc, changeOffset, oldText, newText, delta, templateEdit);
//                                stopReplace = false;
//                            }
//                        } else {
//                            newText = null; 
//                        }
//                        if (newText == null) {
//                            String formatTokenOldText = formatToken.getOldText() == null ? "" : formatToken.getOldText();
//                            int formatTokenOldTextLength = formatTokenOldText.length();
//                            int lines = countOfNewLines(formatTokenOldText);
//                            if (lines > 0) {
//                                int lastNewLine = formatTokenOldText.lastIndexOf('\n'); //NOI18N
//                                column = formatTokenOldText.substring(lastNewLine).length();
//                            } else {
//                                column += formatTokenOldTextLength;
//                            }
//                        } else {
//                            int lines = countOfNewLines(newText);
//                            if (lines > 0) {
//                                column = newText.length() - lines;
//                            } else {
//                                column += newText.length();
//                            }
//                        }
//                        newText = null;
//                        index++;
//                    }
//
//                } finally {
//                    mti.tokenHierarchyControl().setActive(true);
//                }
//                if (LOGGER.isLoggable(Level.FINE)) {
//                    long end = System.currentTimeMillis();
//                    LOGGER.log(Level.FINE, "Applaying format stream took: {0} ms", (end - start.get())); // NOI18N
//                }
//            }
//
//            private Whitespace countWSBeforeAStatement(
//                    CodeStyle.WrapStyle style,
//                    boolean addSpaceIfNoLine,
//                    int column,
//                    int lengthOfNexSequence,
//                    int currentIndent,
//                    boolean isAfterLineComment) {
//                int lines = 0;
//                int spaces = 0;
//                switch (style) {
//                    case WRAP_ALWAYS:
//                        lines = 1;
//                        spaces = currentIndent;
//                        break;
//                    case WRAP_NEVER:
//                        if (isAfterLineComment) {
//                            lines = 1;
//                            spaces = currentIndent;
//                        } else {
//                            lines = 0;
//                            spaces = addSpaceIfNoLine ? 1 : 0;
//                        }
//                        break;
//                    case WRAP_IF_LONG:
//                        if (column + 1 + lengthOfNexSequence > docOptions.margin) {
//                            lines = 1;
//                            spaces = currentIndent + docOptions.indentSize;
//                        } else {
//                            if (isAfterLineComment) {
//                                lines = 1;
//                                spaces = currentIndent;
//                            } else {
//                                lines = 0;
//                                spaces = addSpaceIfNoLine ? 1 : 0;
//                            }
//                        }
//                        break;
//                    default:
//                        assert false : style;
//                }
//                return new Whitespace(lines, spaces);
//            }
//
//            private int startOffset = -1;
//            private int endOffset = -1;
//            // prviousIndentDelta keeps information, when a template is inserted and
//            // the code is not formatted according setted rules. Like initial indentation, etc.
//            // Basically it contain difference between number of spaces in document and
//            // the position if the document will be formatted according our rules.
//            private int previousIndentDelta = 0;
//            private String previousOldIndentText = "";
//            private String previousNewIndentText = "";
//
//            private int replaceString(BaseDocument document, int offset, String oldText, String newText, int delta, boolean templateEdit) {
//                if (oldText == null) {
//                    oldText = "";
//                }
//
//                if (startOffset == -1) {
//                    // set the range, where the formatting should be done
//                    startOffset = formatContext.startOffset();
//                    endOffset = formatContext.endOffset();
//                }
//                if (startOffset > 0 && (startOffset - oldText.length()) > offset
//                        && newText != null && newText.indexOf('\n') > -1) {
//                    // will be formatted new line that the first one has to be special
//                    previousNewIndentText = newText;
//                    previousOldIndentText = oldText;
//                }
//                if (newText != null && (!oldText.equals(newText)
//                        || (startOffset > 0 && (startOffset - oldText.length()) == offset))) {
//                    int realOffset = offset + delta;
//                    if (startOffset > 0 && (startOffset - oldText.length()) == offset) {
//                        // this should be a line with a place, where the template is inserted.
//                        if (previousOldIndentText.length() == 0 && previousNewIndentText.length() == 0) {
//                            // probably we are at the begining of file, so keep the current possition
//                            previousOldIndentText = oldText;
//                            previousNewIndentText = newText;
//                        }
//                        // find difference between the new text and old text of the previous formatting rule
//                        int indexOldTextLine = previousOldIndentText.lastIndexOf('\n');
//                        int indexNewTextLine = previousNewIndentText.lastIndexOf('\n');
//
//                        previousNewIndentText = indexNewTextLine == -1 ? previousNewIndentText : previousNewIndentText.substring(indexNewTextLine + 1);
//                        previousOldIndentText = indexOldTextLine == -1 ? previousOldIndentText : previousOldIndentText.substring(indexOldTextLine + 1);
//
//                        previousIndentDelta = countOfSpaces(previousOldIndentText, docOptions.tabSize)
//                                - countOfSpaces(previousNewIndentText, docOptions.tabSize);
//
//                        // find the indent of the new text
//                        indexNewTextLine = newText.lastIndexOf('\n');
//                        String replaceNew = indexNewTextLine == -1 ? newText : newText.substring(indexNewTextLine + 1);
//                        int replaceNewLength = countOfSpaces(replaceNew, docOptions.tabSize);
//
//                        // if there was a difference on the previous line, apply the difference for the current line as well.
//                        if (previousIndentDelta != 0 && indexNewTextLine > -1 && (replaceNewLength >= 0)) {
//                            replaceNewLength += previousIndentDelta;
//                            replaceNew = createWhitespace(docOptions, 0, Math.max(0, replaceNewLength));
//                        }
//                        indexOldTextLine = oldText.lastIndexOf('\n');
//                        String replaceOld = indexOldTextLine == -1 ? oldText : oldText.substring(indexOldTextLine + 1);
//                        int replaceOldLength = countOfSpaces(replaceOld, docOptions.tabSize);
//
//                        if (replaceOldLength != replaceNewLength) {
//                            delta = replaceSimpleString(document, realOffset + indexOldTextLine + 1, replaceOld, replaceNew, delta);
//                            return delta;
//                        }
//                    }
//                    if (startOffset <= realOffset
//                            && ((realOffset < endOffset + delta) || (realOffset == endOffset + delta && !templateEdit))) {
//
//                        if (!templateEdit || startOffset == 0) { // if is not in template, then replace simply or is not format selection
//                            delta = replaceSimpleString(document, realOffset, oldText, newText, delta);
//                        } else {
//                            // the replacing has to be done line by line.
//                            int indexOldTextLine = oldText.indexOf('\n');
//                            int indexNewTextLine = newText.indexOf('\n');
//                            int indexOldText = 0;
//                            int indexNewText = 0;
//                            String replaceOld;
//                            String replaceNew;
//
//                            if (indexOldTextLine == -1 && indexNewTextLine == -1) { // no new line in both)
//                                delta = replaceSimpleString(document, realOffset, oldText, newText, delta);
//                            } else {
//
//                                do {
//                                    indexOldTextLine = oldText.indexOf('\n', indexOldText); // NOI18N
//                                    indexNewTextLine = newText.indexOf('\n', indexNewText); // NOI18N
//
//                                    if (indexOldTextLine == -1) {
//                                        indexOldTextLine = oldText.length();
//                                    }
//                                    if (indexNewTextLine == -1) {
//                                        indexNewTextLine = newText.length();
//                                    }
//                                    replaceOld = indexOldText == indexOldTextLine && oldText.length() > 0 ? "\n" : oldText.substring(indexOldText, indexOldTextLine); // NOI18N
//                                    replaceNew = indexNewText == indexNewTextLine ? "\n" : newText.substring(indexNewText, indexNewTextLine); // NOI18N
//                                    if (previousIndentDelta != 0 && indexNewText != indexNewTextLine
//                                            && indexNewText > 0
//                                            && indexNewTextLine > -1 && (replaceNew.length()) > 0) {
//                                        int newSpaces = countOfSpaces(replaceNew, docOptions.tabSize) + previousIndentDelta;
//                                        replaceNew = createWhitespace(docOptions, 0, Math.max(0, newSpaces));
//                                    }
//                                    if (!replaceOld.equals(replaceNew)
//                                            && ((indexOldText + replaceOld.length()) <= oldText.length()
//                                            || indexNewText == indexNewTextLine)) {
//
//                                        if (newText.trim().length() == 0) {
//                                            delta = replaceSimpleString(document, realOffset + indexOldText,
//                                                    replaceOld, replaceNew, delta);
//                                        } else {
//                                            // in template we can move only with whitespaces
//                                            // if we will touch a parameter of the template
//                                            // then the processing of the template is stopped.
//                                            // see issue #197906
//                                            int indexOldChar = 0;
//                                            int indexNewChar = 0;
//                                            while (indexNewChar < replaceNew.length() && indexOldChar < replaceOld.length()) {
//                                                char newChar = replaceNew.charAt(indexNewChar);
//                                                char oldChar = replaceOld.charAt(indexOldChar);
//                                                if (newChar != oldChar) {
//                                                    if (Character.isWhitespace(newChar)) {
//                                                        delta = replaceSimpleString(document, realOffset + indexOldText + indexNewChar,
//                                                                "", "" + newChar, delta);
//                                                        indexNewChar++;
//                                                    } else {
//                                                        if (Character.isWhitespace(oldChar)) {
//                                                            delta = replaceSimpleString(document, realOffset + indexOldText + indexNewChar,
//                                                                    "" + oldChar, "", delta);
//                                                            indexOldChar++;
//                                                        }
//                                                    }
//
//                                                } else {
//                                                    indexNewChar++;
//                                                    indexOldChar++;
//                                                }
//                                            }
//
//                                        }
//                                    }
//                                    indexOldText = indexOldTextLine + 1; //(indexOldText == indexOldTextLine ? 2 : 1);
//                                    indexNewText = indexNewTextLine + 1; //(indexNewText == indexNewTextLine ? 2 : 1);
//                                    realOffset = offset + delta;
//
//                                } while (indexOldText < oldText.length()
//                                        && indexNewText < newText.length());
//
//                                if (indexOldText >= oldText.length()
//                                        && indexNewText < newText.length()) {
//                                    StringBuilder sb = new StringBuilder();
//                                    boolean addNewLine;
//                                    do {
//                                        indexNewTextLine = newText.indexOf('\n', indexNewText); // NOI18N
//                                        addNewLine = (indexNewTextLine != -1);
//                                        if (!addNewLine) {
//                                            indexNewTextLine = newText.length();
//                                        }
//                                        replaceNew = newText.substring(indexNewText, indexNewTextLine == -1 ? newText.length() : indexNewTextLine); // NOI18N
//                                        int newSpaces = countOfSpaces(replaceNew, docOptions.tabSize);
//                                        if (previousIndentDelta != 0 && indexNewText != indexNewTextLine
//                                                && indexNewText > 0
//                                                && indexNewTextLine > -1 && (newSpaces > 0)) {
//                                            newSpaces = newSpaces + previousIndentDelta;
//                                            replaceNew = createWhitespace(docOptions, 0, Math.max(0, newSpaces));
//                                        }
//                                        sb.append(replaceNew);
//                                        if (addNewLine) {
//                                            sb.append('\n');   //NOI18N
//                                        }
//                                        indexNewText = indexNewTextLine + 1;
//                                    } while (indexNewText < newText.length());
//
//                                    if (sb.length() > 0) {
//                                        delta = replaceSimpleString(document, realOffset + oldText.length(),
//                                                "", sb.toString(), delta);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//                return delta;
//            }
//
//            private int replaceSimpleString(BaseDocument document, int realOffset, String oldText, String newText, int delta) {
//                try {
//                    int removeLength = 0;
//                    if (oldText.length() > 0) {
//                        removeLength = realOffset + oldText.length() < document.getLength()
//                                ? oldText.length()
//                                : document.getLength() - realOffset;
//                    }
//                    document.replace(realOffset, removeLength, newText, null);
//                    delta = delta - oldText.length() + newText.length();
//                } catch (BadLocationException ex) {
//                    LOGGER.throwing(TokenFormatter1.this.getClass().getName(), "replaceSimpleSring", ex); //NOI18N
//                }
//                return delta;
//            }
//
//            private int countLengthOfNextSequence(List<FormatToken> formatTokens, int index) {
//                FormatToken token = formatTokens.get(index);
//                int length = 0;
//                //TODO complete
//                return length;
//            }
//
//        });
//    }
//
//    private static class Whitespace {
//
//        int lines;
//        int spaces;
//
//        public Whitespace(int lines, int spaces) {
//            this.lines = lines;
//            this.spaces = spaces;
//        }
//
//    }
//
//    private int countOfSpaces(String text, int tabSize) {
//        int spaces = 0;
//        int index = 0;
//        while (index < text.length()) {
//            if (text.charAt(index) == '\t') {
//                spaces += tabSize;
//            } else {
//                spaces++;
//            }
//            index++;
//        }
//        return spaces;
//    }
//
//    private boolean isAfterLineComment(List<FormatToken> tokens, int index) {
//        //TODO complete
//        return false;
//    }
//
//    private boolean isBeginLine(List<FormatToken> tokens, int index) {
//        FormatToken token = tokens.get(index);
//        while (index > 0 && (token.isWhitespace() || token.getId() == FormatToken.Kind.INDENT)
//                && token.getId() != FormatToken.Kind.WHITESPACE_INDENT) {
//            token = tokens.get(--index);
//        }
//
//        return token.getId() == FormatToken.Kind.WHITESPACE_INDENT || token.getId() == FormatToken.Kind.LINE_COMMENT;
//    }
//
//    private String createWhitespace(DocumentOptions docOptions, int lines, int spaces) {
//        if (lines == 0 && spaces == 0) {
//            return EMPTY_STRING;
//        }
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < lines; i++) {
//            sb.append('\n');
//        }
//        if (spaces > 0) {
//            // should be called IndentUtils from editor api, when issue #192289 will be fixed
//            sb.append(IndentUtils.cachedOrCreatedIndentString(spaces, docOptions.expandTabsToSpaces, docOptions.tabSize));
//        }
//
//        return sb.toString();
//    }
//
//}
