package com.imalvisc.spring.bean.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenjiaming
 * @version Id: B.java, v 0.1 2020-06-28 15:33 chenjiaming Exp $$
 */
@Component
public class B {

	@Autowired
	private C c;

}
