lexer grammar BladeAntlrLexer;
import BladeCommonLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.v10;
}

@lexer::members {
    int rparenBalance = 0;
    int sqparenBalance = 0;
    int curlyparenBalance = 0;
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
    LSQUAREBRACKET,
    RSQUAREBRACKET,
    LCURLYBRACE,
    RCURLYBRACE,
    COMMA,
    ERROR
}

//conditionals
D_IF : '@if' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ELSEIF : '@elseif' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_ELSE : '@else';
D_ENDIF : '@endif';

D_SWITCH : '@switch' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_CASE : '@case' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_DEFAULT : '@default';
D_ENDSWITCH : '@endswitch';

//layouts
D_EXTENDS : '@extends' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};
D_INCLUDE : '@include' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};
D_EACH : '@each' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};

D_YIELD : '@yield' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};
D_SECTION : '@section' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};
D_ENDSECTION : '@endsection';

D_PARENT : '@parent';
D_SHOW : '@show';
D_OVERWRITE : '@overwrite';
D_STOP : '@stop';
D_APPEND : '@append';
D_ONCE : '@once';
D_ENDONCE : '@endonce';

D_STACK : '@stack' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};
D_PUSH : '@push' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};
D_ENDPUSH : '@endpush';
D_PUSH_IF : '@pushIf' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};
D_ENDPUSH_IF : '@endPushIf';
D_PUSH_ONCE : '@pushOnce' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};
D_ENDPUSH_ONCE : '@endPushOnce';
D_PREPEND : '@prepend' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};
D_ENDPREPEND : '@endprepend';

D_HAS_SECTION : '@hasSection' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};
D_SECTION_MISSING : '@sectionMissing' (' ')* {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};

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

D_VERBATIM : '@verbatim' ->pushMode(VERBATIM_MODE);
D_ENDVERBATIM : '@endverbatim';

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

//misc
D_DUMPER : ('@dd' | '@dump') (' ')* {lookupMode(INSIDE_PHP_EXPRESSION);};
D_LANG : '@lang' {lookupMode(INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS);};

//extra

BLADE_CONTENT_OPEN_TAG : '{{';
BLADE_TAG_ESCAPE : '@{';
BLADE_CONTENT_CLOSE_TAG : '}}';

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

LCURLYBRACE: '{'->skip;
RCURLYBRACE: '}'->skip;

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

mode INSIDE_PHP_EXPRESSION_WITH_IDENTIFIABLE_PARAMS;

EI_IDENTIFIABLE_STRING : (' ')*  STRING_LITERAL (' ')* 
   {this._input.LA(1) == ',' || this._input.LA(1) == ')'}? ->type(IDENTIFIABLE_STRING),mode(INSIDE_PHP_EXPRESSION);

START_EI_LPAREN: '(' {rparenBalance == 0}? {rparenBalance++;}->type(LPAREN);
EI_LPAREN: '(' {rparenBalance++;}->skip;
EXIT_EI_RPAREN: ')' {rparenBalance == 1}? {rparenBalance--;}  ->type(RPAREN),mode(DEFAULT_MODE);
EI_RPAREN: ')' {rparenBalance--;} ->skip,mode(INSIDE_PHP_EXPRESSION);

EI_OTHER : . ->skip, mode(INSIDE_PHP_EXPRESSION);

EXIT_EI_EOF : EOF->type(ERROR),mode(DEFAULT_MODE);

mode VERBATIM_MODE;

D_ENDVERBATIM_IN_MODE : '@endverbatim'->type(D_ENDVERBATIM), mode(DEFAULT_MODE);

//hack to merge all php inputs into one token
VERBATIM_HTML : . ->skip;


EXIT_VERBATIM_MOD_EOF : EOF->type(ERROR),mode(DEFAULT_MODE);
