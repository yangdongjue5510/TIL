package state.pair;

import Strategy.strategy2.mode.EcoMode;

public class BasicCar extends Car{
    public BasicCar(){
        this.fuel = 100;
        this.carState = new NormalState();
    }
    @Override
    public void drive() {
        if(fuel<30&& ! (carState instanceof EcoState)){
            carState.stopState(this);
            this.setCarState(new EcoState());
        } else if(fuel>80 && ! (carState instanceof TurboState)){
            carState.stopState(this);
            this.setCarState(new TurboState());
        }
        carState.driveState(this);
    }
}
