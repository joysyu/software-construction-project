package abc.player;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import abc.sound.LCM;
import abc.sound.Piece;

/**
 * Main entry point of your application.
 */
public class Main {

    /**
     * Plays the input file using Java MIDI API and displays
     * header information to the standard output stream.
     * 
     * (Your code should not exit the application abnormally using
     * System.exit().)
     * 
     * @param file the name of input abc file
     * @throws IOException 
     * @throws InterruptedException 
     * @throws InvalidMidiDataException 
     * @throws MidiUnavailableException 
     */
    public static void play(String file) throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException {
        Piece piece = new Piece(new File(file));
        System.out.println(piece.getHeader().toString());
        piece.play();
        Thread.sleep(100000);
    }

    public static void main(String[] args) throws IOException, MidiUnavailableException, InvalidMidiDataException, InterruptedException {
//        String fileToPlay = "sample_abc/fur_elise.abc";
        String fileToPlay = args[0];
        play(fileToPlay);        
    }
}
