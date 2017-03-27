package com.jun.dpms.park.dao;

import java.util.List;

import com.jun.dpms.park.bean.DpmsPark;

public interface IDpmsParkDao {
	/**
	 * ��ȡͣ�����ܹ�ͣ��
	 * @return
	 */
	public int getTotalItem();
	/**
	 * ��ȡ��ʷ��¼��
	 * @return
	 */
	public int getHisTotalItem();
	/**
	 * ��ȡͣ����ͣ����Ϣ
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsPark> findAll(int eachPage,int currentPage);
	/**
	 * ��ȡͣ������ʷ��Ϣ
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsPark> findHisAll(int eachPage,int currentPage);
	/**
	 * ͨ�����ƺŽ��в���
	 * @param plateNumber
	 * @return
	 */
	public DpmsPark searchByPlateNumber(String plateNumber);
}
