package Singleton;

public class CoffeeShop {
    private static CoffeeShop coffeeShop = new CoffeeShop();
    private CoffeeShop(){}
    public static CoffeeShop getInstance(){
        return coffeeShop;
    }
    public void makeCoffee(){
        System.out.println("세상에 단 하나뿐인 커피가게에서 커피를 만들었습니다!");
    }
}
