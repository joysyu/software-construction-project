package abc.sound;

import java.util.HashSet;
import java.util.Set;

/**
 * Concat is an immutable representation of two pieces of music played one after the other.
 */
public class Concat implements Music {
    // Abstraction Function
    //  Represents a two pieces of music played one after the other 
    // Rep Invariant
    //  two pieces of music are not null
    // Safety from Rep Exposure
    //  fields are all private and final
    //  immutable data type
    
    private final Music first;
    private final Music second;
    
    /*
     * assert the rep invariant
     */
    private void checkRep() {
        assert first != null;
        assert second != null;
    }
    
    /**
     * Make a Music sequence that plays first followed by second.
     * @param first music to play first
     * @param second music to play second
     */
    public Concat(Music first, Music second) {
        this.first = first;
        this.second = second;
        checkRep();
    }

    @Override
    public Fraction duration() {
        checkRep();
        return first.duration().add(second.duration());
    }

    @Override
    public void play(SequencePlayer player, int ticksPerBeat, int startTick, Fraction speed) {
        checkRep();
        this.first.play(player, ticksPerBeat, startTick, speed);
        this.second.play(player, ticksPerBeat, (this.first.duration().getNumerator() * ticksPerBeat) 
                / this.first.duration().getDenominator() + startTick, speed);
    }

    /**
     * @return the string representation of the first music concatenated with the string
     *          representation of the second music
     */
    @Override public String toString() {
        checkRep();
        return this.first.toString() + this.second.toString();
    }
    
    /**
     * @param thatObject the object to compare this object to
     * @return true of both the first and second musics of this and thatObject are equal
     *          false otherwise
     */
    @Override public boolean equals(Object thatObject) {
        checkRep();
        if ( ! (thatObject instanceof Concat)) { return false; }
        Concat that = (Concat)thatObject;
        return this.first.equals(that.first) && this.second.equals(that.second);
    }

    @Override public int hashCode() {
        checkRep();
        return (int)(this.duration().getNumerator());
    }

    @Override
    public Set<Integer> findDenominators() {
        checkRep();
        Set<Integer> s = new HashSet<>();
        s.addAll(first.findDenominators());
        s.addAll(second.findDenominators());
        return s;
    }

    @Override
    public Integer findNumTicks(int ticksPerBeat) {
        checkRep();
        return (this.duration().getNumerator() * ticksPerBeat) / this.duration().getDenominator();
    }
}