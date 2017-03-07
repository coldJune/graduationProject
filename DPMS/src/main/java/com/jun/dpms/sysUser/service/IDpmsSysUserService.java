package com.jun.dpms.sysUser.service;

import java.util.List;

import com.jun.dpms.sysUser.bean.DpmsSysUser;

public interface IDpmsSysUserService {
	public List<DpmsSysUser> findAll(int eachPage,int currentPage);
	public int getTotalItem();
	public DpmsSysUser searchByUserName(String userName);
	public void updateSysUser(DpmsSysUser dpmsSysUser);
	public void addSysUser(DpmsSysUser dpmsSysUser);
	
	public void delSysUser(String[] userNames);
}
