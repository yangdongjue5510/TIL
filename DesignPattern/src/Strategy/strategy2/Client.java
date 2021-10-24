package Strategy.strategy2;

import Strategy.strategy2.car.Avante;
import Strategy.strategy2.car.Benz;
import Strategy.strategy2.car.Car;
import Strategy.strategy2.car.Tesla;
import Strategy.strategy2.mode.EcoMode;
import Strategy.strategy2.mode.SuperBenzTurboMode;
import Strategy.strategy2.mode.TurboMode;

public class Client {
    public static void main(String[] args) {
        Car avante = new Avante();
        avante.setModeStrategy(new EcoMode());
        avante.drive();
        avante.setModeStrategy(new TurboMode());
        avante.drive();

        Car benz = new Benz();
        benz.setModeStrategy(new EcoMode());
        benz.drive();
        benz.setModeStrategy(new SuperBenzTurboMode());
        benz.drive();

        Car tesla = new Tesla();
        tesla.setModeStrategy(new EcoMode());
        tesla.drive();
    }
}
