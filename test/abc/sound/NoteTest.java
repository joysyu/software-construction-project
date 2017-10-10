package abc.sound;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Testing Note variant of Music
 * @author Dora
 *
 */
public class NoteTest {
    // TESTING STRATEGY
    // pitch: returns correct pitch
    // duration: returns correct duration
    // toString, equals, and hashCode
    // findDenominators, findNumTicks
    
    //test for pitch
    @Test public void notePitchTest() {
        Pitch pitch = new Pitch('C');
        Note note = new Note(pitch, new Fraction(5,1));
        assertEquals("expected pitch C", pitch, note.pitch());
    }
    
    //test for duration
    @Test public void noteDurationTest() {
        Pitch pitch = new Pitch('C');
        Note note = new Note(pitch, new Fraction(5,1));
        assertEquals("expected duration 5", note.duration(), new Fraction(5,1));
    }

    //test for toString
    @Test public void noteToStringTest() {
        Pitch pitch = new Pitch('C');
        Note note = new Note(pitch, new Fraction(5,1));
        assertTrue(note.toString().equals("C5/1 "));
    }
    
    //test for equals
    @Test public void noteEqualsTest() {
        Pitch pitch = new Pitch('C');
        Note note1 = new Note(pitch, new Fraction(5,1));
        Note note2 = new Note(pitch, new Fraction(5,2));
        assertTrue(note1.equals(new Note(pitch, new Fraction(5,1))));
        assertFalse(note1.equals(note2));
    }
    
    //test for hashCode
    @Test public void noteHashCodeTest() {
        Pitch pitch = new Pitch('C');
        Note note1 = new Note(pitch, new Fraction(5,1));
        Note note2 = new Note(pitch, new Fraction(5,1));
        assertEquals(note1.hashCode(),note2.hashCode());
    }
    
    //test for findDenominators
    @Test public void noteFindDenominatorsTest() {
        Pitch pitch = new Pitch('C');
        Note note = new Note(pitch, new Fraction(5,4));
        Set<Integer> denomSet = new HashSet<Integer>(Arrays.asList(4));
        assertEquals(denomSet, note.findDenominators());
    }
    
    //test for findNumTicks
    @Test public void noteFindNumTicksTest() {
        Pitch pitch = new Pitch('C');
        Note note = new Note(pitch, new Fraction(5,4));
        assertEquals(5, note.findNumTicks(4).intValue());
    }
}
