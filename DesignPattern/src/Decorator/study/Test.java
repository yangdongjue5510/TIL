package Decorator.study;

public class Test {
    public static void main(String[] args) {
        Model yang = new Pants(new Shirts(new Yangdongjue()));
        yang.runway();
    }
}
