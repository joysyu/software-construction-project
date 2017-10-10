// Generated from Music.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MusicLexer extends Lexer {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, SHARP=15, FLAT=16, 
    NATURAL=17, OCTAVE_UP=18, OCTAVE_DOWN=19, BASENOTE=20, NEWLINE=21, WHITESPACE=22, 
    DIGIT=23;
  public static String[] modeNames = {
    "DEFAULT_MODE"
  };

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
    "T__9", "T__10", "T__11", "T__12", "T__13", "SHARP", "FLAT", "NATURAL", 
    "OCTAVE_UP", "OCTAVE_DOWN", "BASENOTE", "NEWLINE", "WHITESPACE", "DIGIT"
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


  public MusicLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }

  @Override
  public String getGrammarFileName() { return "Music.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public String[] getModeNames() { return modeNames; }

  @Override
  public ATN getATN() { return _ATN; }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31u\b\1\4\2\t\2"+
      "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
      "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"+
      "\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t"+
      "\30\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3"+
      "\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
      "\16\3\16\3\17\3\17\3\20\3\20\3\20\5\20X\n\20\3\21\3\21\3\21\5\21]"+
      "\n\21\3\22\3\22\3\23\6\23b\n\23\r\23\16\23c\3\24\6\24g\n\24\r\24\16"+
      "\24h\3\25\3\25\3\26\5\26n\n\26\3\26\3\26\3\27\3\27\3\30\3\30\2\2\31"+
      "\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
      "\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\3\2\7\4\2CIci\3\2\17\17"+
      "\3\2\f\f\4\2\13\13\"\"\3\2\62;y\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
      "\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
      "\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
      "\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
      "\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5"+
      "\63\3\2\2\2\7\66\3\2\2\2\t9\3\2\2\2\13<\3\2\2\2\r?\3\2\2\2\17B\3\2"+
      "\2\2\21E\3\2\2\2\23H\3\2\2\2\25J\3\2\2\2\27L\3\2\2\2\31N\3\2\2\2\33"+
      "P\3\2\2\2\35R\3\2\2\2\37W\3\2\2\2!\\\3\2\2\2#^\3\2\2\2%a\3\2\2\2\'"+
      "f\3\2\2\2)j\3\2\2\2+m\3\2\2\2-q\3\2\2\2/s\3\2\2\2\61\62\7~\2\2\62"+
      "\4\3\2\2\2\63\64\7]\2\2\64\65\7\63\2\2\65\6\3\2\2\2\66\67\7]\2\2\67"+
      "8\7\64\2\28\b\3\2\2\29:\7~\2\2:;\7~\2\2;\n\3\2\2\2<=\7]\2\2=>\7~\2"+
      "\2>\f\3\2\2\2?@\7~\2\2@A\7_\2\2A\16\3\2\2\2BC\7~\2\2CD\7<\2\2D\20"+
      "\3\2\2\2EF\7<\2\2FG\7~\2\2G\22\3\2\2\2HI\7]\2\2I\24\3\2\2\2JK\7_\2"+
      "\2K\26\3\2\2\2LM\7|\2\2M\30\3\2\2\2NO\7\61\2\2O\32\3\2\2\2PQ\7*\2"+
      "\2Q\34\3\2\2\2RS\7\'\2\2S\36\3\2\2\2TX\7`\2\2UV\7`\2\2VX\7`\2\2WT"+
      "\3\2\2\2WU\3\2\2\2X \3\2\2\2Y]\7a\2\2Z[\7a\2\2[]\7a\2\2\\Y\3\2\2\2"+
      "\\Z\3\2\2\2]\"\3\2\2\2^_\7?\2\2_$\3\2\2\2`b\7)\2\2a`\3\2\2\2bc\3\2"+
      "\2\2ca\3\2\2\2cd\3\2\2\2d&\3\2\2\2eg\7.\2\2fe\3\2\2\2gh\3\2\2\2hf"+
      "\3\2\2\2hi\3\2\2\2i(\3\2\2\2jk\t\2\2\2k*\3\2\2\2ln\t\3\2\2ml\3\2\2"+
      "\2mn\3\2\2\2no\3\2\2\2op\t\4\2\2p,\3\2\2\2qr\t\5\2\2r.\3\2\2\2st\t"+
      "\6\2\2t\60\3\2\2\2\b\2W\\chm\2";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}