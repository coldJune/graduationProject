package com.jun.dpms.propertyCharge.bean;

import com.jun.dpms.household.bean.DpmsHousehold;

public class DpmsPropertyChargeHis {
	private Integer id;
	private DpmsHousehold dpmsHousehold;
	private DpmsPropertyCharge dpmsPropertyCharge;
	private String chargeTime;
	private String opPerson;
	private String opPhone;
	private String price;
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public DpmsHousehold getDpmsHousehold() {
		return dpmsHousehold;
	}
	public void setDpmsHousehold(DpmsHousehold dpmsHousehold) {
		this.dpmsHousehold = dpmsHousehold;
	}
	public DpmsPropertyCharge getDpmsPropertyCharge() {
		return dpmsPropertyCharge;
	}
	public void setDpmsPropertyCharge(DpmsPropertyCharge dpmsPropertyCharge) {
		this.dpmsPropertyCharge = dpmsPropertyCharge;
	}
	public String getChargeTime() {
		return chargeTime;
	}
	public void setChargeTime(String chargeTime) {
		this.chargeTime = chargeTime;
	}
	public String getOpPerson() {
		return opPerson;
	}
	public void setOpPerson(String opPerson) {
		this.opPerson = opPerson;
	}
	public String getOpPhone() {
		return opPhone;
	}
	public void setOpPhone(String opPhone) {
		this.opPhone = opPhone;
	}
	
}
