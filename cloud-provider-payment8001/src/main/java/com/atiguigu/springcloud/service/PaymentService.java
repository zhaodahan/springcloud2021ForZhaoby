package com.atiguigu.springcloud.service;

import com.atiguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

//java中接口的方法默认是 public  abstract 的,可以放心的删掉public
public interface PaymentService {

    int create(Payment payment); //增

    Payment getPaymentById(@Param("id") Long id); //查
}
