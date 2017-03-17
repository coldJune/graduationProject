package com.jun.dpms.household.dao;

import java.util.List;
import java.util.Map;

import com.jun.dpms.household.bean.DpmsHousehold;

public interface IDpmsHouseholdDao {
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
	 * ͨ��Id����ס��
	 * @param id
	 * @return
	 */
	public DpmsHousehold searchById(int id);
	/**
	 * �������е�¥��
	 * @return
	 */
	public List searchRealEstate();
	/**
	 * ͨ��¥���Ų�ѯ��Ӧ�Ĳ����͵�Ԫ��
	 * @param relateRealEstate
	 * @return
	 */
	public List searchUnitAndFloor(int relateRealEstate);
	/**
	 * ��鷿��źϷ���
	 * @param dpmsHousehold
	 * @return
	 */
	public boolean checkRelate(DpmsHousehold dpmsHousehold);
}
