package abc.sound;

import static org.junit.Assert.*;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

/**
 * Testing warmup sequences piece1.abc and piece2.abc
 * @author joysyu
 * @category no_didit
 */
public class SequencePlayerTest {
    
    //test for Piece1 (row row row your boat)
    @Test
    public void testPiece1() throws InterruptedException {
        try {
            SequencePlayer player = new SequencePlayer(140, 12);
            //wouldn't this have worked with new SequencePlater(140, 4)?
            //SequencePlayer( beats per minute, the default length is 1/4 and so a quarter note is 12 ticks)

            //12 ticks a beat. one beat.
            player.addNote(new Pitch('C').toMidiNote(), 0, 12);
            
            //12 ticks a beat. one beat.
            player.addNote(new Pitch('C').toMidiNote(), 12, 12);
            
            //12 ticks a beat. 3/4 beats.
            player.addNote(new Pitch('C').toMidiNote(), 24, 9);
            player.addNote(new Pitch('D').toMidiNote(), 33, 3);
            player.addNote(new Pitch('E').toMidiNote(), 36, 12);
            
            player.addNote(new Pitch('E').toMidiNote(), 48, 9);
            player.addNote(new Pitch('D').toMidiNote(), 57, 3);
            player.addNote(new Pitch('E').toMidiNote(), 60, 9);
            player.addNote(new Pitch('F').toMidiNote(), 69, 3);
            player.addNote(new Pitch('G').toMidiNote(), 72, 24);
            
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 96, 4); //this is like C/3. duration is 1/3.
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 100, 4);  //this is like C/3. duration is 1/3.
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 104, 4);
            player.addNote(new Pitch('G').toMidiNote(), 108, 4);
            player.addNote(new Pitch('G').toMidiNote(), 112, 4);
            player.addNote(new Pitch('G').toMidiNote(), 116, 4);
            player.addNote(new Pitch('E').toMidiNote(), 120, 4);
            player.addNote(new Pitch('E').toMidiNote(), 124, 4);
            player.addNote(new Pitch('E').toMidiNote(), 128, 4);
            player.addNote(new Pitch('C').toMidiNote(), 132, 4);
            player.addNote(new Pitch('C').toMidiNote(), 136, 4);
            player.addNote(new Pitch('C').toMidiNote(), 140, 4);
            
            player.addNote(new Pitch('G').toMidiNote(), 144, 9);
            player.addNote(new Pitch('F').toMidiNote(), 153, 3); //this is like F/4. duration is 0.25.
            player.addNote(new Pitch('E').toMidiNote(), 156, 9);
            player.addNote(new Pitch('D').toMidiNote(), 165, 3);
            player.addNote(new Pitch('C').toMidiNote(), 168, 24);

            String playerString = player.toString();
            String[] splitPlayerString = playerString.split("\\n");
            assertEquals(splitPlayerString[0], "Event: NOTE_ON  Pitch: 60  Tick: 0");
            assertEquals(splitPlayerString[1], "Event: NOTE_OFF Pitch: 60  Tick: 12");
            assertEquals(splitPlayerString[splitPlayerString.length-3], "Event: NOTE_ON  Pitch: 60  Tick: 168");
            assertEquals(splitPlayerString[splitPlayerString.length-2], "Event: NOTE_OFF Pitch: 60  Tick: 192");
            assertEquals(splitPlayerString[splitPlayerString.length-1], "Meta event: END_OF_TRACK Tick: 192");
            
            // play!
            player.play();
            Thread.sleep(10000);

            /*
             * Note: A possible weird behavior of the Java sequencer: Even if the
             * sequencer has finished playing all of the scheduled notes and is
             * manually closed, the program may not terminate. This is likely
             * due to daemon threads that are spawned when the sequencer is
             * opened but keep on running even after the sequencer is killed. In
             * this case, you need to explicitly exit the program with
             * System.exit(0).
             */
            // System.exit(0);

        } catch (MidiUnavailableException mue) {
            mue.printStackTrace();
        } catch (InvalidMidiDataException imde) {
            imde.printStackTrace();
        }
    }
    
    //test for piece2 (mario theme song)
    @Test
    public void testPiece2() throws InterruptedException {
        try {
            SequencePlayer player = new SequencePlayer(200, 12);
            

            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 0, 6);
            player.addNote(new Pitch('F').transpose(1).toMidiNote(), 0, 6);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 6, 6);
            player.addNote(new Pitch('F').transpose(1).toMidiNote(), 6, 6);
            //eighth rest +6ticks so it's like player.addNote(nothing, 12, 6);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 18, 6);
            player.addNote(new Pitch('F').transpose(1).toMidiNote(), 18, 6);
            //eighth rest +6ticks
            player.addNote(new Pitch('F').transpose(1).toMidiNote(), 30, 6);
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 30, 6);


            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 36, 12);
            player.addNote(new Pitch('F').toMidiNote(), 36, 12);
            
            player.addNote(new Pitch('G').toMidiNote(), 48, 12);
            player.addNote(new Pitch('B').toMidiNote(), 48, 12);
            player.addNote(new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote(), 48, 12);
            //quarter rest +12 ticks
            player.addNote(new Pitch('G').toMidiNote(), 72, 12);
            //quarter rest +12ticks
            
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 96, 18);
            player.addNote(new Pitch('G').toMidiNote(), 114, 6);
            //quarter rest +12ticks
            player.addNote(new Pitch('E').toMidiNote(), 132, 12);
            
            player.addNote(new Pitch('E').toMidiNote(), 144, 6);
            player.addNote(new Pitch('A').toMidiNote(), 150, 12);
            player.addNote(new Pitch('B').toMidiNote(), 162, 12);
            player.addNote(new Pitch('B').transpose(-1).toMidiNote(), 174, 6);
            player.addNote(new Pitch('A').toMidiNote(), 180, 12);
            
            player.addNote(new Pitch('G').toMidiNote(), 192, 8);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 200, 8);
            player.addNote(new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote(), 208, 8);
            player.addNote(new Pitch('A').transpose(Pitch.OCTAVE).toMidiNote(), 216, 12);
            player.addNote(new Pitch('F').transpose(Pitch.OCTAVE).toMidiNote(), 228, 6);
            player.addNote(new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote(), 234, 6);
            
            //eighth rest +6 ticks
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 246, 12);
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 258, 6);
            player.addNote(new Pitch('D').transpose(Pitch.OCTAVE).toMidiNote(), 264, 6);
            player.addNote(new Pitch('B').toMidiNote(), 270, 9);
            //3/8 rest +9ticks

            String playerString = player.toString();
            String[] splitPlayerString = playerString.split("\\n");
            assertEquals(splitPlayerString[0], "Event: NOTE_ON  Pitch: 76  Tick: 0");
            assertEquals(splitPlayerString[1], "Event: NOTE_ON  Pitch: 66  Tick: 0");
            assertEquals(splitPlayerString[splitPlayerString.length-3], "Event: NOTE_ON  Pitch: 71  Tick: 270");
            assertEquals(splitPlayerString[splitPlayerString.length-2], "Event: NOTE_OFF Pitch: 71  Tick: 279");
            assertEquals(splitPlayerString[splitPlayerString.length-1], "Meta event: END_OF_TRACK Tick: 279");
            
            // play!
            player.play();
            Thread.sleep(10000);
            
            /*
             * Note: A possible weird behavior of the Java sequencer: Even if the
             * sequencer has finished playing all of the scheduled notes and is
             * manually closed, the program may not terminate. This is likely
             * due to daemon threads that are spawned when the sequencer is
             * opened but keep on running even after the sequencer is killed. In
             * this case, you need to explicitly exit the program with
             * System.exit(0).
             */
            // System.exit(0);

        } catch (MidiUnavailableException mue) {
            mue.printStackTrace();
        } catch (InvalidMidiDataException imde) {
            imde.printStackTrace();
        }
    }

}
