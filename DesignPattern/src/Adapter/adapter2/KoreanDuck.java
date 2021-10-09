package Adapter.adapter2;

public class KoreanDuck implements Duck{
    @Override
    public void quak() {
        System.out.println("꽥!!");
    }

    @Override
    public void fly() {
        System.out.println("푸드득~!");
    }
}
