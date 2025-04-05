// Generated from BladeAntlrParser.g4 by ANTLR 4.13.0

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
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

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
		D_PROPS=93, D_VITE=94, D_VITE_REFRESH=95, D_LANG=96, D_INJECT=97, D_USE=98, 
		BLADE_CONTENT_OPEN_TAG=99, BLADE_TAG_ESCAPE=100, BLADE_RAW_OPEN_TAG=101, 
		BLADE_RAW_CLOSE_TAG=102, URI_PATH_PART=103, D_CSS_AT=104, D_CSS_AT2=105, 
		D_ENDCUSTOM=106, AT=107, PHP_INLINE_START=108, HTML_COMPONENT_OPEN_TAG=109, 
		WS=110, OTHER=111, BLADE_COMMENT_START=112, EMAIL_SUBSTRING=113, VERSION_WITH_AT=114, 
		D_ESCAPES=115, E_LPAREN=116, E_RPAREN=117, E_LSQUAREBRACKET=118, E_RSQUAREBRACKET=119, 
		E_LCURLYBRACE=120, E_RCURLYBRACE=121, E_OTHER=122, EI_LPAREN=123, EI_RPAREN=124, 
		EI_OTHER=125, ESPOS_LPAREN=126, ESPOS_RPAREN=127, ESPOS_LSQUAREBRACKET=128, 
		ESPOS_RSQUAREBRACKET=129, ESPOS_LCURLYBRACE=130, ESPOS_RCURLYBRACE=131, 
		ESPOS_OTHER=132, EACH_LPAREN=133, EACH_RPAREN=134, EACH_LSQUAREBRACKET=135, 
		EACH_RSQUAREBRACKET=136, EACH_LCURLYBRACE=137, EACH_RCURLYBRACE=138, EACH_OTHER=139, 
		INCF_LPAREN=140, INCF_RPAREN=141, INCF_LSQUAREBRACKET=142, INCF_RSQUAREBRACKET=143, 
		INCF_LCURLYBRACE=144, INCF_RCURLYBRACE=145, INCF_OTHER=146, MIXED_S_A_LPAREN=147, 
		MIXED_S_A_RPAREN=148, MIXED_S_A_LSQUAREBRACKET=149, MIXED_S_A_RSQUAREBRACKET=150, 
		MIXED_S_A_LCURLYBRACE=151, MIXED_S_A_RCURLYBRACE=152, MIXED_S_A_OTHER=153, 
		FOREACH_LPAREN=154, FOREACH_RPAREN=155, FOREACH_LSQUAREBRACKET=156, FOREACH_RSQUAREBRACKET=157, 
		FOREACH_LCURLYBRACE=158, FOREACH_RCURLYBRACE=159, FOREACH_VAR=160, FOREACH_PHP_EXPR_STRING=161, 
		FOREACH_AS=162, FOREACH_DOUBLE_ARROW=163, FOREACH_DENTIFIER=164, FOREACH_OTHER=165, 
		D_ENDPHP=166, BLADE_INLINE_PHP_OTHER=167, VERBATIM_HTML=168, PHP_INLINE_EXIT=169, 
		PHP_INLINE_OTHER=170, PHP_INLINE_EOF=171, BLADE_COMMENT_END=172, BLADE_COMMENT_MORE=173, 
		BLADE_COMMENT_EOF=174, D_SPATIE=175;
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
			null, null, null, "'@viteReactRefresh'", "'@lang'", null, "'@use'", "'{{'", 
			null, "'{!!'", "'!!}'", null, null, null, null, "'@'", null, null, null, 
			null, "'{{--'", null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "'as'", "'=>'", null, null, "'@endphp'", null, 
			null, "'?>'", null, null, "'--}}'", null, null, "'@honeypot'"
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
			"D_ENDFRAGMENT", "D_SIMPLE_DIRECTIVE", "D_PROPS", "D_VITE", "D_VITE_REFRESH", 
			"D_LANG", "D_INJECT", "D_USE", "BLADE_CONTENT_OPEN_TAG", "BLADE_TAG_ESCAPE", 
			"BLADE_RAW_OPEN_TAG", "BLADE_RAW_CLOSE_TAG", "URI_PATH_PART", "D_CSS_AT", 
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
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
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
		public TerminalNode D_ELSE() { return getToken(BladeAntlrParser.D_ELSE, 0); }
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
			setState(281);
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3074436684023773096L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
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
					case D_PROPS:
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
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
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(118);
						statement();
						}
						} 
					}
					setState(123);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(124);
					match(D_ELSE);
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
						{
						{
						setState(125);
						statement();
						}
						}
						setState(130);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(133);
				match(D_ENDEMPTY);
				}
				break;
			case D_ISSET:
				enterOuterAlt(_localctx, 12);
				{
				setState(135);
				match(D_ISSET);
				setState(136);
				directiveArguments();
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(137);
						statement();
						}
						} 
					}
					setState(142);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(143);
					match(D_ELSE);
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
						{
						{
						setState(144);
						statement();
						}
						}
						setState(149);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(152);
				match(D_ENDISSET);
				}
				break;
			case D_SESSION:
				enterOuterAlt(_localctx, 13);
				{
				setState(154);
				match(D_SESSION);
				setState(155);
				directiveArguments();
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					{
					setState(156);
					statement();
					}
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(162);
				match(D_ENDSESSION);
				}
				break;
			case D_CAN:
				enterOuterAlt(_localctx, 14);
				{
				setState(164);
				match(D_CAN);
				setState(165);
				directiveArguments();
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(166);
						statement();
						}
						} 
					}
					setState(171);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==D_ELSECAN) {
					{
					{
					setState(172);
					match(D_ELSECAN);
					setState(173);
					directiveArguments();
					setState(177);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(174);
							statement();
							}
							} 
						}
						setState(179);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
					}
					}
					}
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(185);
					match(D_ELSE);
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
						{
						{
						setState(186);
						statement();
						}
						}
						setState(191);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(194);
				match(D_ENDCAN);
				}
				break;
			case D_CANNOT:
				enterOuterAlt(_localctx, 15);
				{
				setState(196);
				match(D_CANNOT);
				setState(197);
				directiveArguments();
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(198);
						statement();
						}
						} 
					}
					setState(203);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==D_ELSECAN) {
					{
					{
					setState(204);
					match(D_ELSECAN);
					setState(205);
					directiveArguments();
					setState(209);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(206);
							statement();
							}
							} 
						}
						setState(211);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					}
					}
					}
					setState(216);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(217);
					match(D_ELSE);
					setState(221);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
						{
						{
						setState(218);
						statement();
						}
						}
						setState(223);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(226);
				match(D_ENDCANNOT);
				}
				break;
			case D_CANANY:
				enterOuterAlt(_localctx, 16);
				{
				setState(228);
				match(D_CANANY);
				setState(229);
				directiveArguments();
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(230);
						statement();
						}
						} 
					}
					setState(235);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==D_ELSECAN) {
					{
					{
					setState(236);
					match(D_ELSECAN);
					setState(237);
					directiveArguments();
					setState(241);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(238);
							statement();
							}
							} 
						}
						setState(243);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
					}
					}
					}
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(249);
					match(D_ELSE);
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
						{
						{
						setState(250);
						statement();
						}
						}
						setState(255);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(258);
				match(D_ENDCANANY);
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 17);
				{
				setState(260);
				bladePhpBlock();
				}
				break;
			case D_FRAGMENT:
				enterOuterAlt(_localctx, 18);
				{
				setState(261);
				match(D_FRAGMENT);
				setState(262);
				directiveArguments();
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					{
					setState(263);
					statement();
					}
					}
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(269);
				match(D_ENDFRAGMENT);
				}
				break;
			case D_VERBATIM:
				enterOuterAlt(_localctx, 19);
				{
				setState(271);
				match(D_VERBATIM);
				setState(272);
				match(D_ENDVERBATIM);
				}
				break;
			case D_ELSE:
				enterOuterAlt(_localctx, 20);
				{
				setState(273);
				match(D_ELSE);
				setState(277);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(274);
						statement();
						}
						} 
					}
					setState(279);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				setState(280);
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
			setState(283);
			ifStartStatement();
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(287);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case D_ELSEIF:
						{
						setState(284);
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
					case D_PROPS:
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
						setState(285);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(286);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_ELSE) {
				{
				setState(292);
				match(D_ELSE);
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3074436684023773096L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					setState(295);
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
					case D_PROPS:
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
						setState(293);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(294);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(299);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(302);
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
			setState(304);
			match(D_FOREACH);
			setState(305);
			foreachLoopArguments();
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3074436684023773096L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
				{
				setState(308);
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
				case D_PROPS:
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
					setState(306);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(307);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(313);
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
			setState(315);
			match(D_FOR);
			setState(316);
			directiveArguments();
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3074436684023773096L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
				{
				setState(319);
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
				case D_PROPS:
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
					setState(317);
					statement();
					}
					break;
				case D_BREAK:
				case D_CONTINUE:
					{
					setState(318);
					loopBreaks();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(324);
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
			setState(326);
			match(D_FORELSE);
			setState(327);
			directiveArguments();
			setState(332);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(330);
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
					case D_PROPS:
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
						setState(328);
						statement();
						}
						break;
					case D_BREAK:
					case D_CONTINUE:
						{
						setState(329);
						loopBreaks();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			setState(335);
			match(D_EMPTY);
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
				{
				{
				setState(336);
				statement();
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(342);
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
			setState(344);
			match(D_IF);
			setState(345);
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
			setState(347);
			match(D_ELSEIF);
			setState(348);
			directiveArguments();
			setState(352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(349);
					statement();
					}
					} 
				}
				setState(354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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
			setState(355);
			match(D_SWITCH);
			setState(356);
			directiveArguments();
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==D_CASE) {
				{
				{
				setState(357);
				match(D_CASE);
				setState(358);
				directiveArguments();
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					{
					setState(359);
					statement();
					}
					}
					setState(364);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_BREAK) {
					{
					setState(365);
					match(D_BREAK);
					}
				}

				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==D_DEFAULT) {
				{
				setState(373);
				match(D_DEFAULT);
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					{
					setState(374);
					statement();
					}
					}
					setState(379);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(382);
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
			setState(384);
			match(D_PHP);
			setState(385);
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
		public TerminalNode D_PROPS() { return getToken(BladeAntlrParser.D_PROPS, 0); }
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
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SIMPLE_DIRECTIVE:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				match(D_SIMPLE_DIRECTIVE);
				setState(388);
				directiveArguments();
				}
				break;
			case D_PROPS:
				enterOuterAlt(_localctx, 2);
				{
				setState(389);
				match(D_PROPS);
				setState(390);
				directiveArguments();
				}
				break;
			case D_PHP:
				enterOuterAlt(_localctx, 3);
				{
				setState(391);
				match(D_PHP);
				setState(392);
				directiveArguments();
				}
				break;
			case D_DIRECTIVE:
				enterOuterAlt(_localctx, 4);
				{
				setState(393);
				match(D_DIRECTIVE);
				}
				break;
			case D_VITE_REFRESH:
				enterOuterAlt(_localctx, 5);
				{
				setState(394);
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
			setState(472);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(397);
				match(D_SECTION);
				setState(398);
				match(LPAREN);
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(399);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(402);
				match(COMMA);
				setState(403);
				match(RPAREN);
				}
				break;
			case D_EXTENDS:
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
				match(D_EXTENDS);
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

				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(409);
					match(COMMA);
					}
				}

				setState(412);
				match(RPAREN);
				}
				break;
			case D_INCLUDE:
			case D_INCLUDE_IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(413);
				_la = _input.LA(1);
				if ( !(_la==D_INCLUDE || _la==D_INCLUDE_IF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(414);
				match(LPAREN);
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(415);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(418);
					match(COMMA);
					}
				}

				setState(421);
				match(RPAREN);
				}
				break;
			case D_INCLUDE_WHEN:
			case D_INCLUDE_UNLESS:
				enterOuterAlt(_localctx, 4);
				{
				setState(422);
				_la = _input.LA(1);
				if ( !(_la==D_INCLUDE_WHEN || _la==D_INCLUDE_UNLESS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(423);
				match(LPAREN);
				setState(424);
				match(COMMA);
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(425);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(428);
					match(COMMA);
					}
				}

				setState(431);
				match(RPAREN);
				}
				break;
			case D_YIELD:
				enterOuterAlt(_localctx, 5);
				{
				setState(432);
				match(D_YIELD);
				setState(433);
				match(LPAREN);
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(434);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(437);
					match(COMMA);
					}
				}

				setState(440);
				match(RPAREN);
				}
				break;
			case D_STACK:
				enterOuterAlt(_localctx, 6);
				{
				setState(441);
				match(D_STACK);
				setState(442);
				match(LPAREN);
				setState(444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(443);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(446);
				match(RPAREN);
				}
				break;
			case D_LANG:
				enterOuterAlt(_localctx, 7);
				{
				setState(447);
				match(D_LANG);
				setState(448);
				match(LPAREN);
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(449);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(452);
					match(COMMA);
					}
				}

				setState(455);
				match(RPAREN);
				}
				break;
			case D_INJECT:
				enterOuterAlt(_localctx, 8);
				{
				setState(456);
				match(D_INJECT);
				setState(457);
				match(LPAREN);
				setState(458);
				match(COMMA);
				setState(460);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(459);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(462);
				match(RPAREN);
				}
				break;
			case D_USE:
				enterOuterAlt(_localctx, 9);
				{
				setState(463);
				match(D_USE);
				setState(464);
				match(LPAREN);
				setState(466);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(465);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(469);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(468);
					match(COMMA);
					}
				}

				setState(471);
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
			setState(515);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EACH:
				enterOuterAlt(_localctx, 1);
				{
				setState(474);
				match(D_EACH);
				setState(475);
				match(LPAREN);
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(476);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(479);
				match(COMMA);
				setState(480);
				match(COMMA);
				setState(485);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(481);
					match(COMMA);
					setState(483);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIABLE_STRING) {
						{
						setState(482);
						match(IDENTIFIABLE_STRING);
						}
					}

					}
				}

				setState(487);
				match(RPAREN);
				}
				break;
			case D_INCLUDE_FIRST:
				enterOuterAlt(_localctx, 2);
				{
				setState(488);
				match(D_INCLUDE_FIRST);
				setState(489);
				match(LPAREN);
				setState(493);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENTIFIABLE_STRING) {
					{
					{
					setState(490);
					match(IDENTIFIABLE_STRING);
					}
					}
					setState(495);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(496);
					match(COMMA);
					}
				}

				setState(499);
				match(RPAREN);
				}
				break;
			case D_VITE:
				enterOuterAlt(_localctx, 3);
				{
				setState(500);
				match(D_VITE);
				setState(501);
				match(LPAREN);
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(502);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(511);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(505);
					match(COMMA);
					setState(507);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIABLE_STRING) {
						{
						setState(506);
						match(IDENTIFIABLE_STRING);
						}
					}

					}
					}
					setState(513);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(514);
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
			setState(615);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_SECTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(517);
				match(D_SECTION);
				setState(518);
				match(LPAREN);
				setState(520);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(519);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(522);
				match(RPAREN);
				setState(524);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(523);
					match(D_PARENT);
					}
					break;
				}
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					{
					setState(526);
					statement();
					}
					}
					setState(531);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(533);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_PARENT) {
					{
					setState(532);
					match(D_PARENT);
					}
				}

				setState(535);
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
				setState(536);
				match(D_HAS_SECTION);
				setState(537);
				match(LPAREN);
				setState(539);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(538);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(541);
				match(RPAREN);
				setState(545);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					{
					setState(542);
					statement();
					}
					}
					setState(547);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(548);
				match(D_ENDIF);
				}
				break;
			case D_SECTION_MISSING:
				enterOuterAlt(_localctx, 3);
				{
				setState(549);
				match(D_SECTION_MISSING);
				setState(550);
				match(LPAREN);
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(551);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(554);
				match(RPAREN);
				setState(558);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
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
				setState(561);
				match(D_ENDIF);
				}
				break;
			case D_PUSH:
				enterOuterAlt(_localctx, 4);
				{
				setState(562);
				match(D_PUSH);
				setState(563);
				match(LPAREN);
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(564);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(567);
				match(RPAREN);
				setState(571);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
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
				match(D_ENDPUSH);
				}
				break;
			case D_PUSH_IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(575);
				match(D_PUSH_IF);
				setState(576);
				match(LPAREN);
				setState(578);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(577);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(580);
				match(COMMA);
				setState(581);
				match(RPAREN);
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					{
					setState(582);
					statement();
					}
					}
					setState(587);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(588);
				match(D_ENDPUSH_IF);
				}
				break;
			case D_PUSH_ONCE:
				enterOuterAlt(_localctx, 6);
				{
				setState(589);
				match(D_PUSH_ONCE);
				setState(590);
				match(LPAREN);
				setState(592);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(591);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(594);
				match(RPAREN);
				setState(598);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					{
					setState(595);
					statement();
					}
					}
					setState(600);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(601);
				match(D_ENDPUSH_ONCE);
				}
				break;
			case D_PREPEND:
				enterOuterAlt(_localctx, 7);
				{
				setState(602);
				match(D_PREPEND);
				setState(603);
				match(LPAREN);
				setState(605);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(604);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(607);
				match(RPAREN);
				setState(611);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					{
					setState(608);
					statement();
					}
					}
					setState(613);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(614);
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
			setState(617);
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
			setState(619);
			match(D_CUSTOM);
			setState(621);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(620);
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
			setState(623);
			_la = _input.LA(1);
			if ( !(_la==D_BREAK || _la==D_CONTINUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(625);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(624);
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
			setState(652);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_ERROR:
				enterOuterAlt(_localctx, 1);
				{
				setState(627);
				match(D_ERROR);
				setState(628);
				match(LPAREN);
				setState(630);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(629);
					match(COMMA);
					}
				}

				setState(632);
				match(RPAREN);
				setState(636);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(633);
						statement();
						}
						} 
					}
					setState(638);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
				}
				setState(646);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE) {
					{
					setState(639);
					match(D_ELSE);
					setState(643);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
						{
						{
						setState(640);
						statement();
						}
						}
						setState(645);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(648);
				match(D_ENDERROR);
				}
				break;
			case D_CSRF:
				enterOuterAlt(_localctx, 2);
				{
				setState(649);
				match(D_CSRF);
				}
				break;
			case D_METHOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(650);
				match(D_METHOD);
				setState(651);
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
			setState(703);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_AUTH:
				enterOuterAlt(_localctx, 1);
				{
				setState(654);
				match(D_AUTH);
				setState(656);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(655);
					directiveArguments();
					}
				}

				setState(661);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(658);
						statement();
						}
						} 
					}
					setState(663);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
				}
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==D_ELSE || _la==D_ELSEGUEST) {
					{
					setState(664);
					_la = _input.LA(1);
					if ( !(_la==D_ELSE || _la==D_ELSEGUEST) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(668);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
						{
						{
						setState(665);
						statement();
						}
						}
						setState(670);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(673);
				match(D_ENDAUTH);
				}
				break;
			case D_GUEST:
				enterOuterAlt(_localctx, 2);
				{
				setState(674);
				match(D_GUEST);
				setState(676);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(675);
					directiveArguments();
					}
				}

				setState(681);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					{
					setState(678);
					statement();
					}
					}
					setState(683);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(684);
				match(D_ENDGUEST);
				}
				break;
			case D_ENV:
				enterOuterAlt(_localctx, 3);
				{
				setState(685);
				match(D_ENV);
				setState(686);
				directiveArguments();
				setState(690);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					{
					setState(687);
					statement();
					}
					}
					setState(692);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(693);
				match(D_ENDENV);
				}
				break;
			case D_PRODUCTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(695);
				match(D_PRODUCTION);
				setState(699);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1537249334403614808L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 57655446640085L) != 0)) {
					{
					{
					setState(696);
					statement();
					}
					}
					setState(701);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(702);
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
			setState(705);
			match(BLADE_CONTENT_OPEN_TAG);
			setState(706);
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
			setState(708);
			match(BLADE_RAW_OPEN_TAG);
			setState(709);
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
			setState(736);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case D_EXTENDS:
			case D_INCLUDE:
			case D_YIELD:
				enterOuterAlt(_localctx, 1);
				{
				setState(711);
				directiveWithArg();
				setState(712);
				match(LPAREN);
				notifyErrorListeners("Missing closing ')'");
				}
				break;
			case D_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(715);
				match(D_IF);
				setState(716);
				directiveArguments();
				notifyErrorListeners("Syntax error, expecting @elseif or @else or @endif");
				}
				break;
			case D_FOREACH:
			case D_FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(723);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case D_FOREACH:
					{
					setState(719);
					match(D_FOREACH);
					setState(720);
					foreachLoopArguments();
					}
					break;
				case D_FOR:
					{
					setState(721);
					match(D_FOR);
					setState(722);
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
				setState(727);
				match(D_VERBATIM);
				notifyErrorListeners("Unclosed verbatim block");
				}
				break;
			case D_SECTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(729);
				match(D_SECTION);
				setState(730);
				match(LPAREN);
				setState(732);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIABLE_STRING) {
					{
					setState(731);
					match(IDENTIFIABLE_STRING);
					}
				}

				setState(734);
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
			setState(738);
			match(LPAREN);
			setState(742);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(739);
				match(COMMA);
				}
				}
				setState(744);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(745);
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
			setState(780);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(747);
				match(LPAREN);
				setState(748);
				((ForeachLoopArgumentsContext)_localctx).main_array = match(FOREACH_VAR);
				setState(749);
				match(FOREACH_AS);
				setState(750);
				((ForeachLoopArgumentsContext)_localctx).array_item = match(FOREACH_VAR);
				setState(753);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOREACH_DOUBLE_ARROW) {
					{
					setState(751);
					match(FOREACH_DOUBLE_ARROW);
					setState(752);
					((ForeachLoopArgumentsContext)_localctx).array_value = match(FOREACH_VAR);
					}
				}

				setState(755);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(756);
				match(LPAREN);
				setState(760);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FOREACH_VAR) {
					{
					{
					setState(757);
					match(FOREACH_VAR);
					}
					}
					setState(762);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(763);
				match(FOREACH_AS);
				setState(767);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FOREACH_VAR) {
					{
					{
					setState(764);
					match(FOREACH_VAR);
					}
					}
					setState(769);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(777);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FOREACH_DOUBLE_ARROW) {
					{
					setState(770);
					match(FOREACH_DOUBLE_ARROW);
					setState(774);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==FOREACH_VAR) {
						{
						{
						setState(771);
						match(FOREACH_VAR);
						}
						}
						setState(776);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(779);
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
		enterRule(_localctx, 50, RULE_phpInline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(782);
			match(PHP_INLINE_START);
			setState(783);
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
		enterRule(_localctx, 52, RULE_htmlComponentOpenTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(785);
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
		"\u0004\u0001\u00af\u0314\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"\u0002x\b\u0002\n\u0002\f\u0002{\t\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002\u007f\b\u0002\n\u0002\f\u0002\u0082\t\u0002\u0003\u0002\u0084\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002\u008b\b\u0002\n\u0002\f\u0002\u008e\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u0092\b\u0002\n\u0002\f\u0002\u0095\t\u0002\u0003\u0002\u0097"+
		"\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002\u009e\b\u0002\n\u0002\f\u0002\u00a1\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00a8\b\u0002\n\u0002"+
		"\f\u0002\u00ab\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u00b0\b\u0002\n\u0002\f\u0002\u00b3\t\u0002\u0005\u0002\u00b5\b\u0002"+
		"\n\u0002\f\u0002\u00b8\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00bc"+
		"\b\u0002\n\u0002\f\u0002\u00bf\t\u0002\u0003\u0002\u00c1\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u00c8"+
		"\b\u0002\n\u0002\f\u0002\u00cb\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u00d0\b\u0002\n\u0002\f\u0002\u00d3\t\u0002\u0005\u0002\u00d5"+
		"\b\u0002\n\u0002\f\u0002\u00d8\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u00dc\b\u0002\n\u0002\f\u0002\u00df\t\u0002\u0003\u0002\u00e1\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u00e8\b\u0002\n\u0002\f\u0002\u00eb\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u00f0\b\u0002\n\u0002\f\u0002\u00f3\t\u0002\u0005\u0002"+
		"\u00f5\b\u0002\n\u0002\f\u0002\u00f8\t\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002\u00fc\b\u0002\n\u0002\f\u0002\u00ff\t\u0002\u0003\u0002\u0101\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u0109\b\u0002\n\u0002\f\u0002\u010c\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u0114\b\u0002\n\u0002\f\u0002\u0117\t\u0002\u0001\u0002\u0003\u0002\u011a"+
		"\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u0120"+
		"\b\u0003\n\u0003\f\u0003\u0123\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003\u0128\b\u0003\n\u0003\f\u0003\u012b\t\u0003\u0003\u0003\u012d"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u0135\b\u0004\n\u0004\f\u0004\u0138\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u0140\b\u0005\n\u0005\f\u0005\u0143\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u014b\b\u0006\n"+
		"\u0006\f\u0006\u014e\t\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0152"+
		"\b\u0006\n\u0006\f\u0006\u0155\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u015f\b\b\n\b"+
		"\f\b\u0162\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0169\b"+
		"\t\n\t\f\t\u016c\t\t\u0001\t\u0003\t\u016f\b\t\u0005\t\u0171\b\t\n\t\f"+
		"\t\u0174\t\t\u0001\t\u0001\t\u0005\t\u0178\b\t\n\t\f\t\u017b\t\t\u0003"+
		"\t\u017d\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u018c\b\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u0191"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0198\b\f\u0001\f"+
		"\u0003\f\u019b\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01a1\b\f\u0001"+
		"\f\u0003\f\u01a4\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01ab"+
		"\b\f\u0001\f\u0003\f\u01ae\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f"+
		"\u01b4\b\f\u0001\f\u0003\f\u01b7\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u01bd\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01c3\b\f\u0001\f"+
		"\u0003\f\u01c6\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01cd"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01d3\b\f\u0001\f\u0003\f"+
		"\u01d6\b\f\u0001\f\u0003\f\u01d9\b\f\u0001\r\u0001\r\u0001\r\u0003\r\u01de"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u01e4\b\r\u0003\r\u01e6\b"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u01ec\b\r\n\r\f\r\u01ef\t\r"+
		"\u0001\r\u0003\r\u01f2\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u01f8"+
		"\b\r\u0001\r\u0001\r\u0003\r\u01fc\b\r\u0005\r\u01fe\b\r\n\r\f\r\u0201"+
		"\t\r\u0001\r\u0003\r\u0204\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0209\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u020d\b\u000e"+
		"\u0001\u000e\u0005\u000e\u0210\b\u000e\n\u000e\f\u000e\u0213\t\u000e\u0001"+
		"\u000e\u0003\u000e\u0216\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u021c\b\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0220"+
		"\b\u000e\n\u000e\f\u000e\u0223\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u0229\b\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u022d\b\u000e\n\u000e\f\u000e\u0230\t\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u0236\b\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u023a\b\u000e\n\u000e\f\u000e\u023d\t\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u0243\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u0248\b\u000e\n\u000e\f\u000e\u024b\t\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0251\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u0255\b\u000e\n\u000e\f\u000e\u0258\t\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u025e\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u0262\b\u000e\n\u000e\f\u000e\u0265"+
		"\t\u000e\u0001\u000e\u0003\u000e\u0268\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u026e\b\u0010\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0272\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u0277\b\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u027b\b\u0012\n\u0012"+
		"\f\u0012\u027e\t\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0282\b\u0012"+
		"\n\u0012\f\u0012\u0285\t\u0012\u0003\u0012\u0287\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u028d\b\u0012\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u0291\b\u0013\u0001\u0013\u0005\u0013\u0294\b\u0013"+
		"\n\u0013\f\u0013\u0297\t\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u029b"+
		"\b\u0013\n\u0013\f\u0013\u029e\t\u0013\u0003\u0013\u02a0\b\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u02a5\b\u0013\u0001\u0013\u0005"+
		"\u0013\u02a8\b\u0013\n\u0013\f\u0013\u02ab\t\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u02b1\b\u0013\n\u0013\f\u0013\u02b4"+
		"\t\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u02ba"+
		"\b\u0013\n\u0013\f\u0013\u02bd\t\u0013\u0001\u0013\u0003\u0013\u02c0\b"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u02d4\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u02dd\b\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u02e1\b\u0016\u0001\u0017\u0001\u0017\u0005"+
		"\u0017\u02e5\b\u0017\n\u0017\f\u0017\u02e8\t\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u02f2\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018"+
		"\u02f7\b\u0018\n\u0018\f\u0018\u02fa\t\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u02fe\b\u0018\n\u0018\f\u0018\u0301\t\u0018\u0001\u0018\u0001\u0018"+
		"\u0005\u0018\u0305\b\u0018\n\u0018\f\u0018\u0308\t\u0018\u0003\u0018\u030a"+
		"\b\u0018\u0001\u0018\u0003\u0018\u030d\b\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0000\u0000\u001b\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.024\u0000\b\u0002\u0000\u0006\u0006ff\u0001\u0000\u001b"+
		"\u001c\u0001\u0000\u001d\u001e\u0002\u0000%%\'*\u0002\u0000\u001a\u001b"+
		"!!\u0001\u0000>?\u0002\u0000\u0010\u0010MM\u0001\u0001\u00a9\u00a9\u03a3"+
		"\u00009\u0001\u0000\u0000\u0000\u0002K\u0001\u0000\u0000\u0000\u0004\u0119"+
		"\u0001\u0000\u0000\u0000\u0006\u011b\u0001\u0000\u0000\u0000\b\u0130\u0001"+
		"\u0000\u0000\u0000\n\u013b\u0001\u0000\u0000\u0000\f\u0146\u0001\u0000"+
		"\u0000\u0000\u000e\u0158\u0001\u0000\u0000\u0000\u0010\u015b\u0001\u0000"+
		"\u0000\u0000\u0012\u0163\u0001\u0000\u0000\u0000\u0014\u0180\u0001\u0000"+
		"\u0000\u0000\u0016\u018b\u0001\u0000\u0000\u0000\u0018\u01d8\u0001\u0000"+
		"\u0000\u0000\u001a\u0203\u0001\u0000\u0000\u0000\u001c\u0267\u0001\u0000"+
		"\u0000\u0000\u001e\u0269\u0001\u0000\u0000\u0000 \u026b\u0001\u0000\u0000"+
		"\u0000\"\u026f\u0001\u0000\u0000\u0000$\u028c\u0001\u0000\u0000\u0000"+
		"&\u02bf\u0001\u0000\u0000\u0000(\u02c1\u0001\u0000\u0000\u0000*\u02c4"+
		"\u0001\u0000\u0000\u0000,\u02e0\u0001\u0000\u0000\u0000.\u02e2\u0001\u0000"+
		"\u0000\u00000\u030c\u0001\u0000\u0000\u00002\u030e\u0001\u0000\u0000\u0000"+
		"4\u0311\u0001\u0000\u0000\u000068\u0003\u0002\u0001\u000076\u0001\u0000"+
		"\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		"<=\u0005\u0000\u0000\u0001=\u0001\u0001\u0000\u0000\u0000>L\u0003\u001c"+
		"\u000e\u0000?L\u0003\u0004\u0002\u0000@L\u0003\u0018\f\u0000AL\u0003\u001a"+
		"\r\u0000BL\u0003\u0016\u000b\u0000CL\u0003 \u0010\u0000DL\u0003(\u0014"+
		"\u0000EL\u0003*\u0015\u0000FL\u0007\u0000\u0000\u0000GL\u0003,\u0016\u0000"+
		"HL\u00032\u0019\u0000IL\u0005j\u0000\u0000JL\u00034\u001a\u0000K>\u0001"+
		"\u0000\u0000\u0000K?\u0001\u0000\u0000\u0000K@\u0001\u0000\u0000\u0000"+
		"KA\u0001\u0000\u0000\u0000KB\u0001\u0000\u0000\u0000KC\u0001\u0000\u0000"+
		"\u0000KD\u0001\u0000\u0000\u0000KE\u0001\u0000\u0000\u0000KF\u0001\u0000"+
		"\u0000\u0000KG\u0001\u0000\u0000\u0000KH\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000L\u0003\u0001\u0000\u0000"+
		"\u0000M\u011a\u0003\u0006\u0003\u0000N\u011a\u0003\b\u0004\u0000O\u011a"+
		"\u0003\n\u0005\u0000P\u011a\u0003\f\u0006\u0000QR\u0005<\u0000\u0000R"+
		"W\u0003.\u0017\u0000SV\u0003\u0002\u0001\u0000TV\u0003\"\u0011\u0000U"+
		"S\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000"+
		"\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XZ\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000Z[\u0005=\u0000\u0000[\u011a\u0001"+
		"\u0000\u0000\u0000\\\u011a\u0003\u0012\t\u0000]\u011a\u0003$\u0012\u0000"+
		"^\u011a\u0003&\u0013\u0000_a\u0005+\u0000\u0000`b\u0003.\u0017\u0000a"+
		"`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bf\u0001\u0000\u0000"+
		"\u0000ce\u0003\u0002\u0001\u0000dc\u0001\u0000\u0000\u0000eh\u0001\u0000"+
		"\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gi\u0001"+
		"\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000i\u011a\u0005,\u0000\u0000"+
		"jk\u0005\u0012\u0000\u0000ko\u0003.\u0017\u0000ln\u0003\u0002\u0001\u0000"+
		"ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000"+
		"\u0000op\u0001\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000qo\u0001\u0000"+
		"\u0000\u0000rs\u0005\u0013\u0000\u0000s\u011a\u0001\u0000\u0000\u0000"+
		"tu\u0005@\u0000\u0000uy\u0003.\u0017\u0000vx\u0003\u0002\u0001\u0000w"+
		"v\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000z\u0083\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|\u0080\u0005\u0010\u0000\u0000}\u007f\u0003\u0002\u0001"+
		"\u0000~}\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0084"+
		"\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083|\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0005A\u0000\u0000\u0086\u011a\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0005\u0014\u0000\u0000\u0088\u008c\u0003.\u0017"+
		"\u0000\u0089\u008b\u0003\u0002\u0001\u0000\u008a\u0089\u0001\u0000\u0000"+
		"\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u0096\u0001\u0000\u0000"+
		"\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0093\u0005\u0010\u0000"+
		"\u0000\u0090\u0092\u0003\u0002\u0001\u0000\u0091\u0090\u0001\u0000\u0000"+
		"\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000"+
		"\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u008f\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0005\u0015\u0000\u0000\u0099\u011a\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0005D\u0000\u0000\u009b\u009f\u0003.\u0017\u0000\u009c"+
		"\u009e\u0003\u0002\u0001\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e"+
		"\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a2\u0001\u0000\u0000\u0000\u00a1"+
		"\u009f\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005E\u0000\u0000\u00a3\u011a"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005S\u0000\u0000\u00a5\u00a9\u0003"+
		".\u0017\u0000\u00a6\u00a8\u0003\u0002\u0001\u0000\u00a7\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00b6\u0001\u0000"+
		"\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005W\u0000"+
		"\u0000\u00ad\u00b1\u0003.\u0017\u0000\u00ae\u00b0\u0003\u0002\u0001\u0000"+
		"\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b4\u00ac\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7\u00c0\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b9\u00bd\u0005\u0010\u0000\u0000\u00ba\u00bc\u0003\u0002\u0001\u0000"+
		"\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000"+
		"\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000"+
		"\u00be\u00c1\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000"+
		"\u00c0\u00b9\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005T\u0000\u0000\u00c3"+
		"\u011a\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005U\u0000\u0000\u00c5\u00c9"+
		"\u0003.\u0017\u0000\u00c6\u00c8\u0003\u0002\u0001\u0000\u00c7\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00d6\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005"+
		"W\u0000\u0000\u00cd\u00d1\u0003.\u0017\u0000\u00ce\u00d0\u0003\u0002\u0001"+
		"\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d4\u00cc\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d7\u00e0\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d9\u00dd\u0005\u0010\u0000\u0000\u00da\u00dc\u0003\u0002\u0001"+
		"\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc\u00df\u0001\u0000\u0000"+
		"\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000"+
		"\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000"+
		"\u0000\u00e0\u00d9\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005X\u0000\u0000"+
		"\u00e3\u011a\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005V\u0000\u0000\u00e5"+
		"\u00e9\u0003.\u0017\u0000\u00e6\u00e8\u0003\u0002\u0001\u0000\u00e7\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00f6"+
		"\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed"+
		"\u0005W\u0000\u0000\u00ed\u00f1\u0003.\u0017\u0000\u00ee\u00f0\u0003\u0002"+
		"\u0001\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f5\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000"+
		"\u0000\u0000\u00f4\u00ec\u0001\u0000\u0000\u0000\u00f5\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000"+
		"\u0000\u0000\u00f7\u0100\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fd\u0005\u0010\u0000\u0000\u00fa\u00fc\u0003\u0002"+
		"\u0001\u0000\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc\u00ff\u0001\u0000"+
		"\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000"+
		"\u0000\u0000\u00fe\u0101\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000"+
		"\u0000\u0000\u0100\u00f9\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000"+
		"\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0103\u0005Y\u0000"+
		"\u0000\u0103\u011a\u0001\u0000\u0000\u0000\u0104\u011a\u0003\u0014\n\u0000"+
		"\u0105\u0106\u0005Z\u0000\u0000\u0106\u010a\u0003.\u0017\u0000\u0107\u0109"+
		"\u0003\u0002\u0001\u0000\u0108\u0107\u0001\u0000\u0000\u0000\u0109\u010c"+
		"\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u010b"+
		"\u0001\u0000\u0000\u0000\u010b\u010d\u0001\u0000\u0000\u0000\u010c\u010a"+
		"\u0001\u0000\u0000\u0000\u010d\u010e\u0005[\u0000\u0000\u010e\u011a\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0005B\u0000\u0000\u0110\u011a\u0005C\u0000"+
		"\u0000\u0111\u0115\u0005\u0010\u0000\u0000\u0112\u0114\u0003\u0002\u0001"+
		"\u0000\u0113\u0112\u0001\u0000\u0000\u0000\u0114\u0117\u0001\u0000\u0000"+
		"\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000"+
		"\u0000\u0116\u0118\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000"+
		"\u0000\u0118\u011a\u0005j\u0000\u0000\u0119M\u0001\u0000\u0000\u0000\u0119"+
		"N\u0001\u0000\u0000\u0000\u0119O\u0001\u0000\u0000\u0000\u0119P\u0001"+
		"\u0000\u0000\u0000\u0119Q\u0001\u0000\u0000\u0000\u0119\\\u0001\u0000"+
		"\u0000\u0000\u0119]\u0001\u0000\u0000\u0000\u0119^\u0001\u0000\u0000\u0000"+
		"\u0119_\u0001\u0000\u0000\u0000\u0119j\u0001\u0000\u0000\u0000\u0119t"+
		"\u0001\u0000\u0000\u0000\u0119\u0087\u0001\u0000\u0000\u0000\u0119\u009a"+
		"\u0001\u0000\u0000\u0000\u0119\u00a4\u0001\u0000\u0000\u0000\u0119\u00c4"+
		"\u0001\u0000\u0000\u0000\u0119\u00e4\u0001\u0000\u0000\u0000\u0119\u0104"+
		"\u0001\u0000\u0000\u0000\u0119\u0105\u0001\u0000\u0000\u0000\u0119\u010f"+
		"\u0001\u0000\u0000\u0000\u0119\u0111\u0001\u0000\u0000\u0000\u011a\u0005"+
		"\u0001\u0000\u0000\u0000\u011b\u0121\u0003\u000e\u0007\u0000\u011c\u0120"+
		"\u0003\u0010\b\u0000\u011d\u0120\u0003\u0002\u0001\u0000\u011e\u0120\u0003"+
		"\"\u0011\u0000\u011f\u011c\u0001\u0000\u0000\u0000\u011f\u011d\u0001\u0000"+
		"\u0000\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u0120\u0123\u0001\u0000"+
		"\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000"+
		"\u0000\u0000\u0122\u012c\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000"+
		"\u0000\u0000\u0124\u0129\u0005\u0010\u0000\u0000\u0125\u0128\u0003\u0002"+
		"\u0001\u0000\u0126\u0128\u0003\"\u0011\u0000\u0127\u0125\u0001\u0000\u0000"+
		"\u0000\u0127\u0126\u0001\u0000\u0000\u0000\u0128\u012b\u0001\u0000\u0000"+
		"\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000"+
		"\u0000\u012a\u012d\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000"+
		"\u0000\u012c\u0124\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000"+
		"\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u012f\u0005\u0011\u0000"+
		"\u0000\u012f\u0007\u0001\u0000\u0000\u0000\u0130\u0131\u00056\u0000\u0000"+
		"\u0131\u0136\u00030\u0018\u0000\u0132\u0135\u0003\u0002\u0001\u0000\u0133"+
		"\u0135\u0003\"\u0011\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0134\u0133"+
		"\u0001\u0000\u0000\u0000\u0135\u0138\u0001\u0000\u0000\u0000\u0136\u0134"+
		"\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137\u0139"+
		"\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0139\u013a"+
		"\u00057\u0000\u0000\u013a\t\u0001\u0000\u0000\u0000\u013b\u013c\u0005"+
		"8\u0000\u0000\u013c\u0141\u0003.\u0017\u0000\u013d\u0140\u0003\u0002\u0001"+
		"\u0000\u013e\u0140\u0003\"\u0011\u0000\u013f\u013d\u0001\u0000\u0000\u0000"+
		"\u013f\u013e\u0001\u0000\u0000\u0000\u0140\u0143\u0001\u0000\u0000\u0000"+
		"\u0141\u013f\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000\u0000"+
		"\u0142\u0144\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000"+
		"\u0144\u0145\u00059\u0000\u0000\u0145\u000b\u0001\u0000\u0000\u0000\u0146"+
		"\u0147\u0005:\u0000\u0000\u0147\u014c\u0003.\u0017\u0000\u0148\u014b\u0003"+
		"\u0002\u0001\u0000\u0149\u014b\u0003\"\u0011\u0000\u014a\u0148\u0001\u0000"+
		"\u0000\u0000\u014a\u0149\u0001\u0000\u0000\u0000\u014b\u014e\u0001\u0000"+
		"\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000"+
		"\u0000\u0000\u014d\u014f\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000"+
		"\u0000\u0000\u014f\u0153\u0005@\u0000\u0000\u0150\u0152\u0003\u0002\u0001"+
		"\u0000\u0151\u0150\u0001\u0000\u0000\u0000\u0152\u0155\u0001\u0000\u0000"+
		"\u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000"+
		"\u0000\u0154\u0156\u0001\u0000\u0000\u0000\u0155\u0153\u0001\u0000\u0000"+
		"\u0000\u0156\u0157\u0005;\u0000\u0000\u0157\r\u0001\u0000\u0000\u0000"+
		"\u0158\u0159\u0005\u000e\u0000\u0000\u0159\u015a\u0003.\u0017\u0000\u015a"+
		"\u000f\u0001\u0000\u0000\u0000\u015b\u015c\u0005\u000f\u0000\u0000\u015c"+
		"\u0160\u0003.\u0017\u0000\u015d\u015f\u0003\u0002\u0001\u0000\u015e\u015d"+
		"\u0001\u0000\u0000\u0000\u015f\u0162\u0001\u0000\u0000\u0000\u0160\u015e"+
		"\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000\u0161\u0011"+
		"\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0163\u0164"+
		"\u0005\u0016\u0000\u0000\u0164\u0172\u0003.\u0017\u0000\u0165\u0166\u0005"+
		"\u0017\u0000\u0000\u0166\u016a\u0003.\u0017\u0000\u0167\u0169\u0003\u0002"+
		"\u0001\u0000\u0168\u0167\u0001\u0000\u0000\u0000\u0169\u016c\u0001\u0000"+
		"\u0000\u0000\u016a\u0168\u0001\u0000\u0000\u0000\u016a\u016b\u0001\u0000"+
		"\u0000\u0000\u016b\u016e\u0001\u0000\u0000\u0000\u016c\u016a\u0001\u0000"+
		"\u0000\u0000\u016d\u016f\u0005>\u0000\u0000\u016e\u016d\u0001\u0000\u0000"+
		"\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u0171\u0001\u0000\u0000"+
		"\u0000\u0170\u0165\u0001\u0000\u0000\u0000\u0171\u0174\u0001\u0000\u0000"+
		"\u0000\u0172\u0170\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000"+
		"\u0000\u0173\u017c\u0001\u0000\u0000\u0000\u0174\u0172\u0001\u0000\u0000"+
		"\u0000\u0175\u0179\u0005\u0018\u0000\u0000\u0176\u0178\u0003\u0002\u0001"+
		"\u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0178\u017b\u0001\u0000\u0000"+
		"\u0000\u0179\u0177\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000\u0000"+
		"\u0000\u017a\u017d\u0001\u0000\u0000\u0000\u017b\u0179\u0001\u0000\u0000"+
		"\u0000\u017c\u0175\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000"+
		"\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u017f\u0005\u0019\u0000"+
		"\u0000\u017f\u0013\u0001\u0000\u0000\u0000\u0180\u0181\u0005\u000b\u0000"+
		"\u0000\u0181\u0182\u0005\u00a6\u0000\u0000\u0182\u0015\u0001\u0000\u0000"+
		"\u0000\u0183\u0184\u0005\\\u0000\u0000\u0184\u018c\u0003.\u0017\u0000"+
		"\u0185\u0186\u0005]\u0000\u0000\u0186\u018c\u0003.\u0017\u0000\u0187\u0188"+
		"\u0005\u000b\u0000\u0000\u0188\u018c\u0003.\u0017\u0000\u0189\u018c\u0005"+
		"\u0004\u0000\u0000\u018a\u018c\u0005_\u0000\u0000\u018b\u0183\u0001\u0000"+
		"\u0000\u0000\u018b\u0185\u0001\u0000\u0000\u0000\u018b\u0187\u0001\u0000"+
		"\u0000\u0000\u018b\u0189\u0001\u0000\u0000\u0000\u018b\u018a\u0001\u0000"+
		"\u0000\u0000\u018c\u0017\u0001\u0000\u0000\u0000\u018d\u018e\u0005\"\u0000"+
		"\u0000\u018e\u0190\u0005\u0001\u0000\u0000\u018f\u0191\u0005\u0005\u0000"+
		"\u0000\u0190\u018f\u0001\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000"+
		"\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0192\u0193\u0005\f\u0000\u0000"+
		"\u0193\u01d9\u0005\u0002\u0000\u0000\u0194\u0195\u0005\u001a\u0000\u0000"+
		"\u0195\u0197\u0005\u0001\u0000\u0000\u0196\u0198\u0005\u0005\u0000\u0000"+
		"\u0197\u0196\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000"+
		"\u0198\u019a\u0001\u0000\u0000\u0000\u0199\u019b\u0005\f\u0000\u0000\u019a"+
		"\u0199\u0001\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000\u0000\u019b"+
		"\u019c\u0001\u0000\u0000\u0000\u019c\u01d9\u0005\u0002\u0000\u0000\u019d"+
		"\u019e\u0007\u0001\u0000\u0000\u019e\u01a0\u0005\u0001\u0000\u0000\u019f"+
		"\u01a1\u0005\u0005\u0000\u0000\u01a0\u019f\u0001\u0000\u0000\u0000\u01a0"+
		"\u01a1\u0001\u0000\u0000\u0000\u01a1\u01a3\u0001\u0000\u0000\u0000\u01a2"+
		"\u01a4\u0005\f\u0000\u0000\u01a3\u01a2\u0001\u0000\u0000\u0000\u01a3\u01a4"+
		"\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000\u01a5\u01d9"+
		"\u0005\u0002\u0000\u0000\u01a6\u01a7\u0007\u0002\u0000\u0000\u01a7\u01a8"+
		"\u0005\u0001\u0000\u0000\u01a8\u01aa\u0005\f\u0000\u0000\u01a9\u01ab\u0005"+
		"\u0005\u0000\u0000\u01aa\u01a9\u0001\u0000\u0000\u0000\u01aa\u01ab\u0001"+
		"\u0000\u0000\u0000\u01ab\u01ad\u0001\u0000\u0000\u0000\u01ac\u01ae\u0005"+
		"\f\u0000\u0000\u01ad\u01ac\u0001\u0000\u0000\u0000\u01ad\u01ae\u0001\u0000"+
		"\u0000\u0000\u01ae\u01af\u0001\u0000\u0000\u0000\u01af\u01d9\u0005\u0002"+
		"\u0000\u0000\u01b0\u01b1\u0005!\u0000\u0000\u01b1\u01b3\u0005\u0001\u0000"+
		"\u0000\u01b2\u01b4\u0005\u0005\u0000\u0000\u01b3\u01b2\u0001\u0000\u0000"+
		"\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4\u01b6\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b7\u0005\f\u0000\u0000\u01b6\u01b5\u0001\u0000\u0000\u0000"+
		"\u01b6\u01b7\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001\u0000\u0000\u0000"+
		"\u01b8\u01d9\u0005\u0002\u0000\u0000\u01b9\u01ba\u0005-\u0000\u0000\u01ba"+
		"\u01bc\u0005\u0001\u0000\u0000\u01bb\u01bd\u0005\u0005\u0000\u0000\u01bc"+
		"\u01bb\u0001\u0000\u0000\u0000\u01bc\u01bd\u0001\u0000\u0000\u0000\u01bd"+
		"\u01be\u0001\u0000\u0000\u0000\u01be\u01d9\u0005\u0002\u0000\u0000\u01bf"+
		"\u01c0\u0005`\u0000\u0000\u01c0\u01c2\u0005\u0001\u0000\u0000\u01c1\u01c3"+
		"\u0005\u0005\u0000\u0000\u01c2\u01c1\u0001\u0000\u0000\u0000\u01c2\u01c3"+
		"\u0001\u0000\u0000\u0000\u01c3\u01c5\u0001\u0000\u0000\u0000\u01c4\u01c6"+
		"\u0005\f\u0000\u0000\u01c5\u01c4\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001"+
		"\u0000\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000\u01c7\u01d9\u0005"+
		"\u0002\u0000\u0000\u01c8\u01c9\u0005a\u0000\u0000\u01c9\u01ca\u0005\u0001"+
		"\u0000\u0000\u01ca\u01cc\u0005\f\u0000\u0000\u01cb\u01cd\u0005\u0005\u0000"+
		"\u0000\u01cc\u01cb\u0001\u0000\u0000\u0000\u01cc\u01cd\u0001\u0000\u0000"+
		"\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ce\u01d9\u0005\u0002\u0000"+
		"\u0000\u01cf\u01d0\u0005b\u0000\u0000\u01d0\u01d2\u0005\u0001\u0000\u0000"+
		"\u01d1\u01d3\u0005\u0005\u0000\u0000\u01d2\u01d1\u0001\u0000\u0000\u0000"+
		"\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d5\u0001\u0000\u0000\u0000"+
		"\u01d4\u01d6\u0005\f\u0000\u0000\u01d5\u01d4\u0001\u0000\u0000\u0000\u01d5"+
		"\u01d6\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000\u0000\u01d7"+
		"\u01d9\u0005\u0002\u0000\u0000\u01d8\u018d\u0001\u0000\u0000\u0000\u01d8"+
		"\u0194\u0001\u0000\u0000\u0000\u01d8\u019d\u0001\u0000\u0000\u0000\u01d8"+
		"\u01a6\u0001\u0000\u0000\u0000\u01d8\u01b0\u0001\u0000\u0000\u0000\u01d8"+
		"\u01b9\u0001\u0000\u0000\u0000\u01d8\u01bf\u0001\u0000\u0000\u0000\u01d8"+
		"\u01c8\u0001\u0000\u0000\u0000\u01d8\u01cf\u0001\u0000\u0000\u0000\u01d9"+
		"\u0019\u0001\u0000\u0000\u0000\u01da\u01db\u0005 \u0000\u0000\u01db\u01dd"+
		"\u0005\u0001\u0000\u0000\u01dc\u01de\u0005\u0005\u0000\u0000\u01dd\u01dc"+
		"\u0001\u0000\u0000\u0000\u01dd\u01de\u0001\u0000\u0000\u0000\u01de\u01df"+
		"\u0001\u0000\u0000\u0000\u01df\u01e0\u0005\f\u0000\u0000\u01e0\u01e5\u0005"+
		"\f\u0000\u0000\u01e1\u01e3\u0005\f\u0000\u0000\u01e2\u01e4\u0005\u0005"+
		"\u0000\u0000\u01e3\u01e2\u0001\u0000\u0000\u0000\u01e3\u01e4\u0001\u0000"+
		"\u0000\u0000\u01e4\u01e6\u0001\u0000\u0000\u0000\u01e5\u01e1\u0001\u0000"+
		"\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001\u0000"+
		"\u0000\u0000\u01e7\u0204\u0005\u0002\u0000\u0000\u01e8\u01e9\u0005\u001f"+
		"\u0000\u0000\u01e9\u01ed\u0005\u0001\u0000\u0000\u01ea\u01ec\u0005\u0005"+
		"\u0000\u0000\u01eb\u01ea\u0001\u0000\u0000\u0000\u01ec\u01ef\u0001\u0000"+
		"\u0000\u0000\u01ed\u01eb\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000"+
		"\u0000\u0000\u01ee\u01f1\u0001\u0000\u0000\u0000\u01ef\u01ed\u0001\u0000"+
		"\u0000\u0000\u01f0\u01f2\u0005\f\u0000\u0000\u01f1\u01f0\u0001\u0000\u0000"+
		"\u0000\u01f1\u01f2\u0001\u0000\u0000\u0000\u01f2\u01f3\u0001\u0000\u0000"+
		"\u0000\u01f3\u0204\u0005\u0002\u0000\u0000\u01f4\u01f5\u0005^\u0000\u0000"+
		"\u01f5\u01f7\u0005\u0001\u0000\u0000\u01f6\u01f8\u0005\u0005\u0000\u0000"+
		"\u01f7\u01f6\u0001\u0000\u0000\u0000\u01f7\u01f8\u0001\u0000\u0000\u0000"+
		"\u01f8\u01ff\u0001\u0000\u0000\u0000\u01f9\u01fb\u0005\f\u0000\u0000\u01fa"+
		"\u01fc\u0005\u0005\u0000\u0000\u01fb\u01fa\u0001\u0000\u0000\u0000\u01fb"+
		"\u01fc\u0001\u0000\u0000\u0000\u01fc\u01fe\u0001\u0000\u0000\u0000\u01fd"+
		"\u01f9\u0001\u0000\u0000\u0000\u01fe\u0201\u0001\u0000\u0000\u0000\u01ff"+
		"\u01fd\u0001\u0000\u0000\u0000\u01ff\u0200\u0001\u0000\u0000\u0000\u0200"+
		"\u0202\u0001\u0000\u0000\u0000\u0201\u01ff\u0001\u0000\u0000\u0000\u0202"+
		"\u0204\u0005\u0002\u0000\u0000\u0203\u01da\u0001\u0000\u0000\u0000\u0203"+
		"\u01e8\u0001\u0000\u0000\u0000\u0203\u01f4\u0001\u0000\u0000\u0000\u0204"+
		"\u001b\u0001\u0000\u0000\u0000\u0205\u0206\u0005\"\u0000\u0000\u0206\u0208"+
		"\u0005\u0001\u0000\u0000\u0207\u0209\u0005\u0005\u0000\u0000\u0208\u0207"+
		"\u0001\u0000\u0000\u0000\u0208\u0209\u0001\u0000\u0000\u0000\u0209\u020a"+
		"\u0001\u0000\u0000\u0000\u020a\u020c\u0005\u0002\u0000\u0000\u020b\u020d"+
		"\u0005&\u0000\u0000\u020c\u020b\u0001\u0000\u0000\u0000\u020c\u020d\u0001"+
		"\u0000\u0000\u0000\u020d\u0211\u0001\u0000\u0000\u0000\u020e\u0210\u0003"+
		"\u0002\u0001\u0000\u020f\u020e\u0001\u0000\u0000\u0000\u0210\u0213\u0001"+
		"\u0000\u0000\u0000\u0211\u020f\u0001\u0000\u0000\u0000\u0211\u0212\u0001"+
		"\u0000\u0000\u0000\u0212\u0215\u0001\u0000\u0000\u0000\u0213\u0211\u0001"+
		"\u0000\u0000\u0000\u0214\u0216\u0005&\u0000\u0000\u0215\u0214\u0001\u0000"+
		"\u0000\u0000\u0215\u0216\u0001\u0000\u0000\u0000\u0216\u0217\u0001\u0000"+
		"\u0000\u0000\u0217\u0268\u0007\u0003\u0000\u0000\u0218\u0219\u0005#\u0000"+
		"\u0000\u0219\u021b\u0005\u0001\u0000\u0000\u021a\u021c\u0005\u0005\u0000"+
		"\u0000\u021b\u021a\u0001\u0000\u0000\u0000\u021b\u021c\u0001\u0000\u0000"+
		"\u0000\u021c\u021d\u0001\u0000\u0000\u0000\u021d\u0221\u0005\u0002\u0000"+
		"\u0000\u021e\u0220\u0003\u0002\u0001\u0000\u021f\u021e\u0001\u0000\u0000"+
		"\u0000\u0220\u0223\u0001\u0000\u0000\u0000\u0221\u021f\u0001\u0000\u0000"+
		"\u0000\u0221\u0222\u0001\u0000\u0000\u0000\u0222\u0224\u0001\u0000\u0000"+
		"\u0000\u0223\u0221\u0001\u0000\u0000\u0000\u0224\u0268\u0005\u0011\u0000"+
		"\u0000\u0225\u0226\u0005$\u0000\u0000\u0226\u0228\u0005\u0001\u0000\u0000"+
		"\u0227\u0229\u0005\u0005\u0000\u0000\u0228\u0227\u0001\u0000\u0000\u0000"+
		"\u0228\u0229\u0001\u0000\u0000\u0000\u0229\u022a\u0001\u0000\u0000\u0000"+
		"\u022a\u022e\u0005\u0002\u0000\u0000\u022b\u022d\u0003\u0002\u0001\u0000"+
		"\u022c\u022b\u0001\u0000\u0000\u0000\u022d\u0230\u0001\u0000\u0000\u0000"+
		"\u022e\u022c\u0001\u0000\u0000\u0000\u022e\u022f\u0001\u0000\u0000\u0000"+
		"\u022f\u0231\u0001\u0000\u0000\u0000\u0230\u022e\u0001\u0000\u0000\u0000"+
		"\u0231\u0268\u0005\u0011\u0000\u0000\u0232\u0233\u0005.\u0000\u0000\u0233"+
		"\u0235\u0005\u0001\u0000\u0000\u0234\u0236\u0005\u0005\u0000\u0000\u0235"+
		"\u0234\u0001\u0000\u0000\u0000\u0235\u0236\u0001\u0000\u0000\u0000\u0236"+
		"\u0237\u0001\u0000\u0000\u0000\u0237\u023b\u0005\u0002\u0000\u0000\u0238"+
		"\u023a\u0003\u0002\u0001\u0000\u0239\u0238\u0001\u0000\u0000\u0000\u023a"+
		"\u023d\u0001\u0000\u0000\u0000\u023b\u0239\u0001\u0000\u0000\u0000\u023b"+
		"\u023c\u0001\u0000\u0000\u0000\u023c\u023e\u0001\u0000\u0000\u0000\u023d"+
		"\u023b\u0001\u0000\u0000\u0000\u023e\u0268\u0005/\u0000\u0000\u023f\u0240"+
		"\u00050\u0000\u0000\u0240\u0242\u0005\u0001\u0000\u0000\u0241\u0243\u0005"+
		"\u0005\u0000\u0000\u0242\u0241\u0001\u0000\u0000\u0000\u0242\u0243\u0001"+
		"\u0000\u0000\u0000\u0243\u0244\u0001\u0000\u0000\u0000\u0244\u0245\u0005"+
		"\f\u0000\u0000\u0245\u0249\u0005\u0002\u0000\u0000\u0246\u0248\u0003\u0002"+
		"\u0001\u0000\u0247\u0246\u0001\u0000\u0000\u0000\u0248\u024b\u0001\u0000"+
		"\u0000\u0000\u0249\u0247\u0001\u0000\u0000\u0000\u0249\u024a\u0001\u0000"+
		"\u0000\u0000\u024a\u024c\u0001\u0000\u0000\u0000\u024b\u0249\u0001\u0000"+
		"\u0000\u0000\u024c\u0268\u00051\u0000\u0000\u024d\u024e\u00052\u0000\u0000"+
		"\u024e\u0250\u0005\u0001\u0000\u0000\u024f\u0251\u0005\u0005\u0000\u0000"+
		"\u0250\u024f\u0001\u0000\u0000\u0000\u0250\u0251\u0001\u0000\u0000\u0000"+
		"\u0251\u0252\u0001\u0000\u0000\u0000\u0252\u0256\u0005\u0002\u0000\u0000"+
		"\u0253\u0255\u0003\u0002\u0001\u0000\u0254\u0253\u0001\u0000\u0000\u0000"+
		"\u0255\u0258\u0001\u0000\u0000\u0000\u0256\u0254\u0001\u0000\u0000\u0000"+
		"\u0256\u0257\u0001\u0000\u0000\u0000\u0257\u0259\u0001\u0000\u0000\u0000"+
		"\u0258\u0256\u0001\u0000\u0000\u0000\u0259\u0268\u00053\u0000\u0000\u025a"+
		"\u025b\u00054\u0000\u0000\u025b\u025d\u0005\u0001\u0000\u0000\u025c\u025e"+
		"\u0005\u0005\u0000\u0000\u025d\u025c\u0001\u0000\u0000\u0000\u025d\u025e"+
		"\u0001\u0000\u0000\u0000\u025e\u025f\u0001\u0000\u0000\u0000\u025f\u0263"+
		"\u0005\u0002\u0000\u0000\u0260\u0262\u0003\u0002\u0001\u0000\u0261\u0260"+
		"\u0001\u0000\u0000\u0000\u0262\u0265\u0001\u0000\u0000\u0000\u0263\u0261"+
		"\u0001\u0000\u0000\u0000\u0263\u0264\u0001\u0000\u0000\u0000\u0264\u0266"+
		"\u0001\u0000\u0000\u0000\u0265\u0263\u0001\u0000\u0000\u0000\u0266\u0268"+
		"\u00055\u0000\u0000\u0267\u0205\u0001\u0000\u0000\u0000\u0267\u0218\u0001"+
		"\u0000\u0000\u0000\u0267\u0225\u0001\u0000\u0000\u0000\u0267\u0232\u0001"+
		"\u0000\u0000\u0000\u0267\u023f\u0001\u0000\u0000\u0000\u0267\u024d\u0001"+
		"\u0000\u0000\u0000\u0267\u025a\u0001\u0000\u0000\u0000\u0268\u001d\u0001"+
		"\u0000\u0000\u0000\u0269\u026a\u0007\u0004\u0000\u0000\u026a\u001f\u0001"+
		"\u0000\u0000\u0000\u026b\u026d\u0005\u0003\u0000\u0000\u026c\u026e\u0003"+
		".\u0017\u0000\u026d\u026c\u0001\u0000\u0000\u0000\u026d\u026e\u0001\u0000"+
		"\u0000\u0000\u026e!\u0001\u0000\u0000\u0000\u026f\u0271\u0007\u0005\u0000"+
		"\u0000\u0270\u0272\u0003.\u0017\u0000\u0271\u0270\u0001\u0000\u0000\u0000"+
		"\u0271\u0272\u0001\u0000\u0000\u0000\u0272#\u0001\u0000\u0000\u0000\u0273"+
		"\u0274\u0005H\u0000\u0000\u0274\u0276\u0005\u0001\u0000\u0000\u0275\u0277"+
		"\u0005\f\u0000\u0000\u0276\u0275\u0001\u0000\u0000\u0000\u0276\u0277\u0001"+
		"\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278\u027c\u0005"+
		"\u0002\u0000\u0000\u0279\u027b\u0003\u0002\u0001\u0000\u027a\u0279\u0001"+
		"\u0000\u0000\u0000\u027b\u027e\u0001\u0000\u0000\u0000\u027c\u027a\u0001"+
		"\u0000\u0000\u0000\u027c\u027d\u0001\u0000\u0000\u0000\u027d\u0286\u0001"+
		"\u0000\u0000\u0000\u027e\u027c\u0001\u0000\u0000\u0000\u027f\u0283\u0005"+
		"\u0010\u0000\u0000\u0280\u0282\u0003\u0002\u0001\u0000\u0281\u0280\u0001"+
		"\u0000\u0000\u0000\u0282\u0285\u0001\u0000\u0000\u0000\u0283\u0281\u0001"+
		"\u0000\u0000\u0000\u0283\u0284\u0001\u0000\u0000\u0000\u0284\u0287\u0001"+
		"\u0000\u0000\u0000\u0285\u0283\u0001\u0000\u0000\u0000\u0286\u027f\u0001"+
		"\u0000\u0000\u0000\u0286\u0287\u0001\u0000\u0000\u0000\u0287\u0288\u0001"+
		"\u0000\u0000\u0000\u0288\u028d\u0005I\u0000\u0000\u0289\u028d\u0005F\u0000"+
		"\u0000\u028a\u028b\u0005G\u0000\u0000\u028b\u028d\u0003.\u0017\u0000\u028c"+
		"\u0273\u0001\u0000\u0000\u0000\u028c\u0289\u0001\u0000\u0000\u0000\u028c"+
		"\u028a\u0001\u0000\u0000\u0000\u028d%\u0001\u0000\u0000\u0000\u028e\u0290"+
		"\u0005J\u0000\u0000\u028f\u0291\u0003.\u0017\u0000\u0290\u028f\u0001\u0000"+
		"\u0000\u0000\u0290\u0291\u0001\u0000\u0000\u0000\u0291\u0295\u0001\u0000"+
		"\u0000\u0000\u0292\u0294\u0003\u0002\u0001\u0000\u0293\u0292\u0001\u0000"+
		"\u0000\u0000\u0294\u0297\u0001\u0000\u0000\u0000\u0295\u0293\u0001\u0000"+
		"\u0000\u0000\u0295\u0296\u0001\u0000\u0000\u0000\u0296\u029f\u0001\u0000"+
		"\u0000\u0000\u0297\u0295\u0001\u0000\u0000\u0000\u0298\u029c\u0007\u0006"+
		"\u0000\u0000\u0299\u029b\u0003\u0002\u0001\u0000\u029a\u0299\u0001\u0000"+
		"\u0000\u0000\u029b\u029e\u0001\u0000\u0000\u0000\u029c\u029a\u0001\u0000"+
		"\u0000\u0000\u029c\u029d\u0001\u0000\u0000\u0000\u029d\u02a0\u0001\u0000"+
		"\u0000\u0000\u029e\u029c\u0001\u0000\u0000\u0000\u029f\u0298\u0001\u0000"+
		"\u0000\u0000\u029f\u02a0\u0001\u0000\u0000\u0000\u02a0\u02a1\u0001\u0000"+
		"\u0000\u0000\u02a1\u02c0\u0005K\u0000\u0000\u02a2\u02a4\u0005L\u0000\u0000"+
		"\u02a3\u02a5\u0003.\u0017\u0000\u02a4\u02a3\u0001\u0000\u0000\u0000\u02a4"+
		"\u02a5\u0001\u0000\u0000\u0000\u02a5\u02a9\u0001\u0000\u0000\u0000\u02a6"+
		"\u02a8\u0003\u0002\u0001\u0000\u02a7\u02a6\u0001\u0000\u0000\u0000\u02a8"+
		"\u02ab\u0001\u0000\u0000\u0000\u02a9\u02a7\u0001\u0000\u0000\u0000\u02a9"+
		"\u02aa\u0001\u0000\u0000\u0000\u02aa\u02ac\u0001\u0000\u0000\u0000\u02ab"+
		"\u02a9\u0001\u0000\u0000\u0000\u02ac\u02c0\u0005N\u0000\u0000\u02ad\u02ae"+
		"\u0005O\u0000\u0000\u02ae\u02b2\u0003.\u0017\u0000\u02af\u02b1\u0003\u0002"+
		"\u0001\u0000\u02b0\u02af\u0001\u0000\u0000\u0000\u02b1\u02b4\u0001\u0000"+
		"\u0000\u0000\u02b2\u02b0\u0001\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000"+
		"\u0000\u0000\u02b3\u02b5\u0001\u0000\u0000\u0000\u02b4\u02b2\u0001\u0000"+
		"\u0000\u0000\u02b5\u02b6\u0005P\u0000\u0000\u02b6\u02c0\u0001\u0000\u0000"+
		"\u0000\u02b7\u02bb\u0005Q\u0000\u0000\u02b8\u02ba\u0003\u0002\u0001\u0000"+
		"\u02b9\u02b8\u0001\u0000\u0000\u0000\u02ba\u02bd\u0001\u0000\u0000\u0000"+
		"\u02bb\u02b9\u0001\u0000\u0000\u0000\u02bb\u02bc\u0001\u0000\u0000\u0000"+
		"\u02bc\u02be\u0001\u0000\u0000\u0000\u02bd\u02bb\u0001\u0000\u0000\u0000"+
		"\u02be\u02c0\u0005R\u0000\u0000\u02bf\u028e\u0001\u0000\u0000\u0000\u02bf"+
		"\u02a2\u0001\u0000\u0000\u0000\u02bf\u02ad\u0001\u0000\u0000\u0000\u02bf"+
		"\u02b7\u0001\u0000\u0000\u0000\u02c0\'\u0001\u0000\u0000\u0000\u02c1\u02c2"+
		"\u0005c\u0000\u0000\u02c2\u02c3\u0005\u0006\u0000\u0000\u02c3)\u0001\u0000"+
		"\u0000\u0000\u02c4\u02c5\u0005e\u0000\u0000\u02c5\u02c6\u0005f\u0000\u0000"+
		"\u02c6+\u0001\u0000\u0000\u0000\u02c7\u02c8\u0003\u001e\u000f\u0000\u02c8"+
		"\u02c9\u0005\u0001\u0000\u0000\u02c9\u02ca\u0006\u0016\uffff\uffff\u0000"+
		"\u02ca\u02e1\u0001\u0000\u0000\u0000\u02cb\u02cc\u0005\u000e\u0000\u0000"+
		"\u02cc\u02cd\u0003.\u0017\u0000\u02cd\u02ce\u0006\u0016\uffff\uffff\u0000"+
		"\u02ce\u02e1\u0001\u0000\u0000\u0000\u02cf\u02d0\u00056\u0000\u0000\u02d0"+
		"\u02d4\u00030\u0018\u0000\u02d1\u02d2\u00058\u0000\u0000\u02d2\u02d4\u0003"+
		".\u0017\u0000\u02d3\u02cf\u0001\u0000\u0000\u0000\u02d3\u02d1\u0001\u0000"+
		"\u0000\u0000\u02d4\u02d5\u0001\u0000\u0000\u0000\u02d5\u02d6\u0006\u0016"+
		"\uffff\uffff\u0000\u02d6\u02e1\u0001\u0000\u0000\u0000\u02d7\u02d8\u0005"+
		"B\u0000\u0000\u02d8\u02e1\u0006\u0016\uffff\uffff\u0000\u02d9\u02da\u0005"+
		"\"\u0000\u0000\u02da\u02dc\u0005\u0001\u0000\u0000\u02db\u02dd\u0005\u0005"+
		"\u0000\u0000\u02dc\u02db\u0001\u0000\u0000\u0000\u02dc\u02dd\u0001\u0000"+
		"\u0000\u0000\u02dd\u02de\u0001\u0000\u0000\u0000\u02de\u02df\u0005\u0002"+
		"\u0000\u0000\u02df\u02e1\u0006\u0016\uffff\uffff\u0000\u02e0\u02c7\u0001"+
		"\u0000\u0000\u0000\u02e0\u02cb\u0001\u0000\u0000\u0000\u02e0\u02d3\u0001"+
		"\u0000\u0000\u0000\u02e0\u02d7\u0001\u0000\u0000\u0000\u02e0\u02d9\u0001"+
		"\u0000\u0000\u0000\u02e1-\u0001\u0000\u0000\u0000\u02e2\u02e6\u0005\u0001"+
		"\u0000\u0000\u02e3\u02e5\u0005\f\u0000\u0000\u02e4\u02e3\u0001\u0000\u0000"+
		"\u0000\u02e5\u02e8\u0001\u0000\u0000\u0000\u02e6\u02e4\u0001\u0000\u0000"+
		"\u0000\u02e6\u02e7\u0001\u0000\u0000\u0000\u02e7\u02e9\u0001\u0000\u0000"+
		"\u0000\u02e8\u02e6\u0001\u0000\u0000\u0000\u02e9\u02ea\u0005\u0002\u0000"+
		"\u0000\u02ea/\u0001\u0000\u0000\u0000\u02eb\u02ec\u0005\u0001\u0000\u0000"+
		"\u02ec\u02ed\u0005\u00a0\u0000\u0000\u02ed\u02ee\u0005\u00a2\u0000\u0000"+
		"\u02ee\u02f1\u0005\u00a0\u0000\u0000\u02ef\u02f0\u0005\u00a3\u0000\u0000"+
		"\u02f0\u02f2\u0005\u00a0\u0000\u0000\u02f1\u02ef\u0001\u0000\u0000\u0000"+
		"\u02f1\u02f2\u0001\u0000\u0000\u0000\u02f2\u02f3\u0001\u0000\u0000\u0000"+
		"\u02f3\u030d\u0005\u0002\u0000\u0000\u02f4\u02f8\u0005\u0001\u0000\u0000"+
		"\u02f5\u02f7\u0005\u00a0\u0000\u0000\u02f6\u02f5\u0001\u0000\u0000\u0000"+
		"\u02f7\u02fa\u0001\u0000\u0000\u0000\u02f8\u02f6\u0001\u0000\u0000\u0000"+
		"\u02f8\u02f9\u0001\u0000\u0000\u0000\u02f9\u02fb\u0001\u0000\u0000\u0000"+
		"\u02fa\u02f8\u0001\u0000\u0000\u0000\u02fb\u02ff\u0005\u00a2\u0000\u0000"+
		"\u02fc\u02fe\u0005\u00a0\u0000\u0000\u02fd\u02fc\u0001\u0000\u0000\u0000"+
		"\u02fe\u0301\u0001\u0000\u0000\u0000\u02ff\u02fd\u0001\u0000\u0000\u0000"+
		"\u02ff\u0300\u0001\u0000\u0000\u0000\u0300\u0309\u0001\u0000\u0000\u0000"+
		"\u0301\u02ff\u0001\u0000\u0000\u0000\u0302\u0306\u0005\u00a3\u0000\u0000"+
		"\u0303\u0305\u0005\u00a0\u0000\u0000\u0304\u0303\u0001\u0000\u0000\u0000"+
		"\u0305\u0308\u0001\u0000\u0000\u0000\u0306\u0304\u0001\u0000\u0000\u0000"+
		"\u0306\u0307\u0001\u0000\u0000\u0000\u0307\u030a\u0001\u0000\u0000\u0000"+
		"\u0308\u0306\u0001\u0000\u0000\u0000\u0309\u0302\u0001\u0000\u0000\u0000"+
		"\u0309\u030a\u0001\u0000\u0000\u0000\u030a\u030b\u0001\u0000\u0000\u0000"+
		"\u030b\u030d\u0005\u0002\u0000\u0000\u030c\u02eb\u0001\u0000\u0000\u0000"+
		"\u030c\u02f4\u0001\u0000\u0000\u0000\u030d1\u0001\u0000\u0000\u0000\u030e"+
		"\u030f\u0005l\u0000\u0000\u030f\u0310\u0007\u0007\u0000\u0000\u03103\u0001"+
		"\u0000\u0000\u0000\u0311\u0312\u0005m\u0000\u0000\u03125\u0001\u0000\u0000"+
		"\u0000w9KUWafoy\u0080\u0083\u008c\u0093\u0096\u009f\u00a9\u00b1\u00b6"+
		"\u00bd\u00c0\u00c9\u00d1\u00d6\u00dd\u00e0\u00e9\u00f1\u00f6\u00fd\u0100"+
		"\u010a\u0115\u0119\u011f\u0121\u0127\u0129\u012c\u0134\u0136\u013f\u0141"+
		"\u014a\u014c\u0153\u0160\u016a\u016e\u0172\u0179\u017c\u018b\u0190\u0197"+
		"\u019a\u01a0\u01a3\u01aa\u01ad\u01b3\u01b6\u01bc\u01c2\u01c5\u01cc\u01d2"+
		"\u01d5\u01d8\u01dd\u01e3\u01e5\u01ed\u01f1\u01f7\u01fb\u01ff\u0203\u0208"+
		"\u020c\u0211\u0215\u021b\u0221\u0228\u022e\u0235\u023b\u0242\u0249\u0250"+
		"\u0256\u025d\u0263\u0267\u026d\u0271\u0276\u027c\u0283\u0286\u028c\u0290"+
		"\u0295\u029c\u029f\u02a4\u02a9\u02b2\u02bb\u02bf\u02d3\u02dc\u02e0\u02e6"+
		"\u02f1\u02f8\u02ff\u0306\u0309\u030c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}