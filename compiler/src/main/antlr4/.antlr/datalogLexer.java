// Generated from datalog.g4 by ANTLR 4.9.2
package compiler;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class datalogLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, QUERY_MARKER=9, 
		BODY_HEAD_SEPARATOR=10, SLC=11, MLC_START=12, MLC_END=13, EOL=14, NOT=15, 
		BUILT_IN=16, UPPER=17, LOWER=18, NUMBER=19, WS=20, COMMENT=21, MULTILINE_COMMENT=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "QUERY_MARKER", 
			"BODY_HEAD_SEPARATOR", "SLC", "MLC_START", "MLC_END", "EOL", "NOT", "BUILT_IN", 
			"UPPER", "LOWER", "NUMBER", "WS", "COMMENT", "MULTILINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'['", "']'", "'{'", "'}'", "'_'", "'?-'", 
			"':-'", "'%'", "'/*'", "'*/'", "'.'", "'\\+'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "QUERY_MARKER", 
			"BODY_HEAD_SEPARATOR", "SLC", "MLC_START", "MLC_END", "EOL", "NOT", "BUILT_IN", 
			"UPPER", "LOWER", "NUMBER", "WS", "COMMENT", "MULTILINE_COMMENT"
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


	public datalogLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "datalog.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0084\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\22\6\22V\n\22\r\22\16\22W\3\23\6\23[\n\23\r\23\16\23\\\3\24"+
		"\6\24`\n\24\r\24\16\24a\3\25\6\25e\n\25\r\25\16\25f\3\25\3\25\3\26\3\26"+
		"\7\26m\n\26\f\26\16\26p\13\26\3\26\5\26s\n\26\3\26\3\26\3\27\3\27\3\27"+
		"\7\27z\n\27\f\27\16\27}\13\27\3\27\3\27\5\27\u0081\n\27\3\27\3\27\3{\2"+
		"\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30\3\2\b\3\2C\\\3\2c|\3\2\62;\5\2"+
		"\13\f\17\17\"\"\4\2\f\f\17\17\4\3\f\f\17\17\2\u008b\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\61\3\2\2\2\7\63"+
		"\3\2\2\2\t\65\3\2\2\2\13\67\3\2\2\2\r9\3\2\2\2\17;\3\2\2\2\21=\3\2\2\2"+
		"\23?\3\2\2\2\25B\3\2\2\2\27E\3\2\2\2\31G\3\2\2\2\33J\3\2\2\2\35M\3\2\2"+
		"\2\37O\3\2\2\2!R\3\2\2\2#U\3\2\2\2%Z\3\2\2\2\'_\3\2\2\2)d\3\2\2\2+j\3"+
		"\2\2\2-v\3\2\2\2/\60\7*\2\2\60\4\3\2\2\2\61\62\7+\2\2\62\6\3\2\2\2\63"+
		"\64\7.\2\2\64\b\3\2\2\2\65\66\7]\2\2\66\n\3\2\2\2\678\7_\2\28\f\3\2\2"+
		"\29:\7}\2\2:\16\3\2\2\2;<\7\177\2\2<\20\3\2\2\2=>\7a\2\2>\22\3\2\2\2?"+
		"@\7A\2\2@A\7/\2\2A\24\3\2\2\2BC\7<\2\2CD\7/\2\2D\26\3\2\2\2EF\7\'\2\2"+
		"F\30\3\2\2\2GH\7\61\2\2HI\7,\2\2I\32\3\2\2\2JK\7,\2\2KL\7\61\2\2L\34\3"+
		"\2\2\2MN\7\60\2\2N\36\3\2\2\2OP\7^\2\2PQ\7-\2\2Q \3\2\2\2RS\7&\2\2S\""+
		"\3\2\2\2TV\t\2\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X$\3\2\2\2Y"+
		"[\t\3\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]&\3\2\2\2^`\t\4\2"+
		"\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2b(\3\2\2\2ce\t\5\2\2dc\3\2\2"+
		"\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\b\25\2\2i*\3\2\2\2jn\5\27"+
		"\f\2km\n\6\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2or\3\2\2\2pn\3\2"+
		"\2\2qs\t\7\2\2rq\3\2\2\2st\3\2\2\2tu\b\26\3\2u,\3\2\2\2v{\5\31\r\2wz\5"+
		"-\27\2xz\13\2\2\2yw\3\2\2\2yx\3\2\2\2z}\3\2\2\2{|\3\2\2\2{y\3\2\2\2|\u0080"+
		"\3\2\2\2}{\3\2\2\2~\u0081\5\33\16\2\177\u0081\7\2\2\3\u0080~\3\2\2\2\u0080"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\b\27\3\2\u0083.\3\2\2\2\f"+
		"\2W\\afnry{\u0080\4\b\2\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}