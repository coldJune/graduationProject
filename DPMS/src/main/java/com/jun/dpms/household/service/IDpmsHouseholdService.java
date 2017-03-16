package com.jun.dpms.household.service;

import java.util.List;

import com.jun.dpms.household.bean.DpmsHousehold;

public interface IDpmsHouseholdService {
	/**
	 * 分页查询
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsHousehold> findAll(int eachPage,int currentPage);
	/**
	 * 总条数
	 * @return
	 */
	public int getTotalItem();
	/**
	 * 通过户主名字查询
	 * @param userName
	 * @return
	 */
	public List<DpmsHousehold> searchByHoldName(String holdName);
	
	/**
	 * 更新住户信息
	 * @param DpmsHousehold
	 */
	public void updateRealEstat(DpmsHousehold dpmsHousehold);
	
	/**
	 * 添加住户信息
	 * @param DpmsHousehold
	 */
	public void addRealEstat(DpmsHousehold dpmsHousehold);
	/**
	 * 通过id号逻辑删除楼
	 * @param userName
	 */
	public void delHousehold(int[] ids);
	/**
	 * 通过id查找住户
	 * @param id
	 * @return
	 */
	public DpmsHousehold searchById(int id);

}
