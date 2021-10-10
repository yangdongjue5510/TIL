package Adapter.adapter3;

public class Driver {
    public static void main(String[] args) {
        Car firstCar = new Pony();
        firstCar.drive();
        firstCar.stop();

        GreatCar secondCar = new Tesla();
        Car secondCar2 = new CarAdapter(secondCar);
        secondCar2.drive();
        secondCar2.stop();


        CarAdapterInterface carInterface = new CarAdapter2(new Pony());
        carInterface.go();
        carInterface = new CarAdapter2(new Tesla());
        carInterface.go();
    }
}
