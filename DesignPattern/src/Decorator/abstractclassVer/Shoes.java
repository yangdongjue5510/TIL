package Decorator.abstractclassVer;

import Decorator.interfaceVer.Model;

public class Shoes extends ClothDecorator{
    public Shoes(Model model) {
        super(model);
    }

    @Override
    public void wearCloth() {
        System.out.println("신발을 신었습니다!!!");
    }
}
