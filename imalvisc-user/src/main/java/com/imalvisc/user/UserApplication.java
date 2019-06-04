package com.imalvisc.user;

import com.imalvisc.apollo.annotation.CustomEnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@CustomEnableApolloConfig(value = {"application.properties", "imalvisc.properties"})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }

}
