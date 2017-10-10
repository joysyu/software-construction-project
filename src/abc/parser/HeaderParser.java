// Generated from Header.g4 by ANTLR 4.5.1

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
public class HeaderParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, T__11=12, CNOTE=13, BASENOTE=14, KEY_ACCIDENTAL=15, 
    MODE_MINOR=16, NEWLINE=17, LETTER=18, SIGN=19, DIGIT=20;
  public static final int
    RULE_header = 0, RULE_field_number = 1, RULE_field_title = 2, RULE_other_fields = 3, 
    RULE_field_composer = 4, RULE_field_default_length = 5, RULE_field_meter = 6, 
    RULE_field_tempo = 7, RULE_field_key = 8, RULE_field_voice = 9, RULE_key = 10, 
    RULE_keynote = 11, RULE_note_length_strict = 12, RULE_meter = 13, RULE_meter_fraction = 14, 
    RULE_tempo = 15, RULE_text = 16, RULE_number = 17;
  public static final String[] ruleNames = {
    "header", "field_number", "field_title", "other_fields", "field_composer", 
    "field_default_length", "field_meter", "field_tempo", "field_key", "field_voice", 
    "key", "keynote", "note_length_strict", "meter", "meter_fraction", "tempo", 
    "text", "number"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'X:'", "' '", "'T:'", "'C:'", "'L:'", "'M:'", "'Q:'", "'K:'", 
    "'V:'", "'/'", "'C|'", "'='", "'C'", null, null, "'m'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, null, null, null, null, null, null, 
    null, "CNOTE", "BASENOTE", "KEY_ACCIDENTAL", "MODE_MINOR", "NEWLINE", 
    "LETTER", "SIGN", "DIGIT"
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
  public String getGrammarFileName() { return "Header.g4"; }

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

  public HeaderParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class HeaderContext extends ParserRuleContext {
    public Field_numberContext field_number() {
      return getRuleContext(Field_numberContext.class,0);
    }
    public Field_titleContext field_title() {
      return getRuleContext(Field_titleContext.class,0);
    }
    public Field_keyContext field_key() {
      return getRuleContext(Field_keyContext.class,0);
    }
    public TerminalNode EOF() { return getToken(HeaderParser.EOF, 0); }
    public List<Other_fieldsContext> other_fields() {
      return getRuleContexts(Other_fieldsContext.class);
    }
    public Other_fieldsContext other_fields(int i) {
      return getRuleContext(Other_fieldsContext.class,i);
    }
    public HeaderContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_header; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterHeader(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitHeader(this);
    }
  }

  public final HeaderContext header() throws RecognitionException {
    HeaderContext _localctx = new HeaderContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_header);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(36);
      field_number();
      setState(37);
      field_title();
      setState(41);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8))) != 0)) {
        {
        {
        setState(38);
        other_fields();
        }
        }
        setState(43);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(44);
      field_key();
      setState(45);
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

  public static class Field_numberContext extends ParserRuleContext {
    public NumberContext number() {
      return getRuleContext(NumberContext.class,0);
    }
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public Field_numberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_number; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_number(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_number(this);
    }
  }

  public final Field_numberContext field_number() throws RecognitionException {
    Field_numberContext _localctx = new Field_numberContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_field_number);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(47);
      match(T__0);
      setState(51);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==T__1) {
        {
        {
        setState(48);
        match(T__1);
        }
        }
        setState(53);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(54);
      number();
      setState(55);
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

  public static class Field_titleContext extends ParserRuleContext {
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public List<TextContext> text() {
      return getRuleContexts(TextContext.class);
    }
    public TextContext text(int i) {
      return getRuleContext(TextContext.class,i);
    }
    public Field_titleContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_title; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_title(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_title(this);
    }
  }

  public final Field_titleContext field_title() throws RecognitionException {
    Field_titleContext _localctx = new Field_titleContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_field_title);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(57);
      match(T__2);
      setState(62); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(58);
        text();
        setState(60);
        _la = _input.LA(1);
        if (_la==T__1) {
          {
          setState(59);
          match(T__1);
          }
        }

        }
        }
        setState(64); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CNOTE) | (1L << BASENOTE) | (1L << KEY_ACCIDENTAL) | (1L << MODE_MINOR) | (1L << LETTER) | (1L << SIGN) | (1L << DIGIT))) != 0) );
      setState(66);
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

  public static class Other_fieldsContext extends ParserRuleContext {
    public Field_composerContext field_composer() {
      return getRuleContext(Field_composerContext.class,0);
    }
    public Field_default_lengthContext field_default_length() {
      return getRuleContext(Field_default_lengthContext.class,0);
    }
    public Field_meterContext field_meter() {
      return getRuleContext(Field_meterContext.class,0);
    }
    public Field_tempoContext field_tempo() {
      return getRuleContext(Field_tempoContext.class,0);
    }
    public Field_voiceContext field_voice() {
      return getRuleContext(Field_voiceContext.class,0);
    }
    public Other_fieldsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_other_fields; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterOther_fields(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitOther_fields(this);
    }
  }

  public final Other_fieldsContext other_fields() throws RecognitionException {
    Other_fieldsContext _localctx = new Other_fieldsContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_other_fields);
    try {
      setState(73);
      switch (_input.LA(1)) {
      case T__3:
        enterOuterAlt(_localctx, 1);
        {
        setState(68);
        field_composer();
        }
        break;
      case T__4:
        enterOuterAlt(_localctx, 2);
        {
        setState(69);
        field_default_length();
        }
        break;
      case T__5:
        enterOuterAlt(_localctx, 3);
        {
        setState(70);
        field_meter();
        }
        break;
      case T__6:
        enterOuterAlt(_localctx, 4);
        {
        setState(71);
        field_tempo();
        }
        break;
      case T__8:
        enterOuterAlt(_localctx, 5);
        {
        setState(72);
        field_voice();
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

  public static class Field_composerContext extends ParserRuleContext {
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public List<TextContext> text() {
      return getRuleContexts(TextContext.class);
    }
    public TextContext text(int i) {
      return getRuleContext(TextContext.class,i);
    }
    public Field_composerContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_composer; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_composer(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_composer(this);
    }
  }

  public final Field_composerContext field_composer() throws RecognitionException {
    Field_composerContext _localctx = new Field_composerContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_field_composer);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(75);
      match(T__3);
      setState(80); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(76);
        text();
        setState(78);
        _la = _input.LA(1);
        if (_la==T__1) {
          {
          setState(77);
          match(T__1);
          }
        }

        }
        }
        setState(82); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CNOTE) | (1L << BASENOTE) | (1L << KEY_ACCIDENTAL) | (1L << MODE_MINOR) | (1L << LETTER) | (1L << SIGN) | (1L << DIGIT))) != 0) );
      setState(84);
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

  public static class Field_default_lengthContext extends ParserRuleContext {
    public Note_length_strictContext note_length_strict() {
      return getRuleContext(Note_length_strictContext.class,0);
    }
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public Field_default_lengthContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_default_length; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_default_length(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_default_length(this);
    }
  }

  public final Field_default_lengthContext field_default_length() throws RecognitionException {
    Field_default_lengthContext _localctx = new Field_default_lengthContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_field_default_length);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(86);
      match(T__4);
      setState(90);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==T__1) {
        {
        {
        setState(87);
        match(T__1);
        }
        }
        setState(92);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(93);
      note_length_strict();
      setState(94);
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

  public static class Field_meterContext extends ParserRuleContext {
    public MeterContext meter() {
      return getRuleContext(MeterContext.class,0);
    }
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public Field_meterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_meter; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_meter(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_meter(this);
    }
  }

  public final Field_meterContext field_meter() throws RecognitionException {
    Field_meterContext _localctx = new Field_meterContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_field_meter);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(96);
      match(T__5);
      setState(100);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==T__1) {
        {
        {
        setState(97);
        match(T__1);
        }
        }
        setState(102);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(103);
      meter();
      setState(104);
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

  public static class Field_tempoContext extends ParserRuleContext {
    public TempoContext tempo() {
      return getRuleContext(TempoContext.class,0);
    }
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public Field_tempoContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_tempo; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_tempo(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_tempo(this);
    }
  }

  public final Field_tempoContext field_tempo() throws RecognitionException {
    Field_tempoContext _localctx = new Field_tempoContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_field_tempo);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(106);
      match(T__6);
      setState(110);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==T__1) {
        {
        {
        setState(107);
        match(T__1);
        }
        }
        setState(112);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(113);
      tempo();
      setState(114);
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

  public static class Field_keyContext extends ParserRuleContext {
    public KeyContext key() {
      return getRuleContext(KeyContext.class,0);
    }
    public Field_keyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_key; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_key(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_key(this);
    }
  }

  public final Field_keyContext field_key() throws RecognitionException {
    Field_keyContext _localctx = new Field_keyContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_field_key);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(116);
      match(T__7);
      setState(120);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==T__1) {
        {
        {
        setState(117);
        match(T__1);
        }
        }
        setState(122);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(123);
      key();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Field_voiceContext extends ParserRuleContext {
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public List<TextContext> text() {
      return getRuleContexts(TextContext.class);
    }
    public TextContext text(int i) {
      return getRuleContext(TextContext.class,i);
    }
    public Field_voiceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_field_voice; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterField_voice(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitField_voice(this);
    }
  }

  public final Field_voiceContext field_voice() throws RecognitionException {
    Field_voiceContext _localctx = new Field_voiceContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_field_voice);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(125);
      match(T__8);
      setState(130); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(126);
        text();
        setState(128);
        _la = _input.LA(1);
        if (_la==T__1) {
          {
          setState(127);
          match(T__1);
          }
        }

        }
        }
        setState(132); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CNOTE) | (1L << BASENOTE) | (1L << KEY_ACCIDENTAL) | (1L << MODE_MINOR) | (1L << LETTER) | (1L << SIGN) | (1L << DIGIT))) != 0) );
      setState(134);
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

  public static class KeyContext extends ParserRuleContext {
    public KeynoteContext keynote() {
      return getRuleContext(KeynoteContext.class,0);
    }
    public TerminalNode MODE_MINOR() { return getToken(HeaderParser.MODE_MINOR, 0); }
    public KeyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_key; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterKey(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitKey(this);
    }
  }

  public final KeyContext key() throws RecognitionException {
    KeyContext _localctx = new KeyContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_key);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(136);
      keynote();
      setState(138);
      _la = _input.LA(1);
      if (_la==MODE_MINOR) {
        {
        setState(137);
        match(MODE_MINOR);
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

  public static class KeynoteContext extends ParserRuleContext {
    public TerminalNode BASENOTE() { return getToken(HeaderParser.BASENOTE, 0); }
    public TerminalNode CNOTE() { return getToken(HeaderParser.CNOTE, 0); }
    public TerminalNode KEY_ACCIDENTAL() { return getToken(HeaderParser.KEY_ACCIDENTAL, 0); }
    public KeynoteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_keynote; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterKeynote(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitKeynote(this);
    }
  }

  public final KeynoteContext keynote() throws RecognitionException {
    KeynoteContext _localctx = new KeynoteContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_keynote);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(140);
      _la = _input.LA(1);
      if ( !(_la==CNOTE || _la==BASENOTE) ) {
      _errHandler.recoverInline(this);
      } else {
        consume();
      }
      setState(142);
      _la = _input.LA(1);
      if (_la==KEY_ACCIDENTAL) {
        {
        setState(141);
        match(KEY_ACCIDENTAL);
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

  public static class Note_length_strictContext extends ParserRuleContext {
    public List<NumberContext> number() {
      return getRuleContexts(NumberContext.class);
    }
    public NumberContext number(int i) {
      return getRuleContext(NumberContext.class,i);
    }
    public Note_length_strictContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note_length_strict; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterNote_length_strict(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitNote_length_strict(this);
    }
  }

  public final Note_length_strictContext note_length_strict() throws RecognitionException {
    Note_length_strictContext _localctx = new Note_length_strictContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_note_length_strict);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(144);
      number();
      setState(145);
      match(T__9);
      setState(146);
      number();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class MeterContext extends ParserRuleContext {
    public Meter_fractionContext meter_fraction() {
      return getRuleContext(Meter_fractionContext.class,0);
    }
    public MeterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_meter; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterMeter(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitMeter(this);
    }
  }

  public final MeterContext meter() throws RecognitionException {
    MeterContext _localctx = new MeterContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_meter);
    try {
      setState(151);
      switch (_input.LA(1)) {
      case CNOTE:
        enterOuterAlt(_localctx, 1);
        {
        setState(148);
        match(CNOTE);
        }
        break;
      case T__10:
        enterOuterAlt(_localctx, 2);
        {
        setState(149);
        match(T__10);
        }
        break;
      case DIGIT:
        enterOuterAlt(_localctx, 3);
        {
        setState(150);
        meter_fraction();
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

  public static class Meter_fractionContext extends ParserRuleContext {
    public List<NumberContext> number() {
      return getRuleContexts(NumberContext.class);
    }
    public NumberContext number(int i) {
      return getRuleContext(NumberContext.class,i);
    }
    public Meter_fractionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_meter_fraction; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterMeter_fraction(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitMeter_fraction(this);
    }
  }

  public final Meter_fractionContext meter_fraction() throws RecognitionException {
    Meter_fractionContext _localctx = new Meter_fractionContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_meter_fraction);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(153);
      number();
      setState(154);
      match(T__9);
      setState(155);
      number();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class TempoContext extends ParserRuleContext {
    public Meter_fractionContext meter_fraction() {
      return getRuleContext(Meter_fractionContext.class,0);
    }
    public NumberContext number() {
      return getRuleContext(NumberContext.class,0);
    }
    public TempoContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tempo; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterTempo(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitTempo(this);
    }
  }

  public final TempoContext tempo() throws RecognitionException {
    TempoContext _localctx = new TempoContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_tempo);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(157);
      meter_fraction();
      setState(158);
      match(T__11);
      setState(159);
      number();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class TextContext extends ParserRuleContext {
    public TerminalNode LETTER() { return getToken(HeaderParser.LETTER, 0); }
    public TerminalNode BASENOTE() { return getToken(HeaderParser.BASENOTE, 0); }
    public TerminalNode MODE_MINOR() { return getToken(HeaderParser.MODE_MINOR, 0); }
    public TerminalNode KEY_ACCIDENTAL() { return getToken(HeaderParser.KEY_ACCIDENTAL, 0); }
    public TerminalNode SIGN() { return getToken(HeaderParser.SIGN, 0); }
    public TerminalNode CNOTE() { return getToken(HeaderParser.CNOTE, 0); }
    public TerminalNode DIGIT() { return getToken(HeaderParser.DIGIT, 0); }
    public TextContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_text; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterText(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitText(this);
    }
  }

  public final TextContext text() throws RecognitionException {
    TextContext _localctx = new TextContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_text);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(161);
      _la = _input.LA(1);
      if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CNOTE) | (1L << BASENOTE) | (1L << KEY_ACCIDENTAL) | (1L << MODE_MINOR) | (1L << LETTER) | (1L << SIGN) | (1L << DIGIT))) != 0)) ) {
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

  public static class NumberContext extends ParserRuleContext {
    public List<TerminalNode> DIGIT() { return getTokens(HeaderParser.DIGIT); }
    public TerminalNode DIGIT(int i) {
      return getToken(HeaderParser.DIGIT, i);
    }
    public NumberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_number; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterNumber(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitNumber(this);
    }
  }

  public final NumberContext number() throws RecognitionException {
    NumberContext _localctx = new NumberContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_number);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(164); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(163);
        match(DIGIT);
        }
        }
        setState(166); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( _la==DIGIT );
      }
    }
    catch (RecognitionException re) {
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
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26\u00ab\4\2\t"+
      "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
      "\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
      "\4\22\t\22\4\23\t\23\3\2\3\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\3"+
      "\2\3\3\3\3\7\3\64\n\3\f\3\16\3\67\13\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4"+
      "?\n\4\6\4A\n\4\r\4\16\4B\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5L\n\5\3\6"+
      "\3\6\3\6\5\6Q\n\6\6\6S\n\6\r\6\16\6T\3\6\3\6\3\7\3\7\7\7[\n\7\f\7"+
      "\16\7^\13\7\3\7\3\7\3\7\3\b\3\b\7\be\n\b\f\b\16\bh\13\b\3\b\3\b\3"+
      "\b\3\t\3\t\7\to\n\t\f\t\16\tr\13\t\3\t\3\t\3\t\3\n\3\n\7\ny\n\n\f"+
      "\n\16\n|\13\n\3\n\3\n\3\13\3\13\3\13\5\13\u0083\n\13\6\13\u0085\n"+
      "\13\r\13\16\13\u0086\3\13\3\13\3\f\3\f\5\f\u008d\n\f\3\r\3\r\5\r\u0091"+
      "\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u009a\n\17\3\20\3\20"+
      "\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\23\6\23\u00a7\n\23\r\23"+
      "\16\23\u00a8\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
      "$\2\4\3\2\17\20\4\2\17\22\24\26\u00ad\2&\3\2\2\2\4\61\3\2\2\2\6;\3"+
      "\2\2\2\bK\3\2\2\2\nM\3\2\2\2\fX\3\2\2\2\16b\3\2\2\2\20l\3\2\2\2\22"+
      "v\3\2\2\2\24\177\3\2\2\2\26\u008a\3\2\2\2\30\u008e\3\2\2\2\32\u0092"+
      "\3\2\2\2\34\u0099\3\2\2\2\36\u009b\3\2\2\2 \u009f\3\2\2\2\"\u00a3"+
      "\3\2\2\2$\u00a6\3\2\2\2&\'\5\4\3\2\'+\5\6\4\2(*\5\b\5\2)(\3\2\2\2"+
      "*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\5\22\n\2/\60"+
      "\7\2\2\3\60\3\3\2\2\2\61\65\7\3\2\2\62\64\7\4\2\2\63\62\3\2\2\2\64"+
      "\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\2"+
      "89\5$\23\29:\7\23\2\2:\5\3\2\2\2;@\7\5\2\2<>\5\"\22\2=?\7\4\2\2>="+
      "\3\2\2\2>?\3\2\2\2?A\3\2\2\2@<\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2"+
      "\2CD\3\2\2\2DE\7\23\2\2E\7\3\2\2\2FL\5\n\6\2GL\5\f\7\2HL\5\16\b\2"+
      "IL\5\20\t\2JL\5\24\13\2KF\3\2\2\2KG\3\2\2\2KH\3\2\2\2KI\3\2\2\2KJ"+
      "\3\2\2\2L\t\3\2\2\2MR\7\6\2\2NP\5\"\22\2OQ\7\4\2\2PO\3\2\2\2PQ\3\2"+
      "\2\2QS\3\2\2\2RN\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2V"+
      "W\7\23\2\2W\13\3\2\2\2X\\\7\7\2\2Y[\7\4\2\2ZY\3\2\2\2[^\3\2\2\2\\"+
      "Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\5\32\16\2`a\7\23\2\2a"+
      "\r\3\2\2\2bf\7\b\2\2ce\7\4\2\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2"+
      "\2\2gi\3\2\2\2hf\3\2\2\2ij\5\34\17\2jk\7\23\2\2k\17\3\2\2\2lp\7\t"+
      "\2\2mo\7\4\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2r"+
      "p\3\2\2\2st\5 \21\2tu\7\23\2\2u\21\3\2\2\2vz\7\n\2\2wy\7\4\2\2xw\3"+
      "\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\5\26\f"+
      "\2~\23\3\2\2\2\177\u0084\7\13\2\2\u0080\u0082\5\"\22\2\u0081\u0083"+
      "\7\4\2\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2"+
      "\2\u0084\u0080\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
      "\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\23\2\2\u0089\25\3"+
      "\2\2\2\u008a\u008c\5\30\r\2\u008b\u008d\7\22\2\2\u008c\u008b\3\2\2"+
      "\2\u008c\u008d\3\2\2\2\u008d\27\3\2\2\2\u008e\u0090\t\2\2\2\u008f"+
      "\u0091\7\21\2\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\31\3"+
      "\2\2\2\u0092\u0093\5$\23\2\u0093\u0094\7\f\2\2\u0094\u0095\5$\23\2"+
      "\u0095\33\3\2\2\2\u0096\u009a\7\17\2\2\u0097\u009a\7\r\2\2\u0098\u009a"+
      "\5\36\20\2\u0099\u0096\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u0098\3\2"+
      "\2\2\u009a\35\3\2\2\2\u009b\u009c\5$\23\2\u009c\u009d\7\f\2\2\u009d"+
      "\u009e\5$\23\2\u009e\37\3\2\2\2\u009f\u00a0\5\36\20\2\u00a0\u00a1"+
      "\7\16\2\2\u00a1\u00a2\5$\23\2\u00a2!\3\2\2\2\u00a3\u00a4\t\3\2\2\u00a4"+
      "#\3\2\2\2\u00a5\u00a7\7\26\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2"+
      "\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9%\3\2\2\2\23+\65"+
      ">BKPT\\fpz\u0082\u0086\u008c\u0090\u0099\u00a8";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}