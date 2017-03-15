package com.jun.dpms.household.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.household.dao.IDpmsHouseholdDao;

public class DpmsHouseholdDaoImpl implements IDpmsHouseholdDao {
	
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.openSession();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<DpmsHousehold> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		Query q =this.getCurrentSession().createQuery("from DpmsHousehold h");
		q.setMaxResults(eachPage);
		q.setFirstResult((currentPage-1)*eachPage);
		
		return q.list();
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		
		return ((Number)(this.getCurrentSession().createQuery("select count(*) from DpmsHousehold").uniqueResult())).intValue();
	}

	@Override
	public DpmsHousehold searchByHoldName(String holdName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRealEstat(DpmsHousehold dpmsHousehold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRealEstat(DpmsHousehold dpmsHousehold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delHousehold(int[] ids) {
		// TODO Auto-generated method stub
		
	}

}
