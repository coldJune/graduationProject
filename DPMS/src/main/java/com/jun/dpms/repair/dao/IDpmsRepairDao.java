package com.jun.dpms.repair.dao;

import java.util.List;
import java.util.Map;

import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.repair.bean.DpmsRepair;

public interface IDpmsRepairDao {
	/**
	 * ��ҳ��ѯ
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsRepair> findAll(int eachPage,int currentPage);
	/**
	 * ������
	 * @return
	 */
	public int getTotalItem();
	/**
	 * ͨ����������ѯ
	 * @param userName
	 * @return
	 */
	public List<DpmsRepair> searchByHoldName(String holdName);
	
	/**
	 * ����Ͷ����Ϣ
	 * @param DpmsRepair
	 */
	public void updateRepair(DpmsRepair dpmsRepair);
	
	/**
	 * ���Ͷ����Ϣ
	 * @param DpmsRepair
	 */
	public void addRepair(DpmsRepair dpmsRepair);
	/**
	 * ͨ��idɾ��¥
	 * @param userName
	 */
	public void delRepair(int[] ids);
	/**
	 * ͨ��id��ѯ
	 * @param id
	 * @return
	 */
	public DpmsRepair searchById(int id);
	
	/**
	 * ����û��ĺϷ���
	 * @param dpmsHousehold
	 * @return
	 */
	public Map<String,String> checkHousehold(DpmsHousehold dpmsHousehold);
}
