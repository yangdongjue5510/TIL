package state.pair;

public class TurboState implements CarState{
    final int fuelPerHour = 40;

    @Override
    public void driveState(Car car) {
        car.fuel-=fuelPerHour;
        System.out.println("Drive Turbo state...");
    }

    @Override
    public void stopState(Car car) {
        System.out.println("Stop Turbo state...");
    }
}
