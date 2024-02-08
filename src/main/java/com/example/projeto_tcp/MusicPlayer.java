package com.example.projeto_tcp;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.player.Player;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;

public class MusicPlayer
{
    private Music music;
    //private long currentTime;
    private boolean isPlay;
    private boolean isPause;
    private Player player;
    private Sequence sequence;

    public MusicPlayer(Music music)
    {
        this.music = music;
        this.isPlay = false;
        this.isPause = false;
        this.player = new Player();
        this.sequence = this.player.getSequence(music.getPattern());
    }

    public Player getPlayer() {
        return player;
    }

    public Sequence getSequence() {
        return sequence;
    }

    public boolean isPlay() {
        return isPlay;
    }

    public boolean isPause() {
        return isPause;
    }

    public boolean isFinished() {
        return player.getManagedPlayer().isFinished();
    }

    public void start() throws InvalidMidiDataException, MidiUnavailableException {
        player.getManagedPlayer().start(sequence);
        this.isPlay = true;
    }

    public void finish() throws InvalidMidiDataException, MidiUnavailableException {
        this.isPlay = false;
    }

    public void pause()
    {
        player.getManagedPlayer().pause();
        this.isPause = true;
    }

    public void resume()
    {
        player.getManagedPlayer().resume();
        this.isPause = false;
    }

    public void save(String path){
        try {
            MidiFileManager.savePatternToMidi(music.getPattern(), new File(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
