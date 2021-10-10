package Adapter.adapter3;

public class CarAdapter2  implements CarAdapterInterface{
    private Object car;

    public CarAdapter2(Object car) {
        this.car = car;
    }
    @Override
    public void go() {
        if(car instanceof Car)
            ((Car) car).drive();
        else if(car instanceof GreatCar)
            ((GreatCar) car).autoDrive();
        else
            System.out.println("지원하지 않는 형식....");
    }
}
