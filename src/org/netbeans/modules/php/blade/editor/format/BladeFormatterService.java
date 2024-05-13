package org.netbeans.modules.php.blade.editor.format;

import java.util.Map;
import java.util.TreeMap;
import javax.swing.text.BadLocationException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.php.blade.syntax.antlr4.formatter.BladeAntlrFormatterLexer;
import org.netbeans.modules.php.blade.syntax.antlr4.formatter.BladeAntlrFormatterParser;
import org.netbeans.modules.php.blade.syntax.antlr4.formatter.BladeAntlrFormatterParserBaseListener;
import org.openide.util.Exceptions;

/**
 * TODO fix indentation
 * 
 * @author bhaidu
 */
public class BladeFormatterService {

    public final Map<Integer, FormatToken> formattedLineIndentList = new TreeMap<>();
    boolean debugMode = false;
    public boolean isIndentation;

    public void format(Context context, String text, int indentSize) {
        isIndentation = context.isIndent();
        BladeAntlrFormatterLexer lexer = new BladeAntlrFormatterLexer(CharStreams.fromString(text));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BladeAntlrFormatterParser parser = new BladeAntlrFormatterParser(tokens);
        parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        parser.addParseListener(createFormatterListener());
        parser.setBuildParseTree(false);
        parser.file();

        final int cstart = context.startOffset();
        final int cend = context.endOffset();
        int textDelta = 0;
        System.out.println("Starting formatting from caret " + cstart + ":\n");
        
        for (Map.Entry<Integer, FormatToken> entry : formattedLineIndentList.entrySet()) {
            int tstart = entry.getValue().tokenStart;
            int indent = entry.getValue().indent;
            int htmlIndent = entry.getValue().htmlIndent;
            if (tstart < context.document().getLength()) {
                int existingLineIndent = 0;
                try {
                    existingLineIndent = context.lineIndent(tstart);
                } catch (BadLocationException ex) {
                    Exceptions.printStackTrace(ex);
                    break;
                }
                if (tstart > cend) {
                    System.out.println("exit " + tstart + " > " + cend);
                    System.out.println("line : " + entry.getKey() + " ei " + existingLineIndent);
                    System.out.println("token : " + entry.getValue());
                    System.out.println("Finished formatting for caret " + cstart);
                    break;
                }
            }

            if (tstart >= cstart) {
                System.out.println("doc length : " + context.document().getLength());
                System.out.println("delta : " + (tstart - textDelta));
                if (context.document().getLength() < (tstart - textDelta)) {
                    //skipping
                    continue;
                }

                System.out.println("line : " + entry.getKey());
                System.out.println("token : " + entry.getValue());
                System.out.println("indent : " + indent);
                System.out.println("htmlindent : " + htmlIndent);
                try {
                    int lineStart_i = context.lineStartOffset(tstart - textDelta);
                    int originalIndent_i = context.lineIndent(lineStart_i);
                    int wsIndent = (indent + htmlIndent) * indentSize;
                    System.out.println("linestart + offset : " + (lineStart_i + wsIndent));
                    if (lineStart_i + wsIndent > context.document().getLength()) {
                        System.out.println("out of range : " + (lineStart_i + wsIndent));
                        break;
                    }
                    context.modifyIndent(lineStart_i, wsIndent);
                    System.out.println("delta : " + (originalIndent_i - wsIndent));
                    System.out.println("====================================");
                    textDelta += (originalIndent_i - wsIndent);
                } catch (BadLocationException ex) {
                    Exceptions.printStackTrace(ex);
                    break;
                }
            }
        }
    }

    private ParseTreeListener createFormatterListener() {
        return new BladeAntlrFormatterParserBaseListener() {
            int indent = 0;
            int blockBalance = 0;
            int htmlBlockBalance = 0;
            int lastIncrementedLine = 0;

            @Override
            public void exitBlock_start(BladeAntlrFormatterParser.Block_startContext ctx) {

                Token start = ctx.getStart();
                blockBalance++;
                if (ctx.getStop() != null && !formattedLineIndentList.containsKey(start.getLine())) {
                    Token endDefinition = ctx.getStop();
                    //hack to indent after blade block
                    int offset = isIndentation ? 1 : 0;
                    formattedLineIndentList.put(endDefinition.getLine(),
                            new FormatToken(endDefinition.getStopIndex() + 1 + offset, indent+offset, htmlBlockBalance, null));
                }
                indent++;
            }

            @Override
            public void exitBlock_end(BladeAntlrFormatterParser.Block_endContext ctx) {
                Token start = ctx.getStart();
                int line = start.getLine();
                indent--;
                //correction
                if (indent < 0) {
                    indent = 0;
                }
                if (!formattedLineIndentList.containsKey(line)) {
                    String debugText = debugMode ? start.getText() : null;
                    formattedLineIndentList.put(line, new FormatToken(start.getStartIndex(), indent, htmlBlockBalance, debugText));
                } else {
                    formattedLineIndentList.remove(line);
                }

                blockBalance--;
            }

            @Override
            public void exitSection_block_start(BladeAntlrFormatterParser.Section_block_startContext ctx) {
                Token start = ctx.getStart();
                blockBalance++;
                if (ctx.getStop() != null && !formattedLineIndentList.containsKey(start.getLine())) {
                    Token rArgParent = ctx.getStop();
                    String debugText = debugMode ? rArgParent.getText() : null;
                    formattedLineIndentList.put(rArgParent.getLine(), new FormatToken(rArgParent.getStopIndex() + 1, indent, htmlBlockBalance, debugText));
                    indent++;
                }
            }

            @Override
            public void exitSection_block_end(BladeAntlrFormatterParser.Section_block_endContext ctx) {
                Token start = ctx.getStart();
                int line = start.getLine();
                if (!formattedLineIndentList.containsKey(line)) {
                    indent--;
                    if (indent < 0) {
                        indent = 0;
                    }
                    formattedLineIndentList.put(line, new FormatToken(start.getStartIndex(), indent, htmlBlockBalance, start.getText()));
                } else {
                    formattedLineIndentList.remove(line);
                }
                //correction
                if (indent < 0) {
                    indent = 0;
                }
                blockBalance--;
            }

            @Override
            public void exitInline_identable_element(BladeAntlrFormatterParser.Inline_identable_elementContext ctx) {
                Token start = ctx.getStart();
                int line = start.getLine();
                if (!formattedLineIndentList.containsKey(line)) {
                    if ((htmlBlockBalance > 0 || blockBalance > 0)) {
                        formattedLineIndentList.put(line, new FormatToken(start.getStartIndex(), indent, htmlBlockBalance, start.getText()));
                    }
                }
            }

            @Override
            public void exitNl_with_space(BladeAntlrFormatterParser.Nl_with_spaceContext ctx) {
                if (ctx.WS().isEmpty()) {
                    return;
                }

                Token start = ctx.WS(0).getSymbol();
                int line = start.getLine();
                if (!formattedLineIndentList.containsKey(line)) {
                    formattedLineIndentList.put(line, new FormatToken(start.getStartIndex(), indent, "ws"));
                }
            }

            @Override
            public void exitHtml_close_tag(BladeAntlrFormatterParser.Html_close_tagContext ctx) {

                Token start = ctx.getStart();
                int line = start.getLine();
                if (line > 0 && lastIncrementedLine != line){
                    if (htmlBlockBalance > 0) {
                        htmlBlockBalance--;
                    } else {
                        htmlBlockBalance = 0;
                    }
                    lastIncrementedLine = line;
                }
                if (!formattedLineIndentList.containsKey(line)) {
                    formattedLineIndentList.put(line, new FormatToken(start.getStartIndex(), indent, htmlBlockBalance, start.getText()));
                }
            }

            @Override
            public void exitHtml_tag(BladeAntlrFormatterParser.Html_tagContext ctx) {
                Token start = ctx.getStart();
                int line = start.getLine();
                if (!formattedLineIndentList.containsKey(line)) {
                    if ((htmlBlockBalance > 0 || blockBalance > 0)) {
                        formattedLineIndentList.put(line, new FormatToken(start.getStartIndex(), indent, htmlBlockBalance, start.getText()));
                    }
                    htmlBlockBalance++;
                }
            }

            @Override
            public void exitSelf_closed_tag(BladeAntlrFormatterParser.Self_closed_tagContext ctx) {
                Token start = ctx.getStart();
                int line = start.getLine();
                if (!formattedLineIndentList.containsKey(line)) {
                    if ((htmlBlockBalance > 0 || blockBalance > 0)) {
                        formattedLineIndentList.put(line, new FormatToken(start.getStartIndex(), indent, htmlBlockBalance, start.getText()));
                    }
                }
            }

            @Override
            public void exitHtml_indent(BladeAntlrFormatterParser.Html_indentContext ctx) {
                Token start = ctx.getStart();
                int line = start.getLine();
                if (!formattedLineIndentList.containsKey(line)) {
                    String debugText = debugMode ? start.getText() : null;
                    formattedLineIndentList.put(line, new FormatToken(start.getStartIndex(), indent, htmlBlockBalance, debugText));
                }
                htmlBlockBalance++;
            }

            @Override
            public void exitBlock_aligned_directive(BladeAntlrFormatterParser.Block_aligned_directiveContext ctx) {
                Token start = ctx.getStart();
                int line = start.getLine();
                if (!formattedLineIndentList.containsKey(line)) {
                    if ((htmlBlockBalance > 0 || blockBalance > 0)) {
                        formattedLineIndentList.put(line, new FormatToken(start.getStartIndex(), indent - 1, htmlBlockBalance, start.getText()));
                    }
                }
            }
        };
    }
}
