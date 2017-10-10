package abc.sound;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeaderTest{
    //TESTING STRATEGY:
    //-makingHeader():
    //  headerString: 
    //      -valid,invalid (lacks a mandatory field, has a field that doesn't fit grammar)
    //      -composer: given, not given
    //      -meter: given, not given
    //      -defaultLength: given, not given
    //      -tempo: given, not given

    //We test the factory method makingHeader() through the getting and setting methods below:
    //getIndexNumber():
    //  number is 0, 1, >1
    //getTitle(), getComposer(): 
    //  title contains: 
    //      -spaces, no spaces
    //      -numbers, no numbers
    //      -punctuation (like "."), no punctuation
    //getKey():
    //  key signature:
    //      -'C', any other key (C is worth testing because of overlaps in grammar)
    //      -has 'm', does not have 'm' (representing minor)
    //      -has key accidental '#', 'b', or none
    //getDefaultLength():

    //  numerator: 1, >1
    //  denominator: 1, >1
    
    //setMeter(Fraction meter), getMeter():
    //  numerator: 1, >1
    //  denominator: 1, >1

    //setTempo(Fraction noteThatKeepsBeat, int tempo), getTempo():
    //  noteThatKeepsBeat: 
    //      numerator: 1, >1
    //      denominator: 1, >1
    //  tempo:
    //      1, >1
    //toString(): each of the partitions for getting and setting methods above applies to toString.
    
    //a header: all optional fields given. 
    private String headerStringInvalidLackingOneMandField = "X:1\nT:Alphabet Song\nC:Traditional Kid's Song\nM:4/4\nL:2/4\nQ:2/4=100\n";
    private String headerStringEmpty = "";
    private String headerString1 = "X:1\nT:Alphabet Song\nC:Traditional Kid's Song\nM:4/4\nL:2/4\nQ:2/4=100\nK:D";
    private String headerString2 = "X:2\nT:JoySong...\nC:Trad.\nM:6/8\nQ:1/8=200\nK:Db";
    private String headerString3 = "X:2\nT:JoySong...\nC:Trad.2\nM:1/8\nQ:1/1=1\nK:F#m";
    private String headerString4 = "X:2\nT:JoySong...\nC:Trad.2\nM:3/4\nQ:1/1=1\nK:F#m";
    private String headerStringCMeter = "X:2\nT:JoySong...\nC:Trad.2\nM:C\nQ:1/1=1\nK:F#m";
    private String headerStringCLineMeter = "X:2\nT:JoySong...\nC:Trad.2\nM:C|\nQ:1/1=1\nK:F#m";

    private String headerStringOnlyMandatoryFields = "X:0\nT:Alphabet Song 2\nK:Cm";

    private Header h1 = Header.makeHeader(headerString1);
    private Header h2 = Header.makeHeader(headerString2);
    private Header h3 = Header.makeHeader(headerString3);
    private Header h4 = Header.makeHeader(headerString4);
    private Header hCMeter = Header.makeHeader(headerStringCMeter);
    private Header hCLineMeter = Header.makeHeader(headerStringCLineMeter);

    private Header hOnlyMandatoryFields = Header.makeHeader(headerStringOnlyMandatoryFields);

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

//TESTING GET METHODS:

//mandatory fields (index number, title, key signature)
//getIndexNumber():
    //OUTPUT: number = 0
    @Test public void testGetIndexNumberIsZero(){
        assertTrue("expected 0", hOnlyMandatoryFields.getIndexNumber()==0);
    }
    
    //OUTPUT: number = 1
    @Test public void testGetIndexNumberIsOne(){
        assertTrue("expected 1", h1.getIndexNumber()==1);
    }
    
    //OUTPUT: number > 1
    @Test public void testGetIndexNumberGreaterThanOne(){
        assertTrue("expected 2", h2.getIndexNumber()==2);
    }

//getTitle():
    //OUTPUT: title contains spaces, numbers, no symbols
    @Test public void testGetTitleWithSpacesNumbers(){
        assertEquals("expected title", "Alphabet Song 2", hOnlyMandatoryFields.getTitle());
    }
    //OUTPUT: title contains symbols, no spaces, no numbers
    @Test public void testGetTitleWithSymbols(){
        assertEquals("expected title", "JoySong...", h2.getTitle());
    }

//getKey():
    //INPUT: key has 'm', key is 'C' (special because of overlaps in the grammar)
    @Test public void testGetKeyMinor(){
        assertEquals("expected key", hOnlyMandatoryFields.getKey(), KeySignature.C_MINOR);
    }
    
    //INPUT: key doesn't have 'm'
    @Test public void testGetKeyMajor(){
        assertEquals("expected key", h1.getKey(), KeySignature.D_MAJOR);
    }
    
    //INPUT: key has 'b'
    @Test public void testGetKeyFlat(){
        assertEquals("expected key", h2.getKey(), KeySignature.D_FLAT_MAJOR);
    }
    
    //INPUT: key has '#', key has 'm'
    @Test public void testGetKeySharp(){
        assertEquals("expected key", h3.getKey(), KeySignature.F_SHARP_MINOR);
    }

//optional fields (composer, meter, default length, tempo)

//getComposer():
    //INPUT: composer given
    //OUTPUT: composer has: spaces, symbols, no numbers
    @Test public void testGetComposerSpacesSymbols(){
        assertEquals("expected composer", "Traditional Kid's Song", h1.getComposer());
    }
    //INPUT: composer given
    //OUTPUT: composer has: symbols, numbers, no spaces
    @Test public void testGetComposerSymbolsNumbers(){
        assertEquals("expected composer", "Trad.2", h3.getComposer());
    }
    //INPUT: composer not given
    @Test public void testGetComposerNotGiven(){
        assertEquals("expected composer", "unknown", hOnlyMandatoryFields.getComposer());
    }
    
//getDefaultLength():
    //INPUT: default length given
    //OUTPUT: 2/4
    @Test public void testGetDefaultLengthGivenQuarter(){
        assertEquals("expected default length", new Fraction(2,4), h1.getDefaultLength());
    }
    
    //INPUT: default length not given, meter not given
    //OUTPUT: 1/8
    @Test public void testGetDefaultLengthNothingGiven(){
        assertEquals("expected default length", new Fraction(1,8), hOnlyMandatoryFields.getDefaultLength());
    }
    
    //INPUT: default length not given, meter less that 0.75
    //OUTPUT: 1/16
    @Test public void testGetDefaultLengthGivenMeterLess(){
        assertEquals("expected default length", new Fraction(1,16), h3.getDefaultLength());
    }
    
    //INPUT: default length not given, meter is 0.75
    //OUTPUT: 1/8
    @Test public void testGetDefaultLengthGivenMeterEquals(){
        assertEquals("expected default length", new Fraction(1,8), h4.getDefaultLength());
    }
    
    //INPUT: default length not given, meter > 0.75
    //OUTPUT: 1/8
    @Test public void testGetDefaultLengthGivenMeterGreater(){
        assertEquals("expected default length", new Fraction(1,8), h2.getDefaultLength());
    }
    
//getMeter(Fraction meter):
    //INPUT: meter not given (should set to 4/4)
    @Test public void testSetMeterNotGiven(){
        assertEquals("expected meter", new Fraction(4,4), hOnlyMandatoryFields.getMeter());
    }
    //INPUT: C (should set to 4/4)
    @Test public void testSetMeterGivenC(){
        assertEquals("expected meter", new Fraction(4,4), hCMeter.getMeter());
    }
    
    //INPUT: C| (should set to 2/2)
    @Test public void testSetMeterGivenCLine(){
        assertEquals("expected meter", new Fraction(2,2), hCLineMeter.getMeter());
    }
    
    //INPUT: 1/8
    @Test public void testMeterGivenAnEighth(){
        assertEquals("expected meter", new Fraction(1,8), h3.getMeter());
    }
    
//getTempo(Fraction noteThatKeepsBeat, int tempo):
    //INPUT: tempo not given (should set to 100 beats per minute, a beat is default field given by L)
    @Test public void testGetTempoNotGiven(){
        assertEquals("expected length that keeps beat", new Fraction(1,8), hOnlyMandatoryFields.getTempo().get(0));
        assertEquals("expected tempo", new Fraction(100,1), hOnlyMandatoryFields.getTempo().get(1));
    }

    //INPUT: tempo given (beat length not necessarily based on L)
    @Test public void testGetTempoGiven(){
        assertEquals("expected length that keeps beat", new Fraction(2,4), h1.getTempo().get(0));
        assertEquals("expected tempo", new Fraction(100,1), h1.getTempo().get(1));
    }

//TESTING SET METHODS, makeHeader(), AND toString() TOGETHER:   
    //makeHeader() uses all of the set methods, so we can just test all these using toString();
    
    //invalid input: empty string
    @Test(expected=IllegalArgumentException.class) 
    public void testmakeHeaderEmptyString(){
        Header.makeHeader(headerStringEmpty);
    }
    
    //invalid input: lacking a mandatory field
    @Test(expected=IllegalArgumentException.class) 
    public void testmakeHeaderStringMissingKey(){
        Header.makeHeader(headerStringInvalidLackingOneMandField);
    }

    @Test public void toStringHeaderWithOnlyMandatoryFields(){
        String expectedString = "indexNumber: " + 0 + " title: " + "Alphabet Song 2" + " key: " + "C_MINOR" +
                " composer: " + "unknown" + " default_length: " + "1/8" +
                " meter: " + "4/4" + " tempo: " + "1/8" + "=" + "100";
        assertEquals("expected string", expectedString, hOnlyMandatoryFields.toString());
        }
    
    @Test public void toStringHeaderWithAllFieldsGiven(){
        String expectedString = "indexNumber: " + 1 + " title: " + "Alphabet Song" + " key: " + "D_MAJOR" +
                " composer: " + "Traditional Kid's Song" + " default_length: " + "2/4" +
                " meter: " + "4/4" + " tempo: " + "2/4" + "=" + "100";
        assertEquals("expected string", expectedString, h1.toString());
        }
    

    @Test public void toStringHeaderWithSomeFieldsGiven(){
        String expectedString = "indexNumber: " + 2 + " title: " + "JoySong..." + " key: " + "F_SHARP_MINOR" +
                " composer: " + "Trad.2" + " default_length: " + "1/8" +
                " meter: " + "2/2" + " tempo: " + "1/1" + "=" + "1";
        assertEquals("expected string", expectedString, hCLineMeter.toString());
    }
}