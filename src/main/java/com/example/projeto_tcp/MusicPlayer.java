package com.example.projeto_tcp;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.player.Player;
import javax.sound.midi.Sequence;

public class MusicPlayer
{
    private Music music;
    //private long currentTime;
    private boolean play;
    private Player player;
    private Sequence sequence;

    public MusicPlayer(Music music)
    {
        this.music = music;
        this.play = false;
        this.player = new Player();
        this.sequence = this.player.getSequence(music.getPattern());
    }

    public Player getPlayer() {
        return player;
    }

    public Sequence getSequence() {
        return sequence;
    }

    public void play()
    {
        this.play = true;
    }

    public void pause()
    {
        this.play = false;
    }

    public void save(String path){
        try {
            MidiFileManager.savePatternToMidi(music.getPattern(), new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}