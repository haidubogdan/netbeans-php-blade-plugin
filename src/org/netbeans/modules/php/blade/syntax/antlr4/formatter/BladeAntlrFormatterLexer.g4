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
    : [a-z\u0080-\ufffe][a-z0-9_.\u0080-\ufffe]*;

fragment DirectiveArgLookup
    : (' ')* {this._input.LA(1) == '('}?;

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

D_IF : ('@if' DirectiveArgLookup)->pushMode(DIRECTIVE_ARG);
D_ENDIF : '@endif';


D_FOREACH : ('@foreach' DirectiveArgLookup)->pushMode(DIRECTIVE_ARG);
D_ENDFOREACH : '@endforeach';

NON_PARAM_DIRECTIVE : '@continue' | '@break';

D_INLINE_DIRECTIVE : '@' DirectiveLabel DirectiveArgLookup;

SG_QUOTE : '\'';
DB_QUOTE : '"';

HTML_CLOSE_TAG : '<' (' ')* '/' (' ')*  [a-z\u0080-\ufffe][a-z0-9_.\u0080-\ufffe]* (' ')* '>';
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