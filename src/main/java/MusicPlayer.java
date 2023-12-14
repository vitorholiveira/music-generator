public class MusicPlayer
{
    private Music music;
    private long currentTime;
    private boolean play;

    public MusicPlayer(Music music)
    {
        this.music = music;
        this.currentTime = 0;
        this.play = false;
    }

    public void play()
    {
        // TODO
        // START PLAYING MUSIC
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

}
