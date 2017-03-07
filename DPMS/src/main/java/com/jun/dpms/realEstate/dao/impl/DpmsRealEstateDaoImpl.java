package com.jun.dpms.realEstate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jun.dpms.realEstate.bean.DpmsRealEstate;
import com.jun.dpms.realEstate.dao.IDpmsRealEstateDao;

public class DpmsRealEstateDaoImpl implements IDpmsRealEstateDao {
	private SessionFactory sessionFactory;

	private Session getCurrentSession(){
		return sessionFactory.openSession();
	}
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<DpmsRealEstate> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DpmsRealEstate searchByEstateNo(int estateNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRealEstat(DpmsRealEstate dpmsRealEstate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRealEstat(DpmsRealEstate dpmsRealEstate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delRealEstate(int[] estateNos) {
		// TODO Auto-generated method stub

	}

}
