parser grammar BladeAntlrFormatterParser;

@header{
  package org.netbeans.modules.php.blade.syntax.antlr4.formatter;
}

options { tokenVocab = BladeAntlrFormatterLexer; }

file : statement* EOF;

statement:
    html_indent
    | indetable_element
    | section_block
    | inline_identable_element
    | block_aligned_directive
    | static_element
    | nl_with_space_before
    | blade_echo
    | block_end
    | (SG_QUOTE | DB_QUOTE)
    | GT_SYMBOL
    | html_close_tag
    | (NL | WS)
    ;

inline_tag_statement : 
    IDENTIFIER EQ IDENTIFIER
    | IDENTIFIER EQ STRING
    | IDENTIFIER
    | WS
    | NL
    ;

html_close_tag : HTML_CLOSE_TAG;
    
indetable_element:
    block_start (statement)+ nl_with_space? block_end
    ;

html_indent : HTML_START_BLOCK_TAG inline_tag_statement* GT_SYMBOL NL WS*;
block_start : ws_before=nl_with_space_before? block_directive_name  D_ARG_LPAREN D_ARG_RPAREN;
block_directive_name : D_BLOCK_DIRECTIVE_START;
block_end : D_BLOCK_DIRECTIVE_END;
block_aligned_directive : D_BLOCK_ALIGNED_DIRECTIVE;
inline_identable_element : D_INLINE_DIRECTIVE | NON_PARAM_DIRECTIVE 
    | blade_echo
    ;

section_block : section_block_start (statement)+ D_ENDSECTION;
section_block_start : D_SECTION D_ARG_LPAREN D_ARG_RPAREN;
nl_with_space_before : NL WS*;
nl_with_space : NL WS*;

static_element : 
    D_PHP PHP_CODE+ D_ENDPHP
    | HTML_COMMENT
    | HTML
    | OTHER;

blade_echo : (CONTENT_TAG_OPEN CONTENT_TAG_CLOSE)
    | (RAW_TAG_OPEN RAW_TAG_CLOSE);