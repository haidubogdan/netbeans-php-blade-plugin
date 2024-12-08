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
		RULE_expression = 0, RULE_exprStatement = 1, RULE_foreachDirectiveStatement = 2, 
		RULE_foreachArguments = 3, RULE_staticClassReference = 4, RULE_staticMethodAccess = 5, 
		RULE_staticFieldAccess = 6, RULE_staticAccess = 7, RULE_directMethodAccess = 8, 
		RULE_directAccess = 9, RULE_functionExpr = 10, RULE_arguments = 11, RULE_namespace = 12, 
		RULE_argument = 13, RULE_misc = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "exprStatement", "foreachDirectiveStatement", "foreachArguments", 
			"staticClassReference", "staticMethodAccess", "staticFieldAccess", "staticAccess", 
			"directMethodAccess", "directAccess", "functionExpr", "arguments", "namespace", 
			"argument", "misc"
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
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(30);
					exprStatement();
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(36);
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
		public FunctionExprContext functionExpr() {
			return getRuleContext(FunctionExprContext.class,0);
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
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(SEMI_COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				foreachDirectiveStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				match(NEW);
				setState(41);
				match(IDENTIFIER);
				setState(43);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(42);
					arguments();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(45);
				staticMethodAccess();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(46);
				staticFieldAccess();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(47);
				staticClassReference();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(48);
				staticAccess();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(49);
				directMethodAccess();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(50);
				functionExpr();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(51);
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
		enterRule(_localctx, 4, RULE_foreachDirectiveStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			if (!(this.bladeParserContext.equals(ParserContext.FOREACH))) throw new FailedPredicateException(this, "this.bladeParserContext.equals(ParserContext.FOREACH)");
			setState(55);
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
		enterRule(_localctx, 6, RULE_foreachArguments);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				((ForeachArgumentsContext)_localctx).main_array = match(PHP_VARIABLE);
				setState(58);
				match(AS);
				setState(59);
				((ForeachArgumentsContext)_localctx).array_item = match(PHP_VARIABLE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				((ForeachArgumentsContext)_localctx).main_array = match(PHP_VARIABLE);
				setState(61);
				match(AS);
				setState(62);
				((ForeachArgumentsContext)_localctx).array_key = match(PHP_VARIABLE);
				setState(63);
				match(ARROW);
				setState(64);
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
		enterRule(_localctx, 8, RULE_staticClassReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(67);
				namespace();
				}
				break;
			}
			setState(70);
			match(IDENTIFIER);
			setState(71);
			match(DOUBLE_COLON);
			setState(72);
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
		enterRule(_localctx, 10, RULE_staticMethodAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(74);
				namespace();
				}
				break;
			}
			setState(77);
			((StaticMethodAccessContext)_localctx).className = match(IDENTIFIER);
			setState(78);
			match(DOUBLE_COLON);
			setState(79);
			((StaticMethodAccessContext)_localctx).method = match(IDENTIFIER);
			setState(80);
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
		enterRule(_localctx, 12, RULE_staticFieldAccess);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(82);
					namespace();
					}
					break;
				}
				setState(85);
				((StaticFieldAccessContext)_localctx).className = match(IDENTIFIER);
				setState(86);
				match(DOUBLE_COLON);
				setState(87);
				((StaticFieldAccessContext)_localctx).const_ = match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
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
				((StaticFieldAccessContext)_localctx).className = match(IDENTIFIER);
				setState(92);
				match(DOUBLE_COLON);
				setState(93);
				((StaticFieldAccessContext)_localctx).propertyAlias = match(PHP_VARIABLE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				((StaticFieldAccessContext)_localctx).classAlias = match(PHP_VARIABLE);
				setState(95);
				match(DOUBLE_COLON);
				setState(96);
				((StaticFieldAccessContext)_localctx).const_ = match(IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				((StaticFieldAccessContext)_localctx).classAlias = match(PHP_VARIABLE);
				setState(98);
				match(DOUBLE_COLON);
				setState(99);
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
		enterRule(_localctx, 14, RULE_staticAccess);
		try {
			enterOuterAlt(_localctx, 1);
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
			((StaticAccessContext)_localctx).className = match(IDENTIFIER);
			setState(106);
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
		enterRule(_localctx, 16, RULE_directMethodAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(NEW);
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(109);
				namespace();
				}
				break;
			}
			setState(112);
			match(IDENTIFIER);
			setState(113);
			arguments();
			setState(114);
			match(OBJECT_OPERATOR);
			setState(115);
			match(IDENTIFIER);
			setState(116);
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
		enterRule(_localctx, 18, RULE_directAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(IDENTIFIER);
			setState(119);
			arguments();
			setState(120);
			match(OBJECT_OPERATOR);
			setState(121);
			match(IDENTIFIER);
			setState(122);
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
		enterRule(_localctx, 20, RULE_functionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(IDENTIFIER);
			setState(125);
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
		enterRule(_localctx, 22, RULE_arguments);
		int _la;
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(LPAREN);
				setState(128);
				argument();
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(129);
					match(COMMA);
					setState(130);
					argument();
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(136);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(LPAREN);
				setState(139);
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
		enterRule(_localctx, 24, RULE_namespace);
		int _la;
		try {
			int _alt;
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAMESPACE_SEPARATOR) {
					{
					setState(142);
					match(NAMESPACE_SEPARATOR);
					}
				}

				setState(147); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(145);
						match(IDENTIFIER);
						setState(146);
						match(NAMESPACE_SEPARATOR);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(149); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
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
		public TerminalNode PHP_VARIABLE() { return getToken(BladePhpAntlrParser.PHP_VARIABLE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_argument);
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(PHP_VARIABLE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				expression();
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
		enterRule(_localctx, 28, RULE_misc);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEW:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(NEW);
				setState(159);
				match(PHP_VARIABLE);
				setState(161);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(160);
					arguments();
					}
					break;
				}
				}
				break;
			case PHP_VARIABLE:
			case DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(163);
					match(DOLLAR);
					}
				}

				setState(166);
				match(PHP_VARIABLE);
				}
				break;
			case IDENTIFIER:
			case NAMESPACE_SEPARATOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				namespace();
				setState(168);
				((MiscContext)_localctx).className = match(IDENTIFIER);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
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
		"\u0004\u0001$\u00ad\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001,\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u00015\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003B\b\u0003\u0001\u0004\u0003\u0004"+
		"E\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0003\u0005L\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0003\u0006T\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006Z\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006e\b\u0006\u0001\u0007\u0003\u0007h\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0003\bo\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u0084\b\u000b\n\u000b\f\u000b\u0087\t\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u008d\b\u000b\u0001"+
		"\f\u0003\f\u0090\b\f\u0001\f\u0001\f\u0004\f\u0094\b\f\u000b\f\f\f\u0095"+
		"\u0001\f\u0003\f\u0099\b\f\u0001\r\u0001\r\u0003\r\u009d\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u00a2\b\u000e\u0001\u000e\u0003\u000e"+
		"\u00a5\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u00ab\b\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0000\u00bc"+
		"\u0000!\u0001\u0000\u0000\u0000\u00024\u0001\u0000\u0000\u0000\u00046"+
		"\u0001\u0000\u0000\u0000\u0006A\u0001\u0000\u0000\u0000\bD\u0001\u0000"+
		"\u0000\u0000\nK\u0001\u0000\u0000\u0000\fd\u0001\u0000\u0000\u0000\u000e"+
		"g\u0001\u0000\u0000\u0000\u0010l\u0001\u0000\u0000\u0000\u0012v\u0001"+
		"\u0000\u0000\u0000\u0014|\u0001\u0000\u0000\u0000\u0016\u008c\u0001\u0000"+
		"\u0000\u0000\u0018\u0098\u0001\u0000\u0000\u0000\u001a\u009c\u0001\u0000"+
		"\u0000\u0000\u001c\u00aa\u0001\u0000\u0000\u0000\u001e \u0003\u0002\u0001"+
		"\u0000\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!"+
		"\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000"+
		"\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0005\u0000\u0000\u0001%\u0001"+
		"\u0001\u0000\u0000\u0000&5\u0005\u0019\u0000\u0000\'5\u0003\u0004\u0002"+
		"\u0000()\u0005\u0007\u0000\u0000)+\u0005\u0012\u0000\u0000*,\u0003\u0016"+
		"\u000b\u0000+*\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,5\u0001"+
		"\u0000\u0000\u0000-5\u0003\n\u0005\u0000.5\u0003\f\u0006\u0000/5\u0003"+
		"\b\u0004\u000005\u0003\u000e\u0007\u000015\u0003\u0010\b\u000025\u0003"+
		"\u0014\n\u000035\u0003\u001c\u000e\u00004&\u0001\u0000\u0000\u00004\'"+
		"\u0001\u0000\u0000\u00004(\u0001\u0000\u0000\u00004-\u0001\u0000\u0000"+
		"\u00004.\u0001\u0000\u0000\u00004/\u0001\u0000\u0000\u000040\u0001\u0000"+
		"\u0000\u000041\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000043\u0001"+
		"\u0000\u0000\u00005\u0003\u0001\u0000\u0000\u000067\u0004\u0002\u0000"+
		"\u000078\u0003\u0006\u0003\u00008\u0005\u0001\u0000\u0000\u00009:\u0005"+
		"\u0013\u0000\u0000:;\u0005\u0005\u0000\u0000;B\u0005\u0013\u0000\u0000"+
		"<=\u0005\u0013\u0000\u0000=>\u0005\u0005\u0000\u0000>?\u0005\u0013\u0000"+
		"\u0000?@\u0005\u0017\u0000\u0000@B\u0005\u0013\u0000\u0000A9\u0001\u0000"+
		"\u0000\u0000A<\u0001\u0000\u0000\u0000B\u0007\u0001\u0000\u0000\u0000"+
		"CE\u0003\u0018\f\u0000DC\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000"+
		"EF\u0001\u0000\u0000\u0000FG\u0005\u0012\u0000\u0000GH\u0005\u0016\u0000"+
		"\u0000HI\u0005\b\u0000\u0000I\t\u0001\u0000\u0000\u0000JL\u0003\u0018"+
		"\f\u0000KJ\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000"+
		"\u0000\u0000MN\u0005\u0012\u0000\u0000NO\u0005\u0016\u0000\u0000OP\u0005"+
		"\u0012\u0000\u0000PQ\u0003\u0016\u000b\u0000Q\u000b\u0001\u0000\u0000"+
		"\u0000RT\u0003\u0018\f\u0000SR\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000UV\u0005\u0012\u0000\u0000VW\u0005\u0016"+
		"\u0000\u0000We\u0005\u0012\u0000\u0000XZ\u0003\u0018\f\u0000YX\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0005"+
		"\u0012\u0000\u0000\\]\u0005\u0016\u0000\u0000]e\u0005\u0013\u0000\u0000"+
		"^_\u0005\u0013\u0000\u0000_`\u0005\u0016\u0000\u0000`e\u0005\u0012\u0000"+
		"\u0000ab\u0005\u0013\u0000\u0000bc\u0005\u0016\u0000\u0000ce\u0005\u0013"+
		"\u0000\u0000dS\u0001\u0000\u0000\u0000dY\u0001\u0000\u0000\u0000d^\u0001"+
		"\u0000\u0000\u0000da\u0001\u0000\u0000\u0000e\r\u0001\u0000\u0000\u0000"+
		"fh\u0003\u0018\f\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hi\u0001\u0000\u0000\u0000ij\u0005\u0012\u0000\u0000jk\u0005\u0016\u0000"+
		"\u0000k\u000f\u0001\u0000\u0000\u0000ln\u0005\u0007\u0000\u0000mo\u0003"+
		"\u0018\f\u0000nm\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pq\u0005\u0012\u0000\u0000qr\u0003\u0016\u000b\u0000"+
		"rs\u0005\u0018\u0000\u0000st\u0005\u0012\u0000\u0000tu\u0003\u0016\u000b"+
		"\u0000u\u0011\u0001\u0000\u0000\u0000vw\u0005\u0012\u0000\u0000wx\u0003"+
		"\u0016\u000b\u0000xy\u0005\u0018\u0000\u0000yz\u0005\u0012\u0000\u0000"+
		"z{\u0003\u0016\u000b\u0000{\u0013\u0001\u0000\u0000\u0000|}\u0005\u0012"+
		"\u0000\u0000}~\u0003\u0016\u000b\u0000~\u0015\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0005\f\u0000\u0000\u0080\u0085\u0003\u001a\r\u0000\u0081"+
		"\u0082\u0005\u000b\u0000\u0000\u0082\u0084\u0003\u001a\r\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0083"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0088"+
		"\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0005\r\u0000\u0000\u0089\u008d\u0001\u0000\u0000\u0000\u008a\u008b\u0005"+
		"\f\u0000\u0000\u008b\u008d\u0005\r\u0000\u0000\u008c\u007f\u0001\u0000"+
		"\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u0017\u0001\u0000"+
		"\u0000\u0000\u008e\u0090\u0005\u0015\u0000\u0000\u008f\u008e\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0005\u0012\u0000\u0000\u0092\u0094\u0005\u0015"+
		"\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000"+
		"\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000"+
		"\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0099\u0005\u0015"+
		"\u0000\u0000\u0098\u008f\u0001\u0000\u0000\u0000\u0098\u0097\u0001\u0000"+
		"\u0000\u0000\u0099\u0019\u0001\u0000\u0000\u0000\u009a\u009d\u0005\u0013"+
		"\u0000\u0000\u009b\u009d\u0003\u0000\u0000\u0000\u009c\u009a\u0001\u0000"+
		"\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u001b\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0005\u0007\u0000\u0000\u009f\u00a1\u0005\u0013"+
		"\u0000\u0000\u00a0\u00a2\u0003\u0016\u000b\u0000\u00a1\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00ab\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a5\u0005\u0014\u0000\u0000\u00a4\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a6\u00ab\u0005\u0013\u0000\u0000\u00a7\u00a8\u0003\u0018"+
		"\f\u0000\u00a8\u00a9\u0005\u0012\u0000\u0000\u00a9\u00ab\u0001\u0000\u0000"+
		"\u0000\u00aa\u009e\u0001\u0000\u0000\u0000\u00aa\u00a4\u0001\u0000\u0000"+
		"\u0000\u00aa\u00a7\u0001\u0000\u0000\u0000\u00ab\u001d\u0001\u0000\u0000"+
		"\u0000\u0014!+4ADKSYdgn\u0085\u008c\u008f\u0095\u0098\u009c\u00a1\u00a4"+
		"\u00aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}