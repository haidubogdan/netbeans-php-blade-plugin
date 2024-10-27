lexer grammar BladeAntlrLexer;
import BladeCommonLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.v10;
}

@lexer::members {
    int rparenBalance = 0;
    int sqparenBalance = 0;
    int curlyparenBalance = 0;
    int htmlCurlyParenBalance = 0;
}

options { 
    superClass = LexerAdaptor;
    caseInsensitive = true;
}

channels {PHP_CODE}

tokens {
    LPAREN,
    RPAREN,
    IDENTIFIABLE_STRING,
    BLADE_CONTENT_CLOSE_TAG,
    LSQUAREBRACKET,
    RSQUAREBRACKET,
    LCURLYBRACE,
    RCURLYBRACE,
    D_PHP,
    COMMA,
    ERROR
}

//conditionals
D_IF : '@if' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ELSEIF : '@elseif' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ELSE : '@else';
D_ENDIF : '@endif';

D_UNLESS: '@unless' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ENDUNLESS: '@endunless';


D_ISSET: '@isset' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ENDISSET: '@endisset';

D_SWITCH : '@switch' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_CASE : '@case' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_DEFAULT : '@default';
D_ENDSWITCH : '@endswitch';

//layouts
D_EXTENDS : '@extends' (' ')* {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};
D_INCLUDE : '@include' (' ')* {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};
D_INCLUDE_IF : '@includeIf' (' ')* {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};
D_INCLUDE_WHEN : '@includeWhen' (' ')* {this.identifierStringPos = 2; lookupMode(PHP_EXPR_WITH_CUSTOM_IDENTIFIABLE_STRING_POS);};
D_INCLUDE_UNLESS : '@includeUnless' (' ')* {this.identifierStringPos = 2; lookupMode(PHP_EXPR_WITH_CUSTOM_IDENTIFIABLE_STRING_POS);};
D_EACH : '@each' (' ')* {lookupMode(PHP_EXPR_EACH);};
D_INCLUDE_FIRST : '@includeFirst' (' ')* {lookupMode(INCLUDE_FIRST_MODE);};

D_YIELD : '@yield' (' ')* {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};
D_SECTION : '@section' (' ')* {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};
D_ENDSECTION : '@endsection';

D_PARENT : '@parent';
D_SHOW : '@show';
D_OVERWRITE : '@overwrite';
D_STOP : '@stop';
D_APPEND : '@append';
D_ONCE : '@once';
D_ENDONCE : '@endonce';

D_STACK : '@stack' (' ')* {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};
D_PUSH : '@push' (' ')* {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};
D_ENDPUSH : '@endpush';
D_PUSH_IF : '@pushIf' (' ')* {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};
D_ENDPUSH_IF : '@endPushIf';
D_PUSH_ONCE : '@pushOnce' (' ')* {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};
D_ENDPUSH_ONCE : '@endPushOnce';
D_PREPEND : '@prepend' (' ')* {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};
D_ENDPREPEND : '@endprepend';

D_HAS_SECTION : '@hasSection' (' ')* {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};
D_SECTION_MISSING : '@sectionMissing' (' ')* {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};

//loops
D_FOREACH : '@foreach' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ENDFOREACH : '@endforeach';

D_FOR : '@for' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ENDFOR : '@endfor';

D_FORELSE : '@forelse' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ENDFORELSE : '@endforelse';

D_WHILE : '@while' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ENDWHILE : '@endwhile';

D_BREAK : '@break' (' ')* {flexibleMode(INSIDE_PHP_EXPRESSION);};
D_CONTINUE : '@continue' (' ')* {flexibleMode(INSIDE_PHP_EXPRESSION);};

//context

D_EMPTY : '@empty' (' ')* {flexibleMode(INSIDE_PHP_EXPRESSION);};
D_ENDEMPTY: '@endempty';
D_VERBATIM : '@verbatim' ->pushMode(VERBATIM_MODE);
D_ENDVERBATIM : '@endverbatim';

D_SESSION : '@session' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ENDSESSION : '@endsession';

//forms
D_CSRF  : '@csrf';
D_METHOD : '@method' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ERROR : '@error' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ENDERROR : '@enderror';

//authentification

D_AUTH : '@auth' (' ')* {flexibleMode(INSIDE_PHP_EXPRESSION);};
D_ENDAUTH : '@endauth';

D_GUEST : '@guest' (' ')* {flexibleMode(INSIDE_PHP_EXPRESSION);};
D_ELSEGUEST : '@elseguest';
D_ENDGUEST : '@endguest';

D_ENV : '@env' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ENDENV : '@endenv';

D_PRODUCTION : '@production';
D_ENDPRODUCTION : '@endproduction';

//blocks

D_FRAGMENT : '@fragment' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ENDFRAGMENT: '@endfragment';

D_PHP_INLINE : '@php' (' ')* {this._input.LA(1) == '('}? ->type(D_PHP),pushMode(INSIDE_PHP_EXPRESSION);

D_PHP : '@php' [ \r\n] ->pushMode(BLADE_INLINE_PHP);

//misc
D_SIMPLE_DIRECTIVE : ('@dd' | '@dump' | '@json' | '@checked' 
| '@style' | '@class' | '@disabled' | '@required' | '@readonly') (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_LANG : '@lang' {lookupMode(PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING);};

D_INJECT : '@inject' (' ')* {this.identifierStringPos = 2; lookupMode(PHP_EXPR_WITH_CUSTOM_IDENTIFIABLE_STRING_POS);};

//extra

BLADE_CONTENT_OPEN_TAG : '{{';
BLADE_TAG_ESCAPE : '@' ('{')+->skip;
//avoid curly closing 

BLADE_CONTENT_CLOSE_TAG : '}}' {this.consumeCloseTag(htmlCurlyParenBalance);} ;

BLADE_RAW_OPEN_TAG : '{!!';
BLADE_RAW_CLOSE_TAG : '!!}';

D_CUSTOM : '@' DirectiveLabel (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};

AT : '@' ->skip;

COMMA : ',' ->skip;

//for simpler syntax on parser
LPAREN : '('->skip;
RPAREN : ')'->skip;

LSQUAREBRACKET: '['->skip;
RSQUAREBRACKET: ']'->skip;

LCURLYBRACE: '{' {htmlCurlyParenBalance++;}->skip;
RCURLYBRACE: '}' {htmlCurlyParenBalance--;}->skip;

WS : ((' ')+ | [\r\n]+)->skip;

OTHER : . ->skip;

mode INSIDE_PHP_EXPRESSION;

START_E_LPAREN: '(' {rparenBalance == 0}? {rparenBalance++;}->type(LPAREN);
E_LPAREN: '(' {rparenBalance++;}->skip;
EXIT_E_RPAREN: ')' {rparenBalance == 1}? {rparenBalance--;}  ->type(RPAREN),mode(DEFAULT_MODE);
E_RPAREN: ')' {rparenBalance--;} ->skip;

E_LSQUAREBRACKET: '[' {sqparenBalance++;} ->skip;
E_RSQUAREBRACKET: ']' {sqparenBalance--;}->skip;

E_LCURLYBRACE: '{' {curlyparenBalance++;}->skip;
E_RCURLYBRACE: '}' {curlyparenBalance--;}->skip;

E_ARG_COMMA : ',' {rparenBalance == 1 && sqparenBalance == 0 && sqparenBalance == 0}? ->type(COMMA);

E_OTHER : . ->skip;

EXIT_E_EOF : EOF->type(ERROR),mode(DEFAULT_MODE);

mode PHP_EXPR_WITH_FIRST_IDENTIFIABLE_STRING;

EI_IDENTIFIABLE_STRING : (' ')*  STRING_LITERAL (' ')* 
   {this._input.LA(1) == ',' || this._input.LA(1) == ')'}? ->type(IDENTIFIABLE_STRING),mode(INSIDE_PHP_EXPRESSION);

START_EI_LPAREN: '(' {rparenBalance == 0}? {rparenBalance++;}->type(LPAREN);
EI_LPAREN: '(' {rparenBalance++;}->skip;
EXIT_EI_RPAREN: ')' {rparenBalance == 1}? {rparenBalance--;}  ->type(RPAREN),mode(DEFAULT_MODE);
EI_RPAREN: ')' {rparenBalance--;} ->skip,mode(INSIDE_PHP_EXPRESSION);

EI_OTHER : . ->skip, mode(INSIDE_PHP_EXPRESSION);

EXIT_EI_EOF : EOF->type(ERROR),mode(DEFAULT_MODE);

mode PHP_EXPR_WITH_CUSTOM_IDENTIFIABLE_STRING_POS;

START_ESPOS_LPAREN: '(' {rparenBalance == 0}? {rparenBalance++; this.argCounter=1;}->type(LPAREN);
ESPOS_LPAREN: '(' {rparenBalance++;}->skip;
EXIT_ESPOS_RPAREN: ')' {rparenBalance == 1}? {rparenBalance--;}  ->type(RPAREN),mode(DEFAULT_MODE);
ESPOS_RPAREN: ')' {rparenBalance--;} ->skip;

ESPOS_LSQUAREBRACKET: '[' {sqparenBalance++;} ->skip;
ESPOS_RSQUAREBRACKET: ']' {sqparenBalance--;}->skip;

ESPOS_LCURLYBRACE: '{' {curlyparenBalance++;}->skip;
ESPOS_RCURLYBRACE: '}' {curlyparenBalance--;}->skip;

ESPOS_ARG_COMMA : ',' {rparenBalance == 1 && sqparenBalance == 0 && sqparenBalance == 0}? {this.argCounter++;} ->type(COMMA);

ESPOS_IDENTIFIABLE_STRING : (' ')*  STRING_LITERAL (' ')* 
   {this._input.LA(1) == ',' && this.argCounter == this.identifierStringPos }? { this.identifierStringPos = 0;  } ->type(IDENTIFIABLE_STRING);

ESPOS_OTHER : . ->skip;

EXIT_ESPOS_EOF : EOF->type(ERROR),mode(DEFAULT_MODE);

//@each
mode PHP_EXPR_EACH;

START_EACH_LPAREN: '(' {rparenBalance == 0}? {rparenBalance++;this.argCounter=1;}->type(LPAREN);
EACH_LPAREN: '(' {rparenBalance++;}->skip;
EXIT_EACH_RPAREN: ')' {rparenBalance == 1}? {rparenBalance--;}  ->type(RPAREN),mode(DEFAULT_MODE);
EACH_RPAREN: ')' {rparenBalance--;} ->skip;

EACH_LSQUAREBRACKET: '[' {sqparenBalance++;} ->skip;
EACH_RSQUAREBRACKET: ']' {sqparenBalance--;}->skip;

EACH_LCURLYBRACE: '{' {curlyparenBalance++;}->skip;
EACH_RCURLYBRACE: '}' {curlyparenBalance--;}->skip;

EACH_ARG_COMMA : ',' {rparenBalance == 1 && sqparenBalance == 0 && sqparenBalance == 0}? {this.argCounter++;} ->type(COMMA);

EACH_IDENTIFIABLE_STRING : (' ')*  STRING_LITERAL (' ')* 
   {this.argCounter == 1 && this.identifierStringPos == 1 }? { this.identifierStringPos = 4;  } ->type(IDENTIFIABLE_STRING);

EACH_LAST_IDENTIFIABLE_STRING : (' ')*  STRING_LITERAL (' ')* 
   {this._input.LA(1) == ')' && this.argCounter == 4 && this.identifierStringPos == 4 }? { this.identifierStringPos = 0;  } ->type(IDENTIFIABLE_STRING);

EACH_OTHER : . ->skip;

EXIT_EACH_EOF : EOF->type(ERROR),mode(DEFAULT_MODE);

//@includeFirst
mode INCLUDE_FIRST_MODE;

START_INCF_LPAREN: '(' {rparenBalance == 0}? {rparenBalance++;this.argCounter=1;}->type(LPAREN);
INCF_LPAREN: '(' {rparenBalance++;}->skip;
EXIT_INCF_RPAREN: ')' {rparenBalance == 1}? {rparenBalance--;}  ->type(RPAREN),mode(DEFAULT_MODE);
INCF_RPAREN: ')' {rparenBalance--;} ->skip;

INCF_LSQUAREBRACKET: '[' {sqparenBalance++;} ->skip;
INCF_RSQUAREBRACKET: ']' {sqparenBalance--;}->skip;

INCF_LCURLYBRACE: '{' {curlyparenBalance++;}->skip;
INCF_RCURLYBRACE: '}' {curlyparenBalance--;}->skip;

INCF_ARG_COMMA : ',' {rparenBalance == 1 && sqparenBalance == 0 && sqparenBalance == 0}? {this.argCounter++;} ->type(COMMA);

INCF_IDENTIFIABLE_STRING : (' ')*  STRING_LITERAL (' ')*
    {rparenBalance == 1 && sqparenBalance == 1 && this.argCounter == 1}? ->type(IDENTIFIABLE_STRING)
    ;

INCF_OTHER : . ->skip;

EXIT_INCF_EOF : EOF->type(ERROR),mode(DEFAULT_MODE);

//@php @endphp
mode BLADE_INLINE_PHP;

D_ENDPHP : '@endphp'->popMode;

BLADE_INLINE_PHP_OTHER : . ->skip;

EXIT_BLADE_INLINE_PHP : EOF->type(ERROR),mode(DEFAULT_MODE);

//verbatim
mode VERBATIM_MODE;

D_ENDVERBATIM_IN_MODE : '@endverbatim'->type(D_ENDVERBATIM), mode(DEFAULT_MODE);

//hack to merge all php inputs into one token
VERBATIM_HTML : . ->skip;


EXIT_VERBATIM_MOD_EOF : EOF->type(ERROR),mode(DEFAULT_MODE);
