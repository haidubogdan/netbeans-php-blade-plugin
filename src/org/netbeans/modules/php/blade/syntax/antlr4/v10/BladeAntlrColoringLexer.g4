lexer grammar BladeAntlrColoringLexer;
import BladeColoringCommonLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.v10;
}

options { 
    superClass = ColoringLexerAdaptor;
    caseInsensitive = true;
 }

tokens {
 DIRECTIVE,
 BLADE_PAREN,
 PHP_EXPRESSION,
 BLADE_PHP_ECHO_EXPR,
 BLADE_PHP_INLINE,
 RAW_TAG,
 CONTENT_TAG,
 HTML,
 HTML_TAG,   
 ERROR
}

fragment DirectivesWithEndTag : 'for' ('each')? | 'if' | 'while' 
   | 'section' | 'session' | 'once' | 'push' | 'PushOnce'
   | 'switch' | 'unless' | 'can' ('any' | 'not')?
   | 'auth' | 'guest'
   | 'error' | 'empty'
   //11.x
   | 'fragment';

fragment Include : '@include' ('If' | 'When' | 'First' | 'Unless')?;

fragment ComponentTagIdentifier 
    : [a-z_\u0080-\ufffe][a-z0-9.:\u0080-\ufffe-]*;   

//??
fragment SpecialChars : '°';

PHP_INLINE : '<?=' .*? '?>' | '<?php' .*? ('?>' | EOF);

D_GENERIC_BLOCK_DIRECTIVES : ('@' DirectivesWithEndTag | '@sectionMissing' | '@hasSection') (' ')* {this._input.LA(1) == '('}? ->pushMode(INSIDE_PHP_EXPRESSION),type(DIRECTIVE);

D_SIMPLE_BLOCK_DIRECTIVES : '@' 'end'? ('empty' | 'production' | 'once') ->type(DIRECTIVE);

D_GENERIC_INLINE_DIRECTIVES : ('@elseif' |  Include | '@extends' | '@each' | '@yield' | '@props' | '@method' 
   | '@class' | '@style' | '@aware' | '@break' | '@continue' | '@selected' | '@disabled' 
   | '@readonly' | '@required' | '@when' | '@bool') (' ')* {this._input.LA(1) == '('}? ->pushMode(INSIDE_PHP_EXPRESSION),type(DIRECTIVE);

D_GENERIC_INLINE_MIXED_DIRECTIVES : ('@break' | '@continue' | '@auth' | '@guest')->type(DIRECTIVE);

D_GENERIC_END_TAGS : ('@stop' | '@show' | '@overwrite' | '@viteReactRefresh' | '@end' DirectivesWithEndTag)->type(DIRECTIVE);

//verbatim has special blade escape logic
D_VERBATIM : '@verbatim' ->pushMode(VERBATIM_MODE), type(DIRECTIVE);
D_ENDVERBATIM : '@endverbatim'->type(DIRECTIVE);

D_MISC : ('@dd' | '@dump' | '@js' | '@json' | '@inject') (' ')* {this._input.LA(1) == '('}? ->pushMode(INSIDE_PHP_EXPRESSION),type(DIRECTIVE);

D_SIMPLE : ('@else' 'guest'? | '@csrf' | '@default' | '@append' | '@parent')->type(DIRECTIVE);

//php emebeddings
D_PHP_SHORT : '@php' (' ')? {this._input.LA(1) == '('}? ->type(D_PHP),pushMode(INSIDE_PHP_EXPRESSION);
D_PHP : '@php'->pushMode(BLADE_INLINE_PHP);

//allow php expression highlight for custom directives which start with 'end' also
D_END_ARG : ('@end' NameString) (' ')* {this._input.LA(1) == '('}?->pushMode(INSIDE_PHP_EXPRESSION),type(DIRECTIVE);
D_END : ('@end' NameString)->type(DIRECTIVE);

//known plugins
D_LIVEWIRE : ('@livewireStyles' | '@bukStyles' | '@livewireScripts' | '@bukScripts' | '@click' ('.away')? '=')->type(DIRECTIVE);
D_ASSET_BUNDLER : '@vite' (' ')* {this._input.LA(1) == '('}? ->pushMode(INSIDE_PHP_EXPRESSION),type(DIRECTIVE);

D_CSS_AT_RULE : ('@supports' | '@container' | '@scope' | '@media') (' ')* {this._input.LA(1) == '('}? ->type(HTML);
//we will decide that a custom directive has expression to avoid email matching
D_CUSTOM : ('@' NameString (' ')* {this._input.LA(1) == '('}? ) ->pushMode(INSIDE_PHP_EXPRESSION);

D_UNKNOWN : '@' NameString->pushMode(ADIACENT_DIRECTIVE_TOKENS);

//hack to allow completion for directives
//it doesn't trigger completion
D_AT : '@' (' ' | '>' | [\n\r])?;

//display
CONTENT_TAG_OPEN : '{{' ->pushMode(INSIDE_REGULAR_ECHO),type(CONTENT_TAG);
RAW_TAG_OPEN : '{!!' ->pushMode(INSIDE_RAW_ECHO),type(RAW_TAG);

CSS_COMMENT : ('/*' .*? '*/' | '//')->type(HTML);

HTML_X : ('<x-' ComponentTagIdentifier | '<' ComponentTagIdentifier ('::' ComponentTagIdentifier)+)->type(HTML),pushMode(INSIDE_HTML_COMPONENT_TAG);

CLOSE_TAG : ('</' FullIdentifier '>' [\n\r ]*)+->type(HTML);

HTML : ((' ')+ | [\r\n]+ | ComponentTagIdentifier | SpecialChars | '"' {this._input.LA(1) != '@'}? | '\\\'' {this._input.LA(1) != '@'}? | '_' | '.' 
| ',' | '=' | [()-;]+ | '[' | ']' )* '<' {this._input.LA(1) != 'x' && this._input.LA(1) != '?' && this._input.LA(2) != 'p'}? ->pushMode(INSIDE_HTML_TAG),more;

HTML_MISC : ((' ')+ | [\r\n]+ | ('#' | '.')? ComponentTagIdentifier | SpecialChars | '"' {this._input.LA(1) != '@'}?
| ',' | '\\\'' | '_' | '.' | '=' | [()-;]+ | '[' | ']'  )+->type(HTML);

HTML_WS : ((' ')+ | [\r\n]+)->type(HTML);

INCOMPLETE_BLADE_TAG : ('{!' | '{{-') ->type(HTML);

OTHER : . ->type(HTML);

mode INSIDE_HTML_TAG;

OTHER_HTML_POP : . {this._input.LA(1) == '@' || this._input.LA(1) == '{' || (this._input.LA(1) == '<' && (this._input.LA(2) == 'x' || this._input.LA(2) == '?'))}? ->type(HTML_TAG), popMode;

OTHER_HTML : . ->more;

HTML_EOF : EOF->type(HTML_TAG),popMode;

// {{  }}
mode INSIDE_REGULAR_ECHO;

CONTENT_TAG_CLOSE : ('}}')->popMode,type(CONTENT_TAG);

GREEDY_REGULAR_ECHO_EXPR : ~[ {}]+ {this.consumeEscapedEchoToken();};

ESCAPED_ECHO_EXPR : . [ ]* {this.consumeEscapedEchoToken();};
EXIT_ECHO_EOF : EOF->type(ERROR),popMode;

// {!!  !!}
mode INSIDE_RAW_ECHO;

RAW_TAG_CLOSE : ('!!}')->popMode, type(RAW_TAG);

RAW_ECHO_EXPR : ~[ !{}]+ {this.consumeNotEscapedEchoToken();};
RAW_ECHO_EXPR_MORE : . [ ]* {this.consumeNotEscapedEchoToken();};
EXIT_RAW_ECHO_EOF : EOF->type(ERROR),popMode;

// @directive (?)
mode INSIDE_PHP_EXPRESSION;

OPEN_PAREN : '(' {this.rParenBalance == 0}? {this.rParenBalance++;}->type(BLADE_PAREN);
OPEN_E_PAREN : '(' {this.rParenBalance++;}->type(PHP_EXPRESSION);
CLOSE_PAREN : ')' {this.rParenBalance <= 1}? {this.rParenBalance = 0;}->type(BLADE_PAREN),mode(DEFAULT_MODE);
CLOSE_E_PAREN : ')' {this.rParenBalance--;}->type(PHP_EXPRESSION);

PHP_EXPRESSION_COMMENT : ('/*' .*? '*/')->skip;

PHP_EXPRESSION_GREEDY : ~[()]+ ->type(PHP_EXPRESSION);

PHP_EXPRESSION_MORE : . ->type(PHP_EXPRESSION);

EXIT_EOF : EOF->type(ERROR),mode(DEFAULT_MODE);

// @php
mode BLADE_INLINE_PHP;

D_ENDPHP : '@endphp'->popMode;

BLADE_PHP_INLINE : ~[@]+;
BLADE_PHP_INLINE_MORE : . ->type(BLADE_PHP_INLINE);

EXIT_INLINE_PHP_EOF : EOF->type(ERROR),popMode;

// @verbatim
mode VERBATIM_MODE;

D_ENDVERBATIM_IN_MODE : '@endverbatim'->type(DIRECTIVE), popMode;

//hack to merge all php inputs into one token
VERBATIM_HTML : ~[@]+ ->type(HTML);
VERBATIM_HTML_MORE : . ->type(HTML);

EXIT_VERBATIM_MOD_EOF : EOF->type(ERROR),popMode;

mode INSIDE_HTML_COMPONENT_TAG;

COMPONENT_ATTRIBUTE : (':' FullIdentifier '="') ->type(HTML),pushMode(COMPONENT_PHP_EXPRESSION); 

COMPONENT_CONTENT_TAG_OPEN : '{{' ->pushMode(INSIDE_REGULAR_ECHO),type(CONTENT_TAG);
COMPONENT_RAW_TAG_OPEN : '{!!' ->pushMode(INSIDE_RAW_ECHO),type(RAW_TAG);

EXIT_HTML_COMPONENT : '>'->type(HTML), popMode;

HTML_COMPONENT_ANY : . ->type(HTML);

EXIT_HTML_COMPONENT_EOF : EOF->type(ERROR),popMode;

mode COMPONENT_PHP_EXPRESSION;

EXIT_COMPONENT_PHP_EXPRESSION : '"'->type(HTML), popMode;
COMPONENT_PHP_EXPRESSION_LAST : . {this._input.LA(1) == '"'}? ->type(PHP_EXPRESSION);
COMPONENT_PHP_EXPRESSION : . ->more;

EXIT_COMPONENT_PHP_EXPRESSION_EOF : EOF->type(ERROR),popMode;

mode ADIACENT_DIRECTIVE_TOKENS;

TOKEN_ADIACENT_DIRECTIVE : (' ' | '>' | [\n\r])->type(D_UNKNOWN),popMode;

TOKEN_ADIACENT_DIRECTIVE_OTHER : . ->type(HTML),popMode;
TOKEN_ADIACENT_DIRECTIVE_EOF : EOF->type(ERROR),popMode;