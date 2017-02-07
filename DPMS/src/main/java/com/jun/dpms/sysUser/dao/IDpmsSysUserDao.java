package com.jun.dpms.sysUser.dao;

import java.util.List;

import com.jun.dpms.sysUser.bean.DpmsSysUser;

public interface IDpmsSysUserDao {
	/**
	 * ��ҳ��ѯ
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsSysUser> findAll(int eachPage,int currentPage);
	/**
	 * ������
	 * @return
	 */
	public int getTotalItem();
	/**
	 * ͨ���û�����ѯ
	 * @param userName
	 * @return
	 */
	public DpmsSysUser searchByUserName(String userName);
}
