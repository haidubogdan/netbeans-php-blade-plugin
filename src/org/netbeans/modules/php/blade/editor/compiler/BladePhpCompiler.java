/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.editor.compiler;

import java.util.Map;
import java.util.TreeMap;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.php.blade.editor.parser.ParsingUtils;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrParserBaseListener;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler.BladeAntlrCompilerLexer;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler.BladeAntlrCompilerParser;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler.BladeAntlrCompilerParserBaseListener;
import org.netbeans.modules.php.editor.parser.PHPParseResult;

/**
 * we will need to maintain the carret position for code completion to work
 *
 * @author bogdan
 */
public class BladePhpCompiler {

    boolean finished = false;
    public StringBuilder result = new StringBuilder();

    public BladePhpCompiler() {
    }

    protected BladeAntlrCompilerParser createParser(Snapshot snapshot) {
        CharStream cs = CharStreams.fromString(String.valueOf(snapshot.getText()));
        BladeAntlrCompilerLexer lexer = new BladeAntlrCompilerLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BladeAntlrCompilerParser ret = new BladeAntlrCompilerParser(tokens);
        ret.removeErrorListener(ConsoleErrorListener.INSTANCE);
        return ret;
    }

    public BladePhpCompiler extractPhpContent(Snapshot snapshot) {
        if (!finished) {
            BladeAntlrCompilerParser parser = createParser(snapshot);
            parser.addParseListener(createPhpCompiledTextListener());

            evaluateParser(parser);

            finished = true;
        }
        return this;
    }

    public PHPParseResult getPhpParserResult() {
        if (result.length() == 0) {
            return null;
        }
        ParsingUtils parsingUtils = new ParsingUtils();
        parsingUtils.parsePhpText(result.toString());
        return parsingUtils.getParserResult();
    }

    protected ParseTreeListener createPhpCompiledTextListener() {

        return new BladeAntlrCompilerParserBaseListener() {
            int lastPhpOffset = 0;

            @Override
            public void exitPhp_blade(BladeAntlrCompilerParser.Php_bladeContext ctx) {
                int startOffset = ctx.getStart().getStartIndex();
                if (startOffset > 0 && startOffset >= lastPhpOffset) {
                    //fill in the skipped content minus one element
                    result.append(new String(new char[startOffset - lastPhpOffset - 1]).replace("\0", " "));
                }

                if (startOffset > 0) {
                    result.append("<?php");
                    result.append(ctx.php_blade_code().getText());
                    //a bit of hack
                    result.append("     ?>");
                }
                lastPhpOffset = ctx.getStop().getStopIndex() + 1;
            }

            @Override
            public void exitPhp_inline(BladeAntlrCompilerParser.Php_inlineContext ctx) {
                int startOffset = ctx.getStart().getStartIndex();
                if (startOffset > 0 && startOffset >= lastPhpOffset) {
                    //fill in the skipped content
                    result.append(new String(new char[startOffset - lastPhpOffset]).replace("\0", " "));
                }

                result.append(ctx.PHP_INLINE().getSymbol().getText());

                lastPhpOffset = ctx.getStop().getStopIndex() + 1;
            }
        };
    }

    protected void evaluateParser(BladeAntlrCompilerParser parser) {
        parser.file();
    }

}
