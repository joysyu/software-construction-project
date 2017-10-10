package abc.sound;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import abc.parser.HeaderListener;
import abc.parser.HeaderParser.Field_composerContext;
import abc.parser.HeaderParser.Field_default_lengthContext;
import abc.parser.HeaderParser.Field_keyContext;
import abc.parser.HeaderParser.Field_meterContext;
import abc.parser.HeaderParser.Field_numberContext;
import abc.parser.HeaderParser.Field_tempoContext;
import abc.parser.HeaderParser.Field_titleContext;
import abc.parser.HeaderParser.Field_voiceContext;
import abc.parser.HeaderParser.HeaderContext;
import abc.parser.HeaderParser.KeyContext;
import abc.parser.HeaderParser.KeynoteContext;
import abc.parser.HeaderParser.MeterContext;
import abc.parser.HeaderParser.Meter_fractionContext;
import abc.parser.HeaderParser.Note_length_strictContext;
import abc.parser.HeaderParser.NumberContext;
import abc.parser.HeaderParser.Other_fieldsContext;
import abc.parser.HeaderParser.TempoContext;
import abc.parser.HeaderParser.TextContext;

class MakeHeader implements HeaderListener {
    private final Stack<String> stack = new Stack<>();
    private final Stack<String> optionalStack = new Stack<>();
    
    /**
     * Read information from the stack and make a Header object.
     * @return Header object
     */
    public Header parseToGetHeader() {
        int index = 0;
        String title = "";
        KeySignature ks = KeySignature.valueOf("C_MAJOR");
        //getting the required fields
        while (!stack.isEmpty()){
            String ctx = stack.pop();
            //index number
            if (ctx.contains("X:")){
                Pattern regex = Pattern.compile("[0-9]+");
                Matcher matcher = regex.matcher(ctx);
                if(matcher.find()){
                    index = Integer.valueOf(matcher.group());
                }
            } 
            //title
            else if (ctx.contains("T:")){
                title = ctx.substring(2).replace("\n", "");
            }
            //key
            else if (ctx.contains("K:")){
                String k = "";
                ctx = ctx.substring(2).replace("\n", "");
                Pattern regex = Pattern.compile("[A-G]+");
                Matcher matcher = regex.matcher(ctx);
                if(matcher.find()){
                    k = matcher.group();
                    }
                if (ctx.contains("#")){
                    k = k + "_SHARP";
                } else if (ctx.contains("b")){
                    k = k + "_FLAT";
                }
                if (ctx.contains("m")){
                    k += "_MINOR";
                } else {
                    k += "_MAJOR";
                }
                ks = KeySignature.valueOf(k);
            }
        }
        Header Header = new Header(index, title, ks);

        while (!optionalStack.isEmpty()){
            String ctx = optionalStack.pop();
            //composer
            if (ctx.contains("C:")){
                Header.setComposer(ctx.substring(2).replace("\n", ""));
            }
            //meter
            else if (ctx.contains("M:")){
                ctx = ctx.substring(2).replace("\n", "");
                if (ctx.equals("C")){
                    Header.setMeter(new Fraction(4,4));
                } else if (ctx.equals("C|")){
                    Header.setMeter(new Fraction(2,2));
                } else {
                    String[] ctxSplit = ctx.split("/");
                    Fraction f = new Fraction(Integer.valueOf(ctxSplit[0]), Integer.valueOf(ctxSplit[1]));
                    Header.setMeter(f);
                }
            }
            //default length
            else if (ctx.contains("L:")){
                ctx = ctx.substring(2).replace("\n", "");
                String[] ctxSplit = ctx.split("/");
                Fraction f = new Fraction(Integer.valueOf(ctxSplit[0]), Integer.valueOf(ctxSplit[1]));
                Header.setDefaultLength(f);
            }
            //tempo
            else if (ctx.contains("Q:")){
                ctx = ctx.substring(2).replace("\n", "");
                String[] ctxSplit = ctx.split("=");
                String frac = ctxSplit[0];
                String tempo = ctxSplit[1];
                String[] fracSplit = frac.split("/");
                Fraction f = new Fraction(Integer.valueOf(fracSplit[0]), Integer.valueOf(fracSplit[1]));
                Header.setTempo(f, Integer.valueOf(tempo));
            }
            //voice
            else if (ctx.contains("V:")){
                ctx = ctx.substring(2).replace("\n", "");
            }
        }
        return Header;
    }
    @Override
    public void exitField_number(Field_numberContext context) {
        stack.push(context.getText());
    }
    
    @Override
    public void exitField_title(Field_titleContext context) {
        stack.push(context.getText());
    }
    
    @Override
    public void exitField_composer(Field_composerContext context) {
        optionalStack.push(context.getText());
    }
    
    @Override
    public void exitField_default_length(Field_default_lengthContext context) {
        optionalStack.push(context.getText());
    }

    @Override
    public void exitField_meter(Field_meterContext context) {
        optionalStack.push(context.getText());
    }
    
    @Override
    public void exitField_tempo(Field_tempoContext context) {
        optionalStack.push(context.getText());
    }
    
    @Override
    public void exitField_key(Field_keyContext context) {
        stack.push(context.getText());
    }
    
    @Override
    public void exitField_voice(Field_voiceContext ctx) {
        optionalStack.push(ctx.getText());        
    }

    @Override public void enterEveryRule(ParserRuleContext arg0) {}

    @Override public void exitEveryRule(ParserRuleContext arg0) {}

    @Override public void visitErrorNode(ErrorNode arg0) {}

    @Override public void visitTerminal(TerminalNode arg0) {}

    @Override public void enterHeader(HeaderContext ctx) {}

    @Override public void exitHeader(HeaderContext ctx) {}

    @Override
    public void enterField_number(Field_numberContext ctx) {}

    @Override
    public void enterField_title(Field_titleContext ctx) {}

    @Override
    public void enterOther_fields(Other_fieldsContext ctx) {}

    @Override
    public void exitOther_fields(Other_fieldsContext ctx) {}

    @Override
    public void enterField_composer(Field_composerContext ctx) {}

    @Override
    public void enterField_default_length(Field_default_lengthContext ctx) {}

    @Override
    public void enterField_meter(Field_meterContext ctx) {}

    @Override
    public void enterField_tempo(Field_tempoContext ctx) {}

    @Override
    public void enterField_key(Field_keyContext ctx) {}
    
    @Override
    public void enterField_voice(Field_voiceContext ctx) {}

    @Override
    public void enterKey(KeyContext ctx) {}

    @Override
    public void exitKey(KeyContext ctx) {}

    @Override
    public void enterNote_length_strict(Note_length_strictContext ctx) {}

    @Override
    public void exitNote_length_strict(Note_length_strictContext ctx) {}

    @Override
    public void enterMeter(MeterContext ctx) {}

    @Override
    public void exitMeter(MeterContext ctx) {}

    @Override
    public void enterMeter_fraction(Meter_fractionContext ctx) {}

    @Override
    public void exitMeter_fraction(Meter_fractionContext ctx) {}

    @Override
    public void enterTempo(TempoContext ctx) {}

    @Override
    public void exitTempo(TempoContext ctx) {}
    
    @Override
    public void enterText(TextContext ctx) {}

    @Override
    public void exitText(TextContext ctx) {}
    @Override
    public void enterKeynote(KeynoteContext ctx) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void exitKeynote(KeynoteContext ctx) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void enterNumber(NumberContext ctx) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void exitNumber(NumberContext ctx) {
        // TODO Auto-generated method stub
        
    }

}