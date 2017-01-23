package com.jun.dpms.sys;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.sysUser.action.DpmsSysUserAction;
import com.jun.dpms.sysUser.bean.DpmsSysUser;
import com.jun.dpms.sysUser.service.IDpmsSysUserService;
import com.jun.dpms.sysUser.service.impl.DpmsSysUserServiceImpl;

public class TestLogin {

	@Test
	public void test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)context.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		IDpmsSysUserService dpmsSysUserService=(IDpmsSysUserService)context.getBean("dpmsSysUserService");
		DpmsSysUser user=new DpmsSysUser();
		user.setUserName("root");
		System.out.println(dpmsSysUserService.checkUserName(user));
		user.setPassWord("roo");
		System.out.println(dpmsSysUserService.checkUser(user));
	}

}
