package com.example.myapplication.controller;

import com.example.myapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CntController {

    @Autowired
    private UserService userService;

    @GetMapping("/cnt/user")
    public long cntUserGet() {
        return userService.getCnt();
    }
}
