package com.jun.dpms.park.service.impl;

import java.util.List;

import com.jun.dpms.park.bean.DpmsPark;
import com.jun.dpms.park.dao.IDpmsParkDao;
import com.jun.dpms.park.service.IDpmsParkService;

public class DpmsParkServiceImpl implements IDpmsParkService {
	private IDpmsParkDao dpmsParkDao;

	public IDpmsParkDao getDpmsParkDao() {
		return dpmsParkDao;
	}

	public void setDpmsParkDao(IDpmsParkDao dpmsParkDao) {
		this.dpmsParkDao = dpmsParkDao;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return dpmsParkDao.getTotalItem();
	}

	@Override
	public int getHisTotalItem() {
		// TODO Auto-generated method stub
		return dpmsParkDao.getHisTotalItem();
	}

	@Override
	public List<DpmsPark> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		return dpmsParkDao.findAll(eachPage, currentPage);
	}

	@Override
	public List<DpmsPark> findHisAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		return dpmsParkDao.findHisAll(eachPage, currentPage);
	}

	@Override
	public DpmsPark searchByPlateNumber(String plateNumber) {
		// TODO Auto-generated method stub
		return dpmsParkDao.searchByPlateNumber(plateNumber);
	}

	@Override
	public boolean updateLeave(String plateNumber) {
		// TODO Auto-generated method stub
		return dpmsParkDao.updateLeave(plateNumber);
	}

	@Override
	public boolean updateCharge(DpmsPark dpmsPark) {
		// TODO Auto-generated method stub
		return dpmsParkDao.updateCharge(dpmsPark);
	}

	@Override
	public void addPark(DpmsPark dpmsPark) {
		// TODO Auto-generated method stub
		dpmsParkDao.addPark(dpmsPark);
	}
}
