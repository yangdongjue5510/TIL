package Decorator.abstractclassVer;

import Decorator.interfaceVer.Model;

public class Hat extends ClothDecorator{
    public Hat(Model model) { super(model); }

    @Override
    public void wearCloth() { System.out.println("모자를 썼습니다!!!"); }
}
