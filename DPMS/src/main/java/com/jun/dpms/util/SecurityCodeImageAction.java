package com.jun.dpms.util;


import java.io.ByteArrayInputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SecurityCodeImageAction extends ActionSupport implements SessionAware {
	//struts2 Map绫诲瀷鐨剆ession
	private Map<String, Object> session;
	//鍥剧墖娴�
	private ByteArrayInputStream imageStream;
	
	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}
	
	public String execute() throws Exception{
		String securityCode = SecurityCode.getSecurityCode();
		imageStream =SecurityImage.getImageAsInputStream(securityCode);
		session.put("securityCode", securityCode);
		return SUCCESS;
	}
}
