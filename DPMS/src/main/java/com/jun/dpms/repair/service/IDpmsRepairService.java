package com.jun.dpms.repair.service;

import java.util.List;
import java.util.Map;

import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.repair.bean.DpmsRepair;

public interface IDpmsRepairService {
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
	 * ���±�����Ϣ
	 * @param DpmsRepair
	 */
	public void updateRepair(DpmsRepair dpmsRepair);
	
	/**
	 * ���ӱ�����Ϣ
	 * @param DpmsRepair
	 */
	public void addRepair(DpmsRepair dpmsRepair);
	/**
	 * ͨ��idɾ��
	 * @param ids
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