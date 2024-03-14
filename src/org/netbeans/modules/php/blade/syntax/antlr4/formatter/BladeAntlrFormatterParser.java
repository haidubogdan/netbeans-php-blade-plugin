// Generated from java-escape by ANTLR 4.11.1

  package org.netbeans.modules.php.blade.syntax.antlr4.formatter;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BladeAntlrFormatterParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HTML=1, PHP_CODE=2, PHP_INLINE=3, D_IF=4, D_ENDIF=5, D_FOREACH=6, D_ENDFOREACH=7, 
		NON_PARAM_DIRECTIVE=8, D_INLINE_DIRECTIVE=9, SG_QUOTE=10, DB_QUOTE=11, 
		HTML_CLOSE_TAG=12, GT_SYMBOL=13, D_PHP=14, AT=15, WS=16, NL=17, OTHER=18, 
		D_ARG_LPAREN=19, D_ARG_RPAREN=20, PHP_EXPR=21, EXIT_EOF=22, D_ENDPHP=23;
	public static final int
		RULE_file = 0, RULE_statement = 1, RULE_indetable_element = 2, RULE_html_indent = 3, 
		RULE_block_start = 4, RULE_block_directive_name = 5, RULE_block_end = 6, 
		RULE_inline_identable_element = 7, RULE_nl_with_space_before = 8, RULE_nl_with_space = 9, 
		RULE_static_element = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "statement", "indetable_element", "html_indent", "block_start", 
			"block_directive_name", "block_end", "inline_identable_element", "nl_with_space_before", 
			"nl_with_space", "static_element"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'@endif'", null, "'@endforeach'", null, 
			null, "'''", "'\"'", null, "'>'", null, "'@'", null, null, null, "'('", 
			"')'", null, null, "'@endphp'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HTML", "PHP_CODE", "PHP_INLINE", "D_IF", "D_ENDIF", "D_FOREACH", 
			"D_ENDFOREACH", "NON_PARAM_DIRECTIVE", "D_INLINE_DIRECTIVE", "SG_QUOTE", 
			"DB_QUOTE", "HTML_CLOSE_TAG", "GT_SYMBOL", "D_PHP", "AT", "WS", "NL", 
			"OTHER", "D_ARG_LPAREN", "D_ARG_RPAREN", "PHP_EXPR", "EXIT_EOF", "D_ENDPHP"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BladeAntlrFormatterParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BladeAntlrFormatterParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 491346L) != 0) {
				{
				{
				setState(22);
				statement();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
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
	public static class StatementContext extends ParserRuleContext {
		public Html_indentContext html_indent() {
			return getRuleContext(Html_indentContext.class,0);
		}
		public Indetable_elementContext indetable_element() {
			return getRuleContext(Indetable_elementContext.class,0);
		}
		public Inline_identable_elementContext inline_identable_element() {
			return getRuleContext(Inline_identable_elementContext.class,0);
		}
		public Static_elementContext static_element() {
			return getRuleContext(Static_elementContext.class,0);
		}
		public Nl_with_space_beforeContext nl_with_space_before() {
			return getRuleContext(Nl_with_space_beforeContext.class,0);
		}
		public TerminalNode SG_QUOTE() { return getToken(BladeAntlrFormatterParser.SG_QUOTE, 0); }
		public TerminalNode DB_QUOTE() { return getToken(BladeAntlrFormatterParser.DB_QUOTE, 0); }
		public TerminalNode GT_SYMBOL() { return getToken(BladeAntlrFormatterParser.GT_SYMBOL, 0); }
		public TerminalNode HTML_CLOSE_TAG() { return getToken(BladeAntlrFormatterParser.HTML_CLOSE_TAG, 0); }
		public TerminalNode NL() { return getToken(BladeAntlrFormatterParser.NL, 0); }
		public TerminalNode WS() { return getToken(BladeAntlrFormatterParser.WS, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				html_indent();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				indetable_element();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				inline_identable_element();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				static_element();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(34);
				nl_with_space_before();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(35);
				_la = _input.LA(1);
				if ( !(_la==SG_QUOTE || _la==DB_QUOTE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(36);
				match(GT_SYMBOL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(37);
				match(HTML_CLOSE_TAG);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(38);
				_la = _input.LA(1);
				if ( !(_la==WS || _la==NL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
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
	public static class Indetable_elementContext extends ParserRuleContext {
		public Block_startContext block_start() {
			return getRuleContext(Block_startContext.class,0);
		}
		public Block_endContext block_end() {
			return getRuleContext(Block_endContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Nl_with_spaceContext nl_with_space() {
			return getRuleContext(Nl_with_spaceContext.class,0);
		}
		public Indetable_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indetable_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterIndetable_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitIndetable_element(this);
		}
	}

	public final Indetable_elementContext indetable_element() throws RecognitionException {
		Indetable_elementContext _localctx = new Indetable_elementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_indetable_element);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			block_start();
			setState(43); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(42);
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(45); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(47);
				nl_with_space();
				}
			}

			setState(50);
			block_end();
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
	public static class Html_indentContext extends ParserRuleContext {
		public TerminalNode GT_SYMBOL() { return getToken(BladeAntlrFormatterParser.GT_SYMBOL, 0); }
		public TerminalNode NL() { return getToken(BladeAntlrFormatterParser.NL, 0); }
		public List<TerminalNode> WS() { return getTokens(BladeAntlrFormatterParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(BladeAntlrFormatterParser.WS, i);
		}
		public Html_indentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html_indent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterHtml_indent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitHtml_indent(this);
		}
	}

	public final Html_indentContext html_indent() throws RecognitionException {
		Html_indentContext _localctx = new Html_indentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_html_indent);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(GT_SYMBOL);
			setState(53);
			match(NL);
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(54);
					match(WS);
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
	public static class Block_startContext extends ParserRuleContext {
		public Nl_with_space_beforeContext ws_before;
		public Block_directive_nameContext block_directive_name() {
			return getRuleContext(Block_directive_nameContext.class,0);
		}
		public TerminalNode D_ARG_LPAREN() { return getToken(BladeAntlrFormatterParser.D_ARG_LPAREN, 0); }
		public TerminalNode D_ARG_RPAREN() { return getToken(BladeAntlrFormatterParser.D_ARG_RPAREN, 0); }
		public Nl_with_space_beforeContext nl_with_space_before() {
			return getRuleContext(Nl_with_space_beforeContext.class,0);
		}
		public Block_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterBlock_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitBlock_start(this);
		}
	}

	public final Block_startContext block_start() throws RecognitionException {
		Block_startContext _localctx = new Block_startContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(60);
				((Block_startContext)_localctx).ws_before = nl_with_space_before();
				}
			}

			setState(63);
			block_directive_name();
			setState(64);
			match(D_ARG_LPAREN);
			setState(65);
			match(D_ARG_RPAREN);
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
	public static class Block_directive_nameContext extends ParserRuleContext {
		public TerminalNode D_IF() { return getToken(BladeAntlrFormatterParser.D_IF, 0); }
		public TerminalNode D_FOREACH() { return getToken(BladeAntlrFormatterParser.D_FOREACH, 0); }
		public Block_directive_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_directive_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterBlock_directive_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitBlock_directive_name(this);
		}
	}

	public final Block_directive_nameContext block_directive_name() throws RecognitionException {
		Block_directive_nameContext _localctx = new Block_directive_nameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block_directive_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_la = _input.LA(1);
			if ( !(_la==D_IF || _la==D_FOREACH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class Block_endContext extends ParserRuleContext {
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrFormatterParser.D_ENDIF, 0); }
		public TerminalNode D_ENDFOREACH() { return getToken(BladeAntlrFormatterParser.D_ENDFOREACH, 0); }
		public Block_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterBlock_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitBlock_end(this);
		}
	}

	public final Block_endContext block_end() throws RecognitionException {
		Block_endContext _localctx = new Block_endContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block_end);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !(_la==D_ENDIF || _la==D_ENDFOREACH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class Inline_identable_elementContext extends ParserRuleContext {
		public TerminalNode D_INLINE_DIRECTIVE() { return getToken(BladeAntlrFormatterParser.D_INLINE_DIRECTIVE, 0); }
		public TerminalNode NON_PARAM_DIRECTIVE() { return getToken(BladeAntlrFormatterParser.NON_PARAM_DIRECTIVE, 0); }
		public Inline_identable_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_identable_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterInline_identable_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitInline_identable_element(this);
		}
	}

	public final Inline_identable_elementContext inline_identable_element() throws RecognitionException {
		Inline_identable_elementContext _localctx = new Inline_identable_elementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_inline_identable_element);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !(_la==NON_PARAM_DIRECTIVE || _la==D_INLINE_DIRECTIVE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class Nl_with_space_beforeContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(BladeAntlrFormatterParser.NL, 0); }
		public List<TerminalNode> WS() { return getTokens(BladeAntlrFormatterParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(BladeAntlrFormatterParser.WS, i);
		}
		public Nl_with_space_beforeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nl_with_space_before; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterNl_with_space_before(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitNl_with_space_before(this);
		}
	}

	public final Nl_with_space_beforeContext nl_with_space_before() throws RecognitionException {
		Nl_with_space_beforeContext _localctx = new Nl_with_space_beforeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_nl_with_space_before);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(NL);
			setState(77);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(74);
					match(WS);
					}
					} 
				}
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
	public static class Nl_with_spaceContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(BladeAntlrFormatterParser.NL, 0); }
		public List<TerminalNode> WS() { return getTokens(BladeAntlrFormatterParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(BladeAntlrFormatterParser.WS, i);
		}
		public Nl_with_spaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nl_with_space; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterNl_with_space(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitNl_with_space(this);
		}
	}

	public final Nl_with_spaceContext nl_with_space() throws RecognitionException {
		Nl_with_spaceContext _localctx = new Nl_with_spaceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nl_with_space);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(NL);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(81);
				match(WS);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class Static_elementContext extends ParserRuleContext {
		public TerminalNode D_PHP() { return getToken(BladeAntlrFormatterParser.D_PHP, 0); }
		public TerminalNode D_ENDPHP() { return getToken(BladeAntlrFormatterParser.D_ENDPHP, 0); }
		public List<TerminalNode> PHP_CODE() { return getTokens(BladeAntlrFormatterParser.PHP_CODE); }
		public TerminalNode PHP_CODE(int i) {
			return getToken(BladeAntlrFormatterParser.PHP_CODE, i);
		}
		public TerminalNode HTML() { return getToken(BladeAntlrFormatterParser.HTML, 0); }
		public TerminalNode OTHER() { return getToken(BladeAntlrFormatterParser.OTHER, 0); }
		public Static_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_static_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterStatic_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitStatic_element(this);
		}
	}

	public final Static_elementContext static_element() throws RecognitionException {
		Static_elementContext _localctx = new Static_elementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_static_element);
		int _la;
		try {
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_PHP:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(D_PHP);
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(88);
					match(PHP_CODE);
					}
					}
					setState(91); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PHP_CODE );
				setState(93);
				match(D_ENDPHP);
				}
				break;
			case HTML:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(HTML);
				}
				break;
			case OTHER:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				match(OTHER);
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
		"\u0004\u0001\u0017c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0005\u0000\u0018"+
		"\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001(\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0004\u0002,\b\u0002\u000b\u0002\f\u0002-\u0001\u0002\u0003\u00021\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u00038\b\u0003\n\u0003\f\u0003;\t\u0003\u0001\u0004\u0003\u0004>\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005"+
		"\bL\b\b\n\b\f\bO\t\b\u0001\t\u0001\t\u0005\tS\b\t\n\t\f\tV\t\t\u0001\n"+
		"\u0001\n\u0004\nZ\b\n\u000b\n\f\n[\u0001\n\u0001\n\u0001\n\u0003\na\b"+
		"\n\u0001\n\u0000\u0000\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0000\u0005\u0001\u0000\n\u000b\u0001\u0000\u0010\u0011\u0002"+
		"\u0000\u0004\u0004\u0006\u0006\u0002\u0000\u0005\u0005\u0007\u0007\u0001"+
		"\u0000\b\ti\u0000\u0019\u0001\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000"+
		"\u0000\u0004)\u0001\u0000\u0000\u0000\u00064\u0001\u0000\u0000\u0000\b"+
		"=\u0001\u0000\u0000\u0000\nC\u0001\u0000\u0000\u0000\fE\u0001\u0000\u0000"+
		"\u0000\u000eG\u0001\u0000\u0000\u0000\u0010I\u0001\u0000\u0000\u0000\u0012"+
		"P\u0001\u0000\u0000\u0000\u0014`\u0001\u0000\u0000\u0000\u0016\u0018\u0003"+
		"\u0002\u0001\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u001b\u0001"+
		"\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001"+
		"\u0000\u0000\u0000\u001a\u001c\u0001\u0000\u0000\u0000\u001b\u0019\u0001"+
		"\u0000\u0000\u0000\u001c\u001d\u0005\u0000\u0000\u0001\u001d\u0001\u0001"+
		"\u0000\u0000\u0000\u001e(\u0003\u0006\u0003\u0000\u001f(\u0003\u0004\u0002"+
		"\u0000 (\u0003\u000e\u0007\u0000!(\u0003\u0014\n\u0000\"(\u0003\u0010"+
		"\b\u0000#(\u0007\u0000\u0000\u0000$(\u0005\r\u0000\u0000%(\u0005\f\u0000"+
		"\u0000&(\u0007\u0001\u0000\u0000\'\u001e\u0001\u0000\u0000\u0000\'\u001f"+
		"\u0001\u0000\u0000\u0000\' \u0001\u0000\u0000\u0000\'!\u0001\u0000\u0000"+
		"\u0000\'\"\u0001\u0000\u0000\u0000\'#\u0001\u0000\u0000\u0000\'$\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'&\u0001\u0000\u0000\u0000"+
		"(\u0003\u0001\u0000\u0000\u0000)+\u0003\b\u0004\u0000*,\u0003\u0002\u0001"+
		"\u0000+*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-+\u0001\u0000"+
		"\u0000\u0000-.\u0001\u0000\u0000\u0000.0\u0001\u0000\u0000\u0000/1\u0003"+
		"\u0012\t\u00000/\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000012\u0001"+
		"\u0000\u0000\u000023\u0003\f\u0006\u00003\u0005\u0001\u0000\u0000\u0000"+
		"45\u0005\r\u0000\u000059\u0005\u0011\u0000\u000068\u0005\u0010\u0000\u0000"+
		"76\u0001\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000"+
		"\u00009:\u0001\u0000\u0000\u0000:\u0007\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000<>\u0003\u0010\b\u0000=<\u0001\u0000\u0000\u0000=>\u0001"+
		"\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0003\n\u0005\u0000@A\u0005"+
		"\u0013\u0000\u0000AB\u0005\u0014\u0000\u0000B\t\u0001\u0000\u0000\u0000"+
		"CD\u0007\u0002\u0000\u0000D\u000b\u0001\u0000\u0000\u0000EF\u0007\u0003"+
		"\u0000\u0000F\r\u0001\u0000\u0000\u0000GH\u0007\u0004\u0000\u0000H\u000f"+
		"\u0001\u0000\u0000\u0000IM\u0005\u0011\u0000\u0000JL\u0005\u0010\u0000"+
		"\u0000KJ\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000\u0000MK\u0001\u0000"+
		"\u0000\u0000MN\u0001\u0000\u0000\u0000N\u0011\u0001\u0000\u0000\u0000"+
		"OM\u0001\u0000\u0000\u0000PT\u0005\u0011\u0000\u0000QS\u0005\u0010\u0000"+
		"\u0000RQ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000U\u0013\u0001\u0000\u0000\u0000"+
		"VT\u0001\u0000\u0000\u0000WY\u0005\u000e\u0000\u0000XZ\u0005\u0002\u0000"+
		"\u0000YX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[Y\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]a\u0005"+
		"\u0017\u0000\u0000^a\u0005\u0001\u0000\u0000_a\u0005\u0012\u0000\u0000"+
		"`W\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`_\u0001\u0000\u0000"+
		"\u0000a\u0015\u0001\u0000\u0000\u0000\n\u0019\'-09=MT[`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}