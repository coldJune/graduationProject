package com.jun.dpms.propertyCharge.action;

import com.jun.dpms.propertyCharge.service.IDpmsPropertyChargeService;
import com.opensymphony.xwork2.ActionSupport;

public class DpmsPropertyChargeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7062031402001361984L;
	private IDpmsPropertyChargeService dpmsPropertyChargeService;
	public IDpmsPropertyChargeService getDpmsPropertyChargeService() {
		return dpmsPropertyChargeService;
	}
	public void setDpmsPropertyChargeService(IDpmsPropertyChargeService dpmsPropertyChargeService) {
		this.dpmsPropertyChargeService = dpmsPropertyChargeService;
	}
}
