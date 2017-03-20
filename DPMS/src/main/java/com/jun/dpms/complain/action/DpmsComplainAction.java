package com.jun.dpms.complain.action;

import com.jun.dpms.complain.service.IDpmsComplainService;
import com.opensymphony.xwork2.ActionSupport;

public class DpmsComplainAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6352282289007185565L;
	private IDpmsComplainService dpmsComplainService;
	public IDpmsComplainService getDpmsComplainService() {
		return dpmsComplainService;
	}
	public void setDpmsComplainService(IDpmsComplainService dpmsComplainService) {
		this.dpmsComplainService = dpmsComplainService;
	}
}
