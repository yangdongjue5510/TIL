# 메시지, 국제화

메세지는 출력되는 내용을 일일히 하드코딩하지 않고 한 곳에 모아서 관리하는 방식.

## 일반 스프링에서 메시지 활용

그냥 스프링에서는 MessageSource를 빈 등록하면 된다.(구현체인 ResourceBundleMessageSource 객체를 등록한다.)

```java
@Bean
public MessageSource messageSource() {
 ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
 messageSource.setBasenames("messages", "errors");
 messageSource.setDefaultEncoding("utf-8");
 return messageSource;
}
```

resources 폴더에 messages, errors 두 개의 메시지 파일을 읽고, 인코딩을 utf-8로 했다는 의미다.

## 스프링 부트에서 메시지 활용

스프링 부트는 메시지를 기본으로 빈등록한다.

```properties
#application.properties
#기본으로 등록된 메시지
spring.messages.basename=messages
#혹은 이렇게 등록해도 좋다.
spring.messages.basename=messages,config.i18n.messages
```

이렇게 하면 resources 폴더에 message 파일을 메시지로 등록한다. (국제화는 message_en, message_kr ... 이런 파일들을 등록한다.)

```properties
#messages.properties
hello=안녕
hello.name=안녕 {0}
```

```properties
#messages_en.properties
hello=hello
hello.name=hello {0}
```

위와 같이 메시지 파일을 등록해놓으면, 다음과 같이 적용할 수 있다.

```java
@SpringBootTest
public class MessageSourceTest {
	@Autowired
	MessageSource ms;
	
  void message() {
    //ms.getMessage(코드, 매개변수, (기본값), 지역정보);
    
    //hello에 해당하는 메세지
    String result = ms.getMessage("hello", null, null);
    
    //존재하지 않는 코드를 부르는 경우, NoSuchMessageException 발생.
    ms.getMessage("no_code", null, null);
    
    //존재하지 않지만, 기본값 메시지 반환
    String result = ms.getMessage("no_code", null, "Default", null);
    
    //매개변수 전달되어 반환
    String result = ms.getMessage("hello.name", new Object[] {"스프링"}, null);
    
    //message_en 존재할 경우, 국제화되서 반환
    String result = ms.getMessage("hello", null, Locale.ENGLISH); 
  }
}
```

### 타임리프에서 메시지 적용하기

`<h2 th:text="#{page.addItem}">상품 등록 폼</h2>` 이런식으로 `th:text="#{코드}"` 형식으로 사용하면 
메시지소스 객체를 불러서 메시지를 찾을 필요 없이 찾아준다.

`<p th:text="#{hello.name(${item.itemName})}"></p>` 이런식으로 매개변수도 활용할 수 있다.



# 검증

검증은 정보를 post했을 때 유효하지 않으면, 유효하지 않은 폼 데이터와 에러메세지를 모델에 담아 다시 폼을 입력할 수 있도록 한다.

