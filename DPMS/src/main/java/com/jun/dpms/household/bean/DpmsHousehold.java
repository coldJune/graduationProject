package com.jun.dpms.household.bean;

import java.util.Date;

public class DpmsHousehold {
	private Integer id;
	private String holdName;//户主名称
	private String holdGender;//户主性别
	private Integer holdAge;//户主年龄
	private Integer familyNo;//家庭人数
	private String hasPackin;//是否有停车位
	private Integer relateRealEstate;//所属楼栋
	private Integer relateUnit;//所属单元
	private Integer relateFloor;//所属层数
	private Integer relateNo;//所属门牌号
	private String holdPhone;//户主电话
	private Date checkInDate;//入住时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHoldName() {
		return holdName;
	}
	public void setHoldName(String holdName) {
		this.holdName = holdName;
	}
	public String getHoldGender() {
		return holdGender;
	}
	public void setHoldGender(String holdGender) {
		this.holdGender = holdGender;
	}
	public Integer getHoldAge() {
		return holdAge;
	}
	public void setHoldAge(Integer holdAge) {
		this.holdAge = holdAge;
	}
	public Integer getFamilyNo() {
		return familyNo;
	}
	public void setFamilyNo(Integer familyNo) {
		this.familyNo = familyNo;
	}
	public String getHasPackin() {
		return hasPackin;
	}
	public void setHasPackin(String hasPackin) {
		this.hasPackin = hasPackin;
	}
	public Integer getRelateRealEstate() {
		return relateRealEstate;
	}
	public void setRelateRealEstate(Integer relateRealEstate) {
		this.relateRealEstate = relateRealEstate;
	}
	public Integer getRelateUnit() {
		return relateUnit;
	}
	public void setRelateUnit(Integer relateUnit) {
		this.relateUnit = relateUnit;
	}
	public Integer getRelateFloor() {
		return relateFloor;
	}
	public void setRelateFloor(Integer relateFloor) {
		this.relateFloor = relateFloor;
	}
	public Integer getRelateNo() {
		return relateNo;
	}
	public void setRelateNo(Integer relateNo) {
		this.relateNo = relateNo;
	}
	public String getHoldPhone() {
		return holdPhone;
	}
	public void setHoldPhone(String holdPhone) {
		this.holdPhone = holdPhone;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	
}
