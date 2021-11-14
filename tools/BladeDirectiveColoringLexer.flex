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

import java.util.Objects;
import org.netbeans.spi.lexer.LexerInput;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.netbeans.modules.web.common.api.ByteStack;

@org.netbeans.api.annotations.common.SuppressWarnings({"SF_SWITCH_FALLTHROUGH", "URF_UNREAD_FIELD", "DLS_DEAD_LOCAL_STORE", "DM_DEFAULT_ENCODING", "EI_EXPOSE_REP"})
%%
%public
%class BladeDirectiveColoringLexer
%type BladeTokenId
%function findNextToken
%unicode
%caseless
%char

%state ST_ECHO
%state ST_COMMENT
%state ST_DIRECTIVE
%state ST_DIRECTIVE_ARGUMENTS
%state ST_DIRECTIVE_PHP
%state ST_CLOSE_BLADE_PHP
%state ST_HIGHLIGHTING_ERROR

%eofval{
        String yytext = yytext();
        if(input.readLength() > 0) {
            // backup eof
            input.backup(1);
            //and return the text as error token
            if (getZZLexicalState() == ST_DIRECTIVE){
                return BladeTokenId.T_BLADE_DIRECTIVE;
            }
            return BladeTokenId.T_HTML;
        } else {
            return null;
        }
%eofval}


%{
    private ByteStack stack = new ByteStack();
    private LexerInput input;
    private int parenBalanceInDirective = 0; //for directive arguments

    public BladeDirectiveColoringLexer(LexerRestartInfo info) {
        this.input = info.input();
        if(info.state() != null) {
            //reset state
            setState((LexerState) info.state(), parenBalanceInDirective);
        } else {
            //initial state
            stack.push(YYINITIAL);
            zzState = YYINITIAL;
            zzLexicalState = YYINITIAL;
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

//getParameters??

    protected int getZZLexicalState() {
        return zzLexicalState;
    }

    //other functios

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

%}


WHITESPACE=[ \t\r\n]+
OPEN_ECHO="{{"
CLOSE_ECHO="}}"
OPEN_ECHO_ESCAPED="{!!"
CLOSE_ECHO_ESCAPED="!!}"
COMMENT_START="{{--"
COMMENT_END="--}}"
ANY_CHAR=[^]
DIRECTIVE_PREFIX = "@"
%%

<YYINITIAL, ST_ECHO, ST_DIRECTIVE, ST_COMMENT, ST_DIRECTIVE_ARGUMENTS, ST_DIRECTIVE_PHP>{WHITESPACE}+ {
}

<YYINITIAL> {
    {OPEN_ECHO} {
        //open echo
        pushState(ST_ECHO);
        if (yylength() > 2){
            yypushback(2);
        }
        return BladeTokenId.T_BLADE_ECHO;
    }
    {OPEN_ECHO_ESCAPED}
    {
        //open echo escaoed
        pushState(ST_ECHO);
        if (yylength() > 3){
            yypushback(3);
        }
        return BladeTokenId.T_BLADE_ECHO;
    }
    {DIRECTIVE_PREFIX} {
    	pushState(ST_DIRECTIVE);
    }
    "(" {
         String yytext = yytext();
         pushState(ST_DIRECTIVE_ARGUMENTS);
    }
    {ANY_CHAR} {
        //initial
        String yytext = yytext();
    }
}

//echo

<ST_ECHO> {
    {COMMENT_START} {
        pushState(ST_COMMENT);
    }
    {CLOSE_ECHO} {
        //close echo
        if (yylength() > 2){
            yypushback(2);
            return BladeTokenId.T_BLADE_PHP_VAR;
        }
        popState();
        return BladeTokenId.T_BLADE_ECHO;
    }
    {CLOSE_ECHO_ESCAPED} {
        //close echo escaped
        if (yylength() > 3){
            yypushback(3);
            return BladeTokenId.T_BLADE_PHP_VAR;
        }
        popState();
        return BladeTokenId.T_BLADE_ECHO;
    }
}

//comment

<ST_COMMENT> {
    {COMMENT_END} {
        //do twice
        popState();
        popState();
        return BladeTokenId.T_BLADE_COMMENT;
    }
}

//directive

<ST_DIRECTIVE> {
    "@php" {
        //php
        pushState(ST_DIRECTIVE_PHP);
        return BladeTokenId.T_BLADE_DIRECTIVE;
    }
     ")" {
        stack.clear();
        pushState(YYINITIAL);
        return BladeTokenId.T_BLADE_DIRECTIVE;
    }
    {ANY_CHAR} {
        String yytext = yytext();
        if (yytext.startsWith("@php")){
            //php any char
            pushState(ST_DIRECTIVE_PHP);
            return BladeTokenId.T_BLADE_DIRECTIVE;
        }
        if (yytext.endsWith("(")){
            pushState(ST_DIRECTIVE_ARGUMENTS);
            return BladeTokenId.T_BLADE_DIRECTIVE;
        } else if (yytext.endsWith(")")) {
            stack.clear();
            pushState(YYINITIAL);
            return BladeTokenId.T_BLADE_DIRECTIVE;
        }
    }
   
}

<ST_DIRECTIVE_PHP> {
    {ANY_CHAR} {
        String yytext = yytext();
        if (yytext.endsWith("@endphp")){
            if (yylength() >8){
            yypushback(8);
        }
        pushState(ST_CLOSE_BLADE_PHP);
        }
    }
}

<ST_CLOSE_BLADE_PHP> {
	{ANY_CHAR} {
		stack.clear();
		pushState(YYINITIAL);
		return BladeTokenId.T_BLADE_PHP_VAR;
	}
}

//directive arguments

<ST_DIRECTIVE_ARGUMENTS> {ANY_CHAR} {
    String yytext = yytext();
    if (yytext.endsWith("(")){
        parenBalanceInDirective++;
    }
    if (yytext.endsWith(")")){
        parenBalanceInDirective--;
        if (parenBalanceInDirective == 0){
            popState();
            if (yylength() >1){
                yypushback(1);
            }
            return BladeTokenId.T_BLADE_PHP_VAR;
        }
    }
}

/* ============================================
   Stay in this state until we find a whitespace.
   After we find a whitespace we go the the prev state and try again from the next token.
   ============================================ */
<ST_HIGHLIGHTING_ERROR> {
    {WHITESPACE} {
        popState();
        return BladeTokenId.T_BLADE_ECHO;
    }
    . {
        return BladeTokenId.T_BLADE_ECHO;
    }
}

/* ============================================
   This rule must be the last in the section!!
   it should contain all the states.
   ============================================ */
<YYINITIAL, YYINITIAL, ST_ECHO, ST_DIRECTIVE, ST_DIRECTIVE_ARGUMENTS, ST_COMMENT> {
    . {
        //if (yylength() > 1) {
        //    yypushback(1);
        //}
        //pushState(ST_HIGHLIGHTING_ERROR);
    }
}