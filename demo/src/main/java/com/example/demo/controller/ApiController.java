package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //해당 클래스는 rest api 처리하는 컨트롤러
@RequestMapping("/api") //RequestMapping은 URI를 지정해주는 Annotation
public class ApiController {
    @GetMapping("/hello") //http://localhost:9090/api/hello
    public String hello(){
        return "hello spring boot!";
    }
}
