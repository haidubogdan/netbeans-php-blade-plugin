// Generated from java-escape by ANTLR 4.11.1

  package org.netbeans.modules.php.blade.syntax.antlr4.formatter;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BladeAntlrFormatterParser}.
 */
public interface BladeAntlrFormatterParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BladeAntlrFormatterParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(BladeAntlrFormatterParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrFormatterParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(BladeAntlrFormatterParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrFormatterParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BladeAntlrFormatterParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrFormatterParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BladeAntlrFormatterParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrFormatterParser#indetable_element}.
	 * @param ctx the parse tree
	 */
	void enterIndetable_element(BladeAntlrFormatterParser.Indetable_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrFormatterParser#indetable_element}.
	 * @param ctx the parse tree
	 */
	void exitIndetable_element(BladeAntlrFormatterParser.Indetable_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrFormatterParser#html_indent}.
	 * @param ctx the parse tree
	 */
	void enterHtml_indent(BladeAntlrFormatterParser.Html_indentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrFormatterParser#html_indent}.
	 * @param ctx the parse tree
	 */
	void exitHtml_indent(BladeAntlrFormatterParser.Html_indentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrFormatterParser#block_start}.
	 * @param ctx the parse tree
	 */
	void enterBlock_start(BladeAntlrFormatterParser.Block_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrFormatterParser#block_start}.
	 * @param ctx the parse tree
	 */
	void exitBlock_start(BladeAntlrFormatterParser.Block_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrFormatterParser#block_directive_name}.
	 * @param ctx the parse tree
	 */
	void enterBlock_directive_name(BladeAntlrFormatterParser.Block_directive_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrFormatterParser#block_directive_name}.
	 * @param ctx the parse tree
	 */
	void exitBlock_directive_name(BladeAntlrFormatterParser.Block_directive_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrFormatterParser#block_end}.
	 * @param ctx the parse tree
	 */
	void enterBlock_end(BladeAntlrFormatterParser.Block_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrFormatterParser#block_end}.
	 * @param ctx the parse tree
	 */
	void exitBlock_end(BladeAntlrFormatterParser.Block_endContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrFormatterParser#inline_identable_element}.
	 * @param ctx the parse tree
	 */
	void enterInline_identable_element(BladeAntlrFormatterParser.Inline_identable_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrFormatterParser#inline_identable_element}.
	 * @param ctx the parse tree
	 */
	void exitInline_identable_element(BladeAntlrFormatterParser.Inline_identable_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrFormatterParser#nl_with_space_before}.
	 * @param ctx the parse tree
	 */
	void enterNl_with_space_before(BladeAntlrFormatterParser.Nl_with_space_beforeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrFormatterParser#nl_with_space_before}.
	 * @param ctx the parse tree
	 */
	void exitNl_with_space_before(BladeAntlrFormatterParser.Nl_with_space_beforeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrFormatterParser#nl_with_space}.
	 * @param ctx the parse tree
	 */
	void enterNl_with_space(BladeAntlrFormatterParser.Nl_with_spaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrFormatterParser#nl_with_space}.
	 * @param ctx the parse tree
	 */
	void exitNl_with_space(BladeAntlrFormatterParser.Nl_with_spaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrFormatterParser#static_element}.
	 * @param ctx the parse tree
	 */
	void enterStatic_element(BladeAntlrFormatterParser.Static_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrFormatterParser#static_element}.
	 * @param ctx the parse tree
	 */
	void exitStatic_element(BladeAntlrFormatterParser.Static_elementContext ctx);
}