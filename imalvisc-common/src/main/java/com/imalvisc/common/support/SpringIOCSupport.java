package com.imalvisc.common.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName SpringIOCSupport
 * @Description Spring IOC容器support组件
 * @motto 学会编程而不是学会编码！
 * @date 2019-03-29 10:44
 */
@Component
public class SpringIOCSupport implements ApplicationContextAware {

    @Autowired
    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口，Spring自带的后置处理器会
     * 传入ApplicationContext调用setApplicationContext()方法，
     * 这时赋值给成员变量即可完成ApplicationContext注入。
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringIOCSupport.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> t) {
        return applicationContext.getBean(t);
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

}
