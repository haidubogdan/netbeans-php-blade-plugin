package org.netbeans.modules.php.blade.editor.parsing;

import java.util.LinkedList;
import java.util.List;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.ASTError;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.ASTErrorExpression;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.ArgumentExpression;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeComment;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeConditionStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeConstDirectiveStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeEchoStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeExtendsStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeForStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeForeachStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeIfStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeIncludeStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeInlineSectionStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeProgram;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeSectionStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeSwitchStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.BladeYieldStatement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.Block;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.DirectiveName;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.DirectiveWithArgument;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.Expression;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.InLineBladePhp;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.InLineHtml;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.InLinePhp;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.PathExpression;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.PhpExpression;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.SectionName;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.Statement;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.Variable;

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$ASTBladeParser$actions {
  private final ASTBladeParser parser;

  /** Constructor */
  CUP$ASTBladeParser$actions(ASTBladeParser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$ASTBladeParser$do_action(
    int                        CUP$ASTBladeParser$act_num,
    java_cup.runtime.lr_parser CUP$ASTBladeParser$parser,
    java.util.Stack            CUP$ASTBladeParser$stack,
    int                        CUP$ASTBladeParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ASTBladeParser$result;

      /* select the action based on the action number */
      switch (CUP$ASTBladeParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 50: // elseif_list ::= elseif_list T_BLADE_ELSEIF T_PHP_CONDITION_EXPRESSION inner_statement_list 
            {
              List[] RESULT =null;
		int elseifListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int elseifListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		List[] elseifList = (List[])((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int statementListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int statementListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		List statementList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    Block block = new Block(statementListleft, statementListright, statementList);
//    ((LinkedList)elseifList[0]).addFirst(condition);
    ((LinkedList)elseifList[1]).addFirst(block);

    RESULT = elseifList;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("elseif_list",13, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 49: // elseif_list ::= 
            {
              List[] RESULT =null;
		
    List listConditions = new LinkedList();
    List listStatements = new LinkedList();
    List listTokens = new LinkedList();

    List[] returnList = new List[] { listConditions, listStatements, listTokens };

    RESULT = returnList;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("elseif_list",13, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 48: // path ::= error 
            {
              Expression RESULT =null;
		int exprleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int exprright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object expr = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    RESULT = new ASTErrorExpression(exprleft, exprright);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("path",8, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 47: // path ::= T_PHP_PARAMETER_EXPRESSION 
            {
              Expression RESULT =null;
		int pathleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int pathright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object path = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
	RESULT = new PathExpression(pathleft, pathright, path.toString());

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("path",8, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 46: // path ::= T_STRING 
            {
              Expression RESULT =null;
		int pathleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int pathright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		String path = (String)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    if (path == null) {
        path = "";
    }
    else if (path.length() > 2) {
    	//remove quotes
    	path = path.substring(1, path.length() -1);
    }
	RESULT = new PathExpression(pathleft, pathright, path);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("path",8, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 45: // path_expression ::= T_OPEN_PARENTHESE path T_CLOSE_PARENTHESE 
            {
              ArgumentExpression RESULT =null;
		int oleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int oright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		Object o = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int pathleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int pathright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		Expression path = (Expression)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
	RESULT = new ArgumentExpression(path, oleft, eright );

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("path_expression",7, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // variableList ::= 
            {
              List RESULT =null;
		
    RESULT = new LinkedList();

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("variableList",3, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // variableList ::= variableList variable 
            {
              List RESULT =null;
		int statementListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int statementListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		List statementList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int varleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int varright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Variable var = (Variable)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    // Ignore null statements
    if(var != null) {
        statementList.add(var);
    }
    RESULT = statementList;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("variableList",3, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // variable ::= variable T_NEKUDA variable 
            {
              Variable RESULT =null;
		int expr1left = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int expr1right = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		Variable expr1 = (Variable)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int expr2left = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int expr2right = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Variable expr2 = (Variable)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    //we will force just one string
    String expr1Str = "";
                if (expr1 != null){
                    expr1Str = expr1.toString();
                }
    RESULT = new Variable(expr1left, expr1right, expr1Str);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("variable",11, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // variable ::= T_PHP_PARAMETER_EXPRESSION 
            {
              Variable RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int varright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object var = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		 RESULT = new Variable(varleft, varright, var.toString());  
              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("variable",11, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // variable ::= T_STRING 
            {
              Variable RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int varright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    if (var == null) {
        var = "";
    }
    else if (var.length() > 2) {
    	//remove quotes
    	var = var.substring(1, var.length() -1);
    }
    RESULT = new Variable(varleft, varright, var.toString());    

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("variable",11, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // variable ::= T_VARIABLE 
            {
              Variable RESULT =null;
		int varleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int varright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		String var = (String)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    if (var == null) {
        var = "";
    }
    RESULT = new Variable(varleft, varright, var.toString());

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("variable",11, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // yield_label ::= T_STRING 
            {
              Expression RESULT =null;
		int labelleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int labelright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		String label = (String)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    if (label == null) {
        label = "";
    } else if (label.length() > 2) {
    	//remove quotes
    	label = label.substring(1, label.length() -1);
    }
	RESULT = new SectionName(labelleft, labelright, label.toString());

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("yield_label",10, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // yield_label_expression ::= T_OPEN_PARENTHESE yield_label T_CLOSE_PARENTHESE 
            {
              ArgumentExpression RESULT =null;
		int poleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int poright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		Object po = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int labelleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int labelright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		Expression label = (Expression)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int pcleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int pcright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object pc = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    RESULT =  new ArgumentExpression(label, poleft, pcright);;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("yield_label_expression",9, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // end_section ::= T_BLADE_OVERWRITE 
            {
              Object RESULT =null;
		int tokenleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int tokenright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object token = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		 RESULT = token; 
              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("end_section",0, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // end_section ::= T_BLADE_APPEND 
            {
              Object RESULT =null;
		int tokenleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int tokenright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object token = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		 
   RESULT = token;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("end_section",0, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // end_section ::= T_BLADE_STOP 
            {
              Object RESULT =null;
		int tokenleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int tokenright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object token = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    RESULT = token;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("end_section",0, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // end_section ::= T_BLADE_SHOW 
            {
              Object RESULT =null;
		int tokenleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int tokenright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object token = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    RESULT = token;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("end_section",0, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // end_section ::= T_BLADE_ENDSECTION 
            {
              Object RESULT =null;
		int tokenleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int tokenright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object token = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		 
    RESULT = token;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("end_section",0, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // d_section_statement ::= T_BLADE_SECTION yield_label_expression inner_statement_list end_section 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int labelleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int labelright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		ArgumentExpression label = (ArgumentExpression)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int statementListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int statementListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		List statementList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    Block block = new Block(statementListleft, statementListright, statementList);
    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    RESULT = new BladeSectionStatement(dleft, endright, directive, label, block);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("d_section_statement",16, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // d_section_statement ::= T_BLADE_SECTION T_OPEN_PARENTHESE yield_label T_COMMA T_PHP_PARAMETER_EXPRESSION T_CLOSE_PARENTHESE 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).value;
		int poleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).left;
		int poright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).right;
		Object po = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).value;
		int labelleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int labelright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		Expression label = (Expression)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		Object p = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    PhpExpression phpExpression = new PhpExpression(pleft, pright,  p.toString());
    ArgumentExpression argexpr = new ArgumentExpression(phpExpression, poleft, endright, phpExpression);
    RESULT = new BladeInlineSectionStatement(dleft, endright, directive, argexpr);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("d_section_statement",16, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // directive_statement ::= d_section_statement 
            {
              Statement RESULT =null;
		int stmleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int stmright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Statement stm = (Statement)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
	RESULT = stm;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("directive_statement",14, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // statement ::= error 
            {
              Statement RESULT =null;
		int theErrorleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int theErrorright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object theError = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    ASTError error = new ASTError(theErrorleft, theErrorright);
    RESULT = error;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // statement ::= T_BLADE_COMMENT 
            {
              Statement RESULT =null;
		int commentleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int commentright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object comment = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    /* comment */
    BladeComment commentSt = new BladeComment(commentleft, commentright, comment.toString());
    RESULT = commentSt;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // statement ::= T_NEKUDA 
            {
              Statement RESULT =null;
		int htmlleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int htmlright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object html = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
	//stray element
    InLineHtml inLineHtml = new InLineHtml(htmlleft, htmlright, ":");
    RESULT = inLineHtml;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // statement ::= T_STRING 
            {
              Statement RESULT =null;
		int htmlleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int htmlright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		String html = (String)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    //unkown string
    InLineHtml inLineHtml = new InLineHtml(htmlleft, htmlright, html);
    RESULT = inLineHtml;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // statement ::= T_BLADE_INLINE_PHP 
            {
              Statement RESULT =null;
		int phpleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int phpright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object php = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    InLineBladePhp inLinePhp = new InLineBladePhp(phpleft, phpright, php.toString());
    RESULT = inLinePhp;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // statement ::= T_INLINE_PHP 
            {
              Statement RESULT =null;
		int phpleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int phpright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object php = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    InLinePhp inLinePhp = new InLinePhp(phpleft, phpright, php.toString());
    RESULT = inLinePhp;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // statement ::= T_INLINE_HTML 
            {
              Statement RESULT =null;
		int htmlleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int htmlright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object html = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    InLineHtml inLineHtml = new InLineHtml(htmlleft, htmlright, html.toString());
    RESULT = inLineHtml;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // statement ::= T_BLADE_OPEN_ECHO T_BLADE_PHP_ECHO T_BLADE_CLOSE_ECHO 
            {
              Statement RESULT =null;
		int tokenleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int tokenright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		Object token = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int phpleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int phpright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		Object php = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    Expression expr = new PhpExpression(phpleft, phpright, php.toString());
    RESULT = new BladeEchoStatement(tokenleft, endright, token.toString(), expr);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // statement ::= T_BLADE_DIRECTIVE 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    RESULT = new BladeConstDirectiveStatement(dleft, dright, directive);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // statement ::= T_BLADE_DIRECTIVE T_OPEN_PARENTHESE T_PHP_PARAMETER_EXPRESSION T_CLOSE_PARENTHESE 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int exprleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int exprright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		Object expr = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		
	//TODO store expression expression
    //directive statement with arguments
    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    PhpExpression phpExpression = new PhpExpression(exprleft, exprright, expr.toString());
    ArgumentExpression argexpr = new ArgumentExpression(phpExpression, exprleft, exprright);
    RESULT = new DirectiveWithArgument(dleft, exprright, directive, argexpr);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // statement ::= T_BLADE_SWITCH T_OPEN_PARENTHESE T_PHP_PARAMETER_EXPRESSION T_CLOSE_PARENTHESE inner_statement_list T_BLADE_ENDSWITCH 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).value;
		int poleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).left;
		int poright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).right;
		Object po = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).value;
		int exprleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int exprright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		Object expr = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int pcleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int pcright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		Object pc = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int statementListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int statementListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		List statementList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    Block block = new Block(statementListleft, statementListright, statementList);
    PhpExpression phpExpression = new PhpExpression(exprleft, exprright, expr.toString());
    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    ArgumentExpression argexpr = new ArgumentExpression(phpExpression, poleft, pcright);
    RESULT = new BladeSwitchStatement(dleft, endright, directive, argexpr, block);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // statement ::= T_BLADE_CONDITION_OPEN_TAG T_PHP_CONDITION_EXPRESSION inner_statement_list T_BLADE_ENDIF 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int exprleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int exprright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		Object expr = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int statementListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int statementListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		List statementList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    Block block = new Block(statementListleft, statementListright, statementList);
    PhpExpression phpExpression = new PhpExpression(exprleft, exprright, expr.toString());
    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    ArgumentExpression argexpr = new ArgumentExpression(phpExpression, exprleft, exprright);
    RESULT = new BladeConditionStatement(dleft, endright, directive, argexpr, block);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // statement ::= T_BLADE_IF T_PHP_CONDITION_EXPRESSION inner_statement_list elseif_list T_BLADE_ENDIF 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int statementListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int statementListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		List statementList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int elseifleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int elseifright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		List[] elseif = (List[])((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		

	for (int i=0 ; i < elseif[0].size() ; i++) {
			//TODO add a else logic
        //int debug = 3;
    }

    Block block = new Block(statementListleft, statementListright, statementList);
    PhpExpression ifExpr = new PhpExpression(sleft, sright, s.toString());
    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    ArgumentExpression expr = new ArgumentExpression(ifExpr, sleft, sright);
    RESULT = new BladeIfStatement(dleft, endright, directive, expr, block);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // statement ::= T_BLADE_FOR T_PHP_LOOP_EXPRESSION inner_statement_list T_BLADE_ENDFOR 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int statementListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int statementListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		List statementList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    Block block = new Block(statementListleft, statementListright, statementList);
    PhpExpression loopExpr = new PhpExpression(sleft, sright, s.toString());
    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    ArgumentExpression expr = new ArgumentExpression(loopExpr, sleft, sright);
    RESULT = new BladeForStatement(dleft, endright, directive, expr, block);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // statement ::= T_BLADE_FOREACH T_PHP_LOOP_EXPRESSION inner_statement_list T_BLADE_ENDFOREACH 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		Object s = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int statementListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int statementListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		List statementList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    Block block = new Block(statementListleft, statementListright, statementList);
    PhpExpression loopExpr = new PhpExpression(sleft, sright, s.toString());
    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    ArgumentExpression expr = new ArgumentExpression(loopExpr, sleft, sright);
    RESULT = new BladeForeachStatement(dleft, endright, directive, expr, block);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // statement ::= T_BLADE_INCLUDE T_OPEN_PARENTHESE variableList T_COMMA T_PHP_PARAMETER_EXPRESSION T_CLOSE_PARENTHESE 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).value;
		int poleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).left;
		int poright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).right;
		Object po = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).value;
		int varListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int varListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		List varList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		Object p = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    String strPath = "";
    String strV = "";
    Object v;
    for (int i=0 ; i < varList.size() ; i++) {
        
        v = varList.get(i);
        if (v instanceof String){
            //stop at first string
            strPath = (String) v;
            break;
        }
    }
    PathExpression label = new PathExpression(varListleft, varListright, strPath);
    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    Variable parameter = new Variable(0, 1, strV);
    ArgumentExpression expr = new ArgumentExpression(label, poleft, endright, parameter);
    RESULT = new BladeIncludeStatement(dleft, endright, directive, expr);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // statement ::= T_BLADE_INCLUDE T_OPEN_PARENTHESE variableList T_CLOSE_PARENTHESE 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int poleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int poright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		Object po = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int varListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int varListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		List varList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
	String strPath = "";
    
    Object v;
    for (int i=0 ; i < varList.size() ; i++) {
        
        v = varList.get(i);
        if (v instanceof String){
            //stop at first string
            strPath = (String) v;
            break;
        }
    }

    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    PathExpression label = new PathExpression(varListleft, varListright, strPath);
    ArgumentExpression expr = new ArgumentExpression(label, poleft, endright);
    RESULT = new BladeIncludeStatement(dleft, endright, directive, expr);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // statement ::= T_BLADE_YIELD T_OPEN_PARENTHESE yield_label T_COMMA T_PHP_PARAMETER_EXPRESSION T_CLOSE_PARENTHESE 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).value;
		int poleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).left;
		int poright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).right;
		Object po = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		Expression s = (Expression)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		Object p = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    String strPath = "";
    if (s != null){
        strPath = s.toString();
    }
    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    SectionName label = new SectionName(sleft, sright, strPath);
    ArgumentExpression expr = new ArgumentExpression(label, poleft, endright);
    RESULT = new BladeYieldStatement(dleft, endright, directive, expr);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // statement ::= T_BLADE_YIELD T_OPEN_PARENTHESE yield_label T_CLOSE_PARENTHESE 
            {
              Statement RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int poleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).left;
		int poright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).right;
		Object po = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		Expression s = (Expression)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    String strPath = "";
    if (s != null){
        strPath = s.toString();
    }
    //to be refactored to handle parameter directly

    DirectiveName directive = new DirectiveName(dleft, dright, d.toString());
    SectionName label = new SectionName(sleft, sright, strPath);
    ArgumentExpression expr = new ArgumentExpression(label, poleft, endright);
    RESULT = new BladeYieldStatement(dleft, endright, directive, expr);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // statement ::= T_BLADE_EXTENDS T_OPEN_PARENTHESE variable T_COMMA T_PHP_PARAMETER_EXPRESSION T_CLOSE_PARENTHESE 
            {
              Statement RESULT =null;
		int extsleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).left;
		int extsright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).right;
		Object exts = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)).value;
		int poleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).left;
		int poright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).right;
		Object po = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-4)).value;
		int pathleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).left;
		int pathright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).right;
		Variable path = (Variable)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-3)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		Object p = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int endleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int endright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Object end = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    //for the moment until we find to make use of <<EOL>>
    Block block = null;
    PhpExpression parameter = new PhpExpression(pleft, pright, p.toString());
    DirectiveName directive = new DirectiveName(extsleft, extsright, exts.toString());
    ArgumentExpression expr = new ArgumentExpression(path, poleft, endright, parameter);
    RESULT = new BladeExtendsStatement(extsleft, endright, directive, expr, block);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-5)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // statement ::= T_BLADE_EXTENDS path_expression 
            {
              Statement RESULT =null;
		int extsleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int extsright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		Object exts = (Object)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int pathleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int pathright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		ArgumentExpression path = (ArgumentExpression)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    //for the moment until we find to make use of <<EOL>>
    Block block = null;
    DirectiveName directive = new DirectiveName(extsleft, extsright, exts.toString());
    RESULT = new BladeExtendsStatement(extsleft, pathright, directive, path, block);

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // statement ::= directive_statement 
            {
              Statement RESULT =null;
		int stmleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int stmright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Statement stm = (Statement)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
	RESULT = stm;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("statement",5, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // top_statement ::= statement 
            {
              Statement RESULT =null;
		int statementleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int statementright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Statement statement = (Statement)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    RESULT = statement;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("top_statement",4, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // inner_statement_list ::= 
            {
              List RESULT =null;
		
    RESULT = new LinkedList();

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("inner_statement_list",6, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // inner_statement_list ::= inner_statement_list top_statement 
            {
              List RESULT =null;
		int statementListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int statementListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		List statementList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int statementleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int statementright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Statement statement = (Statement)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    // Ignore null statements
    if(statement != null) {
        statementList.add(statement);
    }
    RESULT = statementList;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("inner_statement_list",6, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // top_statement_list ::= 
            {
              List RESULT =null;
		
    RESULT = new LinkedList();

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("top_statement_list",2, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // top_statement_list ::= top_statement_list top_statement 
            {
              List RESULT =null;
		int sListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int sListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		List sList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		int statementleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int statementright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		Statement statement = (Statement)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    //check for extends
    if(statement != null) {
        sList.add(statement);
    }
    RESULT = sList;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("top_statement_list",2, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= thestart EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).right;
		BladeProgram start_val = (BladeProgram)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)).value;
		RESULT = start_val;
              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.elementAt(CUP$ASTBladeParser$top-1)), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ASTBladeParser$parser.done_parsing();
          return CUP$ASTBladeParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // thestart ::= top_statement_list 
            {
              BladeProgram RESULT =null;
		int statementListleft = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).left;
		int statementListright = ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()).right;
		List statementList = (List)((java_cup.runtime.Symbol) CUP$ASTBladeParser$stack.peek()).value;
		
    ASTBladeScanner bladeAstLexer = (ASTBladeScanner) parser.getScanner();
    int endOfProgram = statementListright > bladeAstLexer.getWhitespaceEndPosition() ? statementListright : bladeAstLexer.getWhitespaceEndPosition();
    BladeProgram program = new BladeProgram(statementListleft, endOfProgram, statementList, bladeAstLexer.getPhpParserResult());
    RESULT = program;

              CUP$ASTBladeParser$result = parser.getSymbolFactory().newSymbol("thestart",1, ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$ASTBladeParser$stack.peek()), RESULT);
            }
          return CUP$ASTBladeParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}
