/*
Licensed to the Apache Software Foundation (ASF)
 */
package org.netbeans.modules.php.blade.syntax.antlr4.v10;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
/**
 *
 * @author bogdan
 */
public abstract class LexerAdaptor extends Lexer {

    public int exitIfModePosition = 0;
    public boolean compomentTagOpen = false;
    public int identifierStringPos = 1;
    public int argCounter = 1;

    public LexerAdaptor(CharStream input) {
        super(input);
    }
    
    public void lookupMode(int mode){
        if (this._input.LA(1) == '('){
            this.mode(mode);
        } else {
            this.resetIdentifierStringPos();
            this.skip();
        }
    }
    
    public void flexibleMode(int mode){
        if (this._input.LA(1) == '('){
            this.mode(mode);
        }
    }
    
    public void resetIdentifierStringPos(){
        this.identifierStringPos = 1;
    }
    
    public void consumeCloseTag(int curlyBalance){
        if (curlyBalance == 0) {
            this.setType(BladeAntlrLexer.BLADE_CONTENT_CLOSE_TAG);
        } else {
            this.skip();
        }
    }
}
