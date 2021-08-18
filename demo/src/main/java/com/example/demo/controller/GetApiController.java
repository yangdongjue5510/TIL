package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });
        return sb.toString();
    }
    //쿼리 파라미터 - 여러 변수 받기.
    @GetMapping("query-param02")
    public String queryPram02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name+" "+email+" "+age;
    }
    //쿼리 파라미터 - DTO
    @GetMapping("query-param03")
    public String queryPram03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }

}
