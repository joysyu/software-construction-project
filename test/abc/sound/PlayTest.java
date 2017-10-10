package abc.sound;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

/**
 * PlayTest will test all the play methods of the music variants
 * @author Dora
 * @category no_didit
 *
 */
public class PlayTest {
    //TESTING STRATEGY
    // test play method for all of the following:
    // Note
    // Rest
    // Concat
    // Together
    // Tuplet
    
    //test for Note
    @Test public void playNoteTest() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
        SequencePlayer player = new SequencePlayer(120, 4);
        Pitch pitch = new Pitch('D');
        Note note = new Note(pitch, new Fraction(3,1));        
        int ticksPerBeat = 1;
        int startTick = 0;
        note.play(player, ticksPerBeat, startTick, new Fraction(1,1));
        player.play();
        Thread.sleep(1000);
    }
    
    //test for Rest
    @Test public void playRestTest() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
        SequencePlayer player = new SequencePlayer(200, 12);
        Rest rest = new Rest(new Fraction(4,1));
        int ticksPerBeat = 2;
        int startTick = 0;
        rest.play(player, ticksPerBeat, startTick, new Fraction(1,1));
        player.play();
        Thread.sleep(1000);
    }
    
    //test for Concat
    @Test public void playConcatTest() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
        SequencePlayer player = new SequencePlayer(100, 12);
        Note note = new Note(new Pitch('C'), new Fraction(4,1));
        Concat concat = new Concat(note, note);
        int ticksPerBeat = 1;
        int startTick = 0;
        concat.play(player, ticksPerBeat, startTick,new Fraction(1,1));
        player.play();
        Thread.sleep(1000);
    }
    
    //test for Together
    @Test public void playTogetherTest() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
        SequencePlayer player = new SequencePlayer(100, 12);
        Note note1 = new Note(new Pitch('D'), new Fraction(3, 1));
        Note note2 = new Note(new Pitch('C'), new Fraction(9, 1));
        Together together = new Together(note1, note2);
        int ticksPerBeat = 1;
        int startTick = 0;
        together.play(player, ticksPerBeat, startTick, new Fraction(1,1));
        player.play();
        Thread.sleep(1000);
    }
    
    //test for Tuplet
    @Test public void playTupletTest() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
            SequencePlayer player = new SequencePlayer(100, 12);
            Note note1 = new Note(new Pitch('D'), new Fraction(4, 1));
            Note note2 = new Note(new Pitch('C'), new Fraction(4, 1));
            Tuplet tuplet = new Tuplet(2, Arrays.asList(note1, note2));
            int ticksPerBeat = 1;
            int startTick = 0;
            tuplet.play(player, ticksPerBeat, startTick, new Fraction(1,1));
            player.play();
            Thread.sleep(1000);
        }
    
    @Test public void playAbcSong() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/abc_song.abc"));
        piece.play();
        Thread.sleep(100000);
    }

    @Test public void playPaddy() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/paddy.abc"));
        piece.play();
        Thread.sleep(100000);
    }
    
    @Test public void playLittleNightMusic() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/little_night_music.abc"));
        piece.play();
        Thread.sleep(100000);
    }
    
    @Test public void playPrelude() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/prelude.abc"));
        piece.play();
        Thread.sleep(100000);
    }
    
    @Test public void playPiece1() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/piece1.abc"));
        piece.play();
        Thread.sleep(100000);
    }
    
    @Test public void playPiece2() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/piece2.abc"));
        piece.play();
        Thread.sleep(100000);
    }
    
    @Test public void playScale() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/scale.abc"));
        piece.play();
        Thread.sleep(100000);
    }
    
    @Test public void playWaxiesDargle() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/waxies_dargle.abc"));
        piece.play();
        Thread.sleep(100000);
    }
    
    @Test public void playInvention() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/invention.abc"));
        piece.play();
        Thread.sleep(100000);
    }
    
    @Test public void playSample1() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/sample1.abc"));
        piece.play();
        Thread.sleep(1000000);
    }

    @Test public void playSample2() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/sample2.abc"));
        piece.play();
        Thread.sleep(100000);
    }
    
    @Test public void playSample3() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/sample3.abc"));
        piece.play();
        Thread.sleep(100000);
    }
    @Test public void playFurElise() throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        Piece piece = new Piece(new File("sample_abc/fur_elise.abc"));
        piece.play();
        Thread.sleep(1000000);
    }
}
