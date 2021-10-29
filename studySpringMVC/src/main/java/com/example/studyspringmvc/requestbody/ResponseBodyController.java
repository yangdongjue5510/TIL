package com.example.studyspringmvc.requestbody;

import com.example.studyspringmvc.basic.PersonData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseBodyController {

    @RequestMapping("/response/body/entity/string")
    public ResponseEntity<String> responseV1(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @RequestMapping("/response/body/entity")
    public ResponseEntity<PersonData> responseV2(){
        PersonData data = new PersonData();
        data.setAge(12);
        data.setName("yang");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @RequestMapping("/response/body/string")
    public String responseV3(){
        return "hello";
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/response/body/entity2")
    public PersonData responseV4(){
        PersonData data = new PersonData();
        data.setName("yang ho");
        data.setAge(12);
        return data;
    }
}
