package Observer;

public class NBCDisplay implements Observer, DisplayElement{
    private float ppg;
    private float rpg;
    private float apg;
    private Subject nbaData;

    public NBCDisplay(Subject nbaData){
        this.nbaData = nbaData;
        nbaData.registerObserver(this);
    }

    public void update(float ppg, float rpg, float apg){
        this.ppg = ppg;
        this.apg = apg;
        this.rpg = rpg;
        display();
    }

    public void display() {
        System.out.printf("This is from NBC!");
        System.out.printf(ppg+"points "+rpg+"rebounds "+apg+"assists!!!!\n");
    }
}
