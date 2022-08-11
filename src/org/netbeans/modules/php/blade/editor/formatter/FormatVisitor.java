package org.netbeans.modules.php.blade.editor.formatter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;
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
    boolean lastHtmlEndsInNewLine;
    private final Pattern newLineEndPattern = Pattern.compile("\\n([ ]+)$");

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
        if (node == null){
            return;
        }
        if (node instanceof BladeProgram){
            super.scan(node);
            return;
        }
        
        if (node instanceof InLineHtml){
            if (((InLineHtml) node).getContent().length() == 0){
                return;
            }
        }

        int currentDocLineStart  = 0;
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
        
        if (!parseError){
            lastDocLineStart = currentDocLineStart;
            lastDocLineEnd = currentDocLineEnd;
        }
        
        node.accept(this);

        if (node instanceof DirectiveExpressionBlock){
            DirectiveExpressionBlock directiveBlockNode = (DirectiveExpressionBlock) node;
            String directiveName = directiveBlockNode.getDirectiveName().toString();
            int directiveOffset = directiveBlockNode.getDirectiveName().getStartOffset();
            if (!lastHtmlEndsInNewLine && lastDocLineStart == lastHtmlLineEnd){
                int x = 1;
            } else {
                formatTokens.add(
                        new FormatToken.WsDirectiveToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_START_TAG,
                                directiveOffset, directiveName));
            }
            if (directiveBlockNode.getBody() == null){
                return;
            }
            this.scan(directiveBlockNode.getBody().getStatements());
            DirectiveEndTag directiveEndTag = directiveBlockNode.getDirectiveEndTag();
            if (directiveEndTag  != null){
                 formatTokens.add(
                        new FormatToken.WsDirectiveToken(FormatToken.Kind.WHITESPACE_BEFORE_DIRECTIVE_ENDTAG,
                                directiveEndTag.getStartOffset(), directiveEndTag.getName()));
            }
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

//
//    @Override
//    public void visit(DirectiveExpressionBlock node) {
//        scan(node.getBody().getStatements());
//    }

    @Override
    public void visit(InLineHtml node) {
       String content = node.getContent();
       boolean isSimpleWhitespace = content.matches("^[ \t\r]+$");
       lastHtmlNode = node;
       lastHtmlLineStart = lastDocLineStart;
       lastHtmlLineEnd = lastDocLineEnd;
       Matcher m = newLineEndPattern.matcher(content);
       boolean hasMatches =  m.matches();
       lastHtmlEndsInNewLine = content.endsWith("\n") || hasMatches;
       //??
       if (lastHtmlEndsInNewLine){
            String val = hasMatches ? m.group(1) : "";
            if (content.length() == 1){
                //formatTokens.add(new FormatToken.IndentToken(node.getStartOffset(), options.indentSize, val.length()));
            } else {
                formatTokens.add(new FormatToken.IndentToken(node.getStartOffset(), options.indentSize, val.length()));
            }
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
