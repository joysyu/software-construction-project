package abc.sound;

import java.util.HashMap;
/**
 * All possible Key Signatures are mapped to the number of semitones that need to be adjusted
 * for each basenote in the key.
 * @author joysyu
 *
 */
public class KeySignatureToTranspose{
    //Key Signature Map is:
    //  <KeySignature :  <basenote : integer> >
    //AF:
    //  the integer represents the number of semitones the basenote needs to be transposed.
    //sharp is +1
    //flat is -1.
    //the basenote is in the map only if the integer != 0.
    
    //For example, C_MAJOR and A_MINOR are not in the map because they do not map to any basenotes
    //  that are tranposed in their respective keys.
    //For example, D_MAJOR is in the map and would be mapped to a map with one key-value pair.
    
    public final static HashMap<KeySignature, HashMap<String, Integer>> KEY_SIGNATURE; 
//                            
    static{
        KEY_SIGNATURE = new HashMap<KeySignature, HashMap<String, Integer>>();

        final HashMap<String, Integer> C_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> A_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> G_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> E_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> F_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> D_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> D_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> B_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> B_FLAT_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> G_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> A_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> F_SHARP_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> E_FLAT_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> C_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> E_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> C_SHARP_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> A_FLAT_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> F_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> B_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> G_SHARP_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> D_FLAT_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> B_FLAT_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> F_SHARP_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> D_SHARP_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> G_FLAT_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> E_FLAT_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> C_SHARP_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> A_SHARP_MINOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> C_FLAT_MAJOR = new HashMap<String, Integer>();
        final HashMap<String, Integer> A_FLAT_MINOR = new HashMap<String, Integer>();
        //no sharps or flats
        //C major and A Minor aren"t in map because they have no notes to tranpose.
    
        // 1 sharp: F sharp
        G_MAJOR.put("F",1);
        E_MINOR.put("F",1);
    
        // 1 flat: B flat
        F_MAJOR.put("B",-1);
        D_MINOR.put("B",-1);
    
        // 2 sharps: F sharp, C sharp
        D_MAJOR.put("F",1);
        B_MINOR.put("F",1);
        D_MAJOR.put("C",1);
        B_MINOR.put("C",1);
    
        // 2 flats: B flat, E flat
        B_FLAT_MAJOR.put("B",-1);
        G_MINOR.put("B",-1);
        B_FLAT_MAJOR.put("E",-1);
        G_MINOR.put("E",-1);
    
        // 3 sharps: F, C, G
        A_MAJOR.put("F",1);
        F_SHARP_MINOR.put("F",1);
        A_MAJOR.put("C",1);
        F_SHARP_MINOR.put("C",1);
        A_MAJOR.put("G",1);
        F_SHARP_MINOR.put("G",1);
    
        // 3 flats: B, E, A
        E_FLAT_MAJOR.put("B",-1);
        C_MINOR.put("B",-1);
        E_FLAT_MAJOR.put("E",-1);
        C_MINOR.put("E",-1);
        E_FLAT_MAJOR.put("A",-1);
        C_MINOR.put("A",-1);
    
        // 4 sharps: F, C, G, D
        E_MAJOR.put("F",1);
        C_SHARP_MINOR.put("F",1);
        E_MAJOR.put("C",1);
        C_SHARP_MINOR.put("C",1);
        E_MAJOR.put("G",1);
        C_SHARP_MINOR.put("G",1);
        E_MAJOR.put("D",1);
        C_SHARP_MINOR.put("D",1);
    
        // 4 flats: B, E, A, D
        A_FLAT_MAJOR.put("B",-1);
        F_MINOR.put("B",-1);
        A_FLAT_MAJOR.put("E",-1);
        F_MINOR.put("E",-1);
        A_FLAT_MAJOR.put("A",-1);
        F_MINOR.put("A",-1);
        A_FLAT_MAJOR.put("D",-1);
        F_MINOR.put("D",-1);
    
        // 5 sharps: F, C, G, D, A
        B_MAJOR.put("F",1);
        G_SHARP_MINOR.put("F",1);
        B_MAJOR.put("C",1);
        G_SHARP_MINOR.put("C",1);
        B_MAJOR.put("G",1);
        G_SHARP_MINOR.put("G",1);
        B_MAJOR.put("D",1);
        G_SHARP_MINOR.put("D",1);
        B_MAJOR.put("A",1);
        G_SHARP_MINOR.put("A",1);
    
        // 5 flats: B, E, A, D, G
        D_FLAT_MAJOR.put("B", -1);
        B_FLAT_MINOR.put("B", -1);
        D_FLAT_MAJOR.put("E", -1);
        B_FLAT_MINOR.put("E", -1);
        D_FLAT_MAJOR.put("A", -1);
        B_FLAT_MINOR.put("A", -1);
        D_FLAT_MAJOR.put("D", -1);
        B_FLAT_MINOR.put("D", -1);
        D_FLAT_MAJOR.put("G", -1);
        B_FLAT_MINOR.put("G", -1);
    
        // 6 sharps: F, C, G, D, A, E
        F_SHARP_MAJOR.put("F",1);
        D_SHARP_MINOR.put("F",1);
        F_SHARP_MAJOR.put("C",1);
        D_SHARP_MINOR.put("C",1);
        F_SHARP_MAJOR.put("G",1);
        D_SHARP_MINOR.put("G",1);
        F_SHARP_MAJOR.put("D",1);
        D_SHARP_MINOR.put("D",1);
        F_SHARP_MAJOR.put("A",1);
        D_SHARP_MINOR.put("A",1);
        F_SHARP_MAJOR.put("E",1);
        D_SHARP_MINOR.put("E",1);
    
        // 6 flats: B, E, A, D, G, C
        G_FLAT_MAJOR.put("B", -1);
        E_FLAT_MINOR.put("B", -1);
        G_FLAT_MAJOR.put("E", -1);
        E_FLAT_MINOR.put("E", -1);
        G_FLAT_MAJOR.put("A", -1);
        E_FLAT_MINOR.put("A", -1);
        G_FLAT_MAJOR.put("D", -1);
        E_FLAT_MINOR.put("D", -1);
        G_FLAT_MAJOR.put("G", -1);
        E_FLAT_MINOR.put("G", -1);
        G_FLAT_MAJOR.put("C", -1);
        E_FLAT_MINOR.put("C", -1);
    
        // 7 sharps: F, C, G, D, A, E, B
        C_SHARP_MAJOR.put("F",1);
        A_SHARP_MINOR.put("F",1);
        C_SHARP_MAJOR.put("C",1);
        A_SHARP_MINOR.put("C",1);
        C_SHARP_MAJOR.put("G",1);
        A_SHARP_MINOR.put("G",1);
        C_SHARP_MAJOR.put("D",1);
        A_SHARP_MINOR.put("D",1);
        C_SHARP_MAJOR.put("A",1);
        A_SHARP_MINOR.put("A",1);
        C_SHARP_MAJOR.put("E",1);
        A_SHARP_MINOR.put("E",1);
        C_SHARP_MAJOR.put("B",1);
        A_SHARP_MINOR.put("B",1);
    
        // 7 flats: B, E, A, D, G, C, F
        C_FLAT_MAJOR.put("B", -1);
        A_FLAT_MINOR.put("B", -1);
        C_FLAT_MAJOR.put("E", -1);
        A_FLAT_MINOR.put("E", -1);
        C_FLAT_MAJOR.put("A", -1);
        A_FLAT_MINOR.put("A", -1);
        C_FLAT_MAJOR.put("D", -1);
        A_FLAT_MINOR.put("D", -1);
        C_FLAT_MAJOR.put("G", -1);
        A_FLAT_MINOR.put("G", -1);
        C_FLAT_MAJOR.put("C", -1);
        A_FLAT_MINOR.put("C", -1);
        C_FLAT_MAJOR.put("F", -1);
        A_FLAT_MINOR.put("F", -1);
        
        KEY_SIGNATURE.put(KeySignature.C_MAJOR,  C_MAJOR);
        KEY_SIGNATURE.put(KeySignature.A_MINOR,  A_MINOR);
        KEY_SIGNATURE.put(KeySignature.G_MAJOR, G_MAJOR);
        KEY_SIGNATURE.put(KeySignature.E_MINOR, E_MINOR);
        KEY_SIGNATURE.put(KeySignature.F_MAJOR, F_MAJOR);
        KEY_SIGNATURE.put(KeySignature.D_MINOR, D_MINOR);
        KEY_SIGNATURE.put(KeySignature.D_MAJOR, D_MAJOR);
        KEY_SIGNATURE.put(KeySignature.B_MINOR, B_MINOR);
        KEY_SIGNATURE.put(KeySignature.B_FLAT_MAJOR, B_FLAT_MAJOR);
        KEY_SIGNATURE.put(KeySignature.G_MINOR, G_MINOR);
        KEY_SIGNATURE.put(KeySignature.A_MAJOR, A_MAJOR);
        KEY_SIGNATURE.put(KeySignature.F_SHARP_MINOR, F_SHARP_MINOR);
        KEY_SIGNATURE.put(KeySignature.E_FLAT_MAJOR, E_FLAT_MAJOR);
        KEY_SIGNATURE.put(KeySignature.C_MINOR, C_MINOR);
        KEY_SIGNATURE.put(KeySignature.E_MAJOR, E_MAJOR);
        KEY_SIGNATURE.put(KeySignature.C_SHARP_MINOR, C_SHARP_MINOR);
        KEY_SIGNATURE.put(KeySignature.A_FLAT_MAJOR, A_FLAT_MAJOR);
        KEY_SIGNATURE.put(KeySignature.F_MINOR, F_MINOR);
        KEY_SIGNATURE.put(KeySignature.B_MAJOR, B_MAJOR);
        KEY_SIGNATURE.put(KeySignature.G_SHARP_MINOR, G_SHARP_MINOR);
        KEY_SIGNATURE.put(KeySignature.D_FLAT_MAJOR, D_FLAT_MAJOR);
        KEY_SIGNATURE.put(KeySignature.B_FLAT_MINOR, B_FLAT_MINOR);
        KEY_SIGNATURE.put(KeySignature.F_SHARP_MAJOR, F_SHARP_MAJOR);
        KEY_SIGNATURE.put(KeySignature.D_SHARP_MINOR, D_SHARP_MINOR);
        KEY_SIGNATURE.put(KeySignature.G_FLAT_MAJOR, G_FLAT_MAJOR);
        KEY_SIGNATURE.put(KeySignature.E_FLAT_MINOR, E_FLAT_MINOR);
        KEY_SIGNATURE.put(KeySignature.C_SHARP_MAJOR, C_SHARP_MAJOR);
        KEY_SIGNATURE.put(KeySignature.A_SHARP_MINOR, A_SHARP_MINOR);
        KEY_SIGNATURE.put(KeySignature.C_FLAT_MAJOR, C_FLAT_MAJOR);
        KEY_SIGNATURE.put(KeySignature.A_FLAT_MINOR, A_FLAT_MINOR);
        }
}