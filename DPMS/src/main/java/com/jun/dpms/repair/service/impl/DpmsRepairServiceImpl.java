package com.jun.dpms.repair.service.impl;

import java.util.List;
import java.util.Map;

import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.repair.bean.DpmsRepair;
import com.jun.dpms.repair.dao.IDpmsRepairDao;
import com.jun.dpms.repair.service.IDpmsRepairService;

public class DpmsRepairServiceImpl implements IDpmsRepairService {
	private IDpmsRepairDao dpmsRepairDao;
	
	public IDpmsRepairDao getDpmsRepairDao() {
		return dpmsRepairDao;
	}

	public void setDpmsRepairDao(IDpmsRepairDao dpmsRepairDao) {
		this.dpmsRepairDao = dpmsRepairDao;
	}

	@Override
	public List<DpmsRepair> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DpmsRepair> searchByHoldName(String holdName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRepair(DpmsRepair dpmsRepair) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRepair(DpmsRepair dpmsRepair) {
		// TODO Auto-generated method stub
		dpmsRepairDao.addRepair(dpmsRepair);
	}

	@Override
	public void delRepair(int[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DpmsRepair searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> checkHousehold(DpmsHousehold dpmsHousehold) {
		// TODO Auto-generated method stub
		return null;
	}

}
