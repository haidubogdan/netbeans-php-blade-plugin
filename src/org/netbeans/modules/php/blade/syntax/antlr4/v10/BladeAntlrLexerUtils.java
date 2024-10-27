/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.syntax.antlr4.v10;

import org.netbeans.modules.php.blade.syntax.antlr4.utils.*;
import java.util.List;
import java.util.Set;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer;
import static org.netbeans.modules.php.blade.syntax.antlr4.v10.BladeAntlrLexer.*;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;

/**
 *
 * @author bogdan
 */
public final class BladeAntlrLexerUtils extends BladeAntlrUtils {

    public static AntlrTokenSequence getTokens(Document doc) {

        try {
            String text = doc.getText(0, doc.getLength());
            return new AntlrTokenSequence(new BladeAntlrLexer(CharStreams.fromString(text)));
        } catch (BadLocationException ex) {

        }
        return null;
    }

    public static AntlrTokenSequence lexerStringScan(String text) {
        CharStream cs = CharStreams.fromString(text);
        BladeAntlrLexer lexer = new BladeAntlrLexer(cs);
        AntlrTokenSequence tokens = new AntlrTokenSequence(lexer);
        return tokens;
    }

    public static Token getToken(String text, int offset) {
        AntlrTokenSequence tokens = lexerStringScan(text);
        if (offset > text.length()) {
            return null;
        }
        tokens.seekTo(offset);

        if (!tokens.hasNext()) {
            return null;
        }
        Token token = tokens.next().get();
        return token;
    }

    public static int getTagPairTokenType(int tokenType) {
        switch (tokenType) {
            case BLADE_CONTENT_OPEN_TAG:
                return BLADE_CONTENT_CLOSE_TAG;
            case BLADE_CONTENT_CLOSE_TAG:
                return BLADE_CONTENT_OPEN_TAG;
            case BLADE_RAW_OPEN_TAG:
                return BLADE_RAW_CLOSE_TAG;
            case BLADE_RAW_CLOSE_TAG:
                return BLADE_RAW_OPEN_TAG;
            default:
                return -1;
        }
    }
    
    public static boolean isUndefinedDirective(int token){
        return token == BladeAntlrLexer.D_CUSTOM;
    }
}
