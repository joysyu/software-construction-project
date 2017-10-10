package abc.sound;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

/**
 * Testing Piece class
 * @author Dora
 *
 */
public class PieceTest {
    // TESTING STRATEGY
    // test all the following pieces:
    // abc_song
    // fur_elise
    // invention
    // little_night_music
    // paddy
    // prelude
    // sample1, sample2, sample3
    // scale
    // waxies_dargle

    //test for abc_song
    @Test public void testAbcSong() throws IOException{
        Piece piece = new Piece(new File("sample_abc/abc_song.abc"));
        Header header = piece.getHeader();
        assertEquals("expected composer", "Traditional Kid's Song", header.getComposer());
        assertEquals("expected key", KeySignature.D_MAJOR, header.getKey());
        assertEquals("expected default length", new Fraction(1,4), header.getDefaultLength());
        assertEquals("expected meter", new Fraction(4,4), header.getMeter());
        assertEquals("expected tempo", new Fraction(100,1), header.getTempo().get(1));
        assertEquals("expected title", "Alphabet Song", header.getTitle());
        assertTrue("expected index number", 1== header.getIndexNumber());
    }

    //test for little_night_music
    @Test public void testLittleNightMusic() throws IOException {
        Piece piece = new Piece(new File("sample_abc/little_night_music.abc"));
        Header header = piece.getHeader();
        assertEquals("expected composer", "Wolfgang Amadeus Mozart", header.getComposer());
        assertEquals("expected key", KeySignature.G_MAJOR, header.getKey());
        assertEquals("expected default length", new Fraction(1,8), header.getDefaultLength());
        assertEquals("expected meter", new Fraction(4,4), header.getMeter());
        assertEquals("expected tempo", new Fraction(140,1), header.getTempo().get(1));
        assertEquals("expected title", "Little Night Music Mvt. 1", header.getTitle());
        assertTrue("expected index number", 1== header.getIndexNumber());
    }
    
    //test for paddy
    @Test public void testPaddy() throws IOException{
        Piece piece = new Piece(new File("sample_abc/paddy.abc"));
        Header header = piece.getHeader();
        assertEquals("expected composer", "Trad.", header.getComposer());
        assertEquals("expected key", KeySignature.D_MAJOR, header.getKey());
        assertEquals("expected default length", new Fraction(1,8), header.getDefaultLength());
        assertEquals("expected meter", new Fraction(6,8), header.getMeter());
        assertEquals("expected tempo", new Fraction(200,1), header.getTempo().get(1));
        assertEquals("expected title", "Paddy O'Rafferty", header.getTitle());
        assertTrue("expected index number", 1== header.getIndexNumber());
    }
    
    //test for fur_elise
    //parsing is not working rn
    @Test public void testFurElise() throws IOException{
        Piece piece = new Piece(new File("sample_abc/fur_elise.abc"));
        Header header = piece.getHeader();
        assertEquals("expected composer", "Ludwig van Beethoven", header.getComposer());
        assertEquals("expected key", KeySignature.A_MINOR, header.getKey());
        assertEquals("expected default length", new Fraction(1,16), header.getDefaultLength());
        assertEquals("expected meter", new Fraction(3,8), header.getMeter());
        assertEquals("expected tempo", new Fraction(140,1), header.getTempo().get(1));
        assertEquals("expected title", "Bagatelle No.25 in A, WoO.59", header.getTitle());
        assertTrue("expected index number", 1== header.getIndexNumber());
    }
    
    //test for invention
    @Test public void testInvention() throws IOException{
        Piece piece = new Piece(new File("sample_abc/invention.abc"));
        Header header = piece.getHeader();
        assertEquals("expected composer", "Johann Sebastian Bach", header.getComposer());
        assertEquals("expected key", KeySignature.C_MAJOR, header.getKey());
        assertEquals("expected default length", new Fraction(1,8), header.getDefaultLength());
        assertEquals("expected meter", new Fraction(4,4), header.getMeter());
        assertEquals("expected tempo", new Fraction(70,1), header.getTempo().get(1));
        assertEquals("expected title", "Invention no. 1", header.getTitle());
        assertTrue("expected index number", 1868== header.getIndexNumber());
    }

    //test for piece1
    @Test public void testPiece1() throws IOException{
        Piece piece = new Piece(new File("sample_abc/piece1.abc"));
        Header header = piece.getHeader();
        assertEquals("expected composer", "unknown", header.getComposer());
        assertEquals("expected key", KeySignature.C_MAJOR, header.getKey());
        assertEquals("expected default length", new Fraction(1,4), header.getDefaultLength());
        assertEquals("expected meter", new Fraction(4,4), header.getMeter());
        assertEquals("expected tempo", new Fraction(140,1), header.getTempo().get(1));
        assertEquals("expected title", "Piece No.1", header.getTitle());
        assertTrue("expected index number", 1== header.getIndexNumber());
    }
    
    //test for piece2
    @Test public void testPiece2() throws IOException{
        Piece piece = new Piece(new File("sample_abc/piece2.abc"));
        Header header = piece.getHeader();
        assertEquals("expected composer", "unknown", header.getComposer());
        assertEquals("expected key", KeySignature.C_MAJOR, header.getKey());
        assertEquals("expected default length", new Fraction(1,4), header.getDefaultLength());
        assertEquals("expected meter", new Fraction(4,4), header.getMeter());
        assertEquals("expected tempo", new Fraction(200,1), header.getTempo().get(1));
        assertEquals("expected title", "Piece No.2", header.getTitle());
        assertTrue("expected index number", 2 == header.getIndexNumber());
    }
    
    //test for prelude
    @Test public void testPrelude() throws IOException{
        Piece piece = new Piece(new File("sample_abc/prelude.abc"));
        Header header = piece.getHeader();
        assertEquals("expected composer", "Johann Sebastian Bach", header.getComposer());
        assertEquals("expected key", KeySignature.C_MAJOR, header.getKey());
        assertEquals("expected default length", new Fraction(1,16), header.getDefaultLength());
        assertEquals("expected meter", new Fraction(4,4), header.getMeter());
        assertEquals("expected tempo", new Fraction(70,1), header.getTempo().get(1));
        assertEquals("expected title", "Prelude BWV 846 no. 1", header.getTitle());
        assertTrue("expected index number", 8628== header.getIndexNumber());
    }
    
    //test for sample1
    @Test public void testSample1() throws IOException{
        Piece piece = new Piece(new File("sample_abc/sample1.abc"));
        Header header = piece.getHeader();
        assertEquals("expected key", KeySignature.C_MAJOR, header.getKey());
        assertEquals("expected title", "sample 1", header.getTitle());
        assertTrue("expected index number", 1== header.getIndexNumber());
    }
    
    //test for sample2
    @Test public void testSample2() throws IOException{
        Piece piece = new Piece(new File("sample_abc/sample2.abc"));
        Header header = piece.getHeader();
        assertEquals("expected key", KeySignature.C_MAJOR, header.getKey());
        assertEquals("expected title", "Chord", header.getTitle());
        assertTrue("expected index number", 8== header.getIndexNumber());
    }
    
    //test for sample3
    @Test public void testSample3() throws IOException{
        Piece piece = new Piece(new File("sample_abc/sample3.abc"));
        Header header = piece.getHeader();
        assertEquals("expected key", KeySignature.C_MINOR, header.getKey());
        assertEquals("expected title", "voices", header.getTitle());
        assertTrue("expected index number", 1 == header.getIndexNumber());
    }
    
    //test for scale
    @Test public void testScale() throws IOException{
        Piece piece = new Piece(new File("sample_abc/scale.abc"));
        Header header = piece.getHeader();
        assertEquals("expected composer", "Unknown", header.getComposer());
        assertEquals("expected key", KeySignature.C_MAJOR, header.getKey());
        assertEquals("expected default length", new Fraction(1,4), header.getDefaultLength());
        assertEquals("expected meter", new Fraction(4,4), header.getMeter());
        assertEquals("expected tempo", new Fraction(120,1), header.getTempo().get(1));
        assertEquals("expected title", "Simple scale", header.getTitle());
        assertTrue("expected index number", 1== header.getIndexNumber());
    }
    
    //test for waxies_dargle
    @Test public void testWaxiesDargle() throws IOException{
        Piece piece = new Piece(new File("sample_abc/waxies_dargle.abc"));
        Header header = piece.getHeader();
        assertEquals("expected key", KeySignature.G_MAJOR, header.getKey());
        assertEquals("expected default length", new Fraction(1,8), header.getDefaultLength());
        assertEquals("expected meter", new Fraction(4,4), header.getMeter());
        assertEquals("expected tempo", new Fraction(180,1), header.getTempo().get(1));
        assertEquals("expected title", "Waxie's Dargle", header.getTitle());
        assertTrue("expected index number", 2167== header.getIndexNumber());
    }
}
