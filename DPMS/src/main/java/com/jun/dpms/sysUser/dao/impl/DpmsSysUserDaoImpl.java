package com.jun.dpms.sysUser.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jun.dpms.sysUser.bean.*;
import com.jun.dpms.sysUser.dao.IDpmsSysUserDao;
public class DpmsSysUserDaoImpl implements IDpmsSysUserDao {
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return sessionFactory.openSession();
	}
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkUser(Object obj) {
		// TODO Auto-generated method stub
		DpmsSysUser dsu = (DpmsSysUser)obj;
		Query q = this.getCurrentSession().createQuery("from DpmsSysUser d where d.userName=? and d.password=?");
		q.setString(0, dsu.getUserName());
		q.setString(1, dsu.getPassWord());
		if(q.list()==null ||q.list().isEmpty()){
			return false;
		}else{
			return true;
		}
	}


	@Override
	public boolean checkUserName(Object obj) {
		// TODO Auto-generated method stub
		
		DpmsSysUser user=(DpmsSysUser)obj;
		Query q = getCurrentSession().createQuery("from DpmsSysUser d where d.userName=?");
		q.setString(0, user.getUserName());
		if(q.list()!=null&&!q.list().isEmpty()){
			return true;
		}else{
			return false;
		}
	}



}
