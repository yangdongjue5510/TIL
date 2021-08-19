package Factory;

public class NikeFootballShoes extends Shoes{
    public NikeFootballShoes(){
        this.modelName = "Nike Football";
        this.cushion = "NO cushion";
        this.signaturePlayer = "Ronaldo";
        this.shoeItem.add("nike football sticker");
    }
    @Override
    public void wrap() {
        System.out.println("wrapping Nike football shoes");
    }

    @Override
    public void box() {
        System.out.println("boxing Nike football shoes");
    }
}
