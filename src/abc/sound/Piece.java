package abc.sound;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 * Immutable class representing a piece of music, including the header and the music.
 */
public class Piece{
    private static final String DEFAULT_VOICE = "DEFAULT";
    
    private final Header header;
    private final KeySignature key;
    private final Fraction length;
    private final List<Fraction> tempo;
    private final Map<String, Music> voiceMap;
    private final Map<String, Integer> keySignatureMap;
    
    private int ticksPerBeat;
    private int adjustedTempo;
    
    /**
     * Make A piece of music from an abc file
     * @param fileName an abc file that has a header component that satisfies the Header.g4 grammar
     * and a music component that satisfies the Music.g4 grammar.
     * @throws IOException
     */
    public Piece(File fileName) throws IOException{
       String headerString = "";
       String musicString = "";
       String line = null;
       List<String> voices = new ArrayList<String>();
       voices.add(DEFAULT_VOICE);
       
       //first split the file into the header and music. Also initialize map of voices to lists of musics
       boolean isMusic = false;
       BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
       
       //create the header string.
       while ((line = bufferedReader.readLine()) != null && !isMusic) {           
           headerString = headerString + line + "\n";
           //end of the header
           if (line.startsWith("K")) {
               isMusic = true;
               }
           }
       
       //create the music string
       while (line != null){
           if(line.trim().equals("") || line.trim().charAt(0) == '%'){
               line = bufferedReader.readLine();
               continue;
               }
           if (line.startsWith("V")){
               if(!voices.contains(line)){
                   voices.add(line);
                   }
               musicString += line + "\n";
               }
           else {
               musicString += line + "\n";
               }
           line = bufferedReader.readLine();
           }
       bufferedReader.close();
       headerString = headerString.trim();
       musicString = musicString.trim();

       //assign header values.
       this.header = Header.makeHeader(headerString);
       this.key = header.getKey();
       this.length = header.getDefaultLength();
       this.tempo = header.getTempo();
       this.keySignatureMap = KeySignatureToTranspose.KEY_SIGNATURE.get(this.key);

       //Create the musics
       this.voiceMap = splitMusicVoices(musicString,voices);

       calculateAdjustedTempo();
       calculateTicksPerBeat();
    }

    /**
     * private helper method that sets the adjusted tempo.
     */
    private void calculateAdjustedTempo(){
      //Adjust the tempo of the piece
        this.adjustedTempo = this.tempo.get(1).getNumerator();
        if (!this.tempo.get(0).simplify().equals(length)){
            Fraction adjustedTempoFrac = new Fraction(this.tempo.get(0).getNumerator() * length.getDenominator() * adjustedTempo, this.tempo.get(0).getDenominator() * length.getNumerator());
            adjustedTempo = adjustedTempoFrac.getNumerator() / adjustedTempoFrac.getDenominator();
        }
    }

    /**
     * private helper method that sets the number of ticks per beat.
     */
    private void calculateTicksPerBeat(){
      //get ticksPerBeat by finding the least common multiple of all the denominators of note lengths
        if (voiceMap.size() != 0){
        Set<Integer> denominators = new HashSet<>();
        for(String key: voiceMap.keySet()){
            denominators.addAll(voiceMap.get(key).findDenominators());
        }
        int[] denoms = new int[denominators.size()];
        int i = 0;
        for (int denom: denominators){
            denoms[i] = denom;
            i++;
        }
        this.ticksPerBeat = LCM.lcm(denoms);
        }
    }

    /**
     * Get the header.
     * @return the header of the music piece
     */
    public Header getHeader(){
        return this.header;
    }

    /**
     * Creates a map that maps each voice to a string to be parsed as music
     * @param music the String of music
     * @param voices the list of voices
     * @return a map with each voice mapped to its respective music
     * @throws IOException
     */
    private Map<String, Music> splitMusicVoices(String music, List<String> voices) throws IOException {
        Map<String, String> collectMusic = new HashMap<>();
        Map<String, Music> musicByVoices = new HashMap<>();

        String currentVoice = DEFAULT_VOICE;
        String line = null;
        BufferedReader buffReader = new BufferedReader(new StringReader(music));
                
        //Assign music to voices and combine all the music of the same voice
        while ((line = buffReader.readLine()) != null) {
            if (line.startsWith("V")) { 
                currentVoice = line; 
            } else {
                if(!collectMusic.containsKey(currentVoice)){
                    collectMusic.put(currentVoice, line.trim());
                }
                else{
                    String currentMusic = collectMusic.get(currentVoice);
                    //Don't put two bars right next to one another
                    if(currentMusic.substring(currentMusic.length()-1).equals("|") &&
                            line.substring(0,1).equals("|") ) {
                        line = line.substring(1, line.length());
                    }
                    collectMusic.put(currentVoice, currentMusic + line.trim());
                    
                }
            }
        }
        for(String voice: collectMusic.keySet()){
            if(( !collectMusic.get(voice).endsWith("|") && !collectMusic.get(voice).endsWith("]") ) || !collectMusic.get(voice).contains("|")){
                collectMusic.put(voice, collectMusic.get(voice)+ "|");
            }
            musicByVoices.put(voice, Music.parse(collectMusic.get(voice), keySignatureMap));
        }
        return musicByVoices;
    
    }

    /**
     * play this piece of music
     * @throws InvalidMidiDataException 
     * @throws MidiUnavailableException 
     * @throws InterruptedException 
     */
    public void play() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException{
        SequencePlayer player = new SequencePlayer(adjustedTempo, ticksPerBeat);
        int startTick = 0;        
        for (String voice: voiceMap.keySet()){
            voiceMap.get(voice).play(player, ticksPerBeat, startTick, new Fraction(1,1));
            }
        player.play();
        Thread.sleep(1000);
        }
}
