package com.example.myapplication.controller;

import com.example.myapplication.aspect.TimeCostMonitorAnnotation;
import com.example.myapplication.feign.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yucheng
 * @Date 2023/5/26 11:07
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/feign")
public class FeignClientController {

    @Autowired
    private UserFeignClient userFeignClient;

//    @TimeCostMonitorAnnotation
    @GetMapping("/get")
    public String getUserInfoByFeignClient(){
        log.info("start to feign client get UserInfo");
        return userFeignClient.getUserInfo();
    }


}
