// Generated from BladeAntlrParser.g4 by ANTLR 4.13.1

 /*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

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
		D_VERBATIM=66, D_ENDVERBATIM=67, D_SESSION=68, D_ENDSESSION=69, D_CONTEXT=70, 
		D_ENDCONTEXT=71, D_CSRF=72, D_METHOD=73, D_ERROR=74, D_ENDERROR=75, D_AUTH=76, 
		D_ENDAUTH=77, D_GUEST=78, D_ELSEGUEST=79, D_ENDGUEST=80, D_ENV=81, D_ENDENV=82, 
		D_PRODUCTION=83, D_ENDPRODUCTION=84, D_CAN=85, D_ENDCAN=86, D_CANNOT=87, 
		D_CANANY=88, D_ELSECAN=89, D_ENDCANNOT=90, D_ENDCANANY=91, D_FRAGMENT=92, 
		D_ENDFRAGMENT=93, D_SIMPLE_DIRECTIVE=94, D_PROPS=95, D_AWARE=96, D_VITE=97, 
		D_VITE_REFRESH=98, D_LANG=99, D_INJECT=100, D_USE=101, BLADE_CONTENT_OPEN_TAG=102, 
		BLADE_TAG_ESCAPE=103, BLADE_RAW_OPEN_TAG=104, BLADE_RAW_CLOSE_TAG=105, 
		URI_PATH_PART=106, D_CSS_AT=107, D_CSS_AT2=108, D_ENDCUSTOM=109, AT=110, 
		PHP_INLINE_START=111, HTML_COMPONENT_OPEN_TAG=112, WS=113, OTHER=114, 
		BLADE_COMMENT_START=115, EMAIL_SUBSTRING=116, VERSION_WITH_AT=117, D_ESCAPES=118, 
		E_LPAREN=119, E_RPAREN=120, E_LSQUAREBRACKET=121, E_RSQUAREBRACKET=122, 
		E_LCURLYBRACE=123, E_RCURLYBRACE=124, E_OTHER=125, EI_LPAREN=126, EI_RPAREN=127, 
		EI_OTHER=128, ESPOS_LPAREN=129, ESPOS_RPAREN=130, ESPOS_LSQUAREBRACKET=131, 
		ESPOS_RSQUAREBRACKET=132, ESPOS_LCURLYBRACE=133, ESPOS_RCURLYBRACE=134, 
		ESPOS_OTHER=135, EACH_LPAREN=136, EACH_RPAREN=137, EACH_LSQUAREBRACKET=138, 
		EACH_RSQUAREBRACKET=139, EACH_LCURLYBRACE=140, EACH_RCURLYBRACE=141, EACH_OTHER=142, 
		INCF_LPAREN=143, INCF_RPAREN=144, INCF_LSQUAREBRACKET=145, INCF_RSQUAREBRACKET=146, 
		INCF_LCURLYBRACE=147, INCF_RCURLYBRACE=148, INCF_OTHER=149, MIXED_S_A_LPAREN=150, 
		MIXED_S_A_RPAREN=151, MIXED_S_A_LSQUAREBRACKET=152, MIXED_S_A_RSQUAREBRACKET=153, 
		MIXED_S_A_LCURLYBRACE=154, MIXED_S_A_RCURLYBRACE=155, MIXED_ASSOCIATED_VALUE_STRING=156, 
		MIXED_S_A_OTHER=157, FOREACH_LPAREN=158, FOREACH_RPAREN=159, FOREACH_LSQUAREBRACKET=160, 
		FOREACH_RSQUAREBRACKET=161, FOREACH_LCURLYBRACE=162, FOREACH_RCURLYBRACE=163, 
		FOREACH_VAR=164, FOREACH_PHP_EXPR_STRING=165, FOREACH_AS=166, FOREACH_DOUBLE_ARROW=167, 
		FOREACH_DENTIFIER=168, FOREACH_OTHER=169, D_ENDPHP=170, BLADE_INLINE_PHP_OTHER=171, 
		VERBATIM_HTML=172, PHP_INLINE_EXIT=173, PHP_INLINE_OTHER=174, PHP_INLINE_EOF=175, 
		BLADE_COMMENT_END=176, BLADE_COMMENT_MORE=177, BLADE_COMMENT_EOF=178, 
		D_SPATIE=179;
	public static final int
		RULE_file = 0, RULE_statement = 1, RULE_blockDirective = 2, RULE_ifStatement = 3, 
		RULE_foreachStatement = 4, RULE_forStatement = 5, RULE_forElseStatement = 6, 
		RULE_ifStartStatement = 7, RULE_elseifStatement = 8, RULE_switchStatement = 9, 
		RULE_bladePhpBlock = 10, RULE_inlineDirective = 11, RULE_propsDirective = 12, 
		RULE_identifiableArgDirective = 13, RULE_multipleArgDirective = 14, RULE_blockIdentifiableArgDirective = 15, 
		RULE_directiveWithArg = 16, RULE_customDirective = 17, RULE_loopBreaks = 18, 
		RULE_formStatements = 19, RULE_authStatements = 20, RULE_bladeContentTags = 21, 
		RULE_bladeRawTags = 22, RULE_errorDirectives = 23, RULE_directiveArguments = 24, 
		RULE_foreachLoopArguments = 25, RULE_phpInline = 26, RULE_htmlComponentOpenTag = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "statement", "blockDirective", "ifStatement", "foreachStatement", 
			"forStatement", "forElseStatement", "ifStartStatement", "elseifStatement", 
			"switchStatement", "bladePhpBlock", "inlineDirective", "propsDirective", 
			"identifiableArgDirective", "multipleArgDirective", "blockIdentifiableArgDirective", 
			"directiveWithArg", "customDirective", "loopBreaks", "formStatements", 
			"authStatements", "bladeContentTags", "bladeRawTags", "errorDirectives", 
			"directiveArguments", "foreachLoopArguments", "phpInline", "htmlComponentOpenTag"
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
			"'@verbatim'", "'@endverbatim'", null, "'@endsession'", null, "'@endcontext'", 
			"'@csrf'", null, null, "'@enderror'", null, "'@endauth'", null, "'@elseguest'", 
			"'@endguest'", null, "'@endenv'", "'@production'", "'@endproduction'", 
			null, "'@endcan'", null, null, null, "'@endcannot'", "'@endcanany'", 
			null, "'@endfragment'", null, null, null, null, "'@viteReactRefresh'", 
			"'@lang'", null, "'@use'", "'{{'", null, "'{!!'", "'!!}'", null, null, 
			null, null, "'@'", null, null, null, null, "'{{--'", null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "'as'", 
			"'=>'", null, null, "'@endphp'", null, null, "'?>'", null, null, "'--}}'", 
			null, null, "'@honeypot'"
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
			"D_SESSION", "D_ENDSESSION", "D_CONTEXT", "D_ENDCONTEXT", "D_CSRF", "D_METHOD", 
			"D_ERROR", "D_ENDERROR", "D_AUTH", "D_ENDAUTH", "D_GUEST", "D_ELSEGUEST", 
			"D_ENDGUEST", "D_ENV", "D_ENDENV", "D_PRODUCTION", "D_ENDPRODUCTION", 
			"D_CAN", "D_ENDCAN", "D_CANNOT", "D_CANANY", "D_ELSECAN", "D_ENDCANNOT", 
			"D_ENDCANANY", "D_FRAGMENT", "D_ENDFRAGMENT", "D_SIMPLE_DIRECTIVE", "D_PROPS", 
			"D_AWARE", "D_VITE", "D_VITE_REFRESH", "D_LANG", "D_INJECT", "D_USE", 
			"BLADE_CONTENT_OPEN_TAG", "BLADE_TAG_ESCAPE", "BLADE_RAW_OPEN_TAG", "BLADE_RAW_CLOSE_TAG", 
			"URI_PATH_PART", "D_CSS_AT", "D_CSS_AT2", "D_ENDCUSTOM", "AT", "PHP_INLINE_START", 
			"HTML_COMPONENT_OPEN_TAG", "WS", "OTHER", "BLADE_COMMENT_START", "EMAIL_SUBSTRING", 
			"VERSION_WITH_AT", "D_ESCAPES", "E_LPAREN", "E_RPAREN", "E_LSQUAREBRACKET", 
			"E_RSQUAREBRACKET", "E_LCURLYBRACE", "E_RCURLYBRACE", "E_OTHER", "EI_LPAREN", 
			"EI_RPAREN", "EI_OTHER", "ESPOS_LPAREN", "ESPOS_RPAREN", "ESPOS_LSQUAREBRACKET", 
			"ESPOS_RSQUAREBRACKET", "ESPOS_LCURLYBRACE", "ESPOS_RCURLYBRACE", "ESPOS_OTHER", 
			"EACH_LPAREN", "EACH_RPAREN", "EACH_LSQUAREBRACKET", "EACH_RSQUAREBRACKET", 
			"EACH_LCURLYBRACE", "EACH_RCURLYBRACE", "EACH_OTHER", "INCF_LPAREN", 
			"INCF_RPAREN", "INCF_LSQUAREBRACKET", "INCF_RSQUAREBRACKET", "INCF_LCURLYBRACE", 
			"INCF_RCURLYBRACE", "INCF_OTHER", "MIXED_S_A_LPAREN", "MIXED_S_A_RPAREN", 
			"MIXED_S_A_LSQUAREBRACKET", "MIXED_S_A_RSQUAREBRACKET", "MIXED_S_A_LCURLYBRACE", 
			"MIXED_S_A_RCURLYBRACE", "MIXED_ASSOCIATED_VALUE_STRING", "MIXED_S_A_OTHER", 
			"FOREACH_LPAREN", "FOREACH_RPAREN", "FOREACH_LSQUAREBRACKET", "FOREACH_RSQUAREBRACKET", 
			"FOREACH_LCURLYBRACE", "FOREACH_RCURLYBRACE", "FOREACH_VAR", "FOREACH_PHP_EXPR_STRING", 
			"FOREACH_AS", "FOREACH_DOUBLE_ARROW", "FOREACH_DENTIFIER", "FOREACH_OTHER", 
			"D_ENDPHP", "BLADE_INLINE_PHP_OTHER", "VERBATIM_HTML", "PHP_INLINE_EXIT", 
			"PHP_INLINE_OTHER", "PHP_INLINE_EOF", "BLADE_COMMENT_END", "BLADE_COMMENT_MORE", 
			"BLADE_COMMENT_EOF", "D_SPATIE"
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
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
				{
				{
				setState(56);
				statement();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
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
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				blockIdentifiableArgDirective();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				blockDirective();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				identifiableArgDirective();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				multipleArgDirective();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				inlineDirective();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(69);
				customDirective();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(70);
				bladeContentTags();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(71);
				bladeRawTags();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(72);
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
				setState(73);
				errorDirectives();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(74);
				phpInline();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(75);
				match(D_ENDCUSTOM);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(76);
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
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
		public TerminalNode D_ISSET() { return getToken(BladeAntlrParser.D_ISSET, 0); }
		public TerminalNode D_ENDISSET() { return getToken(BladeAntlrParser.D_ENDISSET, 0); }
		public TerminalNode D_SESSION() { return getToken(BladeAntlrParser.D_SESSION, 0); }
		public TerminalNode D_ENDSESSION() { return getToken(BladeAntlrParser.D_ENDSESSION, 0); }
		public TerminalNode D_CONTEXT() { return getToken(BladeAntlrParser.D_CONTEXT, 0); }
		public TerminalNode D_ENDCONTEXT() { return getToken(BladeAntlrParser.D_ENDCONTEXT, 0); }
		public TerminalNode D_CAN() { return getToken(BladeAntlrParser.D_CAN, 0); }
		public TerminalNode D_ENDCAN() { return getToken(BladeAntlrParser.D_ENDCAN, 0); }
		public List<TerminalNode> D_ELSECAN() { return getTokens(BladeAntlrParser.D_ELSECAN); }
		public TerminalNode D_ELSECAN(int i) {
			return getToken(BladeAntlrParser.D_ELSECAN, i);
		}
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
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				ifStatement();
				}
				break;
			case D_FOREACH:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				foreachStatement();
				}
				break;
			case D_FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				forStatement();
				}
				break;
			case D_FORELSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				forElseStatement();
				}
				break;
			case D_WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				match(D_WHILE);
				setState(84);
				directiveArguments();
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3074436684023773096L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					setState(87);
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
					case D_CONTEXT:
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
					case D_PROPS:
					case D_AWARE:
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
						setState(85);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(86);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(92);
				match(D_ENDWHILE);
				}
				break;
			case D_SWITCH:
				enterOuterAlt(_localctx, 6);
				{
				setState(94);
				switchStatement();
				}
				break;
			case D_CSRF:
			case D_METHOD:
			case D_ERROR:
				enterOuterAlt(_localctx, 7);
				{
				setState(95);
				formStatements();
				}
				break;
			case D_AUTH:
			case D_GUEST:
			case D_ENV:
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 8);
				{
				setState(96);
				authStatements();
				}
				break;
			case D_ONCE:
				enterOuterAlt(_localctx, 9);
				{
				setState(97);
				match(D_ONCE);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(98);
					directiveArguments();
					}
				}

				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					{
					setState(101);
					statement();
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(107);
				match(D_ENDONCE);
				}
				break;
			case D_UNLESS:
				enterOuterAlt(_localctx, 10);
				{
				setState(108);
				match(D_UNLESS);
				setState(109);
				directiveArguments();
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					{
					setState(110);
					statement();
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(116);
				match(D_ENDUNLESS);
				}
				break;
			case D_EMPTY:
				enterOuterAlt(_localctx, 11);
				{
				setState(118);
				match(D_EMPTY);
				setState(119);
				directiveArguments();
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(120);
						statement();
						}
						} 
					}
					setState(125);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(126);
					match(D_ELSE);
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
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
					}
				}

				setState(135);
				match(D_ENDEMPTY);
				}
				break;
			case D_ISSET:
				enterOuterAlt(_localctx, 12);
				{
				setState(137);
				match(D_ISSET);
				setState(138);
				directiveArguments();
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(139);
						statement();
						}
						} 
					}
					setState(144);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(145);
					match(D_ELSE);
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
						{
						{
						setState(146);
						statement();
						}
						}
						setState(151);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(154);
				match(D_ENDISSET);
				}
				break;
			case D_SESSION:
				enterOuterAlt(_localctx, 13);
				{
				setState(156);
				match(D_SESSION);
				setState(157);
				directiveArguments();
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					{
					setState(158);
					statement();
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(164);
				match(D_ENDSESSION);
				}
				break;
			case D_CONTEXT:
				enterOuterAlt(_localctx, 14);
				{
				setState(166);
				match(D_CONTEXT);
				setState(167);
				directiveArguments();
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
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
				setState(174);
				match(D_ENDCONTEXT);
				}
				break;
			case D_CAN:
				enterOuterAlt(_localctx, 15);
				{
				setState(176);
				match(D_CAN);
				setState(177);
				directiveArguments();
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(178);
						statement();
						}
						} 
					}
					setState(183);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==D_ELSECAN) {
					{
					{
					setState(184);
					match(D_ELSECAN);
					setState(185);
					directiveArguments();
					setState(189);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(186);
							statement();
							}
							} 
						}
						setState(191);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
					}
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(197);
					match(D_ELSE);
					setState(201);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
						{
						{
						setState(198);
						statement();
						}
						}
						setState(203);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(206);
				match(D_ENDCAN);
				}
				break;
			case D_CANNOT:
				enterOuterAlt(_localctx, 16);
				{
				setState(208);
				match(D_CANNOT);
				setState(209);
				directiveArguments();
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(210);
						statement();
						}
						} 
					}
					setState(215);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==D_ELSECAN) {
					{
					{
					setState(216);
					match(D_ELSECAN);
					setState(217);
					directiveArguments();
					setState(221);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(218);
							statement();
							}
							} 
						}
						setState(223);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					}
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(229);
					match(D_ELSE);
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
						{
						{
						setState(230);
						statement();
						}
						}
						setState(235);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(238);
				match(D_ENDCANNOT);
				}
				break;
			case D_CANANY:
				enterOuterAlt(_localctx, 17);
				{
				setState(240);
				match(D_CANANY);
				setState(241);
				directiveArguments();
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(242);
						statement();
						}
						} 
					}
					setState(247);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==D_ELSECAN) {
					{
					{
					setState(248);
					match(D_ELSECAN);
					setState(249);
					directiveArguments();
					setState(253);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(250);
							statement();
							}
							} 
						}
						setState(255);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
					}
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(261);
					match(D_ELSE);
					setState(265);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
						{
						{
						setState(262);
						statement();
						}
						}
						setState(267);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(270);
				match(D_ENDCANANY);
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 18);
				{
				setState(272);
				bladePhpBlock();
				}
				break;
			case D_FRAGMENT:
				enterOuterAlt(_localctx, 19);
				{
				setState(273);
				match(D_FRAGMENT);
				setState(274);
				directiveArguments();
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					{
					setState(275);
					statement();
					}
					}
					setState(280);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(281);
				match(D_ENDFRAGMENT);
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 20);
				{
				setState(283);
				match(D_VERBATIM);
				setState(284);
				match(D_ENDVERBATIM);
				}
				break;
			case D_ELSE:
				enterOuterAlt(_localctx, 21);
				{
				setState(285);
				match(D_ELSE);
				setState(289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(286);
						statement();
						}
						} 
					}
					setState(291);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				}
				setState(292);
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
			setState(295);
			ifStartStatement();
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(299);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_ELSEIF:
						{
						setState(296);
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
					case D_CONTEXT:
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
					case D_PROPS:
					case D_AWARE:
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
						setState(297);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(298);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_ELSE) {
				{
				setState(304);
				match(D_ELSE);
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3074436684023773096L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					setState(307);
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
					case D_CONTEXT:
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
					case D_PROPS:
					case D_AWARE:
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
						setState(305);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(306);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(311);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(314);
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
			setState(316);
			match(D_FOREACH);
			setState(317);
			foreachLoopArguments();
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3074436684023773096L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
				{
				setState(320);
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
				case D_CONTEXT:
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
				case D_PROPS:
				case D_AWARE:
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
					setState(318);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(319);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(325);
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
			setState(327);
			match(D_FOR);
			setState(328);
			directiveArguments();
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3074436684023773096L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
				{
				setState(331);
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
				case D_CONTEXT:
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
				case D_PROPS:
				case D_AWARE:
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
					setState(329);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(330);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(336);
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
			setState(338);
			match(D_FORELSE);
			setState(339);
			directiveArguments();
			setState(344);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(342);
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
					case D_CONTEXT:
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
					case D_PROPS:
					case D_AWARE:
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
						setState(340);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(341);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(346);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			setState(347);
			match(D_EMPTY);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
				{
				{
				setState(348);
				statement();
				}
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(354);
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
			setState(356);
			match(D_IF);
			setState(357);
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
			setState(359);
			match(D_ELSEIF);
			setState(360);
			directiveArguments();
			setState(364);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(361);
					statement();
					}
					} 
				}
				setState(366);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
			setState(367);
			match(D_SWITCH);
			setState(368);
			directiveArguments();
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==D_CASE) {
				{
				{
				setState(369);
				match(D_CASE);
				setState(370);
				directiveArguments();
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
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
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_BREAK) {
					{
					setState(377);
					match(D_BREAK);
					}
				}

				}
				}
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_DEFAULT) {
				{
				setState(385);
				match(D_DEFAULT);
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					{
					setState(386);
					statement();
					}
					}
					setState(391);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(394);
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
			setState(396);
			match(D_PHP);
			setState(397);
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
		public PropsDirectiveContext propsDirective() {
			return getRuleContext(PropsDirectiveContext.class,0);
		}
		public TerminalNode D_AWARE() { return getToken(BladeAntlrParser.D_AWARE, 0); }
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
			setState(408);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SIMPLE_DIRECTIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(399);
				match(D_SIMPLE_DIRECTIVE);
				setState(400);
				directiveArguments();
				}
				break;
			case D_PROPS:
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				propsDirective();
				}
				break;
			case D_AWARE:
				enterOuterAlt(_localctx, 3);
				{
				setState(402);
				match(D_AWARE);
				setState(403);
				directiveArguments();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 4);
				{
				setState(404);
				match(D_PHP);
				setState(405);
				directiveArguments();
				}
				break;
			case D_DIRECTIVE:
				enterOuterAlt(_localctx, 5);
				{
				setState(406);
				match(D_DIRECTIVE);
				}
				break;
			case D_VITE_REFRESH:
				enterOuterAlt(_localctx, 6);
				{
				setState(407);
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
	public static class PropsDirectiveContext extends ParserRuleContext {
		public TerminalNode D_PROPS() { return getToken(BladeAntlrParser.D_PROPS, 0); }
		public TerminalNode LPAREN() { return getToken(BladeAntlrParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BladeAntlrParser.RPAREN, 0); }
		public List<TerminalNode> IDENTIFIABLE_STRING() { return getTokens(BladeAntlrParser.IDENTIFIABLE_STRING); }
		public TerminalNode IDENTIFIABLE_STRING(int i) {
			return getToken(BladeAntlrParser.IDENTIFIABLE_STRING, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BladeAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BladeAntlrParser.COMMA, i);
		}
		public PropsDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propsDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).enterPropsDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BladeAntlrParserListener ) ((BladeAntlrParserListener)listener).exitPropsDirective(this);
		}
	}

	public final PropsDirectiveContext propsDirective() throws RecognitionException {
		PropsDirectiveContext _localctx = new PropsDirectiveContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_propsDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(D_PROPS);
			setState(411);
			match(LPAREN);
			setState(413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIABLE_STRING) {
				{
				setState(412);
				match(IDENTIFIABLE_STRING);
				}
			}

			setState(421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(415);
				match(COMMA);
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(416);
					match(IDENTIFIABLE_STRING);
					}
				}

				}
				}
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(424);
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
		enterRule(_localctx, 26, RULE_identifiableArgDirective);
		int _la;
		try {
			setState(501);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(426);
				match(D_SECTION);
				setState(427);
				match(LPAREN);
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(428);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(431);
				match(COMMA);
				setState(432);
				match(RPAREN);
				}
				break;
			case D_EXTENDS:
				enterOuterAlt(_localctx, 2);
				{
				setState(433);
				match(D_EXTENDS);
				setState(434);
				match(LPAREN);
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(435);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(438);
					match(COMMA);
					}
				}

				setState(441);
				match(RPAREN);
				}
				break;
			case D_INCLUDE:
			case D_INCLUDE_IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(442);
				_la = _input.LA(1);
				if ( !(_la==D_INCLUDE || _la==D_INCLUDE_IF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(443);
				match(LPAREN);
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(444);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(447);
					match(COMMA);
					}
				}

				setState(450);
				match(RPAREN);
				}
				break;
			case D_INCLUDE_WHEN:
			case D_INCLUDE_UNLESS:
				enterOuterAlt(_localctx, 4);
				{
				setState(451);
				_la = _input.LA(1);
				if ( !(_la==D_INCLUDE_WHEN || _la==D_INCLUDE_UNLESS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(452);
				match(LPAREN);
				setState(453);
				match(COMMA);
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(454);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(458);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(457);
					match(COMMA);
					}
				}

				setState(460);
				match(RPAREN);
				}
				break;
			case D_YIELD:
				enterOuterAlt(_localctx, 5);
				{
				setState(461);
				match(D_YIELD);
				setState(462);
				match(LPAREN);
				setState(464);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(463);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(467);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(466);
					match(COMMA);
					}
				}

				setState(469);
				match(RPAREN);
				}
				break;
			case D_STACK:
				enterOuterAlt(_localctx, 6);
				{
				setState(470);
				match(D_STACK);
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
				}
				break;
			case D_LANG:
				enterOuterAlt(_localctx, 7);
				{
				setState(476);
				match(D_LANG);
				setState(477);
				match(LPAREN);
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(478);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(482);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(481);
					match(COMMA);
					}
				}

				setState(484);
				match(RPAREN);
				}
				break;
			case D_INJECT:
				enterOuterAlt(_localctx, 8);
				{
				setState(485);
				match(D_INJECT);
				setState(486);
				match(LPAREN);
				setState(487);
				match(COMMA);
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(488);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(491);
				match(RPAREN);
				}
				break;
			case D_USE:
				enterOuterAlt(_localctx, 9);
				{
				setState(492);
				match(D_USE);
				setState(493);
				match(LPAREN);
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(494);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(497);
					match(COMMA);
					}
				}

				setState(500);
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
		enterRule(_localctx, 28, RULE_multipleArgDirective);
		int _la;
		try {
			setState(544);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EACH:
				enterOuterAlt(_localctx, 1);
				{
				setState(503);
				match(D_EACH);
				setState(504);
				match(LPAREN);
				setState(506);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(505);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(508);
				match(COMMA);
				setState(509);
				match(COMMA);
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(510);
					match(COMMA);
					setState(512);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIABLE_STRING) {
						{
						setState(511);
						match(IDENTIFIABLE_STRING);
						}
					}

					}
				}

				setState(516);
				match(RPAREN);
				}
				break;
			case D_INCLUDE_FIRST:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
				match(D_INCLUDE_FIRST);
				setState(518);
				match(LPAREN);
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIABLE_STRING) {
					{
					{
					setState(519);
					match(IDENTIFIABLE_STRING);
					}
					}
					setState(524);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(526);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(525);
					match(COMMA);
					}
				}

				setState(528);
				match(RPAREN);
				}
				break;
			case D_VITE:
				enterOuterAlt(_localctx, 3);
				{
				setState(529);
				match(D_VITE);
				setState(530);
				match(LPAREN);
				setState(532);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(531);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(540);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(534);
					match(COMMA);
					setState(536);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIABLE_STRING) {
						{
						setState(535);
						match(IDENTIFIABLE_STRING);
						}
					}

					}
					}
					setState(542);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(543);
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
		public List<TerminalNode> D_PARENT() { return getTokens(BladeAntlrParser.D_PARENT); }
		public TerminalNode D_PARENT(int i) {
			return getToken(BladeAntlrParser.D_PARENT, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode D_HAS_SECTION() { return getToken(BladeAntlrParser.D_HAS_SECTION, 0); }
		public TerminalNode D_ENDIF() { return getToken(BladeAntlrParser.D_ENDIF, 0); }
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
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
		enterRule(_localctx, 30, RULE_blockIdentifiableArgDirective);
		int _la;
		try {
			int _alt;
			setState(671);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(546);
				match(D_SECTION);
				setState(547);
				match(LPAREN);
				setState(549);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(548);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(551);
				match(RPAREN);
				setState(553);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
				case 1:
					{
					setState(552);
					match(D_PARENT);
					}
					break;
				}
				setState(558);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					{
					setState(555);
					statement();
					}
					}
					setState(560);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(562);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_PARENT) {
					{
					setState(561);
					match(D_PARENT);
					}
				}

				setState(564);
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
				setState(565);
				match(D_HAS_SECTION);
				setState(566);
				match(LPAREN);
				setState(568);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(567);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(570);
				match(RPAREN);
				setState(574);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(571);
						statement();
						}
						} 
					}
					setState(576);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
				}
				setState(584);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(577);
					match(D_ELSE);
					setState(581);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
						{
						{
						setState(578);
						statement();
						}
						}
						setState(583);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(586);
				match(D_ENDIF);
				}
				break;
			case D_SECTION_MISSING:
				enterOuterAlt(_localctx, 3);
				{
				setState(587);
				match(D_SECTION_MISSING);
				setState(588);
				match(LPAREN);
				setState(590);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(589);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(592);
				match(RPAREN);
				setState(596);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(593);
						statement();
						}
						} 
					}
					setState(598);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
				}
				setState(606);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(599);
					match(D_ELSE);
					setState(603);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
						{
						{
						setState(600);
						statement();
						}
						}
						setState(605);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(608);
				match(D_ENDIF);
				}
				break;
			case D_PUSH:
				enterOuterAlt(_localctx, 4);
				{
				setState(609);
				match(D_PUSH);
				setState(610);
				match(LPAREN);
				setState(612);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(611);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(614);
				match(RPAREN);
				setState(618);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					{
					setState(615);
					statement();
					}
					}
					setState(620);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(621);
				match(D_ENDPUSH);
				}
				break;
			case D_PUSH_IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(622);
				match(D_PUSH_IF);
				setState(623);
				match(LPAREN);
				setState(625);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(624);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(627);
				match(COMMA);
				setState(628);
				match(RPAREN);
				setState(632);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(629);
						statement();
						}
						} 
					}
					setState(634);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
				}
				setState(642);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(635);
					match(D_ELSE);
					setState(639);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
						{
						{
						setState(636);
						statement();
						}
						}
						setState(641);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(644);
				match(D_ENDPUSH_IF);
				}
				break;
			case D_PUSH_ONCE:
				enterOuterAlt(_localctx, 6);
				{
				setState(645);
				match(D_PUSH_ONCE);
				setState(646);
				match(LPAREN);
				setState(648);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(647);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(650);
				match(RPAREN);
				setState(654);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					{
					setState(651);
					statement();
					}
					}
					setState(656);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(657);
				match(D_ENDPUSH_ONCE);
				}
				break;
			case D_PREPEND:
				enterOuterAlt(_localctx, 7);
				{
				setState(658);
				match(D_PREPEND);
				setState(659);
				match(LPAREN);
				setState(661);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(660);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(663);
				match(RPAREN);
				setState(667);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
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
		enterRule(_localctx, 32, RULE_directiveWithArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
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
		enterRule(_localctx, 34, RULE_customDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			match(D_CUSTOM);
			setState(677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(676);
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
		enterRule(_localctx, 36, RULE_loopBreaks);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(679);
			_la = _input.LA(1);
			if ( !(_la==D_BREAK || _la==D_CONTINUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(681);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(680);
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
		public List<ElseifStatementContext> elseifStatement() {
			return getRuleContexts(ElseifStatementContext.class);
		}
		public ElseifStatementContext elseifStatement(int i) {
			return getRuleContext(ElseifStatementContext.class,i);
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
		enterRule(_localctx, 38, RULE_formStatements);
		int _la;
		try {
			int _alt;
			setState(714);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_ERROR:
				enterOuterAlt(_localctx, 1);
				{
				setState(683);
				match(D_ERROR);
				setState(684);
				match(LPAREN);
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(685);
					match(COMMA);
					}
				}

				setState(688);
				match(RPAREN);
				setState(692);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(689);
						statement();
						}
						} 
					}
					setState(694);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
				}
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==D_ELSEIF) {
					{
					{
					setState(695);
					elseifStatement();
					}
					}
					setState(700);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(708);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(701);
					match(D_ELSE);
					setState(705);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
						{
						{
						setState(702);
						statement();
						}
						}
						setState(707);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(710);
				match(D_ENDERROR);
				}
				break;
			case D_CSRF:
				enterOuterAlt(_localctx, 2);
				{
				setState(711);
				match(D_CSRF);
				}
				break;
			case D_METHOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(712);
				match(D_METHOD);
				setState(713);
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
		enterRule(_localctx, 40, RULE_authStatements);
		int _la;
		try {
			int _alt;
			setState(765);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_AUTH:
				enterOuterAlt(_localctx, 1);
				{
				setState(716);
				match(D_AUTH);
				setState(718);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(717);
					directiveArguments();
					}
				}

				setState(723);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(720);
						statement();
						}
						} 
					}
					setState(725);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				}
				setState(733);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE || _la==D_ELSEGUEST) {
					{
					setState(726);
					_la = _input.LA(1);
					if ( !(_la==D_ELSE || _la==D_ELSEGUEST) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(730);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
						{
						{
						setState(727);
						statement();
						}
						}
						setState(732);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(735);
				match(D_ENDAUTH);
				}
				break;
			case D_GUEST:
				enterOuterAlt(_localctx, 2);
				{
				setState(736);
				match(D_GUEST);
				setState(738);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(737);
					directiveArguments();
					}
				}

				setState(743);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					{
					setState(740);
					statement();
					}
					}
					setState(745);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(746);
				match(D_ENDGUEST);
				}
				break;
			case D_ENV:
				enterOuterAlt(_localctx, 3);
				{
				setState(747);
				match(D_ENV);
				setState(748);
				directiveArguments();
				setState(752);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					{
					setState(749);
					statement();
					}
					}
					setState(754);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(755);
				match(D_ENDENV);
				}
				break;
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(757);
				match(D_PRODUCTION);
				setState(761);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 461244350486357L) != 0)) {
					{
					{
					setState(758);
					statement();
					}
					}
					setState(763);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(764);
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
		public TerminalNode D_CUSTOM() { return getToken(BladeAntlrParser.D_CUSTOM, 0); }
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
		enterRule(_localctx, 42, RULE_bladeContentTags);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			match(BLADE_CONTENT_OPEN_TAG);
			setState(769);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_CUSTOM) {
				{
				setState(768);
				match(D_CUSTOM);
				}
			}

			setState(771);
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
		enterRule(_localctx, 44, RULE_bladeRawTags);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(773);
			match(BLADE_RAW_OPEN_TAG);
			setState(774);
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
		enterRule(_localctx, 46, RULE_errorDirectives);
		int _la;
		try {
			setState(801);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EXTENDS:
			case D_INCLUDE:
			case D_YIELD:
				enterOuterAlt(_localctx, 1);
				{
				setState(776);
				directiveWithArg();
				setState(777);
				match(LPAREN);
				notifyErrorListeners("Missing closing ')'");
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(780);
				match(D_IF);
				setState(781);
				directiveArguments();
				notifyErrorListeners("Syntax error, expecting @elseif or @else or @endif");
				}
				break;
			case D_FOREACH:
			case D_FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(788);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case D_FOREACH:
					{
					setState(784);
					match(D_FOREACH);
					setState(785);
					foreachLoopArguments();
					}
					break;
				case D_FOR:
					{
					setState(786);
					match(D_FOR);
					setState(787);
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
				setState(792);
				match(D_VERBATIM);
				notifyErrorListeners("Unclosed verbatim block");
				}
				break;
			case D_SECTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(794);
				match(D_SECTION);
				setState(795);
				match(LPAREN);
				setState(797);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(796);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(799);
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
		enterRule(_localctx, 48, RULE_directiveArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(803);
			match(LPAREN);
			setState(807);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(804);
				match(COMMA);
				}
				}
				setState(809);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(810);
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
		enterRule(_localctx, 50, RULE_foreachLoopArguments);
		int _la;
		try {
			setState(845);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(812);
				match(LPAREN);
				setState(813);
				((ForeachLoopArgumentsContext)_localctx).main_array = match(FOREACH_VAR);
				setState(814);
				match(FOREACH_AS);
				setState(815);
				((ForeachLoopArgumentsContext)_localctx).array_item = match(FOREACH_VAR);
				setState(818);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOREACH_DOUBLE_ARROW) {
					{
					setState(816);
					match(FOREACH_DOUBLE_ARROW);
					setState(817);
					((ForeachLoopArgumentsContext)_localctx).array_value = match(FOREACH_VAR);
					}
				}

				setState(820);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(821);
				match(LPAREN);
				setState(825);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FOREACH_VAR) {
					{
					{
					setState(822);
					match(FOREACH_VAR);
					}
					}
					setState(827);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(828);
				match(FOREACH_AS);
				setState(832);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FOREACH_VAR) {
					{
					{
					setState(829);
					match(FOREACH_VAR);
					}
					}
					setState(834);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(842);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOREACH_DOUBLE_ARROW) {
					{
					setState(835);
					match(FOREACH_DOUBLE_ARROW);
					setState(839);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==FOREACH_VAR) {
						{
						{
						setState(836);
						match(FOREACH_VAR);
						}
						}
						setState(841);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(844);
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
		public TerminalNode EOF() { return getToken(BladeAntlrParser.EOF, 0); }
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
		enterRule(_localctx, 52, RULE_phpInline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(847);
			match(PHP_INLINE_START);
			setState(848);
			((PhpInlineContext)_localctx).phpInlineEnd = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==PHP_INLINE_EXIT) ) {
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
		enterRule(_localctx, 54, RULE_htmlComponentOpenTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(850);
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
		"\u0004\u0001\u00b3\u0355\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0001\u0000\u0005\u0000:\b\u0000\n\u0000\f\u0000=\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001N\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002X\b\u0002\n\u0002\f\u0002[\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002d\b\u0002\u0001\u0002\u0005\u0002g\b\u0002\n\u0002\f\u0002j\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002p\b\u0002"+
		"\n\u0002\f\u0002s\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002z\b\u0002\n\u0002\f\u0002}\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002\u0081\b\u0002\n\u0002\f\u0002\u0084\t\u0002\u0003"+
		"\u0002\u0086\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u008d\b\u0002\n\u0002\f\u0002\u0090\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002\u0094\b\u0002\n\u0002\f\u0002\u0097\t\u0002\u0003"+
		"\u0002\u0099\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u00a0\b\u0002\n\u0002\f\u0002\u00a3\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00aa\b\u0002"+
		"\n\u0002\f\u0002\u00ad\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002\u00b4\b\u0002\n\u0002\f\u0002\u00b7\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00bc\b\u0002\n\u0002"+
		"\f\u0002\u00bf\t\u0002\u0005\u0002\u00c1\b\u0002\n\u0002\f\u0002\u00c4"+
		"\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00c8\b\u0002\n\u0002\f\u0002"+
		"\u00cb\t\u0002\u0003\u0002\u00cd\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00d4\b\u0002\n\u0002\f\u0002"+
		"\u00d7\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00dc\b"+
		"\u0002\n\u0002\f\u0002\u00df\t\u0002\u0005\u0002\u00e1\b\u0002\n\u0002"+
		"\f\u0002\u00e4\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00e8\b\u0002"+
		"\n\u0002\f\u0002\u00eb\t\u0002\u0003\u0002\u00ed\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00f4\b\u0002\n"+
		"\u0002\f\u0002\u00f7\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002\u00fc\b\u0002\n\u0002\f\u0002\u00ff\t\u0002\u0005\u0002\u0101\b"+
		"\u0002\n\u0002\f\u0002\u0104\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u0108\b\u0002\n\u0002\f\u0002\u010b\t\u0002\u0003\u0002\u010d\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u0115\b\u0002\n\u0002\f\u0002\u0118\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0120"+
		"\b\u0002\n\u0002\f\u0002\u0123\t\u0002\u0001\u0002\u0003\u0002\u0126\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u012c"+
		"\b\u0003\n\u0003\f\u0003\u012f\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003\u0134\b\u0003\n\u0003\f\u0003\u0137\t\u0003\u0003\u0003\u0139"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u0141\b\u0004\n\u0004\f\u0004\u0144\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u014c\b\u0005\n\u0005\f\u0005\u014f\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0157\b\u0006\n"+
		"\u0006\f\u0006\u015a\t\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u015e"+
		"\b\u0006\n\u0006\f\u0006\u0161\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u016b\b\b\n\b"+
		"\f\b\u016e\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0175\b"+
		"\t\n\t\f\t\u0178\t\t\u0001\t\u0003\t\u017b\b\t\u0005\t\u017d\b\t\n\t\f"+
		"\t\u0180\t\t\u0001\t\u0001\t\u0005\t\u0184\b\t\n\t\f\t\u0187\t\t\u0003"+
		"\t\u0189\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u0199\b\u000b\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u019e\b\f\u0001\f\u0001\f\u0003\f\u01a2\b\f\u0005\f\u01a4\b\f\n\f\f"+
		"\f\u01a7\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0003\r\u01ae\b\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u01b5\b\r\u0001\r\u0003"+
		"\r\u01b8\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u01be\b\r\u0001\r"+
		"\u0003\r\u01c1\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u01c8"+
		"\b\r\u0001\r\u0003\r\u01cb\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r"+
		"\u01d1\b\r\u0001\r\u0003\r\u01d4\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u01da\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u01e0\b\r\u0001\r"+
		"\u0003\r\u01e3\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u01ea"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u01f0\b\r\u0001\r\u0003\r"+
		"\u01f3\b\r\u0001\r\u0003\r\u01f6\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u01fb\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u0201\b\u000e\u0003\u000e\u0203\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0209\b\u000e\n\u000e\f\u000e"+
		"\u020c\t\u000e\u0001\u000e\u0003\u000e\u020f\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0215\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u0219\b\u000e\u0005\u000e\u021b\b\u000e\n\u000e\f\u000e"+
		"\u021e\t\u000e\u0001\u000e\u0003\u000e\u0221\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u0226\b\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u022a\b\u000f\u0001\u000f\u0005\u000f\u022d\b\u000f\n\u000f\f\u000f"+
		"\u0230\t\u000f\u0001\u000f\u0003\u000f\u0233\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0239\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u023d\b\u000f\n\u000f\f\u000f\u0240\t\u000f\u0001\u000f"+
		"\u0001\u000f\u0005\u000f\u0244\b\u000f\n\u000f\f\u000f\u0247\t\u000f\u0003"+
		"\u000f\u0249\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u024f\b\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0253\b\u000f"+
		"\n\u000f\f\u000f\u0256\t\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u025a"+
		"\b\u000f\n\u000f\f\u000f\u025d\t\u000f\u0003\u000f\u025f\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0265\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u0269\b\u000f\n\u000f\f\u000f\u026c\t\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0272\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0277\b\u000f\n\u000f"+
		"\f\u000f\u027a\t\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u027e\b\u000f"+
		"\n\u000f\f\u000f\u0281\t\u000f\u0003\u000f\u0283\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0289\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u028d\b\u000f\n\u000f\f\u000f\u0290\t\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0296\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0005\u000f\u029a\b\u000f\n\u000f\f\u000f\u029d\t\u000f\u0001"+
		"\u000f\u0003\u000f\u02a0\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u02a6\b\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u02aa"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u02af\b\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u02b3\b\u0013\n\u0013\f\u0013\u02b6"+
		"\t\u0013\u0001\u0013\u0005\u0013\u02b9\b\u0013\n\u0013\f\u0013\u02bc\t"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u02c0\b\u0013\n\u0013\f\u0013"+
		"\u02c3\t\u0013\u0003\u0013\u02c5\b\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u02cb\b\u0013\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u02cf\b\u0014\u0001\u0014\u0005\u0014\u02d2\b\u0014\n\u0014\f\u0014"+
		"\u02d5\t\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u02d9\b\u0014\n\u0014"+
		"\f\u0014\u02dc\t\u0014\u0003\u0014\u02de\b\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u02e3\b\u0014\u0001\u0014\u0005\u0014\u02e6\b"+
		"\u0014\n\u0014\f\u0014\u02e9\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u02ef\b\u0014\n\u0014\f\u0014\u02f2\t\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u02f8\b\u0014\n"+
		"\u0014\f\u0014\u02fb\t\u0014\u0001\u0014\u0003\u0014\u02fe\b\u0014\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u0302\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0315\b\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u031e\b\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0322\b\u0017"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u0326\b\u0018\n\u0018\f\u0018\u0329"+
		"\t\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0333\b\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0005\u0019\u0338\b\u0019\n\u0019\f\u0019\u033b\t\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u033f\b\u0019\n\u0019\f\u0019\u0342"+
		"\t\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0346\b\u0019\n\u0019\f\u0019"+
		"\u0349\t\u0019\u0003\u0019\u034b\b\u0019\u0001\u0019\u0003\u0019\u034e"+
		"\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0000\u0000\u001c\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0246\u0000\b\u0002\u0000"+
		"\u0006\u0006ii\u0001\u0000\u001b\u001c\u0001\u0000\u001d\u001e\u0002\u0000"+
		"%%\'*\u0002\u0000\u001a\u001b!!\u0001\u0000>?\u0002\u0000\u0010\u0010"+
		"OO\u0001\u0001\u00ad\u00ad\u03f1\u0000;\u0001\u0000\u0000\u0000\u0002"+
		"M\u0001\u0000\u0000\u0000\u0004\u0125\u0001\u0000\u0000\u0000\u0006\u0127"+
		"\u0001\u0000\u0000\u0000\b\u013c\u0001\u0000\u0000\u0000\n\u0147\u0001"+
		"\u0000\u0000\u0000\f\u0152\u0001\u0000\u0000\u0000\u000e\u0164\u0001\u0000"+
		"\u0000\u0000\u0010\u0167\u0001\u0000\u0000\u0000\u0012\u016f\u0001\u0000"+
		"\u0000\u0000\u0014\u018c\u0001\u0000\u0000\u0000\u0016\u0198\u0001\u0000"+
		"\u0000\u0000\u0018\u019a\u0001\u0000\u0000\u0000\u001a\u01f5\u0001\u0000"+
		"\u0000\u0000\u001c\u0220\u0001\u0000\u0000\u0000\u001e\u029f\u0001\u0000"+
		"\u0000\u0000 \u02a1\u0001\u0000\u0000\u0000\"\u02a3\u0001\u0000\u0000"+
		"\u0000$\u02a7\u0001\u0000\u0000\u0000&\u02ca\u0001\u0000\u0000\u0000("+
		"\u02fd\u0001\u0000\u0000\u0000*\u02ff\u0001\u0000\u0000\u0000,\u0305\u0001"+
		"\u0000\u0000\u0000.\u0321\u0001\u0000\u0000\u00000\u0323\u0001\u0000\u0000"+
		"\u00002\u034d\u0001\u0000\u0000\u00004\u034f\u0001\u0000\u0000\u00006"+
		"\u0352\u0001\u0000\u0000\u00008:\u0003\u0002\u0001\u000098\u0001\u0000"+
		"\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		">?\u0005\u0000\u0000\u0001?\u0001\u0001\u0000\u0000\u0000@N\u0003\u001e"+
		"\u000f\u0000AN\u0003\u0004\u0002\u0000BN\u0003\u001a\r\u0000CN\u0003\u001c"+
		"\u000e\u0000DN\u0003\u0016\u000b\u0000EN\u0003\"\u0011\u0000FN\u0003*"+
		"\u0015\u0000GN\u0003,\u0016\u0000HN\u0007\u0000\u0000\u0000IN\u0003.\u0017"+
		"\u0000JN\u00034\u001a\u0000KN\u0005m\u0000\u0000LN\u00036\u001b\u0000"+
		"M@\u0001\u0000\u0000\u0000MA\u0001\u0000\u0000\u0000MB\u0001\u0000\u0000"+
		"\u0000MC\u0001\u0000\u0000\u0000MD\u0001\u0000\u0000\u0000ME\u0001\u0000"+
		"\u0000\u0000MF\u0001\u0000\u0000\u0000MG\u0001\u0000\u0000\u0000MH\u0001"+
		"\u0000\u0000\u0000MI\u0001\u0000\u0000\u0000MJ\u0001\u0000\u0000\u0000"+
		"MK\u0001\u0000\u0000\u0000ML\u0001\u0000\u0000\u0000N\u0003\u0001\u0000"+
		"\u0000\u0000O\u0126\u0003\u0006\u0003\u0000P\u0126\u0003\b\u0004\u0000"+
		"Q\u0126\u0003\n\u0005\u0000R\u0126\u0003\f\u0006\u0000ST\u0005<\u0000"+
		"\u0000TY\u00030\u0018\u0000UX\u0003\u0002\u0001\u0000VX\u0003$\u0012\u0000"+
		"WU\u0001\u0000\u0000\u0000WV\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000"+
		"\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000"+
		"\u0000\u0000[Y\u0001\u0000\u0000\u0000\\]\u0005=\u0000\u0000]\u0126\u0001"+
		"\u0000\u0000\u0000^\u0126\u0003\u0012\t\u0000_\u0126\u0003&\u0013\u0000"+
		"`\u0126\u0003(\u0014\u0000ac\u0005+\u0000\u0000bd\u00030\u0018\u0000c"+
		"b\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000dh\u0001\u0000\u0000"+
		"\u0000eg\u0003\u0002\u0001\u0000fe\u0001\u0000\u0000\u0000gj\u0001\u0000"+
		"\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001"+
		"\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000k\u0126\u0005,\u0000\u0000"+
		"lm\u0005\u0012\u0000\u0000mq\u00030\u0018\u0000np\u0003\u0002\u0001\u0000"+
		"on\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000qr\u0001\u0000\u0000\u0000rt\u0001\u0000\u0000\u0000sq\u0001\u0000"+
		"\u0000\u0000tu\u0005\u0013\u0000\u0000u\u0126\u0001\u0000\u0000\u0000"+
		"vw\u0005@\u0000\u0000w{\u00030\u0018\u0000xz\u0003\u0002\u0001\u0000y"+
		"x\u0001\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|\u0085\u0001\u0000\u0000\u0000}{\u0001"+
		"\u0000\u0000\u0000~\u0082\u0005\u0010\u0000\u0000\u007f\u0081\u0003\u0002"+
		"\u0001\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000"+
		"\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000"+
		"\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000"+
		"\u0000\u0000\u0085~\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0005A\u0000\u0000"+
		"\u0088\u0126\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u0014\u0000\u0000"+
		"\u008a\u008e\u00030\u0018\u0000\u008b\u008d\u0003\u0002\u0001\u0000\u008c"+
		"\u008b\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e"+
		"\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u0098\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091"+
		"\u0095\u0005\u0010\u0000\u0000\u0092\u0094\u0003\u0002\u0001\u0000\u0093"+
		"\u0092\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095"+
		"\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096"+
		"\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098"+
		"\u0091\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0015\u0000\u0000\u009b"+
		"\u0126\u0001\u0000\u0000\u0000\u009c\u009d\u0005D\u0000\u0000\u009d\u00a1"+
		"\u00030\u0018\u0000\u009e\u00a0\u0003\u0002\u0001\u0000\u009f\u009e\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005"+
		"E\u0000\u0000\u00a5\u0126\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005F\u0000"+
		"\u0000\u00a7\u00ab\u00030\u0018\u0000\u00a8\u00aa\u0003\u0002\u0001\u0000"+
		"\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0005G\u0000\u0000\u00af\u0126\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\u0005U\u0000\u0000\u00b1\u00b5\u00030\u0018\u0000\u00b2\u00b4\u0003"+
		"\u0002\u0001\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b6\u00c2\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u0005Y\u0000\u0000\u00b9\u00bd\u00030\u0018"+
		"\u0000\u00ba\u00bc\u0003\u0002\u0001\u0000\u00bb\u00ba\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000"+
		"\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00b8\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00cc\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u00c9\u0005\u0010\u0000"+
		"\u0000\u00c6\u00c8\u0003\u0002\u0001\u0000\u00c7\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000"+
		"\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00c5\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0005V\u0000\u0000\u00cf\u0126\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0005W\u0000\u0000\u00d1\u00d5\u00030\u0018\u0000\u00d2\u00d4"+
		"\u0003\u0002\u0001\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d6\u00e2\u0001\u0000\u0000\u0000\u00d7\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005Y\u0000\u0000\u00d9\u00dd\u0003"+
		"0\u0018\u0000\u00da\u00dc\u0003\u0002\u0001\u0000\u00db\u00da\u0001\u0000"+
		"\u0000\u0000\u00dc\u00df\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000"+
		"\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00e1\u0001\u0000"+
		"\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00d8\u0001\u0000"+
		"\u0000\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00ec\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e9\u0005\u0010"+
		"\u0000\u0000\u00e6\u00e8\u0003\u0002\u0001\u0000\u00e7\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00ed\u0001\u0000"+
		"\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00e5\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ef\u0005Z\u0000\u0000\u00ef\u0126\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0005X\u0000\u0000\u00f1\u00f5\u00030\u0018\u0000\u00f2"+
		"\u00f4\u0003\u0002\u0001\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f7\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f6\u0001\u0000\u0000\u0000\u00f6\u0102\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005Y\u0000\u0000\u00f9\u00fd"+
		"\u00030\u0018\u0000\u00fa\u00fc\u0003\u0002\u0001\u0000\u00fb\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fc\u00ff\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u0101\u0001"+
		"\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u0100\u00f8\u0001"+
		"\u0000\u0000\u0000\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0100\u0001"+
		"\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u010c\u0001"+
		"\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u0109\u0005"+
		"\u0010\u0000\u0000\u0106\u0108\u0003\u0002\u0001\u0000\u0107\u0106\u0001"+
		"\u0000\u0000\u0000\u0108\u010b\u0001\u0000\u0000\u0000\u0109\u0107\u0001"+
		"\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010d\u0001"+
		"\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c\u0105\u0001"+
		"\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010e\u0001"+
		"\u0000\u0000\u0000\u010e\u010f\u0005[\u0000\u0000\u010f\u0126\u0001\u0000"+
		"\u0000\u0000\u0110\u0126\u0003\u0014\n\u0000\u0111\u0112\u0005\\\u0000"+
		"\u0000\u0112\u0116\u00030\u0018\u0000\u0113\u0115\u0003\u0002\u0001\u0000"+
		"\u0114\u0113\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000\u0000\u0000"+
		"\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000"+
		"\u0117\u0119\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000"+
		"\u0119\u011a\u0005]\u0000\u0000\u011a\u0126\u0001\u0000\u0000\u0000\u011b"+
		"\u011c\u0005B\u0000\u0000\u011c\u0126\u0005C\u0000\u0000\u011d\u0121\u0005"+
		"\u0010\u0000\u0000\u011e\u0120\u0003\u0002\u0001\u0000\u011f\u011e\u0001"+
		"\u0000\u0000\u0000\u0120\u0123\u0001\u0000\u0000\u0000\u0121\u011f\u0001"+
		"\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122\u0124\u0001"+
		"\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0124\u0126\u0005"+
		"m\u0000\u0000\u0125O\u0001\u0000\u0000\u0000\u0125P\u0001\u0000\u0000"+
		"\u0000\u0125Q\u0001\u0000\u0000\u0000\u0125R\u0001\u0000\u0000\u0000\u0125"+
		"S\u0001\u0000\u0000\u0000\u0125^\u0001\u0000\u0000\u0000\u0125_\u0001"+
		"\u0000\u0000\u0000\u0125`\u0001\u0000\u0000\u0000\u0125a\u0001\u0000\u0000"+
		"\u0000\u0125l\u0001\u0000\u0000\u0000\u0125v\u0001\u0000\u0000\u0000\u0125"+
		"\u0089\u0001\u0000\u0000\u0000\u0125\u009c\u0001\u0000\u0000\u0000\u0125"+
		"\u00a6\u0001\u0000\u0000\u0000\u0125\u00b0\u0001\u0000\u0000\u0000\u0125"+
		"\u00d0\u0001\u0000\u0000\u0000\u0125\u00f0\u0001\u0000\u0000\u0000\u0125"+
		"\u0110\u0001\u0000\u0000\u0000\u0125\u0111\u0001\u0000\u0000\u0000\u0125"+
		"\u011b\u0001\u0000\u0000\u0000\u0125\u011d\u0001\u0000\u0000\u0000\u0126"+
		"\u0005\u0001\u0000\u0000\u0000\u0127\u012d\u0003\u000e\u0007\u0000\u0128"+
		"\u012c\u0003\u0010\b\u0000\u0129\u012c\u0003\u0002\u0001\u0000\u012a\u012c"+
		"\u0003$\u0012\u0000\u012b\u0128\u0001\u0000\u0000\u0000\u012b\u0129\u0001"+
		"\u0000\u0000\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c\u012f\u0001"+
		"\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001"+
		"\u0000\u0000\u0000\u012e\u0138\u0001\u0000\u0000\u0000\u012f\u012d\u0001"+
		"\u0000\u0000\u0000\u0130\u0135\u0005\u0010\u0000\u0000\u0131\u0134\u0003"+
		"\u0002\u0001\u0000\u0132\u0134\u0003$\u0012\u0000\u0133\u0131\u0001\u0000"+
		"\u0000\u0000\u0133\u0132\u0001\u0000\u0000\u0000\u0134\u0137\u0001\u0000"+
		"\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000"+
		"\u0000\u0000\u0136\u0139\u0001\u0000\u0000\u0000\u0137\u0135\u0001\u0000"+
		"\u0000\u0000\u0138\u0130\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000"+
		"\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013b\u0005\u0011"+
		"\u0000\u0000\u013b\u0007\u0001\u0000\u0000\u0000\u013c\u013d\u00056\u0000"+
		"\u0000\u013d\u0142\u00032\u0019\u0000\u013e\u0141\u0003\u0002\u0001\u0000"+
		"\u013f\u0141\u0003$\u0012\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140"+
		"\u013f\u0001\u0000\u0000\u0000\u0141\u0144\u0001\u0000\u0000\u0000\u0142"+
		"\u0140\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143"+
		"\u0145\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0145"+
		"\u0146\u00057\u0000\u0000\u0146\t\u0001\u0000\u0000\u0000\u0147\u0148"+
		"\u00058\u0000\u0000\u0148\u014d\u00030\u0018\u0000\u0149\u014c\u0003\u0002"+
		"\u0001\u0000\u014a\u014c\u0003$\u0012\u0000\u014b\u0149\u0001\u0000\u0000"+
		"\u0000\u014b\u014a\u0001\u0000\u0000\u0000\u014c\u014f\u0001\u0000\u0000"+
		"\u0000\u014d\u014b\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000"+
		"\u0000\u014e\u0150\u0001\u0000\u0000\u0000\u014f\u014d\u0001\u0000\u0000"+
		"\u0000\u0150\u0151\u00059\u0000\u0000\u0151\u000b\u0001\u0000\u0000\u0000"+
		"\u0152\u0153\u0005:\u0000\u0000\u0153\u0158\u00030\u0018\u0000\u0154\u0157"+
		"\u0003\u0002\u0001\u0000\u0155\u0157\u0003$\u0012\u0000\u0156\u0154\u0001"+
		"\u0000\u0000\u0000\u0156\u0155\u0001\u0000\u0000\u0000\u0157\u015a\u0001"+
		"\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001"+
		"\u0000\u0000\u0000\u0159\u015b\u0001\u0000\u0000\u0000\u015a\u0158\u0001"+
		"\u0000\u0000\u0000\u015b\u015f\u0005@\u0000\u0000\u015c\u015e\u0003\u0002"+
		"\u0001\u0000\u015d\u015c\u0001\u0000\u0000\u0000\u015e\u0161\u0001\u0000"+
		"\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000"+
		"\u0000\u0000\u0160\u0162\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000"+
		"\u0000\u0000\u0162\u0163\u0005;\u0000\u0000\u0163\r\u0001\u0000\u0000"+
		"\u0000\u0164\u0165\u0005\u000e\u0000\u0000\u0165\u0166\u00030\u0018\u0000"+
		"\u0166\u000f\u0001\u0000\u0000\u0000\u0167\u0168\u0005\u000f\u0000\u0000"+
		"\u0168\u016c\u00030\u0018\u0000\u0169\u016b\u0003\u0002\u0001\u0000\u016a"+
		"\u0169\u0001\u0000\u0000\u0000\u016b\u016e\u0001\u0000\u0000\u0000\u016c"+
		"\u016a\u0001\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d"+
		"\u0011\u0001\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016f"+
		"\u0170\u0005\u0016\u0000\u0000\u0170\u017e\u00030\u0018\u0000\u0171\u0172"+
		"\u0005\u0017\u0000\u0000\u0172\u0176\u00030\u0018\u0000\u0173\u0175\u0003"+
		"\u0002\u0001\u0000\u0174\u0173\u0001\u0000\u0000\u0000\u0175\u0178\u0001"+
		"\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0176\u0177\u0001"+
		"\u0000\u0000\u0000\u0177\u017a\u0001\u0000\u0000\u0000\u0178\u0176\u0001"+
		"\u0000\u0000\u0000\u0179\u017b\u0005>\u0000\u0000\u017a\u0179\u0001\u0000"+
		"\u0000\u0000\u017a\u017b\u0001\u0000\u0000\u0000\u017b\u017d\u0001\u0000"+
		"\u0000\u0000\u017c\u0171\u0001\u0000\u0000\u0000\u017d\u0180\u0001\u0000"+
		"\u0000\u0000\u017e\u017c\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000"+
		"\u0000\u0000\u017f\u0188\u0001\u0000\u0000\u0000\u0180\u017e\u0001\u0000"+
		"\u0000\u0000\u0181\u0185\u0005\u0018\u0000\u0000\u0182\u0184\u0003\u0002"+
		"\u0001\u0000\u0183\u0182\u0001\u0000\u0000\u0000\u0184\u0187\u0001\u0000"+
		"\u0000\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000"+
		"\u0000\u0000\u0186\u0189\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000"+
		"\u0000\u0000\u0188\u0181\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000"+
		"\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a\u018b\u0005\u0019"+
		"\u0000\u0000\u018b\u0013\u0001\u0000\u0000\u0000\u018c\u018d\u0005\u000b"+
		"\u0000\u0000\u018d\u018e\u0005\u00aa\u0000\u0000\u018e\u0015\u0001\u0000"+
		"\u0000\u0000\u018f\u0190\u0005^\u0000\u0000\u0190\u0199\u00030\u0018\u0000"+
		"\u0191\u0199\u0003\u0018\f\u0000\u0192\u0193\u0005`\u0000\u0000\u0193"+
		"\u0199\u00030\u0018\u0000\u0194\u0195\u0005\u000b\u0000\u0000\u0195\u0199"+
		"\u00030\u0018\u0000\u0196\u0199\u0005\u0004\u0000\u0000\u0197\u0199\u0005"+
		"b\u0000\u0000\u0198\u018f\u0001\u0000\u0000\u0000\u0198\u0191\u0001\u0000"+
		"\u0000\u0000\u0198\u0192\u0001\u0000\u0000\u0000\u0198\u0194\u0001\u0000"+
		"\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0198\u0197\u0001\u0000"+
		"\u0000\u0000\u0199\u0017\u0001\u0000\u0000\u0000\u019a\u019b\u0005_\u0000"+
		"\u0000\u019b\u019d\u0005\u0001\u0000\u0000\u019c\u019e\u0005\u0005\u0000"+
		"\u0000\u019d\u019c\u0001\u0000\u0000\u0000\u019d\u019e\u0001\u0000\u0000"+
		"\u0000\u019e\u01a5\u0001\u0000\u0000\u0000\u019f\u01a1\u0005\f\u0000\u0000"+
		"\u01a0\u01a2\u0005\u0005\u0000\u0000\u01a1\u01a0\u0001\u0000\u0000\u0000"+
		"\u01a1\u01a2\u0001\u0000\u0000\u0000\u01a2\u01a4\u0001\u0000\u0000\u0000"+
		"\u01a3\u019f\u0001\u0000\u0000\u0000\u01a4\u01a7\u0001\u0000\u0000\u0000"+
		"\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000"+
		"\u01a6\u01a8\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000"+
		"\u01a8\u01a9\u0005\u0002\u0000\u0000\u01a9\u0019\u0001\u0000\u0000\u0000"+
		"\u01aa\u01ab\u0005\"\u0000\u0000\u01ab\u01ad\u0005\u0001\u0000\u0000\u01ac"+
		"\u01ae\u0005\u0005\u0000\u0000\u01ad\u01ac\u0001\u0000\u0000\u0000\u01ad"+
		"\u01ae\u0001\u0000\u0000\u0000\u01ae\u01af\u0001\u0000\u0000\u0000\u01af"+
		"\u01b0\u0005\f\u0000\u0000\u01b0\u01f6\u0005\u0002\u0000\u0000\u01b1\u01b2"+
		"\u0005\u001a\u0000\u0000\u01b2\u01b4\u0005\u0001\u0000\u0000\u01b3\u01b5"+
		"\u0005\u0005\u0000\u0000\u01b4\u01b3\u0001\u0000\u0000\u0000\u01b4\u01b5"+
		"\u0001\u0000\u0000\u0000\u01b5\u01b7\u0001\u0000\u0000\u0000\u01b6\u01b8"+
		"\u0005\f\u0000\u0000\u01b7\u01b6\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001"+
		"\u0000\u0000\u0000\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01f6\u0005"+
		"\u0002\u0000\u0000\u01ba\u01bb\u0007\u0001\u0000\u0000\u01bb\u01bd\u0005"+
		"\u0001\u0000\u0000\u01bc\u01be\u0005\u0005\u0000\u0000\u01bd\u01bc\u0001"+
		"\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000\u0000\u01be\u01c0\u0001"+
		"\u0000\u0000\u0000\u01bf\u01c1\u0005\f\u0000\u0000\u01c0\u01bf\u0001\u0000"+
		"\u0000\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000"+
		"\u0000\u0000\u01c2\u01f6\u0005\u0002\u0000\u0000\u01c3\u01c4\u0007\u0002"+
		"\u0000\u0000\u01c4\u01c5\u0005\u0001\u0000\u0000\u01c5\u01c7\u0005\f\u0000"+
		"\u0000\u01c6\u01c8\u0005\u0005\u0000\u0000\u01c7\u01c6\u0001\u0000\u0000"+
		"\u0000\u01c7\u01c8\u0001\u0000\u0000\u0000\u01c8\u01ca\u0001\u0000\u0000"+
		"\u0000\u01c9\u01cb\u0005\f\u0000\u0000\u01ca\u01c9\u0001\u0000\u0000\u0000"+
		"\u01ca\u01cb\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001\u0000\u0000\u0000"+
		"\u01cc\u01f6\u0005\u0002\u0000\u0000\u01cd\u01ce\u0005!\u0000\u0000\u01ce"+
		"\u01d0\u0005\u0001\u0000\u0000\u01cf\u01d1\u0005\u0005\u0000\u0000\u01d0"+
		"\u01cf\u0001\u0000\u0000\u0000\u01d0\u01d1\u0001\u0000\u0000\u0000\u01d1"+
		"\u01d3\u0001\u0000\u0000\u0000\u01d2\u01d4\u0005\f\u0000\u0000\u01d3\u01d2"+
		"\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4\u01d5"+
		"\u0001\u0000\u0000\u0000\u01d5\u01f6\u0005\u0002\u0000\u0000\u01d6\u01d7"+
		"\u0005-\u0000\u0000\u01d7\u01d9\u0005\u0001\u0000\u0000\u01d8\u01da\u0005"+
		"\u0005\u0000\u0000\u01d9\u01d8\u0001\u0000\u0000\u0000\u01d9\u01da\u0001"+
		"\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01f6\u0005"+
		"\u0002\u0000\u0000\u01dc\u01dd\u0005c\u0000\u0000\u01dd\u01df\u0005\u0001"+
		"\u0000\u0000\u01de\u01e0\u0005\u0005\u0000\u0000\u01df\u01de\u0001\u0000"+
		"\u0000\u0000\u01df\u01e0\u0001\u0000\u0000\u0000\u01e0\u01e2\u0001\u0000"+
		"\u0000\u0000\u01e1\u01e3\u0005\f\u0000\u0000\u01e2\u01e1\u0001\u0000\u0000"+
		"\u0000\u01e2\u01e3\u0001\u0000\u0000\u0000\u01e3\u01e4\u0001\u0000\u0000"+
		"\u0000\u01e4\u01f6\u0005\u0002\u0000\u0000\u01e5\u01e6\u0005d\u0000\u0000"+
		"\u01e6\u01e7\u0005\u0001\u0000\u0000\u01e7\u01e9\u0005\f\u0000\u0000\u01e8"+
		"\u01ea\u0005\u0005\u0000\u0000\u01e9\u01e8\u0001\u0000\u0000\u0000\u01e9"+
		"\u01ea\u0001\u0000\u0000\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000\u01eb"+
		"\u01f6\u0005\u0002\u0000\u0000\u01ec\u01ed\u0005e\u0000\u0000\u01ed\u01ef"+
		"\u0005\u0001\u0000\u0000\u01ee\u01f0\u0005\u0005\u0000\u0000\u01ef\u01ee"+
		"\u0001\u0000\u0000\u0000\u01ef\u01f0\u0001\u0000\u0000\u0000\u01f0\u01f2"+
		"\u0001\u0000\u0000\u0000\u01f1\u01f3\u0005\f\u0000\u0000\u01f2\u01f1\u0001"+
		"\u0000\u0000\u0000\u01f2\u01f3\u0001\u0000\u0000\u0000\u01f3\u01f4\u0001"+
		"\u0000\u0000\u0000\u01f4\u01f6\u0005\u0002\u0000\u0000\u01f5\u01aa\u0001"+
		"\u0000\u0000\u0000\u01f5\u01b1\u0001\u0000\u0000\u0000\u01f5\u01ba\u0001"+
		"\u0000\u0000\u0000\u01f5\u01c3\u0001\u0000\u0000\u0000\u01f5\u01cd\u0001"+
		"\u0000\u0000\u0000\u01f5\u01d6\u0001\u0000\u0000\u0000\u01f5\u01dc\u0001"+
		"\u0000\u0000\u0000\u01f5\u01e5\u0001\u0000\u0000\u0000\u01f5\u01ec\u0001"+
		"\u0000\u0000\u0000\u01f6\u001b\u0001\u0000\u0000\u0000\u01f7\u01f8\u0005"+
		" \u0000\u0000\u01f8\u01fa\u0005\u0001\u0000\u0000\u01f9\u01fb\u0005\u0005"+
		"\u0000\u0000\u01fa\u01f9\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000"+
		"\u0000\u0000\u01fb\u01fc\u0001\u0000\u0000\u0000\u01fc\u01fd\u0005\f\u0000"+
		"\u0000\u01fd\u0202\u0005\f\u0000\u0000\u01fe\u0200\u0005\f\u0000\u0000"+
		"\u01ff\u0201\u0005\u0005\u0000\u0000\u0200\u01ff\u0001\u0000\u0000\u0000"+
		"\u0200\u0201\u0001\u0000\u0000\u0000\u0201\u0203\u0001\u0000\u0000\u0000"+
		"\u0202\u01fe\u0001\u0000\u0000\u0000\u0202\u0203\u0001\u0000\u0000\u0000"+
		"\u0203\u0204\u0001\u0000\u0000\u0000\u0204\u0221\u0005\u0002\u0000\u0000"+
		"\u0205\u0206\u0005\u001f\u0000\u0000\u0206\u020a\u0005\u0001\u0000\u0000"+
		"\u0207\u0209\u0005\u0005\u0000\u0000\u0208\u0207\u0001\u0000\u0000\u0000"+
		"\u0209\u020c\u0001\u0000\u0000\u0000\u020a\u0208\u0001\u0000\u0000\u0000"+
		"\u020a\u020b\u0001\u0000\u0000\u0000\u020b\u020e\u0001\u0000\u0000\u0000"+
		"\u020c\u020a\u0001\u0000\u0000\u0000\u020d\u020f\u0005\f\u0000\u0000\u020e"+
		"\u020d\u0001\u0000\u0000\u0000\u020e\u020f\u0001\u0000\u0000\u0000\u020f"+
		"\u0210\u0001\u0000\u0000\u0000\u0210\u0221\u0005\u0002\u0000\u0000\u0211"+
		"\u0212\u0005a\u0000\u0000\u0212\u0214\u0005\u0001\u0000\u0000\u0213\u0215"+
		"\u0005\u0005\u0000\u0000\u0214\u0213\u0001\u0000\u0000\u0000\u0214\u0215"+
		"\u0001\u0000\u0000\u0000\u0215\u021c\u0001\u0000\u0000\u0000\u0216\u0218"+
		"\u0005\f\u0000\u0000\u0217\u0219\u0005\u0005\u0000\u0000\u0218\u0217\u0001"+
		"\u0000\u0000\u0000\u0218\u0219\u0001\u0000\u0000\u0000\u0219\u021b\u0001"+
		"\u0000\u0000\u0000\u021a\u0216\u0001\u0000\u0000\u0000\u021b\u021e\u0001"+
		"\u0000\u0000\u0000\u021c\u021a\u0001\u0000\u0000\u0000\u021c\u021d\u0001"+
		"\u0000\u0000\u0000\u021d\u021f\u0001\u0000\u0000\u0000\u021e\u021c\u0001"+
		"\u0000\u0000\u0000\u021f\u0221\u0005\u0002\u0000\u0000\u0220\u01f7\u0001"+
		"\u0000\u0000\u0000\u0220\u0205\u0001\u0000\u0000\u0000\u0220\u0211\u0001"+
		"\u0000\u0000\u0000\u0221\u001d\u0001\u0000\u0000\u0000\u0222\u0223\u0005"+
		"\"\u0000\u0000\u0223\u0225\u0005\u0001\u0000\u0000\u0224\u0226\u0005\u0005"+
		"\u0000\u0000\u0225\u0224\u0001\u0000\u0000\u0000\u0225\u0226\u0001\u0000"+
		"\u0000\u0000\u0226\u0227\u0001\u0000\u0000\u0000\u0227\u0229\u0005\u0002"+
		"\u0000\u0000\u0228\u022a\u0005&\u0000\u0000\u0229\u0228\u0001\u0000\u0000"+
		"\u0000\u0229\u022a\u0001\u0000\u0000\u0000\u022a\u022e\u0001\u0000\u0000"+
		"\u0000\u022b\u022d\u0003\u0002\u0001\u0000\u022c\u022b\u0001\u0000\u0000"+
		"\u0000\u022d\u0230\u0001\u0000\u0000\u0000\u022e\u022c\u0001\u0000\u0000"+
		"\u0000\u022e\u022f\u0001\u0000\u0000\u0000\u022f\u0232\u0001\u0000\u0000"+
		"\u0000\u0230\u022e\u0001\u0000\u0000\u0000\u0231\u0233\u0005&\u0000\u0000"+
		"\u0232\u0231\u0001\u0000\u0000\u0000\u0232\u0233\u0001\u0000\u0000\u0000"+
		"\u0233\u0234\u0001\u0000\u0000\u0000\u0234\u02a0\u0007\u0003\u0000\u0000"+
		"\u0235\u0236\u0005#\u0000\u0000\u0236\u0238\u0005\u0001\u0000\u0000\u0237"+
		"\u0239\u0005\u0005\u0000\u0000\u0238\u0237\u0001\u0000\u0000\u0000\u0238"+
		"\u0239\u0001\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000\u0000\u023a"+
		"\u023e\u0005\u0002\u0000\u0000\u023b\u023d\u0003\u0002\u0001\u0000\u023c"+
		"\u023b\u0001\u0000\u0000\u0000\u023d\u0240\u0001\u0000\u0000\u0000\u023e"+
		"\u023c\u0001\u0000\u0000\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f"+
		"\u0248\u0001\u0000\u0000\u0000\u0240\u023e\u0001\u0000\u0000\u0000\u0241"+
		"\u0245\u0005\u0010\u0000\u0000\u0242\u0244\u0003\u0002\u0001\u0000\u0243"+
		"\u0242\u0001\u0000\u0000\u0000\u0244\u0247\u0001\u0000\u0000\u0000\u0245"+
		"\u0243\u0001\u0000\u0000\u0000\u0245\u0246\u0001\u0000\u0000\u0000\u0246"+
		"\u0249\u0001\u0000\u0000\u0000\u0247\u0245\u0001\u0000\u0000\u0000\u0248"+
		"\u0241\u0001\u0000\u0000\u0000\u0248\u0249\u0001\u0000\u0000\u0000\u0249"+
		"\u024a\u0001\u0000\u0000\u0000\u024a\u02a0\u0005\u0011\u0000\u0000\u024b"+
		"\u024c\u0005$\u0000\u0000\u024c\u024e\u0005\u0001\u0000\u0000\u024d\u024f"+
		"\u0005\u0005\u0000\u0000\u024e\u024d\u0001\u0000\u0000\u0000\u024e\u024f"+
		"\u0001\u0000\u0000\u0000\u024f\u0250\u0001\u0000\u0000\u0000\u0250\u0254"+
		"\u0005\u0002\u0000\u0000\u0251\u0253\u0003\u0002\u0001\u0000\u0252\u0251"+
		"\u0001\u0000\u0000\u0000\u0253\u0256\u0001\u0000\u0000\u0000\u0254\u0252"+
		"\u0001\u0000\u0000\u0000\u0254\u0255\u0001\u0000\u0000\u0000\u0255\u025e"+
		"\u0001\u0000\u0000\u0000\u0256\u0254\u0001\u0000\u0000\u0000\u0257\u025b"+
		"\u0005\u0010\u0000\u0000\u0258\u025a\u0003\u0002\u0001\u0000\u0259\u0258"+
		"\u0001\u0000\u0000\u0000\u025a\u025d\u0001\u0000\u0000\u0000\u025b\u0259"+
		"\u0001\u0000\u0000\u0000\u025b\u025c\u0001\u0000\u0000\u0000\u025c\u025f"+
		"\u0001\u0000\u0000\u0000\u025d\u025b\u0001\u0000\u0000\u0000\u025e\u0257"+
		"\u0001\u0000\u0000\u0000\u025e\u025f\u0001\u0000\u0000\u0000\u025f\u0260"+
		"\u0001\u0000\u0000\u0000\u0260\u02a0\u0005\u0011\u0000\u0000\u0261\u0262"+
		"\u0005.\u0000\u0000\u0262\u0264\u0005\u0001\u0000\u0000\u0263\u0265\u0005"+
		"\u0005\u0000\u0000\u0264\u0263\u0001\u0000\u0000\u0000\u0264\u0265\u0001"+
		"\u0000\u0000\u0000\u0265\u0266\u0001\u0000\u0000\u0000\u0266\u026a\u0005"+
		"\u0002\u0000\u0000\u0267\u0269\u0003\u0002\u0001\u0000\u0268\u0267\u0001"+
		"\u0000\u0000\u0000\u0269\u026c\u0001\u0000\u0000\u0000\u026a\u0268\u0001"+
		"\u0000\u0000\u0000\u026a\u026b\u0001\u0000\u0000\u0000\u026b\u026d\u0001"+
		"\u0000\u0000\u0000\u026c\u026a\u0001\u0000\u0000\u0000\u026d\u02a0\u0005"+
		"/\u0000\u0000\u026e\u026f\u00050\u0000\u0000\u026f\u0271\u0005\u0001\u0000"+
		"\u0000\u0270\u0272\u0005\u0005\u0000\u0000\u0271\u0270\u0001\u0000\u0000"+
		"\u0000\u0271\u0272\u0001\u0000\u0000\u0000\u0272\u0273\u0001\u0000\u0000"+
		"\u0000\u0273\u0274\u0005\f\u0000\u0000\u0274\u0278\u0005\u0002\u0000\u0000"+
		"\u0275\u0277\u0003\u0002\u0001\u0000\u0276\u0275\u0001\u0000\u0000\u0000"+
		"\u0277\u027a\u0001\u0000\u0000\u0000\u0278\u0276\u0001\u0000\u0000\u0000"+
		"\u0278\u0279\u0001\u0000\u0000\u0000\u0279\u0282\u0001\u0000\u0000\u0000"+
		"\u027a\u0278\u0001\u0000\u0000\u0000\u027b\u027f\u0005\u0010\u0000\u0000"+
		"\u027c\u027e\u0003\u0002\u0001\u0000\u027d\u027c\u0001\u0000\u0000\u0000"+
		"\u027e\u0281\u0001\u0000\u0000\u0000\u027f\u027d\u0001\u0000\u0000\u0000"+
		"\u027f\u0280\u0001\u0000\u0000\u0000\u0280\u0283\u0001\u0000\u0000\u0000"+
		"\u0281\u027f\u0001\u0000\u0000\u0000\u0282\u027b\u0001\u0000\u0000\u0000"+
		"\u0282\u0283\u0001\u0000\u0000\u0000\u0283\u0284\u0001\u0000\u0000\u0000"+
		"\u0284\u02a0\u00051\u0000\u0000\u0285\u0286\u00052\u0000\u0000\u0286\u0288"+
		"\u0005\u0001\u0000\u0000\u0287\u0289\u0005\u0005\u0000\u0000\u0288\u0287"+
		"\u0001\u0000\u0000\u0000\u0288\u0289\u0001\u0000\u0000\u0000\u0289\u028a"+
		"\u0001\u0000\u0000\u0000\u028a\u028e\u0005\u0002\u0000\u0000\u028b\u028d"+
		"\u0003\u0002\u0001\u0000\u028c\u028b\u0001\u0000\u0000\u0000\u028d\u0290"+
		"\u0001\u0000\u0000\u0000\u028e\u028c\u0001\u0000\u0000\u0000\u028e\u028f"+
		"\u0001\u0000\u0000\u0000\u028f\u0291\u0001\u0000\u0000\u0000\u0290\u028e"+
		"\u0001\u0000\u0000\u0000\u0291\u02a0\u00053\u0000\u0000\u0292\u0293\u0005"+
		"4\u0000\u0000\u0293\u0295\u0005\u0001\u0000\u0000\u0294\u0296\u0005\u0005"+
		"\u0000\u0000\u0295\u0294\u0001\u0000\u0000\u0000\u0295\u0296\u0001\u0000"+
		"\u0000\u0000\u0296\u0297\u0001\u0000\u0000\u0000\u0297\u029b\u0005\u0002"+
		"\u0000\u0000\u0298\u029a\u0003\u0002\u0001\u0000\u0299\u0298\u0001\u0000"+
		"\u0000\u0000\u029a\u029d\u0001\u0000\u0000\u0000\u029b\u0299\u0001\u0000"+
		"\u0000\u0000\u029b\u029c\u0001\u0000\u0000\u0000\u029c\u029e\u0001\u0000"+
		"\u0000\u0000\u029d\u029b\u0001\u0000\u0000\u0000\u029e\u02a0\u00055\u0000"+
		"\u0000\u029f\u0222\u0001\u0000\u0000\u0000\u029f\u0235\u0001\u0000\u0000"+
		"\u0000\u029f\u024b\u0001\u0000\u0000\u0000\u029f\u0261\u0001\u0000\u0000"+
		"\u0000\u029f\u026e\u0001\u0000\u0000\u0000\u029f\u0285\u0001\u0000\u0000"+
		"\u0000\u029f\u0292\u0001\u0000\u0000\u0000\u02a0\u001f\u0001\u0000\u0000"+
		"\u0000\u02a1\u02a2\u0007\u0004\u0000\u0000\u02a2!\u0001\u0000\u0000\u0000"+
		"\u02a3\u02a5\u0005\u0003\u0000\u0000\u02a4\u02a6\u00030\u0018\u0000\u02a5"+
		"\u02a4\u0001\u0000\u0000\u0000\u02a5\u02a6\u0001\u0000\u0000\u0000\u02a6"+
		"#\u0001\u0000\u0000\u0000\u02a7\u02a9\u0007\u0005\u0000\u0000\u02a8\u02aa"+
		"\u00030\u0018\u0000\u02a9\u02a8\u0001\u0000\u0000\u0000\u02a9\u02aa\u0001"+
		"\u0000\u0000\u0000\u02aa%\u0001\u0000\u0000\u0000\u02ab\u02ac\u0005J\u0000"+
		"\u0000\u02ac\u02ae\u0005\u0001\u0000\u0000\u02ad\u02af\u0005\f\u0000\u0000"+
		"\u02ae\u02ad\u0001\u0000\u0000\u0000\u02ae\u02af\u0001\u0000\u0000\u0000"+
		"\u02af\u02b0\u0001\u0000\u0000\u0000\u02b0\u02b4\u0005\u0002\u0000\u0000"+
		"\u02b1\u02b3\u0003\u0002\u0001\u0000\u02b2\u02b1\u0001\u0000\u0000\u0000"+
		"\u02b3\u02b6\u0001\u0000\u0000\u0000\u02b4\u02b2\u0001\u0000\u0000\u0000"+
		"\u02b4\u02b5\u0001\u0000\u0000\u0000\u02b5\u02ba\u0001\u0000\u0000\u0000"+
		"\u02b6\u02b4\u0001\u0000\u0000\u0000\u02b7\u02b9\u0003\u0010\b\u0000\u02b8"+
		"\u02b7\u0001\u0000\u0000\u0000\u02b9\u02bc\u0001\u0000\u0000\u0000\u02ba"+
		"\u02b8\u0001\u0000\u0000\u0000\u02ba\u02bb\u0001\u0000\u0000\u0000\u02bb"+
		"\u02c4\u0001\u0000\u0000\u0000\u02bc\u02ba\u0001\u0000\u0000\u0000\u02bd"+
		"\u02c1\u0005\u0010\u0000\u0000\u02be\u02c0\u0003\u0002\u0001\u0000\u02bf"+
		"\u02be\u0001\u0000\u0000\u0000\u02c0\u02c3\u0001\u0000\u0000\u0000\u02c1"+
		"\u02bf\u0001\u0000\u0000\u0000\u02c1\u02c2\u0001\u0000\u0000\u0000\u02c2"+
		"\u02c5\u0001\u0000\u0000\u0000\u02c3\u02c1\u0001\u0000\u0000\u0000\u02c4"+
		"\u02bd\u0001\u0000\u0000\u0000\u02c4\u02c5\u0001\u0000\u0000\u0000\u02c5"+
		"\u02c6\u0001\u0000\u0000\u0000\u02c6\u02cb\u0005K\u0000\u0000\u02c7\u02cb"+
		"\u0005H\u0000\u0000\u02c8\u02c9\u0005I\u0000\u0000\u02c9\u02cb\u00030"+
		"\u0018\u0000\u02ca\u02ab\u0001\u0000\u0000\u0000\u02ca\u02c7\u0001\u0000"+
		"\u0000\u0000\u02ca\u02c8\u0001\u0000\u0000\u0000\u02cb\'\u0001\u0000\u0000"+
		"\u0000\u02cc\u02ce\u0005L\u0000\u0000\u02cd\u02cf\u00030\u0018\u0000\u02ce"+
		"\u02cd\u0001\u0000\u0000\u0000\u02ce\u02cf\u0001\u0000\u0000\u0000\u02cf"+
		"\u02d3\u0001\u0000\u0000\u0000\u02d0\u02d2\u0003\u0002\u0001\u0000\u02d1"+
		"\u02d0\u0001\u0000\u0000\u0000\u02d2\u02d5\u0001\u0000\u0000\u0000\u02d3"+
		"\u02d1\u0001\u0000\u0000\u0000\u02d3\u02d4\u0001\u0000\u0000\u0000\u02d4"+
		"\u02dd\u0001\u0000\u0000\u0000\u02d5\u02d3\u0001\u0000\u0000\u0000\u02d6"+
		"\u02da\u0007\u0006\u0000\u0000\u02d7\u02d9\u0003\u0002\u0001\u0000\u02d8"+
		"\u02d7\u0001\u0000\u0000\u0000\u02d9\u02dc\u0001\u0000\u0000\u0000\u02da"+
		"\u02d8\u0001\u0000\u0000\u0000\u02da\u02db\u0001\u0000\u0000\u0000\u02db"+
		"\u02de\u0001\u0000\u0000\u0000\u02dc\u02da\u0001\u0000\u0000\u0000\u02dd"+
		"\u02d6\u0001\u0000\u0000\u0000\u02dd\u02de\u0001\u0000\u0000\u0000\u02de"+
		"\u02df\u0001\u0000\u0000\u0000\u02df\u02fe\u0005M\u0000\u0000\u02e0\u02e2"+
		"\u0005N\u0000\u0000\u02e1\u02e3\u00030\u0018\u0000\u02e2\u02e1\u0001\u0000"+
		"\u0000\u0000\u02e2\u02e3\u0001\u0000\u0000\u0000\u02e3\u02e7\u0001\u0000"+
		"\u0000\u0000\u02e4\u02e6\u0003\u0002\u0001\u0000\u02e5\u02e4\u0001\u0000"+
		"\u0000\u0000\u02e6\u02e9\u0001\u0000\u0000\u0000\u02e7\u02e5\u0001\u0000"+
		"\u0000\u0000\u02e7\u02e8\u0001\u0000\u0000\u0000\u02e8\u02ea\u0001\u0000"+
		"\u0000\u0000\u02e9\u02e7\u0001\u0000\u0000\u0000\u02ea\u02fe\u0005P\u0000"+
		"\u0000\u02eb\u02ec\u0005Q\u0000\u0000\u02ec\u02f0\u00030\u0018\u0000\u02ed"+
		"\u02ef\u0003\u0002\u0001\u0000\u02ee\u02ed\u0001\u0000\u0000\u0000\u02ef"+
		"\u02f2\u0001\u0000\u0000\u0000\u02f0\u02ee\u0001\u0000\u0000\u0000\u02f0"+
		"\u02f1\u0001\u0000\u0000\u0000\u02f1\u02f3\u0001\u0000\u0000\u0000\u02f2"+
		"\u02f0\u0001\u0000\u0000\u0000\u02f3\u02f4\u0005R\u0000\u0000\u02f4\u02fe"+
		"\u0001\u0000\u0000\u0000\u02f5\u02f9\u0005S\u0000\u0000\u02f6\u02f8\u0003"+
		"\u0002\u0001\u0000\u02f7\u02f6\u0001\u0000\u0000\u0000\u02f8\u02fb\u0001"+
		"\u0000\u0000\u0000\u02f9\u02f7\u0001\u0000\u0000\u0000\u02f9\u02fa\u0001"+
		"\u0000\u0000\u0000\u02fa\u02fc\u0001\u0000\u0000\u0000\u02fb\u02f9\u0001"+
		"\u0000\u0000\u0000\u02fc\u02fe\u0005T\u0000\u0000\u02fd\u02cc\u0001\u0000"+
		"\u0000\u0000\u02fd\u02e0\u0001\u0000\u0000\u0000\u02fd\u02eb\u0001\u0000"+
		"\u0000\u0000\u02fd\u02f5\u0001\u0000\u0000\u0000\u02fe)\u0001\u0000\u0000"+
		"\u0000\u02ff\u0301\u0005f\u0000\u0000\u0300\u0302\u0005\u0003\u0000\u0000"+
		"\u0301\u0300\u0001\u0000\u0000\u0000\u0301\u0302\u0001\u0000\u0000\u0000"+
		"\u0302\u0303\u0001\u0000\u0000\u0000\u0303\u0304\u0005\u0006\u0000\u0000"+
		"\u0304+\u0001\u0000\u0000\u0000\u0305\u0306\u0005h\u0000\u0000\u0306\u0307"+
		"\u0005i\u0000\u0000\u0307-\u0001\u0000\u0000\u0000\u0308\u0309\u0003 "+
		"\u0010\u0000\u0309\u030a\u0005\u0001\u0000\u0000\u030a\u030b\u0006\u0017"+
		"\uffff\uffff\u0000\u030b\u0322\u0001\u0000\u0000\u0000\u030c\u030d\u0005"+
		"\u000e\u0000\u0000\u030d\u030e\u00030\u0018\u0000\u030e\u030f\u0006\u0017"+
		"\uffff\uffff\u0000\u030f\u0322\u0001\u0000\u0000\u0000\u0310\u0311\u0005"+
		"6\u0000\u0000\u0311\u0315\u00032\u0019\u0000\u0312\u0313\u00058\u0000"+
		"\u0000\u0313\u0315\u00030\u0018\u0000\u0314\u0310\u0001\u0000\u0000\u0000"+
		"\u0314\u0312\u0001\u0000\u0000\u0000\u0315\u0316\u0001\u0000\u0000\u0000"+
		"\u0316\u0317\u0006\u0017\uffff\uffff\u0000\u0317\u0322\u0001\u0000\u0000"+
		"\u0000\u0318\u0319\u0005B\u0000\u0000\u0319\u0322\u0006\u0017\uffff\uffff"+
		"\u0000\u031a\u031b\u0005\"\u0000\u0000\u031b\u031d\u0005\u0001\u0000\u0000"+
		"\u031c\u031e\u0005\u0005\u0000\u0000\u031d\u031c\u0001\u0000\u0000\u0000"+
		"\u031d\u031e\u0001\u0000\u0000\u0000\u031e\u031f\u0001\u0000\u0000\u0000"+
		"\u031f\u0320\u0005\u0002\u0000\u0000\u0320\u0322\u0006\u0017\uffff\uffff"+
		"\u0000\u0321\u0308\u0001\u0000\u0000\u0000\u0321\u030c\u0001\u0000\u0000"+
		"\u0000\u0321\u0314\u0001\u0000\u0000\u0000\u0321\u0318\u0001\u0000\u0000"+
		"\u0000\u0321\u031a\u0001\u0000\u0000\u0000\u0322/\u0001\u0000\u0000\u0000"+
		"\u0323\u0327\u0005\u0001\u0000\u0000\u0324\u0326\u0005\f\u0000\u0000\u0325"+
		"\u0324\u0001\u0000\u0000\u0000\u0326\u0329\u0001\u0000\u0000\u0000\u0327"+
		"\u0325\u0001\u0000\u0000\u0000\u0327\u0328\u0001\u0000\u0000\u0000\u0328"+
		"\u032a\u0001\u0000\u0000\u0000\u0329\u0327\u0001\u0000\u0000\u0000\u032a"+
		"\u032b\u0005\u0002\u0000\u0000\u032b1\u0001\u0000\u0000\u0000\u032c\u032d"+
		"\u0005\u0001\u0000\u0000\u032d\u032e\u0005\u00a4\u0000\u0000\u032e\u032f"+
		"\u0005\u00a6\u0000\u0000\u032f\u0332\u0005\u00a4\u0000\u0000\u0330\u0331"+
		"\u0005\u00a7\u0000\u0000\u0331\u0333\u0005\u00a4\u0000\u0000\u0332\u0330"+
		"\u0001\u0000\u0000\u0000\u0332\u0333\u0001\u0000\u0000\u0000\u0333\u0334"+
		"\u0001\u0000\u0000\u0000\u0334\u034e\u0005\u0002\u0000\u0000\u0335\u0339"+
		"\u0005\u0001\u0000\u0000\u0336\u0338\u0005\u00a4\u0000\u0000\u0337\u0336"+
		"\u0001\u0000\u0000\u0000\u0338\u033b\u0001\u0000\u0000\u0000\u0339\u0337"+
		"\u0001\u0000\u0000\u0000\u0339\u033a\u0001\u0000\u0000\u0000\u033a\u033c"+
		"\u0001\u0000\u0000\u0000\u033b\u0339\u0001\u0000\u0000\u0000\u033c\u0340"+
		"\u0005\u00a6\u0000\u0000\u033d\u033f\u0005\u00a4\u0000\u0000\u033e\u033d"+
		"\u0001\u0000\u0000\u0000\u033f\u0342\u0001\u0000\u0000\u0000\u0340\u033e"+
		"\u0001\u0000\u0000\u0000\u0340\u0341\u0001\u0000\u0000\u0000\u0341\u034a"+
		"\u0001\u0000\u0000\u0000\u0342\u0340\u0001\u0000\u0000\u0000\u0343\u0347"+
		"\u0005\u00a7\u0000\u0000\u0344\u0346\u0005\u00a4\u0000\u0000\u0345\u0344"+
		"\u0001\u0000\u0000\u0000\u0346\u0349\u0001\u0000\u0000\u0000\u0347\u0345"+
		"\u0001\u0000\u0000\u0000\u0347\u0348\u0001\u0000\u0000\u0000\u0348\u034b"+
		"\u0001\u0000\u0000\u0000\u0349\u0347\u0001\u0000\u0000\u0000\u034a\u0343"+
		"\u0001\u0000\u0000\u0000\u034a\u034b\u0001\u0000\u0000\u0000\u034b\u034c"+
		"\u0001\u0000\u0000\u0000\u034c\u034e\u0005\u0002\u0000\u0000\u034d\u032c"+
		"\u0001\u0000\u0000\u0000\u034d\u0335\u0001\u0000\u0000\u0000\u034e3\u0001"+
		"\u0000\u0000\u0000\u034f\u0350\u0005o\u0000\u0000\u0350\u0351\u0007\u0007"+
		"\u0000\u0000\u03515\u0001\u0000\u0000\u0000\u0352\u0353\u0005p\u0000\u0000"+
		"\u03537\u0001\u0000\u0000\u0000\u0083;MWYchq{\u0082\u0085\u008e\u0095"+
		"\u0098\u00a1\u00ab\u00b5\u00bd\u00c2\u00c9\u00cc\u00d5\u00dd\u00e2\u00e9"+
		"\u00ec\u00f5\u00fd\u0102\u0109\u010c\u0116\u0121\u0125\u012b\u012d\u0133"+
		"\u0135\u0138\u0140\u0142\u014b\u014d\u0156\u0158\u015f\u016c\u0176\u017a"+
		"\u017e\u0185\u0188\u0198\u019d\u01a1\u01a5\u01ad\u01b4\u01b7\u01bd\u01c0"+
		"\u01c7\u01ca\u01d0\u01d3\u01d9\u01df\u01e2\u01e9\u01ef\u01f2\u01f5\u01fa"+
		"\u0200\u0202\u020a\u020e\u0214\u0218\u021c\u0220\u0225\u0229\u022e\u0232"+
		"\u0238\u023e\u0245\u0248\u024e\u0254\u025b\u025e\u0264\u026a\u0271\u0278"+
		"\u027f\u0282\u0288\u028e\u0295\u029b\u029f\u02a5\u02a9\u02ae\u02b4\u02ba"+
		"\u02c1\u02c4\u02ca\u02ce\u02d3\u02da\u02dd\u02e2\u02e7\u02f0\u02f9\u02fd"+
		"\u0301\u0314\u031d\u0321\u0327\u0332\u0339\u0340\u0347\u034a\u034d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}