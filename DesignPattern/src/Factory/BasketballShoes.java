package Factory;

public class BasketballShoes extends Shoes {
    ShoeIngredientFactory shoeIngredientFactory;

    public BasketballShoes(ShoeIngredientFactory shoeIngredientFactory) {
        this.shoeIngredientFactory = shoeIngredientFactory;
    }

    @Override
    public void prepare() {
        this.cushion = shoeIngredientFactory.creatCushion();
        this.shoelace = shoeIngredientFactory.createShoelace();
        this.outsole = shoeIngredientFactory.createOutsole();
    }
}