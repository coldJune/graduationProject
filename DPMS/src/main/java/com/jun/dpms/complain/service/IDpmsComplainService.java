package com.jun.dpms.complain.service;

import java.util.List;

import com.jun.dpms.complain.bean.DpmsComplain;

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
	public DpmsComplain searchByHoldName(String holdName);
	
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
}
