package abc.sound;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import abc.parser.MusicLexer;
import abc.parser.MusicParser;


/**
 * Music represents an immutable piece of music.
 */
public interface Music {
    //Data-type definition
    //Music = Note(Pitch p, double duration) 
    //  + Rest(double duration)
    //  + Concat(Music m1, Music m2) 
    //  + Together(Music m1, Music m2)
    //  + Tuplet(List<Music> m)
    
    
    
    /**
     * Parse from file with a specific key signature.
     * @param input music to parse.
     * @param keySignature the key for the file
     * @return a music that represents the string input
     * @throws IllegalArgumentException if the expression is invalid
     */
     public static Music parse(String input, Map<String, Integer> keySignature) throws IllegalArgumentException {
        try{
         
        CharStream stream = new ANTLRInputStream(input);
        MusicLexer lexer = new MusicLexer(stream);
        lexer.reportErrorsAsExceptions();
        
        TokenStream tokens = new CommonTokenStream(lexer);
        
        MusicParser parser = new MusicParser(tokens);
        parser.reportErrorsAsExceptions();
        
        ParseTree tree = parser.root();
        //System.err.println(tree.toStringTree(parser));


        MakeMusic musicMaker = new MakeMusic(keySignature);
        new ParseTreeWalker().walk(musicMaker, tree);

        return musicMaker.getMusic();
        }
        catch(ParseCancellationException e){
            throw new IllegalArgumentException(e.getMessage(), e.getCause());
        }
    }
    
    /**
     * @return total duration of this piece in beats
     */
    Fraction duration();
    
    /**
     * Play this piece.
     * @param player player to play on
     * @param atBeat when to play
     * @param speed the speed with which to play the beat (i.e 2.0 = double the speed)
     */
    void play(SequencePlayer player, int ticksPerBeat, int startTick, Fraction speed);
    
    /**
     * Returns the denominators of the note durations in the music.
     * @return a set of integers that are the denominators of the note durations in the music.
     */
    Set<Integer> findDenominators();
    
    /**
     * Find the number of ticks a piece of music takes.
     * @param ticksPerBeat
     * @param speed 
     * @return
     */
    Integer findNumTicks(int ticksPerBeat);
}

