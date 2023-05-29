package com.example.feignprovider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yucheng
 * @Date 2023/5/26 10:13
 * @Version 1.0
 */
@Slf4j
@RestController
public class TemplateController {

    @GetMapping
    public String templateController() {
        return "this is feign provider application, welcome";
    }
}
