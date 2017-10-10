/*
 * Compile all your grammars using
 *       java -jar ../../../lib/antlr.jar *.g4
 * then Refresh in Eclipse.
 */
grammar Header;
import Configuration;

header: field_number field_title other_fields* field_key EOF; 
field_number: 'X:' ' '* number NEWLINE;
field_title: 'T:' (text ' '?)+ NEWLINE;
other_fields: field_composer | field_default_length | field_meter | field_tempo | field_voice;
field_composer: 'C:' (text ' '?)+ NEWLINE;
field_default_length: 'L:' ' '* note_length_strict NEWLINE;
field_meter: 'M:' ' '* meter NEWLINE;
field_tempo: 'Q:' ' '* tempo NEWLINE;
field_key: 'K:' ' '* key;
field_voice: 'V:' (text ' '?)+ NEWLINE;

key: keynote MODE_MINOR?;
keynote: (BASENOTE|CNOTE) KEY_ACCIDENTAL?;
CNOTE: 'C';
BASENOTE: 'D' | 'E' | 'F' | 'G' | 'A' | 'B' ;
KEY_ACCIDENTAL: '#' | 'b';
MODE_MINOR: 'm';

note_length_strict: number '/' number;
meter: 'C' | 'C|' | meter_fraction;
meter_fraction: number '/' number;
tempo: meter_fraction '=' number;

text : LETTER | BASENOTE | MODE_MINOR | KEY_ACCIDENTAL | SIGN | CNOTE | DIGIT;
number : DIGIT+ ;
NEWLINE: '\n' | '\r' '\n'?;
LETTER : ('a'..'l'| 'n'..'z' | 'H'..'Z') ;
SIGN : ('.'|'+'|'~'|'`'|'!'|'@'|'$'|'^'|'&'|'*'|'-'|'_'|'{'|'}'|'['|']'|'?'|'<'|'>'|','|'('|')'|'/'|'\'') ;
DIGIT : ('0'..'9') ;