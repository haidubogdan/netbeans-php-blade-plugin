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

    public LexerAdaptor(CharStream input) {
        super(input);
    }
    
    public void lookupMode(int mode){
        if (this._input.LA(1) == '('){
            this.mode(mode);
        } else {
            this.skip();
        }
    }
    
    public void flexibleMode(int mode){
        if (this._input.LA(1) == '('){
            this.mode(mode);
        }
    }
}
