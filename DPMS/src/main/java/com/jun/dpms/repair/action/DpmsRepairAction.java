package com.jun.dpms.repair.action;

import com.jun.dpms.repair.service.IDpmsRepairService;
import com.opensymphony.xwork2.ActionSupport;

public class DpmsRepairAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3946794357926185068L;
	private IDpmsRepairService dpmsRepairService;
	public IDpmsRepairService getDpmsRepairService() {
		return dpmsRepairService;
	}
	public void setDpmsRepairService(IDpmsRepairService dpmsRepairService) {
		this.dpmsRepairService = dpmsRepairService;
	}
}
