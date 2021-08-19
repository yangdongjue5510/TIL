package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){
        return "main.html";
    }

    //how to response in json
    //ResponseEntity

    @ResponseBody
    @GetMapping("/user")
    public User user(){
        var user = new User(); //java 신기능 var
        user.setName("steve");
        user.setAddress("home");
        return user;
    }
}
