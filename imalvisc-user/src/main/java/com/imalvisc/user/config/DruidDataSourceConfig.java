package com.imalvisc.user.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName DruidDataSourceConfig
 * @Description Druid数据源配置
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-12 18:59
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Configuration
public class DruidDataSourceConfig {

    /**
     * Druid监控
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //IP白名单
        registrationBean.addInitParameter("allow", "");
        //IP黑名单, 与allow存在相同时, deny优先于allow
        registrationBean.addInitParameter("deny", "");
        //登陆名
        registrationBean.addInitParameter("loginUsername", "admin");
        //登陆密码
        registrationBean.addInitParameter("loginPassword", "admin");
        return registrationBean;
    }

}
