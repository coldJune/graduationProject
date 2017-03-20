package com.jun.dpms.sys;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.complain.bean.DpmsComplain;
import com.jun.dpms.complain.service.IDpmsComplainService;
import com.jun.dpms.household.bean.DpmsHousehold;

public class TestComplain {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		IDpmsComplainService dpmsComplainService=(IDpmsComplainService)context.getBean("dpmsComplainService");
		//测试添加
		/*DpmsComplain dpmsComplain = new DpmsComplain();
		dpmsComplain.setDetails("这是详情");
		DpmsHousehold dpmsHousehold = new DpmsHousehold();
		dpmsHousehold.setId(8);
		dpmsComplain.setDpmsHousehold(dpmsHousehold);
		dpmsComplainService.addComplain(dpmsComplain);*/
		//测试查询
		List<DpmsComplain> dpmsComplains = dpmsComplainService.findAll(3, 1);
		/*Object[] object = (Object[]) dpmsComplains.get(0);
		System.out.println(((DpmsHousehold)object[0]).getHoldName());
		System.out.println(dpmsComplains);
		for(int i=0;i<dpmsComplains.size();i++){
			System.out.println(((DpmsComplain)dpmsComplains.get(i)).getDetails());
		}*/
		for (DpmsComplain dpmsComplain : dpmsComplains) {
			System.out.println(dpmsComplain.getDpmsHousehold().getHoldName());
		}
	}

}
