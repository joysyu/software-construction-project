package abc.sound;

import static org.junit.Assert.*;

import org.junit.Test;

public class LCMTest{
    //PARTITIONS:
    //lcm(a, b):
    //INPUT:
    //  a = 1, >1, b = 1, > 1
    //OUTPUT:
    //  lcm = a or b, a*b, or  a, b < lcm < a*b.
    
    //gcd(a, b): 
    //INPUT:
    //INPUT:
    //  a = 1, >1, b = 1, > 1
    //OUTPUT:
    //  gcd = 1, a or b, or 1 < gcd < max(a,b)
    
    //lcm(int[]):
    //INPUT:
    // length = 3, >3
    //OUTPUT:
    // lcm = one of the existing numbers, all the number multiplied together,
    //  or greater than any of the existing numbers but less than all of them multipled together

//lcm(a,b):
    //INPUT:
    // a > 1, b > 1
    //OUTPUT:
    //  lcm = a * b
    @Test public void testLCMMultiple(){
        int a = 5;
        int b = 6;
        assertTrue("expected lcm", 30==LCM.lcm(a,b));
    }

    //INPUT:
    // a > 1, b > 1
    //OUTPUT:
    //  a, b < lcm < a*b
    @Test public void testLCMBetween(){
        int a = 48;
        int b = 36;
        assertTrue("expected lcm", 144==LCM.lcm(a,b));
    }

    //INPUT:
    // a > 1, b > 1
    //OUTPUT:
    //  lcm = a
    @Test public void testLCMExisting(){
        int a = 48;
        int b = 24;
        assertTrue("expected lcm", 48==LCM.lcm(a,b));
    }

//gcd(a,b):

    //INPUT:
    // a > 1, b > 1
    //OUTPUT:
    //  1 < gcd < max(a,b)
    @Test public void testGCDBetween(){
        int a = 48;
        int b = 36;
        assertTrue("expected gcd", 12==LCM.gcd(a,b));
    }

    //INPUT:
    // a = 1, b > 1
    //OUTPUT:
    //  gcd = 1 (which is a)
    @Test public void testGCDOne(){
        int a = 1;
        int b = 24;
        assertTrue("expected gcd", 1==LCM.gcd(a,b));
    }

    //INPUT:
    // a  >1, b > 1
    //OUTPUT:
    //  gcd = b 
    @Test public void testGCDExisting(){
        int a = 10;
        int b = 5;
        assertTrue("expected gcd", 5==LCM.gcd(a,b));
    }
    
//lcm(int[]):
    //INPUT:
    // length = 3
    //OUTPUT:
    //  all numbers multiplied together
    @Test public void testLCMArrayAllNumsMultiplied(){
        int[] array = new int[3];
        array[0] = 5;
        array[1] = 6;
        array[2] = 7;
        assertTrue("expected lcm", LCM.lcm(array) == 210);
    }
    
    //INPUT:
    // length > 3
    //OUTPUT:
    // one of the existing numbers
    @Test public void testLCMArrayExisting(){
        int[] array = new int[4];
        array[0] = 5;
        array[1] = 6;
        array[2] = 210;
        array[3] = 10;
        assertTrue("expected lcm", LCM.lcm(array) == 210);
    }
    
    //INPUT:
    // length = 3
    //OUTPUT:
    //  less than all numbers multipled together and greater than any of the existing numbers
    @Test public void testLCMArrayBetween(){
        int[] array = new int[3];
        array[0] = 48;
        array[1] = 36;
        array[2] = 24;
        assertTrue("expected lcm", LCM.lcm(array) == 144);
    }
}