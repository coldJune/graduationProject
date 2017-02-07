package com.jun.dpms.sysUser.dao;

import java.util.List;

import com.jun.dpms.sysUser.bean.DpmsSysUser;

public interface IDpmsSysUserDao {
	/**
	 * 分页查询
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsSysUser> findAll(int eachPage,int currentPage);
	/**
	 * 总条数
	 * @return
	 */
	public int getTotalItem();
	/**
	 * 通过用户名查询
	 * @param userName
	 * @return
	 */
	public DpmsSysUser searchByUserName(String userName);
}
