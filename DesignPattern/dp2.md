---
title: 어댑터 패턴
date: 2021-07-29 13:11:15
tags:
category:
    - Java
    - Design Pattern
---
# 어댑터 패턴

어댑터하면 실생활에서 콘센트 볼트를 호환 해주는 도구를 가르킨다.  
어댑터 패턴은 호환성이 없는 기존 클래스의 인터페이스를 변환하여 재사용할 수 있도록 한다.

> SOLID 중에서 개방폐쇄 원칙을 따른다(OCP)

서로 비슷한 인터페이스를 구현하지만 서로 동일하지는 않을 때 이를 호환해주는 어댑터 클래스를 활용하는 패턴이다.

> 활용 예시.

110v를 사용하는 가정에서 220v를 활용하려고 할 때 어댑터를 사용하는 얘시.

#### 110v 인터페이스

```
package com.company.design.adapter;

public interface Electronic110V {
    void powerOn();
}
```

#### 220v 인터페이스

```
package com.company.design.adapter;

public interface Electronic220V {
    void connect();
}
```

#### 110v 헤어드라이기 클래스

```
package com.company.design.adapter;

public class HairDryer implements  Electronic110V{
    @Override
    public void powerOn() {
        System.out.println("110v hairdryer on");
    }
}
```

#### 220v 청소기 클래스

```
package com.company.design.adapter;

public class Cleaner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("220v cleaner on");
    }
}
```

#### main 클래스

```
public class Main{
    public static void main(string[] args){
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);
    }

       public static void connect(Electronic 110V electronic110V){
        electronic110V.powerOn();
    }
}
```