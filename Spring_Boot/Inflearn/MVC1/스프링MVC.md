# 스프링 MVC 기본 기능

## SpringMVC 구조

1. **Dispatcher Servlet**으로 HTTP 요청이 도착(프론트 컨트롤러 수행)
2. **핸들러 매핑**에서 핸들러 조회 (컨트롤러 찾기)
3. 핸들러 어댑터 목록에서 맞는 **핸들러 어댑터 조회**
4. 핸들러 어댑터를 통해 **핸들러 수행**
5. 핸들러 어댑터가 **ModelAndView 반환**(데이터 객체와 논리적 뷰)
6. 디스패처 서블릿이 **viewResolver를 호출해서 View 반환**
   (논리적 뷰를 물리적 뷰로 전환)
7. View를 **렌더링** 해서 HTML응답.

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

하지만 **@Slf4j** 어노테이션으로 로그 선언을 대체할 수 있다.

**로그 호출**

```java
log.trace("trace log={}", name);
log.debug("debug log={}", name);
log.info(" info log={}", name);
log.warn(" warn log={}", name);
log.error("error log={}", name);

//log.trace("trace log="+name); 이런식으로 연산자를 넣으면 안된다!
```

**로그 레벨 설정** (trace > debug > info > warn > error)

```java
//전체 프로젝트 로그레벨
logging.level.root=info  

//특정 패키지 및 하위 로그레벨
logging.level.hello.springmvc = debug
```



## 매핑

### 매핑 정보

**@RestController** : 반환 값으로 뷰로 찾는게 아니라 HTTP 메시지 바디에 입력
**@Controller** : String으로 뷰 이름을 인식

**@RequestMapping("url")** : url호출이 오면 메서드 실행
{"url1", "url2"}도 가능!,  http 메서드와 무관하게 호출

**@GetMapping(), @PostMapping** : http 메서드를 지정한 requestMapping.
Consume 필드 = content-type 지정
Produce 필드 = accept 타입 지정
Params 필드 = 쿼리파라미터의 특정 조건 (a=b를 써주면 그 내용이 있어야)
header 필드 = 헤더 값의 조건 (헤더에 a=b가 있어야)

**@PathVariable** : 쿼리 파라미터로 값 받아오기. 
Url 속 {value}를 말하는데, url 속 이름과 변수 이름이 같으면 어노테이션만 붙여도 된다.
다르면 매개변수로 url 속 이름을 전달해줘야 한다.

**요청 매핑 API 예시**

```java
GET 회원 목록 조회 "/users"
POST 회원 등록 "/users"
GET 회원 조회 "/users/{userId}"
PATCH 회원 수정 "/users/{userId}"
DELETE 회원 삭제 "/users/{userId}"
```



## HTTP 요청

HttpServletRequest 요청객체
HttpServletResponse 응답객체
HttpMethod http 메소드
Locale 지역정보
@RequestHeader MultiValueMap<String, String> 헤더값 모두 저장
@ReqeustHeader("헤더키") 헤더 밸류반환
@CookieValue(value="value", required = false) 쿠키반환

> MultiValueMap

하나의 키에 여러 값 받을 수 잇음.



## HTTP 요청 파라미터

클라이언트에서 서버로 요청 데이터 보내는 3가지

1. **GET - 쿼리 파라미터**
   바디 안쓰고 url에 파라미터로 보냄
2. **POST - HTML form**
   Content-type : application/x-www-form-urlencoded
   메시지 바디에 쿼리 파라미터 형식으로 전달
3. **POST/PUT/PATCH - HTTP message body**
   바디에 데이터 직접 담기 (JSON, xml, text)

### 요청 파라미터 - 쿼리 파라미터, html form

HttpServletRequest의 getParameter()로 두가지 요청 파라미터 처리 가능했다.

> Jar 는 webapp을 인식하지 않고 static에서 정적 리소스 인식!



**@RequestParam** : HttpServletRequest의 getParmeter()를 호출한 것과 동일!
키값이 변수명과 같으면 그냥 붙이면 됨(PathVariable과 동일)

- Required 필드 : 파라미터 필수 여부

- 파라미터에 빈 값을 전달하면 null을 전달-> 파라미터의 자료형이 기본형이면 오류!!!

  -> Integer 같은 레퍼런스 타입을 사용하자.
  -> defaultValue를 사용.

- 모든 파라미터를 전달받고 싶으면 Map 혹은 MultiValueMap 사용!

**@ResponseBody** : controller기반의 메소드에서 view 조회를 무시하고 HTTP body에 해당 내용 입력

### 요청 파라미터 - @ModelAttribute

파라미터를 받아서 그걸 저장할 수 있는 객체에 넣어주는 역할을 한다.

데이터를 받을 수 있는 객체를 선언하고 메서드의 파라미터로 넣어놓으면?
스프링이 알아서 객체 만들어서 변수에 할당하고 setter로 초기화.



> ### 스프링 MVC 파라미터에 규칙

- 단순 타입 전달되면? @RequestParam이 붙었다고 생각!
- 나머지 타입이면? @ModelAttribute가 붙었다고 생각!
- Argument reslover가 지정한 타입은 제외!(HttpServletRequest..등)

### 요청 Body 메시지 - 단순 텍스트

servlet에서는 

HttpServletRequest.getInputStream()으로 ServeltInputStream 객체를 받아 메시지를 가져올 수 있다.

HttpServletResponse.getWriter().write()로 Body에 내용을 적을 수 있다.

**InputStream (Reader), OutputStream (Writer)**

스프링 mvc 파라미터로 위 객체형을 넣어주면, HTTP 요청(혹은 응답) 메시지 바디에 직접 접근할 수 있다.

**HttpEntity**

http header, body 정보를 편리하게 조회.
HttpEntity는 응답에도 사용가능

**RequestEntity, ResponseEntity**

HttpEntity를 상속받은 객체. 여러 추가 기능 제공

**@RequestBody**

http 메시지 바디 정보를 쉽게 조회가능. 
(헤더가 필요하면 @RequestHeader 사용, 혹은 HttpEntity)

**@ResponseBody**

return 값을 메시지에 담음. (view를 반환 안한다!)



## 요청 Body 메시지 - JSON

Servlet에서는

HttpServletRequest로 json을 문자로 불러와서,
Jackson 라이브러리의 objectMapper 객체를 통해 json을 담을 수 있는 객체에 파싱해서 저장한다.

**@RequestBody로 문자열로 받기**

이럴 경우 문자열을 objectMapper로 다시 다른 객체로 담아줘야 한다.

**@RequestBody로 객체로 받기**

애초에 MVC 파라미터로 객체를 주면 마치 @ModelAttribute처럼 파싱되서 저장된다. 
(하지만 ModelAttribute와는 달리 생략이 안된다.)

**@ResponseBody로 객체 반환하기**

객체로 값을 담아서 반환하면, JSON으로 응답된다.

> **요약**

@RequestBody : Json -> 메시지 컨버터 -> 객체

@ResonseBody : 객체 -> 메시지 컨버터 -> Json



## 응답 - 정적 리소스, 뷰 템플릿

### 스프링에서 응답 데이터를 만드는 3가지

1. **정적 리소스**
   HTML, CSS, JS
2. **뷰 템플릿 사용**
   동적인 HTML
3. **HTTP 메시지 사용**
   HTTP API 제공하면, 데이터를 전달해야 함.
   바디에 JSON 형식으로 데이터 전달



### 정적 리소스

**경로**
**/static, /public, /resources, /META-INF/resources**
스프링 부트는 클래스패스의 다음 디렉토리에 있는 정적 리소스를 제공.

정적 리소스는 해당 파일을 변경 없이 그대로 서비스!



### 뷰 템플릿

뷰 템플릿을 거쳐 HTML을 생성하고 뷰가 응답을 만들어 전달.

**경로**
src/main/resources/templates

```java
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

application.properties에서 뷰 템플릿이 논리적 뷰를 물리적 뷰로 바꾸는 원리를 알 수 있다.



### String을 반환하는 경우 - view or http 메시지

**@ResponseBody가 없다고 할 때,**

문자열이 반환되면, **뷰 리졸버**가 실행되서 뷰를 찾고 렌더링한다.



> void를 반환하면?

요청 URL을 참고해서 논리 뷰로 전달된다.(물론 비추!!!)



**@ResponseBody가 있다고 할 때,**

문자열이 반환되면, HTTP 바디에 직접 응답 데이터를 넣을 수 있다!



### 응답 - HTTP API, 메시지 바디에 직접 입력

서블릿를 이용해서,

HttpServletResponse.getWriter().write()로 직접 쓸 수 있다.

**ResponseEntity 반환하기**

ResponseEntity 객체를 생성해서 데이터와 상태코드를 입력해서 반환
ResponseEntity에는 객체나 문자열이 바디 데이터로 들어갈 수 있다.

**@ResponseBody로 객체, 문자열 반환**

객체를 보내면 json으로, 문자열을 보내면 그대로 바디에 담아서 응답한다.
다만 상태코드는 @ResponseStatus로 지정해줄 수 있다.



## HTTP 메시지 컨버터

HTTP API처럼 **JSON 데이터를 HTTP 바디에서 읽고 쓰는 경우 메시지 컨버터가 작동!**

문자는 StringHttpMessageConverter
객체는 MappingJacson2HttpMessageConverter 등등..

HTTP **Accept 헤더와 서버의 컨트롤러 반환 타입**에 따라 HTTP 메시지 컨버터가 선택된다.

스프링의 경우,

**@RequestBody, @ResponseBody, HttpEntity (RequestEntity, ResponseEntity)** 인 경우 메시지 컨버터가 작동!

### 메시지 컨버터의 위치

@RequestMapping을 처리하는 어댑터인 **RequestMappingHandlerAdapter(요청 매핑 핸들러 어댑터)**를 주목해야.

**ArgumentResolver**

요청 매핑 핸들러 어댑터가 ArgumentResolver가 호출해서 컨트롤러가 필요로 하는 다양한 파라미터 객체를 생성한다.
(실제로는 HandlerMethodArgumentResolver 인터페이스, 더 확장 가능)

ArgumentResolver는 해당 파라미터가 supportsParameter()로 지원하는 지 판별하고, resolveArgument()로 적절한 객체를 반환한다.

**ReturnValueHandler**

HandlerMethodReturnValueHandler가 응답값을 변환하고 처리한다.

문자열을 반환해도 동작하는 이유가 얘때문이다.

> **메시지 컨버터는 ArgumentResolver와 ReturnValueHandler에 있다!**

@RequestBody, @ResponseBody, HttpEntity 모두 적절하게 문자열이나 json으로 변환 가능해야 하므로...!

인자로 뭐가 오던, 반환값으로 뭐가 오던 적절한 데이터로 바꿔서 전달한다!
