package abc.sound;

/**
 * Immutable type. Fraction represents a mathematical fraction.
 *
 */
public class Fraction{
    //Abstraction Function
    //    Represents a fraction split in to numerator and denominator
    //    numer represents the numerator of a fraction,
    //    denom represents the denominator of a fraction.
    //Rep Invariant
    //    denom != 0
    
    private int numer;
    private int denom;
    
    /*
     * assert the rep invariant
     */
    private void checkRep() {
        assert denom!=0;
    }
    
    /**
     * A fraction with a numerator and denominator
     * @param numerator all integers
     * @param denominator denominator != 0
     */
    public Fraction(int numerator, int denominator){
        this.numer = numerator;
        this.denom = denominator;
        checkRep();
    }
    
    /**
     * @return the numerator of the Fraction
     */
    public int getNumerator(){
        checkRep();
        return numer;
    }
    
    /**
     * @return the denominator of the Fraction
     */
    public int getDenominator(){
        checkRep();
        return denom;
    }
    
    /**
     * Adds fractions together
     * @param other
     * @return the fraction that is this fraction plus other fraction
     */
    public Fraction add(Fraction other){
        int denomLCM = LCM.lcm(this.denom, other.denom);
        int multiplyingFactor = denomLCM / this.denom;
        int multiplyingFactorOther = denomLCM / other.denom;
        int top = multiplyingFactor * this.numer + multiplyingFactorOther * other.numer;
        checkRep();
        return new Fraction(top, denomLCM);
    }

    /**
     * Simplifies fractions
     * @return simplified fraction
     */
    public Fraction simplify(){
        int gcd = LCM.gcd(this.denom, this.numer);
        if (gcd != 1){
            int top = numer / gcd;
            int bottom = denom / gcd;
            return new Fraction(top, bottom);
        }
        checkRep();
        return new Fraction(numer, denom);
    }

    @Override
    public boolean equals(Object thatObject){
        if (!(thatObject instanceof Fraction)) return false;
        Fraction that = (Fraction) thatObject;
        Fraction thisFrac = this.simplify();
        Fraction thatFrac = that.simplify();
        checkRep();
        return thisFrac.getNumerator() == thatFrac.getNumerator() && thisFrac.getDenominator() == thatFrac.getDenominator();
    };
    
    @Override
    public int hashCode(){
        checkRep();
        return this.numer + this.denom;
    }
    
    @Override
    public String toString(){
        checkRep();
        return this.numer + "/" + this.denom;
    }
}