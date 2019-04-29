package com.imalvisc.user.config;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName MyBatisPlusConfiguration
 * @Description MyBatisPlus配置
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 12:16
 */
@Configuration
public class MyBatisPlusConfiguration {

    /**
     * MybatisPlus SQL执行性能监控插件
     * dev和test环境开启
     */
    @Bean
    @Profile({"dev", "test"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

}
