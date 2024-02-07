package com.example.projeto_tcp;

public class MusicSettings {
    private int bpm;
    private int timbre;
    private String firstInstrument;

    public MusicSettings( int bpm, int timbre, String firstInstrument){
        this.bpm = bpm;
        this.timbre = timbre;
        this.firstInstrument = firstInstrument;
    }

    public void setBpm(int bpm){
        this.bpm = bpm;
    }

    public void setTimbre(int timbre){
        this.timbre = timbre;
    }

    public void setFirstInstrument(String firstInstrument){
        this.firstInstrument = firstInstrument;
    }

    public int getBpm(){
        return this.bpm;
    }

    public int getTimbre(){
        return this.timbre;
    }

    public String getFirstInstrument(){
        return this.firstInstrument;
    }

}
