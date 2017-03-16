package com.jun.dpms.household.service;

import java.util.List;

import com.jun.dpms.household.bean.DpmsHousehold;

public interface IDpmsHouseholdService {
	/**
	 * ��ҳ��ѯ
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsHousehold> findAll(int eachPage,int currentPage);
	/**
	 * ������
	 * @return
	 */
	public int getTotalItem();
	/**
	 * ͨ���������ֲ�ѯ
	 * @param userName
	 * @return
	 */
	public List<DpmsHousehold> searchByHoldName(String holdName);
	
	/**
	 * ����ס����Ϣ
	 * @param DpmsHousehold
	 */
	public void updateRealEstat(DpmsHousehold dpmsHousehold);
	
	/**
	 * ���ס����Ϣ
	 * @param DpmsHousehold
	 */
	public void addRealEstat(DpmsHousehold dpmsHousehold);
	/**
	 * ͨ��id���߼�ɾ��¥
	 * @param userName
	 */
	public void delHousehold(int[] ids);
	/**
	 * ͨ��id����ס��
	 * @param id
	 * @return
	 */
	public DpmsHousehold searchById(int id);

}
