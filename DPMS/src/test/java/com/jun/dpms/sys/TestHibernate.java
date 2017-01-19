package com.jun.dpms.sys;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.sys.bean.DpmsSysUser;

public class TestHibernate {

	@Test
	public void test() {
		//����ָ��Ŀ¼�µ������ļ����õ�configuration����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DpmsSysUser dpmsSysUser = (DpmsSysUser)context.getBean("dpmsSysUser");
		dpmsSysUser.setUserName("root");
		dpmsSysUser.setPassword("root");
		System.out.println("-------------------------------");
		//����configuration����õ�session��������
		SessionFactory sf =(SessionFactory) context.getBean("sessionFactory");
		System.out.println("-------------------------------");
		//ʹ�ù������һ��session
		Session session = sf.openSession();
		//��������
		Transaction tx= session.beginTransaction();
		//�������������ݿ�Ķ���
		
		
		
		session.save(dpmsSysUser);
		session.flush();
		tx.commit();
		session.close();
		sf.close();
	}

}
