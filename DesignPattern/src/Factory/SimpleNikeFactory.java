package Factory;

public class SimpleNikeFactory {
    public Shoes createShoes (String type){
        Shoes shoes = null;
        if (type.equals("basketball")){
            shoes = new BasketballShoes();
        } else if (type.equals("football")){
            shoes = new FootballShoes();
        }
        return shoes;
    }
}
