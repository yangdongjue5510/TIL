package Adapter.adapter2;

public class ChickenAdapter implements Duck{
    Chicken chicken;

    public ChickenAdapter(Chicken chicken){
        this.chicken = chicken;
    }
    @Override
    public void quak() {
        chicken.kokkio();
    }

    @Override
    public void fly() {
        chicken.fly();
    }
}
