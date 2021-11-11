package Decorator.interfaceVer;

public class Test {
    public static void main(String[] args) {
        Model yang = new Pants(new Shirts(new KoreanModel()));
        yang.runway();
    }
}
