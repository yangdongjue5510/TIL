package state.pair;

public class EcoState implements CarState {
    final int fuelPerHour = 3;

    @Override
    public void driveState(Car car) {
        car.fuel-=fuelPerHour;
        System.out.println("Drive EcoState...");
    }

    @Override
    public void stopState(Car car) {
        System.out.println("Stop Eco State...");
    }
}
