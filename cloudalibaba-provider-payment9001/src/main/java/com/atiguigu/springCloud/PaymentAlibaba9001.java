package com.atiguigu.springCloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentAlibaba9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentAlibaba9001.class,args);
    }
}
