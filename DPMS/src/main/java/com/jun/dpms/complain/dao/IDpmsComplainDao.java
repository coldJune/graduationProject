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
	 * ͨ����������ѯ
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
	 * ͨ��idɾ��¥
	 * @param userName
	 */
	public void delComplaine(int[] ids);
	/**
	 * ͨ��id��ѯ
	 * @param id
	 * @return
	 */
	public DpmsComplain searchById(int id);
}
