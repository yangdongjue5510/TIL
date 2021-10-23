# 스프링 MVC 기본 기능

##### Welcome 페이지

스프링 부트에 Jar를 사용하면 /resources/static/index.html을 첫 페이지로 인식. (스프링 부트가 지원하는 정적 컨텐츠 위치에 index.html잇으면 인식)

## 로깅

스프링 부트는 spring-boot-starter-logging이 라이브러리에 포함된다.

기본적으로 SLF4J와 Logback을 사용한다.
SLF4J는 라이브러리, Logback은 구현체.

**로그 선언**

```java
private Logger log = LoggerFactory.getLogger(getClass());
private static final Logger log = LoggerFactory.getLogger(xxx.class);
```

하지만 @Slf4j 어노테이션으로 로그 선언을 대체할 수 있다.

**로그 호출**

```java
log.trace("trace log={}", name);
log.debug("debug log={}", name);
log.info(" info log={}", name);
log.warn(" warn log={}", name);
log.error("error log={}", name);

//log.trace("trace log="+name); 이런식으로 연산자를 넣으면 안된다!
```



