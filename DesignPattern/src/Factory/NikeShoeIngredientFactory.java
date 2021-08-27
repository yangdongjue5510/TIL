package Factory;

public class NikeShoeIngredientFactory implements ShoeIngredientFactory{

    @Override
    public Shoelace createShoelace() {
        return new NikeShoelace();
    }

    @Override
    public Outsole createOutsole() {
        return NikeOutsole();
    }

    @Override
    public Cushion creatCushion() {
        return NikeCushion();
    }

    @Override
    public Colors[] createColors() {
        return new Colors[] = {new BredColor()};
    }

}
