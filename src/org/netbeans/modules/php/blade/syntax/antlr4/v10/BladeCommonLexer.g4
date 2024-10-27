lexer grammar BladeCommonLexer;

fragment DirectiveLabel 
    : [a-z_\u0080-\ufffe][a-z0-9_\u0080-\ufffe]*;    
 

fragment HtmlIdentifier 
    : [a-z_\u0080-\ufffe][a-z0-9_\u0080-\ufffe-]*;    

fragment ESC_DOUBLE_QUOTED_STRING 
    : [\\"];

fragment DOUBLE_QUOTED_STRING_FRAGMENT 
    : '"' (ESC_DOUBLE_QUOTED_STRING | . )*? '"';

fragment SINGLE_QUOTED_STRING_FRAGMENT 
    : '\'' (~('\'' | '\\') | '\\' . )* '\'';

fragment STRING_LITERAL : DOUBLE_QUOTED_STRING_FRAGMENT | SINGLE_QUOTED_STRING_FRAGMENT;

fragment Digit
    : ('0'..'9');

BLADE_COMMENT_START : '{{--' ->pushMode(INSIDE_BLADE_COMMENT), skip;

EMAIL_SUBSTRING : ('@' DirectiveLabel '.')->skip;

VERSION_WITH_AT: '@' (Digit '.'?)+->skip;

//escapes
D_ESCAPES 
    : (
      '{{{'
    |  '@@' '@'?
    | '@media' [ ]+ ('screen' [ ]+ 'and'?)?
    | '@media' (' ')* {this._input.LA(1) == '('}?
    | ( '@charset' | '@import' | '@namespace' | '@document' | '@font-face'
       | '@page' | '@layer' | '@supports' | '@tailwind' | '@apply' | '@-webkit-keyframes' 
       | '@keyframes' | '@counter-style' | '@font-feature-values' | '@property'
       | '@scope' | '@starting-style' | '@supports' | '@view-transition'
       | '@container' | '@color-profile' | '@styleset' | '@font-palette-values' | '@media'
      ) [ ]*
    )->skip;

mode INSIDE_BLADE_COMMENT;

BLADE_COMMENT_END : '--}}'->popMode, skip;

BLADE_COMMENT_MORE : . ->skip;

BLADE_COMMENT_EOF : EOF->popMode, skip;