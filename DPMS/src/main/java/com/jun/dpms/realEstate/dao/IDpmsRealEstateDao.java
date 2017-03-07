package com.jun.dpms.realEstate.dao;

import java.util.List;

import com.jun.dpms.realEstate.bean.DpmsRealEstate;

public interface IDpmsRealEstateDao {
	/**
	 * 分页查询
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsRealEstate> findAll(int eachPage,int currentPage);
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
	public DpmsRealEstate searchByEstateNo(int estateNo);
	
	/**
	 * 更新楼盘信息
	 * @param DpmsRealEstate
	 */
	public void updateRealEstat(DpmsRealEstate dpmsRealEstate);
	
	/**
	 * 添加楼盘信息
	 * @param DpmsRealEstate
	 */
	public void addRealEstat(DpmsRealEstate dpmsRealEstate);
	/**
	 * 通过楼栋号逻辑删除楼
	 * @param userName
	 */
	public void delRealEstate(int[] estateNos);
}
