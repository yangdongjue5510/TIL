package Adapter.adapter1;

public class VideoFormatAdapter implements Adaptable{
    @Override
    public boolean supports(Object o) {
        return o instanceof VideoFormat;
    }

    @Override
    public void handle(Object o) {
        VideoFormat videoFormat = (VideoFormat) o;
        videoFormat.playVideo();
        videoFormat.stopVideo();
    }
}
