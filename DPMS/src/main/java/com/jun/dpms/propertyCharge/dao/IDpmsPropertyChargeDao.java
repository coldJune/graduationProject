package com.jun.dpms.propertyCharge.dao;

import java.util.List;

import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;

public interface IDpmsPropertyChargeDao {
	/**
	 * ��ҳ��ѯ
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsPropertyCharge> findAll(int eachPage,int currentPage);
	/**
	 * ������
	 * @return
	 */
	public int getTotalItem();
	
	/**
	 * ������Ŀ��������Ŀ
	 * @param PropertyName
	 * @return
	 */
	public DpmsPropertyCharge searchByPropertyName(String propertyName);
	
	/**
	 * �����Ŀ
	 * @param dpmsPropertyCharge
	 */
	
	public void addPropertyName(DpmsPropertyCharge dpmsPropertyCharge);
	
	/**
	 * �޸���ҵ�շ���Ŀ
	 * @param dpmsPropertyCharge
	 */
	public void updatePropertyCharge(DpmsPropertyCharge dpmsPropertyCharge);
	/**
	 * ɾ����Ŀ
	 * @param ids
	 */
	public void delPropertyCharge(int[] ids);
}
