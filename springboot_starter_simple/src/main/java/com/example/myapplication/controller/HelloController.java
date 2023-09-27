package com.example.myapplication.controller;

import com.example.myapplication.config.TestBean;
import com.example.myapplication.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    @Qualifier("testBeanthree")
    private TestBean bean;

    @RequestMapping("/")
    private String home() {
        return "Hello World!\n this is from myapplication";
    }

    @RequestMapping("/hello")
    String hello() {
        String helloTemplate = "hello word~";
        log.info(helloTemplate);
        return helloTemplate;
    }

    @RequestMapping("/test/bean")
    String testBean() {
        log.info("[testBean] {}", bean);
        return "hello! testBean is created";
    }


}
