package com.jun.dpms.sys;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.sysUser.bean.DpmsSysUser;
import com.jun.dpms.sysUser.service.IDpmsSysUserService;

public class TestSysUser {

	@Test
	public void test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)context.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		IDpmsSysUserService dpmsSysUserService=(IDpmsSysUserService)context.getBean("dpmsSysUserService");
		/*List<DpmsSysUser> dpmsSysUsers = dpmsSysUserService.findAll(3,1);
		for (DpmsSysUser dpmsSysUser : dpmsSysUsers) {
			System.out.println(dpmsSysUser.getUserName()+"|"+dpmsSysUser.getPassWord());
		}*/
		DpmsSysUser dpmsSysUser=dpmsSysUserService.searchByUserName("root");
		System.out.println(dpmsSysUser.getUserName());
	}

}
