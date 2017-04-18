package com.jun.dpms.propertyCharge.dao;

import java.text.ParseException;
import java.util.List;

import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;
import com.jun.dpms.propertyCharge.bean.DpmsPropertyChargeHis;

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
	 * ������Ŀ
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
	/**
	 * ��ѯ�շ�����
	 * @param dpmsPropertyCharge
	 * @return
	 * @throws ParseException
	 */
	public List<DpmsPropertyChargeHis> searchByPropertyCharge(DpmsPropertyCharge dpmsPropertyCharge) throws ParseException;
	/**
	 * ��ѯ�շ�����
	 * @param dpmsPropertyChargeHis
	 * @return
	 */
	public DpmsPropertyChargeHis searchChargeDetail(DpmsPropertyChargeHis dpmsPropertyChargeHis);
	/**
	 * �����շ���Ϣ
	 * @param dpmsPropertyChargeHis
	 */
	public void addChargeHis(DpmsPropertyChargeHis dpmsPropertyChargeHis);
	/**
	 * ��ҳ��ѯ�ɷ�
	 * @param eachPage
	 * @param currentPage
	 * @return
	 */
	public List<DpmsPropertyChargeHis> findAllHis(int eachPage,int currentPage);
	/*
	 * ��ѯ�ɷѼ�¼������
	 */
	public int getHisTotalItem();
	/**
	 * ͨ��ס��������
	 * @param holdName
	 * @return
	 */
	public List<DpmsPropertyChargeHis> searchByHoldName(String holdName);
	/**
	 * ͨ��id�����շ�����
	 * @param id
	 * @return
	 */
	public DpmsPropertyChargeHis searchHisById(int id);
}