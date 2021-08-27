package Factory;

public interface ShoeIngredientFactory {
    public Shoelace createShoelace();
    public Outsole createOutsole();
    public Cushion creatCushion();
    public Colors[] createColors();
}
