package Observer;

import java.util.ArrayList;

public class NBAData implements Subject{
    private ArrayList observers;
    private float ppg;
    private float rpg;
    private float apg;

    public NBAData(){
        observers = new ArrayList();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        int i = observers.indexOf(o);
        if (i >= 0){
            observers.remove(i);
        }
    }
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++){
            Observer observer = (Observer)observers.get(i);
            observer.update(ppg, rpg, apg);
        }
    }
    public void measurementChanged(){
        notifyObservers();
    }
    public void setMeasurements(float ppg, float rpg, float apg){
        this.ppg = ppg;
        this.apg = apg;
        this.rpg = rpg;
        measurementChanged();
    }
}
