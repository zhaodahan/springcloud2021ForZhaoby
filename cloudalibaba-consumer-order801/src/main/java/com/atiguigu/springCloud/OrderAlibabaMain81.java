package com.atiguigu.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderAlibabaMain81{
    public static void main(String[] args) {
        SpringApplication.run(OrderAlibabaMain81.class,args);
    }
}
