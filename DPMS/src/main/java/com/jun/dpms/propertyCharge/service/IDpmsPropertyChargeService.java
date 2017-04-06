package com.jun.dpms.propertyCharge.service;

import java.util.List;

import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;

public interface IDpmsPropertyChargeService {
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
	/**
	 * 根据项目名查找项目
	 * @param PropertyName
	 * @return
	 */
	public DpmsPropertyCharge searchByPropertyName(String propertyName);
}
