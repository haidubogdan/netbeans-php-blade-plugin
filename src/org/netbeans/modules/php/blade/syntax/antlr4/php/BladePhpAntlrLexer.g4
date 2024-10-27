lexer grammar BladePhpAntlrLexer;
import BladePhpCommonLexer;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.php;
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

LINE_COMMENT : LineComment->skip;

ARRAY : 'array';
AS : 'as';
ECHO : 'echo';
NEW : 'new';
CLASS : 'class';
FUNCTION : 'function';
LANG_CONSTRUCT : 'empty';

COMMA : ',' ;

LPAREN : '(';
RPAREN : ')';

LSQUAREBRACKET: '[';
RSQUAREBRACKET: ']';

LCURLYBRACE: '{';
RCURLYBRACE: '}';

IDENTIFIER : Identifier;

PHP_VARIABLE : PhpVariable;

NAMESPACE_SEPARATOR : '\\';
DOUBLE_COLON : '::';
OBJECT_OPERATOR : '->';

STRING_LITERAL : StringLiteral->skip;


STYLE_COMMENT : '/*' .*? '*/' [\n\r]*->skip;

WS : ((' ')+ | [\r\n]+)->skip;

OTHER : . ->skip;

