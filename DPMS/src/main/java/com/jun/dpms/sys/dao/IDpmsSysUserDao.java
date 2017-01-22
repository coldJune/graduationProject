package com.jun.dpms.sys.dao;

public interface IDpmsSysUserDao {
	/*
	 * 登录检测用户是否合法
	 */
	public boolean checkUser(Object obj);
	/*
	 * 检查用户名是否存在
	 */
	public boolean checkUserName(Object obj);
	
}
