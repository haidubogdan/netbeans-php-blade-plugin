parser grammar BladeAntlrCompilerParser;

@header{
  /**
   * Parser generated for netbeans blade editor
   * Some elements have been simplified to optimize parser speed
   * For example
   * - switch statement have a loos validation
   * - generic block statement "@isset" | "@unless" are grouped togehter
   * - the start match and end match will be checked in the parser
   */
  package org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler;
}

options { tokenVocab = BladeAntlrCompilerLexer; }

file : general_statement* EOF;

general_statement :
    block_statement
    | php_blade
    | php_inline
;

block_statement: D_IF;
php_blade : D_PHP php_blade_code D_ENDPHP;

php_blade_code: PHP_CODE+;

php_inline : PHP_INLINE;