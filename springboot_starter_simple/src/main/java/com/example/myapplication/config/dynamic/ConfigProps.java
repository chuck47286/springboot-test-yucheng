package com.example.myapplication.config.dynamic;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Author yucheng
 * @Date 2023/9/25 18:21
 * @Version 1.0
 */
@Data
@Configuration
@ConfigurationProperties("iitp")
public class ConfigProps {

    private Map<String, BaseBean> biz;
//    private Map<String, String> beans;


//    public Map<String, BaseBean> getBeans() {
//        return beans;
//    }
//
//    public void setBeans(Map<String, BaseBean> beans) {
//        this.beans = beans;
//    }
}
