package com.imalvisc.common.utils;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMqUtils {

    private static RabbitTemplate rabbitTemplate;

    static {
        rabbitTemplate = SpringUtils.getBean(RabbitTemplate.class);
    }

    public static void send(String exchange, String routingKey, Object message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
