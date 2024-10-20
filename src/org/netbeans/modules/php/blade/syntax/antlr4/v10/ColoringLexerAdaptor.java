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

    private int _currentRuleType = Token.INVALID_TYPE;
    private int roundParenBalance = 0;

    public ColoringLexerAdaptor(CharStream input) {
        super(input);
    }

    public int getCurrentRuleType() {
        return _currentRuleType;
    }

    public void setCurrentRuleType(int ruleType) {
        this._currentRuleType = ruleType;
    }

    public int getRoundParenBalance() {
        return this.roundParenBalance;
    }

    @Override
    public Token emit() {
        return super.emit();
    }

    @Override
    public void reset() {
        setCurrentRuleType(Token.INVALID_TYPE);
        super.reset();
    }

    /**
     * eager check to see if the character position in a line is at the start
     *
     * @return
     */
    public boolean IsNewLineOrStart() {
        return this._tokenStartCharPositionInLine <= 2;
    }

    public boolean peekNextChar(char peekChar) {
        return (char) this._input.LA(1) == peekChar;
    }

    public boolean peekNextChars(char peekChar, int number) {
        for (int i = 1; i < number; i++) {
            if ((char) this._input.LA(i) != peekChar) {
                return false;
            }
        }
        return true;
    }

    public void increaseRoundParenBalance() {
        this.roundParenBalance++;
    }

    public void decreaseRoundParenBalance() {
        this.roundParenBalance--;
    }

    public void resetRoundParenBalance() {
        this.roundParenBalance = 0;
    }

    public boolean endsWith(char ch1, char ch2) {
        return this._input.LA(1) == ch1 && this._input.LA(2) == ch2;
    }

    public boolean endsWith(char ch1, char ch2, char ch3) {
        return this._input.LA(1) == ch1
                && this._input.LA(2) == ch2
                && this._input.LA(3) == ch3;
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

    public void consumeExprToken() {
        if (this._input.LA(1) == ')' && this.getRoundParenBalance() <= 1) {
            this.setType(BladeAntlrColoringLexer.PHP_EXPRESSION);
        } else {
            this.more();
        }
    }

    public void consumeOpenParen() {
        this.increaseRoundParenBalance();
        if (this.roundParenBalance == 1) {
            this.setType(BladeAntlrColoringLexer.BLADE_PAREN);
        } else {
            this.more();
        }
    }

    public void consumeCloseParen() {
        this.decreaseRoundParenBalance();
        if (this.roundParenBalance <= 0) {
            this.resetRoundParenBalance();
            this.setType(BladeAntlrColoringLexer.BLADE_PAREN);
            this.mode(DEFAULT_MODE);
        } else {
            if (this._input.LA(1) == ')' && this.roundParenBalance == 1) {
                this.setType(BladeAntlrColoringLexer.PHP_EXPRESSION);
            } else {
                this.more();
            }
        }
    }
}
