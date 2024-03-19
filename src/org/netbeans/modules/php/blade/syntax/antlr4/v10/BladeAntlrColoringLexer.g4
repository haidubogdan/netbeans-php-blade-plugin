lexer grammar BladeAntlrColoringLexer;
import BladeCommonLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.v10;
}

options { 
    superClass = ColoringLexerAdaptor;
    caseInsensitive = true;
 }

channels {PHP_CODE}

tokens {
 DIRECTIVE,
 PHP_EXPRESSION,
 BLADE_PHP_ECHO_EXPR,
 RAW_TAG,
 CONTENT_TAG,
 HTML,
 ERROR
}

fragment
NEKUDO_WHITELIST_MATCH : '::' | '?:' | ' : ';

fragment DOUBLE_QUOTED_STRING_FRAGMENT_WITH_PHP 
    : '"' (ESC_DOUBLE_QUOTED_STRING | '{' PhpVariable '}' | . | ~[:])*?  '"';

fragment ComponentTagIdentifier 
    : [a-z_\u0080-\ufffe][a-z0-9\u0080-\ufffe-]*;   

PHP_INLINE : '<?=' .*? '?>' | '<?php' .*? ('?>' | EOF);

//conditionals
D_COND_ARG : ('@if' | '@elseif')->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_COND : ('@else' | '@endif')->type(DIRECTIVE);
D_SWITCH : '@switch'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_CASE : '@case'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDSWITCH : '@endswitch'->type(DIRECTIVE);
D_UNLESS : '@unless'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDUNLESS : '@endunless'->type(DIRECTIVE);

//loops
D_EACH : '@each'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_FOR : '@for' ('each' | 'else')?->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDFOR : '@endfor' ('else' | 'each')?->type(DIRECTIVE);
D_WHILE : '@while'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDWHILE : '@endwhile'->type(DIRECTIVE);
D_CONTINUE : '@continue'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_BREAK : '@break'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);

//includes
D_INCLUDE : '@include' ('If' | 'When' | 'First' | 'Unless')?->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);

//layout
D_EXTENDS : '@extends'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_JS : '@js'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_SECTION : '@section'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_HAS_SECTION : '@hasSection'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_SECTION_MISSING : '@sectionMissing'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDSECTION : '@endsection'->type(DIRECTIVE);
D_YIELD : '@yield'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_PARENT : '@parent'->type(DIRECTIVE);
D_SHOW : '@show'->type(DIRECTIVE);
D_OVERWRITE : '@overwrite'->type(DIRECTIVE);
D_ONCE : '@once'->type(DIRECTIVE);
D_ENDONCE : '@endonce'->type(DIRECTIVE);
D_PUSH : '@push'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDPUSH : '@endpush'->type(DIRECTIVE);
D_PUSH_ONCE : '@pushOnce'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDPUSH_ONCE : '@endPushOnce';
D_PROPS : '@props'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);

//forms
D_METHOD : '@method'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ERROR : '@error'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDERROR : '@enderror'->type(DIRECTIVE);

//env
D_PRODUCTION : '@production'->type(DIRECTIVE);
D_ENDPRODUCTION : '@endproduction'->type(DIRECTIVE);

//styles, attributes
D_CLASS : '@class'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_STYLE : '@style'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_AWARE : '@aware'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);

//misc
D_EMPTY : '@empty'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDEMPTY : '@endempty'->type(DIRECTIVE);
D_AUTH : '@auth'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_PERMISSION : ('@can' | '@cannot' | '@canany')->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_INJECT : '@inject'->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_MISC : ('@session' | '@dd' | '@json')->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);
D_ENDMISC : '@end' ('session')->type(DIRECTIVE);
D_PHP_SHORT : '@php' (' ')? {this._input.LA(1) == '('}? ->type(D_PHP),pushMode(LOOK_FOR_PHP_EXPRESSION);
D_PHP : '@php'->pushMode(BLADE_INLINE_PHP);

D_VERBATIM : '@verbatim' ->pushMode(VERBATIM_MODE), type(DIRECTIVE);
D_ENDVERBATIM : '@endverbatim'->type(DIRECTIVE);

//starting the optimisation
//D_WITH_EXPR: ''
//lazy end match
D_WITH_EXPR : ('@break' | '@continue' | '@selected' | '@disabled' | '@readonly' |
               '@required')->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);

D_SIMPLE : ('@stop' | '@csrf' | '@default' | '@append')->type(DIRECTIVE);
D_END : ('@end' NameString)->pushMode(LOOK_FOR_PHP_EXPRESSION),type(DIRECTIVE);

//known plugins
D_LIVEWIRE : ('@livewireStyles' | '@bukStyles' | '@livewireScripts' | '@bukScripts' | '@click' ('.away')? '=')->type(DIRECTIVE);

//we will decide that a custom directive has expression to avoid email matching
D_CUSTOM : ('@' NameString {this._input.LA(1) == '(' || 
        (this._input.LA(1) == ' ' && this._input.LA(2) == '(')}? ) ->pushMode(LOOK_FOR_PHP_EXPRESSION);

//display
CONTENT_TAG_OPEN : '{{' ->pushMode(INSIDE_REGULAR_ECHO),type(CONTENT_TAG);
RAW_TAG_OPEN : '{!!' ->pushMode(INSIDE_RAW_ECHO),type(RAW_TAG);

HTML_CLOSE_TAG : '<' '/'?  NameString [ ]* '>'->type(HTML); 

//hack for the last unclosed tags
//to check if we still have this issue
UNCLOSED_TAG : ('<' NameString [\r\n]+)->type(HTML); 

LAST_NL : [\r\n]+ EOF; 

HTML_X : ('<x-' ComponentTagIdentifier)->type(HTML),pushMode(INSIDE_HTML_COMPONENT_TAG);

HTML : ~[<?@{!]+;

OTHER : . ->type(HTML);

// {{  }}
mode INSIDE_REGULAR_ECHO;

CONTENT_TAG_CLOSE : ('}}')->popMode,type(CONTENT_TAG);
//hack due to a netbeans php embedding issue when adding or deleting ':' chars
ECHO_DOUBLE_NEKODU : NEKUDO_WHITELIST_MATCH {this.consumeEscapedEchoToken();};
ECHO_STRING_LITERAL : (SINGLE_QUOTED_STRING_FRAGMENT | DOUBLE_QUOTED_STRING_FRAGMENT_WITH_PHP) {this.consumeEscapedEchoToken();};
ECHO_PHP_FREEZE_SYNTAX : (':)' | ':') ->skip;

GREEDY_REGULAR_ECHO_EXPR : ~[ ':{}]+ {this.consumeEscapedEchoToken();};

ESCAPED_ECHO_EXPR : . [ ]* {this.consumeEscapedEchoToken();};
EXIT_ECHO_EOF : EOF->type(ERROR),popMode;

// {!!  !!}
mode INSIDE_RAW_ECHO;

RAW_TAG_CLOSE : ('!!}')->popMode, type(RAW_TAG);
//hack due to a netbeans php embedding issue when adding or deleting ':' chars
RAW_ECHO_DOUBLE_NEKODU : NEKUDO_WHITELIST_MATCH {this.consumeNotEscapedEchoToken();};
RAW_ECHO_STRING_LITERAL : (SINGLE_QUOTED_STRING_FRAGMENT | DOUBLE_QUOTED_STRING_FRAGMENT_WITH_PHP) {this.consumeNotEscapedEchoToken();};
RAW_ECHO_PHP_FREEZE_SYNTAX : (':)' | ':') ->skip;
RAW_ECHO_EXPR : ~[ ':!{}]+ {this.consumeNotEscapedEchoToken();};
RAW_ECHO_EXPR_MORE : . [ ]* {this.consumeNotEscapedEchoToken();};
EXIT_RAW_ECHO_EOF : EOF->type(ERROR),popMode;

// @directive ()?
mode LOOK_FOR_PHP_EXPRESSION;

WS_EXPR : [ ]+ {this._input.LA(1) == '('}? ->pushMode(INSIDE_PHP_EXPRESSION);
OPEN_EXPR_PAREN_MORE : '(' {this.increaseRoundParenBalance();} ->more,pushMode(INSIDE_PHP_EXPRESSION);

L_OTHER : . ->type(HTML), popMode;

// @directive (?)
mode INSIDE_PHP_EXPRESSION;

OPEN_EXPR_PAREN : {this.roundParenBalance == 0}? '(' {this.increaseRoundParenBalance();} ->more;
CLOSE_EXPR_PAREN : {this.roundParenBalance == 1}? ')' 
    {this.decreaseRoundParenBalance();}->type(PHP_EXPRESSION),mode(DEFAULT_MODE);

LPAREN : {this.roundParenBalance > 0}? '(' {this.increaseRoundParenBalance();}->more;
RPAREN : {this.roundParenBalance > 0}? ')' {this.decreaseRoundParenBalance();}->more;

//in case of lexer restart context
EXIT_RPAREN : ')' {this.roundParenBalance == 0}?->type(PHP_EXPRESSION),mode(DEFAULT_MODE);

//hack due to a netbeans php embedding issue when adding or deleting ':' chars
DOUBLE_NEKODU : NEKUDO_WHITELIST_MATCH ->more;
PHP_FREEZE_SYNTAX : (':)' | ':' ) ->skip;
//no string interpolation for the moment
//freeze issue
EXPR_STRING_LITERAL : (SINGLE_QUOTED_STRING_FRAGMENT)->more;

//STATIC_STRING : //check if start of token ... check if bracket and 

PHP_EXPRESSION_MORE : . ->more;

EXIT_EOF : EOF->type(ERROR),popMode;

// @php
mode BLADE_INLINE_PHP;

D_ENDPHP : '@endphp'->popMode;

//hack to merge all php inputs into one token
BLADE_PHP_INLINE : . {
        this._input.LA(1) == '@' &&
        this._input.LA(2) == 'e' &&
        this._input.LA(3) == 'n' &&
        this._input.LA(4) == 'd' &&
        this._input.LA(5) == 'p' &&
        this._input.LA(6) == 'h' &&
        this._input.LA(7) == 'p'
      }?->channel(PHP_CODE) ;
BLADE_PHP_INLINE_MORE : . ->more;

EXIT_INLINE_PHP_EOF : EOF->type(ERROR),popMode;

// @verbatim
mode VERBATIM_MODE;

D_ENDVERBATIM_IN_MODE : '@endverbatim'->type(DIRECTIVE), popMode;

//hack to merge all php inputs into one token
VERBATIM_HTML : . {
        this._input.LA(1) == '@' &&
        this._input.LA(2) == 'e' &&
        this._input.LA(3) == 'n' &&
        this._input.LA(4) == 'd' &&
        this._input.LA(5) == 'v' &&
        this._input.LA(6) == 'e' &&
        this._input.LA(7) == 'r'
      }? ->type(HTML);
VERBATIM_HTML_MORE : . ->more;

EXIT_VERBATIM_MOD_EOF : EOF->type(ERROR),popMode;

mode INSIDE_HTML_COMPONENT_TAG;

COMPONENT_ATTRIBUTE : (':' NameString '="') ->type(HTML),pushMode(COMPONENT_PHP_EXPRESSION); 

COMPONENT_CONTENT_TAG_OPEN : '{{' ->pushMode(INSIDE_REGULAR_ECHO),type(CONTENT_TAG);
COMPONENT_RAW_TAG_OPEN : '{!!' ->pushMode(INSIDE_RAW_ECHO),type(RAW_TAG);

EXIT_HTML_COMPONENT : '>'->type(HTML), popMode;

HTML_COMPONENT_ANY : . ->more;

EXIT_HTML_COMPONENT_EOF : EOF->type(ERROR),popMode;

mode COMPONENT_PHP_EXPRESSION;

EXIT_COMPONENT_PHP_EXPRESSION : '"'->type(HTML), popMode;
COMPONENT_PHP_EXPRESSION_LAST : . {this._input.LA(1) == '"'}? ->type(PHP_EXPRESSION);
COMPONENT_PHP_EXPRESSION : . ->more;

EXIT_COMPONENT_PHP_EXPRESSION_EOF : EOF->type(ERROR),popMode;