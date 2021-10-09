package Adapter.adapter1;

public class Test {
    public static void main(String[] args) {
        Device iphone = new Device();
        SongFormat danceMusic = new Mp3();
        VideoFormat actionFilm = new Mp4();

        iphone.play(danceMusic);
        iphone.play(actionFilm);
    }
}
