// Generated from BladeHtmlAntlrLexer.g4 by ANTLR 4.13.0

  package org.netbeans.modules.php.blade.syntax.antlr4.html_components;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BladeHtmlAntlrLexer extends LexerAdaptor {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HTML_COMPONENT_OPEN_TAG=1, COMPONENT_ATTRIBUTE=2, GT=3, BLADE_COMMENT_START=4, 
		BLADE_TAG_ESCAPE=5, CONTENT_TAG_OPEN=6, CONTENT_TAG_CLOSE=7, RAW_TAG_OPEN=8, 
		RAW_TAG_CLOSE=9, WS=10, OTHER=11, BLADE_COMMENT_END=12, BLADE_COMMENT_MORE=13, 
		BLADE_COMMENT_EOF=14;
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
			"Identifier", "HTML_COMPONENT_OPEN_TAG", "COMPONENT_ATTRIBUTE", "GT", 
			"BLADE_COMMENT_START", "BLADE_TAG_ESCAPE", "CONTENT_TAG_OPEN", "CONTENT_TAG_CLOSE", 
			"RAW_TAG_OPEN", "RAW_TAG_CLOSE", "WS", "OTHER", "BLADE_COMMENT_END", 
			"BLADE_COMMENT_MORE", "BLADE_COMMENT_EOF"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'>'", "'{{--'", null, null, null, null, null, null, 
			null, "'--}}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HTML_COMPONENT_OPEN_TAG", "COMPONENT_ATTRIBUTE", "GT", "BLADE_COMMENT_START", 
			"BLADE_TAG_ESCAPE", "CONTENT_TAG_OPEN", "CONTENT_TAG_CLOSE", "RAW_TAG_OPEN", 
			"RAW_TAG_CLOSE", "WS", "OTHER", "BLADE_COMMENT_END", "BLADE_COMMENT_MORE", 
			"BLADE_COMMENT_EOF"
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


	    boolean tagOpened = false;
	    boolean insideTag = false;
	    int contentTagBalance = 0;
	    int rawTagBalance = 0;


	public BladeHtmlAntlrLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BladeHtmlAntlrLexer.g4"; }

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
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 1:
			HTML_COMPONENT_OPEN_TAG_action((RuleContext)_localctx, actionIndex);
			break;
		case 3:
			GT_action((RuleContext)_localctx, actionIndex);
			break;
		case 6:
			CONTENT_TAG_OPEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 7:
			CONTENT_TAG_CLOSE_action((RuleContext)_localctx, actionIndex);
			break;
		case 8:
			RAW_TAG_OPEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 9:
			RAW_TAG_CLOSE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void HTML_COMPONENT_OPEN_TAG_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			tagOpened = true;insideTag = true;
			break;
		}
	}
	private void GT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			insideTag = false;
			break;
		}
	}
	private void CONTENT_TAG_OPEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			contentTagBalance++;
			break;
		}
	}
	private void CONTENT_TAG_CLOSE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			contentTagBalance--;
			break;
		}
	}
	private void RAW_TAG_OPEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			rawTagBalance++;
			break;
		}
	}
	private void RAW_TAG_CLOSE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			rawTagBalance--;
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return COMPONENT_ATTRIBUTE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean COMPONENT_ATTRIBUTE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return insideTag == true && contentTagBalance == 0 && rawTagBalance == 0;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0000\u000e\u0090\u0006\uffff\uffff\u0006\uffff\uffff\u0002\u0000"+
		"\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003"+
		"\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006"+
		"\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002"+
		"\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002"+
		"\u000e\u0007\u000e\u0001\u0000\u0001\u0000\u0005\u0000#\b\u0000\n\u0000"+
		"\f\u0000&\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00010\b\u0001\u0001"+
		"\u0001\u0003\u00013\b\u0001\u0003\u00015\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0004\u0005"+
		"J\b\u0005\u000b\u0005\f\u0005K\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0004\no\b\n\u000b\n\f\np\u0001\n\u0004\nt\b\n\u000b\n\f\nu\u0003\n"+
		"x\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0000\u0000\u000f\u0002\u0000\u0004\u0001\u0006\u0002\b\u0003"+
		"\n\u0004\f\u0005\u000e\u0006\u0010\u0007\u0012\b\u0014\t\u0016\n\u0018"+
		"\u000b\u001a\f\u001c\r\u001e\u000e\u0002\u0000\u0001\u0004\u0003\u0000"+
		"AZaz\u0080\u8000\ufffe\u0006\u0000--09AZ__az\u0080\u8000\ufffe\u0002\u0000"+
		"XXxx\u0002\u0000\n\n\r\r\u0095\u0000\u0004\u0001\u0000\u0000\u0000\u0000"+
		"\u0006\u0001\u0000\u0000\u0000\u0000\b\u0001\u0000\u0000\u0000\u0000\n"+
		"\u0001\u0000\u0000\u0000\u0000\f\u0001\u0000\u0000\u0000\u0000\u000e\u0001"+
		"\u0000\u0000\u0000\u0000\u0010\u0001\u0000\u0000\u0000\u0000\u0012\u0001"+
		"\u0000\u0000\u0000\u0000\u0014\u0001\u0000\u0000\u0000\u0000\u0016\u0001"+
		"\u0000\u0000\u0000\u0000\u0018\u0001\u0000\u0000\u0000\u0001\u001a\u0001"+
		"\u0000\u0000\u0000\u0001\u001c\u0001\u0000\u0000\u0000\u0001\u001e\u0001"+
		"\u0000\u0000\u0000\u0002 \u0001\u0000\u0000\u0000\u0004\'\u0001\u0000"+
		"\u0000\u0000\u00068\u0001\u0000\u0000\u0000\b<\u0001\u0000\u0000\u0000"+
		"\n?\u0001\u0000\u0000\u0000\fG\u0001\u0000\u0000\u0000\u000eO\u0001\u0000"+
		"\u0000\u0000\u0010V\u0001\u0000\u0000\u0000\u0012]\u0001\u0000\u0000\u0000"+
		"\u0014e\u0001\u0000\u0000\u0000\u0016w\u0001\u0000\u0000\u0000\u0018{"+
		"\u0001\u0000\u0000\u0000\u001a\u007f\u0001\u0000\u0000\u0000\u001c\u0087"+
		"\u0001\u0000\u0000\u0000\u001e\u008b\u0001\u0000\u0000\u0000 $\u0007\u0000"+
		"\u0000\u0000!#\u0007\u0001\u0000\u0000\"!\u0001\u0000\u0000\u0000#&\u0001"+
		"\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000"+
		"%\u0003\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000\'(\u0005<\u0000"+
		"\u0000()\u0007\u0002\u0000\u0000)*\u0005-\u0000\u0000*4\u0001\u0000\u0000"+
		"\u0000+2\u0003\u0002\u0000\u0000,-\u0005:\u0000\u0000-0\u0005:\u0000\u0000"+
		".0\u0005.\u0000\u0000/,\u0001\u0000\u0000\u0000/.\u0001\u0000\u0000\u0000"+
		"01\u0001\u0000\u0000\u000013\u0003\u0002\u0000\u00002/\u0001\u0000\u0000"+
		"\u000023\u0001\u0000\u0000\u000035\u0001\u0000\u0000\u00004+\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0006"+
		"\u0001\u0000\u00007\u0005\u0001\u0000\u0000\u000089\u0004\u0002\u0000"+
		"\u00009:\u0005:\u0000\u0000:;\u0003\u0002\u0000\u0000;\u0007\u0001\u0000"+
		"\u0000\u0000<=\u0005>\u0000\u0000=>\u0006\u0003\u0001\u0000>\t\u0001\u0000"+
		"\u0000\u0000?@\u0005{\u0000\u0000@A\u0005{\u0000\u0000AB\u0005-\u0000"+
		"\u0000BC\u0005-\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0006\u0004\u0002"+
		"\u0000EF\u0006\u0004\u0003\u0000F\u000b\u0001\u0000\u0000\u0000GI\u0005"+
		"@\u0000\u0000HJ\u0005{\u0000\u0000IH\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000MN\u0006\u0005\u0003\u0000N\r\u0001\u0000\u0000\u0000"+
		"OP\u0005{\u0000\u0000PQ\u0005{\u0000\u0000QR\u0001\u0000\u0000\u0000R"+
		"S\u0006\u0006\u0004\u0000ST\u0001\u0000\u0000\u0000TU\u0006\u0006\u0003"+
		"\u0000U\u000f\u0001\u0000\u0000\u0000VW\u0005}\u0000\u0000WX\u0005}\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000YZ\u0006\u0007\u0005\u0000Z[\u0001\u0000"+
		"\u0000\u0000[\\\u0006\u0007\u0003\u0000\\\u0011\u0001\u0000\u0000\u0000"+
		"]^\u0005{\u0000\u0000^_\u0005!\u0000\u0000_`\u0005!\u0000\u0000`a\u0001"+
		"\u0000\u0000\u0000ab\u0006\b\u0006\u0000bc\u0001\u0000\u0000\u0000cd\u0006"+
		"\b\u0003\u0000d\u0013\u0001\u0000\u0000\u0000ef\u0005!\u0000\u0000fg\u0005"+
		"!\u0000\u0000gh\u0005}\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0006\t"+
		"\u0007\u0000jk\u0001\u0000\u0000\u0000kl\u0006\t\u0003\u0000l\u0015\u0001"+
		"\u0000\u0000\u0000mo\u0005 \u0000\u0000nm\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000"+
		"qx\u0001\u0000\u0000\u0000rt\u0007\u0003\u0000\u0000sr\u0001\u0000\u0000"+
		"\u0000tu\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000"+
		"\u0000\u0000vx\u0001\u0000\u0000\u0000wn\u0001\u0000\u0000\u0000ws\u0001"+
		"\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0006\n\u0003\u0000z\u0017"+
		"\u0001\u0000\u0000\u0000{|\t\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}~\u0006\u000b\u0003\u0000~\u0019\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0005-\u0000\u0000\u0080\u0081\u0005-\u0000\u0000\u0081\u0082\u0005}"+
		"\u0000\u0000\u0082\u0083\u0005}\u0000\u0000\u0083\u0084\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0006\f\b\u0000\u0085\u0086\u0006\f\u0003\u0000\u0086"+
		"\u001b\u0001\u0000\u0000\u0000\u0087\u0088\t\u0000\u0000\u0000\u0088\u0089"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0006\r\u0003\u0000\u008a\u001d\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0005\u0000\u0000\u0001\u008c\u008d\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0006\u000e\b\u0000\u008e\u008f\u0006\u000e"+
		"\u0003\u0000\u008f\u001f\u0001\u0000\u0000\u0000\n\u0000\u0001$/24Kpu"+
		"w\t\u0001\u0001\u0000\u0001\u0003\u0001\u0005\u0001\u0000\u0006\u0000"+
		"\u0000\u0001\u0006\u0002\u0001\u0007\u0003\u0001\b\u0004\u0001\t\u0005"+
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