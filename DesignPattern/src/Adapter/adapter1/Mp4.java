package Adapter.adapter1;

public class Mp4 implements VideoFormat{
    @Override
    public void playVideo() {
        System.out.println("start to play Mp4...");
    }

    @Override
    public void stopVideo() {
        System.out.println("stop to play Mp4....");
    }
}
