/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.syntax.antlr4.v10;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author bogdan
 */
public abstract class ColoringLexerAdaptor extends Lexer {

    public int rParenBalance = 0;

    public ColoringLexerAdaptor(CharStream input) {
        super(input);
    }

    @Override
    public void reset() {
        rParenBalance = 0;
        super.reset();
    }

    //blade coloring lexer
    public void consumeEscapedEchoToken() {
        if (this._input.LA(1) == '}' && this._input.LA(2) == '}') {
            this.setType(BladeAntlrColoringLexer.BLADE_PHP_ECHO_EXPR);
        } else {
            this.more();
        }
    }

    //blade coloring lexer
    public void consumeNotEscapedEchoToken() {
        if (this._input.LA(1) == '!' && this._input.LA(2) == '!' && this._input.LA(3) == '}') {
            this.setType(BladeAntlrColoringLexer.BLADE_PHP_ECHO_EXPR);
        } else {
            this.more();
        }
    }

}
