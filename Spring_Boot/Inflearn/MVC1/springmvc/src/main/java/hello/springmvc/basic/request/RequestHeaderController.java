package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod, //get, put, post ...
                          Locale locale, //국가 언어정보
                          @RequestHeader MultiValueMap<String, String> headerMap, //헤더의 모든 정보
                          @RequestHeader("host") String host, //헤더의 하나만 가져오기
                          @CookieValue(value= "myCookie", required = false) String cookie //쿠키가져오기
                          ){

        log.info("{} {} {} {} {} {} {}", request, response , httpMethod, locale, headerMap, host, cookie);
        return "ok";
    }
}
