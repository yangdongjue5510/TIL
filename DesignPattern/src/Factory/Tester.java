package Factory;

public class Tester {
    public static void main(String[] args) {
        SimpleNikeFactory factory = new SimpleNikeFactory();
        ShoeStore store1 = new ShoeStore(factory);
        store1.orderShoes("basketball");
        store1.orderShoes("football");
    }
}
