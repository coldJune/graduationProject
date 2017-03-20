package com.jun.dpms.complain.dao;

import java.util.List;

import com.jun.dpms.complain.bean.DpmsComplain;


public interface IDpmsComplainDao {
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
	 * ͨ��¥���Ų�ѯ
	 * @param userName
	 * @return
	 */
	public DpmsComplain searchByHoldName(String holdName);
	
	/**
	 * ����¥����Ϣ
	 * @param DpmsComplain
	 */
	public void updateComplain(DpmsComplain dpmsComplain);
	
	/**
	 * ���¥����Ϣ
	 * @param DpmsComplain
	 */
	public void addComplain(DpmsComplain dpmsComplain);
	/**
	 * ͨ��¥�����߼�ɾ��¥
	 * @param userName
	 */
	public void delComplaine(int[] ids);
}
