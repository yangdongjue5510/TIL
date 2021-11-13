package state.example;

public class NormalState implements BasicCarState{
    private static NormalState normalState;

    private NormalState(){};

    public static BasicCarState getInstance(){
        if(normalState==null){
            normalState = new NormalState();
        }
        return normalState;
    }

    @Override
    public void driveState(Car car) {
        System.out.println("Start Normal process...");
    }

    @Override
    public void stopState(Car car) {
        System.out.println("Stop Normal process...");
    }
}
