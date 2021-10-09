package Adapter.adapter1;

public class Mp3 implements SongFormat{
    @Override
    public void playSong() {
        System.out.println("start to play Mp3....!");
    }

    @Override
    public void stopSong() {
        System.out.println("stop to play Mp3....!");
    }
}
