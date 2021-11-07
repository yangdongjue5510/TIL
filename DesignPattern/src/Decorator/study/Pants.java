package Decorator.study;

public class Pants implements ClotheDecorator{
    Model model;
    public Pants(Model model){
        this.model = model;
    }
    @Override
    public void wearClothes() {
        System.out.println("바지를 입었습니다!!");
    }

    @Override
    public void runway() {
        model.runway();
        wearClothes();
    }
}
