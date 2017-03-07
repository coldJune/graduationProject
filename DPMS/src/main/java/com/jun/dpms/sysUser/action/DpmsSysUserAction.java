
package com.jun.dpms.sysUser.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

import com.jun.dpms.sysUser.bean.DpmsSysUser;
import com.jun.dpms.sysUser.service.IDpmsSysUserService;
import com.jun.dpms.util.MD5Util;
import com.jun.dpms.util.SecurityCode;
import com.jun.dpms.util.SendMail;
import com.jun.dpms.util.pagecut.bean.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * @author coldJune
 * �û������Action
 */
public class DpmsSysUserAction extends ActionSupport implements ModelDriven{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7357031286250160066L;
	private IDpmsSysUserService dpmsSysUserService;
	private DpmsSysUser dpmsSysUser=new DpmsSysUser();
	private Page page = new Page();
	private List<DpmsSysUser> dpmsSysUsers;
	private String userNames[];
	public List<DpmsSysUser> getDpmsSysUsers() {
		return dpmsSysUsers;
	}

	public void setDpmsSysUsers(List<DpmsSysUser> dpmsSysUsers) {
		this.dpmsSysUsers = dpmsSysUsers;
	}

	public IDpmsSysUserService getDpmsSysUserService() {
		return dpmsSysUserService;
	}

	public void setDpmsSysUserService(IDpmsSysUserService dpmsSysUserService) {
		this.dpmsSysUserService = dpmsSysUserService;
	}
	/*
	 * ��ѯ���е�����
	 */
	public String findAll(){
		page.setEachPage(3);
		page.setTotalItem(dpmsSysUserService.getTotalItem());
		page.setTotalPage(page.getTotalItem()/page.getEachPage()+(page.getTotalItem()%page.getEachPage()>0?1:0));
		try{
			page.setCurrentPage(Integer.valueOf((ServletActionContext.getRequest().getParameter("currentPage"))).intValue());
			System.out.println("===============");
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		dpmsSysUsers=dpmsSysUserService.findAll(page.getEachPage(),page.getCurrentPage());
		return SUCCESS;
	}
	/**
	 * ͨ���û�������
	 * @return
	 */
	public String searchByUserName(){
		dpmsSysUsers.clear();
		dpmsSysUsers.add(dpmsSysUserService.searchByUserName(((DpmsSysUser)getModel()).getUserName()));
		return SUCCESS;
	}
	
	/**
	 * ��ʽ��ϸ��Ϣҳ��
	 */
	public String showDetail(){
		dpmsSysUser=dpmsSysUserService.searchByUserName(dpmsSysUser.getUserName());
		return SUCCESS;
	}
	/**
	 * ����ϵͳ�û���Ϣ
	 */
	public String update(){
		dpmsSysUserService.updateSysUser(dpmsSysUser);
		return SUCCESS;
	}
	
	/*
	 * ��ת�����ҳ��
	 */
	public String addB(){
		return SUCCESS;
	}
	/**
	 * ���ϵͳ�û���Ϣ
	 * @return
	 */
	public String add(){
		DpmsSysUser dpmsSysUser = (DpmsSysUser)getModel();
		System.out.println(dpmsSysUser.getGender()+"---------------------");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createDate=df.format(new Date());
		String passWord=SecurityCode.getSecurityCode();
		String md5pass=MD5Util.encode2hex(passWord);
		dpmsSysUser.setCreateDate(createDate);
		dpmsSysUser.setIsUse(1);
		dpmsSysUser.setIsSysPass(1);
		dpmsSysUser.setPassWord(md5pass);
		dpmsSysUser.setLastLogin(null);
		dpmsSysUserService.addSysUser(dpmsSysUser);
		SendMail.send(dpmsSysUser.getEmail(), "DPMS<br>��������Ϊ<strong>"+passWord+"</strong>,�뾡���¼ϵͳ����");
		return SUCCESS;
	}
	/**
	 * �߼�ɾ���û���Ϣ
	 * @return
	 */
	public String del(){
		dpmsSysUserService.delSysUser(userNames);
		return SUCCESS;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return dpmsSysUser;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		
		this.page=page;
	}

	public DpmsSysUser getDpmsSysUser() {
		return dpmsSysUser;
	}

	public void setDpmsSysUser(DpmsSysUser dpmsSysUser) {
		this.dpmsSysUser = dpmsSysUser;
	}

	public String[] getUserNames() {
		return userNames;
	}

	public void setUserNames(String[] userNames) {
		this.userNames = userNames;
	}
	
	
}
