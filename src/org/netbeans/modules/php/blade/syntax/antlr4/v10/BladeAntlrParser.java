// Generated from java-escape by ANTLR 4.11.1

  /**
   * Parser generated for netbeans blade editor
   * Some elements have been simplified to optimize parser speed
   * For example
   * - switch statement have a loos validation
   * - generic block statement "@isset" | "@unless" are grouped togehter
   * - the start match and end match will be checked in the parser
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
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PHP_EXPRESSION=1, PHP_VARIABLE=2, PHP_KEYWORD=3, PHP_NEW=4, PHP_WS=5, 
		PHP_IDENTIFIER=6, PHP_NAMESPACE_PATH=7, PHP_STATIC_ACCESS=8, PHP_CLASS_KEYWORD=9, 
		PHP_INSTANCE_ACCESS=10, BLADE_PARAM_EXTRA=11, BLADE_PARAM_LPAREN=12, BLADE_PARAM_RPAREN=13, 
		BLADE_EXPR_LPAREN=14, BLADE_EXPR_RPAREN=15, BL_SQ_LPAREN=16, BL_SQ_LRAREN=17, 
		BL_PARAM_STRING=18, BL_PARAM_ASSIGN=19, BL_COMMA=20, BL_PARAM_COMMA=21, 
		PHP_EXPR_STRING=22, ERROR=23, HTML=24, BLADE_COMMENT=25, D_IF=26, D_ELSEIF=27, 
		D_ELSE=28, D_ENDIF=29, D_SWITCH=30, D_CASE=31, D_DEFAULT=32, D_ENDSWITCH=33, 
		D_EMPTY=34, D_ENDEMPTY=35, D_COND_BLOCK_START=36, D_COND_BLOCK_END=37, 
		D_FOREACH=38, D_ENDFOREACH=39, D_FOR=40, D_ENDFOR=41, D_FORELSE=42, D_ENDFORELSE=43, 
		D_WHILE=44, D_ENDWHILE=45, D_BREAK=46, D_LOOP_ACTION=47, D_INCLUDE=48, 
		D_INCLUDE_IF=49, D_INCLUDE_WHEN=50, D_INCLUDE_FIRST=51, D_INCLUDE_UNLESS=52, 
		D_EACH=53, D_EXTENDS=54, D_JS=55, D_SECTION=56, D_HAS_SECTION=57, D_SECTION_MISSING=58, 
		D_ENDSECTION=59, D_YIELD=60, D_PARENT=61, D_SHOW=62, D_OVERWRITE=63, D_STOP=64, 
		D_APPEND=65, D_ONCE=66, D_ENDONCE=67, D_STACK=68, D_PUSH=69, D_ENDPUSH=70, 
		D_PUSH_IF=71, D_ENDPUSH_IF=72, D_PUSH_ONCE=73, D_ENDPUSH_ONCE=74, D_PREPEND=75, 
		D_ENDPREPEND=76, D_PROPS=77, D_FRAGMENT=78, D_ENDFRAGMENT=79, D_CSRF=80, 
		D_METHOD=81, D_ERROR=82, D_ENDERROR=83, D_PRODUCTION=84, D_ENDPRODUCTION=85, 
		D_ENV=86, D_ENDENV=87, D_AUTH_START=88, D_AUTH_END=89, D_PERMISSION_START=90, 
		D_PERMISSION_ELSE=91, D_PERMISSION_END=92, D_CLASS=93, D_STYLE=94, D_HTML_ATTR_EXPR=95, 
		D_AWARE=96, D_JSON=97, D_DD=98, D_LANG=99, D_USE=100, D_INJECT=101, D_PHP=102, 
		D_VERBATIM=103, D_ENDVERBATIM=104, D_LIVEWIRE=105, D_CUSTOM=106, D_UNKNOWN=107, 
		CONTENT_TAG_OPEN=108, RAW_TAG_OPEN=109, PHP_INLINE_START=110, BLADE_COMMENT_START=111, 
		CONTENT_TAG_CLOSE=112, RAW_TAG_CLOSE=113, WS_EXPR_ESCAPE=114, WS_EXPR=115, 
		WS_COMPOSED_EXPR=116, EXPR_STRING=117, COMPOSED_EXPR_RPAREN=118, WS_BL_PARAM=119, 
		FOREACH_WS_EXPR=120, FOREACH_LOOP_LPAREN=121, FOREACH_LOOP_RPAREN=122, 
		FOREACH_AS=123, FOREACH_PARAM_ASSIGN=124, BL_PARAM_LINE_COMMENT=125, BL_SQ_RPAREN=126, 
		BL_PARAM_RPAREN=127, BL_PARAM_CONCAT_OPERATOR=128, BL_COMMA_EL=129, BL_PARAM_WS=130, 
		BL_NAME_STRING=131, PHP_D_BLADE_COMMENT=132, PHP_D_BLADE_ML_COMMENT=133, 
		D_ENDPHP=134, PHP_EXIT=135, PHP_INLINE_COMMENT=136, PHP_INLINE_ML_COMMENT=137, 
		BLADE_COMMENT_END=138, AT=139, RAW_TAG_START=140, REGULAR_ECHO_STATIC_ACCESS=141, 
		REGULAR_ECHO_LPAREN=142, REGULAR_ECHO_RPAREN=143, PHP_D_EXPR_CURLY_LPAREN=144, 
		PHP_D_EXPR_CURLY_RPAREN=145, PHP_D_CLASS=146, PHP_D_WS=147, PHP_COMPOSED_EXPR_INSTANCE_ACCESS=148;
	public static final int
		RULE_file = 0, RULE_general_statement = 1, RULE_inline_statement = 2, 
		RULE_inline_directive = 3, RULE_block_statement = 4, RULE_non_blade_statement = 5, 
		RULE_extends = 6, RULE_section_inline = 7, RULE_section = 8, RULE_push = 9, 
		RULE_pushOnce = 10, RULE_pushIf = 11, RULE_prepend = 12, RULE_fragmentD = 13, 
		RULE_if = 14, RULE_elseif = 15, RULE_else = 16, RULE_endif = 17, RULE_empty_block = 18, 
		RULE_conditional_block = 19, RULE_auth_block = 20, RULE_env_block = 21, 
		RULE_permission = 22, RULE_error_block = 23, RULE_switch = 24, RULE_while = 25, 
		RULE_for = 26, RULE_foreach = 27, RULE_forelse = 28, RULE_yieldD = 29, 
		RULE_stack = 30, RULE_useD = 31, RULE_inject = 32, RULE_include = 33, 
		RULE_includeIf = 34, RULE_includeCond = 35, RULE_includeFirst = 36, RULE_each = 37, 
		RULE_once_block = 38, RULE_hasSection = 39, RULE_sectionMissing = 40, 
		RULE_custom_directive = 41, RULE_possibleDirective = 42, RULE_php_blade = 43, 
		RULE_phpInline = 44, RULE_regular_echo = 45, RULE_raw_echo = 46, RULE_echo_expr = 47, 
		RULE_class_expr_usage = 48, RULE_class_alias_static_access = 49, RULE_static_direct_class_access = 50, 
		RULE_class_instance = 51, RULE_class_name_reference = 52, RULE_class_identifier = 53, 
		RULE_namespacePath = 54, RULE_method_call = 55, RULE_function_call = 56, 
		RULE_php_expression = 57, RULE_loop_expression = 58, RULE_main_php_expression = 59, 
		RULE_composed_php_expression = 60, RULE_simple_foreach_expr = 61, RULE_singleArgWrapper = 62, 
		RULE_singleArgWrapperNovar = 63, RULE_singleArgAndDefaultWrapper = 64, 
		RULE_doubleArgWrapper = 65, RULE_doubleIfArgWrapper = 66, RULE_multiArgWrapper = 67, 
		RULE_identifiableArgument = 68, RULE_composedArgument = 69, RULE_phpExpr = 70, 
		RULE_identifiableArray = 71, RULE_arrayDefine = 72, RULE_paramAssign = 73, 
		RULE_verbatim_block = 74, RULE_loop_action = 75, RULE_html = 76;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "general_statement", "inline_statement", "inline_directive", 
			"block_statement", "non_blade_statement", "extends", "section_inline", 
			"section", "push", "pushOnce", "pushIf", "prepend", "fragmentD", "if", 
			"elseif", "else", "endif", "empty_block", "conditional_block", "auth_block", 
			"env_block", "permission", "error_block", "switch", "while", "for", "foreach", 
			"forelse", "yieldD", "stack", "useD", "inject", "include", "includeIf", 
			"includeCond", "includeFirst", "each", "once_block", "hasSection", "sectionMissing", 
			"custom_directive", "possibleDirective", "php_blade", "phpInline", "regular_echo", 
			"raw_echo", "echo_expr", "class_expr_usage", "class_alias_static_access", 
			"static_direct_class_access", "class_instance", "class_name_reference", 
			"class_identifier", "namespacePath", "method_call", "function_call", 
			"php_expression", "loop_expression", "main_php_expression", "composed_php_expression", 
			"simple_foreach_expr", "singleArgWrapper", "singleArgWrapperNovar", "singleArgAndDefaultWrapper", 
			"doubleArgWrapper", "doubleIfArgWrapper", "multiArgWrapper", "identifiableArgument", 
			"composedArgument", "phpExpr", "identifiableArray", "arrayDefine", "paramAssign", 
			"verbatim_block", "loop_action", "html"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'@if'", "'@elseif'", "'@else'", "'@endif'", "'@switch'", 
			"'@case'", "'@default'", "'@endswitch'", "'@empty'", "'@endempty'", null, 
			null, "'@foreach'", "'@endforeach'", "'@for'", "'@endfor'", "'@forelse'", 
			"'@endforelse'", "'@while'", "'@endwhile'", "'@break'", null, "'@include'", 
			"'@includeIf'", "'@includeWhen'", "'@includeFirst'", "'@includeUnless'", 
			"'@each'", "'@extends'", "'@js'", "'@section'", "'@hasSection'", "'@sectionMissing'", 
			"'@endsection'", "'@yield'", "'@parent'", "'@show'", "'@overwrite'", 
			"'@stop'", "'@append'", "'@once'", "'@endonce'", "'@stack'", "'@push'", 
			"'@endpush'", "'@pushIf'", "'@endPushIf'", "'@pushOnce'", "'@endPushOnce'", 
			"'@prepend'", "'@endprepend'", "'@props'", "'@fragment'", "'@endfragment'", 
			"'@csrf'", "'@method'", "'@error'", "'@enderror'", "'@production'", "'@endproduction'", 
			"'@env'", "'@endenv'", null, null, null, null, null, "'@class'", "'@style'", 
			null, "'@aware'", "'@json'", "'@dd'", "'@lang'", "'@use'", "'@inject'", 
			null, "'@verbatim'", "'@endverbatim'", null, null, null, "'{{'", "'{!!'", 
			null, "'{{--'", null, null, null, null, null, null, null, null, null, 
			null, null, "'as'", null, null, null, null, "'.'", "','", null, null, 
			null, null, "'@endphp'", "'?>'", null, null, "'--}}'", null, "'{!'", 
			null, null, null, null, null, "'class'", "' '", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PHP_EXPRESSION", "PHP_VARIABLE", "PHP_KEYWORD", "PHP_NEW", "PHP_WS", 
			"PHP_IDENTIFIER", "PHP_NAMESPACE_PATH", "PHP_STATIC_ACCESS", "PHP_CLASS_KEYWORD", 
			"PHP_INSTANCE_ACCESS", "BLADE_PARAM_EXTRA", "BLADE_PARAM_LPAREN", "BLADE_PARAM_RPAREN", 
			"BLADE_EXPR_LPAREN", "BLADE_EXPR_RPAREN", "BL_SQ_LPAREN", "BL_SQ_LRAREN", 
			"BL_PARAM_STRING", "BL_PARAM_ASSIGN", "BL_COMMA", "BL_PARAM_COMMA", "PHP_EXPR_STRING", 
			"ERROR", "HTML", "BLADE_COMMENT", "D_IF", "D_ELSEIF", "D_ELSE", "D_ENDIF", 
			"D_SWITCH", "D_CASE", "D_DEFAULT", "D_ENDSWITCH", "D_EMPTY", "D_ENDEMPTY", 
			"D_COND_BLOCK_START", "D_COND_BLOCK_END", "D_FOREACH", "D_ENDFOREACH", 
			"D_FOR", "D_ENDFOR", "D_FORELSE", "D_ENDFORELSE", "D_WHILE", "D_ENDWHILE", 
			"D_BREAK", "D_LOOP_ACTION", "D_INCLUDE", "D_INCLUDE_IF", "D_INCLUDE_WHEN", 
			"D_INCLUDE_FIRST", "D_INCLUDE_UNLESS", "D_EACH", "D_EXTENDS", "D_JS", 
			"D_SECTION", "D_HAS_SECTION", "D_SECTION_MISSING", "D_ENDSECTION", "D_YIELD", 
			"D_PARENT", "D_SHOW", "D_OVERWRITE", "D_STOP", "D_APPEND", "D_ONCE", 
			"D_ENDONCE", "D_STACK", "D_PUSH", "D_ENDPUSH", "D_PUSH_IF", "D_ENDPUSH_IF", 
			"D_PUSH_ONCE", "D_ENDPUSH_ONCE", "D_PREPEND", "D_ENDPREPEND", "D_PROPS", 
			"D_FRAGMENT", "D_ENDFRAGMENT", "D_CSRF", "D_METHOD", "D_ERROR", "D_ENDERROR", 
			"D_PRODUCTION", "D_ENDPRODUCTION", "D_ENV", "D_ENDENV", "D_AUTH_START", 
			"D_AUTH_END", "D_PERMISSION_START", "D_PERMISSION_ELSE", "D_PERMISSION_END", 
			"D_CLASS", "D_STYLE", "D_HTML_ATTR_EXPR", "D_AWARE", "D_JSON", "D_DD", 
			"D_LANG", "D_USE", "D_INJECT", "D_PHP", "D_VERBATIM", "D_ENDVERBATIM", 
			"D_LIVEWIRE", "D_CUSTOM", "D_UNKNOWN", "CONTENT_TAG_OPEN", "RAW_TAG_OPEN", 
			"PHP_INLINE_START", "BLADE_COMMENT_START", "CONTENT_TAG_CLOSE", "RAW_TAG_CLOSE", 
			"WS_EXPR_ESCAPE", "WS_EXPR", "WS_COMPOSED_EXPR", "EXPR_STRING", "COMPOSED_EXPR_RPAREN", 
			"WS_BL_PARAM", "FOREACH_WS_EXPR", "FOREACH_LOOP_LPAREN", "FOREACH_LOOP_RPAREN", 
			"FOREACH_AS", "FOREACH_PARAM_ASSIGN", "BL_PARAM_LINE_COMMENT", "BL_SQ_RPAREN", 
			"BL_PARAM_RPAREN", "BL_PARAM_CONCAT_OPERATOR", "BL_COMMA_EL", "BL_PARAM_WS", 
			"BL_NAME_STRING", "PHP_D_BLADE_COMMENT", "PHP_D_BLADE_ML_COMMENT", "D_ENDPHP", 
			"PHP_EXIT", "PHP_INLINE_COMMENT", "PHP_INLINE_ML_COMMENT", "BLADE_COMMENT_END", 
			"AT", "RAW_TAG_START", "REGULAR_ECHO_STATIC_ACCESS", "REGULAR_ECHO_LPAREN", 
			"REGULAR_ECHO_RPAREN", "PHP_D_EXPR_CURLY_LPAREN", "PHP_D_EXPR_CURLY_RPAREN", 
			"PHP_D_CLASS", "PHP_D_WS", "PHP_COMPOSED_EXPR_INSTANCE_ACCESS"
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

	public static int bladeVersion = 10;
	public BladeAntlrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BladeAntlrParser.EOF, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
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
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0) {
				{
				{
				setState(154);
				general_statement();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160);
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
	public static class General_statementContext extends ParserRuleContext {
		public Inline_statementContext inline_statement() {
			return getRuleContext(Inline_statementContext.class,0);
		}
		public Block_statementContext block_statement() {
			return getRuleContext(Block_statementContext.class,0);
		}
		public HtmlContext html() {
			return getRuleContext(HtmlContext.class,0);
		}
		public General_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterGeneral_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitGeneral_statement(this);
		}
	}

	public final General_statementContext general_statement() throws RecognitionException {
		General_statementContext _localctx = new General_statementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_general_statement);
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				inline_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				block_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				html();
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
	public static class Inline_statementContext extends ParserRuleContext {
		public Inline_directiveContext inline_directive() {
			return getRuleContext(Inline_directiveContext.class,0);
		}
		public PossibleDirectiveContext possibleDirective() {
			return getRuleContext(PossibleDirectiveContext.class,0);
		}
		public Regular_echoContext regular_echo() {
			return getRuleContext(Regular_echoContext.class,0);
		}
		public Raw_echoContext raw_echo() {
			return getRuleContext(Raw_echoContext.class,0);
		}
		public PhpInlineContext phpInline() {
			return getRuleContext(PhpInlineContext.class,0);
		}
		public TerminalNode BLADE_COMMENT_START() { return getToken(BladeAntlrParser.BLADE_COMMENT_START, 0); }
		public TerminalNode BLADE_COMMENT_END() { return getToken(BladeAntlrParser.BLADE_COMMENT_END, 0); }
		public List<TerminalNode> BLADE_COMMENT() { return getTokens(BladeAntlrParser.BLADE_COMMENT); }
		public TerminalNode BLADE_COMMENT(int i) {
			return getToken(BladeAntlrParser.BLADE_COMMENT, i);
		}
		public Inline_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterInline_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitInline_statement(this);
		}
	}

	public final Inline_statementContext inline_statement() throws RecognitionException {
		Inline_statementContext _localctx = new Inline_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_inline_statement);
		int _la;
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_CASE:
			case D_DEFAULT:
			case D_BREAK:
			case D_LOOP_ACTION:
			case D_INCLUDE:
			case D_INCLUDE_IF:
			case D_INCLUDE_WHEN:
			case D_INCLUDE_FIRST:
			case D_INCLUDE_UNLESS:
			case D_EACH:
			case D_EXTENDS:
			case D_JS:
			case D_SECTION:
			case D_YIELD:
			case D_STACK:
			case D_PROPS:
			case D_CSRF:
			case D_METHOD:
			case D_PERMISSION_ELSE:
			case D_CLASS:
			case D_STYLE:
			case D_HTML_ATTR_EXPR:
			case D_AWARE:
			case D_JSON:
			case D_DD:
			case D_LANG:
			case D_USE:
			case D_INJECT:
			case D_LIVEWIRE:
			case D_CUSTOM:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				inline_directive();
				}
				break;
			case D_UNKNOWN:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				possibleDirective();
				}
				break;
			case CONTENT_TAG_OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				regular_echo();
				}
				break;
			case RAW_TAG_OPEN:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				raw_echo();
				}
				break;
			case PHP_INLINE_START:
				enterOuterAlt(_localctx, 5);
				{
				setState(171);
				phpInline();
				}
				break;
			case BLADE_COMMENT_START:
				enterOuterAlt(_localctx, 6);
				{
				setState(172);
				match(BLADE_COMMENT_START);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BLADE_COMMENT) {
					{
					{
					setState(173);
					match(BLADE_COMMENT);
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(179);
				match(BLADE_COMMENT_END);
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
	public static class Inline_directiveContext extends ParserRuleContext {
		public ExtendsContext extends_() {
			return getRuleContext(ExtendsContext.class,0);
		}
		public Section_inlineContext section_inline() {
			return getRuleContext(Section_inlineContext.class,0);
		}
		public YieldDContext yieldD() {
			return getRuleContext(YieldDContext.class,0);
		}
		public StackContext stack() {
			return getRuleContext(StackContext.class,0);
		}
		public IncludeContext include() {
			return getRuleContext(IncludeContext.class,0);
		}
		public IncludeIfContext includeIf() {
			return getRuleContext(IncludeIfContext.class,0);
		}
		public IncludeCondContext includeCond() {
			return getRuleContext(IncludeCondContext.class,0);
		}
		public IncludeFirstContext includeFirst() {
			return getRuleContext(IncludeFirstContext.class,0);
		}
		public EachContext each() {
			return getRuleContext(EachContext.class,0);
		}
		public Composed_php_expressionContext composed_php_expression() {
			return getRuleContext(Composed_php_expressionContext.class,0);
		}
		public TerminalNode D_CLASS() { return getToken(BladeAntlrParser.D_CLASS, 0); }
		public TerminalNode D_STYLE() { return getToken(BladeAntlrParser.D_STYLE, 0); }
		public TerminalNode D_METHOD() { return getToken(BladeAntlrParser.D_METHOD, 0); }
		public TerminalNode D_PROPS() { return getToken(BladeAntlrParser.D_PROPS, 0); }
		public TerminalNode D_DD() { return getToken(BladeAntlrParser.D_DD, 0); }
		public TerminalNode D_JS() { return getToken(BladeAntlrParser.D_JS, 0); }
		public TerminalNode D_AWARE() { return getToken(BladeAntlrParser.D_AWARE, 0); }
		public TerminalNode D_CSRF() { return getToken(BladeAntlrParser.D_CSRF, 0); }
		public UseDContext useD() {
			return getRuleContext(UseDContext.class,0);
		}
		public InjectContext inject() {
			return getRuleContext(InjectContext.class,0);
		}
		public TerminalNode D_HTML_ATTR_EXPR() { return getToken(BladeAntlrParser.D_HTML_ATTR_EXPR, 0); }
		public TerminalNode D_CASE() { return getToken(BladeAntlrParser.D_CASE, 0); }
		public TerminalNode D_JSON() { return getToken(BladeAntlrParser.D_JSON, 0); }
		public TerminalNode D_DEFAULT() { return getToken(BladeAntlrParser.D_DEFAULT, 0); }
		public TerminalNode D_PERMISSION_ELSE() { return getToken(BladeAntlrParser.D_PERMISSION_ELSE, 0); }
		public Loop_actionContext loop_action() {
			return getRuleContext(Loop_actionContext.class,0);
		}
		public TerminalNode D_LANG() { return getToken(BladeAntlrParser.D_LANG, 0); }
		public SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() {
			return getRuleContext(SingleArgAndDefaultWrapperContext.class,0);
		}
		public TerminalNode D_LOOP_ACTION() { return getToken(BladeAntlrParser.D_LOOP_ACTION, 0); }
		public TerminalNode D_BREAK() { return getToken(BladeAntlrParser.D_BREAK, 0); }
		public TerminalNode D_LIVEWIRE() { return getToken(BladeAntlrParser.D_LIVEWIRE, 0); }
		public Custom_directiveContext custom_directive() {
			return getRuleContext(Custom_directiveContext.class,0);
		}
		public Inline_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterInline_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitInline_directive(this);
		}
	}

	public final Inline_directiveContext inline_directive() throws RecognitionException {
		Inline_directiveContext _localctx = new Inline_directiveContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_inline_directive);
		int _la;
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				extends_();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				section_inline();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				yieldD();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				stack();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(186);
				include();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(187);
				includeIf();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(188);
				includeCond();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(189);
				includeFirst();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(190);
				each();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(191);
				_la = _input.LA(1);
				if ( !(_la==D_CLASS || _la==D_STYLE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(192);
				composed_php_expression();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				{
				setState(193);
				match(D_METHOD);
				}
				setState(194);
				composed_php_expression();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(195);
				match(D_PROPS);
				setState(196);
				composed_php_expression();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(197);
				match(D_DD);
				setState(198);
				composed_php_expression();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(199);
				match(D_JS);
				setState(200);
				composed_php_expression();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(201);
				match(D_AWARE);
				setState(202);
				composed_php_expression();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(203);
				match(D_CSRF);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(204);
				useD();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(205);
				inject();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(206);
				match(D_HTML_ATTR_EXPR);
				setState(207);
				composed_php_expression();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(208);
				match(D_CASE);
				setState(209);
				composed_php_expression();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(210);
				match(D_JSON);
				setState(211);
				composed_php_expression();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(212);
				match(D_DEFAULT);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(213);
				match(D_PERMISSION_ELSE);
				setState(214);
				composed_php_expression();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(215);
				loop_action();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(216);
				match(D_LANG);
				setState(217);
				singleArgAndDefaultWrapper();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(218);
				match(D_LOOP_ACTION);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(219);
				match(D_BREAK);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(220);
				match(D_LIVEWIRE);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(221);
				custom_directive();
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
	public static class Block_statementContext extends ParserRuleContext {
		public SectionContext section() {
			return getRuleContext(SectionContext.class,0);
		}
		public HasSectionContext hasSection() {
			return getRuleContext(HasSectionContext.class,0);
		}
		public SectionMissingContext sectionMissing() {
			return getRuleContext(SectionMissingContext.class,0);
		}
		public PushContext push() {
			return getRuleContext(PushContext.class,0);
		}
		public PushIfContext pushIf() {
			return getRuleContext(PushIfContext.class,0);
		}
		public Once_blockContext once_block() {
			return getRuleContext(Once_blockContext.class,0);
		}
		public PrependContext prepend() {
			return getRuleContext(PrependContext.class,0);
		}
		public FragmentDContext fragmentD() {
			return getRuleContext(FragmentDContext.class,0);
		}
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public ElseifContext elseif() {
			return getRuleContext(ElseifContext.class,0);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public SwitchContext switch_() {
			return getRuleContext(SwitchContext.class,0);
		}
		public Env_blockContext env_block() {
			return getRuleContext(Env_blockContext.class,0);
		}
		public Error_blockContext error_block() {
			return getRuleContext(Error_blockContext.class,0);
		}
		public Conditional_blockContext conditional_block() {
			return getRuleContext(Conditional_blockContext.class,0);
		}
		public Auth_blockContext auth_block() {
			return getRuleContext(Auth_blockContext.class,0);
		}
		public PermissionContext permission() {
			return getRuleContext(PermissionContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public ForContext for_() {
			return getRuleContext(ForContext.class,0);
		}
		public ForeachContext foreach() {
			return getRuleContext(ForeachContext.class,0);
		}
		public ForelseContext forelse() {
			return getRuleContext(ForelseContext.class,0);
		}
		public Verbatim_blockContext verbatim_block() {
			return getRuleContext(Verbatim_blockContext.class,0);
		}
		public Php_bladeContext php_blade() {
			return getRuleContext(Php_bladeContext.class,0);
		}
		public Block_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterBlock_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitBlock_statement(this);
		}
	}

	public final Block_statementContext block_statement() throws RecognitionException {
		Block_statementContext _localctx = new Block_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block_statement);
		try {
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				section();
				}
				break;
			case D_HAS_SECTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				hasSection();
				}
				break;
			case D_SECTION_MISSING:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				sectionMissing();
				}
				break;
			case D_PUSH:
				enterOuterAlt(_localctx, 4);
				{
				setState(227);
				push();
				}
				break;
			case D_PUSH_IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(228);
				pushIf();
				}
				break;
			case D_ONCE:
				enterOuterAlt(_localctx, 6);
				{
				setState(229);
				once_block();
				}
				break;
			case D_PREPEND:
				enterOuterAlt(_localctx, 7);
				{
				setState(230);
				prepend();
				}
				break;
			case D_FRAGMENT:
				enterOuterAlt(_localctx, 8);
				{
				setState(231);
				fragmentD();
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 9);
				{
				setState(232);
				if_();
				}
				break;
			case D_ELSEIF:
				enterOuterAlt(_localctx, 10);
				{
				setState(233);
				elseif();
				}
				break;
			case D_ELSE:
				enterOuterAlt(_localctx, 11);
				{
				setState(234);
				else_();
				}
				break;
			case D_SWITCH:
				enterOuterAlt(_localctx, 12);
				{
				setState(235);
				switch_();
				}
				break;
			case D_PRODUCTION:
			case D_ENV:
				enterOuterAlt(_localctx, 13);
				{
				setState(236);
				env_block();
				}
				break;
			case D_ERROR:
				enterOuterAlt(_localctx, 14);
				{
				setState(237);
				error_block();
				}
				break;
			case D_COND_BLOCK_START:
				enterOuterAlt(_localctx, 15);
				{
				setState(238);
				conditional_block();
				}
				break;
			case D_AUTH_START:
				enterOuterAlt(_localctx, 16);
				{
				setState(239);
				auth_block();
				}
				break;
			case D_PERMISSION_START:
				enterOuterAlt(_localctx, 17);
				{
				setState(240);
				permission();
				}
				break;
			case D_WHILE:
				enterOuterAlt(_localctx, 18);
				{
				setState(241);
				while_();
				}
				break;
			case D_FOR:
				enterOuterAlt(_localctx, 19);
				{
				setState(242);
				for_();
				}
				break;
			case D_FOREACH:
				enterOuterAlt(_localctx, 20);
				{
				setState(243);
				foreach();
				}
				break;
			case D_FORELSE:
				enterOuterAlt(_localctx, 21);
				{
				setState(244);
				forelse();
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 22);
				{
				setState(245);
				verbatim_block();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 23);
				{
				setState(246);
				php_blade();
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
	public static class Non_blade_statementContext extends ParserRuleContext {
		public HtmlContext html() {
			return getRuleContext(HtmlContext.class,0);
		}
		public PhpInlineContext phpInline() {
			return getRuleContext(PhpInlineContext.class,0);
		}
		public Non_blade_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_blade_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterNon_blade_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitNon_blade_statement(this);
		}
	}

	public final Non_blade_statementContext non_blade_statement() throws RecognitionException {
		Non_blade_statementContext _localctx = new Non_blade_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_non_blade_statement);
		try {
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				html();
				}
				break;
			case PHP_INLINE_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				phpInline();
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
	public static class ExtendsContext extends ParserRuleContext {
		public TerminalNode D_EXTENDS() { return getToken(BladeAntlrParser.D_EXTENDS, 0); }
		public SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() {
			return getRuleContext(SingleArgAndDefaultWrapperContext.class,0);
		}
		public ExtendsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extends; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterExtends(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitExtends(this);
		}
	}

	public final ExtendsContext extends_() throws RecognitionException {
		ExtendsContext _localctx = new ExtendsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_extends);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(D_EXTENDS);
			setState(254);
			singleArgAndDefaultWrapper();
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
	public static class Section_inlineContext extends ParserRuleContext {
		public TerminalNode D_SECTION() { return getToken(BladeAntlrParser.D_SECTION, 0); }
		public DoubleArgWrapperContext doubleArgWrapper() {
			return getRuleContext(DoubleArgWrapperContext.class,0);
		}
		public Section_inlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section_inline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSection_inline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSection_inline(this);
		}
	}

	public final Section_inlineContext section_inline() throws RecognitionException {
		Section_inlineContext _localctx = new Section_inlineContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_section_inline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(D_SECTION);
			setState(257);
			doubleArgWrapper();
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
	public static class SectionContext extends ParserRuleContext {
		public TerminalNode D_SECTION() { return getToken(BladeAntlrParser.D_SECTION, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public TerminalNode D_SHOW() { return getToken(BladeAntlrParser.D_SHOW, 0); }
		public TerminalNode D_STOP() { return getToken(BladeAntlrParser.D_STOP, 0); }
		public TerminalNode D_OVERWRITE() { return getToken(BladeAntlrParser.D_OVERWRITE, 0); }
		public TerminalNode D_ENDSECTION() { return getToken(BladeAntlrParser.D_ENDSECTION, 0); }
		public TerminalNode D_APPEND() { return getToken(BladeAntlrParser.D_APPEND, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public List<TerminalNode> D_PARENT() { return getTokens(BladeAntlrParser.D_PARENT); }
		public TerminalNode D_PARENT(int i) {
			return getToken(BladeAntlrParser.D_PARENT, i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSection(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(D_SECTION);
			setState(260);
			singleArgWrapper();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4035178338724085760L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0) {
				{
				setState(263);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case HTML:
				case D_IF:
				case D_ELSEIF:
				case D_ELSE:
				case D_SWITCH:
				case D_CASE:
				case D_DEFAULT:
				case D_COND_BLOCK_START:
				case D_FOREACH:
				case D_FOR:
				case D_FORELSE:
				case D_WHILE:
				case D_BREAK:
				case D_LOOP_ACTION:
				case D_INCLUDE:
				case D_INCLUDE_IF:
				case D_INCLUDE_WHEN:
				case D_INCLUDE_FIRST:
				case D_INCLUDE_UNLESS:
				case D_EACH:
				case D_EXTENDS:
				case D_JS:
				case D_SECTION:
				case D_HAS_SECTION:
				case D_SECTION_MISSING:
				case D_YIELD:
				case D_ONCE:
				case D_STACK:
				case D_PUSH:
				case D_PUSH_IF:
				case D_PREPEND:
				case D_PROPS:
				case D_FRAGMENT:
				case D_CSRF:
				case D_METHOD:
				case D_ERROR:
				case D_PRODUCTION:
				case D_ENV:
				case D_AUTH_START:
				case D_PERMISSION_START:
				case D_PERMISSION_ELSE:
				case D_CLASS:
				case D_STYLE:
				case D_HTML_ATTR_EXPR:
				case D_AWARE:
				case D_JSON:
				case D_DD:
				case D_LANG:
				case D_USE:
				case D_INJECT:
				case D_PHP:
				case D_VERBATIM:
				case D_LIVEWIRE:
				case D_CUSTOM:
				case D_UNKNOWN:
				case CONTENT_TAG_OPEN:
				case RAW_TAG_OPEN:
				case PHP_INLINE_START:
				case BLADE_COMMENT_START:
					{
					setState(261);
					general_statement();
					}
					break;
				case D_PARENT:
					{
					setState(262);
					match(D_PARENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(268);
			_la = _input.LA(1);
			if ( !((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & 121L) != 0) ) {
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
	public static class PushContext extends ParserRuleContext {
		public TerminalNode D_PUSH() { return getToken(BladeAntlrParser.D_PUSH, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public TerminalNode D_ENDPUSH() { return getToken(BladeAntlrParser.D_ENDPUSH, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public PushContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_push; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPush(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPush(this);
		}
	}

	public final PushContext push() throws RecognitionException {
		PushContext _localctx = new PushContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_push);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(D_PUSH);
			setState(271);
			singleArgWrapper();
			setState(273); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(272);
				general_statement();
				}
				}
				setState(275); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(277);
			match(D_ENDPUSH);
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
	public static class PushOnceContext extends ParserRuleContext {
		public TerminalNode D_PUSH_ONCE() { return getToken(BladeAntlrParser.D_PUSH_ONCE, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public TerminalNode D_ENDPUSH_ONCE() { return getToken(BladeAntlrParser.D_ENDPUSH_ONCE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public PushOnceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pushOnce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPushOnce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPushOnce(this);
		}
	}

	public final PushOnceContext pushOnce() throws RecognitionException {
		PushOnceContext _localctx = new PushOnceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pushOnce);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(D_PUSH_ONCE);
			setState(280);
			singleArgWrapper();
			setState(282); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(281);
				general_statement();
				}
				}
				setState(284); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(286);
			match(D_ENDPUSH_ONCE);
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
	public static class PushIfContext extends ParserRuleContext {
		public TerminalNode D_PUSH_IF() { return getToken(BladeAntlrParser.D_PUSH_IF, 0); }
		public DoubleIfArgWrapperContext doubleIfArgWrapper() {
			return getRuleContext(DoubleIfArgWrapperContext.class,0);
		}
		public TerminalNode D_ENDPUSH_IF() { return getToken(BladeAntlrParser.D_ENDPUSH_IF, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public PushIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pushIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPushIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPushIf(this);
		}
	}

	public final PushIfContext pushIf() throws RecognitionException {
		PushIfContext _localctx = new PushIfContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pushIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(D_PUSH_IF);
			setState(289);
			doubleIfArgWrapper();
			setState(291); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(290);
				general_statement();
				}
				}
				setState(293); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(295);
			match(D_ENDPUSH_IF);
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
	public static class PrependContext extends ParserRuleContext {
		public TerminalNode D_PREPEND() { return getToken(BladeAntlrParser.D_PREPEND, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public TerminalNode D_ENDPREPEND() { return getToken(BladeAntlrParser.D_ENDPREPEND, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public PrependContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prepend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPrepend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPrepend(this);
		}
	}

	public final PrependContext prepend() throws RecognitionException {
		PrependContext _localctx = new PrependContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_prepend);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(D_PREPEND);
			setState(298);
			singleArgWrapper();
			setState(300); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(299);
				general_statement();
				}
				}
				setState(302); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(304);
			match(D_ENDPREPEND);
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
	public static class FragmentDContext extends ParserRuleContext {
		public String version = "10";
		public TerminalNode D_FRAGMENT() { return getToken(BladeAntlrParser.D_FRAGMENT, 0); }
		public Composed_php_expressionContext composed_php_expression() {
			return getRuleContext(Composed_php_expressionContext.class,0);
		}
		public TerminalNode D_ENDFRAGMENT() { return getToken(BladeAntlrParser.D_ENDFRAGMENT, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public FragmentDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fragmentD; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterFragmentD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitFragmentD(this);
		}
	}

	public final FragmentDContext fragmentD() throws RecognitionException {
		FragmentDContext _localctx = new FragmentDContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fragmentD);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(D_FRAGMENT);
			setState(307);
			composed_php_expression();
			setState(309); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(308);
				general_statement();
				}
				}
				setState(311); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(313);
			match(D_ENDFRAGMENT);
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
	public static class IfContext extends ParserRuleContext {
		public TerminalNode D_IF() { return getToken(BladeAntlrParser.D_IF, 0); }
		public Main_php_expressionContext main_php_expression() {
			return getRuleContext(Main_php_expressionContext.class,0);
		}
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public EndifContext endif() {
			return getRuleContext(EndifContext.class,0);
		}
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIf(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_if);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(D_IF);
			setState(316);
			main_php_expression();
			setState(318); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(317);
					general_statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(320); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(323);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(322);
				endif();
				}
				break;
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
	public static class ElseifContext extends ParserRuleContext {
		public TerminalNode D_ELSEIF() { return getToken(BladeAntlrParser.D_ELSEIF, 0); }
		public Main_php_expressionContext main_php_expression() {
			return getRuleContext(Main_php_expressionContext.class,0);
		}
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public EndifContext endif() {
			return getRuleContext(EndifContext.class,0);
		}
		public ElseifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterElseif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitElseif(this);
		}
	}

	public final ElseifContext elseif() throws RecognitionException {
		ElseifContext _localctx = new ElseifContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_elseif);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(D_ELSEIF);
			setState(326);
			main_php_expression();
			setState(328); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(327);
					general_statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(330); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(332);
				endif();
				}
				break;
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
	public static class ElseContext extends ParserRuleContext {
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public EndifContext endif() {
			return getRuleContext(EndifContext.class,0);
		}
		public ElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitElse(this);
		}
	}

	public final ElseContext else_() throws RecognitionException {
		ElseContext _localctx = new ElseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_else);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(D_ELSE);
			setState(337); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(336);
					general_statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(339); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(342);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(341);
				endif();
				}
				break;
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
	public static class EndifContext extends ParserRuleContext {
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrParser.D_ENDIF, 0); }
		public EndifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterEndif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitEndif(this);
		}
	}

	public final EndifContext endif() throws RecognitionException {
		EndifContext _localctx = new EndifContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_endif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
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
	public static class Empty_blockContext extends ParserRuleContext {
		public TerminalNode D_EMPTY() { return getToken(BladeAntlrParser.D_EMPTY, 0); }
		public Main_php_expressionContext main_php_expression() {
			return getRuleContext(Main_php_expressionContext.class,0);
		}
		public TerminalNode D_ENDEMPTY() { return getToken(BladeAntlrParser.D_ENDEMPTY, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public Empty_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterEmpty_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitEmpty_block(this);
		}
	}

	public final Empty_blockContext empty_block() throws RecognitionException {
		Empty_blockContext _localctx = new Empty_blockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_empty_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(D_EMPTY);
			setState(347);
			main_php_expression();
			setState(349); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(348);
				general_statement();
				}
				}
				setState(351); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(353);
			match(D_ENDEMPTY);
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
	public static class Conditional_blockContext extends ParserRuleContext {
		public TerminalNode D_COND_BLOCK_START() { return getToken(BladeAntlrParser.D_COND_BLOCK_START, 0); }
		public Main_php_expressionContext main_php_expression() {
			return getRuleContext(Main_php_expressionContext.class,0);
		}
		public TerminalNode D_COND_BLOCK_END() { return getToken(BladeAntlrParser.D_COND_BLOCK_END, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public Conditional_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterConditional_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitConditional_block(this);
		}
	}

	public final Conditional_blockContext conditional_block() throws RecognitionException {
		Conditional_blockContext _localctx = new Conditional_blockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_conditional_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(D_COND_BLOCK_START);
			setState(356);
			main_php_expression();
			setState(358); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(357);
				general_statement();
				}
				}
				setState(360); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(362);
			match(D_COND_BLOCK_END);
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
	public static class Auth_blockContext extends ParserRuleContext {
		public TerminalNode D_AUTH_START() { return getToken(BladeAntlrParser.D_AUTH_START, 0); }
		public TerminalNode D_AUTH_END() { return getToken(BladeAntlrParser.D_AUTH_END, 0); }
		public List<SingleArgWrapperNovarContext> singleArgWrapperNovar() {
			return getRuleContexts(SingleArgWrapperNovarContext.class);
		}
		public SingleArgWrapperNovarContext singleArgWrapperNovar(int i) {
			return getRuleContext(SingleArgWrapperNovarContext.class,i);
		}
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public Auth_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_auth_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterAuth_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitAuth_block(this);
		}
	}

	public final Auth_blockContext auth_block() throws RecognitionException {
		Auth_blockContext _localctx = new Auth_blockContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_auth_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(D_AUTH_START);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BLADE_PARAM_LPAREN) {
				{
				{
				setState(365);
				singleArgWrapperNovar();
				}
				}
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(372); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(371);
				general_statement();
				}
				}
				setState(374); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(376);
			match(D_AUTH_END);
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
	public static class Env_blockContext extends ParserRuleContext {
		public TerminalNode D_ENV() { return getToken(BladeAntlrParser.D_ENV, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public TerminalNode D_ENDENV() { return getToken(BladeAntlrParser.D_ENDENV, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public TerminalNode D_PRODUCTION() { return getToken(BladeAntlrParser.D_PRODUCTION, 0); }
		public TerminalNode D_ENDPRODUCTION() { return getToken(BladeAntlrParser.D_ENDPRODUCTION, 0); }
		public Env_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_env_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterEnv_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitEnv_block(this);
		}
	}

	public final Env_blockContext env_block() throws RecognitionException {
		Env_blockContext _localctx = new Env_blockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_env_block);
		int _la;
		try {
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_ENV:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(378);
				match(D_ENV);
				setState(379);
				singleArgWrapper();
				setState(381); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(380);
					general_statement();
					}
					}
					setState(383); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
				setState(385);
				match(D_ENDENV);
				}
				}
				break;
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
				match(D_PRODUCTION);
				setState(389); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(388);
					general_statement();
					}
					}
					setState(391); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
				setState(393);
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
	public static class PermissionContext extends ParserRuleContext {
		public TerminalNode D_PERMISSION_START() { return getToken(BladeAntlrParser.D_PERMISSION_START, 0); }
		public Composed_php_expressionContext composed_php_expression() {
			return getRuleContext(Composed_php_expressionContext.class,0);
		}
		public TerminalNode D_PERMISSION_END() { return getToken(BladeAntlrParser.D_PERMISSION_END, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public PermissionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_permission; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPermission(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPermission(this);
		}
	}

	public final PermissionContext permission() throws RecognitionException {
		PermissionContext _localctx = new PermissionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_permission);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(D_PERMISSION_START);
			setState(398);
			composed_php_expression();
			setState(400); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(399);
				general_statement();
				}
				}
				setState(402); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(404);
			match(D_PERMISSION_END);
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
	public static class Error_blockContext extends ParserRuleContext {
		public TerminalNode D_ERROR() { return getToken(BladeAntlrParser.D_ERROR, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ENDERROR() { return getToken(BladeAntlrParser.D_ENDERROR, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public Error_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterError_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitError_block(this);
		}
	}

	public final Error_blockContext error_block() throws RecognitionException {
		Error_blockContext _localctx = new Error_blockContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_error_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(D_ERROR);
			setState(407);
			php_expression();
			setState(409); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(408);
				general_statement();
				}
				}
				setState(411); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(413);
			match(D_ENDERROR);
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
	public static class SwitchContext extends ParserRuleContext {
		public TerminalNode D_SWITCH() { return getToken(BladeAntlrParser.D_SWITCH, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ENDSWITCH() { return getToken(BladeAntlrParser.D_ENDSWITCH, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public List<TerminalNode> D_BREAK() { return getTokens(BladeAntlrParser.D_BREAK); }
		public TerminalNode D_BREAK(int i) {
			return getToken(BladeAntlrParser.D_BREAK, i);
		}
		public SwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSwitch(this);
		}
	}

	public final SwitchContext switch_() throws RecognitionException {
		SwitchContext _localctx = new SwitchContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_switch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(D_SWITCH);
			setState(416);
			php_expression();
			setState(419); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(419);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(417);
					general_statement();
					}
					break;
				case 2:
					{
					setState(418);
					match(D_BREAK);
					}
					break;
				}
				}
				setState(421); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(423);
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
	public static class WhileContext extends ParserRuleContext {
		public TerminalNode D_WHILE() { return getToken(BladeAntlrParser.D_WHILE, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ENDWHILE() { return getToken(BladeAntlrParser.D_ENDWHILE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitWhile(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(D_WHILE);
			setState(426);
			php_expression();
			setState(428); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(427);
				general_statement();
				}
				}
				setState(430); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(432);
			match(D_ENDWHILE);
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
	public static class ForContext extends ParserRuleContext {
		public TerminalNode D_FOR() { return getToken(BladeAntlrParser.D_FOR, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ENDFOR() { return getToken(BladeAntlrParser.D_ENDFOR, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public ForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitFor(this);
		}
	}

	public final ForContext for_() throws RecognitionException {
		ForContext _localctx = new ForContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_for);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			match(D_FOR);
			setState(435);
			php_expression();
			setState(437); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(436);
				general_statement();
				}
				}
				setState(439); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(441);
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
	public static class ForeachContext extends ParserRuleContext {
		public TerminalNode D_FOREACH() { return getToken(BladeAntlrParser.D_FOREACH, 0); }
		public TerminalNode FOREACH_LOOP_LPAREN() { return getToken(BladeAntlrParser.FOREACH_LOOP_LPAREN, 0); }
		public Loop_expressionContext loop_expression() {
			return getRuleContext(Loop_expressionContext.class,0);
		}
		public TerminalNode FOREACH_LOOP_RPAREN() { return getToken(BladeAntlrParser.FOREACH_LOOP_RPAREN, 0); }
		public TerminalNode D_ENDFOREACH() { return getToken(BladeAntlrParser.D_ENDFOREACH, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public ForeachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreach; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterForeach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitForeach(this);
		}
	}

	public final ForeachContext foreach() throws RecognitionException {
		ForeachContext _localctx = new ForeachContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_foreach);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(D_FOREACH);
			setState(444);
			match(FOREACH_LOOP_LPAREN);
			setState(445);
			loop_expression();
			setState(446);
			match(FOREACH_LOOP_RPAREN);
			setState(448); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(447);
				general_statement();
				}
				}
				setState(450); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(452);
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
	public static class ForelseContext extends ParserRuleContext {
		public TerminalNode D_FORELSE() { return getToken(BladeAntlrParser.D_FORELSE, 0); }
		public TerminalNode FOREACH_LOOP_LPAREN() { return getToken(BladeAntlrParser.FOREACH_LOOP_LPAREN, 0); }
		public Loop_expressionContext loop_expression() {
			return getRuleContext(Loop_expressionContext.class,0);
		}
		public TerminalNode FOREACH_LOOP_RPAREN() { return getToken(BladeAntlrParser.FOREACH_LOOP_RPAREN, 0); }
		public TerminalNode D_ENDFORELSE() { return getToken(BladeAntlrParser.D_ENDFORELSE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public List<TerminalNode> D_EMPTY() { return getTokens(BladeAntlrParser.D_EMPTY); }
		public TerminalNode D_EMPTY(int i) {
			return getToken(BladeAntlrParser.D_EMPTY, i);
		}
		public ForelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forelse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterForelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitForelse(this);
		}
	}

	public final ForelseContext forelse() throws RecognitionException {
		ForelseContext _localctx = new ForelseContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_forelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(D_FORELSE);
			setState(455);
			match(FOREACH_LOOP_LPAREN);
			setState(456);
			loop_expression();
			setState(457);
			match(FOREACH_LOOP_RPAREN);
			setState(460); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(460);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case HTML:
				case D_IF:
				case D_ELSEIF:
				case D_ELSE:
				case D_SWITCH:
				case D_CASE:
				case D_DEFAULT:
				case D_COND_BLOCK_START:
				case D_FOREACH:
				case D_FOR:
				case D_FORELSE:
				case D_WHILE:
				case D_BREAK:
				case D_LOOP_ACTION:
				case D_INCLUDE:
				case D_INCLUDE_IF:
				case D_INCLUDE_WHEN:
				case D_INCLUDE_FIRST:
				case D_INCLUDE_UNLESS:
				case D_EACH:
				case D_EXTENDS:
				case D_JS:
				case D_SECTION:
				case D_HAS_SECTION:
				case D_SECTION_MISSING:
				case D_YIELD:
				case D_ONCE:
				case D_STACK:
				case D_PUSH:
				case D_PUSH_IF:
				case D_PREPEND:
				case D_PROPS:
				case D_FRAGMENT:
				case D_CSRF:
				case D_METHOD:
				case D_ERROR:
				case D_PRODUCTION:
				case D_ENV:
				case D_AUTH_START:
				case D_PERMISSION_START:
				case D_PERMISSION_ELSE:
				case D_CLASS:
				case D_STYLE:
				case D_HTML_ATTR_EXPR:
				case D_AWARE:
				case D_JSON:
				case D_DD:
				case D_LANG:
				case D_USE:
				case D_INJECT:
				case D_PHP:
				case D_VERBATIM:
				case D_LIVEWIRE:
				case D_CUSTOM:
				case D_UNKNOWN:
				case CONTENT_TAG_OPEN:
				case RAW_TAG_OPEN:
				case PHP_INLINE_START:
				case BLADE_COMMENT_START:
					{
					setState(458);
					general_statement();
					}
					break;
				case D_EMPTY:
					{
					setState(459);
					match(D_EMPTY);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(462); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335346690260992L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(464);
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
	public static class YieldDContext extends ParserRuleContext {
		public TerminalNode D_YIELD() { return getToken(BladeAntlrParser.D_YIELD, 0); }
		public SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() {
			return getRuleContext(SingleArgAndDefaultWrapperContext.class,0);
		}
		public YieldDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yieldD; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterYieldD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitYieldD(this);
		}
	}

	public final YieldDContext yieldD() throws RecognitionException {
		YieldDContext _localctx = new YieldDContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_yieldD);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(D_YIELD);
			setState(467);
			singleArgAndDefaultWrapper();
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
	public static class StackContext extends ParserRuleContext {
		public TerminalNode D_STACK() { return getToken(BladeAntlrParser.D_STACK, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public StackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stack; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterStack(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitStack(this);
		}
	}

	public final StackContext stack() throws RecognitionException {
		StackContext _localctx = new StackContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_stack);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(D_STACK);
			setState(470);
			singleArgWrapper();
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
	public static class UseDContext extends ParserRuleContext {
		public TerminalNode D_USE() { return getToken(BladeAntlrParser.D_USE, 0); }
		public SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() {
			return getRuleContext(SingleArgAndDefaultWrapperContext.class,0);
		}
		public UseDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useD; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterUseD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitUseD(this);
		}
	}

	public final UseDContext useD() throws RecognitionException {
		UseDContext _localctx = new UseDContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_useD);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(D_USE);
			setState(473);
			singleArgAndDefaultWrapper();
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
	public static class InjectContext extends ParserRuleContext {
		public TerminalNode D_INJECT() { return getToken(BladeAntlrParser.D_INJECT, 0); }
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public TerminalNode BL_COMMA() { return getToken(BladeAntlrParser.BL_COMMA, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
		}
		public InjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterInject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitInject(this);
		}
	}

	public final InjectContext inject() throws RecognitionException {
		InjectContext _localctx = new InjectContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_inject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			match(D_INJECT);
			setState(476);
			match(BLADE_PARAM_LPAREN);
			setState(477);
			composedArgument();
			setState(478);
			match(BL_COMMA);
			setState(481);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(479);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(480);
				composedArgument();
				}
				break;
			}
			setState(483);
			match(BLADE_PARAM_RPAREN);
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
	public static class IncludeContext extends ParserRuleContext {
		public TerminalNode D_INCLUDE() { return getToken(BladeAntlrParser.D_INCLUDE, 0); }
		public SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() {
			return getRuleContext(SingleArgAndDefaultWrapperContext.class,0);
		}
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitInclude(this);
		}
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(D_INCLUDE);
			setState(486);
			singleArgAndDefaultWrapper();
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
	public static class IncludeIfContext extends ParserRuleContext {
		public TerminalNode D_INCLUDE_IF() { return getToken(BladeAntlrParser.D_INCLUDE_IF, 0); }
		public SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() {
			return getRuleContext(SingleArgAndDefaultWrapperContext.class,0);
		}
		public IncludeIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIncludeIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIncludeIf(this);
		}
	}

	public final IncludeIfContext includeIf() throws RecognitionException {
		IncludeIfContext _localctx = new IncludeIfContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_includeIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			match(D_INCLUDE_IF);
			setState(489);
			singleArgAndDefaultWrapper();
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
	public static class IncludeCondContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public List<TerminalNode> BL_COMMA() { return getTokens(BladeAntlrParser.BL_COMMA); }
		public TerminalNode BL_COMMA(int i) {
			return getToken(BladeAntlrParser.BL_COMMA, i);
		}
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public TerminalNode D_INCLUDE_WHEN() { return getToken(BladeAntlrParser.D_INCLUDE_WHEN, 0); }
		public TerminalNode D_INCLUDE_UNLESS() { return getToken(BladeAntlrParser.D_INCLUDE_UNLESS, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
		}
		public IncludeCondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeCond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIncludeCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIncludeCond(this);
		}
	}

	public final IncludeCondContext includeCond() throws RecognitionException {
		IncludeCondContext _localctx = new IncludeCondContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_includeCond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			_la = _input.LA(1);
			if ( !(_la==D_INCLUDE_WHEN || _la==D_INCLUDE_UNLESS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(492);
			match(BLADE_PARAM_LPAREN);
			setState(493);
			composedArgument();
			setState(494);
			match(BL_COMMA);
			setState(497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(495);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(496);
				composedArgument();
				}
				break;
			}
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(499);
				match(BL_COMMA);
				setState(500);
				composedArgument();
				}
			}

			setState(503);
			match(BLADE_PARAM_RPAREN);
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
	public static class IncludeFirstContext extends ParserRuleContext {
		public TerminalNode D_INCLUDE_FIRST() { return getToken(BladeAntlrParser.D_INCLUDE_FIRST, 0); }
		public SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() {
			return getRuleContext(SingleArgAndDefaultWrapperContext.class,0);
		}
		public IncludeFirstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeFirst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIncludeFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIncludeFirst(this);
		}
	}

	public final IncludeFirstContext includeFirst() throws RecognitionException {
		IncludeFirstContext _localctx = new IncludeFirstContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_includeFirst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			match(D_INCLUDE_FIRST);
			setState(506);
			singleArgAndDefaultWrapper();
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
	public static class EachContext extends ParserRuleContext {
		public TerminalNode D_EACH() { return getToken(BladeAntlrParser.D_EACH, 0); }
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public List<TerminalNode> BL_COMMA() { return getTokens(BladeAntlrParser.BL_COMMA); }
		public TerminalNode BL_COMMA(int i) {
			return getToken(BladeAntlrParser.BL_COMMA, i);
		}
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public List<IdentifiableArgumentContext> identifiableArgument() {
			return getRuleContexts(IdentifiableArgumentContext.class);
		}
		public IdentifiableArgumentContext identifiableArgument(int i) {
			return getRuleContext(IdentifiableArgumentContext.class,i);
		}
		public EachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_each; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterEach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitEach(this);
		}
	}

	public final EachContext each() throws RecognitionException {
		EachContext _localctx = new EachContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_each);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			match(D_EACH);
			setState(509);
			match(BLADE_PARAM_LPAREN);
			setState(512);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(510);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(511);
				composedArgument();
				}
				break;
			}
			setState(514);
			match(BL_COMMA);
			setState(515);
			composedArgument();
			setState(516);
			match(BL_COMMA);
			setState(517);
			composedArgument();
			setState(523);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(518);
				match(BL_COMMA);
				setState(521);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(519);
					identifiableArgument();
					}
					break;
				case 2:
					{
					setState(520);
					composedArgument();
					}
					break;
				}
				}
			}

			setState(525);
			match(BLADE_PARAM_RPAREN);
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
	public static class Once_blockContext extends ParserRuleContext {
		public TerminalNode D_ONCE() { return getToken(BladeAntlrParser.D_ONCE, 0); }
		public TerminalNode D_ENDONCE() { return getToken(BladeAntlrParser.D_ENDONCE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public Once_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_once_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterOnce_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitOnce_block(this);
		}
	}

	public final Once_blockContext once_block() throws RecognitionException {
		Once_blockContext _localctx = new Once_blockContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_once_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(D_ONCE);
			setState(529); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(528);
				general_statement();
				}
				}
				setState(531); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0 );
			setState(533);
			match(D_ENDONCE);
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
	public static class HasSectionContext extends ParserRuleContext {
		public TerminalNode D_HAS_SECTION() { return getToken(BladeAntlrParser.D_HAS_SECTION, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrParser.D_ENDIF, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public HasSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hasSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterHasSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitHasSection(this);
		}
	}

	public final HasSectionContext hasSection() throws RecognitionException {
		HasSectionContext _localctx = new HasSectionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_hasSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			match(D_HAS_SECTION);
			setState(536);
			singleArgWrapper();
			setState(540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0) {
				{
				{
				setState(537);
				general_statement();
				}
				}
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(543);
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
	public static class SectionMissingContext extends ParserRuleContext {
		public TerminalNode D_SECTION_MISSING() { return getToken(BladeAntlrParser.D_SECTION_MISSING, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrParser.D_ENDIF, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public SectionMissingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sectionMissing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSectionMissing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSectionMissing(this);
		}
	}

	public final SectionMissingContext sectionMissing() throws RecognitionException {
		SectionMissingContext _localctx = new SectionMissingContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_sectionMissing);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			match(D_SECTION_MISSING);
			setState(546);
			singleArgWrapper();
			setState(550);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1729335329510391808L) != 0 || (((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 70093788011053L) != 0) {
				{
				{
				setState(547);
				general_statement();
				}
				}
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(553);
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
	public static class Custom_directiveContext extends ParserRuleContext {
		public TerminalNode D_CUSTOM() { return getToken(BladeAntlrParser.D_CUSTOM, 0); }
		public MultiArgWrapperContext multiArgWrapper() {
			return getRuleContext(MultiArgWrapperContext.class,0);
		}
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public Custom_directiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_custom_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterCustom_directive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitCustom_directive(this);
		}
	}

	public final Custom_directiveContext custom_directive() throws RecognitionException {
		Custom_directiveContext _localctx = new Custom_directiveContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_custom_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
			match(D_CUSTOM);
			setState(559);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(556);
				multiArgWrapper();
				}
				break;
			case 2:
				{
				{
				setState(557);
				match(BLADE_PARAM_LPAREN);
				setState(558);
				match(BLADE_PARAM_RPAREN);
				}
				}
				break;
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
	public static class PossibleDirectiveContext extends ParserRuleContext {
		public TerminalNode D_UNKNOWN() { return getToken(BladeAntlrParser.D_UNKNOWN, 0); }
		public PossibleDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possibleDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPossibleDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPossibleDirective(this);
		}
	}

	public final PossibleDirectiveContext possibleDirective() throws RecognitionException {
		PossibleDirectiveContext _localctx = new PossibleDirectiveContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_possibleDirective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			match(D_UNKNOWN);
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
	public static class Php_bladeContext extends ParserRuleContext {
		public TerminalNode D_PHP() { return getToken(BladeAntlrParser.D_PHP, 0); }
		public TerminalNode D_ENDPHP() { return getToken(BladeAntlrParser.D_ENDPHP, 0); }
		public List<Composed_php_expressionContext> composed_php_expression() {
			return getRuleContexts(Composed_php_expressionContext.class);
		}
		public Composed_php_expressionContext composed_php_expression(int i) {
			return getRuleContext(Composed_php_expressionContext.class,i);
		}
		public Main_php_expressionContext main_php_expression() {
			return getRuleContext(Main_php_expressionContext.class,0);
		}
		public Php_bladeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_php_blade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPhp_blade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPhp_blade(this);
		}
	}

	public final Php_bladeContext php_blade() throws RecognitionException {
		Php_bladeContext _localctx = new Php_bladeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_php_blade);
		int _la;
		try {
			setState(573);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(563);
				match(D_PHP);
				setState(565); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(564);
					composed_php_expression();
					}
					}
					setState(567); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0 || _la==EXPR_STRING );
				setState(569);
				match(D_ENDPHP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(571);
				match(D_PHP);
				setState(572);
				main_php_expression();
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
		public TerminalNode PHP_INLINE_START() { return getToken(BladeAntlrParser.PHP_INLINE_START, 0); }
		public TerminalNode PHP_EXIT() { return getToken(BladeAntlrParser.PHP_EXIT, 0); }
		public TerminalNode EOF() { return getToken(BladeAntlrParser.EOF, 0); }
		public List<Composed_php_expressionContext> composed_php_expression() {
			return getRuleContexts(Composed_php_expressionContext.class);
		}
		public Composed_php_expressionContext composed_php_expression(int i) {
			return getRuleContext(Composed_php_expressionContext.class,i);
		}
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
		enterRule(_localctx, 88, RULE_phpInline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			match(PHP_INLINE_START);
			setState(577); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(576);
				composed_php_expression();
				}
				}
				setState(579); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0 || _la==EXPR_STRING );
			setState(581);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==PHP_EXIT) ) {
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
	public static class Regular_echoContext extends ParserRuleContext {
		public TerminalNode CONTENT_TAG_OPEN() { return getToken(BladeAntlrParser.CONTENT_TAG_OPEN, 0); }
		public TerminalNode CONTENT_TAG_CLOSE() { return getToken(BladeAntlrParser.CONTENT_TAG_CLOSE, 0); }
		public List<Echo_exprContext> echo_expr() {
			return getRuleContexts(Echo_exprContext.class);
		}
		public Echo_exprContext echo_expr(int i) {
			return getRuleContext(Echo_exprContext.class,i);
		}
		public Regular_echoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regular_echo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterRegular_echo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitRegular_echo(this);
		}
	}

	public final Regular_echoContext regular_echo() throws RecognitionException {
		Regular_echoContext _localctx = new Regular_echoContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_regular_echo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			match(CONTENT_TAG_OPEN);
			setState(587);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0 || _la==EXPR_STRING) {
				{
				{
				setState(584);
				echo_expr();
				}
				}
				setState(589);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(590);
			match(CONTENT_TAG_CLOSE);
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
	public static class Raw_echoContext extends ParserRuleContext {
		public TerminalNode RAW_TAG_OPEN() { return getToken(BladeAntlrParser.RAW_TAG_OPEN, 0); }
		public TerminalNode RAW_TAG_CLOSE() { return getToken(BladeAntlrParser.RAW_TAG_CLOSE, 0); }
		public List<Echo_exprContext> echo_expr() {
			return getRuleContexts(Echo_exprContext.class);
		}
		public Echo_exprContext echo_expr(int i) {
			return getRuleContext(Echo_exprContext.class,i);
		}
		public Raw_echoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raw_echo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterRaw_echo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitRaw_echo(this);
		}
	}

	public final Raw_echoContext raw_echo() throws RecognitionException {
		Raw_echoContext _localctx = new Raw_echoContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_raw_echo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592);
			match(RAW_TAG_OPEN);
			setState(596);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0 || _la==EXPR_STRING) {
				{
				{
				setState(593);
				echo_expr();
				}
				}
				setState(598);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(599);
			match(RAW_TAG_CLOSE);
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
	public static class Echo_exprContext extends ParserRuleContext {
		public Composed_php_expressionContext composed_php_expression() {
			return getRuleContext(Composed_php_expressionContext.class,0);
		}
		public Echo_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_echo_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterEcho_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitEcho_expr(this);
		}
	}

	public final Echo_exprContext echo_expr() throws RecognitionException {
		Echo_exprContext _localctx = new Echo_exprContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_echo_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			composed_php_expression();
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
	public static class Class_expr_usageContext extends ParserRuleContext {
		public Class_name_referenceContext class_name_reference() {
			return getRuleContext(Class_name_referenceContext.class,0);
		}
		public Class_alias_static_accessContext class_alias_static_access() {
			return getRuleContext(Class_alias_static_accessContext.class,0);
		}
		public Static_direct_class_accessContext static_direct_class_access() {
			return getRuleContext(Static_direct_class_accessContext.class,0);
		}
		public Class_instanceContext class_instance() {
			return getRuleContext(Class_instanceContext.class,0);
		}
		public Class_expr_usageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_expr_usage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterClass_expr_usage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitClass_expr_usage(this);
		}
	}

	public final Class_expr_usageContext class_expr_usage() throws RecognitionException {
		Class_expr_usageContext _localctx = new Class_expr_usageContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_class_expr_usage);
		try {
			setState(607);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(603);
				class_name_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(604);
				class_alias_static_access();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(605);
				static_direct_class_access();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(606);
				class_instance();
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
	public static class Class_alias_static_accessContext extends ParserRuleContext {
		public Token class_name;
		public Token static_property;
		public TerminalNode PHP_STATIC_ACCESS() { return getToken(BladeAntlrParser.PHP_STATIC_ACCESS, 0); }
		public TerminalNode PHP_VARIABLE() { return getToken(BladeAntlrParser.PHP_VARIABLE, 0); }
		public TerminalNode PHP_IDENTIFIER() { return getToken(BladeAntlrParser.PHP_IDENTIFIER, 0); }
		public Class_alias_static_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_alias_static_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterClass_alias_static_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitClass_alias_static_access(this);
		}
	}

	public final Class_alias_static_accessContext class_alias_static_access() throws RecognitionException {
		Class_alias_static_accessContext _localctx = new Class_alias_static_accessContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_class_alias_static_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			((Class_alias_static_accessContext)_localctx).class_name = match(PHP_VARIABLE);
			setState(610);
			match(PHP_STATIC_ACCESS);
			setState(611);
			((Class_alias_static_accessContext)_localctx).static_property = match(PHP_IDENTIFIER);
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
	public static class Static_direct_class_accessContext extends ParserRuleContext {
		public Token static_property;
		public Class_identifierContext class_identifier() {
			return getRuleContext(Class_identifierContext.class,0);
		}
		public TerminalNode PHP_STATIC_ACCESS() { return getToken(BladeAntlrParser.PHP_STATIC_ACCESS, 0); }
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public TerminalNode PHP_IDENTIFIER() { return getToken(BladeAntlrParser.PHP_IDENTIFIER, 0); }
		public Static_direct_class_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_static_direct_class_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterStatic_direct_class_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitStatic_direct_class_access(this);
		}
	}

	public final Static_direct_class_accessContext static_direct_class_access() throws RecognitionException {
		Static_direct_class_accessContext _localctx = new Static_direct_class_accessContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_static_direct_class_access);
		try {
			setState(621);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(613);
				class_identifier();
				setState(614);
				match(PHP_STATIC_ACCESS);
				setState(615);
				method_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(617);
				class_identifier();
				setState(618);
				match(PHP_STATIC_ACCESS);
				setState(619);
				((Static_direct_class_accessContext)_localctx).static_property = match(PHP_IDENTIFIER);
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
	public static class Class_instanceContext extends ParserRuleContext {
		public TerminalNode PHP_NEW() { return getToken(BladeAntlrParser.PHP_NEW, 0); }
		public TerminalNode BLADE_EXPR_LPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_LPAREN, 0); }
		public TerminalNode BLADE_EXPR_RPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_RPAREN, 0); }
		public Class_identifierContext class_identifier() {
			return getRuleContext(Class_identifierContext.class,0);
		}
		public NamespacePathContext namespacePath() {
			return getRuleContext(NamespacePathContext.class,0);
		}
		public List<TerminalNode> PHP_WS() { return getTokens(BladeAntlrParser.PHP_WS); }
		public TerminalNode PHP_WS(int i) {
			return getToken(BladeAntlrParser.PHP_WS, i);
		}
		public List<Composed_php_expressionContext> composed_php_expression() {
			return getRuleContexts(Composed_php_expressionContext.class);
		}
		public Composed_php_expressionContext composed_php_expression(int i) {
			return getRuleContext(Composed_php_expressionContext.class,i);
		}
		public Class_instanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_instance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterClass_instance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitClass_instance(this);
		}
	}

	public final Class_instanceContext class_instance() throws RecognitionException {
		Class_instanceContext _localctx = new Class_instanceContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_class_instance);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			match(PHP_NEW);
			setState(625); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(624);
				match(PHP_WS);
				}
				}
				setState(627); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PHP_WS );
			setState(631);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(629);
				class_identifier();
				}
				break;
			case 2:
				{
				setState(630);
				namespacePath();
				}
				break;
			}
			setState(633);
			match(BLADE_EXPR_LPAREN);
			setState(637);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0 || _la==EXPR_STRING) {
				{
				{
				setState(634);
				composed_php_expression();
				}
				}
				setState(639);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(640);
			match(BLADE_EXPR_RPAREN);
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
	public static class Class_name_referenceContext extends ParserRuleContext {
		public Class_identifierContext class_identifier() {
			return getRuleContext(Class_identifierContext.class,0);
		}
		public TerminalNode PHP_STATIC_ACCESS() { return getToken(BladeAntlrParser.PHP_STATIC_ACCESS, 0); }
		public TerminalNode PHP_CLASS_KEYWORD() { return getToken(BladeAntlrParser.PHP_CLASS_KEYWORD, 0); }
		public Class_name_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_name_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterClass_name_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitClass_name_reference(this);
		}
	}

	public final Class_name_referenceContext class_name_reference() throws RecognitionException {
		Class_name_referenceContext _localctx = new Class_name_referenceContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_class_name_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642);
			class_identifier();
			setState(643);
			match(PHP_STATIC_ACCESS);
			setState(644);
			match(PHP_CLASS_KEYWORD);
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
	public static class Class_identifierContext extends ParserRuleContext {
		public Token namespace;
		public Token class_name;
		public TerminalNode PHP_IDENTIFIER() { return getToken(BladeAntlrParser.PHP_IDENTIFIER, 0); }
		public TerminalNode PHP_NAMESPACE_PATH() { return getToken(BladeAntlrParser.PHP_NAMESPACE_PATH, 0); }
		public Class_identifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterClass_identifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitClass_identifier(this);
		}
	}

	public final Class_identifierContext class_identifier() throws RecognitionException {
		Class_identifierContext _localctx = new Class_identifierContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_class_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHP_NAMESPACE_PATH) {
				{
				setState(646);
				((Class_identifierContext)_localctx).namespace = match(PHP_NAMESPACE_PATH);
				}
			}

			setState(649);
			((Class_identifierContext)_localctx).class_name = match(PHP_IDENTIFIER);
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
	public static class NamespacePathContext extends ParserRuleContext {
		public Token namespace;
		public Token class_name;
		public TerminalNode PHP_IDENTIFIER() { return getToken(BladeAntlrParser.PHP_IDENTIFIER, 0); }
		public TerminalNode PHP_NAMESPACE_PATH() { return getToken(BladeAntlrParser.PHP_NAMESPACE_PATH, 0); }
		public NamespacePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterNamespacePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitNamespacePath(this);
		}
	}

	public final NamespacePathContext namespacePath() throws RecognitionException {
		NamespacePathContext _localctx = new NamespacePathContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_namespacePath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHP_NAMESPACE_PATH) {
				{
				setState(651);
				((NamespacePathContext)_localctx).namespace = match(PHP_NAMESPACE_PATH);
				}
			}

			setState(654);
			((NamespacePathContext)_localctx).class_name = match(PHP_IDENTIFIER);
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
	public static class Method_callContext extends ParserRuleContext {
		public Token func_name;
		public TerminalNode BLADE_EXPR_LPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_LPAREN, 0); }
		public TerminalNode BLADE_EXPR_RPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_RPAREN, 0); }
		public TerminalNode PHP_IDENTIFIER() { return getToken(BladeAntlrParser.PHP_IDENTIFIER, 0); }
		public List<Composed_php_expressionContext> composed_php_expression() {
			return getRuleContexts(Composed_php_expressionContext.class);
		}
		public Composed_php_expressionContext composed_php_expression(int i) {
			return getRuleContext(Composed_php_expressionContext.class,i);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterMethod_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitMethod_call(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(656);
			((Method_callContext)_localctx).func_name = match(PHP_IDENTIFIER);
			setState(657);
			match(BLADE_EXPR_LPAREN);
			setState(661);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0 || _la==EXPR_STRING) {
				{
				{
				setState(658);
				composed_php_expression();
				}
				}
				setState(663);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(664);
			match(BLADE_EXPR_RPAREN);
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
	public static class Function_callContext extends ParserRuleContext {
		public Token func_name;
		public TerminalNode BLADE_EXPR_LPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_LPAREN, 0); }
		public TerminalNode BLADE_EXPR_RPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_RPAREN, 0); }
		public TerminalNode PHP_IDENTIFIER() { return getToken(BladeAntlrParser.PHP_IDENTIFIER, 0); }
		public List<Composed_php_expressionContext> composed_php_expression() {
			return getRuleContexts(Composed_php_expressionContext.class);
		}
		public Composed_php_expressionContext composed_php_expression(int i) {
			return getRuleContext(Composed_php_expressionContext.class,i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitFunction_call(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			((Function_callContext)_localctx).func_name = match(PHP_IDENTIFIER);
			setState(667);
			match(BLADE_EXPR_LPAREN);
			setState(671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0 || _la==EXPR_STRING) {
				{
				{
				setState(668);
				composed_php_expression();
				}
				}
				setState(673);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(674);
			match(BLADE_EXPR_RPAREN);
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
	public static class Php_expressionContext extends ParserRuleContext {
		public TerminalNode PHP_EXPRESSION() { return getToken(BladeAntlrParser.PHP_EXPRESSION, 0); }
		public Php_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_php_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPhp_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPhp_expression(this);
		}
	}

	public final Php_expressionContext php_expression() throws RecognitionException {
		Php_expressionContext _localctx = new Php_expressionContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_php_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			match(PHP_EXPRESSION);
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
	public static class Loop_expressionContext extends ParserRuleContext {
		public Simple_foreach_exprContext simple_foreach_expr() {
			return getRuleContext(Simple_foreach_exprContext.class,0);
		}
		public List<TerminalNode> PHP_VARIABLE() { return getTokens(BladeAntlrParser.PHP_VARIABLE); }
		public TerminalNode PHP_VARIABLE(int i) {
			return getToken(BladeAntlrParser.PHP_VARIABLE, i);
		}
		public List<TerminalNode> PHP_EXPRESSION() { return getTokens(BladeAntlrParser.PHP_EXPRESSION); }
		public TerminalNode PHP_EXPRESSION(int i) {
			return getToken(BladeAntlrParser.PHP_EXPRESSION, i);
		}
		public List<TerminalNode> FOREACH_PARAM_ASSIGN() { return getTokens(BladeAntlrParser.FOREACH_PARAM_ASSIGN); }
		public TerminalNode FOREACH_PARAM_ASSIGN(int i) {
			return getToken(BladeAntlrParser.FOREACH_PARAM_ASSIGN, i);
		}
		public List<TerminalNode> FOREACH_LOOP_LPAREN() { return getTokens(BladeAntlrParser.FOREACH_LOOP_LPAREN); }
		public TerminalNode FOREACH_LOOP_LPAREN(int i) {
			return getToken(BladeAntlrParser.FOREACH_LOOP_LPAREN, i);
		}
		public List<TerminalNode> FOREACH_LOOP_RPAREN() { return getTokens(BladeAntlrParser.FOREACH_LOOP_RPAREN); }
		public TerminalNode FOREACH_LOOP_RPAREN(int i) {
			return getToken(BladeAntlrParser.FOREACH_LOOP_RPAREN, i);
		}
		public List<TerminalNode> FOREACH_AS() { return getTokens(BladeAntlrParser.FOREACH_AS); }
		public TerminalNode FOREACH_AS(int i) {
			return getToken(BladeAntlrParser.FOREACH_AS, i);
		}
		public Loop_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterLoop_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitLoop_expression(this);
		}
	}

	public final Loop_expressionContext loop_expression() throws RecognitionException {
		Loop_expressionContext _localctx = new Loop_expressionContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_loop_expression);
		int _la;
		try {
			int _alt;
			setState(684);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(678);
				simple_foreach_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(680); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(679);
						_la = _input.LA(1);
						if ( !(_la==PHP_EXPRESSION || _la==PHP_VARIABLE || (((_la - 121)) & ~0x3f) == 0 && ((1L << (_la - 121)) & 15L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(682); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
	public static class Main_php_expressionContext extends ParserRuleContext {
		public TerminalNode BLADE_EXPR_LPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_LPAREN, 0); }
		public TerminalNode BLADE_EXPR_RPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_RPAREN, 0); }
		public List<Composed_php_expressionContext> composed_php_expression() {
			return getRuleContexts(Composed_php_expressionContext.class);
		}
		public Composed_php_expressionContext composed_php_expression(int i) {
			return getRuleContext(Composed_php_expressionContext.class,i);
		}
		public Main_php_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_php_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterMain_php_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitMain_php_expression(this);
		}
	}

	public final Main_php_expressionContext main_php_expression() throws RecognitionException {
		Main_php_expressionContext _localctx = new Main_php_expressionContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_main_php_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686);
			match(BLADE_EXPR_LPAREN);
			setState(688); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(687);
				composed_php_expression();
				}
				}
				setState(690); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0 || _la==EXPR_STRING );
			setState(692);
			match(BLADE_EXPR_RPAREN);
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
	public static class Composed_php_expressionContext extends ParserRuleContext {
		public Class_expr_usageContext class_expr_usage() {
			return getRuleContext(Class_expr_usageContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public TerminalNode PHP_IDENTIFIER() { return getToken(BladeAntlrParser.PHP_IDENTIFIER, 0); }
		public NamespacePathContext namespacePath() {
			return getRuleContext(NamespacePathContext.class,0);
		}
		public TerminalNode PHP_VARIABLE() { return getToken(BladeAntlrParser.PHP_VARIABLE, 0); }
		public TerminalNode PHP_NAMESPACE_PATH() { return getToken(BladeAntlrParser.PHP_NAMESPACE_PATH, 0); }
		public TerminalNode EXPR_STRING() { return getToken(BladeAntlrParser.EXPR_STRING, 0); }
		public TerminalNode PHP_KEYWORD() { return getToken(BladeAntlrParser.PHP_KEYWORD, 0); }
		public List<TerminalNode> PHP_EXPRESSION() { return getTokens(BladeAntlrParser.PHP_EXPRESSION); }
		public TerminalNode PHP_EXPRESSION(int i) {
			return getToken(BladeAntlrParser.PHP_EXPRESSION, i);
		}
		public TerminalNode PHP_WS() { return getToken(BladeAntlrParser.PHP_WS, 0); }
		public TerminalNode PHP_STATIC_ACCESS() { return getToken(BladeAntlrParser.PHP_STATIC_ACCESS, 0); }
		public TerminalNode PHP_CLASS_KEYWORD() { return getToken(BladeAntlrParser.PHP_CLASS_KEYWORD, 0); }
		public TerminalNode PHP_INSTANCE_ACCESS() { return getToken(BladeAntlrParser.PHP_INSTANCE_ACCESS, 0); }
		public TerminalNode BLADE_EXPR_LPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_LPAREN, 0); }
		public TerminalNode BLADE_EXPR_RPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_RPAREN, 0); }
		public List<Composed_php_expressionContext> composed_php_expression() {
			return getRuleContexts(Composed_php_expressionContext.class);
		}
		public Composed_php_expressionContext composed_php_expression(int i) {
			return getRuleContext(Composed_php_expressionContext.class,i);
		}
		public TerminalNode PHP_EXPR_STRING() { return getToken(BladeAntlrParser.PHP_EXPR_STRING, 0); }
		public Composed_php_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composed_php_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterComposed_php_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitComposed_php_expression(this);
		}
	}

	public final Composed_php_expressionContext composed_php_expression() throws RecognitionException {
		Composed_php_expressionContext _localctx = new Composed_php_expressionContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_composed_php_expression);
		int _la;
		try {
			int _alt;
			setState(720);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(694);
				class_expr_usage();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(695);
				function_call();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(696);
				match(PHP_IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(697);
				namespacePath();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(698);
				match(PHP_VARIABLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(699);
				match(PHP_NAMESPACE_PATH);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(700);
				match(EXPR_STRING);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(701);
				match(PHP_KEYWORD);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(703); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(702);
						match(PHP_EXPRESSION);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(705); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(707);
				match(PHP_WS);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(708);
				match(PHP_STATIC_ACCESS);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(709);
				match(PHP_CLASS_KEYWORD);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(710);
				match(PHP_INSTANCE_ACCESS);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(711);
				match(BLADE_EXPR_LPAREN);
				setState(715);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0 || _la==EXPR_STRING) {
					{
					{
					setState(712);
					composed_php_expression();
					}
					}
					setState(717);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(718);
				match(BLADE_EXPR_RPAREN);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(719);
				match(PHP_EXPR_STRING);
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
	public static class Simple_foreach_exprContext extends ParserRuleContext {
		public Token loop_array;
		public Token key;
		public Token item;
		public TerminalNode FOREACH_AS() { return getToken(BladeAntlrParser.FOREACH_AS, 0); }
		public List<TerminalNode> PHP_VARIABLE() { return getTokens(BladeAntlrParser.PHP_VARIABLE); }
		public TerminalNode PHP_VARIABLE(int i) {
			return getToken(BladeAntlrParser.PHP_VARIABLE, i);
		}
		public TerminalNode FOREACH_PARAM_ASSIGN() { return getToken(BladeAntlrParser.FOREACH_PARAM_ASSIGN, 0); }
		public Simple_foreach_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_foreach_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSimple_foreach_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSimple_foreach_expr(this);
		}
	}

	public final Simple_foreach_exprContext simple_foreach_expr() throws RecognitionException {
		Simple_foreach_exprContext _localctx = new Simple_foreach_exprContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_simple_foreach_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(722);
			((Simple_foreach_exprContext)_localctx).loop_array = match(PHP_VARIABLE);
			setState(723);
			match(FOREACH_AS);
			setState(724);
			((Simple_foreach_exprContext)_localctx).key = match(PHP_VARIABLE);
			setState(727);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FOREACH_PARAM_ASSIGN) {
				{
				setState(725);
				match(FOREACH_PARAM_ASSIGN);
				setState(726);
				((Simple_foreach_exprContext)_localctx).item = match(PHP_VARIABLE);
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
	public static class SingleArgWrapperContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
		}
		public ComposedArgumentContext composedArgument() {
			return getRuleContext(ComposedArgumentContext.class,0);
		}
		public SingleArgWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleArgWrapper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSingleArgWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSingleArgWrapper(this);
		}
	}

	public final SingleArgWrapperContext singleArgWrapper() throws RecognitionException {
		SingleArgWrapperContext _localctx = new SingleArgWrapperContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_singleArgWrapper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729);
			match(BLADE_PARAM_LPAREN);
			setState(732);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				{
				setState(730);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(731);
				composedArgument();
				}
				break;
			}
			setState(734);
			match(BLADE_PARAM_RPAREN);
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
	public static class SingleArgWrapperNovarContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public List<IdentifiableArgumentContext> identifiableArgument() {
			return getRuleContexts(IdentifiableArgumentContext.class);
		}
		public IdentifiableArgumentContext identifiableArgument(int i) {
			return getRuleContext(IdentifiableArgumentContext.class,i);
		}
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public SingleArgWrapperNovarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleArgWrapperNovar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSingleArgWrapperNovar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSingleArgWrapperNovar(this);
		}
	}

	public final SingleArgWrapperNovarContext singleArgWrapperNovar() throws RecognitionException {
		SingleArgWrapperNovarContext _localctx = new SingleArgWrapperNovarContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_singleArgWrapperNovar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(736);
			match(BLADE_PARAM_LPAREN);
			setState(741);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2951180L) != 0 || (((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 13L) != 0) {
				{
				setState(739);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(737);
					identifiableArgument();
					}
					break;
				case 2:
					{
					setState(738);
					composedArgument();
					}
					break;
				}
				}
				setState(743);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(744);
			match(BLADE_PARAM_RPAREN);
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
	public static class SingleArgAndDefaultWrapperContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
		}
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public List<TerminalNode> BL_COMMA() { return getTokens(BladeAntlrParser.BL_COMMA); }
		public TerminalNode BL_COMMA(int i) {
			return getToken(BladeAntlrParser.BL_COMMA, i);
		}
		public List<TerminalNode> BL_PARAM_WS() { return getTokens(BladeAntlrParser.BL_PARAM_WS); }
		public TerminalNode BL_PARAM_WS(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_WS, i);
		}
		public SingleArgAndDefaultWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleArgAndDefaultWrapper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSingleArgAndDefaultWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSingleArgAndDefaultWrapper(this);
		}
	}

	public final SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() throws RecognitionException {
		SingleArgAndDefaultWrapperContext _localctx = new SingleArgAndDefaultWrapperContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_singleArgAndDefaultWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(746);
			match(BLADE_PARAM_LPAREN);
			setState(749);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(747);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(748);
				composedArgument();
				}
				break;
			}
			setState(753);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(751);
				match(BL_COMMA);
				setState(752);
				composedArgument();
				}
				break;
			}
			setState(762);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(755);
				match(BL_COMMA);
				setState(759);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BL_PARAM_WS) {
					{
					{
					setState(756);
					match(BL_PARAM_WS);
					}
					}
					setState(761);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(764);
			match(BLADE_PARAM_RPAREN);
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
	public static class DoubleArgWrapperContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BL_COMMA() { return getToken(BladeAntlrParser.BL_COMMA, 0); }
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
		}
		public DoubleArgWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleArgWrapper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterDoubleArgWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitDoubleArgWrapper(this);
		}
	}

	public final DoubleArgWrapperContext doubleArgWrapper() throws RecognitionException {
		DoubleArgWrapperContext _localctx = new DoubleArgWrapperContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_doubleArgWrapper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(766);
			match(BLADE_PARAM_LPAREN);
			setState(769);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(767);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(768);
				composedArgument();
				}
				break;
			}
			setState(771);
			match(BL_COMMA);
			setState(772);
			composedArgument();
			setState(773);
			match(BLADE_PARAM_RPAREN);
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
	public static class DoubleIfArgWrapperContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public TerminalNode BL_COMMA() { return getToken(BladeAntlrParser.BL_COMMA, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
		}
		public DoubleIfArgWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleIfArgWrapper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterDoubleIfArgWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitDoubleIfArgWrapper(this);
		}
	}

	public final DoubleIfArgWrapperContext doubleIfArgWrapper() throws RecognitionException {
		DoubleIfArgWrapperContext _localctx = new DoubleIfArgWrapperContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_doubleIfArgWrapper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(775);
			match(BLADE_PARAM_LPAREN);
			setState(776);
			composedArgument();
			setState(777);
			match(BL_COMMA);
			setState(780);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(778);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(779);
				composedArgument();
				}
				break;
			}
			setState(782);
			match(BLADE_PARAM_RPAREN);
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
	public static class MultiArgWrapperContext extends ParserRuleContext {
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
		}
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public List<TerminalNode> BL_COMMA() { return getTokens(BladeAntlrParser.BL_COMMA); }
		public TerminalNode BL_COMMA(int i) {
			return getToken(BladeAntlrParser.BL_COMMA, i);
		}
		public MultiArgWrapperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiArgWrapper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterMultiArgWrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitMultiArgWrapper(this);
		}
	}

	public final MultiArgWrapperContext multiArgWrapper() throws RecognitionException {
		MultiArgWrapperContext _localctx = new MultiArgWrapperContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_multiArgWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
			match(BLADE_PARAM_LPAREN);
			setState(787);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				setState(785);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(786);
				composedArgument();
				}
				break;
			}
			setState(793);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_COMMA) {
				{
				{
				setState(789);
				match(BL_COMMA);
				setState(790);
				composedArgument();
				}
				}
				setState(795);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(796);
			match(BLADE_PARAM_RPAREN);
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
	public static class IdentifiableArgumentContext extends ParserRuleContext {
		public TerminalNode BL_PARAM_STRING() { return getToken(BladeAntlrParser.BL_PARAM_STRING, 0); }
		public List<TerminalNode> BL_PARAM_WS() { return getTokens(BladeAntlrParser.BL_PARAM_WS); }
		public TerminalNode BL_PARAM_WS(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_WS, i);
		}
		public IdentifiableArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiableArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIdentifiableArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIdentifiableArgument(this);
		}
	}

	public final IdentifiableArgumentContext identifiableArgument() throws RecognitionException {
		IdentifiableArgumentContext _localctx = new IdentifiableArgumentContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_identifiableArgument);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(801);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(798);
				match(BL_PARAM_WS);
				}
				}
				setState(803);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(804);
			match(BL_PARAM_STRING);
			setState(808);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(805);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(810);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
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
	public static class ComposedArgumentContext extends ParserRuleContext {
		public List<TerminalNode> BL_PARAM_WS() { return getTokens(BladeAntlrParser.BL_PARAM_WS); }
		public TerminalNode BL_PARAM_WS(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_WS, i);
		}
		public List<PhpExprContext> phpExpr() {
			return getRuleContexts(PhpExprContext.class);
		}
		public PhpExprContext phpExpr(int i) {
			return getRuleContext(PhpExprContext.class,i);
		}
		public ComposedArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composedArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterComposedArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitComposedArgument(this);
		}
	}

	public final ComposedArgumentContext composedArgument() throws RecognitionException {
		ComposedArgumentContext _localctx = new ComposedArgumentContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_composedArgument);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(814);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(811);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(816);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			}
			setState(818); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(817);
					phpExpr();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(820); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(825);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(822);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(827);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
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
	public static class PhpExprContext extends ParserRuleContext {
		public IdentifiableArrayContext identifiableArray() {
			return getRuleContext(IdentifiableArrayContext.class,0);
		}
		public ArrayDefineContext arrayDefine() {
			return getRuleContext(ArrayDefineContext.class,0);
		}
		public TerminalNode BLADE_PARAM_EXTRA() { return getToken(BladeAntlrParser.BLADE_PARAM_EXTRA, 0); }
		public TerminalNode PHP_VARIABLE() { return getToken(BladeAntlrParser.PHP_VARIABLE, 0); }
		public TerminalNode PHP_KEYWORD() { return getToken(BladeAntlrParser.PHP_KEYWORD, 0); }
		public TerminalNode BL_PARAM_WS() { return getToken(BladeAntlrParser.BL_PARAM_WS, 0); }
		public TerminalNode BL_PARAM_CONCAT_OPERATOR() { return getToken(BladeAntlrParser.BL_PARAM_CONCAT_OPERATOR, 0); }
		public TerminalNode BL_PARAM_STRING() { return getToken(BladeAntlrParser.BL_PARAM_STRING, 0); }
		public TerminalNode BL_PARAM_ASSIGN() { return getToken(BladeAntlrParser.BL_PARAM_ASSIGN, 0); }
		public TerminalNode BL_NAME_STRING() { return getToken(BladeAntlrParser.BL_NAME_STRING, 0); }
		public TerminalNode BL_PARAM_COMMA() { return getToken(BladeAntlrParser.BL_PARAM_COMMA, 0); }
		public PhpExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phpExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPhpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPhpExpr(this);
		}
	}

	public final PhpExprContext phpExpr() throws RecognitionException {
		PhpExprContext _localctx = new PhpExprContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_phpExpr);
		try {
			setState(839);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(828);
				identifiableArray();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(829);
				arrayDefine();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(830);
				match(BLADE_PARAM_EXTRA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(831);
				match(PHP_VARIABLE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(832);
				match(PHP_KEYWORD);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(833);
				match(BL_PARAM_WS);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(834);
				match(BL_PARAM_CONCAT_OPERATOR);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(835);
				match(BL_PARAM_STRING);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(836);
				match(BL_PARAM_ASSIGN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(837);
				match(BL_NAME_STRING);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(838);
				match(BL_PARAM_COMMA);
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
	public static class IdentifiableArrayContext extends ParserRuleContext {
		public TerminalNode BL_SQ_LPAREN() { return getToken(BladeAntlrParser.BL_SQ_LPAREN, 0); }
		public List<ParamAssignContext> paramAssign() {
			return getRuleContexts(ParamAssignContext.class);
		}
		public ParamAssignContext paramAssign(int i) {
			return getRuleContext(ParamAssignContext.class,i);
		}
		public TerminalNode BL_SQ_RPAREN() { return getToken(BladeAntlrParser.BL_SQ_RPAREN, 0); }
		public List<TerminalNode> BL_PARAM_COMMA() { return getTokens(BladeAntlrParser.BL_PARAM_COMMA); }
		public TerminalNode BL_PARAM_COMMA(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_COMMA, i);
		}
		public IdentifiableArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiableArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIdentifiableArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIdentifiableArray(this);
		}
	}

	public final IdentifiableArrayContext identifiableArray() throws RecognitionException {
		IdentifiableArrayContext _localctx = new IdentifiableArrayContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_identifiableArray);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(841);
			match(BL_SQ_LPAREN);
			setState(842);
			paramAssign();
			setState(847);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(843);
					match(BL_PARAM_COMMA);
					setState(844);
					paramAssign();
					}
					} 
				}
				setState(849);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			}
			setState(851);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_PARAM_COMMA) {
				{
				setState(850);
				match(BL_PARAM_COMMA);
				}
			}

			setState(853);
			match(BL_SQ_RPAREN);
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
	public static class ArrayDefineContext extends ParserRuleContext {
		public TerminalNode BL_SQ_LPAREN() { return getToken(BladeAntlrParser.BL_SQ_LPAREN, 0); }
		public TerminalNode BL_SQ_RPAREN() { return getToken(BladeAntlrParser.BL_SQ_RPAREN, 0); }
		public List<PhpExprContext> phpExpr() {
			return getRuleContexts(PhpExprContext.class);
		}
		public PhpExprContext phpExpr(int i) {
			return getRuleContext(PhpExprContext.class,i);
		}
		public ArrayDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterArrayDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitArrayDefine(this);
		}
	}

	public final ArrayDefineContext arrayDefine() throws RecognitionException {
		ArrayDefineContext _localctx = new ArrayDefineContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_arrayDefine);
		int _la;
		try {
			setState(865);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(855);
				match(BL_SQ_LPAREN);
				setState(857); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(856);
					phpExpr();
					}
					}
					setState(859); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 2951180L) != 0 || (((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 13L) != 0 );
				setState(861);
				match(BL_SQ_RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(863);
				match(BL_SQ_LPAREN);
				setState(864);
				match(BL_SQ_RPAREN);
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
	public static class ParamAssignContext extends ParserRuleContext {
		public List<TerminalNode> BL_PARAM_STRING() { return getTokens(BladeAntlrParser.BL_PARAM_STRING); }
		public TerminalNode BL_PARAM_STRING(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_STRING, i);
		}
		public TerminalNode BL_PARAM_ASSIGN() { return getToken(BladeAntlrParser.BL_PARAM_ASSIGN, 0); }
		public TerminalNode PHP_VARIABLE() { return getToken(BladeAntlrParser.PHP_VARIABLE, 0); }
		public TerminalNode PHP_KEYWORD() { return getToken(BladeAntlrParser.PHP_KEYWORD, 0); }
		public List<TerminalNode> BL_PARAM_WS() { return getTokens(BladeAntlrParser.BL_PARAM_WS); }
		public TerminalNode BL_PARAM_WS(int i) {
			return getToken(BladeAntlrParser.BL_PARAM_WS, i);
		}
		public ParamAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterParamAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitParamAssign(this);
		}
	}

	public final ParamAssignContext paramAssign() throws RecognitionException {
		ParamAssignContext _localctx = new ParamAssignContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_paramAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(867);
			match(BL_PARAM_STRING);
			setState(871);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(868);
				match(BL_PARAM_WS);
				}
				}
				setState(873);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(874);
			match(BL_PARAM_ASSIGN);
			setState(878);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(875);
				match(BL_PARAM_WS);
				}
				}
				setState(880);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(881);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 262156L) != 0) ) {
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
	public static class Verbatim_blockContext extends ParserRuleContext {
		public TerminalNode D_VERBATIM() { return getToken(BladeAntlrParser.D_VERBATIM, 0); }
		public TerminalNode D_ENDVERBATIM() { return getToken(BladeAntlrParser.D_ENDVERBATIM, 0); }
		public List<Non_blade_statementContext> non_blade_statement() {
			return getRuleContexts(Non_blade_statementContext.class);
		}
		public Non_blade_statementContext non_blade_statement(int i) {
			return getRuleContext(Non_blade_statementContext.class,i);
		}
		public Verbatim_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbatim_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterVerbatim_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitVerbatim_block(this);
		}
	}

	public final Verbatim_blockContext verbatim_block() throws RecognitionException {
		Verbatim_blockContext _localctx = new Verbatim_blockContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_verbatim_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(883);
			match(D_VERBATIM);
			setState(885); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(884);
				non_blade_statement();
				}
				}
				setState(887); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HTML || _la==PHP_INLINE_START );
			setState(889);
			match(D_ENDVERBATIM);
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
	public static class Loop_actionContext extends ParserRuleContext {
		public TerminalNode D_LOOP_ACTION() { return getToken(BladeAntlrParser.D_LOOP_ACTION, 0); }
		public TerminalNode D_BREAK() { return getToken(BladeAntlrParser.D_BREAK, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public Loop_actionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterLoop_action(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitLoop_action(this);
		}
	}

	public final Loop_actionContext loop_action() throws RecognitionException {
		Loop_actionContext _localctx = new Loop_actionContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_loop_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(891);
			_la = _input.LA(1);
			if ( !(_la==D_BREAK || _la==D_LOOP_ACTION) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(893);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHP_EXPRESSION) {
				{
				setState(892);
				php_expression();
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
	public static class HtmlContext extends ParserRuleContext {
		public List<TerminalNode> HTML() { return getTokens(BladeAntlrParser.HTML); }
		public TerminalNode HTML(int i) {
			return getToken(BladeAntlrParser.HTML, i);
		}
		public HtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitHtml(this);
		}
	}

	public final HtmlContext html() throws RecognitionException {
		HtmlContext _localctx = new HtmlContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_html);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(896); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(895);
					match(HTML);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(898); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		"\u0004\u0001\u0094\u0385\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0001\u0000\u0005\u0000\u009c\b\u0000\n"+
		"\u0000\f\u0000\u009f\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001\u00a6\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00af"+
		"\b\u0002\n\u0002\f\u0002\u00b2\t\u0002\u0001\u0002\u0003\u0002\u00b5\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00df"+
		"\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u00f8\b\u0004\u0001\u0005\u0001\u0005\u0003\u0005\u00fc\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0108\b\b\n\b\f\b\u010b\t\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0004\t\u0112\b\t\u000b\t\f\t\u0113"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0004\n\u011b\b\n\u000b\n\f\n"+
		"\u011c\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b"+
		"\u0124\b\u000b\u000b\u000b\f\u000b\u0125\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0004\f\u012d\b\f\u000b\f\f\f\u012e\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\r\u0004\r\u0136\b\r\u000b\r\f\r\u0137\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u013f\b\u000e\u000b"+
		"\u000e\f\u000e\u0140\u0001\u000e\u0003\u000e\u0144\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0004\u000f\u0149\b\u000f\u000b\u000f\f\u000f"+
		"\u014a\u0001\u000f\u0003\u000f\u014e\b\u000f\u0001\u0010\u0001\u0010\u0004"+
		"\u0010\u0152\b\u0010\u000b\u0010\f\u0010\u0153\u0001\u0010\u0003\u0010"+
		"\u0157\b\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0004\u0012\u015e\b\u0012\u000b\u0012\f\u0012\u015f\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0004\u0013\u0167\b\u0013\u000b"+
		"\u0013\f\u0013\u0168\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0005"+
		"\u0014\u016f\b\u0014\n\u0014\f\u0014\u0172\t\u0014\u0001\u0014\u0004\u0014"+
		"\u0175\b\u0014\u000b\u0014\f\u0014\u0176\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0004\u0015\u017e\b\u0015\u000b\u0015\f"+
		"\u0015\u017f\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0004\u0015"+
		"\u0186\b\u0015\u000b\u0015\f\u0015\u0187\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u018c\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0004\u0016\u0191"+
		"\b\u0016\u000b\u0016\f\u0016\u0192\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0004\u0017\u019a\b\u0017\u000b\u0017\f\u0017"+
		"\u019b\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0004\u0018\u01a4\b\u0018\u000b\u0018\f\u0018\u01a5\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0004\u0019\u01ad\b\u0019"+
		"\u000b\u0019\f\u0019\u01ae\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0004\u001a\u01b6\b\u001a\u000b\u001a\f\u001a\u01b7\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0004\u001b\u01c1\b\u001b\u000b\u001b\f\u001b\u01c2\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0004\u001c\u01cd\b\u001c\u000b\u001c\f\u001c\u01ce\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0003 \u01e2\b \u0001 \u0001 \u0001!\u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003"+
		"#\u01f2\b#\u0001#\u0001#\u0003#\u01f6\b#\u0001#\u0001#\u0001$\u0001$\u0001"+
		"$\u0001%\u0001%\u0001%\u0001%\u0003%\u0201\b%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0003%\u020a\b%\u0003%\u020c\b%\u0001%\u0001%\u0001"+
		"&\u0001&\u0004&\u0212\b&\u000b&\f&\u0213\u0001&\u0001&\u0001\'\u0001\'"+
		"\u0001\'\u0005\'\u021b\b\'\n\'\f\'\u021e\t\'\u0001\'\u0001\'\u0001(\u0001"+
		"(\u0001(\u0005(\u0225\b(\n(\f(\u0228\t(\u0001(\u0001(\u0001)\u0001)\u0001"+
		")\u0001)\u0003)\u0230\b)\u0001*\u0001*\u0001+\u0001+\u0004+\u0236\b+\u000b"+
		"+\f+\u0237\u0001+\u0001+\u0001+\u0001+\u0003+\u023e\b+\u0001,\u0001,\u0004"+
		",\u0242\b,\u000b,\f,\u0243\u0001,\u0001,\u0001-\u0001-\u0005-\u024a\b"+
		"-\n-\f-\u024d\t-\u0001-\u0001-\u0001.\u0001.\u0005.\u0253\b.\n.\f.\u0256"+
		"\t.\u0001.\u0001.\u0001/\u0001/\u00010\u00010\u00010\u00010\u00030\u0260"+
		"\b0\u00011\u00011\u00011\u00011\u00012\u00012\u00012\u00012\u00012\u0001"+
		"2\u00012\u00012\u00032\u026e\b2\u00013\u00013\u00043\u0272\b3\u000b3\f"+
		"3\u0273\u00013\u00013\u00033\u0278\b3\u00013\u00013\u00053\u027c\b3\n"+
		"3\f3\u027f\t3\u00013\u00013\u00014\u00014\u00014\u00014\u00015\u00035"+
		"\u0288\b5\u00015\u00015\u00016\u00036\u028d\b6\u00016\u00016\u00017\u0001"+
		"7\u00017\u00057\u0294\b7\n7\f7\u0297\t7\u00017\u00017\u00018\u00018\u0001"+
		"8\u00058\u029e\b8\n8\f8\u02a1\t8\u00018\u00018\u00019\u00019\u0001:\u0001"+
		":\u0004:\u02a9\b:\u000b:\f:\u02aa\u0003:\u02ad\b:\u0001;\u0001;\u0004"+
		";\u02b1\b;\u000b;\f;\u02b2\u0001;\u0001;\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0001<\u0001<\u0001<\u0001<\u0004<\u02c0\b<\u000b<\f<\u02c1\u0001<\u0001"+
		"<\u0001<\u0001<\u0001<\u0001<\u0005<\u02ca\b<\n<\f<\u02cd\t<\u0001<\u0001"+
		"<\u0003<\u02d1\b<\u0001=\u0001=\u0001=\u0001=\u0001=\u0003=\u02d8\b=\u0001"+
		">\u0001>\u0001>\u0003>\u02dd\b>\u0001>\u0001>\u0001?\u0001?\u0001?\u0005"+
		"?\u02e4\b?\n?\f?\u02e7\t?\u0001?\u0001?\u0001@\u0001@\u0001@\u0003@\u02ee"+
		"\b@\u0001@\u0001@\u0003@\u02f2\b@\u0001@\u0001@\u0005@\u02f6\b@\n@\f@"+
		"\u02f9\t@\u0003@\u02fb\b@\u0001@\u0001@\u0001A\u0001A\u0001A\u0003A\u0302"+
		"\bA\u0001A\u0001A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001B\u0001B\u0003"+
		"B\u030d\bB\u0001B\u0001B\u0001C\u0001C\u0001C\u0003C\u0314\bC\u0001C\u0001"+
		"C\u0005C\u0318\bC\nC\fC\u031b\tC\u0001C\u0001C\u0001D\u0005D\u0320\bD"+
		"\nD\fD\u0323\tD\u0001D\u0001D\u0005D\u0327\bD\nD\fD\u032a\tD\u0001E\u0005"+
		"E\u032d\bE\nE\fE\u0330\tE\u0001E\u0004E\u0333\bE\u000bE\fE\u0334\u0001"+
		"E\u0005E\u0338\bE\nE\fE\u033b\tE\u0001F\u0001F\u0001F\u0001F\u0001F\u0001"+
		"F\u0001F\u0001F\u0001F\u0001F\u0001F\u0003F\u0348\bF\u0001G\u0001G\u0001"+
		"G\u0001G\u0005G\u034e\bG\nG\fG\u0351\tG\u0001G\u0003G\u0354\bG\u0001G"+
		"\u0001G\u0001H\u0001H\u0004H\u035a\bH\u000bH\fH\u035b\u0001H\u0001H\u0001"+
		"H\u0001H\u0003H\u0362\bH\u0001I\u0001I\u0005I\u0366\bI\nI\fI\u0369\tI"+
		"\u0001I\u0001I\u0005I\u036d\bI\nI\fI\u0370\tI\u0001I\u0001I\u0001J\u0001"+
		"J\u0004J\u0376\bJ\u000bJ\fJ\u0377\u0001J\u0001J\u0001K\u0001K\u0003K\u037e"+
		"\bK\u0001L\u0004L\u0381\bL\u000bL\fL\u0382\u0001L\u0000\u0000M\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u0000\u0007\u0001"+
		"\u0000]^\u0002\u0000;;>A\u0002\u00002244\u0001\u0001\u0087\u0087\u0002"+
		"\u0000\u0001\u0002y|\u0002\u0000\u0002\u0003\u0012\u0012\u0001\u0000."+
		"/\u03e1\u0000\u009d\u0001\u0000\u0000\u0000\u0002\u00a5\u0001\u0000\u0000"+
		"\u0000\u0004\u00b4\u0001\u0000\u0000\u0000\u0006\u00de\u0001\u0000\u0000"+
		"\u0000\b\u00f7\u0001\u0000\u0000\u0000\n\u00fb\u0001\u0000\u0000\u0000"+
		"\f\u00fd\u0001\u0000\u0000\u0000\u000e\u0100\u0001\u0000\u0000\u0000\u0010"+
		"\u0103\u0001\u0000\u0000\u0000\u0012\u010e\u0001\u0000\u0000\u0000\u0014"+
		"\u0117\u0001\u0000\u0000\u0000\u0016\u0120\u0001\u0000\u0000\u0000\u0018"+
		"\u0129\u0001\u0000\u0000\u0000\u001a\u0132\u0001\u0000\u0000\u0000\u001c"+
		"\u013b\u0001\u0000\u0000\u0000\u001e\u0145\u0001\u0000\u0000\u0000 \u014f"+
		"\u0001\u0000\u0000\u0000\"\u0158\u0001\u0000\u0000\u0000$\u015a\u0001"+
		"\u0000\u0000\u0000&\u0163\u0001\u0000\u0000\u0000(\u016c\u0001\u0000\u0000"+
		"\u0000*\u018b\u0001\u0000\u0000\u0000,\u018d\u0001\u0000\u0000\u0000."+
		"\u0196\u0001\u0000\u0000\u00000\u019f\u0001\u0000\u0000\u00002\u01a9\u0001"+
		"\u0000\u0000\u00004\u01b2\u0001\u0000\u0000\u00006\u01bb\u0001\u0000\u0000"+
		"\u00008\u01c6\u0001\u0000\u0000\u0000:\u01d2\u0001\u0000\u0000\u0000<"+
		"\u01d5\u0001\u0000\u0000\u0000>\u01d8\u0001\u0000\u0000\u0000@\u01db\u0001"+
		"\u0000\u0000\u0000B\u01e5\u0001\u0000\u0000\u0000D\u01e8\u0001\u0000\u0000"+
		"\u0000F\u01eb\u0001\u0000\u0000\u0000H\u01f9\u0001\u0000\u0000\u0000J"+
		"\u01fc\u0001\u0000\u0000\u0000L\u020f\u0001\u0000\u0000\u0000N\u0217\u0001"+
		"\u0000\u0000\u0000P\u0221\u0001\u0000\u0000\u0000R\u022b\u0001\u0000\u0000"+
		"\u0000T\u0231\u0001\u0000\u0000\u0000V\u023d\u0001\u0000\u0000\u0000X"+
		"\u023f\u0001\u0000\u0000\u0000Z\u0247\u0001\u0000\u0000\u0000\\\u0250"+
		"\u0001\u0000\u0000\u0000^\u0259\u0001\u0000\u0000\u0000`\u025f\u0001\u0000"+
		"\u0000\u0000b\u0261\u0001\u0000\u0000\u0000d\u026d\u0001\u0000\u0000\u0000"+
		"f\u026f\u0001\u0000\u0000\u0000h\u0282\u0001\u0000\u0000\u0000j\u0287"+
		"\u0001\u0000\u0000\u0000l\u028c\u0001\u0000\u0000\u0000n\u0290\u0001\u0000"+
		"\u0000\u0000p\u029a\u0001\u0000\u0000\u0000r\u02a4\u0001\u0000\u0000\u0000"+
		"t\u02ac\u0001\u0000\u0000\u0000v\u02ae\u0001\u0000\u0000\u0000x\u02d0"+
		"\u0001\u0000\u0000\u0000z\u02d2\u0001\u0000\u0000\u0000|\u02d9\u0001\u0000"+
		"\u0000\u0000~\u02e0\u0001\u0000\u0000\u0000\u0080\u02ea\u0001\u0000\u0000"+
		"\u0000\u0082\u02fe\u0001\u0000\u0000\u0000\u0084\u0307\u0001\u0000\u0000"+
		"\u0000\u0086\u0310\u0001\u0000\u0000\u0000\u0088\u0321\u0001\u0000\u0000"+
		"\u0000\u008a\u032e\u0001\u0000\u0000\u0000\u008c\u0347\u0001\u0000\u0000"+
		"\u0000\u008e\u0349\u0001\u0000\u0000\u0000\u0090\u0361\u0001\u0000\u0000"+
		"\u0000\u0092\u0363\u0001\u0000\u0000\u0000\u0094\u0373\u0001\u0000\u0000"+
		"\u0000\u0096\u037b\u0001\u0000\u0000\u0000\u0098\u0380\u0001\u0000\u0000"+
		"\u0000\u009a\u009c\u0003\u0002\u0001\u0000\u009b\u009a\u0001\u0000\u0000"+
		"\u0000\u009c\u009f\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u00a0\u0001\u0000\u0000"+
		"\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u0000\u0000"+
		"\u0001\u00a1\u0001\u0001\u0000\u0000\u0000\u00a2\u00a6\u0003\u0004\u0002"+
		"\u0000\u00a3\u00a6\u0003\b\u0004\u0000\u00a4\u00a6\u0003\u0098L\u0000"+
		"\u00a5\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u0003\u0001\u0000\u0000\u0000"+
		"\u00a7\u00b5\u0003\u0006\u0003\u0000\u00a8\u00b5\u0003T*\u0000\u00a9\u00b5"+
		"\u0003Z-\u0000\u00aa\u00b5\u0003\\.\u0000\u00ab\u00b5\u0003X,\u0000\u00ac"+
		"\u00b0\u0005o\u0000\u0000\u00ad\u00af\u0005\u0019\u0000\u0000\u00ae\u00ad"+
		"\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b5"+
		"\u0005\u008a\u0000\u0000\u00b4\u00a7\u0001\u0000\u0000\u0000\u00b4\u00a8"+
		"\u0001\u0000\u0000\u0000\u00b4\u00a9\u0001\u0000\u0000\u0000\u00b4\u00aa"+
		"\u0001\u0000\u0000\u0000\u00b4\u00ab\u0001\u0000\u0000\u0000\u00b4\u00ac"+
		"\u0001\u0000\u0000\u0000\u00b5\u0005\u0001\u0000\u0000\u0000\u00b6\u00df"+
		"\u0003\f\u0006\u0000\u00b7\u00df\u0003\u000e\u0007\u0000\u00b8\u00df\u0003"+
		":\u001d\u0000\u00b9\u00df\u0003<\u001e\u0000\u00ba\u00df\u0003B!\u0000"+
		"\u00bb\u00df\u0003D\"\u0000\u00bc\u00df\u0003F#\u0000\u00bd\u00df\u0003"+
		"H$\u0000\u00be\u00df\u0003J%\u0000\u00bf\u00c0\u0007\u0000\u0000\u0000"+
		"\u00c0\u00df\u0003x<\u0000\u00c1\u00c2\u0005Q\u0000\u0000\u00c2\u00df"+
		"\u0003x<\u0000\u00c3\u00c4\u0005M\u0000\u0000\u00c4\u00df\u0003x<\u0000"+
		"\u00c5\u00c6\u0005b\u0000\u0000\u00c6\u00df\u0003x<\u0000\u00c7\u00c8"+
		"\u00057\u0000\u0000\u00c8\u00df\u0003x<\u0000\u00c9\u00ca\u0005`\u0000"+
		"\u0000\u00ca\u00df\u0003x<\u0000\u00cb\u00df\u0005P\u0000\u0000\u00cc"+
		"\u00df\u0003>\u001f\u0000\u00cd\u00df\u0003@ \u0000\u00ce\u00cf\u0005"+
		"_\u0000\u0000\u00cf\u00df\u0003x<\u0000\u00d0\u00d1\u0005\u001f\u0000"+
		"\u0000\u00d1\u00df\u0003x<\u0000\u00d2\u00d3\u0005a\u0000\u0000\u00d3"+
		"\u00df\u0003x<\u0000\u00d4\u00df\u0005 \u0000\u0000\u00d5\u00d6\u0005"+
		"[\u0000\u0000\u00d6\u00df\u0003x<\u0000\u00d7\u00df\u0003\u0096K\u0000"+
		"\u00d8\u00d9\u0005c\u0000\u0000\u00d9\u00df\u0003\u0080@\u0000\u00da\u00df"+
		"\u0005/\u0000\u0000\u00db\u00df\u0005.\u0000\u0000\u00dc\u00df\u0005i"+
		"\u0000\u0000\u00dd\u00df\u0003R)\u0000\u00de\u00b6\u0001\u0000\u0000\u0000"+
		"\u00de\u00b7\u0001\u0000\u0000\u0000\u00de\u00b8\u0001\u0000\u0000\u0000"+
		"\u00de\u00b9\u0001\u0000\u0000\u0000\u00de\u00ba\u0001\u0000\u0000\u0000"+
		"\u00de\u00bb\u0001\u0000\u0000\u0000\u00de\u00bc\u0001\u0000\u0000\u0000"+
		"\u00de\u00bd\u0001\u0000\u0000\u0000\u00de\u00be\u0001\u0000\u0000\u0000"+
		"\u00de\u00bf\u0001\u0000\u0000\u0000\u00de\u00c1\u0001\u0000\u0000\u0000"+
		"\u00de\u00c3\u0001\u0000\u0000\u0000\u00de\u00c5\u0001\u0000\u0000\u0000"+
		"\u00de\u00c7\u0001\u0000\u0000\u0000\u00de\u00c9\u0001\u0000\u0000\u0000"+
		"\u00de\u00cb\u0001\u0000\u0000\u0000\u00de\u00cc\u0001\u0000\u0000\u0000"+
		"\u00de\u00cd\u0001\u0000\u0000\u0000\u00de\u00ce\u0001\u0000\u0000\u0000"+
		"\u00de\u00d0\u0001\u0000\u0000\u0000\u00de\u00d2\u0001\u0000\u0000\u0000"+
		"\u00de\u00d4\u0001\u0000\u0000\u0000\u00de\u00d5\u0001\u0000\u0000\u0000"+
		"\u00de\u00d7\u0001\u0000\u0000\u0000\u00de\u00d8\u0001\u0000\u0000\u0000"+
		"\u00de\u00da\u0001\u0000\u0000\u0000\u00de\u00db\u0001\u0000\u0000\u0000"+
		"\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00dd\u0001\u0000\u0000\u0000"+
		"\u00df\u0007\u0001\u0000\u0000\u0000\u00e0\u00f8\u0003\u0010\b\u0000\u00e1"+
		"\u00f8\u0003N\'\u0000\u00e2\u00f8\u0003P(\u0000\u00e3\u00f8\u0003\u0012"+
		"\t\u0000\u00e4\u00f8\u0003\u0016\u000b\u0000\u00e5\u00f8\u0003L&\u0000"+
		"\u00e6\u00f8\u0003\u0018\f\u0000\u00e7\u00f8\u0003\u001a\r\u0000\u00e8"+
		"\u00f8\u0003\u001c\u000e\u0000\u00e9\u00f8\u0003\u001e\u000f\u0000\u00ea"+
		"\u00f8\u0003 \u0010\u0000\u00eb\u00f8\u00030\u0018\u0000\u00ec\u00f8\u0003"+
		"*\u0015\u0000\u00ed\u00f8\u0003.\u0017\u0000\u00ee\u00f8\u0003&\u0013"+
		"\u0000\u00ef\u00f8\u0003(\u0014\u0000\u00f0\u00f8\u0003,\u0016\u0000\u00f1"+
		"\u00f8\u00032\u0019\u0000\u00f2\u00f8\u00034\u001a\u0000\u00f3\u00f8\u0003"+
		"6\u001b\u0000\u00f4\u00f8\u00038\u001c\u0000\u00f5\u00f8\u0003\u0094J"+
		"\u0000\u00f6\u00f8\u0003V+\u0000\u00f7\u00e0\u0001\u0000\u0000\u0000\u00f7"+
		"\u00e1\u0001\u0000\u0000\u0000\u00f7\u00e2\u0001\u0000\u0000\u0000\u00f7"+
		"\u00e3\u0001\u0000\u0000\u0000\u00f7\u00e4\u0001\u0000\u0000\u0000\u00f7"+
		"\u00e5\u0001\u0000\u0000\u0000\u00f7\u00e6\u0001\u0000\u0000\u0000\u00f7"+
		"\u00e7\u0001\u0000\u0000\u0000\u00f7\u00e8\u0001\u0000\u0000\u0000\u00f7"+
		"\u00e9\u0001\u0000\u0000\u0000\u00f7\u00ea\u0001\u0000\u0000\u0000\u00f7"+
		"\u00eb\u0001\u0000\u0000\u0000\u00f7\u00ec\u0001\u0000\u0000\u0000\u00f7"+
		"\u00ed\u0001\u0000\u0000\u0000\u00f7\u00ee\u0001\u0000\u0000\u0000\u00f7"+
		"\u00ef\u0001\u0000\u0000\u0000\u00f7\u00f0\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f7\u00f2\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f7\u00f4\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f6\u0001\u0000\u0000\u0000\u00f8"+
		"\t\u0001\u0000\u0000\u0000\u00f9\u00fc\u0003\u0098L\u0000\u00fa\u00fc"+
		"\u0003X,\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fa\u0001\u0000"+
		"\u0000\u0000\u00fc\u000b\u0001\u0000\u0000\u0000\u00fd\u00fe\u00056\u0000"+
		"\u0000\u00fe\u00ff\u0003\u0080@\u0000\u00ff\r\u0001\u0000\u0000\u0000"+
		"\u0100\u0101\u00058\u0000\u0000\u0101\u0102\u0003\u0082A\u0000\u0102\u000f"+
		"\u0001\u0000\u0000\u0000\u0103\u0104\u00058\u0000\u0000\u0104\u0109\u0003"+
		"|>\u0000\u0105\u0108\u0003\u0002\u0001\u0000\u0106\u0108\u0005=\u0000"+
		"\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107\u0106\u0001\u0000\u0000"+
		"\u0000\u0108\u010b\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000"+
		"\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010c\u0001\u0000\u0000"+
		"\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c\u010d\u0007\u0001\u0000"+
		"\u0000\u010d\u0011\u0001\u0000\u0000\u0000\u010e\u010f\u0005E\u0000\u0000"+
		"\u010f\u0111\u0003|>\u0000\u0110\u0112\u0003\u0002\u0001\u0000\u0111\u0110"+
		"\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0111"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\u0001\u0000\u0000\u0000\u0115\u0116\u0005F\u0000\u0000\u0116\u0013\u0001"+
		"\u0000\u0000\u0000\u0117\u0118\u0005I\u0000\u0000\u0118\u011a\u0003|>"+
		"\u0000\u0119\u011b\u0003\u0002\u0001\u0000\u011a\u0119\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000"+
		"\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000"+
		"\u0000\u011e\u011f\u0005J\u0000\u0000\u011f\u0015\u0001\u0000\u0000\u0000"+
		"\u0120\u0121\u0005G\u0000\u0000\u0121\u0123\u0003\u0084B\u0000\u0122\u0124"+
		"\u0003\u0002\u0001\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0124\u0125"+
		"\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126"+
		"\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0128"+
		"\u0005H\u0000\u0000\u0128\u0017\u0001\u0000\u0000\u0000\u0129\u012a\u0005"+
		"K\u0000\u0000\u012a\u012c\u0003|>\u0000\u012b\u012d\u0003\u0002\u0001"+
		"\u0000\u012c\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000"+
		"\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000"+
		"\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0131\u0005L\u0000\u0000"+
		"\u0131\u0019\u0001\u0000\u0000\u0000\u0132\u0133\u0005N\u0000\u0000\u0133"+
		"\u0135\u0003x<\u0000\u0134\u0136\u0003\u0002\u0001\u0000\u0135\u0134\u0001"+
		"\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137\u0135\u0001"+
		"\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u0139\u0001"+
		"\u0000\u0000\u0000\u0139\u013a\u0005O\u0000\u0000\u013a\u001b\u0001\u0000"+
		"\u0000\u0000\u013b\u013c\u0005\u001a\u0000\u0000\u013c\u013e\u0003v;\u0000"+
		"\u013d\u013f\u0003\u0002\u0001\u0000\u013e\u013d\u0001\u0000\u0000\u0000"+
		"\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000"+
		"\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0143\u0001\u0000\u0000\u0000"+
		"\u0142\u0144\u0003\"\u0011\u0000\u0143\u0142\u0001\u0000\u0000\u0000\u0143"+
		"\u0144\u0001\u0000\u0000\u0000\u0144\u001d\u0001\u0000\u0000\u0000\u0145"+
		"\u0146\u0005\u001b\u0000\u0000\u0146\u0148\u0003v;\u0000\u0147\u0149\u0003"+
		"\u0002\u0001\u0000\u0148\u0147\u0001\u0000\u0000\u0000\u0149\u014a\u0001"+
		"\u0000\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014a\u014b\u0001"+
		"\u0000\u0000\u0000\u014b\u014d\u0001\u0000\u0000\u0000\u014c\u014e\u0003"+
		"\"\u0011\u0000\u014d\u014c\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000"+
		"\u0000\u0000\u014e\u001f\u0001\u0000\u0000\u0000\u014f\u0151\u0005\u001c"+
		"\u0000\u0000\u0150\u0152\u0003\u0002\u0001\u0000\u0151\u0150\u0001\u0000"+
		"\u0000\u0000\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000"+
		"\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0156\u0001\u0000"+
		"\u0000\u0000\u0155\u0157\u0003\"\u0011\u0000\u0156\u0155\u0001\u0000\u0000"+
		"\u0000\u0156\u0157\u0001\u0000\u0000\u0000\u0157!\u0001\u0000\u0000\u0000"+
		"\u0158\u0159\u0005\u001d\u0000\u0000\u0159#\u0001\u0000\u0000\u0000\u015a"+
		"\u015b\u0005\"\u0000\u0000\u015b\u015d\u0003v;\u0000\u015c\u015e\u0003"+
		"\u0002\u0001\u0000\u015d\u015c\u0001\u0000\u0000\u0000\u015e\u015f\u0001"+
		"\u0000\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001"+
		"\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000\u0161\u0162\u0005"+
		"#\u0000\u0000\u0162%\u0001\u0000\u0000\u0000\u0163\u0164\u0005$\u0000"+
		"\u0000\u0164\u0166\u0003v;\u0000\u0165\u0167\u0003\u0002\u0001\u0000\u0166"+
		"\u0165\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168"+
		"\u0166\u0001\u0000\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u0169"+
		"\u016a\u0001\u0000\u0000\u0000\u016a\u016b\u0005%\u0000\u0000\u016b\'"+
		"\u0001\u0000\u0000\u0000\u016c\u0170\u0005X\u0000\u0000\u016d\u016f\u0003"+
		"~?\u0000\u016e\u016d\u0001\u0000\u0000\u0000\u016f\u0172\u0001\u0000\u0000"+
		"\u0000\u0170\u016e\u0001\u0000\u0000\u0000\u0170\u0171\u0001\u0000\u0000"+
		"\u0000\u0171\u0174\u0001\u0000\u0000\u0000\u0172\u0170\u0001\u0000\u0000"+
		"\u0000\u0173\u0175\u0003\u0002\u0001\u0000\u0174\u0173\u0001\u0000\u0000"+
		"\u0000\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000"+
		"\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000"+
		"\u0000\u0178\u0179\u0005Y\u0000\u0000\u0179)\u0001\u0000\u0000\u0000\u017a"+
		"\u017b\u0005V\u0000\u0000\u017b\u017d\u0003|>\u0000\u017c\u017e\u0003"+
		"\u0002\u0001\u0000\u017d\u017c\u0001\u0000\u0000\u0000\u017e\u017f\u0001"+
		"\u0000\u0000\u0000\u017f\u017d\u0001\u0000\u0000\u0000\u017f\u0180\u0001"+
		"\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000\u0000\u0181\u0182\u0005"+
		"W\u0000\u0000\u0182\u018c\u0001\u0000\u0000\u0000\u0183\u0185\u0005T\u0000"+
		"\u0000\u0184\u0186\u0003\u0002\u0001\u0000\u0185\u0184\u0001\u0000\u0000"+
		"\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000"+
		"\u0000\u0187\u0188\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000"+
		"\u0000\u0189\u018a\u0005U\u0000\u0000\u018a\u018c\u0001\u0000\u0000\u0000"+
		"\u018b\u017a\u0001\u0000\u0000\u0000\u018b\u0183\u0001\u0000\u0000\u0000"+
		"\u018c+\u0001\u0000\u0000\u0000\u018d\u018e\u0005Z\u0000\u0000\u018e\u0190"+
		"\u0003x<\u0000\u018f\u0191\u0003\u0002\u0001\u0000\u0190\u018f\u0001\u0000"+
		"\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0192\u0190\u0001\u0000"+
		"\u0000\u0000\u0192\u0193\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000"+
		"\u0000\u0000\u0194\u0195\u0005\\\u0000\u0000\u0195-\u0001\u0000\u0000"+
		"\u0000\u0196\u0197\u0005R\u0000\u0000\u0197\u0199\u0003r9\u0000\u0198"+
		"\u019a\u0003\u0002\u0001\u0000\u0199\u0198\u0001\u0000\u0000\u0000\u019a"+
		"\u019b\u0001\u0000\u0000\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019b"+
		"\u019c\u0001\u0000\u0000\u0000\u019c\u019d\u0001\u0000\u0000\u0000\u019d"+
		"\u019e\u0005S\u0000\u0000\u019e/\u0001\u0000\u0000\u0000\u019f\u01a0\u0005"+
		"\u001e\u0000\u0000\u01a0\u01a3\u0003r9\u0000\u01a1\u01a4\u0003\u0002\u0001"+
		"\u0000\u01a2\u01a4\u0005.\u0000\u0000\u01a3\u01a1\u0001\u0000\u0000\u0000"+
		"\u01a3\u01a2\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000"+
		"\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000"+
		"\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a7\u01a8\u0005!\u0000\u0000\u01a8"+
		"1\u0001\u0000\u0000\u0000\u01a9\u01aa\u0005,\u0000\u0000\u01aa\u01ac\u0003"+
		"r9\u0000\u01ab\u01ad\u0003\u0002\u0001\u0000\u01ac\u01ab\u0001\u0000\u0000"+
		"\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01ae\u01ac\u0001\u0000\u0000"+
		"\u0000\u01ae\u01af\u0001\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000"+
		"\u0000\u01b0\u01b1\u0005-\u0000\u0000\u01b13\u0001\u0000\u0000\u0000\u01b2"+
		"\u01b3\u0005(\u0000\u0000\u01b3\u01b5\u0003r9\u0000\u01b4\u01b6\u0003"+
		"\u0002\u0001\u0000\u01b5\u01b4\u0001\u0000\u0000\u0000\u01b6\u01b7\u0001"+
		"\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001"+
		"\u0000\u0000\u0000\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01ba\u0005"+
		")\u0000\u0000\u01ba5\u0001\u0000\u0000\u0000\u01bb\u01bc\u0005&\u0000"+
		"\u0000\u01bc\u01bd\u0005y\u0000\u0000\u01bd\u01be\u0003t:\u0000\u01be"+
		"\u01c0\u0005z\u0000\u0000\u01bf\u01c1\u0003\u0002\u0001\u0000\u01c0\u01bf"+
		"\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000\u0000\u01c2\u01c0"+
		"\u0001\u0000\u0000\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c4"+
		"\u0001\u0000\u0000\u0000\u01c4\u01c5\u0005\'\u0000\u0000\u01c57\u0001"+
		"\u0000\u0000\u0000\u01c6\u01c7\u0005*\u0000\u0000\u01c7\u01c8\u0005y\u0000"+
		"\u0000\u01c8\u01c9\u0003t:\u0000\u01c9\u01cc\u0005z\u0000\u0000\u01ca"+
		"\u01cd\u0003\u0002\u0001\u0000\u01cb\u01cd\u0005\"\u0000\u0000\u01cc\u01ca"+
		"\u0001\u0000\u0000\u0000\u01cc\u01cb\u0001\u0000\u0000\u0000\u01cd\u01ce"+
		"\u0001\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000\u01ce\u01cf"+
		"\u0001\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0\u01d1"+
		"\u0005+\u0000\u0000\u01d19\u0001\u0000\u0000\u0000\u01d2\u01d3\u0005<"+
		"\u0000\u0000\u01d3\u01d4\u0003\u0080@\u0000\u01d4;\u0001\u0000\u0000\u0000"+
		"\u01d5\u01d6\u0005D\u0000\u0000\u01d6\u01d7\u0003|>\u0000\u01d7=\u0001"+
		"\u0000\u0000\u0000\u01d8\u01d9\u0005d\u0000\u0000\u01d9\u01da\u0003\u0080"+
		"@\u0000\u01da?\u0001\u0000\u0000\u0000\u01db\u01dc\u0005e\u0000\u0000"+
		"\u01dc\u01dd\u0005\f\u0000\u0000\u01dd\u01de\u0003\u008aE\u0000\u01de"+
		"\u01e1\u0005\u0014\u0000\u0000\u01df\u01e2\u0003\u0088D\u0000\u01e0\u01e2"+
		"\u0003\u008aE\u0000\u01e1\u01df\u0001\u0000\u0000\u0000\u01e1\u01e0\u0001"+
		"\u0000\u0000\u0000\u01e2\u01e3\u0001\u0000\u0000\u0000\u01e3\u01e4\u0005"+
		"\r\u0000\u0000\u01e4A\u0001\u0000\u0000\u0000\u01e5\u01e6\u00050\u0000"+
		"\u0000\u01e6\u01e7\u0003\u0080@\u0000\u01e7C\u0001\u0000\u0000\u0000\u01e8"+
		"\u01e9\u00051\u0000\u0000\u01e9\u01ea\u0003\u0080@\u0000\u01eaE\u0001"+
		"\u0000\u0000\u0000\u01eb\u01ec\u0007\u0002\u0000\u0000\u01ec\u01ed\u0005"+
		"\f\u0000\u0000\u01ed\u01ee\u0003\u008aE\u0000\u01ee\u01f1\u0005\u0014"+
		"\u0000\u0000\u01ef\u01f2\u0003\u0088D\u0000\u01f0\u01f2\u0003\u008aE\u0000"+
		"\u01f1\u01ef\u0001\u0000\u0000\u0000\u01f1\u01f0\u0001\u0000\u0000\u0000"+
		"\u01f2\u01f5\u0001\u0000\u0000\u0000\u01f3\u01f4\u0005\u0014\u0000\u0000"+
		"\u01f4\u01f6\u0003\u008aE\u0000\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f5"+
		"\u01f6\u0001\u0000\u0000\u0000\u01f6\u01f7\u0001\u0000\u0000\u0000\u01f7"+
		"\u01f8\u0005\r\u0000\u0000\u01f8G\u0001\u0000\u0000\u0000\u01f9\u01fa"+
		"\u00053\u0000\u0000\u01fa\u01fb\u0003\u0080@\u0000\u01fbI\u0001\u0000"+
		"\u0000\u0000\u01fc\u01fd\u00055\u0000\u0000\u01fd\u0200\u0005\f\u0000"+
		"\u0000\u01fe\u0201\u0003\u0088D\u0000\u01ff\u0201\u0003\u008aE\u0000\u0200"+
		"\u01fe\u0001\u0000\u0000\u0000\u0200\u01ff\u0001\u0000\u0000\u0000\u0201"+
		"\u0202\u0001\u0000\u0000\u0000\u0202\u0203\u0005\u0014\u0000\u0000\u0203"+
		"\u0204\u0003\u008aE\u0000\u0204\u0205\u0005\u0014\u0000\u0000\u0205\u020b"+
		"\u0003\u008aE\u0000\u0206\u0209\u0005\u0014\u0000\u0000\u0207\u020a\u0003"+
		"\u0088D\u0000\u0208\u020a\u0003\u008aE\u0000\u0209\u0207\u0001\u0000\u0000"+
		"\u0000\u0209\u0208\u0001\u0000\u0000\u0000\u020a\u020c\u0001\u0000\u0000"+
		"\u0000\u020b\u0206\u0001\u0000\u0000\u0000\u020b\u020c\u0001\u0000\u0000"+
		"\u0000\u020c\u020d\u0001\u0000\u0000\u0000\u020d\u020e\u0005\r\u0000\u0000"+
		"\u020eK\u0001\u0000\u0000\u0000\u020f\u0211\u0005B\u0000\u0000\u0210\u0212"+
		"\u0003\u0002\u0001\u0000\u0211\u0210\u0001\u0000\u0000\u0000\u0212\u0213"+
		"\u0001\u0000\u0000\u0000\u0213\u0211\u0001\u0000\u0000\u0000\u0213\u0214"+
		"\u0001\u0000\u0000\u0000\u0214\u0215\u0001\u0000\u0000\u0000\u0215\u0216"+
		"\u0005C\u0000\u0000\u0216M\u0001\u0000\u0000\u0000\u0217\u0218\u00059"+
		"\u0000\u0000\u0218\u021c\u0003|>\u0000\u0219\u021b\u0003\u0002\u0001\u0000"+
		"\u021a\u0219\u0001\u0000\u0000\u0000\u021b\u021e\u0001\u0000\u0000\u0000"+
		"\u021c\u021a\u0001\u0000\u0000\u0000\u021c\u021d\u0001\u0000\u0000\u0000"+
		"\u021d\u021f\u0001\u0000\u0000\u0000\u021e\u021c\u0001\u0000\u0000\u0000"+
		"\u021f\u0220\u0005\u001d\u0000\u0000\u0220O\u0001\u0000\u0000\u0000\u0221"+
		"\u0222\u0005:\u0000\u0000\u0222\u0226\u0003|>\u0000\u0223\u0225\u0003"+
		"\u0002\u0001\u0000\u0224\u0223\u0001\u0000\u0000\u0000\u0225\u0228\u0001"+
		"\u0000\u0000\u0000\u0226\u0224\u0001\u0000\u0000\u0000\u0226\u0227\u0001"+
		"\u0000\u0000\u0000\u0227\u0229\u0001\u0000\u0000\u0000\u0228\u0226\u0001"+
		"\u0000\u0000\u0000\u0229\u022a\u0005\u001d\u0000\u0000\u022aQ\u0001\u0000"+
		"\u0000\u0000\u022b\u022f\u0005j\u0000\u0000\u022c\u0230\u0003\u0086C\u0000"+
		"\u022d\u022e\u0005\f\u0000\u0000\u022e\u0230\u0005\r\u0000\u0000\u022f"+
		"\u022c\u0001\u0000\u0000\u0000\u022f\u022d\u0001\u0000\u0000\u0000\u0230"+
		"S\u0001\u0000\u0000\u0000\u0231\u0232\u0005k\u0000\u0000\u0232U\u0001"+
		"\u0000\u0000\u0000\u0233\u0235\u0005f\u0000\u0000\u0234\u0236\u0003x<"+
		"\u0000\u0235\u0234\u0001\u0000\u0000\u0000\u0236\u0237\u0001\u0000\u0000"+
		"\u0000\u0237\u0235\u0001\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000"+
		"\u0000\u0238\u0239\u0001\u0000\u0000\u0000\u0239\u023a\u0005\u0086\u0000"+
		"\u0000\u023a\u023e\u0001\u0000\u0000\u0000\u023b\u023c\u0005f\u0000\u0000"+
		"\u023c\u023e\u0003v;\u0000\u023d\u0233\u0001\u0000\u0000\u0000\u023d\u023b"+
		"\u0001\u0000\u0000\u0000\u023eW\u0001\u0000\u0000\u0000\u023f\u0241\u0005"+
		"n\u0000\u0000\u0240\u0242\u0003x<\u0000\u0241\u0240\u0001\u0000\u0000"+
		"\u0000\u0242\u0243\u0001\u0000\u0000\u0000\u0243\u0241\u0001\u0000\u0000"+
		"\u0000\u0243\u0244\u0001\u0000\u0000\u0000\u0244\u0245\u0001\u0000\u0000"+
		"\u0000\u0245\u0246\u0007\u0003\u0000\u0000\u0246Y\u0001\u0000\u0000\u0000"+
		"\u0247\u024b\u0005l\u0000\u0000\u0248\u024a\u0003^/\u0000\u0249\u0248"+
		"\u0001\u0000\u0000\u0000\u024a\u024d\u0001\u0000\u0000\u0000\u024b\u0249"+
		"\u0001\u0000\u0000\u0000\u024b\u024c\u0001\u0000\u0000\u0000\u024c\u024e"+
		"\u0001\u0000\u0000\u0000\u024d\u024b\u0001\u0000\u0000\u0000\u024e\u024f"+
		"\u0005p\u0000\u0000\u024f[\u0001\u0000\u0000\u0000\u0250\u0254\u0005m"+
		"\u0000\u0000\u0251\u0253\u0003^/\u0000\u0252\u0251\u0001\u0000\u0000\u0000"+
		"\u0253\u0256\u0001\u0000\u0000\u0000\u0254\u0252\u0001\u0000\u0000\u0000"+
		"\u0254\u0255\u0001\u0000\u0000\u0000\u0255\u0257\u0001\u0000\u0000\u0000"+
		"\u0256\u0254\u0001\u0000\u0000\u0000\u0257\u0258\u0005q\u0000\u0000\u0258"+
		"]\u0001\u0000\u0000\u0000\u0259\u025a\u0003x<\u0000\u025a_\u0001\u0000"+
		"\u0000\u0000\u025b\u0260\u0003h4\u0000\u025c\u0260\u0003b1\u0000\u025d"+
		"\u0260\u0003d2\u0000\u025e\u0260\u0003f3\u0000\u025f\u025b\u0001\u0000"+
		"\u0000\u0000\u025f\u025c\u0001\u0000\u0000\u0000\u025f\u025d\u0001\u0000"+
		"\u0000\u0000\u025f\u025e\u0001\u0000\u0000\u0000\u0260a\u0001\u0000\u0000"+
		"\u0000\u0261\u0262\u0005\u0002\u0000\u0000\u0262\u0263\u0005\b\u0000\u0000"+
		"\u0263\u0264\u0005\u0006\u0000\u0000\u0264c\u0001\u0000\u0000\u0000\u0265"+
		"\u0266\u0003j5\u0000\u0266\u0267\u0005\b\u0000\u0000\u0267\u0268\u0003"+
		"n7\u0000\u0268\u026e\u0001\u0000\u0000\u0000\u0269\u026a\u0003j5\u0000"+
		"\u026a\u026b\u0005\b\u0000\u0000\u026b\u026c\u0005\u0006\u0000\u0000\u026c"+
		"\u026e\u0001\u0000\u0000\u0000\u026d\u0265\u0001\u0000\u0000\u0000\u026d"+
		"\u0269\u0001\u0000\u0000\u0000\u026ee\u0001\u0000\u0000\u0000\u026f\u0271"+
		"\u0005\u0004\u0000\u0000\u0270\u0272\u0005\u0005\u0000\u0000\u0271\u0270"+
		"\u0001\u0000\u0000\u0000\u0272\u0273\u0001\u0000\u0000\u0000\u0273\u0271"+
		"\u0001\u0000\u0000\u0000\u0273\u0274\u0001\u0000\u0000\u0000\u0274\u0277"+
		"\u0001\u0000\u0000\u0000\u0275\u0278\u0003j5\u0000\u0276\u0278\u0003l"+
		"6\u0000\u0277\u0275\u0001\u0000\u0000\u0000\u0277\u0276\u0001\u0000\u0000"+
		"\u0000\u0278\u0279\u0001\u0000\u0000\u0000\u0279\u027d\u0005\u000e\u0000"+
		"\u0000\u027a\u027c\u0003x<\u0000\u027b\u027a\u0001\u0000\u0000\u0000\u027c"+
		"\u027f\u0001\u0000\u0000\u0000\u027d\u027b\u0001\u0000\u0000\u0000\u027d"+
		"\u027e\u0001\u0000\u0000\u0000\u027e\u0280\u0001\u0000\u0000\u0000\u027f"+
		"\u027d\u0001\u0000\u0000\u0000\u0280\u0281\u0005\u000f\u0000\u0000\u0281"+
		"g\u0001\u0000\u0000\u0000\u0282\u0283\u0003j5\u0000\u0283\u0284\u0005"+
		"\b\u0000\u0000\u0284\u0285\u0005\t\u0000\u0000\u0285i\u0001\u0000\u0000"+
		"\u0000\u0286\u0288\u0005\u0007\u0000\u0000\u0287\u0286\u0001\u0000\u0000"+
		"\u0000\u0287\u0288\u0001\u0000\u0000\u0000\u0288\u0289\u0001\u0000\u0000"+
		"\u0000\u0289\u028a\u0005\u0006\u0000\u0000\u028ak\u0001\u0000\u0000\u0000"+
		"\u028b\u028d\u0005\u0007\u0000\u0000\u028c\u028b\u0001\u0000\u0000\u0000"+
		"\u028c\u028d\u0001\u0000\u0000\u0000\u028d\u028e\u0001\u0000\u0000\u0000"+
		"\u028e\u028f\u0005\u0006\u0000\u0000\u028fm\u0001\u0000\u0000\u0000\u0290"+
		"\u0291\u0005\u0006\u0000\u0000\u0291\u0295\u0005\u000e\u0000\u0000\u0292"+
		"\u0294\u0003x<\u0000\u0293\u0292\u0001\u0000\u0000\u0000\u0294\u0297\u0001"+
		"\u0000\u0000\u0000\u0295\u0293\u0001\u0000\u0000\u0000\u0295\u0296\u0001"+
		"\u0000\u0000\u0000\u0296\u0298\u0001\u0000\u0000\u0000\u0297\u0295\u0001"+
		"\u0000\u0000\u0000\u0298\u0299\u0005\u000f\u0000\u0000\u0299o\u0001\u0000"+
		"\u0000\u0000\u029a\u029b\u0005\u0006\u0000\u0000\u029b\u029f\u0005\u000e"+
		"\u0000\u0000\u029c\u029e\u0003x<\u0000\u029d\u029c\u0001\u0000\u0000\u0000"+
		"\u029e\u02a1\u0001\u0000\u0000\u0000\u029f\u029d\u0001\u0000\u0000\u0000"+
		"\u029f\u02a0\u0001\u0000\u0000\u0000\u02a0\u02a2\u0001\u0000\u0000\u0000"+
		"\u02a1\u029f\u0001\u0000\u0000\u0000\u02a2\u02a3\u0005\u000f\u0000\u0000"+
		"\u02a3q\u0001\u0000\u0000\u0000\u02a4\u02a5\u0005\u0001\u0000\u0000\u02a5"+
		"s\u0001\u0000\u0000\u0000\u02a6\u02ad\u0003z=\u0000\u02a7\u02a9\u0007"+
		"\u0004\u0000\u0000\u02a8\u02a7\u0001\u0000\u0000\u0000\u02a9\u02aa\u0001"+
		"\u0000\u0000\u0000\u02aa\u02a8\u0001\u0000\u0000\u0000\u02aa\u02ab\u0001"+
		"\u0000\u0000\u0000\u02ab\u02ad\u0001\u0000\u0000\u0000\u02ac\u02a6\u0001"+
		"\u0000\u0000\u0000\u02ac\u02a8\u0001\u0000\u0000\u0000\u02adu\u0001\u0000"+
		"\u0000\u0000\u02ae\u02b0\u0005\u000e\u0000\u0000\u02af\u02b1\u0003x<\u0000"+
		"\u02b0\u02af\u0001\u0000\u0000\u0000\u02b1\u02b2\u0001\u0000\u0000\u0000"+
		"\u02b2\u02b0\u0001\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000\u0000\u0000"+
		"\u02b3\u02b4\u0001\u0000\u0000\u0000\u02b4\u02b5\u0005\u000f\u0000\u0000"+
		"\u02b5w\u0001\u0000\u0000\u0000\u02b6\u02d1\u0003`0\u0000\u02b7\u02d1"+
		"\u0003p8\u0000\u02b8\u02d1\u0005\u0006\u0000\u0000\u02b9\u02d1\u0003l"+
		"6\u0000\u02ba\u02d1\u0005\u0002\u0000\u0000\u02bb\u02d1\u0005\u0007\u0000"+
		"\u0000\u02bc\u02d1\u0005u\u0000\u0000\u02bd\u02d1\u0005\u0003\u0000\u0000"+
		"\u02be\u02c0\u0005\u0001\u0000\u0000\u02bf\u02be\u0001\u0000\u0000\u0000"+
		"\u02c0\u02c1\u0001\u0000\u0000\u0000\u02c1\u02bf\u0001\u0000\u0000\u0000"+
		"\u02c1\u02c2\u0001\u0000\u0000\u0000\u02c2\u02d1\u0001\u0000\u0000\u0000"+
		"\u02c3\u02d1\u0005\u0005\u0000\u0000\u02c4\u02d1\u0005\b\u0000\u0000\u02c5"+
		"\u02d1\u0005\t\u0000\u0000\u02c6\u02d1\u0005\n\u0000\u0000\u02c7\u02cb"+
		"\u0005\u000e\u0000\u0000\u02c8\u02ca\u0003x<\u0000\u02c9\u02c8\u0001\u0000"+
		"\u0000\u0000\u02ca\u02cd\u0001\u0000\u0000\u0000\u02cb\u02c9\u0001\u0000"+
		"\u0000\u0000\u02cb\u02cc\u0001\u0000\u0000\u0000\u02cc\u02ce\u0001\u0000"+
		"\u0000\u0000\u02cd\u02cb\u0001\u0000\u0000\u0000\u02ce\u02d1\u0005\u000f"+
		"\u0000\u0000\u02cf\u02d1\u0005\u0016\u0000\u0000\u02d0\u02b6\u0001\u0000"+
		"\u0000\u0000\u02d0\u02b7\u0001\u0000\u0000\u0000\u02d0\u02b8\u0001\u0000"+
		"\u0000\u0000\u02d0\u02b9\u0001\u0000\u0000\u0000\u02d0\u02ba\u0001\u0000"+
		"\u0000\u0000\u02d0\u02bb\u0001\u0000\u0000\u0000\u02d0\u02bc\u0001\u0000"+
		"\u0000\u0000\u02d0\u02bd\u0001\u0000\u0000\u0000\u02d0\u02bf\u0001\u0000"+
		"\u0000\u0000\u02d0\u02c3\u0001\u0000\u0000\u0000\u02d0\u02c4\u0001\u0000"+
		"\u0000\u0000\u02d0\u02c5\u0001\u0000\u0000\u0000\u02d0\u02c6\u0001\u0000"+
		"\u0000\u0000\u02d0\u02c7\u0001\u0000\u0000\u0000\u02d0\u02cf\u0001\u0000"+
		"\u0000\u0000\u02d1y\u0001\u0000\u0000\u0000\u02d2\u02d3\u0005\u0002\u0000"+
		"\u0000\u02d3\u02d4\u0005{\u0000\u0000\u02d4\u02d7\u0005\u0002\u0000\u0000"+
		"\u02d5\u02d6\u0005|\u0000\u0000\u02d6\u02d8\u0005\u0002\u0000\u0000\u02d7"+
		"\u02d5\u0001\u0000\u0000\u0000\u02d7\u02d8\u0001\u0000\u0000\u0000\u02d8"+
		"{\u0001\u0000\u0000\u0000\u02d9\u02dc\u0005\f\u0000\u0000\u02da\u02dd"+
		"\u0003\u0088D\u0000\u02db\u02dd\u0003\u008aE\u0000\u02dc\u02da\u0001\u0000"+
		"\u0000\u0000\u02dc\u02db\u0001\u0000\u0000\u0000\u02dd\u02de\u0001\u0000"+
		"\u0000\u0000\u02de\u02df\u0005\r\u0000\u0000\u02df}\u0001\u0000\u0000"+
		"\u0000\u02e0\u02e5\u0005\f\u0000\u0000\u02e1\u02e4\u0003\u0088D\u0000"+
		"\u02e2\u02e4\u0003\u008aE\u0000\u02e3\u02e1\u0001\u0000\u0000\u0000\u02e3"+
		"\u02e2\u0001\u0000\u0000\u0000\u02e4\u02e7\u0001\u0000\u0000\u0000\u02e5"+
		"\u02e3\u0001\u0000\u0000\u0000\u02e5\u02e6\u0001\u0000\u0000\u0000\u02e6"+
		"\u02e8\u0001\u0000\u0000\u0000\u02e7\u02e5\u0001\u0000\u0000\u0000\u02e8"+
		"\u02e9\u0005\r\u0000\u0000\u02e9\u007f\u0001\u0000\u0000\u0000\u02ea\u02ed"+
		"\u0005\f\u0000\u0000\u02eb\u02ee\u0003\u0088D\u0000\u02ec\u02ee\u0003"+
		"\u008aE\u0000\u02ed\u02eb\u0001\u0000\u0000\u0000\u02ed\u02ec\u0001\u0000"+
		"\u0000\u0000\u02ee\u02f1\u0001\u0000\u0000\u0000\u02ef\u02f0\u0005\u0014"+
		"\u0000\u0000\u02f0\u02f2\u0003\u008aE\u0000\u02f1\u02ef\u0001\u0000\u0000"+
		"\u0000\u02f1\u02f2\u0001\u0000\u0000\u0000\u02f2\u02fa\u0001\u0000\u0000"+
		"\u0000\u02f3\u02f7\u0005\u0014\u0000\u0000\u02f4\u02f6\u0005\u0082\u0000"+
		"\u0000\u02f5\u02f4\u0001\u0000\u0000\u0000\u02f6\u02f9\u0001\u0000\u0000"+
		"\u0000\u02f7\u02f5\u0001\u0000\u0000\u0000\u02f7\u02f8\u0001\u0000\u0000"+
		"\u0000\u02f8\u02fb\u0001\u0000\u0000\u0000\u02f9\u02f7\u0001\u0000\u0000"+
		"\u0000\u02fa\u02f3\u0001\u0000\u0000\u0000\u02fa\u02fb\u0001\u0000\u0000"+
		"\u0000\u02fb\u02fc\u0001\u0000\u0000\u0000\u02fc\u02fd\u0005\r\u0000\u0000"+
		"\u02fd\u0081\u0001\u0000\u0000\u0000\u02fe\u0301\u0005\f\u0000\u0000\u02ff"+
		"\u0302\u0003\u0088D\u0000\u0300\u0302\u0003\u008aE\u0000\u0301\u02ff\u0001"+
		"\u0000\u0000\u0000\u0301\u0300\u0001\u0000\u0000\u0000\u0302\u0303\u0001"+
		"\u0000\u0000\u0000\u0303\u0304\u0005\u0014\u0000\u0000\u0304\u0305\u0003"+
		"\u008aE\u0000\u0305\u0306\u0005\r\u0000\u0000\u0306\u0083\u0001\u0000"+
		"\u0000\u0000\u0307\u0308\u0005\f\u0000\u0000\u0308\u0309\u0003\u008aE"+
		"\u0000\u0309\u030c\u0005\u0014\u0000\u0000\u030a\u030d\u0003\u0088D\u0000"+
		"\u030b\u030d\u0003\u008aE\u0000\u030c\u030a\u0001\u0000\u0000\u0000\u030c"+
		"\u030b\u0001\u0000\u0000\u0000\u030d\u030e\u0001\u0000\u0000\u0000\u030e"+
		"\u030f\u0005\r\u0000\u0000\u030f\u0085\u0001\u0000\u0000\u0000\u0310\u0313"+
		"\u0005\f\u0000\u0000\u0311\u0314\u0003\u0088D\u0000\u0312\u0314\u0003"+
		"\u008aE\u0000\u0313\u0311\u0001\u0000\u0000\u0000\u0313\u0312\u0001\u0000"+
		"\u0000\u0000\u0314\u0319\u0001\u0000\u0000\u0000\u0315\u0316\u0005\u0014"+
		"\u0000\u0000\u0316\u0318\u0003\u008aE\u0000\u0317\u0315\u0001\u0000\u0000"+
		"\u0000\u0318\u031b\u0001\u0000\u0000\u0000\u0319\u0317\u0001\u0000\u0000"+
		"\u0000\u0319\u031a\u0001\u0000\u0000\u0000\u031a\u031c\u0001\u0000\u0000"+
		"\u0000\u031b\u0319\u0001\u0000\u0000\u0000\u031c\u031d\u0005\r\u0000\u0000"+
		"\u031d\u0087\u0001\u0000\u0000\u0000\u031e\u0320\u0005\u0082\u0000\u0000"+
		"\u031f\u031e\u0001\u0000\u0000\u0000\u0320\u0323\u0001\u0000\u0000\u0000"+
		"\u0321\u031f\u0001\u0000\u0000\u0000\u0321\u0322\u0001\u0000\u0000\u0000"+
		"\u0322\u0324\u0001\u0000\u0000\u0000\u0323\u0321\u0001\u0000\u0000\u0000"+
		"\u0324\u0328\u0005\u0012\u0000\u0000\u0325\u0327\u0005\u0082\u0000\u0000"+
		"\u0326\u0325\u0001\u0000\u0000\u0000\u0327\u032a\u0001\u0000\u0000\u0000"+
		"\u0328\u0326\u0001\u0000\u0000\u0000\u0328\u0329\u0001\u0000\u0000\u0000"+
		"\u0329\u0089\u0001\u0000\u0000\u0000\u032a\u0328\u0001\u0000\u0000\u0000"+
		"\u032b\u032d\u0005\u0082\u0000\u0000\u032c\u032b\u0001\u0000\u0000\u0000"+
		"\u032d\u0330\u0001\u0000\u0000\u0000\u032e\u032c\u0001\u0000\u0000\u0000"+
		"\u032e\u032f\u0001\u0000\u0000\u0000\u032f\u0332\u0001\u0000\u0000\u0000"+
		"\u0330\u032e\u0001\u0000\u0000\u0000\u0331\u0333\u0003\u008cF\u0000\u0332"+
		"\u0331\u0001\u0000\u0000\u0000\u0333\u0334\u0001\u0000\u0000\u0000\u0334"+
		"\u0332\u0001\u0000\u0000\u0000\u0334\u0335\u0001\u0000\u0000\u0000\u0335"+
		"\u0339\u0001\u0000\u0000\u0000\u0336\u0338\u0005\u0082\u0000\u0000\u0337"+
		"\u0336\u0001\u0000\u0000\u0000\u0338\u033b\u0001\u0000\u0000\u0000\u0339"+
		"\u0337\u0001\u0000\u0000\u0000\u0339\u033a\u0001\u0000\u0000\u0000\u033a"+
		"\u008b\u0001\u0000\u0000\u0000\u033b\u0339\u0001\u0000\u0000\u0000\u033c"+
		"\u0348\u0003\u008eG\u0000\u033d\u0348\u0003\u0090H\u0000\u033e\u0348\u0005"+
		"\u000b\u0000\u0000\u033f\u0348\u0005\u0002\u0000\u0000\u0340\u0348\u0005"+
		"\u0003\u0000\u0000\u0341\u0348\u0005\u0082\u0000\u0000\u0342\u0348\u0005"+
		"\u0080\u0000\u0000\u0343\u0348\u0005\u0012\u0000\u0000\u0344\u0348\u0005"+
		"\u0013\u0000\u0000\u0345\u0348\u0005\u0083\u0000\u0000\u0346\u0348\u0005"+
		"\u0015\u0000\u0000\u0347\u033c\u0001\u0000\u0000\u0000\u0347\u033d\u0001"+
		"\u0000\u0000\u0000\u0347\u033e\u0001\u0000\u0000\u0000\u0347\u033f\u0001"+
		"\u0000\u0000\u0000\u0347\u0340\u0001\u0000\u0000\u0000\u0347\u0341\u0001"+
		"\u0000\u0000\u0000\u0347\u0342\u0001\u0000\u0000\u0000\u0347\u0343\u0001"+
		"\u0000\u0000\u0000\u0347\u0344\u0001\u0000\u0000\u0000\u0347\u0345\u0001"+
		"\u0000\u0000\u0000\u0347\u0346\u0001\u0000\u0000\u0000\u0348\u008d\u0001"+
		"\u0000\u0000\u0000\u0349\u034a\u0005\u0010\u0000\u0000\u034a\u034f\u0003"+
		"\u0092I\u0000\u034b\u034c\u0005\u0015\u0000\u0000\u034c\u034e\u0003\u0092"+
		"I\u0000\u034d\u034b\u0001\u0000\u0000\u0000\u034e\u0351\u0001\u0000\u0000"+
		"\u0000\u034f\u034d\u0001\u0000\u0000\u0000\u034f\u0350\u0001\u0000\u0000"+
		"\u0000\u0350\u0353\u0001\u0000\u0000\u0000\u0351\u034f\u0001\u0000\u0000"+
		"\u0000\u0352\u0354\u0005\u0015\u0000\u0000\u0353\u0352\u0001\u0000\u0000"+
		"\u0000\u0353\u0354\u0001\u0000\u0000\u0000\u0354\u0355\u0001\u0000\u0000"+
		"\u0000\u0355\u0356\u0005~\u0000\u0000\u0356\u008f\u0001\u0000\u0000\u0000"+
		"\u0357\u0359\u0005\u0010\u0000\u0000\u0358\u035a\u0003\u008cF\u0000\u0359"+
		"\u0358\u0001\u0000\u0000\u0000\u035a\u035b\u0001\u0000\u0000\u0000\u035b"+
		"\u0359\u0001\u0000\u0000\u0000\u035b\u035c\u0001\u0000\u0000\u0000\u035c"+
		"\u035d\u0001\u0000\u0000\u0000\u035d\u035e\u0005~\u0000\u0000\u035e\u0362"+
		"\u0001\u0000\u0000\u0000\u035f\u0360\u0005\u0010\u0000\u0000\u0360\u0362"+
		"\u0005~\u0000\u0000\u0361\u0357\u0001\u0000\u0000\u0000\u0361\u035f\u0001"+
		"\u0000\u0000\u0000\u0362\u0091\u0001\u0000\u0000\u0000\u0363\u0367\u0005"+
		"\u0012\u0000\u0000\u0364\u0366\u0005\u0082\u0000\u0000\u0365\u0364\u0001"+
		"\u0000\u0000\u0000\u0366\u0369\u0001\u0000\u0000\u0000\u0367\u0365\u0001"+
		"\u0000\u0000\u0000\u0367\u0368\u0001\u0000\u0000\u0000\u0368\u036a\u0001"+
		"\u0000\u0000\u0000\u0369\u0367\u0001\u0000\u0000\u0000\u036a\u036e\u0005"+
		"\u0013\u0000\u0000\u036b\u036d\u0005\u0082\u0000\u0000\u036c\u036b\u0001"+
		"\u0000\u0000\u0000\u036d\u0370\u0001\u0000\u0000\u0000\u036e\u036c\u0001"+
		"\u0000\u0000\u0000\u036e\u036f\u0001\u0000\u0000\u0000\u036f\u0371\u0001"+
		"\u0000\u0000\u0000\u0370\u036e\u0001\u0000\u0000\u0000\u0371\u0372\u0007"+
		"\u0005\u0000\u0000\u0372\u0093\u0001\u0000\u0000\u0000\u0373\u0375\u0005"+
		"g\u0000\u0000\u0374\u0376\u0003\n\u0005\u0000\u0375\u0374\u0001\u0000"+
		"\u0000\u0000\u0376\u0377\u0001\u0000\u0000\u0000\u0377\u0375\u0001\u0000"+
		"\u0000\u0000\u0377\u0378\u0001\u0000\u0000\u0000\u0378\u0379\u0001\u0000"+
		"\u0000\u0000\u0379\u037a\u0005h\u0000\u0000\u037a\u0095\u0001\u0000\u0000"+
		"\u0000\u037b\u037d\u0007\u0006\u0000\u0000\u037c\u037e\u0003r9\u0000\u037d"+
		"\u037c\u0001\u0000\u0000\u0000\u037d\u037e\u0001\u0000\u0000\u0000\u037e"+
		"\u0097\u0001\u0000\u0000\u0000\u037f\u0381\u0005\u0018\u0000\u0000\u0380"+
		"\u037f\u0001\u0000\u0000\u0000\u0381\u0382\u0001\u0000\u0000\u0000\u0382"+
		"\u0380\u0001\u0000\u0000\u0000\u0382\u0383\u0001\u0000\u0000\u0000\u0383"+
		"\u0099\u0001\u0000\u0000\u0000]\u009d\u00a5\u00b0\u00b4\u00de\u00f7\u00fb"+
		"\u0107\u0109\u0113\u011c\u0125\u012e\u0137\u0140\u0143\u014a\u014d\u0153"+
		"\u0156\u015f\u0168\u0170\u0176\u017f\u0187\u018b\u0192\u019b\u01a3\u01a5"+
		"\u01ae\u01b7\u01c2\u01cc\u01ce\u01e1\u01f1\u01f5\u0200\u0209\u020b\u0213"+
		"\u021c\u0226\u022f\u0237\u023d\u0243\u024b\u0254\u025f\u026d\u0273\u0277"+
		"\u027d\u0287\u028c\u0295\u029f\u02aa\u02ac\u02b2\u02c1\u02cb\u02d0\u02d7"+
		"\u02dc\u02e3\u02e5\u02ed\u02f1\u02f7\u02fa\u0301\u030c\u0313\u0319\u0321"+
		"\u0328\u032e\u0334\u0339\u0347\u034f\u0353\u035b\u0361\u0367\u036e\u0377"+
		"\u037d\u0382";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}