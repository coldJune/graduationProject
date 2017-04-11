package com.jun.dpms.propertyCharge.service;

import java.text.ParseException;
import java.util.List;

import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;
import com.jun.dpms.propertyCharge.bean.DpmsPropertyChargeHis;

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
	
	/**
	 * 添加项目
	 * @param dpmsPropertyCharge
	 */
	
	public void addPropertyName(DpmsPropertyCharge dpmsPropertyCharge);
	/**
	 * 修改物业收费项目
	 * @param dpmsPropertyCharge
	 */
	public void updatePropertyCharge(DpmsPropertyCharge dpmsPropertyCharge);
	/**
	 * 删除项目
	 * @param ids
	 */
	public void delPropertyCharge(int[] ids);
	
	/**
	 * 查询收费名单
	 * @param dpmsPropertyCharge
	 * @return
	 * @throws ParseException
	 */
	public List<DpmsPropertyChargeHis> searchByPropertyCharge(DpmsPropertyCharge dpmsPropertyCharge) throws ParseException;
	/**
	 * 查询收费详情
	 * @param dpmsPropertyChargeHis
	 * @return
	 */
	public DpmsPropertyChargeHis searchChargeDetail(DpmsPropertyChargeHis dpmsPropertyChargeHis);
	
	/**
	 * 添加收费信息
	 * @param dpmsPropertyChargeHis
	 */
	public void addChargeHis(DpmsPropertyChargeHis dpmsPropertyChargeHis);
}
