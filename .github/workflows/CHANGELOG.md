# Change Log

## What's changed

**directives**

- issue #72 include `@when`, `@bool` directives

**coloring lexer**

- directive wrapper parenteshis are no longer php embedded to fix php embedding from trying to automatically close quotes

```
@test('my_text')\new line
```