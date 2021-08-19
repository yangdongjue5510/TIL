package Factory;

public abstract class ShoeStore {

    public Shoes orderShoes(String type) {
        Shoes shoes;
        shoes = createShoes(type);

        shoes.prepare();
        shoes.wrap();
        shoes.box();
        return shoes;
    }
    public abstract Shoes createShoes(String type);
}
