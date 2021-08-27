package Factory;

public class NikeBasketballShoes extends Shoes{
    ShoeIngredientFactory shoeIngredientFactory;
    public NikeBasketballShoes(ShoeIngredientFactory shoeIngredientFactory){
        this.shoeIngredientFactory = shoeIngredientFactory;
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
