package com.jun.dpms.complain.bean;

import com.jun.dpms.household.bean.DpmsHousehold;

public class DpmsComplain {
	private int id;
	private DpmsHousehold dpmsHousehold;
	private String details;//ฯ๊ว้
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
	
}
