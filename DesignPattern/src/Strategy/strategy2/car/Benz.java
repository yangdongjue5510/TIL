package Strategy.strategy2.car;

import Strategy.strategy2.mode.ModeStrategy;

public class Benz implements Car {
    private ModeStrategy modeStrategy;
    @Override
    public void drive() {
        modeStrategy.generateMode();
        System.out.println("Benz drive.\n");
    }

    @Override
    public void setModeStrategy(ModeStrategy modeStrategy) {
        this.modeStrategy = modeStrategy;
    }

}
