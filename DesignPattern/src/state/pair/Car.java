package state.pair;

public abstract class Car {
    public int fuel;
    public CarState carState;

    public abstract void drive();

    public void setCarState(CarState carState){
        this.carState = carState;
    }
}
