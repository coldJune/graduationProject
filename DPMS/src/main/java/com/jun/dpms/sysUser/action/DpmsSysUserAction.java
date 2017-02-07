
package com.jun.dpms.sysUser.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

import com.jun.dpms.sysUser.bean.DpmsSysUser;
import com.jun.dpms.sysUser.service.IDpmsSysUserService;
import com.jun.dpms.util.pagecut.bean.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * @author coldJune
 * 用户管理的Action
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
	 * 查询所有的数据
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
	
	public String searchByUserName(){
		dpmsSysUsers.clear();
		dpmsSysUsers.add(dpmsSysUserService.searchByUserName(((DpmsSysUser)getModel()).getUserName()));
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


	
	
}
