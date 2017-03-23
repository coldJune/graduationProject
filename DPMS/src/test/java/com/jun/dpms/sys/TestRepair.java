package com.jun.dpms.sys;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.complain.service.IDpmsComplainService;
import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.repair.bean.DpmsRepair;
import com.jun.dpms.repair.service.IDpmsRepairService;

public class TestRepair {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		IDpmsRepairService dpmsComplainService=(IDpmsRepairService)context.getBean("dpmsRepairService");
		DpmsRepair dpmsRepair = new DpmsRepair();
		DpmsHousehold dpmsHousehold=new DpmsHousehold();
		dpmsHousehold.setId(7);
		dpmsRepair.setDetails("Íô±¿µ°");
		dpmsRepair.setDpmsHousehold(dpmsHousehold);
		dpmsComplainService.addRepair(dpmsRepair);
	}

}
