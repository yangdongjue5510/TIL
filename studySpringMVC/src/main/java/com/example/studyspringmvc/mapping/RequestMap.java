package com.example.studyspringmvc.mapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


@Slf4j
@RestController
public class RequestMap {
    @GetMapping
    public String user(){
        return "get users";
    }

    @RequestMapping("/url")
    public String requestMappingV1(){
        log.info("requestMappingV1");
        return "ok";
    }

    @RequestMapping({"/url1", "/url2"})
    public String requestMappingV2(){
        log.info("requestMappingV2");
        return "ok";
    }

    @RequestMapping("/url3/{param1}")
    public String requestParam(@PathVariable String param1){
        log.info(param1);
        return "ok";
    }

    @GetMapping("/http-req")
    public String httpReqV1(HttpServletRequest request,
                            HttpServletResponse response,
                            HttpMethod method,
                            Locale locale,
                            @RequestHeader MultiValueMap<String, String> hashMap,
                            @RequestHeader("host") String host,
                            @CookieValue(value = "myCookie", required = false) String cookie){

        log.info("{}",request);
        log.info("{}",response);

        return "ok";

    }
}
