package com.example.putapi.controller;

import com.example.putapi.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {
    @PutMapping("/put")
    public PutRequestDto put(@RequestBody PutRequestDto requestDto){
        System.out.println(requestDto);
        return requestDto;
    }
    //pathVariable
    @PutMapping("/put/{userId}")
    public PutRequestDto put2(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") Long Id){
        System.out.println(Id);
        return requestDto;
    }
}
