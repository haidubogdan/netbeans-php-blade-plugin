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
    public int roundParenBalance = 0;
    public int squareParenBalance = 0;
    public int curlyParenBalance = 0;
    public int exitIfModePosition = 0;
    public boolean hasPhpExprContent = false;

    public ColoringLexerAdaptor(CharStream input) {
        super(input);
    }

    public int getCurrentRuleType() {
        return _currentRuleType;
    }

    public void setCurrentRuleType(int ruleType) {
        this._currentRuleType = ruleType;
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

    public boolean endsWith(char ch1, char ch2) {
        return this._input.LA(1) == ch1 && this._input.LA(2) == ch2;
    }

    public boolean endsWith(char ch1, char ch2, char ch3) {
        return this._input.LA(1) == ch1
                && this._input.LA(2) == ch2
                && this._input.LA(3) == ch3;
    }

    public boolean hasNoBladeParamOpenBracket() {
        return this.roundParenBalance > 0
                && this.squareParenBalance == 0
                && this.curlyParenBalance == 0;
    }
    
    public void consumeRParen(){
        //we start from 0 balance
        this.roundParenBalance--;
        if (this.roundParenBalance < 0) {
            this.roundParenBalance = 0;
            this.setType(BladeAntlrLexer.BLADE_PARAM_RPAREN);
            this.mode(DEFAULT_MODE);
        } else {
             this.setType(BladeAntlrLexer.BLADE_PARAM_EXTRA);
        }
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
    
    public void maskFreezeString(){
        if (this._input.LA(2) == ')'){
            this.setText("@@");
        } else {
            this.setText("@");
        }
        this.more();
    }
}
