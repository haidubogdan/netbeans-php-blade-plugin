package org.netbeans.modules.php.blade.editor.formatter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import org.netbeans.api.editor.document.LineDocumentUtils;
import org.netbeans.api.lexer.Token;
import org.netbeans.api.lexer.TokenUtilities;
import org.netbeans.editor.BaseDocument;
import org.netbeans.modules.php.blade.editor.formatter.TokenFormatter.DocumentOptions;
import org.netbeans.modules.php.blade.editor.lexer.BladeTokenId;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.ASTNode;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.*;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.visitors.DefaultVisitor;


/**
 *
 * @author bhaidu
 */
public class FormatVisitor extends DefaultVisitor {

    private static final Logger LOGGER = Logger.getLogger(FormatVisitor.class.getName());
    private final BaseDocument doc;
    private final List<FormatToken> formatTokens;
    private final LinkedList<ASTNode> path;
    private final DocumentOptions options;
    private final int caretOffset;
    private final int startOffset;
    private final int endOffset;
    boolean inlineState = false;
    boolean blockState = false;
    boolean blockIsInline = false;
    boolean insideHtmlElementTag = false;
    int lastWhitespaceOffset = -1;
    int lastNodeStartOffset;
    int lastNodeEndOffset;
    InLineHtml lastHtmlNode;
    int lastDocLineStart;
    int lastDocLineEnd;
    int lastHtmlLineStart;
    int lastHtmlLineEnd;
    int lastSpaceCount = 0;
    boolean lastHtmlEndsInNewLine;

    public FormatVisitor(BaseDocument document, DocumentOptions documentOptions, final int caretOffset, final int startOffset, final int endOffset) {
        this.doc = document;
        path = new LinkedList<>();
        options = documentOptions;
        formatTokens = new ArrayList<>();
        formatTokens.add(new FormatToken.InitToken());
        this.caretOffset = caretOffset;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
    }

    @Override
    public void visit(BladeProgram program) {
        super.visit(program);
    }

    @Override
    public void scan(ASTNode node) {
        if (node == null) {
            return;
        }
        if (node instanceof BladeProgram) {
            super.scan(node);
            return;
        }

        if (node instanceof InLineHtml) {
            if (((InLineHtml) node).getContent().length() == 0) {
                return;
            }
        }

        int currentDocLineStart = 0;
        int currentDocLineEnd = 0;
        boolean parseError = false;
        try {
            currentDocLineStart = LineDocumentUtils.getLineIndex(doc, node.getStartOffset());
            currentDocLineEnd = LineDocumentUtils.getLineIndex(doc, node.getEndOffset());
        } catch (BadLocationException ex) {
            parseError = true;
            //Exceptions.printStackTrace(ex);
        }

        lastNodeStartOffset = node.getStartOffset();
        lastNodeEndOffset = node.getEndOffset();

        if (!parseError) {
            lastDocLineStart = currentDocLineStart;
            lastDocLineEnd = currentDocLineEnd;
        }

        node.accept(this);

        if (node instanceof DirectiveExpressionBlock) {
            DirectiveExpressionBlock directiveBlockNode = (DirectiveExpressionBlock) node;
            String directiveName = directiveBlockNode.getDirectiveName().getName();
            int directiveOffset = directiveBlockNode.getDirectiveName().getStartOffset();
            boolean isInline = !lastHtmlEndsInNewLine && lastDocLineStart == lastHtmlLineEnd;
            FormatToken.Kind startTagKind = (isInline) ?
                    FormatToken.Kind.WHITESPACE_BEFORE_INLINE_DIRECTIVE_START_TAG : 
                    FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_START_TAG;
            formatTokens.add(
                    new FormatToken.WsDirectiveToken(startTagKind,
                            directiveOffset, lastSpaceCount, directiveName, currentDocLineStart));
            if (directiveBlockNode.getBody() == null) {
                return;
            }
            formatTokens.add(new FormatToken.DirectiveIndentToken(node.getStartOffset(), 0, lastDocLineStart));
            this.scan(directiveBlockNode.getBody().getStatements());
            DirectiveEndTag directiveEndTag = directiveBlockNode.getDirectiveEndTag();
            if (directiveEndTag != null) {
                FormatToken.Kind endTagkind = (isInline) ? 
                        FormatToken.Kind.WHITESPACE_BEFORE_INLINE_DIRECTIVE_ENDTAG :
                        FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_ENDTAG;
                formatTokens.add(
                        new FormatToken.WsDirectiveToken(endTagkind,
                                directiveEndTag.getStartOffset(), lastSpaceCount, directiveEndTag.getName(), currentDocLineStart));
            }
        } else if (node instanceof InlineDirectiveStatement) {
            InlineDirectiveStatement directiveNode = (InlineDirectiveStatement) node;
            int directiveOffset = directiveNode.getDirectiveName().getStartOffset();
            String directiveName = directiveNode.getDirectiveName().getName();
            formatTokens.add(
                    new FormatToken.WsDirectiveToken(FormatToken.Kind.WHITESPACE_BEFORE_INLINE_DIRECTIVE_TAG,
                            directiveOffset, lastSpaceCount, directiveName, currentDocLineStart));
        }else if (node instanceof BladeConstDirectiveStatement) {
            BladeConstDirectiveStatement directiveNode = (BladeConstDirectiveStatement) node;
            int directiveOffset = directiveNode.getDirectiveName().getStartOffset();
            String directiveName = directiveNode.getDirectiveName().getName();
            formatTokens.add(
                    new FormatToken.WsDirectiveToken(FormatToken.Kind.WHITESPACE_BEFORE_INLINE_DIRECTIVE_TAG,
                            directiveOffset, lastSpaceCount, directiveName, currentDocLineStart));
        }
    }

    @Override
    public void scan(Iterable<? extends ASTNode> nodes) {
        if (nodes != null) {
            for (ASTNode n : nodes) {
                if (n.getStartOffset() < startOffset) {//in case of selection formatting
                    continue;
                }

                if (n.getEndOffset() > endOffset) {//in case of selection formatting
                    break;
                }
                this.scan(n);
            }
        }
    }

    @Override
    public void visit(InLineHtml node) {
        String content = node.getContent();
        boolean isSimpleWhitespace = content.matches("^[ \t\r]+$");
        lastHtmlNode = node;
        lastHtmlLineStart = lastDocLineStart;
        lastHtmlLineEnd = lastDocLineEnd;
        boolean hasMatches = false;
        lastHtmlEndsInNewLine = content.endsWith("\n");

        char[] chars = content.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            int temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = (char) temp;
        }
        int space = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isSpaceChar(chars[i])) {
                if (chars[i] == '\n') {
                    lastHtmlEndsInNewLine = true;
                }
                break;
            }
            space++;
        }
        lastSpaceCount = space;
        if (lastHtmlEndsInNewLine) {
            formatTokens.add(new FormatToken.HtmlIndentToken(node.getStartOffset(), space, lastDocLineStart));
        }
        //find out if it's a directive new line
    }

    @Override
    public void visit(BladeEchoStatement node) {

    }

    @Override
    public void visit(BladeComment node) {

    }

    @Override
    public void visit(InLineBladePhp node) {

    }

    @Override
    public void visit(BladeForStatement node) {
        int x = 3;
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
    public void visit(ASTNode node) {
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

    private void addDirectiveBlockWSTokens(DirectiveExpressionBlock node) {

    }

    private void addDirectiveInlineWSTokens(InlineDirectiveStatement node) {

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

        return result;
    }

    private String adjustLastWhitespaceToken(Token<? extends BladeTokenId> token) {
        String result = "";

        return result;
    }

    private void setBlockLineInlineStatus(ASTNode node) {
        int startLine = LineDocumentUtils.getLineStart(doc, node.getStartOffset());
        int endLine = LineDocumentUtils.getLineStart(doc, node.getEndOffset());
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

    private boolean hasDirectiveStart(final CharSequence text) {
        return TokenUtilities.startsWith("@", text);
    }
}
