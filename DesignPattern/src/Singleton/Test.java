package Singleton;

public class Test {
    public static void main(String[] args) {
        CoffeeShop starbucks = CoffeeShop.getInstance();
        starbucks.makeCoffee();
    }
}
