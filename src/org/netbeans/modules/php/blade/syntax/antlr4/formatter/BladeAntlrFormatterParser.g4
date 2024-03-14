parser grammar BladeAntlrFormatterParser;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.formatter;
}

options { tokenVocab = BladeAntlrFormatterLexer; }

file : statement* EOF;

statement:
    html_indent
    | indetable_element
    | inline_identable_element
    | static_element
    | nl_with_space_before
    | (SG_QUOTE | DB_QUOTE)
    | GT_SYMBOL
    | HTML_CLOSE_TAG
    | (NL | WS)
    ;

indetable_element:
   block_start (statement)+ nl_with_space? block_end
 ;

html_indent : GT_SYMBOL NL WS*;
block_start : ws_before=nl_with_space_before? block_directive_name  D_ARG_LPAREN D_ARG_RPAREN;
block_directive_name : (D_IF | D_FOREACH);
block_end : D_ENDIF | D_ENDFOREACH;
inline_identable_element : D_INLINE_DIRECTIVE | NON_PARAM_DIRECTIVE;

nl_with_space_before : NL WS*;
nl_with_space : NL WS*;

static_element : 
    D_PHP PHP_CODE+ D_ENDPHP
    | HTML
    | OTHER;

