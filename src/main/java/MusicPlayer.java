public class MusicPlayer
{
    private Music music;
    private long currentTime;
    private boolean play;
    private Player player;
    private int volume;

    public MusicPlayer(Music music)
    {
        this.music = music;
        this.currentTime = 0;
        this.play = false;
        this.volume = 20;
        this.player = new Player();
    }

    public void play()
    {
        for (int i = 0; i < this.music.getPattern(i); i++) {

        }
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

    public void getDuration()
    {
        //TODO
        // RETURN THE MUSIC'S TOTAL DURATION TIME
    }

    public void setTime(long time)
    {
        //TODO
        // SET THE TIME OF THE MUSIC
    }

    public int getVolume()
    {
        return this.volume;
    }

    public void setVolume(int vol)
    {
        this.volume = vol;
    }

}
