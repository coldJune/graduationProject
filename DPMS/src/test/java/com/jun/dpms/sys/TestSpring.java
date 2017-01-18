package com.jun.dpms.sys;

import static org.junit.Assert.*;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.sys.bean.DpmsSysUser;
public class TestSpring {

	@org.junit.Test
	public void test() {
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

			DpmsSysUser user=(DpmsSysUser)context.getBean("dpmsSysUser",DpmsSysUser.class);
			System.out.println(user.getAge());
		fail("Not yet implemented");
	}

}
