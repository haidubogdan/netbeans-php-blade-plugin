# Change Log

## [2.2.1.2]

**parser**

Too much tokenisation can hurt. If the token is not necessary for the parser it should be skipped.

- cleaning tokens sent to parser to speed up parsing process [wip]


## [2.1.80]

- revert changes on lexer, add a simple error token when detecting `identifier:identifier` or `(:` tokens

**components**

- add `App\\Livewire` in the namespace register


## [2.1.70]

**lexer**

- fix freezing embedding usecases by splitting the php expression embeded tokens (usually it breaks with `(:`) #25

**components**

- work in progress for autocompleting components with hardcoded paths

it will search for components found in : 

- `App\\View\\Components`
- `App\\Http\\Livewire`
- `Illuminate\\Console\\View\\Components`

**indenting**

- quick fix for tab indent blocked after html tag #47 

**hints**

- disable warning path for namespace include `@include('base::my_comp')`

## [2.1.60]

**parser**

- regression with `@empty` block tag

## [2.1.50]

**lexer, formatting**

- fixing formatting issues due to self clossing tags or special composer tags which contain `::` symbols
- fixing `@section` formatting issue due to lack of separation between block and inline context
- include standard html keyword attributes

**debug**

- add coloring lexer

## [2.1.40]

**completion, lexer, parser, navigator, formatting**

- added `@session` directive

**lexer**

- fix component tag coloring

## [2.1.3]

**formatting**

- enabled by default
- fixed bugs ~(almost stable version)

**lexer**

- adding some **livewire** pluging directives

**navigator**

- fix missing `@can` directive from navigator
- add identifier info in navigator

## [2.1.2]

**formatting**

- blade formatting and indenting flow (needs to be enabled from Project Properties -> Laravel Blade)

**completion, brace matching**

- added `@switch` directive + `@can` and `@default`

**declaration finder**

- fix issue with constnant declaration finder

**utils**

- added token view action for debugging purpose

## [2.1.1]

**general**

Trying some performance updates

- clean unused imports
- change scope of ParserResult variable
- remove ParserResult blade Index
- remove Blade Properties Instance when project closed

**completion**

- adding `$loop` variable, refactor scopedLoopVariable

## [2.0.9]

**indexing**

- revert to the previous index nr

## [2.0.8]

**package**

- increase netbeans libraries package to start from netbeans 18

**hints**

- added blade language option in hints config (might require check and uncheck in the Options -> Editor -> Hints)

**parser**

- fix parser error display for 

```blade
@php
  $x = \new Date();
@endphp
```

## [2.0.7]

**lexer**

pre-release

- display custom lexer without arguments (#34 )

**completion**

- recognize path after folder for include path autocomplete (#41 )

## [2.0.6]

**parser**

- fix parser error for `@auth` with no param
- fix parser error for inline `@if` with directive which can work with or without arguments (ex: `@continue`)
- fix inline php parser error with EOF

**completion**

- include in completion `@foreach`, `@endforeach`

**brace match**

- add brace dynamic match for custom directives blocks

**lexer**

- fix lexer highlight for custom directives which starts with `@end` and have arguments

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

