---
title: 프록시 패턴
date: 2021-07-29 17:17:15
tags:
category:
    - Java
    - Design Pattern
---

## Proxy pattern
proxy는 대리인이라는 뜻. 프록시에게 어떤 일을 대신 시키는 것
proxy class를 통해서 대신 전달하는 형태로 설계. 실제 클라이언트는 프록시로부터 결과를 받음
어떤 객체가 있을 때, 그 객체 대신에 프록시가 대신 들어가 그 객체가 해야할 일을 하는 것.
이때 프록시는 객체와 동일한 기능을 해야 된다. 프록시가 객체가 해야할 일을 다르게 처리하면 안된다.

이러면 객체에 직접 접근하지 않고 우회하여 접근하도록 설계가 가능하다.
이는 클라이언트가 객체를 잘못 접근할 가능성을 낮춘다.

캐시의 기능으로도 활용 가능.
SOLID중에서 개방폐쇄 원칙(OCP)과 의존 역전 원칙(DIP)를 따른다.

## AOP?

어떤 작업 전, 후에 기능을 실행할 수 있는 작업.
어떤 작업이 얼마나 걸렸는지 측정할 때 사용하기도 한다.

```java
//IBrowser 인터페이스
public interface IBrowser {
    Html show();
}
//Html 클래스
public class Html {
    private String url;
    public Html(String url){
        this.url = url;
    }
}
//Browser 클래스
public class Browser implements IBrowser{
    private String url;
    public Browser(String url){
        this.url = url;
    }

    @Override
    public Html show() {
        System.out.println("browser is working: "+url);
        return new Html(url);
    }
}
//BrowserProxy
public class BrowserProxy  implements IBrowser{
    private String url;
    private Html html;

    public BrowserProxy(String url){
        this.url = url;
    }

    @Override
    public Html show() {
        if(html == null){
            this.html = new Html(url);
            System.out.println("Browser Proxy loading : "+url);
        }
        System.out.println("Browser Proxy use cache html :"+url);
        return html;
    }
}
//AOP 사용하는 AopBrowser 클래스
public class AopBrowser implements IBrowser{

    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after){
        this.url = url;
        this.before = before;
        this.after = after;
    }
    @Override
    public Html show() {
        before.run();
        if(html == null){
            this.html = new Html(url);
            System.out.println("appBrowser html loading from:"+url);
            try{
                Thread.sleep(1500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        after.run();
        System.out.println("appBrowser html cache : "+url);
        return html;
    }
}
```

```java
public class Main {
    public static void main(String[] args){

        //proxy가 아닌 경우
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        //proxy인 경우
        IBrowser browser2 = new BrowserProxy("www.naver.com");
        browser2.show();
        browser2.show();

        //proxy with AOP
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now-start.get());
                });
        aopBrowser.show();
        System.out.println("Loading time: "+end.get());
    }