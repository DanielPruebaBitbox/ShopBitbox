package com.example.shop.shopproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorld {
    @RequestMapping("/")
    public String index(){
        return "Hello World";
    }
}
