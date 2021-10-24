package Strategy.strategy2.car;

import Strategy.strategy2.mode.ModeStrategy;

public class Tesla implements AiCar{
    private ModeStrategy modeStrategy;

    @Override
    public void aiGenerate() {
        System.out.println("Ai generate.");
    }

    @Override
    public void drive() {
        modeStrategy.generateMode();
        aiGenerate();
        System.out.println("Tesla drive.");
    }

    @Override
    public void setModeStrategy(ModeStrategy modeStrategy) {
        this.modeStrategy = modeStrategy;
    }
}
