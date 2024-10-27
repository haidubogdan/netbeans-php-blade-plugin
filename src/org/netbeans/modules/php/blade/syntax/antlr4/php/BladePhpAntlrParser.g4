parser grammar BladePhpAntlrParser;

@header{
  /**
   * Parser generated for netbeans blade editor
   * Some elements have been simplified to optimize parser speed
   * For example
   * - switch statement have a loos validation
   * - generic block statement "@isset" | "@unless" are grouped togehter
   * - the start match and end match will be checked in the parser
   */
  package org.netbeans.modules.php.blade.syntax.antlr4.php;
}

options { tokenVocab = BladePhpAntlrLexer; }

expression : exprStatement* EOF;

exprStatement :
    'new' IDENTIFIER arguments?
    | staticMethodAccess
    | staticFieldAccess
    | staticClassReference
    | directMethodAccess
    | functionExpr
;

staticClassReference :
    namespace? IDENTIFIER '::' CLASS
;

staticMethodAccess : 
    namespace? className=IDENTIFIER '::' method=IDENTIFIER arguments
;

staticFieldAccess : 
    namespace? className=IDENTIFIER '::' const=IDENTIFIER
;

directMethodAccess : 
    namespace? IDENTIFIER '->' IDENTIFIER arguments
;

functionExpr : 
    IDENTIFIER arguments
;

arguments :
    '(' argument (',' argument )* ')'
    ;

namespace :
    '\\'? (IDENTIFIER '\\')+
    | '\\'
;

argument: 
    PHP_VARIABLE
    | expression
    ;