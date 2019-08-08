package com.imalvisc.spring.mybatis;

import com.imalvisc.spring.mybatis.mapper.UserInfoMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = {"com.imalvisc.spring.mybatis.mapper"})
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        UserInfoMapper userInfoMapper = applicationContext.getBean(UserInfoMapper.class);
        System.out.println(userInfoMapper.selectAll());
    }

}
