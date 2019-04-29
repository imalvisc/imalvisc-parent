package com.imalvisc.user.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName MyBatisPlusConfiguration
 * @Description MyBatisPlus配置
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 12:16
 */
@Configuration
@EnableTransactionManagement
@MapperScan(value = "com.imalvisc.user.mapper")
public class MyBatisPlusConfiguration {

    /**
     * SQL执行性能监控插件
     * dev和test环境开启
     */
    @Bean
    @Profile(value = {"dev", "test"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
