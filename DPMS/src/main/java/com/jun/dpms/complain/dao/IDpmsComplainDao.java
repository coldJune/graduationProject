package com.jun.dpms.complain.dao;

import java.util.List;

import com.jun.dpms.complain.bean.DpmsComplain;


public interface IDpmsComplainDao {
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
	 * 通过户主名查询
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
	 * 通过id删除楼
	 * @param userName
	 */
	public void delComplaine(int[] ids);
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	public DpmsComplain searchById(int id);
}
