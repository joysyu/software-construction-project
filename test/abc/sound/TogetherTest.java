package abc.sound;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * Testing the Together variant of Music
 * @author Dora
 *
 */
public class TogetherTest {
    //TESTING STRATEGY
    // duration: returns correct duration
    // toString, equals, and hashCode
    // findDenominators, findNumTicks
    
    //test for duration
    @Test public void togetherDurationTest() {
        Note note1 = new Note(new Pitch('D'), new Fraction(3, 1));
        Note note2 = new Note(new Pitch('C'), new Fraction(9, 1));
        Together together = new Together(note1, note2);
        assertEquals("expected 9.0", together.duration(), new Fraction(9,1));
    }
    
    //test for toString
    @Test public void togetherToStringTest() {
        Note note1 = new Note(new Pitch('D'), new Fraction(3, 1));
        Note note2 = new Note(new Pitch('C'), new Fraction(9, 1));
        Together together = new Together(note1, note2);
        assertEquals("[D3/1 C9/1 ]", together.toString());
    }
    
    //test for equals
    @Test public void togetherEqualsTest() {
        Note note1 = new Note(new Pitch('D'), new Fraction(3, 1));
        Note note2 = new Note(new Pitch('C'), new Fraction(9, 1));
        Together together = new Together(note1, note2);
        assertTrue(together.equals(new Together(note1, note2)));
        assertFalse(together.equals(new Together(note1, note1)));
    }
    
    //test for hashCode
    @Test public void togetherHashCodeTest() {
        Note note1 = new Note(new Pitch('D'), new Fraction(3, 1));
        Note note2 = new Note(new Pitch('C'), new Fraction(9, 1));
        Together together = new Together(note1, note2);
        assertEquals(together.hashCode(), new Together(note1, note2).hashCode());
    }
    
    //test for findDenominators
    @Test public void togetherFindDenominatorsTest() {
        Note note1 = new Note(new Pitch('D'), new Fraction(3, 2));
        Note note2 = new Note(new Pitch('C'), new Fraction(9, 1));
        Together together = new Together(note1, note2);
        Set<Integer> denomSet = new HashSet<Integer>(Arrays.asList(1,2));
        assertEquals(denomSet, together.findDenominators());
    }
    
    //test for findNumTicks
    @Test public void togetherFindNumTicksTest() {
        Note note1 = new Note(new Pitch('D'), new Fraction(3, 1));
        Note note2 = new Note(new Pitch('C'), new Fraction(9, 1));
        Together together = new Together(note1, note2);
        assertEquals(27, together.findNumTicks(3).intValue());
    }
}
