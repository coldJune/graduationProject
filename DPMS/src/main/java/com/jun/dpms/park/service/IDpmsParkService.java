package com.jun.dpms.park.service;

import java.util.List;

import com.jun.dpms.park.bean.DpmsPark;

public interface IDpmsParkService {
	/**
	 * 获取停车场总共停车
	 * @return
	 */
	public int getTotalItem();
	/**
	 * 获取历史记录数
	 * @return
	 */
	public int getHisTotalItem();
	/**
	 * 获取停车场停车信息
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsPark> findAll(int eachPage,int currentPage);
	/**
	 * 获取停车场历史信息
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsPark> findHisAll(int eachPage,int currentPage);
	
	/**
	 * 通过车牌号进行查找
	 * @param plateNumber
	 * @return
	 */
	public DpmsPark searchByPlateNumber(String plateNumber);
	
	/**
	 * 离场
	 * @param plateNumber
	 */
	public boolean updateLeave(String plateNumber);
	/**
	 * 收费
	 * @param dpmsPark
	 * @return
	 */
	public boolean updateCharge(DpmsPark dpmsPark);
}
