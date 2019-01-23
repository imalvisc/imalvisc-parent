package com.imalvisc.api.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.imalvisc")
public class AuthApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplicationRunner.class, args);
    }

}
