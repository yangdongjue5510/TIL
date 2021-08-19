package Factory;

public class Tester {
    public static void main(String[] args) {
        ShoeStore nikeShoeStore = new NikeShoeStore();
        ShoeStore adidasShoeStore= new AdidasShoeStore();
        adidasShoeStore.orderShoes("basketball");
        System.out.println();
        nikeShoeStore.orderShoes("football");
    }
}
