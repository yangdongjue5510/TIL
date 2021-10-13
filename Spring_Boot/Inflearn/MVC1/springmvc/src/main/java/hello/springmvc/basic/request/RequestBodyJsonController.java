package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyJsonController {

    /*
    1. 서블릿 활용하기
    2. @RequestBody
    3. @RequestBody 모델 넣기 *
    ->메시지 컨버터가 json인식하고 모델에 넣어줌(컨텐트 타입이 json으로 되야 json으로 인식)
        - @RequestBody 생략하면 안됩니다!!!!(생략하면 @ModelAttribute가 들어가서..)
        - 스프링의 생략 규칙 : 단순타입 = @RequestParam / 나머지 @ModelAttribute (argument resolver는 논외 , HttpEntity...등)
    4. HttpEntity 사용하기 *
    5. @ResponseBody의 특징을 이용해 응답 바디에 json넣기. (모델을 리턴) *
    -> 이때도 메시지 컨버터가 모델을 json으로 바꿔서 바디에 넣는다.
    -> Accept 헤더 값이 json으로 되어있어야 응답을 json으로 받을 수 있다.

    정리
    @RequestBody 요청 시 : JSON 요청 -> HTTP 메시지 컨버터 -> 객체
    @ResponseBody 응답 시 : 객체 -> HTTP 메시지 컨버터 -> JSON
     */

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("{}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("{} {}", helloData.getUsername(), helloData.getAge());;
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws IOException {
        log.info("{}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("{} {}", helloData.getUsername(), helloData.getAge());;
        return "ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody HelloData helloData)  {
        log.info("{} {}", helloData.getUsername(), helloData.getAge());;
        return "Ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public String requestBodyJsonV4(HttpEntity<HelloData> data)  {
        HelloData helloData = data.getBody();
        log.info("{} {}", helloData.getUsername(), helloData.getAge());;
        return "Ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData requestBodyJsonV5(@RequestBody HelloData helloData)  {
        log.info("{} {}", helloData.getUsername(), helloData.getAge());;
        return helloData;
    }
}
