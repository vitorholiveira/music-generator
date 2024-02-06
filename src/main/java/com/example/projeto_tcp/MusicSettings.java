package com.example.projeto_tcp;

public class MusicSettings {
    private int bpm;
    private int timbre;
    private String Instrument;
    private int volume;
    private int octave;

    public MusicSettings(int bpm, int timbre, String firstInstrument, int volume, int octave){
        this.bpm = bpm;
        this.timbre = timbre;
        this.Instrument = firstInstrument;
        this.volume = volume;
        this.octave = octave;
    }

    public void setBpm(int bpm){

        this.bpm = bpm;
    }

    public void setTimbre(int timbre){

        this.timbre = timbre;
    }

    public void setInstrument(String instrument){

        this.Instrument = instrument;
    }

    public int getBpm(){

        return this.bpm;
    }

    public int getTimbre(){

        return this.timbre;
    }

    public String getInstrument(){

        return this.Instrument;
    }
    public void setVolume(int volume){

        this.volume = volume;
    }

    public int getVolume(){

        return this.volume;
    }

    public int getOctave() {
        return octave;
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }
}
