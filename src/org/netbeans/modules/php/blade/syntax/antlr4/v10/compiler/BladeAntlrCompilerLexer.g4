lexer grammar BladeAntlrCompilerLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler;
}

options { superClass = LexerAdaptor; }
 
//we will hide html in the end
tokens {HTML, PHP_CODE}
 
channels { COMMENT }

PHP_INLINE : '<?=' .*? '?>' | '<?php' .*? '?>';
//
D_ESCAPES 
    : (
      '@@'
    | '@{'
    | '@media'
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

D_IF : '@if';

D_PHP : '@php' {this._input.LA(1) == ' ' || this._input.LA(1) == '\n'}?->pushMode(BLADE_INLINE_PHP);

OTHER : . ->skip;

mode BLADE_INLINE_PHP;

D_ENDPHP : '@endphp'->popMode;

PHP_CODE_GREEDY : ~[@]+->type(PHP_CODE);

PHP_CODE_COMPLETION : . ->type(PHP_CODE);