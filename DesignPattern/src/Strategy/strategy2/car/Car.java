package Strategy.strategy2.car;

import Strategy.strategy2.mode.ModeStrategy;

public interface Car extends Modeable, Driveable {
    @Override
    void drive();

    @Override
    void setModeStrategy(ModeStrategy modeStrategy);

}
