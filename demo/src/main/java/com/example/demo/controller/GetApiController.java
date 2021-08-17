package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path = "/hello") //http://localhost:9090/api/get/hello
    public String getHello(){
        return "get Hello";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET) //method 없으면, get, post, put, delete 모두 작동.
    public String hi(){
        return "hi";
    }
    //http://localhost:9090/api/get/path-variable/{name}
    //{name}은 변화하는 값. 변화할 때마다 주소를 다 추가할 순 없어!

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable: "+pathName);
        return pathName;
    }
    //쿼리 파라미터
    //http://localhost:9090/api/get/query-param?user=steve&email=naver&age=25
}
