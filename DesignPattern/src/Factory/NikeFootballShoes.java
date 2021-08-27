package Factory;

public class NikeFootballShoes extends Shoes{
    ShoeIngredientFactory shoeIngredientFactory;
    public NikeFootballShoes(ShoeIngredientFactory shoeIngredientFactory){
        this.shoeIngredientFactory = shoeIngredientFactory;
    }

    @Override
    public void prepare() {
        this.modelName = "Nike Football shoes";
        this.shoelace = shoeIngredientFactory.createShoelace();
        this.cushion = shoeIngredientFactory.creatCushion();
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
