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
		D_ONCE=65, D_ENDONCE=66, D_STACK=67, D_PUSH=68, D_ENDPUSH=69, D_PUSH_ONCE=70, 
		D_ENDPUSH_ONCE=71, D_PROPS=72, D_LANG=73, D_CSRF=74, D_METHOD=75, D_ERROR=76, 
		D_ENDERROR=77, D_PRODUCTION=78, D_ENDPRODUCTION=79, D_ENV=80, D_ENDENV=81, 
		D_AUTH_START=82, D_AUTH_END=83, D_CLASS=84, D_STYLE=85, D_HTML_ATTR_EXPR=86, 
		D_AWARE=87, D_JSON=88, D_DD=89, D_USE=90, D_INJECT=91, D_PHP=92, D_VERBATIM=93, 
		D_ENDVERBATIM=94, D_CUSTOM=95, CONTENT_TAG_OPEN=96, RAW_TAG_OPEN=97, PHP_INLINE_START=98, 
		BLADE_COMMENT_START=99, CONTENT_TAG_CLOSE=100, RAW_TAG_CLOSE=101, WS_EXPR=102, 
		WS_COMPOSED_EXPR=103, EXPR_STRING=104, COMPOSED_EXPR_RPAREN=105, WS_BL_PARAM=106, 
		FOREACH_WS_EXPR=107, FOREACH_LOOP_LPAREN=108, FOREACH_LOOP_RPAREN=109, 
		FOREACH_AS=110, FOREACH_PARAM_ASSIGN=111, BL_PARAM_LINE_COMMENT=112, BL_SQ_RPAREN=113, 
		BL_PARAM_RPAREN=114, BL_PARAM_CONCAT_OPERATOR=115, BL_COMMA_EL=116, BL_PARAM_WS=117, 
		BL_NAME_STRING=118, D_ENDPHP=119, PHP_EXIT=120, BLADE_COMMENT_END=121, 
		AT=122, RAW_TAG_START=123, REGULAR_ECHO_STATIC_ACCESS=124, REGULAR_ECHO_LPAREN=125, 
		REGULAR_ECHO_RPAREN=126, PHP_D_EXPR_CURLY_LPAREN=127, PHP_D_EXPR_CURLY_RPAREN=128, 
		PHP_D_CLASS=129, PHP_D_WS=130, PHP_COMPOSED_EXPR_INSTANCE_ACCESS=131;
	public static final int
		RULE_file = 0, RULE_general_statement = 1, RULE_inline_statement = 2, 
		RULE_inline_directive = 3, RULE_block_statement = 4, RULE_non_blade_statement = 5, 
		RULE_extends = 6, RULE_section_inline = 7, RULE_section = 8, RULE_push = 9, 
		RULE_pushOnce = 10, RULE_if = 11, RULE_elseif = 12, RULE_else = 13, RULE_endif = 14, 
		RULE_conditional_block = 15, RULE_auth_block = 16, RULE_switch = 17, RULE_while = 18, 
		RULE_for = 19, RULE_foreach = 20, RULE_forelse = 21, RULE_yieldD = 22, 
		RULE_stack = 23, RULE_useD = 24, RULE_include = 25, RULE_includeIf = 26, 
		RULE_includeCond = 27, RULE_includeFirst = 28, RULE_each = 29, RULE_hasSection = 30, 
		RULE_sectionMissing = 31, RULE_custom_directive = 32, RULE_php_blade = 33, 
		RULE_phpInline = 34, RULE_regular_echo = 35, RULE_raw_echo = 36, RULE_echo_expr = 37, 
		RULE_class_expr_usage = 38, RULE_class_alias_static_access = 39, RULE_static_direct_class_access = 40, 
		RULE_class_instance = 41, RULE_class_name_reference = 42, RULE_class_identifier = 43, 
		RULE_namespacePath = 44, RULE_method_call = 45, RULE_function_call = 46, 
		RULE_php_expression = 47, RULE_loop_expression = 48, RULE_main_php_expression = 49, 
		RULE_composed_php_expression = 50, RULE_simple_foreach_expr = 51, RULE_singleArgWrapper = 52, 
		RULE_singleArgAndDefaultWrapper = 53, RULE_doubleArgWrapper = 54, RULE_multiArgWrapper = 55, 
		RULE_identifiableArgument = 56, RULE_composedArgument = 57, RULE_phpExpr = 58, 
		RULE_identifiableArray = 59, RULE_arrayDefine = 60, RULE_paramAssign = 61, 
		RULE_verbatim_block = 62, RULE_loop_action = 63, RULE_html = 64;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "general_statement", "inline_statement", "inline_directive", 
			"block_statement", "non_blade_statement", "extends", "section_inline", 
			"section", "push", "pushOnce", "if", "elseif", "else", "endif", "conditional_block", 
			"auth_block", "switch", "while", "for", "foreach", "forelse", "yieldD", 
			"stack", "useD", "include", "includeIf", "includeCond", "includeFirst", 
			"each", "hasSection", "sectionMissing", "custom_directive", "php_blade", 
			"phpInline", "regular_echo", "raw_echo", "echo_expr", "class_expr_usage", 
			"class_alias_static_access", "static_direct_class_access", "class_instance", 
			"class_name_reference", "class_identifier", "namespacePath", "method_call", 
			"function_call", "php_expression", "loop_expression", "main_php_expression", 
			"composed_php_expression", "simple_foreach_expr", "singleArgWrapper", 
			"singleArgAndDefaultWrapper", "doubleArgWrapper", "multiArgWrapper", 
			"identifiableArgument", "composedArgument", "phpExpr", "identifiableArray", 
			"arrayDefine", "paramAssign", "verbatim_block", "loop_action", "html"
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
			"'@stop'", "'@once'", "'@endonce'", "'@stack'", "'@push'", "'@endpush'", 
			"'@pushOnce'", "'@endPushOnce'", "'@props'", "'@lang'", "'@csrf'", "'@method'", 
			"'@error'", "'@enderror'", "'@production'", "'@endproduction'", "'@env'", 
			"'@endenv'", null, null, "'@class'", "'@style'", null, "'@aware'", "'@json'", 
			"'@dd'", "'@use'", "'@inject'", null, "'@verbatim'", "'@endverbatim'", 
			null, "'{{'", "'{!!'", null, "'{{--'", null, null, null, null, null, 
			null, null, null, null, null, "'as'", null, null, null, null, "'.'", 
			"','", null, null, "'@endphp'", "'?>'", "'--}}'", null, "'{!'", null, 
			null, null, null, null, "'class'", "' '", "'->'"
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
			"D_PARENT", "D_SHOW", "D_OVERWRITE", "D_STOP", "D_ONCE", "D_ENDONCE", 
			"D_STACK", "D_PUSH", "D_ENDPUSH", "D_PUSH_ONCE", "D_ENDPUSH_ONCE", "D_PROPS", 
			"D_LANG", "D_CSRF", "D_METHOD", "D_ERROR", "D_ENDERROR", "D_PRODUCTION", 
			"D_ENDPRODUCTION", "D_ENV", "D_ENDENV", "D_AUTH_START", "D_AUTH_END", 
			"D_CLASS", "D_STYLE", "D_HTML_ATTR_EXPR", "D_AWARE", "D_JSON", "D_DD", 
			"D_USE", "D_INJECT", "D_PHP", "D_VERBATIM", "D_ENDVERBATIM", "D_CUSTOM", 
			"CONTENT_TAG_OPEN", "RAW_TAG_OPEN", "PHP_INLINE_START", "BLADE_COMMENT_START", 
			"CONTENT_TAG_CLOSE", "RAW_TAG_CLOSE", "WS_EXPR", "WS_COMPOSED_EXPR", 
			"EXPR_STRING", "COMPOSED_EXPR_RPAREN", "WS_BL_PARAM", "FOREACH_WS_EXPR", 
			"FOREACH_LOOP_LPAREN", "FOREACH_LOOP_RPAREN", "FOREACH_AS", "FOREACH_PARAM_ASSIGN", 
			"BL_PARAM_LINE_COMMENT", "BL_SQ_RPAREN", "BL_PARAM_RPAREN", "BL_PARAM_CONCAT_OPERATOR", 
			"BL_COMMA_EL", "BL_PARAM_WS", "BL_NAME_STRING", "D_ENDPHP", "PHP_EXIT", 
			"BLADE_COMMENT_END", "AT", "RAW_TAG_START", "REGULAR_ECHO_STATIC_ACCESS", 
			"REGULAR_ECHO_LPAREN", "REGULAR_ECHO_RPAREN", "PHP_D_EXPR_CURLY_LPAREN", 
			"PHP_D_EXPR_CURLY_RPAREN", "PHP_D_CLASS", "PHP_D_WS", "PHP_COMPOSED_EXPR_INSTANCE_ACCESS"
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
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0)) {
				{
				{
				setState(130);
				general_statement();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
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
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				inline_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				block_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
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
			setState(155);
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
			case D_SECTION:
			case D_YIELD:
			case D_STACK:
			case D_PROPS:
			case D_LANG:
			case D_CSRF:
			case D_METHOD:
			case D_CLASS:
			case D_STYLE:
			case D_HTML_ATTR_EXPR:
			case D_USE:
			case D_INJECT:
			case D_CUSTOM:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				inline_directive();
				}
				break;
			case CONTENT_TAG_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				regular_echo();
				}
				break;
			case RAW_TAG_OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				raw_echo();
				}
				break;
			case PHP_INLINE_START:
				enterOuterAlt(_localctx, 4);
				{
				setState(146);
				phpInline();
				}
				break;
			case BLADE_COMMENT_START:
				enterOuterAlt(_localctx, 5);
				{
				setState(147);
				match(BLADE_COMMENT_START);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BLADE_COMMENT) {
					{
					{
					setState(148);
					match(BLADE_COMMENT);
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(154);
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
		public TerminalNode D_CSRF() { return getToken(BladeAntlrParser.D_CSRF, 0); }
		public UseDContext useD() {
			return getRuleContext(UseDContext.class,0);
		}
		public TerminalNode D_INJECT() { return getToken(BladeAntlrParser.D_INJECT, 0); }
		public DoubleArgWrapperContext doubleArgWrapper() {
			return getRuleContext(DoubleArgWrapperContext.class,0);
		}
		public TerminalNode D_HTML_ATTR_EXPR() { return getToken(BladeAntlrParser.D_HTML_ATTR_EXPR, 0); }
		public TerminalNode D_CASE() { return getToken(BladeAntlrParser.D_CASE, 0); }
		public TerminalNode D_DEFAULT() { return getToken(BladeAntlrParser.D_DEFAULT, 0); }
		public Loop_actionContext loop_action() {
			return getRuleContext(Loop_actionContext.class,0);
		}
		public TerminalNode D_LANG() { return getToken(BladeAntlrParser.D_LANG, 0); }
		public SingleArgAndDefaultWrapperContext singleArgAndDefaultWrapper() {
			return getRuleContext(SingleArgAndDefaultWrapperContext.class,0);
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
			switch (_input.LA(1)) {
			case D_EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				extends_();
				}
				break;
			case D_SECTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				section_inline();
				}
				break;
			case D_YIELD:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				yieldD();
				}
				break;
			case D_STACK:
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				stack();
				}
				break;
			case D_INCLUDE:
				enterOuterAlt(_localctx, 5);
				{
				setState(161);
				include();
				}
				break;
			case D_INCLUDE_IF:
				enterOuterAlt(_localctx, 6);
				{
				setState(162);
				includeIf();
				}
				break;
			case D_INCLUDE_WHEN:
			case D_INCLUDE_UNLESS:
				enterOuterAlt(_localctx, 7);
				{
				setState(163);
				includeCond();
				}
				break;
			case D_INCLUDE_FIRST:
				enterOuterAlt(_localctx, 8);
				{
				setState(164);
				includeFirst();
				}
				break;
			case D_EACH:
				enterOuterAlt(_localctx, 9);
				{
				setState(165);
				each();
				}
				break;
			case D_CLASS:
			case D_STYLE:
				enterOuterAlt(_localctx, 10);
				{
				setState(166);
				_la = _input.LA(1);
				if ( !(_la==D_CLASS || _la==D_STYLE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(167);
				composed_php_expression();
				}
				break;
			case D_METHOD:
				enterOuterAlt(_localctx, 11);
				{
				{
				setState(168);
				match(D_METHOD);
				}
				setState(169);
				composed_php_expression();
				}
				break;
			case D_PROPS:
				enterOuterAlt(_localctx, 12);
				{
				setState(170);
				match(D_PROPS);
				setState(171);
				composed_php_expression();
				}
				break;
			case D_CSRF:
				enterOuterAlt(_localctx, 13);
				{
				setState(172);
				match(D_CSRF);
				}
				break;
			case D_USE:
				enterOuterAlt(_localctx, 14);
				{
				setState(173);
				useD();
				}
				break;
			case D_INJECT:
				enterOuterAlt(_localctx, 15);
				{
				setState(174);
				match(D_INJECT);
				setState(175);
				doubleArgWrapper();
				}
				break;
			case D_HTML_ATTR_EXPR:
				enterOuterAlt(_localctx, 16);
				{
				setState(176);
				match(D_HTML_ATTR_EXPR);
				setState(177);
				composed_php_expression();
				}
				break;
			case D_CASE:
				enterOuterAlt(_localctx, 17);
				{
				setState(178);
				match(D_CASE);
				setState(179);
				composed_php_expression();
				}
				break;
			case D_DEFAULT:
				enterOuterAlt(_localctx, 18);
				{
				setState(180);
				match(D_DEFAULT);
				}
				break;
			case D_BREAK:
			case D_LOOP_ACTION:
				enterOuterAlt(_localctx, 19);
				{
				setState(181);
				loop_action();
				}
				break;
			case D_LANG:
				enterOuterAlt(_localctx, 20);
				{
				setState(182);
				match(D_LANG);
				setState(183);
				singleArgAndDefaultWrapper();
				}
				break;
			case D_CUSTOM:
				enterOuterAlt(_localctx, 21);
				{
				setState(184);
				custom_directive();
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
		public TerminalNode D_ONCE() { return getToken(BladeAntlrParser.D_ONCE, 0); }
		public TerminalNode D_ENDONCE() { return getToken(BladeAntlrParser.D_ENDONCE, 0); }
		public List<General_statementContext> general_statement() {
			return getRuleContexts(General_statementContext.class);
		}
		public General_statementContext general_statement(int i) {
			return getRuleContext(General_statementContext.class,i);
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
		public TerminalNode D_ENV() { return getToken(BladeAntlrParser.D_ENV, 0); }
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
		}
		public TerminalNode D_ENDENV() { return getToken(BladeAntlrParser.D_ENDENV, 0); }
		public TerminalNode D_PRODUCTION() { return getToken(BladeAntlrParser.D_PRODUCTION, 0); }
		public TerminalNode D_ENDPRODUCTION() { return getToken(BladeAntlrParser.D_ENDPRODUCTION, 0); }
		public TerminalNode D_EMPTY() { return getToken(BladeAntlrParser.D_EMPTY, 0); }
		public Main_php_expressionContext main_php_expression() {
			return getRuleContext(Main_php_expressionContext.class,0);
		}
		public TerminalNode D_ENDEMPTY() { return getToken(BladeAntlrParser.D_ENDEMPTY, 0); }
		public TerminalNode D_ERROR() { return getToken(BladeAntlrParser.D_ERROR, 0); }
		public Php_expressionContext php_expression() {
			return getRuleContext(Php_expressionContext.class,0);
		}
		public TerminalNode D_ENDERROR() { return getToken(BladeAntlrParser.D_ENDERROR, 0); }
		public Conditional_blockContext conditional_block() {
			return getRuleContext(Conditional_blockContext.class,0);
		}
		public Auth_blockContext auth_block() {
			return getRuleContext(Auth_blockContext.class,0);
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
		int _la;
		try {
			setState(246);
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
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				hasSection();
				}
				break;
			case D_SECTION_MISSING:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				sectionMissing();
				}
				break;
			case D_PUSH:
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
				push();
				}
				break;
			case D_ONCE:
				enterOuterAlt(_localctx, 5);
				{
				setState(191);
				match(D_ONCE);
				setState(193); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(192);
					general_statement();
					}
					}
					setState(195); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
				setState(197);
				match(D_ENDONCE);
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 6);
				{
				setState(199);
				if_();
				}
				break;
			case D_ELSEIF:
				enterOuterAlt(_localctx, 7);
				{
				setState(200);
				elseif();
				}
				break;
			case D_ELSE:
				enterOuterAlt(_localctx, 8);
				{
				setState(201);
				else_();
				}
				break;
			case D_SWITCH:
				enterOuterAlt(_localctx, 9);
				{
				setState(202);
				switch_();
				}
				break;
			case D_ENV:
				enterOuterAlt(_localctx, 10);
				{
				setState(203);
				match(D_ENV);
				setState(204);
				singleArgWrapper();
				setState(206); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(205);
					general_statement();
					}
					}
					setState(208); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
				setState(210);
				match(D_ENDENV);
				}
				break;
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 11);
				{
				setState(212);
				match(D_PRODUCTION);
				setState(214); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(213);
					general_statement();
					}
					}
					setState(216); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
				setState(218);
				match(D_ENDPRODUCTION);
				}
				break;
			case D_EMPTY:
				enterOuterAlt(_localctx, 12);
				{
				setState(220);
				match(D_EMPTY);
				setState(221);
				main_php_expression();
				setState(223); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(222);
					general_statement();
					}
					}
					setState(225); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
				setState(227);
				match(D_ENDEMPTY);
				}
				break;
			case D_ERROR:
				enterOuterAlt(_localctx, 13);
				{
				setState(229);
				match(D_ERROR);
				setState(230);
				php_expression();
				setState(232); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(231);
					general_statement();
					}
					}
					setState(234); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
				setState(236);
				match(D_ENDERROR);
				}
				break;
			case D_COND_BLOCK_START:
				enterOuterAlt(_localctx, 14);
				{
				setState(238);
				conditional_block();
				}
				break;
			case D_AUTH_START:
				enterOuterAlt(_localctx, 15);
				{
				setState(239);
				auth_block();
				}
				break;
			case D_WHILE:
				enterOuterAlt(_localctx, 16);
				{
				setState(240);
				while_();
				}
				break;
			case D_FOR:
				enterOuterAlt(_localctx, 17);
				{
				setState(241);
				for_();
				}
				break;
			case D_FOREACH:
				enterOuterAlt(_localctx, 18);
				{
				setState(242);
				foreach();
				}
				break;
			case D_FORELSE:
				enterOuterAlt(_localctx, 19);
				{
				setState(243);
				forelse();
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 20);
				{
				setState(244);
				verbatim_block();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 21);
				{
				setState(245);
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
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				html();
				}
				break;
			case PHP_INLINE_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
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
			setState(252);
			match(D_EXTENDS);
			setState(253);
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
			setState(255);
			match(D_SECTION);
			setState(256);
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
			setState(258);
			match(D_SECTION);
			setState(259);
			singleArgWrapper();
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3999149558884990976L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0)) {
				{
				setState(262);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case HTML:
				case D_IF:
				case D_ELSEIF:
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
				case D_SECTION:
				case D_HAS_SECTION:
				case D_SECTION_MISSING:
				case D_YIELD:
				case D_ONCE:
				case D_STACK:
				case D_PUSH:
				case D_PROPS:
				case D_LANG:
				case D_CSRF:
				case D_METHOD:
				case D_ERROR:
				case D_PRODUCTION:
				case D_ENV:
				case D_AUTH_START:
				case D_CLASS:
				case D_STYLE:
				case D_HTML_ATTR_EXPR:
				case D_USE:
				case D_INJECT:
				case D_PHP:
				case D_VERBATIM:
				case D_CUSTOM:
				case CONTENT_TAG_OPEN:
				case RAW_TAG_OPEN:
				case PHP_INLINE_START:
				case BLADE_COMMENT_START:
					{
					setState(260);
					general_statement();
					}
					break;
				case D_PARENT:
					{
					setState(261);
					match(D_PARENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(267);
			_la = _input.LA(1);
			if ( !(((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & 57L) != 0)) ) {
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
			setState(269);
			match(D_PUSH);
			setState(270);
			singleArgWrapper();
			setState(272); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(271);
				general_statement();
				}
				}
				setState(274); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
			setState(276);
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
			setState(278);
			match(D_PUSH_ONCE);
			setState(279);
			singleArgWrapper();
			setState(281); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(280);
				general_statement();
				}
				}
				setState(283); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
			setState(285);
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
		enterRule(_localctx, 22, RULE_if);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(D_IF);
			setState(288);
			main_php_expression();
			setState(290); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(289);
					general_statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(292); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(294);
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
		enterRule(_localctx, 24, RULE_elseif);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(D_ELSEIF);
			setState(298);
			main_php_expression();
			setState(300); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(299);
					general_statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(302); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(304);
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
		enterRule(_localctx, 26, RULE_else);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(D_ELSE);
			setState(309); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(308);
					general_statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(311); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(313);
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
		enterRule(_localctx, 28, RULE_endif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
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
		enterRule(_localctx, 30, RULE_conditional_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(D_COND_BLOCK_START);
			setState(319);
			main_php_expression();
			setState(321); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(320);
				general_statement();
				}
				}
				setState(323); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
			setState(325);
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
		public List<SingleArgWrapperContext> singleArgWrapper() {
			return getRuleContexts(SingleArgWrapperContext.class);
		}
		public SingleArgWrapperContext singleArgWrapper(int i) {
			return getRuleContext(SingleArgWrapperContext.class,i);
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
		enterRule(_localctx, 32, RULE_auth_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(D_AUTH_START);
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BLADE_PARAM_LPAREN) {
				{
				{
				setState(328);
				singleArgWrapper();
				}
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(335); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(334);
				general_statement();
				}
				}
				setState(337); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
			setState(339);
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
		enterRule(_localctx, 34, RULE_switch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(D_SWITCH);
			setState(342);
			php_expression();
			setState(345); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(345);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(343);
					general_statement();
					}
					break;
				case 2:
					{
					setState(344);
					match(D_BREAK);
					}
					break;
				}
				}
				setState(347); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
			setState(349);
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
		enterRule(_localctx, 36, RULE_while);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			match(D_WHILE);
			setState(352);
			php_expression();
			setState(354); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(353);
				general_statement();
				}
				}
				setState(356); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
			setState(358);
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
		enterRule(_localctx, 38, RULE_for);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(D_FOR);
			setState(361);
			php_expression();
			setState(363); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(362);
				general_statement();
				}
				}
				setState(365); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
			setState(367);
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
		enterRule(_localctx, 40, RULE_foreach);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(D_FOREACH);
			setState(370);
			match(FOREACH_LOOP_LPAREN);
			setState(371);
			loop_expression();
			setState(372);
			match(FOREACH_LOOP_RPAREN);
			setState(374); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(373);
				general_statement();
				}
				}
				setState(376); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
			setState(378);
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
		enterRule(_localctx, 42, RULE_forelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(D_FORELSE);
			setState(381);
			match(FOREACH_LOOP_LPAREN);
			setState(382);
			loop_expression();
			setState(383);
			match(FOREACH_LOOP_RPAREN);
			setState(386); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(386);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(384);
					general_statement();
					}
					break;
				case 2:
					{
					setState(385);
					match(D_EMPTY);
					}
					break;
				}
				}
				setState(388); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0) );
			setState(390);
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
		enterRule(_localctx, 44, RULE_yieldD);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(D_YIELD);
			setState(393);
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
		enterRule(_localctx, 46, RULE_stack);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(D_STACK);
			setState(396);
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
		public SingleArgWrapperContext singleArgWrapper() {
			return getRuleContext(SingleArgWrapperContext.class,0);
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
		enterRule(_localctx, 48, RULE_useD);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			match(D_USE);
			setState(399);
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
		enterRule(_localctx, 50, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(D_INCLUDE);
			setState(402);
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
		enterRule(_localctx, 52, RULE_includeIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			match(D_INCLUDE_IF);
			setState(405);
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
		enterRule(_localctx, 54, RULE_includeCond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			_la = _input.LA(1);
			if ( !(_la==D_INCLUDE_WHEN || _la==D_INCLUDE_UNLESS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(408);
			match(BLADE_PARAM_LPAREN);
			setState(409);
			composedArgument();
			setState(410);
			match(BL_COMMA);
			setState(413);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(411);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(412);
				composedArgument();
				}
				break;
			}
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(415);
				match(BL_COMMA);
				setState(416);
				composedArgument();
				}
			}

			setState(419);
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
		enterRule(_localctx, 56, RULE_includeFirst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(D_INCLUDE_FIRST);
			setState(422);
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
		enterRule(_localctx, 58, RULE_each);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			match(D_EACH);
			setState(425);
			match(BLADE_PARAM_LPAREN);
			setState(428);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(426);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(427);
				composedArgument();
				}
				break;
			}
			setState(430);
			match(BL_COMMA);
			setState(431);
			composedArgument();
			setState(432);
			match(BL_COMMA);
			setState(433);
			composedArgument();
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(434);
				match(BL_COMMA);
				setState(437);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(435);
					identifiableArgument();
					}
					break;
				case 2:
					{
					setState(436);
					composedArgument();
					}
					break;
				}
				}
			}

			setState(441);
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
		enterRule(_localctx, 60, RULE_hasSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(D_HAS_SECTION);
			setState(444);
			singleArgWrapper();
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0)) {
				{
				{
				setState(445);
				general_statement();
				}
				}
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(451);
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
		enterRule(_localctx, 62, RULE_sectionMissing);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(D_SECTION_MISSING);
			setState(454);
			singleArgWrapper();
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1693306549671297024L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 33793159053L) != 0)) {
				{
				{
				setState(455);
				general_statement();
				}
				}
				setState(460);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(461);
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
		enterRule(_localctx, 64, RULE_custom_directive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(D_CUSTOM);
			setState(467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(464);
				multiArgWrapper();
				}
				break;
			case 2:
				{
				{
				setState(465);
				match(BLADE_PARAM_LPAREN);
				setState(466);
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
		enterRule(_localctx, 66, RULE_php_blade);
		int _la;
		try {
			setState(479);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				match(D_PHP);
				setState(471); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(470);
					composed_php_expression();
					}
					}
					setState(473); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0) || _la==EXPR_STRING );
				setState(475);
				match(D_ENDPHP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(477);
				match(D_PHP);
				setState(478);
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
		enterRule(_localctx, 68, RULE_phpInline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			match(PHP_INLINE_START);
			setState(483); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(482);
				composed_php_expression();
				}
				}
				setState(485); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0) || _la==EXPR_STRING );
			setState(487);
			match(PHP_EXIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		enterRule(_localctx, 70, RULE_regular_echo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			match(CONTENT_TAG_OPEN);
			setState(493);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0) || _la==EXPR_STRING) {
				{
				{
				setState(490);
				echo_expr();
				}
				}
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(496);
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
		enterRule(_localctx, 72, RULE_raw_echo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			match(RAW_TAG_OPEN);
			setState(502);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0) || _la==EXPR_STRING) {
				{
				{
				setState(499);
				echo_expr();
				}
				}
				setState(504);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(505);
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
		enterRule(_localctx, 74, RULE_echo_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
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
		enterRule(_localctx, 76, RULE_class_expr_usage);
		try {
			setState(513);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(509);
				class_name_reference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(510);
				class_alias_static_access();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(511);
				static_direct_class_access();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(512);
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
		enterRule(_localctx, 78, RULE_class_alias_static_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			((Class_alias_static_accessContext)_localctx).class_name = match(PHP_VARIABLE);
			setState(516);
			match(PHP_STATIC_ACCESS);
			setState(517);
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
		enterRule(_localctx, 80, RULE_static_direct_class_access);
		try {
			setState(527);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(519);
				class_identifier();
				setState(520);
				match(PHP_STATIC_ACCESS);
				setState(521);
				method_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(523);
				class_identifier();
				setState(524);
				match(PHP_STATIC_ACCESS);
				setState(525);
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
		public Class_identifierContext class_identifier() {
			return getRuleContext(Class_identifierContext.class,0);
		}
		public TerminalNode BLADE_EXPR_LPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_LPAREN, 0); }
		public TerminalNode BLADE_EXPR_RPAREN() { return getToken(BladeAntlrParser.BLADE_EXPR_RPAREN, 0); }
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
		enterRule(_localctx, 82, RULE_class_instance);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			match(PHP_NEW);
			setState(531); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(530);
				match(PHP_WS);
				}
				}
				setState(533); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PHP_WS );
			setState(535);
			class_identifier();
			setState(536);
			match(BLADE_EXPR_LPAREN);
			setState(540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0) || _la==EXPR_STRING) {
				{
				{
				setState(537);
				composed_php_expression();
				}
				}
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(543);
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
		enterRule(_localctx, 84, RULE_class_name_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			class_identifier();
			setState(546);
			match(PHP_STATIC_ACCESS);
			setState(547);
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
		enterRule(_localctx, 86, RULE_class_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHP_NAMESPACE_PATH) {
				{
				setState(549);
				((Class_identifierContext)_localctx).namespace = match(PHP_NAMESPACE_PATH);
				}
			}

			setState(552);
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
		enterRule(_localctx, 88, RULE_namespacePath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHP_NAMESPACE_PATH) {
				{
				setState(554);
				((NamespacePathContext)_localctx).namespace = match(PHP_NAMESPACE_PATH);
				}
			}

			setState(557);
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
		enterRule(_localctx, 90, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			((Method_callContext)_localctx).func_name = match(PHP_IDENTIFIER);
			setState(560);
			match(BLADE_EXPR_LPAREN);
			setState(564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0) || _la==EXPR_STRING) {
				{
				{
				setState(561);
				composed_php_expression();
				}
				}
				setState(566);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(567);
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
		enterRule(_localctx, 92, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
			((Function_callContext)_localctx).func_name = match(PHP_IDENTIFIER);
			setState(570);
			match(BLADE_EXPR_LPAREN);
			setState(574);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0) || _la==EXPR_STRING) {
				{
				{
				setState(571);
				composed_php_expression();
				}
				}
				setState(576);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(577);
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
		enterRule(_localctx, 94, RULE_php_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
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
		enterRule(_localctx, 96, RULE_loop_expression);
		int _la;
		try {
			int _alt;
			setState(587);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(581);
				simple_foreach_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(583); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(582);
						_la = _input.LA(1);
						if ( !(_la==PHP_EXPRESSION || _la==PHP_VARIABLE || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 15L) != 0)) ) {
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
					setState(585); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
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
		enterRule(_localctx, 98, RULE_main_php_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(BLADE_EXPR_LPAREN);
			setState(591); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(590);
				composed_php_expression();
				}
				}
				setState(593); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0) || _la==EXPR_STRING );
			setState(595);
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
		public NamespacePathContext namespacePath() {
			return getRuleContext(NamespacePathContext.class,0);
		}
		public TerminalNode PHP_VARIABLE() { return getToken(BladeAntlrParser.PHP_VARIABLE, 0); }
		public TerminalNode PHP_NAMESPACE_PATH() { return getToken(BladeAntlrParser.PHP_NAMESPACE_PATH, 0); }
		public TerminalNode PHP_IDENTIFIER() { return getToken(BladeAntlrParser.PHP_IDENTIFIER, 0); }
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
		enterRule(_localctx, 100, RULE_composed_php_expression);
		int _la;
		try {
			int _alt;
			setState(623);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(597);
				class_expr_usage();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(598);
				function_call();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(599);
				namespacePath();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(600);
				match(PHP_VARIABLE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(601);
				match(PHP_NAMESPACE_PATH);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(602);
				match(PHP_IDENTIFIER);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(603);
				match(EXPR_STRING);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(604);
				match(PHP_KEYWORD);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(606); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(605);
						match(PHP_EXPRESSION);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(608); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(610);
				match(PHP_WS);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(611);
				match(PHP_STATIC_ACCESS);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(612);
				match(PHP_CLASS_KEYWORD);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(613);
				match(PHP_INSTANCE_ACCESS);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(614);
				match(BLADE_EXPR_LPAREN);
				setState(618);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4212734L) != 0) || _la==EXPR_STRING) {
					{
					{
					setState(615);
					composed_php_expression();
					}
					}
					setState(620);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(621);
				match(BLADE_EXPR_RPAREN);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(622);
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
		enterRule(_localctx, 102, RULE_simple_foreach_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			((Simple_foreach_exprContext)_localctx).loop_array = match(PHP_VARIABLE);
			setState(626);
			match(FOREACH_AS);
			setState(627);
			((Simple_foreach_exprContext)_localctx).key = match(PHP_VARIABLE);
			setState(630);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FOREACH_PARAM_ASSIGN) {
				{
				setState(628);
				match(FOREACH_PARAM_ASSIGN);
				setState(629);
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
		enterRule(_localctx, 104, RULE_singleArgWrapper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			match(BLADE_PARAM_LPAREN);
			setState(635);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(633);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(634);
				composedArgument();
				}
				break;
			}
			setState(637);
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
		enterRule(_localctx, 106, RULE_singleArgAndDefaultWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			match(BLADE_PARAM_LPAREN);
			setState(642);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(640);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(641);
				composedArgument();
				}
				break;
			}
			setState(646);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(644);
				match(BL_COMMA);
				setState(645);
				composedArgument();
				}
				break;
			}
			setState(655);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_COMMA) {
				{
				setState(648);
				match(BL_COMMA);
				setState(652);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BL_PARAM_WS) {
					{
					{
					setState(649);
					match(BL_PARAM_WS);
					}
					}
					setState(654);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(657);
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
		enterRule(_localctx, 108, RULE_doubleArgWrapper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			match(BLADE_PARAM_LPAREN);
			setState(662);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(660);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(661);
				composedArgument();
				}
				break;
			}
			setState(664);
			match(BL_COMMA);
			setState(665);
			composedArgument();
			setState(666);
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
		enterRule(_localctx, 110, RULE_multiArgWrapper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(668);
			match(BLADE_PARAM_LPAREN);
			setState(671);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(669);
				identifiableArgument();
				}
				break;
			case 2:
				{
				setState(670);
				composedArgument();
				}
				break;
			}
			setState(677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_COMMA) {
				{
				{
				setState(673);
				match(BL_COMMA);
				setState(674);
				composedArgument();
				}
				}
				setState(679);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(680);
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
		enterRule(_localctx, 112, RULE_identifiableArgument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(682);
				match(BL_PARAM_WS);
				}
				}
				setState(687);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(688);
			match(BL_PARAM_STRING);
			setState(692);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(689);
				match(BL_PARAM_WS);
				}
				}
				setState(694);
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
		enterRule(_localctx, 114, RULE_composedArgument);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(695);
					match(BL_PARAM_WS);
					}
					} 
				}
				setState(700);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			}
			setState(702); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(701);
					phpExpr();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(704); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(709);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(706);
				match(BL_PARAM_WS);
				}
				}
				setState(711);
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
		enterRule(_localctx, 116, RULE_phpExpr);
		try {
			setState(723);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(712);
				identifiableArray();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(713);
				arrayDefine();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(714);
				match(BLADE_PARAM_EXTRA);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(715);
				match(PHP_VARIABLE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(716);
				match(PHP_KEYWORD);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(717);
				match(BL_PARAM_WS);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(718);
				match(BL_PARAM_CONCAT_OPERATOR);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(719);
				match(BL_PARAM_STRING);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(720);
				match(BL_PARAM_ASSIGN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(721);
				match(BL_NAME_STRING);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(722);
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
		enterRule(_localctx, 118, RULE_identifiableArray);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
			match(BL_SQ_LPAREN);
			setState(726);
			paramAssign();
			setState(731);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(727);
					match(BL_PARAM_COMMA);
					setState(728);
					paramAssign();
					}
					} 
				}
				setState(733);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			}
			setState(735);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BL_PARAM_COMMA) {
				{
				setState(734);
				match(BL_PARAM_COMMA);
				}
			}

			setState(737);
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
		enterRule(_localctx, 120, RULE_arrayDefine);
		int _la;
		try {
			setState(749);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(739);
				match(BL_SQ_LPAREN);
				setState(741); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(740);
					phpExpr();
					}
					}
					setState(743); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2951180L) != 0) || ((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & 13L) != 0) );
				setState(745);
				match(BL_SQ_RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(747);
				match(BL_SQ_LPAREN);
				setState(748);
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
		enterRule(_localctx, 122, RULE_paramAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(751);
			match(BL_PARAM_STRING);
			setState(755);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(752);
				match(BL_PARAM_WS);
				}
				}
				setState(757);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(758);
			match(BL_PARAM_ASSIGN);
			setState(762);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BL_PARAM_WS) {
				{
				{
				setState(759);
				match(BL_PARAM_WS);
				}
				}
				setState(764);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(765);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 262156L) != 0)) ) {
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
		enterRule(_localctx, 124, RULE_verbatim_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			match(D_VERBATIM);
			setState(769); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(768);
				non_blade_statement();
				}
				}
				setState(771); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HTML || _la==PHP_INLINE_START );
			setState(773);
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
		enterRule(_localctx, 126, RULE_loop_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(775);
			_la = _input.LA(1);
			if ( !(_la==D_BREAK || _la==D_LOOP_ACTION) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(777);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHP_EXPRESSION) {
				{
				setState(776);
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
		enterRule(_localctx, 128, RULE_html);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(780); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(779);
					match(HTML);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(782); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
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
		"\u0004\u0001\u0083\u0311\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"@\u0001\u0000\u0005\u0000\u0084\b\u0000\n\u0000\f\u0000\u0087\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u008e\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002\u0096\b\u0002\n\u0002\f\u0002\u0099\t\u0002\u0001"+
		"\u0002\u0003\u0002\u009c\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003\u00ba\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u00c2\b\u0004\u000b\u0004\f"+
		"\u0004\u00c3\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u00cf\b\u0004"+
		"\u000b\u0004\f\u0004\u00d0\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0004\u0004\u00d7\b\u0004\u000b\u0004\f\u0004\u00d8\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u00e0\b\u0004\u000b"+
		"\u0004\f\u0004\u00e1\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0004\u0004\u00e9\b\u0004\u000b\u0004\f\u0004\u00ea\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00f7\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u00fb\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u0107\b\b\n\b\f\b\u010a\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0004\t\u0111\b\t\u000b\t\f\t\u0112\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0004\n\u011a\b\n\u000b\n\f\n\u011b\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0004\u000b\u0123\b\u000b\u000b\u000b\f\u000b\u0124"+
		"\u0001\u000b\u0003\u000b\u0128\b\u000b\u0001\f\u0001\f\u0001\f\u0004\f"+
		"\u012d\b\f\u000b\f\f\f\u012e\u0001\f\u0003\f\u0132\b\f\u0001\r\u0001\r"+
		"\u0004\r\u0136\b\r\u000b\r\f\r\u0137\u0001\r\u0003\r\u013b\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f\u0142\b\u000f"+
		"\u000b\u000f\f\u000f\u0143\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u014a\b\u0010\n\u0010\f\u0010\u014d\t\u0010\u0001\u0010\u0004"+
		"\u0010\u0150\b\u0010\u000b\u0010\f\u0010\u0151\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011\u015a\b\u0011"+
		"\u000b\u0011\f\u0011\u015b\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0004\u0012\u0163\b\u0012\u000b\u0012\f\u0012\u0164\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0004\u0013\u016c"+
		"\b\u0013\u000b\u0013\f\u0013\u016d\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0004\u0014\u0177\b\u0014"+
		"\u000b\u0014\f\u0014\u0178\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0004\u0015\u0183\b\u0015"+
		"\u000b\u0015\f\u0015\u0184\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u019e\b\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u01a2\b\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u01ad\b\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u01b6\b\u001d\u0003\u001d\u01b8\b\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u01bf"+
		"\b\u001e\n\u001e\f\u001e\u01c2\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0005\u001f\u01c9\b\u001f\n\u001f\f\u001f\u01cc"+
		"\t\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0003 \u01d4"+
		"\b \u0001!\u0001!\u0004!\u01d8\b!\u000b!\f!\u01d9\u0001!\u0001!\u0001"+
		"!\u0001!\u0003!\u01e0\b!\u0001\"\u0001\"\u0004\"\u01e4\b\"\u000b\"\f\""+
		"\u01e5\u0001\"\u0001\"\u0001#\u0001#\u0005#\u01ec\b#\n#\f#\u01ef\t#\u0001"+
		"#\u0001#\u0001$\u0001$\u0005$\u01f5\b$\n$\f$\u01f8\t$\u0001$\u0001$\u0001"+
		"%\u0001%\u0001&\u0001&\u0001&\u0001&\u0003&\u0202\b&\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003"+
		"(\u0210\b(\u0001)\u0001)\u0004)\u0214\b)\u000b)\f)\u0215\u0001)\u0001"+
		")\u0001)\u0005)\u021b\b)\n)\f)\u021e\t)\u0001)\u0001)\u0001*\u0001*\u0001"+
		"*\u0001*\u0001+\u0003+\u0227\b+\u0001+\u0001+\u0001,\u0003,\u022c\b,\u0001"+
		",\u0001,\u0001-\u0001-\u0001-\u0005-\u0233\b-\n-\f-\u0236\t-\u0001-\u0001"+
		"-\u0001.\u0001.\u0001.\u0005.\u023d\b.\n.\f.\u0240\t.\u0001.\u0001.\u0001"+
		"/\u0001/\u00010\u00010\u00040\u0248\b0\u000b0\f0\u0249\u00030\u024c\b"+
		"0\u00011\u00011\u00041\u0250\b1\u000b1\f1\u0251\u00011\u00011\u00012\u0001"+
		"2\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u00042\u025f\b2\u000b"+
		"2\f2\u0260\u00012\u00012\u00012\u00012\u00012\u00012\u00052\u0269\b2\n"+
		"2\f2\u026c\t2\u00012\u00012\u00032\u0270\b2\u00013\u00013\u00013\u0001"+
		"3\u00013\u00033\u0277\b3\u00014\u00014\u00014\u00034\u027c\b4\u00014\u0001"+
		"4\u00015\u00015\u00015\u00035\u0283\b5\u00015\u00015\u00035\u0287\b5\u0001"+
		"5\u00015\u00055\u028b\b5\n5\f5\u028e\t5\u00035\u0290\b5\u00015\u00015"+
		"\u00016\u00016\u00016\u00036\u0297\b6\u00016\u00016\u00016\u00016\u0001"+
		"7\u00017\u00017\u00037\u02a0\b7\u00017\u00017\u00057\u02a4\b7\n7\f7\u02a7"+
		"\t7\u00017\u00017\u00018\u00058\u02ac\b8\n8\f8\u02af\t8\u00018\u00018"+
		"\u00058\u02b3\b8\n8\f8\u02b6\t8\u00019\u00059\u02b9\b9\n9\f9\u02bc\t9"+
		"\u00019\u00049\u02bf\b9\u000b9\f9\u02c0\u00019\u00059\u02c4\b9\n9\f9\u02c7"+
		"\t9\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001"+
		":\u0001:\u0003:\u02d4\b:\u0001;\u0001;\u0001;\u0001;\u0005;\u02da\b;\n"+
		";\f;\u02dd\t;\u0001;\u0003;\u02e0\b;\u0001;\u0001;\u0001<\u0001<\u0004"+
		"<\u02e6\b<\u000b<\f<\u02e7\u0001<\u0001<\u0001<\u0001<\u0003<\u02ee\b"+
		"<\u0001=\u0001=\u0005=\u02f2\b=\n=\f=\u02f5\t=\u0001=\u0001=\u0005=\u02f9"+
		"\b=\n=\f=\u02fc\t=\u0001=\u0001=\u0001>\u0001>\u0004>\u0302\b>\u000b>"+
		"\f>\u0303\u0001>\u0001>\u0001?\u0001?\u0003?\u030a\b?\u0001@\u0004@\u030d"+
		"\b@\u000b@\f@\u030e\u0001@\u0000\u0000A\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:"+
		"<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0000\u0006\u0001\u0000TU\u0002"+
		"\u0000;;>@\u0002\u00002244\u0002\u0000\u0001\u0002lo\u0002\u0000\u0002"+
		"\u0003\u0012\u0012\u0001\u0000./\u0364\u0000\u0085\u0001\u0000\u0000\u0000"+
		"\u0002\u008d\u0001\u0000\u0000\u0000\u0004\u009b\u0001\u0000\u0000\u0000"+
		"\u0006\u00b9\u0001\u0000\u0000\u0000\b\u00f6\u0001\u0000\u0000\u0000\n"+
		"\u00fa\u0001\u0000\u0000\u0000\f\u00fc\u0001\u0000\u0000\u0000\u000e\u00ff"+
		"\u0001\u0000\u0000\u0000\u0010\u0102\u0001\u0000\u0000\u0000\u0012\u010d"+
		"\u0001\u0000\u0000\u0000\u0014\u0116\u0001\u0000\u0000\u0000\u0016\u011f"+
		"\u0001\u0000\u0000\u0000\u0018\u0129\u0001\u0000\u0000\u0000\u001a\u0133"+
		"\u0001\u0000\u0000\u0000\u001c\u013c\u0001\u0000\u0000\u0000\u001e\u013e"+
		"\u0001\u0000\u0000\u0000 \u0147\u0001\u0000\u0000\u0000\"\u0155\u0001"+
		"\u0000\u0000\u0000$\u015f\u0001\u0000\u0000\u0000&\u0168\u0001\u0000\u0000"+
		"\u0000(\u0171\u0001\u0000\u0000\u0000*\u017c\u0001\u0000\u0000\u0000,"+
		"\u0188\u0001\u0000\u0000\u0000.\u018b\u0001\u0000\u0000\u00000\u018e\u0001"+
		"\u0000\u0000\u00002\u0191\u0001\u0000\u0000\u00004\u0194\u0001\u0000\u0000"+
		"\u00006\u0197\u0001\u0000\u0000\u00008\u01a5\u0001\u0000\u0000\u0000:"+
		"\u01a8\u0001\u0000\u0000\u0000<\u01bb\u0001\u0000\u0000\u0000>\u01c5\u0001"+
		"\u0000\u0000\u0000@\u01cf\u0001\u0000\u0000\u0000B\u01df\u0001\u0000\u0000"+
		"\u0000D\u01e1\u0001\u0000\u0000\u0000F\u01e9\u0001\u0000\u0000\u0000H"+
		"\u01f2\u0001\u0000\u0000\u0000J\u01fb\u0001\u0000\u0000\u0000L\u0201\u0001"+
		"\u0000\u0000\u0000N\u0203\u0001\u0000\u0000\u0000P\u020f\u0001\u0000\u0000"+
		"\u0000R\u0211\u0001\u0000\u0000\u0000T\u0221\u0001\u0000\u0000\u0000V"+
		"\u0226\u0001\u0000\u0000\u0000X\u022b\u0001\u0000\u0000\u0000Z\u022f\u0001"+
		"\u0000\u0000\u0000\\\u0239\u0001\u0000\u0000\u0000^\u0243\u0001\u0000"+
		"\u0000\u0000`\u024b\u0001\u0000\u0000\u0000b\u024d\u0001\u0000\u0000\u0000"+
		"d\u026f\u0001\u0000\u0000\u0000f\u0271\u0001\u0000\u0000\u0000h\u0278"+
		"\u0001\u0000\u0000\u0000j\u027f\u0001\u0000\u0000\u0000l\u0293\u0001\u0000"+
		"\u0000\u0000n\u029c\u0001\u0000\u0000\u0000p\u02ad\u0001\u0000\u0000\u0000"+
		"r\u02ba\u0001\u0000\u0000\u0000t\u02d3\u0001\u0000\u0000\u0000v\u02d5"+
		"\u0001\u0000\u0000\u0000x\u02ed\u0001\u0000\u0000\u0000z\u02ef\u0001\u0000"+
		"\u0000\u0000|\u02ff\u0001\u0000\u0000\u0000~\u0307\u0001\u0000\u0000\u0000"+
		"\u0080\u030c\u0001\u0000\u0000\u0000\u0082\u0084\u0003\u0002\u0001\u0000"+
		"\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000"+
		"\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000"+
		"\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0005\u0000\u0000\u0001\u0089\u0001\u0001\u0000\u0000\u0000"+
		"\u008a\u008e\u0003\u0004\u0002\u0000\u008b\u008e\u0003\b\u0004\u0000\u008c"+
		"\u008e\u0003\u0080@\u0000\u008d\u008a\u0001\u0000\u0000\u0000\u008d\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u0003"+
		"\u0001\u0000\u0000\u0000\u008f\u009c\u0003\u0006\u0003\u0000\u0090\u009c"+
		"\u0003F#\u0000\u0091\u009c\u0003H$\u0000\u0092\u009c\u0003D\"\u0000\u0093"+
		"\u0097\u0005c\u0000\u0000\u0094\u0096\u0005\u0019\u0000\u0000\u0095\u0094"+
		"\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u009a"+
		"\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009c"+
		"\u0005y\u0000\u0000\u009b\u008f\u0001\u0000\u0000\u0000\u009b\u0090\u0001"+
		"\u0000\u0000\u0000\u009b\u0091\u0001\u0000\u0000\u0000\u009b\u0092\u0001"+
		"\u0000\u0000\u0000\u009b\u0093\u0001\u0000\u0000\u0000\u009c\u0005\u0001"+
		"\u0000\u0000\u0000\u009d\u00ba\u0003\f\u0006\u0000\u009e\u00ba\u0003\u000e"+
		"\u0007\u0000\u009f\u00ba\u0003,\u0016\u0000\u00a0\u00ba\u0003.\u0017\u0000"+
		"\u00a1\u00ba\u00032\u0019\u0000\u00a2\u00ba\u00034\u001a\u0000\u00a3\u00ba"+
		"\u00036\u001b\u0000\u00a4\u00ba\u00038\u001c\u0000\u00a5\u00ba\u0003:"+
		"\u001d\u0000\u00a6\u00a7\u0007\u0000\u0000\u0000\u00a7\u00ba\u0003d2\u0000"+
		"\u00a8\u00a9\u0005K\u0000\u0000\u00a9\u00ba\u0003d2\u0000\u00aa\u00ab"+
		"\u0005H\u0000\u0000\u00ab\u00ba\u0003d2\u0000\u00ac\u00ba\u0005J\u0000"+
		"\u0000\u00ad\u00ba\u00030\u0018\u0000\u00ae\u00af\u0005[\u0000\u0000\u00af"+
		"\u00ba\u0003l6\u0000\u00b0\u00b1\u0005V\u0000\u0000\u00b1\u00ba\u0003"+
		"d2\u0000\u00b2\u00b3\u0005\u001f\u0000\u0000\u00b3\u00ba\u0003d2\u0000"+
		"\u00b4\u00ba\u0005 \u0000\u0000\u00b5\u00ba\u0003~?\u0000\u00b6\u00b7"+
		"\u0005I\u0000\u0000\u00b7\u00ba\u0003j5\u0000\u00b8\u00ba\u0003@ \u0000"+
		"\u00b9\u009d\u0001\u0000\u0000\u0000\u00b9\u009e\u0001\u0000\u0000\u0000"+
		"\u00b9\u009f\u0001\u0000\u0000\u0000\u00b9\u00a0\u0001\u0000\u0000\u0000"+
		"\u00b9\u00a1\u0001\u0000\u0000\u0000\u00b9\u00a2\u0001\u0000\u0000\u0000"+
		"\u00b9\u00a3\u0001\u0000\u0000\u0000\u00b9\u00a4\u0001\u0000\u0000\u0000"+
		"\u00b9\u00a5\u0001\u0000\u0000\u0000\u00b9\u00a6\u0001\u0000\u0000\u0000"+
		"\u00b9\u00a8\u0001\u0000\u0000\u0000\u00b9\u00aa\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ac\u0001\u0000\u0000\u0000\u00b9\u00ad\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ae\u0001\u0000\u0000\u0000\u00b9\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b9\u00b2\u0001\u0000\u0000\u0000\u00b9\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b9\u00b5\u0001\u0000\u0000\u0000\u00b9\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba\u0007\u0001\u0000\u0000\u0000"+
		"\u00bb\u00f7\u0003\u0010\b\u0000\u00bc\u00f7\u0003<\u001e\u0000\u00bd"+
		"\u00f7\u0003>\u001f\u0000\u00be\u00f7\u0003\u0012\t\u0000\u00bf\u00c1"+
		"\u0005A\u0000\u0000\u00c0\u00c2\u0003\u0002\u0001\u0000\u00c1\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0005B\u0000\u0000\u00c6\u00f7\u0001\u0000"+
		"\u0000\u0000\u00c7\u00f7\u0003\u0016\u000b\u0000\u00c8\u00f7\u0003\u0018"+
		"\f\u0000\u00c9\u00f7\u0003\u001a\r\u0000\u00ca\u00f7\u0003\"\u0011\u0000"+
		"\u00cb\u00cc\u0005P\u0000\u0000\u00cc\u00ce\u0003h4\u0000\u00cd\u00cf"+
		"\u0003\u0002\u0001\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3"+
		"\u0005Q\u0000\u0000\u00d3\u00f7\u0001\u0000\u0000\u0000\u00d4\u00d6\u0005"+
		"N\u0000\u0000\u00d5\u00d7\u0003\u0002\u0001\u0000\u00d6\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0005O\u0000\u0000\u00db\u00f7\u0001\u0000\u0000"+
		"\u0000\u00dc\u00dd\u0005\"\u0000\u0000\u00dd\u00df\u0003b1\u0000\u00de"+
		"\u00e0\u0003\u0002\u0001\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e4\u0005#\u0000\u0000\u00e4\u00f7\u0001\u0000\u0000\u0000\u00e5\u00e6"+
		"\u0005L\u0000\u0000\u00e6\u00e8\u0003^/\u0000\u00e7\u00e9\u0003\u0002"+
		"\u0001\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000"+
		"\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000"+
		"\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005M\u0000"+
		"\u0000\u00ed\u00f7\u0001\u0000\u0000\u0000\u00ee\u00f7\u0003\u001e\u000f"+
		"\u0000\u00ef\u00f7\u0003 \u0010\u0000\u00f0\u00f7\u0003$\u0012\u0000\u00f1"+
		"\u00f7\u0003&\u0013\u0000\u00f2\u00f7\u0003(\u0014\u0000\u00f3\u00f7\u0003"+
		"*\u0015\u0000\u00f4\u00f7\u0003|>\u0000\u00f5\u00f7\u0003B!\u0000\u00f6"+
		"\u00bb\u0001\u0000\u0000\u0000\u00f6\u00bc\u0001\u0000\u0000\u0000\u00f6"+
		"\u00bd\u0001\u0000\u0000\u0000\u00f6\u00be\u0001\u0000\u0000\u0000\u00f6"+
		"\u00bf\u0001\u0000\u0000\u0000\u00f6\u00c7\u0001\u0000\u0000\u0000\u00f6"+
		"\u00c8\u0001\u0000\u0000\u0000\u00f6\u00c9\u0001\u0000\u0000\u0000\u00f6"+
		"\u00ca\u0001\u0000\u0000\u0000\u00f6\u00cb\u0001\u0000\u0000\u0000\u00f6"+
		"\u00d4\u0001\u0000\u0000\u0000\u00f6\u00dc\u0001\u0000\u0000\u0000\u00f6"+
		"\u00e5\u0001\u0000\u0000\u0000\u00f6\u00ee\u0001\u0000\u0000\u0000\u00f6"+
		"\u00ef\u0001\u0000\u0000\u0000\u00f6\u00f0\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f6\u00f2\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f7\t\u0001\u0000\u0000\u0000\u00f8\u00fb"+
		"\u0003\u0080@\u0000\u00f9\u00fb\u0003D\"\u0000\u00fa\u00f8\u0001\u0000"+
		"\u0000\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fb\u000b\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fd\u00056\u0000\u0000\u00fd\u00fe\u0003j5\u0000"+
		"\u00fe\r\u0001\u0000\u0000\u0000\u00ff\u0100\u00058\u0000\u0000\u0100"+
		"\u0101\u0003l6\u0000\u0101\u000f\u0001\u0000\u0000\u0000\u0102\u0103\u0005"+
		"8\u0000\u0000\u0103\u0108\u0003h4\u0000\u0104\u0107\u0003\u0002\u0001"+
		"\u0000\u0105\u0107\u0005=\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000"+
		"\u0106\u0105\u0001\u0000\u0000\u0000\u0107\u010a\u0001\u0000\u0000\u0000"+
		"\u0108\u0106\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000"+
		"\u0109\u010b\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000"+
		"\u010b\u010c\u0007\u0001\u0000\u0000\u010c\u0011\u0001\u0000\u0000\u0000"+
		"\u010d\u010e\u0005D\u0000\u0000\u010e\u0110\u0003h4\u0000\u010f\u0111"+
		"\u0003\u0002\u0001\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0111\u0112"+
		"\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\u0005E\u0000\u0000\u0115\u0013\u0001\u0000\u0000\u0000\u0116\u0117\u0005"+
		"F\u0000\u0000\u0117\u0119\u0003h4\u0000\u0118\u011a\u0003\u0002\u0001"+
		"\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000"+
		"\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000"+
		"\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011e\u0005G\u0000\u0000"+
		"\u011e\u0015\u0001\u0000\u0000\u0000\u011f\u0120\u0005\u001a\u0000\u0000"+
		"\u0120\u0122\u0003b1\u0000\u0121\u0123\u0003\u0002\u0001\u0000\u0122\u0121"+
		"\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u0122"+
		"\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125\u0127"+
		"\u0001\u0000\u0000\u0000\u0126\u0128\u0003\u001c\u000e\u0000\u0127\u0126"+
		"\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u0017"+
		"\u0001\u0000\u0000\u0000\u0129\u012a\u0005\u001b\u0000\u0000\u012a\u012c"+
		"\u0003b1\u0000\u012b\u012d\u0003\u0002\u0001\u0000\u012c\u012b\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u012c\u0001\u0000"+
		"\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0131\u0001\u0000"+
		"\u0000\u0000\u0130\u0132\u0003\u001c\u000e\u0000\u0131\u0130\u0001\u0000"+
		"\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0019\u0001\u0000"+
		"\u0000\u0000\u0133\u0135\u0005\u001c\u0000\u0000\u0134\u0136\u0003\u0002"+
		"\u0001\u0000\u0135\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000"+
		"\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000"+
		"\u0000\u0000\u0138\u013a\u0001\u0000\u0000\u0000\u0139\u013b\u0003\u001c"+
		"\u000e\u0000\u013a\u0139\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000"+
		"\u0000\u0000\u013b\u001b\u0001\u0000\u0000\u0000\u013c\u013d\u0005\u001d"+
		"\u0000\u0000\u013d\u001d\u0001\u0000\u0000\u0000\u013e\u013f\u0005$\u0000"+
		"\u0000\u013f\u0141\u0003b1\u0000\u0140\u0142\u0003\u0002\u0001\u0000\u0141"+
		"\u0140\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143"+
		"\u0141\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144"+
		"\u0145\u0001\u0000\u0000\u0000\u0145\u0146\u0005%\u0000\u0000\u0146\u001f"+
		"\u0001\u0000\u0000\u0000\u0147\u014b\u0005R\u0000\u0000\u0148\u014a\u0003"+
		"h4\u0000\u0149\u0148\u0001\u0000\u0000\u0000\u014a\u014d\u0001\u0000\u0000"+
		"\u0000\u014b\u0149\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000"+
		"\u0000\u014c\u014f\u0001\u0000\u0000\u0000\u014d\u014b\u0001\u0000\u0000"+
		"\u0000\u014e\u0150\u0003\u0002\u0001\u0000\u014f\u014e\u0001\u0000\u0000"+
		"\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000"+
		"\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000\u0000"+
		"\u0000\u0153\u0154\u0005S\u0000\u0000\u0154!\u0001\u0000\u0000\u0000\u0155"+
		"\u0156\u0005\u001e\u0000\u0000\u0156\u0159\u0003^/\u0000\u0157\u015a\u0003"+
		"\u0002\u0001\u0000\u0158\u015a\u0005.\u0000\u0000\u0159\u0157\u0001\u0000"+
		"\u0000\u0000\u0159\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000"+
		"\u0000\u0000\u015b\u0159\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000"+
		"\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015e\u0005!\u0000"+
		"\u0000\u015e#\u0001\u0000\u0000\u0000\u015f\u0160\u0005,\u0000\u0000\u0160"+
		"\u0162\u0003^/\u0000\u0161\u0163\u0003\u0002\u0001\u0000\u0162\u0161\u0001"+
		"\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0162\u0001"+
		"\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0166\u0001"+
		"\u0000\u0000\u0000\u0166\u0167\u0005-\u0000\u0000\u0167%\u0001\u0000\u0000"+
		"\u0000\u0168\u0169\u0005(\u0000\u0000\u0169\u016b\u0003^/\u0000\u016a"+
		"\u016c\u0003\u0002\u0001\u0000\u016b\u016a\u0001\u0000\u0000\u0000\u016c"+
		"\u016d\u0001\u0000\u0000\u0000\u016d\u016b\u0001\u0000\u0000\u0000\u016d"+
		"\u016e\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f"+
		"\u0170\u0005)\u0000\u0000\u0170\'\u0001\u0000\u0000\u0000\u0171\u0172"+
		"\u0005&\u0000\u0000\u0172\u0173\u0005l\u0000\u0000\u0173\u0174\u0003`"+
		"0\u0000\u0174\u0176\u0005m\u0000\u0000\u0175\u0177\u0003\u0002\u0001\u0000"+
		"\u0176\u0175\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000"+
		"\u0178\u0176\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000"+
		"\u0179\u017a\u0001\u0000\u0000\u0000\u017a\u017b\u0005\'\u0000\u0000\u017b"+
		")\u0001\u0000\u0000\u0000\u017c\u017d\u0005*\u0000\u0000\u017d\u017e\u0005"+
		"l\u0000\u0000\u017e\u017f\u0003`0\u0000\u017f\u0182\u0005m\u0000\u0000"+
		"\u0180\u0183\u0003\u0002\u0001\u0000\u0181\u0183\u0005\"\u0000\u0000\u0182"+
		"\u0180\u0001\u0000\u0000\u0000\u0182\u0181\u0001\u0000\u0000\u0000\u0183"+
		"\u0184\u0001\u0000\u0000\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0184"+
		"\u0185\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186"+
		"\u0187\u0005+\u0000\u0000\u0187+\u0001\u0000\u0000\u0000\u0188\u0189\u0005"+
		"<\u0000\u0000\u0189\u018a\u0003j5\u0000\u018a-\u0001\u0000\u0000\u0000"+
		"\u018b\u018c\u0005C\u0000\u0000\u018c\u018d\u0003h4\u0000\u018d/\u0001"+
		"\u0000\u0000\u0000\u018e\u018f\u0005Z\u0000\u0000\u018f\u0190\u0003h4"+
		"\u0000\u01901\u0001\u0000\u0000\u0000\u0191\u0192\u00050\u0000\u0000\u0192"+
		"\u0193\u0003j5\u0000\u01933\u0001\u0000\u0000\u0000\u0194\u0195\u0005"+
		"1\u0000\u0000\u0195\u0196\u0003j5\u0000\u01965\u0001\u0000\u0000\u0000"+
		"\u0197\u0198\u0007\u0002\u0000\u0000\u0198\u0199\u0005\f\u0000\u0000\u0199"+
		"\u019a\u0003r9\u0000\u019a\u019d\u0005\u0014\u0000\u0000\u019b\u019e\u0003"+
		"p8\u0000\u019c\u019e\u0003r9\u0000\u019d\u019b\u0001\u0000\u0000\u0000"+
		"\u019d\u019c\u0001\u0000\u0000\u0000\u019e\u01a1\u0001\u0000\u0000\u0000"+
		"\u019f\u01a0\u0005\u0014\u0000\u0000\u01a0\u01a2\u0003r9\u0000\u01a1\u019f"+
		"\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000\u0000\u01a2\u01a3"+
		"\u0001\u0000\u0000\u0000\u01a3\u01a4\u0005\r\u0000\u0000\u01a47\u0001"+
		"\u0000\u0000\u0000\u01a5\u01a6\u00053\u0000\u0000\u01a6\u01a7\u0003j5"+
		"\u0000\u01a79\u0001\u0000\u0000\u0000\u01a8\u01a9\u00055\u0000\u0000\u01a9"+
		"\u01ac\u0005\f\u0000\u0000\u01aa\u01ad\u0003p8\u0000\u01ab\u01ad\u0003"+
		"r9\u0000\u01ac\u01aa\u0001\u0000\u0000\u0000\u01ac\u01ab\u0001\u0000\u0000"+
		"\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01ae\u01af\u0005\u0014\u0000"+
		"\u0000\u01af\u01b0\u0003r9\u0000\u01b0\u01b1\u0005\u0014\u0000\u0000\u01b1"+
		"\u01b7\u0003r9\u0000\u01b2\u01b5\u0005\u0014\u0000\u0000\u01b3\u01b6\u0003"+
		"p8\u0000\u01b4\u01b6\u0003r9\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000"+
		"\u01b5\u01b4\u0001\u0000\u0000\u0000\u01b6\u01b8\u0001\u0000\u0000\u0000"+
		"\u01b7\u01b2\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001\u0000\u0000\u0000"+
		"\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01ba\u0005\r\u0000\u0000\u01ba"+
		";\u0001\u0000\u0000\u0000\u01bb\u01bc\u00059\u0000\u0000\u01bc\u01c0\u0003"+
		"h4\u0000\u01bd\u01bf\u0003\u0002\u0001\u0000\u01be\u01bd\u0001\u0000\u0000"+
		"\u0000\u01bf\u01c2\u0001\u0000\u0000\u0000\u01c0\u01be\u0001\u0000\u0000"+
		"\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1\u01c3\u0001\u0000\u0000"+
		"\u0000\u01c2\u01c0\u0001\u0000\u0000\u0000\u01c3\u01c4\u0005\u001d\u0000"+
		"\u0000\u01c4=\u0001\u0000\u0000\u0000\u01c5\u01c6\u0005:\u0000\u0000\u01c6"+
		"\u01ca\u0003h4\u0000\u01c7\u01c9\u0003\u0002\u0001\u0000\u01c8\u01c7\u0001"+
		"\u0000\u0000\u0000\u01c9\u01cc\u0001\u0000\u0000\u0000\u01ca\u01c8\u0001"+
		"\u0000\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000\u0000\u01cb\u01cd\u0001"+
		"\u0000\u0000\u0000\u01cc\u01ca\u0001\u0000\u0000\u0000\u01cd\u01ce\u0005"+
		"\u001d\u0000\u0000\u01ce?\u0001\u0000\u0000\u0000\u01cf\u01d3\u0005_\u0000"+
		"\u0000\u01d0\u01d4\u0003n7\u0000\u01d1\u01d2\u0005\f\u0000\u0000\u01d2"+
		"\u01d4\u0005\r\u0000\u0000\u01d3\u01d0\u0001\u0000\u0000\u0000\u01d3\u01d1"+
		"\u0001\u0000\u0000\u0000\u01d4A\u0001\u0000\u0000\u0000\u01d5\u01d7\u0005"+
		"\\\u0000\u0000\u01d6\u01d8\u0003d2\u0000\u01d7\u01d6\u0001\u0000\u0000"+
		"\u0000\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9\u01d7\u0001\u0000\u0000"+
		"\u0000\u01d9\u01da\u0001\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000"+
		"\u0000\u01db\u01dc\u0005w\u0000\u0000\u01dc\u01e0\u0001\u0000\u0000\u0000"+
		"\u01dd\u01de\u0005\\\u0000\u0000\u01de\u01e0\u0003b1\u0000\u01df\u01d5"+
		"\u0001\u0000\u0000\u0000\u01df\u01dd\u0001\u0000\u0000\u0000\u01e0C\u0001"+
		"\u0000\u0000\u0000\u01e1\u01e3\u0005b\u0000\u0000\u01e2\u01e4\u0003d2"+
		"\u0000\u01e3\u01e2\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000"+
		"\u0000\u01e5\u01e3\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000"+
		"\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01e8\u0005x\u0000\u0000"+
		"\u01e8E\u0001\u0000\u0000\u0000\u01e9\u01ed\u0005`\u0000\u0000\u01ea\u01ec"+
		"\u0003J%\u0000\u01eb\u01ea\u0001\u0000\u0000\u0000\u01ec\u01ef\u0001\u0000"+
		"\u0000\u0000\u01ed\u01eb\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000"+
		"\u0000\u0000\u01ee\u01f0\u0001\u0000\u0000\u0000\u01ef\u01ed\u0001\u0000"+
		"\u0000\u0000\u01f0\u01f1\u0005d\u0000\u0000\u01f1G\u0001\u0000\u0000\u0000"+
		"\u01f2\u01f6\u0005a\u0000\u0000\u01f3\u01f5\u0003J%\u0000\u01f4\u01f3"+
		"\u0001\u0000\u0000\u0000\u01f5\u01f8\u0001\u0000\u0000\u0000\u01f6\u01f4"+
		"\u0001\u0000\u0000\u0000\u01f6\u01f7\u0001\u0000\u0000\u0000\u01f7\u01f9"+
		"\u0001\u0000\u0000\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f9\u01fa"+
		"\u0005e\u0000\u0000\u01faI\u0001\u0000\u0000\u0000\u01fb\u01fc\u0003d"+
		"2\u0000\u01fcK\u0001\u0000\u0000\u0000\u01fd\u0202\u0003T*\u0000\u01fe"+
		"\u0202\u0003N\'\u0000\u01ff\u0202\u0003P(\u0000\u0200\u0202\u0003R)\u0000"+
		"\u0201\u01fd\u0001\u0000\u0000\u0000\u0201\u01fe\u0001\u0000\u0000\u0000"+
		"\u0201\u01ff\u0001\u0000\u0000\u0000\u0201\u0200\u0001\u0000\u0000\u0000"+
		"\u0202M\u0001\u0000\u0000\u0000\u0203\u0204\u0005\u0002\u0000\u0000\u0204"+
		"\u0205\u0005\b\u0000\u0000\u0205\u0206\u0005\u0006\u0000\u0000\u0206O"+
		"\u0001\u0000\u0000\u0000\u0207\u0208\u0003V+\u0000\u0208\u0209\u0005\b"+
		"\u0000\u0000\u0209\u020a\u0003Z-\u0000\u020a\u0210\u0001\u0000\u0000\u0000"+
		"\u020b\u020c\u0003V+\u0000\u020c\u020d\u0005\b\u0000\u0000\u020d\u020e"+
		"\u0005\u0006\u0000\u0000\u020e\u0210\u0001\u0000\u0000\u0000\u020f\u0207"+
		"\u0001\u0000\u0000\u0000\u020f\u020b\u0001\u0000\u0000\u0000\u0210Q\u0001"+
		"\u0000\u0000\u0000\u0211\u0213\u0005\u0004\u0000\u0000\u0212\u0214\u0005"+
		"\u0005\u0000\u0000\u0213\u0212\u0001\u0000\u0000\u0000\u0214\u0215\u0001"+
		"\u0000\u0000\u0000\u0215\u0213\u0001\u0000\u0000\u0000\u0215\u0216\u0001"+
		"\u0000\u0000\u0000\u0216\u0217\u0001\u0000\u0000\u0000\u0217\u0218\u0003"+
		"V+\u0000\u0218\u021c\u0005\u000e\u0000\u0000\u0219\u021b\u0003d2\u0000"+
		"\u021a\u0219\u0001\u0000\u0000\u0000\u021b\u021e\u0001\u0000\u0000\u0000"+
		"\u021c\u021a\u0001\u0000\u0000\u0000\u021c\u021d\u0001\u0000\u0000\u0000"+
		"\u021d\u021f\u0001\u0000\u0000\u0000\u021e\u021c\u0001\u0000\u0000\u0000"+
		"\u021f\u0220\u0005\u000f\u0000\u0000\u0220S\u0001\u0000\u0000\u0000\u0221"+
		"\u0222\u0003V+\u0000\u0222\u0223\u0005\b\u0000\u0000\u0223\u0224\u0005"+
		"\t\u0000\u0000\u0224U\u0001\u0000\u0000\u0000\u0225\u0227\u0005\u0007"+
		"\u0000\u0000\u0226\u0225\u0001\u0000\u0000\u0000\u0226\u0227\u0001\u0000"+
		"\u0000\u0000\u0227\u0228\u0001\u0000\u0000\u0000\u0228\u0229\u0005\u0006"+
		"\u0000\u0000\u0229W\u0001\u0000\u0000\u0000\u022a\u022c\u0005\u0007\u0000"+
		"\u0000\u022b\u022a\u0001\u0000\u0000\u0000\u022b\u022c\u0001\u0000\u0000"+
		"\u0000\u022c\u022d\u0001\u0000\u0000\u0000\u022d\u022e\u0005\u0006\u0000"+
		"\u0000\u022eY\u0001\u0000\u0000\u0000\u022f\u0230\u0005\u0006\u0000\u0000"+
		"\u0230\u0234\u0005\u000e\u0000\u0000\u0231\u0233\u0003d2\u0000\u0232\u0231"+
		"\u0001\u0000\u0000\u0000\u0233\u0236\u0001\u0000\u0000\u0000\u0234\u0232"+
		"\u0001\u0000\u0000\u0000\u0234\u0235\u0001\u0000\u0000\u0000\u0235\u0237"+
		"\u0001\u0000\u0000\u0000\u0236\u0234\u0001\u0000\u0000\u0000\u0237\u0238"+
		"\u0005\u000f\u0000\u0000\u0238[\u0001\u0000\u0000\u0000\u0239\u023a\u0005"+
		"\u0006\u0000\u0000\u023a\u023e\u0005\u000e\u0000\u0000\u023b\u023d\u0003"+
		"d2\u0000\u023c\u023b\u0001\u0000\u0000\u0000\u023d\u0240\u0001\u0000\u0000"+
		"\u0000\u023e\u023c\u0001\u0000\u0000\u0000\u023e\u023f\u0001\u0000\u0000"+
		"\u0000\u023f\u0241\u0001\u0000\u0000\u0000\u0240\u023e\u0001\u0000\u0000"+
		"\u0000\u0241\u0242\u0005\u000f\u0000\u0000\u0242]\u0001\u0000\u0000\u0000"+
		"\u0243\u0244\u0005\u0001\u0000\u0000\u0244_\u0001\u0000\u0000\u0000\u0245"+
		"\u024c\u0003f3\u0000\u0246\u0248\u0007\u0003\u0000\u0000\u0247\u0246\u0001"+
		"\u0000\u0000\u0000\u0248\u0249\u0001\u0000\u0000\u0000\u0249\u0247\u0001"+
		"\u0000\u0000\u0000\u0249\u024a\u0001\u0000\u0000\u0000\u024a\u024c\u0001"+
		"\u0000\u0000\u0000\u024b\u0245\u0001\u0000\u0000\u0000\u024b\u0247\u0001"+
		"\u0000\u0000\u0000\u024ca\u0001\u0000\u0000\u0000\u024d\u024f\u0005\u000e"+
		"\u0000\u0000\u024e\u0250\u0003d2\u0000\u024f\u024e\u0001\u0000\u0000\u0000"+
		"\u0250\u0251\u0001\u0000\u0000\u0000\u0251\u024f\u0001\u0000\u0000\u0000"+
		"\u0251\u0252\u0001\u0000\u0000\u0000\u0252\u0253\u0001\u0000\u0000\u0000"+
		"\u0253\u0254\u0005\u000f\u0000\u0000\u0254c\u0001\u0000\u0000\u0000\u0255"+
		"\u0270\u0003L&\u0000\u0256\u0270\u0003\\.\u0000\u0257\u0270\u0003X,\u0000"+
		"\u0258\u0270\u0005\u0002\u0000\u0000\u0259\u0270\u0005\u0007\u0000\u0000"+
		"\u025a\u0270\u0005\u0006\u0000\u0000\u025b\u0270\u0005h\u0000\u0000\u025c"+
		"\u0270\u0005\u0003\u0000\u0000\u025d\u025f\u0005\u0001\u0000\u0000\u025e"+
		"\u025d\u0001\u0000\u0000\u0000\u025f\u0260\u0001\u0000\u0000\u0000\u0260"+
		"\u025e\u0001\u0000\u0000\u0000\u0260\u0261\u0001\u0000\u0000\u0000\u0261"+
		"\u0270\u0001\u0000\u0000\u0000\u0262\u0270\u0005\u0005\u0000\u0000\u0263"+
		"\u0270\u0005\b\u0000\u0000\u0264\u0270\u0005\t\u0000\u0000\u0265\u0270"+
		"\u0005\n\u0000\u0000\u0266\u026a\u0005\u000e\u0000\u0000\u0267\u0269\u0003"+
		"d2\u0000\u0268\u0267\u0001\u0000\u0000\u0000\u0269\u026c\u0001\u0000\u0000"+
		"\u0000\u026a\u0268\u0001\u0000\u0000\u0000\u026a\u026b\u0001\u0000\u0000"+
		"\u0000\u026b\u026d\u0001\u0000\u0000\u0000\u026c\u026a\u0001\u0000\u0000"+
		"\u0000\u026d\u0270\u0005\u000f\u0000\u0000\u026e\u0270\u0005\u0016\u0000"+
		"\u0000\u026f\u0255\u0001\u0000\u0000\u0000\u026f\u0256\u0001\u0000\u0000"+
		"\u0000\u026f\u0257\u0001\u0000\u0000\u0000\u026f\u0258\u0001\u0000\u0000"+
		"\u0000\u026f\u0259\u0001\u0000\u0000\u0000\u026f\u025a\u0001\u0000\u0000"+
		"\u0000\u026f\u025b\u0001\u0000\u0000\u0000\u026f\u025c\u0001\u0000\u0000"+
		"\u0000\u026f\u025e\u0001\u0000\u0000\u0000\u026f\u0262\u0001\u0000\u0000"+
		"\u0000\u026f\u0263\u0001\u0000\u0000\u0000\u026f\u0264\u0001\u0000\u0000"+
		"\u0000\u026f\u0265\u0001\u0000\u0000\u0000\u026f\u0266\u0001\u0000\u0000"+
		"\u0000\u026f\u026e\u0001\u0000\u0000\u0000\u0270e\u0001\u0000\u0000\u0000"+
		"\u0271\u0272\u0005\u0002\u0000\u0000\u0272\u0273\u0005n\u0000\u0000\u0273"+
		"\u0276\u0005\u0002\u0000\u0000\u0274\u0275\u0005o\u0000\u0000\u0275\u0277"+
		"\u0005\u0002\u0000\u0000\u0276\u0274\u0001\u0000\u0000\u0000\u0276\u0277"+
		"\u0001\u0000\u0000\u0000\u0277g\u0001\u0000\u0000\u0000\u0278\u027b\u0005"+
		"\f\u0000\u0000\u0279\u027c\u0003p8\u0000\u027a\u027c\u0003r9\u0000\u027b"+
		"\u0279\u0001\u0000\u0000\u0000\u027b\u027a\u0001\u0000\u0000\u0000\u027c"+
		"\u027d\u0001\u0000\u0000\u0000\u027d\u027e\u0005\r\u0000\u0000\u027ei"+
		"\u0001\u0000\u0000\u0000\u027f\u0282\u0005\f\u0000\u0000\u0280\u0283\u0003"+
		"p8\u0000\u0281\u0283\u0003r9\u0000\u0282\u0280\u0001\u0000\u0000\u0000"+
		"\u0282\u0281\u0001\u0000\u0000\u0000\u0283\u0286\u0001\u0000\u0000\u0000"+
		"\u0284\u0285\u0005\u0014\u0000\u0000\u0285\u0287\u0003r9\u0000\u0286\u0284"+
		"\u0001\u0000\u0000\u0000\u0286\u0287\u0001\u0000\u0000\u0000\u0287\u028f"+
		"\u0001\u0000\u0000\u0000\u0288\u028c\u0005\u0014\u0000\u0000\u0289\u028b"+
		"\u0005u\u0000\u0000\u028a\u0289\u0001\u0000\u0000\u0000\u028b\u028e\u0001"+
		"\u0000\u0000\u0000\u028c\u028a\u0001\u0000\u0000\u0000\u028c\u028d\u0001"+
		"\u0000\u0000\u0000\u028d\u0290\u0001\u0000\u0000\u0000\u028e\u028c\u0001"+
		"\u0000\u0000\u0000\u028f\u0288\u0001\u0000\u0000\u0000\u028f\u0290\u0001"+
		"\u0000\u0000\u0000\u0290\u0291\u0001\u0000\u0000\u0000\u0291\u0292\u0005"+
		"\r\u0000\u0000\u0292k\u0001\u0000\u0000\u0000\u0293\u0296\u0005\f\u0000"+
		"\u0000\u0294\u0297\u0003p8\u0000\u0295\u0297\u0003r9\u0000\u0296\u0294"+
		"\u0001\u0000\u0000\u0000\u0296\u0295\u0001\u0000\u0000\u0000\u0297\u0298"+
		"\u0001\u0000\u0000\u0000\u0298\u0299\u0005\u0014\u0000\u0000\u0299\u029a"+
		"\u0003r9\u0000\u029a\u029b\u0005\r\u0000\u0000\u029bm\u0001\u0000\u0000"+
		"\u0000\u029c\u029f\u0005\f\u0000\u0000\u029d\u02a0\u0003p8\u0000\u029e"+
		"\u02a0\u0003r9\u0000\u029f\u029d\u0001\u0000\u0000\u0000\u029f\u029e\u0001"+
		"\u0000\u0000\u0000\u02a0\u02a5\u0001\u0000\u0000\u0000\u02a1\u02a2\u0005"+
		"\u0014\u0000\u0000\u02a2\u02a4\u0003r9\u0000\u02a3\u02a1\u0001\u0000\u0000"+
		"\u0000\u02a4\u02a7\u0001\u0000\u0000\u0000\u02a5\u02a3\u0001\u0000\u0000"+
		"\u0000\u02a5\u02a6\u0001\u0000\u0000\u0000\u02a6\u02a8\u0001\u0000\u0000"+
		"\u0000\u02a7\u02a5\u0001\u0000\u0000\u0000\u02a8\u02a9\u0005\r\u0000\u0000"+
		"\u02a9o\u0001\u0000\u0000\u0000\u02aa\u02ac\u0005u\u0000\u0000\u02ab\u02aa"+
		"\u0001\u0000\u0000\u0000\u02ac\u02af\u0001\u0000\u0000\u0000\u02ad\u02ab"+
		"\u0001\u0000\u0000\u0000\u02ad\u02ae\u0001\u0000\u0000\u0000\u02ae\u02b0"+
		"\u0001\u0000\u0000\u0000\u02af\u02ad\u0001\u0000\u0000\u0000\u02b0\u02b4"+
		"\u0005\u0012\u0000\u0000\u02b1\u02b3\u0005u\u0000\u0000\u02b2\u02b1\u0001"+
		"\u0000\u0000\u0000\u02b3\u02b6\u0001\u0000\u0000\u0000\u02b4\u02b2\u0001"+
		"\u0000\u0000\u0000\u02b4\u02b5\u0001\u0000\u0000\u0000\u02b5q\u0001\u0000"+
		"\u0000\u0000\u02b6\u02b4\u0001\u0000\u0000\u0000\u02b7\u02b9\u0005u\u0000"+
		"\u0000\u02b8\u02b7\u0001\u0000\u0000\u0000\u02b9\u02bc\u0001\u0000\u0000"+
		"\u0000\u02ba\u02b8\u0001\u0000\u0000\u0000\u02ba\u02bb\u0001\u0000\u0000"+
		"\u0000\u02bb\u02be\u0001\u0000\u0000\u0000\u02bc\u02ba\u0001\u0000\u0000"+
		"\u0000\u02bd\u02bf\u0003t:\u0000\u02be\u02bd\u0001\u0000\u0000\u0000\u02bf"+
		"\u02c0\u0001\u0000\u0000\u0000\u02c0\u02be\u0001\u0000\u0000\u0000\u02c0"+
		"\u02c1\u0001\u0000\u0000\u0000\u02c1\u02c5\u0001\u0000\u0000\u0000\u02c2"+
		"\u02c4\u0005u\u0000\u0000\u02c3\u02c2\u0001\u0000\u0000\u0000\u02c4\u02c7"+
		"\u0001\u0000\u0000\u0000\u02c5\u02c3\u0001\u0000\u0000\u0000\u02c5\u02c6"+
		"\u0001\u0000\u0000\u0000\u02c6s\u0001\u0000\u0000\u0000\u02c7\u02c5\u0001"+
		"\u0000\u0000\u0000\u02c8\u02d4\u0003v;\u0000\u02c9\u02d4\u0003x<\u0000"+
		"\u02ca\u02d4\u0005\u000b\u0000\u0000\u02cb\u02d4\u0005\u0002\u0000\u0000"+
		"\u02cc\u02d4\u0005\u0003\u0000\u0000\u02cd\u02d4\u0005u\u0000\u0000\u02ce"+
		"\u02d4\u0005s\u0000\u0000\u02cf\u02d4\u0005\u0012\u0000\u0000\u02d0\u02d4"+
		"\u0005\u0013\u0000\u0000\u02d1\u02d4\u0005v\u0000\u0000\u02d2\u02d4\u0005"+
		"\u0015\u0000\u0000\u02d3\u02c8\u0001\u0000\u0000\u0000\u02d3\u02c9\u0001"+
		"\u0000\u0000\u0000\u02d3\u02ca\u0001\u0000\u0000\u0000\u02d3\u02cb\u0001"+
		"\u0000\u0000\u0000\u02d3\u02cc\u0001\u0000\u0000\u0000\u02d3\u02cd\u0001"+
		"\u0000\u0000\u0000\u02d3\u02ce\u0001\u0000\u0000\u0000\u02d3\u02cf\u0001"+
		"\u0000\u0000\u0000\u02d3\u02d0\u0001\u0000\u0000\u0000\u02d3\u02d1\u0001"+
		"\u0000\u0000\u0000\u02d3\u02d2\u0001\u0000\u0000\u0000\u02d4u\u0001\u0000"+
		"\u0000\u0000\u02d5\u02d6\u0005\u0010\u0000\u0000\u02d6\u02db\u0003z=\u0000"+
		"\u02d7\u02d8\u0005\u0015\u0000\u0000\u02d8\u02da\u0003z=\u0000\u02d9\u02d7"+
		"\u0001\u0000\u0000\u0000\u02da\u02dd\u0001\u0000\u0000\u0000\u02db\u02d9"+
		"\u0001\u0000\u0000\u0000\u02db\u02dc\u0001\u0000\u0000\u0000\u02dc\u02df"+
		"\u0001\u0000\u0000\u0000\u02dd\u02db\u0001\u0000\u0000\u0000\u02de\u02e0"+
		"\u0005\u0015\u0000\u0000\u02df\u02de\u0001\u0000\u0000\u0000\u02df\u02e0"+
		"\u0001\u0000\u0000\u0000\u02e0\u02e1\u0001\u0000\u0000\u0000\u02e1\u02e2"+
		"\u0005q\u0000\u0000\u02e2w\u0001\u0000\u0000\u0000\u02e3\u02e5\u0005\u0010"+
		"\u0000\u0000\u02e4\u02e6\u0003t:\u0000\u02e5\u02e4\u0001\u0000\u0000\u0000"+
		"\u02e6\u02e7\u0001\u0000\u0000\u0000\u02e7\u02e5\u0001\u0000\u0000\u0000"+
		"\u02e7\u02e8\u0001\u0000\u0000\u0000\u02e8\u02e9\u0001\u0000\u0000\u0000"+
		"\u02e9\u02ea\u0005q\u0000\u0000\u02ea\u02ee\u0001\u0000\u0000\u0000\u02eb"+
		"\u02ec\u0005\u0010\u0000\u0000\u02ec\u02ee\u0005q\u0000\u0000\u02ed\u02e3"+
		"\u0001\u0000\u0000\u0000\u02ed\u02eb\u0001\u0000\u0000\u0000\u02eey\u0001"+
		"\u0000\u0000\u0000\u02ef\u02f3\u0005\u0012\u0000\u0000\u02f0\u02f2\u0005"+
		"u\u0000\u0000\u02f1\u02f0\u0001\u0000\u0000\u0000\u02f2\u02f5\u0001\u0000"+
		"\u0000\u0000\u02f3\u02f1\u0001\u0000\u0000\u0000\u02f3\u02f4\u0001\u0000"+
		"\u0000\u0000\u02f4\u02f6\u0001\u0000\u0000\u0000\u02f5\u02f3\u0001\u0000"+
		"\u0000\u0000\u02f6\u02fa\u0005\u0013\u0000\u0000\u02f7\u02f9\u0005u\u0000"+
		"\u0000\u02f8\u02f7\u0001\u0000\u0000\u0000\u02f9\u02fc\u0001\u0000\u0000"+
		"\u0000\u02fa\u02f8\u0001\u0000\u0000\u0000\u02fa\u02fb\u0001\u0000\u0000"+
		"\u0000\u02fb\u02fd\u0001\u0000\u0000\u0000\u02fc\u02fa\u0001\u0000\u0000"+
		"\u0000\u02fd\u02fe\u0007\u0004\u0000\u0000\u02fe{\u0001\u0000\u0000\u0000"+
		"\u02ff\u0301\u0005]\u0000\u0000\u0300\u0302\u0003\n\u0005\u0000\u0301"+
		"\u0300\u0001\u0000\u0000\u0000\u0302\u0303\u0001\u0000\u0000\u0000\u0303"+
		"\u0301\u0001\u0000\u0000\u0000\u0303\u0304\u0001\u0000\u0000\u0000\u0304"+
		"\u0305\u0001\u0000\u0000\u0000\u0305\u0306\u0005^\u0000\u0000\u0306}\u0001"+
		"\u0000\u0000\u0000\u0307\u0309\u0007\u0005\u0000\u0000\u0308\u030a\u0003"+
		"^/\u0000\u0309\u0308\u0001\u0000\u0000\u0000\u0309\u030a\u0001\u0000\u0000"+
		"\u0000\u030a\u007f\u0001\u0000\u0000\u0000\u030b\u030d\u0005\u0018\u0000"+
		"\u0000\u030c\u030b\u0001\u0000\u0000\u0000\u030d\u030e\u0001\u0000\u0000"+
		"\u0000\u030e\u030c\u0001\u0000\u0000\u0000\u030e\u030f\u0001\u0000\u0000"+
		"\u0000\u030f\u0081\u0001\u0000\u0000\u0000S\u0085\u008d\u0097\u009b\u00b9"+
		"\u00c3\u00d0\u00d8\u00e1\u00ea\u00f6\u00fa\u0106\u0108\u0112\u011b\u0124"+
		"\u0127\u012e\u0131\u0137\u013a\u0143\u014b\u0151\u0159\u015b\u0164\u016d"+
		"\u0178\u0182\u0184\u019d\u01a1\u01ac\u01b5\u01b7\u01c0\u01ca\u01d3\u01d9"+
		"\u01df\u01e5\u01ed\u01f6\u0201\u020f\u0215\u021c\u0226\u022b\u0234\u023e"+
		"\u0249\u024b\u0251\u0260\u026a\u026f\u0276\u027b\u0282\u0286\u028c\u028f"+
		"\u0296\u029f\u02a5\u02ad\u02b4\u02ba\u02c0\u02c5\u02d3\u02db\u02df\u02e7"+
		"\u02ed\u02f3\u02fa\u0303\u0309\u030e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}