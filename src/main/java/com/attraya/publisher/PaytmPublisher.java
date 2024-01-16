package com.attraya.publisher;

import com.attraya.config.MessagingConfig;
import com.attraya.dto.PaymentRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class PaytmPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void doPaymentTransaction(PaymentRequest paymentRequest){
        paymentRequest.setTransactionId(UUID.randomUUID().toString());
        paymentRequest.setTransactionDate(new Date());
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE,
                MessagingConfig.ROUTING_KEY, paymentRequest);
    }


}
