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
	public List<DpmsHousehold> searchByHoldName(String holdName) {
		// TODO Auto-generated method stub
		return dpmsHouseholdDao.searchByHoldName(holdName);
	}

	@Override
	public void updateRealEstat(DpmsHousehold dpmsHousehold) {
		// TODO Auto-generated method stub
		dpmsHouseholdDao.updateRealEstat(dpmsHousehold);
	}

	@Override
	public void addRealEstat(DpmsHousehold dpmsHousehold) {
		// TODO Auto-generated method stub
		dpmsHouseholdDao.addRealEstat(dpmsHousehold);
	}

	@Override
	public void delHousehold(int[] ids) {
		// TODO Auto-generated method stub
		dpmsHouseholdDao.delHousehold(ids);
	}

	@Override
	public DpmsHousehold searchById(int id) {
		// TODO Auto-generated method stub
		return dpmsHouseholdDao.searchById(id);
	}

	@Override
	public List searchRealEstate() {
		// TODO Auto-generated method stub
		return dpmsHouseholdDao.searchRealEstate();
	}

	@Override
	public List searchUnitAndFloor(int relateRealEstate) {
		// TODO Auto-generated method stub
		return dpmsHouseholdDao.searchUnitAndFloor(relateRealEstate);
	}

	@Override
	public boolean checkRelate(DpmsHousehold dpmsHousehold) {
		// TODO Auto-generated method stub
		return dpmsHouseholdDao.checkRelate(dpmsHousehold);
	}

}
