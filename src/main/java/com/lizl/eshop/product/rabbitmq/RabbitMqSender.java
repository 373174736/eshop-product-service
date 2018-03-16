package com.lizl.eshop.product.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lizhaoliang on 18/2/24.
 */
@Component
public class RabbitMqSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String queue, String message){
        rabbitTemplate.convertAndSend(queue, message);

    }
}
