package com.jun.dpms.household.service.impl;

import java.util.List;


import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.household.dao.IDpmsHouseholdDao;
import com.jun.dpms.household.service.IDpmsHouseholdService;

public class DpmsHouseholdServiceImpl implements IDpmsHouseholdService {
	private IDpmsHouseholdDao dpmsHouseholdDao;

	
	public IDpmsHouseholdDao getDpmsHouseholdDao() {
		return dpmsHouseholdDao;
	}

	public void setDpmsHouseholdDao(IDpmsHouseholdDao dpmsHouseholdDao) {
		this.dpmsHouseholdDao = dpmsHouseholdDao;
	}

	@Override
	public List<DpmsHousehold> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		return dpmsHouseholdDao.findAll(eachPage, currentPage);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return dpmsHouseholdDao.getTotalItem();
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
