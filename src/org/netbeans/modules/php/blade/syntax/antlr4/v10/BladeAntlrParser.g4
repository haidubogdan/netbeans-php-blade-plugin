parser grammar BladeAntlrParser;

@header{
  /**
   * Parser generated for netbeans blade editor
   * Php expression syntax is handled seprately
   */
  package org.netbeans.modules.php.blade.syntax.antlr4.v10;
}
 
@parser::members {public static int bladeVersion = 10;}

options { tokenVocab = BladeAntlrLexer; }

file : (statement)* EOF;

statement :
    blockIdentifiableArgDirective
    | blockDirective
    | identifiableArgDirective
    | multipleArgDirective
    | inlineDirective
    | customDirective
    | bladeContentTags
    | bladeRawTags
    | ('}}' | '!!}') //stray tags are possible
    | errorDirectives
    | phpInline
;

blockDirective : 
    ifStatement
    | foreachStatement
    | forStatement
    | forElseStatement
    | D_WHILE directiveArguments (statement | loopBreaks)* D_ENDWHILE
    | switchStatement
    | formStatements
    | authStatements
    | D_ONCE directiveArguments? statement* D_ENDONCE
    | D_UNLESS directiveArguments statement* D_ENDUNLESS
    | D_EMPTY directiveArguments statement* D_ENDEMPTY
    | D_ISSET directiveArguments statement* D_ENDISSET
    | D_SESSION directiveArguments statement* D_ENDSESSION
    | bladePhpBlock
    //x.11
    | D_FRAGMENT directiveArguments statement* D_ENDFRAGMENT
    | D_VERBATIM D_ENDVERBATIM
;

ifStatement : ifStartStatement
    (elseifStatement | statement | loopBreaks)*
    (D_ELSE (statement | loopBreaks)*)?
     D_ENDIF;

foreachStatement : D_FOREACH directiveArguments
    (statement | loopBreaks)* D_ENDFOREACH;

forStatement : D_FOR directiveArguments
    (statement | loopBreaks)* D_ENDFOR;

forElseStatement : D_FORELSE directiveArguments (statement | loopBreaks)* 
    D_EMPTY statement* D_ENDFORELSE;

ifStartStatement : D_IF directiveArguments;
elseifStatement: D_ELSEIF directiveArguments statement*;

switchStatement :
    D_SWITCH directiveArguments
    (D_CASE directiveArguments statement* D_BREAK?)*
    (D_DEFAULT directiveArguments statement*)?
    D_ENDSWITCH
    ;

bladePhpBlock : 
    D_PHP D_ENDPHP
    ;

//
inlineDirective:
    D_SIMPLE_DIRECTIVE directiveArguments
    | D_PHP directiveArguments
;

identifiableArgDirective :
  D_SECTION '(' IDENTIFIABLE_STRING? ',' ')'
  | D_EXTENDS '(' IDENTIFIABLE_STRING? (',')? ')'
  | (D_INCLUDE | D_INCLUDE_IF) '(' IDENTIFIABLE_STRING? (',')? ')'
  | (D_INCLUDE_WHEN | D_INCLUDE_UNLESS) '(' ',' IDENTIFIABLE_STRING? (',')? ')'
  | D_YIELD '(' IDENTIFIABLE_STRING? ','? ')'
  | D_STACK  '(' IDENTIFIABLE_STRING? ')'
  | D_LANG   '(' IDENTIFIABLE_STRING? ','? ')'
  | D_INJECT '(' ',' IDENTIFIABLE_STRING? ')'
;

multipleArgDirective :
  D_EACH '(' IDENTIFIABLE_STRING? ',' ',' (',' IDENTIFIABLE_STRING?)? ')'
  | D_INCLUDE_FIRST '(' IDENTIFIABLE_STRING* (',')? ')'
;

blockIdentifiableArgDirective : 
    D_SECTION '(' IDENTIFIABLE_STRING? ')' D_PARENT? statement* (D_SHOW | D_STOP | D_OVERWRITE | D_ENDSECTION | D_APPEND)
    | D_HAS_SECTION '(' IDENTIFIABLE_STRING? ')' statement* D_ENDIF
    | D_SECTION_MISSING '(' IDENTIFIABLE_STRING? ')' statement* D_ENDIF
    | D_PUSH '(' IDENTIFIABLE_STRING? ')' statement* D_ENDPUSH
    | D_PUSH_IF '(' IDENTIFIABLE_STRING? ',' ')' statement* D_ENDPUSH_IF
    | D_PUSH_ONCE '(' IDENTIFIABLE_STRING? ')' statement* D_ENDPUSH_ONCE
    | D_PREPEND '(' IDENTIFIABLE_STRING?  ')' statement* D_ENDPREPEND
;   

directiveWithArg :
    D_EXTENDS
    | D_INCLUDE
    | D_YIELD
;

customDirective :
    D_CUSTOM directiveArguments?;

loopBreaks :
    (D_CONTINUE | D_BREAK) directiveArguments?;


formStatements:
   D_ERROR '(' ','? ')' statement* (D_ELSE statement*)? D_ENDERROR
   | D_CSRF
   | D_METHOD directiveArguments
   ;

authStatements:
    D_AUTH directiveArguments? statement* ((D_ELSEGUEST | D_ELSE) statement*)? D_ENDAUTH
    | D_GUEST directiveArguments? statement* D_ENDGUEST
    | D_ENV directiveArguments statement* D_ENDENV
    | D_PRODUCTION statement* D_ENDPRODUCTION
;
    
bladeContentTags: 
    '{{' '}}'
;

bladeRawTags: 
     '{!!' '!!}'
;

errorDirectives:
    directiveWithArg '(' {notifyErrorListeners("Missing closing ')'");}
    | D_IF directiveArguments {notifyErrorListeners("Syntax error, expecting @elseif or @else or @endif");}
    | (D_FOREACH | D_FOR) directiveArguments {notifyErrorListeners("Unclosed block directive");}
    | D_VERBATIM {notifyErrorListeners("Unclosed verbatim block");}
    | D_SECTION '(' IDENTIFIABLE_STRING? ')' {notifyErrorListeners("Inline @section requires second argument");}
;

directiveArguments : 
    '(' ')';

phpInline:
    PHP_INLINE_START phpInlineEnd=(PHP_INLINE_EXIT | PHP_INLINE_EOF);