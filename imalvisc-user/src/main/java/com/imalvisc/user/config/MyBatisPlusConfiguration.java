package com.imalvisc.user.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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

//    /**
//     * SQL执行性能监控插件
//     * dev和test环境开启
//     */
//    @Bean
//    @Profile(value = {"dev", "test"})
//    public PerformanceInterceptor performanceInterceptor() {
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        performanceInterceptor.setFormat(true);
//        return performanceInterceptor;
//    }

    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLimit(Integer.MAX_VALUE);
        return paginationInterceptor;
    }

}
