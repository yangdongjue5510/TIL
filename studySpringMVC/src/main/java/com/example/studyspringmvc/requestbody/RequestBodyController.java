package com.example.studyspringmvc.requestbody;

import com.example.studyspringmvc.basic.PersonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class RequestBodyController {

    @ResponseBody
    @RequestMapping("/request/body/text")
    public String requestBodyV1(@RequestBody String body){
        return body;
    }

    @ResponseBody
    @RequestMapping("/request/body/json")
    public PersonData requestBodyV2(@RequestBody PersonData data){
        return data;
    }
}
