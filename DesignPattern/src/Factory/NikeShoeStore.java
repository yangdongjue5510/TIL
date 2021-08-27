package Factory;

public class NikeShoeStore extends ShoeStore{
    public Shoes createShoes (String type){
        Shoes shoes = null;
        ShoeIngredientFactory shoeIngredientFactory = new NikeShoeIngredientFactory()

        if (type.equals("basketball")){
            shoes = new NikeBasketballShoes(shoeIngredientFactory);
            shoes.setModelName("basketball");
        } else if (type.equals("football")){
            shoes = new NikeFootballShoes(shoeIngredientFactory);
            shoes.setModelName("football");
        }
        return shoes;
    }
}
