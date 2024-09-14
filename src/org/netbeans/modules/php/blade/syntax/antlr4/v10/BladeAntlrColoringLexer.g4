lexer grammar BladeAntlrColoringLexer;
import BladeColoringCommonLexer;

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
 D_UNKNOWN,
 PHP_EXPRESSION,
 BLADE_PHP_ECHO_EXPR,
 RAW_TAG,
 CONTENT_TAG,
 HTML,
 HTML_TAG,
 PHP_TOKEN,
 PHP_KEYWORD,
 PHP_STRING,
 PHP_VARIABLE,
 PHP_NUMBER,
 PHP_COMMENT,
 PHP_WS,
 ERROR
}

fragment NekudoWithelistMatch : '::' | '?:' | ' : ';

fragment DirectivesWithEndTag : 'for' ('each')? | 'if' | 'while' 
   | 'section' | 'session' | 'once' | 'push' | 'PushOnce'
   | 'switch' | 'unless' | 'can' ('any' | 'not')?
   | 'auth' | 'guest'
   | 'error' | 'production' | 'empty';

fragment Include : '@include' ('If' | 'When' | 'First' | 'Unless')?;

//to remove
fragment DOUBLE_QUOTED_STRING_FRAGMENT_WITH_PHP 
    : '"' (ESC_DOUBLE_QUOTED_STRING | '{' PhpVariable '}' | . | ~[:])*?  '"';

fragment ComponentTagIdentifier 
    : [a-z_\u0080-\ufffe][a-z0-9.:\u0080-\ufffe-]*;   

//??
fragment SpecialChars : '°';

PHP_INLINE : '<?=' .*? '?>' | '<?php' .*? ('?>' | EOF);

D_GENERIC_BLOCK_DIRECTIVES : ('@' DirectivesWithEndTag | '@sectionMissing' | '@hasSection') (' ')* {this.lookForDirectiveArg(BladeAntlrColoringLexer.DIRECTIVE);};

D_GENERIC_INLINE_DIRECTIVES : ('@elseif' |  Include | '@extends' | '@each' | '@yield' | '@props' | '@method' 
   | '@class' | '@style' | '@aware' | '@break' | '@continue' | '@selected' | '@disabled' | '@readonly' | '@required') (' ')* {this.lookForDirectiveArg(BladeAntlrColoringLexer.DIRECTIVE);};

D_GENERIC_INLINE_MIXED_DIRECTIVES : ('@break' | '@continue')->type(DIRECTIVE);

D_GENERIC_END_TAGS : ('@stop' | '@show' | '@overwrite' | '@viteReactRefresh' | '@end' DirectivesWithEndTag)->type(DIRECTIVE);

//verbatim has special blade escape logic
D_VERBATIM : '@verbatim' ->pushMode(VERBATIM_MODE), type(DIRECTIVE);
D_ENDVERBATIM : '@endverbatim'->type(DIRECTIVE);

D_MISC : ('@dd' | '@dump' | '@js' | '@json' | '@inject') (' ')* {this.lookForDirectiveArg(BladeAntlrColoringLexer.DIRECTIVE);};

D_SIMPLE : ('@else' | '@csrf' | '@default' | '@append' | '@parent')->type(DIRECTIVE);

//php emebeddings
D_PHP_SHORT : '@php' (' ')? {this._input.LA(1) == '('}? ->type(D_PHP),pushMode(INSIDE_PHP_EXPRESSION);
D_PHP : '@php'->pushMode(BLADE_INLINE_PHP);

//allow php expression highlight for custom directives which start with 'end' also
D_END : ('@end' NameString)(' ')* {this.lookForDirectiveArg(BladeAntlrColoringLexer.D_UNKNOWN);};

//known plugins
D_LIVEWIRE : ('@livewireStyles' | '@bukStyles' | '@livewireScripts' | '@bukScripts' | '@click' ('.away')? '=')->type(DIRECTIVE);
D_ASSET_BUNDLER : '@vite' (' ')* {this.lookForDirectiveArg(BladeAntlrColoringLexer.DIRECTIVE);};

//we will decide that a custom directive has expression to avoid email matching
D_CUSTOM : '@' NameString (' ')* {this.lookForDirectiveArg(BladeAntlrColoringLexer.D_UNKNOWN);};

D_EMAIL : (FullIdentifier '@' FullIdentifier '.' ('com' |  NameString))->type(HTML);

//TODO move all known directives to fragment?
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
//hack due to a netbeans php embedding issue when adding or deleting ':' chars
ECHO_DOUBLE_NEKODU : NekudoWithelistMatch {this.consumeEscapedEchoToken();};
ECHO_STRING_LITERAL : (SingleQuotedString | DOUBLE_QUOTED_STRING_FRAGMENT_WITH_PHP) {this.consumeEscapedEchoToken();};
ECHO_PHP_FREEZE_SYNTAX : (':)' | ':') ->skip;
GREEDY_REGULAR_ECHO_EXPR : ~[ "':{}]+ {this.consumeEscapedEchoToken();};

ESCAPED_ECHO_EXPR : . [ ]* {this.consumeEscapedEchoToken();};
EXIT_ECHO_EOF : EOF->type(ERROR),popMode;

// {!!  !!}
mode INSIDE_RAW_ECHO;

RAW_TAG_CLOSE : ('!!}')->popMode, type(RAW_TAG);
//hack due to a netbeans php embedding issue when adding or deleting ':' chars
RAW_ECHO_DOUBLE_NEKODU : NekudoWithelistMatch {this.consumeNotEscapedEchoToken();};
RAW_ECHO_STRING_LITERAL : (SingleQuotedString | DOUBLE_QUOTED_STRING_FRAGMENT_WITH_PHP) {this.consumeNotEscapedEchoToken();};
RAW_ECHO_PHP_FREEZE_SYNTAX : (':)' | ':') ->skip;
RAW_ECHO_EXPR : ~[ "':!{}]+ {this.consumeNotEscapedEchoToken();};
RAW_ECHO_EXPR_MORE : . [ ]* {this.consumeNotEscapedEchoToken();};
EXIT_RAW_ECHO_EOF : EOF->type(ERROR),popMode;

// @directive (?)
mode INSIDE_PHP_EXPRESSION;

LPAREN : '(' {this.handleOpenRoundParen();};

RPAREN : ')' {this.handleEndRoundParen();};

DB_STRING_OPEN : '"' ->more,pushMode(DB_STRING_MODE);
//hack due to a netbeans php embedding issue when adding or deleting ':' chars

EXPR_STRING_LITERAL : (SingleQuotedString)->type(PHP_STRING);

PHP_EXPRESSION_COMMENT : ('/*' .*? '*/')->type(PHP_COMMENT);

EXPR_PHP_VARIABLE : PhpVariable->type(PHP_VARIABLE);

EXPR_KEYWORD : PhpKeyword->type(PHP_KEYWORD);

EXP_NUMBER : [0-9]+ ('.' [0-9]+)? -> type(PHP_NUMBER);

EXPR_PHP_TOKEN_NAME : FullIdentifier ->type(PHP_TOKEN);

EXPR_WS : ((' ')+ | [\r\n]+)->type(PHP_WS);

EXPR_PHP_TOKEN : . ->type(PHP_TOKEN);

EXIT_EOF : EOF->type(ERROR),mode(DEFAULT_MODE);

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
      }?;
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

mode DB_STRING_MODE;

DB_CURLY : '{' {this._input.LA(1) == '$'}? ->type(PHP_TOKEN),pushMode(STRING_VAR_EXPR);

DB_PHP_VARIABLE : PhpVariable->type(PHP_VARIABLE);

DB_QUOTE_MORE : '\\"'->more;

DB_QUOTE_EXIT : '"'->type(PHP_STRING), popMode;

DB_STRING_BEFORE_VAR_EXPR : . {this._input.LA(1) == '{' || this._input.LA(1) == '$'}?->type(PHP_STRING);

DB_QUOTE_ANY : . ->more;

DB_QUOTE_EOF : EOF->type(ERROR),popMode;

mode STRING_VAR_EXPR;

STRING_VAR_EXPR_VARIABLE : PhpVariable->type(PHP_VARIABLE);
STRING_VAR_EXPR_NUMBER : [0-9]+ -> type(PHP_NUMBER);
STRING_VAR_EXPR_VARIABLE_ARR : (('->' FullIdentifier)+ | '[' | ']' | ('[' [ ]+ ']'))->type(PHP_TOKEN);
STRING_VAR_EXPR_ARR_KEY : SingleQuotedString->type(PHP_STRING);
STRING_VAR_EXPR_EXIT : '}'->type(PHP_TOKEN), popMode;

STRING_VAR_EXP_EOF : EOF->type(ERROR),popMode;