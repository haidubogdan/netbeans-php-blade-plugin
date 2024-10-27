// Generated from BladeAntlrParser.g4 by ANTLR 4.13.0

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
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PHP_EXPRESSION=1, PHP_VARIABLE=2, PHP_KEYWORD=3, PHP_NEW=4, PHP_IDENTIFIER=5, 
		PHP_NAMESPACE_PATH=6, PHP_STATIC_ACCESS=7, PHP_CLASS_KEYWORD=8, PHP_INSTANCE_ACCESS=9, 
		BLADE_PARAM_EXTRA=10, BLADE_PARAM_LPAREN=11, BLADE_PARAM_RPAREN=12, BLADE_EXPR_LPAREN=13, 
		BLADE_EXPR_RPAREN=14, BL_SQ_LPAREN=15, BL_SQ_LRAREN=16, BL_PARAM_STRING=17, 
		BL_PARAM_ASSIGN=18, BL_COMMA=19, BL_PARAM_COMMA=20, PHP_EXPR_STRING=21, 
		ERROR=22, HTML=23, BLADE_COMMENT=24, D_IF=25, D_ELSEIF=26, D_ELSE=27, 
		D_ENDIF=28, D_SWITCH=29, D_CASE=30, D_DEFAULT=31, D_ENDSWITCH=32, D_EMPTY=33, 
		D_ENDEMPTY=34, D_COND_BLOCK_START=35, D_COND_BLOCK_END=36, D_FOREACH=37, 
		D_ENDFOREACH=38, D_FOR=39, D_ENDFOR=40, D_FORELSE=41, D_ENDFORELSE=42, 
		D_WHILE=43, D_ENDWHILE=44, D_BREAK=45, D_LOOP_ACTION=46, D_INCLUDE=47, 
		D_INCLUDE_IF=48, D_INCLUDE_WHEN=49, D_INCLUDE_FIRST=50, D_INCLUDE_UNLESS=51, 
		D_EACH=52, D_EXTENDS=53, D_JS=54, D_JSON=55, D_SECTION=56, D_HAS_SECTION=57, 
		D_SECTION_MISSING=58, D_ENDSECTION=59, D_YIELD=60, D_PARENT=61, D_SHOW=62, 
		D_OVERWRITE=63, D_STOP=64, D_APPEND=65, D_ONCE=66, D_ENDONCE=67, D_STACK=68, 
		D_PUSH=69, D_ENDPUSH=70, D_PUSH_IF=71, D_ENDPUSH_IF=72, D_PUSH_ONCE=73, 
		D_ENDPUSH_ONCE=74, D_PREPEND=75, D_ENDPREPEND=76, D_PROPS=77, D_FRAGMENT=78, 
		D_ENDFRAGMENT=79, D_CSRF=80, D_METHOD=81, D_ERROR=82, D_ENDERROR=83, D_PRODUCTION=84, 
		D_ENDPRODUCTION=85, D_ENV=86, D_ENDENV=87, D_AUTH_START=88, D_AUTH_END=89, 
		D_PERMISSION_START=90, D_PERMISSION_ELSE=91, D_PERMISSION_END=92, D_CLASS=93, 
		D_STYLE=94, D_HTML_ATTR_EXPR=95, D_AWARE=96, D_BOOL=97, D_WHEN=98, D_SESSION=99, 
		D_ENDSESSION=100, D_DD=101, D_LANG=102, D_USE=103, D_INJECT=104, D_PHP=105, 
		D_VERBATIM=106, D_ENDVERBATIM=107, D_LIVEWIRE=108, D_ASSET_BUNDLER=109, 
		D_MISC=110, D_CUSTOM=111, D_UNKNOWN_ATTR_ENC=112, D_UNKNOWN=113, CONTENT_TAG_OPEN=114, 
		RAW_TAG_OPEN=115, PHP_INLINE_START=116, HTML_COMPONENT_PREFIX=117, JS_SCRIPT=118, 
		HTML_TAG_START=119, HTML_CLOSE_TAG=120, STRING_PATH=121, HTML_PATH=122, 
		HTML_TEXT=123, HTML_IDENTIFIER=124, EQ=125, WS=126, OTHER=127, BLADE_COMMENT_START=128, 
		REGULAR_ECH0_EXPR_STRING=129, CONTENT_TAG_CLOSE=130, REGULAR_ECHO_EXPR_MORE=131, 
		RAW_ECH0_EXPR_STRING=132, RAW_TAG_CLOSE=133, RAW_ECHO_EXPR_MORE=134, WS_EXPR_ESCAPE=135, 
		WS_EXPR=136, WS_COMPOSED_EXPR=137, EXPR_STRING=138, COMPOSED_EXPR_RPAREN=139, 
		PHP_COMPOSED_EXPRESSION=140, WS_BL_PARAM=141, FOREACH_WS_EXPR=142, FOREACH_LOOP_LPAREN=143, 
		FOREACH_LOOP_RPAREN=144, FOREACH_AS=145, FOREACH_PARAM_ASSIGN=146, BL_PARAM_LINE_COMMENT=147, 
		BL_SQ_RPAREN=148, BL_PARAM_RPAREN=149, BL_PARAM_CONCAT_OPERATOR=150, BL_COMMA_EL=151, 
		BL_PARAM_WS=152, BL_NAME_STRING=153, PHP_D_BLADE_COMMENT=154, PHP_D_BLADE_ML_COMMENT=155, 
		D_ENDPHP=156, PHP_D_WS=157, PHP_D_PHP_COMPOSED_EXPRESSION=158, PHP_EXIT=159, 
		PHP_INLINE_COMMENT=160, PHP_INLINE_ML_COMMENT=161, VERBATIM_HTML=162, 
		BLADE_COMMENT_END=163, BLADE_COMMENT_PEEK=164, BLADE_COMMENT_MORE=165, 
		BLADE_COMMENT_EOF=166, AT=167, RAW_TAG_START=168, REGULAR_ECHO_STATIC_ACCESS=169, 
		REGULAR_ECHO_LPAREN=170, REGULAR_ECHO_RPAREN=171, REGULAR_ECHO_INSTANCE_ACCESS=172, 
		PHP_D_EXPR_CURLY_LPAREN=173, PHP_D_EXPR_CURLY_RPAREN=174, PHP_D_CLASS=175;
	public static final int
		RULE_file = 0, RULE_general_statement = 1, RULE_inline_statement = 2, 
		RULE_inline_directive = 3, RULE_block_statement = 4, RULE_identifiableType = 5, 
		RULE_section_inline = 6, RULE_section = 7, RULE_push = 8, RULE_pushOnce = 9, 
		RULE_pushIf = 10, RULE_prepend = 11, RULE_fragmentD = 12, RULE_if = 13, 
		RULE_else = 14, RULE_endif = 15, RULE_empty_block = 16, RULE_conditional_block = 17, 
		RULE_auth_block = 18, RULE_env_block = 19, RULE_permission = 20, RULE_simple_conditional_stm = 21, 
		RULE_error_block = 22, RULE_switch = 23, RULE_while = 24, RULE_for = 25, 
		RULE_foreach = 26, RULE_forelse = 27, RULE_session = 28, RULE_stack = 29, 
		RULE_asset_bundler = 30, RULE_inject = 31, RULE_includeCond = 32, RULE_each = 33, 
		RULE_once_block = 34, RULE_condSection = 35, RULE_custom_directive = 36, 
		RULE_possibleDirective = 37, RULE_php_blade = 38, RULE_phpInline = 39, 
		RULE_regular_echo = 40, RULE_raw_echo = 41, RULE_echo_expr = 42, RULE_class_expr_usage = 43, 
		RULE_object_alias_static_access = 44, RULE_object_alias_direct_access = 45, 
		RULE_static_direct_class_access = 46, RULE_static_direct_namespace_class_access = 47, 
		RULE_class_instance = 48, RULE_class_name_reference = 49, RULE_namespacePath = 50, 
		RULE_function_call = 51, RULE_php_expression = 52, RULE_loop_expression = 53, 
		RULE_main_php_expression = 54, RULE_composed_php_expression = 55, RULE_simple_foreach_expr = 56, 
		RULE_singleArgWrapperP = 57, RULE_doubleArgWrapperP = 58, RULE_doubleArgWrapperPwithFallback = 59, 
		RULE_multiArgWrapper = 60, RULE_identifiableArgument = 61, RULE_composedArgument = 62, 
		RULE_phpExpr = 63, RULE_identifiableArray = 64, RULE_arrayDefine = 65, 
		RULE_paramAssign = 66, RULE_verbatim_block = 67, RULE_loop_action = 68, 
		RULE_html = 69;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "general_statement", "inline_statement", "inline_directive", 
			"block_statement", "identifiableType", "section_inline", "section", "push", 
			"pushOnce", "pushIf", "prepend", "fragmentD", "if", "else", "endif", 
			"empty_block", "conditional_block", "auth_block", "env_block", "permission", 
			"simple_conditional_stm", "error_block", "switch", "while", "for", "foreach", 
			"forelse", "session", "stack", "asset_bundler", "inject", "includeCond", 
			"each", "once_block", "condSection", "custom_directive", "possibleDirective", 
			"php_blade", "phpInline", "regular_echo", "raw_echo", "echo_expr", "class_expr_usage", 
			"object_alias_static_access", "object_alias_direct_access", "static_direct_class_access", 
			"static_direct_namespace_class_access", "class_instance", "class_name_reference", 
			"namespacePath", "function_call", "php_expression", "loop_expression", 
			"main_php_expression", "composed_php_expression", "simple_foreach_expr", 
			"singleArgWrapperP", "doubleArgWrapperP", "doubleArgWrapperPwithFallback", 
			"multiArgWrapper", "identifiableArgument", "composedArgument", "phpExpr", 
			"identifiableArray", "arrayDefine", "paramAssign", "verbatim_block", 
			"loop_action", "html"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'@if'", "'@elseif'", "'@else'", "'@endif'", "'@switch'", "'@case'", 
			"'@default'", "'@endswitch'", "'@empty'", "'@endempty'", null, null, 
			"'@foreach'", "'@endforeach'", "'@for'", "'@endfor'", "'@forelse'", "'@endforelse'", 
			"'@while'", "'@endwhile'", "'@break'", null, "'@include'", "'@includeIf'", 
			"'@includeWhen'", "'@includeFirst'", "'@includeUnless'", "'@each'", "'@extends'", 
			"'@js'", "'@json'", "'@section'", "'@hasSection'", "'@sectionMissing'", 
			"'@endsection'", "'@yield'", "'@parent'", "'@show'", "'@overwrite'", 
			"'@stop'", "'@append'", "'@once'", "'@endonce'", "'@stack'", "'@push'", 
			"'@endpush'", "'@pushIf'", "'@endPushIf'", "'@pushOnce'", "'@endPushOnce'", 
			"'@prepend'", "'@endprepend'", "'@props'", "'@fragment'", "'@endfragment'", 
			"'@csrf'", "'@method'", "'@error'", "'@enderror'", "'@production'", "'@endproduction'", 
			"'@env'", "'@endenv'", null, null, null, null, null, "'@class'", "'@style'", 
			null, "'@aware'", "'@bool'", "'@when'", "'@session'", "'@endsession'", 
			null, "'@lang'", "'@use'", "'@inject'", null, "'@verbatim'", "'@endverbatim'", 
			null, "'@vite'", "'@viteReactRefresh'", null, null, null, "'{{'", "'{!!'", 
			null, null, null, null, null, null, null, null, null, "'='", null, null, 
			"'{{--'", null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'as'", null, null, null, null, "'.'", 
			"','", null, null, null, null, "'@endphp'", "' '", null, "'?>'", null, 
			null, null, "'--}}'", null, null, null, null, "'{!'", null, null, null, 
			null, null, null, "'class'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PHP_EXPRESSION", "PHP_VARIABLE", "PHP_KEYWORD", "PHP_NEW", "PHP_IDENTIFIER", 
			"PHP_NAMESPACE_PATH", "PHP_STATIC_ACCESS", "PHP_CLASS_KEYWORD", "PHP_INSTANCE_ACCESS", 
			"BLADE_PARAM_EXTRA", "BLADE_PARAM_LPAREN", "BLADE_PARAM_RPAREN", "BLADE_EXPR_LPAREN", 
			"BLADE_EXPR_RPAREN", "BL_SQ_LPAREN", "BL_SQ_LRAREN", "BL_PARAM_STRING", 
			"BL_PARAM_ASSIGN", "BL_COMMA", "BL_PARAM_COMMA", "PHP_EXPR_STRING", "ERROR", 
			"HTML", "BLADE_COMMENT", "D_IF", "D_ELSEIF", "D_ELSE", "D_ENDIF", "D_SWITCH", 
			"D_CASE", "D_DEFAULT", "D_ENDSWITCH", "D_EMPTY", "D_ENDEMPTY", "D_COND_BLOCK_START", 
			"D_COND_BLOCK_END", "D_FOREACH", "D_ENDFOREACH", "D_FOR", "D_ENDFOR", 
			"D_FORELSE", "D_ENDFORELSE", "D_WHILE", "D_ENDWHILE", "D_BREAK", "D_LOOP_ACTION", 
			"D_INCLUDE", "D_INCLUDE_IF", "D_INCLUDE_WHEN", "D_INCLUDE_FIRST", "D_INCLUDE_UNLESS", 
			"D_EACH", "D_EXTENDS", "D_JS", "D_JSON", "D_SECTION", "D_HAS_SECTION", 
			"D_SECTION_MISSING", "D_ENDSECTION", "D_YIELD", "D_PARENT", "D_SHOW", 
			"D_OVERWRITE", "D_STOP", "D_APPEND", "D_ONCE", "D_ENDONCE", "D_STACK", 
			"D_PUSH", "D_ENDPUSH", "D_PUSH_IF", "D_ENDPUSH_IF", "D_PUSH_ONCE", "D_ENDPUSH_ONCE", 
			"D_PREPEND", "D_ENDPREPEND", "D_PROPS", "D_FRAGMENT", "D_ENDFRAGMENT", 
			"D_CSRF", "D_METHOD", "D_ERROR", "D_ENDERROR", "D_PRODUCTION", "D_ENDPRODUCTION", 
			"D_ENV", "D_ENDENV", "D_AUTH_START", "D_AUTH_END", "D_PERMISSION_START", 
			"D_PERMISSION_ELSE", "D_PERMISSION_END", "D_CLASS", "D_STYLE", "D_HTML_ATTR_EXPR", 
			"D_AWARE", "D_BOOL", "D_WHEN", "D_SESSION", "D_ENDSESSION", "D_DD", "D_LANG", 
			"D_USE", "D_INJECT", "D_PHP", "D_VERBATIM", "D_ENDVERBATIM", "D_LIVEWIRE", 
			"D_ASSET_BUNDLER", "D_MISC", "D_CUSTOM", "D_UNKNOWN_ATTR_ENC", "D_UNKNOWN", 
			"CONTENT_TAG_OPEN", "RAW_TAG_OPEN", "PHP_INLINE_START", "HTML_COMPONENT_PREFIX", 
			"JS_SCRIPT", "HTML_TAG_START", "HTML_CLOSE_TAG", "STRING_PATH", "HTML_PATH", 
			"HTML_TEXT", "HTML_IDENTIFIER", "EQ", "WS", "OTHER", "BLADE_COMMENT_START", 
			"REGULAR_ECH0_EXPR_STRING", "CONTENT_TAG_CLOSE", "REGULAR_ECHO_EXPR_MORE", 
			"RAW_ECH0_EXPR_STRING", "RAW_TAG_CLOSE", "RAW_ECHO_EXPR_MORE", "WS_EXPR_ESCAPE", 
			"WS_EXPR", "WS_COMPOSED_EXPR", "EXPR_STRING", "COMPOSED_EXPR_RPAREN", 
			"PHP_COMPOSED_EXPRESSION", "WS_BL_PARAM", "FOREACH_WS_EXPR", "FOREACH_LOOP_LPAREN", 
			"FOREACH_LOOP_RPAREN", "FOREACH_AS", "FOREACH_PARAM_ASSIGN", "BL_PARAM_LINE_COMMENT", 
			"BL_SQ_RPAREN", "BL_PARAM_RPAREN", "BL_PARAM_CONCAT_OPERATOR", "BL_COMMA_EL", 
			"BL_PARAM_WS", "BL_NAME_STRING", "PHP_D_BLADE_COMMENT", "PHP_D_BLADE_ML_COMMENT", 
			"D_ENDPHP", "PHP_D_WS", "PHP_D_PHP_COMPOSED_EXPRESSION", "PHP_EXIT", 
			"PHP_INLINE_COMMENT", "PHP_INLINE_ML_COMMENT", "VERBATIM_HTML", "BLADE_COMMENT_END", 
			"BLADE_COMMENT_PEEK", "BLADE_COMMENT_MORE", "BLADE_COMMENT_EOF", "AT", 
			"RAW_TAG_START", "REGULAR_ECHO_STATIC_ACCESS", "REGULAR_ECHO_LPAREN", 
			"REGULAR_ECHO_RPAREN", "REGULAR_ECHO_INSTANCE_ACCESS", "PHP_D_EXPR_CURLY_LPAREN", 
			"PHP_D_EXPR_CURLY_RPAREN", "PHP_D_CLASS"
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
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				{
				setState(140);
				general_statement();
				}
				}
				setState(145);
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
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				inline_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				block_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
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
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_ELSE:
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
			case D_JSON:
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
			case D_BOOL:
			case D_WHEN:
			case D_DD:
			case D_LANG:
			case D_USE:
			case D_INJECT:
			case D_LIVEWIRE:
			case D_ASSET_BUNDLER:
			case D_MISC:
			case D_CUSTOM:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				inline_directive();
				}
				break;
			case D_UNKNOWN_ATTR_ENC:
			case D_UNKNOWN:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				possibleDirective();
				}
				break;
			case CONTENT_TAG_OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				regular_echo();
				}
				break;
			case RAW_TAG_OPEN:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				raw_echo();
				}
				break;
			case PHP_INLINE_START:
				enterOuterAlt(_localctx, 5);
				{
				setState(155);
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
	public static class Inline_directiveContext extends ParserRuleContext {
		public Section_inlineContext section_inline() {
			return getRuleContext(Section_inlineContext.class,0);
		}
		public IdentifiableTypeContext identifiableType() {
			return getRuleContext(IdentifiableTypeContext.class,0);
		}
		public StackContext stack() {
			return getRuleContext(StackContext.class,0);
		}
		public IncludeCondContext includeCond() {
			return getRuleContext(IncludeCondContext.class,0);
		}
		public TerminalNode D_INCLUDE_FIRST() { return getToken(BladeAntlrParser.D_INCLUDE_FIRST, 0); }
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public TerminalNode BL_COMMA() { return getToken(BladeAntlrParser.BL_COMMA, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
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
		public TerminalNode D_HTML_ATTR_EXPR() { return getToken(BladeAntlrParser.D_HTML_ATTR_EXPR, 0); }
		public TerminalNode D_CASE() { return getToken(BladeAntlrParser.D_CASE, 0); }
		public TerminalNode D_JSON() { return getToken(BladeAntlrParser.D_JSON, 0); }
		public TerminalNode D_CSRF() { return getToken(BladeAntlrParser.D_CSRF, 0); }
		public TerminalNode D_LOOP_ACTION() { return getToken(BladeAntlrParser.D_LOOP_ACTION, 0); }
		public TerminalNode D_BREAK() { return getToken(BladeAntlrParser.D_BREAK, 0); }
		public TerminalNode D_LIVEWIRE() { return getToken(BladeAntlrParser.D_LIVEWIRE, 0); }
		public TerminalNode D_DEFAULT() { return getToken(BladeAntlrParser.D_DEFAULT, 0); }
		public Asset_bundlerContext asset_bundler() {
			return getRuleContext(Asset_bundlerContext.class,0);
		}
		public InjectContext inject() {
			return getRuleContext(InjectContext.class,0);
		}
		public TerminalNode D_PERMISSION_ELSE() { return getToken(BladeAntlrParser.D_PERMISSION_ELSE, 0); }
		public Loop_actionContext loop_action() {
			return getRuleContext(Loop_actionContext.class,0);
		}
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
		public TerminalNode D_MISC() { return getToken(BladeAntlrParser.D_MISC, 0); }
		public TerminalNode D_WHEN() { return getToken(BladeAntlrParser.D_WHEN, 0); }
		public DoubleArgWrapperPwithFallbackContext doubleArgWrapperPwithFallback() {
			return getRuleContext(DoubleArgWrapperPwithFallbackContext.class,0);
		}
		public TerminalNode D_BOOL() { return getToken(BladeAntlrParser.D_BOOL, 0); }
		public SingleArgWrapperPContext singleArgWrapperP() {
			return getRuleContext(SingleArgWrapperPContext.class,0);
		}
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
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				section_inline();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				identifiableType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				stack();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(161);
				includeCond();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(162);
				match(D_INCLUDE_FIRST);
				setState(163);
				match(BLADE_PARAM_LPAREN);
				setState(164);
				composedArgument();
				setState(165);
				match(BL_COMMA);
				setState(166);
				composedArgument();
				setState(167);
				match(BLADE_PARAM_RPAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(169);
				each();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(170);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 54043196602187776L) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 17760273L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(171);
				composed_php_expression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(172);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 105555263750144L) != 0) || _la==D_CSRF || _la==D_LIVEWIRE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(173);
				asset_bundler();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(174);
				inject();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(175);
				match(D_PERMISSION_ELSE);
				setState(176);
				composed_php_expression();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(177);
				loop_action();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(178);
				match(D_ELSE);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(179);
				match(D_MISC);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(180);
				match(D_WHEN);
				setState(181);
				doubleArgWrapperPwithFallback();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(182);
				match(D_BOOL);
				setState(183);
				singleArgWrapperP();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(184);
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
		public CondSectionContext condSection() {
			return getRuleContext(CondSectionContext.class,0);
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
		public SwitchContext switch_() {
			return getRuleContext(SwitchContext.class,0);
		}
		public Env_blockContext env_block() {
			return getRuleContext(Env_blockContext.class,0);
		}
		public Empty_blockContext empty_block() {
			return getRuleContext(Empty_blockContext.class,0);
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
		public SessionContext session() {
			return getRuleContext(SessionContext.class,0);
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
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				section();
				}
				break;
			case D_HAS_SECTION:
			case D_SECTION_MISSING:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				condSection();
				}
				break;
			case D_PUSH:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				push();
				}
				break;
			case D_PUSH_IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
				pushIf();
				}
				break;
			case D_ONCE:
				enterOuterAlt(_localctx, 5);
				{
				setState(191);
				once_block();
				}
				break;
			case D_PREPEND:
				enterOuterAlt(_localctx, 6);
				{
				setState(192);
				prepend();
				}
				break;
			case D_FRAGMENT:
				enterOuterAlt(_localctx, 7);
				{
				setState(193);
				fragmentD();
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 8);
				{
				setState(194);
				if_();
				}
				break;
			case D_SWITCH:
				enterOuterAlt(_localctx, 9);
				{
				setState(195);
				switch_();
				}
				break;
			case D_PRODUCTION:
			case D_ENV:
				enterOuterAlt(_localctx, 10);
				{
				setState(196);
				env_block();
				}
				break;
			case D_EMPTY:
				enterOuterAlt(_localctx, 11);
				{
				setState(197);
				empty_block();
				}
				break;
			case D_ERROR:
				enterOuterAlt(_localctx, 12);
				{
				setState(198);
				error_block();
				}
				break;
			case D_COND_BLOCK_START:
				enterOuterAlt(_localctx, 13);
				{
				setState(199);
				conditional_block();
				}
				break;
			case D_AUTH_START:
				enterOuterAlt(_localctx, 14);
				{
				setState(200);
				auth_block();
				}
				break;
			case D_PERMISSION_START:
				enterOuterAlt(_localctx, 15);
				{
				setState(201);
				permission();
				}
				break;
			case D_WHILE:
				enterOuterAlt(_localctx, 16);
				{
				setState(202);
				while_();
				}
				break;
			case D_FOR:
				enterOuterAlt(_localctx, 17);
				{
				setState(203);
				for_();
				}
				break;
			case D_FOREACH:
				enterOuterAlt(_localctx, 18);
				{
				setState(204);
				foreach();
				}
				break;
			case D_FORELSE:
				enterOuterAlt(_localctx, 19);
				{
				setState(205);
				forelse();
				}
				break;
			case D_SESSION:
				enterOuterAlt(_localctx, 20);
				{
				setState(206);
				session();
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 21);
				{
				setState(207);
				verbatim_block();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 22);
				{
				setState(208);
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
	public static class IdentifiableTypeContext extends ParserRuleContext {
		public Token d_name;
		public Token idString;
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public TerminalNode D_INCLUDE() { return getToken(BladeAntlrParser.D_INCLUDE, 0); }
		public TerminalNode D_INCLUDE_IF() { return getToken(BladeAntlrParser.D_INCLUDE_IF, 0); }
		public TerminalNode D_EXTENDS() { return getToken(BladeAntlrParser.D_EXTENDS, 0); }
		public TerminalNode D_YIELD() { return getToken(BladeAntlrParser.D_YIELD, 0); }
		public TerminalNode D_USE() { return getToken(BladeAntlrParser.D_USE, 0); }
		public TerminalNode D_LANG() { return getToken(BladeAntlrParser.D_LANG, 0); }
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public TerminalNode BL_PARAM_STRING() { return getToken(BladeAntlrParser.BL_PARAM_STRING, 0); }
		public List<TerminalNode> BL_COMMA() { return getTokens(BladeAntlrParser.BL_COMMA); }
		public TerminalNode BL_COMMA(int i) {
			return getToken(BladeAntlrParser.BL_COMMA, i);
		}
		public IdentifiableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiableType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterIdentifiableType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitIdentifiableType(this);
		}
	}

	public final IdentifiableTypeContext identifiableType() throws RecognitionException {
		IdentifiableTypeContext _localctx = new IdentifiableTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_identifiableType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			((IdentifiableTypeContext)_localctx).d_name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 108086391056900163L) != 0)) ) {
				((IdentifiableTypeContext)_localctx).d_name = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(212);
			match(BLADE_PARAM_LPAREN);
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(213);
				((IdentifiableTypeContext)_localctx).idString = match(BL_PARAM_STRING);
				}
				break;
			case 2:
				{
				setState(214);
				composedArgument();
				}
				break;
			}
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(217);
				match(BL_COMMA);
				setState(218);
				composedArgument();
				}
				break;
			}
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(221);
				match(BL_COMMA);
				}
			}

			setState(224);
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
	public static class Section_inlineContext extends ParserRuleContext {
		public TerminalNode D_SECTION() { return getToken(BladeAntlrParser.D_SECTION, 0); }
		public DoubleArgWrapperPContext doubleArgWrapperP() {
			return getRuleContext(DoubleArgWrapperPContext.class,0);
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
		enterRule(_localctx, 12, RULE_section_inline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(D_SECTION);
			setState(227);
			doubleArgWrapperP();
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
		public SingleArgWrapperPContext singleArgWrapperP() {
			return getRuleContext(SingleArgWrapperPContext.class,0);
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
		enterRule(_localctx, 14, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(D_SECTION);
			setState(230);
			singleArgWrapperP();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4035201810946850816L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				setState(233);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case HTML:
				case D_IF:
				case D_ELSE:
				case D_SWITCH:
				case D_CASE:
				case D_DEFAULT:
				case D_EMPTY:
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
				case D_JSON:
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
				case D_BOOL:
				case D_WHEN:
				case D_SESSION:
				case D_DD:
				case D_LANG:
				case D_USE:
				case D_INJECT:
				case D_PHP:
				case D_VERBATIM:
				case D_LIVEWIRE:
				case D_ASSET_BUNDLER:
				case D_MISC:
				case D_CUSTOM:
				case D_UNKNOWN_ATTR_ENC:
				case D_UNKNOWN:
				case CONTENT_TAG_OPEN:
				case RAW_TAG_OPEN:
				case PHP_INLINE_START:
				case HTML_COMPONENT_PREFIX:
				case HTML_TAG_START:
				case HTML_IDENTIFIER:
				case EQ:
					{
					setState(231);
					general_statement();
					}
					break;
				case D_PARENT:
					{
					setState(232);
					match(D_PARENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(238);
			_la = _input.LA(1);
			if ( !(((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & 121L) != 0)) ) {
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
		public SingleArgWrapperPContext singleArgWrapperP() {
			return getRuleContext(SingleArgWrapperPContext.class,0);
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
		enterRule(_localctx, 16, RULE_push);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(D_PUSH);
			setState(241);
			singleArgWrapperP();
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				{
				setState(242);
				general_statement();
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
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
		public SingleArgWrapperPContext singleArgWrapperP() {
			return getRuleContext(SingleArgWrapperPContext.class,0);
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
		enterRule(_localctx, 18, RULE_pushOnce);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(D_PUSH_ONCE);
			setState(251);
			singleArgWrapperP();
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				{
				setState(252);
				general_statement();
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(258);
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
		public SingleArgWrapperPContext singleArgWrapperP() {
			return getRuleContext(SingleArgWrapperPContext.class,0);
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
		enterRule(_localctx, 20, RULE_pushIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(D_PUSH_IF);
			setState(261);
			singleArgWrapperP();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				{
				setState(262);
				general_statement();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(268);
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
		public SingleArgWrapperPContext singleArgWrapperP() {
			return getRuleContext(SingleArgWrapperPContext.class,0);
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
		enterRule(_localctx, 22, RULE_prepend);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(D_PREPEND);
			setState(271);
			singleArgWrapperP();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				{
				setState(272);
				general_statement();
				}
				}
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(278);
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
		enterRule(_localctx, 24, RULE_fragmentD);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(D_FRAGMENT);
			setState(281);
			composed_php_expression();
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				{
				setState(282);
				general_statement();
				}
				}
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(288);
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
		public List<Main_php_expressionContext> main_php_expression() {
			return getRuleContexts(Main_php_expressionContext.class);
		}
		public Main_php_expressionContext main_php_expression(int i) {
			return getRuleContext(Main_php_expressionContext.class,i);
		}
		public EndifContext endif() {
			return getRuleContext(EndifContext.class,0);
		}
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public List<TerminalNode> D_ELSEIF() { return getTokens(BladeAntlrParser.D_ELSEIF); }
		public TerminalNode D_ELSEIF(int i) {
			return getToken(BladeAntlrParser.D_ELSEIF, i);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
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
		enterRule(_localctx, 26, RULE_if);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(D_IF);
			setState(291);
			main_php_expression();
			setState(295);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(292);
					general_statement();
					}
					} 
				}
				setState(297);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==D_ELSEIF) {
				{
				{
				setState(298);
				match(D_ELSEIF);
				setState(299);
				main_php_expression();
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(300);
						general_statement();
						}
						} 
					}
					setState(305);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				}
				}
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_ELSE) {
				{
				setState(311);
				else_();
				}
			}

			setState(314);
			endif();
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
		enterRule(_localctx, 28, RULE_else);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(D_ELSE);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				{
				setState(317);
				general_statement();
				}
				}
				setState(322);
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
		enterRule(_localctx, 30, RULE_endif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
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
		public Composed_php_expressionContext composed_php_expression() {
			return getRuleContext(Composed_php_expressionContext.class,0);
		}
		public Simple_conditional_stmContext simple_conditional_stm() {
			return getRuleContext(Simple_conditional_stmContext.class,0);
		}
		public TerminalNode D_ENDEMPTY() { return getToken(BladeAntlrParser.D_ENDEMPTY, 0); }
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
		enterRule(_localctx, 32, RULE_empty_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(D_EMPTY);
			setState(326);
			composed_php_expression();
			setState(327);
			simple_conditional_stm();
			setState(328);
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
		public Simple_conditional_stmContext simple_conditional_stm() {
			return getRuleContext(Simple_conditional_stmContext.class,0);
		}
		public TerminalNode D_COND_BLOCK_END() { return getToken(BladeAntlrParser.D_COND_BLOCK_END, 0); }
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
		enterRule(_localctx, 34, RULE_conditional_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(D_COND_BLOCK_START);
			setState(331);
			main_php_expression();
			setState(332);
			simple_conditional_stm();
			setState(333);
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
		public Simple_conditional_stmContext simple_conditional_stm() {
			return getRuleContext(Simple_conditional_stmContext.class,0);
		}
		public TerminalNode D_AUTH_END() { return getToken(BladeAntlrParser.D_AUTH_END, 0); }
		public List<TerminalNode> BLADE_PARAM_LPAREN() { return getTokens(BladeAntlrParser.BLADE_PARAM_LPAREN); }
		public TerminalNode BLADE_PARAM_LPAREN(int i) {
			return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, i);
		}
		public List<TerminalNode> BLADE_PARAM_RPAREN() { return getTokens(BladeAntlrParser.BLADE_PARAM_RPAREN); }
		public TerminalNode BLADE_PARAM_RPAREN(int i) {
			return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, i);
		}
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
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
		enterRule(_localctx, 36, RULE_auth_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(D_AUTH_START);
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BLADE_PARAM_LPAREN) {
				{
				{
				setState(336);
				match(BLADE_PARAM_LPAREN);
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1475596L) != 0) || _la==BL_PARAM_CONCAT_OPERATOR || _la==BL_NAME_STRING) {
					{
					{
					setState(337);
					composedArgument();
					}
					}
					setState(342);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(343);
				match(BLADE_PARAM_RPAREN);
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(349);
			simple_conditional_stm();
			setState(350);
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
		public SingleArgWrapperPContext singleArgWrapperP() {
			return getRuleContext(SingleArgWrapperPContext.class,0);
		}
		public Simple_conditional_stmContext simple_conditional_stm() {
			return getRuleContext(Simple_conditional_stmContext.class,0);
		}
		public TerminalNode D_ENDENV() { return getToken(BladeAntlrParser.D_ENDENV, 0); }
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
		enterRule(_localctx, 38, RULE_env_block);
		try {
			setState(361);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_ENV:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(352);
				match(D_ENV);
				setState(353);
				singleArgWrapperP();
				setState(354);
				simple_conditional_stm();
				setState(355);
				match(D_ENDENV);
				}
				}
				break;
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
				match(D_PRODUCTION);
				setState(358);
				simple_conditional_stm();
				setState(359);
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
		public Simple_conditional_stmContext simple_conditional_stm() {
			return getRuleContext(Simple_conditional_stmContext.class,0);
		}
		public TerminalNode D_PERMISSION_END() { return getToken(BladeAntlrParser.D_PERMISSION_END, 0); }
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
		enterRule(_localctx, 40, RULE_permission);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(D_PERMISSION_START);
			setState(364);
			composed_php_expression();
			setState(365);
			simple_conditional_stm();
			setState(366);
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
	public static class Simple_conditional_stmContext extends ParserRuleContext {
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public Simple_conditional_stmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_conditional_stm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSimple_conditional_stm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSimple_conditional_stm(this);
		}
	}

	public final Simple_conditional_stmContext simple_conditional_stm() throws RecognitionException {
		Simple_conditional_stmContext _localctx = new Simple_conditional_stmContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_simple_conditional_stm);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(368);
					general_statement();
					}
					} 
				}
				setState(373);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_ELSE) {
				{
				setState(374);
				else_();
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
		enterRule(_localctx, 44, RULE_error_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			match(D_ERROR);
			setState(378);
			php_expression();
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				{
				setState(379);
				general_statement();
				}
				}
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(385);
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
		enterRule(_localctx, 46, RULE_switch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(D_SWITCH);
			setState(388);
			php_expression();
			setState(391); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(391);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(389);
					general_statement();
					}
					break;
				case 2:
					{
					setState(390);
					match(D_BREAK);
					}
					break;
				}
				}
				setState(393); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0) );
			setState(395);
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
		enterRule(_localctx, 48, RULE_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(D_WHILE);
			setState(398);
			php_expression();
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				{
				setState(399);
				general_statement();
				}
				}
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(405);
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
		enterRule(_localctx, 50, RULE_for);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			match(D_FOR);
			setState(408);
			php_expression();
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				{
				setState(409);
				general_statement();
				}
				}
				setState(414);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(415);
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
		enterRule(_localctx, 52, RULE_foreach);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(D_FOREACH);
			setState(418);
			match(FOREACH_LOOP_LPAREN);
			setState(419);
			loop_expression();
			setState(420);
			match(FOREACH_LOOP_RPAREN);
			setState(424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				{
				setState(421);
				general_statement();
				}
				}
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(427);
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
		enterRule(_localctx, 54, RULE_forelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			match(D_FORELSE);
			setState(430);
			match(FOREACH_LOOP_LPAREN);
			setState(431);
			loop_expression();
			setState(432);
			match(FOREACH_LOOP_RPAREN);
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				setState(435);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(433);
					general_statement();
					}
					break;
				case 2:
					{
					setState(434);
					match(D_EMPTY);
					}
					break;
				}
				}
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(440);
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
	public static class SessionContext extends ParserRuleContext {
		public TerminalNode D_SESSION() { return getToken(BladeAntlrParser.D_SESSION, 0); }
		public Composed_php_expressionContext composed_php_expression() {
			return getRuleContext(Composed_php_expressionContext.class,0);
		}
		public TerminalNode D_ENDSESSION() { return getToken(BladeAntlrParser.D_ENDSESSION, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
		}
		public SessionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_session; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSession(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSession(this);
		}
	}

	public final SessionContext session() throws RecognitionException {
		SessionContext _localctx = new SessionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_session);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			match(D_SESSION);
			setState(443);
			composed_php_expression();
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0)) {
				{
				{
				setState(444);
				general_statement();
				}
				}
				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(450);
			match(D_ENDSESSION);
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
		public SingleArgWrapperPContext singleArgWrapperP() {
			return getRuleContext(SingleArgWrapperPContext.class,0);
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
		enterRule(_localctx, 58, RULE_stack);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(D_STACK);
			setState(453);
			singleArgWrapperP();
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
	public static class Asset_bundlerContext extends ParserRuleContext {
		public Token d_name;
		public Token id_strings;
		public Token dir;
		public Token id_string;
		public TerminalNode BLADE_EXPR_LPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_LPAREN, 0); }
		public TerminalNode BLADE_EXPR_RPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_RPAREN, 0); }
		public TerminalNode D_ASSET_BUNDLER() { return getToken(BladeAntlrParser.D_ASSET_BUNDLER, 0); }
		public TerminalNode BL_SQ_LPAREN() { return getToken(BladeAntlrParser.BL_SQ_LPAREN, 0); }
		public TerminalNode BL_SQ_RPAREN() { return getToken(BladeAntlrParser.BL_SQ_RPAREN, 0); }
		public List<TerminalNode> EXPR_STRING() { return getTokens(BladeAntlrParser.EXPR_STRING); }
		public TerminalNode EXPR_STRING(int i) {
			return getToken(BladeAntlrParser.EXPR_STRING, i);
		}
		public List<Composed_php_expressionContext> composed_php_expression() {
			return getRuleContexts(Composed_php_expressionContext.class);
		}
		public Composed_php_expressionContext composed_php_expression(int i) {
			return getRuleContext(Composed_php_expressionContext.class,i);
		}
		public Asset_bundlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asset_bundler; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterAsset_bundler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitAsset_bundler(this);
		}
	}

	public final Asset_bundlerContext asset_bundler() throws RecognitionException {
		Asset_bundlerContext _localctx = new Asset_bundlerContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_asset_bundler);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			((Asset_bundlerContext)_localctx).d_name = match(D_ASSET_BUNDLER);
			setState(456);
			match(BLADE_EXPR_LPAREN);
			setState(473);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(457);
				match(BL_SQ_LPAREN);
				setState(459); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(458);
					((Asset_bundlerContext)_localctx).id_strings = match(EXPR_STRING);
					}
					}
					setState(461); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EXPR_STRING );
				setState(463);
				match(BL_SQ_RPAREN);
				setState(465);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXPR_STRING) {
					{
					setState(464);
					((Asset_bundlerContext)_localctx).dir = match(EXPR_STRING);
					}
				}

				}
				break;
			case 2:
				{
				setState(467);
				((Asset_bundlerContext)_localctx).id_string = match(EXPR_STRING);
				}
				break;
			case 3:
				{
				setState(469); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(468);
					composed_php_expression();
					}
					}
					setState(471); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2139134L) != 0) || _la==EXPR_STRING );
				}
				break;
			}
			setState(475);
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
		enterRule(_localctx, 62, RULE_inject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(D_INJECT);
			setState(478);
			match(BLADE_PARAM_LPAREN);
			setState(479);
			composedArgument();
			setState(480);
			match(BL_COMMA);
			setState(483);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(481);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(482);
				composedArgument();
				}
				break;
			}
			setState(485);
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
	public static class IncludeCondContext extends ParserRuleContext {
		public Token d_name;
		public Token idString;
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
		public TerminalNode BL_PARAM_STRING() { return getToken(BladeAntlrParser.BL_PARAM_STRING, 0); }
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
		enterRule(_localctx, 64, RULE_includeCond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			((IncludeCondContext)_localctx).d_name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==D_INCLUDE_WHEN || _la==D_INCLUDE_UNLESS) ) {
				((IncludeCondContext)_localctx).d_name = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(488);
			match(BLADE_PARAM_LPAREN);
			setState(489);
			composedArgument();
			setState(490);
			match(BL_COMMA);
			setState(493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(491);
				((IncludeCondContext)_localctx).idString = match(BL_PARAM_STRING);
				}
				break;
			case 2:
				{
				setState(492);
				composedArgument();
				}
				break;
			}
			setState(497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(495);
				match(BL_COMMA);
				setState(496);
				composedArgument();
				}
			}

			setState(499);
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
	public static class EachContext extends ParserRuleContext {
		public Token idString;
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
		public TerminalNode BL_PARAM_STRING() { return getToken(BladeAntlrParser.BL_PARAM_STRING, 0); }
		public IdentifiableArgumentContext identifiableArgument() {
			return getRuleContext(IdentifiableArgumentContext.class,0);
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
		enterRule(_localctx, 66, RULE_each);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(D_EACH);
			setState(502);
			match(BLADE_PARAM_LPAREN);
			setState(505);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(503);
				((EachContext)_localctx).idString = match(BL_PARAM_STRING);
				}
				break;
			case 2:
				{
				setState(504);
				composedArgument();
				}
				break;
			}
			setState(507);
			match(BL_COMMA);
			setState(508);
			composedArgument();
			setState(509);
			match(BL_COMMA);
			setState(510);
			composedArgument();
			setState(516);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(511);
				match(BL_COMMA);
				setState(514);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(512);
					identifiableArgument();
					}
					break;
				case 2:
					{
					setState(513);
					composedArgument();
					}
					break;
				}
				}
			}

			setState(518);
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
		enterRule(_localctx, 68, RULE_once_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			match(D_ONCE);
			setState(522); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(521);
				general_statement();
				}
				}
				setState(524); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1729358801733156864L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 878199711055862317L) != 0) );
			setState(526);
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
	public static class CondSectionContext extends ParserRuleContext {
		public SingleArgWrapperPContext singleArgWrapperP() {
			return getRuleContext(SingleArgWrapperPContext.class,0);
		}
		public Simple_conditional_stmContext simple_conditional_stm() {
			return getRuleContext(Simple_conditional_stmContext.class,0);
		}
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrParser.D_ENDIF, 0); }
		public TerminalNode D_SECTION_MISSING() { return getToken(BladeAntlrParser.D_SECTION_MISSING, 0); }
		public TerminalNode D_HAS_SECTION() { return getToken(BladeAntlrParser.D_HAS_SECTION, 0); }
		public CondSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterCondSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitCondSection(this);
		}
	}

	public final CondSectionContext condSection() throws RecognitionException {
		CondSectionContext _localctx = new CondSectionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_condSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			_la = _input.LA(1);
			if ( !(_la==D_HAS_SECTION || _la==D_SECTION_MISSING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(529);
			singleArgWrapperP();
			setState(530);
			simple_conditional_stm();
			setState(531);
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
		enterRule(_localctx, 72, RULE_custom_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			match(D_CUSTOM);
			setState(537);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				{
				setState(534);
				match(BLADE_PARAM_LPAREN);
				setState(535);
				match(BLADE_PARAM_RPAREN);
				}
				}
				break;
			case 2:
				{
				setState(536);
				multiArgWrapper();
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
		public TerminalNode D_UNKNOWN_ATTR_ENC() { return getToken(BladeAntlrParser.D_UNKNOWN_ATTR_ENC, 0); }
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
		enterRule(_localctx, 74, RULE_possibleDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			_la = _input.LA(1);
			if ( !(_la==D_UNKNOWN_ATTR_ENC || _la==D_UNKNOWN) ) {
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
		enterRule(_localctx, 76, RULE_php_blade);
		int _la;
		try {
			setState(551);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(541);
				match(D_PHP);
				setState(545);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2139134L) != 0) || _la==EXPR_STRING) {
					{
					{
					setState(542);
					composed_php_expression();
					}
					}
					setState(547);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(548);
				match(D_ENDPHP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(549);
				match(D_PHP);
				setState(550);
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
		enterRule(_localctx, 78, RULE_phpInline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			match(PHP_INLINE_START);
			setState(555); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(554);
				composed_php_expression();
				}
				}
				setState(557); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2139134L) != 0) || _la==EXPR_STRING );
			setState(559);
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
		enterRule(_localctx, 80, RULE_regular_echo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			match(CONTENT_TAG_OPEN);
			setState(565);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2139134L) != 0) || _la==EXPR_STRING) {
				{
				{
				setState(562);
				echo_expr();
				}
				}
				setState(567);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(568);
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
		enterRule(_localctx, 82, RULE_raw_echo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			match(RAW_TAG_OPEN);
			setState(574);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2139134L) != 0) || _la==EXPR_STRING) {
				{
				{
				setState(571);
				echo_expr();
				}
				}
				setState(576);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(577);
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
		enterRule(_localctx, 84, RULE_echo_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
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
		public Object_alias_static_accessContext object_alias_static_access() {
			return getRuleContext(Object_alias_static_accessContext.class,0);
		}
		public Object_alias_direct_accessContext object_alias_direct_access() {
			return getRuleContext(Object_alias_direct_accessContext.class,0);
		}
		public Static_direct_class_accessContext static_direct_class_access() {
			return getRuleContext(Static_direct_class_accessContext.class,0);
		}
		public Static_direct_namespace_class_accessContext static_direct_namespace_class_access() {
			return getRuleContext(Static_direct_namespace_class_accessContext.class,0);
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
		enterRule(_localctx, 86, RULE_class_expr_usage);
		try {
			setState(587);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(581);
				class_name_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(582);
				object_alias_static_access();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(583);
				object_alias_direct_access();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(584);
				static_direct_class_access();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(585);
				static_direct_namespace_class_access();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(586);
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
	public static class Object_alias_static_accessContext extends ParserRuleContext {
		public Token alias_name;
		public Token static_property;
		public TerminalNode PHP_STATIC_ACCESS() { return getToken(BladeAntlrParser.PHP_STATIC_ACCESS, 0); }
		public TerminalNode PHP_VARIABLE() { return getToken(BladeAntlrParser.PHP_VARIABLE, 0); }
		public TerminalNode PHP_IDENTIFIER() { return getToken(BladeAntlrParser.PHP_IDENTIFIER, 0); }
		public Object_alias_static_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_alias_static_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterObject_alias_static_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitObject_alias_static_access(this);
		}
	}

	public final Object_alias_static_accessContext object_alias_static_access() throws RecognitionException {
		Object_alias_static_accessContext _localctx = new Object_alias_static_accessContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_object_alias_static_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			((Object_alias_static_accessContext)_localctx).alias_name = match(PHP_VARIABLE);
			setState(590);
			match(PHP_STATIC_ACCESS);
			setState(591);
			((Object_alias_static_accessContext)_localctx).static_property = match(PHP_IDENTIFIER);
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
	public static class Object_alias_direct_accessContext extends ParserRuleContext {
		public Token alias_name;
		public Token property;
		public TerminalNode PHP_INSTANCE_ACCESS() { return getToken(BladeAntlrParser.PHP_INSTANCE_ACCESS, 0); }
		public TerminalNode PHP_VARIABLE() { return getToken(BladeAntlrParser.PHP_VARIABLE, 0); }
		public TerminalNode PHP_IDENTIFIER() { return getToken(BladeAntlrParser.PHP_IDENTIFIER, 0); }
		public Object_alias_direct_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_alias_direct_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterObject_alias_direct_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitObject_alias_direct_access(this);
		}
	}

	public final Object_alias_direct_accessContext object_alias_direct_access() throws RecognitionException {
		Object_alias_direct_accessContext _localctx = new Object_alias_direct_accessContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_object_alias_direct_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			((Object_alias_direct_accessContext)_localctx).alias_name = match(PHP_VARIABLE);
			setState(594);
			match(PHP_INSTANCE_ACCESS);
			setState(595);
			((Object_alias_direct_accessContext)_localctx).property = match(PHP_IDENTIFIER);
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
		public Token class_name;
		public Token func_name;
		public Token static_property;
		public TerminalNode PHP_STATIC_ACCESS() { return getToken(BladeAntlrParser.PHP_STATIC_ACCESS, 0); }
		public TerminalNode BLADE_EXPR_LPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_LPAREN, 0); }
		public TerminalNode BLADE_EXPR_RPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_RPAREN, 0); }
		public List<TerminalNode> PHP_IDENTIFIER() { return getTokens(BladeAntlrParser.PHP_IDENTIFIER); }
		public TerminalNode PHP_IDENTIFIER(int i) {
			return getToken(BladeAntlrParser.PHP_IDENTIFIER, i);
		}
		public List<Composed_php_expressionContext> composed_php_expression() {
			return getRuleContexts(Composed_php_expressionContext.class);
		}
		public Composed_php_expressionContext composed_php_expression(int i) {
			return getRuleContext(Composed_php_expressionContext.class,i);
		}
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
		enterRule(_localctx, 92, RULE_static_direct_class_access);
		int _la;
		try {
			setState(611);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(597);
				((Static_direct_class_accessContext)_localctx).class_name = match(PHP_IDENTIFIER);
				setState(598);
				match(PHP_STATIC_ACCESS);
				setState(599);
				((Static_direct_class_accessContext)_localctx).func_name = match(PHP_IDENTIFIER);
				setState(600);
				match(BLADE_EXPR_LPAREN);
				setState(604);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2139134L) != 0) || _la==EXPR_STRING) {
					{
					{
					setState(601);
					composed_php_expression();
					}
					}
					setState(606);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(607);
				match(BLADE_EXPR_RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(608);
				((Static_direct_class_accessContext)_localctx).class_name = match(PHP_IDENTIFIER);
				setState(609);
				match(PHP_STATIC_ACCESS);
				setState(610);
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
	public static class Static_direct_namespace_class_accessContext extends ParserRuleContext {
		public Token namespace;
		public Token class_name;
		public Token func_name;
		public Token static_property;
		public TerminalNode PHP_STATIC_ACCESS() { return getToken(BladeAntlrParser.PHP_STATIC_ACCESS, 0); }
		public TerminalNode BLADE_EXPR_LPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_LPAREN, 0); }
		public TerminalNode BLADE_EXPR_RPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_RPAREN, 0); }
		public List<TerminalNode> PHP_IDENTIFIER() { return getTokens(BladeAntlrParser.PHP_IDENTIFIER); }
		public TerminalNode PHP_IDENTIFIER(int i) {
			return getToken(BladeAntlrParser.PHP_IDENTIFIER, i);
		}
		public List<Composed_php_expressionContext> composed_php_expression() {
			return getRuleContexts(Composed_php_expressionContext.class);
		}
		public Composed_php_expressionContext composed_php_expression(int i) {
			return getRuleContext(Composed_php_expressionContext.class,i);
		}
		public TerminalNode PHP_NAMESPACE_PATH() { return getToken(BladeAntlrParser.PHP_NAMESPACE_PATH, 0); }
		public Static_direct_namespace_class_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_static_direct_namespace_class_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterStatic_direct_namespace_class_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitStatic_direct_namespace_class_access(this);
		}
	}

	public final Static_direct_namespace_class_accessContext static_direct_namespace_class_access() throws RecognitionException {
		Static_direct_namespace_class_accessContext _localctx = new Static_direct_namespace_class_accessContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_static_direct_namespace_class_access);
		int _la;
		try {
			setState(633);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(614);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PHP_NAMESPACE_PATH) {
					{
					setState(613);
					((Static_direct_namespace_class_accessContext)_localctx).namespace = match(PHP_NAMESPACE_PATH);
					}
				}

				setState(616);
				((Static_direct_namespace_class_accessContext)_localctx).class_name = match(PHP_IDENTIFIER);
				setState(617);
				match(PHP_STATIC_ACCESS);
				setState(618);
				((Static_direct_namespace_class_accessContext)_localctx).func_name = match(PHP_IDENTIFIER);
				setState(619);
				match(BLADE_EXPR_LPAREN);
				setState(623);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2139134L) != 0) || _la==EXPR_STRING) {
					{
					{
					setState(620);
					composed_php_expression();
					}
					}
					setState(625);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(626);
				match(BLADE_EXPR_RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PHP_NAMESPACE_PATH) {
					{
					setState(627);
					((Static_direct_namespace_class_accessContext)_localctx).namespace = match(PHP_NAMESPACE_PATH);
					}
				}

				setState(630);
				((Static_direct_namespace_class_accessContext)_localctx).class_name = match(PHP_IDENTIFIER);
				setState(631);
				match(PHP_STATIC_ACCESS);
				setState(632);
				((Static_direct_namespace_class_accessContext)_localctx).static_property = match(PHP_IDENTIFIER);
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
		public Token namespace;
		public Token class_name;
		public TerminalNode PHP_NEW() { return getToken(BladeAntlrParser.PHP_NEW, 0); }
		public TerminalNode BLADE_EXPR_LPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_LPAREN, 0); }
		public TerminalNode BLADE_EXPR_RPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_RPAREN, 0); }
		public TerminalNode PHP_IDENTIFIER() { return getToken(BladeAntlrParser.PHP_IDENTIFIER, 0); }
		public List<Composed_php_expressionContext> composed_php_expression() {
			return getRuleContexts(Composed_php_expressionContext.class);
		}
		public Composed_php_expressionContext composed_php_expression(int i) {
			return getRuleContext(Composed_php_expressionContext.class,i);
		}
		public TerminalNode PHP_NAMESPACE_PATH() { return getToken(BladeAntlrParser.PHP_NAMESPACE_PATH, 0); }
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
		enterRule(_localctx, 96, RULE_class_instance);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			match(PHP_NEW);
			{
			setState(637);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHP_NAMESPACE_PATH) {
				{
				setState(636);
				((Class_instanceContext)_localctx).namespace = match(PHP_NAMESPACE_PATH);
				}
			}

			setState(639);
			((Class_instanceContext)_localctx).class_name = match(PHP_IDENTIFIER);
			}
			setState(641);
			match(BLADE_EXPR_LPAREN);
			setState(645);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2139134L) != 0) || _la==EXPR_STRING) {
				{
				{
				setState(642);
				composed_php_expression();
				}
				}
				setState(647);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(648);
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
		public Token namespace;
		public Token class_name;
		public TerminalNode PHP_STATIC_ACCESS() { return getToken(BladeAntlrParser.PHP_STATIC_ACCESS, 0); }
		public TerminalNode PHP_CLASS_KEYWORD() { return getToken(BladeAntlrParser.PHP_CLASS_KEYWORD, 0); }
		public TerminalNode PHP_IDENTIFIER() { return getToken(BladeAntlrParser.PHP_IDENTIFIER, 0); }
		public TerminalNode PHP_NAMESPACE_PATH() { return getToken(BladeAntlrParser.PHP_NAMESPACE_PATH, 0); }
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
		enterRule(_localctx, 98, RULE_class_name_reference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHP_NAMESPACE_PATH) {
				{
				setState(650);
				((Class_name_referenceContext)_localctx).namespace = match(PHP_NAMESPACE_PATH);
				}
			}

			setState(653);
			((Class_name_referenceContext)_localctx).class_name = match(PHP_IDENTIFIER);
			setState(654);
			match(PHP_STATIC_ACCESS);
			setState(655);
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
		enterRule(_localctx, 100, RULE_namespacePath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHP_NAMESPACE_PATH) {
				{
				setState(657);
				((NamespacePathContext)_localctx).namespace = match(PHP_NAMESPACE_PATH);
				}
			}

			setState(660);
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
		enterRule(_localctx, 102, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(662);
			((Function_callContext)_localctx).func_name = match(PHP_IDENTIFIER);
			setState(663);
			match(BLADE_EXPR_LPAREN);
			setState(667);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2139134L) != 0) || _la==EXPR_STRING) {
				{
				{
				setState(664);
				composed_php_expression();
				}
				}
				setState(669);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(670);
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
		enterRule(_localctx, 104, RULE_php_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
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
		enterRule(_localctx, 106, RULE_loop_expression);
		int _la;
		try {
			int _alt;
			setState(680);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(674);
				simple_foreach_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(676); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(675);
						_la = _input.LA(1);
						if ( !(_la==PHP_EXPRESSION || _la==PHP_VARIABLE || ((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & 15L) != 0)) ) {
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
					setState(678); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
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
		enterRule(_localctx, 108, RULE_main_php_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
			match(BLADE_EXPR_LPAREN);
			setState(684); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(683);
				composed_php_expression();
				}
				}
				setState(686); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2139134L) != 0) || _la==EXPR_STRING );
			setState(688);
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
		public TerminalNode PHP_STATIC_ACCESS() { return getToken(BladeAntlrParser.PHP_STATIC_ACCESS, 0); }
		public TerminalNode PHP_CLASS_KEYWORD() { return getToken(BladeAntlrParser.PHP_CLASS_KEYWORD, 0); }
		public TerminalNode PHP_INSTANCE_ACCESS() { return getToken(BladeAntlrParser.PHP_INSTANCE_ACCESS, 0); }
		public TerminalNode BL_SQ_LPAREN() { return getToken(BladeAntlrParser.BL_SQ_LPAREN, 0); }
		public TerminalNode BL_SQ_RPAREN() { return getToken(BladeAntlrParser.BL_SQ_RPAREN, 0); }
		public List<Composed_php_expressionContext> composed_php_expression() {
			return getRuleContexts(Composed_php_expressionContext.class);
		}
		public Composed_php_expressionContext composed_php_expression(int i) {
			return getRuleContext(Composed_php_expressionContext.class,i);
		}
		public TerminalNode BLADE_EXPR_LPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_LPAREN, 0); }
		public TerminalNode BLADE_EXPR_RPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_RPAREN, 0); }
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
		enterRule(_localctx, 110, RULE_composed_php_expression);
		int _la;
		try {
			int _alt;
			setState(723);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(690);
				class_expr_usage();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(691);
				function_call();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(692);
				match(PHP_IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(693);
				namespacePath();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(694);
				match(PHP_VARIABLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(695);
				match(PHP_NAMESPACE_PATH);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(696);
				match(EXPR_STRING);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(697);
				match(PHP_KEYWORD);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(699); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(698);
						match(PHP_EXPRESSION);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(701); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(703);
				match(PHP_STATIC_ACCESS);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(704);
				match(PHP_CLASS_KEYWORD);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(705);
				match(PHP_INSTANCE_ACCESS);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(706);
				match(BL_SQ_LPAREN);
				setState(710);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2139134L) != 0) || _la==EXPR_STRING) {
					{
					{
					setState(707);
					composed_php_expression();
					}
					}
					setState(712);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(713);
				match(BL_SQ_RPAREN);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(714);
				match(BLADE_EXPR_LPAREN);
				setState(718);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2139134L) != 0) || _la==EXPR_STRING) {
					{
					{
					setState(715);
					composed_php_expression();
					}
					}
					setState(720);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(721);
				match(BLADE_EXPR_RPAREN);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(722);
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
		enterRule(_localctx, 112, RULE_simple_foreach_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
			((Simple_foreach_exprContext)_localctx).loop_array = match(PHP_VARIABLE);
			setState(726);
			match(FOREACH_AS);
			setState(727);
			((Simple_foreach_exprContext)_localctx).key = match(PHP_VARIABLE);
			setState(730);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FOREACH_PARAM_ASSIGN) {
				{
				setState(728);
				match(FOREACH_PARAM_ASSIGN);
				setState(729);
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
	public static class SingleArgWrapperPContext extends ParserRuleContext {
		public Token idString;
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public ComposedArgumentContext composedArgument() {
			return getRuleContext(ComposedArgumentContext.class,0);
		}
		public TerminalNode BL_PARAM_STRING() { return getToken(BladeAntlrParser.BL_PARAM_STRING, 0); }
		public SingleArgWrapperPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleArgWrapperP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterSingleArgWrapperP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitSingleArgWrapperP(this);
		}
	}

	public final SingleArgWrapperPContext singleArgWrapperP() throws RecognitionException {
		SingleArgWrapperPContext _localctx = new SingleArgWrapperPContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_singleArgWrapperP);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			match(BLADE_PARAM_LPAREN);
			setState(735);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(733);
				((SingleArgWrapperPContext)_localctx).idString = match(BL_PARAM_STRING);
				}
				break;
			case 2:
				{
				setState(734);
				composedArgument();
				}
				break;
			}
			setState(737);
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
	public static class DoubleArgWrapperPContext extends ParserRuleContext {
		public Token idString;
		public TerminalNode BLADE_PARAM_LPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_LPAREN, 0); }
		public TerminalNode BL_COMMA() { return getToken(BladeAntlrParser.BL_COMMA, 0); }
		public List<ComposedArgumentContext> composedArgument() {
			return getRuleContexts(ComposedArgumentContext.class);
		}
		public ComposedArgumentContext composedArgument(int i) {
			return getRuleContext(ComposedArgumentContext.class,i);
		}
		public TerminalNode BLADE_PARAM_RPAREN() { return getToken(BladeAntlrParser.BLADE_PARAM_RPAREN, 0); }
		public TerminalNode BL_PARAM_STRING() { return getToken(BladeAntlrParser.BL_PARAM_STRING, 0); }
		public DoubleArgWrapperPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleArgWrapperP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterDoubleArgWrapperP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitDoubleArgWrapperP(this);
		}
	}

	public final DoubleArgWrapperPContext doubleArgWrapperP() throws RecognitionException {
		DoubleArgWrapperPContext _localctx = new DoubleArgWrapperPContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_doubleArgWrapperP);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(739);
			match(BLADE_PARAM_LPAREN);
			setState(742);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				{
				setState(740);
				((DoubleArgWrapperPContext)_localctx).idString = match(BL_PARAM_STRING);
				}
				break;
			case 2:
				{
				setState(741);
				composedArgument();
				}
				break;
			}
			setState(744);
			match(BL_COMMA);
			setState(745);
			composedArgument();
			setState(746);
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
	public static class DoubleArgWrapperPwithFallbackContext extends ParserRuleContext {
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
		public DoubleArgWrapperPwithFallbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleArgWrapperPwithFallback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterDoubleArgWrapperPwithFallback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitDoubleArgWrapperPwithFallback(this);
		}
	}

	public final DoubleArgWrapperPwithFallbackContext doubleArgWrapperPwithFallback() throws RecognitionException {
		DoubleArgWrapperPwithFallbackContext _localctx = new DoubleArgWrapperPwithFallbackContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_doubleArgWrapperPwithFallback);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748);
			match(BLADE_PARAM_LPAREN);
			setState(749);
			composedArgument();
			setState(750);
			match(BL_COMMA);
			setState(751);
			composedArgument();
			setState(754);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(752);
				match(BL_COMMA);
				setState(753);
				composedArgument();
				}
			}

			setState(756);
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
		enterRule(_localctx, 120, RULE_multiArgWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			match(BLADE_PARAM_LPAREN);
			{
			setState(759);
			composedArgument();
			}
			setState(764);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_COMMA) {
				{
				{
				setState(760);
				match(BL_COMMA);
				setState(761);
				composedArgument();
				}
				}
				setState(766);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(767);
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
		enterRule(_localctx, 122, RULE_identifiableArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(769);
			match(BL_PARAM_STRING);
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
		enterRule(_localctx, 124, RULE_composedArgument);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(772); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(771);
					phpExpr();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(774); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
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
		enterRule(_localctx, 126, RULE_phpExpr);
		try {
			setState(786);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(776);
				identifiableArray();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(777);
				arrayDefine();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(778);
				match(BLADE_PARAM_EXTRA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(779);
				match(PHP_VARIABLE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(780);
				match(PHP_KEYWORD);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(781);
				match(BL_PARAM_CONCAT_OPERATOR);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(782);
				match(BL_PARAM_STRING);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(783);
				match(BL_PARAM_ASSIGN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(784);
				match(BL_NAME_STRING);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(785);
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
		enterRule(_localctx, 128, RULE_identifiableArray);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(788);
			match(BL_SQ_LPAREN);
			setState(789);
			paramAssign();
			setState(794);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(790);
					match(BL_PARAM_COMMA);
					setState(791);
					paramAssign();
					}
					} 
				}
				setState(796);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			}
			setState(798);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_PARAM_COMMA) {
				{
				setState(797);
				match(BL_PARAM_COMMA);
				}
			}

			setState(800);
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
		enterRule(_localctx, 130, RULE_arrayDefine);
		int _la;
		try {
			setState(812);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(802);
				match(BL_SQ_LPAREN);
				setState(804); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(803);
					phpExpr();
					}
					}
					setState(806); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1475596L) != 0) || _la==BL_PARAM_CONCAT_OPERATOR || _la==BL_NAME_STRING );
				setState(808);
				match(BL_SQ_RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(810);
				match(BL_SQ_LPAREN);
				setState(811);
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
		enterRule(_localctx, 132, RULE_paramAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(814);
			match(BL_PARAM_STRING);
			setState(815);
			match(BL_PARAM_ASSIGN);
			setState(816);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 131084L) != 0)) ) {
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
		enterRule(_localctx, 134, RULE_verbatim_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(818);
			match(D_VERBATIM);
			setState(819);
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
		enterRule(_localctx, 136, RULE_loop_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(821);
			_la = _input.LA(1);
			if ( !(_la==D_BREAK || _la==D_LOOP_ACTION) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(823);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHP_EXPRESSION) {
				{
				setState(822);
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
		public TerminalNode HTML_COMPONENT_PREFIX() { return getToken(BladeAntlrParser.HTML_COMPONENT_PREFIX, 0); }
		public TerminalNode HTML_TAG_START() { return getToken(BladeAntlrParser.HTML_TAG_START, 0); }
		public TerminalNode EQ() { return getToken(BladeAntlrParser.EQ, 0); }
		public TerminalNode HTML_IDENTIFIER() { return getToken(BladeAntlrParser.HTML_IDENTIFIER, 0); }
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
		enterRule(_localctx, 138, RULE_html);
		try {
			int _alt;
			setState(834);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML:
				enterOuterAlt(_localctx, 1);
				{
				setState(826); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(825);
						match(HTML);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(828); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case HTML_COMPONENT_PREFIX:
				enterOuterAlt(_localctx, 2);
				{
				setState(830);
				match(HTML_COMPONENT_PREFIX);
				}
				break;
			case HTML_TAG_START:
				enterOuterAlt(_localctx, 3);
				{
				setState(831);
				match(HTML_TAG_START);
				}
				break;
			case EQ:
				enterOuterAlt(_localctx, 4);
				{
				setState(832);
				match(EQ);
				}
				break;
			case HTML_IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(833);
				match(HTML_IDENTIFIER);
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
		"\u0004\u0001\u00af\u0345\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"E\u0001\u0000\u0005\u0000\u008e\b\u0000\n\u0000\f\u0000\u0091\t\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0096\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u009d\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00ba\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00d2\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00d8\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u00dc\b\u0005\u0001\u0005\u0003\u0005\u00df\b"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00ea\b\u0007\n"+
		"\u0007\f\u0007\u00ed\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0005\b\u00f4\b\b\n\b\f\b\u00f7\t\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0001\t\u0005\t\u00fe\b\t\n\t\f\t\u0101\t\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u0108\b\n\n\n\f\n\u010b\t\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u0112\b\u000b\n\u000b\f\u000b\u0115"+
		"\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u011c"+
		"\b\f\n\f\f\f\u011f\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0005\r"+
		"\u0126\b\r\n\r\f\r\u0129\t\r\u0001\r\u0001\r\u0001\r\u0005\r\u012e\b\r"+
		"\n\r\f\r\u0131\t\r\u0005\r\u0133\b\r\n\r\f\r\u0136\t\r\u0001\r\u0003\r"+
		"\u0139\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0005\u000e\u013f\b"+
		"\u000e\n\u000e\f\u000e\u0142\t\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u0153\b\u0012\n\u0012\f\u0012\u0156\t\u0012\u0001\u0012\u0005"+
		"\u0012\u0159\b\u0012\n\u0012\f\u0012\u015c\t\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u016a\b\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0005\u0015\u0172\b\u0015\n\u0015\f\u0015\u0175\t\u0015\u0001\u0015\u0003"+
		"\u0015\u0178\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u017d"+
		"\b\u0016\n\u0016\f\u0016\u0180\t\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0004\u0017\u0188\b\u0017\u000b\u0017"+
		"\f\u0017\u0189\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0005\u0018\u0191\b\u0018\n\u0018\f\u0018\u0194\t\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u019b\b\u0019\n"+
		"\u0019\f\u0019\u019e\t\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u01a7\b\u001a\n"+
		"\u001a\f\u001a\u01aa\t\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u01b4"+
		"\b\u001b\n\u001b\f\u001b\u01b7\t\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0005\u001c\u01be\b\u001c\n\u001c\f\u001c\u01c1"+
		"\t\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0004\u001e\u01cc\b\u001e\u000b"+
		"\u001e\f\u001e\u01cd\u0001\u001e\u0001\u001e\u0003\u001e\u01d2\b\u001e"+
		"\u0001\u001e\u0001\u001e\u0004\u001e\u01d6\b\u001e\u000b\u001e\f\u001e"+
		"\u01d7\u0003\u001e\u01da\b\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u01e4"+
		"\b\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0003 \u01ee\b \u0001 \u0001 \u0003 \u01f2\b \u0001 \u0001 \u0001!\u0001"+
		"!\u0001!\u0001!\u0003!\u01fa\b!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0003!\u0203\b!\u0003!\u0205\b!\u0001!\u0001!\u0001\"\u0001\""+
		"\u0004\"\u020b\b\"\u000b\"\f\"\u020c\u0001\"\u0001\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0003$\u021a\b$\u0001%\u0001"+
		"%\u0001&\u0001&\u0005&\u0220\b&\n&\f&\u0223\t&\u0001&\u0001&\u0001&\u0003"+
		"&\u0228\b&\u0001\'\u0001\'\u0004\'\u022c\b\'\u000b\'\f\'\u022d\u0001\'"+
		"\u0001\'\u0001(\u0001(\u0005(\u0234\b(\n(\f(\u0237\t(\u0001(\u0001(\u0001"+
		")\u0001)\u0005)\u023d\b)\n)\f)\u0240\t)\u0001)\u0001)\u0001*\u0001*\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0003+\u024c\b+\u0001,\u0001,\u0001"+
		",\u0001,\u0001-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001"+
		".\u0005.\u025b\b.\n.\f.\u025e\t.\u0001.\u0001.\u0001.\u0001.\u0003.\u0264"+
		"\b.\u0001/\u0003/\u0267\b/\u0001/\u0001/\u0001/\u0001/\u0001/\u0005/\u026e"+
		"\b/\n/\f/\u0271\t/\u0001/\u0001/\u0003/\u0275\b/\u0001/\u0001/\u0001/"+
		"\u0003/\u027a\b/\u00010\u00010\u00030\u027e\b0\u00010\u00010\u00010\u0001"+
		"0\u00050\u0284\b0\n0\f0\u0287\t0\u00010\u00010\u00011\u00031\u028c\b1"+
		"\u00011\u00011\u00011\u00011\u00012\u00032\u0293\b2\u00012\u00012\u0001"+
		"3\u00013\u00013\u00053\u029a\b3\n3\f3\u029d\t3\u00013\u00013\u00014\u0001"+
		"4\u00015\u00015\u00045\u02a5\b5\u000b5\f5\u02a6\u00035\u02a9\b5\u0001"+
		"6\u00016\u00046\u02ad\b6\u000b6\f6\u02ae\u00016\u00016\u00017\u00017\u0001"+
		"7\u00017\u00017\u00017\u00017\u00017\u00017\u00047\u02bc\b7\u000b7\f7"+
		"\u02bd\u00017\u00017\u00017\u00017\u00017\u00057\u02c5\b7\n7\f7\u02c8"+
		"\t7\u00017\u00017\u00017\u00057\u02cd\b7\n7\f7\u02d0\t7\u00017\u00017"+
		"\u00037\u02d4\b7\u00018\u00018\u00018\u00018\u00018\u00038\u02db\b8\u0001"+
		"9\u00019\u00019\u00039\u02e0\b9\u00019\u00019\u0001:\u0001:\u0001:\u0003"+
		":\u02e7\b:\u0001:\u0001:\u0001:\u0001:\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0003;\u02f3\b;\u0001;\u0001;\u0001<\u0001<\u0001<\u0001<\u0005"+
		"<\u02fb\b<\n<\f<\u02fe\t<\u0001<\u0001<\u0001=\u0001=\u0001>\u0004>\u0305"+
		"\b>\u000b>\f>\u0306\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001"+
		"?\u0001?\u0001?\u0003?\u0313\b?\u0001@\u0001@\u0001@\u0001@\u0005@\u0319"+
		"\b@\n@\f@\u031c\t@\u0001@\u0003@\u031f\b@\u0001@\u0001@\u0001A\u0001A"+
		"\u0004A\u0325\bA\u000bA\fA\u0326\u0001A\u0001A\u0001A\u0001A\u0003A\u032d"+
		"\bA\u0001B\u0001B\u0001B\u0001B\u0001C\u0001C\u0001C\u0001D\u0001D\u0003"+
		"D\u0338\bD\u0001E\u0004E\u033b\bE\u000bE\fE\u033c\u0001E\u0001E\u0001"+
		"E\u0001E\u0003E\u0343\bE\u0001E\u0000\u0000F\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02"+
		"468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u0000\u000b\u0006\u0000\u001e\u001e67MMQQ]`ee\u0004\u0000\u001f"+
		"\u001f-.PPll\u0004\u0000/055<<fg\u0002\u0000;;>A\u0002\u00001133\u0001"+
		"\u00009:\u0001\u0000pq\u0001\u0001\u009f\u009f\u0002\u0000\u0001\u0002"+
		"\u008f\u0092\u0002\u0000\u0002\u0003\u0011\u0011\u0001\u0000-.\u0396\u0000"+
		"\u008f\u0001\u0000\u0000\u0000\u0002\u0095\u0001\u0000\u0000\u0000\u0004"+
		"\u009c\u0001\u0000\u0000\u0000\u0006\u00b9\u0001\u0000\u0000\u0000\b\u00d1"+
		"\u0001\u0000\u0000\u0000\n\u00d3\u0001\u0000\u0000\u0000\f\u00e2\u0001"+
		"\u0000\u0000\u0000\u000e\u00e5\u0001\u0000\u0000\u0000\u0010\u00f0\u0001"+
		"\u0000\u0000\u0000\u0012\u00fa\u0001\u0000\u0000\u0000\u0014\u0104\u0001"+
		"\u0000\u0000\u0000\u0016\u010e\u0001\u0000\u0000\u0000\u0018\u0118\u0001"+
		"\u0000\u0000\u0000\u001a\u0122\u0001\u0000\u0000\u0000\u001c\u013c\u0001"+
		"\u0000\u0000\u0000\u001e\u0143\u0001\u0000\u0000\u0000 \u0145\u0001\u0000"+
		"\u0000\u0000\"\u014a\u0001\u0000\u0000\u0000$\u014f\u0001\u0000\u0000"+
		"\u0000&\u0169\u0001\u0000\u0000\u0000(\u016b\u0001\u0000\u0000\u0000*"+
		"\u0173\u0001\u0000\u0000\u0000,\u0179\u0001\u0000\u0000\u0000.\u0183\u0001"+
		"\u0000\u0000\u00000\u018d\u0001\u0000\u0000\u00002\u0197\u0001\u0000\u0000"+
		"\u00004\u01a1\u0001\u0000\u0000\u00006\u01ad\u0001\u0000\u0000\u00008"+
		"\u01ba\u0001\u0000\u0000\u0000:\u01c4\u0001\u0000\u0000\u0000<\u01c7\u0001"+
		"\u0000\u0000\u0000>\u01dd\u0001\u0000\u0000\u0000@\u01e7\u0001\u0000\u0000"+
		"\u0000B\u01f5\u0001\u0000\u0000\u0000D\u0208\u0001\u0000\u0000\u0000F"+
		"\u0210\u0001\u0000\u0000\u0000H\u0215\u0001\u0000\u0000\u0000J\u021b\u0001"+
		"\u0000\u0000\u0000L\u0227\u0001\u0000\u0000\u0000N\u0229\u0001\u0000\u0000"+
		"\u0000P\u0231\u0001\u0000\u0000\u0000R\u023a\u0001\u0000\u0000\u0000T"+
		"\u0243\u0001\u0000\u0000\u0000V\u024b\u0001\u0000\u0000\u0000X\u024d\u0001"+
		"\u0000\u0000\u0000Z\u0251\u0001\u0000\u0000\u0000\\\u0263\u0001\u0000"+
		"\u0000\u0000^\u0279\u0001\u0000\u0000\u0000`\u027b\u0001\u0000\u0000\u0000"+
		"b\u028b\u0001\u0000\u0000\u0000d\u0292\u0001\u0000\u0000\u0000f\u0296"+
		"\u0001\u0000\u0000\u0000h\u02a0\u0001\u0000\u0000\u0000j\u02a8\u0001\u0000"+
		"\u0000\u0000l\u02aa\u0001\u0000\u0000\u0000n\u02d3\u0001\u0000\u0000\u0000"+
		"p\u02d5\u0001\u0000\u0000\u0000r\u02dc\u0001\u0000\u0000\u0000t\u02e3"+
		"\u0001\u0000\u0000\u0000v\u02ec\u0001\u0000\u0000\u0000x\u02f6\u0001\u0000"+
		"\u0000\u0000z\u0301\u0001\u0000\u0000\u0000|\u0304\u0001\u0000\u0000\u0000"+
		"~\u0312\u0001\u0000\u0000\u0000\u0080\u0314\u0001\u0000\u0000\u0000\u0082"+
		"\u032c\u0001\u0000\u0000\u0000\u0084\u032e\u0001\u0000\u0000\u0000\u0086"+
		"\u0332\u0001\u0000\u0000\u0000\u0088\u0335\u0001\u0000\u0000\u0000\u008a"+
		"\u0342\u0001\u0000\u0000\u0000\u008c\u008e\u0003\u0002\u0001\u0000\u008d"+
		"\u008c\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f"+
		"\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090"+
		"\u0001\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092"+
		"\u0096\u0003\u0004\u0002\u0000\u0093\u0096\u0003\b\u0004\u0000\u0094\u0096"+
		"\u0003\u008aE\u0000\u0095\u0092\u0001\u0000\u0000\u0000\u0095\u0093\u0001"+
		"\u0000\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u0003\u0001"+
		"\u0000\u0000\u0000\u0097\u009d\u0003\u0006\u0003\u0000\u0098\u009d\u0003"+
		"J%\u0000\u0099\u009d\u0003P(\u0000\u009a\u009d\u0003R)\u0000\u009b\u009d"+
		"\u0003N\'\u0000\u009c\u0097\u0001\u0000\u0000\u0000\u009c\u0098\u0001"+
		"\u0000\u0000\u0000\u009c\u0099\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u0005\u0001"+
		"\u0000\u0000\u0000\u009e\u00ba\u0003\f\u0006\u0000\u009f\u00ba\u0003\n"+
		"\u0005\u0000\u00a0\u00ba\u0003:\u001d\u0000\u00a1\u00ba\u0003@ \u0000"+
		"\u00a2\u00a3\u00052\u0000\u0000\u00a3\u00a4\u0005\u000b\u0000\u0000\u00a4"+
		"\u00a5\u0003|>\u0000\u00a5\u00a6\u0005\u0013\u0000\u0000\u00a6\u00a7\u0003"+
		"|>\u0000\u00a7\u00a8\u0005\f\u0000\u0000\u00a8\u00ba\u0001\u0000\u0000"+
		"\u0000\u00a9\u00ba\u0003B!\u0000\u00aa\u00ab\u0007\u0000\u0000\u0000\u00ab"+
		"\u00ba\u0003n7\u0000\u00ac\u00ba\u0007\u0001\u0000\u0000\u00ad\u00ba\u0003"+
		"<\u001e\u0000\u00ae\u00ba\u0003>\u001f\u0000\u00af\u00b0\u0005[\u0000"+
		"\u0000\u00b0\u00ba\u0003n7\u0000\u00b1\u00ba\u0003\u0088D\u0000\u00b2"+
		"\u00ba\u0005\u001b\u0000\u0000\u00b3\u00ba\u0005n\u0000\u0000\u00b4\u00b5"+
		"\u0005b\u0000\u0000\u00b5\u00ba\u0003v;\u0000\u00b6\u00b7\u0005a\u0000"+
		"\u0000\u00b7\u00ba\u0003r9\u0000\u00b8\u00ba\u0003H$\u0000\u00b9\u009e"+
		"\u0001\u0000\u0000\u0000\u00b9\u009f\u0001\u0000\u0000\u0000\u00b9\u00a0"+
		"\u0001\u0000\u0000\u0000\u00b9\u00a1\u0001\u0000\u0000\u0000\u00b9\u00a2"+
		"\u0001\u0000\u0000\u0000\u00b9\u00a9\u0001\u0000\u0000\u0000\u00b9\u00aa"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ac\u0001\u0000\u0000\u0000\u00b9\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ae\u0001\u0000\u0000\u0000\u00b9\u00af"+
		"\u0001\u0000\u0000\u0000\u00b9\u00b1\u0001\u0000\u0000\u0000\u00b9\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b9\u00b3\u0001\u0000\u0000\u0000\u00b9\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b9\u00b6\u0001\u0000\u0000\u0000\u00b9\u00b8"+
		"\u0001\u0000\u0000\u0000\u00ba\u0007\u0001\u0000\u0000\u0000\u00bb\u00d2"+
		"\u0003\u000e\u0007\u0000\u00bc\u00d2\u0003F#\u0000\u00bd\u00d2\u0003\u0010"+
		"\b\u0000\u00be\u00d2\u0003\u0014\n\u0000\u00bf\u00d2\u0003D\"\u0000\u00c0"+
		"\u00d2\u0003\u0016\u000b\u0000\u00c1\u00d2\u0003\u0018\f\u0000\u00c2\u00d2"+
		"\u0003\u001a\r\u0000\u00c3\u00d2\u0003.\u0017\u0000\u00c4\u00d2\u0003"+
		"&\u0013\u0000\u00c5\u00d2\u0003 \u0010\u0000\u00c6\u00d2\u0003,\u0016"+
		"\u0000\u00c7\u00d2\u0003\"\u0011\u0000\u00c8\u00d2\u0003$\u0012\u0000"+
		"\u00c9\u00d2\u0003(\u0014\u0000\u00ca\u00d2\u00030\u0018\u0000\u00cb\u00d2"+
		"\u00032\u0019\u0000\u00cc\u00d2\u00034\u001a\u0000\u00cd\u00d2\u00036"+
		"\u001b\u0000\u00ce\u00d2\u00038\u001c\u0000\u00cf\u00d2\u0003\u0086C\u0000"+
		"\u00d0\u00d2\u0003L&\u0000\u00d1\u00bb\u0001\u0000\u0000\u0000\u00d1\u00bc"+
		"\u0001\u0000\u0000\u0000\u00d1\u00bd\u0001\u0000\u0000\u0000\u00d1\u00be"+
		"\u0001\u0000\u0000\u0000\u00d1\u00bf\u0001\u0000\u0000\u0000\u00d1\u00c0"+
		"\u0001\u0000\u0000\u0000\u00d1\u00c1\u0001\u0000\u0000\u0000\u00d1\u00c2"+
		"\u0001\u0000\u0000\u0000\u00d1\u00c3\u0001\u0000\u0000\u0000\u00d1\u00c4"+
		"\u0001\u0000\u0000\u0000\u00d1\u00c5\u0001\u0000\u0000\u0000\u00d1\u00c6"+
		"\u0001\u0000\u0000\u0000\u00d1\u00c7\u0001\u0000\u0000\u0000\u00d1\u00c8"+
		"\u0001\u0000\u0000\u0000\u00d1\u00c9\u0001\u0000\u0000\u0000\u00d1\u00ca"+
		"\u0001\u0000\u0000\u0000\u00d1\u00cb\u0001\u0000\u0000\u0000\u00d1\u00cc"+
		"\u0001\u0000\u0000\u0000\u00d1\u00cd\u0001\u0000\u0000\u0000\u00d1\u00ce"+
		"\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d2\t\u0001\u0000\u0000\u0000\u00d3\u00d4\u0007"+
		"\u0002\u0000\u0000\u00d4\u00d7\u0005\u000b\u0000\u0000\u00d5\u00d8\u0005"+
		"\u0011\u0000\u0000\u00d6\u00d8\u0003|>\u0000\u00d7\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000"+
		"\u0000\u00d9\u00da\u0005\u0013\u0000\u0000\u00da\u00dc\u0003|>\u0000\u00db"+
		"\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc"+
		"\u00de\u0001\u0000\u0000\u0000\u00dd\u00df\u0005\u0013\u0000\u0000\u00de"+
		"\u00dd\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005\f\u0000\u0000\u00e1\u000b"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u00058\u0000\u0000\u00e3\u00e4\u0003"+
		"t:\u0000\u00e4\r\u0001\u0000\u0000\u0000\u00e5\u00e6\u00058\u0000\u0000"+
		"\u00e6\u00eb\u0003r9\u0000\u00e7\u00ea\u0003\u0002\u0001\u0000\u00e8\u00ea"+
		"\u0005=\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00e8\u0001"+
		"\u0000\u0000\u0000\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001"+
		"\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ee\u0001"+
		"\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00ef\u0007"+
		"\u0003\u0000\u0000\u00ef\u000f\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005"+
		"E\u0000\u0000\u00f1\u00f5\u0003r9\u0000\u00f2\u00f4\u0003\u0002\u0001"+
		"\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f7\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f9\u0005F\u0000\u0000\u00f9\u0011\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fb\u0005I\u0000\u0000\u00fb\u00ff\u0003r9\u0000\u00fc\u00fe"+
		"\u0003\u0002\u0001\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fe\u0101"+
		"\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100"+
		"\u0001\u0000\u0000\u0000\u0100\u0102\u0001\u0000\u0000\u0000\u0101\u00ff"+
		"\u0001\u0000\u0000\u0000\u0102\u0103\u0005J\u0000\u0000\u0103\u0013\u0001"+
		"\u0000\u0000\u0000\u0104\u0105\u0005G\u0000\u0000\u0105\u0109\u0003r9"+
		"\u0000\u0106\u0108\u0003\u0002\u0001\u0000\u0107\u0106\u0001\u0000\u0000"+
		"\u0000\u0108\u010b\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000"+
		"\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010c\u0001\u0000\u0000"+
		"\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c\u010d\u0005H\u0000\u0000"+
		"\u010d\u0015\u0001\u0000\u0000\u0000\u010e\u010f\u0005K\u0000\u0000\u010f"+
		"\u0113\u0003r9\u0000\u0110\u0112\u0003\u0002\u0001\u0000\u0111\u0110\u0001"+
		"\u0000\u0000\u0000\u0112\u0115\u0001\u0000\u0000\u0000\u0113\u0111\u0001"+
		"\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0116\u0001"+
		"\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0116\u0117\u0005"+
		"L\u0000\u0000\u0117\u0017\u0001\u0000\u0000\u0000\u0118\u0119\u0005N\u0000"+
		"\u0000\u0119\u011d\u0003n7\u0000\u011a\u011c\u0003\u0002\u0001\u0000\u011b"+
		"\u011a\u0001\u0000\u0000\u0000\u011c\u011f\u0001\u0000\u0000\u0000\u011d"+
		"\u011b\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e"+
		"\u0120\u0001\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u0120"+
		"\u0121\u0005O\u0000\u0000\u0121\u0019\u0001\u0000\u0000\u0000\u0122\u0123"+
		"\u0005\u0019\u0000\u0000\u0123\u0127\u0003l6\u0000\u0124\u0126\u0003\u0002"+
		"\u0001\u0000\u0125\u0124\u0001\u0000\u0000\u0000\u0126\u0129\u0001\u0000"+
		"\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000"+
		"\u0000\u0000\u0128\u0134\u0001\u0000\u0000\u0000\u0129\u0127\u0001\u0000"+
		"\u0000\u0000\u012a\u012b\u0005\u001a\u0000\u0000\u012b\u012f\u0003l6\u0000"+
		"\u012c\u012e\u0003\u0002\u0001\u0000\u012d\u012c\u0001\u0000\u0000\u0000"+
		"\u012e\u0131\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000"+
		"\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0133\u0001\u0000\u0000\u0000"+
		"\u0131\u012f\u0001\u0000\u0000\u0000\u0132\u012a\u0001\u0000\u0000\u0000"+
		"\u0133\u0136\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000"+
		"\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0138\u0001\u0000\u0000\u0000"+
		"\u0136\u0134\u0001\u0000\u0000\u0000\u0137\u0139\u0003\u001c\u000e\u0000"+
		"\u0138\u0137\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000"+
		"\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013b\u0003\u001e\u000f\u0000"+
		"\u013b\u001b\u0001\u0000\u0000\u0000\u013c\u0140\u0005\u001b\u0000\u0000"+
		"\u013d\u013f\u0003\u0002\u0001\u0000\u013e\u013d\u0001\u0000\u0000\u0000"+
		"\u013f\u0142\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000"+
		"\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u001d\u0001\u0000\u0000\u0000"+
		"\u0142\u0140\u0001\u0000\u0000\u0000\u0143\u0144\u0005\u001c\u0000\u0000"+
		"\u0144\u001f\u0001\u0000\u0000\u0000\u0145\u0146\u0005!\u0000\u0000\u0146"+
		"\u0147\u0003n7\u0000\u0147\u0148\u0003*\u0015\u0000\u0148\u0149\u0005"+
		"\"\u0000\u0000\u0149!\u0001\u0000\u0000\u0000\u014a\u014b\u0005#\u0000"+
		"\u0000\u014b\u014c\u0003l6\u0000\u014c\u014d\u0003*\u0015\u0000\u014d"+
		"\u014e\u0005$\u0000\u0000\u014e#\u0001\u0000\u0000\u0000\u014f\u015a\u0005"+
		"X\u0000\u0000\u0150\u0154\u0005\u000b\u0000\u0000\u0151\u0153\u0003|>"+
		"\u0000\u0152\u0151\u0001\u0000\u0000\u0000\u0153\u0156\u0001\u0000\u0000"+
		"\u0000\u0154\u0152\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000\u0000"+
		"\u0000\u0155\u0157\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000"+
		"\u0000\u0157\u0159\u0005\f\u0000\u0000\u0158\u0150\u0001\u0000\u0000\u0000"+
		"\u0159\u015c\u0001\u0000\u0000\u0000\u015a\u0158\u0001\u0000\u0000\u0000"+
		"\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015d\u0001\u0000\u0000\u0000"+
		"\u015c\u015a\u0001\u0000\u0000\u0000\u015d\u015e\u0003*\u0015\u0000\u015e"+
		"\u015f\u0005Y\u0000\u0000\u015f%\u0001\u0000\u0000\u0000\u0160\u0161\u0005"+
		"V\u0000\u0000\u0161\u0162\u0003r9\u0000\u0162\u0163\u0003*\u0015\u0000"+
		"\u0163\u0164\u0005W\u0000\u0000\u0164\u016a\u0001\u0000\u0000\u0000\u0165"+
		"\u0166\u0005T\u0000\u0000\u0166\u0167\u0003*\u0015\u0000\u0167\u0168\u0005"+
		"U\u0000\u0000\u0168\u016a\u0001\u0000\u0000\u0000\u0169\u0160\u0001\u0000"+
		"\u0000\u0000\u0169\u0165\u0001\u0000\u0000\u0000\u016a\'\u0001\u0000\u0000"+
		"\u0000\u016b\u016c\u0005Z\u0000\u0000\u016c\u016d\u0003n7\u0000\u016d"+
		"\u016e\u0003*\u0015\u0000\u016e\u016f\u0005\\\u0000\u0000\u016f)\u0001"+
		"\u0000\u0000\u0000\u0170\u0172\u0003\u0002\u0001\u0000\u0171\u0170\u0001"+
		"\u0000\u0000\u0000\u0172\u0175\u0001\u0000\u0000\u0000\u0173\u0171\u0001"+
		"\u0000\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174\u0177\u0001"+
		"\u0000\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0176\u0178\u0003"+
		"\u001c\u000e\u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0177\u0178\u0001"+
		"\u0000\u0000\u0000\u0178+\u0001\u0000\u0000\u0000\u0179\u017a\u0005R\u0000"+
		"\u0000\u017a\u017e\u0003h4\u0000\u017b\u017d\u0003\u0002\u0001\u0000\u017c"+
		"\u017b\u0001\u0000\u0000\u0000\u017d\u0180\u0001\u0000\u0000\u0000\u017e"+
		"\u017c\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000\u0000\u017f"+
		"\u0181\u0001\u0000\u0000\u0000\u0180\u017e\u0001\u0000\u0000\u0000\u0181"+
		"\u0182\u0005S\u0000\u0000\u0182-\u0001\u0000\u0000\u0000\u0183\u0184\u0005"+
		"\u001d\u0000\u0000\u0184\u0187\u0003h4\u0000\u0185\u0188\u0003\u0002\u0001"+
		"\u0000\u0186\u0188\u0005-\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000"+
		"\u0187\u0186\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000\u0000"+
		"\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000"+
		"\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u018c\u0005 \u0000\u0000\u018c"+
		"/\u0001\u0000\u0000\u0000\u018d\u018e\u0005+\u0000\u0000\u018e\u0192\u0003"+
		"h4\u0000\u018f\u0191\u0003\u0002\u0001\u0000\u0190\u018f\u0001\u0000\u0000"+
		"\u0000\u0191\u0194\u0001\u0000\u0000\u0000\u0192\u0190\u0001\u0000\u0000"+
		"\u0000\u0192\u0193\u0001\u0000\u0000\u0000\u0193\u0195\u0001\u0000\u0000"+
		"\u0000\u0194\u0192\u0001\u0000\u0000\u0000\u0195\u0196\u0005,\u0000\u0000"+
		"\u01961\u0001\u0000\u0000\u0000\u0197\u0198\u0005\'\u0000\u0000\u0198"+
		"\u019c\u0003h4\u0000\u0199\u019b\u0003\u0002\u0001\u0000\u019a\u0199\u0001"+
		"\u0000\u0000\u0000\u019b\u019e\u0001\u0000\u0000\u0000\u019c\u019a\u0001"+
		"\u0000\u0000\u0000\u019c\u019d\u0001\u0000\u0000\u0000\u019d\u019f\u0001"+
		"\u0000\u0000\u0000\u019e\u019c\u0001\u0000\u0000\u0000\u019f\u01a0\u0005"+
		"(\u0000\u0000\u01a03\u0001\u0000\u0000\u0000\u01a1\u01a2\u0005%\u0000"+
		"\u0000\u01a2\u01a3\u0005\u008f\u0000\u0000\u01a3\u01a4\u0003j5\u0000\u01a4"+
		"\u01a8\u0005\u0090\u0000\u0000\u01a5\u01a7\u0003\u0002\u0001\u0000\u01a6"+
		"\u01a5\u0001\u0000\u0000\u0000\u01a7\u01aa\u0001\u0000\u0000\u0000\u01a8"+
		"\u01a6\u0001\u0000\u0000\u0000\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a9"+
		"\u01ab\u0001\u0000\u0000\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000\u01ab"+
		"\u01ac\u0005&\u0000\u0000\u01ac5\u0001\u0000\u0000\u0000\u01ad\u01ae\u0005"+
		")\u0000\u0000\u01ae\u01af\u0005\u008f\u0000\u0000\u01af\u01b0\u0003j5"+
		"\u0000\u01b0\u01b5\u0005\u0090\u0000\u0000\u01b1\u01b4\u0003\u0002\u0001"+
		"\u0000\u01b2\u01b4\u0005!\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000\u0000"+
		"\u01b3\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000\u0000"+
		"\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000"+
		"\u01b6\u01b8\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000"+
		"\u01b8\u01b9\u0005*\u0000\u0000\u01b97\u0001\u0000\u0000\u0000\u01ba\u01bb"+
		"\u0005c\u0000\u0000\u01bb\u01bf\u0003n7\u0000\u01bc\u01be\u0003\u0002"+
		"\u0001\u0000\u01bd\u01bc\u0001\u0000\u0000\u0000\u01be\u01c1\u0001\u0000"+
		"\u0000\u0000\u01bf\u01bd\u0001\u0000\u0000\u0000\u01bf\u01c0\u0001\u0000"+
		"\u0000\u0000\u01c0\u01c2\u0001\u0000\u0000\u0000\u01c1\u01bf\u0001\u0000"+
		"\u0000\u0000\u01c2\u01c3\u0005d\u0000\u0000\u01c39\u0001\u0000\u0000\u0000"+
		"\u01c4\u01c5\u0005D\u0000\u0000\u01c5\u01c6\u0003r9\u0000\u01c6;\u0001"+
		"\u0000\u0000\u0000\u01c7\u01c8\u0005m\u0000\u0000\u01c8\u01d9\u0005\r"+
		"\u0000\u0000\u01c9\u01cb\u0005\u000f\u0000\u0000\u01ca\u01cc\u0005\u008a"+
		"\u0000\u0000\u01cb\u01ca\u0001\u0000\u0000\u0000\u01cc\u01cd\u0001\u0000"+
		"\u0000\u0000\u01cd\u01cb\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000"+
		"\u0000\u0000\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cf\u01d1\u0005\u0094"+
		"\u0000\u0000\u01d0\u01d2\u0005\u008a\u0000\u0000\u01d1\u01d0\u0001\u0000"+
		"\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000\u0000\u01d2\u01da\u0001\u0000"+
		"\u0000\u0000\u01d3\u01da\u0005\u008a\u0000\u0000\u01d4\u01d6\u0003n7\u0000"+
		"\u01d5\u01d4\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000\u0000"+
		"\u01d7\u01d5\u0001\u0000\u0000\u0000\u01d7\u01d8\u0001\u0000\u0000\u0000"+
		"\u01d8\u01da\u0001\u0000\u0000\u0000\u01d9\u01c9\u0001\u0000\u0000\u0000"+
		"\u01d9\u01d3\u0001\u0000\u0000\u0000\u01d9\u01d5\u0001\u0000\u0000\u0000"+
		"\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01dc\u0005\u000e\u0000\u0000"+
		"\u01dc=\u0001\u0000\u0000\u0000\u01dd\u01de\u0005h\u0000\u0000\u01de\u01df"+
		"\u0005\u000b\u0000\u0000\u01df\u01e0\u0003|>\u0000\u01e0\u01e3\u0005\u0013"+
		"\u0000\u0000\u01e1\u01e4\u0003z=\u0000\u01e2\u01e4\u0003|>\u0000\u01e3"+
		"\u01e1\u0001\u0000\u0000\u0000\u01e3\u01e2\u0001\u0000\u0000\u0000\u01e4"+
		"\u01e5\u0001\u0000\u0000\u0000\u01e5\u01e6\u0005\f\u0000\u0000\u01e6?"+
		"\u0001\u0000\u0000\u0000\u01e7\u01e8\u0007\u0004\u0000\u0000\u01e8\u01e9"+
		"\u0005\u000b\u0000\u0000\u01e9\u01ea\u0003|>\u0000\u01ea\u01ed\u0005\u0013"+
		"\u0000\u0000\u01eb\u01ee\u0005\u0011\u0000\u0000\u01ec\u01ee\u0003|>\u0000"+
		"\u01ed\u01eb\u0001\u0000\u0000\u0000\u01ed\u01ec\u0001\u0000\u0000\u0000"+
		"\u01ee\u01f1\u0001\u0000\u0000\u0000\u01ef\u01f0\u0005\u0013\u0000\u0000"+
		"\u01f0\u01f2\u0003|>\u0000\u01f1\u01ef\u0001\u0000\u0000\u0000\u01f1\u01f2"+
		"\u0001\u0000\u0000\u0000\u01f2\u01f3\u0001\u0000\u0000\u0000\u01f3\u01f4"+
		"\u0005\f\u0000\u0000\u01f4A\u0001\u0000\u0000\u0000\u01f5\u01f6\u0005"+
		"4\u0000\u0000\u01f6\u01f9\u0005\u000b\u0000\u0000\u01f7\u01fa\u0005\u0011"+
		"\u0000\u0000\u01f8\u01fa\u0003|>\u0000\u01f9\u01f7\u0001\u0000\u0000\u0000"+
		"\u01f9\u01f8\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000"+
		"\u01fb\u01fc\u0005\u0013\u0000\u0000\u01fc\u01fd\u0003|>\u0000\u01fd\u01fe"+
		"\u0005\u0013\u0000\u0000\u01fe\u0204\u0003|>\u0000\u01ff\u0202\u0005\u0013"+
		"\u0000\u0000\u0200\u0203\u0003z=\u0000\u0201\u0203\u0003|>\u0000\u0202"+
		"\u0200\u0001\u0000\u0000\u0000\u0202\u0201\u0001\u0000\u0000\u0000\u0203"+
		"\u0205\u0001\u0000\u0000\u0000\u0204\u01ff\u0001\u0000\u0000\u0000\u0204"+
		"\u0205\u0001\u0000\u0000\u0000\u0205\u0206\u0001\u0000\u0000\u0000\u0206"+
		"\u0207\u0005\f\u0000\u0000\u0207C\u0001\u0000\u0000\u0000\u0208\u020a"+
		"\u0005B\u0000\u0000\u0209\u020b\u0003\u0002\u0001\u0000\u020a\u0209\u0001"+
		"\u0000\u0000\u0000\u020b\u020c\u0001\u0000\u0000\u0000\u020c\u020a\u0001"+
		"\u0000\u0000\u0000\u020c\u020d\u0001\u0000\u0000\u0000\u020d\u020e\u0001"+
		"\u0000\u0000\u0000\u020e\u020f\u0005C\u0000\u0000\u020fE\u0001\u0000\u0000"+
		"\u0000\u0210\u0211\u0007\u0005\u0000\u0000\u0211\u0212\u0003r9\u0000\u0212"+
		"\u0213\u0003*\u0015\u0000\u0213\u0214\u0005\u001c\u0000\u0000\u0214G\u0001"+
		"\u0000\u0000\u0000\u0215\u0219\u0005o\u0000\u0000\u0216\u0217\u0005\u000b"+
		"\u0000\u0000\u0217\u021a\u0005\f\u0000\u0000\u0218\u021a\u0003x<\u0000"+
		"\u0219\u0216\u0001\u0000\u0000\u0000\u0219\u0218\u0001\u0000\u0000\u0000"+
		"\u021aI\u0001\u0000\u0000\u0000\u021b\u021c\u0007\u0006\u0000\u0000\u021c"+
		"K\u0001\u0000\u0000\u0000\u021d\u0221\u0005i\u0000\u0000\u021e\u0220\u0003"+
		"n7\u0000\u021f\u021e\u0001\u0000\u0000\u0000\u0220\u0223\u0001\u0000\u0000"+
		"\u0000\u0221\u021f\u0001\u0000\u0000\u0000\u0221\u0222\u0001\u0000\u0000"+
		"\u0000\u0222\u0224\u0001\u0000\u0000\u0000\u0223\u0221\u0001\u0000\u0000"+
		"\u0000\u0224\u0228\u0005\u009c\u0000\u0000\u0225\u0226\u0005i\u0000\u0000"+
		"\u0226\u0228\u0003l6\u0000\u0227\u021d\u0001\u0000\u0000\u0000\u0227\u0225"+
		"\u0001\u0000\u0000\u0000\u0228M\u0001\u0000\u0000\u0000\u0229\u022b\u0005"+
		"t\u0000\u0000\u022a\u022c\u0003n7\u0000\u022b\u022a\u0001\u0000\u0000"+
		"\u0000\u022c\u022d\u0001\u0000\u0000\u0000\u022d\u022b\u0001\u0000\u0000"+
		"\u0000\u022d\u022e\u0001\u0000\u0000\u0000\u022e\u022f\u0001\u0000\u0000"+
		"\u0000\u022f\u0230\u0007\u0007\u0000\u0000\u0230O\u0001\u0000\u0000\u0000"+
		"\u0231\u0235\u0005r\u0000\u0000\u0232\u0234\u0003T*\u0000\u0233\u0232"+
		"\u0001\u0000\u0000\u0000\u0234\u0237\u0001\u0000\u0000\u0000\u0235\u0233"+
		"\u0001\u0000\u0000\u0000\u0235\u0236\u0001\u0000\u0000\u0000\u0236\u0238"+
		"\u0001\u0000\u0000\u0000\u0237\u0235\u0001\u0000\u0000\u0000\u0238\u0239"+
		"\u0005\u0082\u0000\u0000\u0239Q\u0001\u0000\u0000\u0000\u023a\u023e\u0005"+
		"s\u0000\u0000\u023b\u023d\u0003T*\u0000\u023c\u023b\u0001\u0000\u0000"+
		"\u0000\u023d\u0240\u0001\u0000\u0000\u0000\u023e\u023c\u0001\u0000\u0000"+
		"\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f\u0241\u0001\u0000\u0000"+
		"\u0000\u0240\u023e\u0001\u0000\u0000\u0000\u0241\u0242\u0005\u0085\u0000"+
		"\u0000\u0242S\u0001\u0000\u0000\u0000\u0243\u0244\u0003n7\u0000\u0244"+
		"U\u0001\u0000\u0000\u0000\u0245\u024c\u0003b1\u0000\u0246\u024c\u0003"+
		"X,\u0000\u0247\u024c\u0003Z-\u0000\u0248\u024c\u0003\\.\u0000\u0249\u024c"+
		"\u0003^/\u0000\u024a\u024c\u0003`0\u0000\u024b\u0245\u0001\u0000\u0000"+
		"\u0000\u024b\u0246\u0001\u0000\u0000\u0000\u024b\u0247\u0001\u0000\u0000"+
		"\u0000\u024b\u0248\u0001\u0000\u0000\u0000\u024b\u0249\u0001\u0000\u0000"+
		"\u0000\u024b\u024a\u0001\u0000\u0000\u0000\u024cW\u0001\u0000\u0000\u0000"+
		"\u024d\u024e\u0005\u0002\u0000\u0000\u024e\u024f\u0005\u0007\u0000\u0000"+
		"\u024f\u0250\u0005\u0005\u0000\u0000\u0250Y\u0001\u0000\u0000\u0000\u0251"+
		"\u0252\u0005\u0002\u0000\u0000\u0252\u0253\u0005\t\u0000\u0000\u0253\u0254"+
		"\u0005\u0005\u0000\u0000\u0254[\u0001\u0000\u0000\u0000\u0255\u0256\u0005"+
		"\u0005\u0000\u0000\u0256\u0257\u0005\u0007\u0000\u0000\u0257\u0258\u0005"+
		"\u0005\u0000\u0000\u0258\u025c\u0005\r\u0000\u0000\u0259\u025b\u0003n"+
		"7\u0000\u025a\u0259\u0001\u0000\u0000\u0000\u025b\u025e\u0001\u0000\u0000"+
		"\u0000\u025c\u025a\u0001\u0000\u0000\u0000\u025c\u025d\u0001\u0000\u0000"+
		"\u0000\u025d\u025f\u0001\u0000\u0000\u0000\u025e\u025c\u0001\u0000\u0000"+
		"\u0000\u025f\u0264\u0005\u000e\u0000\u0000\u0260\u0261\u0005\u0005\u0000"+
		"\u0000\u0261\u0262\u0005\u0007\u0000\u0000\u0262\u0264\u0005\u0005\u0000"+
		"\u0000\u0263\u0255\u0001\u0000\u0000\u0000\u0263\u0260\u0001\u0000\u0000"+
		"\u0000\u0264]\u0001\u0000\u0000\u0000\u0265\u0267\u0005\u0006\u0000\u0000"+
		"\u0266\u0265\u0001\u0000\u0000\u0000\u0266\u0267\u0001\u0000\u0000\u0000"+
		"\u0267\u0268\u0001\u0000\u0000\u0000\u0268\u0269\u0005\u0005\u0000\u0000"+
		"\u0269\u026a\u0005\u0007\u0000\u0000\u026a\u026b\u0005\u0005\u0000\u0000"+
		"\u026b\u026f\u0005\r\u0000\u0000\u026c\u026e\u0003n7\u0000\u026d\u026c"+
		"\u0001\u0000\u0000\u0000\u026e\u0271\u0001\u0000\u0000\u0000\u026f\u026d"+
		"\u0001\u0000\u0000\u0000\u026f\u0270\u0001\u0000\u0000\u0000\u0270\u0272"+
		"\u0001\u0000\u0000\u0000\u0271\u026f\u0001\u0000\u0000\u0000\u0272\u027a"+
		"\u0005\u000e\u0000\u0000\u0273\u0275\u0005\u0006\u0000\u0000\u0274\u0273"+
		"\u0001\u0000\u0000\u0000\u0274\u0275\u0001\u0000\u0000\u0000\u0275\u0276"+
		"\u0001\u0000\u0000\u0000\u0276\u0277\u0005\u0005\u0000\u0000\u0277\u0278"+
		"\u0005\u0007\u0000\u0000\u0278\u027a\u0005\u0005\u0000\u0000\u0279\u0266"+
		"\u0001\u0000\u0000\u0000\u0279\u0274\u0001\u0000\u0000\u0000\u027a_\u0001"+
		"\u0000\u0000\u0000\u027b\u027d\u0005\u0004\u0000\u0000\u027c\u027e\u0005"+
		"\u0006\u0000\u0000\u027d\u027c\u0001\u0000\u0000\u0000\u027d\u027e\u0001"+
		"\u0000\u0000\u0000\u027e\u027f\u0001\u0000\u0000\u0000\u027f\u0280\u0005"+
		"\u0005\u0000\u0000\u0280\u0281\u0001\u0000\u0000\u0000\u0281\u0285\u0005"+
		"\r\u0000\u0000\u0282\u0284\u0003n7\u0000\u0283\u0282\u0001\u0000\u0000"+
		"\u0000\u0284\u0287\u0001\u0000\u0000\u0000\u0285\u0283\u0001\u0000\u0000"+
		"\u0000\u0285\u0286\u0001\u0000\u0000\u0000\u0286\u0288\u0001\u0000\u0000"+
		"\u0000\u0287\u0285\u0001\u0000\u0000\u0000\u0288\u0289\u0005\u000e\u0000"+
		"\u0000\u0289a\u0001\u0000\u0000\u0000\u028a\u028c\u0005\u0006\u0000\u0000"+
		"\u028b\u028a\u0001\u0000\u0000\u0000\u028b\u028c\u0001\u0000\u0000\u0000"+
		"\u028c\u028d\u0001\u0000\u0000\u0000\u028d\u028e\u0005\u0005\u0000\u0000"+
		"\u028e\u028f\u0005\u0007\u0000\u0000\u028f\u0290\u0005\b\u0000\u0000\u0290"+
		"c\u0001\u0000\u0000\u0000\u0291\u0293\u0005\u0006\u0000\u0000\u0292\u0291"+
		"\u0001\u0000\u0000\u0000\u0292\u0293\u0001\u0000\u0000\u0000\u0293\u0294"+
		"\u0001\u0000\u0000\u0000\u0294\u0295\u0005\u0005\u0000\u0000\u0295e\u0001"+
		"\u0000\u0000\u0000\u0296\u0297\u0005\u0005\u0000\u0000\u0297\u029b\u0005"+
		"\r\u0000\u0000\u0298\u029a\u0003n7\u0000\u0299\u0298\u0001\u0000\u0000"+
		"\u0000\u029a\u029d\u0001\u0000\u0000\u0000\u029b\u0299\u0001\u0000\u0000"+
		"\u0000\u029b\u029c\u0001\u0000\u0000\u0000\u029c\u029e\u0001\u0000\u0000"+
		"\u0000\u029d\u029b\u0001\u0000\u0000\u0000\u029e\u029f\u0005\u000e\u0000"+
		"\u0000\u029fg\u0001\u0000\u0000\u0000\u02a0\u02a1\u0005\u0001\u0000\u0000"+
		"\u02a1i\u0001\u0000\u0000\u0000\u02a2\u02a9\u0003p8\u0000\u02a3\u02a5"+
		"\u0007\b\u0000\u0000\u02a4\u02a3\u0001\u0000\u0000\u0000\u02a5\u02a6\u0001"+
		"\u0000\u0000\u0000\u02a6\u02a4\u0001\u0000\u0000\u0000\u02a6\u02a7\u0001"+
		"\u0000\u0000\u0000\u02a7\u02a9\u0001\u0000\u0000\u0000\u02a8\u02a2\u0001"+
		"\u0000\u0000\u0000\u02a8\u02a4\u0001\u0000\u0000\u0000\u02a9k\u0001\u0000"+
		"\u0000\u0000\u02aa\u02ac\u0005\r\u0000\u0000\u02ab\u02ad\u0003n7\u0000"+
		"\u02ac\u02ab\u0001\u0000\u0000\u0000\u02ad\u02ae\u0001\u0000\u0000\u0000"+
		"\u02ae\u02ac\u0001\u0000\u0000\u0000\u02ae\u02af\u0001\u0000\u0000\u0000"+
		"\u02af\u02b0\u0001\u0000\u0000\u0000\u02b0\u02b1\u0005\u000e\u0000\u0000"+
		"\u02b1m\u0001\u0000\u0000\u0000\u02b2\u02d4\u0003V+\u0000\u02b3\u02d4"+
		"\u0003f3\u0000\u02b4\u02d4\u0005\u0005\u0000\u0000\u02b5\u02d4\u0003d"+
		"2\u0000\u02b6\u02d4\u0005\u0002\u0000\u0000\u02b7\u02d4\u0005\u0006\u0000"+
		"\u0000\u02b8\u02d4\u0005\u008a\u0000\u0000\u02b9\u02d4\u0005\u0003\u0000"+
		"\u0000\u02ba\u02bc\u0005\u0001\u0000\u0000\u02bb\u02ba\u0001\u0000\u0000"+
		"\u0000\u02bc\u02bd\u0001\u0000\u0000\u0000\u02bd\u02bb\u0001\u0000\u0000"+
		"\u0000\u02bd\u02be\u0001\u0000\u0000\u0000\u02be\u02d4\u0001\u0000\u0000"+
		"\u0000\u02bf\u02d4\u0005\u0007\u0000\u0000\u02c0\u02d4\u0005\b\u0000\u0000"+
		"\u02c1\u02d4\u0005\t\u0000\u0000\u02c2\u02c6\u0005\u000f\u0000\u0000\u02c3"+
		"\u02c5\u0003n7\u0000\u02c4\u02c3\u0001\u0000\u0000\u0000\u02c5\u02c8\u0001"+
		"\u0000\u0000\u0000\u02c6\u02c4\u0001\u0000\u0000\u0000\u02c6\u02c7\u0001"+
		"\u0000\u0000\u0000\u02c7\u02c9\u0001\u0000\u0000\u0000\u02c8\u02c6\u0001"+
		"\u0000\u0000\u0000\u02c9\u02d4\u0005\u0094\u0000\u0000\u02ca\u02ce\u0005"+
		"\r\u0000\u0000\u02cb\u02cd\u0003n7\u0000\u02cc\u02cb\u0001\u0000\u0000"+
		"\u0000\u02cd\u02d0\u0001\u0000\u0000\u0000\u02ce\u02cc\u0001\u0000\u0000"+
		"\u0000\u02ce\u02cf\u0001\u0000\u0000\u0000\u02cf\u02d1\u0001\u0000\u0000"+
		"\u0000\u02d0\u02ce\u0001\u0000\u0000\u0000\u02d1\u02d4\u0005\u000e\u0000"+
		"\u0000\u02d2\u02d4\u0005\u0015\u0000\u0000\u02d3\u02b2\u0001\u0000\u0000"+
		"\u0000\u02d3\u02b3\u0001\u0000\u0000\u0000\u02d3\u02b4\u0001\u0000\u0000"+
		"\u0000\u02d3\u02b5\u0001\u0000\u0000\u0000\u02d3\u02b6\u0001\u0000\u0000"+
		"\u0000\u02d3\u02b7\u0001\u0000\u0000\u0000\u02d3\u02b8\u0001\u0000\u0000"+
		"\u0000\u02d3\u02b9\u0001\u0000\u0000\u0000\u02d3\u02bb\u0001\u0000\u0000"+
		"\u0000\u02d3\u02bf\u0001\u0000\u0000\u0000\u02d3\u02c0\u0001\u0000\u0000"+
		"\u0000\u02d3\u02c1\u0001\u0000\u0000\u0000\u02d3\u02c2\u0001\u0000\u0000"+
		"\u0000\u02d3\u02ca\u0001\u0000\u0000\u0000\u02d3\u02d2\u0001\u0000\u0000"+
		"\u0000\u02d4o\u0001\u0000\u0000\u0000\u02d5\u02d6\u0005\u0002\u0000\u0000"+
		"\u02d6\u02d7\u0005\u0091\u0000\u0000\u02d7\u02da\u0005\u0002\u0000\u0000"+
		"\u02d8\u02d9\u0005\u0092\u0000\u0000\u02d9\u02db\u0005\u0002\u0000\u0000"+
		"\u02da\u02d8\u0001\u0000\u0000\u0000\u02da\u02db\u0001\u0000\u0000\u0000"+
		"\u02dbq\u0001\u0000\u0000\u0000\u02dc\u02df\u0005\u000b\u0000\u0000\u02dd"+
		"\u02e0\u0005\u0011\u0000\u0000\u02de\u02e0\u0003|>\u0000\u02df\u02dd\u0001"+
		"\u0000\u0000\u0000\u02df\u02de\u0001\u0000\u0000\u0000\u02e0\u02e1\u0001"+
		"\u0000\u0000\u0000\u02e1\u02e2\u0005\f\u0000\u0000\u02e2s\u0001\u0000"+
		"\u0000\u0000\u02e3\u02e6\u0005\u000b\u0000\u0000\u02e4\u02e7\u0005\u0011"+
		"\u0000\u0000\u02e5\u02e7\u0003|>\u0000\u02e6\u02e4\u0001\u0000\u0000\u0000"+
		"\u02e6\u02e5\u0001\u0000\u0000\u0000\u02e7\u02e8\u0001\u0000\u0000\u0000"+
		"\u02e8\u02e9\u0005\u0013\u0000\u0000\u02e9\u02ea\u0003|>\u0000\u02ea\u02eb"+
		"\u0005\f\u0000\u0000\u02ebu\u0001\u0000\u0000\u0000\u02ec\u02ed\u0005"+
		"\u000b\u0000\u0000\u02ed\u02ee\u0003|>\u0000\u02ee\u02ef\u0005\u0013\u0000"+
		"\u0000\u02ef\u02f2\u0003|>\u0000\u02f0\u02f1\u0005\u0013\u0000\u0000\u02f1"+
		"\u02f3\u0003|>\u0000\u02f2\u02f0\u0001\u0000\u0000\u0000\u02f2\u02f3\u0001"+
		"\u0000\u0000\u0000\u02f3\u02f4\u0001\u0000\u0000\u0000\u02f4\u02f5\u0005"+
		"\f\u0000\u0000\u02f5w\u0001\u0000\u0000\u0000\u02f6\u02f7\u0005\u000b"+
		"\u0000\u0000\u02f7\u02fc\u0003|>\u0000\u02f8\u02f9\u0005\u0013\u0000\u0000"+
		"\u02f9\u02fb\u0003|>\u0000\u02fa\u02f8\u0001\u0000\u0000\u0000\u02fb\u02fe"+
		"\u0001\u0000\u0000\u0000\u02fc\u02fa\u0001\u0000\u0000\u0000\u02fc\u02fd"+
		"\u0001\u0000\u0000\u0000\u02fd\u02ff\u0001\u0000\u0000\u0000\u02fe\u02fc"+
		"\u0001\u0000\u0000\u0000\u02ff\u0300\u0005\f\u0000\u0000\u0300y\u0001"+
		"\u0000\u0000\u0000\u0301\u0302\u0005\u0011\u0000\u0000\u0302{\u0001\u0000"+
		"\u0000\u0000\u0303\u0305\u0003~?\u0000\u0304\u0303\u0001\u0000\u0000\u0000"+
		"\u0305\u0306\u0001\u0000\u0000\u0000\u0306\u0304\u0001\u0000\u0000\u0000"+
		"\u0306\u0307\u0001\u0000\u0000\u0000\u0307}\u0001\u0000\u0000\u0000\u0308"+
		"\u0313\u0003\u0080@\u0000\u0309\u0313\u0003\u0082A\u0000\u030a\u0313\u0005"+
		"\n\u0000\u0000\u030b\u0313\u0005\u0002\u0000\u0000\u030c\u0313\u0005\u0003"+
		"\u0000\u0000\u030d\u0313\u0005\u0096\u0000\u0000\u030e\u0313\u0005\u0011"+
		"\u0000\u0000\u030f\u0313\u0005\u0012\u0000\u0000\u0310\u0313\u0005\u0099"+
		"\u0000\u0000\u0311\u0313\u0005\u0014\u0000\u0000\u0312\u0308\u0001\u0000"+
		"\u0000\u0000\u0312\u0309\u0001\u0000\u0000\u0000\u0312\u030a\u0001\u0000"+
		"\u0000\u0000\u0312\u030b\u0001\u0000\u0000\u0000\u0312\u030c\u0001\u0000"+
		"\u0000\u0000\u0312\u030d\u0001\u0000\u0000\u0000\u0312\u030e\u0001\u0000"+
		"\u0000\u0000\u0312\u030f\u0001\u0000\u0000\u0000\u0312\u0310\u0001\u0000"+
		"\u0000\u0000\u0312\u0311\u0001\u0000\u0000\u0000\u0313\u007f\u0001\u0000"+
		"\u0000\u0000\u0314\u0315\u0005\u000f\u0000\u0000\u0315\u031a\u0003\u0084"+
		"B\u0000\u0316\u0317\u0005\u0014\u0000\u0000\u0317\u0319\u0003\u0084B\u0000"+
		"\u0318\u0316\u0001\u0000\u0000\u0000\u0319\u031c\u0001\u0000\u0000\u0000"+
		"\u031a\u0318\u0001\u0000\u0000\u0000\u031a\u031b\u0001\u0000\u0000\u0000"+
		"\u031b\u031e\u0001\u0000\u0000\u0000\u031c\u031a\u0001\u0000\u0000\u0000"+
		"\u031d\u031f\u0005\u0014\u0000\u0000\u031e\u031d\u0001\u0000\u0000\u0000"+
		"\u031e\u031f\u0001\u0000\u0000\u0000\u031f\u0320\u0001\u0000\u0000\u0000"+
		"\u0320\u0321\u0005\u0094\u0000\u0000\u0321\u0081\u0001\u0000\u0000\u0000"+
		"\u0322\u0324\u0005\u000f\u0000\u0000\u0323\u0325\u0003~?\u0000\u0324\u0323"+
		"\u0001\u0000\u0000\u0000\u0325\u0326\u0001\u0000\u0000\u0000\u0326\u0324"+
		"\u0001\u0000\u0000\u0000\u0326\u0327\u0001\u0000\u0000\u0000\u0327\u0328"+
		"\u0001\u0000\u0000\u0000\u0328\u0329\u0005\u0094\u0000\u0000\u0329\u032d"+
		"\u0001\u0000\u0000\u0000\u032a\u032b\u0005\u000f\u0000\u0000\u032b\u032d"+
		"\u0005\u0094\u0000\u0000\u032c\u0322\u0001\u0000\u0000\u0000\u032c\u032a"+
		"\u0001\u0000\u0000\u0000\u032d\u0083\u0001\u0000\u0000\u0000\u032e\u032f"+
		"\u0005\u0011\u0000\u0000\u032f\u0330\u0005\u0012\u0000\u0000\u0330\u0331"+
		"\u0007\t\u0000\u0000\u0331\u0085\u0001\u0000\u0000\u0000\u0332\u0333\u0005"+
		"j\u0000\u0000\u0333\u0334\u0005k\u0000\u0000\u0334\u0087\u0001\u0000\u0000"+
		"\u0000\u0335\u0337\u0007\n\u0000\u0000\u0336\u0338\u0003h4\u0000\u0337"+
		"\u0336\u0001\u0000\u0000\u0000\u0337\u0338\u0001\u0000\u0000\u0000\u0338"+
		"\u0089\u0001\u0000\u0000\u0000\u0339\u033b\u0005\u0017\u0000\u0000\u033a"+
		"\u0339\u0001\u0000\u0000\u0000\u033b\u033c\u0001\u0000\u0000\u0000\u033c"+
		"\u033a\u0001\u0000\u0000\u0000\u033c\u033d\u0001\u0000\u0000\u0000\u033d"+
		"\u0343\u0001\u0000\u0000\u0000\u033e\u0343\u0005u\u0000\u0000\u033f\u0343"+
		"\u0005w\u0000\u0000\u0340\u0343\u0005}\u0000\u0000\u0341\u0343\u0005|"+
		"\u0000\u0000\u0342\u033a\u0001\u0000\u0000\u0000\u0342\u033e\u0001\u0000"+
		"\u0000\u0000\u0342\u033f\u0001\u0000\u0000\u0000\u0342\u0340\u0001\u0000"+
		"\u0000\u0000\u0342\u0341\u0001\u0000\u0000\u0000\u0343\u008b\u0001\u0000"+
		"\u0000\u0000T\u008f\u0095\u009c\u00b9\u00d1\u00d7\u00db\u00de\u00e9\u00eb"+
		"\u00f5\u00ff\u0109\u0113\u011d\u0127\u012f\u0134\u0138\u0140\u0154\u015a"+
		"\u0169\u0173\u0177\u017e\u0187\u0189\u0192\u019c\u01a8\u01b3\u01b5\u01bf"+
		"\u01cd\u01d1\u01d7\u01d9\u01e3\u01ed\u01f1\u01f9\u0202\u0204\u020c\u0219"+
		"\u0221\u0227\u022d\u0235\u023e\u024b\u025c\u0263\u0266\u026f\u0274\u0279"+
		"\u027d\u0285\u028b\u0292\u029b\u02a6\u02a8\u02ae\u02bd\u02c6\u02ce\u02d3"+
		"\u02da\u02df\u02e6\u02f2\u02fc\u0306\u0312\u031a\u031e\u0326\u032c\u0337"+
		"\u033c\u0342";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}