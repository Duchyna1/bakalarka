// Generated from datalog.g4 by ANTLR 4.9.2
package compiler;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class datalogParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, QUERY_MARKER=9, 
		BODY_HEAD_SEPARATOR=10, SLC=11, MLC_START=12, MLC_END=13, EOL=14, NOT=15, 
		BUILT_IN=16, UPPER=17, LOWER=18, NUMBER=19, WS=20, COMMENT=21, MULTILINE_COMMENT=22;
	public static final int
		RULE_program = 0, RULE_query = 1, RULE_normal_built_in_predicate = 2, 
		RULE_negative_built_in_predicate = 3, RULE_built_in_predicate = 4, RULE_parameter = 5, 
		RULE_normal_predicate = 6, RULE_negative_predicate = 7, RULE_predicate = 8, 
		RULE_clause = 9, RULE_definition = 10, RULE_term_tuple = 11, RULE_term = 12, 
		RULE_name = 13, RULE_function = 14, RULE_variable = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "query", "normal_built_in_predicate", "negative_built_in_predicate", 
			"built_in_predicate", "parameter", "normal_predicate", "negative_predicate", 
			"predicate", "clause", "definition", "term_tuple", "term", "name", "function", 
			"variable"
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

	@Override
	public String getGrammarFileName() { return "datalog.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public datalogParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public List<ClauseContext> clause() {
			return getRuleContexts(ClauseContext.class);
		}
		public ClauseContext clause(int i) {
			return getRuleContext(ClauseContext.class,i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOWER) {
				{
				setState(34);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(32);
					clause();
					}
					break;
				case 2:
					{
					setState(33);
					definition();
					}
					break;
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			query();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public TerminalNode QUERY_MARKER() { return getToken(datalogParser.QUERY_MARKER, 0); }
		public TerminalNode EOL() { return getToken(datalogParser.EOL, 0); }
		public Normal_predicateContext normal_predicate() {
			return getRuleContext(Normal_predicateContext.class,0);
		}
		public Normal_built_in_predicateContext normal_built_in_predicate() {
			return getRuleContext(Normal_built_in_predicateContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(QUERY_MARKER);
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOWER:
				{
				setState(42);
				normal_predicate();
				}
				break;
			case BUILT_IN:
				{
				setState(43);
				normal_built_in_predicate();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(46);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Normal_built_in_predicateContext extends ParserRuleContext {
		public TerminalNode BUILT_IN() { return getToken(datalogParser.BUILT_IN, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public Normal_built_in_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normal_built_in_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterNormal_built_in_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitNormal_built_in_predicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitNormal_built_in_predicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Normal_built_in_predicateContext normal_built_in_predicate() throws RecognitionException {
		Normal_built_in_predicateContext _localctx = new Normal_built_in_predicateContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_normal_built_in_predicate);
		int _la;
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(BUILT_IN);
				setState(49);
				name();
				setState(50);
				match(T__0);
				setState(51);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				match(BUILT_IN);
				setState(54);
				name();
				setState(55);
				match(T__0);
				setState(56);
				parameter();
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(57);
					match(T__2);
					setState(58);
					parameter();
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(64);
				match(T__1);
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

	public static class Negative_built_in_predicateContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(datalogParser.NOT, 0); }
		public Normal_built_in_predicateContext normal_built_in_predicate() {
			return getRuleContext(Normal_built_in_predicateContext.class,0);
		}
		public Negative_built_in_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negative_built_in_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterNegative_built_in_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitNegative_built_in_predicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitNegative_built_in_predicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Negative_built_in_predicateContext negative_built_in_predicate() throws RecognitionException {
		Negative_built_in_predicateContext _localctx = new Negative_built_in_predicateContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_negative_built_in_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(NOT);
			setState(69);
			normal_built_in_predicate();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Built_in_predicateContext extends ParserRuleContext {
		public Normal_built_in_predicateContext normal_built_in_predicate() {
			return getRuleContext(Normal_built_in_predicateContext.class,0);
		}
		public Negative_built_in_predicateContext negative_built_in_predicate() {
			return getRuleContext(Negative_built_in_predicateContext.class,0);
		}
		public Built_in_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_built_in_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterBuilt_in_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitBuilt_in_predicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitBuilt_in_predicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Built_in_predicateContext built_in_predicate() throws RecognitionException {
		Built_in_predicateContext _localctx = new Built_in_predicateContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_built_in_predicate);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BUILT_IN:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				normal_built_in_predicate();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				negative_built_in_predicate();
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

	public static class ParameterContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public Normal_predicateContext normal_predicate() {
			return getRuleContext(Normal_predicateContext.class,0);
		}
		public Normal_built_in_predicateContext normal_built_in_predicate() {
			return getRuleContext(Normal_built_in_predicateContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameter);
		int _la;
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(T__3);
				setState(76);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(T__3);
				setState(78);
				parameter();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(79);
					match(T__2);
					setState(80);
					parameter();
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				match(T__4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				normal_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				normal_built_in_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(90);
				term();
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

	public static class Normal_predicateContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Normal_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normal_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterNormal_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitNormal_predicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitNormal_predicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Normal_predicateContext normal_predicate() throws RecognitionException {
		Normal_predicateContext _localctx = new Normal_predicateContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_normal_predicate);
		int _la;
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				name();
				setState(94);
				match(T__0);
				setState(95);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				name();
				setState(98);
				match(T__0);
				setState(99);
				term();
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(100);
					match(T__2);
					setState(101);
					term();
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(107);
				match(T__1);
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

	public static class Negative_predicateContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(datalogParser.NOT, 0); }
		public Normal_predicateContext normal_predicate() {
			return getRuleContext(Normal_predicateContext.class,0);
		}
		public Negative_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negative_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterNegative_predicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitNegative_predicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitNegative_predicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Negative_predicateContext negative_predicate() throws RecognitionException {
		Negative_predicateContext _localctx = new Negative_predicateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_negative_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(NOT);
			setState(112);
			normal_predicate();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public Normal_predicateContext normal_predicate() {
			return getRuleContext(Normal_predicateContext.class,0);
		}
		public Negative_predicateContext negative_predicate() {
			return getRuleContext(Negative_predicateContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_predicate);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LOWER:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				normal_predicate();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				negative_predicate();
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

	public static class ClauseContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode BODY_HEAD_SEPARATOR() { return getToken(datalogParser.BODY_HEAD_SEPARATOR, 0); }
		public TerminalNode EOL() { return getToken(datalogParser.EOL, 0); }
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public List<Built_in_predicateContext> built_in_predicate() {
			return getRuleContexts(Built_in_predicateContext.class);
		}
		public Built_in_predicateContext built_in_predicate(int i) {
			return getRuleContext(Built_in_predicateContext.class,i);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClauseContext clause() throws RecognitionException {
		ClauseContext _localctx = new ClauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_clause);
		int _la;
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				name();
				setState(119);
				match(T__0);
				setState(120);
				match(T__1);
				setState(121);
				match(BODY_HEAD_SEPARATOR);
				setState(124);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(122);
					predicate();
					}
					break;
				case 2:
					{
					setState(123);
					built_in_predicate();
					}
					break;
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(126);
					match(T__2);
					setState(129);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						setState(127);
						predicate();
						}
						break;
					case 2:
						{
						setState(128);
						built_in_predicate();
						}
						break;
					}
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(136);
				match(EOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				name();
				setState(139);
				match(T__0);
				setState(140);
				term();
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(141);
					match(T__2);
					setState(142);
					term();
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(148);
				match(T__1);
				setState(149);
				match(BODY_HEAD_SEPARATOR);
				setState(152);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(150);
					predicate();
					}
					break;
				case 2:
					{
					setState(151);
					built_in_predicate();
					}
					break;
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(154);
					match(T__2);
					setState(157);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(155);
						predicate();
						}
						break;
					case 2:
						{
						setState(156);
						built_in_predicate();
						}
						break;
					}
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(164);
				match(EOL);
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

	public static class DefinitionContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode BODY_HEAD_SEPARATOR() { return getToken(datalogParser.BODY_HEAD_SEPARATOR, 0); }
		public TerminalNode EOL() { return getToken(datalogParser.EOL, 0); }
		public List<Term_tupleContext> term_tuple() {
			return getRuleContexts(Term_tupleContext.class);
		}
		public Term_tupleContext term_tuple(int i) {
			return getRuleContext(Term_tupleContext.class,i);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_definition);
		int _la;
		try {
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				name();
				setState(169);
				match(BODY_HEAD_SEPARATOR);
				setState(170);
				match(T__5);
				setState(171);
				match(T__6);
				setState(172);
				match(EOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				name();
				setState(175);
				match(BODY_HEAD_SEPARATOR);
				setState(176);
				match(T__5);
				setState(177);
				term_tuple();
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(178);
					match(T__2);
					setState(179);
					term_tuple();
					}
					}
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(185);
				match(T__6);
				setState(186);
				match(EOL);
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

	public static class Term_tupleContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Term_tupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterTerm_tuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitTerm_tuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitTerm_tuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term_tupleContext term_tuple() throws RecognitionException {
		Term_tupleContext _localctx = new Term_tupleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_term_tuple);
		int _la;
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				match(T__0);
				setState(191);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(T__0);
				setState(193);
				term();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(194);
					match(T__2);
					setState(195);
					term();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(201);
				match(T__1);
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

	public static class TermContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_term);
		int _la;
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				function();
				setState(207);
				match(T__0);
				setState(208);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				function();
				setState(211);
				match(T__0);
				setState(212);
				term();
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(213);
					match(T__2);
					setState(214);
					term();
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(220);
				match(T__1);
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

	public static class NameContext extends ParserRuleContext {
		public List<TerminalNode> LOWER() { return getTokens(datalogParser.LOWER); }
		public TerminalNode LOWER(int i) {
			return getToken(datalogParser.LOWER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(datalogParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(datalogParser.NUMBER, i);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(LOWER);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << LOWER) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(225);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << LOWER) | (1L << NUMBER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(230);
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

	public static class FunctionContext extends ParserRuleContext {
		public List<TerminalNode> LOWER() { return getTokens(datalogParser.LOWER); }
		public TerminalNode LOWER(int i) {
			return getToken(datalogParser.LOWER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(datalogParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(datalogParser.NUMBER, i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(LOWER);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << LOWER) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(232);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << LOWER) | (1L << NUMBER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(237);
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

	public static class VariableContext extends ParserRuleContext {
		public List<TerminalNode> UPPER() { return getTokens(datalogParser.UPPER); }
		public TerminalNode UPPER(int i) {
			return getToken(datalogParser.UPPER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(datalogParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(datalogParser.NUMBER, i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof datalogListener ) ((datalogListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof datalogVisitor ) return ((datalogVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(UPPER);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << UPPER) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(239);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << UPPER) | (1L << NUMBER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(244);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u00f8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\7\2%\n\2\f\2\16\2(\13\2\3\2\3\2\3\3\3\3\3\3\5\3/\n\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4>\n\4\f\4\16\4A\13\4\3\4\3\4\5"+
		"\4E\n\4\3\5\3\5\3\5\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7T\n\7"+
		"\f\7\16\7W\13\7\3\7\3\7\3\7\3\7\3\7\5\7^\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\7\bi\n\b\f\b\16\bl\13\b\3\b\3\b\5\bp\n\b\3\t\3\t\3\t\3\n\3"+
		"\n\5\nw\n\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\177\n\13\3\13\3\13\3\13"+
		"\5\13\u0084\n\13\7\13\u0086\n\13\f\13\16\13\u0089\13\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u0092\n\13\f\13\16\13\u0095\13\13\3\13\3\13"+
		"\3\13\3\13\5\13\u009b\n\13\3\13\3\13\3\13\5\13\u00a0\n\13\7\13\u00a2\n"+
		"\13\f\13\16\13\u00a5\13\13\3\13\3\13\5\13\u00a9\n\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00b7\n\f\f\f\16\f\u00ba\13\f\3\f\3"+
		"\f\3\f\5\f\u00bf\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00c7\n\r\f\r\16\r\u00ca"+
		"\13\r\3\r\3\r\5\r\u00ce\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\7\16\u00da\n\16\f\16\16\16\u00dd\13\16\3\16\3\16\5\16\u00e1\n"+
		"\16\3\17\3\17\7\17\u00e5\n\17\f\17\16\17\u00e8\13\17\3\20\3\20\7\20\u00ec"+
		"\n\20\f\20\16\20\u00ef\13\20\3\21\3\21\7\21\u00f3\n\21\f\21\16\21\u00f6"+
		"\13\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\4\4\2\n\n"+
		"\24\25\5\2\n\n\23\23\25\25\2\u0107\2&\3\2\2\2\4+\3\2\2\2\6D\3\2\2\2\b"+
		"F\3\2\2\2\nK\3\2\2\2\f]\3\2\2\2\16o\3\2\2\2\20q\3\2\2\2\22v\3\2\2\2\24"+
		"\u00a8\3\2\2\2\26\u00be\3\2\2\2\30\u00cd\3\2\2\2\32\u00e0\3\2\2\2\34\u00e2"+
		"\3\2\2\2\36\u00e9\3\2\2\2 \u00f0\3\2\2\2\"%\5\24\13\2#%\5\26\f\2$\"\3"+
		"\2\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)"+
		"*\5\4\3\2*\3\3\2\2\2+.\7\13\2\2,/\5\16\b\2-/\5\6\4\2.,\3\2\2\2.-\3\2\2"+
		"\2/\60\3\2\2\2\60\61\7\20\2\2\61\5\3\2\2\2\62\63\7\22\2\2\63\64\5\34\17"+
		"\2\64\65\7\3\2\2\65\66\7\4\2\2\66E\3\2\2\2\678\7\22\2\289\5\34\17\29:"+
		"\7\3\2\2:?\5\f\7\2;<\7\5\2\2<>\5\f\7\2=;\3\2\2\2>A\3\2\2\2?=\3\2\2\2?"+
		"@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7\4\2\2CE\3\2\2\2D\62\3\2\2\2D\67\3\2"+
		"\2\2E\7\3\2\2\2FG\7\21\2\2GH\5\6\4\2H\t\3\2\2\2IL\5\6\4\2JL\5\b\5\2KI"+
		"\3\2\2\2KJ\3\2\2\2L\13\3\2\2\2MN\7\6\2\2N^\7\7\2\2OP\7\6\2\2PU\5\f\7\2"+
		"QR\7\5\2\2RT\5\f\7\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2"+
		"WU\3\2\2\2XY\7\7\2\2Y^\3\2\2\2Z^\5\16\b\2[^\5\6\4\2\\^\5\32\16\2]M\3\2"+
		"\2\2]O\3\2\2\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2\2^\r\3\2\2\2_`\5\34\17\2`"+
		"a\7\3\2\2ab\7\4\2\2bp\3\2\2\2cd\5\34\17\2de\7\3\2\2ej\5\32\16\2fg\7\5"+
		"\2\2gi\5\32\16\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3"+
		"\2\2\2mn\7\4\2\2np\3\2\2\2o_\3\2\2\2oc\3\2\2\2p\17\3\2\2\2qr\7\21\2\2"+
		"rs\5\16\b\2s\21\3\2\2\2tw\5\16\b\2uw\5\20\t\2vt\3\2\2\2vu\3\2\2\2w\23"+
		"\3\2\2\2xy\5\34\17\2yz\7\3\2\2z{\7\4\2\2{~\7\f\2\2|\177\5\22\n\2}\177"+
		"\5\n\6\2~|\3\2\2\2~}\3\2\2\2\177\u0087\3\2\2\2\u0080\u0083\7\5\2\2\u0081"+
		"\u0084\5\22\n\2\u0082\u0084\5\n\6\2\u0083\u0081\3\2\2\2\u0083\u0082\3"+
		"\2\2\2\u0084\u0086\3\2\2\2\u0085\u0080\3\2\2\2\u0086\u0089\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2"+
		"\2\2\u008a\u008b\7\20\2\2\u008b\u00a9\3\2\2\2\u008c\u008d\5\34\17\2\u008d"+
		"\u008e\7\3\2\2\u008e\u0093\5\32\16\2\u008f\u0090\7\5\2\2\u0090\u0092\5"+
		"\32\16\2\u0091\u008f\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\4"+
		"\2\2\u0097\u009a\7\f\2\2\u0098\u009b\5\22\n\2\u0099\u009b\5\n\6\2\u009a"+
		"\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009b\u00a3\3\2\2\2\u009c\u009f\7\5"+
		"\2\2\u009d\u00a0\5\22\n\2\u009e\u00a0\5\n\6\2\u009f\u009d\3\2\2\2\u009f"+
		"\u009e\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009c\3\2\2\2\u00a2\u00a5\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a6\u00a7\7\20\2\2\u00a7\u00a9\3\2\2\2\u00a8x\3\2\2\2"+
		"\u00a8\u008c\3\2\2\2\u00a9\25\3\2\2\2\u00aa\u00ab\5\34\17\2\u00ab\u00ac"+
		"\7\f\2\2\u00ac\u00ad\7\b\2\2\u00ad\u00ae\7\t\2\2\u00ae\u00af\7\20\2\2"+
		"\u00af\u00bf\3\2\2\2\u00b0\u00b1\5\34\17\2\u00b1\u00b2\7\f\2\2\u00b2\u00b3"+
		"\7\b\2\2\u00b3\u00b8\5\30\r\2\u00b4\u00b5\7\5\2\2\u00b5\u00b7\5\30\r\2"+
		"\u00b6\u00b4\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7\t\2\2\u00bc"+
		"\u00bd\7\20\2\2\u00bd\u00bf\3\2\2\2\u00be\u00aa\3\2\2\2\u00be\u00b0\3"+
		"\2\2\2\u00bf\27\3\2\2\2\u00c0\u00c1\7\3\2\2\u00c1\u00ce\7\4\2\2\u00c2"+
		"\u00c3\7\3\2\2\u00c3\u00c8\5\32\16\2\u00c4\u00c5\7\5\2\2\u00c5\u00c7\5"+
		"\32\16\2\u00c6\u00c4\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\7\4"+
		"\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00c0\3\2\2\2\u00cd\u00c2\3\2\2\2\u00ce"+
		"\31\3\2\2\2\u00cf\u00e1\5 \21\2\u00d0\u00d1\5\36\20\2\u00d1\u00d2\7\3"+
		"\2\2\u00d2\u00d3\7\4\2\2\u00d3\u00e1\3\2\2\2\u00d4\u00d5\5\36\20\2\u00d5"+
		"\u00d6\7\3\2\2\u00d6\u00db\5\32\16\2\u00d7\u00d8\7\5\2\2\u00d8\u00da\5"+
		"\32\16\2\u00d9\u00d7\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7\4"+
		"\2\2\u00df\u00e1\3\2\2\2\u00e0\u00cf\3\2\2\2\u00e0\u00d0\3\2\2\2\u00e0"+
		"\u00d4\3\2\2\2\u00e1\33\3\2\2\2\u00e2\u00e6\7\24\2\2\u00e3\u00e5\t\2\2"+
		"\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7"+
		"\3\2\2\2\u00e7\35\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ed\7\24\2\2\u00ea"+
		"\u00ec\t\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\37\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f4"+
		"\7\23\2\2\u00f1\u00f3\t\3\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2"+
		"\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5!\3\2\2\2\u00f6\u00f4\3"+
		"\2\2\2\36$&.?DKU]jov~\u0083\u0087\u0093\u009a\u009f\u00a3\u00a8\u00b8"+
		"\u00be\u00c8\u00cd\u00db\u00e0\u00e6\u00ed\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}