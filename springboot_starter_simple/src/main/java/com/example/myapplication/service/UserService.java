package com.example.myapplication.service;

import cn.hutool.json.JSONUtil;
import com.example.myapplication.dto.UserDTO;
import com.example.myapplication.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
public class UserService {


    private AtomicLong cnt = new AtomicLong(0l);


    public void add(UserDTO userDTO) {
        try {
            cnt.getAndIncrement();
//            log.info("[UserDTO] {}", JSONUtil.toJsonStr(userDTO));
//            Thread.sleep(35);
        } catch (Exception e) {
            log.info("[err-message] {}", e.getMessage());
        }

    }

    public long getCnt() {
        long cntAndReSet = cnt.getAndSet(0l);
        log.info("userService add method is queried by {} times", cntAndReSet);
        return cntAndReSet;
    }
}
