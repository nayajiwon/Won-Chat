package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {
    @RequestMapping("/test")
    public String restTest(@RequestParam String str){
        return str + "테스트";
    }
}
