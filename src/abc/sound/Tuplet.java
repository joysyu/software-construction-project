package abc.sound;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Tuplet represents 2, 3, or 4 notes that are grouped together and played for an adjusted duration.
 */
public class Tuplet implements Music {
    // Abstraction Function
    //      Represents a tuplet of numNotes notes of music, where all notes have the same duration adjusted
    //  by an adjustment factor according to how many notes are in the tuplet.
    // Rep Invariant
    //  tuplet has either 2,3,4 notes:
    //      durationAdjustment is 3/2 for 2 notes
    //      durationAdjustment is 2/3 for 3 notes
    //      durationAdjustment is 3/4 for 4 notes
    //  numNotes always equals the size of notes
    // Safety from Rep Exposure
    //  fields are all private and final
    private final int numNotes;
    private final List<Music> notes;
    private final Fraction durationAdjustment;
    
    /*
     * assert the rep invariant
     */
    private void checkRep(){
        assert numNotes == notes.size();
        assert (numNotes == 2 | numNotes == 3 | numNotes == 4);
        if (numNotes == 2){
            assert durationAdjustment.equals(new Fraction(3,2));
        } else if (numNotes == 3){
            assert durationAdjustment.equals(new Fraction(2,3));
        } else if (numNotes == 4){
            assert durationAdjustment.equals(new Fraction(3,4));
        }
    }

    /**
     * Makes a tuplet object with numNotes notes that are in notes.
     * @param numNotes the number of notes in the tuplet, can be either 2, 3, or 4.
     * @param notes the Music notes that make up the tuplet.
     */
    public Tuplet(int numNotes, List<Music> notes) {
        assert  1 < numNotes && 5 > numNotes;
        assert numNotes == notes.size();
        this.numNotes = numNotes;
        this.notes = notes;
        if(this.numNotes == 2){
            this.durationAdjustment = new Fraction(3, 2);
        }
        else if(this.numNotes ==3){
            this.durationAdjustment = new Fraction(2, 3);
        }
        else{
            this.durationAdjustment = new Fraction(3, 4);
        }
        checkRep();

    }

    @Override
    public Fraction duration() {
        checkRep();
        Fraction duration = notes.get(0).duration();
        int top = this.numNotes*duration.getNumerator()*this.durationAdjustment.getNumerator();
        int bottom = duration.getDenominator()*this.durationAdjustment.getDenominator();
        checkRep();
        return new Fraction(top, bottom);
    }

    @Override
    public void play(SequencePlayer player, int ticksPerBeat, int startTick, Fraction speed) {
        checkRep();
        int currentTick = startTick;
        for (Music m: notes){
            m.play(player, ticksPerBeat, currentTick, 
                    new Fraction(speed.getNumerator()*durationAdjustment.getNumerator(), 
                            (speed.getDenominator() * durationAdjustment.getDenominator())));
            currentTick += m.findNumTicks(ticksPerBeat) * speed.getNumerator() * durationAdjustment.getNumerator() / 
                    (speed.getDenominator() * durationAdjustment.getDenominator());
        }
    }

    /**
     * @return a string representation with the number of notes in the tuplet, 
     *          followed by an open parenthesis and the notes in the tuplet
     */
    @Override public String toString() {
        String notesList = "";
        for (int i =0; i<notes.size();i++) { notesList += notes.get(i); }
        checkRep();
        return "(" + this.numNotes + notesList;
    }

    /**
     * @param thatObject the object to compare this object to
     * @return true if this and thatObject have the same number of notes and the same notes in the tuplet
     *          false otherwise
     */
    @Override public boolean equals(Object thatObject) {
        checkRep();
        if ( ! (thatObject instanceof Tuplet)) { return false; }
        Tuplet that = (Tuplet)thatObject;
        return this.numNotes==that.numNotes && this.notes.equals(that.notes)
                && this.durationAdjustment.equals(that.durationAdjustment);
    }
    
    @Override public int hashCode() {
        checkRep();
        return numNotes+durationAdjustment.getNumerator();
    }

    @Override
    public Set<Integer> findDenominators() {
        checkRep();
        Set<Integer> s = new HashSet<Integer>();
        for (Music note: notes){
            s.addAll(note.findDenominators());
        }
        s.add(this.durationAdjustment.getDenominator());
        return s;
    }

    @Override
    public Integer findNumTicks(int ticksPerBeat) {
        checkRep();
        return (this.duration().getNumerator() * ticksPerBeat) / this.duration().getDenominator();
    }
}
