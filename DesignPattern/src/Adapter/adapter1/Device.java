package Adapter.adapter1;

import java.util.ArrayList;
import java.util.List;

public class Device {
    private SongFormatAdapter songFormatAdapter = new SongFormatAdapter();
    private VideoFormatAdapter videoFormatAdapter = new VideoFormatAdapter();
    private List<Adaptable> adapters = new ArrayList<>();

    public Device(){
        adapters.add(songFormatAdapter);
        adapters.add(videoFormatAdapter);
    }
    public void play(Object o){
        for(Adaptable adapter : adapters){
            if(adapter.supports(o)){
                adapter.handle(o);
            }
        }
    }
}
