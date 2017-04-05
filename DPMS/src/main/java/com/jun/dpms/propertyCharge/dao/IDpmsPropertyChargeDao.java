package com.jun.dpms.propertyCharge.dao;

import java.util.List;

import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;

public interface IDpmsPropertyChargeDao {
	/**
	 * 分页查询
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsPropertyCharge> findAll(int eachPage,int currentPage);
	/**
	 * 总条数
	 * @return
	 */
	public int getTotalItem();
}
