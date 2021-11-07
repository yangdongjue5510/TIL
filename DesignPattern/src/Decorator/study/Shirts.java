package Decorator.study;

public class Shirts implements ClotheDecorator{
    Model model;
    public Shirts(Model model){
        this.model = model;
    }
    @Override
    public void wearClothes() {
        System.out.println("셔츠를 입었습니다!");
    }

    @Override
    public void runway() {
        model.runway();
        wearClothes();
    }
}
