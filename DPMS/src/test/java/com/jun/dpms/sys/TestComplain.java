package com.jun.dpms.sys;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		//≤‚ ‘ÃÌº”
		DpmsComplain dpmsComplain = new DpmsComplain();
		dpmsComplain.setDetails("’‚ «œÍ«ÈÕÙÀº—¥∞°∞°∞°∞°∞°∞°∞°∞°∞°∞°∞°∞°∞°∞° ∞°∞°∞°∞°∞° ∞°∞°∞°∞°∞° ∞°∞°∞°");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=df.format(new Date());
		dpmsComplain.setComplainDate(date);
		DpmsHousehold dpmsHousehold = new DpmsHousehold();
		dpmsHousehold.setId(9);
		dpmsComplain.setDpmsHousehold(dpmsHousehold);
		dpmsComplainService.addComplain(dpmsComplain);
		/*//≤‚ ‘≤È—Ø
		List<DpmsComplain> dpmsComplains = dpmsComplainService.findAll(3, 1);
		Object[] object = (Object[]) dpmsComplains.get(0);
		System.out.println(((DpmsHousehold)object[0]).getHoldName());
		System.out.println(dpmsComplains);
		for(int i=0;i<dpmsComplains.size();i++){
			System.out.println(((DpmsComplain)dpmsComplains.get(i)).getDetails());
		}
		for (DpmsComplain dpmsComplain : dpmsComplains) {
			System.out.println(dpmsComplain.getDpmsHousehold().getHoldName());
		}*/
	}

}
