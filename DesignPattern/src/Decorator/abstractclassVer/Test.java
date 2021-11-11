package Decorator.abstractclassVer;

import Decorator.interfaceVer.KoreanModel;
import Decorator.interfaceVer.Model;

public class Test {
    public static void main(String[] args) {
        Model yang = new Shoes(new Hat(new KoreanModel()));
        yang.runway();
    }
}
