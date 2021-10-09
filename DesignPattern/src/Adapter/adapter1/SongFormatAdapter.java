package Adapter.adapter1;

public class SongFormatAdapter implements Adaptable{
    @Override
    public boolean supports(Object o) {
        return o instanceof SongFormat;
    }

    @Override
    public void handle(Object o) {
        SongFormat songFormat = (SongFormat) o;
        songFormat.playSong();
        songFormat.stopSong();
    }
}
