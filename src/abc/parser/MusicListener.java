// Generated from Music.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MusicParser}.
 */
public interface MusicListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link MusicParser#root}.
   * @param ctx the parse tree
   */
  void enterRoot(MusicParser.RootContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#root}.
   * @param ctx the parse tree
   */
  void exitRoot(MusicParser.RootContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#music}.
   * @param ctx the parse tree
   */
  void enterMusic(MusicParser.MusicContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#music}.
   * @param ctx the parse tree
   */
  void exitMusic(MusicParser.MusicContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#measure}.
   * @param ctx the parse tree
   */
  void enterMeasure(MusicParser.MeasureContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#measure}.
   * @param ctx the parse tree
   */
  void exitMeasure(MusicParser.MeasureContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#first_ending}.
   * @param ctx the parse tree
   */
  void enterFirst_ending(MusicParser.First_endingContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#first_ending}.
   * @param ctx the parse tree
   */
  void exitFirst_ending(MusicParser.First_endingContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#second_ending}.
   * @param ctx the parse tree
   */
  void enterSecond_ending(MusicParser.Second_endingContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#second_ending}.
   * @param ctx the parse tree
   */
  void exitSecond_ending(MusicParser.Second_endingContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#normal_measure}.
   * @param ctx the parse tree
   */
  void enterNormal_measure(MusicParser.Normal_measureContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#normal_measure}.
   * @param ctx the parse tree
   */
  void exitNormal_measure(MusicParser.Normal_measureContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#double_bar}.
   * @param ctx the parse tree
   */
  void enterDouble_bar(MusicParser.Double_barContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#double_bar}.
   * @param ctx the parse tree
   */
  void exitDouble_bar(MusicParser.Double_barContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#start_repeat}.
   * @param ctx the parse tree
   */
  void enterStart_repeat(MusicParser.Start_repeatContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#start_repeat}.
   * @param ctx the parse tree
   */
  void exitStart_repeat(MusicParser.Start_repeatContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#end_repeat}.
   * @param ctx the parse tree
   */
  void enterEnd_repeat(MusicParser.End_repeatContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#end_repeat}.
   * @param ctx the parse tree
   */
  void exitEnd_repeat(MusicParser.End_repeatContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#element}.
   * @param ctx the parse tree
   */
  void enterElement(MusicParser.ElementContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#element}.
   * @param ctx the parse tree
   */
  void exitElement(MusicParser.ElementContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#note_element}.
   * @param ctx the parse tree
   */
  void enterNote_element(MusicParser.Note_elementContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#note_element}.
   * @param ctx the parse tree
   */
  void exitNote_element(MusicParser.Note_elementContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#multi_note}.
   * @param ctx the parse tree
   */
  void enterMulti_note(MusicParser.Multi_noteContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#multi_note}.
   * @param ctx the parse tree
   */
  void exitMulti_note(MusicParser.Multi_noteContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#note}.
   * @param ctx the parse tree
   */
  void enterNote(MusicParser.NoteContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#note}.
   * @param ctx the parse tree
   */
  void exitNote(MusicParser.NoteContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#pitch}.
   * @param ctx the parse tree
   */
  void enterPitch(MusicParser.PitchContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#pitch}.
   * @param ctx the parse tree
   */
  void exitPitch(MusicParser.PitchContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#rest}.
   * @param ctx the parse tree
   */
  void enterRest(MusicParser.RestContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#rest}.
   * @param ctx the parse tree
   */
  void exitRest(MusicParser.RestContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#note_length}.
   * @param ctx the parse tree
   */
  void enterNote_length(MusicParser.Note_lengthContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#note_length}.
   * @param ctx the parse tree
   */
  void exitNote_length(MusicParser.Note_lengthContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#tuplet_element}.
   * @param ctx the parse tree
   */
  void enterTuplet_element(MusicParser.Tuplet_elementContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#tuplet_element}.
   * @param ctx the parse tree
   */
  void exitTuplet_element(MusicParser.Tuplet_elementContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#tuplet_spec}.
   * @param ctx the parse tree
   */
  void enterTuplet_spec(MusicParser.Tuplet_specContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#tuplet_spec}.
   * @param ctx the parse tree
   */
  void exitTuplet_spec(MusicParser.Tuplet_specContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#comment}.
   * @param ctx the parse tree
   */
  void enterComment(MusicParser.CommentContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#comment}.
   * @param ctx the parse tree
   */
  void exitComment(MusicParser.CommentContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#accidental}.
   * @param ctx the parse tree
   */
  void enterAccidental(MusicParser.AccidentalContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#accidental}.
   * @param ctx the parse tree
   */
  void exitAccidental(MusicParser.AccidentalContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#octave}.
   * @param ctx the parse tree
   */
  void enterOctave(MusicParser.OctaveContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#octave}.
   * @param ctx the parse tree
   */
  void exitOctave(MusicParser.OctaveContext ctx);
}