package com.jun.dpms.sysUser.bean;

import java.util.Date;
/**
 * 
 * @author coldJune
 * @date 2017.1.16
 */
public class DpmsSysUser {
	private int userId;
	private String userName;//�����û���¼������
	private String passWord;
	private String gender; 
	private Integer age;
	private String address;
	private String name;//�û�������
	private String cardId;//�û������֤��
	private String phone;
	private String imgPath;
	private String createDate;//�˻�����ʱ��
	private String lastLogin;//���һ�ε�¼ʱ��
	private String birthDay;//��������
	private String email;
	private Integer isUse;//��isUse==1ʱ��ʾ�˺�����ʹ�ã���isUse==0ʱ��ʾ�˺�ֹͣʹ��
	private Integer isSysPass;//�Ƿ�Ϊϵͳ��������,1��ʾ�ǣ�0��ʾ��
	
	public DpmsSysUser() {
		super();
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public Integer getIsUse() {
		return isUse;
	}
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}
	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Integer getIsSysPass() {
		return isSysPass;
	}
	public void setIsSysPass(Integer isSysPass) {
		this.isSysPass = isSysPass;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	
}
