package com.jun.dpms.realEstate.dao;

import java.util.List;

import com.jun.dpms.realEstate.bean.DpmsRealEstate;

public interface IDpmsRealEstateDao {
	/**
	 * ��ҳ��ѯ
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsRealEstate> findAll(int eachPage,int currentPage);
	/**
	 * ������
	 * @return
	 */
	public int getTotalItem();
	/**
	 * ͨ��¥���Ų�ѯ
	 * @param userName
	 * @return
	 */
	public DpmsRealEstate searchByEstateNo(int estateNo);
	
	/**
	 * ����¥����Ϣ
	 * @param DpmsRealEstate
	 */
	public void updateRealEstat(DpmsRealEstate dpmsRealEstate);
	
	/**
	 * ���¥����Ϣ
	 * @param DpmsRealEstate
	 */
	public void addRealEstat(DpmsRealEstate dpmsRealEstate);
	/**
	 * ͨ��¥�����߼�ɾ��¥
	 * @param userName
	 */
	public void delRealEstate(int[] estateNos);
}
