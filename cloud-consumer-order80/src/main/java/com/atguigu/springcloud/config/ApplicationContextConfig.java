package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//全局配置类
@Configuration
public class ApplicationContextConfig {

    /*springBoot 是容器类的方式，默认的是没有自动引入restTmplate 这个类的，他属于额外功能
    我们需要额外引入tmplate 这个类的话，需要将他先注入到容器中*/
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return  new RestTemplate();
    }
}


