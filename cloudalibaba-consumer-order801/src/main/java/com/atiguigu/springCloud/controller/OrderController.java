package com.atiguigu.springCloud.controller;

import com.atiguigu.springCloud.dao.MessDao;
import com.atiguigu.springCloud.entities.Mess;
import com.atiguigu.springCloud.service.PaymentFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService; //读操作用get, 写操作用post

    @Resource
    private MessDao messDao;


    @GetMapping("/consumer/payment/get/{id}")
    @GlobalTransactional
    public String getPayment(@PathVariable("id") Integer id) {
        Mess mess = new Mess();
        mess.setLen(new Random(100).nextInt(10));
        messDao.insert(mess);
        log.info("order 操作数据库成功");
        return paymentFeignService.getPayment(id);
    }
}
