package com.jun.dpms.sys;


import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.sysUser.bean.DpmsSysUser;
import com.jun.dpms.sysUser.dao.IDpmsSysUserDao;
import com.jun.dpms.sysUser.service.IDpmsSysUserService;

public class TestSysUser {

	@Test
	public void test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)context.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		IDpmsSysUserService dpmsSysUserService=(IDpmsSysUserService)context.getBean("dpmsSysUserService");
		IDpmsSysUserDao dpmsSysUserDao=(IDpmsSysUserDao) context.getBean("dpmsSysUserDao");
		/**
		 * ���������û�����ҳ��ʾ
		 */
//		List<DpmsSysUser> dpmsSysUsers = dpmsSysUserService.findAll(3,1);
//		for (DpmsSysUser dpmsSysUser : dpmsSysUsers) {
//			System.out.println(dpmsSysUser.getUserName()+"|"+dpmsSysUser.getPassWord());
//		}
		/**
		 * ͨ���û��������û�
		 */
//		DpmsSysUser dpmsSysUser=dpmsSysUserService.searchByUserName("root");
//		System.out.println(dpmsSysUser.getUserName());
		
		/**
		 * �����û�
		 */
		DpmsSysUser dpmsSysUser = (DpmsSysUser)dpmsSysUserService.searchByUserName("test1");
		dpmsSysUser.setAddress("����");
		dpmsSysUser.setEmail("1883294@qq.com");
		dpmsSysUser.setAge(23);
		dpmsSysUser.setBirthDay(new Date());
		dpmsSysUser.setCardId("1234567");
		dpmsSysUser.setPhone("11111111111");
		dpmsSysUser.setGender(0);
		dpmsSysUserDao.updateSysUser(dpmsSysUser);
		
	}

}
