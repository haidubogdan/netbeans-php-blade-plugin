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
%class BladeTopColoringLexer
%type BladeTopTokenId
%function findNextToken
%unicode
%caseless
%char

%state ST_HTML
%state ST_INLINE_PHP
%state ST_BLADE_PHP
%state ST_BLADE_ECHO
%state ST_BLADE_ECHO_ESCAPED
%state ST_DIRECTIVE
%state ST_DIRECTIVE_ARGUMENTS
%state ST_COMMENT
%state ST_HIGHLIGHTING_ERROR
%state ST_CLOSE_BLADE_PHP



%{
    private ByteStack stack = new ByteStack();
    private LexerInput input;
    private int parenBalanceInDirective = 0; //for directive arguments

    public BladeTopColoringLexer(LexerRestartInfo info) {
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

%}


%eofval{
        if(input.readLength() > 0) {
    		String yytext = yytext();
            // backup eof
            input.backup(1);
            //and return the text as error token
            if (getState().equals(ST_DIRECTIVE){
            		return BladeTopTokenId.T_DIRECTIVE;
            }
            return BladeTopTokenId.T_HTML;
        } else {
            return null;
        }
%eofval}

WHITESPACE=[ \t\r\n]+
OPEN_ECHO="{{"
CLOSE_ECHO="}}"
OPEN_ECHO_ESCAPED="{!!"
CLOSE_ECHO_ESCAPED="!!}"
COMMENT_START="{{--"
COMMENT_END="--}}"
ANY_CHAR=[^]
DIRECTIVE_PREFIX = "@"
letter = [A-Za-z]
digit = [0-9]

DIRECTIVE_FUNCTION={DIRECTIVE_PREFIX} {letter} ({letter}|{digit}|"_")* [ ]* "("
DIRECTIVE={DIRECTIVE_PREFIX} {letter} ({letter}|{digit}|"_")*
OPEN_PHP="<?php"
CLOSE_PHP="?>"
%%

<YYINITIAL, ST_BLADE_ECHO, ST_BLADE_ECHO_ESCAPED, ST_DIRECTIVE, ST_COMMENT>{WHITESPACE}+ {
}

<YYINITIAL, ST_HTML> {
    {OPEN_ECHO} {
        //open echo
        String yytext = yytext();
        pushState(ST_BLADE_ECHO);
        if (yylength() > 2){
            yypushback(2);
            return BladeTopTokenId.T_HTML;
        }
    }
    {OPEN_ECHO_ESCAPED}
    {
        //open echo escaoed
        pushState(ST_BLADE_ECHO_ESCAPED);
        if (yylength() > 3){
            yypushback(3);
            return BladeTopTokenId.T_HTML;
        }
    }
    {DIRECTIVE_PREFIX} {
    	pushState(ST_DIRECTIVE);
    	if (yylength() > 1){
    		yypushback(1);
    		return BladeTopTokenId.T_HTML;
    	}
    }
    {OPEN_PHP} {
        //inline php
        pushState(ST_INLINE_PHP);
        if (yylength() > 5){
            yypushback(5);
            return BladeTopTokenId.T_HTML;
        }
    }
}

//echo

<ST_BLADE_ECHO> {
    {COMMENT_START} {
        pushState(ST_COMMENT);
        if (yylength() > 4){
            yypushback(4);
            return BladeTopTokenId.T_HTML;
        }
    }
    {CLOSE_ECHO} {
        //close echo
        stack.clear();
        pushState(YYINITIAL);
        String yytext = yytext();
        if (yytext.startsWith("{{--")){
        	return BladeTopTokenId.T_BLADE_COMMENT;
        }
        return BladeTopTokenId.T_BLADE;
    }
}

<ST_BLADE_ECHO_ESCAPED> {
    {CLOSE_ECHO_ESCAPED} {
        //close echo escaped
        popState();
        return BladeTopTokenId.T_BLADE;
    }
}

//comment

<ST_COMMENT> {
    {COMMENT_END} {
        //do twice
        stack.clear();
        pushState(YYINITIAL);
        return BladeTopTokenId.T_BLADE_COMMENT;
    }
}

//directive

<ST_DIRECTIVE> {
    {DIRECTIVE_FUNCTION} {
        //directive function
        String yytext = yytext();
        parenBalanceInDirective++;
        pushState(ST_DIRECTIVE_ARGUMENTS);
        break;
    }

    {DIRECTIVE} {
        //simple directive
        String yytext = yytext();
        if (yytext.equals("@php")){
            pushState(ST_BLADE_PHP);
            break;
        }
        stack.clear();
        pushState(YYINITIAL);
        return BladeTopTokenId.T_DIRECTIVE;
    }
    {ANY_CHAR} {
        //any char directive
		String yytext = yytext();
		if (yytext.endsWith("(")){
			parenBalanceInDirective++;
	        pushState(ST_DIRECTIVE_ARGUMENTS);
	        break;
		}

		if (yytext.endsWith("\"")){
			stack.clear();
			pushState(YYINITIAL);
			if (yylength() > 1){
	            yypushback(1);
	        }
	        return BladeTopTokenId.T_DIRECTIVE;
		}
    }
}

<ST_BLADE_PHP> {
	{ANY_CHAR} {
		String yytext = yytext();
		if (yytext.endsWith("@endphp")){
	        stack.clear();
			pushState(YYINITIAL);
	        return BladeTopTokenId.T_DIRECTIVE;
        }
	}
}

//directive arguments

<ST_DIRECTIVE_ARGUMENTS> {
	{ANY_CHAR} {
		String yytext = yytext();
		if (yytext.endsWith("(")){
			parenBalanceInDirective++;
		}
		if (yytext.endsWith(")")){
			parenBalanceInDirective--;
			if (parenBalanceInDirective == 0){
				stack.clear();
				pushState(YYINITIAL);
				return BladeTopTokenId.T_DIRECTIVE;
			}
		}
	}
}


<ST_INLINE_PHP> {
	{CLOSE_PHP} {
        //close inline php
		popState();
		return BladeTopTokenId.T_PHP;
	}
	{ANY_CHAR} {
        //close inline php anychar
		String yytext = yytext();
		if (yytext.endsWith("?>")){
			//using any char
			popState();
			return BladeTopTokenId.T_PHP;
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
        return BladeTopTokenId.T_HTML;
    }
    . {
        return BladeTopTokenId.T_HTML;
    }
}

/* ============================================
   This rule must be the last in the section!!
   it should contain all the states.
   ============================================ */
<YYINITIAL, ST_BLADE_ECHO, ST_BLADE_ECHO_ESCAPED, ST_DIRECTIVE, ST_COMMENT, ST_HTML> {
    . {
        //if (yylength() > 1) {
        //    yypushback(1);
        //}
        //pushState(ST_HIGHLIGHTING_ERROR);
    }
}