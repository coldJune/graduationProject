package com.jun.dpms.sysUser.service.impl;

import com.jun.dpms.sysUser.dao.IDpmsSysUserDao;
import com.jun.dpms.sysUser.service.IDpmsSysUserService;

public class DpmsSysUserServiceImpl implements IDpmsSysUserService {
	
	private IDpmsSysUserDao dpmsSysUserDao;
	@Override
	public boolean checkUser(Object obj) {
		// TODO Auto-generated method stub
		return dpmsSysUserDao.checkUser(obj);
	}

	@Override
	public boolean checkUserName(Object obj) {
		// TODO Auto-generated method stub
		return dpmsSysUserDao.checkUserName(obj);
	}

	public IDpmsSysUserDao getDpmsSysUserDao() {
		return dpmsSysUserDao;
	}

	public void setDpmsSysUserDao(IDpmsSysUserDao dpmsSysUserDao) {
		this.dpmsSysUserDao = dpmsSysUserDao;
	}

		
}
