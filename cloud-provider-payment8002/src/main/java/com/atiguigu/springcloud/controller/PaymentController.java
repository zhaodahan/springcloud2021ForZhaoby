package com.atiguigu.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.atiguigu.springcloud.entities.CommonResult;
import com.atiguigu.springcloud.entities.Payment;
import com.atiguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
//我们想答应日志，因为引入了lombok ，可以使用@Slf4j 注解 来简化引入log 编码
//相当于在代码中加入了一句private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort; //获取配置文件中的值

    @PostMapping(value = "/payment/create")
    /*这里为什么必须要使用@RequestBody 注解：
    这里是作为服务的提供方,接收的是其他服务的调用。他们是rest 调用，传过来的是json字符串。
    需要使用@RequestBody 注解将他们转换为对象。 rest 通信的本质是json*/
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info("查询：{}", id);
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询出结果：{}", JSON.toJSONString(payment));

        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id, null);
        }
    }

}
