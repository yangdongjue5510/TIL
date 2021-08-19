package Factory;

public class NikeShoeStore extends ShoeStore{
    public Shoes createShoes (String type){
        Shoes shoes = null;
        if (type.equals("basketball")){
            shoes = new NikeBasketballShoes();
        } else if (type.equals("football")){
            shoes = new NikeFootballShoes();
        }
        return shoes;
    }
}
