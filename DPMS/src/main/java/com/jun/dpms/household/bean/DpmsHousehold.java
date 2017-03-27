package com.jun.dpms.household.bean;

import java.util.Date;
import java.util.Set;

import com.jun.dpms.complain.bean.DpmsComplain;
import com.jun.dpms.park.bean.DpmsPark;
import com.jun.dpms.repair.bean.DpmsRepair;

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
	private String checkInDate;//入住时间
	private Set<DpmsComplain> dpmsComplains;//投诉类容
	private Set<DpmsRepair> dpmsRepairs;//报修内容
	private String plateNumber;
	private Set<DpmsPark> dpmsParks;
	public Set<DpmsPark> getDpmsParks() {
		return dpmsParks;
	}
	public void setDpmsParks(Set<DpmsPark> dpmsParks) {
		this.dpmsParks = dpmsParks;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
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
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Set<DpmsComplain> getDpmsComplains() {
		return dpmsComplains;
	}
	public void setDpmsComplains(Set<DpmsComplain> dpmsComplains) {
		this.dpmsComplains = dpmsComplains;
	}
	public Set<DpmsRepair> getDpmsRepairs() {
		return dpmsRepairs;
	}
	public void setDpmsRepairs(Set<DpmsRepair> dpmsRepairs) {
		this.dpmsRepairs = dpmsRepairs;
	}
	
	
}
