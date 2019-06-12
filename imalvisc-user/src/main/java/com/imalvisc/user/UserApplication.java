package com.imalvisc.user;

import com.imalvisc.framework.redis.annotation.CustomEnableRedisConfig;
import com.imalvisc.framework.swagger.annotation.CustomEnableSwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.imalvisc.api")
@EnableCircuitBreaker
@CustomEnableSwaggerConfig
@CustomEnableRedisConfig
@MapperScan(basePackages = "com.imalvisc.user.mapper")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }

}
