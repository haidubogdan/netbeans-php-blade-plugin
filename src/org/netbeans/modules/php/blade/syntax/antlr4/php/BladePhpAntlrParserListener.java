// Generated from BladePhpAntlrParser.g4 by ANTLR 4.13.0

  /**
   * Parser generated for netbeans blade editor
   * Some elements have been simplified to optimize parser speed
   * For example
   * - switch statement have a loos validation
   * - generic block statement "@isset" | "@unless" are grouped togehter
   * - the start match and end match will be checked in the parser
   */
  package org.netbeans.modules.php.blade.syntax.antlr4.php;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BladePhpAntlrParser}.
 */
public interface BladePhpAntlrParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BladePhpAntlrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(BladePhpAntlrParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladePhpAntlrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(BladePhpAntlrParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladePhpAntlrParser#exprStatement}.
	 * @param ctx the parse tree
	 */
	void enterExprStatement(BladePhpAntlrParser.ExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladePhpAntlrParser#exprStatement}.
	 * @param ctx the parse tree
	 */
	void exitExprStatement(BladePhpAntlrParser.ExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladePhpAntlrParser#staticClassReference}.
	 * @param ctx the parse tree
	 */
	void enterStaticClassReference(BladePhpAntlrParser.StaticClassReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladePhpAntlrParser#staticClassReference}.
	 * @param ctx the parse tree
	 */
	void exitStaticClassReference(BladePhpAntlrParser.StaticClassReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladePhpAntlrParser#staticMethodAccess}.
	 * @param ctx the parse tree
	 */
	void enterStaticMethodAccess(BladePhpAntlrParser.StaticMethodAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladePhpAntlrParser#staticMethodAccess}.
	 * @param ctx the parse tree
	 */
	void exitStaticMethodAccess(BladePhpAntlrParser.StaticMethodAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladePhpAntlrParser#staticFieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterStaticFieldAccess(BladePhpAntlrParser.StaticFieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladePhpAntlrParser#staticFieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitStaticFieldAccess(BladePhpAntlrParser.StaticFieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladePhpAntlrParser#directMethodAccess}.
	 * @param ctx the parse tree
	 */
	void enterDirectMethodAccess(BladePhpAntlrParser.DirectMethodAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladePhpAntlrParser#directMethodAccess}.
	 * @param ctx the parse tree
	 */
	void exitDirectMethodAccess(BladePhpAntlrParser.DirectMethodAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladePhpAntlrParser#functionExpr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpr(BladePhpAntlrParser.FunctionExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladePhpAntlrParser#functionExpr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpr(BladePhpAntlrParser.FunctionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladePhpAntlrParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(BladePhpAntlrParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladePhpAntlrParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(BladePhpAntlrParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladePhpAntlrParser#namespace}.
	 * @param ctx the parse tree
	 */
	void enterNamespace(BladePhpAntlrParser.NamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladePhpAntlrParser#namespace}.
	 * @param ctx the parse tree
	 */
	void exitNamespace(BladePhpAntlrParser.NamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladePhpAntlrParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(BladePhpAntlrParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladePhpAntlrParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(BladePhpAntlrParser.ArgumentContext ctx);
}