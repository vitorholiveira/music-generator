package com.example.projeto_tcp;

import org.jfugue.pattern.Pattern;

import java.util.Random;

public class Music
{
    private final MusicSettings defaultSettings;
    private MusicSettings settings;
    private String text;
    private Pattern music_generator;


    public Music(MusicSettings settings, String text)
    {
        this.defaultSettings = new MusicSettings(settings.getBpm(),settings.getInstrument(),settings.getVolume(), settings.getOctave());
        this.settings = new MusicSettings(settings.getBpm(),settings.getInstrument(),settings.getVolume(), settings.getOctave());
        this.text = text;
    }

    public void generate()
    {
        StringBuilder patternText = new StringBuilder(setPatternVolume() + setPatternBPM() + setPatternInstrument());
        for (int i = 0; i < text.length(); i++) {
            String newSymbol = mapping(text.charAt(i) ,i);

            //Check the char's mapped command
            if (newSymbol.equals("Change BPM")){
                i+=3;
                patternText.append(setPatternBPM());
            } else if (newSymbol.equals("Random BPM")) {
                patternText.append(setPatternBPM());
            } else if (newSymbol.equals("Change Volume")) {
                patternText.append(setPatternVolume());
            } else if (newSymbol.equals("Telephone")) {
                patternText.append("I[Telephone_Ring] A ");
                patternText.append(setPatternInstrument());
            } else if (newSymbol.equals("Change Instrument")) {
                i++;
                patternText.append(setPatternInstrument());
            } else if (newSymbol.equals("Change Octave")) {
                i++;
            } else {
                patternText.append(newSymbol);
            }

        }
        //Create a Pattern with the somg built
        music_generator = new Pattern(patternText.toString());
    }

    public String mapping(char character, int index)
    {
        int sortedIndex;
        character = Character.toUpperCase(character);
        Random random = new Random();
        switch (character){
            //Check BPM or B commands
            case ('B'):
                if (text.length() >= index+4){
                    if (text.startsWith("PM+", index+1)) {
                        settings.setBpm(settings.getBpm() + 80);
                        return "Change BPM";
                    } else if (text.startsWith("PM-", index+1)) {
                        settings.setBpm(settings.getBpm() - 80);
                        return "Change BPM";
                    } else {
                        return SetPatternNote(character);
                    }
                } else {
                    return SetPatternNote(character);
                }
            //Check usual notes
            case('A'):
            case('C'):
            case('D'):
            case('E'):
            case('F'):
            case('G'):
                return SetPatternNote(character);
            //Check volume changes
            case('+'):
                if (settings.getVolume()*2 > 127){
                    settings.setVolume(127);
                } else{
                    settings.setVolume(settings.getVolume()*2);
                }
                return "Change Volume";
            case('-'):
                settings.setVolume(getDefaultSettings().getVolume());
                return "Change Volume";
            //Check space
            case(' '):
                return "R ";
            //Check random note
            case('?'):
                sortedIndex = random.nextInt(Symbol.G.getAsciiValue() - Symbol.A.getAsciiValue() +1);
                return SetPatternNote((char) (Symbol.A.getAsciiValue()+sortedIndex));
            //Check repeated note
            case('O'):
            case('I'):
            case('U'):
                char prevChar = Character.toUpperCase(text.charAt(index-1));
                if (prevChar >= Symbol.A.getAsciiValue() && prevChar <= Symbol.G.getAsciiValue()){
                    return SetPatternNote(prevChar);
                } else {
                    return "Telephone";
                }
            //Check random BPM
            case(';'):
                sortedIndex = random.nextInt(400);
                settings.setBpm(sortedIndex);
                return "Random BPM";
            //Check Instrument change
            case('\n'):
                if (text.length() >= index+1) {
                    String instrument = Instrument.getInstrument(text.charAt(index + 1));
                    settings.setInstrument(instrument);
                    return "Change Instrument";
                }
            //Check Octave Change
            case('R'):
                if (text.length() >= index+1){
                    if(text.charAt(index + 1) == '+' && settings.getOctave()<10){
                        settings.setOctave(settings.getOctave()+1);
                        return "Change Octave";
                    } else if (text.charAt(index + 1) == '-' && settings.getOctave() > 0) {
                        settings.setOctave(settings.getOctave()-1);
                        return "Change Octave";
                    }
                }
        }
        return "";
    }

    public String getText()
    {
        return this.text;
    }
    public void setText(String text)
    {
        this.text = text;
    }

    public MusicSettings getSettings()
    {
        return this.settings;
    }
    public void setSettings(MusicSettings settings)
    {

        this.settings = settings;
    }

    public MusicSettings getDefaultSettings() {
        return defaultSettings;
    }

    public Pattern getPattern() {
        return this.music_generator;
    }

    public String setPatternVolume(){
        return ":CON(7, "+ Integer.toString(getSettings().getVolume()) +") ";
    }

    public String setPatternBPM(){
        return "T"+ Integer.toString(getSettings().getBpm()) +" ";
    }

    public String setPatternInstrument(){
        return "I["+ getSettings().getInstrument() +"] ";
    }

    public String SetPatternNote(char note){
        return Character.toString(note)+Integer.toString(getSettings().getOctave())+" ";
    }
}