// Generated from BladePhpAntlrParser.g4 by ANTLR 4.13.0

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
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HTML=1, BLADE_COMMENT=2, LINE_COMMENT=3, ARRAY=4, AS=5, ECHO=6, NEW=7, 
		CLASS=8, FUNCTION=9, LANG_CONSTRUCT=10, COMMA=11, LPAREN=12, RPAREN=13, 
		LSQUAREBRACKET=14, RSQUAREBRACKET=15, LCURLYBRACE=16, RCURLYBRACE=17, 
		IDENTIFIER=18, PHP_VARIABLE=19, DOLLAR=20, NAMESPACE_SEPARATOR=21, DOUBLE_COLON=22, 
		ARROW=23, OBJECT_OPERATOR=24, SEMI_COLON=25, STRING_LITERAL=26, STYLE_COMMENT=27, 
		WS=28, OTHER=29, BLADE_COMMENT_START=30, EMAIL_SUBSTRING=31, VERSION_WITH_AT=32, 
		BLADE_COMMENT_END=33, BLADE_COMMENT_PEEK=34, BLADE_COMMENT_MORE=35, BLADE_COMMENT_EOF=36;
	public static final int
		RULE_expression = 0, RULE_exprStatement = 1, RULE_functionalExpr = 2, 
		RULE_classExpression = 3, RULE_foreachDirectiveStatement = 4, RULE_foreachArguments = 5, 
		RULE_staticClassReference = 6, RULE_staticMethodAccess = 7, RULE_staticFieldAccess = 8, 
		RULE_staticAccess = 9, RULE_directMethodAccess = 10, RULE_directAccess = 11, 
		RULE_functionExpr = 12, RULE_arguments = 13, RULE_namespace = 14, RULE_argument = 15, 
		RULE_array = 16, RULE_array_key_item = 17, RULE_misc = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "exprStatement", "functionalExpr", "classExpression", "foreachDirectiveStatement", 
			"foreachArguments", "staticClassReference", "staticMethodAccess", "staticFieldAccess", 
			"staticAccess", "directMethodAccess", "directAccess", "functionExpr", 
			"arguments", "namespace", "argument", "array", "array_key_item", "misc"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'array'", "'as'", "'echo'", "'new'", "'class'", 
			"'function'", "'empty'", "','", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			null, null, "'$'", "'\\'", "'::'", "'=>'", "'->'", "';'", null, null, 
			null, null, "'{{--'", null, null, "'--}}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HTML", "BLADE_COMMENT", "LINE_COMMENT", "ARRAY", "AS", "ECHO", 
			"NEW", "CLASS", "FUNCTION", "LANG_CONSTRUCT", "COMMA", "LPAREN", "RPAREN", 
			"LSQUAREBRACKET", "RSQUAREBRACKET", "LCURLYBRACE", "RCURLYBRACE", "IDENTIFIER", 
			"PHP_VARIABLE", "DOLLAR", "NAMESPACE_SEPARATOR", "DOUBLE_COLON", "ARROW", 
			"OBJECT_OPERATOR", "SEMI_COLON", "STRING_LITERAL", "STYLE_COMMENT", "WS", 
			"OTHER", "BLADE_COMMENT_START", "EMAIL_SUBSTRING", "VERSION_WITH_AT", 
			"BLADE_COMMENT_END", "BLADE_COMMENT_PEEK", "BLADE_COMMENT_MORE", "BLADE_COMMENT_EOF"
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
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(38);
					exprStatement();
					}
					} 
				}
				setState(43);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(44);
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
		public ForeachDirectiveStatementContext foreachDirectiveStatement() {
			return getRuleContext(ForeachDirectiveStatementContext.class,0);
		}
		public FunctionalExprContext functionalExpr() {
			return getRuleContext(FunctionalExprContext.class,0);
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
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(SEMI_COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				foreachDirectiveStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
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
	public static class FunctionalExprContext extends ParserRuleContext {
		public ClassExpressionContext classExpression() {
			return getRuleContext(ClassExpressionContext.class,0);
		}
		public FunctionExprContext functionExpr() {
			return getRuleContext(FunctionExprContext.class,0);
		}
		public MiscContext misc() {
			return getRuleContext(MiscContext.class,0);
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
		enterRule(_localctx, 4, RULE_functionalExpr);
		try {
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				classExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				functionExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
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
	public static class ClassExpressionContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(BladePhpAntlrParser.NEW, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BladePhpAntlrParser.IDENTIFIER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
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
		enterRule(_localctx, 6, RULE_classExpression);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(NEW);
				setState(57);
				match(IDENTIFIER);
				setState(59);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(58);
					arguments();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				staticMethodAccess();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				staticFieldAccess();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				staticClassReference();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(64);
				staticAccess();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(65);
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
		enterRule(_localctx, 8, RULE_foreachDirectiveStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			if (!(this.bladeParserContext.equals(ParserContext.FOREACH))) throw new FailedPredicateException(this, "this.bladeParserContext.equals(ParserContext.FOREACH)");
			setState(69);
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
		public TerminalNode ARROW() { return getToken(BladePhpAntlrParser.ARROW, 0); }
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
		enterRule(_localctx, 10, RULE_foreachArguments);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				((ForeachArgumentsContext)_localctx).main_array = match(PHP_VARIABLE);
				setState(72);
				match(AS);
				setState(73);
				((ForeachArgumentsContext)_localctx).array_item = match(PHP_VARIABLE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				((ForeachArgumentsContext)_localctx).main_array = match(PHP_VARIABLE);
				setState(75);
				match(AS);
				setState(76);
				((ForeachArgumentsContext)_localctx).array_key = match(PHP_VARIABLE);
				setState(77);
				match(ARROW);
				setState(78);
				((ForeachArgumentsContext)_localctx).array_item = match(PHP_VARIABLE);
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
		enterRule(_localctx, 12, RULE_staticClassReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(81);
				namespace();
				}
				break;
			}
			setState(84);
			match(IDENTIFIER);
			setState(85);
			match(DOUBLE_COLON);
			setState(86);
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
		enterRule(_localctx, 14, RULE_staticMethodAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(88);
				namespace();
				}
				break;
			}
			setState(91);
			((StaticMethodAccessContext)_localctx).className = match(IDENTIFIER);
			setState(92);
			match(DOUBLE_COLON);
			setState(93);
			((StaticMethodAccessContext)_localctx).method = match(IDENTIFIER);
			setState(94);
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
		enterRule(_localctx, 16, RULE_staticFieldAccess);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(96);
					namespace();
					}
					break;
				}
				setState(99);
				((StaticFieldAccessContext)_localctx).className = match(IDENTIFIER);
				setState(100);
				match(DOUBLE_COLON);
				setState(101);
				((StaticFieldAccessContext)_localctx).const_ = match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(102);
					namespace();
					}
					break;
				}
				setState(105);
				((StaticFieldAccessContext)_localctx).className = match(IDENTIFIER);
				setState(106);
				match(DOUBLE_COLON);
				setState(107);
				((StaticFieldAccessContext)_localctx).propertyAlias = match(PHP_VARIABLE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				((StaticFieldAccessContext)_localctx).classAlias = match(PHP_VARIABLE);
				setState(109);
				match(DOUBLE_COLON);
				setState(110);
				((StaticFieldAccessContext)_localctx).const_ = match(IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				((StaticFieldAccessContext)_localctx).classAlias = match(PHP_VARIABLE);
				setState(112);
				match(DOUBLE_COLON);
				setState(113);
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
		enterRule(_localctx, 18, RULE_staticAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(116);
				namespace();
				}
				break;
			}
			setState(119);
			((StaticAccessContext)_localctx).className = match(IDENTIFIER);
			setState(120);
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
	public static class DirectMethodAccessContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(BladePhpAntlrParser.NEW, 0); }
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
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
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
		enterRule(_localctx, 20, RULE_directMethodAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(NEW);
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(123);
				namespace();
				}
				break;
			}
			setState(126);
			match(IDENTIFIER);
			setState(127);
			arguments();
			setState(128);
			match(OBJECT_OPERATOR);
			setState(129);
			match(IDENTIFIER);
			setState(130);
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
		enterRule(_localctx, 22, RULE_directAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(IDENTIFIER);
			setState(133);
			arguments();
			setState(134);
			match(OBJECT_OPERATOR);
			setState(135);
			match(IDENTIFIER);
			setState(136);
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
		enterRule(_localctx, 24, RULE_functionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(IDENTIFIER);
			setState(139);
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
		enterRule(_localctx, 26, RULE_arguments);
		int _la;
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(LPAREN);
				setState(142);
				argument();
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(143);
					match(COMMA);
					setState(144);
					argument();
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(150);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(LPAREN);
				setState(153);
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
		enterRule(_localctx, 28, RULE_namespace);
		int _la;
		try {
			int _alt;
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAMESPACE_SEPARATOR) {
					{
					setState(156);
					match(NAMESPACE_SEPARATOR);
					}
				}

				setState(161); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(159);
						match(IDENTIFIER);
						setState(160);
						match(NAMESPACE_SEPARATOR);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(163); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
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
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode PHP_VARIABLE() { return getToken(BladePhpAntlrParser.PHP_VARIABLE, 0); }
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
		enterRule(_localctx, 30, RULE_argument);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				array();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(PHP_VARIABLE);
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
		enterRule(_localctx, 32, RULE_array);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(PHP_VARIABLE);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(173);
					array_key_item();
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
	public static class Array_key_itemContext extends ParserRuleContext {
		public TerminalNode LSQUAREBRACKET() { return getToken(BladePhpAntlrParser.LSQUAREBRACKET, 0); }
		public TerminalNode PHP_VARIABLE() { return getToken(BladePhpAntlrParser.PHP_VARIABLE, 0); }
		public TerminalNode RSQUAREBRACKET() { return getToken(BladePhpAntlrParser.RSQUAREBRACKET, 0); }
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
		enterRule(_localctx, 34, RULE_array_key_item);
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(LSQUAREBRACKET);
				setState(180);
				match(PHP_VARIABLE);
				setState(181);
				match(RSQUAREBRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(LSQUAREBRACKET);
				setState(183);
				match(RSQUAREBRACKET);
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
		public TerminalNode ECHO() { return getToken(BladePhpAntlrParser.ECHO, 0); }
		public FunctionalExprContext functionalExpr() {
			return getRuleContext(FunctionalExprContext.class,0);
		}
		public TerminalNode NEW() { return getToken(BladePhpAntlrParser.NEW, 0); }
		public TerminalNode PHP_VARIABLE() { return getToken(BladePhpAntlrParser.PHP_VARIABLE, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode DOLLAR() { return getToken(BladePhpAntlrParser.DOLLAR, 0); }
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
		enterRule(_localctx, 36, RULE_misc);
		int _la;
		try {
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(ECHO);
				setState(187);
				functionalExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(NEW);
				setState(189);
				match(PHP_VARIABLE);
				setState(191);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(190);
					arguments();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				array();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(194);
					match(DOLLAR);
					}
				}

				setState(197);
				match(PHP_VARIABLE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(198);
				namespace();
				setState(199);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
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
		"\u0004\u0001$\u00cc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0005\u0000(\b\u0000\n\u0000\f\u0000+\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00012\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00027\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003<\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003C\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005P\b\u0005"+
		"\u0001\u0006\u0003\u0006S\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0003\u0007Z\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0003\bb\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\bh\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bs\b\b\u0001\t\u0003\tv\b\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n}\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u0092\b\r\n\r\f\r\u0095\t\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0003\r\u009b\b\r\u0001\u000e\u0003\u000e\u009e\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0004\u000e\u00a2\b\u000e\u000b\u000e\f\u000e\u00a3"+
		"\u0001\u000e\u0003\u000e\u00a7\b\u000e\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00ab\b\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u00af\b\u0010\n\u0010"+
		"\f\u0010\u00b2\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00b9\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00c0\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u00c4\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u00ca\b\u0012\u0001\u0012\u0000\u0000\u0013\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$\u0000\u0000\u00db\u0000)\u0001\u0000\u0000\u0000\u00021\u0001\u0000"+
		"\u0000\u0000\u00046\u0001\u0000\u0000\u0000\u0006B\u0001\u0000\u0000\u0000"+
		"\bD\u0001\u0000\u0000\u0000\nO\u0001\u0000\u0000\u0000\fR\u0001\u0000"+
		"\u0000\u0000\u000eY\u0001\u0000\u0000\u0000\u0010r\u0001\u0000\u0000\u0000"+
		"\u0012u\u0001\u0000\u0000\u0000\u0014z\u0001\u0000\u0000\u0000\u0016\u0084"+
		"\u0001\u0000\u0000\u0000\u0018\u008a\u0001\u0000\u0000\u0000\u001a\u009a"+
		"\u0001\u0000\u0000\u0000\u001c\u00a6\u0001\u0000\u0000\u0000\u001e\u00aa"+
		"\u0001\u0000\u0000\u0000 \u00ac\u0001\u0000\u0000\u0000\"\u00b8\u0001"+
		"\u0000\u0000\u0000$\u00c9\u0001\u0000\u0000\u0000&(\u0003\u0002\u0001"+
		"\u0000\'&\u0001\u0000\u0000\u0000(+\u0001\u0000\u0000\u0000)\'\u0001\u0000"+
		"\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0001\u0000\u0000\u0000+)\u0001"+
		"\u0000\u0000\u0000,-\u0005\u0000\u0000\u0001-\u0001\u0001\u0000\u0000"+
		"\u0000.2\u0005\u0019\u0000\u0000/2\u0003\b\u0004\u000002\u0003\u0004\u0002"+
		"\u00001.\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000010\u0001\u0000"+
		"\u0000\u00002\u0003\u0001\u0000\u0000\u000037\u0003\u0006\u0003\u0000"+
		"47\u0003\u0018\f\u000057\u0003$\u0012\u000063\u0001\u0000\u0000\u0000"+
		"64\u0001\u0000\u0000\u000065\u0001\u0000\u0000\u00007\u0005\u0001\u0000"+
		"\u0000\u000089\u0005\u0007\u0000\u00009;\u0005\u0012\u0000\u0000:<\u0003"+
		"\u001a\r\u0000;:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<C\u0001"+
		"\u0000\u0000\u0000=C\u0003\u000e\u0007\u0000>C\u0003\u0010\b\u0000?C\u0003"+
		"\f\u0006\u0000@C\u0003\u0012\t\u0000AC\u0003\u0014\n\u0000B8\u0001\u0000"+
		"\u0000\u0000B=\u0001\u0000\u0000\u0000B>\u0001\u0000\u0000\u0000B?\u0001"+
		"\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000"+
		"C\u0007\u0001\u0000\u0000\u0000DE\u0004\u0004\u0000\u0000EF\u0003\n\u0005"+
		"\u0000F\t\u0001\u0000\u0000\u0000GH\u0005\u0013\u0000\u0000HI\u0005\u0005"+
		"\u0000\u0000IP\u0005\u0013\u0000\u0000JK\u0005\u0013\u0000\u0000KL\u0005"+
		"\u0005\u0000\u0000LM\u0005\u0013\u0000\u0000MN\u0005\u0017\u0000\u0000"+
		"NP\u0005\u0013\u0000\u0000OG\u0001\u0000\u0000\u0000OJ\u0001\u0000\u0000"+
		"\u0000P\u000b\u0001\u0000\u0000\u0000QS\u0003\u001c\u000e\u0000RQ\u0001"+
		"\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000"+
		"TU\u0005\u0012\u0000\u0000UV\u0005\u0016\u0000\u0000VW\u0005\b\u0000\u0000"+
		"W\r\u0001\u0000\u0000\u0000XZ\u0003\u001c\u000e\u0000YX\u0001\u0000\u0000"+
		"\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0005\u0012"+
		"\u0000\u0000\\]\u0005\u0016\u0000\u0000]^\u0005\u0012\u0000\u0000^_\u0003"+
		"\u001a\r\u0000_\u000f\u0001\u0000\u0000\u0000`b\u0003\u001c\u000e\u0000"+
		"a`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000cd\u0005\u0012\u0000\u0000de\u0005\u0016\u0000\u0000es\u0005\u0012"+
		"\u0000\u0000fh\u0003\u001c\u000e\u0000gf\u0001\u0000\u0000\u0000gh\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0005\u0012\u0000\u0000"+
		"jk\u0005\u0016\u0000\u0000ks\u0005\u0013\u0000\u0000lm\u0005\u0013\u0000"+
		"\u0000mn\u0005\u0016\u0000\u0000ns\u0005\u0012\u0000\u0000op\u0005\u0013"+
		"\u0000\u0000pq\u0005\u0016\u0000\u0000qs\u0005\u0013\u0000\u0000ra\u0001"+
		"\u0000\u0000\u0000rg\u0001\u0000\u0000\u0000rl\u0001\u0000\u0000\u0000"+
		"ro\u0001\u0000\u0000\u0000s\u0011\u0001\u0000\u0000\u0000tv\u0003\u001c"+
		"\u000e\u0000ut\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001"+
		"\u0000\u0000\u0000wx\u0005\u0012\u0000\u0000xy\u0005\u0016\u0000\u0000"+
		"y\u0013\u0001\u0000\u0000\u0000z|\u0005\u0007\u0000\u0000{}\u0003\u001c"+
		"\u000e\u0000|{\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0001"+
		"\u0000\u0000\u0000~\u007f\u0005\u0012\u0000\u0000\u007f\u0080\u0003\u001a"+
		"\r\u0000\u0080\u0081\u0005\u0018\u0000\u0000\u0081\u0082\u0005\u0012\u0000"+
		"\u0000\u0082\u0083\u0003\u001a\r\u0000\u0083\u0015\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0005\u0012\u0000\u0000\u0085\u0086\u0003\u001a\r\u0000\u0086"+
		"\u0087\u0005\u0018\u0000\u0000\u0087\u0088\u0005\u0012\u0000\u0000\u0088"+
		"\u0089\u0003\u001a\r\u0000\u0089\u0017\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0005\u0012\u0000\u0000\u008b\u008c\u0003\u001a\r\u0000\u008c\u0019\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0005\f\u0000\u0000\u008e\u0093\u0003\u001e"+
		"\u000f\u0000\u008f\u0090\u0005\u000b\u0000\u0000\u0090\u0092\u0003\u001e"+
		"\u000f\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000"+
		"\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000"+
		"\u0000\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0005\r\u0000\u0000\u0097\u009b\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0005\f\u0000\u0000\u0099\u009b\u0005\r\u0000\u0000"+
		"\u009a\u008d\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000"+
		"\u009b\u001b\u0001\u0000\u0000\u0000\u009c\u009e\u0005\u0015\u0000\u0000"+
		"\u009d\u009c\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000"+
		"\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u0012\u0000\u0000"+
		"\u00a0\u00a2\u0005\u0015\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a7\u0005\u0015\u0000\u0000\u00a6\u009d\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u001d\u0001\u0000\u0000\u0000"+
		"\u00a8\u00ab\u0003 \u0010\u0000\u00a9\u00ab\u0005\u0013\u0000\u0000\u00aa"+
		"\u00a8\u0001\u0000\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab"+
		"\u001f\u0001\u0000\u0000\u0000\u00ac\u00b0\u0005\u0013\u0000\u0000\u00ad"+
		"\u00af\u0003\"\u0011\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b1!\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0005\u000e\u0000\u0000\u00b4\u00b5\u0005"+
		"\u0013\u0000\u0000\u00b5\u00b9\u0005\u000f\u0000\u0000\u00b6\u00b7\u0005"+
		"\u000e\u0000\u0000\u00b7\u00b9\u0005\u000f\u0000\u0000\u00b8\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9#\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0005\u0006\u0000\u0000\u00bb\u00ca\u0003\u0004"+
		"\u0002\u0000\u00bc\u00bd\u0005\u0007\u0000\u0000\u00bd\u00bf\u0005\u0013"+
		"\u0000\u0000\u00be\u00c0\u0003\u001a\r\u0000\u00bf\u00be\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00ca\u0001\u0000\u0000"+
		"\u0000\u00c1\u00ca\u0003 \u0010\u0000\u00c2\u00c4\u0005\u0014\u0000\u0000"+
		"\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00ca\u0005\u0013\u0000\u0000"+
		"\u00c6\u00c7\u0003\u001c\u000e\u0000\u00c7\u00c8\u0005\u0012\u0000\u0000"+
		"\u00c8\u00ca\u0001\u0000\u0000\u0000\u00c9\u00ba\u0001\u0000\u0000\u0000"+
		"\u00c9\u00bc\u0001\u0000\u0000\u0000\u00c9\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c9\u00c3\u0001\u0000\u0000\u0000\u00c9\u00c6\u0001\u0000\u0000\u0000"+
		"\u00ca%\u0001\u0000\u0000\u0000\u0018)16;BORYagru|\u0093\u009a\u009d\u00a3"+
		"\u00a6\u00aa\u00b0\u00b8\u00bf\u00c3\u00c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}