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
		HTML=1, PHP_CODE=2, PHP_INLINE=3, D_BLOCK_DIRECTIVE_START=4, D_BLOCK_DIRECTIVE_END=5, 
		D_SECTION=6, D_ENDSECTION=7, D_BLOCK_ALIGNED_DIRECTIVE=8, NON_PARAM_DIRECTIVE=9, 
		D_INLINE_DIRECTIVE=10, STRING=11, CONTENT_TAG_OPEN=12, RAW_TAG_OPEN=13, 
		SG_QUOTE=14, DB_QUOTE=15, HTML_CLOSE_TAG=16, HTML_COMMENT=17, HTML_START_BLOCK_TAG=18, 
		EQ=19, IDENTIFIER=20, GT_SYMBOL=21, D_PHP=22, AT=23, WS=24, NL=25, OTHER=26, 
		D_ARG_LPAREN=27, D_ARG_RPAREN=28, PHP_EXPR=29, EXIT_EOF=30, D_ENDPHP=31, 
		CONTENT_TAG_CLOSE=32, CONTENT_OTHER=33, EXIT_REGULAR_ECHO_EOF=34, RAW_TAG_CLOSE=35, 
		RAW_CONTENT_OTHER=36, EXIT_RAW_ECHO_EOF=37;
	public static final int
		RULE_file = 0, RULE_statement = 1, RULE_inline_tag_statement = 2, RULE_html_close_tag = 3, 
		RULE_indetable_element = 4, RULE_html_indent = 5, RULE_block_start = 6, 
		RULE_block_directive_name = 7, RULE_block_end = 8, RULE_block_aligned_directive = 9, 
		RULE_inline_identable_element = 10, RULE_section_block = 11, RULE_section_block_start = 12, 
		RULE_nl_with_space_before = 13, RULE_nl_with_space = 14, RULE_static_element = 15, 
		RULE_blade_echo = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "statement", "inline_tag_statement", "html_close_tag", "indetable_element", 
			"html_indent", "block_start", "block_directive_name", "block_end", "block_aligned_directive", 
			"inline_identable_element", "section_block", "section_block_start", "nl_with_space_before", 
			"nl_with_space", "static_element", "blade_echo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'{{'", "'{!!'", "'''", "'\"'", null, null, null, "'='", null, "'>'", 
			null, "'@'", null, null, null, "'('", "')'", null, null, "'@endphp'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HTML", "PHP_CODE", "PHP_INLINE", "D_BLOCK_DIRECTIVE_START", "D_BLOCK_DIRECTIVE_END", 
			"D_SECTION", "D_ENDSECTION", "D_BLOCK_ALIGNED_DIRECTIVE", "NON_PARAM_DIRECTIVE", 
			"D_INLINE_DIRECTIVE", "STRING", "CONTENT_TAG_OPEN", "RAW_TAG_OPEN", "SG_QUOTE", 
			"DB_QUOTE", "HTML_CLOSE_TAG", "HTML_COMMENT", "HTML_START_BLOCK_TAG", 
			"EQ", "IDENTIFIER", "GT_SYMBOL", "D_PHP", "AT", "WS", "NL", "OTHER", 
			"D_ARG_LPAREN", "D_ARG_RPAREN", "PHP_EXPR", "EXIT_EOF", "D_ENDPHP", "CONTENT_TAG_CLOSE", 
			"CONTENT_OTHER", "EXIT_REGULAR_ECHO_EOF", "RAW_TAG_CLOSE", "RAW_CONTENT_OTHER", 
			"EXIT_RAW_ECHO_EOF"
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 124254066L) != 0) {
				{
				{
				setState(34);
				statement();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
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
		public Section_blockContext section_block() {
			return getRuleContext(Section_blockContext.class,0);
		}
		public Inline_identable_elementContext inline_identable_element() {
			return getRuleContext(Inline_identable_elementContext.class,0);
		}
		public Block_aligned_directiveContext block_aligned_directive() {
			return getRuleContext(Block_aligned_directiveContext.class,0);
		}
		public Static_elementContext static_element() {
			return getRuleContext(Static_elementContext.class,0);
		}
		public Nl_with_space_beforeContext nl_with_space_before() {
			return getRuleContext(Nl_with_space_beforeContext.class,0);
		}
		public Blade_echoContext blade_echo() {
			return getRuleContext(Blade_echoContext.class,0);
		}
		public Block_endContext block_end() {
			return getRuleContext(Block_endContext.class,0);
		}
		public TerminalNode SG_QUOTE() { return getToken(BladeAntlrFormatterParser.SG_QUOTE, 0); }
		public TerminalNode DB_QUOTE() { return getToken(BladeAntlrFormatterParser.DB_QUOTE, 0); }
		public TerminalNode GT_SYMBOL() { return getToken(BladeAntlrFormatterParser.GT_SYMBOL, 0); }
		public Html_close_tagContext html_close_tag() {
			return getRuleContext(Html_close_tagContext.class,0);
		}
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
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				html_indent();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				indetable_element();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				section_block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(45);
				inline_identable_element();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(46);
				block_aligned_directive();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(47);
				static_element();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(48);
				nl_with_space_before();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(49);
				blade_echo();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(50);
				block_end();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(51);
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
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(52);
				match(GT_SYMBOL);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(53);
				html_close_tag();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(54);
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
	public static class Inline_tag_statementContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(BladeAntlrFormatterParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BladeAntlrFormatterParser.IDENTIFIER, i);
		}
		public TerminalNode EQ() { return getToken(BladeAntlrFormatterParser.EQ, 0); }
		public TerminalNode STRING() { return getToken(BladeAntlrFormatterParser.STRING, 0); }
		public TerminalNode WS() { return getToken(BladeAntlrFormatterParser.WS, 0); }
		public TerminalNode NL() { return getToken(BladeAntlrFormatterParser.NL, 0); }
		public Inline_tag_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_tag_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterInline_tag_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitInline_tag_statement(this);
		}
	}

	public final Inline_tag_statementContext inline_tag_statement() throws RecognitionException {
		Inline_tag_statementContext _localctx = new Inline_tag_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_inline_tag_statement);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(IDENTIFIER);
				setState(58);
				match(EQ);
				setState(59);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(IDENTIFIER);
				setState(61);
				match(EQ);
				setState(62);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				match(IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				match(WS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(65);
				match(NL);
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
	public static class Html_close_tagContext extends ParserRuleContext {
		public TerminalNode HTML_CLOSE_TAG() { return getToken(BladeAntlrFormatterParser.HTML_CLOSE_TAG, 0); }
		public Html_close_tagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html_close_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterHtml_close_tag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitHtml_close_tag(this);
		}
	}

	public final Html_close_tagContext html_close_tag() throws RecognitionException {
		Html_close_tagContext _localctx = new Html_close_tagContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_html_close_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(HTML_CLOSE_TAG);
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
		enterRule(_localctx, 8, RULE_indetable_element);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			block_start();
			setState(72); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(71);
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(74); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(76);
				nl_with_space();
				}
			}

			setState(79);
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
		public TerminalNode HTML_START_BLOCK_TAG() { return getToken(BladeAntlrFormatterParser.HTML_START_BLOCK_TAG, 0); }
		public TerminalNode GT_SYMBOL() { return getToken(BladeAntlrFormatterParser.GT_SYMBOL, 0); }
		public TerminalNode NL() { return getToken(BladeAntlrFormatterParser.NL, 0); }
		public List<Inline_tag_statementContext> inline_tag_statement() {
			return getRuleContexts(Inline_tag_statementContext.class);
		}
		public Inline_tag_statementContext inline_tag_statement(int i) {
			return getRuleContext(Inline_tag_statementContext.class,i);
		}
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
		enterRule(_localctx, 10, RULE_html_indent);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(HTML_START_BLOCK_TAG);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 51380224L) != 0) {
				{
				{
				setState(82);
				inline_tag_statement();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			match(GT_SYMBOL);
			setState(89);
			match(NL);
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(90);
					match(WS);
					}
					} 
				}
				setState(95);
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
		enterRule(_localctx, 12, RULE_block_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(96);
				((Block_startContext)_localctx).ws_before = nl_with_space_before();
				}
			}

			setState(99);
			block_directive_name();
			setState(100);
			match(D_ARG_LPAREN);
			setState(101);
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
		public TerminalNode D_BLOCK_DIRECTIVE_START() { return getToken(BladeAntlrFormatterParser.D_BLOCK_DIRECTIVE_START, 0); }
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
		enterRule(_localctx, 14, RULE_block_directive_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(D_BLOCK_DIRECTIVE_START);
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
		public TerminalNode D_BLOCK_DIRECTIVE_END() { return getToken(BladeAntlrFormatterParser.D_BLOCK_DIRECTIVE_END, 0); }
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
		enterRule(_localctx, 16, RULE_block_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(D_BLOCK_DIRECTIVE_END);
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
	public static class Block_aligned_directiveContext extends ParserRuleContext {
		public TerminalNode D_BLOCK_ALIGNED_DIRECTIVE() { return getToken(BladeAntlrFormatterParser.D_BLOCK_ALIGNED_DIRECTIVE, 0); }
		public Block_aligned_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_aligned_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterBlock_aligned_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitBlock_aligned_directive(this);
		}
	}

	public final Block_aligned_directiveContext block_aligned_directive() throws RecognitionException {
		Block_aligned_directiveContext _localctx = new Block_aligned_directiveContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block_aligned_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(D_BLOCK_ALIGNED_DIRECTIVE);
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
		public Blade_echoContext blade_echo() {
			return getRuleContext(Blade_echoContext.class,0);
		}
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
		enterRule(_localctx, 20, RULE_inline_identable_element);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_INLINE_DIRECTIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(D_INLINE_DIRECTIVE);
				}
				break;
			case NON_PARAM_DIRECTIVE:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(NON_PARAM_DIRECTIVE);
				}
				break;
			case CONTENT_TAG_OPEN:
			case RAW_TAG_OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				blade_echo();
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
	public static class Section_blockContext extends ParserRuleContext {
		public Section_block_startContext section_block_start() {
			return getRuleContext(Section_block_startContext.class,0);
		}
		public TerminalNode D_ENDSECTION() { return getToken(BladeAntlrFormatterParser.D_ENDSECTION, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Section_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterSection_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitSection_block(this);
		}
	}

	public final Section_blockContext section_block() throws RecognitionException {
		Section_blockContext _localctx = new Section_blockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_section_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			section_block_start();
			setState(116); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(115);
				statement();
				}
				}
				setState(118); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 124254066L) != 0 );
			setState(120);
			match(D_ENDSECTION);
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
	public static class Section_block_startContext extends ParserRuleContext {
		public TerminalNode D_SECTION() { return getToken(BladeAntlrFormatterParser.D_SECTION, 0); }
		public TerminalNode D_ARG_LPAREN() { return getToken(BladeAntlrFormatterParser.D_ARG_LPAREN, 0); }
		public TerminalNode D_ARG_RPAREN() { return getToken(BladeAntlrFormatterParser.D_ARG_RPAREN, 0); }
		public Section_block_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section_block_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterSection_block_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitSection_block_start(this);
		}
	}

	public final Section_block_startContext section_block_start() throws RecognitionException {
		Section_block_startContext _localctx = new Section_block_startContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_section_block_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(D_SECTION);
			setState(123);
			match(D_ARG_LPAREN);
			setState(124);
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
		enterRule(_localctx, 26, RULE_nl_with_space_before);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(NL);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(127);
					match(WS);
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		enterRule(_localctx, 28, RULE_nl_with_space);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(NL);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(134);
				match(WS);
				}
				}
				setState(139);
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
		public TerminalNode HTML_COMMENT() { return getToken(BladeAntlrFormatterParser.HTML_COMMENT, 0); }
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
		enterRule(_localctx, 30, RULE_static_element);
		int _la;
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_PHP:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(D_PHP);
				setState(142); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(141);
					match(PHP_CODE);
					}
					}
					setState(144); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PHP_CODE );
				setState(146);
				match(D_ENDPHP);
				}
				break;
			case HTML_COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(HTML_COMMENT);
				}
				break;
			case HTML:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				match(HTML);
				}
				break;
			case OTHER:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Blade_echoContext extends ParserRuleContext {
		public TerminalNode CONTENT_TAG_OPEN() { return getToken(BladeAntlrFormatterParser.CONTENT_TAG_OPEN, 0); }
		public TerminalNode CONTENT_TAG_CLOSE() { return getToken(BladeAntlrFormatterParser.CONTENT_TAG_CLOSE, 0); }
		public TerminalNode RAW_TAG_OPEN() { return getToken(BladeAntlrFormatterParser.RAW_TAG_OPEN, 0); }
		public TerminalNode RAW_TAG_CLOSE() { return getToken(BladeAntlrFormatterParser.RAW_TAG_CLOSE, 0); }
		public Blade_echoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blade_echo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterBlade_echo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitBlade_echo(this);
		}
	}

	public final Blade_echoContext blade_echo() throws RecognitionException {
		Blade_echoContext _localctx = new Blade_echoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_blade_echo);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONTENT_TAG_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(152);
				match(CONTENT_TAG_OPEN);
				setState(153);
				match(CONTENT_TAG_CLOSE);
				}
				}
				break;
			case RAW_TAG_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(154);
				match(RAW_TAG_OPEN);
				setState(155);
				match(RAW_TAG_CLOSE);
				}
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
		"\u0004\u0001%\u009f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000"+
		"\'\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00018\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002C\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0004\u0004I\b\u0004\u000b\u0004"+
		"\f\u0004J\u0001\u0004\u0003\u0004N\b\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0005\u0005T\b\u0005\n\u0005\f\u0005W\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005\\\b\u0005\n\u0005\f\u0005_"+
		"\t\u0005\u0001\u0006\u0003\u0006b\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0003\nq\b\n\u0001\u000b\u0001\u000b\u0004"+
		"\u000bu\b\u000b\u000b\u000b\f\u000bv\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0005\r\u0081\b\r\n\r\f\r\u0084\t\r"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u0088\b\u000e\n\u000e\f\u000e\u008b"+
		"\t\u000e\u0001\u000f\u0001\u000f\u0004\u000f\u008f\b\u000f\u000b\u000f"+
		"\f\u000f\u0090\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u0097\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u009d\b\u0010\u0001\u0010\u0000\u0000\u0011\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0002"+
		"\u0001\u0000\u000e\u000f\u0001\u0000\u0018\u0019\u00ad\u0000%\u0001\u0000"+
		"\u0000\u0000\u00027\u0001\u0000\u0000\u0000\u0004B\u0001\u0000\u0000\u0000"+
		"\u0006D\u0001\u0000\u0000\u0000\bF\u0001\u0000\u0000\u0000\nQ\u0001\u0000"+
		"\u0000\u0000\fa\u0001\u0000\u0000\u0000\u000eg\u0001\u0000\u0000\u0000"+
		"\u0010i\u0001\u0000\u0000\u0000\u0012k\u0001\u0000\u0000\u0000\u0014p"+
		"\u0001\u0000\u0000\u0000\u0016r\u0001\u0000\u0000\u0000\u0018z\u0001\u0000"+
		"\u0000\u0000\u001a~\u0001\u0000\u0000\u0000\u001c\u0085\u0001\u0000\u0000"+
		"\u0000\u001e\u0096\u0001\u0000\u0000\u0000 \u009c\u0001\u0000\u0000\u0000"+
		"\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000\u0000\u0000$\'\u0001\u0000"+
		"\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&(\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000()\u0005\u0000\u0000\u0001"+
		")\u0001\u0001\u0000\u0000\u0000*8\u0003\n\u0005\u0000+8\u0003\b\u0004"+
		"\u0000,8\u0003\u0016\u000b\u0000-8\u0003\u0014\n\u0000.8\u0003\u0012\t"+
		"\u0000/8\u0003\u001e\u000f\u000008\u0003\u001a\r\u000018\u0003 \u0010"+
		"\u000028\u0003\u0010\b\u000038\u0007\u0000\u0000\u000048\u0005\u0015\u0000"+
		"\u000058\u0003\u0006\u0003\u000068\u0007\u0001\u0000\u00007*\u0001\u0000"+
		"\u0000\u00007+\u0001\u0000\u0000\u00007,\u0001\u0000\u0000\u00007-\u0001"+
		"\u0000\u0000\u00007.\u0001\u0000\u0000\u00007/\u0001\u0000\u0000\u0000"+
		"70\u0001\u0000\u0000\u000071\u0001\u0000\u0000\u000072\u0001\u0000\u0000"+
		"\u000073\u0001\u0000\u0000\u000074\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u000076\u0001\u0000\u0000\u00008\u0003\u0001\u0000\u0000\u0000"+
		"9:\u0005\u0014\u0000\u0000:;\u0005\u0013\u0000\u0000;C\u0005\u0014\u0000"+
		"\u0000<=\u0005\u0014\u0000\u0000=>\u0005\u0013\u0000\u0000>C\u0005\u000b"+
		"\u0000\u0000?C\u0005\u0014\u0000\u0000@C\u0005\u0018\u0000\u0000AC\u0005"+
		"\u0019\u0000\u0000B9\u0001\u0000\u0000\u0000B<\u0001\u0000\u0000\u0000"+
		"B?\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BA\u0001\u0000\u0000"+
		"\u0000C\u0005\u0001\u0000\u0000\u0000DE\u0005\u0010\u0000\u0000E\u0007"+
		"\u0001\u0000\u0000\u0000FH\u0003\f\u0006\u0000GI\u0003\u0002\u0001\u0000"+
		"HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000"+
		"\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000LN\u0003\u001c"+
		"\u000e\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0001"+
		"\u0000\u0000\u0000OP\u0003\u0010\b\u0000P\t\u0001\u0000\u0000\u0000QU"+
		"\u0005\u0012\u0000\u0000RT\u0003\u0004\u0002\u0000SR\u0001\u0000\u0000"+
		"\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000"+
		"\u0000\u0000VX\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XY\u0005"+
		"\u0015\u0000\u0000Y]\u0005\u0019\u0000\u0000Z\\\u0005\u0018\u0000\u0000"+
		"[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000^\u000b\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000`b\u0003\u001a\r\u0000a`\u0001\u0000\u0000\u0000ab\u0001"+
		"\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0003\u000e\u0007\u0000"+
		"de\u0005\u001b\u0000\u0000ef\u0005\u001c\u0000\u0000f\r\u0001\u0000\u0000"+
		"\u0000gh\u0005\u0004\u0000\u0000h\u000f\u0001\u0000\u0000\u0000ij\u0005"+
		"\u0005\u0000\u0000j\u0011\u0001\u0000\u0000\u0000kl\u0005\b\u0000\u0000"+
		"l\u0013\u0001\u0000\u0000\u0000mq\u0005\n\u0000\u0000nq\u0005\t\u0000"+
		"\u0000oq\u0003 \u0010\u0000pm\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000"+
		"\u0000po\u0001\u0000\u0000\u0000q\u0015\u0001\u0000\u0000\u0000rt\u0003"+
		"\u0018\f\u0000su\u0003\u0002\u0001\u0000ts\u0001\u0000\u0000\u0000uv\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000xy\u0005\u0007\u0000\u0000y\u0017\u0001\u0000"+
		"\u0000\u0000z{\u0005\u0006\u0000\u0000{|\u0005\u001b\u0000\u0000|}\u0005"+
		"\u001c\u0000\u0000}\u0019\u0001\u0000\u0000\u0000~\u0082\u0005\u0019\u0000"+
		"\u0000\u007f\u0081\u0005\u0018\u0000\u0000\u0080\u007f\u0001\u0000\u0000"+
		"\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u001b\u0001\u0000\u0000"+
		"\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0089\u0005\u0019\u0000"+
		"\u0000\u0086\u0088\u0005\u0018\u0000\u0000\u0087\u0086\u0001\u0000\u0000"+
		"\u0000\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u001d\u0001\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008e\u0005\u0016\u0000"+
		"\u0000\u008d\u008f\u0005\u0002\u0000\u0000\u008e\u008d\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000"+
		"\u0000\u0092\u0097\u0005\u001f\u0000\u0000\u0093\u0097\u0005\u0011\u0000"+
		"\u0000\u0094\u0097\u0005\u0001\u0000\u0000\u0095\u0097\u0005\u001a\u0000"+
		"\u0000\u0096\u008c\u0001\u0000\u0000\u0000\u0096\u0093\u0001\u0000\u0000"+
		"\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0095\u0001\u0000\u0000"+
		"\u0000\u0097\u001f\u0001\u0000\u0000\u0000\u0098\u0099\u0005\f\u0000\u0000"+
		"\u0099\u009d\u0005 \u0000\u0000\u009a\u009b\u0005\r\u0000\u0000\u009b"+
		"\u009d\u0005#\u0000\u0000\u009c\u0098\u0001\u0000\u0000\u0000\u009c\u009a"+
		"\u0001\u0000\u0000\u0000\u009d!\u0001\u0000\u0000\u0000\u000f%7BJMU]a"+
		"pv\u0082\u0089\u0090\u0096\u009c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}