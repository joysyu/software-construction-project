package abc.sound;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import abc.parser.MusicListener;
import abc.parser.MusicParser.AccidentalContext;
import abc.parser.MusicParser.CommentContext;
import abc.parser.MusicParser.Double_barContext;
import abc.parser.MusicParser.ElementContext;
import abc.parser.MusicParser.End_repeatContext;
import abc.parser.MusicParser.First_endingContext;
import abc.parser.MusicParser.MeasureContext;
import abc.parser.MusicParser.Multi_noteContext;
import abc.parser.MusicParser.MusicContext;
import abc.parser.MusicParser.Normal_measureContext;
import abc.parser.MusicParser.NoteContext;
import abc.parser.MusicParser.Note_elementContext;
import abc.parser.MusicParser.Note_lengthContext;
import abc.parser.MusicParser.OctaveContext;
import abc.parser.MusicParser.PitchContext;
import abc.parser.MusicParser.RestContext;
import abc.parser.MusicParser.RootContext;
import abc.parser.MusicParser.Second_endingContext;
import abc.parser.MusicParser.Start_repeatContext;
import abc.parser.MusicParser.Tuplet_elementContext;
import abc.parser.MusicParser.Tuplet_specContext;



/** Make an Music from a parse tree. */
class MakeMusic implements MusicListener {
    private int numRepeatMeasures;
    private boolean currentlyRepeating = false;
    
    private Stack<Music> stack = new Stack<>();
    private Stack<Music> note_stack = new Stack<>();
    private Stack<Pitch> pitches = new Stack<>();
    private Stack<Integer> accidentals = new Stack<>();
    
    // map of key's accidentals
    private final Map<String, Integer> key;
    // map of current accidentals, flush after measure ends
    private Map<String, Integer> measure_accidentals = new HashMap<>();
    
    /**
     * Creates a default MakeMusic object. 
     * The default major is C Major
     */
    public MakeMusic(){
        //Default key is C Major
        this.key = new HashMap<>();
    }
    /**
     * Creates a MakeMusic object where the music to be returned will be in a
     * specified key
     * @param keySignature The key the music is in
     */
    public MakeMusic(Map<String, Integer> keySignature){
        this.key = keySignature;
    }
    /**
     * Returns the expression constructed by this listener object.
     * Requires that this listener has completely walked over an Music
     * parse tree using ParseTreeWalker.
     * @return a Music for the parse tree that was walked
     */
    public Music getMusic() {
        return stack.get(0);       
    }

    @Override
    public void exitMusic(MusicContext ctx) {
        assert !stack.isEmpty();
        Music m = stack.pop();
        while(!stack.isEmpty()){
            m = new Concat(stack.pop(), m);
        }
        
        stack.push(m);
    }


    @Override
    public void exitMeasure(MeasureContext ctx) {
        //flush accidentals
//        System.out.println(ctx.getText() + measure_accidentals);
        measure_accidentals = new HashMap<>();   
    }
    
    @Override
    public void exitNormal_measure(Normal_measureContext ctx) {
        measure_accidentals = new HashMap<>();   

        Music m = note_stack.pop();

        while(!note_stack.isEmpty()){
            Music x = note_stack.pop();
            m = new Concat(x, m);
        }
        //for repeats
        if(currentlyRepeating && ctx.start_repeat() == null){
            numRepeatMeasures +=1;
        }
        
        if(ctx.start_repeat() != null){
            Music start = stack.pop();
            stack.push(m);
            stack.push(start);
            
        }
        else{ stack.push(m); }
        
//        System.err.println(ctx.getText() + " " + numRepeatMeasures); 

    }
    
    @Override
    public void exitEnd_repeat(End_repeatContext ctx) {
        measure_accidentals = new HashMap<>();   

        //m is the end repeat measures
        Music m = note_stack.pop();
        while(!note_stack.isEmpty()){
            Music x = note_stack.pop();
            m = new Concat(x, m);
        }        
        //Track all repeated measures
        List<Music> repeatedMeasures = new ArrayList<>();
        repeatedMeasures.add(m);
                
        //repeat from beginning if no specified repeat start
        if(!currentlyRepeating) numRepeatMeasures = stack.size();

        for(int i = 0; i < numRepeatMeasures; i++){
            Music measure = stack.pop();
            repeatedMeasures.add(measure);
            m = new Concat(measure, m);
            
        }
        //account for last measure
        numRepeatMeasures+=1;

        //push the ending back on the stack
        stack.push(m);
        
//      push the repeat measures back on the stack
        Collections.reverse(repeatedMeasures);
        for(Music measure: repeatedMeasures){
              stack.push(measure);
        }        
        currentlyRepeating = false; 
    }


    @Override
    public void exitFirst_ending(First_endingContext ctx) {
        measure_accidentals = new HashMap<>();   

       //exit first ending - remove the first ending measures
//    number of measures in first ending
      int firstEndingMeasures = ctx.normal_measure().size() + 1;

      //keep only the repeated measures not in the first ending for the second time around
      for(int i = 0; i < firstEndingMeasures; i++){
          stack.pop();
      }
      numRepeatMeasures -= firstEndingMeasures;
      
      //Push the repeated section onto the stack 
      Music repeat = stack.pop();
      for(int i = 1; i < numRepeatMeasures; i++){
          repeat = new Concat(stack.pop(), repeat);
      }
      stack.push(repeat);
//      System.out.println("AAA " + repeat);

    }


    @Override
    public void exitSecond_ending(Second_endingContext ctx) {
          measure_accidentals = new HashMap<>();   
    }


    @Override
    public void exitDouble_bar(Double_barContext ctx) {
        measure_accidentals = new HashMap<>();   

        Music m = note_stack.pop();
        
        //Count only notes
        int numNotes = ctx.element().size();
        for(ElementContext e: ctx.element()){
            if(e.WHITESPACE() != null) numNotes --;
        }
        
        //while(!note_stack.isEmpty()){
        for(int i = 0; i < numNotes-1; i++){
            m = new Concat(note_stack.pop(), m);
        }

        stack.push(m);

    }

    @Override
    public void exitStart_repeat(Start_repeatContext ctx) {        
        measure_accidentals = new HashMap<>();   

        int numberOfElements = ctx.element().size();
        for(ElementContext e: ctx.element()){
            if (e.WHITESPACE() != null) numberOfElements --;
        }
        
        Music m = note_stack.pop();
        // while(!note_stack.isEmpty()){
        for(int i = 0; i < numberOfElements-1; i++){
            m = new Concat(note_stack.pop(), m);
        }
        
        if(ctx.getText().endsWith(":|")){
            m = new Concat(m,m);
            stack.push(m);
        }
        else{
            stack.push(m);        
            currentlyRepeating = true;
            numRepeatMeasures = 1;
        }
    }


    @Override
    public void exitMulti_note(Multi_noteContext ctx) {
        // make sure chord has at least two notes
        assert ctx.note().size() > 1;
        
        // make sure the stack has at least two notes
        assert note_stack.size() > 1;
        
        Music last = note_stack.pop();
        Music secondLast = note_stack.pop();
        
        Together chord = new Together(secondLast, last);
        int numNotes = ctx.note().size();
        
        for(int i = 0; i < numNotes-2; i++){
          chord = new Together(note_stack.pop(), chord);
        }
        note_stack.push(chord);
    }


    @Override
    public void exitNote(NoteContext ctx) {
        Fraction duration = new Fraction(1,1);
        if ( ctx.note_length() != null){
            duration = parseDuration(ctx.note_length().getText());
        }
        
        if( ctx.pitch() != null){
            Pitch pitch = pitches.pop();
            note_stack.push(new Note(pitch, duration));
        }
        else{ // ctx.rest
            note_stack.push(new Rest(duration));
        }

        
    }

    @Override
    public void exitPitch(PitchContext ctx) {
        Pitch p = new Pitch(ctx.BASENOTE().getText().toUpperCase().charAt(0));
        
        //------------------------------------------------------------
        // Be in the right octave
        int octaves = 0;

        //if it is lower case
        if (!ctx.BASENOTE().getText().toUpperCase().equals(ctx.BASENOTE().getText())){
            octaves +=1;
        }
        
        //number of octaves to transpose by
        if(ctx.octave() != null){
            if(ctx.octave().OCTAVE_UP() != null){
                //increase octaves by number of '
                octaves += ctx.octave().OCTAVE_UP().getText().length();
            }
            if(ctx.octave().OCTAVE_DOWN() != null){
                // decrease octaves by number of ,
                octaves -= ctx.octave().OCTAVE_DOWN().getText().length();
            }
        }
        
        //transpose so the pitch is in the right octave
        p = p.transpose(12*octaves);
        
        //------------------------------------------------------
        //Apply accidentals/sharps and flats from key signature
        
        //if no accidentals, apply all accidentals from this measure
        if(ctx.accidental() == null){
            // Apply prior accidentals
            if(measure_accidentals.containsKey(ctx.getText())){
                p = p.transpose(measure_accidentals.get(ctx.getText()));
            }
            // Apply key signature
            else if(key.containsKey(ctx.BASENOTE().getText().toUpperCase())){
                p = p.transpose(key.get(ctx.BASENOTE().getText().toUpperCase()));
            }
        }
        
        //if there is an accidental
        else{
            String note;
            if(ctx.octave() != null)
                note = ctx.BASENOTE().getText() + ctx.octave().getText();
            else note = ctx.BASENOTE().getText();
            
            measure_accidentals.put(note, accidentals.pop());
            p = p.transpose(measure_accidentals.get(note));
        }
        
        //------------------------------------------------------
        pitches.push(p);
    }

    @Override
    public void exitAccidental(AccidentalContext ctx) {
        int semitones = 0;
        
        // If it is a sharp
        if(ctx.SHARP() != null){
            semitones = ctx.SHARP().getText().length();
        }
        // If it is a flat
        else if(ctx.FLAT() != null){
            semitones = -1 * (ctx.FLAT().getText().length());
        }
    
        accidentals.push(semitones);
            
    }
    
    @Override
    public void exitTuplet_element(Tuplet_elementContext ctx) {
        int numNotes = Integer.parseInt(ctx.tuplet_spec().getText().substring(1));
        List<Music> tupletNotes = new ArrayList<>();
        for(int i =0; i < numNotes; i++){
            tupletNotes.add(note_stack.pop());
        }
        
        Tuplet t = new Tuplet(numNotes, tupletNotes);
        note_stack.push(t);
    }


    private Fraction parseDuration(String duration){
      //if duration is a fraction
      if(duration.contains("/")){
          int numerator = 1;
          int denominator = 2;

          String[] fraction = {"",""};

          if(duration.split("/").length > 1)
              fraction = duration.split("/");
                    
          if(!fraction[0].equals("")){ numerator = Integer.valueOf(fraction[0]); }
          if(!fraction[1].equals("")){ denominator = Integer.valueOf(fraction[1]); }
          
          return new Fraction(numerator, denominator);
      }
      //if it is a whole number
      else{
          return new Fraction(Integer.valueOf(duration), 1);
      }
        
    }
   
    
    //---------------------------------------------------------
    @Override
    public void enterElement(ElementContext ctx) {    }

    @Override
    public void exitElement(ElementContext ctx) {    }

    @Override
    public void enterNote_element(Note_elementContext ctx) {    }
   
    @Override
    public void exitNote_element(Note_elementContext ctx) {     }

    @Override
    public void enterMulti_note(Multi_noteContext ctx) {        }

    @Override
    public void enterTuplet_spec(Tuplet_specContext ctx) {      }
    @Override
    public void enterTuplet_element(Tuplet_elementContext ctx) {          }

    @Override
    public void enterPitch(PitchContext ctx) {    }

    @Override
    public void enterNote(NoteContext ctx) {    }
    
    @Override
    public void enterNote_length(Note_lengthContext ctx) {  }

    @Override
    public void exitNote_length(Note_lengthContext ctx) {        }

    @Override
    public void enterAccidental(AccidentalContext ctx) {    }

    @Override
    public void enterOctave(OctaveContext ctx) {    }

    @Override
    public void exitOctave(OctaveContext ctx) { }

    @Override
    public void enterRest(RestContext ctx) {    }

    @Override
    public void exitRest(RestContext ctx) { 
    }

    @Override
    public void enterComment(CommentContext ctx) {  }

    @Override
    public void exitComment(CommentContext ctx) {   }

    @Override
    public void enterMusic(MusicContext ctx) {  }

    @Override
    public void enterEveryRule(ParserRuleContext arg0) {
//        System.err.println(arg0.getText());
    }

    @Override
    public void exitEveryRule(ParserRuleContext arg0) {
//        System.err.println(arg0.getText() + " " + numRepeatMeasures); 
    }

    @Override
    public void visitErrorNode(ErrorNode arg0) {    }

    @Override
    public void visitTerminal(TerminalNode arg0) {  }

    @Override
    public void enterRoot(RootContext ctx) {    }

    @Override
    public void exitRoot(RootContext ctx) {            }
    
    @Override
    public void exitTuplet_spec(Tuplet_specContext ctx) {    }
    
    @Override
    public void enterNormal_measure(Normal_measureContext ctx) {

    }
    @Override
    public void enterEnd_repeat(End_repeatContext ctx) {

    }
    @Override
    public void enterMeasure(MeasureContext ctx) {

    }

    @Override
    public void enterStart_repeat(Start_repeatContext ctx) {
    }
    @Override
    public void enterFirst_ending(First_endingContext ctx) {
    }

    @Override
    public void enterSecond_ending(Second_endingContext ctx) {
    }

    @Override
    public void enterDouble_bar(Double_barContext ctx) {

    }

}

