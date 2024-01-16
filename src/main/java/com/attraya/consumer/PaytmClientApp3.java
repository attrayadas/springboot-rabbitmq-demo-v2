package com.attraya.consumer;

import com.attraya.config.MessagingConfig;
import com.attraya.dto.PaymentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaytmClientApp3 {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void processPaymentRequest(PaymentRequest paymentRequest) throws JsonProcessingException {
        log.info("PaytmClientApp3.processPaymentRequest consumes {}", new ObjectMapper().writeValueAsString(paymentRequest));
    }
}
