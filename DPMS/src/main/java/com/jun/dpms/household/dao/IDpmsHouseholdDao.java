package com.jun.dpms.household.dao;

import java.util.List;
import java.util.Map;

import com.jun.dpms.household.bean.DpmsHousehold;

public interface IDpmsHouseholdDao {
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
	 * 通过Id查找住户
	 * @param id
	 * @return
	 */
	public DpmsHousehold searchById(int id);
	/**
	 * 查找所有的楼栋
	 * @return
	 */
	public List searchRealEstate();
	/**
	 * 通过楼栋号查询对应的层数和单元数
	 * @param relateRealEstate
	 * @return
	 */
	public List searchUnitAndFloor(int relateRealEstate);
	/**
	 * 检查房间号合法性
	 * @param dpmsHousehold
	 * @return
	 */
	public boolean checkRelate(DpmsHousehold dpmsHousehold);
}
