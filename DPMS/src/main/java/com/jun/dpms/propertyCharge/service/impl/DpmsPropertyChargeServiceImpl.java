package com.jun.dpms.propertyCharge.service.impl;

import java.util.List;

import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;
import com.jun.dpms.propertyCharge.dao.IDpmsPropertyChargeDao;
import com.jun.dpms.propertyCharge.service.IDpmsPropertyChargeService;

public class DpmsPropertyChargeServiceImpl implements IDpmsPropertyChargeService {
	private IDpmsPropertyChargeDao dpmsPropertyChargeDao;
	
	public IDpmsPropertyChargeDao getDpmsPropertyChargeDao() {
		return dpmsPropertyChargeDao;
	}

	public void setDpmsPropertyChargeDao(IDpmsPropertyChargeDao dpmsPropertyChargeDao) {
		this.dpmsPropertyChargeDao = dpmsPropertyChargeDao;
	}

	@Override
	public List<DpmsPropertyCharge> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		return dpmsPropertyChargeDao.findAll(eachPage, currentPage);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return dpmsPropertyChargeDao.getTotalItem();
	}

	@Override
	public DpmsPropertyCharge searchByPropertyName(String propertyName) {
		// TODO Auto-generated method stub
		return dpmsPropertyChargeDao.searchByPropertyName(propertyName);
	}

}
