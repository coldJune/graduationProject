package com.jun.dpms.bean;

import java.util.Date;
/**
 * 
 * @author coldJune
 * @date 2017.1.16
 */
public class DpmsSysUser {
	private int userId;
	private String userName;//用于用户登录的名字
	private String password;
	private int gender; //gender==1表示为男性；gender==0表示为女性
	private int age;
	private String address;
	private String name;//用户的名字
	private String cardId;//用户的省份证号
	private String phone;
	private Date createDate;//账户创建时间
	private Date lastLogin;//最后一次登录时间
	private Date birthDay;//出生年月
	private int isUse;//当isUse==1时表示账号正在使用，当isUse==0时表示账号停止使用
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public int getIsUse() {
		return isUse;
	}
	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}

	
}
