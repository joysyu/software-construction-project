package abc.sound;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Note represents an immutable note played by the player
 *
 */
public class Note implements Music {
    // Abstraction Function
    //  Represents a note of music with some pitch and some duration
    // Rep Invariant
    //  pitch is not null and duration is greater than zero
    // Safety from Rep Exposure
    //  fields are all private and final
    //  immutable datatype

    private final Pitch pitch;
    private final Fraction duration;

    /*
     * assert the rep invariant
     */
    private void checkRep(){
        assert duration.getNumerator() > 0;
        assert duration.getDenominator() > 0;
        assert pitch != null;
    }

    /**
     * Make a Note played by instrument for duration beats.
     * @param duration duration in beats, must be >= 0
     * @param pitch pitch to play
     */
    public Note(Pitch p, Fraction duration) {
        this.pitch = p;
        this.duration = duration;
        checkRep();
    }

    /**
     * @return pitch of this note
     */
    public Pitch pitch(){
        checkRep();
        return this.pitch;
    }

    @Override
    public Fraction duration() {
        checkRep();
        return duration;
    }

    @Override
    public void play(SequencePlayer player, int ticksPerBeat, int startTick, Fraction speed) {
        //Figure out the number of beats a duration translates to:
        //first find the number of beats, which is duration.
        //then find the ticks per beat (LCM). then duration * ticks per beat = total ticks of note.
        //ticksPerBeat = ticksPerBeat * 2;
        //have ticksPerBeat divide itself by speed.

        player.addNote(this.pitch.toMidiNote(), startTick, 
                (this.duration.getNumerator() * ticksPerBeat * speed.getNumerator()) 
                / (speed.getDenominator() * this.duration.getDenominator()));
    }
    
    /**
     * @return a string with the pitch of the note, followed by the duration of the note
     */
    @Override public String toString() {
        checkRep();
        return this.pitch.toString() + this.duration + " ";
    }
    
    /**
     * @param thatObject the object to compare this object to
     * @return true of this and thatObject have the same pitch and duration
     *         false otherwise
     */
    @Override public boolean equals(Object thatObject) {
        if ( ! (thatObject instanceof Note)) { return false; }
        Note that = (Note)thatObject;
        checkRep();
        return this.pitch.equals(that.pitch) && this.duration.equals(that.duration);
    }
    
    @Override public int hashCode() {
        checkRep();
        return (int)this.duration.getDenominator();
    }

    @Override
    public Set<Integer> findDenominators() {
        return new HashSet<Integer>(Arrays.asList(this.duration.getDenominator()));
    }

    @Override
    public Integer findNumTicks(int ticksPerBeat) {
        return  (this.duration.getNumerator() * ticksPerBeat) / this.duration.getDenominator();
    }

}
