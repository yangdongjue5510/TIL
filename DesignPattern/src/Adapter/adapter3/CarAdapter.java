package Adapter.adapter3;

public class CarAdapter implements Car{

    private GreatCar greatCar;
    public CarAdapter(GreatCar greatCar){
        this.greatCar = greatCar;
    }
    @Override
    public void drive() {
        greatCar.autoDrive();
    }

    @Override
    public void stop() {
        greatCar.stop();
    }
}
