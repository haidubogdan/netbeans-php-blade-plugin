package org.netbeans.modules.php.blade.editor.format;

import java.util.Map;
import java.util.TreeMap;
import javax.swing.text.BadLocationException;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.netbeans.modules.editor.indent.spi.Context;
import org.netbeans.modules.php.blade.syntax.antlr4.formatter.BladeAntlrFormatterLexer;
import org.netbeans.modules.php.blade.syntax.antlr4.formatter.BladeAntlrFormatterParser;
import org.netbeans.modules.php.blade.syntax.antlr4.formatter.BladeAntlrFormatterParserBaseListener;
import org.openide.util.Exceptions;

/**
 *
 * @author bhaidu
 */
public class BladeFormatterService {

    public final Map<Integer, FormatToken> formattedLineIndentList = new TreeMap<>();

    public void format(Context context, String text, int indentSize) {
        BladeAntlrFormatterLexer lexer = new BladeAntlrFormatterLexer(CharStreams.fromString(text));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BladeAntlrFormatterParser parser = new BladeAntlrFormatterParser(tokens);
        parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        parser.addParseListener(createFormatterListener());
        parser.file();

        final int cstart = context.startOffset();
        final int cend = context.endOffset();
        int textDelta = 0;
        System.out.println("Startng formatting :\n");

        for (Map.Entry<Integer, FormatToken> entry : formattedLineIndentList.entrySet()) {
            int tstart = entry.getValue().tokenStart;
            int indent = entry.getValue().indent;
            int existingLineIndent = 0;
            try {
                existingLineIndent = context.lineIndent(tstart);
            } catch (BadLocationException ex) {
                Exceptions.printStackTrace(ex);
            }
            if (tstart > cend) {
                System.out.println("finished " + tstart + " > " + cend);
                System.out.println("line : " + entry.getKey() + " ei " + existingLineIndent);
                System.out.println("token : " + entry.getValue());
                break;
            }

            if (tstart >= cstart) {
                try {
                    System.out.println(" lineOffset : " + context.document().getLength() + " ~ " + (tstart - textDelta));
                    if (context.document().getLength() < (tstart - textDelta)) {
                        //skipping
                        continue;
                    }

                    System.out.println("line : " + entry.getKey());
                    System.out.println("token : " + entry.getValue());
                    int lineStart_i = context.lineStartOffset(tstart - textDelta);
                    int originalIndent_i = context.lineIndent(lineStart_i);
//                            if (indentContext) {
//                                indent = 2;
//                            }
                    int wsIndent = indent * indentSize;

                    context.modifyIndent(lineStart_i, wsIndent);
                    System.out.println("delta : " + (originalIndent_i - wsIndent));
                    textDelta += (originalIndent_i - wsIndent);
                } catch (BadLocationException ex) {
                    Exceptions.printStackTrace(ex);
                }
            } else {
                //
                System.out.println("out of range " + tstart + " < " + cstart);
                System.out.println("line : " + entry.getKey() + " ei " + existingLineIndent);
                System.out.println("token : " + entry.getValue());
                System.out.println("===============================");
            }
        }
    }

    private ParseTreeListener createFormatterListener() {
        return new BladeAntlrFormatterParserBaseListener() {
            int indent = 0;
            int blockBalance = 0;

            @Override
            public void exitBlock_start(BladeAntlrFormatterParser.Block_startContext ctx) {

                Token start = ctx.block_directive_name().getStart();
                if (!formattedLineIndentList.containsKey(start.getLine())) {
                    formattedLineIndentList.put(start.getLine(), new FormatToken(start.getStartIndex(), indent, start.getText()));
                    indent++;
                } else {
                    formattedLineIndentList.remove(start.getLine());
                }
                blockBalance++;
                if (ctx.getStop() != null) {
                    Token rArgParent = ctx.getStop();
                    //wsTokenAfterArgStm.put(rArgParent.getLine(), new BladeFormatter.FormatToken(rArgParent.getStopIndex() + 1, indent, rArgParent.getText()));
                }
            }

            @Override
            public void exitBlock_end(BladeAntlrFormatterParser.Block_endContext ctx) {
                Token start = ctx.getStart();
                int line = start.getLine();
                if (!formattedLineIndentList.containsKey(line)) {
                    indent--;
                    formattedLineIndentList.put(line, new FormatToken(start.getStartIndex(), indent, start.getText()));
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
                    int blockIndent = blockBalance > 0 ? 1 : 0;
                    formattedLineIndentList.put(line, new FormatToken(start.getStartIndex(), indent, start.getText()));
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
                    int blockIndent = blockBalance > 0 ? 1 : 0;
                    formattedLineIndentList.put(line, new FormatToken(start.getStartIndex(), indent, "ws"));
                }
            }
        };
    }
}
