package com.imalvisc.api.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.imalvisc")
@MapperScan(value = "com.imalvisc.api.auth.mapper")
public class AuthApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplicationRunner.class, args);
    }

}
