package com.jun.dpms.sys;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.household.service.IDpmsHouseholdService;

public class TestHousehold {

	@Test
	public void test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory)context.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		IDpmsHouseholdService dpmsHouseholdService=(IDpmsHouseholdService)context.getBean("dpmsHouseholdService");
		
		List<DpmsHousehold> dpmsHouseholds=dpmsHouseholdService.findAll(5, 1);
		for (DpmsHousehold dpmsHousehold : dpmsHouseholds) {
			System.out.println(dpmsHousehold.getId());
		}
	}

}
