package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置openFegin 日志增强的日志级别
@Configuration
public class FeignConfig {

    //这里的Logger 是openFegin 中的log
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
