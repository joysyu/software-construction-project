package abc.sound;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

/**
 * Testing Concat variant of Music
 * @author Dora
 *
 */
public class ConcatTest {
    // TESTING STRATEGY
    // duration: returns correct duration
    // toString, equals, hashCode
    // findDenominators, findNumTicks
    
    //test for duration
    @Test public void concatDurationTest() {
        Note note = new Note(new Pitch('C'), new Fraction(4,1));
        Concat concat = new Concat(note, note);
        assertEquals("expected duration 8", new Fraction(8,1), concat.duration());
    }
    
    //test for toString
    @Test public void concatToStringTest() {
        Note note = new Note(new Pitch('C'), new Fraction(4,1));
        Concat concat = new Concat(note, note);
        assertEquals("C4/1 C4/1 ", concat.toString());
    }
    
    //test for equals
    @Test public void concatEqualsTest() {
        Note note1 = new Note(new Pitch('C'), new Fraction(4,1));
        Note note2 = new Note(new Pitch('D'), new Fraction(4,1));
        Concat concat1 = new Concat(note1, note1);
        Concat concat2 = new Concat(note1, note2);
        assertTrue(concat1.equals(new Concat(note1, note1)));
        assertFalse(concat1.equals(concat2));
    }
    
    //test for hashCode
    @Test public void concatHashCodeTest() {
        Note note = new Note(new Pitch('C'), new Fraction(4,1));
        Concat concat = new Concat(note, note);
        assertTrue(concat.hashCode() == new Concat(note, note).hashCode());
    }
    
    //test for findDenominators
    @Test public void concatFindDenominatorsTest() {
        Note note1 = new Note(new Pitch('C'), new Fraction(4,1));
        Note note2 = new Note(new Pitch('D'), new Fraction(4,3));
        Concat concat = new Concat(note1, note2);
        Set<Integer> denomSet = new HashSet<Integer>(Arrays.asList(1,3));
        assertEquals(denomSet, concat.findDenominators());
    }
    
    //test for findNumTicks
    @Test public void concatFindNumTicksTest() {
        Note note1 = new Note(new Pitch('C'), new Fraction(4,1));
        Note note2 = new Note(new Pitch('D'), new Fraction(4,3));
        Concat concat = new Concat(note1, note2);
        assertEquals(16, concat.findNumTicks(3).intValue());
    }
    

}
