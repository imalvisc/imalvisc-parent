package com.imalvisc.common.util;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMqUtil {

    private static RabbitTemplate rabbitTemplate;

    static {
        rabbitTemplate = SpringUtil.getBean(RabbitTemplate.class);
    }

    public static void send(String exchange, String routingKey, Object message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
