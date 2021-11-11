package Decorator.abstractclassVer;

import Decorator.interfaceVer.Model;

public abstract class ClothDecorator implements Model {
    Model model;

    public ClothDecorator(Model model){
        this.model = model;
    }
    public abstract void wearCloth();

    @Override
    public void runway(){
        model.runway();
        wearCloth();
    }
}
