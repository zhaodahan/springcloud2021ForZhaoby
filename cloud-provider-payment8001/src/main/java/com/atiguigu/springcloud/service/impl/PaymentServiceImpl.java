package com.atiguigu.springcloud.service.impl;

import com.atiguigu.springcloud.dao.PaymentDao;
import com.atiguigu.springcloud.entities.Payment;
import com.atiguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}