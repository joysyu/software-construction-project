package abc.sound;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Testing the tuplet variant of Music
 * @author Dora
 *
 */
public class TupletTest {
    //TESTING STRATEGY
    // duration
    // toString, equals, hashCode
    // findDenominators, findNumTicks
    
    public static final Note C = new Note(new Pitch('C'), new Fraction(1,1));
    public static final Note D = new Note(new Pitch('D'), new Fraction(1,2));
    public static final Note A = new Note(new Pitch('A'), new Fraction(1,1));


    
    //test for duration
    @Test public void tupletDurationTest() {
        Tuplet tuplet = new Tuplet(3, Arrays.asList(C,D,A));
        assertEquals(new Fraction(6,3), tuplet.duration());
    }
    
    //test for toString
    @Test public void tupletToStringTest() {
        Tuplet tuplet = new Tuplet(3, Arrays.asList(C,D,A));
        assertEquals("(3C1/1 D1/2 A1/1 ", tuplet.toString());
    }
    
    //test for equals
    @Test public void tupletEqualsTest() {
        Tuplet tuplet = new Tuplet(3, Arrays.asList(C,D,A));
        Tuplet tuplet1 = new Tuplet(3, Arrays.asList(C,C,A));
        assertTrue(tuplet.equals(new Tuplet(3, Arrays.asList(C,D,A))));
        assertFalse(tuplet1.equals(new Tuplet(3, Arrays.asList(C,D,A))));
    }
    
    //test for hashCode
    @Test public void tupletHashCodeTest() {
        Tuplet tuplet = new Tuplet(3, Arrays.asList(C,D,A));
        assertEquals(tuplet.hashCode(), new Tuplet(3, Arrays.asList(C,D,A)).hashCode());
    }
    
    //test for findDenominators
    @Test public void tupletFindDenominatorsTest() {
        Tuplet tuplet = new Tuplet(3, Arrays.asList(C,D,A));
        Set<Integer> denomSet = new HashSet<Integer>(Arrays.asList(1,2,3));
        assertEquals(denomSet, tuplet.findDenominators());
    }
    
    //test for findNumTicks
    @Test public void tupletFindNumTicks() {
        Tuplet tuplet = new Tuplet(3, Arrays.asList(C,D,A));
        assertEquals(4, tuplet.findNumTicks(2).intValue());
    }

}
