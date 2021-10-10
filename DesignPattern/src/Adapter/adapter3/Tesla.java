package Adapter.adapter3;

public class Tesla implements GreatCar{
    @Override
    public void autoDrive() {
        System.out.println("자동으로 운전을 시작합니다...");
    }

    @Override
    public void stop() {
        System.out.println("그냥 멈춥니다...");
    }
}
