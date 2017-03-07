package com.jun.dpms.sys;

import static org.junit.Assert.*;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.realEstate.bean.DpmsRealEstate;
import com.jun.dpms.realEstate.service.IDpmsRealEstateService;

public class TestRealEstate {

	@Test
	public void test() {
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf=(SessionFactory)context.getBean("sessionFactory");
		Session session=sf.openSession();
		Transaction tx = session.beginTransaction();
		IDpmsRealEstateService dpmsRealEstateService=(IDpmsRealEstateService)context.getBean("dpmsRealEstateService");
		List<DpmsRealEstate> dpmsRealEstates = dpmsRealEstateService.findAll(4, 2);
		for (DpmsRealEstate dpmsRealEstate : dpmsRealEstates) {
			System.out.println(dpmsRealEstate.getId()+"|"+dpmsRealEstate.getEstateNo());;
		}
	}

}
