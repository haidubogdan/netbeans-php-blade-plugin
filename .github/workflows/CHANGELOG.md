# Change Log

## What's changed

**major refactor**

In order to have a better maintenance of the embedded php syntax actions (autocomplete, declaration finder), I've created a new parser to handle this action.
Although it would have been better to use the existing **Netbeans PHP module parser**, it's inclusion in the plugin is quite difficult.
Blade template has a lot of extracted syntax.  

- the lexer & parsers based on antlr syntax have been separated to cover sepparate responsibility
    - coloring lexer (already exists, refactored to use the lexer grouping action & to try to fix embedding issues)
    - blade parser lexer (already exists, limited to directives & basic php syntax)
    - php parser lexer (new, used to identify variables, class elements, class methods, functions etc...)

**components folder support**

For each project you can store paths to the components class implementation to help with autocomplete & declaration finder.
The configuration is found under : "Project properties -> Laravel blade -> Blade Components Config"

**wip php syntax hints**

Editor -> Hints -> Blade -> Php Syntax error.

For the moment not reliable