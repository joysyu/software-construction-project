/*
 * Compile all your grammars using
 *       java -jar ../../../lib/antlr.jar *.g4
 * then Refresh in Eclipse.
 */
grammar Music;
import Configuration;

root : music EOF;
music : '|'? measure+;
measure : normal_measure | start_repeat | double_bar | first_ending | second_ending | end_repeat;
first_ending : '[1' normal_measure* end_repeat;
second_ending : '[2' normal_measure* double_bar?;
normal_measure : element+ ('|' | start_repeat);
double_bar : element+ ('||' | '[|' | '|]');
start_repeat : '|:' element+ ('|' | ':|');
end_repeat : element+ ':|';

element : note_element | tuplet_element | WHITESPACE;
note_element : note | multi_note;
multi_note : '[' note+ ']';
note : (pitch | rest) note_length?;
pitch : accidental? BASENOTE octave? ;
rest : 'z';
note_length : ((DIGIT+)? '/' (DIGIT+)?) | DIGIT+;
tuplet_element : tuplet_spec note_element+;
tuplet_spec : '(' DIGIT;
comment : '%' ~NEWLINE* NEWLINE;

accidental: SHARP | FLAT | NATURAL;
octave: OCTAVE_UP | OCTAVE_DOWN;

SHARP: '^' | '^^';
FLAT: '_' | '__';
NATURAL: '=';
OCTAVE_UP: '\''+;
OCTAVE_DOWN: ','+;
BASENOTE : [a-gA-G];
NEWLINE : [\r]? [\n];
WHITESPACE : ' ' | '\t';
DIGIT : [0-9];