package com.jun.dpms.util.pagecut.bean;

import java.io.Serializable;

public class Page implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8348045625034296354L;
	//����������
	private int totalItem;
	//ÿҳ��ʾ����
	private int eachPage;
	//��ҳ��
	private int totalPage;
	//��ǰҳ��
	private int currentPage;
	public Page(){
		super();
	}
	
	public Page(int totalItem,int eachPage,int totalPage,int currentPage){
		super();
		this.totalItem=totalItem;
		this.eachPage=eachPage;
		this.totalPage=totalPage;
		this.currentPage=currentPage;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public int getEachPage() {
		return eachPage;
	}

	public void setEachPage(int eachPage) {
		this.eachPage = eachPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
