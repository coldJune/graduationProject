package com.jun.dpms.complain.service;

import java.util.List;
import java.util.Map;

import com.jun.dpms.complain.bean.DpmsComplain;
import com.jun.dpms.household.bean.DpmsHousehold;

public interface IDpmsComplainService {
	/**
	 * ��ҳ��ѯ
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsComplain> findAll(int eachPage,int currentPage);
	/**
	 * ������
	 * @return
	 */
	public int getTotalItem();
	/**
	 * ͨ��ס������ѯ
	 * @param userName
	 * @return
	 */
	public List<DpmsComplain> searchByHoldName(String holdName);
	
	/**
	 * ����Ͷ����Ϣ
	 * @param DpmsComplain
	 */
	public void updateComplain(DpmsComplain dpmsComplain);
	
	/**
	 * ���Ͷ����Ϣ
	 * @param DpmsComplain
	 */
	public void addComplain(DpmsComplain dpmsComplain);
	/**
	 * ͨ��idɾ��Ͷ����Ϣ
	 * @param userName
	 */
	public void delComplaine(int[] ids);
	
	/**
	 * ͨ��id����
	 * @param id
	 * @return
	 */
	public DpmsComplain searchById(int id);
	
	/**
	 * ����û��ĺϷ���
	 * @param dpmsHousehold
	 * @return
	 */
	public Map<String,String> checkHousehold(DpmsHousehold dpmsHousehold);
}
