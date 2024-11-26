/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.syntax.antlr4.html_components;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.antlr.v4.runtime.CharStreams;
import org.netbeans.modules.php.blade.syntax.antlr4.utils.BladeAntlrUtils;
import org.netbeans.spi.lexer.antlr4.AntlrTokenSequence;

/**
 *
 * @author bogdan
 */
public final class BladeHtmlAntlrUtils extends BladeAntlrUtils {

    public static AntlrTokenSequence getTokens(Document doc) {

        try {
            String text = doc.getText(0, doc.getLength());
            return new AntlrTokenSequence(new BladeHtmlAntlrLexer(CharStreams.fromString(text)));
        } catch (BadLocationException ex) {

        }
        return null;
    }
}
