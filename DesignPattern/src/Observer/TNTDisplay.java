package Observer;

public class TNTDisplay implements Observer, DisplayElement{
    private float ppg;
    private float apg;
    private float rpg;
    private Subject nbaData;

    public TNTDisplay(Subject nbaData){
        this.nbaData = nbaData;
        nbaData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("This is from TNT!");
        System.out.printf(ppg+"points "+rpg+"rebounds "+apg+"assists~!\n");
    }

    @Override
    public void update(float ppg, float rpg, float apg) {
        this.ppg = ppg;
        this.apg = apg;
        this.rpg = rpg;
        display();
    }
}
