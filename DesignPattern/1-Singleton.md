# 싱글톤 패턴 Singleton Pattern

> 싱글톤 패턴은 어떤 클래스(객체)가 유일하게 1개만 존재할 때 사용.  
> 서로 자원을 공유 할 때 주로 사용.

현실에서는 프린터를 상상해보면 이해가 된다.  
여러 컴퓨터가 한 프린터를 사용하는 경우가 싱글톤 패턴에 해당한다.

기본 생성자는 private로 접근을 막고 get메소드로 간접 접근하도록 구현한다.

사용 예시

한 소켓클라이언트 객체로 두 클래스가 사용하는 예시

#### 소켓클라이언트 클래스
```
package com.company.design.singleton;

public class SocketClient {
    private static SocketClient socketClient = null; //싱글톤 패턴에서는 자기 자신은 기본적으로 가지고 있어야 함

    //기본 생성자 접근을 막아야 함.
    private SocketClient(){

    }

    //static 메소드로 getInstance 메소드를 작성한다
    //이때 이 메소드는 해당 인스턴스가 없으면 새로 만들어 반환하고, 이미 있으면 있는 걸 반환하는 기능이다.
    public static SocketClient getInstance(){
        if(socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
```

#### 소켓클라이언트 객체를 이용하는 a 클래스
```
package com.company.design.singleton;

public class AClass {
    private SocketClient socketClient;

    public  AClass() {
        this.socketClient = SocketClient.getInstance();
    }
    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
```

#### 소켓클라이언트 객체를 이용하는 b 클래스
```{.java}
package com.company.design.singleton;

public class BClass {
    private SocketClient socketClient;
    public BClass(){
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
```

#### main
```{.java}
public class Main {
    public static void main(String[] args){
        AClass aClass = new AClass();
        BClass bClass = new BClass();

        SocketClient aClient = aClass.getSocketClient();
        SocketClient bClient = bClass.getSocketClient();

        System.out.println("두 개의 객체가 같은가?");
        System.out.println(aClient.equals(bClient));
    }
}
```
