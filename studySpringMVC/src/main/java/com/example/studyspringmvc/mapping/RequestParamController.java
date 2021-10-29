package com.example.studyspringmvc.mapping;

import com.example.studyspringmvc.basic.PersonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestParamController {

    @ResponseBody
    @RequestMapping("/request/param")
    public String requestParamV1( String name, @RequestParam int age){
        log.info(name);
        log.info("{}",age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request/param/map")
    public String requestParamV2(@RequestParam MultiValueMap<String, Object> map){

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model/attribute")
    public String modelAttributeV1(@ModelAttribute PersonData personData){
        log.info("{}", personData.getName());
        log.info("{}", personData.getAge());
        return "ok";
    }

    @RequestMapping("/request/body")
    public void requestBodyV1(InputStream inputStream, Writer writer) throws IOException {
        String content = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        writer.write("content");
    }
}
