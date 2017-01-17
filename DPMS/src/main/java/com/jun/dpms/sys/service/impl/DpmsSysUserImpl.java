package com.jun.dpms.sys.service.impl;

import com.jun.dpms.sys.dao.IDpmsSysUserDao;
import com.jun.dpms.sys.service.IDpmsSysUserService;

public class DpmsSysUserImpl implements IDpmsSysUserService {
	
	private IDpmsSysUserDao dpmsSysUserDao;
	@Override
	public boolean checkUser(Object obj) {
		// TODO Auto-generated method stub
		return dpmsSysUserDao.checkUser(obj);
	}

	/**
	 * @param dpmsSysUserDao the dpmsSysUserDao to set
	 */
	public void setDpmsSysUserDao(IDpmsSysUserDao dpmsSysUserDao) {
		this.dpmsSysUserDao = dpmsSysUserDao;
	}

}
