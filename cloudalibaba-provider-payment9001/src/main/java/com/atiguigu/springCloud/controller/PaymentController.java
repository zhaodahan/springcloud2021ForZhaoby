package com.atiguigu.springCloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${test}")
    private String testFileContent;

    @GetMapping(value = "/payment/nacos/{id}")
    @SentinelResource(value = "payment",blockHandler  = "handleException")
    public String getPayment(@PathVariable("id") Integer id)
    {
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id+"\t yml file content"+testFileContent;
    }


    public String handleException(@PathVariable("id") Integer id,BlockException exception)
    {
        System.out.println("进入了自定义的限流异常方法");
        return "自定义限流handleException";
    }

}
