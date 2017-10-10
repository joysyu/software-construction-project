package abc.sound;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

/**
 * Testing Rest variant of Music
 * @author Dora
 *
 */
public class RestTest {
    //TESTING STRATEGY
    // duration: returns correct duration
    // toString, equals, and hashCode
    // findDenominators, findNumTicks
    
    //test for duration
    @Test public void restDurationTest() {
        Rest rest = new Rest(new Fraction(7,1));
        assertEquals("expected 7", rest.duration(), new Fraction(7,1));
    }
    
    //test for toString
    @Test public void restToStringTest() {
        Rest rest = new Rest(new Fraction(7,1));
        assertTrue(rest.toString().equals("z7/1 "));
    }
    
    //test for equals
    @Test public void restEqualsTest() {
        Rest rest = new Rest(new Fraction(7,1));
        assertTrue(rest.equals(new Rest(new Fraction(7,1))));
        assertFalse(rest.equals(new Rest(new Fraction(7,3))));
    }
    
    //test for hashCode
    @Test public void restHashCodeTest() {
        Rest rest1 = new Rest(new Fraction(7,1));
        Rest rest2 = new Rest(new Fraction(7,1));
        assertTrue(rest1.hashCode() == rest2.hashCode());
    }
    
    //test for findDenominators
    @Test public void restFindDenominatorsTest() {
        Rest rest = new Rest(new Fraction(7,1));
        Set<Integer> denomSet = new HashSet<Integer>(Arrays.asList(1));
        assertTrue(denomSet.equals(rest.findDenominators()));
    }
    
    //test for findNumTicks
    @Test public void restFindNumTicks() {
        Rest rest = new Rest(new Fraction(7,1));
        assertEquals(14, rest.findNumTicks(2).intValue());
    }

}
