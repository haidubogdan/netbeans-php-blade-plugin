package org.netbeans.modules.php.blade.editor.formatter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;
import org.netbeans.api.annotations.common.CheckForNull;
import org.netbeans.api.annotations.common.NullAllowed;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenSequence;
import org.netbeans.api.lexer.TokenUtilities;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.csl.spi.GsfUtilities;
import org.netbeans.modules.php.blade.editor.formatter.TokenFormatter.DocumentOptions;
import org.netbeans.modules.php.blade.editor.lexer.BladeLexerUtils;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.ASTNode;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.*;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.visitors.DefaultVisitor;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
public class FormatVisitor extends DefaultVisitor {

    private static final Logger LOGGER = Logger.getLogger(FormatVisitor.class.getName());
    private final BaseDocument document;
    private final List<FormatToken> formatTokens;
    private final TokenSequence<? extends BladeTokenId> ts;
    private final LinkedList<ASTNode> path;
    private final DocumentOptions options;
    private final int caretOffset;
    private final int startOffset;
    private final int endOffset;
    private int lastIndex = -1;
    private int indent = 0; // TODO see if it can be changed with a loop in formatTokens
    boolean inlineState = false;
    boolean blockState = false;
    private String prevHtmlText = "";
    private BladeTokenId prevTokenId; 

    public FormatVisitor(BaseDocument document, DocumentOptions documentOptions, final int caretOffset, final int startOffset, final int endOffset) {
        this.document = document;
        ts = BladeLexerUtils.getBladeMarkupTokenSequence(document, 0);
        path = new LinkedList<>();
        options = documentOptions;
        formatTokens = new ArrayList<>(ts == null ? 1 : ts.tokenCount() * 2);
        this.caretOffset = caretOffset;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        formatTokens.add(new FormatToken.InitToken());
    }

    public FormatVisitor(BaseDocument document, TokenSequence<? extends BladeTokenId> tseq, DocumentOptions documentOptions, final int caretOffset, final int startOffset, final int endOffset) {
        this.document = document;
        ts = tseq;
        path = new LinkedList<>();
        options = documentOptions;
        formatTokens = new ArrayList<>(ts == null ? 1 : ts.tokenCount() * 2);
        this.caretOffset = caretOffset;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        formatTokens.add(new FormatToken.InitToken());
    }

    @Override
    public void visit(BladeProgram program) {
        //INIT TAG
        if (ts != null) {
            path.addFirst(program);
            ts.move(0);
            ts.moveNext();
            ts.movePrevious();
            addFormatToken(formatTokens);
            super.visit(program);
            FormatToken lastToken = formatTokens.size() > 0
                    ? formatTokens.get(formatTokens.size() - 1)
                    : null;
            while (ts.moveNext()) {
                if (lastToken == null || lastToken.isWhitespace() || lastToken.getOffset() > ts.offset()) {
                    if (lastIndex < ts.index()) {
                        addFormatToken(formatTokens);
                        lastToken = formatTokens.get(formatTokens.size() - 1);
                    }
                }
            }
            path.removeFirst();
        }
    }

    @Override
    public void scan(ASTNode node) {
        if (node == null) {
            return;
        }

        List<FormatToken> beforeTokens = new ArrayList<>(30);
        while (moveNext() && ts.offset() < node.getStartOffset()
                && lastIndex < ts.index()
                && ((ts.offset() + ts.token().length()) <= node.getStartOffset())) {

            String text = ts.token().text().toString();
            int tOffset = ts.offset();
            int debug = 3;
            addFormatToken(beforeTokens);
        }

        formatTokens.addAll(beforeTokens);
        ts.movePrevious();
        path.addFirst(node);
        super.scan(node);
        path.removeFirst();
    }

    @Override
    public void scan(Iterable<? extends ASTNode> nodes) {
        super.scan(nodes);
    }

    @Override
    public void visit(DirectiveBladeBlock node) {
        scan(node.getBody().getStatements());
    }

    @Override
    public void visit(InLineHtml node) {
        //addAllUntilOffset(node.getStartOffset());
        //resets the indent can use in something
        //formatTokens.add(new FormatToken.IndentToken(node.getEndOffset() -1, -1 * options.indentSize)); // -1: ]
    }

    @Override
    public void visit(BladeForStatement node) {
        addAllUntilOffset(node.getStartOffset());
        if (node.getBody() != null) {
            scan(node.getBody().getStatements());
        }
    }

    @Override
    public void visit(BladeSectionStatement node) {
        addAllUntilOffset(node.getStartOffset());
        int debug = 3;
        if (node.getBody() != null) {
            scan(node.getBody().getStatements());
        }
    }

    @Override
    public void visit(BladeForeachStatement node) {
        addAllUntilOffset(node.getStartOffset());
        if (node.getBody() != null) {
            scan(node.getBody().getStatements());
        }
    }

    @Override
    public void visit(BladeIfStatement node) {
        addAllUntilOffset(node.getStartOffset());
        if (node.getBody() != null) {
            scan(node.getBody().getStatements());
        }
    }

    @Override
    public void visit(BladeIncludeStatement node) {
        addAllUntilOffset(node.getStartOffset());
    }

    public List<FormatToken> getFormatTokens() {
        return formatTokens;
    }

    private void addAllUntilOffset(int offset) {
        boolean canMoveNext = moveNext();
        boolean offsetIsSmaller = ts.offset() < offset;
        boolean offsetLengthIsSmaller = (ts.offset() + ts.token().length()) <= offset;
        while (canMoveNext && offsetIsSmaller
                && offsetLengthIsSmaller) {
            String text = ts.token().text().toString();
            int tOffset = ts.offset();
            addFormatToken(formatTokens);
        }
        ts.movePrevious();
    }

    private void addAllUntilOffset(int offset, String terminator) {
        while (moveNext() && ts.offset() < offset
                && (ts.offset() + ts.token().length()) <= offset
                && !TokenUtilities.textEquals(ts.token().text(), terminator)) {
            addFormatToken(formatTokens);
        }
        ts.movePrevious();
    }

    private void addFormatToken(List<FormatToken> tokens) {
        if (lastIndex == ts.index()) {
            ts.moveNext();
            return;
        }
        lastIndex = ts.index();
        BladeTokenId id = (BladeTokenId) ts.token().id();
        ASTNode parent = path.get(0);
        FormatToken lastToken = formatTokens.size() > 0
                ? formatTokens.get(formatTokens.size() - 1)
                : null;
        switch (id) {
            case WHITESPACE:
                tokens.addAll(resolveWhitespaceTokens());
                if (prevTokenId.equals(BladeTokenId.T_HTML)){
                    String debug = prevHtmlText;
                    Pattern pattern = Pattern.compile("<(\\/[\\w\\d\\s]+)>?[\\s]*$");
       
                    if (indent < 0){
                        formatTokens.add(new FormatToken.IndentToken(ts.offset(), options.indentSize));
                    } else {
                        StringTokenizer st = new StringTokenizer(prevHtmlText, "", true);
                        while (st.hasMoreTokens()) {
                            String token = st.nextToken();
                            Matcher matcher = pattern.matcher(token);
                            int newLines = countOfNewLines(token);
                            int closingTagCount = 0;
                            while (matcher.find()) {
                                closingTagCount++;
                            }
                            if (closingTagCount > 0){
                                formatTokens.add(new FormatToken.IndentToken(ts.offset(), -closingTagCount * options.indentSize));
                            } else {
                                formatTokens.add(new FormatToken.IndentToken(ts.offset(), newLines * options.indentSize));
                            }
                            int debug2 = 1;
                        }
                    }
                }
                break;
            case NEWLINE:
                tokens.addAll(resolveWhitespaceTokens());
                if (prevTokenId.equals(BladeTokenId.T_HTML)){
                    //formatTokens.add(new FormatToken.IndentToken(ts.offset(), options.indentSize));
                }
                break;
            case T_BLADE_SECTION:
            //no break
            case T_BLADE_FOR:
            //no break
            case T_BLADE_IF:
            //no break;    
            case T_BLADE_FOREACH:
                //
                inlineState = false;
                blockState = true;

                tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_START_TAG, ts.offset()));
                tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                break;
            case T_BLADE_DIRECTIVE:    
            case T_BLADE_YIELD:
            case T_BLADE_INCLUDE:
                inlineState = true;
                blockState = false;
                tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_TAG, ts.offset()));
                tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                break;
            case T_BLADE_ENDSECTION:
            //no break
            case T_BLADE_ENDIF:
            //no break
            case T_BLADE_ENDFOR:
            //no break
            case T_BLADE_ENDFOREACH:
                indent -= options.indentSize;
                if (indent < 0) {
                    tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_DECREMENT_INDENT, ts.offset()));
                } else {
                    tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_ENDTAG, ts.offset()));
                }
                tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                break;
            case BLADE_PHP_TOKEN:
                CharSequence txt = ts.token().text();

                //statement whitespace before left paren
                if (TokenUtilities.textEquals("(", txt)) { // NOI18N
                    if (parent instanceof DirectiveBladeBlock || parent instanceof BladeProgram) {
                        tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_PAREN, ts.offset()));
                        tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                    }
                } else if (TokenUtilities.textEquals(")", txt)) {
                    //to do check if the directive is a block tag
                    if (parent instanceof DirectiveBladeBlock) {
                        if (indent > 0) {
                            if (inlineState) {
                                indent = 0;//reset
                            }
                            formatTokens.add(new FormatToken.IndentToken(ts.offset(), options.indentSize));
                        } else if (blockState) {
                            indent += options.indentSize;
                        }
                    }
                }
                break;
            case T_BLADE_OPEN_ECHO:
            case T_BLADE_OPEN_ECHO_ESCAPED:
            case T_BLADE_CLOSE_ECHO:
            case T_BLADE_CLOSE_ECHO_ESCAPED:
            case T_BLADE_PHP_ECHO:
                tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                break;
            case T_HTML:
//                String tText = ts.token().text().toString();
                prevHtmlText = ts.token().text().toString();
//                int lastWhitespaceIndex = findLastNonWhitespaceCharacter(tText);
//                if (lastWhitespaceIndex < tText.length() && lastWhitespaceIndex > 0){
//                    tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_HTML, ts.offset()));
//                    String whitespaceString = tText.substring(lastWhitespaceIndex);
//                    tokens.addAll(resolveWhitespaceTokens(whitespaceString, ts.offset() + lastWhitespaceIndex));
//                    formatTokens.add(new FormatToken(FormatToken.Kind.HTML, ts.offset(), tText.substring(0, lastWhitespaceIndex - 1)));
//                    
//                } else 
                if (!lastToken.getId().equals(FormatToken.Kind.HTML)){
                    //tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_HTML, ts.offset()));
                    //formatTokens.add(new FormatToken(FormatToken.Kind.HTML, ts.offset(), ts.token().text().toString()));
                    //tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_AFTER_HTML, ts.offset()));
                }
                break;
            default:
                //tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
        }
        prevTokenId = id;
    }
    
    protected static int findLastNonWhitespaceCharacter(String s){
        int index = s.length() - 1;
        while (index > 0) {
            boolean isWhitespace = Character.isWhitespace(s.charAt(index));
            if (!isWhitespace){
                index++;
                break;
            }
            index--;
        }

        return index;
    }

    private List<FormatToken> resolveWhitespaceTokens() {

        final List<FormatToken> result = new LinkedList<>();
        int countNewLines = countOfNewLines(ts.token().text());
        String tokenText = ts.token().text().toString();
        int tokenStartOffset = ts.offset();
        if (countNewLines > 0) {
            result.add(new FormatToken(FormatToken.Kind.WHITESPACE_INDENT, tokenStartOffset, adjustLastWhitespaceToken(ts.token())));
        } else {
            int tokenEndOffset = tokenStartOffset + ts.token().length();
            if (GsfUtilities.isCodeTemplateEditing(document)
                    && caretOffset > tokenStartOffset
                    && caretOffset < tokenEndOffset
                    && tokenStartOffset > startOffset
                    && tokenEndOffset < endOffset) {
                int devideIndex = caretOffset - tokenStartOffset;
                String firstTextPart = tokenText.substring(0, devideIndex);
                result.add(new FormatToken(FormatToken.Kind.WHITESPACE, tokenStartOffset, firstTextPart));
                result.add(new FormatToken(FormatToken.Kind.WHITESPACE, tokenStartOffset + firstTextPart.length(), tokenText.substring(devideIndex)));
            } else {
                result.add(new FormatToken(FormatToken.Kind.WHITESPACE, tokenStartOffset, adjustLastWhitespaceToken(ts.token())));
            }
        }
        return result;
    }
    
    private List<FormatToken> resolveWhitespaceTokens(String text, int offset) {

        final List<FormatToken> result = new LinkedList<>();
        int countNewLines = countOfNewLines(text);

        if (countNewLines > 0) {
            result.add(new FormatToken(FormatToken.Kind.WHITESPACE_INDENT, offset, adjustLastWhitespaceToken(ts.token())));
        } else {
            int tokenEndOffset = offset + text.length();
            if (GsfUtilities.isCodeTemplateEditing(document)
                    && caretOffset > offset
                    && caretOffset < tokenEndOffset
                    && offset > startOffset
                    && tokenEndOffset < endOffset) {
                int devideIndex = caretOffset - offset;
                String firstTextPart = text.substring(0, devideIndex);
                result.add(new FormatToken(FormatToken.Kind.WHITESPACE, offset, firstTextPart));
                result.add(new FormatToken(FormatToken.Kind.WHITESPACE, offset + firstTextPart.length(), text.substring(devideIndex)));
            } else {
                result.add(new FormatToken(FormatToken.Kind.WHITESPACE, offset, adjustLastWhitespaceToken(ts.token())));
            }
        }
        return result;
    }

    private String adjustLastWhitespaceToken(Token<? extends BladeTokenId> token) {
        //assert token.id() == BladeTokenId.WHITESPACE;
        String result;
        String tokenText = token.text().toString();
        boolean isLast;
        if (ts.moveNext()) {
            isLast = false;
            ts.movePrevious();
        } else {
            isLast = true;
        }
        if (isLast) {
            int firstNewLineOffset = tokenText.indexOf('\n');
            result = tokenText.substring(0, firstNewLineOffset) + tokenText.substring(firstNewLineOffset + 1);
        } else {
            result = tokenText;
        }
        return result;
    }

    private boolean moveNext() {
        boolean value = ts.moveNext();
        if (value) {
            int tokenKey = formatTokens.size() - 1;
            FormatToken last = formatTokens.get(formatTokens.size() - 1);
            value = !(last.getId() == FormatToken.Kind.TEXT && last.getOffset() >= ts.offset());
        }
        return value;
    }

    private int countOfNewLines(CharSequence chs) {
        int count = 0;
        for (int i = 0; i < chs.length(); i++) {
            if (chs.charAt(i) == '\n') { // NOI18N
                count++;
            }
        }
        return count;
    }

    protected static boolean isWhitespace(final CharSequence text) {
        int index = 0;
        while (index < text.length()
                && Character.isWhitespace(text.charAt(index))) {
            index++;
        }
        return index == text.length();
    }

    private static boolean isOpenParen(Token<? extends BladeTokenId> token) {
        return TokenUtilities.textEquals("(", token.text()); // NOI18N
    }

    private static boolean isCloseParen(Token<? extends BladeTokenId> token) {
        return TokenUtilities.textEquals(")", token.text()); // NOI18N
    }

    private boolean hasNewline(int startIndex) {
        boolean hasNewline = false;
        for (int i = startIndex; i < formatTokens.size(); i++) {
            FormatToken formatToken = formatTokens.get(i);
            if (formatToken.getId() == FormatToken.Kind.WHITESPACE_INDENT) {
                hasNewline = true;
                break;
            }
        }
        return hasNewline;
    }

}
