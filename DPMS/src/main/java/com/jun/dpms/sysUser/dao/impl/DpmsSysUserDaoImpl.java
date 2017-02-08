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
	public List<DpmsSysUser> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		Query q =this.getCurrentSession().createQuery("from DpmsSysUser");
		q.setMaxResults(eachPage);
		q.setFirstResult((currentPage-1)*eachPage);
		return q.list();
	}


	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return ((Number)this.getCurrentSession().createQuery("select count(*) from DpmsSysUser").uniqueResult()).intValue();
	}

	
	@Override
	public DpmsSysUser searchByUserName(String userName) {
		// TODO Auto-generated method stub
		Query q= this.getCurrentSession().createQuery("from DpmsSysUser u where u.userName=?");
		q.setString(0, userName);
		List<DpmsSysUser> results=q.list();
		if(results!=null||!results.isEmpty()){
			for (DpmsSysUser dpmsSysUser : results) {
				return dpmsSysUser;
			}
		}else{
			return null;
		}
		return null;
	}


	@Override
	public void updateSysUser(DpmsSysUser dpmsSysUser) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(dpmsSysUser);
	}








}
