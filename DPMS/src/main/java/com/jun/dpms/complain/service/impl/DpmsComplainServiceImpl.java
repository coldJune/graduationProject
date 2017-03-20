package com.jun.dpms.complain.service.impl;

import java.util.List;

import com.jun.dpms.complain.bean.DpmsComplain;
import com.jun.dpms.complain.dao.IDpmsComplainDao;
import com.jun.dpms.complain.dao.impl.DpmsComplainDaoImpl;
import com.jun.dpms.complain.service.IDpmsComplainService;

public class DpmsComplainServiceImpl implements IDpmsComplainService {
	private IDpmsComplainDao dpmsComplainDao;
	
	@Override
	public List<DpmsComplain> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		return dpmsComplainDao.findAll(eachPage, currentPage);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return dpmsComplainDao.getTotalItem();
	}

	@Override
	public DpmsComplain searchByHoldName(String HoldName) {
		// TODO Auto-generated method stub
		return dpmsComplainDao.searchByHoldName(HoldName);
	}

	@Override
	public void updateComplain(DpmsComplain dpmsComplain) {
		// TODO Auto-generated method stub
		dpmsComplainDao.updateComplain(dpmsComplain);
	}

	@Override
	public void addComplain(DpmsComplain dpmsComplain) {
		// TODO Auto-generated method stub
		dpmsComplainDao.addComplain(dpmsComplain);
	}

	@Override
	public void delComplaine(int[] ids) {
		// TODO Auto-generated method stub
		dpmsComplainDao.delComplaine(ids);
	}

	public IDpmsComplainDao getDpmsComplainDao() {
		return dpmsComplainDao;
	}

	public void setDpmsComplainDao(IDpmsComplainDao dpmsComplainDao) {
		this.dpmsComplainDao = dpmsComplainDao;
	}

}
