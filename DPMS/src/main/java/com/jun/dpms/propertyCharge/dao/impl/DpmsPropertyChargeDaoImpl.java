package com.jun.dpms.propertyCharge.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;
import com.jun.dpms.propertyCharge.dao.IDpmsPropertyChargeDao;

public class DpmsPropertyChargeDaoImpl implements IDpmsPropertyChargeDao{
	private SessionFactory sessinFactory;
	
	public void setSessinFactory(SessionFactory sessionFactory){
		this.sessinFactory=sessionFactory;
	}
	public Session getCurrentSession(){
		return this.sessinFactory.openSession();
	}
	@Override
	public List<DpmsPropertyCharge> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

}
