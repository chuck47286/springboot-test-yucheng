package com.example.myapplication.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author yucheng
 * @Date 2023/5/26 11:02
 * @Version 1.0
 */
@FeignClient(
        name = "userService",
        url = "http://localhost:8082/api/server"
)
public interface UserFeignClient {

        @RequestMapping(method = RequestMethod.GET, value = "/getUserInfo")
        @ResponseBody
        String getUserInfo();
}
