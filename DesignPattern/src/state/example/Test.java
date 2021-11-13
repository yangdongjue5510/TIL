package state.example;

public class Test {
    public static void main(String[] args) {
        Car avante = new BasicCar();
        avante.drive();
        avante.stop();

        avante.setState(TurboState.getInstance());
        avante.drive();
        avante.stop();
    }
}
