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
		D_INCLUDE_UNLESS=29, D_INCLUDE_FIRST=30, D_EACH=31, D_YIELD=32, D_SECTION=33, 
		D_HAS_SECTION=34, D_SECTION_MISSING=35, D_ENDSECTION=36, D_PARENT=37, 
		D_SHOW=38, D_OVERWRITE=39, D_STOP=40, D_APPEND=41, D_ONCE=42, D_ENDONCE=43, 
		D_STACK=44, D_PUSH=45, D_ENDPUSH=46, D_PUSH_IF=47, D_ENDPUSH_IF=48, D_PUSH_ONCE=49, 
		D_ENDPUSH_ONCE=50, D_PREPEND=51, D_ENDPREPEND=52, D_FOREACH=53, D_ENDFOREACH=54, 
		D_FOR=55, D_ENDFOR=56, D_FORELSE=57, D_ENDFORELSE=58, D_WHILE=59, D_ENDWHILE=60, 
		D_BREAK=61, D_CONTINUE=62, D_EMPTY=63, D_ENDEMPTY=64, D_VERBATIM=65, D_ENDVERBATIM=66, 
		D_SESSION=67, D_ENDSESSION=68, D_CSRF=69, D_METHOD=70, D_ERROR=71, D_ENDERROR=72, 
		D_AUTH=73, D_ENDAUTH=74, D_GUEST=75, D_ELSEGUEST=76, D_ENDGUEST=77, D_ENV=78, 
		D_ENDENV=79, D_PRODUCTION=80, D_ENDPRODUCTION=81, D_FRAGMENT=82, D_ENDFRAGMENT=83, 
		D_SIMPLE_DIRECTIVE=84, D_VITE=85, D_VITE_REFRESH=86, D_LANG=87, D_INJECT=88, 
		D_USE=89, BLADE_CONTENT_OPEN_TAG=90, BLADE_TAG_ESCAPE=91, BLADE_RAW_OPEN_TAG=92, 
		BLADE_RAW_CLOSE_TAG=93, D_CSS_AT=94, D_CSS_AT2=95, D_ENDCUSTOM=96, AT=97, 
		PHP_INLINE_START=98, HTML_COMPONENT_OPEN_TAG=99, WS=100, OTHER=101, BLADE_COMMENT_START=102, 
		EMAIL_SUBSTRING=103, VERSION_WITH_AT=104, D_ESCAPES=105, E_LPAREN=106, 
		E_RPAREN=107, E_LSQUAREBRACKET=108, E_RSQUAREBRACKET=109, E_LCURLYBRACE=110, 
		E_RCURLYBRACE=111, E_OTHER=112, EI_LPAREN=113, EI_RPAREN=114, EI_OTHER=115, 
		ESPOS_LPAREN=116, ESPOS_RPAREN=117, ESPOS_LSQUAREBRACKET=118, ESPOS_RSQUAREBRACKET=119, 
		ESPOS_LCURLYBRACE=120, ESPOS_RCURLYBRACE=121, ESPOS_OTHER=122, EACH_LPAREN=123, 
		EACH_RPAREN=124, EACH_LSQUAREBRACKET=125, EACH_RSQUAREBRACKET=126, EACH_LCURLYBRACE=127, 
		EACH_RCURLYBRACE=128, EACH_OTHER=129, INCF_LPAREN=130, INCF_RPAREN=131, 
		INCF_LSQUAREBRACKET=132, INCF_RSQUAREBRACKET=133, INCF_LCURLYBRACE=134, 
		INCF_RCURLYBRACE=135, INCF_OTHER=136, MIXED_S_A_LPAREN=137, MIXED_S_A_RPAREN=138, 
		MIXED_S_A_LSQUAREBRACKET=139, MIXED_S_A_RSQUAREBRACKET=140, MIXED_S_A_LCURLYBRACE=141, 
		MIXED_S_A_RCURLYBRACE=142, MIXED_S_A_OTHER=143, FOREACH_LPAREN=144, FOREACH_RPAREN=145, 
		FOREACH_LSQUAREBRACKET=146, FOREACH_RSQUAREBRACKET=147, FOREACH_LCURLYBRACE=148, 
		FOREACH_RCURLYBRACE=149, FOREACH_VAR=150, FOREACH_AS=151, FOREACH_DOUBLE_ARROW=152, 
		FOREACH_OTHER=153, D_ENDPHP=154, BLADE_INLINE_PHP_OTHER=155, VERBATIM_HTML=156, 
		PHP_INLINE_EXIT=157, PHP_INLINE_OTHER=158, PHP_INLINE_EOF=159, BLADE_COMMENT_END=160, 
		BLADE_COMMENT_MORE=161, BLADE_COMMENT_EOF=162;
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
			null, "'('", "')'", null, null, "'}}'", "'['", "']'", null, null, null, 
			"','", null, null, null, "'@else'", "'@endif'", null, "'@endunless'", 
			null, "'@endisset'", null, null, "'@default'", "'@endswitch'", null, 
			null, null, null, null, null, null, null, null, null, null, "'@endsection'", 
			"'@parent'", "'@show'", "'@overwrite'", "'@stop'", "'@append'", "'@once'", 
			"'@endonce'", null, null, "'@endpush'", null, "'@endPushIf'", null, "'@endPushOnce'", 
			null, "'@endprepend'", null, "'@endforeach'", null, "'@endfor'", null, 
			"'@endforelse'", null, "'@endwhile'", null, null, null, "'@endempty'", 
			"'@verbatim'", "'@endverbatim'", null, "'@endsession'", "'@csrf'", null, 
			null, "'@enderror'", null, "'@endauth'", null, "'@elseguest'", "'@endguest'", 
			null, "'@endenv'", "'@production'", "'@endproduction'", null, "'@endfragment'", 
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
			null, "LPAREN", "RPAREN", "D_CUSTOM", "IDENTIFIABLE_STRING", "BLADE_CONTENT_CLOSE_TAG", 
			"LSQUAREBRACKET", "RSQUAREBRACKET", "LCURLYBRACE", "RCURLYBRACE", "D_PHP", 
			"COMMA", "ERROR", "D_IF", "D_ELSEIF", "D_ELSE", "D_ENDIF", "D_UNLESS", 
			"D_ENDUNLESS", "D_ISSET", "D_ENDISSET", "D_SWITCH", "D_CASE", "D_DEFAULT", 
			"D_ENDSWITCH", "D_EXTENDS", "D_INCLUDE", "D_INCLUDE_IF", "D_INCLUDE_WHEN", 
			"D_INCLUDE_UNLESS", "D_INCLUDE_FIRST", "D_EACH", "D_YIELD", "D_SECTION", 
			"D_HAS_SECTION", "D_SECTION_MISSING", "D_ENDSECTION", "D_PARENT", "D_SHOW", 
			"D_OVERWRITE", "D_STOP", "D_APPEND", "D_ONCE", "D_ENDONCE", "D_STACK", 
			"D_PUSH", "D_ENDPUSH", "D_PUSH_IF", "D_ENDPUSH_IF", "D_PUSH_ONCE", "D_ENDPUSH_ONCE", 
			"D_PREPEND", "D_ENDPREPEND", "D_FOREACH", "D_ENDFOREACH", "D_FOR", "D_ENDFOR", 
			"D_FORELSE", "D_ENDFORELSE", "D_WHILE", "D_ENDWHILE", "D_BREAK", "D_CONTINUE", 
			"D_EMPTY", "D_ENDEMPTY", "D_VERBATIM", "D_ENDVERBATIM", "D_SESSION", 
			"D_ENDSESSION", "D_CSRF", "D_METHOD", "D_ERROR", "D_ENDERROR", "D_AUTH", 
			"D_ENDAUTH", "D_GUEST", "D_ELSEGUEST", "D_ENDGUEST", "D_ENV", "D_ENDENV", 
			"D_PRODUCTION", "D_ENDPRODUCTION", "D_FRAGMENT", "D_ENDFRAGMENT", "D_SIMPLE_DIRECTIVE", 
			"D_VITE", "D_VITE_REFRESH", "D_LANG", "D_INJECT", "D_USE", "BLADE_CONTENT_OPEN_TAG", 
			"BLADE_TAG_ESCAPE", "BLADE_RAW_OPEN_TAG", "BLADE_RAW_CLOSE_TAG", "D_CSS_AT", 
			"D_CSS_AT2", "D_ENDCUSTOM", "AT", "PHP_INLINE_START", "HTML_COMPONENT_OPEN_TAG", 
			"WS", "OTHER", "BLADE_COMMENT_START", "EMAIL_SUBSTRING", "VERSION_WITH_AT", 
			"D_ESCAPES", "E_LPAREN", "E_RPAREN", "E_LSQUAREBRACKET", "E_RSQUAREBRACKET", 
			"E_LCURLYBRACE", "E_RCURLYBRACE", "E_OTHER", "EI_LPAREN", "EI_RPAREN", 
			"EI_OTHER", "ESPOS_LPAREN", "ESPOS_RPAREN", "ESPOS_LSQUAREBRACKET", "ESPOS_RSQUAREBRACKET", 
			"ESPOS_LCURLYBRACE", "ESPOS_RCURLYBRACE", "ESPOS_OTHER", "EACH_LPAREN", 
			"EACH_RPAREN", "EACH_LSQUAREBRACKET", "EACH_RSQUAREBRACKET", "EACH_LCURLYBRACE", 
			"EACH_RCURLYBRACE", "EACH_OTHER", "INCF_LPAREN", "INCF_RPAREN", "INCF_LSQUAREBRACKET", 
			"INCF_RSQUAREBRACKET", "INCF_LCURLYBRACE", "INCF_RCURLYBRACE", "INCF_OTHER", 
			"MIXED_S_A_LPAREN", "MIXED_S_A_RPAREN", "MIXED_S_A_LSQUAREBRACKET", "MIXED_S_A_RSQUAREBRACKET", 
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
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
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
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
			setState(167);
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1537218342011886552L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
					{
					setState(85);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_CUSTOM:
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
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
			case D_PHP:
				enterOuterAlt(_localctx, 14);
				{
				setState(146);
				bladePhpBlock();
				}
				break;
			case D_FRAGMENT:
				enterOuterAlt(_localctx, 15);
				{
				setState(147);
				match(D_FRAGMENT);
				setState(148);
				directiveArguments();
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
					{
					{
					setState(149);
					statement();
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(155);
				match(D_ENDFRAGMENT);
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 16);
				{
				setState(157);
				match(D_VERBATIM);
				setState(158);
				match(D_ENDVERBATIM);
				}
				break;
			case D_ELSE:
				enterOuterAlt(_localctx, 17);
				{
				setState(159);
				match(D_ELSE);
				setState(163);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(160);
						statement();
						}
						} 
					}
					setState(165);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(166);
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
			setState(169);
			ifStartStatement();
			setState(175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(173);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_ELSEIF:
						{
						setState(170);
						elseifStatement();
						}
						break;
					case D_CUSTOM:
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
						setState(171);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(172);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_ELSE) {
				{
				setState(178);
				match(D_ELSE);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1537218342011886552L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
					{
					setState(181);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_CUSTOM:
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
						setState(179);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(180);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(188);
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
			setState(190);
			match(D_FOREACH);
			setState(191);
			foreachLoopArguments();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1537218342011886552L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
				{
				setState(194);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case D_CUSTOM:
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
					setState(192);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(193);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(199);
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
			setState(201);
			match(D_FOR);
			setState(202);
			directiveArguments();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1537218342011886552L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
				{
				setState(205);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case D_CUSTOM:
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
					setState(203);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(204);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
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
			setState(212);
			match(D_FORELSE);
			setState(213);
			directiveArguments();
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(216);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_CUSTOM:
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
						setState(214);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(215);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(221);
			match(D_EMPTY);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
				{
				{
				setState(222);
				statement();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228);
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
			setState(230);
			match(D_IF);
			setState(231);
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
			setState(233);
			match(D_ELSEIF);
			setState(234);
			directiveArguments();
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(235);
					statement();
					}
					} 
				}
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
			setState(241);
			match(D_SWITCH);
			setState(242);
			directiveArguments();
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==D_CASE) {
				{
				{
				setState(243);
				match(D_CASE);
				setState(244);
				directiveArguments();
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
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
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_BREAK) {
					{
					setState(251);
					match(D_BREAK);
					}
				}

				}
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_DEFAULT) {
				{
				setState(259);
				match(D_DEFAULT);
				setState(260);
				directiveArguments();
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
					{
					{
					setState(261);
					statement();
					}
					}
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(269);
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
			setState(271);
			match(D_PHP);
			setState(272);
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
			setState(279);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SIMPLE_DIRECTIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				match(D_SIMPLE_DIRECTIVE);
				setState(275);
				directiveArguments();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				match(D_PHP);
				setState(277);
				directiveArguments();
				}
				break;
			case D_VITE_REFRESH:
				enterOuterAlt(_localctx, 3);
				{
				setState(278);
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
			setState(356);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				match(D_SECTION);
				setState(282);
				match(LPAREN);
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(283);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(286);
				match(COMMA);
				setState(287);
				match(RPAREN);
				}
				break;
			case D_EXTENDS:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				match(D_EXTENDS);
				setState(289);
				match(LPAREN);
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(290);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(293);
					match(COMMA);
					}
				}

				setState(296);
				match(RPAREN);
				}
				break;
			case D_INCLUDE:
			case D_INCLUDE_IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(297);
				_la = _input.LA(1);
				if ( !(_la==D_INCLUDE || _la==D_INCLUDE_IF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(298);
				match(LPAREN);
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(299);
					match(IDENTIFIABLE_STRING);
					}
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
				match(RPAREN);
				}
				break;
			case D_INCLUDE_WHEN:
			case D_INCLUDE_UNLESS:
				enterOuterAlt(_localctx, 4);
				{
				setState(306);
				_la = _input.LA(1);
				if ( !(_la==D_INCLUDE_WHEN || _la==D_INCLUDE_UNLESS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(307);
				match(LPAREN);
				setState(308);
				match(COMMA);
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
			case D_YIELD:
				enterOuterAlt(_localctx, 5);
				{
				setState(316);
				match(D_YIELD);
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
			case D_STACK:
				enterOuterAlt(_localctx, 6);
				{
				setState(325);
				match(D_STACK);
				setState(326);
				match(LPAREN);
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(327);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(330);
				match(RPAREN);
				}
				break;
			case D_LANG:
				enterOuterAlt(_localctx, 7);
				{
				setState(331);
				match(D_LANG);
				setState(332);
				match(LPAREN);
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(333);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(336);
					match(COMMA);
					}
				}

				setState(339);
				match(RPAREN);
				}
				break;
			case D_INJECT:
				enterOuterAlt(_localctx, 8);
				{
				setState(340);
				match(D_INJECT);
				setState(341);
				match(LPAREN);
				setState(342);
				match(COMMA);
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(343);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(346);
				match(RPAREN);
				}
				break;
			case D_USE:
				enterOuterAlt(_localctx, 9);
				{
				setState(347);
				match(D_USE);
				setState(348);
				match(LPAREN);
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(349);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(352);
					match(COMMA);
					}
				}

				setState(355);
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
			setState(399);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EACH:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				match(D_EACH);
				setState(359);
				match(LPAREN);
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(360);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(363);
				match(COMMA);
				setState(364);
				match(COMMA);
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(365);
					match(COMMA);
					setState(367);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIABLE_STRING) {
						{
						setState(366);
						match(IDENTIFIABLE_STRING);
						}
					}

					}
				}

				setState(371);
				match(RPAREN);
				}
				break;
			case D_INCLUDE_FIRST:
				enterOuterAlt(_localctx, 2);
				{
				setState(372);
				match(D_INCLUDE_FIRST);
				setState(373);
				match(LPAREN);
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIABLE_STRING) {
					{
					{
					setState(374);
					match(IDENTIFIABLE_STRING);
					}
					}
					setState(379);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(380);
					match(COMMA);
					}
				}

				setState(383);
				match(RPAREN);
				}
				break;
			case D_VITE:
				enterOuterAlt(_localctx, 3);
				{
				setState(384);
				match(D_VITE);
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

				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(389);
					match(COMMA);
					setState(391);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIABLE_STRING) {
						{
						setState(390);
						match(IDENTIFIABLE_STRING);
						}
					}

					}
					}
					setState(397);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(398);
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
			setState(496);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				match(D_SECTION);
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
				match(RPAREN);
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_PARENT) {
					{
					setState(407);
					match(D_PARENT);
					}
				}

				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
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
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4191888080896L) != 0)) ) {
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
				setState(417);
				match(D_HAS_SECTION);
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
				match(RPAREN);
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
					{
					{
					setState(423);
					statement();
					}
					}
					setState(428);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(429);
				match(D_ENDIF);
				}
				break;
			case D_SECTION_MISSING:
				enterOuterAlt(_localctx, 3);
				{
				setState(430);
				match(D_SECTION_MISSING);
				setState(431);
				match(LPAREN);
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(432);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(435);
				match(RPAREN);
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
					{
					{
					setState(436);
					statement();
					}
					}
					setState(441);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(442);
				match(D_ENDIF);
				}
				break;
			case D_PUSH:
				enterOuterAlt(_localctx, 4);
				{
				setState(443);
				match(D_PUSH);
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

				setState(448);
				match(RPAREN);
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
					{
					{
					setState(449);
					statement();
					}
					}
					setState(454);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(455);
				match(D_ENDPUSH);
				}
				break;
			case D_PUSH_IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(456);
				match(D_PUSH_IF);
				setState(457);
				match(LPAREN);
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(458);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(461);
				match(COMMA);
				setState(462);
				match(RPAREN);
				setState(466);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
					{
					{
					setState(463);
					statement();
					}
					}
					setState(468);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(469);
				match(D_ENDPUSH_IF);
				}
				break;
			case D_PUSH_ONCE:
				enterOuterAlt(_localctx, 6);
				{
				setState(470);
				match(D_PUSH_ONCE);
				setState(471);
				match(LPAREN);
				setState(473);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(472);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(475);
				match(RPAREN);
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
					{
					{
					setState(476);
					statement();
					}
					}
					setState(481);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(482);
				match(D_ENDPUSH_ONCE);
				}
				break;
			case D_PREPEND:
				enterOuterAlt(_localctx, 7);
				{
				setState(483);
				match(D_PREPEND);
				setState(484);
				match(LPAREN);
				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(485);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(488);
				match(RPAREN);
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
					{
					{
					setState(489);
					statement();
					}
					}
					setState(494);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(495);
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
			setState(498);
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
			setState(500);
			match(D_CUSTOM);
			setState(502);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(501);
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
			setState(504);
			_la = _input.LA(1);
			if ( !(_la==D_BREAK || _la==D_CONTINUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(505);
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
			setState(533);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_ERROR:
				enterOuterAlt(_localctx, 1);
				{
				setState(508);
				match(D_ERROR);
				setState(509);
				match(LPAREN);
				setState(511);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(510);
					match(COMMA);
					}
				}

				setState(513);
				match(RPAREN);
				setState(517);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(514);
						statement();
						}
						} 
					}
					setState(519);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				}
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(520);
					match(D_ELSE);
					setState(524);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
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
					}
				}

				setState(529);
				match(D_ENDERROR);
				}
				break;
			case D_CSRF:
				enterOuterAlt(_localctx, 2);
				{
				setState(530);
				match(D_CSRF);
				}
				break;
			case D_METHOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(531);
				match(D_METHOD);
				setState(532);
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
			setState(584);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_AUTH:
				enterOuterAlt(_localctx, 1);
				{
				setState(535);
				match(D_AUTH);
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(536);
					directiveArguments();
					}
				}

				setState(542);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(539);
						statement();
						}
						} 
					}
					setState(544);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
				}
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE || _la==D_ELSEGUEST) {
					{
					setState(545);
					_la = _input.LA(1);
					if ( !(_la==D_ELSE || _la==D_ELSEGUEST) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(549);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
						{
						{
						setState(546);
						statement();
						}
						}
						setState(551);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(554);
				match(D_ENDAUTH);
				}
				break;
			case D_GUEST:
				enterOuterAlt(_localctx, 2);
				{
				setState(555);
				match(D_GUEST);
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(556);
					directiveArguments();
					}
				}

				setState(562);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
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
				match(D_ENDGUEST);
				}
				break;
			case D_ENV:
				enterOuterAlt(_localctx, 3);
				{
				setState(566);
				match(D_ENV);
				setState(567);
				directiveArguments();
				setState(571);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
					{
					{
					setState(568);
					statement();
					}
					}
					setState(573);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(574);
				match(D_ENDENV);
				}
				break;
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(576);
				match(D_PRODUCTION);
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8454747369652968408L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 28386698613L) != 0)) {
					{
					{
					setState(577);
					statement();
					}
					}
					setState(582);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(583);
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
			setState(586);
			match(BLADE_CONTENT_OPEN_TAG);
			setState(587);
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
			setState(589);
			match(BLADE_RAW_OPEN_TAG);
			setState(590);
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
			setState(617);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EXTENDS:
			case D_INCLUDE:
			case D_YIELD:
				enterOuterAlt(_localctx, 1);
				{
				setState(592);
				directiveWithArg();
				setState(593);
				match(LPAREN);
				notifyErrorListeners("Missing closing ')'");
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(596);
				match(D_IF);
				setState(597);
				directiveArguments();
				notifyErrorListeners("Syntax error, expecting @elseif or @else or @endif");
				}
				break;
			case D_FOREACH:
			case D_FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(604);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case D_FOREACH:
					{
					setState(600);
					match(D_FOREACH);
					setState(601);
					foreachLoopArguments();
					}
					break;
				case D_FOR:
					{
					setState(602);
					match(D_FOR);
					setState(603);
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
				setState(608);
				match(D_VERBATIM);
				notifyErrorListeners("Unclosed verbatim block");
				}
				break;
			case D_SECTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(610);
				match(D_SECTION);
				setState(611);
				match(LPAREN);
				setState(613);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(612);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(615);
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
			setState(619);
			match(LPAREN);
			setState(620);
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
			setState(655);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(622);
				match(LPAREN);
				setState(623);
				((ForeachLoopArgumentsContext)_localctx).main_array = match(FOREACH_VAR);
				setState(624);
				match(FOREACH_AS);
				setState(625);
				((ForeachLoopArgumentsContext)_localctx).array_item = match(FOREACH_VAR);
				setState(628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOREACH_DOUBLE_ARROW) {
					{
					setState(626);
					match(FOREACH_DOUBLE_ARROW);
					setState(627);
					((ForeachLoopArgumentsContext)_localctx).array_value = match(FOREACH_VAR);
					}
				}

				setState(630);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(631);
				match(LPAREN);
				setState(635);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FOREACH_VAR) {
					{
					{
					setState(632);
					match(FOREACH_VAR);
					}
					}
					setState(637);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(638);
				match(FOREACH_AS);
				setState(642);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FOREACH_VAR) {
					{
					{
					setState(639);
					match(FOREACH_VAR);
					}
					}
					setState(644);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(652);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOREACH_DOUBLE_ARROW) {
					{
					setState(645);
					match(FOREACH_DOUBLE_ARROW);
					setState(649);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==FOREACH_VAR) {
						{
						{
						setState(646);
						match(FOREACH_VAR);
						}
						}
						setState(651);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(654);
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
			setState(657);
			match(PHP_INLINE_START);
			setState(658);
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
			setState(660);
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
		"\u0004\u0001\u00a2\u0297\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0097"+
		"\b\u0002\n\u0002\f\u0002\u009a\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00a2\b\u0002\n\u0002"+
		"\f\u0002\u00a5\t\u0002\u0001\u0002\u0003\u0002\u00a8\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u00ae\b\u0003\n\u0003"+
		"\f\u0003\u00b1\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"\u00b6\b\u0003\n\u0003\f\u0003\u00b9\t\u0003\u0003\u0003\u00bb\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004\u00c3\b\u0004\n\u0004\f\u0004\u00c6\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00ce"+
		"\b\u0005\n\u0005\f\u0005\u00d1\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00d9\b\u0006\n\u0006"+
		"\f\u0006\u00dc\t\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00e0\b\u0006"+
		"\n\u0006\f\u0006\u00e3\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u00ed\b\b\n\b\f\b\u00f0"+
		"\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00f7\b\t\n\t\f\t"+
		"\u00fa\t\t\u0001\t\u0003\t\u00fd\b\t\u0005\t\u00ff\b\t\n\t\f\t\u0102\t"+
		"\t\u0001\t\u0001\t\u0001\t\u0005\t\u0107\b\t\n\t\f\t\u010a\t\t\u0003\t"+
		"\u010c\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0118\b\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0003\f\u011d\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u0124\b\f\u0001\f\u0003\f\u0127\b\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0003\f\u012d\b\f\u0001\f\u0003\f\u0130\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u0137\b\f\u0001\f\u0003\f\u013a\b\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u0140\b\f\u0001\f\u0003\f\u0143\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u0149\b\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u014f\b\f\u0001\f\u0003\f\u0152\b\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0003\f\u0159\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u015f\b\f\u0001\f\u0003\f\u0162\b\f\u0001\f\u0003\f\u0165\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u016a\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u0170\b\r\u0003\r\u0172\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r"+
		"\u0178\b\r\n\r\f\r\u017b\t\r\u0001\r\u0003\r\u017e\b\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0003\r\u0184\b\r\u0001\r\u0001\r\u0003\r\u0188\b\r\u0005"+
		"\r\u018a\b\r\n\r\f\r\u018d\t\r\u0001\r\u0003\r\u0190\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u0195\b\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0199\b\u000e\u0001\u000e\u0005\u000e\u019c\b\u000e\n\u000e\f\u000e"+
		"\u019f\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u01a5\b\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u01a9\b\u000e\n\u000e"+
		"\f\u000e\u01ac\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u01b2\b\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u01b6\b"+
		"\u000e\n\u000e\f\u000e\u01b9\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u01bf\b\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u01c3\b\u000e\n\u000e\f\u000e\u01c6\t\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u01cc\b\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u01d1\b\u000e\n\u000e\f\u000e\u01d4\t\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u01da\b\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u01de\b\u000e\n\u000e\f\u000e\u01e1\t\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u01e7\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u01eb\b\u000e\n\u000e\f\u000e\u01ee\t\u000e"+
		"\u0001\u000e\u0003\u000e\u01f1\b\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u01f7\b\u0010\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u01fb\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0200\b"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0204\b\u0012\n\u0012\f\u0012"+
		"\u0207\t\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u020b\b\u0012\n\u0012"+
		"\f\u0012\u020e\t\u0012\u0003\u0012\u0210\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u0216\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u021a\b\u0013\u0001\u0013\u0005\u0013\u021d\b\u0013\n\u0013"+
		"\f\u0013\u0220\t\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0224\b\u0013"+
		"\n\u0013\f\u0013\u0227\t\u0013\u0003\u0013\u0229\b\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u022e\b\u0013\u0001\u0013\u0005\u0013\u0231"+
		"\b\u0013\n\u0013\f\u0013\u0234\t\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u023a\b\u0013\n\u0013\f\u0013\u023d\t\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0243\b\u0013\n"+
		"\u0013\f\u0013\u0246\t\u0013\u0001\u0013\u0003\u0013\u0249\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u025d\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0266\b\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u026a\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u0275\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u027a"+
		"\b\u0018\n\u0018\f\u0018\u027d\t\u0018\u0001\u0018\u0001\u0018\u0005\u0018"+
		"\u0281\b\u0018\n\u0018\f\u0018\u0284\t\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u0288\b\u0018\n\u0018\f\u0018\u028b\t\u0018\u0003\u0018\u028d\b"+
		"\u0018\u0001\u0018\u0003\u0018\u0290\b\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0000\u0000\u001b\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.024\u0000\b\u0002\u0000\u0005\u0005]]\u0001\u0000\u001a\u001b"+
		"\u0001\u0000\u001c\u001d\u0002\u0000$$&)\u0002\u0000\u0019\u001a  \u0001"+
		"\u0000=>\u0002\u0000\u000f\u000fLL\u0002\u0000\u009d\u009d\u009f\u009f"+
		"\u030c\u00009\u0001\u0000\u0000\u0000\u0002K\u0001\u0000\u0000\u0000\u0004"+
		"\u00a7\u0001\u0000\u0000\u0000\u0006\u00a9\u0001\u0000\u0000\u0000\b\u00be"+
		"\u0001\u0000\u0000\u0000\n\u00c9\u0001\u0000\u0000\u0000\f\u00d4\u0001"+
		"\u0000\u0000\u0000\u000e\u00e6\u0001\u0000\u0000\u0000\u0010\u00e9\u0001"+
		"\u0000\u0000\u0000\u0012\u00f1\u0001\u0000\u0000\u0000\u0014\u010f\u0001"+
		"\u0000\u0000\u0000\u0016\u0117\u0001\u0000\u0000\u0000\u0018\u0164\u0001"+
		"\u0000\u0000\u0000\u001a\u018f\u0001\u0000\u0000\u0000\u001c\u01f0\u0001"+
		"\u0000\u0000\u0000\u001e\u01f2\u0001\u0000\u0000\u0000 \u01f4\u0001\u0000"+
		"\u0000\u0000\"\u01f8\u0001\u0000\u0000\u0000$\u0215\u0001\u0000\u0000"+
		"\u0000&\u0248\u0001\u0000\u0000\u0000(\u024a\u0001\u0000\u0000\u0000*"+
		"\u024d\u0001\u0000\u0000\u0000,\u0269\u0001\u0000\u0000\u0000.\u026b\u0001"+
		"\u0000\u0000\u00000\u028f\u0001\u0000\u0000\u00002\u0291\u0001\u0000\u0000"+
		"\u00004\u0294\u0001\u0000\u0000\u000068\u0003\u0002\u0001\u000076\u0001"+
		"\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000"+
		"9:\u0001\u0000\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000"+
		"\u0000<=\u0005\u0000\u0000\u0001=\u0001\u0001\u0000\u0000\u0000>L\u0003"+
		"\u001c\u000e\u0000?L\u0003\u0004\u0002\u0000@L\u0003\u0018\f\u0000AL\u0003"+
		"\u001a\r\u0000BL\u0003\u0016\u000b\u0000CL\u0003 \u0010\u0000DL\u0003"+
		"(\u0014\u0000EL\u0003*\u0015\u0000FL\u0007\u0000\u0000\u0000GL\u0003,"+
		"\u0016\u0000HL\u00032\u0019\u0000IL\u0005`\u0000\u0000JL\u00034\u001a"+
		"\u0000K>\u0001\u0000\u0000\u0000K?\u0001\u0000\u0000\u0000K@\u0001\u0000"+
		"\u0000\u0000KA\u0001\u0000\u0000\u0000KB\u0001\u0000\u0000\u0000KC\u0001"+
		"\u0000\u0000\u0000KD\u0001\u0000\u0000\u0000KE\u0001\u0000\u0000\u0000"+
		"KF\u0001\u0000\u0000\u0000KG\u0001\u0000\u0000\u0000KH\u0001\u0000\u0000"+
		"\u0000KI\u0001\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000L\u0003\u0001"+
		"\u0000\u0000\u0000M\u00a8\u0003\u0006\u0003\u0000N\u00a8\u0003\b\u0004"+
		"\u0000O\u00a8\u0003\n\u0005\u0000P\u00a8\u0003\f\u0006\u0000QR\u0005;"+
		"\u0000\u0000RW\u0003.\u0017\u0000SV\u0003\u0002\u0001\u0000TV\u0003\""+
		"\u0011\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000VY\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z[\u0005<\u0000\u0000"+
		"[\u00a8\u0001\u0000\u0000\u0000\\\u00a8\u0003\u0012\t\u0000]\u00a8\u0003"+
		"$\u0012\u0000^\u00a8\u0003&\u0013\u0000_a\u0005*\u0000\u0000`b\u0003."+
		"\u0017\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bf\u0001"+
		"\u0000\u0000\u0000ce\u0003\u0002\u0001\u0000dc\u0001\u0000\u0000\u0000"+
		"eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000"+
		"\u0000gi\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000i\u00a8\u0005"+
		"+\u0000\u0000jk\u0005\u0011\u0000\u0000ko\u0003.\u0017\u0000ln\u0003\u0002"+
		"\u0001\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000"+
		"qo\u0001\u0000\u0000\u0000rs\u0005\u0012\u0000\u0000s\u00a8\u0001\u0000"+
		"\u0000\u0000tu\u0005?\u0000\u0000uy\u0003.\u0017\u0000vx\u0003\u0002\u0001"+
		"\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|}\u0005@\u0000\u0000}\u00a8\u0001\u0000\u0000\u0000"+
		"~\u007f\u0005\u0013\u0000\u0000\u007f\u0083\u0003.\u0017\u0000\u0080\u0082"+
		"\u0003\u0002\u0001\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0085"+
		"\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0001\u0000\u0000\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0083"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u0014\u0000\u0000\u0087\u00a8"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0005C\u0000\u0000\u0089\u008d\u0003"+
		".\u0017\u0000\u008a\u008c\u0003\u0002\u0001\u0000\u008b\u008a\u0001\u0000"+
		"\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0090\u0001\u0000"+
		"\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0005D\u0000"+
		"\u0000\u0091\u00a8\u0001\u0000\u0000\u0000\u0092\u00a8\u0003\u0014\n\u0000"+
		"\u0093\u0094\u0005R\u0000\u0000\u0094\u0098\u0003.\u0017\u0000\u0095\u0097"+
		"\u0003\u0002\u0001\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u009a"+
		"\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0001\u0000\u0000\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u0098"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0005S\u0000\u0000\u009c\u00a8\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0005A\u0000\u0000\u009e\u00a8\u0005B\u0000"+
		"\u0000\u009f\u00a3\u0005\u000f\u0000\u0000\u00a0\u00a2\u0003\u0002\u0001"+
		"\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a6\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a8\u0005`\u0000\u0000\u00a7M\u0001\u0000\u0000\u0000\u00a7"+
		"N\u0001\u0000\u0000\u0000\u00a7O\u0001\u0000\u0000\u0000\u00a7P\u0001"+
		"\u0000\u0000\u0000\u00a7Q\u0001\u0000\u0000\u0000\u00a7\\\u0001\u0000"+
		"\u0000\u0000\u00a7]\u0001\u0000\u0000\u0000\u00a7^\u0001\u0000\u0000\u0000"+
		"\u00a7_\u0001\u0000\u0000\u0000\u00a7j\u0001\u0000\u0000\u0000\u00a7t"+
		"\u0001\u0000\u0000\u0000\u00a7~\u0001\u0000\u0000\u0000\u00a7\u0088\u0001"+
		"\u0000\u0000\u0000\u00a7\u0092\u0001\u0000\u0000\u0000\u00a7\u0093\u0001"+
		"\u0000\u0000\u0000\u00a7\u009d\u0001\u0000\u0000\u0000\u00a7\u009f\u0001"+
		"\u0000\u0000\u0000\u00a8\u0005\u0001\u0000\u0000\u0000\u00a9\u00af\u0003"+
		"\u000e\u0007\u0000\u00aa\u00ae\u0003\u0010\b\u0000\u00ab\u00ae\u0003\u0002"+
		"\u0001\u0000\u00ac\u00ae\u0003\"\u0011\u0000\u00ad\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00ba\u0001\u0000\u0000"+
		"\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00b7\u0005\u000f\u0000"+
		"\u0000\u00b3\u00b6\u0003\u0002\u0001\u0000\u00b4\u00b6\u0003\"\u0011\u0000"+
		"\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000"+
		"\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00b2\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u0005\u0010\u0000\u0000\u00bd\u0007\u0001\u0000\u0000\u0000"+
		"\u00be\u00bf\u00055\u0000\u0000\u00bf\u00c4\u00030\u0018\u0000\u00c0\u00c3"+
		"\u0003\u0002\u0001\u0000\u00c1\u00c3\u0003\"\u0011\u0000\u00c2\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c8\u00056\u0000\u0000\u00c8\t\u0001\u0000"+
		"\u0000\u0000\u00c9\u00ca\u00057\u0000\u0000\u00ca\u00cf\u0003.\u0017\u0000"+
		"\u00cb\u00ce\u0003\u0002\u0001\u0000\u00cc\u00ce\u0003\"\u0011\u0000\u00cd"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d3\u00058\u0000\u0000\u00d3\u000b"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d5\u00059\u0000\u0000\u00d5\u00da\u0003"+
		".\u0017\u0000\u00d6\u00d9\u0003\u0002\u0001\u0000\u00d7\u00d9\u0003\""+
		"\u0011\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d9\u00dc\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dd\u0001\u0000"+
		"\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dd\u00e1\u0005?\u0000"+
		"\u0000\u00de\u00e0\u0003\u0002\u0001\u0000\u00df\u00de\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005:\u0000\u0000"+
		"\u00e5\r\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005\r\u0000\u0000\u00e7"+
		"\u00e8\u0003.\u0017\u0000\u00e8\u000f\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0005\u000e\u0000\u0000\u00ea\u00ee\u0003.\u0017\u0000\u00eb\u00ed\u0003"+
		"\u0002\u0001\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed\u00f0\u0001"+
		"\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001"+
		"\u0000\u0000\u0000\u00ef\u0011\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f2\u0005\u0015\u0000\u0000\u00f2\u0100\u0003"+
		".\u0017\u0000\u00f3\u00f4\u0005\u0016\u0000\u0000\u00f4\u00f8\u0003.\u0017"+
		"\u0000\u00f5\u00f7\u0003\u0002\u0001\u0000\u00f6\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fc\u0001\u0000\u0000"+
		"\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fd\u0005=\u0000\u0000"+
		"\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000"+
		"\u00fd\u00ff\u0001\u0000\u0000\u0000\u00fe\u00f3\u0001\u0000\u0000\u0000"+
		"\u00ff\u0102\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000"+
		"\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u010b\u0001\u0000\u0000\u0000"+
		"\u0102\u0100\u0001\u0000\u0000\u0000\u0103\u0104\u0005\u0017\u0000\u0000"+
		"\u0104\u0108\u0003.\u0017\u0000\u0105\u0107\u0003\u0002\u0001\u0000\u0106"+
		"\u0105\u0001\u0000\u0000\u0000\u0107\u010a\u0001\u0000\u0000\u0000\u0108"+
		"\u0106\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109"+
		"\u010c\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010b"+
		"\u0103\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c"+
		"\u010d\u0001\u0000\u0000\u0000\u010d\u010e\u0005\u0018\u0000\u0000\u010e"+
		"\u0013\u0001\u0000\u0000\u0000\u010f\u0110\u0005\n\u0000\u0000\u0110\u0111"+
		"\u0005\u009a\u0000\u0000\u0111\u0015\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u0005T\u0000\u0000\u0113\u0118\u0003.\u0017\u0000\u0114\u0115\u0005\n"+
		"\u0000\u0000\u0115\u0118\u0003.\u0017\u0000\u0116\u0118\u0005V\u0000\u0000"+
		"\u0117\u0112\u0001\u0000\u0000\u0000\u0117\u0114\u0001\u0000\u0000\u0000"+
		"\u0117\u0116\u0001\u0000\u0000\u0000\u0118\u0017\u0001\u0000\u0000\u0000"+
		"\u0119\u011a\u0005!\u0000\u0000\u011a\u011c\u0005\u0001\u0000\u0000\u011b"+
		"\u011d\u0005\u0004\u0000\u0000\u011c\u011b\u0001\u0000\u0000\u0000\u011c"+
		"\u011d\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e"+
		"\u011f\u0005\u000b\u0000\u0000\u011f\u0165\u0005\u0002\u0000\u0000\u0120"+
		"\u0121\u0005\u0019\u0000\u0000\u0121\u0123\u0005\u0001\u0000\u0000\u0122"+
		"\u0124\u0005\u0004\u0000\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0123"+
		"\u0124\u0001\u0000\u0000\u0000\u0124\u0126\u0001\u0000\u0000\u0000\u0125"+
		"\u0127\u0005\u000b\u0000\u0000\u0126\u0125\u0001\u0000\u0000\u0000\u0126"+
		"\u0127\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128"+
		"\u0165\u0005\u0002\u0000\u0000\u0129\u012a\u0007\u0001\u0000\u0000\u012a"+
		"\u012c\u0005\u0001\u0000\u0000\u012b\u012d\u0005\u0004\u0000\u0000\u012c"+
		"\u012b\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d"+
		"\u012f\u0001\u0000\u0000\u0000\u012e\u0130\u0005\u000b\u0000\u0000\u012f"+
		"\u012e\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130"+
		"\u0131\u0001\u0000\u0000\u0000\u0131\u0165\u0005\u0002\u0000\u0000\u0132"+
		"\u0133\u0007\u0002\u0000\u0000\u0133\u0134\u0005\u0001\u0000\u0000\u0134"+
		"\u0136\u0005\u000b\u0000\u0000\u0135\u0137\u0005\u0004\u0000\u0000\u0136"+
		"\u0135\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137"+
		"\u0139\u0001\u0000\u0000\u0000\u0138\u013a\u0005\u000b\u0000\u0000\u0139"+
		"\u0138\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a"+
		"\u013b\u0001\u0000\u0000\u0000\u013b\u0165\u0005\u0002\u0000\u0000\u013c"+
		"\u013d\u0005 \u0000\u0000\u013d\u013f\u0005\u0001\u0000\u0000\u013e\u0140"+
		"\u0005\u0004\u0000\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u013f\u0140"+
		"\u0001\u0000\u0000\u0000\u0140\u0142\u0001\u0000\u0000\u0000\u0141\u0143"+
		"\u0005\u000b\u0000\u0000\u0142\u0141\u0001\u0000\u0000\u0000\u0142\u0143"+
		"\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0165"+
		"\u0005\u0002\u0000\u0000\u0145\u0146\u0005,\u0000\u0000\u0146\u0148\u0005"+
		"\u0001\u0000\u0000\u0147\u0149\u0005\u0004\u0000\u0000\u0148\u0147\u0001"+
		"\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014a\u0001"+
		"\u0000\u0000\u0000\u014a\u0165\u0005\u0002\u0000\u0000\u014b\u014c\u0005"+
		"W\u0000\u0000\u014c\u014e\u0005\u0001\u0000\u0000\u014d\u014f\u0005\u0004"+
		"\u0000\u0000\u014e\u014d\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000"+
		"\u0000\u0000\u014f\u0151\u0001\u0000\u0000\u0000\u0150\u0152\u0005\u000b"+
		"\u0000\u0000\u0151\u0150\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000"+
		"\u0000\u0000\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u0165\u0005\u0002"+
		"\u0000\u0000\u0154\u0155\u0005X\u0000\u0000\u0155\u0156\u0005\u0001\u0000"+
		"\u0000\u0156\u0158\u0005\u000b\u0000\u0000\u0157\u0159\u0005\u0004\u0000"+
		"\u0000\u0158\u0157\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000"+
		"\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u0165\u0005\u0002\u0000"+
		"\u0000\u015b\u015c\u0005Y\u0000\u0000\u015c\u015e\u0005\u0001\u0000\u0000"+
		"\u015d\u015f\u0005\u0004\u0000\u0000\u015e\u015d\u0001\u0000\u0000\u0000"+
		"\u015e\u015f\u0001\u0000\u0000\u0000\u015f\u0161\u0001\u0000\u0000\u0000"+
		"\u0160\u0162\u0005\u000b\u0000\u0000\u0161\u0160\u0001\u0000\u0000\u0000"+
		"\u0161\u0162\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000\u0000\u0000"+
		"\u0163\u0165\u0005\u0002\u0000\u0000\u0164\u0119\u0001\u0000\u0000\u0000"+
		"\u0164\u0120\u0001\u0000\u0000\u0000\u0164\u0129\u0001\u0000\u0000\u0000"+
		"\u0164\u0132\u0001\u0000\u0000\u0000\u0164\u013c\u0001\u0000\u0000\u0000"+
		"\u0164\u0145\u0001\u0000\u0000\u0000\u0164\u014b\u0001\u0000\u0000\u0000"+
		"\u0164\u0154\u0001\u0000\u0000\u0000\u0164\u015b\u0001\u0000\u0000\u0000"+
		"\u0165\u0019\u0001\u0000\u0000\u0000\u0166\u0167\u0005\u001f\u0000\u0000"+
		"\u0167\u0169\u0005\u0001\u0000\u0000\u0168\u016a\u0005\u0004\u0000\u0000"+
		"\u0169\u0168\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000"+
		"\u016a\u016b\u0001\u0000\u0000\u0000\u016b\u016c\u0005\u000b\u0000\u0000"+
		"\u016c\u0171\u0005\u000b\u0000\u0000\u016d\u016f\u0005\u000b\u0000\u0000"+
		"\u016e\u0170\u0005\u0004\u0000\u0000\u016f\u016e\u0001\u0000\u0000\u0000"+
		"\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u0172\u0001\u0000\u0000\u0000"+
		"\u0171\u016d\u0001\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000"+
		"\u0172\u0173\u0001\u0000\u0000\u0000\u0173\u0190\u0005\u0002\u0000\u0000"+
		"\u0174\u0175\u0005\u001e\u0000\u0000\u0175\u0179\u0005\u0001\u0000\u0000"+
		"\u0176\u0178\u0005\u0004\u0000\u0000\u0177\u0176\u0001\u0000\u0000\u0000"+
		"\u0178\u017b\u0001\u0000\u0000\u0000\u0179\u0177\u0001\u0000\u0000\u0000"+
		"\u0179\u017a\u0001\u0000\u0000\u0000\u017a\u017d\u0001\u0000\u0000\u0000"+
		"\u017b\u0179\u0001\u0000\u0000\u0000\u017c\u017e\u0005\u000b\u0000\u0000"+
		"\u017d\u017c\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000"+
		"\u017e\u017f\u0001\u0000\u0000\u0000\u017f\u0190\u0005\u0002\u0000\u0000"+
		"\u0180\u0181\u0005U\u0000\u0000\u0181\u0183\u0005\u0001\u0000\u0000\u0182"+
		"\u0184\u0005\u0004\u0000\u0000\u0183\u0182\u0001\u0000\u0000\u0000\u0183"+
		"\u0184\u0001\u0000\u0000\u0000\u0184\u018b\u0001\u0000\u0000\u0000\u0185"+
		"\u0187\u0005\u000b\u0000\u0000\u0186\u0188\u0005\u0004\u0000\u0000\u0187"+
		"\u0186\u0001\u0000\u0000\u0000\u0187\u0188\u0001\u0000\u0000\u0000\u0188"+
		"\u018a\u0001\u0000\u0000\u0000\u0189\u0185\u0001\u0000\u0000\u0000\u018a"+
		"\u018d\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000\u0000\u0000\u018b"+
		"\u018c\u0001\u0000\u0000\u0000\u018c\u018e\u0001\u0000\u0000\u0000\u018d"+
		"\u018b\u0001\u0000\u0000\u0000\u018e\u0190\u0005\u0002\u0000\u0000\u018f"+
		"\u0166\u0001\u0000\u0000\u0000\u018f\u0174\u0001\u0000\u0000\u0000\u018f"+
		"\u0180\u0001\u0000\u0000\u0000\u0190\u001b\u0001\u0000\u0000\u0000\u0191"+
		"\u0192\u0005!\u0000\u0000\u0192\u0194\u0005\u0001\u0000\u0000\u0193\u0195"+
		"\u0005\u0004\u0000\u0000\u0194\u0193\u0001\u0000\u0000\u0000\u0194\u0195"+
		"\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u0196\u0198"+
		"\u0005\u0002\u0000\u0000\u0197\u0199\u0005%\u0000\u0000\u0198\u0197\u0001"+
		"\u0000\u0000\u0000\u0198\u0199\u0001\u0000\u0000\u0000\u0199\u019d\u0001"+
		"\u0000\u0000\u0000\u019a\u019c\u0003\u0002\u0001\u0000\u019b\u019a\u0001"+
		"\u0000\u0000\u0000\u019c\u019f\u0001\u0000\u0000\u0000\u019d\u019b\u0001"+
		"\u0000\u0000\u0000\u019d\u019e\u0001\u0000\u0000\u0000\u019e\u01a0\u0001"+
		"\u0000\u0000\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u01a0\u01f1\u0007"+
		"\u0003\u0000\u0000\u01a1\u01a2\u0005\"\u0000\u0000\u01a2\u01a4\u0005\u0001"+
		"\u0000\u0000\u01a3\u01a5\u0005\u0004\u0000\u0000\u01a4\u01a3\u0001\u0000"+
		"\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000\u01a5\u01a6\u0001\u0000"+
		"\u0000\u0000\u01a6\u01aa\u0005\u0002\u0000\u0000\u01a7\u01a9\u0003\u0002"+
		"\u0001\u0000\u01a8\u01a7\u0001\u0000\u0000\u0000\u01a9\u01ac\u0001\u0000"+
		"\u0000\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000\u01aa\u01ab\u0001\u0000"+
		"\u0000\u0000\u01ab\u01ad\u0001\u0000\u0000\u0000\u01ac\u01aa\u0001\u0000"+
		"\u0000\u0000\u01ad\u01f1\u0005\u0010\u0000\u0000\u01ae\u01af\u0005#\u0000"+
		"\u0000\u01af\u01b1\u0005\u0001\u0000\u0000\u01b0\u01b2\u0005\u0004\u0000"+
		"\u0000\u01b1\u01b0\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000"+
		"\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3\u01b7\u0005\u0002\u0000"+
		"\u0000\u01b4\u01b6\u0003\u0002\u0001\u0000\u01b5\u01b4\u0001\u0000\u0000"+
		"\u0000\u01b6\u01b9\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000"+
		"\u0000\u01b7\u01b8\u0001\u0000\u0000\u0000\u01b8\u01ba\u0001\u0000\u0000"+
		"\u0000\u01b9\u01b7\u0001\u0000\u0000\u0000\u01ba\u01f1\u0005\u0010\u0000"+
		"\u0000\u01bb\u01bc\u0005-\u0000\u0000\u01bc\u01be\u0005\u0001\u0000\u0000"+
		"\u01bd\u01bf\u0005\u0004\u0000\u0000\u01be\u01bd\u0001\u0000\u0000\u0000"+
		"\u01be\u01bf\u0001\u0000\u0000\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000"+
		"\u01c0\u01c4\u0005\u0002\u0000\u0000\u01c1\u01c3\u0003\u0002\u0001\u0000"+
		"\u01c2\u01c1\u0001\u0000\u0000\u0000\u01c3\u01c6\u0001\u0000\u0000\u0000"+
		"\u01c4\u01c2\u0001\u0000\u0000\u0000\u01c4\u01c5\u0001\u0000\u0000\u0000"+
		"\u01c5\u01c7\u0001\u0000\u0000\u0000\u01c6\u01c4\u0001\u0000\u0000\u0000"+
		"\u01c7\u01f1\u0005.\u0000\u0000\u01c8\u01c9\u0005/\u0000\u0000\u01c9\u01cb"+
		"\u0005\u0001\u0000\u0000\u01ca\u01cc\u0005\u0004\u0000\u0000\u01cb\u01ca"+
		"\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001\u0000\u0000\u0000\u01cc\u01cd"+
		"\u0001\u0000\u0000\u0000\u01cd\u01ce\u0005\u000b\u0000\u0000\u01ce\u01d2"+
		"\u0005\u0002\u0000\u0000\u01cf\u01d1\u0003\u0002\u0001\u0000\u01d0\u01cf"+
		"\u0001\u0000\u0000\u0000\u01d1\u01d4\u0001\u0000\u0000\u0000\u01d2\u01d0"+
		"\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d5"+
		"\u0001\u0000\u0000\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000\u01d5\u01f1"+
		"\u00050\u0000\u0000\u01d6\u01d7\u00051\u0000\u0000\u01d7\u01d9\u0005\u0001"+
		"\u0000\u0000\u01d8\u01da\u0005\u0004\u0000\u0000\u01d9\u01d8\u0001\u0000"+
		"\u0000\u0000\u01d9\u01da\u0001\u0000\u0000\u0000\u01da\u01db\u0001\u0000"+
		"\u0000\u0000\u01db\u01df\u0005\u0002\u0000\u0000\u01dc\u01de\u0003\u0002"+
		"\u0001\u0000\u01dd\u01dc\u0001\u0000\u0000\u0000\u01de\u01e1\u0001\u0000"+
		"\u0000\u0000\u01df\u01dd\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000"+
		"\u0000\u0000\u01e0\u01e2\u0001\u0000\u0000\u0000\u01e1\u01df\u0001\u0000"+
		"\u0000\u0000\u01e2\u01f1\u00052\u0000\u0000\u01e3\u01e4\u00053\u0000\u0000"+
		"\u01e4\u01e6\u0005\u0001\u0000\u0000\u01e5\u01e7\u0005\u0004\u0000\u0000"+
		"\u01e6\u01e5\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000"+
		"\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e8\u01ec\u0005\u0002\u0000\u0000"+
		"\u01e9\u01eb\u0003\u0002\u0001\u0000\u01ea\u01e9\u0001\u0000\u0000\u0000"+
		"\u01eb\u01ee\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001\u0000\u0000\u0000"+
		"\u01ec\u01ed\u0001\u0000\u0000\u0000\u01ed\u01ef\u0001\u0000\u0000\u0000"+
		"\u01ee\u01ec\u0001\u0000\u0000\u0000\u01ef\u01f1\u00054\u0000\u0000\u01f0"+
		"\u0191\u0001\u0000\u0000\u0000\u01f0\u01a1\u0001\u0000\u0000\u0000\u01f0"+
		"\u01ae\u0001\u0000\u0000\u0000\u01f0\u01bb\u0001\u0000\u0000\u0000\u01f0"+
		"\u01c8\u0001\u0000\u0000\u0000\u01f0\u01d6\u0001\u0000\u0000\u0000\u01f0"+
		"\u01e3\u0001\u0000\u0000\u0000\u01f1\u001d\u0001\u0000\u0000\u0000\u01f2"+
		"\u01f3\u0007\u0004\u0000\u0000\u01f3\u001f\u0001\u0000\u0000\u0000\u01f4"+
		"\u01f6\u0005\u0003\u0000\u0000\u01f5\u01f7\u0003.\u0017\u0000\u01f6\u01f5"+
		"\u0001\u0000\u0000\u0000\u01f6\u01f7\u0001\u0000\u0000\u0000\u01f7!\u0001"+
		"\u0000\u0000\u0000\u01f8\u01fa\u0007\u0005\u0000\u0000\u01f9\u01fb\u0003"+
		".\u0017\u0000\u01fa\u01f9\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000"+
		"\u0000\u0000\u01fb#\u0001\u0000\u0000\u0000\u01fc\u01fd\u0005G\u0000\u0000"+
		"\u01fd\u01ff\u0005\u0001\u0000\u0000\u01fe\u0200\u0005\u000b\u0000\u0000"+
		"\u01ff\u01fe\u0001\u0000\u0000\u0000\u01ff\u0200\u0001\u0000\u0000\u0000"+
		"\u0200\u0201\u0001\u0000\u0000\u0000\u0201\u0205\u0005\u0002\u0000\u0000"+
		"\u0202\u0204\u0003\u0002\u0001\u0000\u0203\u0202\u0001\u0000\u0000\u0000"+
		"\u0204\u0207\u0001\u0000\u0000\u0000\u0205\u0203\u0001\u0000\u0000\u0000"+
		"\u0205\u0206\u0001\u0000\u0000\u0000\u0206\u020f\u0001\u0000\u0000\u0000"+
		"\u0207\u0205\u0001\u0000\u0000\u0000\u0208\u020c\u0005\u000f\u0000\u0000"+
		"\u0209\u020b\u0003\u0002\u0001\u0000\u020a\u0209\u0001\u0000\u0000\u0000"+
		"\u020b\u020e\u0001\u0000\u0000\u0000\u020c\u020a\u0001\u0000\u0000\u0000"+
		"\u020c\u020d\u0001\u0000\u0000\u0000\u020d\u0210\u0001\u0000\u0000\u0000"+
		"\u020e\u020c\u0001\u0000\u0000\u0000\u020f\u0208\u0001\u0000\u0000\u0000"+
		"\u020f\u0210\u0001\u0000\u0000\u0000\u0210\u0211\u0001\u0000\u0000\u0000"+
		"\u0211\u0216\u0005H\u0000\u0000\u0212\u0216\u0005E\u0000\u0000\u0213\u0214"+
		"\u0005F\u0000\u0000\u0214\u0216\u0003.\u0017\u0000\u0215\u01fc\u0001\u0000"+
		"\u0000\u0000\u0215\u0212\u0001\u0000\u0000\u0000\u0215\u0213\u0001\u0000"+
		"\u0000\u0000\u0216%\u0001\u0000\u0000\u0000\u0217\u0219\u0005I\u0000\u0000"+
		"\u0218\u021a\u0003.\u0017\u0000\u0219\u0218\u0001\u0000\u0000\u0000\u0219"+
		"\u021a\u0001\u0000\u0000\u0000\u021a\u021e\u0001\u0000\u0000\u0000\u021b"+
		"\u021d\u0003\u0002\u0001\u0000\u021c\u021b\u0001\u0000\u0000\u0000\u021d"+
		"\u0220\u0001\u0000\u0000\u0000\u021e\u021c\u0001\u0000\u0000\u0000\u021e"+
		"\u021f\u0001\u0000\u0000\u0000\u021f\u0228\u0001\u0000\u0000\u0000\u0220"+
		"\u021e\u0001\u0000\u0000\u0000\u0221\u0225\u0007\u0006\u0000\u0000\u0222"+
		"\u0224\u0003\u0002\u0001\u0000\u0223\u0222\u0001\u0000\u0000\u0000\u0224"+
		"\u0227\u0001\u0000\u0000\u0000\u0225\u0223\u0001\u0000\u0000\u0000\u0225"+
		"\u0226\u0001\u0000\u0000\u0000\u0226\u0229\u0001\u0000\u0000\u0000\u0227"+
		"\u0225\u0001\u0000\u0000\u0000\u0228\u0221\u0001\u0000\u0000\u0000\u0228"+
		"\u0229\u0001\u0000\u0000\u0000\u0229\u022a\u0001\u0000\u0000\u0000\u022a"+
		"\u0249\u0005J\u0000\u0000\u022b\u022d\u0005K\u0000\u0000\u022c\u022e\u0003"+
		".\u0017\u0000\u022d\u022c\u0001\u0000\u0000\u0000\u022d\u022e\u0001\u0000"+
		"\u0000\u0000\u022e\u0232\u0001\u0000\u0000\u0000\u022f\u0231\u0003\u0002"+
		"\u0001\u0000\u0230\u022f\u0001\u0000\u0000\u0000\u0231\u0234\u0001\u0000"+
		"\u0000\u0000\u0232\u0230\u0001\u0000\u0000\u0000\u0232\u0233\u0001\u0000"+
		"\u0000\u0000\u0233\u0235\u0001\u0000\u0000\u0000\u0234\u0232\u0001\u0000"+
		"\u0000\u0000\u0235\u0249\u0005M\u0000\u0000\u0236\u0237\u0005N\u0000\u0000"+
		"\u0237\u023b\u0003.\u0017\u0000\u0238\u023a\u0003\u0002\u0001\u0000\u0239"+
		"\u0238\u0001\u0000\u0000\u0000\u023a\u023d\u0001\u0000\u0000\u0000\u023b"+
		"\u0239\u0001\u0000\u0000\u0000\u023b\u023c\u0001\u0000\u0000\u0000\u023c"+
		"\u023e\u0001\u0000\u0000\u0000\u023d\u023b\u0001\u0000\u0000\u0000\u023e"+
		"\u023f\u0005O\u0000\u0000\u023f\u0249\u0001\u0000\u0000\u0000\u0240\u0244"+
		"\u0005P\u0000\u0000\u0241\u0243\u0003\u0002\u0001\u0000\u0242\u0241\u0001"+
		"\u0000\u0000\u0000\u0243\u0246\u0001\u0000\u0000\u0000\u0244\u0242\u0001"+
		"\u0000\u0000\u0000\u0244\u0245\u0001\u0000\u0000\u0000\u0245\u0247\u0001"+
		"\u0000\u0000\u0000\u0246\u0244\u0001\u0000\u0000\u0000\u0247\u0249\u0005"+
		"Q\u0000\u0000\u0248\u0217\u0001\u0000\u0000\u0000\u0248\u022b\u0001\u0000"+
		"\u0000\u0000\u0248\u0236\u0001\u0000\u0000\u0000\u0248\u0240\u0001\u0000"+
		"\u0000\u0000\u0249\'\u0001\u0000\u0000\u0000\u024a\u024b\u0005Z\u0000"+
		"\u0000\u024b\u024c\u0005\u0005\u0000\u0000\u024c)\u0001\u0000\u0000\u0000"+
		"\u024d\u024e\u0005\\\u0000\u0000\u024e\u024f\u0005]\u0000\u0000\u024f"+
		"+\u0001\u0000\u0000\u0000\u0250\u0251\u0003\u001e\u000f\u0000\u0251\u0252"+
		"\u0005\u0001\u0000\u0000\u0252\u0253\u0006\u0016\uffff\uffff\u0000\u0253"+
		"\u026a\u0001\u0000\u0000\u0000\u0254\u0255\u0005\r\u0000\u0000\u0255\u0256"+
		"\u0003.\u0017\u0000\u0256\u0257\u0006\u0016\uffff\uffff\u0000\u0257\u026a"+
		"\u0001\u0000\u0000\u0000\u0258\u0259\u00055\u0000\u0000\u0259\u025d\u0003"+
		"0\u0018\u0000\u025a\u025b\u00057\u0000\u0000\u025b\u025d\u0003.\u0017"+
		"\u0000\u025c\u0258\u0001\u0000\u0000\u0000\u025c\u025a\u0001\u0000\u0000"+
		"\u0000\u025d\u025e\u0001\u0000\u0000\u0000\u025e\u025f\u0006\u0016\uffff"+
		"\uffff\u0000\u025f\u026a\u0001\u0000\u0000\u0000\u0260\u0261\u0005A\u0000"+
		"\u0000\u0261\u026a\u0006\u0016\uffff\uffff\u0000\u0262\u0263\u0005!\u0000"+
		"\u0000\u0263\u0265\u0005\u0001\u0000\u0000\u0264\u0266\u0005\u0004\u0000"+
		"\u0000\u0265\u0264\u0001\u0000\u0000\u0000\u0265\u0266\u0001\u0000\u0000"+
		"\u0000\u0266\u0267\u0001\u0000\u0000\u0000\u0267\u0268\u0005\u0002\u0000"+
		"\u0000\u0268\u026a\u0006\u0016\uffff\uffff\u0000\u0269\u0250\u0001\u0000"+
		"\u0000\u0000\u0269\u0254\u0001\u0000\u0000\u0000\u0269\u025c\u0001\u0000"+
		"\u0000\u0000\u0269\u0260\u0001\u0000\u0000\u0000\u0269\u0262\u0001\u0000"+
		"\u0000\u0000\u026a-\u0001\u0000\u0000\u0000\u026b\u026c\u0005\u0001\u0000"+
		"\u0000\u026c\u026d\u0005\u0002\u0000\u0000\u026d/\u0001\u0000\u0000\u0000"+
		"\u026e\u026f\u0005\u0001\u0000\u0000\u026f\u0270\u0005\u0096\u0000\u0000"+
		"\u0270\u0271\u0005\u0097\u0000\u0000\u0271\u0274\u0005\u0096\u0000\u0000"+
		"\u0272\u0273\u0005\u0098\u0000\u0000\u0273\u0275\u0005\u0096\u0000\u0000"+
		"\u0274\u0272\u0001\u0000\u0000\u0000\u0274\u0275\u0001\u0000\u0000\u0000"+
		"\u0275\u0276\u0001\u0000\u0000\u0000\u0276\u0290\u0005\u0002\u0000\u0000"+
		"\u0277\u027b\u0005\u0001\u0000\u0000\u0278\u027a\u0005\u0096\u0000\u0000"+
		"\u0279\u0278\u0001\u0000\u0000\u0000\u027a\u027d\u0001\u0000\u0000\u0000"+
		"\u027b\u0279\u0001\u0000\u0000\u0000\u027b\u027c\u0001\u0000\u0000\u0000"+
		"\u027c\u027e\u0001\u0000\u0000\u0000\u027d\u027b\u0001\u0000\u0000\u0000"+
		"\u027e\u0282\u0005\u0097\u0000\u0000\u027f\u0281\u0005\u0096\u0000\u0000"+
		"\u0280\u027f\u0001\u0000\u0000\u0000\u0281\u0284\u0001\u0000\u0000\u0000"+
		"\u0282\u0280\u0001\u0000\u0000\u0000\u0282\u0283\u0001\u0000\u0000\u0000"+
		"\u0283\u028c\u0001\u0000\u0000\u0000\u0284\u0282\u0001\u0000\u0000\u0000"+
		"\u0285\u0289\u0005\u0098\u0000\u0000\u0286\u0288\u0005\u0096\u0000\u0000"+
		"\u0287\u0286\u0001\u0000\u0000\u0000\u0288\u028b\u0001\u0000\u0000\u0000"+
		"\u0289\u0287\u0001\u0000\u0000\u0000\u0289\u028a\u0001\u0000\u0000\u0000"+
		"\u028a\u028d\u0001\u0000\u0000\u0000\u028b\u0289\u0001\u0000\u0000\u0000"+
		"\u028c\u0285\u0001\u0000\u0000\u0000\u028c\u028d\u0001\u0000\u0000\u0000"+
		"\u028d\u028e\u0001\u0000\u0000\u0000\u028e\u0290\u0005\u0002\u0000\u0000"+
		"\u028f\u026e\u0001\u0000\u0000\u0000\u028f\u0277\u0001\u0000\u0000\u0000"+
		"\u02901\u0001\u0000\u0000\u0000\u0291\u0292\u0005b\u0000\u0000\u0292\u0293"+
		"\u0007\u0007\u0000\u0000\u02933\u0001\u0000\u0000\u0000\u0294\u0295\u0005"+
		"c\u0000\u0000\u02955\u0001\u0000\u0000\u0000b9KUWafoy\u0083\u008d\u0098"+
		"\u00a3\u00a7\u00ad\u00af\u00b5\u00b7\u00ba\u00c2\u00c4\u00cd\u00cf\u00d8"+
		"\u00da\u00e1\u00ee\u00f8\u00fc\u0100\u0108\u010b\u0117\u011c\u0123\u0126"+
		"\u012c\u012f\u0136\u0139\u013f\u0142\u0148\u014e\u0151\u0158\u015e\u0161"+
		"\u0164\u0169\u016f\u0171\u0179\u017d\u0183\u0187\u018b\u018f\u0194\u0198"+
		"\u019d\u01a4\u01aa\u01b1\u01b7\u01be\u01c4\u01cb\u01d2\u01d9\u01df\u01e6"+
		"\u01ec\u01f0\u01f6\u01fa\u01ff\u0205\u020c\u020f\u0215\u0219\u021e\u0225"+
		"\u0228\u022d\u0232\u023b\u0244\u0248\u025c\u0265\u0269\u0274\u027b\u0282"+
		"\u0289\u028c\u028f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}