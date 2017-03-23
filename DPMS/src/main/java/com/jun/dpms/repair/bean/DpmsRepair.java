package com.jun.dpms.repair.bean;

import com.jun.dpms.household.bean.DpmsHousehold;

public class DpmsRepair {
	private int id;
	private DpmsHousehold dpmsHousehold;
	private String details;//详情
	private String repairDate;//报修时间
	private String isDeal;//是否处理
	private String sparePhone;
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
	public String getRepairDate() {
		return repairDate;
	}
	public void setRepairDate(String repairDate) {
		this.repairDate = repairDate;
	}
	public String getIsDeal() {
		return isDeal;
	}
	public void setIsDeal(String isDeal) {
		this.isDeal = isDeal;
	}
	public String getSparePhone() {
		return sparePhone;
	}
	public void setSparePhone(String sparePhone) {
		this.sparePhone = sparePhone;
	}
	
}
