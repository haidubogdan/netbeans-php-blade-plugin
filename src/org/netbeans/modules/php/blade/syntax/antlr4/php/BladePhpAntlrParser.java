// Generated from BladePhpAntlrParser.g4 by ANTLR 4.13.1

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
  package org.netbeans.modules.php.blade.syntax.antlr4.php;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BladePhpAntlrParser extends ParserAdaptor {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HTML=1, BLADE_COMMENT=2, LINE_COMMENT=3, ARRAY=4, AS=5, ECHO=6, IF=7, 
		ELSEIF=8, ELSE=9, NEW=10, CLASS=11, FUNCTION=12, LANG_CONSTRUCT=13, MATCH=14, 
		FOREACH=15, COMMA=16, LPAREN=17, RPAREN=18, LSQUAREBRACKET=19, RSQUAREBRACKET=20, 
		LCURLYBRACE=21, RCURLYBRACE=22, IDENTIFIER=23, PHP_VARIABLE=24, DOLLAR=25, 
		NAMESPACE_SEPARATOR=26, DOUBLE_COLON=27, ARROW=28, OBJECT_OPERATOR=29, 
		SEMI_COLON=30, COMPARISON_OPERATOR=31, EQ=32, LOGICAL_UNION_OPERATOR=33, 
		STRING_LITERAL=34, STYLE_COMMENT=35, WS=36, PHP_DIRECTIVE=37, OTHER=38, 
		BLADE_COMMENT_START=39, EMAIL_SUBSTRING=40, VERSION_WITH_AT=41, BLADE_COMMENT_END=42, 
		BLADE_COMMENT_PEEK=43, BLADE_COMMENT_MORE=44, BLADE_COMMENT_EOF=45;
	public static final int
		RULE_expression = 0, RULE_exprStatement = 1, RULE_logicalStatement = 2, 
		RULE_ifStatement = 3, RULE_inputExpr = 4, RULE_functionalExpr = 5, RULE_classExpression = 6, 
		RULE_foreachDirectiveStatement = 7, RULE_foreachArguments = 8, RULE_classInstanceStatement = 9, 
		RULE_matchStatement = 10, RULE_staticClassReference = 11, RULE_staticMethodAccess = 12, 
		RULE_staticFieldAccess = 13, RULE_staticAccess = 14, RULE_aliasDirectAccess = 15, 
		RULE_classMember = 16, RULE_directMethodAccess = 17, RULE_directAccess = 18, 
		RULE_functionExpr = 19, RULE_arguments = 20, RULE_namespace = 21, RULE_argument = 22, 
		RULE_array = 23, RULE_array_key_item = 24, RULE_array_child = 25, RULE_varExpr = 26, 
		RULE_misc = 27, RULE_varDefinition = 28, RULE_output = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "exprStatement", "logicalStatement", "ifStatement", "inputExpr", 
			"functionalExpr", "classExpression", "foreachDirectiveStatement", "foreachArguments", 
			"classInstanceStatement", "matchStatement", "staticClassReference", "staticMethodAccess", 
			"staticFieldAccess", "staticAccess", "aliasDirectAccess", "classMember", 
			"directMethodAccess", "directAccess", "functionExpr", "arguments", "namespace", 
			"argument", "array", "array_key_item", "array_child", "varExpr", "misc", 
			"varDefinition", "output"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'array'", "'as'", "'echo'", "'if'", null, "'else'", 
			"'new'", "'class'", "'function'", null, "'match'", "'foreach'", "','", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", null, null, "'$'", "'\\'", 
			"'::'", "'=>'", "'->'", "';'", null, "'='", null, null, null, null, null, 
			null, "'{{--'", null, null, "'--}}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HTML", "BLADE_COMMENT", "LINE_COMMENT", "ARRAY", "AS", "ECHO", 
			"IF", "ELSEIF", "ELSE", "NEW", "CLASS", "FUNCTION", "LANG_CONSTRUCT", 
			"MATCH", "FOREACH", "COMMA", "LPAREN", "RPAREN", "LSQUAREBRACKET", "RSQUAREBRACKET", 
			"LCURLYBRACE", "RCURLYBRACE", "IDENTIFIER", "PHP_VARIABLE", "DOLLAR", 
			"NAMESPACE_SEPARATOR", "DOUBLE_COLON", "ARROW", "OBJECT_OPERATOR", "SEMI_COLON", 
			"COMPARISON_OPERATOR", "EQ", "LOGICAL_UNION_OPERATOR", "STRING_LITERAL", 
			"STYLE_COMMENT", "WS", "PHP_DIRECTIVE", "OTHER", "BLADE_COMMENT_START", 
			"EMAIL_SUBSTRING", "VERSION_WITH_AT", "BLADE_COMMENT_END", "BLADE_COMMENT_PEEK", 
			"BLADE_COMMENT_MORE", "BLADE_COMMENT_EOF"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "BladePhpAntlrParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BladePhpAntlrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BladePhpAntlrParser.EOF, 0); }
		public List<ExprStatementContext> exprStatement() {
			return getRuleContexts(ExprStatementContext.class);
		}
		public ExprStatementContext exprStatement(int i) {
			return getRuleContext(ExprStatementContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(60);
					exprStatement();
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(66);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprStatementContext extends ParserRuleContext {
		public TerminalNode SEMI_COLON() { return getToken(BladePhpAntlrParser.SEMI_COLON, 0); }
		public TerminalNode LCURLYBRACE() { return getToken(BladePhpAntlrParser.LCURLYBRACE, 0); }
		public TerminalNode RCURLYBRACE() { return getToken(BladePhpAntlrParser.RCURLYBRACE, 0); }
		public List<ExprStatementContext> exprStatement() {
			return getRuleContexts(ExprStatementContext.class);
		}
		public ExprStatementContext exprStatement(int i) {
			return getRuleContext(ExprStatementContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(BladePhpAntlrParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BladePhpAntlrParser.RPAREN, 0); }
		public TerminalNode COMPARISON_OPERATOR() { return getToken(BladePhpAntlrParser.COMPARISON_OPERATOR, 0); }
		public TerminalNode LOGICAL_UNION_OPERATOR() { return getToken(BladePhpAntlrParser.LOGICAL_UNION_OPERATOR, 0); }
		public List<FunctionalExprContext> functionalExpr() {
			return getRuleContexts(FunctionalExprContext.class);
		}
		public FunctionalExprContext functionalExpr(int i) {
			return getRuleContext(FunctionalExprContext.class,i);
		}
		public TerminalNode FOREACH() { return getToken(BladePhpAntlrParser.FOREACH, 0); }
		public ForeachArgumentsContext foreachArguments() {
			return getRuleContext(ForeachArgumentsContext.class,0);
		}
		public VarDefinitionContext varDefinition() {
			return getRuleContext(VarDefinitionContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForeachDirectiveStatementContext foreachDirectiveStatement() {
			return getRuleContext(ForeachDirectiveStatementContext.class,0);
		}
		public OutputContext output() {
			return getRuleContext(OutputContext.class,0);
		}
		public MiscContext misc() {
			return getRuleContext(MiscContext.class,0);
		}
		public ExprStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterExprStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitExprStatement(this);
		}
	}

	public final ExprStatementContext exprStatement() throws RecognitionException {
		ExprStatementContext _localctx = new ExprStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exprStatement);
		try {
			int _alt;
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(SEMI_COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(LCURLYBRACE);
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(70);
						exprStatement();
						}
						} 
					}
					setState(75);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				setState(76);
				match(RCURLYBRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				match(LPAREN);
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(78);
						exprStatement();
						}
						} 
					}
					setState(83);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(84);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				match(COMPARISON_OPERATOR);
				setState(86);
				exprStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				match(LOGICAL_UNION_OPERATOR);
				setState(89); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(88);
						functionalExpr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(91); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(93);
				match(FOREACH);
				setState(94);
				match(LPAREN);
				setState(95);
				foreachArguments();
				setState(96);
				match(RPAREN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(98);
				varDefinition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(99);
				functionalExpr();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(100);
				ifStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(101);
				foreachDirectiveStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(102);
				output();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(103);
				misc();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalStatementContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BladePhpAntlrParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BladePhpAntlrParser.RPAREN, 0); }
		public List<FunctionalExprContext> functionalExpr() {
			return getRuleContexts(FunctionalExprContext.class);
		}
		public FunctionalExprContext functionalExpr(int i) {
			return getRuleContext(FunctionalExprContext.class,i);
		}
		public List<TerminalNode> LOGICAL_UNION_OPERATOR() { return getTokens(BladePhpAntlrParser.LOGICAL_UNION_OPERATOR); }
		public TerminalNode LOGICAL_UNION_OPERATOR(int i) {
			return getToken(BladePhpAntlrParser.LOGICAL_UNION_OPERATOR, i);
		}
		public List<TerminalNode> COMPARISON_OPERATOR() { return getTokens(BladePhpAntlrParser.COMPARISON_OPERATOR); }
		public TerminalNode COMPARISON_OPERATOR(int i) {
			return getToken(BladePhpAntlrParser.COMPARISON_OPERATOR, i);
		}
		public LogicalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterLogicalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitLogicalStatement(this);
		}
	}

	public final LogicalStatementContext logicalStatement() throws RecognitionException {
		LogicalStatementContext _localctx = new LogicalStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_logicalStatement);
		int _la;
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(LPAREN);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17843119120L) != 0)) {
					{
					{
					setState(107);
					functionalExpr();
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(113);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				functionalExpr();
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(115);
					match(LOGICAL_UNION_OPERATOR);
					setState(116);
					functionalExpr();
					}
					}
					setState(119); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LOGICAL_UNION_OPERATOR );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				functionalExpr();
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(122);
					match(COMPARISON_OPERATOR);
					setState(123);
					functionalExpr();
					}
					}
					setState(126); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMPARISON_OPERATOR );
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				functionalExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(BladePhpAntlrParser.IF, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(BladePhpAntlrParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(BladePhpAntlrParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(BladePhpAntlrParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(BladePhpAntlrParser.RPAREN, i);
		}
		public List<TerminalNode> LCURLYBRACE() { return getTokens(BladePhpAntlrParser.LCURLYBRACE); }
		public TerminalNode LCURLYBRACE(int i) {
			return getToken(BladePhpAntlrParser.LCURLYBRACE, i);
		}
		public List<TerminalNode> RCURLYBRACE() { return getTokens(BladePhpAntlrParser.RCURLYBRACE); }
		public TerminalNode RCURLYBRACE(int i) {
			return getToken(BladePhpAntlrParser.RCURLYBRACE, i);
		}
		public List<LogicalStatementContext> logicalStatement() {
			return getRuleContexts(LogicalStatementContext.class);
		}
		public LogicalStatementContext logicalStatement(int i) {
			return getRuleContext(LogicalStatementContext.class,i);
		}
		public List<ExprStatementContext> exprStatement() {
			return getRuleContexts(ExprStatementContext.class);
		}
		public ExprStatementContext exprStatement(int i) {
			return getRuleContext(ExprStatementContext.class,i);
		}
		public List<TerminalNode> ELSEIF() { return getTokens(BladePhpAntlrParser.ELSEIF); }
		public TerminalNode ELSEIF(int i) {
			return getToken(BladePhpAntlrParser.ELSEIF, i);
		}
		public TerminalNode ELSE() { return getToken(BladePhpAntlrParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(IF);
			setState(132);
			match(LPAREN);
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				logicalStatement();
				}
				}
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17843250192L) != 0) );
			setState(138);
			match(RPAREN);
			setState(139);
			match(LCURLYBRACE);
			setState(143);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(140);
					exprStatement();
					}
					} 
				}
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(146);
			match(RCURLYBRACE);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(147);
					match(ELSEIF);
					setState(148);
					match(LPAREN);
					setState(150); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(149);
						logicalStatement();
						}
						}
						setState(152); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17843250192L) != 0) );
					setState(154);
					match(RPAREN);
					setState(155);
					match(LCURLYBRACE);
					setState(159);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(156);
							exprStatement();
							}
							} 
						}
						setState(161);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					}
					setState(162);
					match(RCURLYBRACE);
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(169);
				match(ELSE);
				setState(170);
				match(LCURLYBRACE);
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(171);
						exprStatement();
						}
						} 
					}
					setState(176);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(177);
				match(RCURLYBRACE);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputExprContext extends ParserRuleContext {
		public VarExprContext varExpr() {
			return getRuleContext(VarExprContext.class,0);
		}
		public InputExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterInputExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitInputExpr(this);
		}
	}

	public final InputExprContext inputExpr() throws RecognitionException {
		InputExprContext _localctx = new InputExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_inputExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			varExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionalExprContext extends ParserRuleContext {
		public MatchStatementContext matchStatement() {
			return getRuleContext(MatchStatementContext.class,0);
		}
		public ClassExpressionContext classExpression() {
			return getRuleContext(ClassExpressionContext.class,0);
		}
		public List<ClassMemberContext> classMember() {
			return getRuleContexts(ClassMemberContext.class);
		}
		public ClassMemberContext classMember(int i) {
			return getRuleContext(ClassMemberContext.class,i);
		}
		public FunctionExprContext functionExpr() {
			return getRuleContext(FunctionExprContext.class,0);
		}
		public TerminalNode LANG_CONSTRUCT() { return getToken(BladePhpAntlrParser.LANG_CONSTRUCT, 0); }
		public TerminalNode LPAREN() { return getToken(BladePhpAntlrParser.LPAREN, 0); }
		public FunctionalExprContext functionalExpr() {
			return getRuleContext(FunctionalExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BladePhpAntlrParser.RPAREN, 0); }
		public InputExprContext inputExpr() {
			return getRuleContext(InputExprContext.class,0);
		}
		public FunctionalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterFunctionalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitFunctionalExpr(this);
		}
	}

	public final FunctionalExprContext functionalExpr() throws RecognitionException {
		FunctionalExprContext _localctx = new FunctionalExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionalExpr);
		try {
			int _alt;
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				matchStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				classExpression();
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(184);
						classMember();
						}
						} 
					}
					setState(189);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				functionExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(191);
				match(LANG_CONSTRUCT);
				setState(192);
				match(LPAREN);
				setState(193);
				functionalExpr();
				setState(194);
				match(RPAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(196);
				inputExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassExpressionContext extends ParserRuleContext {
		public ClassInstanceStatementContext classInstanceStatement() {
			return getRuleContext(ClassInstanceStatementContext.class,0);
		}
		public StaticMethodAccessContext staticMethodAccess() {
			return getRuleContext(StaticMethodAccessContext.class,0);
		}
		public StaticFieldAccessContext staticFieldAccess() {
			return getRuleContext(StaticFieldAccessContext.class,0);
		}
		public StaticClassReferenceContext staticClassReference() {
			return getRuleContext(StaticClassReferenceContext.class,0);
		}
		public StaticAccessContext staticAccess() {
			return getRuleContext(StaticAccessContext.class,0);
		}
		public AliasDirectAccessContext aliasDirectAccess() {
			return getRuleContext(AliasDirectAccessContext.class,0);
		}
		public DirectMethodAccessContext directMethodAccess() {
			return getRuleContext(DirectMethodAccessContext.class,0);
		}
		public ClassExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterClassExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitClassExpression(this);
		}
	}

	public final ClassExpressionContext classExpression() throws RecognitionException {
		ClassExpressionContext _localctx = new ClassExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classExpression);
		try {
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				classInstanceStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				staticMethodAccess();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				staticFieldAccess();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(202);
				staticClassReference();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(203);
				staticAccess();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(204);
				aliasDirectAccess();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(205);
				directMethodAccess();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForeachDirectiveStatementContext extends ParserRuleContext {
		public ForeachArgumentsContext foreachArguments() {
			return getRuleContext(ForeachArgumentsContext.class,0);
		}
		public ForeachDirectiveStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachDirectiveStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterForeachDirectiveStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitForeachDirectiveStatement(this);
		}
	}

	public final ForeachDirectiveStatementContext foreachDirectiveStatement() throws RecognitionException {
		ForeachDirectiveStatementContext _localctx = new ForeachDirectiveStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_foreachDirectiveStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			if (!(this.bladeParserContext.equals(ParserContext.FOREACH))) throw new FailedPredicateException(this, "this.bladeParserContext.equals(ParserContext.FOREACH)");
			setState(209);
			foreachArguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForeachArgumentsContext extends ParserRuleContext {
		public Token main_array;
		public Token array_item;
		public Token array_key;
		public TerminalNode AS() { return getToken(BladePhpAntlrParser.AS, 0); }
		public List<TerminalNode> PHP_VARIABLE() { return getTokens(BladePhpAntlrParser.PHP_VARIABLE); }
		public TerminalNode PHP_VARIABLE(int i) {
			return getToken(BladePhpAntlrParser.PHP_VARIABLE, i);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(BladePhpAntlrParser.ARROW, 0); }
		public List<FunctionExprContext> functionExpr() {
			return getRuleContexts(FunctionExprContext.class);
		}
		public FunctionExprContext functionExpr(int i) {
			return getRuleContext(FunctionExprContext.class,i);
		}
		public ForeachArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterForeachArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitForeachArguments(this);
		}
	}

	public final ForeachArgumentsContext foreachArguments() throws RecognitionException {
		ForeachArgumentsContext _localctx = new ForeachArgumentsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_foreachArguments);
		try {
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(211);
					array();
					}
					break;
				case 2:
					{
					setState(212);
					((ForeachArgumentsContext)_localctx).main_array = match(PHP_VARIABLE);
					}
					break;
				}
				setState(215);
				match(AS);
				setState(216);
				((ForeachArgumentsContext)_localctx).array_item = match(PHP_VARIABLE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(217);
					array();
					}
					break;
				case 2:
					{
					setState(218);
					((ForeachArgumentsContext)_localctx).main_array = match(PHP_VARIABLE);
					}
					break;
				}
				setState(221);
				match(AS);
				setState(222);
				((ForeachArgumentsContext)_localctx).array_key = match(PHP_VARIABLE);
				setState(223);
				match(ARROW);
				setState(224);
				((ForeachArgumentsContext)_localctx).array_item = match(PHP_VARIABLE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				functionExpr();
				setState(226);
				match(AS);
				setState(227);
				functionExpr();
				setState(230);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(228);
					match(ARROW);
					setState(229);
					functionExpr();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassInstanceStatementContext extends ParserRuleContext {
		public Token className;
		public TerminalNode NEW() { return getToken(BladePhpAntlrParser.NEW, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BladePhpAntlrParser.IDENTIFIER, 0); }
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassInstanceStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterClassInstanceStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitClassInstanceStatement(this);
		}
	}

	public final ClassInstanceStatementContext classInstanceStatement() throws RecognitionException {
		ClassInstanceStatementContext _localctx = new ClassInstanceStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classInstanceStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(NEW);
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(235);
				namespace();
				}
				break;
			}
			setState(238);
			((ClassInstanceStatementContext)_localctx).className = match(IDENTIFIER);
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(239);
				arguments();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatchStatementContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(BladePhpAntlrParser.MATCH, 0); }
		public TerminalNode LPAREN() { return getToken(BladePhpAntlrParser.LPAREN, 0); }
		public List<FunctionalExprContext> functionalExpr() {
			return getRuleContexts(FunctionalExprContext.class);
		}
		public FunctionalExprContext functionalExpr(int i) {
			return getRuleContext(FunctionalExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(BladePhpAntlrParser.RPAREN, 0); }
		public TerminalNode LCURLYBRACE() { return getToken(BladePhpAntlrParser.LCURLYBRACE, 0); }
		public TerminalNode RCURLYBRACE() { return getToken(BladePhpAntlrParser.RCURLYBRACE, 0); }
		public List<TerminalNode> ARROW() { return getTokens(BladePhpAntlrParser.ARROW); }
		public TerminalNode ARROW(int i) {
			return getToken(BladePhpAntlrParser.ARROW, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BladePhpAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BladePhpAntlrParser.COMMA, i);
		}
		public MatchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterMatchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitMatchStatement(this);
		}
	}

	public final MatchStatementContext matchStatement() throws RecognitionException {
		MatchStatementContext _localctx = new MatchStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_matchStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(MATCH);
			setState(243);
			match(LPAREN);
			setState(244);
			functionalExpr();
			setState(245);
			match(RPAREN);
			setState(246);
			match(LCURLYBRACE);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17843119120L) != 0)) {
				{
				{
				setState(248); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(247);
					functionalExpr();
					}
					}
					setState(250); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17843119120L) != 0) );
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(252);
					match(COMMA);
					setState(254); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(253);
						functionalExpr();
						}
						}
						setState(256); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17843119120L) != 0) );
					}
					}
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(263);
				match(ARROW);
				setState(265); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(264);
						functionalExpr();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(267); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(274);
					match(COMMA);
					setState(276); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(275);
						functionalExpr();
						}
						}
						setState(278); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17843119120L) != 0) );
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(280);
						match(COMMA);
						setState(282); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(281);
							functionalExpr();
							}
							}
							setState(284); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17843119120L) != 0) );
						}
						}
						setState(290);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(291);
					match(ARROW);
					setState(293); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(292);
						functionalExpr();
						}
						}
						setState(295); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17843119120L) != 0) );
					}
					} 
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(302);
				match(COMMA);
				}
			}

			setState(305);
			match(RCURLYBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StaticClassReferenceContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BladePhpAntlrParser.IDENTIFIER, 0); }
		public TerminalNode DOUBLE_COLON() { return getToken(BladePhpAntlrParser.DOUBLE_COLON, 0); }
		public TerminalNode CLASS() { return getToken(BladePhpAntlrParser.CLASS, 0); }
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
		}
		public StaticClassReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticClassReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterStaticClassReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitStaticClassReference(this);
		}
	}

	public final StaticClassReferenceContext staticClassReference() throws RecognitionException {
		StaticClassReferenceContext _localctx = new StaticClassReferenceContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_staticClassReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(307);
				namespace();
				}
				break;
			}
			setState(310);
			match(IDENTIFIER);
			setState(311);
			match(DOUBLE_COLON);
			setState(312);
			match(CLASS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StaticMethodAccessContext extends ParserRuleContext {
		public Token className;
		public Token method;
		public TerminalNode DOUBLE_COLON() { return getToken(BladePhpAntlrParser.DOUBLE_COLON, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BladePhpAntlrParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BladePhpAntlrParser.IDENTIFIER, i);
		}
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
		}
		public StaticMethodAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticMethodAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterStaticMethodAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitStaticMethodAccess(this);
		}
	}

	public final StaticMethodAccessContext staticMethodAccess() throws RecognitionException {
		StaticMethodAccessContext _localctx = new StaticMethodAccessContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_staticMethodAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(314);
				namespace();
				}
				break;
			}
			setState(317);
			((StaticMethodAccessContext)_localctx).className = match(IDENTIFIER);
			setState(318);
			match(DOUBLE_COLON);
			setState(319);
			((StaticMethodAccessContext)_localctx).method = match(IDENTIFIER);
			setState(320);
			arguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StaticFieldAccessContext extends ParserRuleContext {
		public Token className;
		public Token const_;
		public Token propertyAlias;
		public Token classAlias;
		public TerminalNode DOUBLE_COLON() { return getToken(BladePhpAntlrParser.DOUBLE_COLON, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(BladePhpAntlrParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BladePhpAntlrParser.IDENTIFIER, i);
		}
		public TerminalNode CLASS() { return getToken(BladePhpAntlrParser.CLASS, 0); }
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
		}
		public List<TerminalNode> PHP_VARIABLE() { return getTokens(BladePhpAntlrParser.PHP_VARIABLE); }
		public TerminalNode PHP_VARIABLE(int i) {
			return getToken(BladePhpAntlrParser.PHP_VARIABLE, i);
		}
		public StaticFieldAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticFieldAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterStaticFieldAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitStaticFieldAccess(this);
		}
	}

	public final StaticFieldAccessContext staticFieldAccess() throws RecognitionException {
		StaticFieldAccessContext _localctx = new StaticFieldAccessContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_staticFieldAccess);
		try {
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(322);
					namespace();
					}
					break;
				}
				setState(325);
				((StaticFieldAccessContext)_localctx).className = match(IDENTIFIER);
				setState(326);
				match(DOUBLE_COLON);
				setState(330);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(327);
					((StaticFieldAccessContext)_localctx).const_ = match(IDENTIFIER);
					}
					break;
				case PHP_VARIABLE:
					{
					setState(328);
					((StaticFieldAccessContext)_localctx).propertyAlias = match(PHP_VARIABLE);
					}
					break;
				case CLASS:
					{
					setState(329);
					match(CLASS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				((StaticFieldAccessContext)_localctx).classAlias = match(PHP_VARIABLE);
				setState(333);
				match(DOUBLE_COLON);
				setState(334);
				((StaticFieldAccessContext)_localctx).const_ = match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(335);
				((StaticFieldAccessContext)_localctx).classAlias = match(PHP_VARIABLE);
				setState(336);
				match(DOUBLE_COLON);
				setState(337);
				((StaticFieldAccessContext)_localctx).propertyAlias = match(PHP_VARIABLE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StaticAccessContext extends ParserRuleContext {
		public Token className;
		public TerminalNode DOUBLE_COLON() { return getToken(BladePhpAntlrParser.DOUBLE_COLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BladePhpAntlrParser.IDENTIFIER, 0); }
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
		}
		public StaticAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterStaticAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitStaticAccess(this);
		}
	}

	public final StaticAccessContext staticAccess() throws RecognitionException {
		StaticAccessContext _localctx = new StaticAccessContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_staticAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(340);
				namespace();
				}
				break;
			}
			setState(343);
			((StaticAccessContext)_localctx).className = match(IDENTIFIER);
			setState(344);
			match(DOUBLE_COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AliasDirectAccessContext extends ParserRuleContext {
		public TerminalNode PHP_VARIABLE() { return getToken(BladePhpAntlrParser.PHP_VARIABLE, 0); }
		public ClassMemberContext classMember() {
			return getRuleContext(ClassMemberContext.class,0);
		}
		public AliasDirectAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasDirectAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterAliasDirectAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitAliasDirectAccess(this);
		}
	}

	public final AliasDirectAccessContext aliasDirectAccess() throws RecognitionException {
		AliasDirectAccessContext _localctx = new AliasDirectAccessContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_aliasDirectAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(PHP_VARIABLE);
			setState(347);
			classMember();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberContext extends ParserRuleContext {
		public DirectMethodAccessContext directMethodAccess() {
			return getRuleContext(DirectMethodAccessContext.class,0);
		}
		public TerminalNode OBJECT_OPERATOR() { return getToken(BladePhpAntlrParser.OBJECT_OPERATOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BladePhpAntlrParser.IDENTIFIER, 0); }
		public ClassMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterClassMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitClassMember(this);
		}
	}

	public final ClassMemberContext classMember() throws RecognitionException {
		ClassMemberContext _localctx = new ClassMemberContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_classMember);
		try {
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				directMethodAccess();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				match(OBJECT_OPERATOR);
				setState(351);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectMethodAccessContext extends ParserRuleContext {
		public TerminalNode OBJECT_OPERATOR() { return getToken(BladePhpAntlrParser.OBJECT_OPERATOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BladePhpAntlrParser.IDENTIFIER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public DirectMethodAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directMethodAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterDirectMethodAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitDirectMethodAccess(this);
		}
	}

	public final DirectMethodAccessContext directMethodAccess() throws RecognitionException {
		DirectMethodAccessContext _localctx = new DirectMethodAccessContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_directMethodAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(OBJECT_OPERATOR);
			setState(355);
			match(IDENTIFIER);
			setState(356);
			arguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectAccessContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(BladePhpAntlrParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BladePhpAntlrParser.IDENTIFIER, i);
		}
		public List<ArgumentsContext> arguments() {
			return getRuleContexts(ArgumentsContext.class);
		}
		public ArgumentsContext arguments(int i) {
			return getRuleContext(ArgumentsContext.class,i);
		}
		public TerminalNode OBJECT_OPERATOR() { return getToken(BladePhpAntlrParser.OBJECT_OPERATOR, 0); }
		public DirectAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterDirectAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitDirectAccess(this);
		}
	}

	public final DirectAccessContext directAccess() throws RecognitionException {
		DirectAccessContext _localctx = new DirectAccessContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_directAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(IDENTIFIER);
			setState(359);
			arguments();
			setState(360);
			match(OBJECT_OPERATOR);
			setState(361);
			match(IDENTIFIER);
			setState(362);
			arguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionExprContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BladePhpAntlrParser.IDENTIFIER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterFunctionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitFunctionExpr(this);
		}
	}

	public final FunctionExprContext functionExpr() throws RecognitionException {
		FunctionExprContext _localctx = new FunctionExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(IDENTIFIER);
			setState(365);
			arguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BladePhpAntlrParser.LPAREN, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(BladePhpAntlrParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BladePhpAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BladePhpAntlrParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_arguments);
		int _la;
		try {
			setState(380);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				match(LPAREN);
				setState(368);
				argument();
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(369);
					match(COMMA);
					setState(370);
					argument();
					}
					}
					setState(375);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(376);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(378);
				match(LPAREN);
				setState(379);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NamespaceContext extends ParserRuleContext {
		public List<TerminalNode> NAMESPACE_SEPARATOR() { return getTokens(BladePhpAntlrParser.NAMESPACE_SEPARATOR); }
		public TerminalNode NAMESPACE_SEPARATOR(int i) {
			return getToken(BladePhpAntlrParser.NAMESPACE_SEPARATOR, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BladePhpAntlrParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BladePhpAntlrParser.IDENTIFIER, i);
		}
		public NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterNamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitNamespace(this);
		}
	}

	public final NamespaceContext namespace() throws RecognitionException {
		NamespaceContext _localctx = new NamespaceContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_namespace);
		int _la;
		try {
			int _alt;
			setState(392);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAMESPACE_SEPARATOR) {
					{
					setState(382);
					match(NAMESPACE_SEPARATOR);
					}
				}

				setState(387); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(385);
						match(IDENTIFIER);
						setState(386);
						match(NAMESPACE_SEPARATOR);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(389); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				match(NAMESPACE_SEPARATOR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentContext extends ParserRuleContext {
		public FunctionalExprContext functionalExpr() {
			return getRuleContext(FunctionalExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(BladePhpAntlrParser.IDENTIFIER, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argument);
		try {
			setState(396);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				functionalExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode PHP_VARIABLE() { return getToken(BladePhpAntlrParser.PHP_VARIABLE, 0); }
		public List<Array_key_itemContext> array_key_item() {
			return getRuleContexts(Array_key_itemContext.class);
		}
		public Array_key_itemContext array_key_item(int i) {
			return getRuleContext(Array_key_itemContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_array);
		try {
			int _alt;
			setState(405);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PHP_VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
				match(PHP_VARIABLE);
				setState(400); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(399);
						array_key_item();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(402); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case ARRAY:
			case LSQUAREBRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
				array_key_item();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_key_itemContext extends ParserRuleContext {
		public TerminalNode LSQUAREBRACKET() { return getToken(BladePhpAntlrParser.LSQUAREBRACKET, 0); }
		public TerminalNode RSQUAREBRACKET() { return getToken(BladePhpAntlrParser.RSQUAREBRACKET, 0); }
		public List<Array_key_itemContext> array_key_item() {
			return getRuleContexts(Array_key_itemContext.class);
		}
		public Array_key_itemContext array_key_item(int i) {
			return getRuleContext(Array_key_itemContext.class,i);
		}
		public TerminalNode ARRAY() { return getToken(BladePhpAntlrParser.ARRAY, 0); }
		public TerminalNode LPAREN() { return getToken(BladePhpAntlrParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BladePhpAntlrParser.RPAREN, 0); }
		public List<Array_childContext> array_child() {
			return getRuleContexts(Array_childContext.class);
		}
		public Array_childContext array_child(int i) {
			return getRuleContext(Array_childContext.class,i);
		}
		public List<TerminalNode> ARROW() { return getTokens(BladePhpAntlrParser.ARROW); }
		public TerminalNode ARROW(int i) {
			return getToken(BladePhpAntlrParser.ARROW, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BladePhpAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BladePhpAntlrParser.COMMA, i);
		}
		public Array_key_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_key_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterArray_key_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitArray_key_item(this);
		}
	}

	public final Array_key_itemContext array_key_item() throws RecognitionException {
		Array_key_itemContext _localctx = new Array_key_itemContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_array_key_item);
		int _la;
		try {
			int _alt;
			setState(476);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(407);
				match(LSQUAREBRACKET);
				setState(411);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ARRAY || _la==LSQUAREBRACKET) {
					{
					{
					setState(408);
					array_key_item();
					}
					}
					setState(413);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(414);
				match(RSQUAREBRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(415);
				match(ARRAY);
				setState(416);
				match(LPAREN);
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ARRAY || _la==LSQUAREBRACKET) {
					{
					{
					setState(417);
					array_key_item();
					}
					}
					setState(422);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(423);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(424);
				match(LSQUAREBRACKET);
				setState(429); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(425);
					array_child();
					setState(426);
					match(ARROW);
					setState(427);
					array_key_item();
					}
					}
					setState(431); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17843119120L) != 0) );
				setState(433);
				match(RSQUAREBRACKET);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(435);
				match(ARRAY);
				setState(436);
				match(LPAREN);
				setState(441); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(437);
					array_child();
					setState(438);
					match(ARROW);
					setState(439);
					array_key_item();
					}
					}
					setState(443); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17843119120L) != 0) );
				setState(445);
				match(RPAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(447);
				match(LSQUAREBRACKET);
				setState(448);
				array_child();
				setState(453);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(449);
						match(COMMA);
						setState(450);
						array_child();
						}
						} 
					}
					setState(455);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				}
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(456);
					match(COMMA);
					}
				}

				setState(459);
				match(RSQUAREBRACKET);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(461);
				match(ARRAY);
				setState(462);
				match(LPAREN);
				setState(463);
				array_child();
				setState(468);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(464);
						match(COMMA);
						setState(465);
						array_child();
						}
						} 
					}
					setState(470);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
				}
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(471);
					match(COMMA);
					}
				}

				setState(474);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_childContext extends ParserRuleContext {
		public List<FunctionalExprContext> functionalExpr() {
			return getRuleContexts(FunctionalExprContext.class);
		}
		public FunctionalExprContext functionalExpr(int i) {
			return getRuleContext(FunctionalExprContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(BladePhpAntlrParser.ARROW, 0); }
		public Array_key_itemContext array_key_item() {
			return getRuleContext(Array_key_itemContext.class,0);
		}
		public Array_childContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_child; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterArray_child(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitArray_child(this);
		}
	}

	public final Array_childContext array_child() throws RecognitionException {
		Array_childContext _localctx = new Array_childContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_array_child);
		try {
			setState(487);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(478);
				functionalExpr();
				setState(479);
				match(ARROW);
				setState(480);
				array_key_item();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(482);
				functionalExpr();
				setState(483);
				match(ARROW);
				setState(484);
				functionalExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(486);
				functionalExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarExprContext extends ParserRuleContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode PHP_VARIABLE() { return getToken(BladePhpAntlrParser.PHP_VARIABLE, 0); }
		public TerminalNode DOLLAR() { return getToken(BladePhpAntlrParser.DOLLAR, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(BladePhpAntlrParser.STRING_LITERAL, 0); }
		public VarExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitVarExpr(this);
		}
	}

	public final VarExprContext varExpr() throws RecognitionException {
		VarExprContext _localctx = new VarExprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_varExpr);
		int _la;
		try {
			setState(495);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				array();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(491);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(490);
					match(DOLLAR);
					}
				}

				setState(493);
				match(PHP_VARIABLE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(494);
				match(STRING_LITERAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MiscContext extends ParserRuleContext {
		public Token className;
		public TerminalNode NEW() { return getToken(BladePhpAntlrParser.NEW, 0); }
		public TerminalNode PHP_VARIABLE() { return getToken(BladePhpAntlrParser.PHP_VARIABLE, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(BladePhpAntlrParser.IDENTIFIER, 0); }
		public MiscContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_misc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterMisc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitMisc(this);
		}
	}

	public final MiscContext misc() throws RecognitionException {
		MiscContext _localctx = new MiscContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_misc);
		try {
			setState(507);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(497);
				match(NEW);
				setState(498);
				match(PHP_VARIABLE);
				setState(500);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(499);
					arguments();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(502);
				match(NEW);
				setState(503);
				namespace();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(504);
				namespace();
				setState(505);
				((MiscContext)_localctx).className = match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefinitionContext extends ParserRuleContext {
		public TerminalNode PHP_VARIABLE() { return getToken(BladePhpAntlrParser.PHP_VARIABLE, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode EQ() { return getToken(BladePhpAntlrParser.EQ, 0); }
		public FunctionalExprContext functionalExpr() {
			return getRuleContext(FunctionalExprContext.class,0);
		}
		public VarDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterVarDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitVarDefinition(this);
		}
	}

	public final VarDefinitionContext varDefinition() throws RecognitionException {
		VarDefinitionContext _localctx = new VarDefinitionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_varDefinition);
		try {
			setState(514);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(509);
				match(PHP_VARIABLE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(510);
				array();
				setState(511);
				match(EQ);
				setState(512);
				functionalExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OutputContext extends ParserRuleContext {
		public TerminalNode ECHO() { return getToken(BladePhpAntlrParser.ECHO, 0); }
		public FunctionalExprContext functionalExpr() {
			return getRuleContext(FunctionalExprContext.class,0);
		}
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).enterOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladePhpAntlrParserListener ) ((BladePhpAntlrParserListener)listener).exitOutput(this);
		}
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_output);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			match(ECHO);
			setState(517);
			functionalExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return foreachDirectiveStatement_sempred((ForeachDirectiveStatementContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean foreachDirectiveStatement_sempred(ForeachDirectiveStatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return this.bladeParserContext.equals(ParserContext.FOREACH);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u0208\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0005\u0000"+
		">\b\u0000\n\u0000\f\u0000A\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001H\b\u0001\n\u0001\f\u0001K\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001P\b\u0001\n\u0001\f\u0001"+
		"S\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0004\u0001Z\b\u0001\u000b\u0001\f\u0001[\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001i\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0005\u0002m\b\u0002\n\u0002\f\u0002p\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0004\u0002v\b\u0002\u000b\u0002\f\u0002"+
		"w\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002}\b\u0002\u000b\u0002"+
		"\f\u0002~\u0001\u0002\u0003\u0002\u0082\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0004\u0003\u0087\b\u0003\u000b\u0003\f\u0003\u0088\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u008e\b\u0003\n\u0003\f\u0003"+
		"\u0091\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003"+
		"\u0097\b\u0003\u000b\u0003\f\u0003\u0098\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003\u009e\b\u0003\n\u0003\f\u0003\u00a1\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003\u00a5\b\u0003\n\u0003\f\u0003\u00a8\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u00ad\b\u0003\n\u0003\f\u0003"+
		"\u00b0\t\u0003\u0001\u0003\u0003\u0003\u00b3\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00ba\b\u0005\n"+
		"\u0005\f\u0005\u00bd\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00c6\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u00cf\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0003\b\u00d6\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00dc"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u00e7\b\b\u0003\b\u00e9\b\b\u0001\t\u0001\t\u0003\t\u00ed\b"+
		"\t\u0001\t\u0001\t\u0003\t\u00f1\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0004\n\u00f9\b\n\u000b\n\f\n\u00fa\u0001\n\u0001\n\u0004\n"+
		"\u00ff\b\n\u000b\n\f\n\u0100\u0005\n\u0103\b\n\n\n\f\n\u0106\t\n\u0001"+
		"\n\u0001\n\u0004\n\u010a\b\n\u000b\n\f\n\u010b\u0005\n\u010e\b\n\n\n\f"+
		"\n\u0111\t\n\u0001\n\u0001\n\u0004\n\u0115\b\n\u000b\n\f\n\u0116\u0001"+
		"\n\u0001\n\u0004\n\u011b\b\n\u000b\n\f\n\u011c\u0005\n\u011f\b\n\n\n\f"+
		"\n\u0122\t\n\u0001\n\u0001\n\u0004\n\u0126\b\n\u000b\n\f\n\u0127\u0005"+
		"\n\u012a\b\n\n\n\f\n\u012d\t\n\u0001\n\u0003\n\u0130\b\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0003\u000b\u0135\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0003\f\u013c\b\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0003\r\u0144\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u014b\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u0153\b\r\u0001\u000e\u0003\u000e\u0156\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u0161\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u0174\b\u0014\n\u0014\f\u0014\u0177"+
		"\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u017d"+
		"\b\u0014\u0001\u0015\u0003\u0015\u0180\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0004\u0015\u0184\b\u0015\u000b\u0015\f\u0015\u0185\u0001\u0015\u0003"+
		"\u0015\u0189\b\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u018d\b\u0016"+
		"\u0001\u0017\u0001\u0017\u0004\u0017\u0191\b\u0017\u000b\u0017\f\u0017"+
		"\u0192\u0001\u0017\u0003\u0017\u0196\b\u0017\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u019a\b\u0018\n\u0018\f\u0018\u019d\t\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u01a3\b\u0018\n\u0018\f\u0018\u01a6"+
		"\t\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0004\u0018\u01ae\b\u0018\u000b\u0018\f\u0018\u01af\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0004\u0018\u01ba\b\u0018\u000b\u0018\f\u0018\u01bb\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u01c4\b\u0018\n\u0018\f\u0018\u01c7\t\u0018\u0001\u0018\u0003\u0018"+
		"\u01ca\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u01d3\b\u0018\n\u0018\f\u0018\u01d6"+
		"\t\u0018\u0001\u0018\u0003\u0018\u01d9\b\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u01dd\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u01e8\b\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u01ec\b\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u01f0\b\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0003\u001b\u01f5\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0003\u001b\u01fc\b\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0203\b\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0000\u0000\u001e\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:\u0000\u0000\u0249\u0000?\u0001\u0000\u0000\u0000\u0002h\u0001\u0000"+
		"\u0000\u0000\u0004\u0081\u0001\u0000\u0000\u0000\u0006\u0083\u0001\u0000"+
		"\u0000\u0000\b\u00b4\u0001\u0000\u0000\u0000\n\u00c5\u0001\u0000\u0000"+
		"\u0000\f\u00ce\u0001\u0000\u0000\u0000\u000e\u00d0\u0001\u0000\u0000\u0000"+
		"\u0010\u00e8\u0001\u0000\u0000\u0000\u0012\u00ea\u0001\u0000\u0000\u0000"+
		"\u0014\u00f2\u0001\u0000\u0000\u0000\u0016\u0134\u0001\u0000\u0000\u0000"+
		"\u0018\u013b\u0001\u0000\u0000\u0000\u001a\u0152\u0001\u0000\u0000\u0000"+
		"\u001c\u0155\u0001\u0000\u0000\u0000\u001e\u015a\u0001\u0000\u0000\u0000"+
		" \u0160\u0001\u0000\u0000\u0000\"\u0162\u0001\u0000\u0000\u0000$\u0166"+
		"\u0001\u0000\u0000\u0000&\u016c\u0001\u0000\u0000\u0000(\u017c\u0001\u0000"+
		"\u0000\u0000*\u0188\u0001\u0000\u0000\u0000,\u018c\u0001\u0000\u0000\u0000"+
		".\u0195\u0001\u0000\u0000\u00000\u01dc\u0001\u0000\u0000\u00002\u01e7"+
		"\u0001\u0000\u0000\u00004\u01ef\u0001\u0000\u0000\u00006\u01fb\u0001\u0000"+
		"\u0000\u00008\u0202\u0001\u0000\u0000\u0000:\u0204\u0001\u0000\u0000\u0000"+
		"<>\u0003\u0002\u0001\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000"+
		"\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0001\u0000"+
		"\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0005\u0000\u0000\u0001C\u0001"+
		"\u0001\u0000\u0000\u0000Di\u0005\u001e\u0000\u0000EI\u0005\u0015\u0000"+
		"\u0000FH\u0003\u0002\u0001\u0000GF\u0001\u0000\u0000\u0000HK\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000Li\u0005\u0016\u0000\u0000"+
		"MQ\u0005\u0011\u0000\u0000NP\u0003\u0002\u0001\u0000ON\u0001\u0000\u0000"+
		"\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000Ti\u0005"+
		"\u0012\u0000\u0000UV\u0005\u001f\u0000\u0000Vi\u0003\u0002\u0001\u0000"+
		"WY\u0005!\u0000\u0000XZ\u0003\n\u0005\u0000YX\u0001\u0000\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000"+
		"\u0000\\i\u0001\u0000\u0000\u0000]^\u0005\u000f\u0000\u0000^_\u0005\u0011"+
		"\u0000\u0000_`\u0003\u0010\b\u0000`a\u0005\u0012\u0000\u0000ai\u0001\u0000"+
		"\u0000\u0000bi\u00038\u001c\u0000ci\u0003\n\u0005\u0000di\u0003\u0006"+
		"\u0003\u0000ei\u0003\u000e\u0007\u0000fi\u0003:\u001d\u0000gi\u00036\u001b"+
		"\u0000hD\u0001\u0000\u0000\u0000hE\u0001\u0000\u0000\u0000hM\u0001\u0000"+
		"\u0000\u0000hU\u0001\u0000\u0000\u0000hW\u0001\u0000\u0000\u0000h]\u0001"+
		"\u0000\u0000\u0000hb\u0001\u0000\u0000\u0000hc\u0001\u0000\u0000\u0000"+
		"hd\u0001\u0000\u0000\u0000he\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000"+
		"\u0000hg\u0001\u0000\u0000\u0000i\u0003\u0001\u0000\u0000\u0000jn\u0005"+
		"\u0011\u0000\u0000km\u0003\n\u0005\u0000lk\u0001\u0000\u0000\u0000mp\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"oq\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000q\u0082\u0005\u0012"+
		"\u0000\u0000ru\u0003\n\u0005\u0000st\u0005!\u0000\u0000tv\u0003\n\u0005"+
		"\u0000us\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000x\u0082\u0001\u0000\u0000\u0000"+
		"y|\u0003\n\u0005\u0000z{\u0005\u001f\u0000\u0000{}\u0003\n\u0005\u0000"+
		"|z\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000"+
		"\u0080\u0082\u0003\n\u0005\u0000\u0081j\u0001\u0000\u0000\u0000\u0081"+
		"r\u0001\u0000\u0000\u0000\u0081y\u0001\u0000\u0000\u0000\u0081\u0080\u0001"+
		"\u0000\u0000\u0000\u0082\u0005\u0001\u0000\u0000\u0000\u0083\u0084\u0005"+
		"\u0007\u0000\u0000\u0084\u0086\u0005\u0011\u0000\u0000\u0085\u0087\u0003"+
		"\u0004\u0002\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"\u0012\u0000\u0000\u008b\u008f\u0005\u0015\u0000\u0000\u008c\u008e\u0003"+
		"\u0002\u0001\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u0091\u0001"+
		"\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001"+
		"\u0000\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u008f\u0001"+
		"\u0000\u0000\u0000\u0092\u00a6\u0005\u0016\u0000\u0000\u0093\u0094\u0005"+
		"\b\u0000\u0000\u0094\u0096\u0005\u0011\u0000\u0000\u0095\u0097\u0003\u0004"+
		"\u0002\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000"+
		"\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0012"+
		"\u0000\u0000\u009b\u009f\u0005\u0015\u0000\u0000\u009c\u009e\u0003\u0002"+
		"\u0001\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u00a1\u0001\u0000"+
		"\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a2\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005\u0016\u0000\u0000\u00a3\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a4\u0093\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a7\u00b2\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a9\u00aa\u0005\t\u0000\u0000\u00aa\u00ae\u0005\u0015\u0000"+
		"\u0000\u00ab\u00ad\u0003\u0002\u0001\u0000\u00ac\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b3\u0005\u0016\u0000"+
		"\u0000\u00b2\u00a9\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b3\u0007\u0001\u0000\u0000\u0000\u00b4\u00b5\u00034\u001a\u0000"+
		"\u00b5\t\u0001\u0000\u0000\u0000\u00b6\u00c6\u0003\u0014\n\u0000\u00b7"+
		"\u00bb\u0003\f\u0006\u0000\u00b8\u00ba\u0003 \u0010\u0000\u00b9\u00b8"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000\u00bb\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00c6"+
		"\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00c6"+
		"\u0003&\u0013\u0000\u00bf\u00c0\u0005\r\u0000\u0000\u00c0\u00c1\u0005"+
		"\u0011\u0000\u0000\u00c1\u00c2\u0003\n\u0005\u0000\u00c2\u00c3\u0005\u0012"+
		"\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4\u00c6\u0003\b\u0004"+
		"\u0000\u00c5\u00b6\u0001\u0000\u0000\u0000\u00c5\u00b7\u0001\u0000\u0000"+
		"\u0000\u00c5\u00be\u0001\u0000\u0000\u0000\u00c5\u00bf\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c6\u000b\u0001\u0000\u0000"+
		"\u0000\u00c7\u00cf\u0003\u0012\t\u0000\u00c8\u00cf\u0003\u0018\f\u0000"+
		"\u00c9\u00cf\u0003\u001a\r\u0000\u00ca\u00cf\u0003\u0016\u000b\u0000\u00cb"+
		"\u00cf\u0003\u001c\u000e\u0000\u00cc\u00cf\u0003\u001e\u000f\u0000\u00cd"+
		"\u00cf\u0003\"\u0011\u0000\u00ce\u00c7\u0001\u0000\u0000\u0000\u00ce\u00c8"+
		"\u0001\u0000\u0000\u0000\u00ce\u00c9\u0001\u0000\u0000\u0000\u00ce\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cc"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00cf\r\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d1\u0004\u0007\u0000\u0000\u00d1\u00d2\u0003"+
		"\u0010\b\u0000\u00d2\u000f\u0001\u0000\u0000\u0000\u00d3\u00d6\u0003."+
		"\u0017\u0000\u00d4\u00d6\u0005\u0018\u0000\u0000\u00d5\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0005\u0005\u0000\u0000\u00d8\u00e9\u0005\u0018"+
		"\u0000\u0000\u00d9\u00dc\u0003.\u0017\u0000\u00da\u00dc\u0005\u0018\u0000"+
		"\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00da\u0001\u0000\u0000"+
		"\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00de\u0005\u0005\u0000"+
		"\u0000\u00de\u00df\u0005\u0018\u0000\u0000\u00df\u00e0\u0005\u001c\u0000"+
		"\u0000\u00e0\u00e9\u0005\u0018\u0000\u0000\u00e1\u00e2\u0003&\u0013\u0000"+
		"\u00e2\u00e3\u0005\u0005\u0000\u0000\u00e3\u00e6\u0003&\u0013\u0000\u00e4"+
		"\u00e5\u0005\u001c\u0000\u0000\u00e5\u00e7\u0003&\u0013\u0000\u00e6\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e9"+
		"\u0001\u0000\u0000\u0000\u00e8\u00d5\u0001\u0000\u0000\u0000\u00e8\u00db"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e1\u0001\u0000\u0000\u0000\u00e9\u0011"+
		"\u0001\u0000\u0000\u0000\u00ea\u00ec\u0005\n\u0000\u0000\u00eb\u00ed\u0003"+
		"*\u0015\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000"+
		"\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00f0\u0005\u0017"+
		"\u0000\u0000\u00ef\u00f1\u0003(\u0014\u0000\u00f0\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u0013\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f3\u0005\u000e\u0000\u0000\u00f3\u00f4\u0005\u0011\u0000"+
		"\u0000\u00f4\u00f5\u0003\n\u0005\u0000\u00f5\u00f6\u0005\u0012\u0000\u0000"+
		"\u00f6\u010f\u0005\u0015\u0000\u0000\u00f7\u00f9\u0003\n\u0005\u0000\u00f8"+
		"\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa"+
		"\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb"+
		"\u0104\u0001\u0000\u0000\u0000\u00fc\u00fe\u0005\u0010\u0000\u0000\u00fd"+
		"\u00ff\u0003\n\u0005\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100"+
		"\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0100\u0101"+
		"\u0001\u0000\u0000\u0000\u0101\u0103\u0001\u0000\u0000\u0000\u0102\u00fc"+
		"\u0001\u0000\u0000\u0000\u0103\u0106\u0001\u0000\u0000\u0000\u0104\u0102"+
		"\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0107"+
		"\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000\u0107\u0109"+
		"\u0005\u001c\u0000\u0000\u0108\u010a\u0003\n\u0005\u0000\u0109\u0108\u0001"+
		"\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u0109\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010e\u0001"+
		"\u0000\u0000\u0000\u010d\u00f8\u0001\u0000\u0000\u0000\u010e\u0111\u0001"+
		"\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u010f\u0110\u0001"+
		"\u0000\u0000\u0000\u0110\u012b\u0001\u0000\u0000\u0000\u0111\u010f\u0001"+
		"\u0000\u0000\u0000\u0112\u0114\u0005\u0010\u0000\u0000\u0113\u0115\u0003"+
		"\n\u0005\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000"+
		"\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000"+
		"\u0000\u0000\u0117\u0120\u0001\u0000\u0000\u0000\u0118\u011a\u0005\u0010"+
		"\u0000\u0000\u0119\u011b\u0003\n\u0005\u0000\u011a\u0119\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000"+
		"\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011f\u0001\u0000\u0000"+
		"\u0000\u011e\u0118\u0001\u0000\u0000\u0000\u011f\u0122\u0001\u0000\u0000"+
		"\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000"+
		"\u0000\u0121\u0123\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000"+
		"\u0000\u0123\u0125\u0005\u001c\u0000\u0000\u0124\u0126\u0003\n\u0005\u0000"+
		"\u0125\u0124\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000"+
		"\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000"+
		"\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u0112\u0001\u0000\u0000\u0000"+
		"\u012a\u012d\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000"+
		"\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012f\u0001\u0000\u0000\u0000"+
		"\u012d\u012b\u0001\u0000\u0000\u0000\u012e\u0130\u0005\u0010\u0000\u0000"+
		"\u012f\u012e\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000"+
		"\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u0005\u0016\u0000\u0000"+
		"\u0132\u0015\u0001\u0000\u0000\u0000\u0133\u0135\u0003*\u0015\u0000\u0134"+
		"\u0133\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135"+
		"\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u0005\u0017\u0000\u0000\u0137"+
		"\u0138\u0005\u001b\u0000\u0000\u0138\u0139\u0005\u000b\u0000\u0000\u0139"+
		"\u0017\u0001\u0000\u0000\u0000\u013a\u013c\u0003*\u0015\u0000\u013b\u013a"+
		"\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c\u013d"+
		"\u0001\u0000\u0000\u0000\u013d\u013e\u0005\u0017\u0000\u0000\u013e\u013f"+
		"\u0005\u001b\u0000\u0000\u013f\u0140\u0005\u0017\u0000\u0000\u0140\u0141"+
		"\u0003(\u0014\u0000\u0141\u0019\u0001\u0000\u0000\u0000\u0142\u0144\u0003"+
		"*\u0015\u0000\u0143\u0142\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000"+
		"\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0146\u0005\u0017"+
		"\u0000\u0000\u0146\u014a\u0005\u001b\u0000\u0000\u0147\u014b\u0005\u0017"+
		"\u0000\u0000\u0148\u014b\u0005\u0018\u0000\u0000\u0149\u014b\u0005\u000b"+
		"\u0000\u0000\u014a\u0147\u0001\u0000\u0000\u0000\u014a\u0148\u0001\u0000"+
		"\u0000\u0000\u014a\u0149\u0001\u0000\u0000\u0000\u014b\u0153\u0001\u0000"+
		"\u0000\u0000\u014c\u014d\u0005\u0018\u0000\u0000\u014d\u014e\u0005\u001b"+
		"\u0000\u0000\u014e\u0153\u0005\u0017\u0000\u0000\u014f\u0150\u0005\u0018"+
		"\u0000\u0000\u0150\u0151\u0005\u001b\u0000\u0000\u0151\u0153\u0005\u0018"+
		"\u0000\u0000\u0152\u0143\u0001\u0000\u0000\u0000\u0152\u014c\u0001\u0000"+
		"\u0000\u0000\u0152\u014f\u0001\u0000\u0000\u0000\u0153\u001b\u0001\u0000"+
		"\u0000\u0000\u0154\u0156\u0003*\u0015\u0000\u0155\u0154\u0001\u0000\u0000"+
		"\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u0156\u0157\u0001\u0000\u0000"+
		"\u0000\u0157\u0158\u0005\u0017\u0000\u0000\u0158\u0159\u0005\u001b\u0000"+
		"\u0000\u0159\u001d\u0001\u0000\u0000\u0000\u015a\u015b\u0005\u0018\u0000"+
		"\u0000\u015b\u015c\u0003 \u0010\u0000\u015c\u001f\u0001\u0000\u0000\u0000"+
		"\u015d\u0161\u0003\"\u0011\u0000\u015e\u015f\u0005\u001d\u0000\u0000\u015f"+
		"\u0161\u0005\u0017\u0000\u0000\u0160\u015d\u0001\u0000\u0000\u0000\u0160"+
		"\u015e\u0001\u0000\u0000\u0000\u0161!\u0001\u0000\u0000\u0000\u0162\u0163"+
		"\u0005\u001d\u0000\u0000\u0163\u0164\u0005\u0017\u0000\u0000\u0164\u0165"+
		"\u0003(\u0014\u0000\u0165#\u0001\u0000\u0000\u0000\u0166\u0167\u0005\u0017"+
		"\u0000\u0000\u0167\u0168\u0003(\u0014\u0000\u0168\u0169\u0005\u001d\u0000"+
		"\u0000\u0169\u016a\u0005\u0017\u0000\u0000\u016a\u016b\u0003(\u0014\u0000"+
		"\u016b%\u0001\u0000\u0000\u0000\u016c\u016d\u0005\u0017\u0000\u0000\u016d"+
		"\u016e\u0003(\u0014\u0000\u016e\'\u0001\u0000\u0000\u0000\u016f\u0170"+
		"\u0005\u0011\u0000\u0000\u0170\u0175\u0003,\u0016\u0000\u0171\u0172\u0005"+
		"\u0010\u0000\u0000\u0172\u0174\u0003,\u0016\u0000\u0173\u0171\u0001\u0000"+
		"\u0000\u0000\u0174\u0177\u0001\u0000\u0000\u0000\u0175\u0173\u0001\u0000"+
		"\u0000\u0000\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0178\u0001\u0000"+
		"\u0000\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0178\u0179\u0005\u0012"+
		"\u0000\u0000\u0179\u017d\u0001\u0000\u0000\u0000\u017a\u017b\u0005\u0011"+
		"\u0000\u0000\u017b\u017d\u0005\u0012\u0000\u0000\u017c\u016f\u0001\u0000"+
		"\u0000\u0000\u017c\u017a\u0001\u0000\u0000\u0000\u017d)\u0001\u0000\u0000"+
		"\u0000\u017e\u0180\u0005\u001a\u0000\u0000\u017f\u017e\u0001\u0000\u0000"+
		"\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u0183\u0001\u0000\u0000"+
		"\u0000\u0181\u0182\u0005\u0017\u0000\u0000\u0182\u0184\u0005\u001a\u0000"+
		"\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0184\u0185\u0001\u0000\u0000"+
		"\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000"+
		"\u0000\u0186\u0189\u0001\u0000\u0000\u0000\u0187\u0189\u0005\u001a\u0000"+
		"\u0000\u0188\u017f\u0001\u0000\u0000\u0000\u0188\u0187\u0001\u0000\u0000"+
		"\u0000\u0189+\u0001\u0000\u0000\u0000\u018a\u018d\u0003\n\u0005\u0000"+
		"\u018b\u018d\u0005\u0017\u0000\u0000\u018c\u018a\u0001\u0000\u0000\u0000"+
		"\u018c\u018b\u0001\u0000\u0000\u0000\u018d-\u0001\u0000\u0000\u0000\u018e"+
		"\u0190\u0005\u0018\u0000\u0000\u018f\u0191\u00030\u0018\u0000\u0190\u018f"+
		"\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0192\u0190"+
		"\u0001\u0000\u0000\u0000\u0192\u0193\u0001\u0000\u0000\u0000\u0193\u0196"+
		"\u0001\u0000\u0000\u0000\u0194\u0196\u00030\u0018\u0000\u0195\u018e\u0001"+
		"\u0000\u0000\u0000\u0195\u0194\u0001\u0000\u0000\u0000\u0196/\u0001\u0000"+
		"\u0000\u0000\u0197\u019b\u0005\u0013\u0000\u0000\u0198\u019a\u00030\u0018"+
		"\u0000\u0199\u0198\u0001\u0000\u0000\u0000\u019a\u019d\u0001\u0000\u0000"+
		"\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019b\u019c\u0001\u0000\u0000"+
		"\u0000\u019c\u019e\u0001\u0000\u0000\u0000\u019d\u019b\u0001\u0000\u0000"+
		"\u0000\u019e\u01dd\u0005\u0014\u0000\u0000\u019f\u01a0\u0005\u0004\u0000"+
		"\u0000\u01a0\u01a4\u0005\u0011\u0000\u0000\u01a1\u01a3\u00030\u0018\u0000"+
		"\u01a2\u01a1\u0001\u0000\u0000\u0000\u01a3\u01a6\u0001\u0000\u0000\u0000"+
		"\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000"+
		"\u01a5\u01a7\u0001\u0000\u0000\u0000\u01a6\u01a4\u0001\u0000\u0000\u0000"+
		"\u01a7\u01dd\u0005\u0012\u0000\u0000\u01a8\u01ad\u0005\u0013\u0000\u0000"+
		"\u01a9\u01aa\u00032\u0019\u0000\u01aa\u01ab\u0005\u001c\u0000\u0000\u01ab"+
		"\u01ac\u00030\u0018\u0000\u01ac\u01ae\u0001\u0000\u0000\u0000\u01ad\u01a9"+
		"\u0001\u0000\u0000\u0000\u01ae\u01af\u0001\u0000\u0000\u0000\u01af\u01ad"+
		"\u0001\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b1"+
		"\u0001\u0000\u0000\u0000\u01b1\u01b2\u0005\u0014\u0000\u0000\u01b2\u01dd"+
		"\u0001\u0000\u0000\u0000\u01b3\u01b4\u0005\u0004\u0000\u0000\u01b4\u01b9"+
		"\u0005\u0011\u0000\u0000\u01b5\u01b6\u00032\u0019\u0000\u01b6\u01b7\u0005"+
		"\u001c\u0000\u0000\u01b7\u01b8\u00030\u0018\u0000\u01b8\u01ba\u0001\u0000"+
		"\u0000\u0000\u01b9\u01b5\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000"+
		"\u0000\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000"+
		"\u0000\u0000\u01bc\u01bd\u0001\u0000\u0000\u0000\u01bd\u01be\u0005\u0012"+
		"\u0000\u0000\u01be\u01dd\u0001\u0000\u0000\u0000\u01bf\u01c0\u0005\u0013"+
		"\u0000\u0000\u01c0\u01c5\u00032\u0019\u0000\u01c1\u01c2\u0005\u0010\u0000"+
		"\u0000\u01c2\u01c4\u00032\u0019\u0000\u01c3\u01c1\u0001\u0000\u0000\u0000"+
		"\u01c4\u01c7\u0001\u0000\u0000\u0000\u01c5\u01c3\u0001\u0000\u0000\u0000"+
		"\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6\u01c9\u0001\u0000\u0000\u0000"+
		"\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c8\u01ca\u0005\u0010\u0000\u0000"+
		"\u01c9\u01c8\u0001\u0000\u0000\u0000\u01c9\u01ca\u0001\u0000\u0000\u0000"+
		"\u01ca\u01cb\u0001\u0000\u0000\u0000\u01cb\u01cc\u0005\u0014\u0000\u0000"+
		"\u01cc\u01dd\u0001\u0000\u0000\u0000\u01cd\u01ce\u0005\u0004\u0000\u0000"+
		"\u01ce\u01cf\u0005\u0011\u0000\u0000\u01cf\u01d4\u00032\u0019\u0000\u01d0"+
		"\u01d1\u0005\u0010\u0000\u0000\u01d1\u01d3\u00032\u0019\u0000\u01d2\u01d0"+
		"\u0001\u0000\u0000\u0000\u01d3\u01d6\u0001\u0000\u0000\u0000\u01d4\u01d2"+
		"\u0001\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000\u0000\u0000\u01d5\u01d8"+
		"\u0001\u0000\u0000\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d7\u01d9"+
		"\u0005\u0010\u0000\u0000\u01d8\u01d7\u0001\u0000\u0000\u0000\u01d8\u01d9"+
		"\u0001\u0000\u0000\u0000\u01d9\u01da\u0001\u0000\u0000\u0000\u01da\u01db"+
		"\u0005\u0012\u0000\u0000\u01db\u01dd\u0001\u0000\u0000\u0000\u01dc\u0197"+
		"\u0001\u0000\u0000\u0000\u01dc\u019f\u0001\u0000\u0000\u0000\u01dc\u01a8"+
		"\u0001\u0000\u0000\u0000\u01dc\u01b3\u0001\u0000\u0000\u0000\u01dc\u01bf"+
		"\u0001\u0000\u0000\u0000\u01dc\u01cd\u0001\u0000\u0000\u0000\u01dd1\u0001"+
		"\u0000\u0000\u0000\u01de\u01df\u0003\n\u0005\u0000\u01df\u01e0\u0005\u001c"+
		"\u0000\u0000\u01e0\u01e1\u00030\u0018\u0000\u01e1\u01e8\u0001\u0000\u0000"+
		"\u0000\u01e2\u01e3\u0003\n\u0005\u0000\u01e3\u01e4\u0005\u001c\u0000\u0000"+
		"\u01e4\u01e5\u0003\n\u0005\u0000\u01e5\u01e8\u0001\u0000\u0000\u0000\u01e6"+
		"\u01e8\u0003\n\u0005\u0000\u01e7\u01de\u0001\u0000\u0000\u0000\u01e7\u01e2"+
		"\u0001\u0000\u0000\u0000\u01e7\u01e6\u0001\u0000\u0000\u0000\u01e83\u0001"+
		"\u0000\u0000\u0000\u01e9\u01f0\u0003.\u0017\u0000\u01ea\u01ec\u0005\u0019"+
		"\u0000\u0000\u01eb\u01ea\u0001\u0000\u0000\u0000\u01eb\u01ec\u0001\u0000"+
		"\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000\u01ed\u01f0\u0005\u0018"+
		"\u0000\u0000\u01ee\u01f0\u0005\"\u0000\u0000\u01ef\u01e9\u0001\u0000\u0000"+
		"\u0000\u01ef\u01eb\u0001\u0000\u0000\u0000\u01ef\u01ee\u0001\u0000\u0000"+
		"\u0000\u01f05\u0001\u0000\u0000\u0000\u01f1\u01f2\u0005\n\u0000\u0000"+
		"\u01f2\u01f4\u0005\u0018\u0000\u0000\u01f3\u01f5\u0003(\u0014\u0000\u01f4"+
		"\u01f3\u0001\u0000\u0000\u0000\u01f4\u01f5\u0001\u0000\u0000\u0000\u01f5"+
		"\u01fc\u0001\u0000\u0000\u0000\u01f6\u01f7\u0005\n\u0000\u0000\u01f7\u01fc"+
		"\u0003*\u0015\u0000\u01f8\u01f9\u0003*\u0015\u0000\u01f9\u01fa\u0005\u0017"+
		"\u0000\u0000\u01fa\u01fc\u0001\u0000\u0000\u0000\u01fb\u01f1\u0001\u0000"+
		"\u0000\u0000\u01fb\u01f6\u0001\u0000\u0000\u0000\u01fb\u01f8\u0001\u0000"+
		"\u0000\u0000\u01fc7\u0001\u0000\u0000\u0000\u01fd\u0203\u0005\u0018\u0000"+
		"\u0000\u01fe\u01ff\u0003.\u0017\u0000\u01ff\u0200\u0005 \u0000\u0000\u0200"+
		"\u0201\u0003\n\u0005\u0000\u0201\u0203\u0001\u0000\u0000\u0000\u0202\u01fd"+
		"\u0001\u0000\u0000\u0000\u0202\u01fe\u0001\u0000\u0000\u0000\u02039\u0001"+
		"\u0000\u0000\u0000\u0204\u0205\u0005\u0006\u0000\u0000\u0205\u0206\u0003"+
		"\n\u0005\u0000\u0206;\u0001\u0000\u0000\u0000B?IQ[hnw~\u0081\u0088\u008f"+
		"\u0098\u009f\u00a6\u00ae\u00b2\u00bb\u00c5\u00ce\u00d5\u00db\u00e6\u00e8"+
		"\u00ec\u00f0\u00fa\u0100\u0104\u010b\u010f\u0116\u011c\u0120\u0127\u012b"+
		"\u012f\u0134\u013b\u0143\u014a\u0152\u0155\u0160\u0175\u017c\u017f\u0185"+
		"\u0188\u018c\u0192\u0195\u019b\u01a4\u01af\u01bb\u01c5\u01c9\u01d4\u01d8"+
		"\u01dc\u01e7\u01eb\u01ef\u01f4\u01fb\u0202";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}