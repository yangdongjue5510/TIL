package Factory;

public class AdidasShoeStore extends ShoeStore{
    @Override
    public Shoes createShoes(String type) {
        Shoes shoes = null;
        if(type.equals("basketball")) {
            shoes = new AdidasBasketballShoes();
        } else if(type.equals("football")){
            shoes = new AdidasFootballShoes();
        }
        return shoes;
    }
}
