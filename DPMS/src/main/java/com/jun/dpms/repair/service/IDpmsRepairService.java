package com.jun.dpms.repair.service;

import java.util.List;
import java.util.Map;

import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.repair.bean.DpmsRepair;

public interface IDpmsRepairService {
	/**
	 * 分页查询
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsRepair> findAll(int eachPage,int currentPage);
	/**
	 * 总条数
	 * @return
	 */
	public int getTotalItem();
	/**
	 * 通过户主名查询
	 * @param userName
	 * @return
	 */
	public List<DpmsRepair> searchByHoldName(String holdName);
	
	/**
	 * 更新报修信息
	 * @param DpmsRepair
	 */
	public void updateRepair(DpmsRepair dpmsRepair);
	
	/**
	 * 添加报修信息
	 * @param DpmsRepair
	 */
	public void addRepair(DpmsRepair dpmsRepair);
	/**
	 * 通过id删除
	 * @param ids
	 */
	public void delRepair(int[] ids);
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	public DpmsRepair searchById(int id);
	
	/**
	 * 检查用户的合法性
	 * @param dpmsHousehold
	 * @return
	 */
	public Map<String,String> checkHousehold(DpmsHousehold dpmsHousehold);
}
