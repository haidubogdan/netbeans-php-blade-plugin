package org.netbeans.modules.php.blade.editor.formatter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import org.netbeans.api.editor.document.LineDocumentUtils;
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
 * TODO treate else if bug if last element is a endif and next is directive tag
 *
 * @author bhaidu
 */
public class FormatVisitor implements Visitor {

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
    boolean blockIsInline = false;
    private String prevHtmlText = "";
    private BladeTokenId prevTokenId;
    private Pattern htmlTagNamePattern = Pattern.compile("<([\\w\\d]+)\\s*(.*?)>");
    private Pattern htmlCloseTagNamePattern = Pattern.compile("<\\/([\\w\\d]+)\\s*>");
    boolean insideHtmlElementTag = false;
    int lastWhitespaceOffset = -1;

    @Override
    public void visit(ASTNode node) {
        //
    }

    @Override
    public void visit(BladeYieldStatement node) {
    }

    @Override
    public void visit(BladeExtendsStatement node) {
    }

    @Override
    public void visit(InLinePhp node) {
    }

    public void scan(Iterable<? extends ASTNode> nodes) {
        if (nodes != null) {
            for (ASTNode n : nodes) {
                scan(n);
            }
        }
    }

    public static Collection<String> HTML_VOID_ELEMENTS = Arrays.asList(
            "input",
            "area",
            "br",
            "col",
            "command",
            "embed",
            "hr",
            "img",
            "keygen",
            "link",
            "meta",
            "param",
            "source",
            "track",
            "wbr"
    );

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
        //create just one TODO
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
            addFormatToken2(formatTokens);
            scan(program.getStatements());
            FormatToken lastToken = formatTokens.size() > 0
                    ? formatTokens.get(formatTokens.size() - 1)
                    : null;
            while (ts.moveNext()) {
                if (lastToken == null || lastToken.isWhitespace() || lastToken.getOffset() > ts.offset()) {
                    if (lastIndex < ts.index()) {
                        addFormatToken2(formatTokens);
                        lastToken = formatTokens.get(formatTokens.size() - 1);
                    }
                }
            }
            path.removeFirst();
        }
    }

    public void scan(ASTNode node) {
        if (node == null) {
            return;
        }

        if (ts.token() != null && ts.offset() < node.getStartOffset()) {
            while (moveNext() && ts.offset() < node.getStartOffset()) {
                //check for whitespaces
                BladeTokenId idBefore = ts.token().id();
                switch (idBefore) {
                    case WHITESPACE:
                    case NEWLINE:
                        int offsetD = ts.offset();
                        if (lastWhitespaceOffset != offsetD) {
                            lastWhitespaceOffset = offsetD;
                            formatTokens.addAll(resolveWhitespaceTokens());
                        }
                        break;
                }
            }
        }

        ts.move(node.getStartOffset());

        if (ts.token() == null) {
            if (!moveNext()) {
                return;
            }
        }

        if (ts.token() == null) {
            return;
        }

        BladeTokenId id = ts.token().id();
        
        //add the first whitespaces
        switch (id) {
            case WHITESPACE:
            case NEWLINE:
                int offsetD = ts.offset();
                if (lastWhitespaceOffset != offsetD) {
                    lastWhitespaceOffset = offsetD;
                    formatTokens.addAll(resolveWhitespaceTokens());
                }
                moveNext();
                break;
        }

        path.addFirst(node);
        if (node instanceof DirectiveExpressionBlock) {
            DirectiveExpressionBlock d = (DirectiveExpressionBlock) node;
            addDirectiveBlockWSTokens(d);
        } else if (node instanceof InlineDirectiveStatement) {
            InlineDirectiveStatement d = (InlineDirectiveStatement) node;
            addDirectiveInlineWSTokens(d);
        }
        node.accept(this);
        path.removeFirst();
    }

    @Override
    public void visit(DirectiveExpressionBlock node) {
        scan(node.getBody().getStatements());
    }

    @Override
    public void visit(InLineHtml node) {
        
        setBlockLineInlineStatus(node);
        if (blockIsInline) {
            //insideHtmlElementTag = false;
            //return;
        }
        BladeTokenId id = ts.token().id();
        String text = ts.token().text().toString();
        String content = node.getContent();

        if (content == null || content.length() == 0 || content.trim().length() == 0) {
            if (id.equals(BladeTokenId.T_HTML)){
                //insideHtmlElementTag = false;
            }
            return;
        }

        if (Character.isWhitespace(content.charAt(0))) {
            int offsetD = ts.offset();
            if (lastWhitespaceOffset != offsetD && Character.isWhitespace(text.charAt(0))) {
                lastWhitespaceOffset = offsetD;
                formatTokens.addAll(resolveWhitespaceTokens());
            } else if (lastWhitespaceOffset != node.getStartOffset() && Character.isWhitespace(content.charAt(0))){
                lastWhitespaceOffset = node.getStartOffset();
                formatTokens.addAll(resolveWhitespaceTokens());
            }
            while (moveNext() && ts.offset() < node.getStartOffset() && ts.token().id() == BladeTokenId.T_HTML) {
                if (lastWhitespaceOffset != ts.offset()) {
                    lastWhitespaceOffset = ts.offset();
                    formatTokens.addAll(resolveWhitespaceTokens());
                }
            }
            if (ts.token().id() != BladeTokenId.T_HTML){
                ts.movePrevious();
            }
        }

        id = ts.token().id();
        text = ts.token().text().toString();
        
        switch (id) {
            case WHITESPACE:
            case NEWLINE:
                if (moveNext()) {
                    id = ts.token().id();
                }
                break;
        }
        
        if (id.equals(BladeTokenId.T_HTML)) {
            formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_HTML, ts.offset()));
            //formatTokens.add(new FormatToken(FormatToken.Kind.HTML, ts.offset(), ts.token().text().toString()));
            String htmlText = ts.token().text().toString();
            StringTokenizer st = new StringTokenizer(htmlText, "<", true);
            int openTagBalance = 0;
            boolean tagDetected = false;
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (token.indexOf("<") > -1) {
                    openTagBalance++;
                    tagDetected= true;
                }
                if (token.indexOf(">") > -1) {
                    openTagBalance--;
                }
            }
            
            String trimmedContent = content.replaceAll("\\s+$", "");
            String trimmedWhitespaceContent = content.replaceAll("[ ]+$", "");
            if (htmlText.trim().endsWith(">")){
                if (trimmedWhitespaceContent.endsWith("\n")){
                    int lastNewLine = trimmedContent.lastIndexOf("\n");
                    int lastOpeningTag = trimmedContent.lastIndexOf("<");
                    int lastClosingOpeningTag = trimmedContent.lastIndexOf("</");
                    int countSpaces = 0;
                    if (lastNewLine > 0 && lastNewLine < lastOpeningTag &&
                        lastClosingOpeningTag < lastOpeningTag){
                        for (int i = lastNewLine + 1; i < lastOpeningTag; i++) {
                            if (!Character.isWhitespace(trimmedContent.charAt(i))) {
                                break;
                            }
                            countSpaces++;
                        }
                    }
                    countSpaces = Math.max(countSpaces, 4);
                    formatTokens.add(new FormatToken.HtmlIndentToken(ts.offset(), countSpaces));
                }
            }
            insideHtmlElementTag = openTagBalance > 0 && tagDetected;
  
            formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_AFTER_HTML, ts.offset()));
        }

        /*
        if (!isTreatedAsHtml(id)){
            ts.movePrevious();
            id = ts.token().id();
            text = ts.token().text().toString();
            if (!isTreatedAsHtml(id)){
                return;
            }
            //return;
        }
        
        switch (id) {
            case T_HTML:
                String htmlText = ts.token().text().toString();
                StringTokenizer st = new StringTokenizer(htmlText, "\n", true);
                //formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_HTML, ts.offset()));
                formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    if (token.trim().length() == 0) {
                        int whitespace = 1111;
                        //whitespace
                        continue;
                    }
                    if (token.trim().length() < 3) {
                        continue;
                    }
                    Matcher mOpen = htmlTagNamePattern.matcher(token);
                    Matcher mClose = htmlCloseTagNamePattern.matcher(token);
                    while (mOpen.find()) {
                        //check if tag name is identable
                        String tagName = mOpen.group(1);
                        formatTokens.add(new FormatToken.IndentToken(ts.offset(), options.indentSize));
                    }
                    while (mClose.find()) {
                        String closeTagName = mClose.group(1);
                        formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_DECREMENT_INDENT, ts.offset()));
                    }
                }
                break;
            case WHITESPACE:
            case NEWLINE:
                int offsetD = ts.offset();
                if (lastWhitespaceOffset != offsetD){
                    lastWhitespaceOffset = offsetD;
                    formatTokens.addAll(resolveWhitespaceTokens());
                }
                break;
        }
         */
    }

    @Override
    public void visit(BladeForStatement node) {
    }

    @Override
    public void visit(BladeSectionStatement node) {
    }

    @Override
    public void visit(BladeForeachStatement node) {
    }

    @Override
    public void visit(BladeIfStatement node) {

    }

    @Override
    public void visit(BladeIncludeStatement node) {

    }

    @Override
    public void visit(BladeEchoStatement node) {
        BladeTokenId id = ts.token().id();
        if (!id.equals(BladeTokenId.T_BLADE_OPEN_ECHO) && !id.equals(BladeTokenId.T_BLADE_OPEN_ECHO_ESCAPED)) {
            ts.movePrevious();
        }
        switch (id) {
            case T_BLADE_OPEN_ECHO:
            case T_BLADE_OPEN_ECHO_ESCAPED:
                formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_ECHO, ts.offset()));
                formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                break;
        }

        ts.move(node.getEndOffset());
        ts.movePrevious();
        Token token = ts.token();
        String text = ts.token().text().toString();
        if (ts.token().id().equals(BladeTokenId.T_BLADE_CLOSE_ECHO)) {
            formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
        }
    }

    @Override
    public void visit(BladeComment node) {
        BladeTokenId id = ts.token().id();
        if (!id.equals(BladeTokenId.T_BLADE_COMMENT)) {
            ts.movePrevious();
        }

        if (id.equals(BladeTokenId.T_BLADE_COMMENT) && ts.token().text().toString().trim().equals("{{--")) {
            formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_BLADE_COMMENT, ts.offset()));
            formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
        }
        moveNext();
        while (ts.token().id() == BladeTokenId.T_BLADE_COMMENT && ts.offset() < node.getEndOffset() && ts.token().text().toString().trim() != "--}}") {
            formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
            moveNext();
        }
        id = ts.token().id();
        if (id.equals(BladeTokenId.T_BLADE_COMMENT) && ts.token().text().toString().trim().equals("--}}")) {
            //formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
            formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_AFTER_BLADE_COMMENT, ts.offset()));
        }
        int debug = 3;
    }

    @Override
    public void visit(BladeInlineSectionStatement node) {
    }

    @Override
    public void visit(DirectiveWithArgument node) {
    }

    @Override
    public void visit(BladeConditionStatement node) {
    }

    @Override
    public void visit(BladeElseIfStatement node) {
    }

    @Override
    public void visit(InLineBladePhp node) {
        //TODO move into a function
        BladeTokenId id = ts.token().id();
        String tText = ts.token().text().toString();

        if (!tText.startsWith("@")) {
            ts.movePrevious();
            if (ts.token() == null) {
                return;
            }
            tText = ts.token().text().toString();

            if (!tText.startsWith("@")) {
                return;
            }
        }
        id = ts.token().id();
        if (insideHtmlElementTag) {
            formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_TAG_INSIDE_HTML_TAG, ts.offset()));
        } else {
            formatTokens.add(new FormatToken.PhpBladeToken(FormatToken.Kind.WHITESPACE_BEFORE_BLADE_PHP, ts.offset(), ts.token().text().toString()));
        }
        //formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
        
        if (insideHtmlElementTag) {
            return;
        }
        
        moveNext();
        id = ts.token().id();
        
        
        if (id.equals(BladeTokenId.T_BLADE_PHP)){
            formatTokens.add(new FormatToken.PhpBladeToken(FormatToken.Kind.WHITESPACE_BEFORE_BLADE_PHP_BODY, ts.offset(),
                    ts.token().text().toString()));
            //formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
        }
        
        moveNext();
        id = ts.token().id();
        tText = ts.token().text().toString();
        
        if (tText.equals("@endphp")) {
            formatTokens.add(new FormatToken.PhpBladeToken(FormatToken.Kind.WHITESPACE_BEFORE_BLADE_PHP, ts.offset(),
                    ts.token().text().toString()));
            //formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
         }
    }

    private void addDirectiveBlockWSTokens(DirectiveExpressionBlock node) {
        BladeTokenId id = ts.token().id();
        String tText = ts.token().text().toString();

        if (!tText.startsWith("@")) {
            ts.movePrevious();
            if (ts.token() == null) {
                return;
            }
            tText = ts.token().text().toString();

            if (!tText.startsWith("@")) {
                return;
            }
        }

        setBlockLineInlineStatus(node);
        formatTokens.add(new FormatToken.WsDirectiveToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_START_TAG,
                ts.offset(), ts.token().text().toString()));
        formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));

        while (moveNext() && ts.offset() < node.getArgumentExpression().getStartOffset() - 1) {
            BladeTokenId btid = ts.token().id();
            String tt = ts.token().text().toString();
            if (isWhitespaceToken(btid) && lastWhitespaceOffset != ts.offset()) {
                lastWhitespaceOffset = ts.offset();
                formatTokens.addAll(resolveWhitespaceTokens());
            }
        }

        //left paren
        ts.move(node.getArgumentExpression().getStartOffset() - 1);
        if (!ts.movePrevious()){
            moveNext();
        }

        if (ts.token() == null) {
            return;
        }
        String text = ts.token().text().toString();
        int offset = ts.offset();

        if (ts.token().id().equals(BladeTokenId.BLADE_PHP_TOKEN)) {
            formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_PAREN, ts.offset()));
            formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
        }

        //right paren
        ts.move(node.getArgumentExpression().getEndOffset());
        ts.movePrevious();
        Token token = ts.token();
        text = ts.token().text().toString();
        if (ts.token().id().equals(BladeTokenId.BLADE_PHP_TOKEN)) {
            formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
            //formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_AFTER_DIRECTIVE_PAREN, ts.offset()));
            if (!blockIsInline) {
                formatTokens.add(new FormatToken.IndentToken(ts.offset(), options.indentSize));
            }
        }

        if (node.getBody() != null) {
            scan(node.getBody().getStatements());
        }

        //TODO check for whitespace 
        if (formatTokens.size() > 1) {
            FormatToken lastFormatToken = formatTokens.get(formatTokens.size() - 1);
            int lastoffset = lastFormatToken.getOffset();
            ts.move(lastoffset);
            while (moveNext() && ts.offset() < node.getEndOffset()) {
                BladeTokenId btid = ts.token().id();
                String tt = ts.token().text().toString();
                if (isWhitespaceToken(btid) && lastWhitespaceOffset != ts.offset()) {
                    lastWhitespaceOffset = ts.offset();
                    formatTokens.addAll(resolveWhitespaceTokens());
                }
            }
        }

        ts.move(node.getEndOffset());

        if (ts.movePrevious()) {
            String endTag = ts.token().text().toString();
            if (!blockIsInline) {
                formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_DECREMENT_INDENT, ts.offset()));
            }
            formatTokens.add(new FormatToken.WsDirectiveToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_ENDTAG, ts.offset(),
                    ts.token().text().toString()));
            formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
            formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_AFTER_DIRECTIVE_ENDTAG, ts.offset()));
        }

        moveNext();
    }

    private void addDirectiveInlineWSTokens(InlineDirectiveStatement node) {
        BladeTokenId id = ts.token().id();
        String tText = ts.token().text().toString();

        if (!tText.startsWith("@")) {
            ts.movePrevious();
            if (ts.token() == null) {
                return;
            }
            tText = ts.token().text().toString();

            if (!tText.startsWith("@")) {
                return;
            }
        }

        id = ts.token().id();
        if (insideHtmlElementTag){
            formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_TAG_INSIDE_HTML_TAG, ts.offset()));
        } else {
            formatTokens.add(new FormatToken.WsDirectiveToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_TAG, ts.offset(), ts.token().text().toString()));
        }
        formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));

        //left paren
        ts.move(node.getArgumentExpression().getStartOffset() - 1);
        ts.movePrevious();

        while (ts.token().id() != BladeTokenId.BLADE_PHP_TOKEN
                && ts.offset() < node.getArgumentExpression().getStartOffset()) {
            moveNext();
        }

        String text = ts.token().text().toString();
        int offset = ts.offset();

        if (ts.token().id().equals(BladeTokenId.BLADE_PHP_TOKEN)) {
            formatTokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_PAREN, ts.offset()));
            formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
        }

        //right paren
        ts.move(node.getArgumentExpression().getEndOffset());
        ts.movePrevious();
        Token token = ts.token();
        text = ts.token().text().toString();
        if (ts.token().id().equals(BladeTokenId.T_BLADE_PHP_VAR)) {
            moveNext();
        }
        if (ts.token() == null) {
            return;
        }
        if (ts.token().id().equals(BladeTokenId.BLADE_PHP_TOKEN)) {
            formatTokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
        }
    }

    private boolean isTreatedAsHtml(BladeTokenId id) {
        switch (id) {
            case T_HTML:
            case NEWLINE:
            case WHITESPACE:
                return true;
        }
        return false;
    }

    private boolean isWhitespaceToken(BladeTokenId id) {
        switch (id) {
            case NEWLINE:
            case WHITESPACE:
                return true;
        }
        return false;
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
            addFormatToken2(formatTokens);
        }
        ts.movePrevious();
    }

    private void addAllUntilOffset(int offset, String terminator) {
        while (moveNext() && ts.offset() < offset
                && (ts.offset() + ts.token().length()) <= offset
                && !TokenUtilities.textEquals(ts.token().text(), terminator)) {
            addFormatToken2(formatTokens);
        }
        ts.movePrevious();
    }

    private void addFormatToken(List<FormatToken> tokens) {

    }

    private void addFormatToken2(List<FormatToken> tokens) {
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
        if (1 == 1) {
            return;
        }
        switch (id) {
            case WHITESPACE:
            case NEWLINE:
                tokens.addAll(resolveWhitespaceTokens());
                if (prevTokenId.equals(BladeTokenId.T_HTML)) {
                    String debug = prevHtmlText;
                    Pattern pattern = Pattern.compile("<(\\/[\\w\\d\\s]+)>");

                    if (indent < 0) {
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
                            if (closingTagCount > 0) {
                                formatTokens.add(new FormatToken.IndentToken(ts.offset(), -closingTagCount * options.indentSize));
                            } else if (newLines > 0) {
                                formatTokens.add(new FormatToken.IndentToken(ts.offset(), newLines * options.indentSize));
                            }
                            int debug2 = 1;
                        }
                    }
                }
                break;
            case T_BLADE_COMMENT:
                tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_BLADE_COMMENT, ts.offset()));
                tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                break;
            case T_BLADE_SECTION:
            //no break
            case T_BLADE_FOR:
            //no break
            case T_BLADE_IF:
            //no break;    
            case T_BLADE_FOREACH:
                //
                inlineState = blockIsInline;
                blockState = !blockIsInline;
                if (!blockIsInline) {
                    tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_START_TAG, ts.offset()));
                } else {
                    tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_START_TAG_INLINE, ts.offset()));
                }
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
            case T_BLADE_ELSEIF:
            //no break
            case T_BLADE_ELSE:
                if (!blockIsInline) {
                    indent -= options.indentSize;
                    if (indent < 0) {
                        tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_DECREMENT_INDENT, ts.offset()));
                    } else {
                        tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_ELSE, ts.offset()));
                    }
                } else {
                    tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_ENDTAG_INLINE, ts.offset()));
                }
                tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                break;
            case T_BLADE_ENDSECTION:
            //no break
            case T_BLADE_ENDIF:
            //no break
            case T_BLADE_ENDFOR:
            //no break
            case T_BLADE_ENDFOREACH:
                if (!blockIsInline) {
                    indent -= options.indentSize;
                    if (indent < 0) {
                        tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_DECREMENT_INDENT, ts.offset()));
                    } else {
                        tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_ENDTAG, ts.offset()));
                    }

                } else {
                    tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_ENDTAG_INLINE, ts.offset()));
                }
                tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                break;
            case BLADE_PHP_TOKEN:
                CharSequence txt = ts.token().text();

                //statement whitespace before left paren
                if (TokenUtilities.textEquals("(", txt)) { // NOI18N
                    if (parent instanceof DirectiveExpressionBlock || parent instanceof BladeProgram) {
                        tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_PAREN, ts.offset()));
                        tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                    }
                } else if (TokenUtilities.textEquals(")", txt)) {
                    //to do check if the directive is a block tag
                    if (parent instanceof DirectiveExpressionBlock) {
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
                tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_ECHO, ts.offset()));
                tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                break;
            case T_BLADE_PHP_ECHO:
                tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_BEFORE_ECHO_VAR, ts.offset()));
                tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
                //tokens.add(new FormatToken(FormatToken.Kind.WHITESPACE_AFTER_ECHO_VAR, ts.offset()));
                break;
            case T_HTML:
                prevHtmlText = ts.token().text().toString();
                break;
            default:
            //tokens.add(new FormatToken(FormatToken.Kind.TEXT, ts.offset(), ts.token().text().toString()));
        }
        prevTokenId = id;
    }

    protected static int findLastNonWhitespaceCharacter(String s) {
        int index = s.length() - 1;
        while (index > 0) {
            boolean isWhitespace = Character.isWhitespace(s.charAt(index));
            if (!isWhitespace) {
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

    private void setBlockLineInlineStatus(ASTNode node) {
        int startLine = LineDocumentUtils.getLineStart(document, node.getStartOffset());
        int endLine = LineDocumentUtils.getLineStart(document, node.getEndOffset());
        blockIsInline = startLine == endLine;
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
