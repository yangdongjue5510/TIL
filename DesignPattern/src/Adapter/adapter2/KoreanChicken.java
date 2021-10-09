package Adapter.adapter2;

public class KoreanChicken implements Chicken{
    @Override
    public void kokkio() {
        System.out.println("꼬끼오!!!");
    }

    @Override
    public void fly() {
        System.out.println("푸득...");
    }
}
