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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BladePhpAntlrParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HTML=1, BLADE_COMMENT=2, LINE_COMMENT=3, ARRAY=4, AS=5, ECHO=6, NEW=7, 
		CLASS=8, FUNCTION=9, LANG_CONSTRUCT=10, COMMA=11, LPAREN=12, RPAREN=13, 
		LSQUAREBRACKET=14, RSQUAREBRACKET=15, LCURLYBRACE=16, RCURLYBRACE=17, 
		IDENTIFIER=18, PHP_VARIABLE=19, NAMESPACE_SEPARATOR=20, DOUBLE_COLON=21, 
		OBJECT_OPERATOR=22, STRING_LITERAL=23, STYLE_COMMENT=24, WS=25, OTHER=26, 
		BLADE_COMMENT_START=27, EMAIL_SUBSTRING=28, VERSION_WITH_AT=29, BLADE_COMMENT_END=30, 
		BLADE_COMMENT_PEEK=31, BLADE_COMMENT_MORE=32, BLADE_COMMENT_EOF=33;
	public static final int
		RULE_expression = 0, RULE_exprStatement = 1, RULE_staticClassReference = 2, 
		RULE_staticMethodAccess = 3, RULE_staticFieldAccess = 4, RULE_staticAccess = 5, 
		RULE_directMethodAccess = 6, RULE_directAccess = 7, RULE_functionExpr = 8, 
		RULE_arguments = 9, RULE_namespace = 10, RULE_argument = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "exprStatement", "staticClassReference", "staticMethodAccess", 
			"staticFieldAccess", "staticAccess", "directMethodAccess", "directAccess", 
			"functionExpr", "arguments", "namespace", "argument"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'array'", "'as'", "'echo'", "'new'", "'class'", 
			"'function'", "'empty'", "','", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			null, null, "'\\'", "'::'", "'->'", null, null, null, null, "'{{--'", 
			null, null, "'--}}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HTML", "BLADE_COMMENT", "LINE_COMMENT", "ARRAY", "AS", "ECHO", 
			"NEW", "CLASS", "FUNCTION", "LANG_CONSTRUCT", "COMMA", "LPAREN", "RPAREN", 
			"LSQUAREBRACKET", "RSQUAREBRACKET", "LCURLYBRACE", "RCURLYBRACE", "IDENTIFIER", 
			"PHP_VARIABLE", "NAMESPACE_SEPARATOR", "DOUBLE_COLON", "OBJECT_OPERATOR", 
			"STRING_LITERAL", "STYLE_COMMENT", "WS", "OTHER", "BLADE_COMMENT_START", 
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1310848L) != 0)) {
				{
				{
				setState(24);
				exprStatement();
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
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
		int _la;
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				match(NEW);
				setState(33);
				match(IDENTIFIER);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(34);
					arguments();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				staticMethodAccess();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				staticFieldAccess();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				staticClassReference();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				staticAccess();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
				directMethodAccess();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(42);
				functionExpr();
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
		enterRule(_localctx, 4, RULE_staticClassReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(45);
				namespace();
				}
				break;
			}
			setState(48);
			match(IDENTIFIER);
			setState(49);
			match(DOUBLE_COLON);
			setState(50);
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
		enterRule(_localctx, 6, RULE_staticMethodAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(52);
				namespace();
				}
				break;
			}
			setState(55);
			((StaticMethodAccessContext)_localctx).className = match(IDENTIFIER);
			setState(56);
			match(DOUBLE_COLON);
			setState(57);
			((StaticMethodAccessContext)_localctx).method = match(IDENTIFIER);
			setState(58);
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
		public TerminalNode DOUBLE_COLON() { return getToken(BladePhpAntlrParser.DOUBLE_COLON, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(BladePhpAntlrParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BladePhpAntlrParser.IDENTIFIER, i);
		}
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
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
		enterRule(_localctx, 8, RULE_staticFieldAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(60);
				namespace();
				}
				break;
			}
			setState(63);
			((StaticFieldAccessContext)_localctx).className = match(IDENTIFIER);
			setState(64);
			match(DOUBLE_COLON);
			setState(65);
			((StaticFieldAccessContext)_localctx).const_ = match(IDENTIFIER);
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
		enterRule(_localctx, 10, RULE_staticAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(67);
				namespace();
				}
				break;
			}
			setState(70);
			((StaticAccessContext)_localctx).className = match(IDENTIFIER);
			setState(71);
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
		enterRule(_localctx, 12, RULE_directMethodAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(NEW);
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(74);
				namespace();
				}
				break;
			}
			setState(77);
			match(IDENTIFIER);
			setState(78);
			arguments();
			setState(79);
			match(OBJECT_OPERATOR);
			setState(80);
			match(IDENTIFIER);
			setState(81);
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
		enterRule(_localctx, 14, RULE_directAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(IDENTIFIER);
			setState(84);
			arguments();
			setState(85);
			match(OBJECT_OPERATOR);
			setState(86);
			match(IDENTIFIER);
			setState(87);
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
		enterRule(_localctx, 16, RULE_functionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(IDENTIFIER);
			setState(90);
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
		enterRule(_localctx, 18, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(LPAREN);
			setState(93);
			argument();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(94);
				match(COMMA);
				setState(95);
				argument();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			match(RPAREN);
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
		enterRule(_localctx, 20, RULE_namespace);
		int _la;
		try {
			int _alt;
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NAMESPACE_SEPARATOR) {
					{
					setState(103);
					match(NAMESPACE_SEPARATOR);
					}
				}

				setState(108); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(106);
						match(IDENTIFIER);
						setState(107);
						match(NAMESPACE_SEPARATOR);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(110); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
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
		enterRule(_localctx, 22, RULE_argument);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PHP_VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(PHP_VARIABLE);
				}
				break;
			case EOF:
			case NEW:
			case IDENTIFIER:
			case NAMESPACE_SEPARATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				expression();
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

	public static final String _serializedATN =
		"\u0004\u0001!x\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001\u0000"+
		"\u0005\u0000\u001a\b\u0000\n\u0000\f\u0000\u001d\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001$\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001,\b\u0001\u0001\u0002\u0003\u0002/\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0003\u00036\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0003\u0004"+
		">\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0003\u0005E\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0003\u0006L\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\ta\b\t\n\t\f\td\t\t\u0001\t\u0001\t\u0001\n\u0003"+
		"\ni\b\n\u0001\n\u0001\n\u0004\nm\b\n\u000b\n\f\nn\u0001\n\u0003\nr\b\n"+
		"\u0001\u000b\u0001\u000b\u0003\u000bv\b\u000b\u0001\u000b\u0000\u0000"+
		"\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0000"+
		"}\u0000\u001b\u0001\u0000\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u0004"+
		".\u0001\u0000\u0000\u0000\u00065\u0001\u0000\u0000\u0000\b=\u0001\u0000"+
		"\u0000\u0000\nD\u0001\u0000\u0000\u0000\fI\u0001\u0000\u0000\u0000\u000e"+
		"S\u0001\u0000\u0000\u0000\u0010Y\u0001\u0000\u0000\u0000\u0012\\\u0001"+
		"\u0000\u0000\u0000\u0014q\u0001\u0000\u0000\u0000\u0016u\u0001\u0000\u0000"+
		"\u0000\u0018\u001a\u0003\u0002\u0001\u0000\u0019\u0018\u0001\u0000\u0000"+
		"\u0000\u001a\u001d\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000"+
		"\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001e\u0001\u0000\u0000"+
		"\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0000\u0000"+
		"\u0001\u001f\u0001\u0001\u0000\u0000\u0000 !\u0005\u0007\u0000\u0000!"+
		"#\u0005\u0012\u0000\u0000\"$\u0003\u0012\t\u0000#\"\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$,\u0001\u0000\u0000\u0000%,\u0003\u0006"+
		"\u0003\u0000&,\u0003\b\u0004\u0000\',\u0003\u0004\u0002\u0000(,\u0003"+
		"\n\u0005\u0000),\u0003\f\u0006\u0000*,\u0003\u0010\b\u0000+ \u0001\u0000"+
		"\u0000\u0000+%\u0001\u0000\u0000\u0000+&\u0001\u0000\u0000\u0000+\'\u0001"+
		"\u0000\u0000\u0000+(\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000"+
		"+*\u0001\u0000\u0000\u0000,\u0003\u0001\u0000\u0000\u0000-/\u0003\u0014"+
		"\n\u0000.-\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0001\u0000"+
		"\u0000\u000001\u0005\u0012\u0000\u000012\u0005\u0015\u0000\u000023\u0005"+
		"\b\u0000\u00003\u0005\u0001\u0000\u0000\u000046\u0003\u0014\n\u000054"+
		"\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0001\u0000\u0000"+
		"\u000078\u0005\u0012\u0000\u000089\u0005\u0015\u0000\u00009:\u0005\u0012"+
		"\u0000\u0000:;\u0003\u0012\t\u0000;\u0007\u0001\u0000\u0000\u0000<>\u0003"+
		"\u0014\n\u0000=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?@\u0005\u0012\u0000\u0000@A\u0005\u0015\u0000\u0000"+
		"AB\u0005\u0012\u0000\u0000B\t\u0001\u0000\u0000\u0000CE\u0003\u0014\n"+
		"\u0000DC\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FG\u0005\u0012\u0000\u0000GH\u0005\u0015\u0000\u0000H\u000b"+
		"\u0001\u0000\u0000\u0000IK\u0005\u0007\u0000\u0000JL\u0003\u0014\n\u0000"+
		"KJ\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000MN\u0005\u0012\u0000\u0000NO\u0003\u0012\t\u0000OP\u0005\u0016\u0000"+
		"\u0000PQ\u0005\u0012\u0000\u0000QR\u0003\u0012\t\u0000R\r\u0001\u0000"+
		"\u0000\u0000ST\u0005\u0012\u0000\u0000TU\u0003\u0012\t\u0000UV\u0005\u0016"+
		"\u0000\u0000VW\u0005\u0012\u0000\u0000WX\u0003\u0012\t\u0000X\u000f\u0001"+
		"\u0000\u0000\u0000YZ\u0005\u0012\u0000\u0000Z[\u0003\u0012\t\u0000[\u0011"+
		"\u0001\u0000\u0000\u0000\\]\u0005\f\u0000\u0000]b\u0003\u0016\u000b\u0000"+
		"^_\u0005\u000b\u0000\u0000_a\u0003\u0016\u000b\u0000`^\u0001\u0000\u0000"+
		"\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000ce\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000ef\u0005"+
		"\r\u0000\u0000f\u0013\u0001\u0000\u0000\u0000gi\u0005\u0014\u0000\u0000"+
		"hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000il\u0001\u0000\u0000"+
		"\u0000jk\u0005\u0012\u0000\u0000km\u0005\u0014\u0000\u0000lj\u0001\u0000"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001"+
		"\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pr\u0005\u0014\u0000\u0000"+
		"qh\u0001\u0000\u0000\u0000qp\u0001\u0000\u0000\u0000r\u0015\u0001\u0000"+
		"\u0000\u0000sv\u0005\u0013\u0000\u0000tv\u0003\u0000\u0000\u0000us\u0001"+
		"\u0000\u0000\u0000ut\u0001\u0000\u0000\u0000v\u0017\u0001\u0000\u0000"+
		"\u0000\r\u001b#+.5=DKbhnqu";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}