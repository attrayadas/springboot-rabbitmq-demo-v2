package com.attraya.controller;

import com.attraya.dto.PaymentRequest;
import com.attraya.publisher.PaytmPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaytmController {

    @Autowired
    private PaytmPublisher paytmPublisher;

    @PostMapping("/mq/pay")
    public String payUsingUPI(@RequestBody PaymentRequest paymentRequest){
        paytmPublisher.doPaymentTransaction(paymentRequest);
        return "payment request in process!!";
    }

}
