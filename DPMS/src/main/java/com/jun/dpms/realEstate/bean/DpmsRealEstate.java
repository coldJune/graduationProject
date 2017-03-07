package com.jun.dpms.realEstate.bean;

public class DpmsRealEstate {
	private Integer id;
	private Integer estateNo;//楼栋编号
	private Integer roomNo;//套数
	private Integer floorNo;//层数
	private Integer roomInNo;//已售套数
	private Integer roomOnSaleNo;//待售套数
	private Integer elevatorNo;//电梯台数
	private Integer unitNo;//单元数
	private String hasDoor;//是否有门禁
	private String hasGas;//是否通燃气
	private String hasBordhand;//是否有宽带
	private String relatePerson;//负责人
	private String phone;//负责人电话
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEstateNo() {
		return estateNo;
	}
	public void setEstateNo(Integer estateNo) {
		this.estateNo = estateNo;
	}
	public Integer getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}
	public Integer getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(Integer floorNo) {
		this.floorNo = floorNo;
	}
	public Integer getRoomInNo() {
		return roomInNo;
	}
	public void setRoomInNo(Integer roomInNo) {
		this.roomInNo = roomInNo;
	}
	public Integer getRoomOnSaleNo() {
		return roomOnSaleNo;
	}
	public void setRoomOnSaleNo(Integer roomOnSaleNo) {
		this.roomOnSaleNo = roomOnSaleNo;
	}
	public Integer getElevatorNo() {
		return elevatorNo;
	}
	public void setElevatorNo(Integer elevatorNo) {
		this.elevatorNo = elevatorNo;
	}
	public Integer getUnitNo() {
		return unitNo;
	}
	public void setUnitNo(Integer unitNo) {
		this.unitNo = unitNo;
	}
	public String getHasDoor() {
		return hasDoor;
	}
	public void setHasDoor(String hasDoor) {
		this.hasDoor = hasDoor;
	}
	public String getHasGas() {
		return hasGas;
	}
	public void setHasGas(String hasGas) {
		this.hasGas = hasGas;
	}
	public String getHasBordhand() {
		return hasBordhand;
	}
	public void setHasBordhand(String hasBordhand) {
		this.hasBordhand = hasBordhand;
	}
	public String getRelatePerson() {
		return relatePerson;
	}
	public void setRelatePerson(String relatePerson) {
		this.relatePerson = relatePerson;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
