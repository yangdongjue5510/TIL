package Factory;

public class BasketballShoes extends Shoes{

    @Override
    public void prepare() {
        System.out.println("ready for the basketball shoes.");
    }

    @Override
    public void wrap() {
        System.out.println("wrapping basketball shoes");
    }

    @Override
    public void box() {
        System.out.println("boxing basketball shoes");
    }
}
