// Generated from Music.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MusicParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, SHARP=15, FLAT=16, 
    NATURAL=17, OCTAVE_UP=18, OCTAVE_DOWN=19, BASENOTE=20, NEWLINE=21, WHITESPACE=22, 
    DIGIT=23;
  public static final int
    RULE_root = 0, RULE_music = 1, RULE_measure = 2, RULE_first_ending = 3, 
    RULE_second_ending = 4, RULE_normal_measure = 5, RULE_double_bar = 6, 
    RULE_start_repeat = 7, RULE_end_repeat = 8, RULE_element = 9, RULE_note_element = 10, 
    RULE_multi_note = 11, RULE_note = 12, RULE_pitch = 13, RULE_rest = 14, 
    RULE_note_length = 15, RULE_tuplet_element = 16, RULE_tuplet_spec = 17, 
    RULE_comment = 18, RULE_accidental = 19, RULE_octave = 20;
  public static final String[] ruleNames = {
    "root", "music", "measure", "first_ending", "second_ending", "normal_measure", 
    "double_bar", "start_repeat", "end_repeat", "element", "note_element", 
    "multi_note", "note", "pitch", "rest", "note_length", "tuplet_element", 
    "tuplet_spec", "comment", "accidental", "octave"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'|'", "'[1'", "'[2'", "'||'", "'[|'", "'|]'", "'|:'", "':|'", 
    "'['", "']'", "'z'", "'/'", "'('", "'%'", null, null, "'='"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, null, null, null, null, null, null, 
    null, null, null, "SHARP", "FLAT", "NATURAL", "OCTAVE_UP", "OCTAVE_DOWN", 
    "BASENOTE", "NEWLINE", "WHITESPACE", "DIGIT"
  };
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
  public String getGrammarFileName() { return "Music.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public ATN getATN() { return _ATN; }


      // This method makes the parser stop running if it encounters
      // invalid input and throw a RuntimeException.
      public void reportErrorsAsExceptions() {
          // To prevent any reports to standard error, add this line:
          //removeErrorListeners();
          
          addErrorListener(new BaseErrorListener() {
              public void syntaxError(Recognizer<?, ?> recognizer,
                                      Object offendingSymbol, 
                                      int line, int charPositionInLine,
                                      String msg, RecognitionException e) {
                  throw new ParseCancellationException(msg, e);
              }
          });
      }

  public MusicParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class RootContext extends ParserRuleContext {
    public MusicContext music() {
      return getRuleContext(MusicContext.class,0);
    }
    public TerminalNode EOF() { return getToken(MusicParser.EOF, 0); }
    public RootContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_root; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterRoot(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitRoot(this);
    }
  }

  public final RootContext root() throws RecognitionException {
    RootContext _localctx = new RootContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_root);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(42);
      music();
      setState(43);
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

  public static class MusicContext extends ParserRuleContext {
    public List<MeasureContext> measure() {
      return getRuleContexts(MeasureContext.class);
    }
    public MeasureContext measure(int i) {
      return getRuleContext(MeasureContext.class,i);
    }
    public MusicContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_music; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterMusic(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitMusic(this);
    }
  }

  public final MusicContext music() throws RecognitionException {
    MusicContext _localctx = new MusicContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_music);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(46);
      _la = _input.LA(1);
      if (_la==T__0) {
        {
        setState(45);
        match(T__0);
        }
      }

      setState(49); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(48);
        measure();
        }
        }
        setState(51); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__6) | (1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << SHARP) | (1L << FLAT) | (1L << NATURAL) | (1L << BASENOTE) | (1L << WHITESPACE))) != 0) );
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class MeasureContext extends ParserRuleContext {
    public Normal_measureContext normal_measure() {
      return getRuleContext(Normal_measureContext.class,0);
    }
    public Start_repeatContext start_repeat() {
      return getRuleContext(Start_repeatContext.class,0);
    }
    public Double_barContext double_bar() {
      return getRuleContext(Double_barContext.class,0);
    }
    public First_endingContext first_ending() {
      return getRuleContext(First_endingContext.class,0);
    }
    public Second_endingContext second_ending() {
      return getRuleContext(Second_endingContext.class,0);
    }
    public End_repeatContext end_repeat() {
      return getRuleContext(End_repeatContext.class,0);
    }
    public MeasureContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_measure; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterMeasure(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitMeasure(this);
    }
  }

  public final MeasureContext measure() throws RecognitionException {
    MeasureContext _localctx = new MeasureContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_measure);
    try {
      setState(59);
      switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
      case 1:
        enterOuterAlt(_localctx, 1);
        {
        setState(53);
        normal_measure();
        }
        break;
      case 2:
        enterOuterAlt(_localctx, 2);
        {
        setState(54);
        start_repeat();
        }
        break;
      case 3:
        enterOuterAlt(_localctx, 3);
        {
        setState(55);
        double_bar();
        }
        break;
      case 4:
        enterOuterAlt(_localctx, 4);
        {
        setState(56);
        first_ending();
        }
        break;
      case 5:
        enterOuterAlt(_localctx, 5);
        {
        setState(57);
        second_ending();
        }
        break;
      case 6:
        enterOuterAlt(_localctx, 6);
        {
        setState(58);
        end_repeat();
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

  public static class First_endingContext extends ParserRuleContext {
    public End_repeatContext end_repeat() {
      return getRuleContext(End_repeatContext.class,0);
    }
    public List<Normal_measureContext> normal_measure() {
      return getRuleContexts(Normal_measureContext.class);
    }
    public Normal_measureContext normal_measure(int i) {
      return getRuleContext(Normal_measureContext.class,i);
    }
    public First_endingContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_first_ending; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterFirst_ending(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitFirst_ending(this);
    }
  }

  public final First_endingContext first_ending() throws RecognitionException {
    First_endingContext _localctx = new First_endingContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_first_ending);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(61);
      match(T__1);
      setState(65);
      _errHandler.sync(this);
      _alt = getInterpreter().adaptivePredict(_input,3,_ctx);
      while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
        if ( _alt==1 ) {
          {
          {
          setState(62);
          normal_measure();
          }
          } 
        }
        setState(67);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,3,_ctx);
      }
      setState(68);
      end_repeat();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Second_endingContext extends ParserRuleContext {
    public List<Normal_measureContext> normal_measure() {
      return getRuleContexts(Normal_measureContext.class);
    }
    public Normal_measureContext normal_measure(int i) {
      return getRuleContext(Normal_measureContext.class,i);
    }
    public Double_barContext double_bar() {
      return getRuleContext(Double_barContext.class,0);
    }
    public Second_endingContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_second_ending; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterSecond_ending(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitSecond_ending(this);
    }
  }

  public final Second_endingContext second_ending() throws RecognitionException {
    Second_endingContext _localctx = new Second_endingContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_second_ending);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(70);
      match(T__2);
      setState(74);
      _errHandler.sync(this);
      _alt = getInterpreter().adaptivePredict(_input,4,_ctx);
      while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
        if ( _alt==1 ) {
          {
          {
          setState(71);
          normal_measure();
          }
          } 
        }
        setState(76);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,4,_ctx);
      }
      setState(78);
      switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
      case 1:
        {
        setState(77);
        double_bar();
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

  public static class Normal_measureContext extends ParserRuleContext {
    public Start_repeatContext start_repeat() {
      return getRuleContext(Start_repeatContext.class,0);
    }
    public List<ElementContext> element() {
      return getRuleContexts(ElementContext.class);
    }
    public ElementContext element(int i) {
      return getRuleContext(ElementContext.class,i);
    }
    public Normal_measureContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_normal_measure; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterNormal_measure(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitNormal_measure(this);
    }
  }

  public final Normal_measureContext normal_measure() throws RecognitionException {
    Normal_measureContext _localctx = new Normal_measureContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_normal_measure);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(81); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(80);
        element();
        }
        }
        setState(83); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << SHARP) | (1L << FLAT) | (1L << NATURAL) | (1L << BASENOTE) | (1L << WHITESPACE))) != 0) );
      setState(87);
      switch (_input.LA(1)) {
      case T__0:
        {
        setState(85);
        match(T__0);
        }
        break;
      case T__6:
        {
        setState(86);
        start_repeat();
        }
        break;
      default:
        throw new NoViableAltException(this);
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

  public static class Double_barContext extends ParserRuleContext {
    public List<ElementContext> element() {
      return getRuleContexts(ElementContext.class);
    }
    public ElementContext element(int i) {
      return getRuleContext(ElementContext.class,i);
    }
    public Double_barContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_double_bar; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterDouble_bar(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitDouble_bar(this);
    }
  }

  public final Double_barContext double_bar() throws RecognitionException {
    Double_barContext _localctx = new Double_barContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_double_bar);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(90); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(89);
        element();
        }
        }
        setState(92); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << SHARP) | (1L << FLAT) | (1L << NATURAL) | (1L << BASENOTE) | (1L << WHITESPACE))) != 0) );
      setState(94);
      _la = _input.LA(1);
      if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) ) {
      _errHandler.recoverInline(this);
      } else {
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

  public static class Start_repeatContext extends ParserRuleContext {
    public List<ElementContext> element() {
      return getRuleContexts(ElementContext.class);
    }
    public ElementContext element(int i) {
      return getRuleContext(ElementContext.class,i);
    }
    public Start_repeatContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_start_repeat; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterStart_repeat(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitStart_repeat(this);
    }
  }

  public final Start_repeatContext start_repeat() throws RecognitionException {
    Start_repeatContext _localctx = new Start_repeatContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_start_repeat);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(96);
      match(T__6);
      setState(98); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(97);
        element();
        }
        }
        setState(100); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << SHARP) | (1L << FLAT) | (1L << NATURAL) | (1L << BASENOTE) | (1L << WHITESPACE))) != 0) );
      setState(102);
      _la = _input.LA(1);
      if ( !(_la==T__0 || _la==T__7) ) {
      _errHandler.recoverInline(this);
      } else {
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

  public static class End_repeatContext extends ParserRuleContext {
    public List<ElementContext> element() {
      return getRuleContexts(ElementContext.class);
    }
    public ElementContext element(int i) {
      return getRuleContext(ElementContext.class,i);
    }
    public End_repeatContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_end_repeat; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterEnd_repeat(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitEnd_repeat(this);
    }
  }

  public final End_repeatContext end_repeat() throws RecognitionException {
    End_repeatContext _localctx = new End_repeatContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_end_repeat);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(105); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(104);
        element();
        }
        }
        setState(107); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__12) | (1L << SHARP) | (1L << FLAT) | (1L << NATURAL) | (1L << BASENOTE) | (1L << WHITESPACE))) != 0) );
      setState(109);
      match(T__7);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class ElementContext extends ParserRuleContext {
    public Note_elementContext note_element() {
      return getRuleContext(Note_elementContext.class,0);
    }
    public Tuplet_elementContext tuplet_element() {
      return getRuleContext(Tuplet_elementContext.class,0);
    }
    public TerminalNode WHITESPACE() { return getToken(MusicParser.WHITESPACE, 0); }
    public ElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterElement(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitElement(this);
    }
  }

  public final ElementContext element() throws RecognitionException {
    ElementContext _localctx = new ElementContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_element);
    try {
      setState(114);
      switch (_input.LA(1)) {
      case T__8:
      case T__10:
      case SHARP:
      case FLAT:
      case NATURAL:
      case BASENOTE:
        enterOuterAlt(_localctx, 1);
        {
        setState(111);
        note_element();
        }
        break;
      case T__12:
        enterOuterAlt(_localctx, 2);
        {
        setState(112);
        tuplet_element();
        }
        break;
      case WHITESPACE:
        enterOuterAlt(_localctx, 3);
        {
        setState(113);
        match(WHITESPACE);
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

  public static class Note_elementContext extends ParserRuleContext {
    public NoteContext note() {
      return getRuleContext(NoteContext.class,0);
    }
    public Multi_noteContext multi_note() {
      return getRuleContext(Multi_noteContext.class,0);
    }
    public Note_elementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterNote_element(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitNote_element(this);
    }
  }

  public final Note_elementContext note_element() throws RecognitionException {
    Note_elementContext _localctx = new Note_elementContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_note_element);
    try {
      setState(118);
      switch (_input.LA(1)) {
      case T__10:
      case SHARP:
      case FLAT:
      case NATURAL:
      case BASENOTE:
        enterOuterAlt(_localctx, 1);
        {
        setState(116);
        note();
        }
        break;
      case T__8:
        enterOuterAlt(_localctx, 2);
        {
        setState(117);
        multi_note();
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

  public static class Multi_noteContext extends ParserRuleContext {
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public Multi_noteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_multi_note; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterMulti_note(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitMulti_note(this);
    }
  }

  public final Multi_noteContext multi_note() throws RecognitionException {
    Multi_noteContext _localctx = new Multi_noteContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_multi_note);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(120);
      match(T__8);
      setState(122); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(121);
        note();
        }
        }
        setState(124); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << SHARP) | (1L << FLAT) | (1L << NATURAL) | (1L << BASENOTE))) != 0) );
      setState(126);
      match(T__9);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class NoteContext extends ParserRuleContext {
    public PitchContext pitch() {
      return getRuleContext(PitchContext.class,0);
    }
    public RestContext rest() {
      return getRuleContext(RestContext.class,0);
    }
    public Note_lengthContext note_length() {
      return getRuleContext(Note_lengthContext.class,0);
    }
    public NoteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterNote(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitNote(this);
    }
  }

  public final NoteContext note() throws RecognitionException {
    NoteContext _localctx = new NoteContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_note);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(130);
      switch (_input.LA(1)) {
      case SHARP:
      case FLAT:
      case NATURAL:
      case BASENOTE:
        {
        setState(128);
        pitch();
        }
        break;
      case T__10:
        {
        setState(129);
        rest();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(133);
      _la = _input.LA(1);
      if (_la==T__11 || _la==DIGIT) {
        {
        setState(132);
        note_length();
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

  public static class PitchContext extends ParserRuleContext {
    public TerminalNode BASENOTE() { return getToken(MusicParser.BASENOTE, 0); }
    public AccidentalContext accidental() {
      return getRuleContext(AccidentalContext.class,0);
    }
    public OctaveContext octave() {
      return getRuleContext(OctaveContext.class,0);
    }
    public PitchContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_pitch; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPitch(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPitch(this);
    }
  }

  public final PitchContext pitch() throws RecognitionException {
    PitchContext _localctx = new PitchContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_pitch);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(136);
      _la = _input.LA(1);
      if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SHARP) | (1L << FLAT) | (1L << NATURAL))) != 0)) {
        {
        setState(135);
        accidental();
        }
      }

      setState(138);
      match(BASENOTE);
      setState(140);
      _la = _input.LA(1);
      if (_la==OCTAVE_UP || _la==OCTAVE_DOWN) {
        {
        setState(139);
        octave();
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

  public static class RestContext extends ParserRuleContext {
    public RestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_rest; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterRest(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitRest(this);
    }
  }

  public final RestContext rest() throws RecognitionException {
    RestContext _localctx = new RestContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_rest);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(142);
      match(T__10);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Note_lengthContext extends ParserRuleContext {
    public List<TerminalNode> DIGIT() { return getTokens(MusicParser.DIGIT); }
    public TerminalNode DIGIT(int i) {
      return getToken(MusicParser.DIGIT, i);
    }
    public Note_lengthContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note_length; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterNote_length(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitNote_length(this);
    }
  }

  public final Note_lengthContext note_length() throws RecognitionException {
    Note_lengthContext _localctx = new Note_lengthContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_note_length);
    int _la;
    try {
      setState(164);
      switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
      case 1:
        enterOuterAlt(_localctx, 1);
        {
        {
        setState(149);
        _la = _input.LA(1);
        if (_la==DIGIT) {
          {
          setState(145); 
          _errHandler.sync(this);
          _la = _input.LA(1);
          do {
            {
            {
            setState(144);
            match(DIGIT);
            }
            }
            setState(147); 
            _errHandler.sync(this);
            _la = _input.LA(1);
          } while ( _la==DIGIT );
          }
        }

        setState(151);
        match(T__11);
        setState(157);
        _la = _input.LA(1);
        if (_la==DIGIT) {
          {
          setState(153); 
          _errHandler.sync(this);
          _la = _input.LA(1);
          do {
            {
            {
            setState(152);
            match(DIGIT);
            }
            }
            setState(155); 
            _errHandler.sync(this);
            _la = _input.LA(1);
          } while ( _la==DIGIT );
          }
        }

        }
        }
        break;
      case 2:
        enterOuterAlt(_localctx, 2);
        {
        setState(160); 
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
          {
          setState(159);
          match(DIGIT);
          }
          }
          setState(162); 
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ( _la==DIGIT );
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

  public static class Tuplet_elementContext extends ParserRuleContext {
    public Tuplet_specContext tuplet_spec() {
      return getRuleContext(Tuplet_specContext.class,0);
    }
    public List<Note_elementContext> note_element() {
      return getRuleContexts(Note_elementContext.class);
    }
    public Note_elementContext note_element(int i) {
      return getRuleContext(Note_elementContext.class,i);
    }
    public Tuplet_elementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tuplet_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterTuplet_element(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitTuplet_element(this);
    }
  }

  public final Tuplet_elementContext tuplet_element() throws RecognitionException {
    Tuplet_elementContext _localctx = new Tuplet_elementContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_tuplet_element);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(166);
      tuplet_spec();
      setState(168); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          {
          setState(167);
          note_element();
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(170); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

  public static class Tuplet_specContext extends ParserRuleContext {
    public TerminalNode DIGIT() { return getToken(MusicParser.DIGIT, 0); }
    public Tuplet_specContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tuplet_spec; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterTuplet_spec(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitTuplet_spec(this);
    }
  }

  public final Tuplet_specContext tuplet_spec() throws RecognitionException {
    Tuplet_specContext _localctx = new Tuplet_specContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_tuplet_spec);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(172);
      match(T__12);
      setState(173);
      match(DIGIT);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class CommentContext extends ParserRuleContext {
    public List<TerminalNode> NEWLINE() { return getTokens(MusicParser.NEWLINE); }
    public TerminalNode NEWLINE(int i) {
      return getToken(MusicParser.NEWLINE, i);
    }
    public CommentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_comment; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterComment(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitComment(this);
    }
  }

  public final CommentContext comment() throws RecognitionException {
    CommentContext _localctx = new CommentContext(_ctx, getState());
    enterRule(_localctx, 36, RULE_comment);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(175);
      match(T__13);
      setState(179);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << SHARP) | (1L << FLAT) | (1L << NATURAL) | (1L << OCTAVE_UP) | (1L << OCTAVE_DOWN) | (1L << BASENOTE) | (1L << WHITESPACE) | (1L << DIGIT))) != 0)) {
        {
        {
        setState(176);
        _la = _input.LA(1);
        if ( _la <= 0 || (_la==NEWLINE) ) {
        _errHandler.recoverInline(this);
        } else {
          consume();
        }
        }
        }
        setState(181);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(182);
      match(NEWLINE);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class AccidentalContext extends ParserRuleContext {
    public TerminalNode SHARP() { return getToken(MusicParser.SHARP, 0); }
    public TerminalNode FLAT() { return getToken(MusicParser.FLAT, 0); }
    public TerminalNode NATURAL() { return getToken(MusicParser.NATURAL, 0); }
    public AccidentalContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_accidental; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterAccidental(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitAccidental(this);
    }
  }

  public final AccidentalContext accidental() throws RecognitionException {
    AccidentalContext _localctx = new AccidentalContext(_ctx, getState());
    enterRule(_localctx, 38, RULE_accidental);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(184);
      _la = _input.LA(1);
      if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SHARP) | (1L << FLAT) | (1L << NATURAL))) != 0)) ) {
      _errHandler.recoverInline(this);
      } else {
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

  public static class OctaveContext extends ParserRuleContext {
    public TerminalNode OCTAVE_UP() { return getToken(MusicParser.OCTAVE_UP, 0); }
    public TerminalNode OCTAVE_DOWN() { return getToken(MusicParser.OCTAVE_DOWN, 0); }
    public OctaveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_octave; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterOctave(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitOctave(this);
    }
  }

  public final OctaveContext octave() throws RecognitionException {
    OctaveContext _localctx = new OctaveContext(_ctx, getState());
    enterRule(_localctx, 40, RULE_octave);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(186);
      _la = _input.LA(1);
      if ( !(_la==OCTAVE_UP || _la==OCTAVE_DOWN) ) {
      _errHandler.recoverInline(this);
      } else {
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

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u00bf\4\2\t"+
      "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
      "\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
      "\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3"+
      "\5\3\61\n\3\3\3\6\3\64\n\3\r\3\16\3\65\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
      ">\n\4\3\5\3\5\7\5B\n\5\f\5\16\5E\13\5\3\5\3\5\3\6\3\6\7\6K\n\6\f\6"+
      "\16\6N\13\6\3\6\5\6Q\n\6\3\7\6\7T\n\7\r\7\16\7U\3\7\3\7\5\7Z\n\7\3"+
      "\b\6\b]\n\b\r\b\16\b^\3\b\3\b\3\t\3\t\6\te\n\t\r\t\16\tf\3\t\3\t\3"+
      "\n\6\nl\n\n\r\n\16\nm\3\n\3\n\3\13\3\13\3\13\5\13u\n\13\3\f\3\f\5"+
      "\fy\n\f\3\r\3\r\6\r}\n\r\r\r\16\r~\3\r\3\r\3\16\3\16\5\16\u0085\n"+
      "\16\3\16\5\16\u0088\n\16\3\17\5\17\u008b\n\17\3\17\3\17\5\17\u008f"+
      "\n\17\3\20\3\20\3\21\6\21\u0094\n\21\r\21\16\21\u0095\5\21\u0098\n"+
      "\21\3\21\3\21\6\21\u009c\n\21\r\21\16\21\u009d\5\21\u00a0\n\21\3\21"+
      "\6\21\u00a3\n\21\r\21\16\21\u00a4\5\21\u00a7\n\21\3\22\3\22\6\22\u00ab"+
      "\n\22\r\22\16\22\u00ac\3\23\3\23\3\23\3\24\3\24\7\24\u00b4\n\24\f"+
      "\24\16\24\u00b7\13\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\2\2\27\2"+
      "\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\7\3\2\6\b\4\2\3\3\n"+
      "\n\3\2\27\27\3\2\21\23\3\2\24\25\u00c8\2,\3\2\2\2\4\60\3\2\2\2\6="+
      "\3\2\2\2\b?\3\2\2\2\nH\3\2\2\2\fS\3\2\2\2\16\\\3\2\2\2\20b\3\2\2\2"+
      "\22k\3\2\2\2\24t\3\2\2\2\26x\3\2\2\2\30z\3\2\2\2\32\u0084\3\2\2\2"+
      "\34\u008a\3\2\2\2\36\u0090\3\2\2\2 \u00a6\3\2\2\2\"\u00a8\3\2\2\2"+
      "$\u00ae\3\2\2\2&\u00b1\3\2\2\2(\u00ba\3\2\2\2*\u00bc\3\2\2\2,-\5\4"+
      "\3\2-.\7\2\2\3.\3\3\2\2\2/\61\7\3\2\2\60/\3\2\2\2\60\61\3\2\2\2\61"+
      "\63\3\2\2\2\62\64\5\6\4\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2"+
      "\2\65\66\3\2\2\2\66\5\3\2\2\2\67>\5\f\7\28>\5\20\t\29>\5\16\b\2:>"+
      "\5\b\5\2;>\5\n\6\2<>\5\22\n\2=\67\3\2\2\2=8\3\2\2\2=9\3\2\2\2=:\3"+
      "\2\2\2=;\3\2\2\2=<\3\2\2\2>\7\3\2\2\2?C\7\4\2\2@B\5\f\7\2A@\3\2\2"+
      "\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\5\22\n\2G\t"+
      "\3\2\2\2HL\7\5\2\2IK\5\f\7\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2"+
      "\2MP\3\2\2\2NL\3\2\2\2OQ\5\16\b\2PO\3\2\2\2PQ\3\2\2\2Q\13\3\2\2\2"+
      "RT\5\24\13\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VY\3\2\2\2WZ\7"+
      "\3\2\2XZ\5\20\t\2YW\3\2\2\2YX\3\2\2\2Z\r\3\2\2\2[]\5\24\13\2\\[\3"+
      "\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\t\2\2\2a\17\3\2"+
      "\2\2bd\7\t\2\2ce\5\24\13\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2"+
      "gh\3\2\2\2hi\t\3\2\2i\21\3\2\2\2jl\5\24\13\2kj\3\2\2\2lm\3\2\2\2m"+
      "k\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\n\2\2p\23\3\2\2\2qu\5\26\f\2ru\5"+
      "\"\22\2su\7\30\2\2tq\3\2\2\2tr\3\2\2\2ts\3\2\2\2u\25\3\2\2\2vy\5\32"+
      "\16\2wy\5\30\r\2xv\3\2\2\2xw\3\2\2\2y\27\3\2\2\2z|\7\13\2\2{}\5\32"+
      "\16\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2"+
      "\u0080\u0081\7\f\2\2\u0081\31\3\2\2\2\u0082\u0085\5\34\17\2\u0083"+
      "\u0085\5\36\20\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u0087"+
      "\3\2\2\2\u0086\u0088\5 \21\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2"+
      "\2\u0088\33\3\2\2\2\u0089\u008b\5(\25\2\u008a\u0089\3\2\2\2\u008a"+
      "\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\7\26\2\2\u008d\u008f"+
      "\5*\26\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\35\3\2\2\2"+
      "\u0090\u0091\7\r\2\2\u0091\37\3\2\2\2\u0092\u0094\7\31\2\2\u0093\u0092"+
      "\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2"+
      "\2\u0096\u0098\3\2\2\2\u0097\u0093\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
      "\u0099\3\2\2\2\u0099\u009f\7\16\2\2\u009a\u009c\7\31\2\2\u009b\u009a"+
      "\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2"+
      "\2\u009e\u00a0\3\2\2\2\u009f\u009b\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
      "\u00a7\3\2\2\2\u00a1\u00a3\7\31\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4"+
      "\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2\2"+
      "\2\u00a6\u0097\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a7!\3\2\2\2\u00a8\u00aa"+
      "\5$\23\2\u00a9\u00ab\5\26\f\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
      "\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad#\3\2\2\2\u00ae"+
      "\u00af\7\17\2\2\u00af\u00b0\7\31\2\2\u00b0%\3\2\2\2\u00b1\u00b5\7"+
      "\20\2\2\u00b2\u00b4\n\4\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2"+
      "\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7"+
      "\u00b5\3\2\2\2\u00b8\u00b9\7\27\2\2\u00b9\'\3\2\2\2\u00ba\u00bb\t"+
      "\5\2\2\u00bb)\3\2\2\2\u00bc\u00bd\t\6\2\2\u00bd+\3\2\2\2\34\60\65"+
      "=CLPUY^fmtx~\u0084\u0087\u008a\u008e\u0095\u0097\u009d\u009f\u00a4"+
      "\u00a6\u00ac\u00b5";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}