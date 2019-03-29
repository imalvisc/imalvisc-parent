package com.imalvisc.api.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName UserApplication
 * @Description 用户模块SpringBoot启动类
 * @motto 学会编程而不是学会编码！
 * @date 2019-03-29 15:12
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@SpringBootApplication
@ComponentScan(value = "com.imalvisc")
@MapperScan(value = "com.imalvisc.api.user.mapper")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
