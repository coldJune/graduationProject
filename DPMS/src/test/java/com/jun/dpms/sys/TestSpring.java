package com.jun.dpms.sys;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.sys.bean.DpmsSysUser;

public class TestSpring {

	@org.junit.Test
	public void test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("src/main/resources/applicationContext.xml");
		DpmsSysUser user=(DpmsSysUser)context.getBean("dpmsSysUser");
		System.out.println(user.getAge());
	
	}
}
