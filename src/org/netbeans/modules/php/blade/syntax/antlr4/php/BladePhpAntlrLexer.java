// Generated from BladePhpAntlrLexer.g4 by ANTLR 4.13.0

  package org.netbeans.modules.php.blade.syntax.antlr4.php;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BladePhpAntlrLexer extends LexerAdaptor {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HTML=1, BLADE_COMMENT=2, LINE_COMMENT=3, ARRAY=4, AS=5, ECHO=6, NEW=7, 
		CLASS=8, FUNCTION=9, LANG_CONSTRUCT=10, COMMA=11, LPAREN=12, RPAREN=13, 
		LSQUAREBRACKET=14, RSQUAREBRACKET=15, LCURLYBRACE=16, RCURLYBRACE=17, 
		IDENTIFIER=18, PHP_VARIABLE=19, NAMESPACE_SEPARATOR=20, DOUBLE_COLON=21, 
		OBJECT_OPERATOR=22, STRING_LITERAL=23, STYLE_COMMENT=24, WS=25, OTHER=26, 
		BLADE_COMMENT_START=27, EMAIL_SUBSTRING=28, VERSION_WITH_AT=29, BLADE_COMMENT_END=30, 
		BLADE_COMMENT_PEEK=31, BLADE_COMMENT_MORE=32, BLADE_COMMENT_EOF=33;
	public static final int
		INSIDE_BLADE_COMMENT=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "INSIDE_BLADE_COMMENT"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LINE_COMMENT", "ARRAY", "AS", "ECHO", "NEW", "CLASS", "FUNCTION", "LANG_CONSTRUCT", 
			"COMMA", "LPAREN", "RPAREN", "LSQUAREBRACKET", "RSQUAREBRACKET", "LCURLYBRACE", 
			"RCURLYBRACE", "IDENTIFIER", "PHP_VARIABLE", "NAMESPACE_SEPARATOR", "DOUBLE_COLON", 
			"OBJECT_OPERATOR", "STRING_LITERAL", "STYLE_COMMENT", "WS", "OTHER", 
			"Identifier", "HtmlIdentifier", "ESC_DOUBLE_QUOTED_STRING", "DOUBLE_QUOTED_STRING_FRAGMENT", 
			"SINGLE_QUOTED_STRING_FRAGMENT", "StringLiteral", "LineComment", "PhpVariable", 
			"Digit", "BLADE_COMMENT_START", "EMAIL_SUBSTRING", "VERSION_WITH_AT", 
			"D_ESCAPES", "BLADE_COMMENT_END", "BLADE_COMMENT_PEEK", "BLADE_COMMENT_MORE", 
			"BLADE_COMMENT_EOF"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'array'", "'as'", "'echo'", "'new'", "'class'", 
			"'function'", "'empty'", "','", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			null, null, "'\\'", "'::'", "'->'", null, null, null, null, "'{{--'", 
			null, null, "'--}}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HTML", "BLADE_COMMENT", "LINE_COMMENT", "ARRAY", "AS", "ECHO", 
			"NEW", "CLASS", "FUNCTION", "LANG_CONSTRUCT", "COMMA", "LPAREN", "RPAREN", 
			"LSQUAREBRACKET", "RSQUAREBRACKET", "LCURLYBRACE", "RCURLYBRACE", "IDENTIFIER", 
			"PHP_VARIABLE", "NAMESPACE_SEPARATOR", "DOUBLE_COLON", "OBJECT_OPERATOR", 
			"STRING_LITERAL", "STYLE_COMMENT", "WS", "OTHER", "BLADE_COMMENT_START", 
			"EMAIL_SUBSTRING", "VERSION_WITH_AT", "BLADE_COMMENT_END", "BLADE_COMMENT_PEEK", 
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


	    int rparenBalance = 0;
	    int sqparenBalance = 0;
	    int curlyparenBalance = 0;


	public BladePhpAntlrLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BladePhpAntlrLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 38:
			return BLADE_COMMENT_PEEK_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean BLADE_COMMENT_PEEK_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return 
		        this._input.LA(1) == '-' &&
		        this._input.LA(2) == '-' &&
		        this._input.LA(3) == '}' &&
		        this._input.LA(4) == '}'
		      ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0000!\u0262\u0006\uffff\uffff\u0006\uffff\uffff\u0002\u0000\u0007"+
		"\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007"+
		"\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007"+
		"\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n"+
		"\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002"+
		"\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002"+
		"\u0011\u0007\u0011\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002"+
		"\u0014\u0007\u0014\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002"+
		"\u0017\u0007\u0017\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002"+
		"\u001a\u0007\u001a\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002"+
		"\u001d\u0007\u001d\u0002\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002"+
		" \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002"+
		"%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002(\u0007(\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0005\u0015\u00a2\b\u0015\n\u0015\f\u0015\u00a5\t\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00ab\b\u0015\n\u0015\f\u0015"+
		"\u00ae\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0004\u0016\u00b3\b"+
		"\u0016\u000b\u0016\f\u0016\u00b4\u0001\u0016\u0004\u0016\u00b8\b\u0016"+
		"\u000b\u0016\f\u0016\u00b9\u0003\u0016\u00bc\b\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0005\u0018\u00c6\b\u0018\n\u0018\f\u0018\u00c9\t\u0018\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u00cd\b\u0019\n\u0019\f\u0019\u00d0\t\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u00d7"+
		"\b\u001b\n\u001b\f\u001b\u00da\t\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u00e2\b\u001c\n\u001c"+
		"\f\u001c\u00e5\t\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0003\u001d\u00eb\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0005\u001e\u00f1\b\u001e\n\u001e\f\u001e\u00f4\t\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"#\u0001#\u0001#\u0003#\u010c\b#\u0004#\u010e\b#\u000b#\f#\u010f\u0001"+
		"#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u011b"+
		"\b$\u0001$\u0001$\u0001$\u0001$\u0003$\u0121\b$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0004$\u012b\b$\u000b$\f$\u012c\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0004$\u0137\b$\u000b$\f$"+
		"\u0138\u0001$\u0001$\u0001$\u0003$\u013e\b$\u0003$\u0140\b$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0003$\u0241\b$\u0001$\u0005$\u0244\b$\n$\f$\u0247"+
		"\t$\u0003$\u0249\b$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0002\u00a3\u00d8\u0000"+
		")\u0002\u0003\u0004\u0004\u0006\u0005\b\u0006\n\u0007\f\b\u000e\t\u0010"+
		"\n\u0012\u000b\u0014\f\u0016\r\u0018\u000e\u001a\u000f\u001c\u0010\u001e"+
		"\u0011 \u0012\"\u0013$\u0014&\u0015(\u0016*\u0017,\u0018.\u00190\u001a"+
		"2\u00004\u00006\u00008\u0000:\u0000<\u0000>\u0000@\u0000B\u0000D\u001b"+
		"F\u001cH\u001dJ\u0000L\u001eN\u001fP R!\u0002\u0000\u0001\u001d\u0002"+
		"\u0000AAaa\u0002\u0000RRrr\u0002\u0000YYyy\u0002\u0000SSss\u0002\u0000"+
		"EEee\u0002\u0000CCcc\u0002\u0000HHhh\u0002\u0000OOoo\u0002\u0000NNnn\u0002"+
		"\u0000WWww\u0002\u0000LLll\u0002\u0000FFff\u0002\u0000UUuu\u0002\u0000"+
		"TTtt\u0002\u0000IIii\u0002\u0000MMmm\u0002\u0000PPpp\u0002\u0000\n\n\r"+
		"\r\u0004\u0000AZ__az\u0080\u8000\ufffe\u0005\u000009AZ__az\u0080\u8000"+
		"\ufffe\u0006\u0000--09AZ__az\u0080\u8000\ufffe\u0002\u0000\"\"\\\\\u0002"+
		"\u0000\'\'\\\\\u0002\u0000DDdd\u0001\u0000  \u0002\u0000GGgg\u0002\u0000"+
		"BBbb\u0002\u0000KKkk\u0002\u0000VVvv\u0288\u0000\u0002\u0001\u0000\u0000"+
		"\u0000\u0000\u0004\u0001\u0000\u0000\u0000\u0000\u0006\u0001\u0000\u0000"+
		"\u0000\u0000\b\u0001\u0000\u0000\u0000\u0000\n\u0001\u0000\u0000\u0000"+
		"\u0000\f\u0001\u0000\u0000\u0000\u0000\u000e\u0001\u0000\u0000\u0000\u0000"+
		"\u0010\u0001\u0000\u0000\u0000\u0000\u0012\u0001\u0000\u0000\u0000\u0000"+
		"\u0014\u0001\u0000\u0000\u0000\u0000\u0016\u0001\u0000\u0000\u0000\u0000"+
		"\u0018\u0001\u0000\u0000\u0000\u0000\u001a\u0001\u0000\u0000\u0000\u0000"+
		"\u001c\u0001\u0000\u0000\u0000\u0000\u001e\u0001\u0000\u0000\u0000\u0000"+
		" \u0001\u0000\u0000\u0000\u0000\"\u0001\u0000\u0000\u0000\u0000$\u0001"+
		"\u0000\u0000\u0000\u0000&\u0001\u0000\u0000\u0000\u0000(\u0001\u0000\u0000"+
		"\u0000\u0000*\u0001\u0000\u0000\u0000\u0000,\u0001\u0000\u0000\u0000\u0000"+
		".\u0001\u0000\u0000\u0000\u00000\u0001\u0000\u0000\u0000\u0000D\u0001"+
		"\u0000\u0000\u0000\u0000F\u0001\u0000\u0000\u0000\u0000H\u0001\u0000\u0000"+
		"\u0000\u0000J\u0001\u0000\u0000\u0000\u0001L\u0001\u0000\u0000\u0000\u0001"+
		"N\u0001\u0000\u0000\u0000\u0001P\u0001\u0000\u0000\u0000\u0001R\u0001"+
		"\u0000\u0000\u0000\u0002T\u0001\u0000\u0000\u0000\u0004X\u0001\u0000\u0000"+
		"\u0000\u0006^\u0001\u0000\u0000\u0000\ba\u0001\u0000\u0000\u0000\nf\u0001"+
		"\u0000\u0000\u0000\fj\u0001\u0000\u0000\u0000\u000ep\u0001\u0000\u0000"+
		"\u0000\u0010y\u0001\u0000\u0000\u0000\u0012\u007f\u0001\u0000\u0000\u0000"+
		"\u0014\u0081\u0001\u0000\u0000\u0000\u0016\u0083\u0001\u0000\u0000\u0000"+
		"\u0018\u0085\u0001\u0000\u0000\u0000\u001a\u0087\u0001\u0000\u0000\u0000"+
		"\u001c\u0089\u0001\u0000\u0000\u0000\u001e\u008b\u0001\u0000\u0000\u0000"+
		" \u008d\u0001\u0000\u0000\u0000\"\u008f\u0001\u0000\u0000\u0000$\u0091"+
		"\u0001\u0000\u0000\u0000&\u0093\u0001\u0000\u0000\u0000(\u0096\u0001\u0000"+
		"\u0000\u0000*\u0099\u0001\u0000\u0000\u0000,\u009d\u0001\u0000\u0000\u0000"+
		".\u00bb\u0001\u0000\u0000\u00000\u00bf\u0001\u0000\u0000\u00002\u00c3"+
		"\u0001\u0000\u0000\u00004\u00ca\u0001\u0000\u0000\u00006\u00d1\u0001\u0000"+
		"\u0000\u00008\u00d3\u0001\u0000\u0000\u0000:\u00dd\u0001\u0000\u0000\u0000"+
		"<\u00ea\u0001\u0000\u0000\u0000>\u00ec\u0001\u0000\u0000\u0000@\u00f5"+
		"\u0001\u0000\u0000\u0000B\u00f8\u0001\u0000\u0000\u0000D\u00fa\u0001\u0000"+
		"\u0000\u0000F\u0102\u0001\u0000\u0000\u0000H\u0108\u0001\u0000\u0000\u0000"+
		"J\u0248\u0001\u0000\u0000\u0000L\u024c\u0001\u0000\u0000\u0000N\u0254"+
		"\u0001\u0000\u0000\u0000P\u0259\u0001\u0000\u0000\u0000R\u025d\u0001\u0000"+
		"\u0000\u0000TU\u0003>\u001e\u0000UV\u0001\u0000\u0000\u0000VW\u0006\u0000"+
		"\u0000\u0000W\u0003\u0001\u0000\u0000\u0000XY\u0007\u0000\u0000\u0000"+
		"YZ\u0007\u0001\u0000\u0000Z[\u0007\u0001\u0000\u0000[\\\u0007\u0000\u0000"+
		"\u0000\\]\u0007\u0002\u0000\u0000]\u0005\u0001\u0000\u0000\u0000^_\u0007"+
		"\u0000\u0000\u0000_`\u0007\u0003\u0000\u0000`\u0007\u0001\u0000\u0000"+
		"\u0000ab\u0007\u0004\u0000\u0000bc\u0007\u0005\u0000\u0000cd\u0007\u0006"+
		"\u0000\u0000de\u0007\u0007\u0000\u0000e\t\u0001\u0000\u0000\u0000fg\u0007"+
		"\b\u0000\u0000gh\u0007\u0004\u0000\u0000hi\u0007\t\u0000\u0000i\u000b"+
		"\u0001\u0000\u0000\u0000jk\u0007\u0005\u0000\u0000kl\u0007\n\u0000\u0000"+
		"lm\u0007\u0000\u0000\u0000mn\u0007\u0003\u0000\u0000no\u0007\u0003\u0000"+
		"\u0000o\r\u0001\u0000\u0000\u0000pq\u0007\u000b\u0000\u0000qr\u0007\f"+
		"\u0000\u0000rs\u0007\b\u0000\u0000st\u0007\u0005\u0000\u0000tu\u0007\r"+
		"\u0000\u0000uv\u0007\u000e\u0000\u0000vw\u0007\u0007\u0000\u0000wx\u0007"+
		"\b\u0000\u0000x\u000f\u0001\u0000\u0000\u0000yz\u0007\u0004\u0000\u0000"+
		"z{\u0007\u000f\u0000\u0000{|\u0007\u0010\u0000\u0000|}\u0007\r\u0000\u0000"+
		"}~\u0007\u0002\u0000\u0000~\u0011\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0005,\u0000\u0000\u0080\u0013\u0001\u0000\u0000\u0000\u0081\u0082\u0005"+
		"(\u0000\u0000\u0082\u0015\u0001\u0000\u0000\u0000\u0083\u0084\u0005)\u0000"+
		"\u0000\u0084\u0017\u0001\u0000\u0000\u0000\u0085\u0086\u0005[\u0000\u0000"+
		"\u0086\u0019\u0001\u0000\u0000\u0000\u0087\u0088\u0005]\u0000\u0000\u0088"+
		"\u001b\u0001\u0000\u0000\u0000\u0089\u008a\u0005{\u0000\u0000\u008a\u001d"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0005}\u0000\u0000\u008c\u001f\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u00032\u0018\u0000\u008e!\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0003@\u001f\u0000\u0090#\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0005\\\u0000\u0000\u0092%\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0005:\u0000\u0000\u0094\u0095\u0005:\u0000\u0000\u0095\'\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0005-\u0000\u0000\u0097\u0098\u0005>\u0000\u0000"+
		"\u0098)\u0001\u0000\u0000\u0000\u0099\u009a\u0003<\u001d\u0000\u009a\u009b"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0006\u0014\u0000\u0000\u009c+\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0005/\u0000\u0000\u009e\u009f\u0005*\u0000"+
		"\u0000\u009f\u00a3\u0001\u0000\u0000\u0000\u00a0\u00a2\t\u0000\u0000\u0000"+
		"\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a6\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0005*\u0000\u0000\u00a7\u00a8\u0005/\u0000\u0000\u00a8\u00ac"+
		"\u0001\u0000\u0000\u0000\u00a9\u00ab\u0007\u0011\u0000\u0000\u00aa\u00a9"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac\u00aa"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00af"+
		"\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af\u00b0"+
		"\u0006\u0015\u0000\u0000\u00b0-\u0001\u0000\u0000\u0000\u00b1\u00b3\u0005"+
		" \u0000\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\u00bc\u0001\u0000\u0000\u0000\u00b6\u00b8\u0007\u0011"+
		"\u0000\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bc\u0001\u0000\u0000\u0000\u00bb\u00b2\u0001\u0000"+
		"\u0000\u0000\u00bb\u00b7\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0006\u0016\u0000\u0000\u00be/\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\t\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0006\u0017\u0000\u0000\u00c21\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c7\u0007\u0012\u0000\u0000\u00c4\u00c6\u0007\u0013\u0000\u0000\u00c5"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c9\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8"+
		"3\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00ca\u00ce"+
		"\u0007\u0012\u0000\u0000\u00cb\u00cd\u0007\u0014\u0000\u0000\u00cc\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce\u00cc"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf5\u0001"+
		"\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d2\u0007"+
		"\u0015\u0000\u0000\u00d27\u0001\u0000\u0000\u0000\u00d3\u00d8\u0005\""+
		"\u0000\u0000\u00d4\u00d7\u00036\u001a\u0000\u00d5\u00d7\t\u0000\u0000"+
		"\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00db\u0001\u0000\u0000"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\"\u0000\u0000"+
		"\u00dc9\u0001\u0000\u0000\u0000\u00dd\u00e3\u0005\'\u0000\u0000\u00de"+
		"\u00e2\b\u0016\u0000\u0000\u00df\u00e0\u0005\\\u0000\u0000\u00e0\u00e2"+
		"\t\u0000\u0000\u0000\u00e1\u00de\u0001\u0000\u0000\u0000\u00e1\u00df\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e6\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005"+
		"\'\u0000\u0000\u00e7;\u0001\u0000\u0000\u0000\u00e8\u00eb\u00038\u001b"+
		"\u0000\u00e9\u00eb\u0003:\u001c\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000"+
		"\u00ea\u00e9\u0001\u0000\u0000\u0000\u00eb=\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\u0005/\u0000\u0000\u00ed\u00ee\u0005/\u0000\u0000\u00ee\u00f2\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f1\b\u0011\u0000\u0000\u00f0\u00ef\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3?\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005$\u0000\u0000"+
		"\u00f6\u00f7\u00032\u0018\u0000\u00f7A\u0001\u0000\u0000\u0000\u00f8\u00f9"+
		"\u000209\u0000\u00f9C\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005{\u0000"+
		"\u0000\u00fb\u00fc\u0005{\u0000\u0000\u00fc\u00fd\u0005-\u0000\u0000\u00fd"+
		"\u00fe\u0005-\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0100"+
		"\u0006!\u0001\u0000\u0100\u0101\u0006!\u0000\u0000\u0101E\u0001\u0000"+
		"\u0000\u0000\u0102\u0103\u0005@\u0000\u0000\u0103\u0104\u00032\u0018\u0000"+
		"\u0104\u0105\u0005.\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106"+
		"\u0107\u0006\"\u0000\u0000\u0107G\u0001\u0000\u0000\u0000\u0108\u010d"+
		"\u0005@\u0000\u0000\u0109\u010b\u0003B \u0000\u010a\u010c\u0005.\u0000"+
		"\u0000\u010b\u010a\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000"+
		"\u0000\u010c\u010e\u0001\u0000\u0000\u0000\u010d\u0109\u0001\u0000\u0000"+
		"\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000"+
		"\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000"+
		"\u0000\u0111\u0112\u0006#\u0000\u0000\u0112I\u0001\u0000\u0000\u0000\u0113"+
		"\u0114\u0005{\u0000\u0000\u0114\u0115\u0005{\u0000\u0000\u0115\u0249\u0005"+
		"{\u0000\u0000\u0116\u0117\u0005@\u0000\u0000\u0117\u0118\u0005@\u0000"+
		"\u0000\u0118\u011a\u0001\u0000\u0000\u0000\u0119\u011b\u0005@\u0000\u0000"+
		"\u011a\u0119\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000"+
		"\u011b\u0249\u0001\u0000\u0000\u0000\u011c\u011d\u0005@\u0000\u0000\u011d"+
		"\u011e\u0005{\u0000\u0000\u011e\u0120\u0001\u0000\u0000\u0000\u011f\u0121"+
		"\u0005{\u0000\u0000\u0120\u011f\u0001\u0000\u0000\u0000\u0120\u0121\u0001"+
		"\u0000\u0000\u0000\u0121\u0249\u0001\u0000\u0000\u0000\u0122\u0123\u0005"+
		"@\u0000\u0000\u0123\u0124\u0007\u000f\u0000\u0000\u0124\u0125\u0007\u0004"+
		"\u0000\u0000\u0125\u0126\u0007\u0017\u0000\u0000\u0126\u0127\u0007\u000e"+
		"\u0000\u0000\u0127\u0128\u0007\u0000\u0000\u0000\u0128\u012a\u0001\u0000"+
		"\u0000\u0000\u0129\u012b\u0007\u0018\u0000\u0000\u012a\u0129\u0001\u0000"+
		"\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012a\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u013f\u0001\u0000"+
		"\u0000\u0000\u012e\u012f\u0007\u0003\u0000\u0000\u012f\u0130\u0007\u0005"+
		"\u0000\u0000\u0130\u0131\u0007\u0001\u0000\u0000\u0131\u0132\u0007\u0004"+
		"\u0000\u0000\u0132\u0133\u0007\u0004\u0000\u0000\u0133\u0134\u0007\b\u0000"+
		"\u0000\u0134\u0136\u0001\u0000\u0000\u0000\u0135\u0137\u0007\u0018\u0000"+
		"\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000"+
		"\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000"+
		"\u0000\u0139\u013d\u0001\u0000\u0000\u0000\u013a\u013b\u0007\u0000\u0000"+
		"\u0000\u013b\u013c\u0007\b\u0000\u0000\u013c\u013e\u0007\u0017\u0000\u0000"+
		"\u013d\u013a\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000"+
		"\u013e\u0140\u0001\u0000\u0000\u0000\u013f\u012e\u0001\u0000\u0000\u0000"+
		"\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u0249\u0001\u0000\u0000\u0000"+
		"\u0141\u0142\u0005@\u0000\u0000\u0142\u0143\u0007\u0005\u0000\u0000\u0143"+
		"\u0144\u0007\u0006\u0000\u0000\u0144\u0145\u0007\u0000\u0000\u0000\u0145"+
		"\u0146\u0007\u0001\u0000\u0000\u0146\u0147\u0007\u0003\u0000\u0000\u0147"+
		"\u0148\u0007\u0004\u0000\u0000\u0148\u0241\u0007\r\u0000\u0000\u0149\u014a"+
		"\u0005@\u0000\u0000\u014a\u014b\u0007\u000e\u0000\u0000\u014b\u014c\u0007"+
		"\u000f\u0000\u0000\u014c\u014d\u0007\u0010\u0000\u0000\u014d\u014e\u0007"+
		"\u0007\u0000\u0000\u014e\u014f\u0007\u0001\u0000\u0000\u014f\u0241\u0007"+
		"\r\u0000\u0000\u0150\u0151\u0005@\u0000\u0000\u0151\u0152\u0007\b\u0000"+
		"\u0000\u0152\u0153\u0007\u0000\u0000\u0000\u0153\u0154\u0007\u000f\u0000"+
		"\u0000\u0154\u0155\u0007\u0004\u0000\u0000\u0155\u0156\u0007\u0003\u0000"+
		"\u0000\u0156\u0157\u0007\u0010\u0000\u0000\u0157\u0158\u0007\u0000\u0000"+
		"\u0000\u0158\u0159\u0007\u0005\u0000\u0000\u0159\u0241\u0007\u0004\u0000"+
		"\u0000\u015a\u015b\u0005@\u0000\u0000\u015b\u015c\u0007\u0017\u0000\u0000"+
		"\u015c\u015d\u0007\u0007\u0000\u0000\u015d\u015e\u0007\u0005\u0000\u0000"+
		"\u015e\u015f\u0007\f\u0000\u0000\u015f\u0160\u0007\u000f\u0000\u0000\u0160"+
		"\u0161\u0007\u0004\u0000\u0000\u0161\u0162\u0007\b\u0000\u0000\u0162\u0241"+
		"\u0007\r\u0000\u0000\u0163\u0164\u0005@\u0000\u0000\u0164\u0165\u0007"+
		"\u000b\u0000\u0000\u0165\u0166\u0007\u0007\u0000\u0000\u0166\u0167\u0007"+
		"\b\u0000\u0000\u0167\u0168\u0007\r\u0000\u0000\u0168\u0169\u0005-\u0000"+
		"\u0000\u0169\u016a\u0007\u000b\u0000\u0000\u016a\u016b\u0007\u0000\u0000"+
		"\u0000\u016b\u016c\u0007\u0005\u0000\u0000\u016c\u0241\u0007\u0004\u0000"+
		"\u0000\u016d\u016e\u0005@\u0000\u0000\u016e\u016f\u0007\u0010\u0000\u0000"+
		"\u016f\u0170\u0007\u0000\u0000\u0000\u0170\u0171\u0007\u0019\u0000\u0000"+
		"\u0171\u0241\u0007\u0004\u0000\u0000\u0172\u0173\u0005@\u0000\u0000\u0173"+
		"\u0174\u0007\n\u0000\u0000\u0174\u0175\u0007\u0000\u0000\u0000\u0175\u0176"+
		"\u0007\u0002\u0000\u0000\u0176\u0177\u0007\u0004\u0000\u0000\u0177\u0241"+
		"\u0007\u0001\u0000\u0000\u0178\u0179\u0005@\u0000\u0000\u0179\u017a\u0007"+
		"\u0003\u0000\u0000\u017a\u017b\u0007\f\u0000\u0000\u017b\u017c\u0007\u0010"+
		"\u0000\u0000\u017c\u017d\u0007\u0010\u0000\u0000\u017d\u017e\u0007\u0007"+
		"\u0000\u0000\u017e\u017f\u0007\u0001\u0000\u0000\u017f\u0180\u0007\r\u0000"+
		"\u0000\u0180\u0241\u0007\u0003\u0000\u0000\u0181\u0182\u0005@\u0000\u0000"+
		"\u0182\u0183\u0007\r\u0000\u0000\u0183\u0184\u0007\u0000\u0000\u0000\u0184"+
		"\u0185\u0007\u000e\u0000\u0000\u0185\u0186\u0007\n\u0000\u0000\u0186\u0187"+
		"\u0007\t\u0000\u0000\u0187\u0188\u0007\u000e\u0000\u0000\u0188\u0189\u0007"+
		"\b\u0000\u0000\u0189\u0241\u0007\u0017\u0000\u0000\u018a\u018b\u0005@"+
		"\u0000\u0000\u018b\u018c\u0007\u0000\u0000\u0000\u018c\u018d\u0007\u0010"+
		"\u0000\u0000\u018d\u018e\u0007\u0010\u0000\u0000\u018e\u018f\u0007\n\u0000"+
		"\u0000\u018f\u0241\u0007\u0002\u0000\u0000\u0190\u0191\u0005@\u0000\u0000"+
		"\u0191\u0192\u0005-\u0000\u0000\u0192\u0193\u0007\t\u0000\u0000\u0193"+
		"\u0194\u0007\u0004\u0000\u0000\u0194\u0195\u0007\u001a\u0000\u0000\u0195"+
		"\u0196\u0007\u001b\u0000\u0000\u0196\u0197\u0007\u000e\u0000\u0000\u0197"+
		"\u0198\u0007\r\u0000\u0000\u0198\u0199\u0005-\u0000\u0000\u0199\u019a"+
		"\u0007\u001b\u0000\u0000\u019a\u019b\u0007\u0004\u0000\u0000\u019b\u019c"+
		"\u0007\u0002\u0000\u0000\u019c\u019d\u0007\u000b\u0000\u0000\u019d\u019e"+
		"\u0007\u0001\u0000\u0000\u019e\u019f\u0007\u0000\u0000\u0000\u019f\u01a0"+
		"\u0007\u000f\u0000\u0000\u01a0\u01a1\u0007\u0004\u0000\u0000\u01a1\u0241"+
		"\u0007\u0003\u0000\u0000\u01a2\u01a3\u0005@\u0000\u0000\u01a3\u01a4\u0007"+
		"\u001b\u0000\u0000\u01a4\u01a5\u0007\u0004\u0000\u0000\u01a5\u01a6\u0007"+
		"\u0002\u0000\u0000\u01a6\u01a7\u0007\u000b\u0000\u0000\u01a7\u01a8\u0007"+
		"\u0001\u0000\u0000\u01a8\u01a9\u0007\u0000\u0000\u0000\u01a9\u01aa\u0007"+
		"\u000f\u0000\u0000\u01aa\u01ab\u0007\u0004\u0000\u0000\u01ab\u0241\u0007"+
		"\u0003\u0000\u0000\u01ac\u01ad\u0005@\u0000\u0000\u01ad\u01ae\u0007\u0005"+
		"\u0000\u0000\u01ae\u01af\u0007\u0007\u0000\u0000\u01af\u01b0\u0007\f\u0000"+
		"\u0000\u01b0\u01b1\u0007\b\u0000\u0000\u01b1\u01b2\u0007\r\u0000\u0000"+
		"\u01b2\u01b3\u0007\u0004\u0000\u0000\u01b3\u01b4\u0007\u0001\u0000\u0000"+
		"\u01b4\u01b5\u0005-\u0000\u0000\u01b5\u01b6\u0007\u0003\u0000\u0000\u01b6"+
		"\u01b7\u0007\r\u0000\u0000\u01b7\u01b8\u0007\u0002\u0000\u0000\u01b8\u01b9"+
		"\u0007\n\u0000\u0000\u01b9\u0241\u0007\u0004\u0000\u0000\u01ba\u01bb\u0005"+
		"@\u0000\u0000\u01bb\u01bc\u0007\u000b\u0000\u0000\u01bc\u01bd\u0007\u0007"+
		"\u0000\u0000\u01bd\u01be\u0007\b\u0000\u0000\u01be\u01bf\u0007\r\u0000"+
		"\u0000\u01bf\u01c0\u0005-\u0000\u0000\u01c0\u01c1\u0007\u000b\u0000\u0000"+
		"\u01c1\u01c2\u0007\u0004\u0000\u0000\u01c2\u01c3\u0007\u0000\u0000\u0000"+
		"\u01c3\u01c4\u0007\r\u0000\u0000\u01c4\u01c5\u0007\f\u0000\u0000\u01c5"+
		"\u01c6\u0007\u0001\u0000\u0000\u01c6\u01c7\u0007\u0004\u0000\u0000\u01c7"+
		"\u01c8\u0005-\u0000\u0000\u01c8\u01c9\u0007\u001c\u0000\u0000\u01c9\u01ca"+
		"\u0007\u0000\u0000\u0000\u01ca\u01cb\u0007\n\u0000\u0000\u01cb\u01cc\u0007"+
		"\f\u0000\u0000\u01cc\u01cd\u0007\u0004\u0000\u0000\u01cd\u0241\u0007\u0003"+
		"\u0000\u0000\u01ce\u01cf\u0005@\u0000\u0000\u01cf\u01d0\u0007\u0010\u0000"+
		"\u0000\u01d0\u01d1\u0007\u0001\u0000\u0000\u01d1\u01d2\u0007\u0007\u0000"+
		"\u0000\u01d2\u01d3\u0007\u0010\u0000\u0000\u01d3\u01d4\u0007\u0004\u0000"+
		"\u0000\u01d4\u01d5\u0007\u0001\u0000\u0000\u01d5\u01d6\u0007\r\u0000\u0000"+
		"\u01d6\u0241\u0007\u0002\u0000\u0000\u01d7\u01d8\u0005@\u0000\u0000\u01d8"+
		"\u01d9\u0007\u0003\u0000\u0000\u01d9\u01da\u0007\u0005\u0000\u0000\u01da"+
		"\u01db\u0007\u0007\u0000\u0000\u01db\u01dc\u0007\u0010\u0000\u0000\u01dc"+
		"\u0241\u0007\u0004\u0000\u0000\u01dd\u01de\u0005@\u0000\u0000\u01de\u01df"+
		"\u0007\u0003\u0000\u0000\u01df\u01e0\u0007\r\u0000\u0000\u01e0\u01e1\u0007"+
		"\u0000\u0000\u0000\u01e1\u01e2\u0007\u0001\u0000\u0000\u01e2\u01e3\u0007"+
		"\r\u0000\u0000\u01e3\u01e4\u0007\u000e\u0000\u0000\u01e4\u01e5\u0007\b"+
		"\u0000\u0000\u01e5\u01e6\u0007\u0019\u0000\u0000\u01e6\u01e7\u0005-\u0000"+
		"\u0000\u01e7\u01e8\u0007\u0003\u0000\u0000\u01e8\u01e9\u0007\r\u0000\u0000"+
		"\u01e9\u01ea\u0007\u0002\u0000\u0000\u01ea\u01eb\u0007\n\u0000\u0000\u01eb"+
		"\u0241\u0007\u0004\u0000\u0000\u01ec\u01ed\u0005@\u0000\u0000\u01ed\u01ee"+
		"\u0007\u0003\u0000\u0000\u01ee\u01ef\u0007\f\u0000\u0000\u01ef\u01f0\u0007"+
		"\u0010\u0000\u0000\u01f0\u01f1\u0007\u0010\u0000\u0000\u01f1\u01f2\u0007"+
		"\u0007\u0000\u0000\u01f2\u01f3\u0007\u0001\u0000\u0000\u01f3\u01f4\u0007"+
		"\r\u0000\u0000\u01f4\u0241\u0007\u0003\u0000\u0000\u01f5\u01f6\u0005@"+
		"\u0000\u0000\u01f6\u01f7\u0007\u001c\u0000\u0000\u01f7\u01f8\u0007\u000e"+
		"\u0000\u0000\u01f8\u01f9\u0007\u0004\u0000\u0000\u01f9\u01fa\u0007\t\u0000"+
		"\u0000\u01fa\u01fb\u0005-\u0000\u0000\u01fb\u01fc\u0007\r\u0000\u0000"+
		"\u01fc\u01fd\u0007\u0001\u0000\u0000\u01fd\u01fe\u0007\u0000\u0000\u0000"+
		"\u01fe\u01ff\u0007\b\u0000\u0000\u01ff\u0200\u0007\u0003\u0000\u0000\u0200"+
		"\u0201\u0007\u000e\u0000\u0000\u0201\u0202\u0007\r\u0000\u0000\u0202\u0203"+
		"\u0007\u000e\u0000\u0000\u0203\u0204\u0007\u0007\u0000\u0000\u0204\u0241"+
		"\u0007\b\u0000\u0000\u0205\u0206\u0005@\u0000\u0000\u0206\u0207\u0007"+
		"\u0005\u0000\u0000\u0207\u0208\u0007\u0007\u0000\u0000\u0208\u0209\u0007"+
		"\b\u0000\u0000\u0209\u020a\u0007\r\u0000\u0000\u020a\u020b\u0007\u0000"+
		"\u0000\u0000\u020b\u020c\u0007\u000e\u0000\u0000\u020c\u020d\u0007\b\u0000"+
		"\u0000\u020d\u020e\u0007\u0004\u0000\u0000\u020e\u0241\u0007\u0001\u0000"+
		"\u0000\u020f\u0210\u0005@\u0000\u0000\u0210\u0211\u0007\u0005\u0000\u0000"+
		"\u0211\u0212\u0007\u0007\u0000\u0000\u0212\u0213\u0007\n\u0000\u0000\u0213"+
		"\u0214\u0007\u0007\u0000\u0000\u0214\u0215\u0007\u0001\u0000\u0000\u0215"+
		"\u0216\u0005-\u0000\u0000\u0216\u0217\u0007\u0010\u0000\u0000\u0217\u0218"+
		"\u0007\u0001\u0000\u0000\u0218\u0219\u0007\u0007\u0000\u0000\u0219\u021a"+
		"\u0007\u000b\u0000\u0000\u021a\u021b\u0007\u000e\u0000\u0000\u021b\u021c"+
		"\u0007\n\u0000\u0000\u021c\u0241\u0007\u0004\u0000\u0000\u021d\u021e\u0005"+
		"@\u0000\u0000\u021e\u021f\u0007\u0003\u0000\u0000\u021f\u0220\u0007\r"+
		"\u0000\u0000\u0220\u0221\u0007\u0002\u0000\u0000\u0221\u0222\u0007\n\u0000"+
		"\u0000\u0222\u0223\u0007\u0004\u0000\u0000\u0223\u0224\u0007\u0003\u0000"+
		"\u0000\u0224\u0225\u0007\u0004\u0000\u0000\u0225\u0241\u0007\r\u0000\u0000"+
		"\u0226\u0227\u0005@\u0000\u0000\u0227\u0228\u0007\u000b\u0000\u0000\u0228"+
		"\u0229\u0007\u0007\u0000\u0000\u0229\u022a\u0007\b\u0000\u0000\u022a\u022b"+
		"\u0007\r\u0000\u0000\u022b\u022c\u0005-\u0000\u0000\u022c\u022d\u0007"+
		"\u0010\u0000\u0000\u022d\u022e\u0007\u0000\u0000\u0000\u022e\u022f\u0007"+
		"\n\u0000\u0000\u022f\u0230\u0007\u0004\u0000\u0000\u0230\u0231\u0007\r"+
		"\u0000\u0000\u0231\u0232\u0007\r\u0000\u0000\u0232\u0233\u0007\u0004\u0000"+
		"\u0000\u0233\u0234\u0005-\u0000\u0000\u0234\u0235\u0007\u001c\u0000\u0000"+
		"\u0235\u0236\u0007\u0000\u0000\u0000\u0236\u0237\u0007\n\u0000\u0000\u0237"+
		"\u0238\u0007\f\u0000\u0000\u0238\u0239\u0007\u0004\u0000\u0000\u0239\u0241"+
		"\u0007\u0003\u0000\u0000\u023a\u023b\u0005@\u0000\u0000\u023b\u023c\u0007"+
		"\u000f\u0000\u0000\u023c\u023d\u0007\u0004\u0000\u0000\u023d\u023e\u0007"+
		"\u0017\u0000\u0000\u023e\u023f\u0007\u000e\u0000\u0000\u023f\u0241\u0007"+
		"\u0000\u0000\u0000\u0240\u0141\u0001\u0000\u0000\u0000\u0240\u0149\u0001"+
		"\u0000\u0000\u0000\u0240\u0150\u0001\u0000\u0000\u0000\u0240\u015a\u0001"+
		"\u0000\u0000\u0000\u0240\u0163\u0001\u0000\u0000\u0000\u0240\u016d\u0001"+
		"\u0000\u0000\u0000\u0240\u0172\u0001\u0000\u0000\u0000\u0240\u0178\u0001"+
		"\u0000\u0000\u0000\u0240\u0181\u0001\u0000\u0000\u0000\u0240\u018a\u0001"+
		"\u0000\u0000\u0000\u0240\u0190\u0001\u0000\u0000\u0000\u0240\u01a2\u0001"+
		"\u0000\u0000\u0000\u0240\u01ac\u0001\u0000\u0000\u0000\u0240\u01ba\u0001"+
		"\u0000\u0000\u0000\u0240\u01ce\u0001\u0000\u0000\u0000\u0240\u01d7\u0001"+
		"\u0000\u0000\u0000\u0240\u01dd\u0001\u0000\u0000\u0000\u0240\u01ec\u0001"+
		"\u0000\u0000\u0000\u0240\u01f5\u0001\u0000\u0000\u0000\u0240\u0205\u0001"+
		"\u0000\u0000\u0000\u0240\u020f\u0001\u0000\u0000\u0000\u0240\u021d\u0001"+
		"\u0000\u0000\u0000\u0240\u0226\u0001\u0000\u0000\u0000\u0240\u023a\u0001"+
		"\u0000\u0000\u0000\u0241\u0245\u0001\u0000\u0000\u0000\u0242\u0244\u0007"+
		"\u0018\u0000\u0000\u0243\u0242\u0001\u0000\u0000\u0000\u0244\u0247\u0001"+
		"\u0000\u0000\u0000\u0245\u0243\u0001\u0000\u0000\u0000\u0245\u0246\u0001"+
		"\u0000\u0000\u0000\u0246\u0249\u0001\u0000\u0000\u0000\u0247\u0245\u0001"+
		"\u0000\u0000\u0000\u0248\u0113\u0001\u0000\u0000\u0000\u0248\u0116\u0001"+
		"\u0000\u0000\u0000\u0248\u011c\u0001\u0000\u0000\u0000\u0248\u0122\u0001"+
		"\u0000\u0000\u0000\u0248\u0240\u0001\u0000\u0000\u0000\u0249\u024a\u0001"+
		"\u0000\u0000\u0000\u024a\u024b\u0006$\u0002\u0000\u024bK\u0001\u0000\u0000"+
		"\u0000\u024c\u024d\u0005-\u0000\u0000\u024d\u024e\u0005-\u0000\u0000\u024e"+
		"\u024f\u0005}\u0000\u0000\u024f\u0250\u0005}\u0000\u0000\u0250\u0251\u0001"+
		"\u0000\u0000\u0000\u0251\u0252\u0006%\u0003\u0000\u0252\u0253\u0006%\u0000"+
		"\u0000\u0253M\u0001\u0000\u0000\u0000\u0254\u0255\t\u0000\u0000\u0000"+
		"\u0255\u0256\u0004&\u0000\u0000\u0256\u0257\u0001\u0000\u0000\u0000\u0257"+
		"\u0258\u0006&\u0000\u0000\u0258O\u0001\u0000\u0000\u0000\u0259\u025a\t"+
		"\u0000\u0000\u0000\u025a\u025b\u0001\u0000\u0000\u0000\u025b\u025c\u0006"+
		"\'\u0000\u0000\u025cQ\u0001\u0000\u0000\u0000\u025d\u025e\u0005\u0000"+
		"\u0000\u0001\u025e\u025f\u0001\u0000\u0000\u0000\u025f\u0260\u0006(\u0003"+
		"\u0000\u0260\u0261\u0006(\u0000\u0000\u0261S\u0001\u0000\u0000\u0000\u001a"+
		"\u0000\u0001\u00a3\u00ac\u00b4\u00b9\u00bb\u00c7\u00ce\u00d6\u00d8\u00e1"+
		"\u00e3\u00ea\u00f2\u010b\u010f\u011a\u0120\u012c\u0138\u013d\u013f\u0240"+
		"\u0245\u0248\u0004\u0006\u0000\u0000\u0005\u0001\u0000\u0007\u0001\u0000"+
		"\u0004\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}