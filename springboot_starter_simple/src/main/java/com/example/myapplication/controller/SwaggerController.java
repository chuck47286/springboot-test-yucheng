package com.example.myapplication.controller;

import cn.hutool.json.JSONUtil;
import com.example.myapplication.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yucheng
 * @Date 2023/5/22 14:10
 * @Version 1.0
 */
@RestController
@RequestMapping("/swagger")
@Api(tags = "Example API")
@Slf4j
public class SwaggerController {


    @GetMapping("/test")
    public String swaggerTest() {
        return "swagger test~";
    }


    @GetMapping("/hello")
    @ApiOperation("Say hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello!");
    }

    @PostMapping("/user")
    @ApiOperation("Create a user")
    public ResponseEntity<User> createUser(
            @ApiParam("User details") @RequestBody User user) {
        // 处理创建用户的逻辑
        log.info("[user] {}", user);
        return ResponseEntity.ok(user);
    }

}
