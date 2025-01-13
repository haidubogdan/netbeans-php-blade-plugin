# Change Log

## What's changed

**Source code unit tests**

As some netbeans platform utility classes (CslTestBase) are not available for stand-alone plugins. This proved to be a little challenge.

- added unit tests for parsing, braces & navigator

**Syntax highlighting**

- improved syntax highlighting for component attributes values

- fix `@foreach` wrong parser error

```
    @foreach ($array->task as $el)

    @endforeach
```