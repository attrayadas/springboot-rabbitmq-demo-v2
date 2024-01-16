package com.attraya.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String QUEUE = "paytm_queue";
    public static final String EXCHANGE = "paytm_exchange";
    public static final String ROUTING_KEY = "paytm_routingKey";

    // Define the queue
    @Bean
    public Queue queue(){
        return new Queue(QUEUE); // name of th queue
    }

    // Define the exchange
    @Bean
    public Exchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    // Combining the queue and exchange
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }

    // Similar to KafkaTemplate
    public AmqpTemplate template(ConnectionFactory factory){
        RabbitTemplate template = new RabbitTemplate(factory);
        template.setMessageConverter(converter());
        return template;
    }

    // to play with JSON
    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

}
