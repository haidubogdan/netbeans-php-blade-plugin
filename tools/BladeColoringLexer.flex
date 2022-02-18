   /*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2016 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2016 Sun Microsystems, Inc.
 */

package org.netbeans.modules.php.blade.editor.lexer;

import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.netbeans.modules.php.blade.editor.common.ByteStack;

@org.netbeans.api.annotations.common.SuppressWarnings({"SF_SWITCH_FALLTHROUGH", "URF_UNREAD_FIELD", "DLS_DEAD_LOCAL_STORE", "DM_DEFAULT_ENCODING", "EI_EXPOSE_REP"})
%%
%public
%class BladeColoringLexer
%type BladeTokenId
%function findNextToken
%unicode
%caseless
%char


%{
    private ByteStack stack = new ByteStack();
    private LexerInput input;
    private int parenBalanceInDirective = 0; //for directive arguments
    private boolean argHasVariable = false;
    private int pushBackCount = 0;

    public BladeColoringLexer(LexerRestartInfo info) {
        this.input = info.input();
        if(info.state() != null) {
            //reset state
            setState((LexerState) info.state(), parenBalanceInDirective);
        } else {
            //initial state
            stack.push(ST_HTML);
            zzState = ST_HTML;
            zzLexicalState = ST_HTML;
        }

    }

    public static final class LexerState  {
        final ByteStack stack;
        /** the current state of the DFA */
        final int zzState;
        /** the current lexical state */
        final int zzLexicalState;
        final int parenBalanceInDirective; 

        LexerState(ByteStack stack, int zzState, int zzLexicalState, int parenBalanceInDirective) {
            this.stack = stack;
            this.zzState = zzState;
            this.zzLexicalState = zzLexicalState;
            this.parenBalanceInDirective = parenBalanceInDirective;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            LexerState state = (LexerState) obj;
            return (this.stack.equals(state.stack)
                && (this.zzState == state.zzState)
                //&& (this.zzLexicalState == state.zzLexicalState)
                //&& (this.parenBalanceInDirective == state.parenBalanceInDirective)
                );
        }

        @Override
        public int hashCode() {
            int hash = 11;
            hash = 31 * hash + this.zzState;
            hash = 31 * hash + this.zzLexicalState;
            hash = 31 * hash + this.parenBalanceInDirective;
            if (stack != null) {
                hash = 31 * hash + this.stack.hashCode();
            }
            return hash;
        }
    }

    public LexerState getState() {
        return new LexerState(stack.copyOf(), zzState, zzLexicalState, parenBalanceInDirective);
    }

    public void setState(LexerState state, int parenBalanceInDirective) {
        this.stack.copyFrom(state.stack);
        this.zzState = state.zzState;
        this.zzLexicalState = state.zzLexicalState;
        this.parenBalanceInDirective = state.parenBalanceInDirective;
    }

    protected int getZZLexicalState() {
        return zzLexicalState;
    }

    //other functions

    protected void pushBack(int i) {
        yypushback(i);
    }

    protected void popState() {
        yybegin(stack.pop());
    }

    protected void pushState(final int state) {
        stack.push(getZZLexicalState());
        yybegin(state);
    }

    /**
     * Returns the smallest of multiple index values.
     *
     * @param values values
     * @return the smallest of multiple index values, -1 if all values are -1
     */
    private static int minIndex(int... values) {
        assert values.length != 0 : "No values"; // NOI18N
        boolean first = true;
        int min = -1;
        for (int value : values) {
            if (value == -1) {
                continue;
            }
            if (first) {
                first = false;
                min = value;
                continue;
            }
            min = Math.min(min, value);
        }
        return min;
    }

    /**
     * Get the first whitespace index of text.
     *
     * @param text the text
     * @return the first index of whitespace if whitespace exists, otherwise -1
     */
    private static int firstWhitespaceIndexOf(String text) {
        return minIndex(
            text.indexOf(' '),
            text.indexOf('\n'),
            text.indexOf('\r'),
            text.indexOf('\t')
        );
    }

    private boolean isWhitespace(){
    	return yytext().replaceAll("\\s+","").length() == 0;
    }

%}


%eofval{
        if(input.readLength() > 0) {
            String yytext = yytext();
            // backup eof
            input.backup(1);
            //and return the text as error token
             return BladeTokenId.T_HTML;
        } else {
            return null;
        }
%eofval}


%state ST_HTML
%state ST_PHP
%state ST_PHP_ECHO
%state ST_INLINE_PHP
%state ST_BLADE_PHP
%state ST_BLADE_ECHO
%state ST_BLADE_ECHO_ESCAPED
%state ST_DIRECTIVE
%state ST_COMMENT
%state ST_HIGHLIGHTING_ERROR
%state ST_CLOSE_BLADE_PHP
%state ST_PHP_LOOKING_FOR_DIRECTIVE_ARG
%state ST_PHP_LOOKING_FOR_DIRECTIVE_PARAM
%state ST_LOOKING_FOR_SECOND_PARAMETER
%state ST_BLADE_ARGUMENT
%state ST_PHP_LOOP_EXPR
%state ST_PHP_IF_EXPR
%state ST_PHP_LOOKING_FOR_IF_EXPR
%state ST_PHP_LOOKING_FOR_LOOP_EXPR
%state ST_DIRECTIVE_ARG
%state ST_CLOSE_PARANTHEIS
%state ST_STRING_DQUOTE
%state ST_STRING_SQUOTE

WHITESPACE=[ \t\r\n]+
NEWLINE=("\r"|"\n"|"\r\n")

OPEN_ECHO="{{"
CLOSE_ECHO="}}"

OPEN_ECHO_ESCAPED="{!!"
CLOSE_ECHO_ESCAPED="!!}"

COMMENT_START="{{--"
COMMENT_END="--}}"

LABEL=([[:letter:]_]|[\u007f-\u00ff])([[:letter:][:digit:]_]|[\u007f-\u00ff])*
ANY_CHAR=[^]
DIRECTIVE_PREFIX = "@"
OPEN_PHP="<?php"
CLOSE_PHP="?>"
CLOSE_BLADE_PHP = "@endphp";
%%

<ST_HTML>{NEWLINE} {
	String yytext = yytext();
	//whitespace
    return BladeTokenId.NEWLINE;
}

<ST_HTML>{WHITESPACE} {
	String yytext = yytext();
	//whitespace
    return BladeTokenId.WHITESPACE;
}

<ST_HTML>(([^\n<@{}]|"<"[^?%(script)<])+)|"<script"|"<" {
	int wstart = 0;
    int firstReverseNW = yytext().length() - 1;
	  String text = yytext();
	  int textLength = yylength();
	  boolean foundWhitespace = false;
      
  	if (text.trim().length() == textLength){
      	return BladeTokenId.T_HTML;
    }
    
    pushBackCount = 0;

    while (firstReverseNW >= 0) {
        Character c = yytext().charAt(firstReverseNW);
        if (!Character.isWhitespace(yytext().charAt(firstReverseNW))){
            firstReverseNW++;
            break;
        }
        foundWhitespace = true;
        firstReverseNW--;
    }
    if (foundWhitespace && firstReverseNW > 0) {
        int diff = yylength() - firstReverseNW;
        yypushback(diff);
        String ddText = text.substring(0, firstReverseNW);
        int dd = 1;
    }
    return BladeTokenId.T_HTML;
}

<ST_HTML>"<script"{WHITESPACE}+"language"{WHITESPACE}*"="{WHITESPACE}*( "php"|"\"php\""|"\'php\'"){WHITESPACE}*">" {
    return BladeTokenId.T_HTML;
}

<ST_HTML>"<?xml" [^<]* "?>" {
	return BladeTokenId.T_XML;
}


<ST_HTML> {OPEN_PHP} {
    pushState(ST_PHP);
    return BladeTokenId.T_OPEN_PHP;
}

<ST_HTML> "<?=" {
    pushState(ST_PHP_ECHO);
    return BladeTokenId.T_PHP_OPEN_ECHO;
}

<ST_PHP> {CLOSE_PHP} {
	if (yylength() == 2){
	    popState(); 
		return BladeTokenId.T_CLOSE_PHP;
	}
	yypushback(2);
    return BladeTokenId.T_PHP;
}

<ST_PHP>~{CLOSE_PHP} {
    if (yylength() == 2){
       popState();
       return BladeTokenId.T_CLOSE_PHP;
    }
    yypushback(2);
    return BladeTokenId.T_PHP;
}

<ST_PHP_ECHO> {CLOSE_PHP} {
	if (yylength() == 2){
	    popState(); 
		return BladeTokenId.T_CLOSE_PHP;
	}
	yypushback(2);
    return BladeTokenId.T_PHP_ECHO;
}

<ST_PHP_ECHO>~{CLOSE_PHP} {
    if (yylength() == 2){
       popState();
       return BladeTokenId.T_CLOSE_PHP;
    }
    yypushback(2);
    return BladeTokenId.T_PHP_ECHO;
}

<ST_PHP> <<EOF>> {
  if (input.readLength() > 0) {
    input.backup(1);  // backup eof
    return BladeTokenId.T_PHP;
  }
  else {
      return null;
  }
}

<ST_HTML> "@php" {
    pushState(ST_BLADE_PHP);
    return BladeTokenId.T_BLADE_PHP_OPEN;
}

<ST_BLADE_PHP> {CLOSE_BLADE_PHP} {
    String ttext = yytext();
    popState();
    return BladeTokenId.T_BLADE_ENDPHP;
}

<ST_BLADE_PHP>{WHITESPACE}?~"@endphp" {
	String ttext = yytext();
    popState();
    if (yylength() == "@endphp".length()){
        return BladeTokenId.T_BLADE_ENDPHP;
    }
    
    yypushback("@endphp".length());
    return BladeTokenId.T_BLADE_PHP;
}

<ST_HTML> {COMMENT_START} {
    pushState(ST_COMMENT);
    return BladeTokenId.T_BLADE_COMMENT;
}


<ST_COMMENT> {COMMENT_END} {
    popState();
    return BladeTokenId.T_BLADE_COMMENT;
}

<ST_COMMENT>~{COMMENT_END} {
    yypushback(4);
    return BladeTokenId.T_BLADE_COMMENT;
}

<ST_COMMENT> <<EOF>> {
  if (input.readLength() > 0) {
    input.backup(1);  // backup eof
    return BladeTokenId.T_BLADE_COMMENT;
  }
  else {
      return null;
  }
}

<ST_HTML> {CLOSE_BLADE_PHP} {
    return BladeTokenId.T_BLADE_ENDPHP;
}


<ST_HTML> "@yield" {
	pushState(ST_PHP_LOOKING_FOR_DIRECTIVE_ARG);
    return BladeTokenId.T_BLADE_YIELD;
}

<ST_HTML> "@section" {
    pushState(ST_PHP_LOOKING_FOR_DIRECTIVE_ARG);
    return BladeTokenId.T_BLADE_SECTION;
}

<ST_HTML> "@parent" {
    return BladeTokenId.T_BLADE_PARENT;
}

<ST_HTML> "@stop" {
    return BladeTokenId.T_BLADE_STOP;
}

<ST_HTML> "@include" {
	pushState(ST_PHP_LOOKING_FOR_DIRECTIVE_ARG);
    return BladeTokenId.T_BLADE_INCLUDE;
}

<ST_HTML> "@extends" {
	pushState(ST_PHP_LOOKING_FOR_DIRECTIVE_ARG);
    return BladeTokenId.T_BLADE_EXTENDS;
}


<ST_HTML> "@foreach" {
    pushState(ST_PHP_LOOKING_FOR_LOOP_EXPR);
    return BladeTokenId.T_BLADE_FOREACH;
}

<ST_HTML> "@for" {
    pushState(ST_PHP_LOOKING_FOR_LOOP_EXPR);
    return BladeTokenId.T_BLADE_FOR;
}

<ST_HTML> "@if" {
    pushState(ST_PHP_LOOKING_FOR_IF_EXPR);
    return BladeTokenId.T_BLADE_IF;
}

<ST_HTML> "@else" {
    return BladeTokenId.T_BLADE_ELSE;
}

<ST_HTML> "@elseif" {
    pushState(ST_PHP_LOOKING_FOR_IF_EXPR);
    return BladeTokenId.T_BLADE_ELSEIF;
}

<ST_HTML> "@endsection" {
    return BladeTokenId.T_BLADE_ENDSECTION;
}

<ST_PHP_LOOKING_FOR_DIRECTIVE_ARG>"(" {
	//directive paranthesis
	parenBalanceInDirective++;
	pushState(ST_BLADE_ARGUMENT);
    return BladeTokenId.BLADE_PHP_TOKEN;
}

<ST_PHP_LOOKING_FOR_DIRECTIVE_ARG>")" {
    //directive end
    parenBalanceInDirective--;
    String yytext = yytext();
    if (parenBalanceInDirective == 0){
        yybegin(ST_HTML);
    }
    return BladeTokenId.BLADE_PHP_TOKEN;
}

<ST_PHP_LOOKING_FOR_DIRECTIVE_ARG>\" | ">" {
	//inline div tag directive
	yybegin(ST_HTML);
	return BladeTokenId.T_HTML;
}

<ST_PHP_LOOKING_FOR_DIRECTIVE_ARG>{NEWLINE}+ {
	yybegin(ST_HTML);
    return BladeTokenId.WHITESPACE;
}

<ST_BLADE_ARGUMENT>")" {
    //directive end
    parenBalanceInDirective--;
    String yytext = yytext();
    if (yylength() == 1 && parenBalanceInDirective == 0){
        yybegin(ST_HTML);
        return BladeTokenId.BLADE_PHP_TOKEN;
    }
    if (parenBalanceInDirective <= 0){
    	parenBalanceInDirective++;
	    yypushback(1);
    	return BladeTokenId.T_BLADE_PHP_VAR;
    }

}

<ST_BLADE_ARGUMENT>\" ([^\"])* \" {
	//should have a flag for include
	//string debug
	String yytext = yytext();
	int debug = 1;
	//might catch other values also
	if (yytext.startsWith("\"")){
            return BladeTokenId.BLADE_PHP_STRING;
	}
}

<ST_BLADE_ARGUMENT>"'" ([^'])* "'" {
	//string debug
	String yytext = yytext();
	int debug = 1;
	//might catch other values also
	if (yytext.startsWith("'")){
		return BladeTokenId.BLADE_PHP_STRING;
	}
}

<ST_BLADE_ARGUMENT>"," {
	//debug comma value
	String yytext = yytext();
	int debug = 5;
	pushState(ST_LOOKING_FOR_SECOND_PARAMETER);
	if (yylength() == 1) {
		return BladeTokenId.T_BLADE_COMMA;
	}
}

<ST_BLADE_ARGUMENT>{ANY_CHAR} {
	
}

<ST_LOOKING_FOR_SECOND_PARAMETER>"(" {
	//second param state
	String yytext = yytext();
	parenBalanceInDirective++;
	if (yylength() == 1 && parenBalanceInDirective == 1){
		return BladeTokenId.BLADE_PHP_TOKEN;
	}
}

<ST_LOOKING_FOR_SECOND_PARAMETER>")" {
	//second param state
    String yytext = yytext();
    parenBalanceInDirective--;
    if (yylength() == 1){
    	parenBalanceInDirective=0;
        yybegin(ST_HTML);
        return BladeTokenId.BLADE_PHP_TOKEN;
    }
    if (parenBalanceInDirective <= 0){
		yypushback(1);
        return BladeTokenId.T_BLADE_PHP_VAR;
    }
}

<ST_LOOKING_FOR_SECOND_PARAMETER>{ANY_CHAR} {
	//second param state
}


<ST_PHP_LOOKING_FOR_IF_EXPR, ST_PHP_LOOKING_FOR_LOOP_EXPR>{WHITESPACE}+"(" {
	String yytext = yytext();
	switch (zzLexicalState) {
            case ST_PHP_LOOKING_FOR_IF_EXPR:
                    popState();
                    pushState(ST_PHP_IF_EXPR);
                    break;
            case ST_PHP_LOOKING_FOR_LOOP_EXPR:
                    popState();
                    pushState(ST_PHP_LOOP_EXPR);
                    break;
	}
	
	yypushback(1);
	return BladeTokenId.WHITESPACE;
}

<ST_PHP_LOOKING_FOR_IF_EXPR, ST_PHP_LOOKING_FOR_LOOP_EXPR>"(" {
	
	switch (zzLexicalState) {
            case ST_PHP_LOOKING_FOR_IF_EXPR:
                    popState();
                    pushState(ST_PHP_IF_EXPR);
                    break;
            case ST_PHP_LOOKING_FOR_LOOP_EXPR:
                    popState();
                    pushState(ST_PHP_LOOP_EXPR);
                    break;
	}
	parenBalanceInDirective++;
	return BladeTokenId.BLADE_PHP_TOKEN;
}

<ST_PHP_LOOKING_FOR_DIRECTIVE_ARG>{WHITESPACE}+ {
    String yytext = yytext();
    if (yytext.contains("\n")){
        //finish searching for arguments
        popState();
    }
    if (isWhitespace()){
    	return BladeTokenId.WHITESPACE;
    }
    
}

<ST_PHP_LOOKING_FOR_DIRECTIVE_ARG, ST_PHP_LOOKING_FOR_IF_EXPR, ST_PHP_LOOKING_FOR_LOOP_EXPR>{ANY_CHAR} {
	//any char directive arg
    String yytext = yytext();
    int debug = 1;
}

<ST_PHP_IF_EXPR, ST_PHP_LOOP_EXPR>{WHITESPACE}+ {
    if (parenBalanceInDirective != 0 && yytext().replaceAll("\\s+","").length() == 1){
    ///??
            return BladeTokenId.WHITESPACE;
    }
}

<ST_PHP_IF_EXPR, ST_PHP_LOOP_EXPR>"(" {
	String yytext = yytext();
	parenBalanceInDirective++;
	if (yylength() == 1 && parenBalanceInDirective == 1){
		return BladeTokenId.BLADE_PHP_TOKEN;
	}
}

<ST_PHP_IF_EXPR, ST_PHP_LOOP_EXPR>")" {
    String yytext = yytext();
    parenBalanceInDirective--;
    if (yylength() == 1){
    	parenBalanceInDirective=0;
        popState();
        return BladeTokenId.BLADE_PHP_TOKEN;
    }
    if (parenBalanceInDirective == 0){
    	yypushback(1);
    	switch (zzLexicalState) {
        case ST_PHP_IF_EXPR:
                return BladeTokenId.T_BLADE_PHP_COND;
        case ST_PHP_LOOP_EXPR:
                return BladeTokenId.T_BLADE_PHP_LOOP_PARAM;
        } 
    }
}

<ST_PHP_IF_EXPR, ST_PHP_LOOP_EXPR>{ANY_CHAR} {
    String yytext = yytext();
    int debug = 1;
}

<ST_HTML> "@endforeach" {
    return BladeTokenId.T_BLADE_ENDFOREACH;
}

<ST_HTML> "@endfor" {
    return BladeTokenId.T_BLADE_ENDFOR;
}

<ST_HTML> "@endif" {
    return BladeTokenId.T_BLADE_ENDIF;
}

<ST_HTML>{DIRECTIVE_PREFIX}{LABEL} {
   String yytext = yytext();
   pushState(ST_PHP_LOOKING_FOR_DIRECTIVE_ARG);
   return BladeTokenId.T_BLADE_DIRECTIVE; 
}

<ST_HTML>{DIRECTIVE_PREFIX}{WHITESPACE} {
   return BladeTokenId.T_BLADE_DIRECTIVE_PREFIX; 
}

/*
<ST_HTML>{DIRECTIVE_PREFIX}{LABEL} {WHITESPACE}* "(" {
   //this is to fix a possible fatal in php embedding after (:) char
   pushState(ST_DIRECTIVE_ARG);
   yypushback(1);
   return BladeTokenId.T_BLADE_DIRECTIVE; 
}*/

<ST_DIRECTIVE_ARG>"(" {
    String yytext = yytext();
    parenBalanceInDirective++;
    if (parenBalanceInDirective == 1){
        //first paranthesis
    	return BladeTokenId.BLADE_PHP_TOKEN;
    }
}

<ST_DIRECTIVE_ARG>")" {
	String yytext = yytext();
    if (yylength() == 1){
       parenBalanceInDirective = 0;
       popState();
       return BladeTokenId.BLADE_PHP_TOKEN;
    }
    parenBalanceInDirective--;
    if (parenBalanceInDirective <= 0){
        if (yylength() == 1){
           popState();
           return BladeTokenId.BLADE_PHP_TOKEN;
        }
        yypushback(1);
        popState();
        pushState(ST_CLOSE_PARANTHEIS);
        argHasVariable = false;
		return BladeTokenId.T_DIRECTIVE_ARG;
    }
}

<ST_DIRECTIVE_ARG>\" {
    //can try to remove this state
    //should add a condition to not include it as a argument
    String yytext = yytext();
    int test = 1;
    if (yylength() == 1){
        pushState(ST_STRING_DQUOTE);
    }
}

<ST_DIRECTIVE_ARG>\' {
    String yytext = yytext();
    int test = 1;
    if (yylength() == 1){
        pushState(ST_STRING_SQUOTE);
    }
}

<ST_DIRECTIVE_ARG>"$"{LABEL} {
    argHasVariable = true;
}

<ST_DIRECTIVE_ARG>{ANY_CHAR} {
	String yytext = yytext();
	int test = 1;
}

<ST_CLOSE_PARANTHEIS>")" {
        String yytext = yytext();
       popState();
       return BladeTokenId.BLADE_PHP_TOKEN;
}

<ST_HTML> {OPEN_ECHO} {
    String yytext = yytext();
    pushState(ST_BLADE_ECHO);
    return BladeTokenId.T_BLADE_OPEN_ECHO;
}

<ST_HTML> {OPEN_ECHO_ESCAPED} {
    String yytext = yytext();
    pushState(ST_BLADE_ECHO_ESCAPED);
    return BladeTokenId.T_BLADE_OPEN_ECHO_ESCAPED;
}


<ST_BLADE_ECHO> {CLOSE_ECHO} {
    String yytext = yytext();
    popState();
    return BladeTokenId.T_BLADE_CLOSE_ECHO;
}

<ST_BLADE_ECHO>~{CLOSE_ECHO} {
    String yytext = yytext();
    if (yylength() == 2){
    	popState();
    	return BladeTokenId.T_BLADE_CLOSE_ECHO;
    }
    yypushback(2);
    return BladeTokenId.T_BLADE_PHP_ECHO;
}

<ST_BLADE_ECHO_ESCAPED> {CLOSE_ECHO_ESCAPED} {
    String yytext = yytext();
    popState();
    return BladeTokenId.T_BLADE_CLOSE_ECHO_ESCAPED;
}

<ST_BLADE_ECHO_ESCAPED>~{CLOSE_ECHO_ESCAPED} {
    String yytext = yytext();
    if (yylength() == 3){
    	popState();
    	return BladeTokenId.T_BLADE_CLOSE_ECHO;
    }
    yypushback(3);
    return BladeTokenId.T_BLADE_PHP_ECHO;
}


<ST_BLADE_ECHO, ST_BLADE_ECHO_ESCAPED> {NEWLINE} {
    String yytext = yytext();
    popState();
    return BladeTokenId.T_HTML;
}

<ST_HTML> {CLOSE_ECHO} | {CLOSE_ECHO_ESCAPED} {
    String yytext = yytext();
    return BladeTokenId.T_BLADE_CLOSE_ECHO;
}

<ST_BLADE_ECHO, ST_BLADE_ECHO_ESCAPED> {WHITESPACE}+ {
    //no break;
}

<ST_HTML>{ANY_CHAR} {}

/* ============================================
   Stay in this state until we find a whitespace.
   After we find a whitespace we go the the prev state and try again from the next token.
   ============================================ */
<ST_HIGHLIGHTING_ERROR> {
    {WHITESPACE} {
        popState();
        return BladeTokenId.WHITESPACE;
    }
    . {
        return BladeTokenId.T_HTML;
    }
}

<ST_STRING_DQUOTE> {
  \"                             { popState();
                                   return BladeTokenId.BLADE_PHP_STRING; }
  [^\"\\]+                       {  }
  \\\"                           {  }
  \\                             {  }
}

<ST_STRING_SQUOTE> {
  \'                             { popState();
                                   return BladeTokenId.BLADE_PHP_STRING; }
  [^\'\\]+                       {  }
  \\\'                           {  }
  \\                             {  }
}

<ST_STRING_SQUOTE, ST_STRING_DQUOTE>{ANY_CHAR} {
    
} 

/* ============================================
   This rule must be the last in the section!!
   it should contain all the states.
   ============================================ */
<ST_HTML, ST_BLADE_ECHO, ST_PHP, ST_BLADE_ECHO_ESCAPED, ST_BLADE_PHP> {
    . {
        //if (yylength() > 1) {
        //    yypushback(1);
        //}
        //pushState(ST_HIGHLIGHTING_ERROR);
    }
}