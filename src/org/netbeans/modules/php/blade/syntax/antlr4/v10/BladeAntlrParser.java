// Generated from BladeAntlrParser.g4 by ANTLR 4.13.2

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

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class BladeAntlrParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, D_CUSTOM=3, D_DIRECTIVE=4, IDENTIFIABLE_STRING=5, 
		BLADE_CONTENT_CLOSE_TAG=6, LSQUAREBRACKET=7, RSQUAREBRACKET=8, LCURLYBRACE=9, 
		RCURLYBRACE=10, D_PHP=11, COMMA=12, ERROR=13, D_IF=14, D_ELSEIF=15, D_ELSE=16, 
		D_ENDIF=17, D_UNLESS=18, D_ENDUNLESS=19, D_ISSET=20, D_ENDISSET=21, D_SWITCH=22, 
		D_CASE=23, D_DEFAULT=24, D_ENDSWITCH=25, D_EXTENDS=26, D_INCLUDE=27, D_INCLUDE_IF=28, 
		D_INCLUDE_WHEN=29, D_INCLUDE_UNLESS=30, D_INCLUDE_FIRST=31, D_EACH=32, 
		D_YIELD=33, D_SECTION=34, D_HAS_SECTION=35, D_SECTION_MISSING=36, D_ENDSECTION=37, 
		D_PARENT=38, D_SHOW=39, D_OVERWRITE=40, D_STOP=41, D_APPEND=42, D_ONCE=43, 
		D_ENDONCE=44, D_STACK=45, D_PUSH=46, D_ENDPUSH=47, D_PUSH_IF=48, D_ENDPUSH_IF=49, 
		D_PUSH_ONCE=50, D_ENDPUSH_ONCE=51, D_PREPEND=52, D_ENDPREPEND=53, D_FOREACH=54, 
		D_ENDFOREACH=55, D_FOR=56, D_ENDFOR=57, D_FORELSE=58, D_ENDFORELSE=59, 
		D_WHILE=60, D_ENDWHILE=61, D_BREAK=62, D_CONTINUE=63, D_EMPTY=64, D_ENDEMPTY=65, 
		D_VERBATIM=66, D_ENDVERBATIM=67, D_SESSION=68, D_ENDSESSION=69, D_CSRF=70, 
		D_METHOD=71, D_ERROR=72, D_ENDERROR=73, D_AUTH=74, D_ENDAUTH=75, D_GUEST=76, 
		D_ELSEGUEST=77, D_ENDGUEST=78, D_ENV=79, D_ENDENV=80, D_PRODUCTION=81, 
		D_ENDPRODUCTION=82, D_CAN=83, D_ENDCAN=84, D_CANNOT=85, D_CANANY=86, D_ELSECAN=87, 
		D_ENDCANNOT=88, D_ENDCANANY=89, D_FRAGMENT=90, D_ENDFRAGMENT=91, D_SIMPLE_DIRECTIVE=92, 
		D_VITE=93, D_VITE_REFRESH=94, D_LANG=95, D_INJECT=96, D_USE=97, BLADE_CONTENT_OPEN_TAG=98, 
		BLADE_TAG_ESCAPE=99, BLADE_RAW_OPEN_TAG=100, BLADE_RAW_CLOSE_TAG=101, 
		D_CSS_AT=102, D_CSS_AT2=103, D_ENDCUSTOM=104, AT=105, PHP_INLINE_START=106, 
		HTML_COMPONENT_OPEN_TAG=107, WS=108, OTHER=109, BLADE_COMMENT_START=110, 
		EMAIL_SUBSTRING=111, VERSION_WITH_AT=112, D_ESCAPES=113, E_LPAREN=114, 
		E_RPAREN=115, E_LSQUAREBRACKET=116, E_RSQUAREBRACKET=117, E_LCURLYBRACE=118, 
		E_RCURLYBRACE=119, E_OTHER=120, EI_LPAREN=121, EI_RPAREN=122, EI_OTHER=123, 
		ESPOS_LPAREN=124, ESPOS_RPAREN=125, ESPOS_LSQUAREBRACKET=126, ESPOS_RSQUAREBRACKET=127, 
		ESPOS_LCURLYBRACE=128, ESPOS_RCURLYBRACE=129, ESPOS_OTHER=130, EACH_LPAREN=131, 
		EACH_RPAREN=132, EACH_LSQUAREBRACKET=133, EACH_RSQUAREBRACKET=134, EACH_LCURLYBRACE=135, 
		EACH_RCURLYBRACE=136, EACH_OTHER=137, INCF_LPAREN=138, INCF_RPAREN=139, 
		INCF_LSQUAREBRACKET=140, INCF_RSQUAREBRACKET=141, INCF_LCURLYBRACE=142, 
		INCF_RCURLYBRACE=143, INCF_OTHER=144, MIXED_S_A_LPAREN=145, MIXED_S_A_RPAREN=146, 
		MIXED_S_A_LSQUAREBRACKET=147, MIXED_S_A_RSQUAREBRACKET=148, MIXED_S_A_LCURLYBRACE=149, 
		MIXED_S_A_RCURLYBRACE=150, MIXED_S_A_OTHER=151, FOREACH_LPAREN=152, FOREACH_RPAREN=153, 
		FOREACH_LSQUAREBRACKET=154, FOREACH_RSQUAREBRACKET=155, FOREACH_LCURLYBRACE=156, 
		FOREACH_RCURLYBRACE=157, FOREACH_VAR=158, FOREACH_AS=159, FOREACH_DOUBLE_ARROW=160, 
		FOREACH_OTHER=161, D_ENDPHP=162, BLADE_INLINE_PHP_OTHER=163, VERBATIM_HTML=164, 
		PHP_INLINE_EXIT=165, PHP_INLINE_OTHER=166, PHP_INLINE_EOF=167, BLADE_COMMENT_END=168, 
		BLADE_COMMENT_MORE=169, BLADE_COMMENT_EOF=170;
	public static final int
		RULE_file = 0, RULE_statement = 1, RULE_blockDirective = 2, RULE_ifStatement = 3, 
		RULE_foreachStatement = 4, RULE_forStatement = 5, RULE_forElseStatement = 6, 
		RULE_ifStartStatement = 7, RULE_elseifStatement = 8, RULE_switchStatement = 9, 
		RULE_bladePhpBlock = 10, RULE_inlineDirective = 11, RULE_identifiableArgDirective = 12, 
		RULE_multipleArgDirective = 13, RULE_blockIdentifiableArgDirective = 14, 
		RULE_directiveWithArg = 15, RULE_customDirective = 16, RULE_loopBreaks = 17, 
		RULE_formStatements = 18, RULE_authStatements = 19, RULE_bladeContentTags = 20, 
		RULE_bladeRawTags = 21, RULE_errorDirectives = 22, RULE_directiveArguments = 23, 
		RULE_foreachLoopArguments = 24, RULE_phpInline = 25, RULE_htmlComponentOpenTag = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "statement", "blockDirective", "ifStatement", "foreachStatement", 
			"forStatement", "forElseStatement", "ifStartStatement", "elseifStatement", 
			"switchStatement", "bladePhpBlock", "inlineDirective", "identifiableArgDirective", 
			"multipleArgDirective", "blockIdentifiableArgDirective", "directiveWithArg", 
			"customDirective", "loopBreaks", "formStatements", "authStatements", 
			"bladeContentTags", "bladeRawTags", "errorDirectives", "directiveArguments", 
			"foreachLoopArguments", "phpInline", "htmlComponentOpenTag"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", null, null, null, "'}}'", "'['", "']'", null, null, 
			null, "','", null, null, null, "'@else'", "'@endif'", null, "'@endunless'", 
			null, "'@endisset'", null, null, "'@default'", "'@endswitch'", null, 
			null, null, null, null, null, null, null, null, null, null, "'@endsection'", 
			"'@parent'", "'@show'", "'@overwrite'", "'@stop'", "'@append'", "'@once'", 
			"'@endonce'", null, null, "'@endpush'", null, "'@endPushIf'", null, "'@endPushOnce'", 
			null, "'@endprepend'", null, "'@endforeach'", null, "'@endfor'", null, 
			"'@endforelse'", null, "'@endwhile'", null, null, null, "'@endempty'", 
			"'@verbatim'", "'@endverbatim'", null, "'@endsession'", "'@csrf'", null, 
			null, "'@enderror'", null, "'@endauth'", null, "'@elseguest'", "'@endguest'", 
			null, "'@endenv'", "'@production'", "'@endproduction'", null, "'@endcan'", 
			null, null, null, "'@endcannot'", "'@endcanany'", null, "'@endfragment'", 
			null, null, "'@viteReactRefresh'", "'@lang'", null, "'@use'", "'{{'", 
			null, "'{!!'", "'!!}'", null, null, null, "'@'", null, null, null, null, 
			"'{{--'", null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'as'", "'=>'", null, "'@endphp'", null, null, "'?>'", null, 
			null, "'--}}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "D_CUSTOM", "D_DIRECTIVE", "IDENTIFIABLE_STRING", 
			"BLADE_CONTENT_CLOSE_TAG", "LSQUAREBRACKET", "RSQUAREBRACKET", "LCURLYBRACE", 
			"RCURLYBRACE", "D_PHP", "COMMA", "ERROR", "D_IF", "D_ELSEIF", "D_ELSE", 
			"D_ENDIF", "D_UNLESS", "D_ENDUNLESS", "D_ISSET", "D_ENDISSET", "D_SWITCH", 
			"D_CASE", "D_DEFAULT", "D_ENDSWITCH", "D_EXTENDS", "D_INCLUDE", "D_INCLUDE_IF", 
			"D_INCLUDE_WHEN", "D_INCLUDE_UNLESS", "D_INCLUDE_FIRST", "D_EACH", "D_YIELD", 
			"D_SECTION", "D_HAS_SECTION", "D_SECTION_MISSING", "D_ENDSECTION", "D_PARENT", 
			"D_SHOW", "D_OVERWRITE", "D_STOP", "D_APPEND", "D_ONCE", "D_ENDONCE", 
			"D_STACK", "D_PUSH", "D_ENDPUSH", "D_PUSH_IF", "D_ENDPUSH_IF", "D_PUSH_ONCE", 
			"D_ENDPUSH_ONCE", "D_PREPEND", "D_ENDPREPEND", "D_FOREACH", "D_ENDFOREACH", 
			"D_FOR", "D_ENDFOR", "D_FORELSE", "D_ENDFORELSE", "D_WHILE", "D_ENDWHILE", 
			"D_BREAK", "D_CONTINUE", "D_EMPTY", "D_ENDEMPTY", "D_VERBATIM", "D_ENDVERBATIM", 
			"D_SESSION", "D_ENDSESSION", "D_CSRF", "D_METHOD", "D_ERROR", "D_ENDERROR", 
			"D_AUTH", "D_ENDAUTH", "D_GUEST", "D_ELSEGUEST", "D_ENDGUEST", "D_ENV", 
			"D_ENDENV", "D_PRODUCTION", "D_ENDPRODUCTION", "D_CAN", "D_ENDCAN", "D_CANNOT", 
			"D_CANANY", "D_ELSECAN", "D_ENDCANNOT", "D_ENDCANANY", "D_FRAGMENT", 
			"D_ENDFRAGMENT", "D_SIMPLE_DIRECTIVE", "D_VITE", "D_VITE_REFRESH", "D_LANG", 
			"D_INJECT", "D_USE", "BLADE_CONTENT_OPEN_TAG", "BLADE_TAG_ESCAPE", "BLADE_RAW_OPEN_TAG", 
			"BLADE_RAW_CLOSE_TAG", "D_CSS_AT", "D_CSS_AT2", "D_ENDCUSTOM", "AT", 
			"PHP_INLINE_START", "HTML_COMPONENT_OPEN_TAG", "WS", "OTHER", "BLADE_COMMENT_START", 
			"EMAIL_SUBSTRING", "VERSION_WITH_AT", "D_ESCAPES", "E_LPAREN", "E_RPAREN", 
			"E_LSQUAREBRACKET", "E_RSQUAREBRACKET", "E_LCURLYBRACE", "E_RCURLYBRACE", 
			"E_OTHER", "EI_LPAREN", "EI_RPAREN", "EI_OTHER", "ESPOS_LPAREN", "ESPOS_RPAREN", 
			"ESPOS_LSQUAREBRACKET", "ESPOS_RSQUAREBRACKET", "ESPOS_LCURLYBRACE", 
			"ESPOS_RCURLYBRACE", "ESPOS_OTHER", "EACH_LPAREN", "EACH_RPAREN", "EACH_LSQUAREBRACKET", 
			"EACH_RSQUAREBRACKET", "EACH_LCURLYBRACE", "EACH_RCURLYBRACE", "EACH_OTHER", 
			"INCF_LPAREN", "INCF_RPAREN", "INCF_LSQUAREBRACKET", "INCF_RSQUAREBRACKET", 
			"INCF_LCURLYBRACE", "INCF_RCURLYBRACE", "INCF_OTHER", "MIXED_S_A_LPAREN", 
			"MIXED_S_A_RPAREN", "MIXED_S_A_LSQUAREBRACKET", "MIXED_S_A_RSQUAREBRACKET", 
			"MIXED_S_A_LCURLYBRACE", "MIXED_S_A_RCURLYBRACE", "MIXED_S_A_OTHER", 
			"FOREACH_LPAREN", "FOREACH_RPAREN", "FOREACH_LSQUAREBRACKET", "FOREACH_RSQUAREBRACKET", 
			"FOREACH_LCURLYBRACE", "FOREACH_RCURLYBRACE", "FOREACH_VAR", "FOREACH_AS", 
			"FOREACH_DOUBLE_ARROW", "FOREACH_OTHER", "D_ENDPHP", "BLADE_INLINE_PHP_OTHER", 
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
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
				{
				{
				setState(54);
				statement();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
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
		public TerminalNode D_ENDCUSTOM() { return getToken(BladeAntlrParser.D_ENDCUSTOM, 0); }
		public HtmlComponentOpenTagContext htmlComponentOpenTag() {
			return getRuleContext(HtmlComponentOpenTagContext.class,0);
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
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				blockIdentifiableArgDirective();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				blockDirective();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				identifiableArgDirective();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				multipleArgDirective();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				inlineDirective();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(67);
				customDirective();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(68);
				bladeContentTags();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(69);
				bladeRawTags();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(70);
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
				setState(71);
				errorDirectives();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(72);
				phpInline();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(73);
				match(D_ENDCUSTOM);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(74);
				htmlComponentOpenTag();
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
		public List<DirectiveArgumentsContext> directiveArguments() {
			return getRuleContexts(DirectiveArgumentsContext.class);
		}
		public DirectiveArgumentsContext directiveArguments(int i) {
			return getRuleContext(DirectiveArgumentsContext.class,i);
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
		public TerminalNode D_CAN() { return getToken(BladeAntlrParser.D_CAN, 0); }
		public TerminalNode D_ENDCAN() { return getToken(BladeAntlrParser.D_ENDCAN, 0); }
		public List<TerminalNode> D_ELSECAN() { return getTokens(BladeAntlrParser.D_ELSECAN); }
		public TerminalNode D_ELSECAN(int i) {
			return getToken(BladeAntlrParser.D_ELSECAN, i);
		}
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
		public TerminalNode D_CANNOT() { return getToken(BladeAntlrParser.D_CANNOT, 0); }
		public TerminalNode D_ENDCANNOT() { return getToken(BladeAntlrParser.D_ENDCANNOT, 0); }
		public TerminalNode D_CANANY() { return getToken(BladeAntlrParser.D_CANANY, 0); }
		public TerminalNode D_ENDCANANY() { return getToken(BladeAntlrParser.D_ENDCANANY, 0); }
		public BladePhpBlockContext bladePhpBlock() {
			return getRuleContext(BladePhpBlockContext.class,0);
		}
		public TerminalNode D_FRAGMENT() { return getToken(BladeAntlrParser.D_FRAGMENT, 0); }
		public TerminalNode D_ENDFRAGMENT() { return getToken(BladeAntlrParser.D_ENDFRAGMENT, 0); }
		public TerminalNode D_VERBATIM() { return getToken(BladeAntlrParser.D_VERBATIM, 0); }
		public TerminalNode D_ENDVERBATIM() { return getToken(BladeAntlrParser.D_ENDVERBATIM, 0); }
		public TerminalNode D_ENDCUSTOM() { return getToken(BladeAntlrParser.D_ENDCUSTOM, 0); }
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
			int _alt;
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				ifStatement();
				}
				break;
			case D_FOREACH:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				foreachStatement();
				}
				break;
			case D_FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				forStatement();
				}
				break;
			case D_FORELSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				forElseStatement();
				}
				break;
			case D_WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				match(D_WHILE);
				setState(82);
				directiveArguments();
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3074436684023773096L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					setState(85);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_CUSTOM:
					case D_DIRECTIVE:
					case BLADE_CONTENT_CLOSE_TAG:
					case D_PHP:
					case D_IF:
					case D_ELSE:
					case D_UNLESS:
					case D_ISSET:
					case D_SWITCH:
					case D_EXTENDS:
					case D_INCLUDE:
					case D_INCLUDE_IF:
					case D_INCLUDE_WHEN:
					case D_INCLUDE_UNLESS:
					case D_INCLUDE_FIRST:
					case D_EACH:
					case D_YIELD:
					case D_SECTION:
					case D_HAS_SECTION:
					case D_SECTION_MISSING:
					case D_ONCE:
					case D_STACK:
					case D_PUSH:
					case D_PUSH_IF:
					case D_PUSH_ONCE:
					case D_PREPEND:
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
					case D_CAN:
					case D_CANNOT:
					case D_CANANY:
					case D_FRAGMENT:
					case D_SIMPLE_DIRECTIVE:
					case D_VITE:
					case D_VITE_REFRESH:
					case D_LANG:
					case D_INJECT:
					case D_USE:
					case BLADE_CONTENT_OPEN_TAG:
					case BLADE_RAW_OPEN_TAG:
					case BLADE_RAW_CLOSE_TAG:
					case D_ENDCUSTOM:
					case PHP_INLINE_START:
					case HTML_COMPONENT_OPEN_TAG:
						{
						setState(83);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(84);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(90);
				match(D_ENDWHILE);
				}
				break;
			case D_SWITCH:
				enterOuterAlt(_localctx, 6);
				{
				setState(92);
				switchStatement();
				}
				break;
			case D_CSRF:
			case D_METHOD:
			case D_ERROR:
				enterOuterAlt(_localctx, 7);
				{
				setState(93);
				formStatements();
				}
				break;
			case D_AUTH:
			case D_GUEST:
			case D_ENV:
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 8);
				{
				setState(94);
				authStatements();
				}
				break;
			case D_ONCE:
				enterOuterAlt(_localctx, 9);
				{
				setState(95);
				match(D_ONCE);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(96);
					directiveArguments();
					}
				}

				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(99);
					statement();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105);
				match(D_ENDONCE);
				}
				break;
			case D_UNLESS:
				enterOuterAlt(_localctx, 10);
				{
				setState(106);
				match(D_UNLESS);
				setState(107);
				directiveArguments();
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(108);
					statement();
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(114);
				match(D_ENDUNLESS);
				}
				break;
			case D_EMPTY:
				enterOuterAlt(_localctx, 11);
				{
				setState(116);
				match(D_EMPTY);
				setState(117);
				directiveArguments();
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(118);
					statement();
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(124);
				match(D_ENDEMPTY);
				}
				break;
			case D_ISSET:
				enterOuterAlt(_localctx, 12);
				{
				setState(126);
				match(D_ISSET);
				setState(127);
				directiveArguments();
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(128);
					statement();
					}
					}
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(134);
				match(D_ENDISSET);
				}
				break;
			case D_SESSION:
				enterOuterAlt(_localctx, 13);
				{
				setState(136);
				match(D_SESSION);
				setState(137);
				directiveArguments();
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(138);
					statement();
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144);
				match(D_ENDSESSION);
				}
				break;
			case D_CAN:
				enterOuterAlt(_localctx, 14);
				{
				setState(146);
				match(D_CAN);
				setState(147);
				directiveArguments();
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(148);
						statement();
						}
						} 
					}
					setState(153);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==D_ELSECAN) {
					{
					{
					setState(154);
					match(D_ELSECAN);
					setState(155);
					directiveArguments();
					setState(159);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(156);
							statement();
							}
							} 
						}
						setState(161);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
					}
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(167);
					match(D_ELSE);
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
						{
						{
						setState(168);
						statement();
						}
						}
						setState(173);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(176);
				match(D_ENDCAN);
				}
				break;
			case D_CANNOT:
				enterOuterAlt(_localctx, 15);
				{
				setState(178);
				match(D_CANNOT);
				setState(179);
				directiveArguments();
				setState(183);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(180);
						statement();
						}
						} 
					}
					setState(185);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==D_ELSECAN) {
					{
					{
					setState(186);
					match(D_ELSECAN);
					setState(187);
					directiveArguments();
					setState(191);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(188);
							statement();
							}
							} 
						}
						setState(193);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
					}
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(199);
					match(D_ELSE);
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
						{
						{
						setState(200);
						statement();
						}
						}
						setState(205);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(208);
				match(D_ENDCANNOT);
				}
				break;
			case D_CANANY:
				enterOuterAlt(_localctx, 16);
				{
				setState(210);
				match(D_CANANY);
				setState(211);
				directiveArguments();
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(212);
						statement();
						}
						} 
					}
					setState(217);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==D_ELSECAN) {
					{
					{
					setState(218);
					match(D_ELSECAN);
					setState(219);
					directiveArguments();
					setState(223);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(220);
							statement();
							}
							} 
						}
						setState(225);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					}
					}
					}
					setState(230);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(231);
					match(D_ELSE);
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
						{
						{
						setState(232);
						statement();
						}
						}
						setState(237);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(240);
				match(D_ENDCANANY);
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 17);
				{
				setState(242);
				bladePhpBlock();
				}
				break;
			case D_FRAGMENT:
				enterOuterAlt(_localctx, 18);
				{
				setState(243);
				match(D_FRAGMENT);
				setState(244);
				directiveArguments();
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(245);
					statement();
					}
					}
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(251);
				match(D_ENDFRAGMENT);
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 19);
				{
				setState(253);
				match(D_VERBATIM);
				setState(254);
				match(D_ENDVERBATIM);
				}
				break;
			case D_ELSE:
				enterOuterAlt(_localctx, 20);
				{
				setState(255);
				match(D_ELSE);
				setState(259);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(256);
						statement();
						}
						} 
					}
					setState(261);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				}
				setState(262);
				match(D_ENDCUSTOM);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			ifStartStatement();
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(269);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_ELSEIF:
						{
						setState(266);
						elseifStatement();
						}
						break;
					case D_CUSTOM:
					case D_DIRECTIVE:
					case BLADE_CONTENT_CLOSE_TAG:
					case D_PHP:
					case D_IF:
					case D_ELSE:
					case D_UNLESS:
					case D_ISSET:
					case D_SWITCH:
					case D_EXTENDS:
					case D_INCLUDE:
					case D_INCLUDE_IF:
					case D_INCLUDE_WHEN:
					case D_INCLUDE_UNLESS:
					case D_INCLUDE_FIRST:
					case D_EACH:
					case D_YIELD:
					case D_SECTION:
					case D_HAS_SECTION:
					case D_SECTION_MISSING:
					case D_ONCE:
					case D_STACK:
					case D_PUSH:
					case D_PUSH_IF:
					case D_PUSH_ONCE:
					case D_PREPEND:
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
					case D_CAN:
					case D_CANNOT:
					case D_CANANY:
					case D_FRAGMENT:
					case D_SIMPLE_DIRECTIVE:
					case D_VITE:
					case D_VITE_REFRESH:
					case D_LANG:
					case D_INJECT:
					case D_USE:
					case BLADE_CONTENT_OPEN_TAG:
					case BLADE_RAW_OPEN_TAG:
					case BLADE_RAW_CLOSE_TAG:
					case D_ENDCUSTOM:
					case PHP_INLINE_START:
					case HTML_COMPONENT_OPEN_TAG:
						{
						setState(267);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(268);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_ELSE) {
				{
				setState(274);
				match(D_ELSE);
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3074436684023773096L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					setState(277);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_CUSTOM:
					case D_DIRECTIVE:
					case BLADE_CONTENT_CLOSE_TAG:
					case D_PHP:
					case D_IF:
					case D_ELSE:
					case D_UNLESS:
					case D_ISSET:
					case D_SWITCH:
					case D_EXTENDS:
					case D_INCLUDE:
					case D_INCLUDE_IF:
					case D_INCLUDE_WHEN:
					case D_INCLUDE_UNLESS:
					case D_INCLUDE_FIRST:
					case D_EACH:
					case D_YIELD:
					case D_SECTION:
					case D_HAS_SECTION:
					case D_SECTION_MISSING:
					case D_ONCE:
					case D_STACK:
					case D_PUSH:
					case D_PUSH_IF:
					case D_PUSH_ONCE:
					case D_PREPEND:
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
					case D_CAN:
					case D_CANNOT:
					case D_CANANY:
					case D_FRAGMENT:
					case D_SIMPLE_DIRECTIVE:
					case D_VITE:
					case D_VITE_REFRESH:
					case D_LANG:
					case D_INJECT:
					case D_USE:
					case BLADE_CONTENT_OPEN_TAG:
					case BLADE_RAW_OPEN_TAG:
					case BLADE_RAW_CLOSE_TAG:
					case D_ENDCUSTOM:
					case PHP_INLINE_START:
					case HTML_COMPONENT_OPEN_TAG:
						{
						setState(275);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(276);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(281);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(284);
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
		public ForeachLoopArgumentsContext foreachLoopArguments() {
			return getRuleContext(ForeachLoopArgumentsContext.class,0);
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
			setState(286);
			match(D_FOREACH);
			setState(287);
			foreachLoopArguments();
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3074436684023773096L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
				{
				setState(290);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case D_CUSTOM:
				case D_DIRECTIVE:
				case BLADE_CONTENT_CLOSE_TAG:
				case D_PHP:
				case D_IF:
				case D_ELSE:
				case D_UNLESS:
				case D_ISSET:
				case D_SWITCH:
				case D_EXTENDS:
				case D_INCLUDE:
				case D_INCLUDE_IF:
				case D_INCLUDE_WHEN:
				case D_INCLUDE_UNLESS:
				case D_INCLUDE_FIRST:
				case D_EACH:
				case D_YIELD:
				case D_SECTION:
				case D_HAS_SECTION:
				case D_SECTION_MISSING:
				case D_ONCE:
				case D_STACK:
				case D_PUSH:
				case D_PUSH_IF:
				case D_PUSH_ONCE:
				case D_PREPEND:
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
				case D_CAN:
				case D_CANNOT:
				case D_CANANY:
				case D_FRAGMENT:
				case D_SIMPLE_DIRECTIVE:
				case D_VITE:
				case D_VITE_REFRESH:
				case D_LANG:
				case D_INJECT:
				case D_USE:
				case BLADE_CONTENT_OPEN_TAG:
				case BLADE_RAW_OPEN_TAG:
				case BLADE_RAW_CLOSE_TAG:
				case D_ENDCUSTOM:
				case PHP_INLINE_START:
				case HTML_COMPONENT_OPEN_TAG:
					{
					setState(288);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(289);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(295);
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
			setState(297);
			match(D_FOR);
			setState(298);
			directiveArguments();
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3074436684023773096L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
				{
				setState(301);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case D_CUSTOM:
				case D_DIRECTIVE:
				case BLADE_CONTENT_CLOSE_TAG:
				case D_PHP:
				case D_IF:
				case D_ELSE:
				case D_UNLESS:
				case D_ISSET:
				case D_SWITCH:
				case D_EXTENDS:
				case D_INCLUDE:
				case D_INCLUDE_IF:
				case D_INCLUDE_WHEN:
				case D_INCLUDE_UNLESS:
				case D_INCLUDE_FIRST:
				case D_EACH:
				case D_YIELD:
				case D_SECTION:
				case D_HAS_SECTION:
				case D_SECTION_MISSING:
				case D_ONCE:
				case D_STACK:
				case D_PUSH:
				case D_PUSH_IF:
				case D_PUSH_ONCE:
				case D_PREPEND:
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
				case D_CAN:
				case D_CANNOT:
				case D_CANANY:
				case D_FRAGMENT:
				case D_SIMPLE_DIRECTIVE:
				case D_VITE:
				case D_VITE_REFRESH:
				case D_LANG:
				case D_INJECT:
				case D_USE:
				case BLADE_CONTENT_OPEN_TAG:
				case BLADE_RAW_OPEN_TAG:
				case BLADE_RAW_CLOSE_TAG:
				case D_ENDCUSTOM:
				case PHP_INLINE_START:
				case HTML_COMPONENT_OPEN_TAG:
					{
					setState(299);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(300);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(306);
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
			setState(308);
			match(D_FORELSE);
			setState(309);
			directiveArguments();
			setState(314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(312);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_CUSTOM:
					case D_DIRECTIVE:
					case BLADE_CONTENT_CLOSE_TAG:
					case D_PHP:
					case D_IF:
					case D_ELSE:
					case D_UNLESS:
					case D_ISSET:
					case D_SWITCH:
					case D_EXTENDS:
					case D_INCLUDE:
					case D_INCLUDE_IF:
					case D_INCLUDE_WHEN:
					case D_INCLUDE_UNLESS:
					case D_INCLUDE_FIRST:
					case D_EACH:
					case D_YIELD:
					case D_SECTION:
					case D_HAS_SECTION:
					case D_SECTION_MISSING:
					case D_ONCE:
					case D_STACK:
					case D_PUSH:
					case D_PUSH_IF:
					case D_PUSH_ONCE:
					case D_PREPEND:
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
					case D_CAN:
					case D_CANNOT:
					case D_CANANY:
					case D_FRAGMENT:
					case D_SIMPLE_DIRECTIVE:
					case D_VITE:
					case D_VITE_REFRESH:
					case D_LANG:
					case D_INJECT:
					case D_USE:
					case BLADE_CONTENT_OPEN_TAG:
					case BLADE_RAW_OPEN_TAG:
					case BLADE_RAW_CLOSE_TAG:
					case D_ENDCUSTOM:
					case PHP_INLINE_START:
					case HTML_COMPONENT_OPEN_TAG:
						{
						setState(310);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(311);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			}
			setState(317);
			match(D_EMPTY);
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
				{
				{
				setState(318);
				statement();
				}
				}
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(324);
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
			setState(326);
			match(D_IF);
			setState(327);
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
			setState(329);
			match(D_ELSEIF);
			setState(330);
			directiveArguments();
			setState(334);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(331);
					statement();
					}
					} 
				}
				setState(336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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
			setState(337);
			match(D_SWITCH);
			setState(338);
			directiveArguments();
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==D_CASE) {
				{
				{
				setState(339);
				match(D_CASE);
				setState(340);
				directiveArguments();
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(341);
					statement();
					}
					}
					setState(346);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_BREAK) {
					{
					setState(347);
					match(D_BREAK);
					}
				}

				}
				}
				setState(354);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_DEFAULT) {
				{
				setState(355);
				match(D_DEFAULT);
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(356);
					statement();
					}
					}
					setState(361);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(364);
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
			setState(366);
			match(D_PHP);
			setState(367);
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
		public TerminalNode D_DIRECTIVE() { return getToken(BladeAntlrParser.D_DIRECTIVE, 0); }
		public TerminalNode D_VITE_REFRESH() { return getToken(BladeAntlrParser.D_VITE_REFRESH, 0); }
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
			setState(375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SIMPLE_DIRECTIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				match(D_SIMPLE_DIRECTIVE);
				setState(370);
				directiveArguments();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 2);
				{
				setState(371);
				match(D_PHP);
				setState(372);
				directiveArguments();
				}
				break;
			case D_DIRECTIVE:
				enterOuterAlt(_localctx, 3);
				{
				setState(373);
				match(D_DIRECTIVE);
				}
				break;
			case D_VITE_REFRESH:
				enterOuterAlt(_localctx, 4);
				{
				setState(374);
				match(D_VITE_REFRESH);
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
		public TerminalNode D_USE() { return getToken(BladeAntlrParser.D_USE, 0); }
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
			setState(452);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				match(D_SECTION);
				setState(378);
				match(LPAREN);
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(379);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(382);
				match(COMMA);
				setState(383);
				match(RPAREN);
				}
				break;
			case D_EXTENDS:
				enterOuterAlt(_localctx, 2);
				{
				setState(384);
				match(D_EXTENDS);
				setState(385);
				match(LPAREN);
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(386);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(389);
					match(COMMA);
					}
				}

				setState(392);
				match(RPAREN);
				}
				break;
			case D_INCLUDE:
			case D_INCLUDE_IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
				_la = _input.LA(1);
				if ( !(_la==D_INCLUDE || _la==D_INCLUDE_IF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(394);
				match(LPAREN);
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(395);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(398);
					match(COMMA);
					}
				}

				setState(401);
				match(RPAREN);
				}
				break;
			case D_INCLUDE_WHEN:
			case D_INCLUDE_UNLESS:
				enterOuterAlt(_localctx, 4);
				{
				setState(402);
				_la = _input.LA(1);
				if ( !(_la==D_INCLUDE_WHEN || _la==D_INCLUDE_UNLESS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(403);
				match(LPAREN);
				setState(404);
				match(COMMA);
				setState(406);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(405);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(408);
					match(COMMA);
					}
				}

				setState(411);
				match(RPAREN);
				}
				break;
			case D_YIELD:
				enterOuterAlt(_localctx, 5);
				{
				setState(412);
				match(D_YIELD);
				setState(413);
				match(LPAREN);
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(414);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(417);
					match(COMMA);
					}
				}

				setState(420);
				match(RPAREN);
				}
				break;
			case D_STACK:
				enterOuterAlt(_localctx, 6);
				{
				setState(421);
				match(D_STACK);
				setState(422);
				match(LPAREN);
				setState(424);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(423);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(426);
				match(RPAREN);
				}
				break;
			case D_LANG:
				enterOuterAlt(_localctx, 7);
				{
				setState(427);
				match(D_LANG);
				setState(428);
				match(LPAREN);
				setState(430);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(429);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(432);
					match(COMMA);
					}
				}

				setState(435);
				match(RPAREN);
				}
				break;
			case D_INJECT:
				enterOuterAlt(_localctx, 8);
				{
				setState(436);
				match(D_INJECT);
				setState(437);
				match(LPAREN);
				setState(438);
				match(COMMA);
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(439);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(442);
				match(RPAREN);
				}
				break;
			case D_USE:
				enterOuterAlt(_localctx, 9);
				{
				setState(443);
				match(D_USE);
				setState(444);
				match(LPAREN);
				setState(446);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(445);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(448);
					match(COMMA);
					}
				}

				setState(451);
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
		public TerminalNode D_VITE() { return getToken(BladeAntlrParser.D_VITE, 0); }
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
			setState(495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EACH:
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				match(D_EACH);
				setState(455);
				match(LPAREN);
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(456);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(459);
				match(COMMA);
				setState(460);
				match(COMMA);
				setState(465);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(461);
					match(COMMA);
					setState(463);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIABLE_STRING) {
						{
						setState(462);
						match(IDENTIFIABLE_STRING);
						}
					}

					}
				}

				setState(467);
				match(RPAREN);
				}
				break;
			case D_INCLUDE_FIRST:
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
				match(D_INCLUDE_FIRST);
				setState(469);
				match(LPAREN);
				setState(473);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIABLE_STRING) {
					{
					{
					setState(470);
					match(IDENTIFIABLE_STRING);
					}
					}
					setState(475);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(476);
					match(COMMA);
					}
				}

				setState(479);
				match(RPAREN);
				}
				break;
			case D_VITE:
				enterOuterAlt(_localctx, 3);
				{
				setState(480);
				match(D_VITE);
				setState(481);
				match(LPAREN);
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(482);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(491);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(485);
					match(COMMA);
					setState(487);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIABLE_STRING) {
						{
						setState(486);
						match(IDENTIFIABLE_STRING);
						}
					}

					}
					}
					setState(493);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(494);
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
			setState(592);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(497);
				match(D_SECTION);
				setState(498);
				match(LPAREN);
				setState(500);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(499);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(502);
				match(RPAREN);
				setState(504);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_PARENT) {
					{
					setState(503);
					match(D_PARENT);
					}
				}

				setState(509);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(506);
					statement();
					}
					}
					setState(511);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(512);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8383776161792L) != 0)) ) {
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
				setState(513);
				match(D_HAS_SECTION);
				setState(514);
				match(LPAREN);
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(515);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(518);
				match(RPAREN);
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(519);
					statement();
					}
					}
					setState(524);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(525);
				match(D_ENDIF);
				}
				break;
			case D_SECTION_MISSING:
				enterOuterAlt(_localctx, 3);
				{
				setState(526);
				match(D_SECTION_MISSING);
				setState(527);
				match(LPAREN);
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(528);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(531);
				match(RPAREN);
				setState(535);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(532);
					statement();
					}
					}
					setState(537);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(538);
				match(D_ENDIF);
				}
				break;
			case D_PUSH:
				enterOuterAlt(_localctx, 4);
				{
				setState(539);
				match(D_PUSH);
				setState(540);
				match(LPAREN);
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(541);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(544);
				match(RPAREN);
				setState(548);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(545);
					statement();
					}
					}
					setState(550);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(551);
				match(D_ENDPUSH);
				}
				break;
			case D_PUSH_IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(552);
				match(D_PUSH_IF);
				setState(553);
				match(LPAREN);
				setState(555);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(554);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(557);
				match(COMMA);
				setState(558);
				match(RPAREN);
				setState(562);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(559);
					statement();
					}
					}
					setState(564);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(565);
				match(D_ENDPUSH_IF);
				}
				break;
			case D_PUSH_ONCE:
				enterOuterAlt(_localctx, 6);
				{
				setState(566);
				match(D_PUSH_ONCE);
				setState(567);
				match(LPAREN);
				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(568);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(571);
				match(RPAREN);
				setState(575);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(572);
					statement();
					}
					}
					setState(577);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(578);
				match(D_ENDPUSH_ONCE);
				}
				break;
			case D_PREPEND:
				enterOuterAlt(_localctx, 7);
				{
				setState(579);
				match(D_PREPEND);
				setState(580);
				match(LPAREN);
				setState(582);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(581);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(584);
				match(RPAREN);
				setState(588);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(585);
					statement();
					}
					}
					setState(590);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(591);
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
			setState(594);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8791261184L) != 0)) ) {
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
			setState(596);
			match(D_CUSTOM);
			setState(598);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(597);
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
			setState(600);
			_la = _input.LA(1);
			if ( !(_la==D_BREAK || _la==D_CONTINUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(602);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(601);
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
			int _alt;
			setState(629);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_ERROR:
				enterOuterAlt(_localctx, 1);
				{
				setState(604);
				match(D_ERROR);
				setState(605);
				match(LPAREN);
				setState(607);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(606);
					match(COMMA);
					}
				}

				setState(609);
				match(RPAREN);
				setState(613);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(610);
						statement();
						}
						} 
					}
					setState(615);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
				}
				setState(623);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(616);
					match(D_ELSE);
					setState(620);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
						{
						{
						setState(617);
						statement();
						}
						}
						setState(622);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(625);
				match(D_ENDERROR);
				}
				break;
			case D_CSRF:
				enterOuterAlt(_localctx, 2);
				{
				setState(626);
				match(D_CSRF);
				}
				break;
			case D_METHOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(627);
				match(D_METHOD);
				setState(628);
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
			int _alt;
			setState(680);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_AUTH:
				enterOuterAlt(_localctx, 1);
				{
				setState(631);
				match(D_AUTH);
				setState(633);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(632);
					directiveArguments();
					}
				}

				setState(638);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(635);
						statement();
						}
						} 
					}
					setState(640);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
				}
				setState(648);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE || _la==D_ELSEGUEST) {
					{
					setState(641);
					_la = _input.LA(1);
					if ( !(_la==D_ELSE || _la==D_ELSEGUEST) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(645);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
						{
						{
						setState(642);
						statement();
						}
						}
						setState(647);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(650);
				match(D_ENDAUTH);
				}
				break;
			case D_GUEST:
				enterOuterAlt(_localctx, 2);
				{
				setState(651);
				match(D_GUEST);
				setState(653);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(652);
					directiveArguments();
					}
				}

				setState(658);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(655);
					statement();
					}
					}
					setState(660);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(661);
				match(D_ENDGUEST);
				}
				break;
			case D_ENV:
				enterOuterAlt(_localctx, 3);
				{
				setState(662);
				match(D_ENV);
				setState(663);
				directiveArguments();
				setState(667);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(664);
					statement();
					}
					}
					setState(669);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(670);
				match(D_ENDENV);
				}
				break;
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(672);
				match(D_PRODUCTION);
				setState(676);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 14533974988245L) != 0)) {
					{
					{
					setState(673);
					statement();
					}
					}
					setState(678);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(679);
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
			setState(682);
			match(BLADE_CONTENT_OPEN_TAG);
			setState(683);
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
			setState(685);
			match(BLADE_RAW_OPEN_TAG);
			setState(686);
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
		public ForeachLoopArgumentsContext foreachLoopArguments() {
			return getRuleContext(ForeachLoopArgumentsContext.class,0);
		}
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
			setState(713);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EXTENDS:
			case D_INCLUDE:
			case D_YIELD:
				enterOuterAlt(_localctx, 1);
				{
				setState(688);
				directiveWithArg();
				setState(689);
				match(LPAREN);
				notifyErrorListeners("Missing closing ')'");
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(692);
				match(D_IF);
				setState(693);
				directiveArguments();
				notifyErrorListeners("Syntax error, expecting @elseif or @else or @endif");
				}
				break;
			case D_FOREACH:
			case D_FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(700);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case D_FOREACH:
					{
					setState(696);
					match(D_FOREACH);
					setState(697);
					foreachLoopArguments();
					}
					break;
				case D_FOR:
					{
					setState(698);
					match(D_FOR);
					setState(699);
					directiveArguments();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				notifyErrorListeners("Unclosed block directive");
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 4);
				{
				setState(704);
				match(D_VERBATIM);
				notifyErrorListeners("Unclosed verbatim block");
				}
				break;
			case D_SECTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(706);
				match(D_SECTION);
				setState(707);
				match(LPAREN);
				setState(709);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(708);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(711);
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
		public List<TerminalNode> COMMA() { return getTokens(BladeAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BladeAntlrParser.COMMA, i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(715);
			match(LPAREN);
			setState(719);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(716);
				match(COMMA);
				}
				}
				setState(721);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(722);
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
	public static class ForeachLoopArgumentsContext extends ParserRuleContext {
		public Token main_array;
		public Token array_item;
		public Token array_value;
		public TerminalNode LPAREN() { return getToken(BladeAntlrParser.LPAREN, 0); }
		public TerminalNode FOREACH_AS() { return getToken(BladeAntlrParser.FOREACH_AS, 0); }
		public TerminalNode RPAREN() { return getToken(BladeAntlrParser.RPAREN, 0); }
		public List<TerminalNode> FOREACH_VAR() { return getTokens(BladeAntlrParser.FOREACH_VAR); }
		public TerminalNode FOREACH_VAR(int i) {
			return getToken(BladeAntlrParser.FOREACH_VAR, i);
		}
		public TerminalNode FOREACH_DOUBLE_ARROW() { return getToken(BladeAntlrParser.FOREACH_DOUBLE_ARROW, 0); }
		public ForeachLoopArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachLoopArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterForeachLoopArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitForeachLoopArguments(this);
		}
	}

	public final ForeachLoopArgumentsContext foreachLoopArguments() throws RecognitionException {
		ForeachLoopArgumentsContext _localctx = new ForeachLoopArgumentsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_foreachLoopArguments);
		int _la;
		try {
			setState(757);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(724);
				match(LPAREN);
				setState(725);
				((ForeachLoopArgumentsContext)_localctx).main_array = match(FOREACH_VAR);
				setState(726);
				match(FOREACH_AS);
				setState(727);
				((ForeachLoopArgumentsContext)_localctx).array_item = match(FOREACH_VAR);
				setState(730);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOREACH_DOUBLE_ARROW) {
					{
					setState(728);
					match(FOREACH_DOUBLE_ARROW);
					setState(729);
					((ForeachLoopArgumentsContext)_localctx).array_value = match(FOREACH_VAR);
					}
				}

				setState(732);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(733);
				match(LPAREN);
				setState(737);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FOREACH_VAR) {
					{
					{
					setState(734);
					match(FOREACH_VAR);
					}
					}
					setState(739);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(740);
				match(FOREACH_AS);
				setState(744);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FOREACH_VAR) {
					{
					{
					setState(741);
					match(FOREACH_VAR);
					}
					}
					setState(746);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(754);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOREACH_DOUBLE_ARROW) {
					{
					setState(747);
					match(FOREACH_DOUBLE_ARROW);
					setState(751);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==FOREACH_VAR) {
						{
						{
						setState(748);
						match(FOREACH_VAR);
						}
						}
						setState(753);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(756);
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
		enterRule(_localctx, 50, RULE_phpInline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(759);
			match(PHP_INLINE_START);
			setState(760);
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

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlComponentOpenTagContext extends ParserRuleContext {
		public TerminalNode HTML_COMPONENT_OPEN_TAG() { return getToken(BladeAntlrParser.HTML_COMPONENT_OPEN_TAG, 0); }
		public HtmlComponentOpenTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlComponentOpenTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterHtmlComponentOpenTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitHtmlComponentOpenTag(this);
		}
	}

	public final HtmlComponentOpenTagContext htmlComponentOpenTag() throws RecognitionException {
		HtmlComponentOpenTagContext _localctx = new HtmlComponentOpenTagContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_htmlComponentOpenTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(762);
			match(HTML_COMPONENT_OPEN_TAG);
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
		"\u0004\u0001\u00aa\u02fd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0005"+
		"\u00008\b\u0000\n\u0000\f\u0000;\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001L\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002V\b"+
		"\u0002\n\u0002\f\u0002Y\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002b\b\u0002\u0001"+
		"\u0002\u0005\u0002e\b\u0002\n\u0002\f\u0002h\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002n\b\u0002\n\u0002\f\u0002q\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002x\b\u0002\n\u0002\f\u0002{\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0082\b\u0002\n\u0002\f\u0002"+
		"\u0085\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u008c\b\u0002\n\u0002\f\u0002\u008f\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0096\b\u0002\n"+
		"\u0002\f\u0002\u0099\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002\u009e\b\u0002\n\u0002\f\u0002\u00a1\t\u0002\u0005\u0002\u00a3\b"+
		"\u0002\n\u0002\f\u0002\u00a6\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u00aa\b\u0002\n\u0002\f\u0002\u00ad\t\u0002\u0003\u0002\u00af\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u00b6\b\u0002\n\u0002\f\u0002\u00b9\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u00be\b\u0002\n\u0002\f\u0002\u00c1\t\u0002\u0005\u0002"+
		"\u00c3\b\u0002\n\u0002\f\u0002\u00c6\t\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002\u00ca\b\u0002\n\u0002\f\u0002\u00cd\t\u0002\u0003\u0002\u00cf\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002\u00d6\b\u0002\n\u0002\f\u0002\u00d9\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002\u00de\b\u0002\n\u0002\f\u0002\u00e1\t\u0002\u0005"+
		"\u0002\u00e3\b\u0002\n\u0002\f\u0002\u00e6\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u00ea\b\u0002\n\u0002\f\u0002\u00ed\t\u0002\u0003\u0002\u00ef"+
		"\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u00f7\b\u0002\n\u0002\f\u0002\u00fa\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u0102\b\u0002\n\u0002\f\u0002\u0105\t\u0002\u0001\u0002\u0003\u0002\u0108"+
		"\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u010e"+
		"\b\u0003\n\u0003\f\u0003\u0111\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003\u0116\b\u0003\n\u0003\f\u0003\u0119\t\u0003\u0003\u0003\u011b"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u0123\b\u0004\n\u0004\f\u0004\u0126\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u012e\b\u0005\n\u0005\f\u0005\u0131\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0139\b\u0006\n"+
		"\u0006\f\u0006\u013c\t\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0140"+
		"\b\u0006\n\u0006\f\u0006\u0143\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u014d\b\b\n\b"+
		"\f\b\u0150\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0157\b"+
		"\t\n\t\f\t\u015a\t\t\u0001\t\u0003\t\u015d\b\t\u0005\t\u015f\b\t\n\t\f"+
		"\t\u0162\t\t\u0001\t\u0001\t\u0005\t\u0166\b\t\n\t\f\t\u0169\t\t\u0003"+
		"\t\u016b\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0178"+
		"\b\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u017d\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u0184\b\f\u0001\f\u0003\f\u0187\b\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u018d\b\f\u0001\f\u0003\f\u0190\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0197\b\f\u0001\f\u0003\f\u019a"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01a0\b\f\u0001\f\u0003\f"+
		"\u01a3\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01a9\b\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u01af\b\f\u0001\f\u0003\f\u01b2\b\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01b9\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u01bf\b\f\u0001\f\u0003\f\u01c2\b\f\u0001\f\u0003\f"+
		"\u01c5\b\f\u0001\r\u0001\r\u0001\r\u0003\r\u01ca\b\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u01d0\b\r\u0003\r\u01d2\b\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0005\r\u01d8\b\r\n\r\f\r\u01db\t\r\u0001\r\u0003\r\u01de\b\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u01e4\b\r\u0001\r\u0001\r\u0003"+
		"\r\u01e8\b\r\u0005\r\u01ea\b\r\n\r\f\r\u01ed\t\r\u0001\r\u0003\r\u01f0"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u01f5\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u01f9\b\u000e\u0001\u000e\u0005\u000e\u01fc"+
		"\b\u000e\n\u000e\f\u000e\u01ff\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u0205\b\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u0209\b\u000e\n\u000e\f\u000e\u020c\t\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u0212\b\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u0216\b\u000e\n\u000e\f\u000e\u0219\t\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u021f\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u0223\b\u000e\n\u000e\f\u000e\u0226\t\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u022c\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u0231\b\u000e\n\u000e\f\u000e\u0234\t\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u023a\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u023e\b\u000e\n\u000e\f\u000e\u0241"+
		"\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0247"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u024b\b\u000e\n\u000e\f\u000e"+
		"\u024e\t\u000e\u0001\u000e\u0003\u000e\u0251\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u0257\b\u0010\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u025b\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u0260\b\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0264\b\u0012"+
		"\n\u0012\f\u0012\u0267\t\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u026b"+
		"\b\u0012\n\u0012\f\u0012\u026e\t\u0012\u0003\u0012\u0270\b\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0276\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u027a\b\u0013\u0001\u0013\u0005\u0013\u027d"+
		"\b\u0013\n\u0013\f\u0013\u0280\t\u0013\u0001\u0013\u0001\u0013\u0005\u0013"+
		"\u0284\b\u0013\n\u0013\f\u0013\u0287\t\u0013\u0003\u0013\u0289\b\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u028e\b\u0013\u0001\u0013"+
		"\u0005\u0013\u0291\b\u0013\n\u0013\f\u0013\u0294\t\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u029a\b\u0013\n\u0013\f\u0013"+
		"\u029d\t\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013"+
		"\u02a3\b\u0013\n\u0013\f\u0013\u02a6\t\u0013\u0001\u0013\u0003\u0013\u02a9"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u02bd\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u02c6\b\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u02ca\b\u0016\u0001\u0017\u0001\u0017\u0005"+
		"\u0017\u02ce\b\u0017\n\u0017\f\u0017\u02d1\t\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u02db\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018"+
		"\u02e0\b\u0018\n\u0018\f\u0018\u02e3\t\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u02e7\b\u0018\n\u0018\f\u0018\u02ea\t\u0018\u0001\u0018\u0001\u0018"+
		"\u0005\u0018\u02ee\b\u0018\n\u0018\f\u0018\u02f1\t\u0018\u0003\u0018\u02f3"+
		"\b\u0018\u0001\u0018\u0003\u0018\u02f6\b\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0000\u0000\u001b\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.024\u0000\b\u0002\u0000\u0006\u0006ee\u0001\u0000\u001b"+
		"\u001c\u0001\u0000\u001d\u001e\u0002\u0000%%\'*\u0002\u0000\u001a\u001b"+
		"!!\u0001\u0000>?\u0002\u0000\u0010\u0010MM\u0002\u0000\u00a5\u00a5\u00a7"+
		"\u00a7\u0386\u00009\u0001\u0000\u0000\u0000\u0002K\u0001\u0000\u0000\u0000"+
		"\u0004\u0107\u0001\u0000\u0000\u0000\u0006\u0109\u0001\u0000\u0000\u0000"+
		"\b\u011e\u0001\u0000\u0000\u0000\n\u0129\u0001\u0000\u0000\u0000\f\u0134"+
		"\u0001\u0000\u0000\u0000\u000e\u0146\u0001\u0000\u0000\u0000\u0010\u0149"+
		"\u0001\u0000\u0000\u0000\u0012\u0151\u0001\u0000\u0000\u0000\u0014\u016e"+
		"\u0001\u0000\u0000\u0000\u0016\u0177\u0001\u0000\u0000\u0000\u0018\u01c4"+
		"\u0001\u0000\u0000\u0000\u001a\u01ef\u0001\u0000\u0000\u0000\u001c\u0250"+
		"\u0001\u0000\u0000\u0000\u001e\u0252\u0001\u0000\u0000\u0000 \u0254\u0001"+
		"\u0000\u0000\u0000\"\u0258\u0001\u0000\u0000\u0000$\u0275\u0001\u0000"+
		"\u0000\u0000&\u02a8\u0001\u0000\u0000\u0000(\u02aa\u0001\u0000\u0000\u0000"+
		"*\u02ad\u0001\u0000\u0000\u0000,\u02c9\u0001\u0000\u0000\u0000.\u02cb"+
		"\u0001\u0000\u0000\u00000\u02f5\u0001\u0000\u0000\u00002\u02f7\u0001\u0000"+
		"\u0000\u00004\u02fa\u0001\u0000\u0000\u000068\u0003\u0002\u0001\u0000"+
		"76\u0001\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000"+
		"\u00009:\u0001\u0000\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000"+
		"\u0000\u0000<=\u0005\u0000\u0000\u0001=\u0001\u0001\u0000\u0000\u0000"+
		">L\u0003\u001c\u000e\u0000?L\u0003\u0004\u0002\u0000@L\u0003\u0018\f\u0000"+
		"AL\u0003\u001a\r\u0000BL\u0003\u0016\u000b\u0000CL\u0003 \u0010\u0000"+
		"DL\u0003(\u0014\u0000EL\u0003*\u0015\u0000FL\u0007\u0000\u0000\u0000G"+
		"L\u0003,\u0016\u0000HL\u00032\u0019\u0000IL\u0005h\u0000\u0000JL\u0003"+
		"4\u001a\u0000K>\u0001\u0000\u0000\u0000K?\u0001\u0000\u0000\u0000K@\u0001"+
		"\u0000\u0000\u0000KA\u0001\u0000\u0000\u0000KB\u0001\u0000\u0000\u0000"+
		"KC\u0001\u0000\u0000\u0000KD\u0001\u0000\u0000\u0000KE\u0001\u0000\u0000"+
		"\u0000KF\u0001\u0000\u0000\u0000KG\u0001\u0000\u0000\u0000KH\u0001\u0000"+
		"\u0000\u0000KI\u0001\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000L\u0003"+
		"\u0001\u0000\u0000\u0000M\u0108\u0003\u0006\u0003\u0000N\u0108\u0003\b"+
		"\u0004\u0000O\u0108\u0003\n\u0005\u0000P\u0108\u0003\f\u0006\u0000QR\u0005"+
		"<\u0000\u0000RW\u0003.\u0017\u0000SV\u0003\u0002\u0001\u0000TV\u0003\""+
		"\u0011\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000VY\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z[\u0005=\u0000\u0000"+
		"[\u0108\u0001\u0000\u0000\u0000\\\u0108\u0003\u0012\t\u0000]\u0108\u0003"+
		"$\u0012\u0000^\u0108\u0003&\u0013\u0000_a\u0005+\u0000\u0000`b\u0003."+
		"\u0017\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bf\u0001"+
		"\u0000\u0000\u0000ce\u0003\u0002\u0001\u0000dc\u0001\u0000\u0000\u0000"+
		"eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000"+
		"\u0000gi\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000i\u0108\u0005"+
		",\u0000\u0000jk\u0005\u0012\u0000\u0000ko\u0003.\u0017\u0000ln\u0003\u0002"+
		"\u0001\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000"+
		"qo\u0001\u0000\u0000\u0000rs\u0005\u0013\u0000\u0000s\u0108\u0001\u0000"+
		"\u0000\u0000tu\u0005@\u0000\u0000uy\u0003.\u0017\u0000vx\u0003\u0002\u0001"+
		"\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|}\u0005A\u0000\u0000}\u0108\u0001\u0000\u0000\u0000"+
		"~\u007f\u0005\u0014\u0000\u0000\u007f\u0083\u0003.\u0017\u0000\u0080\u0082"+
		"\u0003\u0002\u0001\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0085"+
		"\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0001\u0000\u0000\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0083"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u0015\u0000\u0000\u0087\u0108"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0005D\u0000\u0000\u0089\u008d\u0003"+
		".\u0017\u0000\u008a\u008c\u0003\u0002\u0001\u0000\u008b\u008a\u0001\u0000"+
		"\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0090\u0001\u0000"+
		"\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0005E\u0000"+
		"\u0000\u0091\u0108\u0001\u0000\u0000\u0000\u0092\u0093\u0005S\u0000\u0000"+
		"\u0093\u0097\u0003.\u0017\u0000\u0094\u0096\u0003\u0002\u0001\u0000\u0095"+
		"\u0094\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097"+
		"\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098"+
		"\u00a4\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0005W\u0000\u0000\u009b\u009f\u0003.\u0017\u0000\u009c\u009e\u0003"+
		"\u0002\u0001\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u00a1\u0001"+
		"\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f\u0001"+
		"\u0000\u0000\u0000\u00a2\u009a\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00ae\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a7\u00ab\u0005\u0010\u0000\u0000\u00a8\u00aa\u0003"+
		"\u0002\u0001\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ad\u0001"+
		"\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ae\u00a7\u0001\u0000\u0000\u0000\u00ae\u00af\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005"+
		"T\u0000\u0000\u00b1\u0108\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005U\u0000"+
		"\u0000\u00b3\u00b7\u0003.\u0017\u0000\u00b4\u00b6\u0003\u0002\u0001\u0000"+
		"\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b8\u00c4\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0005W\u0000\u0000\u00bb\u00bf\u0003.\u0017\u0000\u00bc\u00be"+
		"\u0003\u0002\u0001\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u00c1"+
		"\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c2\u00ba\u0001\u0000\u0000\u0000\u00c3\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c5\u00ce\u0001\u0000\u0000\u0000\u00c6\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c7\u00cb\u0005\u0010\u0000\u0000\u00c8\u00ca"+
		"\u0003\u0002\u0001\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cd"+
		"\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc"+
		"\u0001\u0000\u0000\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb"+
		"\u0001\u0000\u0000\u0000\u00ce\u00c7\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d1"+
		"\u0005X\u0000\u0000\u00d1\u0108\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005"+
		"V\u0000\u0000\u00d3\u00d7\u0003.\u0017\u0000\u00d4\u00d6\u0003\u0002\u0001"+
		"\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000"+
		"\u0000\u00d8\u00e4\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000"+
		"\u0000\u00da\u00db\u0005W\u0000\u0000\u00db\u00df\u0003.\u0017\u0000\u00dc"+
		"\u00de\u0003\u0002\u0001\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de"+
		"\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1"+
		"\u00df\u0001\u0000\u0000\u0000\u00e2\u00da\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e5\u00ee\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e7\u00eb\u0005\u0010\u0000\u0000\u00e8"+
		"\u00ea\u0003\u0002\u0001\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00ea"+
		"\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ee\u00e7\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f1\u0005Y\u0000\u0000\u00f1\u0108\u0001\u0000\u0000\u0000\u00f2\u0108"+
		"\u0003\u0014\n\u0000\u00f3\u00f4\u0005Z\u0000\u0000\u00f4\u00f8\u0003"+
		".\u0017\u0000\u00f5\u00f7\u0003\u0002\u0001\u0000\u00f6\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005[\u0000"+
		"\u0000\u00fc\u0108\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005B\u0000\u0000"+
		"\u00fe\u0108\u0005C\u0000\u0000\u00ff\u0103\u0005\u0010\u0000\u0000\u0100"+
		"\u0102\u0003\u0002\u0001\u0000\u0101\u0100\u0001\u0000\u0000\u0000\u0102"+
		"\u0105\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0001\u0000\u0000\u0000\u0104\u0106\u0001\u0000\u0000\u0000\u0105"+
		"\u0103\u0001\u0000\u0000\u0000\u0106\u0108\u0005h\u0000\u0000\u0107M\u0001"+
		"\u0000\u0000\u0000\u0107N\u0001\u0000\u0000\u0000\u0107O\u0001\u0000\u0000"+
		"\u0000\u0107P\u0001\u0000\u0000\u0000\u0107Q\u0001\u0000\u0000\u0000\u0107"+
		"\\\u0001\u0000\u0000\u0000\u0107]\u0001\u0000\u0000\u0000\u0107^\u0001"+
		"\u0000\u0000\u0000\u0107_\u0001\u0000\u0000\u0000\u0107j\u0001\u0000\u0000"+
		"\u0000\u0107t\u0001\u0000\u0000\u0000\u0107~\u0001\u0000\u0000\u0000\u0107"+
		"\u0088\u0001\u0000\u0000\u0000\u0107\u0092\u0001\u0000\u0000\u0000\u0107"+
		"\u00b2\u0001\u0000\u0000\u0000\u0107\u00d2\u0001\u0000\u0000\u0000\u0107"+
		"\u00f2\u0001\u0000\u0000\u0000\u0107\u00f3\u0001\u0000\u0000\u0000\u0107"+
		"\u00fd\u0001\u0000\u0000\u0000\u0107\u00ff\u0001\u0000\u0000\u0000\u0108"+
		"\u0005\u0001\u0000\u0000\u0000\u0109\u010f\u0003\u000e\u0007\u0000\u010a"+
		"\u010e\u0003\u0010\b\u0000\u010b\u010e\u0003\u0002\u0001\u0000\u010c\u010e"+
		"\u0003\"\u0011\u0000\u010d\u010a\u0001\u0000\u0000\u0000\u010d\u010b\u0001"+
		"\u0000\u0000\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010e\u0111\u0001"+
		"\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u010f\u0110\u0001"+
		"\u0000\u0000\u0000\u0110\u011a\u0001\u0000\u0000\u0000\u0111\u010f\u0001"+
		"\u0000\u0000\u0000\u0112\u0117\u0005\u0010\u0000\u0000\u0113\u0116\u0003"+
		"\u0002\u0001\u0000\u0114\u0116\u0003\"\u0011\u0000\u0115\u0113\u0001\u0000"+
		"\u0000\u0000\u0115\u0114\u0001\u0000\u0000\u0000\u0116\u0119\u0001\u0000"+
		"\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000"+
		"\u0000\u0000\u0118\u011b\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000"+
		"\u0000\u0000\u011a\u0112\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000"+
		"\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c\u011d\u0005\u0011"+
		"\u0000\u0000\u011d\u0007\u0001\u0000\u0000\u0000\u011e\u011f\u00056\u0000"+
		"\u0000\u011f\u0124\u00030\u0018\u0000\u0120\u0123\u0003\u0002\u0001\u0000"+
		"\u0121\u0123\u0003\"\u0011\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0122"+
		"\u0121\u0001\u0000\u0000\u0000\u0123\u0126\u0001\u0000\u0000\u0000\u0124"+
		"\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125"+
		"\u0127\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0127"+
		"\u0128\u00057\u0000\u0000\u0128\t\u0001\u0000\u0000\u0000\u0129\u012a"+
		"\u00058\u0000\u0000\u012a\u012f\u0003.\u0017\u0000\u012b\u012e\u0003\u0002"+
		"\u0001\u0000\u012c\u012e\u0003\"\u0011\u0000\u012d\u012b\u0001\u0000\u0000"+
		"\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012e\u0131\u0001\u0000\u0000"+
		"\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000"+
		"\u0000\u0130\u0132\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000"+
		"\u0000\u0132\u0133\u00059\u0000\u0000\u0133\u000b\u0001\u0000\u0000\u0000"+
		"\u0134\u0135\u0005:\u0000\u0000\u0135\u013a\u0003.\u0017\u0000\u0136\u0139"+
		"\u0003\u0002\u0001\u0000\u0137\u0139\u0003\"\u0011\u0000\u0138\u0136\u0001"+
		"\u0000\u0000\u0000\u0138\u0137\u0001\u0000\u0000\u0000\u0139\u013c\u0001"+
		"\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013a\u013b\u0001"+
		"\u0000\u0000\u0000\u013b\u013d\u0001\u0000\u0000\u0000\u013c\u013a\u0001"+
		"\u0000\u0000\u0000\u013d\u0141\u0005@\u0000\u0000\u013e\u0140\u0003\u0002"+
		"\u0001\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u0140\u0143\u0001\u0000"+
		"\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000"+
		"\u0000\u0000\u0142\u0144\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000"+
		"\u0000\u0000\u0144\u0145\u0005;\u0000\u0000\u0145\r\u0001\u0000\u0000"+
		"\u0000\u0146\u0147\u0005\u000e\u0000\u0000\u0147\u0148\u0003.\u0017\u0000"+
		"\u0148\u000f\u0001\u0000\u0000\u0000\u0149\u014a\u0005\u000f\u0000\u0000"+
		"\u014a\u014e\u0003.\u0017\u0000\u014b\u014d\u0003\u0002\u0001\u0000\u014c"+
		"\u014b\u0001\u0000\u0000\u0000\u014d\u0150\u0001\u0000\u0000\u0000\u014e"+
		"\u014c\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f"+
		"\u0011\u0001\u0000\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0151"+
		"\u0152\u0005\u0016\u0000\u0000\u0152\u0160\u0003.\u0017\u0000\u0153\u0154"+
		"\u0005\u0017\u0000\u0000\u0154\u0158\u0003.\u0017\u0000\u0155\u0157\u0003"+
		"\u0002\u0001\u0000\u0156\u0155\u0001\u0000\u0000\u0000\u0157\u015a\u0001"+
		"\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001"+
		"\u0000\u0000\u0000\u0159\u015c\u0001\u0000\u0000\u0000\u015a\u0158\u0001"+
		"\u0000\u0000\u0000\u015b\u015d\u0005>\u0000\u0000\u015c\u015b\u0001\u0000"+
		"\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015f\u0001\u0000"+
		"\u0000\u0000\u015e\u0153\u0001\u0000\u0000\u0000\u015f\u0162\u0001\u0000"+
		"\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000"+
		"\u0000\u0000\u0161\u016a\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000"+
		"\u0000\u0000\u0163\u0167\u0005\u0018\u0000\u0000\u0164\u0166\u0003\u0002"+
		"\u0001\u0000\u0165\u0164\u0001\u0000\u0000\u0000\u0166\u0169\u0001\u0000"+
		"\u0000\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000"+
		"\u0000\u0000\u0168\u016b\u0001\u0000\u0000\u0000\u0169\u0167\u0001\u0000"+
		"\u0000\u0000\u016a\u0163\u0001\u0000\u0000\u0000\u016a\u016b\u0001\u0000"+
		"\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u016d\u0005\u0019"+
		"\u0000\u0000\u016d\u0013\u0001\u0000\u0000\u0000\u016e\u016f\u0005\u000b"+
		"\u0000\u0000\u016f\u0170\u0005\u00a2\u0000\u0000\u0170\u0015\u0001\u0000"+
		"\u0000\u0000\u0171\u0172\u0005\\\u0000\u0000\u0172\u0178\u0003.\u0017"+
		"\u0000\u0173\u0174\u0005\u000b\u0000\u0000\u0174\u0178\u0003.\u0017\u0000"+
		"\u0175\u0178\u0005\u0004\u0000\u0000\u0176\u0178\u0005^\u0000\u0000\u0177"+
		"\u0171\u0001\u0000\u0000\u0000\u0177\u0173\u0001\u0000\u0000\u0000\u0177"+
		"\u0175\u0001\u0000\u0000\u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0178"+
		"\u0017\u0001\u0000\u0000\u0000\u0179\u017a\u0005\"\u0000\u0000\u017a\u017c"+
		"\u0005\u0001\u0000\u0000\u017b\u017d\u0005\u0005\u0000\u0000\u017c\u017b"+
		"\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000\u0000\u017d\u017e"+
		"\u0001\u0000\u0000\u0000\u017e\u017f\u0005\f\u0000\u0000\u017f\u01c5\u0005"+
		"\u0002\u0000\u0000\u0180\u0181\u0005\u001a\u0000\u0000\u0181\u0183\u0005"+
		"\u0001\u0000\u0000\u0182\u0184\u0005\u0005\u0000\u0000\u0183\u0182\u0001"+
		"\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184\u0186\u0001"+
		"\u0000\u0000\u0000\u0185\u0187\u0005\f\u0000\u0000\u0186\u0185\u0001\u0000"+
		"\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u0188\u0001\u0000"+
		"\u0000\u0000\u0188\u01c5\u0005\u0002\u0000\u0000\u0189\u018a\u0007\u0001"+
		"\u0000\u0000\u018a\u018c\u0005\u0001\u0000\u0000\u018b\u018d\u0005\u0005"+
		"\u0000\u0000\u018c\u018b\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000"+
		"\u0000\u0000\u018d\u018f\u0001\u0000\u0000\u0000\u018e\u0190\u0005\f\u0000"+
		"\u0000\u018f\u018e\u0001\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000"+
		"\u0000\u0190\u0191\u0001\u0000\u0000\u0000\u0191\u01c5\u0005\u0002\u0000"+
		"\u0000\u0192\u0193\u0007\u0002\u0000\u0000\u0193\u0194\u0005\u0001\u0000"+
		"\u0000\u0194\u0196\u0005\f\u0000\u0000\u0195\u0197\u0005\u0005\u0000\u0000"+
		"\u0196\u0195\u0001\u0000\u0000\u0000\u0196\u0197\u0001\u0000\u0000\u0000"+
		"\u0197\u0199\u0001\u0000\u0000\u0000\u0198\u019a\u0005\f\u0000\u0000\u0199"+
		"\u0198\u0001\u0000\u0000\u0000\u0199\u019a\u0001\u0000\u0000\u0000\u019a"+
		"\u019b\u0001\u0000\u0000\u0000\u019b\u01c5\u0005\u0002\u0000\u0000\u019c"+
		"\u019d\u0005!\u0000\u0000\u019d\u019f\u0005\u0001\u0000\u0000\u019e\u01a0"+
		"\u0005\u0005\u0000\u0000\u019f\u019e\u0001\u0000\u0000\u0000\u019f\u01a0"+
		"\u0001\u0000\u0000\u0000\u01a0\u01a2\u0001\u0000\u0000\u0000\u01a1\u01a3"+
		"\u0005\f\u0000\u0000\u01a2\u01a1\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001"+
		"\u0000\u0000\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4\u01c5\u0005"+
		"\u0002\u0000\u0000\u01a5\u01a6\u0005-\u0000\u0000\u01a6\u01a8\u0005\u0001"+
		"\u0000\u0000\u01a7\u01a9\u0005\u0005\u0000\u0000\u01a8\u01a7\u0001\u0000"+
		"\u0000\u0000\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000"+
		"\u0000\u0000\u01aa\u01c5\u0005\u0002\u0000\u0000\u01ab\u01ac\u0005_\u0000"+
		"\u0000\u01ac\u01ae\u0005\u0001\u0000\u0000\u01ad\u01af\u0005\u0005\u0000"+
		"\u0000\u01ae\u01ad\u0001\u0000\u0000\u0000\u01ae\u01af\u0001\u0000\u0000"+
		"\u0000\u01af\u01b1\u0001\u0000\u0000\u0000\u01b0\u01b2\u0005\f\u0000\u0000"+
		"\u01b1\u01b0\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000"+
		"\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3\u01c5\u0005\u0002\u0000\u0000"+
		"\u01b4\u01b5\u0005`\u0000\u0000\u01b5\u01b6\u0005\u0001\u0000\u0000\u01b6"+
		"\u01b8\u0005\f\u0000\u0000\u01b7\u01b9\u0005\u0005\u0000\u0000\u01b8\u01b7"+
		"\u0001\u0000\u0000\u0000\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01ba"+
		"\u0001\u0000\u0000\u0000\u01ba\u01c5\u0005\u0002\u0000\u0000\u01bb\u01bc"+
		"\u0005a\u0000\u0000\u01bc\u01be\u0005\u0001\u0000\u0000\u01bd\u01bf\u0005"+
		"\u0005\u0000\u0000\u01be\u01bd\u0001\u0000\u0000\u0000\u01be\u01bf\u0001"+
		"\u0000\u0000\u0000\u01bf\u01c1\u0001\u0000\u0000\u0000\u01c0\u01c2\u0005"+
		"\f\u0000\u0000\u01c1\u01c0\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000"+
		"\u0000\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c5\u0005\u0002"+
		"\u0000\u0000\u01c4\u0179\u0001\u0000\u0000\u0000\u01c4\u0180\u0001\u0000"+
		"\u0000\u0000\u01c4\u0189\u0001\u0000\u0000\u0000\u01c4\u0192\u0001\u0000"+
		"\u0000\u0000\u01c4\u019c\u0001\u0000\u0000\u0000\u01c4\u01a5\u0001\u0000"+
		"\u0000\u0000\u01c4\u01ab\u0001\u0000\u0000\u0000\u01c4\u01b4\u0001\u0000"+
		"\u0000\u0000\u01c4\u01bb\u0001\u0000\u0000\u0000\u01c5\u0019\u0001\u0000"+
		"\u0000\u0000\u01c6\u01c7\u0005 \u0000\u0000\u01c7\u01c9\u0005\u0001\u0000"+
		"\u0000\u01c8\u01ca\u0005\u0005\u0000\u0000\u01c9\u01c8\u0001\u0000\u0000"+
		"\u0000\u01c9\u01ca\u0001\u0000\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000"+
		"\u0000\u01cb\u01cc\u0005\f\u0000\u0000\u01cc\u01d1\u0005\f\u0000\u0000"+
		"\u01cd\u01cf\u0005\f\u0000\u0000\u01ce\u01d0\u0005\u0005\u0000\u0000\u01cf"+
		"\u01ce\u0001\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0"+
		"\u01d2\u0001\u0000\u0000\u0000\u01d1\u01cd\u0001\u0000\u0000\u0000\u01d1"+
		"\u01d2\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3"+
		"\u01f0\u0005\u0002\u0000\u0000\u01d4\u01d5\u0005\u001f\u0000\u0000\u01d5"+
		"\u01d9\u0005\u0001\u0000\u0000\u01d6\u01d8\u0005\u0005\u0000\u0000\u01d7"+
		"\u01d6\u0001\u0000\u0000\u0000\u01d8\u01db\u0001\u0000\u0000\u0000\u01d9"+
		"\u01d7\u0001\u0000\u0000\u0000\u01d9\u01da\u0001\u0000\u0000\u0000\u01da"+
		"\u01dd\u0001\u0000\u0000\u0000\u01db\u01d9\u0001\u0000\u0000\u0000\u01dc"+
		"\u01de\u0005\f\u0000\u0000\u01dd\u01dc\u0001\u0000\u0000\u0000\u01dd\u01de"+
		"\u0001\u0000\u0000\u0000\u01de\u01df\u0001\u0000\u0000\u0000\u01df\u01f0"+
		"\u0005\u0002\u0000\u0000\u01e0\u01e1\u0005]\u0000\u0000\u01e1\u01e3\u0005"+
		"\u0001\u0000\u0000\u01e2\u01e4\u0005\u0005\u0000\u0000\u01e3\u01e2\u0001"+
		"\u0000\u0000\u0000\u01e3\u01e4\u0001\u0000\u0000\u0000\u01e4\u01eb\u0001"+
		"\u0000\u0000\u0000\u01e5\u01e7\u0005\f\u0000\u0000\u01e6\u01e8\u0005\u0005"+
		"\u0000\u0000\u01e7\u01e6\u0001\u0000\u0000\u0000\u01e7\u01e8\u0001\u0000"+
		"\u0000\u0000\u01e8\u01ea\u0001\u0000\u0000\u0000\u01e9\u01e5\u0001\u0000"+
		"\u0000\u0000\u01ea\u01ed\u0001\u0000\u0000\u0000\u01eb\u01e9\u0001\u0000"+
		"\u0000\u0000\u01eb\u01ec\u0001\u0000\u0000\u0000\u01ec\u01ee\u0001\u0000"+
		"\u0000\u0000\u01ed\u01eb\u0001\u0000\u0000\u0000\u01ee\u01f0\u0005\u0002"+
		"\u0000\u0000\u01ef\u01c6\u0001\u0000\u0000\u0000\u01ef\u01d4\u0001\u0000"+
		"\u0000\u0000\u01ef\u01e0\u0001\u0000\u0000\u0000\u01f0\u001b\u0001\u0000"+
		"\u0000\u0000\u01f1\u01f2\u0005\"\u0000\u0000\u01f2\u01f4\u0005\u0001\u0000"+
		"\u0000\u01f3\u01f5\u0005\u0005\u0000\u0000\u01f4\u01f3\u0001\u0000\u0000"+
		"\u0000\u01f4\u01f5\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000"+
		"\u0000\u01f6\u01f8\u0005\u0002\u0000\u0000\u01f7\u01f9\u0005&\u0000\u0000"+
		"\u01f8\u01f7\u0001\u0000\u0000\u0000\u01f8\u01f9\u0001\u0000\u0000\u0000"+
		"\u01f9\u01fd\u0001\u0000\u0000\u0000\u01fa\u01fc\u0003\u0002\u0001\u0000"+
		"\u01fb\u01fa\u0001\u0000\u0000\u0000\u01fc\u01ff\u0001\u0000\u0000\u0000"+
		"\u01fd\u01fb\u0001\u0000\u0000\u0000\u01fd\u01fe\u0001\u0000\u0000\u0000"+
		"\u01fe\u0200\u0001\u0000\u0000\u0000\u01ff\u01fd\u0001\u0000\u0000\u0000"+
		"\u0200\u0251\u0007\u0003\u0000\u0000\u0201\u0202\u0005#\u0000\u0000\u0202"+
		"\u0204\u0005\u0001\u0000\u0000\u0203\u0205\u0005\u0005\u0000\u0000\u0204"+
		"\u0203\u0001\u0000\u0000\u0000\u0204\u0205\u0001\u0000\u0000\u0000\u0205"+
		"\u0206\u0001\u0000\u0000\u0000\u0206\u020a\u0005\u0002\u0000\u0000\u0207"+
		"\u0209\u0003\u0002\u0001\u0000\u0208\u0207\u0001\u0000\u0000\u0000\u0209"+
		"\u020c\u0001\u0000\u0000\u0000\u020a\u0208\u0001\u0000\u0000\u0000\u020a"+
		"\u020b\u0001\u0000\u0000\u0000\u020b\u020d\u0001\u0000\u0000\u0000\u020c"+
		"\u020a\u0001\u0000\u0000\u0000\u020d\u0251\u0005\u0011\u0000\u0000\u020e"+
		"\u020f\u0005$\u0000\u0000\u020f\u0211\u0005\u0001\u0000\u0000\u0210\u0212"+
		"\u0005\u0005\u0000\u0000\u0211\u0210\u0001\u0000\u0000\u0000\u0211\u0212"+
		"\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000\u0000\u0000\u0213\u0217"+
		"\u0005\u0002\u0000\u0000\u0214\u0216\u0003\u0002\u0001\u0000\u0215\u0214"+
		"\u0001\u0000\u0000\u0000\u0216\u0219\u0001\u0000\u0000\u0000\u0217\u0215"+
		"\u0001\u0000\u0000\u0000\u0217\u0218\u0001\u0000\u0000\u0000\u0218\u021a"+
		"\u0001\u0000\u0000\u0000\u0219\u0217\u0001\u0000\u0000\u0000\u021a\u0251"+
		"\u0005\u0011\u0000\u0000\u021b\u021c\u0005.\u0000\u0000\u021c\u021e\u0005"+
		"\u0001\u0000\u0000\u021d\u021f\u0005\u0005\u0000\u0000\u021e\u021d\u0001"+
		"\u0000\u0000\u0000\u021e\u021f\u0001\u0000\u0000\u0000\u021f\u0220\u0001"+
		"\u0000\u0000\u0000\u0220\u0224\u0005\u0002\u0000\u0000\u0221\u0223\u0003"+
		"\u0002\u0001\u0000\u0222\u0221\u0001\u0000\u0000\u0000\u0223\u0226\u0001"+
		"\u0000\u0000\u0000\u0224\u0222\u0001\u0000\u0000\u0000\u0224\u0225\u0001"+
		"\u0000\u0000\u0000\u0225\u0227\u0001\u0000\u0000\u0000\u0226\u0224\u0001"+
		"\u0000\u0000\u0000\u0227\u0251\u0005/\u0000\u0000\u0228\u0229\u00050\u0000"+
		"\u0000\u0229\u022b\u0005\u0001\u0000\u0000\u022a\u022c\u0005\u0005\u0000"+
		"\u0000\u022b\u022a\u0001\u0000\u0000\u0000\u022b\u022c\u0001\u0000\u0000"+
		"\u0000\u022c\u022d\u0001\u0000\u0000\u0000\u022d\u022e\u0005\f\u0000\u0000"+
		"\u022e\u0232\u0005\u0002\u0000\u0000\u022f\u0231\u0003\u0002\u0001\u0000"+
		"\u0230\u022f\u0001\u0000\u0000\u0000\u0231\u0234\u0001\u0000\u0000\u0000"+
		"\u0232\u0230\u0001\u0000\u0000\u0000\u0232\u0233\u0001\u0000\u0000\u0000"+
		"\u0233\u0235\u0001\u0000\u0000\u0000\u0234\u0232\u0001\u0000\u0000\u0000"+
		"\u0235\u0251\u00051\u0000\u0000\u0236\u0237\u00052\u0000\u0000\u0237\u0239"+
		"\u0005\u0001\u0000\u0000\u0238\u023a\u0005\u0005\u0000\u0000\u0239\u0238"+
		"\u0001\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000\u0000\u023a\u023b"+
		"\u0001\u0000\u0000\u0000\u023b\u023f\u0005\u0002\u0000\u0000\u023c\u023e"+
		"\u0003\u0002\u0001\u0000\u023d\u023c\u0001\u0000\u0000\u0000\u023e\u0241"+
		"\u0001\u0000\u0000\u0000\u023f\u023d\u0001\u0000\u0000\u0000\u023f\u0240"+
		"\u0001\u0000\u0000\u0000\u0240\u0242\u0001\u0000\u0000\u0000\u0241\u023f"+
		"\u0001\u0000\u0000\u0000\u0242\u0251\u00053\u0000\u0000\u0243\u0244\u0005"+
		"4\u0000\u0000\u0244\u0246\u0005\u0001\u0000\u0000\u0245\u0247\u0005\u0005"+
		"\u0000\u0000\u0246\u0245\u0001\u0000\u0000\u0000\u0246\u0247\u0001\u0000"+
		"\u0000\u0000\u0247\u0248\u0001\u0000\u0000\u0000\u0248\u024c\u0005\u0002"+
		"\u0000\u0000\u0249\u024b\u0003\u0002\u0001\u0000\u024a\u0249\u0001\u0000"+
		"\u0000\u0000\u024b\u024e\u0001\u0000\u0000\u0000\u024c\u024a\u0001\u0000"+
		"\u0000\u0000\u024c\u024d\u0001\u0000\u0000\u0000\u024d\u024f\u0001\u0000"+
		"\u0000\u0000\u024e\u024c\u0001\u0000\u0000\u0000\u024f\u0251\u00055\u0000"+
		"\u0000\u0250\u01f1\u0001\u0000\u0000\u0000\u0250\u0201\u0001\u0000\u0000"+
		"\u0000\u0250\u020e\u0001\u0000\u0000\u0000\u0250\u021b\u0001\u0000\u0000"+
		"\u0000\u0250\u0228\u0001\u0000\u0000\u0000\u0250\u0236\u0001\u0000\u0000"+
		"\u0000\u0250\u0243\u0001\u0000\u0000\u0000\u0251\u001d\u0001\u0000\u0000"+
		"\u0000\u0252\u0253\u0007\u0004\u0000\u0000\u0253\u001f\u0001\u0000\u0000"+
		"\u0000\u0254\u0256\u0005\u0003\u0000\u0000\u0255\u0257\u0003.\u0017\u0000"+
		"\u0256\u0255\u0001\u0000\u0000\u0000\u0256\u0257\u0001\u0000\u0000\u0000"+
		"\u0257!\u0001\u0000\u0000\u0000\u0258\u025a\u0007\u0005\u0000\u0000\u0259"+
		"\u025b\u0003.\u0017\u0000\u025a\u0259\u0001\u0000\u0000\u0000\u025a\u025b"+
		"\u0001\u0000\u0000\u0000\u025b#\u0001\u0000\u0000\u0000\u025c\u025d\u0005"+
		"H\u0000\u0000\u025d\u025f\u0005\u0001\u0000\u0000\u025e\u0260\u0005\f"+
		"\u0000\u0000\u025f\u025e\u0001\u0000\u0000\u0000\u025f\u0260\u0001\u0000"+
		"\u0000\u0000\u0260\u0261\u0001\u0000\u0000\u0000\u0261\u0265\u0005\u0002"+
		"\u0000\u0000\u0262\u0264\u0003\u0002\u0001\u0000\u0263\u0262\u0001\u0000"+
		"\u0000\u0000\u0264\u0267\u0001\u0000\u0000\u0000\u0265\u0263\u0001\u0000"+
		"\u0000\u0000\u0265\u0266\u0001\u0000\u0000\u0000\u0266\u026f\u0001\u0000"+
		"\u0000\u0000\u0267\u0265\u0001\u0000\u0000\u0000\u0268\u026c\u0005\u0010"+
		"\u0000\u0000\u0269\u026b\u0003\u0002\u0001\u0000\u026a\u0269\u0001\u0000"+
		"\u0000\u0000\u026b\u026e\u0001\u0000\u0000\u0000\u026c\u026a\u0001\u0000"+
		"\u0000\u0000\u026c\u026d\u0001\u0000\u0000\u0000\u026d\u0270\u0001\u0000"+
		"\u0000\u0000\u026e\u026c\u0001\u0000\u0000\u0000\u026f\u0268\u0001\u0000"+
		"\u0000\u0000\u026f\u0270\u0001\u0000\u0000\u0000\u0270\u0271\u0001\u0000"+
		"\u0000\u0000\u0271\u0276\u0005I\u0000\u0000\u0272\u0276\u0005F\u0000\u0000"+
		"\u0273\u0274\u0005G\u0000\u0000\u0274\u0276\u0003.\u0017\u0000\u0275\u025c"+
		"\u0001\u0000\u0000\u0000\u0275\u0272\u0001\u0000\u0000\u0000\u0275\u0273"+
		"\u0001\u0000\u0000\u0000\u0276%\u0001\u0000\u0000\u0000\u0277\u0279\u0005"+
		"J\u0000\u0000\u0278\u027a\u0003.\u0017\u0000\u0279\u0278\u0001\u0000\u0000"+
		"\u0000\u0279\u027a\u0001\u0000\u0000\u0000\u027a\u027e\u0001\u0000\u0000"+
		"\u0000\u027b\u027d\u0003\u0002\u0001\u0000\u027c\u027b\u0001\u0000\u0000"+
		"\u0000\u027d\u0280\u0001\u0000\u0000\u0000\u027e\u027c\u0001\u0000\u0000"+
		"\u0000\u027e\u027f\u0001\u0000\u0000\u0000\u027f\u0288\u0001\u0000\u0000"+
		"\u0000\u0280\u027e\u0001\u0000\u0000\u0000\u0281\u0285\u0007\u0006\u0000"+
		"\u0000\u0282\u0284\u0003\u0002\u0001\u0000\u0283\u0282\u0001\u0000\u0000"+
		"\u0000\u0284\u0287\u0001\u0000\u0000\u0000\u0285\u0283\u0001\u0000\u0000"+
		"\u0000\u0285\u0286\u0001\u0000\u0000\u0000\u0286\u0289\u0001\u0000\u0000"+
		"\u0000\u0287\u0285\u0001\u0000\u0000\u0000\u0288\u0281\u0001\u0000\u0000"+
		"\u0000\u0288\u0289\u0001\u0000\u0000\u0000\u0289\u028a\u0001\u0000\u0000"+
		"\u0000\u028a\u02a9\u0005K\u0000\u0000\u028b\u028d\u0005L\u0000\u0000\u028c"+
		"\u028e\u0003.\u0017\u0000\u028d\u028c\u0001\u0000\u0000\u0000\u028d\u028e"+
		"\u0001\u0000\u0000\u0000\u028e\u0292\u0001\u0000\u0000\u0000\u028f\u0291"+
		"\u0003\u0002\u0001\u0000\u0290\u028f\u0001\u0000\u0000\u0000\u0291\u0294"+
		"\u0001\u0000\u0000\u0000\u0292\u0290\u0001\u0000\u0000\u0000\u0292\u0293"+
		"\u0001\u0000\u0000\u0000\u0293\u0295\u0001\u0000\u0000\u0000\u0294\u0292"+
		"\u0001\u0000\u0000\u0000\u0295\u02a9\u0005N\u0000\u0000\u0296\u0297\u0005"+
		"O\u0000\u0000\u0297\u029b\u0003.\u0017\u0000\u0298\u029a\u0003\u0002\u0001"+
		"\u0000\u0299\u0298\u0001\u0000\u0000\u0000\u029a\u029d\u0001\u0000\u0000"+
		"\u0000\u029b\u0299\u0001\u0000\u0000\u0000\u029b\u029c\u0001\u0000\u0000"+
		"\u0000\u029c\u029e\u0001\u0000\u0000\u0000\u029d\u029b\u0001\u0000\u0000"+
		"\u0000\u029e\u029f\u0005P\u0000\u0000\u029f\u02a9\u0001\u0000\u0000\u0000"+
		"\u02a0\u02a4\u0005Q\u0000\u0000\u02a1\u02a3\u0003\u0002\u0001\u0000\u02a2"+
		"\u02a1\u0001\u0000\u0000\u0000\u02a3\u02a6\u0001\u0000\u0000\u0000\u02a4"+
		"\u02a2\u0001\u0000\u0000\u0000\u02a4\u02a5\u0001\u0000\u0000\u0000\u02a5"+
		"\u02a7\u0001\u0000\u0000\u0000\u02a6\u02a4\u0001\u0000\u0000\u0000\u02a7"+
		"\u02a9\u0005R\u0000\u0000\u02a8\u0277\u0001\u0000\u0000\u0000\u02a8\u028b"+
		"\u0001\u0000\u0000\u0000\u02a8\u0296\u0001\u0000\u0000\u0000\u02a8\u02a0"+
		"\u0001\u0000\u0000\u0000\u02a9\'\u0001\u0000\u0000\u0000\u02aa\u02ab\u0005"+
		"b\u0000\u0000\u02ab\u02ac\u0005\u0006\u0000\u0000\u02ac)\u0001\u0000\u0000"+
		"\u0000\u02ad\u02ae\u0005d\u0000\u0000\u02ae\u02af\u0005e\u0000\u0000\u02af"+
		"+\u0001\u0000\u0000\u0000\u02b0\u02b1\u0003\u001e\u000f\u0000\u02b1\u02b2"+
		"\u0005\u0001\u0000\u0000\u02b2\u02b3\u0006\u0016\uffff\uffff\u0000\u02b3"+
		"\u02ca\u0001\u0000\u0000\u0000\u02b4\u02b5\u0005\u000e\u0000\u0000\u02b5"+
		"\u02b6\u0003.\u0017\u0000\u02b6\u02b7\u0006\u0016\uffff\uffff\u0000\u02b7"+
		"\u02ca\u0001\u0000\u0000\u0000\u02b8\u02b9\u00056\u0000\u0000\u02b9\u02bd"+
		"\u00030\u0018\u0000\u02ba\u02bb\u00058\u0000\u0000\u02bb\u02bd\u0003."+
		"\u0017\u0000\u02bc\u02b8\u0001\u0000\u0000\u0000\u02bc\u02ba\u0001\u0000"+
		"\u0000\u0000\u02bd\u02be\u0001\u0000\u0000\u0000\u02be\u02bf\u0006\u0016"+
		"\uffff\uffff\u0000\u02bf\u02ca\u0001\u0000\u0000\u0000\u02c0\u02c1\u0005"+
		"B\u0000\u0000\u02c1\u02ca\u0006\u0016\uffff\uffff\u0000\u02c2\u02c3\u0005"+
		"\"\u0000\u0000\u02c3\u02c5\u0005\u0001\u0000\u0000\u02c4\u02c6\u0005\u0005"+
		"\u0000\u0000\u02c5\u02c4\u0001\u0000\u0000\u0000\u02c5\u02c6\u0001\u0000"+
		"\u0000\u0000\u02c6\u02c7\u0001\u0000\u0000\u0000\u02c7\u02c8\u0005\u0002"+
		"\u0000\u0000\u02c8\u02ca\u0006\u0016\uffff\uffff\u0000\u02c9\u02b0\u0001"+
		"\u0000\u0000\u0000\u02c9\u02b4\u0001\u0000\u0000\u0000\u02c9\u02bc\u0001"+
		"\u0000\u0000\u0000\u02c9\u02c0\u0001\u0000\u0000\u0000\u02c9\u02c2\u0001"+
		"\u0000\u0000\u0000\u02ca-\u0001\u0000\u0000\u0000\u02cb\u02cf\u0005\u0001"+
		"\u0000\u0000\u02cc\u02ce\u0005\f\u0000\u0000\u02cd\u02cc\u0001\u0000\u0000"+
		"\u0000\u02ce\u02d1\u0001\u0000\u0000\u0000\u02cf\u02cd\u0001\u0000\u0000"+
		"\u0000\u02cf\u02d0\u0001\u0000\u0000\u0000\u02d0\u02d2\u0001\u0000\u0000"+
		"\u0000\u02d1\u02cf\u0001\u0000\u0000\u0000\u02d2\u02d3\u0005\u0002\u0000"+
		"\u0000\u02d3/\u0001\u0000\u0000\u0000\u02d4\u02d5\u0005\u0001\u0000\u0000"+
		"\u02d5\u02d6\u0005\u009e\u0000\u0000\u02d6\u02d7\u0005\u009f\u0000\u0000"+
		"\u02d7\u02da\u0005\u009e\u0000\u0000\u02d8\u02d9\u0005\u00a0\u0000\u0000"+
		"\u02d9\u02db\u0005\u009e\u0000\u0000\u02da\u02d8\u0001\u0000\u0000\u0000"+
		"\u02da\u02db\u0001\u0000\u0000\u0000\u02db\u02dc\u0001\u0000\u0000\u0000"+
		"\u02dc\u02f6\u0005\u0002\u0000\u0000\u02dd\u02e1\u0005\u0001\u0000\u0000"+
		"\u02de\u02e0\u0005\u009e\u0000\u0000\u02df\u02de\u0001\u0000\u0000\u0000"+
		"\u02e0\u02e3\u0001\u0000\u0000\u0000\u02e1\u02df\u0001\u0000\u0000\u0000"+
		"\u02e1\u02e2\u0001\u0000\u0000\u0000\u02e2\u02e4\u0001\u0000\u0000\u0000"+
		"\u02e3\u02e1\u0001\u0000\u0000\u0000\u02e4\u02e8\u0005\u009f\u0000\u0000"+
		"\u02e5\u02e7\u0005\u009e\u0000\u0000\u02e6\u02e5\u0001\u0000\u0000\u0000"+
		"\u02e7\u02ea\u0001\u0000\u0000\u0000\u02e8\u02e6\u0001\u0000\u0000\u0000"+
		"\u02e8\u02e9\u0001\u0000\u0000\u0000\u02e9\u02f2\u0001\u0000\u0000\u0000"+
		"\u02ea\u02e8\u0001\u0000\u0000\u0000\u02eb\u02ef\u0005\u00a0\u0000\u0000"+
		"\u02ec\u02ee\u0005\u009e\u0000\u0000\u02ed\u02ec\u0001\u0000\u0000\u0000"+
		"\u02ee\u02f1\u0001\u0000\u0000\u0000\u02ef\u02ed\u0001\u0000\u0000\u0000"+
		"\u02ef\u02f0\u0001\u0000\u0000\u0000\u02f0\u02f3\u0001\u0000\u0000\u0000"+
		"\u02f1\u02ef\u0001\u0000\u0000\u0000\u02f2\u02eb\u0001\u0000\u0000\u0000"+
		"\u02f2\u02f3\u0001\u0000\u0000\u0000\u02f3\u02f4\u0001\u0000\u0000\u0000"+
		"\u02f4\u02f6\u0005\u0002\u0000\u0000\u02f5\u02d4\u0001\u0000\u0000\u0000"+
		"\u02f5\u02dd\u0001\u0000\u0000\u0000\u02f61\u0001\u0000\u0000\u0000\u02f7"+
		"\u02f8\u0005j\u0000\u0000\u02f8\u02f9\u0007\u0007\u0000\u0000\u02f93\u0001"+
		"\u0000\u0000\u0000\u02fa\u02fb\u0005k\u0000\u0000\u02fb5\u0001\u0000\u0000"+
		"\u0000r9KUWafoy\u0083\u008d\u0097\u009f\u00a4\u00ab\u00ae\u00b7\u00bf"+
		"\u00c4\u00cb\u00ce\u00d7\u00df\u00e4\u00eb\u00ee\u00f8\u0103\u0107\u010d"+
		"\u010f\u0115\u0117\u011a\u0122\u0124\u012d\u012f\u0138\u013a\u0141\u014e"+
		"\u0158\u015c\u0160\u0167\u016a\u0177\u017c\u0183\u0186\u018c\u018f\u0196"+
		"\u0199\u019f\u01a2\u01a8\u01ae\u01b1\u01b8\u01be\u01c1\u01c4\u01c9\u01cf"+
		"\u01d1\u01d9\u01dd\u01e3\u01e7\u01eb\u01ef\u01f4\u01f8\u01fd\u0204\u020a"+
		"\u0211\u0217\u021e\u0224\u022b\u0232\u0239\u023f\u0246\u024c\u0250\u0256"+
		"\u025a\u025f\u0265\u026c\u026f\u0275\u0279\u027e\u0285\u0288\u028d\u0292"+
		"\u029b\u02a4\u02a8\u02bc\u02c5\u02c9\u02cf\u02da\u02e1\u02e8\u02ef\u02f2"+
		"\u02f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}