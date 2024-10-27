// Generated from BladeAntlrParser.g4 by ANTLR 4.13.0

  /**
   * Parser generated for netbeans blade editor
   * Php expression syntax is handled seprately
   */
  package org.netbeans.modules.php.blade.syntax.antlr4.v10;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BladeAntlrParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, IDENTIFIABLE_STRING=3, BLADE_CONTENT_CLOSE_TAG=4, 
		LSQUAREBRACKET=5, RSQUAREBRACKET=6, LCURLYBRACE=7, RCURLYBRACE=8, D_PHP=9, 
		COMMA=10, ERROR=11, D_IF=12, D_ELSEIF=13, D_ELSE=14, D_ENDIF=15, D_UNLESS=16, 
		D_ENDUNLESS=17, D_ISSET=18, D_ENDISSET=19, D_SWITCH=20, D_CASE=21, D_DEFAULT=22, 
		D_ENDSWITCH=23, D_EXTENDS=24, D_INCLUDE=25, D_INCLUDE_IF=26, D_INCLUDE_WHEN=27, 
		D_INCLUDE_UNLESS=28, D_EACH=29, D_INCLUDE_FIRST=30, D_YIELD=31, D_SECTION=32, 
		D_ENDSECTION=33, D_PARENT=34, D_SHOW=35, D_OVERWRITE=36, D_STOP=37, D_APPEND=38, 
		D_ONCE=39, D_ENDONCE=40, D_STACK=41, D_PUSH=42, D_ENDPUSH=43, D_PUSH_IF=44, 
		D_ENDPUSH_IF=45, D_PUSH_ONCE=46, D_ENDPUSH_ONCE=47, D_PREPEND=48, D_ENDPREPEND=49, 
		D_HAS_SECTION=50, D_SECTION_MISSING=51, D_FOREACH=52, D_ENDFOREACH=53, 
		D_FOR=54, D_ENDFOR=55, D_FORELSE=56, D_ENDFORELSE=57, D_WHILE=58, D_ENDWHILE=59, 
		D_BREAK=60, D_CONTINUE=61, D_EMPTY=62, D_ENDEMPTY=63, D_VERBATIM=64, D_ENDVERBATIM=65, 
		D_SESSION=66, D_ENDSESSION=67, D_CSRF=68, D_METHOD=69, D_ERROR=70, D_ENDERROR=71, 
		D_AUTH=72, D_ENDAUTH=73, D_GUEST=74, D_ELSEGUEST=75, D_ENDGUEST=76, D_ENV=77, 
		D_ENDENV=78, D_PRODUCTION=79, D_ENDPRODUCTION=80, D_FRAGMENT=81, D_ENDFRAGMENT=82, 
		D_SIMPLE_DIRECTIVE=83, D_LANG=84, BLADE_CONTENT_OPEN_TAG=85, BLADE_TAG_ESCAPE=86, 
		BLADE_RAW_OPEN_TAG=87, BLADE_RAW_CLOSE_TAG=88, D_CUSTOM=89, AT=90, WS=91, 
		OTHER=92, BLADE_COMMENT_START=93, EMAIL_SUBSTRING=94, VERSION_WITH_AT=95, 
		D_ESCAPES=96, E_LPAREN=97, E_RPAREN=98, E_LSQUAREBRACKET=99, E_RSQUAREBRACKET=100, 
		E_LCURLYBRACE=101, E_RCURLYBRACE=102, E_OTHER=103, EI_LPAREN=104, EI_RPAREN=105, 
		EI_OTHER=106, ESPOS_LPAREN=107, ESPOS_RPAREN=108, ESPOS_LSQUAREBRACKET=109, 
		ESPOS_RSQUAREBRACKET=110, ESPOS_LCURLYBRACE=111, ESPOS_RCURLYBRACE=112, 
		ESPOS_OTHER=113, EACH_LPAREN=114, EACH_RPAREN=115, EACH_LSQUAREBRACKET=116, 
		EACH_RSQUAREBRACKET=117, EACH_LCURLYBRACE=118, EACH_RCURLYBRACE=119, EACH_OTHER=120, 
		INCF_LPAREN=121, INCF_RPAREN=122, INCF_LSQUAREBRACKET=123, INCF_RSQUAREBRACKET=124, 
		INCF_LCURLYBRACE=125, INCF_RCURLYBRACE=126, INCF_OTHER=127, D_ENDPHP=128, 
		BLADE_INLINE_PHP_OTHER=129, VERBATIM_HTML=130, BLADE_COMMENT_END=131, 
		BLADE_COMMENT_MORE=132, BLADE_COMMENT_EOF=133;
	public static final int
		RULE_file = 0, RULE_statement = 1, RULE_blockDirective = 2, RULE_ifStatement = 3, 
		RULE_foreachStatement = 4, RULE_forStatement = 5, RULE_forElseStatement = 6, 
		RULE_ifStartStatement = 7, RULE_elseifStatement = 8, RULE_switchStatement = 9, 
		RULE_inlineDirective = 10, RULE_identifiableArgDirective = 11, RULE_multipleArgDirective = 12, 
		RULE_blockIdentifiableArgDirective = 13, RULE_directiveWithArg = 14, RULE_customDirective = 15, 
		RULE_loopBreaks = 16, RULE_formStatements = 17, RULE_authStatements = 18, 
		RULE_bladeContentTags = 19, RULE_bladeRawTags = 20, RULE_errorDirectives = 21, 
		RULE_directiveArguments = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "statement", "blockDirective", "ifStatement", "foreachStatement", 
			"forStatement", "forElseStatement", "ifStartStatement", "elseifStatement", 
			"switchStatement", "inlineDirective", "identifiableArgDirective", "multipleArgDirective", 
			"blockIdentifiableArgDirective", "directiveWithArg", "customDirective", 
			"loopBreaks", "formStatements", "authStatements", "bladeContentTags", 
			"bladeRawTags", "errorDirectives", "directiveArguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", null, "'}}'", "'['", "']'", null, null, null, "','", 
			null, null, null, "'@else'", "'@endif'", null, "'@endunless'", null, 
			"'@endisset'", null, null, "'@default'", "'@endswitch'", null, null, 
			null, null, null, null, null, null, null, "'@endsection'", "'@parent'", 
			"'@show'", "'@overwrite'", "'@stop'", "'@append'", "'@once'", "'@endonce'", 
			null, null, "'@endpush'", null, "'@endPushIf'", null, "'@endPushOnce'", 
			null, "'@endprepend'", null, null, null, "'@endforeach'", null, "'@endfor'", 
			null, "'@endforelse'", null, "'@endwhile'", null, null, null, "'@endempty'", 
			"'@verbatim'", "'@endverbatim'", null, "'@endsession'", "'@csrf'", null, 
			null, "'@enderror'", null, "'@endauth'", null, "'@elseguest'", "'@endguest'", 
			null, "'@endenv'", "'@production'", "'@endproduction'", null, "'@endfragment'", 
			null, "'@lang'", "'{{'", null, "'{!!'", "'!!}'", null, "'@'", null, null, 
			"'{{--'", null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'@endphp'", null, null, "'--}}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "IDENTIFIABLE_STRING", "BLADE_CONTENT_CLOSE_TAG", 
			"LSQUAREBRACKET", "RSQUAREBRACKET", "LCURLYBRACE", "RCURLYBRACE", "D_PHP", 
			"COMMA", "ERROR", "D_IF", "D_ELSEIF", "D_ELSE", "D_ENDIF", "D_UNLESS", 
			"D_ENDUNLESS", "D_ISSET", "D_ENDISSET", "D_SWITCH", "D_CASE", "D_DEFAULT", 
			"D_ENDSWITCH", "D_EXTENDS", "D_INCLUDE", "D_INCLUDE_IF", "D_INCLUDE_WHEN", 
			"D_INCLUDE_UNLESS", "D_EACH", "D_INCLUDE_FIRST", "D_YIELD", "D_SECTION", 
			"D_ENDSECTION", "D_PARENT", "D_SHOW", "D_OVERWRITE", "D_STOP", "D_APPEND", 
			"D_ONCE", "D_ENDONCE", "D_STACK", "D_PUSH", "D_ENDPUSH", "D_PUSH_IF", 
			"D_ENDPUSH_IF", "D_PUSH_ONCE", "D_ENDPUSH_ONCE", "D_PREPEND", "D_ENDPREPEND", 
			"D_HAS_SECTION", "D_SECTION_MISSING", "D_FOREACH", "D_ENDFOREACH", "D_FOR", 
			"D_ENDFOR", "D_FORELSE", "D_ENDFORELSE", "D_WHILE", "D_ENDWHILE", "D_BREAK", 
			"D_CONTINUE", "D_EMPTY", "D_ENDEMPTY", "D_VERBATIM", "D_ENDVERBATIM", 
			"D_SESSION", "D_ENDSESSION", "D_CSRF", "D_METHOD", "D_ERROR", "D_ENDERROR", 
			"D_AUTH", "D_ENDAUTH", "D_GUEST", "D_ELSEGUEST", "D_ENDGUEST", "D_ENV", 
			"D_ENDENV", "D_PRODUCTION", "D_ENDPRODUCTION", "D_FRAGMENT", "D_ENDFRAGMENT", 
			"D_SIMPLE_DIRECTIVE", "D_LANG", "BLADE_CONTENT_OPEN_TAG", "BLADE_TAG_ESCAPE", 
			"BLADE_RAW_OPEN_TAG", "BLADE_RAW_CLOSE_TAG", "D_CUSTOM", "AT", "WS", 
			"OTHER", "BLADE_COMMENT_START", "EMAIL_SUBSTRING", "VERSION_WITH_AT", 
			"D_ESCAPES", "E_LPAREN", "E_RPAREN", "E_LSQUAREBRACKET", "E_RSQUAREBRACKET", 
			"E_LCURLYBRACE", "E_RCURLYBRACE", "E_OTHER", "EI_LPAREN", "EI_RPAREN", 
			"EI_OTHER", "ESPOS_LPAREN", "ESPOS_RPAREN", "ESPOS_LSQUAREBRACKET", "ESPOS_RSQUAREBRACKET", 
			"ESPOS_LCURLYBRACE", "ESPOS_RCURLYBRACE", "ESPOS_OTHER", "EACH_LPAREN", 
			"EACH_RPAREN", "EACH_LSQUAREBRACKET", "EACH_RSQUAREBRACKET", "EACH_LCURLYBRACE", 
			"EACH_RCURLYBRACE", "EACH_OTHER", "INCF_LPAREN", "INCF_RPAREN", "INCF_LSQUAREBRACKET", 
			"INCF_RSQUAREBRACKET", "INCF_LCURLYBRACE", "INCF_RCURLYBRACE", "INCF_OTHER", 
			"D_ENDPHP", "BLADE_INLINE_PHP_OTHER", "VERBATIM_HTML", "BLADE_COMMENT_END", 
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
	public String getGrammarFileName() { return "BladeAntlrParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public static int bladeVersion = 10;
	public BladeAntlrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BladeAntlrParser.EOF, 0); }
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
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
				{
				{
				setState(46);
				statement();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
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
		public BlockIdentifiableArgDirectiveContext blockIdentifiableArgDirective() {
			return getRuleContext(BlockIdentifiableArgDirectiveContext.class,0);
		}
		public BlockDirectiveContext blockDirective() {
			return getRuleContext(BlockDirectiveContext.class,0);
		}
		public IdentifiableArgDirectiveContext identifiableArgDirective() {
			return getRuleContext(IdentifiableArgDirectiveContext.class,0);
		}
		public MultipleArgDirectiveContext multipleArgDirective() {
			return getRuleContext(MultipleArgDirectiveContext.class,0);
		}
		public InlineDirectiveContext inlineDirective() {
			return getRuleContext(InlineDirectiveContext.class,0);
		}
		public CustomDirectiveContext customDirective() {
			return getRuleContext(CustomDirectiveContext.class,0);
		}
		public BladeContentTagsContext bladeContentTags() {
			return getRuleContext(BladeContentTagsContext.class,0);
		}
		public BladeRawTagsContext bladeRawTags() {
			return getRuleContext(BladeRawTagsContext.class,0);
		}
		public TerminalNode BLADE_CONTENT_CLOSE_TAG() { return getToken(BladeAntlrParser.BLADE_CONTENT_CLOSE_TAG, 0); }
		public TerminalNode BLADE_RAW_CLOSE_TAG() { return getToken(BladeAntlrParser.BLADE_RAW_CLOSE_TAG, 0); }
		public ErrorDirectivesContext errorDirectives() {
			return getRuleContext(ErrorDirectivesContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitStatement(this);
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
				setState(54);
				blockIdentifiableArgDirective();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				blockDirective();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				identifiableArgDirective();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				multipleArgDirective();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(58);
				inlineDirective();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				customDirective();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(60);
				bladeContentTags();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(61);
				bladeRawTags();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(62);
				_la = _input.LA(1);
				if ( !(_la==BLADE_CONTENT_CLOSE_TAG || _la==BLADE_RAW_CLOSE_TAG) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(63);
				errorDirectives();
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
	public static class BlockDirectiveContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForeachStatementContext foreachStatement() {
			return getRuleContext(ForeachStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ForElseStatementContext forElseStatement() {
			return getRuleContext(ForElseStatementContext.class,0);
		}
		public TerminalNode D_WHILE() { return getToken(BladeAntlrParser.D_WHILE, 0); }
		public DirectiveArgumentsContext directiveArguments() {
			return getRuleContext(DirectiveArgumentsContext.class,0);
		}
		public TerminalNode D_ENDWHILE() { return getToken(BladeAntlrParser.D_ENDWHILE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<LoopBreaksContext> loopBreaks() {
			return getRuleContexts(LoopBreaksContext.class);
		}
		public LoopBreaksContext loopBreaks(int i) {
			return getRuleContext(LoopBreaksContext.class,i);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public FormStatementsContext formStatements() {
			return getRuleContext(FormStatementsContext.class,0);
		}
		public AuthStatementsContext authStatements() {
			return getRuleContext(AuthStatementsContext.class,0);
		}
		public TerminalNode D_ONCE() { return getToken(BladeAntlrParser.D_ONCE, 0); }
		public TerminalNode D_ENDONCE() { return getToken(BladeAntlrParser.D_ENDONCE, 0); }
		public TerminalNode D_UNLESS() { return getToken(BladeAntlrParser.D_UNLESS, 0); }
		public TerminalNode D_ENDUNLESS() { return getToken(BladeAntlrParser.D_ENDUNLESS, 0); }
		public TerminalNode D_EMPTY() { return getToken(BladeAntlrParser.D_EMPTY, 0); }
		public TerminalNode D_ENDEMPTY() { return getToken(BladeAntlrParser.D_ENDEMPTY, 0); }
		public TerminalNode D_ISSET() { return getToken(BladeAntlrParser.D_ISSET, 0); }
		public TerminalNode D_ENDISSET() { return getToken(BladeAntlrParser.D_ENDISSET, 0); }
		public TerminalNode D_SESSION() { return getToken(BladeAntlrParser.D_SESSION, 0); }
		public TerminalNode D_ENDSESSION() { return getToken(BladeAntlrParser.D_ENDSESSION, 0); }
		public TerminalNode D_PHP() { return getToken(BladeAntlrParser.D_PHP, 0); }
		public TerminalNode D_ENDPHP() { return getToken(BladeAntlrParser.D_ENDPHP, 0); }
		public TerminalNode D_FRAGMENT() { return getToken(BladeAntlrParser.D_FRAGMENT, 0); }
		public TerminalNode D_ENDFRAGMENT() { return getToken(BladeAntlrParser.D_ENDFRAGMENT, 0); }
		public TerminalNode D_VERBATIM() { return getToken(BladeAntlrParser.D_VERBATIM, 0); }
		public TerminalNode D_ENDVERBATIM() { return getToken(BladeAntlrParser.D_ENDVERBATIM, 0); }
		public BlockDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterBlockDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitBlockDirective(this);
		}
	}

	public final BlockDirectiveContext blockDirective() throws RecognitionException {
		BlockDirectiveContext _localctx = new BlockDirectiveContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockDirective);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				ifStatement();
				}
				break;
			case D_FOREACH:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				foreachStatement();
				}
				break;
			case D_FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				forStatement();
				}
				break;
			case D_FORELSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				forElseStatement();
				}
				break;
			case D_WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				match(D_WHILE);
				setState(71);
				directiveArguments();
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8457010791602000400L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					setState(74);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case BLADE_CONTENT_CLOSE_TAG:
					case D_PHP:
					case D_IF:
					case D_UNLESS:
					case D_ISSET:
					case D_SWITCH:
					case D_EXTENDS:
					case D_INCLUDE:
					case D_INCLUDE_IF:
					case D_INCLUDE_WHEN:
					case D_INCLUDE_UNLESS:
					case D_EACH:
					case D_INCLUDE_FIRST:
					case D_YIELD:
					case D_SECTION:
					case D_ONCE:
					case D_STACK:
					case D_PUSH:
					case D_PUSH_IF:
					case D_PUSH_ONCE:
					case D_PREPEND:
					case D_HAS_SECTION:
					case D_SECTION_MISSING:
					case D_FOREACH:
					case D_FOR:
					case D_FORELSE:
					case D_WHILE:
					case D_EMPTY:
					case D_VERBATIM:
					case D_SESSION:
					case D_CSRF:
					case D_METHOD:
					case D_ERROR:
					case D_AUTH:
					case D_GUEST:
					case D_ENV:
					case D_PRODUCTION:
					case D_FRAGMENT:
					case D_SIMPLE_DIRECTIVE:
					case D_LANG:
					case BLADE_CONTENT_OPEN_TAG:
					case BLADE_RAW_OPEN_TAG:
					case BLADE_RAW_CLOSE_TAG:
					case D_CUSTOM:
						{
						setState(72);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(73);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(79);
				match(D_ENDWHILE);
				}
				break;
			case D_SWITCH:
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				switchStatement();
				}
				break;
			case D_CSRF:
			case D_METHOD:
			case D_ERROR:
				enterOuterAlt(_localctx, 7);
				{
				setState(82);
				formStatements();
				}
				break;
			case D_AUTH:
			case D_GUEST:
			case D_ENV:
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 8);
				{
				setState(83);
				authStatements();
				}
				break;
			case D_ONCE:
				enterOuterAlt(_localctx, 9);
				{
				setState(84);
				match(D_ONCE);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(85);
					directiveArguments();
					}
				}

				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(88);
					statement();
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(94);
				match(D_ENDONCE);
				}
				break;
			case D_UNLESS:
				enterOuterAlt(_localctx, 10);
				{
				setState(95);
				match(D_UNLESS);
				setState(96);
				directiveArguments();
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(97);
					statement();
					}
					}
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(103);
				match(D_ENDUNLESS);
				}
				break;
			case D_EMPTY:
				enterOuterAlt(_localctx, 11);
				{
				setState(105);
				match(D_EMPTY);
				setState(106);
				directiveArguments();
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(107);
					statement();
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(113);
				match(D_ENDEMPTY);
				}
				break;
			case D_ISSET:
				enterOuterAlt(_localctx, 12);
				{
				setState(115);
				match(D_ISSET);
				setState(116);
				directiveArguments();
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(117);
					statement();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123);
				match(D_ENDISSET);
				}
				break;
			case D_SESSION:
				enterOuterAlt(_localctx, 13);
				{
				setState(125);
				match(D_SESSION);
				setState(126);
				directiveArguments();
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(127);
					statement();
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(133);
				match(D_ENDSESSION);
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 14);
				{
				setState(135);
				match(D_PHP);
				setState(136);
				match(D_ENDPHP);
				}
				break;
			case D_FRAGMENT:
				enterOuterAlt(_localctx, 15);
				{
				setState(137);
				match(D_FRAGMENT);
				setState(138);
				directiveArguments();
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(139);
					statement();
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(145);
				match(D_ENDFRAGMENT);
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 16);
				{
				setState(147);
				match(D_VERBATIM);
				setState(148);
				match(D_ENDVERBATIM);
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
	public static class IfStatementContext extends ParserRuleContext {
		public IfStartStatementContext ifStartStatement() {
			return getRuleContext(IfStartStatementContext.class,0);
		}
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrParser.D_ENDIF, 0); }
		public List<ElseifStatementContext> elseifStatement() {
			return getRuleContexts(ElseifStatementContext.class);
		}
		public ElseifStatementContext elseifStatement(int i) {
			return getRuleContext(ElseifStatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<LoopBreaksContext> loopBreaks() {
			return getRuleContexts(LoopBreaksContext.class);
		}
		public LoopBreaksContext loopBreaks(int i) {
			return getRuleContext(LoopBreaksContext.class,i);
		}
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			ifStartStatement();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8457010791602008592L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
				{
				setState(155);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case D_ELSEIF:
					{
					setState(152);
					elseifStatement();
					}
					break;
				case BLADE_CONTENT_CLOSE_TAG:
				case D_PHP:
				case D_IF:
				case D_UNLESS:
				case D_ISSET:
				case D_SWITCH:
				case D_EXTENDS:
				case D_INCLUDE:
				case D_INCLUDE_IF:
				case D_INCLUDE_WHEN:
				case D_INCLUDE_UNLESS:
				case D_EACH:
				case D_INCLUDE_FIRST:
				case D_YIELD:
				case D_SECTION:
				case D_ONCE:
				case D_STACK:
				case D_PUSH:
				case D_PUSH_IF:
				case D_PUSH_ONCE:
				case D_PREPEND:
				case D_HAS_SECTION:
				case D_SECTION_MISSING:
				case D_FOREACH:
				case D_FOR:
				case D_FORELSE:
				case D_WHILE:
				case D_EMPTY:
				case D_VERBATIM:
				case D_SESSION:
				case D_CSRF:
				case D_METHOD:
				case D_ERROR:
				case D_AUTH:
				case D_GUEST:
				case D_ENV:
				case D_PRODUCTION:
				case D_FRAGMENT:
				case D_SIMPLE_DIRECTIVE:
				case D_LANG:
				case BLADE_CONTENT_OPEN_TAG:
				case BLADE_RAW_OPEN_TAG:
				case BLADE_RAW_CLOSE_TAG:
				case D_CUSTOM:
					{
					setState(153);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(154);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_ELSE) {
				{
				setState(160);
				match(D_ELSE);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8457010791602000400L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					setState(163);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case BLADE_CONTENT_CLOSE_TAG:
					case D_PHP:
					case D_IF:
					case D_UNLESS:
					case D_ISSET:
					case D_SWITCH:
					case D_EXTENDS:
					case D_INCLUDE:
					case D_INCLUDE_IF:
					case D_INCLUDE_WHEN:
					case D_INCLUDE_UNLESS:
					case D_EACH:
					case D_INCLUDE_FIRST:
					case D_YIELD:
					case D_SECTION:
					case D_ONCE:
					case D_STACK:
					case D_PUSH:
					case D_PUSH_IF:
					case D_PUSH_ONCE:
					case D_PREPEND:
					case D_HAS_SECTION:
					case D_SECTION_MISSING:
					case D_FOREACH:
					case D_FOR:
					case D_FORELSE:
					case D_WHILE:
					case D_EMPTY:
					case D_VERBATIM:
					case D_SESSION:
					case D_CSRF:
					case D_METHOD:
					case D_ERROR:
					case D_AUTH:
					case D_GUEST:
					case D_ENV:
					case D_PRODUCTION:
					case D_FRAGMENT:
					case D_SIMPLE_DIRECTIVE:
					case D_LANG:
					case BLADE_CONTENT_OPEN_TAG:
					case BLADE_RAW_OPEN_TAG:
					case BLADE_RAW_CLOSE_TAG:
					case D_CUSTOM:
						{
						setState(161);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(162);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(170);
			match(D_ENDIF);
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
	public static class ForeachStatementContext extends ParserRuleContext {
		public TerminalNode D_FOREACH() { return getToken(BladeAntlrParser.D_FOREACH, 0); }
		public DirectiveArgumentsContext directiveArguments() {
			return getRuleContext(DirectiveArgumentsContext.class,0);
		}
		public TerminalNode D_ENDFOREACH() { return getToken(BladeAntlrParser.D_ENDFOREACH, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<LoopBreaksContext> loopBreaks() {
			return getRuleContexts(LoopBreaksContext.class);
		}
		public LoopBreaksContext loopBreaks(int i) {
			return getRuleContext(LoopBreaksContext.class,i);
		}
		public ForeachStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterForeachStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitForeachStatement(this);
		}
	}

	public final ForeachStatementContext foreachStatement() throws RecognitionException {
		ForeachStatementContext _localctx = new ForeachStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_foreachStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(D_FOREACH);
			setState(173);
			directiveArguments();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8457010791602000400L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
				{
				setState(176);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BLADE_CONTENT_CLOSE_TAG:
				case D_PHP:
				case D_IF:
				case D_UNLESS:
				case D_ISSET:
				case D_SWITCH:
				case D_EXTENDS:
				case D_INCLUDE:
				case D_INCLUDE_IF:
				case D_INCLUDE_WHEN:
				case D_INCLUDE_UNLESS:
				case D_EACH:
				case D_INCLUDE_FIRST:
				case D_YIELD:
				case D_SECTION:
				case D_ONCE:
				case D_STACK:
				case D_PUSH:
				case D_PUSH_IF:
				case D_PUSH_ONCE:
				case D_PREPEND:
				case D_HAS_SECTION:
				case D_SECTION_MISSING:
				case D_FOREACH:
				case D_FOR:
				case D_FORELSE:
				case D_WHILE:
				case D_EMPTY:
				case D_VERBATIM:
				case D_SESSION:
				case D_CSRF:
				case D_METHOD:
				case D_ERROR:
				case D_AUTH:
				case D_GUEST:
				case D_ENV:
				case D_PRODUCTION:
				case D_FRAGMENT:
				case D_SIMPLE_DIRECTIVE:
				case D_LANG:
				case BLADE_CONTENT_OPEN_TAG:
				case BLADE_RAW_OPEN_TAG:
				case BLADE_RAW_CLOSE_TAG:
				case D_CUSTOM:
					{
					setState(174);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(175);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(181);
			match(D_ENDFOREACH);
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
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode D_FOR() { return getToken(BladeAntlrParser.D_FOR, 0); }
		public DirectiveArgumentsContext directiveArguments() {
			return getRuleContext(DirectiveArgumentsContext.class,0);
		}
		public TerminalNode D_ENDFOR() { return getToken(BladeAntlrParser.D_ENDFOR, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<LoopBreaksContext> loopBreaks() {
			return getRuleContexts(LoopBreaksContext.class);
		}
		public LoopBreaksContext loopBreaks(int i) {
			return getRuleContext(LoopBreaksContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(D_FOR);
			setState(184);
			directiveArguments();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8457010791602000400L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
				{
				setState(187);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BLADE_CONTENT_CLOSE_TAG:
				case D_PHP:
				case D_IF:
				case D_UNLESS:
				case D_ISSET:
				case D_SWITCH:
				case D_EXTENDS:
				case D_INCLUDE:
				case D_INCLUDE_IF:
				case D_INCLUDE_WHEN:
				case D_INCLUDE_UNLESS:
				case D_EACH:
				case D_INCLUDE_FIRST:
				case D_YIELD:
				case D_SECTION:
				case D_ONCE:
				case D_STACK:
				case D_PUSH:
				case D_PUSH_IF:
				case D_PUSH_ONCE:
				case D_PREPEND:
				case D_HAS_SECTION:
				case D_SECTION_MISSING:
				case D_FOREACH:
				case D_FOR:
				case D_FORELSE:
				case D_WHILE:
				case D_EMPTY:
				case D_VERBATIM:
				case D_SESSION:
				case D_CSRF:
				case D_METHOD:
				case D_ERROR:
				case D_AUTH:
				case D_GUEST:
				case D_ENV:
				case D_PRODUCTION:
				case D_FRAGMENT:
				case D_SIMPLE_DIRECTIVE:
				case D_LANG:
				case BLADE_CONTENT_OPEN_TAG:
				case BLADE_RAW_OPEN_TAG:
				case BLADE_RAW_CLOSE_TAG:
				case D_CUSTOM:
					{
					setState(185);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(186);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
			match(D_ENDFOR);
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
	public static class ForElseStatementContext extends ParserRuleContext {
		public TerminalNode D_FORELSE() { return getToken(BladeAntlrParser.D_FORELSE, 0); }
		public DirectiveArgumentsContext directiveArguments() {
			return getRuleContext(DirectiveArgumentsContext.class,0);
		}
		public TerminalNode D_EMPTY() { return getToken(BladeAntlrParser.D_EMPTY, 0); }
		public TerminalNode D_ENDFORELSE() { return getToken(BladeAntlrParser.D_ENDFORELSE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<LoopBreaksContext> loopBreaks() {
			return getRuleContexts(LoopBreaksContext.class);
		}
		public LoopBreaksContext loopBreaks(int i) {
			return getRuleContext(LoopBreaksContext.class,i);
		}
		public ForElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forElseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterForElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitForElseStatement(this);
		}
	}

	public final ForElseStatementContext forElseStatement() throws RecognitionException {
		ForElseStatementContext _localctx = new ForElseStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_forElseStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(D_FORELSE);
			setState(195);
			directiveArguments();
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(198);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case BLADE_CONTENT_CLOSE_TAG:
					case D_PHP:
					case D_IF:
					case D_UNLESS:
					case D_ISSET:
					case D_SWITCH:
					case D_EXTENDS:
					case D_INCLUDE:
					case D_INCLUDE_IF:
					case D_INCLUDE_WHEN:
					case D_INCLUDE_UNLESS:
					case D_EACH:
					case D_INCLUDE_FIRST:
					case D_YIELD:
					case D_SECTION:
					case D_ONCE:
					case D_STACK:
					case D_PUSH:
					case D_PUSH_IF:
					case D_PUSH_ONCE:
					case D_PREPEND:
					case D_HAS_SECTION:
					case D_SECTION_MISSING:
					case D_FOREACH:
					case D_FOR:
					case D_FORELSE:
					case D_WHILE:
					case D_EMPTY:
					case D_VERBATIM:
					case D_SESSION:
					case D_CSRF:
					case D_METHOD:
					case D_ERROR:
					case D_AUTH:
					case D_GUEST:
					case D_ENV:
					case D_PRODUCTION:
					case D_FRAGMENT:
					case D_SIMPLE_DIRECTIVE:
					case D_LANG:
					case BLADE_CONTENT_OPEN_TAG:
					case BLADE_RAW_OPEN_TAG:
					case BLADE_RAW_CLOSE_TAG:
					case D_CUSTOM:
						{
						setState(196);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(197);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(203);
			match(D_EMPTY);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
				{
				{
				setState(204);
				statement();
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
			match(D_ENDFORELSE);
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
	public static class IfStartStatementContext extends ParserRuleContext {
		public TerminalNode D_IF() { return getToken(BladeAntlrParser.D_IF, 0); }
		public DirectiveArgumentsContext directiveArguments() {
			return getRuleContext(DirectiveArgumentsContext.class,0);
		}
		public IfStartStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStartStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIfStartStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIfStartStatement(this);
		}
	}

	public final IfStartStatementContext ifStartStatement() throws RecognitionException {
		IfStartStatementContext _localctx = new IfStartStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStartStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(D_IF);
			setState(213);
			directiveArguments();
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
	public static class ElseifStatementContext extends ParserRuleContext {
		public TerminalNode D_ELSEIF() { return getToken(BladeAntlrParser.D_ELSEIF, 0); }
		public DirectiveArgumentsContext directiveArguments() {
			return getRuleContext(DirectiveArgumentsContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterElseifStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitElseifStatement(this);
		}
	}

	public final ElseifStatementContext elseifStatement() throws RecognitionException {
		ElseifStatementContext _localctx = new ElseifStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elseifStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(D_ELSEIF);
			setState(216);
			directiveArguments();
			setState(220);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(217);
					statement();
					}
					} 
				}
				setState(222);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode D_SWITCH() { return getToken(BladeAntlrParser.D_SWITCH, 0); }
		public List<DirectiveArgumentsContext> directiveArguments() {
			return getRuleContexts(DirectiveArgumentsContext.class);
		}
		public DirectiveArgumentsContext directiveArguments(int i) {
			return getRuleContext(DirectiveArgumentsContext.class,i);
		}
		public TerminalNode D_ENDSWITCH() { return getToken(BladeAntlrParser.D_ENDSWITCH, 0); }
		public List<TerminalNode> D_CASE() { return getTokens(BladeAntlrParser.D_CASE); }
		public TerminalNode D_CASE(int i) {
			return getToken(BladeAntlrParser.D_CASE, i);
		}
		public TerminalNode D_DEFAULT() { return getToken(BladeAntlrParser.D_DEFAULT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> D_BREAK() { return getTokens(BladeAntlrParser.D_BREAK); }
		public TerminalNode D_BREAK(int i) {
			return getToken(BladeAntlrParser.D_BREAK, i);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSwitchStatement(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(D_SWITCH);
			setState(224);
			directiveArguments();
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==D_CASE) {
				{
				{
				setState(225);
				match(D_CASE);
				setState(226);
				directiveArguments();
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(227);
					statement();
					}
					}
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_BREAK) {
					{
					setState(233);
					match(D_BREAK);
					}
				}

				}
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_DEFAULT) {
				{
				setState(241);
				match(D_DEFAULT);
				setState(242);
				directiveArguments();
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(243);
					statement();
					}
					}
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(251);
			match(D_ENDSWITCH);
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
	public static class InlineDirectiveContext extends ParserRuleContext {
		public TerminalNode D_SIMPLE_DIRECTIVE() { return getToken(BladeAntlrParser.D_SIMPLE_DIRECTIVE, 0); }
		public DirectiveArgumentsContext directiveArguments() {
			return getRuleContext(DirectiveArgumentsContext.class,0);
		}
		public TerminalNode D_PHP() { return getToken(BladeAntlrParser.D_PHP, 0); }
		public InlineDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterInlineDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitInlineDirective(this);
		}
	}

	public final InlineDirectiveContext inlineDirective() throws RecognitionException {
		InlineDirectiveContext _localctx = new InlineDirectiveContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inlineDirective);
		try {
			setState(257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SIMPLE_DIRECTIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				match(D_SIMPLE_DIRECTIVE);
				setState(254);
				directiveArguments();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(D_PHP);
				setState(256);
				directiveArguments();
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
	public static class IdentifiableArgDirectiveContext extends ParserRuleContext {
		public TerminalNode D_SECTION() { return getToken(BladeAntlrParser.D_SECTION, 0); }
		public TerminalNode LPAREN() { return getToken(BladeAntlrParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BladeAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BladeAntlrParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(BladeAntlrParser.RPAREN, 0); }
		public TerminalNode IDENTIFIABLE_STRING() { return getToken(BladeAntlrParser.IDENTIFIABLE_STRING, 0); }
		public TerminalNode D_EXTENDS() { return getToken(BladeAntlrParser.D_EXTENDS, 0); }
		public TerminalNode D_INCLUDE() { return getToken(BladeAntlrParser.D_INCLUDE, 0); }
		public TerminalNode D_INCLUDE_IF() { return getToken(BladeAntlrParser.D_INCLUDE_IF, 0); }
		public TerminalNode D_INCLUDE_WHEN() { return getToken(BladeAntlrParser.D_INCLUDE_WHEN, 0); }
		public TerminalNode D_INCLUDE_UNLESS() { return getToken(BladeAntlrParser.D_INCLUDE_UNLESS, 0); }
		public TerminalNode D_YIELD() { return getToken(BladeAntlrParser.D_YIELD, 0); }
		public TerminalNode D_STACK() { return getToken(BladeAntlrParser.D_STACK, 0); }
		public TerminalNode D_LANG() { return getToken(BladeAntlrParser.D_LANG, 0); }
		public IdentifiableArgDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiableArgDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIdentifiableArgDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIdentifiableArgDirective(this);
		}
	}

	public final IdentifiableArgDirectiveContext identifiableArgDirective() throws RecognitionException {
		IdentifiableArgDirectiveContext _localctx = new IdentifiableArgDirectiveContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_identifiableArgDirective);
		int _la;
		try {
			setState(316);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(D_SECTION);
				setState(260);
				match(LPAREN);
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(261);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(264);
				match(COMMA);
				setState(265);
				match(RPAREN);
				}
				break;
			case D_EXTENDS:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(D_EXTENDS);
				setState(267);
				match(LPAREN);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(268);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(271);
				match(RPAREN);
				}
				break;
			case D_INCLUDE:
			case D_INCLUDE_IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(272);
				_la = _input.LA(1);
				if ( !(_la==D_INCLUDE || _la==D_INCLUDE_IF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(273);
				match(LPAREN);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(274);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(277);
					match(COMMA);
					}
				}

				setState(280);
				match(RPAREN);
				}
				break;
			case D_INCLUDE_WHEN:
			case D_INCLUDE_UNLESS:
				enterOuterAlt(_localctx, 4);
				{
				setState(281);
				_la = _input.LA(1);
				if ( !(_la==D_INCLUDE_WHEN || _la==D_INCLUDE_UNLESS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(282);
				match(LPAREN);
				setState(283);
				match(COMMA);
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(284);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(287);
				match(COMMA);
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(288);
					match(COMMA);
					}
				}

				setState(291);
				match(RPAREN);
				}
				break;
			case D_YIELD:
				enterOuterAlt(_localctx, 5);
				{
				setState(292);
				match(D_YIELD);
				setState(293);
				match(LPAREN);
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(294);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(297);
					match(COMMA);
					}
				}

				setState(300);
				match(RPAREN);
				}
				break;
			case D_STACK:
				enterOuterAlt(_localctx, 6);
				{
				setState(301);
				match(D_STACK);
				setState(302);
				match(LPAREN);
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(303);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(306);
				match(RPAREN);
				}
				break;
			case D_LANG:
				enterOuterAlt(_localctx, 7);
				{
				setState(307);
				match(D_LANG);
				setState(308);
				match(LPAREN);
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(309);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(312);
					match(COMMA);
					}
				}

				setState(315);
				match(RPAREN);
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
	public static class MultipleArgDirectiveContext extends ParserRuleContext {
		public TerminalNode D_EACH() { return getToken(BladeAntlrParser.D_EACH, 0); }
		public TerminalNode LPAREN() { return getToken(BladeAntlrParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BladeAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BladeAntlrParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(BladeAntlrParser.RPAREN, 0); }
		public List<TerminalNode> IDENTIFIABLE_STRING() { return getTokens(BladeAntlrParser.IDENTIFIABLE_STRING); }
		public TerminalNode IDENTIFIABLE_STRING(int i) {
			return getToken(BladeAntlrParser.IDENTIFIABLE_STRING, i);
		}
		public TerminalNode D_INCLUDE_FIRST() { return getToken(BladeAntlrParser.D_INCLUDE_FIRST, 0); }
		public MultipleArgDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleArgDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterMultipleArgDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitMultipleArgDirective(this);
		}
	}

	public final MultipleArgDirectiveContext multipleArgDirective() throws RecognitionException {
		MultipleArgDirectiveContext _localctx = new MultipleArgDirectiveContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_multipleArgDirective);
		int _la;
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EACH:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				match(D_EACH);
				setState(319);
				match(LPAREN);
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(320);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(323);
				match(COMMA);
				setState(324);
				match(COMMA);
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(325);
					match(COMMA);
					setState(327);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIABLE_STRING) {
						{
						setState(326);
						match(IDENTIFIABLE_STRING);
						}
					}

					}
				}

				setState(331);
				match(RPAREN);
				}
				break;
			case D_INCLUDE_FIRST:
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				match(D_INCLUDE_FIRST);
				setState(333);
				match(LPAREN);
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIABLE_STRING) {
					{
					{
					setState(334);
					match(IDENTIFIABLE_STRING);
					}
					}
					setState(339);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(340);
					match(COMMA);
					}
				}

				setState(343);
				match(RPAREN);
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
	public static class BlockIdentifiableArgDirectiveContext extends ParserRuleContext {
		public TerminalNode D_SECTION() { return getToken(BladeAntlrParser.D_SECTION, 0); }
		public TerminalNode LPAREN() { return getToken(BladeAntlrParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BladeAntlrParser.RPAREN, 0); }
		public TerminalNode D_SHOW() { return getToken(BladeAntlrParser.D_SHOW, 0); }
		public TerminalNode D_STOP() { return getToken(BladeAntlrParser.D_STOP, 0); }
		public TerminalNode D_OVERWRITE() { return getToken(BladeAntlrParser.D_OVERWRITE, 0); }
		public TerminalNode D_ENDSECTION() { return getToken(BladeAntlrParser.D_ENDSECTION, 0); }
		public TerminalNode D_APPEND() { return getToken(BladeAntlrParser.D_APPEND, 0); }
		public TerminalNode IDENTIFIABLE_STRING() { return getToken(BladeAntlrParser.IDENTIFIABLE_STRING, 0); }
		public TerminalNode D_PARENT() { return getToken(BladeAntlrParser.D_PARENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode D_HAS_SECTION() { return getToken(BladeAntlrParser.D_HAS_SECTION, 0); }
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrParser.D_ENDIF, 0); }
		public TerminalNode D_SECTION_MISSING() { return getToken(BladeAntlrParser.D_SECTION_MISSING, 0); }
		public TerminalNode D_PUSH() { return getToken(BladeAntlrParser.D_PUSH, 0); }
		public TerminalNode D_ENDPUSH() { return getToken(BladeAntlrParser.D_ENDPUSH, 0); }
		public TerminalNode D_PUSH_IF() { return getToken(BladeAntlrParser.D_PUSH_IF, 0); }
		public TerminalNode COMMA() { return getToken(BladeAntlrParser.COMMA, 0); }
		public TerminalNode D_ENDPUSH_IF() { return getToken(BladeAntlrParser.D_ENDPUSH_IF, 0); }
		public TerminalNode D_PUSH_ONCE() { return getToken(BladeAntlrParser.D_PUSH_ONCE, 0); }
		public TerminalNode D_ENDPUSH_ONCE() { return getToken(BladeAntlrParser.D_ENDPUSH_ONCE, 0); }
		public TerminalNode D_PREPEND() { return getToken(BladeAntlrParser.D_PREPEND, 0); }
		public TerminalNode D_ENDPREPEND() { return getToken(BladeAntlrParser.D_ENDPREPEND, 0); }
		public BlockIdentifiableArgDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockIdentifiableArgDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterBlockIdentifiableArgDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitBlockIdentifiableArgDirective(this);
		}
	}

	public final BlockIdentifiableArgDirectiveContext blockIdentifiableArgDirective() throws RecognitionException {
		BlockIdentifiableArgDirectiveContext _localctx = new BlockIdentifiableArgDirectiveContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_blockIdentifiableArgDirective);
		int _la;
		try {
			setState(441);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				match(D_SECTION);
				setState(347);
				match(LPAREN);
				setState(349);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(348);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(351);
				match(RPAREN);
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_PARENT) {
					{
					setState(352);
					match(D_PARENT);
					}
				}

				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(355);
					statement();
					}
					}
					setState(360);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(361);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 523986010112L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case D_HAS_SECTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				match(D_HAS_SECTION);
				setState(363);
				match(LPAREN);
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(364);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(367);
				match(RPAREN);
				setState(371);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(368);
					statement();
					}
					}
					setState(373);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(374);
				match(D_ENDIF);
				}
				break;
			case D_SECTION_MISSING:
				enterOuterAlt(_localctx, 3);
				{
				setState(375);
				match(D_SECTION_MISSING);
				setState(376);
				match(LPAREN);
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(377);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(380);
				match(RPAREN);
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(381);
					statement();
					}
					}
					setState(386);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(387);
				match(D_ENDIF);
				}
				break;
			case D_PUSH:
				enterOuterAlt(_localctx, 4);
				{
				setState(388);
				match(D_PUSH);
				setState(389);
				match(LPAREN);
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(390);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(393);
				match(RPAREN);
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(394);
					statement();
					}
					}
					setState(399);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(400);
				match(D_ENDPUSH);
				}
				break;
			case D_PUSH_IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(401);
				match(D_PUSH_IF);
				setState(402);
				match(LPAREN);
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(403);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(406);
				match(COMMA);
				setState(407);
				match(RPAREN);
				setState(411);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(408);
					statement();
					}
					}
					setState(413);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(414);
				match(D_ENDPUSH_IF);
				}
				break;
			case D_PUSH_ONCE:
				enterOuterAlt(_localctx, 6);
				{
				setState(415);
				match(D_PUSH_ONCE);
				setState(416);
				match(LPAREN);
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(417);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(420);
				match(RPAREN);
				setState(424);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(421);
					statement();
					}
					}
					setState(426);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(427);
				match(D_ENDPUSH_ONCE);
				}
				break;
			case D_PREPEND:
				enterOuterAlt(_localctx, 7);
				{
				setState(428);
				match(D_PREPEND);
				setState(429);
				match(LPAREN);
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(430);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(433);
				match(RPAREN);
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(434);
					statement();
					}
					}
					setState(439);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(440);
				match(D_ENDPREPEND);
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
	public static class DirectiveWithArgContext extends ParserRuleContext {
		public TerminalNode D_EXTENDS() { return getToken(BladeAntlrParser.D_EXTENDS, 0); }
		public TerminalNode D_INCLUDE() { return getToken(BladeAntlrParser.D_INCLUDE, 0); }
		public TerminalNode D_YIELD() { return getToken(BladeAntlrParser.D_YIELD, 0); }
		public DirectiveWithArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directiveWithArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterDirectiveWithArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitDirectiveWithArg(this);
		}
	}

	public final DirectiveWithArgContext directiveWithArg() throws RecognitionException {
		DirectiveWithArgContext _localctx = new DirectiveWithArgContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_directiveWithArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2197815296L) != 0)) ) {
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
	public static class CustomDirectiveContext extends ParserRuleContext {
		public TerminalNode D_CUSTOM() { return getToken(BladeAntlrParser.D_CUSTOM, 0); }
		public DirectiveArgumentsContext directiveArguments() {
			return getRuleContext(DirectiveArgumentsContext.class,0);
		}
		public CustomDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterCustomDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitCustomDirective(this);
		}
	}

	public final CustomDirectiveContext customDirective() throws RecognitionException {
		CustomDirectiveContext _localctx = new CustomDirectiveContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_customDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			match(D_CUSTOM);
			setState(446);
			directiveArguments();
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
	public static class LoopBreaksContext extends ParserRuleContext {
		public TerminalNode D_CONTINUE() { return getToken(BladeAntlrParser.D_CONTINUE, 0); }
		public TerminalNode D_BREAK() { return getToken(BladeAntlrParser.D_BREAK, 0); }
		public DirectiveArgumentsContext directiveArguments() {
			return getRuleContext(DirectiveArgumentsContext.class,0);
		}
		public LoopBreaksContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopBreaks; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterLoopBreaks(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitLoopBreaks(this);
		}
	}

	public final LoopBreaksContext loopBreaks() throws RecognitionException {
		LoopBreaksContext _localctx = new LoopBreaksContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_loopBreaks);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			_la = _input.LA(1);
			if ( !(_la==D_BREAK || _la==D_CONTINUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(449);
				directiveArguments();
				}
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
	public static class FormStatementsContext extends ParserRuleContext {
		public TerminalNode D_ERROR() { return getToken(BladeAntlrParser.D_ERROR, 0); }
		public TerminalNode LPAREN() { return getToken(BladeAntlrParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BladeAntlrParser.RPAREN, 0); }
		public TerminalNode D_ENDERROR() { return getToken(BladeAntlrParser.D_ENDERROR, 0); }
		public TerminalNode COMMA() { return getToken(BladeAntlrParser.COMMA, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
		public TerminalNode D_CSRF() { return getToken(BladeAntlrParser.D_CSRF, 0); }
		public TerminalNode D_METHOD() { return getToken(BladeAntlrParser.D_METHOD, 0); }
		public DirectiveArgumentsContext directiveArguments() {
			return getRuleContext(DirectiveArgumentsContext.class,0);
		}
		public FormStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterFormStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitFormStatements(this);
		}
	}

	public final FormStatementsContext formStatements() throws RecognitionException {
		FormStatementsContext _localctx = new FormStatementsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_formStatements);
		int _la;
		try {
			setState(477);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_ERROR:
				enterOuterAlt(_localctx, 1);
				{
				setState(452);
				match(D_ERROR);
				setState(453);
				match(LPAREN);
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(454);
					match(COMMA);
					}
				}

				setState(457);
				match(RPAREN);
				setState(461);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(458);
					statement();
					}
					}
					setState(463);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(471);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(464);
					match(D_ELSE);
					setState(468);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
						{
						{
						setState(465);
						statement();
						}
						}
						setState(470);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(473);
				match(D_ENDERROR);
				}
				break;
			case D_CSRF:
				enterOuterAlt(_localctx, 2);
				{
				setState(474);
				match(D_CSRF);
				}
				break;
			case D_METHOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(475);
				match(D_METHOD);
				setState(476);
				directiveArguments();
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
	public static class AuthStatementsContext extends ParserRuleContext {
		public TerminalNode D_AUTH() { return getToken(BladeAntlrParser.D_AUTH, 0); }
		public TerminalNode D_ENDAUTH() { return getToken(BladeAntlrParser.D_ENDAUTH, 0); }
		public DirectiveArgumentsContext directiveArguments() {
			return getRuleContext(DirectiveArgumentsContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode D_ELSEGUEST() { return getToken(BladeAntlrParser.D_ELSEGUEST, 0); }
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
		public TerminalNode D_GUEST() { return getToken(BladeAntlrParser.D_GUEST, 0); }
		public TerminalNode D_ENDGUEST() { return getToken(BladeAntlrParser.D_ENDGUEST, 0); }
		public TerminalNode D_ENV() { return getToken(BladeAntlrParser.D_ENV, 0); }
		public TerminalNode D_ENDENV() { return getToken(BladeAntlrParser.D_ENDENV, 0); }
		public TerminalNode D_PRODUCTION() { return getToken(BladeAntlrParser.D_PRODUCTION, 0); }
		public TerminalNode D_ENDPRODUCTION() { return getToken(BladeAntlrParser.D_ENDPRODUCTION, 0); }
		public AuthStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_authStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterAuthStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitAuthStatements(this);
		}
	}

	public final AuthStatementsContext authStatements() throws RecognitionException {
		AuthStatementsContext _localctx = new AuthStatementsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_authStatements);
		int _la;
		try {
			setState(528);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_AUTH:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				match(D_AUTH);
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(480);
					directiveArguments();
					}
				}

				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(483);
					statement();
					}
					}
					setState(488);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(496);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE || _la==D_ELSEGUEST) {
					{
					setState(489);
					_la = _input.LA(1);
					if ( !(_la==D_ELSE || _la==D_ELSEGUEST) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(493);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
						{
						{
						setState(490);
						statement();
						}
						}
						setState(495);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(498);
				match(D_ENDAUTH);
				}
				break;
			case D_GUEST:
				enterOuterAlt(_localctx, 2);
				{
				setState(499);
				match(D_GUEST);
				setState(501);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(500);
					directiveArguments();
					}
				}

				setState(506);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(503);
					statement();
					}
					}
					setState(508);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(509);
				match(D_ENDGUEST);
				}
				break;
			case D_ENV:
				enterOuterAlt(_localctx, 3);
				{
				setState(510);
				match(D_ENV);
				setState(511);
				directiveArguments();
				setState(515);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(512);
					statement();
					}
					}
					setState(517);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(518);
				match(D_ENDENV);
				}
				break;
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(520);
				match(D_PRODUCTION);
				setState(524);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4998246277781459472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 62563701L) != 0)) {
					{
					{
					setState(521);
					statement();
					}
					}
					setState(526);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(527);
				match(D_ENDPRODUCTION);
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
	public static class BladeContentTagsContext extends ParserRuleContext {
		public TerminalNode BLADE_CONTENT_OPEN_TAG() { return getToken(BladeAntlrParser.BLADE_CONTENT_OPEN_TAG, 0); }
		public TerminalNode BLADE_CONTENT_CLOSE_TAG() { return getToken(BladeAntlrParser.BLADE_CONTENT_CLOSE_TAG, 0); }
		public BladeContentTagsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bladeContentTags; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterBladeContentTags(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitBladeContentTags(this);
		}
	}

	public final BladeContentTagsContext bladeContentTags() throws RecognitionException {
		BladeContentTagsContext _localctx = new BladeContentTagsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_bladeContentTags);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			match(BLADE_CONTENT_OPEN_TAG);
			setState(531);
			match(BLADE_CONTENT_CLOSE_TAG);
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
	public static class BladeRawTagsContext extends ParserRuleContext {
		public TerminalNode BLADE_RAW_OPEN_TAG() { return getToken(BladeAntlrParser.BLADE_RAW_OPEN_TAG, 0); }
		public TerminalNode BLADE_RAW_CLOSE_TAG() { return getToken(BladeAntlrParser.BLADE_RAW_CLOSE_TAG, 0); }
		public BladeRawTagsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bladeRawTags; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterBladeRawTags(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitBladeRawTags(this);
		}
	}

	public final BladeRawTagsContext bladeRawTags() throws RecognitionException {
		BladeRawTagsContext _localctx = new BladeRawTagsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_bladeRawTags);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			match(BLADE_RAW_OPEN_TAG);
			setState(534);
			match(BLADE_RAW_CLOSE_TAG);
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
	public static class ErrorDirectivesContext extends ParserRuleContext {
		public DirectiveWithArgContext directiveWithArg() {
			return getRuleContext(DirectiveWithArgContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(BladeAntlrParser.LPAREN, 0); }
		public TerminalNode D_IF() { return getToken(BladeAntlrParser.D_IF, 0); }
		public DirectiveArgumentsContext directiveArguments() {
			return getRuleContext(DirectiveArgumentsContext.class,0);
		}
		public TerminalNode D_FOREACH() { return getToken(BladeAntlrParser.D_FOREACH, 0); }
		public TerminalNode D_FOR() { return getToken(BladeAntlrParser.D_FOR, 0); }
		public TerminalNode D_VERBATIM() { return getToken(BladeAntlrParser.D_VERBATIM, 0); }
		public TerminalNode D_SECTION() { return getToken(BladeAntlrParser.D_SECTION, 0); }
		public TerminalNode RPAREN() { return getToken(BladeAntlrParser.RPAREN, 0); }
		public TerminalNode IDENTIFIABLE_STRING() { return getToken(BladeAntlrParser.IDENTIFIABLE_STRING, 0); }
		public ErrorDirectivesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_errorDirectives; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterErrorDirectives(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitErrorDirectives(this);
		}
	}

	public final ErrorDirectivesContext errorDirectives() throws RecognitionException {
		ErrorDirectivesContext _localctx = new ErrorDirectivesContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_errorDirectives);
		int _la;
		try {
			setState(557);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EXTENDS:
			case D_INCLUDE:
			case D_YIELD:
				enterOuterAlt(_localctx, 1);
				{
				setState(536);
				directiveWithArg();
				setState(537);
				match(LPAREN);
				notifyErrorListeners("Missing closing ')'");
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				match(D_IF);
				setState(541);
				directiveArguments();
				notifyErrorListeners("Syntax error, expecting @elseif or @else or @endif");
				}
				break;
			case D_FOREACH:
			case D_FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(544);
				_la = _input.LA(1);
				if ( !(_la==D_FOREACH || _la==D_FOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(545);
				directiveArguments();
				notifyErrorListeners("Unclosed block directive");
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 4);
				{
				setState(548);
				match(D_VERBATIM);
				notifyErrorListeners("Unclosed verbatim block");
				}
				break;
			case D_SECTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(550);
				match(D_SECTION);
				setState(551);
				match(LPAREN);
				setState(553);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(552);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(555);
				match(RPAREN);
				notifyErrorListeners("Inline @section requires second argument");
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
	public static class DirectiveArgumentsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BladeAntlrParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BladeAntlrParser.RPAREN, 0); }
		public DirectiveArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directiveArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterDirectiveArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitDirectiveArguments(this);
		}
	}

	public final DirectiveArgumentsContext directiveArguments() throws RecognitionException {
		DirectiveArgumentsContext _localctx = new DirectiveArgumentsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_directiveArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			match(LPAREN);
			setState(560);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0085\u0233\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0005\u00000\b\u0000\n\u0000"+
		"\f\u00003\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001A\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002K\b\u0002\n\u0002\f\u0002N\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002W\b"+
		"\u0002\u0001\u0002\u0005\u0002Z\b\u0002\n\u0002\f\u0002]\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002c\b\u0002\n\u0002"+
		"\f\u0002f\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002m\b\u0002\n\u0002\f\u0002p\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002w\b\u0002\n\u0002"+
		"\f\u0002z\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u0081\b\u0002\n\u0002\f\u0002\u0084\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u008d\b\u0002\n\u0002\f\u0002\u0090\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0096\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u009c\b\u0003\n\u0003\f\u0003"+
		"\u009f\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u00a4\b"+
		"\u0003\n\u0003\f\u0003\u00a7\t\u0003\u0003\u0003\u00a9\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u00b1\b\u0004\n\u0004\f\u0004\u00b4\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00bc\b\u0005\n"+
		"\u0005\f\u0005\u00bf\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00c7\b\u0006\n\u0006\f\u0006"+
		"\u00ca\t\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00ce\b\u0006\n\u0006"+
		"\f\u0006\u00d1\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u00db\b\b\n\b\f\b\u00de\t"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00e5\b\t\n\t\f\t\u00e8"+
		"\t\t\u0001\t\u0003\t\u00eb\b\t\u0005\t\u00ed\b\t\n\t\f\t\u00f0\t\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u00f5\b\t\n\t\f\t\u00f8\t\t\u0003\t\u00fa\b"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0102\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0107\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u010e\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0114\b\u000b\u0001"+
		"\u000b\u0003\u000b\u0117\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u011e\b\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u0122\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u0128\b\u000b\u0001\u000b\u0003\u000b\u012b\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0131\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0137\b\u000b\u0001\u000b"+
		"\u0003\u000b\u013a\b\u000b\u0001\u000b\u0003\u000b\u013d\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u0142\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u0148\b\f\u0003\f\u014a\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f"+
		"\u0150\b\f\n\f\f\f\u0153\t\f\u0001\f\u0003\f\u0156\b\f\u0001\f\u0003\f"+
		"\u0159\b\f\u0001\r\u0001\r\u0001\r\u0003\r\u015e\b\r\u0001\r\u0001\r\u0003"+
		"\r\u0162\b\r\u0001\r\u0005\r\u0165\b\r\n\r\f\r\u0168\t\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u016e\b\r\u0001\r\u0001\r\u0005\r\u0172\b\r"+
		"\n\r\f\r\u0175\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u017b\b\r\u0001"+
		"\r\u0001\r\u0005\r\u017f\b\r\n\r\f\r\u0182\t\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0003\r\u0188\b\r\u0001\r\u0001\r\u0005\r\u018c\b\r\n\r\f\r\u018f"+
		"\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0195\b\r\u0001\r\u0001\r"+
		"\u0001\r\u0005\r\u019a\b\r\n\r\f\r\u019d\t\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u01a3\b\r\u0001\r\u0001\r\u0005\r\u01a7\b\r\n\r\f\r\u01aa\t"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u01b0\b\r\u0001\r\u0001\r\u0005"+
		"\r\u01b4\b\r\n\r\f\r\u01b7\t\r\u0001\r\u0003\r\u01ba\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u01c3\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01c8"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u01cc\b\u0011\n\u0011\f\u0011"+
		"\u01cf\t\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u01d3\b\u0011\n\u0011"+
		"\f\u0011\u01d6\t\u0011\u0003\u0011\u01d8\b\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u01de\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u01e2\b\u0012\u0001\u0012\u0005\u0012\u01e5\b\u0012\n\u0012"+
		"\f\u0012\u01e8\t\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u01ec\b\u0012"+
		"\n\u0012\f\u0012\u01ef\t\u0012\u0003\u0012\u01f1\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u01f6\b\u0012\u0001\u0012\u0005\u0012\u01f9"+
		"\b\u0012\n\u0012\f\u0012\u01fc\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u0202\b\u0012\n\u0012\f\u0012\u0205\t\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u020b\b\u0012\n"+
		"\u0012\f\u0012\u020e\t\u0012\u0001\u0012\u0003\u0012\u0211\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u022a"+
		"\b\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u022e\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0000\u0000\u0017\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,\u0000\b\u0002\u0000\u0004\u0004XX\u0001\u0000\u0019\u001a\u0001"+
		"\u0000\u001b\u001c\u0002\u0000!!#&\u0002\u0000\u0018\u0019\u001f\u001f"+
		"\u0001\u0000<=\u0002\u0000\u000e\u000eKK\u0002\u00004466\u0294\u00001"+
		"\u0001\u0000\u0000\u0000\u0002@\u0001\u0000\u0000\u0000\u0004\u0095\u0001"+
		"\u0000\u0000\u0000\u0006\u0097\u0001\u0000\u0000\u0000\b\u00ac\u0001\u0000"+
		"\u0000\u0000\n\u00b7\u0001\u0000\u0000\u0000\f\u00c2\u0001\u0000\u0000"+
		"\u0000\u000e\u00d4\u0001\u0000\u0000\u0000\u0010\u00d7\u0001\u0000\u0000"+
		"\u0000\u0012\u00df\u0001\u0000\u0000\u0000\u0014\u0101\u0001\u0000\u0000"+
		"\u0000\u0016\u013c\u0001\u0000\u0000\u0000\u0018\u0158\u0001\u0000\u0000"+
		"\u0000\u001a\u01b9\u0001\u0000\u0000\u0000\u001c\u01bb\u0001\u0000\u0000"+
		"\u0000\u001e\u01bd\u0001\u0000\u0000\u0000 \u01c0\u0001\u0000\u0000\u0000"+
		"\"\u01dd\u0001\u0000\u0000\u0000$\u0210\u0001\u0000\u0000\u0000&\u0212"+
		"\u0001\u0000\u0000\u0000(\u0215\u0001\u0000\u0000\u0000*\u022d\u0001\u0000"+
		"\u0000\u0000,\u022f\u0001\u0000\u0000\u0000.0\u0003\u0002\u0001\u0000"+
		"/.\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000"+
		"\u000012\u0001\u0000\u0000\u000024\u0001\u0000\u0000\u000031\u0001\u0000"+
		"\u0000\u000045\u0005\u0000\u0000\u00015\u0001\u0001\u0000\u0000\u0000"+
		"6A\u0003\u001a\r\u00007A\u0003\u0004\u0002\u00008A\u0003\u0016\u000b\u0000"+
		"9A\u0003\u0018\f\u0000:A\u0003\u0014\n\u0000;A\u0003\u001e\u000f\u0000"+
		"<A\u0003&\u0013\u0000=A\u0003(\u0014\u0000>A\u0007\u0000\u0000\u0000?"+
		"A\u0003*\u0015\u0000@6\u0001\u0000\u0000\u0000@7\u0001\u0000\u0000\u0000"+
		"@8\u0001\u0000\u0000\u0000@9\u0001\u0000\u0000\u0000@:\u0001\u0000\u0000"+
		"\u0000@;\u0001\u0000\u0000\u0000@<\u0001\u0000\u0000\u0000@=\u0001\u0000"+
		"\u0000\u0000@>\u0001\u0000\u0000\u0000@?\u0001\u0000\u0000\u0000A\u0003"+
		"\u0001\u0000\u0000\u0000B\u0096\u0003\u0006\u0003\u0000C\u0096\u0003\b"+
		"\u0004\u0000D\u0096\u0003\n\u0005\u0000E\u0096\u0003\f\u0006\u0000FG\u0005"+
		":\u0000\u0000GL\u0003,\u0016\u0000HK\u0003\u0002\u0001\u0000IK\u0003 "+
		"\u0010\u0000JH\u0001\u0000\u0000\u0000JI\u0001\u0000\u0000\u0000KN\u0001"+
		"\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MO\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000OP\u0005;\u0000\u0000"+
		"P\u0096\u0001\u0000\u0000\u0000Q\u0096\u0003\u0012\t\u0000R\u0096\u0003"+
		"\"\u0011\u0000S\u0096\u0003$\u0012\u0000TV\u0005\'\u0000\u0000UW\u0003"+
		",\u0016\u0000VU\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000W[\u0001"+
		"\u0000\u0000\u0000XZ\u0003\u0002\u0001\u0000YX\u0001\u0000\u0000\u0000"+
		"Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000"+
		"\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^\u0096\u0005"+
		"(\u0000\u0000_`\u0005\u0010\u0000\u0000`d\u0003,\u0016\u0000ac\u0003\u0002"+
		"\u0001\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000db\u0001"+
		"\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0001\u0000\u0000\u0000"+
		"fd\u0001\u0000\u0000\u0000gh\u0005\u0011\u0000\u0000h\u0096\u0001\u0000"+
		"\u0000\u0000ij\u0005>\u0000\u0000jn\u0003,\u0016\u0000km\u0003\u0002\u0001"+
		"\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001\u0000"+
		"\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000\u0000pn\u0001"+
		"\u0000\u0000\u0000qr\u0005?\u0000\u0000r\u0096\u0001\u0000\u0000\u0000"+
		"st\u0005\u0012\u0000\u0000tx\u0003,\u0016\u0000uw\u0003\u0002\u0001\u0000"+
		"vu\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000y{\u0001\u0000\u0000\u0000zx\u0001\u0000"+
		"\u0000\u0000{|\u0005\u0013\u0000\u0000|\u0096\u0001\u0000\u0000\u0000"+
		"}~\u0005B\u0000\u0000~\u0082\u0003,\u0016\u0000\u007f\u0081\u0003\u0002"+
		"\u0001\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000"+
		"\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000"+
		"\u0000\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0005C\u0000\u0000\u0086\u0096\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0005\t\u0000\u0000\u0088\u0096\u0005\u0080\u0000\u0000"+
		"\u0089\u008a\u0005Q\u0000\u0000\u008a\u008e\u0003,\u0016\u0000\u008b\u008d"+
		"\u0003\u0002\u0001\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d\u0090"+
		"\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0001\u0000\u0000\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u008e"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0005R\u0000\u0000\u0092\u0096\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0005@\u0000\u0000\u0094\u0096\u0005A\u0000"+
		"\u0000\u0095B\u0001\u0000\u0000\u0000\u0095C\u0001\u0000\u0000\u0000\u0095"+
		"D\u0001\u0000\u0000\u0000\u0095E\u0001\u0000\u0000\u0000\u0095F\u0001"+
		"\u0000\u0000\u0000\u0095Q\u0001\u0000\u0000\u0000\u0095R\u0001\u0000\u0000"+
		"\u0000\u0095S\u0001\u0000\u0000\u0000\u0095T\u0001\u0000\u0000\u0000\u0095"+
		"_\u0001\u0000\u0000\u0000\u0095i\u0001\u0000\u0000\u0000\u0095s\u0001"+
		"\u0000\u0000\u0000\u0095}\u0001\u0000\u0000\u0000\u0095\u0087\u0001\u0000"+
		"\u0000\u0000\u0095\u0089\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000"+
		"\u0000\u0000\u0096\u0005\u0001\u0000\u0000\u0000\u0097\u009d\u0003\u000e"+
		"\u0007\u0000\u0098\u009c\u0003\u0010\b\u0000\u0099\u009c\u0003\u0002\u0001"+
		"\u0000\u009a\u009c\u0003 \u0010\u0000\u009b\u0098\u0001\u0000\u0000\u0000"+
		"\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000"+
		"\u009c\u009f\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u00a8\u0001\u0000\u0000\u0000"+
		"\u009f\u009d\u0001\u0000\u0000\u0000\u00a0\u00a5\u0005\u000e\u0000\u0000"+
		"\u00a1\u00a4\u0003\u0002\u0001\u0000\u00a2\u00a4\u0003 \u0010\u0000\u00a3"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a8\u00a0\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0005\u000f\u0000\u0000\u00ab\u0007\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ad\u00054\u0000\u0000\u00ad\u00b2\u0003,\u0016\u0000\u00ae\u00b1\u0003"+
		"\u0002\u0001\u0000\u00af\u00b1\u0003 \u0010\u0000\u00b0\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b1\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b5\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u00055\u0000\u0000\u00b6\t\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u00056\u0000\u0000\u00b8\u00bd\u0003,\u0016\u0000\u00b9"+
		"\u00bc\u0003\u0002\u0001\u0000\u00ba\u00bc\u0003 \u0010\u0000\u00bb\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bf"+
		"\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be"+
		"\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf\u00bd"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c1\u00057\u0000\u0000\u00c1\u000b\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u00058\u0000\u0000\u00c3\u00c8\u0003,\u0016"+
		"\u0000\u00c4\u00c7\u0003\u0002\u0001\u0000\u00c5\u00c7\u0003 \u0010\u0000"+
		"\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c7\u00ca\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00cb\u0001\u0000\u0000\u0000"+
		"\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb\u00cf\u0005>\u0000\u0000\u00cc"+
		"\u00ce\u0003\u0002\u0001\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d3\u00059\u0000\u0000\u00d3\r"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\f\u0000\u0000\u00d5\u00d6\u0003"+
		",\u0016\u0000\u00d6\u000f\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005\r"+
		"\u0000\u0000\u00d8\u00dc\u0003,\u0016\u0000\u00d9\u00db\u0003\u0002\u0001"+
		"\u0000\u00da\u00d9\u0001\u0000\u0000\u0000\u00db\u00de\u0001\u0000\u0000"+
		"\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000"+
		"\u0000\u00dd\u0011\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005\u0014\u0000\u0000\u00e0\u00ee\u0003,\u0016\u0000"+
		"\u00e1\u00e2\u0005\u0015\u0000\u0000\u00e2\u00e6\u0003,\u0016\u0000\u00e3"+
		"\u00e5\u0003\u0002\u0001\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e7\u00ea\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e9\u00eb\u0005<\u0000\u0000\u00ea\u00e9"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ec\u00e1\u0001\u0000\u0000\u0000\u00ed\u00f0"+
		"\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f9\u0001\u0000\u0000\u0000\u00f0\u00ee"+
		"\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005\u0016\u0000\u0000\u00f2\u00f6"+
		"\u0003,\u0016\u0000\u00f3\u00f5\u0003\u0002\u0001\u0000\u00f4\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f8\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00fa\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f9\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fc\u0005\u0017\u0000\u0000\u00fc\u0013\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0005S\u0000\u0000\u00fe\u0102\u0003,\u0016"+
		"\u0000\u00ff\u0100\u0005\t\u0000\u0000\u0100\u0102\u0003,\u0016\u0000"+
		"\u0101\u00fd\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000"+
		"\u0102\u0015\u0001\u0000\u0000\u0000\u0103\u0104\u0005 \u0000\u0000\u0104"+
		"\u0106\u0005\u0001\u0000\u0000\u0105\u0107\u0005\u0003\u0000\u0000\u0106"+
		"\u0105\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107"+
		"\u0108\u0001\u0000\u0000\u0000\u0108\u0109\u0005\n\u0000\u0000\u0109\u013d"+
		"\u0005\u0002\u0000\u0000\u010a\u010b\u0005\u0018\u0000\u0000\u010b\u010d"+
		"\u0005\u0001\u0000\u0000\u010c\u010e\u0005\u0003\u0000\u0000\u010d\u010c"+
		"\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u010f"+
		"\u0001\u0000\u0000\u0000\u010f\u013d\u0005\u0002\u0000\u0000\u0110\u0111"+
		"\u0007\u0001\u0000\u0000\u0111\u0113\u0005\u0001\u0000\u0000\u0112\u0114"+
		"\u0005\u0003\u0000\u0000\u0113\u0112\u0001\u0000\u0000\u0000\u0113\u0114"+
		"\u0001\u0000\u0000\u0000\u0114\u0116\u0001\u0000\u0000\u0000\u0115\u0117"+
		"\u0005\n\u0000\u0000\u0116\u0115\u0001\u0000\u0000\u0000\u0116\u0117\u0001"+
		"\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u013d\u0005"+
		"\u0002\u0000\u0000\u0119\u011a\u0007\u0002\u0000\u0000\u011a\u011b\u0005"+
		"\u0001\u0000\u0000\u011b\u011d\u0005\n\u0000\u0000\u011c\u011e\u0005\u0003"+
		"\u0000\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000"+
		"\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0121\u0005\n\u0000"+
		"\u0000\u0120\u0122\u0005\n\u0000\u0000\u0121\u0120\u0001\u0000\u0000\u0000"+
		"\u0121\u0122\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000"+
		"\u0123\u013d\u0005\u0002\u0000\u0000\u0124\u0125\u0005\u001f\u0000\u0000"+
		"\u0125\u0127\u0005\u0001\u0000\u0000\u0126\u0128\u0005\u0003\u0000\u0000"+
		"\u0127\u0126\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000"+
		"\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u012b\u0005\n\u0000\u0000\u012a"+
		"\u0129\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b"+
		"\u012c\u0001\u0000\u0000\u0000\u012c\u013d\u0005\u0002\u0000\u0000\u012d"+
		"\u012e\u0005)\u0000\u0000\u012e\u0130\u0005\u0001\u0000\u0000\u012f\u0131"+
		"\u0005\u0003\u0000\u0000\u0130\u012f\u0001\u0000\u0000\u0000\u0130\u0131"+
		"\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u013d"+
		"\u0005\u0002\u0000\u0000\u0133\u0134\u0005T\u0000\u0000\u0134\u0136\u0005"+
		"\u0001\u0000\u0000\u0135\u0137\u0005\u0003\u0000\u0000\u0136\u0135\u0001"+
		"\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137\u0139\u0001"+
		"\u0000\u0000\u0000\u0138\u013a\u0005\n\u0000\u0000\u0139\u0138\u0001\u0000"+
		"\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000"+
		"\u0000\u0000\u013b\u013d\u0005\u0002\u0000\u0000\u013c\u0103\u0001\u0000"+
		"\u0000\u0000\u013c\u010a\u0001\u0000\u0000\u0000\u013c\u0110\u0001\u0000"+
		"\u0000\u0000\u013c\u0119\u0001\u0000\u0000\u0000\u013c\u0124\u0001\u0000"+
		"\u0000\u0000\u013c\u012d\u0001\u0000\u0000\u0000\u013c\u0133\u0001\u0000"+
		"\u0000\u0000\u013d\u0017\u0001\u0000\u0000\u0000\u013e\u013f\u0005\u001d"+
		"\u0000\u0000\u013f\u0141\u0005\u0001\u0000\u0000\u0140\u0142\u0005\u0003"+
		"\u0000\u0000\u0141\u0140\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000"+
		"\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0144\u0005\n\u0000"+
		"\u0000\u0144\u0149\u0005\n\u0000\u0000\u0145\u0147\u0005\n\u0000\u0000"+
		"\u0146\u0148\u0005\u0003\u0000\u0000\u0147\u0146\u0001\u0000\u0000\u0000"+
		"\u0147\u0148\u0001\u0000\u0000\u0000\u0148\u014a\u0001\u0000\u0000\u0000"+
		"\u0149\u0145\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000"+
		"\u014a\u014b\u0001\u0000\u0000\u0000\u014b\u0159\u0005\u0002\u0000\u0000"+
		"\u014c\u014d\u0005\u001e\u0000\u0000\u014d\u0151\u0005\u0001\u0000\u0000"+
		"\u014e\u0150\u0005\u0003\u0000\u0000\u014f\u014e\u0001\u0000\u0000\u0000"+
		"\u0150\u0153\u0001\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000"+
		"\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u0155\u0001\u0000\u0000\u0000"+
		"\u0153\u0151\u0001\u0000\u0000\u0000\u0154\u0156\u0005\n\u0000\u0000\u0155"+
		"\u0154\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u0156"+
		"\u0157\u0001\u0000\u0000\u0000\u0157\u0159\u0005\u0002\u0000\u0000\u0158"+
		"\u013e\u0001\u0000\u0000\u0000\u0158\u014c\u0001\u0000\u0000\u0000\u0159"+
		"\u0019\u0001\u0000\u0000\u0000\u015a\u015b\u0005 \u0000\u0000\u015b\u015d"+
		"\u0005\u0001\u0000\u0000\u015c\u015e\u0005\u0003\u0000\u0000\u015d\u015c"+
		"\u0001\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u015f"+
		"\u0001\u0000\u0000\u0000\u015f\u0161\u0005\u0002\u0000\u0000\u0160\u0162"+
		"\u0005\"\u0000\u0000\u0161\u0160\u0001\u0000\u0000\u0000\u0161\u0162\u0001"+
		"\u0000\u0000\u0000\u0162\u0166\u0001\u0000\u0000\u0000\u0163\u0165\u0003"+
		"\u0002\u0001\u0000\u0164\u0163\u0001\u0000\u0000\u0000\u0165\u0168\u0001"+
		"\u0000\u0000\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0166\u0167\u0001"+
		"\u0000\u0000\u0000\u0167\u0169\u0001\u0000\u0000\u0000\u0168\u0166\u0001"+
		"\u0000\u0000\u0000\u0169\u01ba\u0007\u0003\u0000\u0000\u016a\u016b\u0005"+
		"2\u0000\u0000\u016b\u016d\u0005\u0001\u0000\u0000\u016c\u016e\u0005\u0003"+
		"\u0000\u0000\u016d\u016c\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000"+
		"\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u0173\u0005\u0002"+
		"\u0000\u0000\u0170\u0172\u0003\u0002\u0001\u0000\u0171\u0170\u0001\u0000"+
		"\u0000\u0000\u0172\u0175\u0001\u0000\u0000\u0000\u0173\u0171\u0001\u0000"+
		"\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174\u0176\u0001\u0000"+
		"\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0176\u01ba\u0005\u000f"+
		"\u0000\u0000\u0177\u0178\u00053\u0000\u0000\u0178\u017a\u0005\u0001\u0000"+
		"\u0000\u0179\u017b\u0005\u0003\u0000\u0000\u017a\u0179\u0001\u0000\u0000"+
		"\u0000\u017a\u017b\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000"+
		"\u0000\u017c\u0180\u0005\u0002\u0000\u0000\u017d\u017f\u0003\u0002\u0001"+
		"\u0000\u017e\u017d\u0001\u0000\u0000\u0000\u017f\u0182\u0001\u0000\u0000"+
		"\u0000\u0180\u017e\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000"+
		"\u0000\u0181\u0183\u0001\u0000\u0000\u0000\u0182\u0180\u0001\u0000\u0000"+
		"\u0000\u0183\u01ba\u0005\u000f\u0000\u0000\u0184\u0185\u0005*\u0000\u0000"+
		"\u0185\u0187\u0005\u0001\u0000\u0000\u0186\u0188\u0005\u0003\u0000\u0000"+
		"\u0187\u0186\u0001\u0000\u0000\u0000\u0187\u0188\u0001\u0000\u0000\u0000"+
		"\u0188\u0189\u0001\u0000\u0000\u0000\u0189\u018d\u0005\u0002\u0000\u0000"+
		"\u018a\u018c\u0003\u0002\u0001\u0000\u018b\u018a\u0001\u0000\u0000\u0000"+
		"\u018c\u018f\u0001\u0000\u0000\u0000\u018d\u018b\u0001\u0000\u0000\u0000"+
		"\u018d\u018e\u0001\u0000\u0000\u0000\u018e\u0190\u0001\u0000\u0000\u0000"+
		"\u018f\u018d\u0001\u0000\u0000\u0000\u0190\u01ba\u0005+\u0000\u0000\u0191"+
		"\u0192\u0005,\u0000\u0000\u0192\u0194\u0005\u0001\u0000\u0000\u0193\u0195"+
		"\u0005\u0003\u0000\u0000\u0194\u0193\u0001\u0000\u0000\u0000\u0194\u0195"+
		"\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u0196\u0197"+
		"\u0005\n\u0000\u0000\u0197\u019b\u0005\u0002\u0000\u0000\u0198\u019a\u0003"+
		"\u0002\u0001\u0000\u0199\u0198\u0001\u0000\u0000\u0000\u019a\u019d\u0001"+
		"\u0000\u0000\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019b\u019c\u0001"+
		"\u0000\u0000\u0000\u019c\u019e\u0001\u0000\u0000\u0000\u019d\u019b\u0001"+
		"\u0000\u0000\u0000\u019e\u01ba\u0005-\u0000\u0000\u019f\u01a0\u0005.\u0000"+
		"\u0000\u01a0\u01a2\u0005\u0001\u0000\u0000\u01a1\u01a3\u0005\u0003\u0000"+
		"\u0000\u01a2\u01a1\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4\u01a8\u0005\u0002\u0000"+
		"\u0000\u01a5\u01a7\u0003\u0002\u0001\u0000\u01a6\u01a5\u0001\u0000\u0000"+
		"\u0000\u01a7\u01aa\u0001\u0000\u0000\u0000\u01a8\u01a6\u0001\u0000\u0000"+
		"\u0000\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a9\u01ab\u0001\u0000\u0000"+
		"\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000\u01ab\u01ba\u0005/\u0000\u0000"+
		"\u01ac\u01ad\u00050\u0000\u0000\u01ad\u01af\u0005\u0001\u0000\u0000\u01ae"+
		"\u01b0\u0005\u0003\u0000\u0000\u01af\u01ae\u0001\u0000\u0000\u0000\u01af"+
		"\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000\u0000\u01b1"+
		"\u01b5\u0005\u0002\u0000\u0000\u01b2\u01b4\u0003\u0002\u0001\u0000\u01b3"+
		"\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000\u0000\u01b5"+
		"\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6"+
		"\u01b8\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b8"+
		"\u01ba\u00051\u0000\u0000\u01b9\u015a\u0001\u0000\u0000\u0000\u01b9\u016a"+
		"\u0001\u0000\u0000\u0000\u01b9\u0177\u0001\u0000\u0000\u0000\u01b9\u0184"+
		"\u0001\u0000\u0000\u0000\u01b9\u0191\u0001\u0000\u0000\u0000\u01b9\u019f"+
		"\u0001\u0000\u0000\u0000\u01b9\u01ac\u0001\u0000\u0000\u0000\u01ba\u001b"+
		"\u0001\u0000\u0000\u0000\u01bb\u01bc\u0007\u0004\u0000\u0000\u01bc\u001d"+
		"\u0001\u0000\u0000\u0000\u01bd\u01be\u0005Y\u0000\u0000\u01be\u01bf\u0003"+
		",\u0016\u0000\u01bf\u001f\u0001\u0000\u0000\u0000\u01c0\u01c2\u0007\u0005"+
		"\u0000\u0000\u01c1\u01c3\u0003,\u0016\u0000\u01c2\u01c1\u0001\u0000\u0000"+
		"\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3!\u0001\u0000\u0000\u0000"+
		"\u01c4\u01c5\u0005F\u0000\u0000\u01c5\u01c7\u0005\u0001\u0000\u0000\u01c6"+
		"\u01c8\u0005\n\u0000\u0000\u01c7\u01c6\u0001\u0000\u0000\u0000\u01c7\u01c8"+
		"\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000\u01c9\u01cd"+
		"\u0005\u0002\u0000\u0000\u01ca\u01cc\u0003\u0002\u0001\u0000\u01cb\u01ca"+
		"\u0001\u0000\u0000\u0000\u01cc\u01cf\u0001\u0000\u0000\u0000\u01cd\u01cb"+
		"\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ce\u01d7"+
		"\u0001\u0000\u0000\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000\u01d0\u01d4"+
		"\u0005\u000e\u0000\u0000\u01d1\u01d3\u0003\u0002\u0001\u0000\u01d2\u01d1"+
		"\u0001\u0000\u0000\u0000\u01d3\u01d6\u0001\u0000\u0000\u0000\u01d4\u01d2"+
		"\u0001\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000\u0000\u0000\u01d5\u01d8"+
		"\u0001\u0000\u0000\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d7\u01d0"+
		"\u0001\u0000\u0000\u0000\u01d7\u01d8\u0001\u0000\u0000\u0000\u01d8\u01d9"+
		"\u0001\u0000\u0000\u0000\u01d9\u01de\u0005G\u0000\u0000\u01da\u01de\u0005"+
		"D\u0000\u0000\u01db\u01dc\u0005E\u0000\u0000\u01dc\u01de\u0003,\u0016"+
		"\u0000\u01dd\u01c4\u0001\u0000\u0000\u0000\u01dd\u01da\u0001\u0000\u0000"+
		"\u0000\u01dd\u01db\u0001\u0000\u0000\u0000\u01de#\u0001\u0000\u0000\u0000"+
		"\u01df\u01e1\u0005H\u0000\u0000\u01e0\u01e2\u0003,\u0016\u0000\u01e1\u01e0"+
		"\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2\u01e6"+
		"\u0001\u0000\u0000\u0000\u01e3\u01e5\u0003\u0002\u0001\u0000\u01e4\u01e3"+
		"\u0001\u0000\u0000\u0000\u01e5\u01e8\u0001\u0000\u0000\u0000\u01e6\u01e4"+
		"\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01f0"+
		"\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e9\u01ed"+
		"\u0007\u0006\u0000\u0000\u01ea\u01ec\u0003\u0002\u0001\u0000\u01eb\u01ea"+
		"\u0001\u0000\u0000\u0000\u01ec\u01ef\u0001\u0000\u0000\u0000\u01ed\u01eb"+
		"\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000\u0000\u01ee\u01f1"+
		"\u0001\u0000\u0000\u0000\u01ef\u01ed\u0001\u0000\u0000\u0000\u01f0\u01e9"+
		"\u0001\u0000\u0000\u0000\u01f0\u01f1\u0001\u0000\u0000\u0000\u01f1\u01f2"+
		"\u0001\u0000\u0000\u0000\u01f2\u0211\u0005I\u0000\u0000\u01f3\u01f5\u0005"+
		"J\u0000\u0000\u01f4\u01f6\u0003,\u0016\u0000\u01f5\u01f4\u0001\u0000\u0000"+
		"\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000\u01f6\u01fa\u0001\u0000\u0000"+
		"\u0000\u01f7\u01f9\u0003\u0002\u0001\u0000\u01f8\u01f7\u0001\u0000\u0000"+
		"\u0000\u01f9\u01fc\u0001\u0000\u0000\u0000\u01fa\u01f8\u0001\u0000\u0000"+
		"\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000\u01fb\u01fd\u0001\u0000\u0000"+
		"\u0000\u01fc\u01fa\u0001\u0000\u0000\u0000\u01fd\u0211\u0005L\u0000\u0000"+
		"\u01fe\u01ff\u0005M\u0000\u0000\u01ff\u0203\u0003,\u0016\u0000\u0200\u0202"+
		"\u0003\u0002\u0001\u0000\u0201\u0200\u0001\u0000\u0000\u0000\u0202\u0205"+
		"\u0001\u0000\u0000\u0000\u0203\u0201\u0001\u0000\u0000\u0000\u0203\u0204"+
		"\u0001\u0000\u0000\u0000\u0204\u0206\u0001\u0000\u0000\u0000\u0205\u0203"+
		"\u0001\u0000\u0000\u0000\u0206\u0207\u0005N\u0000\u0000\u0207\u0211\u0001"+
		"\u0000\u0000\u0000\u0208\u020c\u0005O\u0000\u0000\u0209\u020b\u0003\u0002"+
		"\u0001\u0000\u020a\u0209\u0001\u0000\u0000\u0000\u020b\u020e\u0001\u0000"+
		"\u0000\u0000\u020c\u020a\u0001\u0000\u0000\u0000\u020c\u020d\u0001\u0000"+
		"\u0000\u0000\u020d\u020f\u0001\u0000\u0000\u0000\u020e\u020c\u0001\u0000"+
		"\u0000\u0000\u020f\u0211\u0005P\u0000\u0000\u0210\u01df\u0001\u0000\u0000"+
		"\u0000\u0210\u01f3\u0001\u0000\u0000\u0000\u0210\u01fe\u0001\u0000\u0000"+
		"\u0000\u0210\u0208\u0001\u0000\u0000\u0000\u0211%\u0001\u0000\u0000\u0000"+
		"\u0212\u0213\u0005U\u0000\u0000\u0213\u0214\u0005\u0004\u0000\u0000\u0214"+
		"\'\u0001\u0000\u0000\u0000\u0215\u0216\u0005W\u0000\u0000\u0216\u0217"+
		"\u0005X\u0000\u0000\u0217)\u0001\u0000\u0000\u0000\u0218\u0219\u0003\u001c"+
		"\u000e\u0000\u0219\u021a\u0005\u0001\u0000\u0000\u021a\u021b\u0006\u0015"+
		"\uffff\uffff\u0000\u021b\u022e\u0001\u0000\u0000\u0000\u021c\u021d\u0005"+
		"\f\u0000\u0000\u021d\u021e\u0003,\u0016\u0000\u021e\u021f\u0006\u0015"+
		"\uffff\uffff\u0000\u021f\u022e\u0001\u0000\u0000\u0000\u0220\u0221\u0007"+
		"\u0007\u0000\u0000\u0221\u0222\u0003,\u0016\u0000\u0222\u0223\u0006\u0015"+
		"\uffff\uffff\u0000\u0223\u022e\u0001\u0000\u0000\u0000\u0224\u0225\u0005"+
		"@\u0000\u0000\u0225\u022e\u0006\u0015\uffff\uffff\u0000\u0226\u0227\u0005"+
		" \u0000\u0000\u0227\u0229\u0005\u0001\u0000\u0000\u0228\u022a\u0005\u0003"+
		"\u0000\u0000\u0229\u0228\u0001\u0000\u0000\u0000\u0229\u022a\u0001\u0000"+
		"\u0000\u0000\u022a\u022b\u0001\u0000\u0000\u0000\u022b\u022c\u0005\u0002"+
		"\u0000\u0000\u022c\u022e\u0006\u0015\uffff\uffff\u0000\u022d\u0218\u0001"+
		"\u0000\u0000\u0000\u022d\u021c\u0001\u0000\u0000\u0000\u022d\u0220\u0001"+
		"\u0000\u0000\u0000\u022d\u0224\u0001\u0000\u0000\u0000\u022d\u0226\u0001"+
		"\u0000\u0000\u0000\u022e+\u0001\u0000\u0000\u0000\u022f\u0230\u0005\u0001"+
		"\u0000\u0000\u0230\u0231\u0005\u0002\u0000\u0000\u0231-\u0001\u0000\u0000"+
		"\u0000R1@JLV[dnx\u0082\u008e\u0095\u009b\u009d\u00a3\u00a5\u00a8\u00b0"+
		"\u00b2\u00bb\u00bd\u00c6\u00c8\u00cf\u00dc\u00e6\u00ea\u00ee\u00f6\u00f9"+
		"\u0101\u0106\u010d\u0113\u0116\u011d\u0121\u0127\u012a\u0130\u0136\u0139"+
		"\u013c\u0141\u0147\u0149\u0151\u0155\u0158\u015d\u0161\u0166\u016d\u0173"+
		"\u017a\u0180\u0187\u018d\u0194\u019b\u01a2\u01a8\u01af\u01b5\u01b9\u01c2"+
		"\u01c7\u01cd\u01d4\u01d7\u01dd\u01e1\u01e6\u01ed\u01f0\u01f5\u01fa\u0203"+
		"\u020c\u0210\u0229\u022d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}