package com.jun.dpms.park.dao;

import java.util.List;

import com.jun.dpms.park.bean.DpmsPark;

public interface IDpmsParkDao {
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
	public List<DpmsPark> searchByPlateNumber(String plateNumber);
	/**
	 * 离场
	 * @param plateNumber
	 */
	public boolean updateLeave(int id);
	/**
	 * 收费
	 * @param dpmsPark
	 * @return
	 */
	public boolean updateCharge(DpmsPark dpmsPark);
	/**
	 * 入库
	 * @param dpmsPark
	 */
	public void addPark(DpmsPark dpmsPark);
	/**
	 * 删除停车场信息
	 * @param ids
	 */
	public void delPark(int[] ids);
	public DpmsPark searchById(int id);
}
