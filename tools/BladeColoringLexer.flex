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

import org.netbeans.api.lexer.TokenId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.netbeans.modules.php.blade.editor.common.ByteStack;

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
    private int parameterExpressionLength = 0;
    private int pushBackCount = 0;
    //[\"][^\:\"]+[\:]{1}[^\:]
    private Pattern freezePhpPattern = Pattern.compile("[^\\:\\\"\\)]+[\\:]{1}[^\\:]", Pattern.CASE_INSENSITIVE);

    public BladeColoringLexer(LexerRestartInfo<? extends TokenId> info) {
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
%state ST_VALIDATE_BLADE_ECHO
%state ST_BLADE_ECHO_ESCAPED
%state ST_DIRECTIVE
%state ST_COMMENT
%state ST_CLOSE_BLADE_PHP
%state ST_LOOKING_FOR_PARAMETER_EXPRESSION
%state ST_BLADE_PARAMETER_EXPRESSION
%state ST_BLADE_ARGUMENT
%state ST_AFTER_DIRECTIVE_ARG

WHITESPACE=[ \t\r]+
NEWLINE=("\r"|"\n"|"\r\n")

OPEN_BLADE_ECHO="{{"
CLOSE_BLADE_ECHO="}}"

OPEN_ECHO_ESCAPED="{!!"
CLOSE_ECHO_ESCAPED="!!}"

COMMENT_START="{{--"
COMMENT_END="--}}"

LABEL=([[:letter:]_]|[\u007f-\u00ff])([[:letter:][:digit:]_]|[\u007f-\u00ff])*
ANY_CHAR=[^]
EMAIL= "@" {LABEL}? "." 
DIRECTIVE_PREFIX = "@"
DIRECTIVE_NAME = {DIRECTIVE_PREFIX}{LABEL}
OPEN_PHP="<?php"
CLOSE_PHP="?>"

OPEN_PHP_ECHO = "<?="
%%

//inline php states

<ST_HTML>{OPEN_PHP} {
    pushState(ST_PHP);
    return BladeTokenId.T_OPEN_PHP_SCRIPT;
}

<ST_HTML>{OPEN_PHP_ECHO} {
    pushState(ST_PHP_ECHO);
    return BladeTokenId.T_PHP_OPEN_ECHO;
}

//php directive state

<ST_HTML>"@php" {
    pushState(ST_BLADE_PHP);
    return BladeTokenId.T_BLADE_PHP_OPEN;
}

<ST_HTML>"@endphp" {
    return BladeTokenId.T_BLADE_ENDPHP;
}

//php state

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

<ST_BLADE_PHP>{WHITESPACE}?~"@endphp" {
    String ttext = yytext();
    popState();
    if (yylength() == "@endphp".length()){
        return BladeTokenId.T_BLADE_ENDPHP;
    }
    
    yypushback("@endphp".length());
    return BladeTokenId.T_BLADE_PHP;
}

<ST_HTML>{
    "@yield" { 
        pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
        return BladeTokenId.T_BLADE_YIELD;
    }
    "@section" {
       pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
       return BladeTokenId.T_BLADE_SECTION;
    }
    "@hasSection" {
       pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
       return BladeTokenId.T_BLADE_HAS_SECTION;
    }
    "@sectionMissing" {
       pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
       return BladeTokenId.T_BLADE_SECTION_MISSING;
    }
}

<ST_HTML>{
    "@parent" { return BladeTokenId.T_BLADE_PARENT;}
    "@stop" { return BladeTokenId.T_BLADE_STOP;}
    "@show" { return BladeTokenId.T_BLADE_SHOW;}
    "@endsection" { 
        return BladeTokenId.T_BLADE_ENDSECTION;
    }
}

//includes

<ST_HTML>{
    "@include" { 
        pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
        return BladeTokenId.T_BLADE_INCLUDE;
    }
    "@extends" { 
        pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
        return BladeTokenId.T_BLADE_EXTENDS;
    }
    "@each" { 
        pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
        return BladeTokenId.T_BLADE_EACH;
    }
    "@extends" { 
        pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
        return BladeTokenId.T_BLADE_EACH;
    }
}

//loops

<ST_HTML>{
    "@foreach" { 
        pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
        return BladeTokenId.T_BLADE_FOREACH;
    }
    "@for" { 
        pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
        return BladeTokenId.T_BLADE_FOR;
    }
}

<ST_HTML>{
    "@endforeach" {
        return BladeTokenId.T_BLADE_ENDFOREACH;
    }
    "@endfor" {
        return BladeTokenId.T_BLADE_ENDFOR;
    }
}


//conditional

<ST_HTML>{
    "@if" { 
        pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
        return BladeTokenId.T_BLADE_IF;
    }
    "@elseif" { 
        pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
        return BladeTokenId.T_BLADE_ELSEIF;
    }
}

<ST_HTML>{
    "@else" {
        return BladeTokenId.T_BLADE_ELSE;
    }
    "@endif" {
        return BladeTokenId.T_BLADE_ENDIF;
    }
}

<ST_LOOKING_FOR_PARAMETER_EXPRESSION>{WHITESPACE}+ {
    return BladeTokenId.WHITESPACE;
}

<ST_LOOKING_FOR_PARAMETER_EXPRESSION>"()" {
   parenBalanceInDirective = 0;
   popState();
   return BladeTokenId.T_EMPTY_EXPRESSION;
}

<ST_LOOKING_FOR_PARAMETER_EXPRESSION>"(" {
   pushState(ST_BLADE_PARAMETER_EXPRESSION);
   parenBalanceInDirective = 1;
   parameterExpressionLength = 0;
   return BladeTokenId.T_BLADE_LPAREN;
}

<ST_LOOKING_FOR_PARAMETER_EXPRESSION>")" {
   parenBalanceInDirective = 0;
   popState();
   return BladeTokenId.T_BLADE_RPAREN;
}

<ST_LOOKING_FOR_PARAMETER_EXPRESSION>{ANY_CHAR} {
    if (yylength() > 0){
        yypushback(1);
    }
    popState();
}

<ST_BLADE_PARAMETER_EXPRESSION>"(" {
   parenBalanceInDirective++;
}

<ST_BLADE_PARAMETER_EXPRESSION>"{"? + ([^\:\"\)]+ ":") [^\:]  {
    //php lexer embedding freeze issue when you type / delete a double colon at the start of the script
    if (parameterExpressionLength == 0) {
        popState();
        popState();
        parameterExpressionLength = 0;
        return  BladeTokenId.T_HTML;
    }
}

<ST_BLADE_PARAMETER_EXPRESSION>")" {
   parenBalanceInDirective--;
   if (parenBalanceInDirective == 0) {
      yypushback(1);
      popState();
      return BladeTokenId.T_BLADE_PHP_EXPRESSION;
   }
}

<ST_BLADE_PARAMETER_EXPRESSION>{WHITESPACE} {
    String text = yytext();
    parameterExpressionLength+= yylength();
}
<ST_BLADE_PARAMETER_EXPRESSION>{ANY_CHAR} {
    parameterExpressionLength =0;
}

<ST_HTML>"@@" {
    //escape directive rule
    return BladeTokenId.T_HTML;
}

<ST_HTML>{EMAIL} {
    //email format
    return BladeTokenId.T_HTML;
}

<ST_HTML>{DIRECTIVE_NAME} {
    String ttext = yytext();
    pushState(ST_LOOKING_FOR_PARAMETER_EXPRESSION);
    return BladeTokenId.T_BLADE_DIRECTIVE;
}


<ST_HTML> {COMMENT_START} {
    pushState(ST_COMMENT);
    return BladeTokenId.T_BLADE_OPEN_COMMENT;
}

<ST_HTML> "{{-" {
    //incomplete comment
    return BladeTokenId.T_HTML;
}

<ST_COMMENT> {COMMENT_END} {
    popState();
    return BladeTokenId.T_BLADE_CLOSE_COMMENT;
}

<ST_COMMENT>~{COMMENT_END} {
    yypushback(4);
    return BladeTokenId.T_BLADE_COMMENT;
}

<ST_COMMENT><<EOF>> {
  popState();
  if (yylength() > 0){
    return BladeTokenId.T_HTML;
  }
}

<ST_HTML> {OPEN_BLADE_ECHO} {
    String yytext = yytext();
    pushState(ST_BLADE_ECHO);
    return BladeTokenId.T_BLADE_OPEN_ECHO;
}

<ST_HTML> {OPEN_ECHO_ESCAPED} {
    String yytext = yytext();
    pushState(ST_BLADE_ECHO_ESCAPED);
    return BladeTokenId.T_BLADE_OPEN_ECHO_ESCAPED;
}

<ST_BLADE_ECHO> {CLOSE_BLADE_ECHO} {
    String yytext = yytext();
    popState();
    return BladeTokenId.T_BLADE_CLOSE_ECHO;
}

<ST_BLADE_ECHO>~{CLOSE_BLADE_ECHO} {
    String yytext = yytext();
    if (yylength() == 2){
    	popState();
    	return BladeTokenId.T_BLADE_CLOSE_ECHO;
    }
    yypushback(2);

    Matcher matcher = freezePhpPattern.matcher(yytext);
    if(matcher.find()) {
        return BladeTokenId.T_HTML;
    }
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
    Matcher matcher = freezePhpPattern.matcher(yytext);
    if(matcher.find()) {
        return BladeTokenId.T_HTML;
    }
    return BladeTokenId.T_BLADE_PHP_ECHO;
}


<ST_BLADE_ECHO, ST_BLADE_ECHO_ESCAPED> {NEWLINE} {
    String yytext = yytext();
    popState();
    return BladeTokenId.T_HTML;
}

<ST_BLADE_ECHO, ST_BLADE_ECHO_ESCAPED>{WHITESPACE}+ {
    //no break;
    parameterExpressionLength += yylength();
}

<ST_HTML>{NEWLINE}+ {
    String yytext = yytext();
	//whitespace
    return BladeTokenId.NEWLINE;
}

<ST_HTML>{WHITESPACE}+ {
	String yytext = yytext();
	//whitespace
    return BladeTokenId.WHITESPACE;
}

<ST_HTML>"/>" {
   return  BladeTokenId.T_HTML; 
}

<ST_HTML>(([^<@({{|}}|/*|\n)+]|"<"[^?%<({{|}})])+)|"<" {
   return  BladeTokenId.T_HTML; 
}

<ST_HTML>"<?xml" [^<]* "?>" {
	return BladeTokenId.T_XML;
}

<ST_HTML>{ANY_CHAR} {
   return  BladeTokenId.T_HTML;
}

<ST_PHP, ST_BLADE_ECHO, ST_BLADE_ECHO_ESCAPED, ST_BLADE_PHP> {
    . {
        //skipp
    }
}
