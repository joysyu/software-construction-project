package abc.parser;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import abc.sound.Concat;
import abc.sound.Fraction;
import abc.sound.KeySignature;
import abc.sound.KeySignatureToTranspose;
import abc.sound.Music;
import abc.sound.Note;
import abc.sound.Pitch;
import abc.sound.Rest;
import abc.sound.Together;
import abc.sound.Tuplet;

public class MusicParserTest {
    
    //TESTING STRATEGY
    // single note, multiple notes
    // rests
    // chords
    // tuplets
    
    // repeats: repeat to beginning, repeat to not beginning, multiple endings, 
    //          multiple endings (not to beginning and to beginning)
    // accidentals: make sure applied to same note for rest of the measure,
    //          make sure they override key signature
    // note lengths: fraction, whole number, absent numerator/denominator
    // octaves
    // measures: 1 measure, multiple measures
    // double bar measure
    
    public static final Map<String,Integer> emptyKey = new HashMap<String,Integer>();
    
    //test for single note
    @Test public void singleNoteTest() {
        Music m = Music.parse("c|", emptyKey);
        Note newNote = new Note(new Pitch('C').transpose(12), new Fraction(1, 1));
        assertTrue(m.toString().equals(newNote.toString()));
    }
    
    //test for multiple notes, 1 measure
    @Test public void multipleNoteTest() {
        Music m = Music.parse("D F|", emptyKey);
        Note D = new Note(new Pitch('D'), new Fraction(1,1));
        Note F = new Note(new Pitch('F'), new Fraction(1,1));
        Concat concat = new Concat(D,F);
        assertTrue(m.toString().equals(concat.toString()));
    }

    //test for rest
    @Test public void restTest() {
        Music m = Music.parse("z |", emptyKey);
        Rest rest = new Rest(new Fraction(1,1));
        assertTrue(m.toString().equals(rest.toString()));
    }

    //test for chord
    @Test public void chordTest() {
        Music m = Music.parse("[CEG]|", emptyKey);
        Note C = new Note(new Pitch('C'), new Fraction(1,1));
        Note E = new Note(new Pitch('E'), new Fraction(1,1));
        Note G = new Note(new Pitch('G'), new Fraction(1,1));
        Together tog1 = new Together(G,E);
        Together tog2 = new Together(tog1, C);
        assertTrue(m.equals(tog2));
    }

    //test for tuplet
    @Test public void tupletTest() {
        Music m = Music.parse("(3AAA |", emptyKey);
        Note A = new Note(new Pitch('A'), new Fraction(1,1));
        List<Music> notes = Arrays.asList(A,A,A);
        Tuplet tuplet = new Tuplet(3,notes);
        assertTrue(m.toString().equals(tuplet.toString()));
    }
    
    //test for repeat to beginning, multiple measures
    @Test public void repeatToBeginningTest() {
        Music m = Music.parse("C D E F | G A B c :|", emptyKey);
        Music correctM = Music.parse("C D E F | G A B c | C D E F | G A B c |", emptyKey);
        assertTrue(m.toString().equals(correctM.toString()));
    }
    
    //test for repeat not to beginning
    @Test public void repeatNotToBeginningTest() {
        Music m = Music.parse("C D E F |: G A B | c :|", emptyKey);
        Music correctM = Music.parse("C D E F | G A B c | G A B c |", emptyKey);
        assertTrue(m.toString().equals(correctM.toString()));
    }
    
    //test for repeat with multiple endings
    @Test public void repeatMultipleEndingsTest() {
        Music m = Music.parse("|: C D E F |[1 G A B c | G A B B :|[2 F E D C |", emptyKey);
        Music correctM = Music.parse("C D E F | G A B c | G A B B | C D E F | F E D C|", emptyKey);
        assertEquals(m.toString(),correctM.toString());
    }
    
    //test for multiple repeats to beginning
    @Test public void repeatMultipleToBeginningTest() {
        Music m = Music.parse("C D | G A :| D D :|", emptyKey);
        Music correctM = Music.parse("C D | G A | C D | G A | D D | C D | G A | C D | G A | D D|", emptyKey);
        assertTrue(m.toString().equals(correctM.toString()));
    }
    
    //test for multiple repeats not to beginning
    @Test public void repeatMultipleNotToBeginning() {
        Music m = Music.parse("C D |: G | A :| D D |: A D | A A :|", emptyKey);
        Music correctM = Music.parse("C D | G A G A | D D | A D A A | A D A A|", emptyKey);
        assertTrue(m.toString().equals(correctM.toString()));
    }
    @Test public void repeatOneMeasure(){
        Music m = Music.parse("C D |: G A :| D D |: A D | A A :|", emptyKey);
        Music correctM = Music.parse("C D | G A G A | D D | A D A A | A D A A|", emptyKey);
        assertTrue(m.toString().equals(correctM.toString()));

    }
    @Test public void repeatTest(){
        String musicString = "a|b|[1c :|[2d | a|:e|f|[1A:|[2B|";
        Music correctM = Music.parse("a b c a b d a e f A e f B|", emptyKey);
        Music m = Music.parse(musicString, emptyKey);
        assertEquals("", correctM.toString(), m.toString());
    }
    
    //test for note lengths, fraction
    @Test public void noteLengthFractionTest() {
        Music m = Music.parse("A1/8|", emptyKey);
        assertTrue(m.duration().equals(new Fraction(1,8)));
    }
    
    //test for note lengths, whole number
    @Test public void noteLengthWholeNumberTest() {
        Music m = Music.parse("A8 |", emptyKey);
        assertTrue(m.duration().equals(new Fraction(8,1)));
    }
    
    //test for note lengths, absent numerator
    @Test public void noteLengthAbsentNumeratorTest() {
        Music m = Music.parse("A,/4 |", emptyKey);
        assertTrue(m.duration().equals(new Fraction(1,4)));
    }
    
    //test for note lengths, absent denominator
    @Test public void noteLengthAbsentDenominatorTest () {
        Music m = Music.parse("A1/ |", emptyKey);
        assertTrue(m.duration().equals(new Fraction(1,2)));
    }
    
    //test for note lengths, absent numerator and denominator
    @Test public void noteLengthAbsentNumAndDenomTest() {
        Music m = Music.parse("A,/ |", emptyKey);
        assertTrue(m.duration().equals(new Fraction(1,2)));
    }
    
    //test for octaves
    @Test public void octavesTest() {
        Music m = Music.parse("A, A a a'|", emptyKey);
        assertTrue(m.toString().equals("A,1/1 A1/1 A'1/1 A''1/1 "));
    }
    
    //test for accidentals, flat
    @Test public void accidentalsFlat() {
        Music m = Music.parse(" _B D b B | B b C|", emptyKey);
        Music correctM = Music.parse(" _B D b _B | B b C|", emptyKey);
        assertTrue(m.toString().equals(correctM.toString()));
    }
    
    //test for accidentals, sharp
    @Test public void accidentalsSharpTest() {
        Music m = Music.parse(" ^B D b B | B b C|", emptyKey);
        Music correctM = Music.parse(" ^B D b ^B | B b C|", emptyKey);
        assertTrue(m.toString().equals(correctM.toString()));
    }
    
    //test for accidentals, natural
    @Test public void accidentalsNaturalTest() {
        Music m = Music.parse("^A B A =A | A C|", emptyKey);
        Music correctM = Music.parse("^A B ^A =A | A C|", emptyKey);
        assertTrue(m.toString().equals(correctM.toString()));
    }
    
    //test for key signature
    @Test public void keySignatureTest() {
         Map<String, Integer> AFlat = KeySignatureToTranspose.KEY_SIGNATURE.get(KeySignature.A_FLAT_MAJOR);
         Music m = Music.parse("A a B | C A| =A |", AFlat);
         Music correctM = Music.parse("_A _a _B | C _A| A|", emptyKey);
         assertTrue(m.toString().equals(correctM.toString()));
    }
   
    //test for accidental overriding key signature
    @Test public void keySignatureOverrideTest() {
        Map<String, Integer> AFlat = KeySignatureToTranspose.KEY_SIGNATURE.get(KeySignature.A_FLAT_MAJOR);
        Music m = Music.parse("A =A ^A|", AFlat);
        Music correctM = Music.parse("_A =A ^A|", emptyKey);
        assertTrue(m.toString().equals(correctM.toString()));
    }
    
    //test for double bar measure
    @Test public void doubleBarMeasureTest() {
        Music m = Music.parse("A B C D | A B ||", emptyKey);
        Music correctM = Music.parse("A B C D A B|", emptyKey);
        assertTrue(m.toString().equals(correctM.toString()));
    }
    
}
