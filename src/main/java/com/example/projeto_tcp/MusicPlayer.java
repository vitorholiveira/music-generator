package com.example.projeto_tcp;
import java.util.UUID;
import org.jfugue.player.Player;

public class MusicPlayer
{
    private Music music;
    //private long currentTime;
    private boolean play;
    private Player player;

    public MusicPlayer(Music music)
    {
        this.music = music;
        this.play = false;
        this.player = new Player();
    }

    public static String getRandomText(){
        return UUID.randomUUID().toString();
    }
    public void play()
    {
    }

    public void pause()
    {
        // TODO
        // PAUSE THE MUSIC
    }

    public void getCurrentTime()
    {
        //TODO
        // RETURN THE MUSIC'S CURRENT TIME
    }

}
