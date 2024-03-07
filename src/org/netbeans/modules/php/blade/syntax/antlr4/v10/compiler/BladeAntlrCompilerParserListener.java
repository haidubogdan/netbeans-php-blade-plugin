// Generated from java-escape by ANTLR 4.11.1

  /**
   * Parser generated for netbeans blade editor
   * Some elements have been simplified to optimize parser speed
   * For example
   * - switch statement have a loos validation
   * - generic block statement "@isset" | "@unless" are grouped togehter
   * - the start match and end match will be checked in the parser
   */
  package org.netbeans.modules.php.blade.syntax.antlr4.v10.compiler;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BladeAntlrCompilerParser}.
 */
public interface BladeAntlrCompilerParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(BladeAntlrCompilerParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(BladeAntlrCompilerParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#general_statement}.
	 * @param ctx the parse tree
	 */
	void enterGeneral_statement(BladeAntlrCompilerParser.General_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#general_statement}.
	 * @param ctx the parse tree
	 */
	void exitGeneral_statement(BladeAntlrCompilerParser.General_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock_statement(BladeAntlrCompilerParser.Block_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock_statement(BladeAntlrCompilerParser.Block_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#php_blade}.
	 * @param ctx the parse tree
	 */
	void enterPhp_blade(BladeAntlrCompilerParser.Php_bladeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#php_blade}.
	 * @param ctx the parse tree
	 */
	void exitPhp_blade(BladeAntlrCompilerParser.Php_bladeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#php_blade_code}.
	 * @param ctx the parse tree
	 */
	void enterPhp_blade_code(BladeAntlrCompilerParser.Php_blade_codeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#php_blade_code}.
	 * @param ctx the parse tree
	 */
	void exitPhp_blade_code(BladeAntlrCompilerParser.Php_blade_codeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrCompilerParser#php_inline}.
	 * @param ctx the parse tree
	 */
	void enterPhp_inline(BladeAntlrCompilerParser.Php_inlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrCompilerParser#php_inline}.
	 * @param ctx the parse tree
	 */
	void exitPhp_inline(BladeAntlrCompilerParser.Php_inlineContext ctx);
}