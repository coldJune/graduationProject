package com.jun.dpms.park.bean;

import com.jun.dpms.household.bean.DpmsHousehold;

public class DpmsPark {
	private int id;
	private DpmsHousehold dpmsHousehold;
	private String plateNumber;//���ƺ�
	private String startTime;//ͣ��ʱ��
	private String endTime;//�뿪ʱ��
	private String price;//��ȡ����
	private String isCharge;//�Ƿ��շ�
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
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIsCharge() {
		return isCharge;
	}
	public void setIsCharge(String isCharge) {
		this.isCharge = isCharge;
	}
	
	
}
