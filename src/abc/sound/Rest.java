package abc.sound;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Rest represents some duration of time that is silent during a piece of music.
 */
public class Rest implements Music {
    // Abstraction Function
    //  Represents a rest with some duration
    // Rep Invariant
    //  duration is not negative
    // Safety from Rep Exposure
    //  fields are all private and final
    
    private final Fraction duration;
    
    /*
     * assert the rep invariant
     */
    private void checkRep(){
        assert duration.getNumerator() >=0;
        assert duration.getDenominator() >0;
    }
    
    /**
     * Create a Rest with a specified duration
     * @param duration the number of beats to rest for
     */
    public Rest(Fraction duration) {
        this.duration = duration;
        checkRep();
    }

    @Override
    public Fraction duration() {
        checkRep();
        return this.duration;
    }

    @Override
    public void play(SequencePlayer player, int ticksPerBeat, int startTick, Fraction speed) {
        checkRep();
        return;
    }
    
    /**
     * @return a string with "z" to represent a rest, followed by the duration of the rest
     */
    @Override public String toString() {
        checkRep();
        return "z" + this.duration + " ";
    }
    
    /**
     * @param thatObject the object to compare this object to
     * @return true of this and thatObject have the same duration
     *          false otherwise
     */
    @Override public boolean equals(Object thatObject) {
        checkRep();
        if ( ! (thatObject instanceof Rest)) { return false; }
        Rest that = (Rest)thatObject;
        return this.duration.equals(that.duration);
    }
    
    @Override public int hashCode() {
        checkRep();
        return (int)this.duration.getNumerator();
    }
    
    @Override
    public Set<Integer> findDenominators() {
        checkRep();
        return new HashSet<Integer>(Arrays.asList(this.duration.getDenominator()));
    }

    @Override
    public Integer findNumTicks(int ticksPerBeat) {
        checkRep();
        return (this.duration().getNumerator() * ticksPerBeat) / this.duration().getDenominator();
    }

}
