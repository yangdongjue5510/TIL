package Factory;

public class AdidasBasketballShoes extends Shoes{
    public AdidasBasketballShoes(){
        this.modelName = "Adidas basketball";
        this.cushion = "Boost cushion";
        this.signaturePlayer = "Lillard";
        this.shoeItem.add("Adidas shoe string");
    }
    @Override
    public void wrap() {
        System.out.println("wrapping Adidas basketball shoes");
    }

    @Override
    public void box() {
        System.out.println("boxing Adidas basketball shoes");
    }
}
