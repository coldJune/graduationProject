package com.jun.dpms.propertyCharge.service;

import java.util.List;

import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;

public interface IDpmsPropertyChargeService {
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
}
