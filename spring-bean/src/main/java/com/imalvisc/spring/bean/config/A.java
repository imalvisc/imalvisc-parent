package com.imalvisc.spring.bean.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author chenjiaming
 * @version Id: A.java, v 0.1 2020-06-28 15:33 chenjiaming Exp $$
 */
@Component
public class A implements ApplicationContextAware {

	@Autowired
	private B b;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setApplicationContext");
	}
}
