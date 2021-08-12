---
title: 데코레이터 패턴
date: 2021-07-29 19:39:38
tags:
category:
    - Java
    - Design Pattern
---
## 데코레이터 패턴
기존 클래스는 유지하되, 이후 필요한 형태로 꾸밀 때 사용!
확장이 필요한 경우 상속의 대안으로 활용!

SOLID 중 개방폐쇄 원칙(OCP)과 의존 역전 원칙(DIP)를 따른다!

```java
//ICar 인터페이스
public interface ICar {
    int getPrice();
    void showPrice();
}
//Audi 클래스
public class Audi implements ICar{
    private int price;
    public Audi(int price){
        this.price = price;
    }
    @Override
    public int getPrice(){
        return 0;
    }

    @Override
    public void showPrice() {
        System.out.println("Audi의 가격은 "+this.price+"원 입니다.");
    }
}
//Audi를 더 다양하게 표현하기 위한 AudiDecorator 클래스