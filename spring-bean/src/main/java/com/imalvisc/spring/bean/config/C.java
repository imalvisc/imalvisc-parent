package com.imalvisc.spring.bean.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenjiaming
 * @version Id: C.java, v 0.1 2020-06-28 15:34 chenjiaming Exp $$
 */
@Component
public class C {

	@Autowired
	private A a;

}
