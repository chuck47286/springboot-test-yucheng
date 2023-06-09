package com.example.feignprovider.controller;

import com.example.feignprovider.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @GetMapping("/getUserInfo")
    public User getUserInfo() throws InterruptedException {
        log.info("sleep 1500");
        Thread.sleep(1500);
        log.info("ready to start getting user info in feign provider server");
        User user = new User();
        user.setId(1L);
        user.setName("BanQ");
        user.setAge(21);
        return user;
    }
    @PostMapping("/addUserInfo")
    public User addUserInfo(long id, String name, int age){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return user;
    }

}