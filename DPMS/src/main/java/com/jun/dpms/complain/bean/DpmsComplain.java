package com.jun.dpms.complain.bean;

import com.jun.dpms.household.bean.DpmsHousehold;

public class DpmsComplain {
	private int id;
	private DpmsHousehold dpmsHousehold;
	private String details;//����
	private String complainDate;//Ͷ��ʱ��
	private String isDeal;//�Ƿ���
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DpmsHousehold getDpmsHousehold() {
		return dpmsHousehold;
	}
	public void setDpmsHousehold(DpmsHousehold dpmsHousehold) {
		this.dpmsHousehold = dpmsHousehold;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getComplainDate() {
		return complainDate;
	}
	public void setComplainDate(String complainDate) {
		this.complainDate = complainDate;
	}
	public String getIsDeal() {
		return isDeal;
	}
	public void setIsDeal(String isDeal) {
		this.isDeal = isDeal;
	}
	
}
