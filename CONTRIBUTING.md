# Contributing Guidelines

For the moment knwoledge of Netbeans plugin code and java are necessary.

## Antlr

You will need to have **antrl** configured on your OS. [Antlr](https://www.antlr.org/)

To compile the parser and lexer you have to run separetly :

```bash
ant generate-antlr-parser
```

## Unit Testing troubleshooting

Might need to add the following env option for *Java* if you have transient java exception

```bash
JAVA_TOOL_OPTIONS=--add-opens=java.prefs/java.util.prefs=ALL-UNNAMED --add-opens=java.base/java.net=ALL-UNNAMED --add-opens=java.desktop/javax.swing=ALL-UNNAMED --add-opens=java.base/java.lang.invoke=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.desktop/javax.swing.text=ALL-UNNAMED
```