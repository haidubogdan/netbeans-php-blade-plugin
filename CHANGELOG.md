# Change Log

## [2.0.5]

**parser**

- fix parser error for `@can`, `@canany`, `@append`

**completion**

- include in completion `@can`

**brace match**

- add brace match for `@section` ... `@append`, `@can` ... `@endcan`

## [2.0.4]

**parser**

- fix parser error for `@json`, `@dd`, `@aware`

**completion**

- include in completion `@json`
- remove param from some endtags directives

**NB IDE framework**

- use deprecated method `hasStructureScanner` to avoid parser error

## [2.0.0]

Full refactor.

Using **antlr** instead of **jflex** for lexer and parser code.

More info about what was added or removed can be found in README.md 

## [1.0.0.51]

Php Lexer update. Detect simple string (without php embedding) before the freeze pattern.
Autocomplete for styling and html directives "@class, @style, @required ..." 

## [1.0.0.50]

Lexer update (fix). If a string pattern which freezes netbeans embeddings (class:::value) is detected and it starts with quote symbol, it will be displayed as a string. 

## [1.0.0.49]

fix blade comment autocomplete bug, extra closing comment statement.

## [1.0.0.48]

## [1.0.0.47]

refactor views autocomplete.
cleaning unused code.
fixing issues on text interceptors.
parser issues for @include type directives.
don't interpret css code with directives (ex: @media)

## [1.0.0]

first Released

