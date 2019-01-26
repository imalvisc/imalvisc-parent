package com.imalvisc.api.auth.service.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
public class LoginRecordListener {

    @RabbitListener(queues = "login-record")
    public void listener(HashMap<String, String> message) {
        log.info("登录记录：{}", message);
    }

}
