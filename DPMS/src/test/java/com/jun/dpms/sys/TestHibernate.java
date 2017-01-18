package com.jun.dpms.sys;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.sys.bean.DpmsSysUser;

public class TestHibernate {

	@Test
	public void test() {
		//加载指定目录下的配置文件，得到configuration对象
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//根据configuration对象得到session工厂对象
		SessionFactory sf=cfg.buildSessionFactory();
		//使用工厂类打开一个session
		Session session = sf.openSession();
		//开启事务
		Transaction tx= session.beginTransaction();
		//创建待插入数据库的对象
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DpmsSysUser dpmsSysUser = (DpmsSysUser)context.getBean("dpmsSysUser");
		dpmsSysUser.setUserName("root");
		dpmsSysUser.setPassword("root");
		session.save(dpmsSysUser);
		tx.commit();
		session.close();
		sf.close();
	}

}
