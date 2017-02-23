package com.jun.dpms.sysUser.service.impl;

import java.util.List;

import com.jun.dpms.sysUser.bean.DpmsSysUser;
import com.jun.dpms.sysUser.dao.IDpmsSysUserDao;
import com.jun.dpms.sysUser.service.IDpmsSysUserService;

public class DpmsSysUserServiceImpl implements IDpmsSysUserService {
	
	private IDpmsSysUserDao dpmsSysUserDao;

	public IDpmsSysUserDao getDpmsSysUserDao() {
		return dpmsSysUserDao;
	}

	public void setDpmsSysUserDao(IDpmsSysUserDao dpmsSysUserDao) {
		this.dpmsSysUserDao = dpmsSysUserDao;
	}

	@Override
	public List<DpmsSysUser> findAll(int eachPage, int currentPage) {
		// TODO Auto-generated method stub
		return dpmsSysUserDao.findAll(eachPage, currentPage);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return dpmsSysUserDao.getTotalItem();
	}

	@Override
	public DpmsSysUser searchByUserName(String userName) {
		// TODO Auto-generated method stub
		return dpmsSysUserDao.searchByUserName(userName);
		
	}

	@Override
	public void updateSysUser(DpmsSysUser dpmsSysUser) {
		// TODO Auto-generated method stub
		dpmsSysUserDao.updateSysUser(dpmsSysUser);
	}

	@Override
	public void addSysUser(DpmsSysUser dpmsSysUser) {
		// TODO Auto-generated method stub
		dpmsSysUserDao.addSysUser(dpmsSysUser);
	}



		
}
