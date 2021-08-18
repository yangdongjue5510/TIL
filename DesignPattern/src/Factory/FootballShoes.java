package Factory;

public class FootballShoes extends Shoes{
    @Override
    public void prepare() {
        System.out.println("prepare for football shoes");
    }

    @Override
    public void wrap() {
        System.out.println("wrapping football shoes");
    }

    @Override
    public void box() {
        System.out.println("boxing football shoes");
    }
}
