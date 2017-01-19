package com.jun.dpms.sys.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jun.dpms.sys.dao.IDpmsSysUserDao;

import com.jun.dpms.sys.bean.*;
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
		q.setString(1, dsu.getPassword());
		List<DpmsSysUser> result=q.list();
		if(result==null){
			return false;
		}else{
			return true;
		}
	}

}
