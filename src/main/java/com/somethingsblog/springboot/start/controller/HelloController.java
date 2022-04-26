package com.somethingsblog.springboot.start.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Hello")
public class HelloController {

    @Value("${welcome.message}")// load stuff from your config
    private String welcomeMessage;

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld(){
        return welcomeMessage;
    }
}
