package com.jun.dpms.sys;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		 * 查找所有用户并分页显示
		 */
//		List<DpmsSysUser> dpmsSysUsers = dpmsSysUserService.findAll(3,1);
//		for (DpmsSysUser dpmsSysUser : dpmsSysUsers) {
//			System.out.println(dpmsSysUser.getUserName()+"|"+dpmsSysUser.getPassWord());
//		}
		/**
		 * 通过用户名查找用户
		 */
//		DpmsSysUser dpmsSysUser=dpmsSysUserService.searchByUserName("root");
//		System.out.println(dpmsSysUser.getUserName());
		
		/**
		 * 更新用户
		 */
		/*Date currentTime=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd");
		DpmsSysUser dpmsSysUser = (DpmsSysUser)dpmsSysUserService.searchByUserName("test1");
		dpmsSysUser.setAddress("绵阳");
		dpmsSysUser.setEmail("1883294@qq.com");
		dpmsSysUser.setAge(23);
		try {
			dpmsSysUser.setBirthDay(sdf.parse(sdf.format(currentTime)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dpmsSysUser.setCardId("1234567");
		dpmsSysUser.setPhone("11111111111");
		dpmsSysUser.setGender(0);
		dpmsSysUserDao.addSysUser(dpmsSysUser);*/
		
		/**
		 * 添加用户
		 */
		/*Date currentTime=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DpmsSysUser dpmsSysUser = new DpmsSysUser();
		dpmsSysUser.setUserName("benda");
		dpmsSysUser.setAddress("绵阳");
		dpmsSysUser.setEmail("1883294@qq.com");
		dpmsSysUser.setAge(23);
		dpmsSysUser.setBirthDay((sdf.format(currentTime)));
			// TODO Auto-generated catch block
		dpmsSysUser.setCardId("1234567");
		dpmsSysUser.setPhone("11111111111");
		dpmsSysUser.setGender("男");
		dpmsSysUserDao.addSysUser(dpmsSysUser);*/
		
		/**
		 * 删除用户
		 */
		String[] userNames={"root","bendan"};
		dpmsSysUserService.delSysUser(userNames);
		
		
	}

}
