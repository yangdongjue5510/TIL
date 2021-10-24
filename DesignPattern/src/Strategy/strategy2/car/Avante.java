package Strategy.strategy2.car;

import Strategy.strategy2.mode.ModeStrategy;

public class Avante implements Car {
    private ModeStrategy modeStrategy;

    public void setModeStrategy(ModeStrategy modeStrategy){
        this.modeStrategy = modeStrategy;
    }
    @Override
    public void drive() {
        modeStrategy.generateMode();
        System.out.println("Avante drive.\n");
    }

}
