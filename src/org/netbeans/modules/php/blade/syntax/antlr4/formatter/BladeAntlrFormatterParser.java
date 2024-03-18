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
		HTML_SELF_CLOSE_TAG=19, COMPONENT_TAG=20, EQ=21, IDENTIFIER=22, INLINE_GT_SYMBOL=23, 
		GT_SYMBOL=24, D_PHP=25, AT=26, WS=27, NL=28, OTHER=29, D_ARG_LPAREN=30, 
		D_ARG_RPAREN=31, PHP_EXPR=32, EXIT_EOF=33, D_ENDPHP=34, CONTENT_TAG_CLOSE=35, 
		CONTENT_OTHER=36, EXIT_REGULAR_ECHO_EOF=37, RAW_TAG_CLOSE=38, RAW_CONTENT_OTHER=39, 
		EXIT_RAW_ECHO_EOF=40;
	public static final int
		RULE_file = 0, RULE_statement = 1, RULE_inline_tag_statement = 2, RULE_html_close_tag = 3, 
		RULE_indetable_element = 4, RULE_html_indent = 5, RULE_html_tag = 6, RULE_self_closed_tag = 7, 
		RULE_block_start = 8, RULE_block_directive_name = 9, RULE_block_end = 10, 
		RULE_block_aligned_directive = 11, RULE_inline_identable_element = 12, 
		RULE_section_block = 13, RULE_section_block_end = 14, RULE_section_block_start = 15, 
		RULE_nl_with_space_before = 16, RULE_nl_with_space = 17, RULE_static_element = 18, 
		RULE_blade_echo = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "statement", "inline_tag_statement", "html_close_tag", "indetable_element", 
			"html_indent", "html_tag", "self_closed_tag", "block_start", "block_directive_name", 
			"block_end", "block_aligned_directive", "inline_identable_element", "section_block", 
			"section_block_end", "section_block_start", "nl_with_space_before", "nl_with_space", 
			"static_element", "blade_echo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'{{'", "'{!!'", "'''", "'\"'", null, null, null, null, null, "'='", 
			null, "'/>'", "'>'", null, "'@'", null, null, null, "'('", "')'", null, 
			null, "'@endphp'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HTML", "PHP_CODE", "PHP_INLINE", "D_BLOCK_DIRECTIVE_START", "D_BLOCK_DIRECTIVE_END", 
			"D_SECTION", "D_ENDSECTION", "D_BLOCK_ALIGNED_DIRECTIVE", "NON_PARAM_DIRECTIVE", 
			"D_INLINE_DIRECTIVE", "STRING", "CONTENT_TAG_OPEN", "RAW_TAG_OPEN", "SG_QUOTE", 
			"DB_QUOTE", "HTML_CLOSE_TAG", "HTML_COMMENT", "HTML_START_BLOCK_TAG", 
			"HTML_SELF_CLOSE_TAG", "COMPONENT_TAG", "EQ", "IDENTIFIER", "INLINE_GT_SYMBOL", 
			"GT_SYMBOL", "D_PHP", "AT", "WS", "NL", "OTHER", "D_ARG_LPAREN", "D_ARG_RPAREN", 
			"PHP_EXPR", "EXIT_EOF", "D_ENDPHP", "CONTENT_TAG_CLOSE", "CONTENT_OTHER", 
			"EXIT_REGULAR_ECHO_EOF", "RAW_TAG_CLOSE", "RAW_CONTENT_OTHER", "EXIT_RAW_ECHO_EOF"
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
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1000339314L) != 0) {
				{
				{
				setState(40);
				statement();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
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
		public Html_tagContext html_tag() {
			return getRuleContext(Html_tagContext.class,0);
		}
		public Self_closed_tagContext self_closed_tag() {
			return getRuleContext(Self_closed_tagContext.class,0);
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
		public Html_close_tagContext html_close_tag() {
			return getRuleContext(Html_close_tagContext.class,0);
		}
		public TerminalNode SG_QUOTE() { return getToken(BladeAntlrFormatterParser.SG_QUOTE, 0); }
		public TerminalNode DB_QUOTE() { return getToken(BladeAntlrFormatterParser.DB_QUOTE, 0); }
		public TerminalNode INLINE_GT_SYMBOL() { return getToken(BladeAntlrFormatterParser.INLINE_GT_SYMBOL, 0); }
		public TerminalNode GT_SYMBOL() { return getToken(BladeAntlrFormatterParser.GT_SYMBOL, 0); }
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
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				html_indent();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				indetable_element();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				html_tag();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				self_closed_tag();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(52);
				section_block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(53);
				inline_identable_element();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(54);
				block_aligned_directive();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(55);
				static_element();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(56);
				nl_with_space_before();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(57);
				blade_echo();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(58);
				block_end();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(59);
				html_close_tag();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(60);
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
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(61);
				match(INLINE_GT_SYMBOL);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(62);
				match(GT_SYMBOL);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(63);
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
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(IDENTIFIER);
				setState(67);
				match(EQ);
				setState(68);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(IDENTIFIER);
				setState(70);
				match(EQ);
				setState(71);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				match(IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				match(WS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
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
			setState(77);
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
			setState(79);
			block_start();
			setState(81); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(80);
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(83); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(85);
				nl_with_space();
				}
			}

			setState(88);
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
		public TerminalNode HTML_START_BLOCK_TAG() { return getToken(BladeAntlrFormatterParser.HTML_START_BLOCK_TAG, 0); }
		public TerminalNode COMPONENT_TAG() { return getToken(BladeAntlrFormatterParser.COMPONENT_TAG, 0); }
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
			setState(90);
			_la = _input.LA(1);
			if ( !(_la==HTML_START_BLOCK_TAG || _la==COMPONENT_TAG) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 406847488L) != 0) {
				{
				{
				setState(91);
				inline_tag_statement();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			match(GT_SYMBOL);
			setState(98);
			match(NL);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(99);
					match(WS);
					}
					} 
				}
				setState(104);
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
	public static class Html_tagContext extends ParserRuleContext {
		public TerminalNode GT_SYMBOL() { return getToken(BladeAntlrFormatterParser.GT_SYMBOL, 0); }
		public TerminalNode HTML_START_BLOCK_TAG() { return getToken(BladeAntlrFormatterParser.HTML_START_BLOCK_TAG, 0); }
		public TerminalNode COMPONENT_TAG() { return getToken(BladeAntlrFormatterParser.COMPONENT_TAG, 0); }
		public List<Inline_tag_statementContext> inline_tag_statement() {
			return getRuleContexts(Inline_tag_statementContext.class);
		}
		public Inline_tag_statementContext inline_tag_statement(int i) {
			return getRuleContext(Inline_tag_statementContext.class,i);
		}
		public Html_tagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterHtml_tag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitHtml_tag(this);
		}
	}

	public final Html_tagContext html_tag() throws RecognitionException {
		Html_tagContext _localctx = new Html_tagContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_html_tag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !(_la==HTML_START_BLOCK_TAG || _la==COMPONENT_TAG) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 406847488L) != 0) {
				{
				{
				setState(106);
				inline_tag_statement();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
			match(GT_SYMBOL);
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
	public static class Self_closed_tagContext extends ParserRuleContext {
		public TerminalNode HTML_SELF_CLOSE_TAG() { return getToken(BladeAntlrFormatterParser.HTML_SELF_CLOSE_TAG, 0); }
		public TerminalNode INLINE_GT_SYMBOL() { return getToken(BladeAntlrFormatterParser.INLINE_GT_SYMBOL, 0); }
		public TerminalNode HTML_START_BLOCK_TAG() { return getToken(BladeAntlrFormatterParser.HTML_START_BLOCK_TAG, 0); }
		public TerminalNode COMPONENT_TAG() { return getToken(BladeAntlrFormatterParser.COMPONENT_TAG, 0); }
		public List<Inline_tag_statementContext> inline_tag_statement() {
			return getRuleContexts(Inline_tag_statementContext.class);
		}
		public Inline_tag_statementContext inline_tag_statement(int i) {
			return getRuleContext(Inline_tag_statementContext.class,i);
		}
		public Self_closed_tagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_self_closed_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterSelf_closed_tag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitSelf_closed_tag(this);
		}
	}

	public final Self_closed_tagContext self_closed_tag() throws RecognitionException {
		Self_closed_tagContext _localctx = new Self_closed_tagContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_self_closed_tag);
		int _la;
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_SELF_CLOSE_TAG:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(HTML_SELF_CLOSE_TAG);
				}
				break;
			case HTML_START_BLOCK_TAG:
			case COMPONENT_TAG:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(115);
				_la = _input.LA(1);
				if ( !(_la==HTML_START_BLOCK_TAG || _la==COMPONENT_TAG) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 406847488L) != 0) {
					{
					{
					setState(116);
					inline_tag_statement();
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(122);
				match(INLINE_GT_SYMBOL);
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
		enterRule(_localctx, 16, RULE_block_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(125);
				((Block_startContext)_localctx).ws_before = nl_with_space_before();
				}
			}

			setState(128);
			block_directive_name();
			setState(129);
			match(D_ARG_LPAREN);
			setState(130);
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
		enterRule(_localctx, 18, RULE_block_directive_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
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
		enterRule(_localctx, 20, RULE_block_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
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
		enterRule(_localctx, 22, RULE_block_aligned_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
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
		enterRule(_localctx, 24, RULE_inline_identable_element);
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_INLINE_DIRECTIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(D_INLINE_DIRECTIVE);
				}
				break;
			case NON_PARAM_DIRECTIVE:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(NON_PARAM_DIRECTIVE);
				}
				break;
			case CONTENT_TAG_OPEN:
			case RAW_TAG_OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
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
		public Section_block_endContext section_block_end() {
			return getRuleContext(Section_block_endContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_section_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			section_block_start();
			setState(145); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(144);
				statement();
				}
				}
				setState(147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1000339314L) != 0 );
			setState(149);
			section_block_end();
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
	public static class Section_block_endContext extends ParserRuleContext {
		public TerminalNode D_ENDSECTION() { return getToken(BladeAntlrFormatterParser.D_ENDSECTION, 0); }
		public Section_block_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section_block_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).enterSection_block_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrFormatterParserListener ) ((BladeAntlrFormatterParserListener)listener).exitSection_block_end(this);
		}
	}

	public final Section_block_endContext section_block_end() throws RecognitionException {
		Section_block_endContext _localctx = new Section_block_endContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_section_block_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
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
		enterRule(_localctx, 30, RULE_section_block_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(D_SECTION);
			setState(154);
			match(D_ARG_LPAREN);
			setState(155);
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
		enterRule(_localctx, 32, RULE_nl_with_space_before);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(NL);
			setState(161);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(158);
					match(WS);
					}
					} 
				}
				setState(163);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		enterRule(_localctx, 34, RULE_nl_with_space);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(NL);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(165);
				match(WS);
				}
				}
				setState(170);
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
		enterRule(_localctx, 36, RULE_static_element);
		int _la;
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_PHP:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(D_PHP);
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(172);
					match(PHP_CODE);
					}
					}
					setState(175); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PHP_CODE );
				setState(177);
				match(D_ENDPHP);
				}
				break;
			case HTML_COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(HTML_COMMENT);
				}
				break;
			case HTML:
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				match(HTML);
				}
				break;
			case OTHER:
				enterOuterAlt(_localctx, 4);
				{
				setState(180);
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
		enterRule(_localctx, 38, RULE_blade_echo);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONTENT_TAG_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(183);
				match(CONTENT_TAG_OPEN);
				setState(184);
				match(CONTENT_TAG_CLOSE);
				}
				}
				break;
			case RAW_TAG_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(185);
				match(RAW_TAG_OPEN);
				setState(186);
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
		"\u0004\u0001(\u00be\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001A\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002L\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0004\u0004R\b\u0004\u000b\u0004\f\u0004S\u0001\u0004\u0003\u0004W\b"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0005\u0005]\b"+
		"\u0005\n\u0005\f\u0005`\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005e\b\u0005\n\u0005\f\u0005h\t\u0005\u0001\u0006\u0001\u0006\u0005"+
		"\u0006l\b\u0006\n\u0006\f\u0006o\t\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007v\b\u0007\n\u0007\f\u0007y\t"+
		"\u0007\u0001\u0007\u0003\u0007|\b\u0007\u0001\b\u0003\b\u007f\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u008e\b\f\u0001\r\u0001\r"+
		"\u0004\r\u0092\b\r\u000b\r\f\r\u0093\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u00a0\b\u0010\n\u0010\f\u0010\u00a3\t\u0010\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u00a7\b\u0011\n\u0011\f\u0011\u00aa\t\u0011\u0001"+
		"\u0012\u0001\u0012\u0004\u0012\u00ae\b\u0012\u000b\u0012\f\u0012\u00af"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00b6\b\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00bc\b\u0013"+
		"\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0003\u0001\u0000"+
		"\u000e\u000f\u0001\u0000\u001b\u001c\u0002\u0000\u0012\u0012\u0014\u0014"+
		"\u00cf\u0000+\u0001\u0000\u0000\u0000\u0002@\u0001\u0000\u0000\u0000\u0004"+
		"K\u0001\u0000\u0000\u0000\u0006M\u0001\u0000\u0000\u0000\bO\u0001\u0000"+
		"\u0000\u0000\nZ\u0001\u0000\u0000\u0000\fi\u0001\u0000\u0000\u0000\u000e"+
		"{\u0001\u0000\u0000\u0000\u0010~\u0001\u0000\u0000\u0000\u0012\u0084\u0001"+
		"\u0000\u0000\u0000\u0014\u0086\u0001\u0000\u0000\u0000\u0016\u0088\u0001"+
		"\u0000\u0000\u0000\u0018\u008d\u0001\u0000\u0000\u0000\u001a\u008f\u0001"+
		"\u0000\u0000\u0000\u001c\u0097\u0001\u0000\u0000\u0000\u001e\u0099\u0001"+
		"\u0000\u0000\u0000 \u009d\u0001\u0000\u0000\u0000\"\u00a4\u0001\u0000"+
		"\u0000\u0000$\u00b5\u0001\u0000\u0000\u0000&\u00bb\u0001\u0000\u0000\u0000"+
		"(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000"+
		"\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000"+
		"\u0000\u0000-+\u0001\u0000\u0000\u0000./\u0005\u0000\u0000\u0001/\u0001"+
		"\u0001\u0000\u0000\u00000A\u0003\n\u0005\u00001A\u0003\b\u0004\u00002"+
		"A\u0003\f\u0006\u00003A\u0003\u000e\u0007\u00004A\u0003\u001a\r\u0000"+
		"5A\u0003\u0018\f\u00006A\u0003\u0016\u000b\u00007A\u0003$\u0012\u0000"+
		"8A\u0003 \u0010\u00009A\u0003&\u0013\u0000:A\u0003\u0014\n\u0000;A\u0003"+
		"\u0006\u0003\u0000<A\u0007\u0000\u0000\u0000=A\u0005\u0017\u0000\u0000"+
		">A\u0005\u0018\u0000\u0000?A\u0007\u0001\u0000\u0000@0\u0001\u0000\u0000"+
		"\u0000@1\u0001\u0000\u0000\u0000@2\u0001\u0000\u0000\u0000@3\u0001\u0000"+
		"\u0000\u0000@4\u0001\u0000\u0000\u0000@5\u0001\u0000\u0000\u0000@6\u0001"+
		"\u0000\u0000\u0000@7\u0001\u0000\u0000\u0000@8\u0001\u0000\u0000\u0000"+
		"@9\u0001\u0000\u0000\u0000@:\u0001\u0000\u0000\u0000@;\u0001\u0000\u0000"+
		"\u0000@<\u0001\u0000\u0000\u0000@=\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000@?\u0001\u0000\u0000\u0000A\u0003\u0001\u0000\u0000\u0000"+
		"BC\u0005\u0016\u0000\u0000CD\u0005\u0015\u0000\u0000DL\u0005\u0016\u0000"+
		"\u0000EF\u0005\u0016\u0000\u0000FG\u0005\u0015\u0000\u0000GL\u0005\u000b"+
		"\u0000\u0000HL\u0005\u0016\u0000\u0000IL\u0005\u001b\u0000\u0000JL\u0005"+
		"\u001c\u0000\u0000KB\u0001\u0000\u0000\u0000KE\u0001\u0000\u0000\u0000"+
		"KH\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KJ\u0001\u0000\u0000"+
		"\u0000L\u0005\u0001\u0000\u0000\u0000MN\u0005\u0010\u0000\u0000N\u0007"+
		"\u0001\u0000\u0000\u0000OQ\u0003\u0010\b\u0000PR\u0003\u0002\u0001\u0000"+
		"QP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000UW\u0003\"\u0011"+
		"\u0000VU\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000XY\u0003\u0014\n\u0000Y\t\u0001\u0000\u0000\u0000Z^\u0007"+
		"\u0002\u0000\u0000[]\u0003\u0004\u0002\u0000\\[\u0001\u0000\u0000\u0000"+
		"]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000"+
		"\u0000_a\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ab\u0005\u0018"+
		"\u0000\u0000bf\u0005\u001c\u0000\u0000ce\u0005\u001b\u0000\u0000dc\u0001"+
		"\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000g\u000b\u0001\u0000\u0000\u0000hf\u0001\u0000"+
		"\u0000\u0000im\u0007\u0002\u0000\u0000jl\u0003\u0004\u0002\u0000kj\u0001"+
		"\u0000\u0000\u0000lo\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000"+
		"mn\u0001\u0000\u0000\u0000np\u0001\u0000\u0000\u0000om\u0001\u0000\u0000"+
		"\u0000pq\u0005\u0018\u0000\u0000q\r\u0001\u0000\u0000\u0000r|\u0005\u0013"+
		"\u0000\u0000sw\u0007\u0002\u0000\u0000tv\u0003\u0004\u0002\u0000ut\u0001"+
		"\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000xz\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000"+
		"\u0000z|\u0005\u0017\u0000\u0000{r\u0001\u0000\u0000\u0000{s\u0001\u0000"+
		"\u0000\u0000|\u000f\u0001\u0000\u0000\u0000}\u007f\u0003 \u0010\u0000"+
		"~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0003\u0012\t\u0000\u0081\u0082\u0005"+
		"\u001e\u0000\u0000\u0082\u0083\u0005\u001f\u0000\u0000\u0083\u0011\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005\u0004\u0000\u0000\u0085\u0013\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0005\u0005\u0000\u0000\u0087\u0015\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0005\b\u0000\u0000\u0089\u0017\u0001\u0000"+
		"\u0000\u0000\u008a\u008e\u0005\n\u0000\u0000\u008b\u008e\u0005\t\u0000"+
		"\u0000\u008c\u008e\u0003&\u0013\u0000\u008d\u008a\u0001\u0000\u0000\u0000"+
		"\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u0019\u0001\u0000\u0000\u0000\u008f\u0091\u0003\u001e\u000f\u0000"+
		"\u0090\u0092\u0003\u0002\u0001\u0000\u0091\u0090\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0003\u001c\u000e\u0000\u0096\u001b\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0005\u0007\u0000\u0000\u0098\u001d\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0005\u0006\u0000\u0000\u009a\u009b\u0005\u001e\u0000\u0000"+
		"\u009b\u009c\u0005\u001f\u0000\u0000\u009c\u001f\u0001\u0000\u0000\u0000"+
		"\u009d\u00a1\u0005\u001c\u0000\u0000\u009e\u00a0\u0005\u001b\u0000\u0000"+
		"\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a2!\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a8\u0005\u001c\u0000\u0000\u00a5\u00a7\u0005\u001b\u0000\u0000\u00a6"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9"+
		"#\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab\u00ad"+
		"\u0005\u0019\u0000\u0000\u00ac\u00ae\u0005\u0002\u0000\u0000\u00ad\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00ad"+
		"\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b1\u00b6\u0005\"\u0000\u0000\u00b2\u00b6\u0005"+
		"\u0011\u0000\u0000\u00b3\u00b6\u0005\u0001\u0000\u0000\u00b4\u00b6\u0005"+
		"\u001d\u0000\u0000\u00b5\u00ab\u0001\u0000\u0000\u0000\u00b5\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b6%\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\f"+
		"\u0000\u0000\u00b8\u00bc\u0005#\u0000\u0000\u00b9\u00ba\u0005\r\u0000"+
		"\u0000\u00ba\u00bc\u0005&\u0000\u0000\u00bb\u00b7\u0001\u0000\u0000\u0000"+
		"\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\'\u0001\u0000\u0000\u0000\u0012"+
		"+@KSV^fmw{~\u008d\u0093\u00a1\u00a8\u00af\u00b5\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}