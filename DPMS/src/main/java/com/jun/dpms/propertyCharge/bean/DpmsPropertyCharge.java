package com.jun.dpms.propertyCharge.bean;

import java.util.Set;

public class DpmsPropertyCharge {
	private Integer id;
	private String propertyName;
	private String createDate;
	private String remark;
	private String standard;
	private String isNecessary;
	private Integer cycle;//ÖÜÆÚ
	private Set<DpmsPropertyChargeHis> dpmsPropertyChargeHiss;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Set<DpmsPropertyChargeHis> getDpmsPropertyChargeHiss() {
		return dpmsPropertyChargeHiss;
	}
	public void setDpmsPropertyChargeHiss(Set<DpmsPropertyChargeHis> dpmsPropertyChargeHiss) {
		this.dpmsPropertyChargeHiss = dpmsPropertyChargeHiss;
	}
	public String getIsNecessary() {
		return isNecessary;
	}
	public void setIsNecessary(String isNecessary) {
		this.isNecessary = isNecessary;
	}
	public Integer getCycle() {
		return cycle;
	}
	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}
}
