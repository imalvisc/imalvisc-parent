package com.imalvisc.common.utils;

import com.imalvisc.common.support.SpringIOCSupport;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMqUtils {

    private static RabbitTemplate rabbitTemplate;

    static {
        rabbitTemplate = SpringIOCSupport.getBean(RabbitTemplate.class);
    }

    public static void send(String exchange, String routingKey, Object message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
