package Adapter.adapter2;

import java.util.Enumeration;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Duck koreanDuck = new KoreanDuck();
        koreanDuck.quak();
        koreanDuck.fly();

        Chicken koreanChicken = new KoreanChicken();
        Duck adaptedChicken = new ChickenAdapter(koreanChicken);
        adaptedChicken.quak();
        adaptedChicken.fly();
    }
}
