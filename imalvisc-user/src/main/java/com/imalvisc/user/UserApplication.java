package com.imalvisc.user;

//import com.imalvisc.framework.apollo.annotation.CustomEnableApolloConfig;
import com.imalvisc.framework.redis.annotation.CustomEnableRedisConfig;
import com.imalvisc.framework.swagger.annotation.CustomEnableSwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@CustomEnableApolloConfig(value = {"application", "imalvisc"})
@CustomEnableSwaggerConfig
@CustomEnableRedisConfig
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }

}
