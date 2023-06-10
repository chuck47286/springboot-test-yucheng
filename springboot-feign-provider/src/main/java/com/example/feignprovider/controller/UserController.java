package com.example.feignprovider.controller;

import com.example.feignprovider.pojo.User;
import com.example.feignprovider.util.ServerPortUtil;
import com.example.feignprovider.vo.CommonResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
public class UserController {


    @ResponseBody
    @GetMapping("/getUserInfo")
    public CommonResponseBody<User> getUserInfo() throws InterruptedException {
        log.info("sleep 1500");
        Thread.sleep(1500);
        log.info("ready to start getting user info in feign provider server");

        User user = new User();
        // 调整是为了防止feign会自动缓存已知数据
        user.setId(ThreadLocalRandom.current().nextLong(1, 11));
        user.setName("BanQ");
        user.setAge(21);
        CommonResponseBody<User> responseBody = new CommonResponseBody<>(user);
        return responseBody.success(ServerPortUtil.getLocalURL());
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