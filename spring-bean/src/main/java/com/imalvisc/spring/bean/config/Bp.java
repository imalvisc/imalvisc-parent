package com.imalvisc.spring.bean.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author chenjiaming
 * @version Id: Bp.java, v 0.1 2020-06-28 15:52 chenjiaming Exp $$
 */
@Component
public class Bp implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("a".equals(beanName)) {
			System.out.println("postProcessBeforeInitialization");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("a".equals(beanName)) {
			System.out.println("postProcessAfterInitialization");
		}
		return bean;
	}
}
