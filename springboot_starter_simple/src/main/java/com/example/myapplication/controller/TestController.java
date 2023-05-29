package com.example.myapplication.controller;

import com.example.myapplication.config.PropertyTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private PropertyTest propertyTest;

    @GetMapping("/test")
    public String propertyGet(){
        return propertyTest.getTestValueA();
    }
}
