package state.example;

public class TurboState implements BasicCarState{
    private static TurboState turboState;

    private TurboState(){}

    public static BasicCarState getInstance(){
        if(turboState==null){
            turboState= new TurboState();
        }
        return turboState;
    }
    @Override
    public void driveState(Car car) {
        System.out.println("Start Turbo process...");
    }

    @Override
    public void stopState(Car car) {
        System.out.println("Stop Turbo process...");
    }
}
