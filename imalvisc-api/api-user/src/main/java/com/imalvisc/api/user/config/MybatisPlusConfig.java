package com.imalvisc.api.user.config;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName MybatisPlusConfig
 * @Description MybatisPlus配置类
 * @motto 学会编程而不是学会编码！
 * @date 2019-03-29 17:02
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Configuration
@MapperScan(value = "com.imalvisc.api.user.mapper")
public class MybatisPlusConfig {

//    /**
//     * MybatisPlus SQL执行性能监控插件
//     * dev和test环境开启
//     */
//    @Bean
//    @Profile({"dev", "test"})
//    public PerformanceInterceptor performanceInterceptor() {
//        return new PerformanceInterceptor();
//    }

}
