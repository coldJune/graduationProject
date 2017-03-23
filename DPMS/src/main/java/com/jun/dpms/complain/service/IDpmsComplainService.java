package com.jun.dpms.complain.service;

import java.util.List;
import java.util.Map;

import com.jun.dpms.complain.bean.DpmsComplain;
import com.jun.dpms.household.bean.DpmsHousehold;

public interface IDpmsComplainService {
	/**
	 * 分页查询
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsComplain> findAll(int eachPage,int currentPage);
	/**
	 * 总条数
	 * @return
	 */
	public int getTotalItem();
	/**
	 * 通过住户名查询
	 * @param userName
	 * @return
	 */
	public List<DpmsComplain> searchByHoldName(String holdName);
	
	/**
	 * 更新投诉信息
	 * @param DpmsComplain
	 */
	public void updateComplain(DpmsComplain dpmsComplain);
	
	/**
	 * 添加投诉信息
	 * @param DpmsComplain
	 */
	public void addComplain(DpmsComplain dpmsComplain);
	/**
	 * 通过id删除投诉信息
	 * @param userName
	 */
	public void delComplaine(int[] ids);
	
	/**
	 * 通过id查找
	 * @param id
	 * @return
	 */
	public DpmsComplain searchById(int id);
	
	/**
	 * 检查用户的合法性
	 * @param dpmsHousehold
	 * @return
	 */
	public Map<String,String> checkHousehold(DpmsHousehold dpmsHousehold);
}
