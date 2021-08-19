package Factory;

public class NikeBasketballShoes extends Shoes{
    public NikeBasketballShoes(){
        this.modelName = "Nike basketball";
        this.cushion = "REACT cushion";
        this.signaturePlayer = "REBRON";
        this.shoeItem.add("Nike shoe string");
    }
    @Override
    public void wrap() {
        System.out.println("wrapping Nike basketball shoes");
    }

    @Override
    public void box() {
        System.out.println("boxing Nike basketball shoes");
    }
}
