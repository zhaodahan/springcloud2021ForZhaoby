package com.atiguigu.springcloud.dao;

import com.atiguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
     int create(Payment payment); //增

     Payment getPaymentById(@Param("id") Long id); //查
}
