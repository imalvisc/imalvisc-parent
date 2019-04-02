package com.imalvisc.api.user;

import com.imalvisc.api.common.swagger.annotation.EnableSwagger;
import com.imalvisc.env.annotation.EnableEnv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName UserApplication
 * @Description 用户模块SpringBoot启动类
 * @motto 学会编程而不是学会编码！
 * @date 2019-03-29 15:12
 */
@SpringBootApplication
@EnableEnv
@EnableEurekaClient
@EnableSwagger
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
