package com.example.myapplication.feign;

import com.example.myapplication.config.FeignConfiguration;
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
        contextId = "feignClient",
        name = "userService",
        configuration = FeignConfiguration.class
)
public interface UserFeignClient {

        @RequestMapping(method = RequestMethod.GET, value = "/api/server/getUserInfo")
        @ResponseBody
        String getUserInfo();
}
