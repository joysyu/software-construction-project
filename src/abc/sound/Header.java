package abc.sound;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import abc.parser.HeaderLexer;
import abc.parser.HeaderParser;

/**
 * Represents the header of a piece of music.
 * @author joysyu
 *
 */
public class Header{
    //AF: 
    //  represents the header of a piece of music.
    //      indexNumber represents the index number of the piece of music
    //      title represents the title of the piece of music
    //      key represents the key signature of the piece of music
    //      composer represents the composer of the piece of music
    //      meter represents the meter of the music
    //      defaultLength represents the default length or duration of a note
    //      noteThatKeepsBeat represents the beat length that the tempo is based on
    //      tempo represents the tempo of the music in beats per music
    //      meterSet represents whether or not the meter has been specified in the music
    //      defaultLengthSet represents whether or not the default length of a note has been specified in the music
    //      tempoSet represents whether or not the tempo has been specified in the music

    //RI:
    //  all fields are not null
    //  tempo >0

    private int indexNumber;
    private String title;
    private KeySignature key;
    //optional fields have default values

    private String composer = "unknown";
    private Fraction meter = new Fraction(4,4);
    private Fraction defaultLength = new Fraction(1,8);
    private Fraction noteThatKeepsBeat = defaultLength;
    private int tempo = 100;

    private boolean meterSet = false;
    private boolean defaultLengthSet = false;
    private boolean tempoSet = false;

    /**
     * Check if representation is valid.
     */
    private void checkRep(){
        assert key != null;
        assert composer != null;
        assert meter != null;
        assert defaultLength != null;
        assert noteThatKeepsBeat != null;
        assert tempo > 0;
    }

    /**
     * Make a Header
     * @param indexNumber the index number
     * @param title the title of the piece
     * @param key the key signature of the piece
     */
    public Header(int indexNumber, String title, KeySignature key){
        this.indexNumber = indexNumber;
        this.title = title;
        this.key = key;
        checkRep();
    }

    /**
     * Get the index number.
     * @return index number
     */
    public int getIndexNumber(){
        checkRep();
        return this.indexNumber;
    }
    
    /**
     * Get the title of the piece
     * @return title the title of the piece
     */
    public String getTitle(){
        checkRep();
        return this.title;
    }
    
    /**
     * Get the key signature of the piece
     * @return key signature
     */
    public KeySignature getKey(){
        checkRep();
        return this.key;
    }
    
    //optional fields will have set methods to replace the default values.
    /**
     * Set the name of the compose to be composer
     * @param composer the name of the composer
     */
    public void setComposer(String composer){
        this.composer = composer;
        checkRep();
    }
    
    /**
     * Get the composer
     * @return name of composer
     */
    public String getComposer(){
        checkRep();
        return this.composer;
    }
    
    /**
     * Set default_length
     * @param default_length the duration of a note
     */
    public void setDefaultLength(Fraction default_length){
        this.defaultLength = default_length;
        this.defaultLengthSet = true;
        checkRep();
    }
    
    /**
     * Get the default length of a note
     * @return the default length of a note
     */
    public Fraction getDefaultLength(){
        updateDefaultLength();
        checkRep();
        return this.defaultLength;
    }
    
    /**
     * If defaultLength is not set when parsing, then update default
     * length according to the following rules:
     *  -if meter is not set, then default length is 1/8
     *  -if meter is set and <0.75, default length is 1/16
     *  -if meter is set and >=0.75, default length is 1/8
     */
    private void updateDefaultLength(){
        if (!defaultLengthSet){
            if (meterSet){
                if ((double)meter.getNumerator()/meter.getDenominator() < 0.75){
                    defaultLength = new Fraction(1,16);
                } else {
                    defaultLength = new Fraction(1,8);
                }
            } else {
                defaultLength = new Fraction(1,8);
            }
        }
        checkRep();
    }

    /**
     * Set the meter of the piece
     * @param meter the meter
     */
    public void setMeter(Fraction meter){
        this.meter = meter;
        this.meterSet = true;
        checkRep();
    }
    
    /**
     * Get the meter of the piece
     * @return meter
     */
    public Fraction getMeter(){
        checkRep();
        updateDefaultLength();
        return this.meter;
    }

    /**
     * Set the tempo of the piece
     * @param noteThatKeepsBeat
     * @param tempo tempo > 0
     */
    public void setTempo(Fraction noteThatKeepsBeat, int tempo){
        this.noteThatKeepsBeat = noteThatKeepsBeat;
        this.tempo = tempo;
        this.tempoSet = true;
        checkRep();
    }

    /**
     * Get the tempo of the piece.
     * If the tempo isn't specified, then it is 100 beats per minute, with the beat length
     * being the same as the default length of a note in the piece
     * @return a list of two fractions, the first one is the length of the length of the note that 
     * keeps the beat, the second one is the tempo itself (number of beats per minute).
     */
    public List<Fraction> getTempo(){
        if (!tempoSet){
            updateDefaultLength();
            this.noteThatKeepsBeat = this.defaultLength;
        }
        List<Fraction> list = new ArrayList<>();
        list.add(this.noteThatKeepsBeat);
        list.add(new Fraction(this.tempo, 1));
        checkRep();
        return list;
    }

    /**
     * Factory creator Method to make a Header from a given String. 
     * Parses the String and uses the parsed information to create a corresponding Header.
     * @param fileName the name of the file. String should match the Header.g4 grammar.
     * @return a Header with mandatory fields of index number, title, and key.
     */
    public static Header makeHeader(String fileData) throws IllegalArgumentException {
        try {
        //producer that takes in file, parses the file, and fills in the private fields.
        
        //create stream of characters from the string
        CharStream stream = new ANTLRInputStream(fileData);
        
        //make a parser
        HeaderParser HeaderParser = makeHeaderParser(stream);
        
        //generate the parse tree using the starter rule.
        //Header is the starter rule for this grammar.
        ParseTree tree = HeaderParser.header();
        
        MakeHeader HeaderMaker = new MakeHeader();
        new ParseTreeWalker().walk(HeaderMaker, tree);
        Header Header = HeaderMaker.parseToGetHeader();
        return Header;
        } catch(ParseCancellationException e) {
            throw new IllegalArgumentException(e.getMessage(), e.getCause());
        }
    }

    /**
     * Make parser for the Header of the abc file.
     * @param stream
     * @return a parser for the Header
     */
    private static HeaderParser makeHeaderParser(CharStream stream) {
        // Make a lexer.  This converts the stream of characters into a 
        // stream of tokens.  A token is a character group, like "<i>"
        // or "</i>".  Note that this doesn't start reading the character stream yet,
        // it just sets up the lexer to read it.
        HeaderLexer lexer = new HeaderLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);
        
        // Make a parser whose input comes from the token stream produced by the lexer.
        HeaderParser parser = new HeaderParser(tokens);
        parser.reportErrorsAsExceptions();
        
        return parser;
    }
    
    @Override
    /**
     * A readable String representation of the header
     */
    public String toString(){
        return "indexNumber: " + indexNumber + " title: " + title + " key: " + key +
                " composer: " + composer + " default_length: " + defaultLength +
                " meter: " + meter + " tempo: " + noteThatKeepsBeat + "=" + tempo;
    }
}