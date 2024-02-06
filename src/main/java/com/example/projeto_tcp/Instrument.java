package com.example.projeto_tcp;

public class Instrument {
    // Constantes dos instrumentos (Strings)
    public static final String BANJO = "Banjo";
    public static final String PIANO = "Piano";
    public static final String MARIMBA = "Marimba";
    public static final String TWEET = "Bird_Tweet";
    public static final String DRUM = "Taiko_Drum";

    // Constantes para os caracteres que representam esses instrumentos
    public static final char BANJO_CHAR = 'B';
    public static final char PIANO_CHAR = 'P';
    public static final char MARIMBA_CHAR = 'M';
    public static final char TWEET_CHAR = 'T';
    public static final char DRUM_CHAR = 'D';

    public static String getInstrument(char character) {
        return switch (Character.toUpperCase(character)) {
            case BANJO_CHAR -> BANJO;
            case PIANO_CHAR -> PIANO;
            case MARIMBA_CHAR -> MARIMBA;
            case TWEET_CHAR -> TWEET;
            case DRUM_CHAR -> DRUM;
            default -> "";
        };
    }

    public static String[] getInstrumentsList(){
        return new String[]{BANJO, PIANO, MARIMBA, TWEET, DRUM};
    }
}