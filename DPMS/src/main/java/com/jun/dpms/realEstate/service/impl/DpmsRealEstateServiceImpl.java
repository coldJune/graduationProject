package com.jun.dpms.realEstate.service.impl;

import java.util.List;

import com.jun.dpms.realEstate.bean.DpmsRealEstate;
import com.jun.dpms.realEstate.dao.IDpmsRealEstateDao;
import com.jun.dpms.realEstate.service.IDpmsRealEstate;

public class DpmsRealEstateServiceImpl implements IDpmsRealEstate {
	
	private IDpmsRealEstateDao dpmsRealEstateDao;

	public IDpmsRealEstateDao getDpmsRealEstateDao() {
		return dpmsRealEstateDao;
	}

	public void setDpmsRealEstateDao(IDpmsRealEstateDao dpmsRealEstateDao) {
		this.dpmsRealEstateDao = dpmsRealEstateDao;
	}

	@Override
	public List<DpmsRealEstate> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		return dpmsRealEstateDao.findAll(eachPage, currentPage);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return dpmsRealEstateDao.getTotalItem();
	}

	@Override
	public DpmsRealEstate searchByEstateNo(int estateNo) {
		// TODO Auto-generated method stub
		return dpmsRealEstateDao.searchByEstateNo(estateNo);
	}

	@Override
	public void updateRealEstat(DpmsRealEstate dpmsRealEstate) {
		// TODO Auto-generated method stub
		dpmsRealEstateDao.updateRealEstat(dpmsRealEstate);
	}

	@Override
	public void addRealEstat(DpmsRealEstate dpmsRealEstate) {
		// TODO Auto-generated method stub
		dpmsRealEstateDao.addRealEstat(dpmsRealEstate);
	}

	@Override
	public void delRealEstate(int[] estateNos) {
		// TODO Auto-generated method stub
		dpmsRealEstateDao.delRealEstate(estateNos);
	}

}
