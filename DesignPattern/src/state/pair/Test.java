package state.pair;

public class Test {
    public static void main(String[] args) {
        Car avante = new BasicCar();
        avante.setCarState(new TurboState());
        while(avante.fuel>0){
            avante.drive();
        }
    }
}
