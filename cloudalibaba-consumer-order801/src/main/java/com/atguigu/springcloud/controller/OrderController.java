package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService; //读操作用get, 写操作用post


    @GetMapping("/consumer/payment/get/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return paymentFeignService.getPayment(id);
    }
}
