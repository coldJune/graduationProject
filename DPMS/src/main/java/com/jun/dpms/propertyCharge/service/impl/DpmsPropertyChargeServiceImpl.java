package com.jun.dpms.propertyCharge.service.impl;

import java.text.ParseException;
import java.util.List;

import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;
import com.jun.dpms.propertyCharge.bean.DpmsPropertyChargeHis;
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

	@Override
	public void addPropertyName(DpmsPropertyCharge dpmsPropertyCharge) {
		// TODO Auto-generated method stub
		dpmsPropertyChargeDao.addPropertyName(dpmsPropertyCharge);
	}

	@Override
	public void updatePropertyCharge(DpmsPropertyCharge dpmsPropertyCharge) {
		// TODO Auto-generated method stub
		dpmsPropertyChargeDao.updatePropertyCharge(dpmsPropertyCharge);
	}

	@Override
	public void delPropertyCharge(int[] ids) {
		// TODO Auto-generated method stub
		dpmsPropertyChargeDao.delPropertyCharge(ids);
	}

	@Override
	public List<DpmsPropertyChargeHis> searchByPropertyCharge(DpmsPropertyCharge dpmsPropertyCharge)
			throws ParseException {
		// TODO Auto-generated method stub
		return dpmsPropertyChargeDao.searchByPropertyCharge(dpmsPropertyCharge);
	}

}
