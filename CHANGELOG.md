# Change Log

## [3.0.0.36]
- fix regression on goto view blade goto click
- include `@aware` directive

## [3.0.0.35]
- completion of defined variable in php directives
- fix go to view if variable string is on new line
- include 'bladeRender' as go to blade view method

## [3.0.0.34]
- fix #90 `@error` directive parser error display

## [3.0.0.33]
- fix #89 inline css at rule coloring issue
- include `@context` directive
- include `$errors` as global variable in echo tag autocomplete

## [3.0.0.32]
- enchancement #88 hard coded click to blade view file support for : `loadView`, `send`

## [3.0.0.31]

- decl finder for arguments adiacent to new line  (#84), inertia directives (#85)

## [3.0.0.30]

- major project properties update #78 , use public properties, store custom directories and files as relative paths

## [3.0.0.29]

- fix #83 mime resolver for detecting real blade files

## [3.0.0.28]

- fix parser error warning for else blocks on directive ending in `@endif`

## [3.0.0.27]

- add spatie honeypot directive, scan for directives inside callbacks, include resource path for components, code updates on components logic

## [3.0.0.26]

- fix custom directive parse lag
## [3.0.0.25]

- include `@props` directive

## [3.0.0.24]

- fix wrong `@php` echo  syntax error

## [3.0.0.22]

- fix wrong `@empty` `@else` syntax error

## [3.0.0.21]

- fix issue #75, wrong parser error in foreach directive

## [3.0.0.20]

- using nb php parser for `@php` directive syntax check

## [3.0.0.19] - removing php syntax error checks
add some interactions to hint warnings
don't detect url parts with at (@) symbols as directives
##[3.0.0.18] - fixing @foreach wrong syntax error
##[3.0.0.17] - updating unit tests for source code
- improve lexer coloring for component attributes
##[3.0.0.1 - 3.0.0.16] - major refactoring for lexer & parser
    - custom blade components config for autocomplete & declaration finder
    - autocomplete constructor properties for blade components
##[2.5.0.8] - regression fix adjustments for directive php embedding
##[2.5.0.7] - regression fix for directive php embedding
##[2.5.0.6] - include `@when`, `@bool` directive, no more php embedding on directive parenthesis wrapping
##[2.5.0.5] -simplifying php brace matcher freeze issue for chars with ":" wrapped in brackets
##[2.5.0.4] - lexer for css at rules
##[2.5.0.3] - brace higlight for custom directive
## [2.5.0.2] 

- fix syntax highlight issue 67

## [2.5.0.1] 

- fix syntax highlight issue 66, stop completion inside php strings

## [2.5.0.0] 

**syntax highlight**

- fix IDE freeze (#65) on ternary operator, short if expr

**code completion**

- fix static method completion with namespace context

## [2.4.9.9] 

- limited go to file + completion for vite assets (#64), decl finder fixes + refactor for Php

## [2.4.9.8] 

- fix comment highlight issue (#62) in directive php expression, improvements on php namespace completion

## [2.4.9.7] 

- fix livewire component formatting, display namespace path on class method completion

## [2.4.9.6] 

- detect namespace path on directives php expression

## [2.4.9.5] 

- fix directive completion before double quote html, add attr directive to completion list

## [2.4.9.4] 

- fix issue 57 formatting with optgroup

## [2.4.9.3] 

- configurable declaration finder for view paths

## [2.4.9.1]

- fix extra `cursor` text on `@foreach` autocomplete

## [2.4.8.9]

- autotag completion is true by default 

## [2.4.8.8]

**syntax highlight**

- fix issue #61 `@endcan` breaks javascript highlight

## [2.4.8.1]

**completion**

- autocompletion for blade tags. These can be configured from Project -> Properties -> Laravel Blade

## [2.4.7.1]

**formatting**

- fix indentation for some html tags

**completion**

- move directive completion to ComplentionHandler trigger for better template insert
- add version of blade laravel for some directives 

**Package & releases**

- using github actions to do releases and nbm generation : https://github.com/haidubogdan/netbeans-php-blade-plugin/blob/main/.github/workflows/maven.yml
- deleting **nbm** folder as all versions will be available in releases

## [2.3.4.1]

**antlr parser**

- disable BuildParserTree for memory efficiency

## [2.3.2.1]

**filesystem**

- fix #53 file duplication issue with `blade.php` extension

**lexer**

- refactor

## [2.2.8.1]

**parser**

- enable empty blocks

**lexer**

- highlight fix for ':' freezing php expression

**comment**

- adjusting comment block toggle for multi emebedded tokens

## [2.2.7.2]

**lexer**

- highlight fix for ':' freezing php expression

**misc**

- fix post color highlight for directives with no argument

## [2.2.7.1]

**lexer**

- highlight fix for string content with html tags and ':' symbol for directive php expression 

**custom directives**

- declaration finder goes to the declaration of custom directive
- fixes for custom directives from multiple files

**parser**

- fix parser error message for empty can block body

**debugging**

- adding logs to measure time

## [2.2.6.1]

**completion, declaration finder**

- remove lock file on complete to avoid stuck behaviour

**completion**

- quick update to enable component completion from hardcoded paths

## [2.2.4.1]

**parser**

- cleaning tokens sent to parser to speed up parsing process [wip]

**lexer**

- optimisation for lexer tokenization
- fixing `@media` directive

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

