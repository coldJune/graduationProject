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
	
	/**
	 * 更新系统用户
	 * @param dpmsSysUser
	 */
	public void updateSysUser(DpmsSysUser dpmsSysUser);
	
	/**
	 * 添加系统用户
	 * @param dpmsSysUser
	 */
	public void addSysUser(DpmsSysUser dpmsSysUser);
	/**
	 * 通过用户名逻辑删除用户
	 * @param userName
	 */
	public void delSysUser(String[] userNames);
	/**
	 * 保存图片路径
	 * @param dpmsSysUser
	 */
	public void updateImg(DpmsSysUser dpmsSysUser);
}
