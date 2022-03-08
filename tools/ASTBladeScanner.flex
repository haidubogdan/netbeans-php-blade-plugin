
package org.netbeans.modules.php.blade.editor.parsing;

import java_cup.runtime.*;
import org.netbeans.modules.php.blade.editor.BladeSyntax;
import org.netbeans.modules.php.editor.parser.PHPParseResult;
import org.netbeans.modules.php.blade.editor.common.ByteStack;
import org.openide.filesystems.FileObject;

@org.netbeans.api.annotations.common.SuppressWarnings({"SF_SWITCH_FALLTHROUGH", "URF_UNREAD_FIELD", "DLS_DEAD_LOCAL_STORE", "DM_DEFAULT_ENCODING", "EI_EXPOSE_REP2", "UUF_UNUSED_FIELD"})

%%

%public
%class ASTBladeScanner
%cup
%implements Scanner
%char
%line
%column
%type Symbol
%function next_token

%unicode
%caseless

%{
    private ByteStack stack = new ByteStack();
    private char yy_old_buffer[] = new char[ZZ_BUFFERSIZE];
    private int yy_old_pushbackPos;
    private int whitespaceEndPosition;
    private int directiveParBalance = 0;
    private String phpConditionText = "";
    private String phpParameterExpressionText = "";
    private FileObject currentFile;
    private String fakePhpEmbeddingText = "";
    private int lastEmbeddedPos = -1;

    public void reset(java.io.Reader reader) {
        yyreset(reader);
    }

    public void setState(int state) {
        yybegin(state);
    }

    public int getState() {
        return yystate();
    }

    private void pushState(int state) {
        stack.push(zzLexicalState);
        yybegin(state);
    }

    private void popState() {
        yybegin(stack.pop());
    }

    public int getCurrentLine() {
        return yyline;
    }

    protected int getTokenStartPosition() {
        return zzStartRead - zzPushbackPos;
    }

    protected int getTokenLength() {
        return zzMarkedPos - zzStartRead;
    }

    public int getLength() {
        return zzEndRead - zzPushbackPos;
    }

    private Symbol createFullSymbol(int symbolNumber) {
        Symbol symbol = createSymbol(symbolNumber);
        symbol.value = yytext();
        return symbol;
    }

    private Symbol createConditionSymbol(int symbolNumber) {
        Symbol symbol = createSymbol(symbolNumber);
        symbol.value = phpConditionText;
        phpConditionText = "";
        return symbol;
    }


    private Symbol createPhpParameterExpression(int symbolNumber) {
        Symbol symbol = createSymbol(symbolNumber);
        symbol.value = phpParameterExpressionText;
        phpParameterExpressionText = "";
        return symbol;
    }


    private Symbol createSymbol(int symbolNumber) {
        int leftPosition = getTokenStartPosition();
        Symbol symbol = new Symbol(symbolNumber, leftPosition, leftPosition + getTokenLength());
        return symbol;
    }

    public int getWhitespaceEndPosition() {
        return whitespaceEndPosition;
    }

    private void error(String message) {
        System.out.println("Error at line " + (yyline + 1) + ", column " + (yycolumn + 1) + " : " + message);
    }

    protected void addBladePhpInline() {
        //TODO may think of an include with php
        //we will have to think of the offset
        int start = getTokenStartPosition();
        if (start > 1) {
            int offsetEmbed;
            if (lastEmbeddedPos < 0) {
                offsetEmbed = start - 2;
            } else {
                offsetEmbed = start - 2 - lastEmbeddedPos;
            }
            String emptyText = "";
            if (offsetEmbed > 0) {
                emptyText = new String(new char[offsetEmbed]).replace("\0", " ");
            }
            fakePhpEmbeddingText += emptyText + yytext().replace("@php", "<?php ").replace("@endphp", "    ?>");
        } else {
            String phpText = yytext().replace("@php", "<?  ").replace("@endphp", "////\n?>");
            if (phpText.length() == yytext().length()) {
                fakePhpEmbeddingText += phpText;
            }
        }

        lastEmbeddedPos = start + getTokenLength();
    }

    protected void addPhpStatement() {
        int start = getTokenStartPosition();
        int offsetEmbed;
        if (lastEmbeddedPos < 0) {
            offsetEmbed = start;
        } else {
            offsetEmbed = start - lastEmbeddedPos;
        }
        String emptyText = "";
        if (offsetEmbed > 0) {
            emptyText = new String(new char[offsetEmbed]).replace("\0", " ");
        }
        fakePhpEmbeddingText += emptyText + yytext();
        lastEmbeddedPos = start + getTokenLength();
    }
    
    protected void addEchoStatement(){
        int start = getTokenStartPosition();
        int offsetEmbed;
        //we assume that previous we had {{ or {!!
        if (lastEmbeddedPos < 0) {
            offsetEmbed = start - 3;
        } else {
            offsetEmbed = start - 3 - lastEmbeddedPos;
        }
        String emptyText;
        if (offsetEmbed > 0) {
            emptyText = new String(new char[offsetEmbed]).replace("\0", " ");
            fakePhpEmbeddingText += emptyText + "<?=" + yytext() + "?>";
            lastEmbeddedPos = start + getTokenLength() + 2;
        }
        
    }

    public String getFakePhpEmbeddingText() {
        return fakePhpEmbeddingText;
    }

    public void setCurentFile(FileObject file) {
        currentFile = file;
    }

    public PHPParseResult getPhpParserResult() {
        ParsingUtils parsingUtils = new ParsingUtils();
        if (fakePhpEmbeddingText.length() > 0) {
            parsingUtils.parsePhpText(fakePhpEmbeddingText);
        } else {
            parsingUtils.parsePhpText("<?php\n");
        }

        return parsingUtils.getParserResult();
    }

%} 

%eofval{
    return createSymbol(ASTBladeSymbols.EOF);
%eofval}


LNUM=[0-9]+(_[0-9]+)*
DNUM=({LNUM}?[\.]{LNUM})|({LNUM}[\.]{LNUM}?)

NEWLINE = \r|\n|\r\n;
ANY_CHAR=[^]
WHITESPACE = {NEWLINE} | [ \t\f]
LABEL=([[:letter:]_]|[\u007f-\u00ff])([[:letter:][:digit:]_]|[\u007f-\u00ff])*
PATH =[A-Za-z_$0-9\-\.\/]+

OPEN_ECHO="{{"
CLOSE_ECHO="}}"

OPEN_ECHO_ESCAPED="{!!"
CLOSE_ECHO_ESCAPED="!!}"

COMMENT_START="{{--"
COMMENT_END="--}}"

%state ST_LOOKING_FOR_PATH
%state ST_LOOKING_FOR_LABEL
%state ST_LOOKING_FOR_INCLUDED_VARS
%state ST_BLADE_DIRECTIVE
%state ST_STRING_DBQUOTE
%state ST_STRING_SQUOTE
%state ST_DOCBLOCK
%state ST_PHP_LOOP_EXPRESSION
%state ST_PHP_CONDITION_EXPRESSION
%state ST_BLADE_INCLUDE_ARGS
%state ST_BLADE_PARAMETER
%state ST_INLINE_PHP
%state ST_PHP
%state ST_COMMENT
%state ST_BLADE_ECHO
%state ST_BLADE_ECHO_ESCAPED
%state ST_BLADE_PARAMETER_EXPRESSION
%state ST_LOOK_FOR_DIRECTIVE_ARGUMENTS
%state ST_HTML_COMMENT

%%
/* @ will activate ST_BLADE_DIRECTIVE pushback -> end la new line sau ")" */


<YYINITIAL> {COMMENT_START} {
    yypushback(4);
    pushState(ST_COMMENT);
}

<ST_COMMENT>~{COMMENT_END} {
    popState();
    return createFullSymbol(ASTBladeSymbols.T_BLADE_COMMENT);
}


<YYINITIAL> {OPEN_ECHO} {
    String yytext = yytext();
    pushState(ST_BLADE_ECHO);
    return createFullSymbol(ASTBladeSymbols.T_BLADE_OPEN_ECHO);
}

<YYINITIAL> {OPEN_ECHO_ESCAPED} {
    String yytext = yytext();
    pushState(ST_BLADE_ECHO_ESCAPED);
    return createFullSymbol(ASTBladeSymbols.T_BLADE_OPEN_ECHO);
}

<ST_BLADE_ECHO> {CLOSE_ECHO} {
    String yytext = yytext();
    popState();
    return createFullSymbol(ASTBladeSymbols.T_BLADE_CLOSE_ECHO);
}

<ST_BLADE_ECHO>~{CLOSE_ECHO} {
    String yytext = yytext();
    yypushback(2);
    return createFullSymbol(ASTBladeSymbols.T_BLADE_PHP_ECHO);
}

<ST_BLADE_ECHO_ESCAPED> {CLOSE_ECHO_ESCAPED} {
    String yytext = yytext();
    popState();
    return createFullSymbol(ASTBladeSymbols.T_BLADE_CLOSE_ECHO);
}

<ST_BLADE_ECHO_ESCAPED>~{CLOSE_ECHO_ESCAPED} {
    String yytext = yytext();
    yypushback(3);
    return createFullSymbol(ASTBladeSymbols.T_BLADE_PHP_ECHO);
}

<ST_BLADE_ECHO, ST_BLADE_ECHO_ESCAPED>{NEWLINE} {
    String yytext = yytext();
    popState();
    return createFullSymbol(ASTBladeSymbols.T_INLINE_HTML);
}

<ST_BLADE_ECHO, ST_BLADE_ECHO_ESCAPED> {WHITESPACE}+ {
    //no break;
}

<YYINITIAL>"@" {
    pushState(ST_BLADE_DIRECTIVE);
    if (yylength() > 0){
        yypushback(1);
        return createFullSymbol(ASTBladeSymbols.T_INLINE_HTML);
    }
}

<ST_BLADE_DIRECTIVE>{

    /* layout modifiers */
    "@section" { 
        pushState(ST_BLADE_INCLUDE_ARGS);
        return createFullSymbol(ASTBladeSymbols.T_BLADE_SECTION);
    }
    "@endsection" { 
    	popState();
    	return createFullSymbol(ASTBladeSymbols.T_BLADE_ENDSECTION);
    }

    "@yield" { 
	    pushState(ST_BLADE_INCLUDE_ARGS);
	    return createFullSymbol(ASTBladeSymbols.T_BLADE_YIELD);
    }


    "@show" {
     	popState();
        return createFullSymbol(ASTBladeSymbols.T_BLADE_SHOW);
    }

    "@stop" {
    	popState();
        return createFullSymbol(ASTBladeSymbols.T_BLADE_STOP);
    }

    "@overwrite" {
        popState();
        return createFullSymbol(ASTBladeSymbols.T_BLADE_OVERWRITE);
    }   

    "@extends" {
        pushState(ST_BLADE_INCLUDE_ARGS);
    	return createFullSymbol(ASTBladeSymbols.T_BLADE_EXTENDS); 
    }

    "@append" {
        popState();
        return createFullSymbol(ASTBladeSymbols.T_BLADE_APPEND);
    }

    /* include */
    "@include" | "@includeIf" {
       pushState(ST_BLADE_INCLUDE_ARGS);
       return createFullSymbol(ASTBladeSymbols.T_BLADE_INCLUDE);
    }

    /* loops */
    "@foreach" {
        pushState(ST_PHP_LOOP_EXPRESSION);
        return createFullSymbol(ASTBladeSymbols.T_BLADE_FOREACH);
    }

    "@endforeach" {
        popState();
        return createFullSymbol(ASTBladeSymbols.T_BLADE_ENDFOREACH);
    }

    "@for" {
        pushState(ST_PHP_LOOP_EXPRESSION);
        return createFullSymbol(ASTBladeSymbols.T_BLADE_FOR);
    }

    "@else" {
    	//pop the state
        popState();
        return createFullSymbol(ASTBladeSymbols.T_BLADE_DIRECTIVE);
    }

    "@endfor" {
        popState();
        return createFullSymbol(ASTBladeSymbols.T_BLADE_ENDFOR);
    }

    /*if */
    "@if" {
        pushState(ST_PHP_CONDITION_EXPRESSION);
        return createFullSymbol(ASTBladeSymbols.T_BLADE_IF);
    }

    "@elseif" {
        pushState(ST_PHP_CONDITION_EXPRESSION);
        return createFullSymbol(ASTBladeSymbols.T_BLADE_ELSEIF);
    }

    "@endif" {
        popState();
        return createFullSymbol(ASTBladeSymbols.T_BLADE_ENDIF);
    }

    /* control statements */

    "@switch" {
    	pushState(ST_LOOK_FOR_DIRECTIVE_ARGUMENTS);
    	return createFullSymbol(ASTBladeSymbols.T_BLADE_SWITCH);
    }

    "@endswitch" {
    	popState();
    	return createFullSymbol(ASTBladeSymbols.T_BLADE_ENDSWITCH);
    }

    "@php"{WHITESPACE}~"@endphp" {
        popState();
        addBladePhpInline();
        return createFullSymbol(ASTBladeSymbols.T_BLADE_INLINE_PHP);
    }

    "@"{DNUM} | "@"{LNUM} {
    	String yytext = yytext();
    	popState();
    	return createFullSymbol(ASTBladeSymbols.T_INLINE_HTML);
    }

    "@"[ ]*[\(\#\.\{\'\"]+ {
       String yytext = yytext();
       popState();
       return createFullSymbol(ASTBladeSymbols.T_INLINE_HTML);
    }

    "@"{LABEL} {
       String yytext = yytext();
       if (BladeSyntax.CONDITIONAL_DIRECTIVES.contains(yytext)) {
             pushState(ST_PHP_CONDITION_EXPRESSION);
             return createFullSymbol(ASTBladeSymbols.T_BLADE_CONDITION_OPEN_TAG);
       }
       pushState(ST_LOOK_FOR_DIRECTIVE_ARGUMENTS);
       return createFullSymbol(ASTBladeSymbols.T_BLADE_DIRECTIVE);
    }


    {NEWLINE} {
       String yytext = yytext();
       popState();
       return createFullSymbol(ASTBladeSymbols.T_INLINE_HTML);
    }
}

<ST_LOOK_FOR_DIRECTIVE_ARGUMENTS>"(" {
    //TO TEST
    //directiveParBalance++;
    popState();
    yypushback(1);
    pushState(ST_BLADE_PARAMETER_EXPRESSION);
    return createSymbol(ASTBladeSymbols.T_OPEN_PARENTHESE);
}       

<ST_LOOK_FOR_DIRECTIVE_ARGUMENTS>{WHITESPACE} {
    
}

<ST_LOOK_FOR_DIRECTIVE_ARGUMENTS>{ANY_CHAR} {
   yybegin(YYINITIAL);
   yypushback(1);
   return createFullSymbol(ASTBladeSymbols.T_INLINE_HTML); 
}

<ST_BLADE_INCLUDE_ARGS> {
   \"    { yypushback(1);pushState(ST_STRING_DBQUOTE); }
   "'"   { yypushback(1);pushState(ST_STRING_SQUOTE); }
   ","                     {
        if (phpParameterExpressionText.trim().length() > 0){
            yypushback(1);
            return createPhpParameterExpression(ASTBladeSymbols.T_PHP_PARAMETER_EXPRESSION);
        }
        pushState(ST_BLADE_PARAMETER);
        return createSymbol(ASTBladeSymbols.T_COMMA);
   }
   "("  {
    	directiveParBalance++;
        if (phpParameterExpressionText.trim().length() > 0){
            phpParameterExpressionText += yytext();
        }
        if (directiveParBalance > 1) {
            pushState(ST_BLADE_PARAMETER);
        } else {
    	   return createSymbol(ASTBladeSymbols.T_OPEN_PARENTHESE);
        }
	}
    ")"                     {
    	String yytext = yytext();
    	directiveParBalance--;
    	if (directiveParBalance <= 0){
            directiveParBalance = 0;
            //exit out of ST_BLADE_INCLUDE_ARGS
            if (phpParameterExpressionText.trim().length() > 0){
                directiveParBalance++;
                yypushback(1);
                return createPhpParameterExpression(ASTBladeSymbols.T_PHP_PARAMETER_EXPRESSION);
            }
    		yybegin(YYINITIAL);
    		
    	}
    	return createSymbol(ASTBladeSymbols.T_CLOSE_PARENTHESE);
    }

    <ST_BLADE_INCLUDE_ARGS>{ANY_CHAR} {
        phpParameterExpressionText += yytext();
    }
}

<ST_PHP_CONDITION_EXPRESSION, ST_PHP_LOOP_EXPRESSION, ST_BLADE_PARAMETER_EXPRESSION>"(" {
    directiveParBalance++;
    phpConditionText += yytext();
}

<ST_PHP_CONDITION_EXPRESSION>")" {
    directiveParBalance--;
    phpConditionText += yytext();
    if (directiveParBalance <= 0){
        directiveParBalance = 0;
  		 yybegin(YYINITIAL);
   		 return createConditionSymbol(ASTBladeSymbols.T_PHP_CONDITION_EXPRESSION);
    }
}


<ST_PHP_LOOP_EXPRESSION>")" {
    directiveParBalance--;
    phpConditionText += yytext();
    if (directiveParBalance <= 0){
        directiveParBalance = 0;
  		 yybegin(YYINITIAL);
   		 return createConditionSymbol(ASTBladeSymbols.T_PHP_LOOP_EXPRESSION);
    }
}

<ST_BLADE_PARAMETER_EXPRESSION>")" {
    directiveParBalance--;
    phpConditionText += yytext();
    if (directiveParBalance <= 0){
        directiveParBalance = 0;
  		 yypushback(1);
         popState();
   		 return createConditionSymbol(ASTBladeSymbols.T_PHP_PARAMETER_EXPRESSION);
    }
}


<ST_PHP_CONDITION_EXPRESSION, ST_PHP_LOOP_EXPRESSION, ST_BLADE_PARAMETER_EXPRESSION >{WHITESPACE}+ { 
        whitespaceEndPosition = getTokenStartPosition() + yylength();
     }

<ST_PHP_CONDITION_EXPRESSION, ST_PHP_LOOP_EXPRESSION, ST_BLADE_PARAMETER_EXPRESSION>{ANY_CHAR} {
	String yytext = yytext();
	int debug = 1;
	phpConditionText += yytext();
}


<ST_BLADE_PARAMETER> {
    "(" {
        //skipping the parameter
    	directiveParBalance++;
    	//return createSymbol(ASTBladeSymbols.T_OPEN_PARENTHESE);
	}
    ")"                     {
        String yytext = yytext();
    	directiveParBalance--;
    	if (directiveParBalance <= 0){
            directiveParBalance =0;
    		if (phpParameterExpressionText.length() > 0){
    			directiveParBalance++;
    			yypushback(1);
    			popState();
    			return createPhpParameterExpression(ASTBladeSymbols.T_PHP_PARAMETER_EXPRESSION);
    		} else {
    			yybegin(YYINITIAL);
            	return createSymbol(ASTBladeSymbols.T_CLOSE_PARENTHESE);
            }
    	}
    	
    }

    {ANY_CHAR} {
    	phpParameterExpressionText += yytext();
    }

    /*
	{LABEL} {
        //to be refactored
        //return createFullSymbol(ASTBladeSymbols.T_VARIABLE);
    }
    */
}

<ST_LOOKING_FOR_PATH, ST_LOOKING_FOR_LABEL,  ST_LOOKING_FOR_INCLUDED_VARS>"$"{LABEL} {
    return createFullSymbol(ASTBladeSymbols.T_VARIABLE);
}

<ST_LOOKING_FOR_PATH, ST_LOOKING_FOR_LABEL, ST_LOOKING_FOR_INCLUDED_VARS>{LABEL} {
    return createFullSymbol(ASTBladeSymbols.T_STRING);
}

<ST_LOOKING_FOR_PATH, ST_LOOKING_FOR_LABEL, ST_LOOKING_FOR_INCLUDED_VARS>{PATH} {
    return createFullSymbol(ASTBladeSymbols.T_STRING);
}

<ST_BLADE_DIRECTIVE, ST_LOOKING_FOR_PATH, ST_LOOKING_FOR_LABEL, ST_LOOKING_FOR_INCLUDED_VARS> {
	/* names */
    \"                      { yypushback(1);pushState(ST_STRING_DBQUOTE); }
    "'"                      { yypushback(1);pushState(ST_STRING_SQUOTE); } 
    "("  {
    	directiveParBalance++;
    	return createSymbol(ASTBladeSymbols.T_OPEN_PARENTHESE);
	}
    ")"                     {
    	directiveParBalance--;
    	if (directiveParBalance <= 0){
            directiveParBalance = 0;
    		yybegin(YYINITIAL);
    	}
    	return createSymbol(ASTBladeSymbols.T_CLOSE_PARENTHESE);
    }

    "$"{LABEL} {
            //to be refactored
        return createFullSymbol(ASTBladeSymbols.T_VARIABLE);
    }
    {LABEL} {
            //to be refactored
        return createFullSymbol(ASTBladeSymbols.T_STRING);
    }
    {PATH} {
        return createFullSymbol(ASTBladeSymbols.T_STRING);
    }
 
    {WHITESPACE}+ { 
        whitespaceEndPosition = getTokenStartPosition() + yylength();
     }
}

<ST_STRING_SQUOTE>"'" [^\']* "'" {
   popState(); 
   return createFullSymbol(ASTBladeSymbols.T_STRING);
}

<ST_STRING_DBQUOTE>\" [^\"]* \" {
   popState(); 
   return createFullSymbol(ASTBladeSymbols.T_STRING);
}


<YYINITIAL>(([^<@{}]|"<"[^?%<!])+)|"<" {
    return createFullSymbol(ASTBladeSymbols.T_INLINE_HTML);
}

<YYINITIAL> "<!--" {
    yypushback(4);
    pushState(ST_HTML_COMMENT);
    //return createFullSymbol(ASTBladeSymbols.T_INLINE_HTML);
}

<ST_HTML_COMMENT>~"-->" {
    popState();
    return createFullSymbol(ASTBladeSymbols.T_INLINE_HTML);
}

<ST_HTML_COMMENT>{ANY_CHAR} {
    
}

<YYINITIAL> "<?php" {
    yypushback(5);
    pushState(ST_PHP);
}

<YYINITIAL> "<?=" {
    yypushback(3);
    pushState(ST_PHP);
}

<ST_PHP>"?>" {
    //yypushback(2);
    popState();
    return createFullSymbol(ASTBladeSymbols.T_INLINE_PHP);
}

<ST_PHP>~"?>" {
    //yypushback(2);
    addPhpStatement();
    popState();
    return createFullSymbol(ASTBladeSymbols.T_INLINE_PHP);
}

<YYINITIAL, ST_BLADE_DIRECTIVE, ST_LOOKING_FOR_LABEL, ST_LOOKING_FOR_INCLUDED_VARS, ST_PHP, ST_STRING_DBQUOTE, ST_STRING_SQUOTE, ST_BLADE_INCLUDE_ARGS, ST_PHP_LOOP_EXPRESSION,  ST_COMMENT>{ANY_CHAR} {
    // do nothing
}

<ST_BLADE_ECHO, ST_BLADE_ECHO_ESCAPED> {ANY_CHAR} {
    //no break;
}