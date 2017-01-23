
package com.jun.dpms.sysUser.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.jun.dpms.sysUser.bean.DpmsSysUser;
import com.jun.dpms.sysUser.service.IDpmsSysUserService;
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
	private Map<String, String> msgs=new HashMap<String, String>();
	private DpmsSysUser dpmsSysUser=new DpmsSysUser();
	public IDpmsSysUserService getDpmsSysUserService() {
		return dpmsSysUserService;
	}

	public void setDpmsSysUserService(IDpmsSysUserService dpmsSysUserService) {
		this.dpmsSysUserService = dpmsSysUserService;
	}
	/*
	 * 登录时的相关验证
	 */
	public String Login(){
		//获取需要验证的类型
		String operateType = ServletActionContext.getRequest().getParameter("operateType");
		//String operateType="checkUserName";
		//验证用户名是否存在
		if(operateType.equalsIgnoreCase("checkUserName")){
			if(!dpmsSysUserService.checkUserName(dpmsSysUser)){
				this.msgs.put("username","该用户不存在");
			}
		}
		if(operateType.equalsIgnoreCase("checkUser")){
			if(!dpmsSysUserService.checkUser(dpmsSysUser)){
				ServletActionContext.getRequest().setAttribute("msg", "用户名或密码错误");
			}
		}
		return SUCCESS;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return dpmsSysUser;
	}


	
	
}
