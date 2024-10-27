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
		LPAREN=1, RPAREN=2, D_CUSTOM=3, IDENTIFIABLE_STRING=4, BLADE_CONTENT_CLOSE_TAG=5, 
		LSQUAREBRACKET=6, RSQUAREBRACKET=7, LCURLYBRACE=8, RCURLYBRACE=9, D_PHP=10, 
		COMMA=11, ERROR=12, D_IF=13, D_ELSEIF=14, D_ELSE=15, D_ENDIF=16, D_UNLESS=17, 
		D_ENDUNLESS=18, D_ISSET=19, D_ENDISSET=20, D_SWITCH=21, D_CASE=22, D_DEFAULT=23, 
		D_ENDSWITCH=24, D_EXTENDS=25, D_INCLUDE=26, D_INCLUDE_IF=27, D_INCLUDE_WHEN=28, 
		D_INCLUDE_UNLESS=29, D_EACH=30, D_INCLUDE_FIRST=31, D_YIELD=32, D_SECTION=33, 
		D_ENDSECTION=34, D_PARENT=35, D_SHOW=36, D_OVERWRITE=37, D_STOP=38, D_APPEND=39, 
		D_ONCE=40, D_ENDONCE=41, D_STACK=42, D_PUSH=43, D_ENDPUSH=44, D_PUSH_IF=45, 
		D_ENDPUSH_IF=46, D_PUSH_ONCE=47, D_ENDPUSH_ONCE=48, D_PREPEND=49, D_ENDPREPEND=50, 
		D_HAS_SECTION=51, D_SECTION_MISSING=52, D_FOREACH=53, D_ENDFOREACH=54, 
		D_FOR=55, D_ENDFOR=56, D_FORELSE=57, D_ENDFORELSE=58, D_WHILE=59, D_ENDWHILE=60, 
		D_BREAK=61, D_CONTINUE=62, D_EMPTY=63, D_ENDEMPTY=64, D_VERBATIM=65, D_ENDVERBATIM=66, 
		D_SESSION=67, D_ENDSESSION=68, D_CSRF=69, D_METHOD=70, D_ERROR=71, D_ENDERROR=72, 
		D_AUTH=73, D_ENDAUTH=74, D_GUEST=75, D_ELSEGUEST=76, D_ENDGUEST=77, D_ENV=78, 
		D_ENDENV=79, D_PRODUCTION=80, D_ENDPRODUCTION=81, D_FRAGMENT=82, D_ENDFRAGMENT=83, 
		D_SIMPLE_DIRECTIVE=84, D_LANG=85, D_INJECT=86, BLADE_CONTENT_OPEN_TAG=87, 
		BLADE_TAG_ESCAPE=88, BLADE_RAW_OPEN_TAG=89, BLADE_RAW_CLOSE_TAG=90, AT=91, 
		PHP_INLINE_START=92, WS=93, OTHER=94, BLADE_COMMENT_START=95, EMAIL_SUBSTRING=96, 
		VERSION_WITH_AT=97, D_ESCAPES=98, E_LPAREN=99, E_RPAREN=100, E_LSQUAREBRACKET=101, 
		E_RSQUAREBRACKET=102, E_LCURLYBRACE=103, E_RCURLYBRACE=104, E_OTHER=105, 
		EI_LPAREN=106, EI_RPAREN=107, EI_OTHER=108, ESPOS_LPAREN=109, ESPOS_RPAREN=110, 
		ESPOS_LSQUAREBRACKET=111, ESPOS_RSQUAREBRACKET=112, ESPOS_LCURLYBRACE=113, 
		ESPOS_RCURLYBRACE=114, ESPOS_OTHER=115, EACH_LPAREN=116, EACH_RPAREN=117, 
		EACH_LSQUAREBRACKET=118, EACH_RSQUAREBRACKET=119, EACH_LCURLYBRACE=120, 
		EACH_RCURLYBRACE=121, EACH_OTHER=122, INCF_LPAREN=123, INCF_RPAREN=124, 
		INCF_LSQUAREBRACKET=125, INCF_RSQUAREBRACKET=126, INCF_LCURLYBRACE=127, 
		INCF_RCURLYBRACE=128, INCF_OTHER=129, D_ENDPHP=130, BLADE_INLINE_PHP_OTHER=131, 
		VERBATIM_HTML=132, PHP_INLINE_EXIT=133, PHP_INLINE_OTHER=134, PHP_INLINE_EOF=135, 
		BLADE_COMMENT_END=136, BLADE_COMMENT_MORE=137, BLADE_COMMENT_EOF=138;
	public static final int
		RULE_file = 0, RULE_statement = 1, RULE_blockDirective = 2, RULE_ifStatement = 3, 
		RULE_foreachStatement = 4, RULE_forStatement = 5, RULE_forElseStatement = 6, 
		RULE_ifStartStatement = 7, RULE_elseifStatement = 8, RULE_switchStatement = 9, 
		RULE_bladePhpBlock = 10, RULE_inlineDirective = 11, RULE_identifiableArgDirective = 12, 
		RULE_multipleArgDirective = 13, RULE_blockIdentifiableArgDirective = 14, 
		RULE_directiveWithArg = 15, RULE_customDirective = 16, RULE_loopBreaks = 17, 
		RULE_formStatements = 18, RULE_authStatements = 19, RULE_bladeContentTags = 20, 
		RULE_bladeRawTags = 21, RULE_errorDirectives = 22, RULE_directiveArguments = 23, 
		RULE_phpInline = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "statement", "blockDirective", "ifStatement", "foreachStatement", 
			"forStatement", "forElseStatement", "ifStartStatement", "elseifStatement", 
			"switchStatement", "bladePhpBlock", "inlineDirective", "identifiableArgDirective", 
			"multipleArgDirective", "blockIdentifiableArgDirective", "directiveWithArg", 
			"customDirective", "loopBreaks", "formStatements", "authStatements", 
			"bladeContentTags", "bladeRawTags", "errorDirectives", "directiveArguments", 
			"phpInline"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", null, null, "'}}'", "'['", "']'", null, null, null, 
			"','", null, null, null, "'@else'", "'@endif'", null, "'@endunless'", 
			null, "'@endisset'", null, null, "'@default'", "'@endswitch'", null, 
			null, null, null, null, null, null, null, null, "'@endsection'", "'@parent'", 
			"'@show'", "'@overwrite'", "'@stop'", "'@append'", "'@once'", "'@endonce'", 
			null, null, "'@endpush'", null, "'@endPushIf'", null, "'@endPushOnce'", 
			null, "'@endprepend'", null, null, null, "'@endforeach'", null, "'@endfor'", 
			null, "'@endforelse'", null, "'@endwhile'", null, null, null, "'@endempty'", 
			"'@verbatim'", "'@endverbatim'", null, "'@endsession'", "'@csrf'", null, 
			null, "'@enderror'", null, "'@endauth'", null, "'@elseguest'", "'@endguest'", 
			null, "'@endenv'", "'@production'", "'@endproduction'", null, "'@endfragment'", 
			null, "'@lang'", null, "'{{'", null, "'{!!'", "'!!}'", "'@'", null, null, 
			null, "'{{--'", null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'@endphp'", null, null, "'?>'", null, null, "'--}}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "D_CUSTOM", "IDENTIFIABLE_STRING", "BLADE_CONTENT_CLOSE_TAG", 
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
			"D_SIMPLE_DIRECTIVE", "D_LANG", "D_INJECT", "BLADE_CONTENT_OPEN_TAG", 
			"BLADE_TAG_ESCAPE", "BLADE_RAW_OPEN_TAG", "BLADE_RAW_CLOSE_TAG", "AT", 
			"PHP_INLINE_START", "WS", "OTHER", "BLADE_COMMENT_START", "EMAIL_SUBSTRING", 
			"VERSION_WITH_AT", "D_ESCAPES", "E_LPAREN", "E_RPAREN", "E_LSQUAREBRACKET", 
			"E_RSQUAREBRACKET", "E_LCURLYBRACE", "E_RCURLYBRACE", "E_OTHER", "EI_LPAREN", 
			"EI_RPAREN", "EI_OTHER", "ESPOS_LPAREN", "ESPOS_RPAREN", "ESPOS_LSQUAREBRACKET", 
			"ESPOS_RSQUAREBRACKET", "ESPOS_LCURLYBRACE", "ESPOS_RCURLYBRACE", "ESPOS_OTHER", 
			"EACH_LPAREN", "EACH_RPAREN", "EACH_LSQUAREBRACKET", "EACH_RSQUAREBRACKET", 
			"EACH_LCURLYBRACE", "EACH_RCURLYBRACE", "EACH_OTHER", "INCF_LPAREN", 
			"INCF_RPAREN", "INCF_LSQUAREBRACKET", "INCF_RSQUAREBRACKET", "INCF_LCURLYBRACE", 
			"INCF_RCURLYBRACE", "INCF_OTHER", "D_ENDPHP", "BLADE_INLINE_PHP_OTHER", 
			"VERBATIM_HTML", "PHP_INLINE_EXIT", "PHP_INLINE_OTHER", "PHP_INLINE_EOF", 
			"BLADE_COMMENT_END", "BLADE_COMMENT_MORE", "BLADE_COMMENT_EOF"
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
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
				{
				{
				setState(50);
				statement();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
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
		public PhpInlineContext phpInline() {
			return getRuleContext(PhpInlineContext.class,0);
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
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				blockIdentifiableArgDirective();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				blockDirective();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				identifiableArgDirective();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				multipleArgDirective();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(62);
				inlineDirective();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(63);
				customDirective();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(64);
				bladeContentTags();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(65);
				bladeRawTags();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(66);
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
				setState(67);
				errorDirectives();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(68);
				phpInline();
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
		public BladePhpBlockContext bladePhpBlock() {
			return getRuleContext(BladePhpBlockContext.class,0);
		}
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
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				ifStatement();
				}
				break;
			case D_FOREACH:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				foreachStatement();
				}
				break;
			case D_FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				forStatement();
				}
				break;
			case D_FORELSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				forElseStatement();
				}
				break;
			case D_WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				match(D_WHILE);
				setState(76);
				directiveArguments();
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1532722490505550808L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					setState(79);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_CUSTOM:
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
					case D_INJECT:
					case BLADE_CONTENT_OPEN_TAG:
					case BLADE_RAW_OPEN_TAG:
					case BLADE_RAW_CLOSE_TAG:
					case PHP_INLINE_START:
						{
						setState(77);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(78);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				match(D_ENDWHILE);
				}
				break;
			case D_SWITCH:
				enterOuterAlt(_localctx, 6);
				{
				setState(86);
				switchStatement();
				}
				break;
			case D_CSRF:
			case D_METHOD:
			case D_ERROR:
				enterOuterAlt(_localctx, 7);
				{
				setState(87);
				formStatements();
				}
				break;
			case D_AUTH:
			case D_GUEST:
			case D_ENV:
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 8);
				{
				setState(88);
				authStatements();
				}
				break;
			case D_ONCE:
				enterOuterAlt(_localctx, 9);
				{
				setState(89);
				match(D_ONCE);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(90);
					directiveArguments();
					}
				}

				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(93);
					statement();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(99);
				match(D_ENDONCE);
				}
				break;
			case D_UNLESS:
				enterOuterAlt(_localctx, 10);
				{
				setState(100);
				match(D_UNLESS);
				setState(101);
				directiveArguments();
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(102);
					statement();
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(108);
				match(D_ENDUNLESS);
				}
				break;
			case D_EMPTY:
				enterOuterAlt(_localctx, 11);
				{
				setState(110);
				match(D_EMPTY);
				setState(111);
				directiveArguments();
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(112);
					statement();
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118);
				match(D_ENDEMPTY);
				}
				break;
			case D_ISSET:
				enterOuterAlt(_localctx, 12);
				{
				setState(120);
				match(D_ISSET);
				setState(121);
				directiveArguments();
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(122);
					statement();
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(128);
				match(D_ENDISSET);
				}
				break;
			case D_SESSION:
				enterOuterAlt(_localctx, 13);
				{
				setState(130);
				match(D_SESSION);
				setState(131);
				directiveArguments();
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(132);
					statement();
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(138);
				match(D_ENDSESSION);
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 14);
				{
				setState(140);
				bladePhpBlock();
				}
				break;
			case D_FRAGMENT:
				enterOuterAlt(_localctx, 15);
				{
				setState(141);
				match(D_FRAGMENT);
				setState(142);
				directiveArguments();
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(143);
					statement();
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149);
				match(D_ENDFRAGMENT);
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 16);
				{
				setState(151);
				match(D_VERBATIM);
				setState(152);
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
			setState(155);
			ifStartStatement();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1532722490505534424L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
				{
				setState(159);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case D_ELSEIF:
					{
					setState(156);
					elseifStatement();
					}
					break;
				case D_CUSTOM:
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
				case D_INJECT:
				case BLADE_CONTENT_OPEN_TAG:
				case BLADE_RAW_OPEN_TAG:
				case BLADE_RAW_CLOSE_TAG:
				case PHP_INLINE_START:
					{
					setState(157);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(158);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_ELSE) {
				{
				setState(164);
				match(D_ELSE);
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1532722490505550808L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					setState(167);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_CUSTOM:
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
					case D_INJECT:
					case BLADE_CONTENT_OPEN_TAG:
					case BLADE_RAW_OPEN_TAG:
					case BLADE_RAW_CLOSE_TAG:
					case PHP_INLINE_START:
						{
						setState(165);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(166);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(174);
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
			setState(176);
			match(D_FOREACH);
			setState(177);
			directiveArguments();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1532722490505550808L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
				{
				setState(180);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case D_CUSTOM:
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
				case D_INJECT:
				case BLADE_CONTENT_OPEN_TAG:
				case BLADE_RAW_OPEN_TAG:
				case BLADE_RAW_CLOSE_TAG:
				case PHP_INLINE_START:
					{
					setState(178);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(179);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
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
			setState(187);
			match(D_FOR);
			setState(188);
			directiveArguments();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1532722490505550808L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
				{
				setState(191);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case D_CUSTOM:
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
				case D_INJECT:
				case BLADE_CONTENT_OPEN_TAG:
				case BLADE_RAW_OPEN_TAG:
				case BLADE_RAW_CLOSE_TAG:
				case PHP_INLINE_START:
					{
					setState(189);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(190);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
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
			setState(198);
			match(D_FORELSE);
			setState(199);
			directiveArguments();
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(202);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_CUSTOM:
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
					case D_INJECT:
					case BLADE_CONTENT_OPEN_TAG:
					case BLADE_RAW_OPEN_TAG:
					case BLADE_RAW_CLOSE_TAG:
					case PHP_INLINE_START:
						{
						setState(200);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(201);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(207);
			match(D_EMPTY);
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
				{
				{
				setState(208);
				statement();
				}
				}
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(214);
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
			setState(216);
			match(D_IF);
			setState(217);
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
			setState(219);
			match(D_ELSEIF);
			setState(220);
			directiveArguments();
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(221);
					statement();
					}
					} 
				}
				setState(226);
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
			setState(227);
			match(D_SWITCH);
			setState(228);
			directiveArguments();
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==D_CASE) {
				{
				{
				setState(229);
				match(D_CASE);
				setState(230);
				directiveArguments();
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(231);
					statement();
					}
					}
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_BREAK) {
					{
					setState(237);
					match(D_BREAK);
					}
				}

				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_DEFAULT) {
				{
				setState(245);
				match(D_DEFAULT);
				setState(246);
				directiveArguments();
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(247);
					statement();
					}
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(255);
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
	public static class BladePhpBlockContext extends ParserRuleContext {
		public TerminalNode D_PHP() { return getToken(BladeAntlrParser.D_PHP, 0); }
		public TerminalNode D_ENDPHP() { return getToken(BladeAntlrParser.D_ENDPHP, 0); }
		public BladePhpBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bladePhpBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterBladePhpBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitBladePhpBlock(this);
		}
	}

	public final BladePhpBlockContext bladePhpBlock() throws RecognitionException {
		BladePhpBlockContext _localctx = new BladePhpBlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bladePhpBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(D_PHP);
			setState(258);
			match(D_ENDPHP);
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
		enterRule(_localctx, 22, RULE_inlineDirective);
		try {
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SIMPLE_DIRECTIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				match(D_SIMPLE_DIRECTIVE);
				setState(261);
				directiveArguments();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				match(D_PHP);
				setState(263);
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
		public TerminalNode D_INJECT() { return getToken(BladeAntlrParser.D_INJECT, 0); }
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
		enterRule(_localctx, 24, RULE_identifiableArgDirective);
		int _la;
		try {
			setState(332);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				match(D_SECTION);
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
				match(COMMA);
				setState(272);
				match(RPAREN);
				}
				break;
			case D_EXTENDS:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				match(D_EXTENDS);
				setState(274);
				match(LPAREN);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(275);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(278);
					match(COMMA);
					}
				}

				setState(281);
				match(RPAREN);
				}
				break;
			case D_INCLUDE:
			case D_INCLUDE_IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(282);
				_la = _input.LA(1);
				if ( !(_la==D_INCLUDE || _la==D_INCLUDE_IF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(283);
				match(LPAREN);
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(284);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(287);
					match(COMMA);
					}
				}

				setState(290);
				match(RPAREN);
				}
				break;
			case D_INCLUDE_WHEN:
			case D_INCLUDE_UNLESS:
				enterOuterAlt(_localctx, 4);
				{
				setState(291);
				_la = _input.LA(1);
				if ( !(_la==D_INCLUDE_WHEN || _la==D_INCLUDE_UNLESS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(292);
				match(LPAREN);
				setState(293);
				match(COMMA);
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
			case D_YIELD:
				enterOuterAlt(_localctx, 5);
				{
				setState(301);
				match(D_YIELD);
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

				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(306);
					match(COMMA);
					}
				}

				setState(309);
				match(RPAREN);
				}
				break;
			case D_STACK:
				enterOuterAlt(_localctx, 6);
				{
				setState(310);
				match(D_STACK);
				setState(311);
				match(LPAREN);
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(312);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(315);
				match(RPAREN);
				}
				break;
			case D_LANG:
				enterOuterAlt(_localctx, 7);
				{
				setState(316);
				match(D_LANG);
				setState(317);
				match(LPAREN);
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(318);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(321);
					match(COMMA);
					}
				}

				setState(324);
				match(RPAREN);
				}
				break;
			case D_INJECT:
				enterOuterAlt(_localctx, 8);
				{
				setState(325);
				match(D_INJECT);
				setState(326);
				match(LPAREN);
				setState(327);
				match(COMMA);
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(328);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(331);
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
		enterRule(_localctx, 26, RULE_multipleArgDirective);
		int _la;
		try {
			setState(360);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EACH:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				match(D_EACH);
				setState(335);
				match(LPAREN);
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(336);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(339);
				match(COMMA);
				setState(340);
				match(COMMA);
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(341);
					match(COMMA);
					setState(343);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIABLE_STRING) {
						{
						setState(342);
						match(IDENTIFIABLE_STRING);
						}
					}

					}
				}

				setState(347);
				match(RPAREN);
				}
				break;
			case D_INCLUDE_FIRST:
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				match(D_INCLUDE_FIRST);
				setState(349);
				match(LPAREN);
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIABLE_STRING) {
					{
					{
					setState(350);
					match(IDENTIFIABLE_STRING);
					}
					}
					setState(355);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(356);
					match(COMMA);
					}
				}

				setState(359);
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
		enterRule(_localctx, 28, RULE_blockIdentifiableArgDirective);
		int _la;
		try {
			setState(457);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(362);
				match(D_SECTION);
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
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_PARENT) {
					{
					setState(368);
					match(D_PARENT);
					}
				}

				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(371);
					statement();
					}
					}
					setState(376);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(377);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1047972020224L) != 0)) ) {
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
				setState(378);
				match(D_HAS_SECTION);
				setState(379);
				match(LPAREN);
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(380);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(383);
				match(RPAREN);
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(384);
					statement();
					}
					}
					setState(389);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(390);
				match(D_ENDIF);
				}
				break;
			case D_SECTION_MISSING:
				enterOuterAlt(_localctx, 3);
				{
				setState(391);
				match(D_SECTION_MISSING);
				setState(392);
				match(LPAREN);
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(393);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(396);
				match(RPAREN);
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(397);
					statement();
					}
					}
					setState(402);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(403);
				match(D_ENDIF);
				}
				break;
			case D_PUSH:
				enterOuterAlt(_localctx, 4);
				{
				setState(404);
				match(D_PUSH);
				setState(405);
				match(LPAREN);
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(406);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(409);
				match(RPAREN);
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(410);
					statement();
					}
					}
					setState(415);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(416);
				match(D_ENDPUSH);
				}
				break;
			case D_PUSH_IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(417);
				match(D_PUSH_IF);
				setState(418);
				match(LPAREN);
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(419);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(422);
				match(COMMA);
				setState(423);
				match(RPAREN);
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(424);
					statement();
					}
					}
					setState(429);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(430);
				match(D_ENDPUSH_IF);
				}
				break;
			case D_PUSH_ONCE:
				enterOuterAlt(_localctx, 6);
				{
				setState(431);
				match(D_PUSH_ONCE);
				setState(432);
				match(LPAREN);
				setState(434);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(433);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(436);
				match(RPAREN);
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(437);
					statement();
					}
					}
					setState(442);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(443);
				match(D_ENDPUSH_ONCE);
				}
				break;
			case D_PREPEND:
				enterOuterAlt(_localctx, 7);
				{
				setState(444);
				match(D_PREPEND);
				setState(445);
				match(LPAREN);
				setState(447);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(446);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(449);
				match(RPAREN);
				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(450);
					statement();
					}
					}
					setState(455);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(456);
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
		enterRule(_localctx, 30, RULE_directiveWithArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4395630592L) != 0)) ) {
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
		enterRule(_localctx, 32, RULE_customDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			match(D_CUSTOM);
			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(462);
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
		enterRule(_localctx, 34, RULE_loopBreaks);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			_la = _input.LA(1);
			if ( !(_la==D_BREAK || _la==D_CONTINUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(466);
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
		enterRule(_localctx, 36, RULE_formStatements);
		int _la;
		try {
			setState(494);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_ERROR:
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				match(D_ERROR);
				setState(470);
				match(LPAREN);
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
				setState(478);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(475);
					statement();
					}
					}
					setState(480);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(481);
					match(D_ELSE);
					setState(485);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
						{
						{
						setState(482);
						statement();
						}
						}
						setState(487);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(490);
				match(D_ENDERROR);
				}
				break;
			case D_CSRF:
				enterOuterAlt(_localctx, 2);
				{
				setState(491);
				match(D_CSRF);
				}
				break;
			case D_METHOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(492);
				match(D_METHOD);
				setState(493);
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
		enterRule(_localctx, 38, RULE_authStatements);
		int _la;
		try {
			setState(545);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_AUTH:
				enterOuterAlt(_localctx, 1);
				{
				setState(496);
				match(D_AUTH);
				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(497);
					directiveArguments();
					}
				}

				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(500);
					statement();
					}
					}
					setState(505);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE || _la==D_ELSEGUEST) {
					{
					setState(506);
					_la = _input.LA(1);
					if ( !(_la==D_ELSE || _la==D_ELSEGUEST) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(510);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
						{
						{
						setState(507);
						statement();
						}
						}
						setState(512);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(515);
				match(D_ENDAUTH);
				}
				break;
			case D_GUEST:
				enterOuterAlt(_localctx, 2);
				{
				setState(516);
				match(D_GUEST);
				setState(518);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(517);
					directiveArguments();
					}
				}

				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(520);
					statement();
					}
					}
					setState(525);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(526);
				match(D_ENDGUEST);
				}
				break;
			case D_ENV:
				enterOuterAlt(_localctx, 3);
				{
				setState(527);
				match(D_ENV);
				setState(528);
				directiveArguments();
				setState(532);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(529);
					statement();
					}
					}
					setState(534);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(535);
				match(D_ENDENV);
				}
				break;
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(537);
				match(D_PRODUCTION);
				setState(541);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8450251518146632664L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 192587125L) != 0)) {
					{
					{
					setState(538);
					statement();
					}
					}
					setState(543);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(544);
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
		enterRule(_localctx, 40, RULE_bladeContentTags);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			match(BLADE_CONTENT_OPEN_TAG);
			setState(548);
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
		enterRule(_localctx, 42, RULE_bladeRawTags);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(BLADE_RAW_OPEN_TAG);
			setState(551);
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
		enterRule(_localctx, 44, RULE_errorDirectives);
		int _la;
		try {
			setState(574);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EXTENDS:
			case D_INCLUDE:
			case D_YIELD:
				enterOuterAlt(_localctx, 1);
				{
				setState(553);
				directiveWithArg();
				setState(554);
				match(LPAREN);
				notifyErrorListeners("Missing closing ')'");
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(557);
				match(D_IF);
				setState(558);
				directiveArguments();
				notifyErrorListeners("Syntax error, expecting @elseif or @else or @endif");
				}
				break;
			case D_FOREACH:
			case D_FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(561);
				_la = _input.LA(1);
				if ( !(_la==D_FOREACH || _la==D_FOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(562);
				directiveArguments();
				notifyErrorListeners("Unclosed block directive");
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 4);
				{
				setState(565);
				match(D_VERBATIM);
				notifyErrorListeners("Unclosed verbatim block");
				}
				break;
			case D_SECTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(567);
				match(D_SECTION);
				setState(568);
				match(LPAREN);
				setState(570);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(569);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(572);
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
		enterRule(_localctx, 46, RULE_directiveArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			match(LPAREN);
			setState(577);
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
	public static class PhpInlineContext extends ParserRuleContext {
		public Token phpInlineEnd;
		public TerminalNode PHP_INLINE_START() { return getToken(BladeAntlrParser.PHP_INLINE_START, 0); }
		public TerminalNode PHP_INLINE_EXIT() { return getToken(BladeAntlrParser.PHP_INLINE_EXIT, 0); }
		public TerminalNode PHP_INLINE_EOF() { return getToken(BladeAntlrParser.PHP_INLINE_EOF, 0); }
		public PhpInlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phpInline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPhpInline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPhpInline(this);
		}
	}

	public final PhpInlineContext phpInline() throws RecognitionException {
		PhpInlineContext _localctx = new PhpInlineContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_phpInline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			match(PHP_INLINE_START);
			setState(580);
			((PhpInlineContext)_localctx).phpInlineEnd = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PHP_INLINE_EXIT || _la==PHP_INLINE_EOF) ) {
				((PhpInlineContext)_localctx).phpInlineEnd = (Token)_errHandler.recoverInline(this);
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

	public static final String _serializedATN =
		"\u0004\u0001\u008a\u0247\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0001\u0000\u0005\u00004\b\u0000\n\u0000\f\u00007\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001F\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002P\b"+
		"\u0002\n\u0002\f\u0002S\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\\\b\u0002\u0001"+
		"\u0002\u0005\u0002_\b\u0002\n\u0002\f\u0002b\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002h\b\u0002\n\u0002\f\u0002k\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002r\b\u0002\n\u0002\f\u0002u\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002|\b\u0002\n\u0002\f\u0002\u007f"+
		"\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002\u0086\b\u0002\n\u0002\f\u0002\u0089\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0091\b\u0002"+
		"\n\u0002\f\u0002\u0094\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002\u009a\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003\u00a0\b\u0003\n\u0003\f\u0003\u00a3\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003\u00a8\b\u0003\n\u0003\f\u0003\u00ab"+
		"\t\u0003\u0003\u0003\u00ad\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00b5\b\u0004\n\u0004"+
		"\f\u0004\u00b8\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u00c0\b\u0005\n\u0005\f\u0005\u00c3"+
		"\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006\u00cb\b\u0006\n\u0006\f\u0006\u00ce\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u00d2\b\u0006\n\u0006\f\u0006\u00d5\t\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0005\b\u00df\b\b\n\b\f\b\u00e2\t\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u00e9\b\t\n\t\f\t\u00ec\t\t\u0001\t\u0003\t\u00ef\b"+
		"\t\u0005\t\u00f1\b\t\n\t\f\t\u00f4\t\t\u0001\t\u0001\t\u0001\t\u0005\t"+
		"\u00f9\b\t\n\t\f\t\u00fc\t\t\u0003\t\u00fe\b\t\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u0109\b\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u010e\b\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0115\b\f\u0001\f\u0003\f\u0118"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u011e\b\f\u0001\f\u0003\f"+
		"\u0121\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0128\b\f\u0001"+
		"\f\u0003\f\u012b\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0131\b\f"+
		"\u0001\f\u0003\f\u0134\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u013a"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0140\b\f\u0001\f\u0003\f"+
		"\u0143\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u014a\b\f\u0001"+
		"\f\u0003\f\u014d\b\f\u0001\r\u0001\r\u0001\r\u0003\r\u0152\b\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u0158\b\r\u0003\r\u015a\b\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u0160\b\r\n\r\f\r\u0163\t\r\u0001\r\u0003\r"+
		"\u0166\b\r\u0001\r\u0003\r\u0169\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u016e\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0172\b"+
		"\u000e\u0001\u000e\u0005\u000e\u0175\b\u000e\n\u000e\f\u000e\u0178\t\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u017e\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u0182\b\u000e\n\u000e\f\u000e\u0185"+
		"\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u018b"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u018f\b\u000e\n\u000e\f\u000e"+
		"\u0192\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u0198\b\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u019c\b\u000e\n\u000e"+
		"\f\u000e\u019f\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u01a5\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u01aa\b\u000e\n\u000e\f\u000e\u01ad\t\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u01b3\b\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u01b7\b\u000e\n\u000e\f\u000e\u01ba\t\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u01c0\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u01c4\b\u000e\n\u000e\f\u000e\u01c7\t\u000e\u0001\u000e\u0003"+
		"\u000e\u01ca\b\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u01d0\b\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u01d4\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u01d9\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u01dd\b\u0012\n\u0012\f\u0012\u01e0\t\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u01e4\b\u0012\n\u0012\f\u0012\u01e7\t\u0012"+
		"\u0003\u0012\u01e9\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u01ef\b\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u01f3\b"+
		"\u0013\u0001\u0013\u0005\u0013\u01f6\b\u0013\n\u0013\f\u0013\u01f9\t\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u01fd\b\u0013\n\u0013\f\u0013\u0200"+
		"\t\u0013\u0003\u0013\u0202\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u0207\b\u0013\u0001\u0013\u0005\u0013\u020a\b\u0013\n\u0013"+
		"\f\u0013\u020d\t\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u0213\b\u0013\n\u0013\f\u0013\u0216\t\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u021c\b\u0013\n\u0013\f\u0013"+
		"\u021f\t\u0013\u0001\u0013\u0003\u0013\u0222\b\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u023b\b\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u023f\b\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0000\u0000\u0019"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.0\u0000\t\u0002\u0000\u0005\u0005ZZ\u0001\u0000\u001a"+
		"\u001b\u0001\u0000\u001c\u001d\u0002\u0000\"\"$\'\u0002\u0000\u0019\u001a"+
		"  \u0001\u0000=>\u0002\u0000\u000f\u000fLL\u0002\u00005577\u0002\u0000"+
		"\u0085\u0085\u0087\u0087\u02ab\u00005\u0001\u0000\u0000\u0000\u0002E\u0001"+
		"\u0000\u0000\u0000\u0004\u0099\u0001\u0000\u0000\u0000\u0006\u009b\u0001"+
		"\u0000\u0000\u0000\b\u00b0\u0001\u0000\u0000\u0000\n\u00bb\u0001\u0000"+
		"\u0000\u0000\f\u00c6\u0001\u0000\u0000\u0000\u000e\u00d8\u0001\u0000\u0000"+
		"\u0000\u0010\u00db\u0001\u0000\u0000\u0000\u0012\u00e3\u0001\u0000\u0000"+
		"\u0000\u0014\u0101\u0001\u0000\u0000\u0000\u0016\u0108\u0001\u0000\u0000"+
		"\u0000\u0018\u014c\u0001\u0000\u0000\u0000\u001a\u0168\u0001\u0000\u0000"+
		"\u0000\u001c\u01c9\u0001\u0000\u0000\u0000\u001e\u01cb\u0001\u0000\u0000"+
		"\u0000 \u01cd\u0001\u0000\u0000\u0000\"\u01d1\u0001\u0000\u0000\u0000"+
		"$\u01ee\u0001\u0000\u0000\u0000&\u0221\u0001\u0000\u0000\u0000(\u0223"+
		"\u0001\u0000\u0000\u0000*\u0226\u0001\u0000\u0000\u0000,\u023e\u0001\u0000"+
		"\u0000\u0000.\u0240\u0001\u0000\u0000\u00000\u0243\u0001\u0000\u0000\u0000"+
		"24\u0003\u0002\u0001\u000032\u0001\u0000\u0000\u000047\u0001\u0000\u0000"+
		"\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000068\u0001\u0000"+
		"\u0000\u000075\u0001\u0000\u0000\u000089\u0005\u0000\u0000\u00019\u0001"+
		"\u0001\u0000\u0000\u0000:F\u0003\u001c\u000e\u0000;F\u0003\u0004\u0002"+
		"\u0000<F\u0003\u0018\f\u0000=F\u0003\u001a\r\u0000>F\u0003\u0016\u000b"+
		"\u0000?F\u0003 \u0010\u0000@F\u0003(\u0014\u0000AF\u0003*\u0015\u0000"+
		"BF\u0007\u0000\u0000\u0000CF\u0003,\u0016\u0000DF\u00030\u0018\u0000E"+
		":\u0001\u0000\u0000\u0000E;\u0001\u0000\u0000\u0000E<\u0001\u0000\u0000"+
		"\u0000E=\u0001\u0000\u0000\u0000E>\u0001\u0000\u0000\u0000E?\u0001\u0000"+
		"\u0000\u0000E@\u0001\u0000\u0000\u0000EA\u0001\u0000\u0000\u0000EB\u0001"+
		"\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000"+
		"F\u0003\u0001\u0000\u0000\u0000G\u009a\u0003\u0006\u0003\u0000H\u009a"+
		"\u0003\b\u0004\u0000I\u009a\u0003\n\u0005\u0000J\u009a\u0003\f\u0006\u0000"+
		"KL\u0005;\u0000\u0000LQ\u0003.\u0017\u0000MP\u0003\u0002\u0001\u0000N"+
		"P\u0003\"\u0011\u0000OM\u0001\u0000\u0000\u0000ON\u0001\u0000\u0000\u0000"+
		"PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000RT\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000TU\u0005<\u0000"+
		"\u0000U\u009a\u0001\u0000\u0000\u0000V\u009a\u0003\u0012\t\u0000W\u009a"+
		"\u0003$\u0012\u0000X\u009a\u0003&\u0013\u0000Y[\u0005(\u0000\u0000Z\\"+
		"\u0003.\u0017\u0000[Z\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\`\u0001\u0000\u0000\u0000]_\u0003\u0002\u0001\u0000^]\u0001\u0000\u0000"+
		"\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000"+
		"\u0000\u0000ac\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000c\u009a"+
		"\u0005)\u0000\u0000de\u0005\u0011\u0000\u0000ei\u0003.\u0017\u0000fh\u0003"+
		"\u0002\u0001\u0000gf\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000"+
		"ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000lm\u0005\u0012\u0000\u0000m\u009a\u0001"+
		"\u0000\u0000\u0000no\u0005?\u0000\u0000os\u0003.\u0017\u0000pr\u0003\u0002"+
		"\u0001\u0000qp\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000vw\u0005@\u0000\u0000w\u009a\u0001\u0000\u0000"+
		"\u0000xy\u0005\u0013\u0000\u0000y}\u0003.\u0017\u0000z|\u0003\u0002\u0001"+
		"\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001"+
		"\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0001\u0000\u0000"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u0014\u0000\u0000"+
		"\u0081\u009a\u0001\u0000\u0000\u0000\u0082\u0083\u0005C\u0000\u0000\u0083"+
		"\u0087\u0003.\u0017\u0000\u0084\u0086\u0003\u0002\u0001\u0000\u0085\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008a"+
		"\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0005D\u0000\u0000\u008b\u009a\u0001\u0000\u0000\u0000\u008c\u009a\u0003"+
		"\u0014\n\u0000\u008d\u008e\u0005R\u0000\u0000\u008e\u0092\u0003.\u0017"+
		"\u0000\u008f\u0091\u0003\u0002\u0001\u0000\u0090\u008f\u0001\u0000\u0000"+
		"\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0095\u0001\u0000\u0000"+
		"\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0096\u0005S\u0000\u0000"+
		"\u0096\u009a\u0001\u0000\u0000\u0000\u0097\u0098\u0005A\u0000\u0000\u0098"+
		"\u009a\u0005B\u0000\u0000\u0099G\u0001\u0000\u0000\u0000\u0099H\u0001"+
		"\u0000\u0000\u0000\u0099I\u0001\u0000\u0000\u0000\u0099J\u0001\u0000\u0000"+
		"\u0000\u0099K\u0001\u0000\u0000\u0000\u0099V\u0001\u0000\u0000\u0000\u0099"+
		"W\u0001\u0000\u0000\u0000\u0099X\u0001\u0000\u0000\u0000\u0099Y\u0001"+
		"\u0000\u0000\u0000\u0099d\u0001\u0000\u0000\u0000\u0099n\u0001\u0000\u0000"+
		"\u0000\u0099x\u0001\u0000\u0000\u0000\u0099\u0082\u0001\u0000\u0000\u0000"+
		"\u0099\u008c\u0001\u0000\u0000\u0000\u0099\u008d\u0001\u0000\u0000\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u0005\u0001\u0000\u0000\u0000"+
		"\u009b\u00a1\u0003\u000e\u0007\u0000\u009c\u00a0\u0003\u0010\b\u0000\u009d"+
		"\u00a0\u0003\u0002\u0001\u0000\u009e\u00a0\u0003\"\u0011\u0000\u009f\u009c"+
		"\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u009e"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00ac"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a9"+
		"\u0005\u000f\u0000\u0000\u00a5\u00a8\u0003\u0002\u0001\u0000\u00a6\u00a8"+
		"\u0003\"\u0011\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ad\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00a4\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0005\u0010\u0000\u0000\u00af\u0007\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u00055\u0000\u0000\u00b1\u00b6\u0003.\u0017"+
		"\u0000\u00b2\u00b5\u0003\u0002\u0001\u0000\u00b3\u00b5\u0003\"\u0011\u0000"+
		"\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00ba\u00056\u0000\u0000\u00ba"+
		"\t\u0001\u0000\u0000\u0000\u00bb\u00bc\u00057\u0000\u0000\u00bc\u00c1"+
		"\u0003.\u0017\u0000\u00bd\u00c0\u0003\u0002\u0001\u0000\u00be\u00c0\u0003"+
		"\"\u0011\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00be\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c5\u00058\u0000"+
		"\u0000\u00c5\u000b\u0001\u0000\u0000\u0000\u00c6\u00c7\u00059\u0000\u0000"+
		"\u00c7\u00cc\u0003.\u0017\u0000\u00c8\u00cb\u0003\u0002\u0001\u0000\u00c9"+
		"\u00cb\u0003\"\u0011\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00c9"+
		"\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca"+
		"\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cf"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d3"+
		"\u0005?\u0000\u0000\u00d0\u00d2\u0003\u0002\u0001\u0000\u00d1\u00d0\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005"+
		":\u0000\u0000\u00d7\r\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\r\u0000"+
		"\u0000\u00d9\u00da\u0003.\u0017\u0000\u00da\u000f\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0005\u000e\u0000\u0000\u00dc\u00e0\u0003.\u0017\u0000\u00dd"+
		"\u00df\u0003\u0002\u0001\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e1\u0011\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005\u0015\u0000\u0000\u00e4"+
		"\u00f2\u0003.\u0017\u0000\u00e5\u00e6\u0005\u0016\u0000\u0000\u00e6\u00ea"+
		"\u0003.\u0017\u0000\u00e7\u00e9\u0003\u0002\u0001\u0000\u00e8\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ec\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001"+
		"\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ed\u00ef\u0005"+
		"=\u0000\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f1\u0001\u0000\u0000\u0000\u00f0\u00e5\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00fd\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\u0017"+
		"\u0000\u0000\u00f6\u00fa\u0003.\u0017\u0000\u00f7\u00f9\u0003\u0002\u0001"+
		"\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fc\u0001\u0000\u0000"+
		"\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000"+
		"\u0000\u00fd\u00f5\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000"+
		"\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0100\u0005\u0018\u0000"+
		"\u0000\u0100\u0013\u0001\u0000\u0000\u0000\u0101\u0102\u0005\n\u0000\u0000"+
		"\u0102\u0103\u0005\u0082\u0000\u0000\u0103\u0015\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0005T\u0000\u0000\u0105\u0109\u0003.\u0017\u0000\u0106\u0107"+
		"\u0005\n\u0000\u0000\u0107\u0109\u0003.\u0017\u0000\u0108\u0104\u0001"+
		"\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0109\u0017\u0001"+
		"\u0000\u0000\u0000\u010a\u010b\u0005!\u0000\u0000\u010b\u010d\u0005\u0001"+
		"\u0000\u0000\u010c\u010e\u0005\u0004\u0000\u0000\u010d\u010c\u0001\u0000"+
		"\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000"+
		"\u0000\u0000\u010f\u0110\u0005\u000b\u0000\u0000\u0110\u014d\u0005\u0002"+
		"\u0000\u0000\u0111\u0112\u0005\u0019\u0000\u0000\u0112\u0114\u0005\u0001"+
		"\u0000\u0000\u0113\u0115\u0005\u0004\u0000\u0000\u0114\u0113\u0001\u0000"+
		"\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0117\u0001\u0000"+
		"\u0000\u0000\u0116\u0118\u0005\u000b\u0000\u0000\u0117\u0116\u0001\u0000"+
		"\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000"+
		"\u0000\u0000\u0119\u014d\u0005\u0002\u0000\u0000\u011a\u011b\u0007\u0001"+
		"\u0000\u0000\u011b\u011d\u0005\u0001\u0000\u0000\u011c\u011e\u0005\u0004"+
		"\u0000\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000"+
		"\u0000\u0000\u011e\u0120\u0001\u0000\u0000\u0000\u011f\u0121\u0005\u000b"+
		"\u0000\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000"+
		"\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122\u014d\u0005\u0002"+
		"\u0000\u0000\u0123\u0124\u0007\u0002\u0000\u0000\u0124\u0125\u0005\u0001"+
		"\u0000\u0000\u0125\u0127\u0005\u000b\u0000\u0000\u0126\u0128\u0005\u0004"+
		"\u0000\u0000\u0127\u0126\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000"+
		"\u0000\u0000\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u012b\u0005\u000b"+
		"\u0000\u0000\u012a\u0129\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000"+
		"\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u014d\u0005\u0002"+
		"\u0000\u0000\u012d\u012e\u0005 \u0000\u0000\u012e\u0130\u0005\u0001\u0000"+
		"\u0000\u012f\u0131\u0005\u0004\u0000\u0000\u0130\u012f\u0001\u0000\u0000"+
		"\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0133\u0001\u0000\u0000"+
		"\u0000\u0132\u0134\u0005\u000b\u0000\u0000\u0133\u0132\u0001\u0000\u0000"+
		"\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000"+
		"\u0000\u0135\u014d\u0005\u0002\u0000\u0000\u0136\u0137\u0005*\u0000\u0000"+
		"\u0137\u0139\u0005\u0001\u0000\u0000\u0138\u013a\u0005\u0004\u0000\u0000"+
		"\u0139\u0138\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000"+
		"\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u014d\u0005\u0002\u0000\u0000"+
		"\u013c\u013d\u0005U\u0000\u0000\u013d\u013f\u0005\u0001\u0000\u0000\u013e"+
		"\u0140\u0005\u0004\u0000\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u013f"+
		"\u0140\u0001\u0000\u0000\u0000\u0140\u0142\u0001\u0000\u0000\u0000\u0141"+
		"\u0143\u0005\u000b\u0000\u0000\u0142\u0141\u0001\u0000\u0000\u0000\u0142"+
		"\u0143\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144"+
		"\u014d\u0005\u0002\u0000\u0000\u0145\u0146\u0005V\u0000\u0000\u0146\u0147"+
		"\u0005\u0001\u0000\u0000\u0147\u0149\u0005\u000b\u0000\u0000\u0148\u014a"+
		"\u0005\u0004\u0000\u0000\u0149\u0148\u0001\u0000\u0000\u0000\u0149\u014a"+
		"\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b\u014d"+
		"\u0005\u0002\u0000\u0000\u014c\u010a\u0001\u0000\u0000\u0000\u014c\u0111"+
		"\u0001\u0000\u0000\u0000\u014c\u011a\u0001\u0000\u0000\u0000\u014c\u0123"+
		"\u0001\u0000\u0000\u0000\u014c\u012d\u0001\u0000\u0000\u0000\u014c\u0136"+
		"\u0001\u0000\u0000\u0000\u014c\u013c\u0001\u0000\u0000\u0000\u014c\u0145"+
		"\u0001\u0000\u0000\u0000\u014d\u0019\u0001\u0000\u0000\u0000\u014e\u014f"+
		"\u0005\u001e\u0000\u0000\u014f\u0151\u0005\u0001\u0000\u0000\u0150\u0152"+
		"\u0005\u0004\u0000\u0000\u0151\u0150\u0001\u0000\u0000\u0000\u0151\u0152"+
		"\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u0154"+
		"\u0005\u000b\u0000\u0000\u0154\u0159\u0005\u000b\u0000\u0000\u0155\u0157"+
		"\u0005\u000b\u0000\u0000\u0156\u0158\u0005\u0004\u0000\u0000\u0157\u0156"+
		"\u0001\u0000\u0000\u0000\u0157\u0158\u0001\u0000\u0000\u0000\u0158\u015a"+
		"\u0001\u0000\u0000\u0000\u0159\u0155\u0001\u0000\u0000\u0000\u0159\u015a"+
		"\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u0169"+
		"\u0005\u0002\u0000\u0000\u015c\u015d\u0005\u001f\u0000\u0000\u015d\u0161"+
		"\u0005\u0001\u0000\u0000\u015e\u0160\u0005\u0004\u0000\u0000\u015f\u015e"+
		"\u0001\u0000\u0000\u0000\u0160\u0163\u0001\u0000\u0000\u0000\u0161\u015f"+
		"\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162\u0165"+
		"\u0001\u0000\u0000\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0164\u0166"+
		"\u0005\u000b\u0000\u0000\u0165\u0164\u0001\u0000\u0000\u0000\u0165\u0166"+
		"\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u0169"+
		"\u0005\u0002\u0000\u0000\u0168\u014e\u0001\u0000\u0000\u0000\u0168\u015c"+
		"\u0001\u0000\u0000\u0000\u0169\u001b\u0001\u0000\u0000\u0000\u016a\u016b"+
		"\u0005!\u0000\u0000\u016b\u016d\u0005\u0001\u0000\u0000\u016c\u016e\u0005"+
		"\u0004\u0000\u0000\u016d\u016c\u0001\u0000\u0000\u0000\u016d\u016e\u0001"+
		"\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u0171\u0005"+
		"\u0002\u0000\u0000\u0170\u0172\u0005#\u0000\u0000\u0171\u0170\u0001\u0000"+
		"\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0176\u0001\u0000"+
		"\u0000\u0000\u0173\u0175\u0003\u0002\u0001\u0000\u0174\u0173\u0001\u0000"+
		"\u0000\u0000\u0175\u0178\u0001\u0000\u0000\u0000\u0176\u0174\u0001\u0000"+
		"\u0000\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0179\u0001\u0000"+
		"\u0000\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0179\u01ca\u0007\u0003"+
		"\u0000\u0000\u017a\u017b\u00053\u0000\u0000\u017b\u017d\u0005\u0001\u0000"+
		"\u0000\u017c\u017e\u0005\u0004\u0000\u0000\u017d\u017c\u0001\u0000\u0000"+
		"\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000"+
		"\u0000\u017f\u0183\u0005\u0002\u0000\u0000\u0180\u0182\u0003\u0002\u0001"+
		"\u0000\u0181\u0180\u0001\u0000\u0000\u0000\u0182\u0185\u0001\u0000\u0000"+
		"\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000"+
		"\u0000\u0184\u0186\u0001\u0000\u0000\u0000\u0185\u0183\u0001\u0000\u0000"+
		"\u0000\u0186\u01ca\u0005\u0010\u0000\u0000\u0187\u0188\u00054\u0000\u0000"+
		"\u0188\u018a\u0005\u0001\u0000\u0000\u0189\u018b\u0005\u0004\u0000\u0000"+
		"\u018a\u0189\u0001\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000\u0000"+
		"\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u0190\u0005\u0002\u0000\u0000"+
		"\u018d\u018f\u0003\u0002\u0001\u0000\u018e\u018d\u0001\u0000\u0000\u0000"+
		"\u018f\u0192\u0001\u0000\u0000\u0000\u0190\u018e\u0001\u0000\u0000\u0000"+
		"\u0190\u0191\u0001\u0000\u0000\u0000\u0191\u0193\u0001\u0000\u0000\u0000"+
		"\u0192\u0190\u0001\u0000\u0000\u0000\u0193\u01ca\u0005\u0010\u0000\u0000"+
		"\u0194\u0195\u0005+\u0000\u0000\u0195\u0197\u0005\u0001\u0000\u0000\u0196"+
		"\u0198\u0005\u0004\u0000\u0000\u0197\u0196\u0001\u0000\u0000\u0000\u0197"+
		"\u0198\u0001\u0000\u0000\u0000\u0198\u0199\u0001\u0000\u0000\u0000\u0199"+
		"\u019d\u0005\u0002\u0000\u0000\u019a\u019c\u0003\u0002\u0001\u0000\u019b"+
		"\u019a\u0001\u0000\u0000\u0000\u019c\u019f\u0001\u0000\u0000\u0000\u019d"+
		"\u019b\u0001\u0000\u0000\u0000\u019d\u019e\u0001\u0000\u0000\u0000\u019e"+
		"\u01a0\u0001\u0000\u0000\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u01a0"+
		"\u01ca\u0005,\u0000\u0000\u01a1\u01a2\u0005-\u0000\u0000\u01a2\u01a4\u0005"+
		"\u0001\u0000\u0000\u01a3\u01a5\u0005\u0004\u0000\u0000\u01a4\u01a3\u0001"+
		"\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000\u01a5\u01a6\u0001"+
		"\u0000\u0000\u0000\u01a6\u01a7\u0005\u000b\u0000\u0000\u01a7\u01ab\u0005"+
		"\u0002\u0000\u0000\u01a8\u01aa\u0003\u0002\u0001\u0000\u01a9\u01a8\u0001"+
		"\u0000\u0000\u0000\u01aa\u01ad\u0001\u0000\u0000\u0000\u01ab\u01a9\u0001"+
		"\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000\u0000\u01ac\u01ae\u0001"+
		"\u0000\u0000\u0000\u01ad\u01ab\u0001\u0000\u0000\u0000\u01ae\u01ca\u0005"+
		".\u0000\u0000\u01af\u01b0\u0005/\u0000\u0000\u01b0\u01b2\u0005\u0001\u0000"+
		"\u0000\u01b1\u01b3\u0005\u0004\u0000\u0000\u01b2\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3\u01b4\u0001\u0000\u0000"+
		"\u0000\u01b4\u01b8\u0005\u0002\u0000\u0000\u01b5\u01b7\u0003\u0002\u0001"+
		"\u0000\u01b6\u01b5\u0001\u0000\u0000\u0000\u01b7\u01ba\u0001\u0000\u0000"+
		"\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000\u01b8\u01b9\u0001\u0000\u0000"+
		"\u0000\u01b9\u01bb\u0001\u0000\u0000\u0000\u01ba\u01b8\u0001\u0000\u0000"+
		"\u0000\u01bb\u01ca\u00050\u0000\u0000\u01bc\u01bd\u00051\u0000\u0000\u01bd"+
		"\u01bf\u0005\u0001\u0000\u0000\u01be\u01c0\u0005\u0004\u0000\u0000\u01bf"+
		"\u01be\u0001\u0000\u0000\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c0"+
		"\u01c1\u0001\u0000\u0000\u0000\u01c1\u01c5\u0005\u0002\u0000\u0000\u01c2"+
		"\u01c4\u0003\u0002\u0001\u0000\u01c3\u01c2\u0001\u0000\u0000\u0000\u01c4"+
		"\u01c7\u0001\u0000\u0000\u0000\u01c5\u01c3\u0001\u0000\u0000\u0000\u01c5"+
		"\u01c6\u0001\u0000\u0000\u0000\u01c6\u01c8\u0001\u0000\u0000\u0000\u01c7"+
		"\u01c5\u0001\u0000\u0000\u0000\u01c8\u01ca\u00052\u0000\u0000\u01c9\u016a"+
		"\u0001\u0000\u0000\u0000\u01c9\u017a\u0001\u0000\u0000\u0000\u01c9\u0187"+
		"\u0001\u0000\u0000\u0000\u01c9\u0194\u0001\u0000\u0000\u0000\u01c9\u01a1"+
		"\u0001\u0000\u0000\u0000\u01c9\u01af\u0001\u0000\u0000\u0000\u01c9\u01bc"+
		"\u0001\u0000\u0000\u0000\u01ca\u001d\u0001\u0000\u0000\u0000\u01cb\u01cc"+
		"\u0007\u0004\u0000\u0000\u01cc\u001f\u0001\u0000\u0000\u0000\u01cd\u01cf"+
		"\u0005\u0003\u0000\u0000\u01ce\u01d0\u0003.\u0017\u0000\u01cf\u01ce\u0001"+
		"\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0!\u0001\u0000"+
		"\u0000\u0000\u01d1\u01d3\u0007\u0005\u0000\u0000\u01d2\u01d4\u0003.\u0017"+
		"\u0000\u01d3\u01d2\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000"+
		"\u0000\u01d4#\u0001\u0000\u0000\u0000\u01d5\u01d6\u0005G\u0000\u0000\u01d6"+
		"\u01d8\u0005\u0001\u0000\u0000\u01d7\u01d9\u0005\u000b\u0000\u0000\u01d8"+
		"\u01d7\u0001\u0000\u0000\u0000\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9"+
		"\u01da\u0001\u0000\u0000\u0000\u01da\u01de\u0005\u0002\u0000\u0000\u01db"+
		"\u01dd\u0003\u0002\u0001\u0000\u01dc\u01db\u0001\u0000\u0000\u0000\u01dd"+
		"\u01e0\u0001\u0000\u0000\u0000\u01de\u01dc\u0001\u0000\u0000\u0000\u01de"+
		"\u01df\u0001\u0000\u0000\u0000\u01df\u01e8\u0001\u0000\u0000\u0000\u01e0"+
		"\u01de\u0001\u0000\u0000\u0000\u01e1\u01e5\u0005\u000f\u0000\u0000\u01e2"+
		"\u01e4\u0003\u0002\u0001\u0000\u01e3\u01e2\u0001\u0000\u0000\u0000\u01e4"+
		"\u01e7\u0001\u0000\u0000\u0000\u01e5\u01e3\u0001\u0000\u0000\u0000\u01e5"+
		"\u01e6\u0001\u0000\u0000\u0000\u01e6\u01e9\u0001\u0000\u0000\u0000\u01e7"+
		"\u01e5\u0001\u0000\u0000\u0000\u01e8\u01e1\u0001\u0000\u0000\u0000\u01e8"+
		"\u01e9\u0001\u0000\u0000\u0000\u01e9\u01ea\u0001\u0000\u0000\u0000\u01ea"+
		"\u01ef\u0005H\u0000\u0000\u01eb\u01ef\u0005E\u0000\u0000\u01ec\u01ed\u0005"+
		"F\u0000\u0000\u01ed\u01ef\u0003.\u0017\u0000\u01ee\u01d5\u0001\u0000\u0000"+
		"\u0000\u01ee\u01eb\u0001\u0000\u0000\u0000\u01ee\u01ec\u0001\u0000\u0000"+
		"\u0000\u01ef%\u0001\u0000\u0000\u0000\u01f0\u01f2\u0005I\u0000\u0000\u01f1"+
		"\u01f3\u0003.\u0017\u0000\u01f2\u01f1\u0001\u0000\u0000\u0000\u01f2\u01f3"+
		"\u0001\u0000\u0000\u0000\u01f3\u01f7\u0001\u0000\u0000\u0000\u01f4\u01f6"+
		"\u0003\u0002\u0001\u0000\u01f5\u01f4\u0001\u0000\u0000\u0000\u01f6\u01f9"+
		"\u0001\u0000\u0000\u0000\u01f7\u01f5\u0001\u0000\u0000\u0000\u01f7\u01f8"+
		"\u0001\u0000\u0000\u0000\u01f8\u0201\u0001\u0000\u0000\u0000\u01f9\u01f7"+
		"\u0001\u0000\u0000\u0000\u01fa\u01fe\u0007\u0006\u0000\u0000\u01fb\u01fd"+
		"\u0003\u0002\u0001\u0000\u01fc\u01fb\u0001\u0000\u0000\u0000\u01fd\u0200"+
		"\u0001\u0000\u0000\u0000\u01fe\u01fc\u0001\u0000\u0000\u0000\u01fe\u01ff"+
		"\u0001\u0000\u0000\u0000\u01ff\u0202\u0001\u0000\u0000\u0000\u0200\u01fe"+
		"\u0001\u0000\u0000\u0000\u0201\u01fa\u0001\u0000\u0000\u0000\u0201\u0202"+
		"\u0001\u0000\u0000\u0000\u0202\u0203\u0001\u0000\u0000\u0000\u0203\u0222"+
		"\u0005J\u0000\u0000\u0204\u0206\u0005K\u0000\u0000\u0205\u0207\u0003."+
		"\u0017\u0000\u0206\u0205\u0001\u0000\u0000\u0000\u0206\u0207\u0001\u0000"+
		"\u0000\u0000\u0207\u020b\u0001\u0000\u0000\u0000\u0208\u020a\u0003\u0002"+
		"\u0001\u0000\u0209\u0208\u0001\u0000\u0000\u0000\u020a\u020d\u0001\u0000"+
		"\u0000\u0000\u020b\u0209\u0001\u0000\u0000\u0000\u020b\u020c\u0001\u0000"+
		"\u0000\u0000\u020c\u020e\u0001\u0000\u0000\u0000\u020d\u020b\u0001\u0000"+
		"\u0000\u0000\u020e\u0222\u0005M\u0000\u0000\u020f\u0210\u0005N\u0000\u0000"+
		"\u0210\u0214\u0003.\u0017\u0000\u0211\u0213\u0003\u0002\u0001\u0000\u0212"+
		"\u0211\u0001\u0000\u0000\u0000\u0213\u0216\u0001\u0000\u0000\u0000\u0214"+
		"\u0212\u0001\u0000\u0000\u0000\u0214\u0215\u0001\u0000\u0000\u0000\u0215"+
		"\u0217\u0001\u0000\u0000\u0000\u0216\u0214\u0001\u0000\u0000\u0000\u0217"+
		"\u0218\u0005O\u0000\u0000\u0218\u0222\u0001\u0000\u0000\u0000\u0219\u021d"+
		"\u0005P\u0000\u0000\u021a\u021c\u0003\u0002\u0001\u0000\u021b\u021a\u0001"+
		"\u0000\u0000\u0000\u021c\u021f\u0001\u0000\u0000\u0000\u021d\u021b\u0001"+
		"\u0000\u0000\u0000\u021d\u021e\u0001\u0000\u0000\u0000\u021e\u0220\u0001"+
		"\u0000\u0000\u0000\u021f\u021d\u0001\u0000\u0000\u0000\u0220\u0222\u0005"+
		"Q\u0000\u0000\u0221\u01f0\u0001\u0000\u0000\u0000\u0221\u0204\u0001\u0000"+
		"\u0000\u0000\u0221\u020f\u0001\u0000\u0000\u0000\u0221\u0219\u0001\u0000"+
		"\u0000\u0000\u0222\'\u0001\u0000\u0000\u0000\u0223\u0224\u0005W\u0000"+
		"\u0000\u0224\u0225\u0005\u0005\u0000\u0000\u0225)\u0001\u0000\u0000\u0000"+
		"\u0226\u0227\u0005Y\u0000\u0000\u0227\u0228\u0005Z\u0000\u0000\u0228+"+
		"\u0001\u0000\u0000\u0000\u0229\u022a\u0003\u001e\u000f\u0000\u022a\u022b"+
		"\u0005\u0001\u0000\u0000\u022b\u022c\u0006\u0016\uffff\uffff\u0000\u022c"+
		"\u023f\u0001\u0000\u0000\u0000\u022d\u022e\u0005\r\u0000\u0000\u022e\u022f"+
		"\u0003.\u0017\u0000\u022f\u0230\u0006\u0016\uffff\uffff\u0000\u0230\u023f"+
		"\u0001\u0000\u0000\u0000\u0231\u0232\u0007\u0007\u0000\u0000\u0232\u0233"+
		"\u0003.\u0017\u0000\u0233\u0234\u0006\u0016\uffff\uffff\u0000\u0234\u023f"+
		"\u0001\u0000\u0000\u0000\u0235\u0236\u0005A\u0000\u0000\u0236\u023f\u0006"+
		"\u0016\uffff\uffff\u0000\u0237\u0238\u0005!\u0000\u0000\u0238\u023a\u0005"+
		"\u0001\u0000\u0000\u0239\u023b\u0005\u0004\u0000\u0000\u023a\u0239\u0001"+
		"\u0000\u0000\u0000\u023a\u023b\u0001\u0000\u0000\u0000\u023b\u023c\u0001"+
		"\u0000\u0000\u0000\u023c\u023d\u0005\u0002\u0000\u0000\u023d\u023f\u0006"+
		"\u0016\uffff\uffff\u0000\u023e\u0229\u0001\u0000\u0000\u0000\u023e\u022d"+
		"\u0001\u0000\u0000\u0000\u023e\u0231\u0001\u0000\u0000\u0000\u023e\u0235"+
		"\u0001\u0000\u0000\u0000\u023e\u0237\u0001\u0000\u0000\u0000\u023f-\u0001"+
		"\u0000\u0000\u0000\u0240\u0241\u0005\u0001\u0000\u0000\u0241\u0242\u0005"+
		"\u0002\u0000\u0000\u0242/\u0001\u0000\u0000\u0000\u0243\u0244\u0005\\"+
		"\u0000\u0000\u0244\u0245\u0007\b\u0000\u0000\u02451\u0001\u0000\u0000"+
		"\u0000U5EOQ[`is}\u0087\u0092\u0099\u009f\u00a1\u00a7\u00a9\u00ac\u00b4"+
		"\u00b6\u00bf\u00c1\u00ca\u00cc\u00d3\u00e0\u00ea\u00ee\u00f2\u00fa\u00fd"+
		"\u0108\u010d\u0114\u0117\u011d\u0120\u0127\u012a\u0130\u0133\u0139\u013f"+
		"\u0142\u0149\u014c\u0151\u0157\u0159\u0161\u0165\u0168\u016d\u0171\u0176"+
		"\u017d\u0183\u018a\u0190\u0197\u019d\u01a4\u01ab\u01b2\u01b8\u01bf\u01c5"+
		"\u01c9\u01cf\u01d3\u01d8\u01de\u01e5\u01e8\u01ee\u01f2\u01f7\u01fe\u0201"+
		"\u0206\u020b\u0214\u021d\u0221\u023a\u023e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}