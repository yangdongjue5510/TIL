package state.pair;

public class NormalState implements CarState{
    final int fuelPerHour = 10;

    @Override
    public void driveState(Car car) {
        car.fuel-=fuelPerHour;
        System.out.println("Drive NormalState...");
    }

    @Override
    public void stopState(Car car) {
        System.out.println("Stop NormalState...");
    }
}
