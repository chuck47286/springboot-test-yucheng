package com.example.myapplication.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.myapplication.config.SentinelConfig;
import com.example.myapplication.dto.UserDTO;
import com.example.myapplication.mappers.UserMapper;
import com.example.myapplication.service.UserService;
import com.example.myapplication.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * TODO 解决没有实例的问题：大概率是依赖
     */
//    @Autowired
//    private UserMapper userMapper;

    @GetMapping("/get/allUser")
    public List<Integer> getAllUser() {
        return Arrays.asList(1,2,3);
    }

    @GetMapping("/get/{id}")
    public int getUserById(@PathVariable int id) {
        return id + 100;
    }

    @PostMapping("/post")
    public void addUser(UserVO userVO) {
//        UserDTO userDTO = userMapper.userVOtoDTO(userVO);
        userService.add(null);
    }


}
