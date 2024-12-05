parser grammar BladePhpAntlrParser;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.php;
}

options { 
    superClass = ParserAdaptor;
    tokenVocab = BladePhpAntlrLexer;
 }

expression : exprStatement* EOF;

exprStatement :
    //empty statement
    ';'
    | foreachDirectiveStatement
    | 'new' IDENTIFIER arguments?
    | staticMethodAccess
    | staticFieldAccess
    | staticClassReference
    | staticAccess
    | directMethodAccess
    | functionExpr
    | misc
;

foreachDirectiveStatement:
    {this.bladeParserContext.equals(ParserContext.FOREACH)}? foreachArguments
    ;

foreachArguments:
    main_array = PHP_VARIABLE 'as' array_item=PHP_VARIABLE
    | main_array = PHP_VARIABLE 'as' array_key=PHP_VARIABLE '=>'  array_item=PHP_VARIABLE
;

staticClassReference :
    namespace? IDENTIFIER '::' CLASS
;

staticMethodAccess : 
    namespace? className=IDENTIFIER '::' method=IDENTIFIER arguments
;

staticFieldAccess : 
    namespace? className=IDENTIFIER '::' const=IDENTIFIER
    | namespace? className=IDENTIFIER '::' propertyAlias=PHP_VARIABLE
    | classAlias=PHP_VARIABLE '::' const=IDENTIFIER
    | classAlias=PHP_VARIABLE '::' propertyAlias=PHP_VARIABLE
;

staticAccess : 
    //should throw an error?
    namespace? className=IDENTIFIER '::'
;

directMethodAccess : 
    'new' namespace? IDENTIFIER arguments '->' IDENTIFIER arguments
;

directAccess : 
    IDENTIFIER arguments '->' IDENTIFIER arguments
;

functionExpr : 
    IDENTIFIER arguments
;

arguments :
    '(' argument (',' argument )* ')'
    | '(' ')'
    ;

namespace :
    '\\'? (IDENTIFIER '\\')+
    | '\\'
;

argument: 
    PHP_VARIABLE
    | expression
    ;

misc:
  'new' PHP_VARIABLE arguments?
  | '$'? PHP_VARIABLE
    ;