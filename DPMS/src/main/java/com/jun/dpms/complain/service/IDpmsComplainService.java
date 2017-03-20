package com.jun.dpms.complain.service;

import java.util.List;

import com.jun.dpms.complain.bean.DpmsComplain;

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
	 * 通过楼栋号查询
	 * @param userName
	 * @return
	 */
	public DpmsComplain searchByHoldName(String holdName);
	
	/**
	 * 更新楼盘信息
	 * @param DpmsComplain
	 */
	public void updateComplain(DpmsComplain dpmsComplain);
	
	/**
	 * 添加楼盘信息
	 * @param DpmsComplain
	 */
	public void addComplain(DpmsComplain dpmsComplain);
	/**
	 * 通过楼栋号逻辑删除楼
	 * @param userName
	 */
	public void delComplaine(int[] ids);
}
