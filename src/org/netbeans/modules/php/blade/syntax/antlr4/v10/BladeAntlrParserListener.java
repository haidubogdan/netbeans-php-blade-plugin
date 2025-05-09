// Generated from BladeAntlrParser.g4 by ANTLR 4.13.2

 /*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
  package org.netbeans.modules.php.blade.syntax.antlr4.v10;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BladeAntlrParser}.
 */
public interface BladeAntlrParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(BladeAntlrParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(BladeAntlrParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BladeAntlrParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BladeAntlrParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#blockDirective}.
	 * @param ctx the parse tree
	 */
	void enterBlockDirective(BladeAntlrParser.BlockDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#blockDirective}.
	 * @param ctx the parse tree
	 */
	void exitBlockDirective(BladeAntlrParser.BlockDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(BladeAntlrParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(BladeAntlrParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#foreachStatement}.
	 * @param ctx the parse tree
	 */
	void enterForeachStatement(BladeAntlrParser.ForeachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#foreachStatement}.
	 * @param ctx the parse tree
	 */
	void exitForeachStatement(BladeAntlrParser.ForeachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(BladeAntlrParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(BladeAntlrParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#forElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterForElseStatement(BladeAntlrParser.ForElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#forElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitForElseStatement(BladeAntlrParser.ForElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#ifStartStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStartStatement(BladeAntlrParser.IfStartStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#ifStartStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStartStatement(BladeAntlrParser.IfStartStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#elseifStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseifStatement(BladeAntlrParser.ElseifStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#elseifStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseifStatement(BladeAntlrParser.ElseifStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(BladeAntlrParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(BladeAntlrParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#bladePhpBlock}.
	 * @param ctx the parse tree
	 */
	void enterBladePhpBlock(BladeAntlrParser.BladePhpBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#bladePhpBlock}.
	 * @param ctx the parse tree
	 */
	void exitBladePhpBlock(BladeAntlrParser.BladePhpBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#inlineDirective}.
	 * @param ctx the parse tree
	 */
	void enterInlineDirective(BladeAntlrParser.InlineDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#inlineDirective}.
	 * @param ctx the parse tree
	 */
	void exitInlineDirective(BladeAntlrParser.InlineDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#identifiableArgDirective}.
	 * @param ctx the parse tree
	 */
	void enterIdentifiableArgDirective(BladeAntlrParser.IdentifiableArgDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#identifiableArgDirective}.
	 * @param ctx the parse tree
	 */
	void exitIdentifiableArgDirective(BladeAntlrParser.IdentifiableArgDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#multipleArgDirective}.
	 * @param ctx the parse tree
	 */
	void enterMultipleArgDirective(BladeAntlrParser.MultipleArgDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#multipleArgDirective}.
	 * @param ctx the parse tree
	 */
	void exitMultipleArgDirective(BladeAntlrParser.MultipleArgDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#blockIdentifiableArgDirective}.
	 * @param ctx the parse tree
	 */
	void enterBlockIdentifiableArgDirective(BladeAntlrParser.BlockIdentifiableArgDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#blockIdentifiableArgDirective}.
	 * @param ctx the parse tree
	 */
	void exitBlockIdentifiableArgDirective(BladeAntlrParser.BlockIdentifiableArgDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#directiveWithArg}.
	 * @param ctx the parse tree
	 */
	void enterDirectiveWithArg(BladeAntlrParser.DirectiveWithArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#directiveWithArg}.
	 * @param ctx the parse tree
	 */
	void exitDirectiveWithArg(BladeAntlrParser.DirectiveWithArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#customDirective}.
	 * @param ctx the parse tree
	 */
	void enterCustomDirective(BladeAntlrParser.CustomDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#customDirective}.
	 * @param ctx the parse tree
	 */
	void exitCustomDirective(BladeAntlrParser.CustomDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#loopBreaks}.
	 * @param ctx the parse tree
	 */
	void enterLoopBreaks(BladeAntlrParser.LoopBreaksContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#loopBreaks}.
	 * @param ctx the parse tree
	 */
	void exitLoopBreaks(BladeAntlrParser.LoopBreaksContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#formStatements}.
	 * @param ctx the parse tree
	 */
	void enterFormStatements(BladeAntlrParser.FormStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#formStatements}.
	 * @param ctx the parse tree
	 */
	void exitFormStatements(BladeAntlrParser.FormStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#authStatements}.
	 * @param ctx the parse tree
	 */
	void enterAuthStatements(BladeAntlrParser.AuthStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#authStatements}.
	 * @param ctx the parse tree
	 */
	void exitAuthStatements(BladeAntlrParser.AuthStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#bladeContentTags}.
	 * @param ctx the parse tree
	 */
	void enterBladeContentTags(BladeAntlrParser.BladeContentTagsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#bladeContentTags}.
	 * @param ctx the parse tree
	 */
	void exitBladeContentTags(BladeAntlrParser.BladeContentTagsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#bladeRawTags}.
	 * @param ctx the parse tree
	 */
	void enterBladeRawTags(BladeAntlrParser.BladeRawTagsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#bladeRawTags}.
	 * @param ctx the parse tree
	 */
	void exitBladeRawTags(BladeAntlrParser.BladeRawTagsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#errorDirectives}.
	 * @param ctx the parse tree
	 */
	void enterErrorDirectives(BladeAntlrParser.ErrorDirectivesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#errorDirectives}.
	 * @param ctx the parse tree
	 */
	void exitErrorDirectives(BladeAntlrParser.ErrorDirectivesContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#directiveArguments}.
	 * @param ctx the parse tree
	 */
	void enterDirectiveArguments(BladeAntlrParser.DirectiveArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#directiveArguments}.
	 * @param ctx the parse tree
	 */
	void exitDirectiveArguments(BladeAntlrParser.DirectiveArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#foreachLoopArguments}.
	 * @param ctx the parse tree
	 */
	void enterForeachLoopArguments(BladeAntlrParser.ForeachLoopArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#foreachLoopArguments}.
	 * @param ctx the parse tree
	 */
	void exitForeachLoopArguments(BladeAntlrParser.ForeachLoopArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#phpInline}.
	 * @param ctx the parse tree
	 */
	void enterPhpInline(BladeAntlrParser.PhpInlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#phpInline}.
	 * @param ctx the parse tree
	 */
	void exitPhpInline(BladeAntlrParser.PhpInlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link BladeAntlrParser#htmlComponentOpenTag}.
	 * @param ctx the parse tree
	 */
	void enterHtmlComponentOpenTag(BladeAntlrParser.HtmlComponentOpenTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link BladeAntlrParser#htmlComponentOpenTag}.
	 * @param ctx the parse tree
	 */
	void exitHtmlComponentOpenTag(BladeAntlrParser.HtmlComponentOpenTagContext ctx);
}