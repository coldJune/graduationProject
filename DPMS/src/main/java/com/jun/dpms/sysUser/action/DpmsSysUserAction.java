
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
 * �û������Action
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
	 * ��¼ʱ�������֤
	 */
	public String Login(){
		//��ȡ��Ҫ��֤������
		String operateType = ServletActionContext.getRequest().getParameter("operateType");
		//String operateType="checkUserName";
		//��֤�û����Ƿ����
		if(operateType.equalsIgnoreCase("checkUserName")){
			if(!dpmsSysUserService.checkUserName(dpmsSysUser)){
				this.msgs.put("username","���û�������");
			}
		}
		if(operateType.equalsIgnoreCase("checkUser")){
			if(!dpmsSysUserService.checkUser(dpmsSysUser)){
				ServletActionContext.getRequest().setAttribute("msg", "�û������������");
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
