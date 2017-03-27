package com.jun.dpms.sys;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.complain.service.IDpmsComplainService;
import com.jun.dpms.park.bean.DpmsPark;
import com.jun.dpms.park.service.IDpmsParkService;

public class TestPark {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		IDpmsParkService dpmsParkService=(IDpmsParkService)context.getBean("dpmsParkService");
		List<DpmsPark> dpmsParks=dpmsParkService.findAll(5, 2);
		for (DpmsPark dpmsPark : dpmsParks) {
			System.out.println(dpmsPark.getId()+"|"+dpmsPark.getPlateNumber()+"|"+dpmsPark.getIsCharge());
		}
		System.out.println("--------------");
		List<DpmsPark> hisDpmsParks=dpmsParkService.findHisAll(5, 2);
		for (DpmsPark dpmsPark : hisDpmsParks) {
			System.out.println(dpmsPark.getId()+"|"+dpmsPark.getPlateNumber()+"|"+dpmsPark.getIsCharge());
		}
		System.out.println("--------------");
		
	}

}
