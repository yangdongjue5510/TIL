package Factory;

public class ShoeStore {
    SimpleNikeFactory factory;

    public ShoeStore(SimpleNikeFactory factory){
        this.factory = factory;
    }

    public Shoes orderShoes(String type) {
        Shoes shoes;
        shoes = factory.createShoes(type);

        shoes.prepare();
        shoes.wrap();
        shoes.box();
        return shoes;
    }
}
