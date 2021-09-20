package com.atiguigu.springCloud.controller;

import com.atiguigu.springCloud.service.PaymentFeignService;
import com.atiguigu.springcloud.entities.CommonResult;
import com.atiguigu.springcloud.entities.Payment;
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
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
