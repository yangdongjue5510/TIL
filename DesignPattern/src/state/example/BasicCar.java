package state.example;

public class BasicCar implements Car{
    private BasicCarState state;

    public BasicCar(){
        state = NormalState.getInstance();
    }
    @Override
    public void drive() {
        state.driveState(this);
    }

    @Override
    public void stop() {
        state.stopState(this);
    }

    @Override
    public void setState(BasicCarState state) {
        this.state = state;
    }
}
