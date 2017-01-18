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
		//����ָ��Ŀ¼�µ������ļ����õ�configuration����
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		//����configuration����õ�session��������
		SessionFactory sf=cfg.buildSessionFactory();
		//ʹ�ù������һ��session
		Session session = sf.openSession();
		//��������
		Transaction tx= session.beginTransaction();
		//�������������ݿ�Ķ���
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