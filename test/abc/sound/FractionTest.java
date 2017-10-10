package abc.sound;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest{
    //getNumerator(): 0, 1, >1
    //getDenominator(): 1, >1
    //add(): 
    //  denominators: equal, not equal
    //  numerator: 0, 1, >1
    //  denominator: 1, >1
    //simplify():
    //  can simplify: 
    //      numerator > denominator, denominator > numerator
    //  cannot simplify: 
    //      stays the same
    //equals():
    //      true, false

    private Fraction f1 = new Fraction(0, 1);
    private Fraction f2 = new Fraction(1, 5);
    private Fraction f3 = new Fraction(5, 2);
//getNumerator():
    // 0
    @Test public void testGetNumeratorZero(){
        assertTrue("expected numerator", 0 == f1.getNumerator());
    }
    // 1
    @Test public void testGetNumeratorOne(){
        assertTrue("expected numerator", 1 == f2.getNumerator());
    }
    // >1
    @Test public void testGetNumeratorGreaterThanOne(){
        assertTrue("expected numerator", 5 == f3.getNumerator());

    }
//getDenominator():
    //1
    @Test public void testGetDenominatorOne(){
        assertTrue("expected denominator", 1 == f1.getDenominator());
    }
    // >1
    @Test public void testGetDenominatorGreaterThanOne(){
        assertTrue("expected denominator", 5 == f2.getDenominator());
    }
//add():
    //denominators equal, numerator 1, > 1, denominator > 1
    @Test public void testAddEqualDenominators(){
        assertEquals(new Fraction(3, 4), new Fraction(1,4).add(new Fraction(1,2)));
    }
    //denominators not equal, denominator 1
    @Test public void testAddDifferentDenominators(){
        assertEquals(new Fraction(17, 4), new Fraction(2,1).add(new Fraction(9,4)));
    }
    //denominators not equal, numerator = 0
    @Test public void testAddZero(){
        assertEquals(new Fraction(4,6), new Fraction(2,3).add(new Fraction(0,2)));
    }
//Simplify():
    // numerator > denominator, can simplify
    @Test public void testSimplifyNumerBiggerCanSimplify(){
        assertEquals(new Fraction(8,2).simplify(), new Fraction(4,1));
    }
    // numerator < denominator, can simplify
    @Test public void testSimplifyNumerSmallerCanSimplify(){
        assertEquals(new Fraction(4,16).simplify(), new Fraction(1,4));
    }
    // numerator < denominator, cannot simplify
    @Test public void testSimplifyNumerSmallerCannotSimplify(){
        assertEquals(new Fraction(3,16).simplify(), new Fraction(3,16));
    }
    // numerator > denominator, cannot simplify
    @Test public void testSimplifyNumerGreaterCannotSimplify(){
        assertEquals(new Fraction(17,16).simplify(), new Fraction(17,16));
    }
}