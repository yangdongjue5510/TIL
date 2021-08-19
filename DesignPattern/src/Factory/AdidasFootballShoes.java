package Factory;

public class AdidasFootballShoes extends Shoes{
    public AdidasFootballShoes(){
        this.modelName = "Adidas Football";
        this.cushion = "NO cushion";
        this.signaturePlayer = "Messi";
        this.shoeItem.add("Adidas sticker");
    }
    @Override
    public void wrap() {
        System.out.println("wrapping Adidas football shoes");
    }

    @Override
    public void box() {
        System.out.println("boxing Adidas football shoes");
    }
}
