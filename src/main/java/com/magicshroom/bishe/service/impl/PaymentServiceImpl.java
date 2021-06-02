package com.magicshroom.bishe.service.impl;

import com.magicshroom.bishe.bean.Payment;
import com.magicshroom.bishe.mapper.PaymentMapper;
import com.magicshroom.bishe.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public void addPayment(Payment payment) {
        paymentMapper.insertPayment(payment);
    }
}
