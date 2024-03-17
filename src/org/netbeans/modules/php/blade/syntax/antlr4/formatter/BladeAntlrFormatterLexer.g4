lexer grammar BladeAntlrFormatterLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.formatter;
}

options { 
    superClass = LexerAdaptor;
    caseInsensitive = true;
}
 
//we will hide html in the end
tokens {HTML, PHP_CODE}
 
channels { COMMENT }

fragment DirectiveLabel 
    : [a-z\u0080-\ufffe][a-z0-9_\u0080-\ufffe]*;

fragment Identifier
    : [a-z\u0080-\ufffe][a-z0-9_\u0080-\ufffe]*;

fragment DirectiveArgLookup
    : (' ')* {this._input.LA(1) == '('}?;

fragment DOUBLE_QUOTED_STRING_FRAGMENT 
    : '"' ([\\"] | . )*? '"';

fragment SINGLE_QUOTED_STRING_FRAGMENT 
    : '\'' (~('\'' | '\\') | '\\' . )* '\'';

fragment BlockDirectiveName 
    : 'auth' | 'guest'
   | 'if' | 'can' ('any' | 'not')? | 'for' ('each' | 'else')? 
   | 'while' | 'hasSection' | 'fragment' | 'verbatim'
   | 'env' | 'once' | 'error'
   | 'push' ('if' | 'once')? | 'prepend' | 'switch';

PHP_INLINE : '<?=' .*? '?>' | '<?php' .*? '?>';
//
D_ESCAPES 
    : (
      '{{{'
    |  '@@' '@'?
    | '@{' '{'?
    | '@media' [ ]*
    | '@charset'
    | '@import'
    | '@namespace'
    | '@document'
    | '@font-face'
    | '@page'
    | '@supports'
    | '@layer'
    | '@tailwind'
    | '@apply' 
    | '@-webkit-keyframes' 
    | '@keyframes'
    )->type(HTML);

D_BLOCK_DIRECTIVE_START : ('@' BlockDirectiveName DirectiveArgLookup)->pushMode(DIRECTIVE_ARG);
D_BLOCK_DIRECTIVE_END : '@end' BlockDirectiveName ;

D_SECTION : ('@section' DirectiveArgLookup)->pushMode(DIRECTIVE_ARG);
D_ENDSECTION : '@endsection' | '@show' | '@append' | '@stop';
D_BLOCK_ALIGNED_DIRECTIVE : '@else' | '@elseif';
NON_PARAM_DIRECTIVE : '@continue' | '@break';

D_INLINE_DIRECTIVE : '@' DirectiveLabel DirectiveArgLookup | '@csrf';

STRING : DOUBLE_QUOTED_STRING_FRAGMENT | SINGLE_QUOTED_STRING_FRAGMENT;

CONTENT_TAG_OPEN : '{{' ->pushMode(INSIDE_REGULAR_ECHO);
RAW_TAG_OPEN : '{!!' ->pushMode(INSIDE_RAW_ECHO);

SG_QUOTE : '\'';
DB_QUOTE : '"';

HTML_CLOSE_TAG : '<' (' ')* '/' (' ')*  [a-z\u0080-\ufffe][a-z0-9_.\u0080-\ufffe]* (' ')* '>';
HTML_COMMENT: '<!--' .*? '-->';
HTML_START_BLOCK_TAG : '<' ('div'
   | 'section'
   | 'script' | 'select' | 'h' [1-9] 
   | ('p' | 'a') {this._input.LA(1) == '@' || this._input.LA(1) == ' ' || this._input.LA(1) == '\n'}?);
EQ : '=';
IDENTIFIER : Identifier; 
GT_SYMBOL : '>';

D_PHP : '@php' {this._input.LA(1) == ' ' || this._input.LA(1) == '\n'}?->pushMode(BLADE_INLINE_PHP);

AT : '@' ->skip;

WS : ((' ') | [\t])+;
NL : [\r\n];



OTHER : . ->skip;

mode DIRECTIVE_ARG;

D_ARG_LPAREN : '(' {this.consumeDirectiveArgLParen();};
D_ARG_RPAREN : ')' {this.consumeDirectiveArgRParen();};

D_ARG_NL : [\r\n]->type(NL);

PHP_EXPR : . ->skip;

EXIT_EOF : EOF->popMode;

mode BLADE_INLINE_PHP;

D_ENDPHP : '@endphp'->popMode;

PHP_CODE_GREEDY : ~[@]+->type(PHP_CODE);

PHP_CODE_COMPLETION : . ->type(PHP_CODE);

// {{  }}
mode INSIDE_REGULAR_ECHO;

CONTENT_TAG_CLOSE : ('}}')->popMode;
CONTENT_OTHER : . ->skip;
EXIT_REGULAR_ECHO_EOF : EOF->popMode;

// {!!  !!}
mode INSIDE_RAW_ECHO;

RAW_TAG_CLOSE : ('!!}')->popMode;
RAW_CONTENT_OTHER : . ->skip;
EXIT_RAW_ECHO_EOF : EOF->popMode;