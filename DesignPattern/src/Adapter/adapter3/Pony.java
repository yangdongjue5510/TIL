package Adapter.adapter3;

public class Pony implements Car{
    @Override
    public void drive() {
        System.out.println("운전자가 직접 운전...");
    }

    @Override
    public void stop() {
        System.out.println("운전자가 직접 정지...");
    }
}
