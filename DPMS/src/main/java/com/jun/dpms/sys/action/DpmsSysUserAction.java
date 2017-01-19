package com.jun.dpms.sys.action;

import com.jun.dpms.sys.service.IDpmsSysUserService;

public class DpmsSysUserAction {
	private IDpmsSysUserService dpmsSysUserService;

	public IDpmsSysUserService getDpmsSysUserService() {
		return dpmsSysUserService;
	}

	public void setDpmsSysUserService(IDpmsSysUserService dpmsSysUserService) {
		this.dpmsSysUserService = dpmsSysUserService;
	}
	
}
