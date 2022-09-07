java -jar java-cup-11a.jar -symbols ASTBladeSymbols -parser ASTBladeParser ASTBladeParser.cup
cp ASTBladeSymbols.java ../src/org/netbeans/modules/php/blade/editor/parsing/ASTBladeSymbols.java
echo "ASTBladeSymbols copied"
