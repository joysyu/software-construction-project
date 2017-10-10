package abc.sound;

import java.util.HashSet;
import java.util.Set;

/**
 * Together represents two pieces of music played at the same time.
 */
public class Together implements Music {
    // Abstraction Function
    //  Represents a two pieces of music, m1 and m2, played at the same time
    // Rep Invariant
    //  two pieces of music are not null
    //  duration is the duration of m1
    // Safety from Rep Exposure
    //  fields are all private and final
    
   private final Music m1;
   private final Music m2;
   private final Fraction duration;
    
   /*
    * assert the rep invariant
    */
   private void checkRep() {
       assert m1 != null;
       assert m2 != null;
       this.duration.equals(m1.duration());
   }
   
   /**
    * Make a Music sequence that plays m1 and m2 at the same time.
    * @param m1 music to play 
    * @param m2 music to play 
    */
    public Together(Music m1, Music m2) {
        this.m1 = m1; 
        this.m2 = m2;
        this.duration = m1.duration();
        checkRep();
    }

    @Override
    public Fraction duration() {
        checkRep();
        double m1Duration = (double) m1.duration().getNumerator() / (double) m1.duration().getDenominator();
        double m2Duration = (double) m2.duration().getNumerator() / (double) m2.duration().getDenominator();
        if (m1Duration > m2Duration){
            checkRep();
            return m1.duration();
        } else {
            checkRep();
            return m2.duration();
        }
    }

    @Override
    public void play(SequencePlayer player, int ticksPerBeat, int startTick, Fraction speed) {
        checkRep();
        Fraction m2Duration = m2.duration();
        Fraction m1Duration = m1.duration();
        Fraction s = speed;
        if (!m2Duration.equals(m1Duration)){
            s = new Fraction (m2Duration.getNumerator() * m1Duration.getDenominator() * speed.getNumerator(),
                    m2Duration.getDenominator() * m1Duration.getNumerator() * speed.getDenominator());
        }
        m1.play(player, ticksPerBeat, startTick, speed);
        m2.play(player, ticksPerBeat, startTick, s);
    }
    
    /**
     * @return a string representation of the first music followed by the second music,
     *          with the entire thing enclosed in square brackets
     */
    @Override public String toString() {
        checkRep();
        return "[" + this.m1.toString() + this.m2.toString() + "]";
    }
    
    /**
     * @param thatObject the object to compare this object to
     * @return true if the first and second musics of this and thatObject are equal
     *          false otherwise
     */
    @Override public boolean equals(Object thatObject) {
        checkRep();
        if ( ! (thatObject instanceof Together)) { return false; }
        Together that = (Together)thatObject;
        return this.m1.equals(that.m1) && this.m2.equals(that.m2) || (this.m2.equals(that.m1) && this.m1.equals(that.m2));
    }
    
    @Override public int hashCode() {
        checkRep();
        return duration().getNumerator();
    }

    @Override
    public Set<Integer> findDenominators() {
        checkRep();
        Set<Integer> s = new HashSet<Integer>();
        s.addAll(m1.findDenominators());
        s.addAll(m2.findDenominators());
        return s;
        }

    @Override
    public Integer findNumTicks(int ticksPerBeat) {
        checkRep();
        return (this.duration().getNumerator() * ticksPerBeat) / this.duration().getDenominator();
    }

}
