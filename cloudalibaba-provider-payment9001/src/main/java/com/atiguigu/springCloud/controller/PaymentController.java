package com.atiguigu.springCloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atiguigu.springCloud.dao.MessDao;
import com.atiguigu.springCloud.entities.Mess;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@RestController
@RefreshScope
public class PaymentController {
//    @Value("${server.port}")
//    private String serverPort;
//
//    @Value("${test}")
//    private String testFileContent;

    @Resource
    private MessDao messDao;

    @GetMapping(value = "/payment/nacos/{id}")
    @SentinelResource(value = "payment",blockHandler  = "handleException")
    public String getPayment(@PathVariable("id") Integer id) throws InterruptedException {
        Mess mess = new Mess();
        mess.setLen(new Random(10).nextInt(10));
        messDao.insert(mess);
        Thread.sleep(3000);
        final int i = 10 / 0;
        return "payment 插入成功";
    }


    public String handleException(@PathVariable("id") Integer id,BlockException exception)
    {
        System.out.println("进入了自定义的限流异常方法");
        return "自定义限流handleException";
    }

}
