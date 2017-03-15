package com.jun.dpms.household.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.household.service.IDpmsHouseholdService;
import com.jun.dpms.realEstate.bean.DpmsRealEstate;
import com.jun.dpms.util.pagecut.bean.Page;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DpmsHouseholdAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -583536679040254632L;
	private IDpmsHouseholdService dpmsHouseholdService;
	private DpmsHousehold dpmsHousehold = new DpmsHousehold();
	private Page page = new Page();
	private List<DpmsHousehold> dpmsHouseholds;
	private int[] ids;
	
	
	/**
	 * 查找所有用户
	 * @return
	 */
	public String findAll(){
		page.setEachPage(5);
		page.setTotalItem(dpmsHouseholdService.getTotalItem());
		page.setTotalPage(page.getTotalItem()/page.getEachPage()+(page.getTotalItem()%page.getEachPage()>0?1:0));
		
		try {
			page.setCurrentPage(Integer.valueOf((ServletActionContext.getRequest().getParameter("currentPage"))).intValue());
		} catch (Exception e) {
			// TODO: handle exception
			page.setCurrentPage(1);
		}
		dpmsHouseholds=dpmsHouseholdService.findAll(page.getEachPage(), page.getCurrentPage());
		return SUCCESS;
	}
	public IDpmsHouseholdService getDpmsHouseholdService() {
		return dpmsHouseholdService;
	}
	public void setDpmsHouseholdService(IDpmsHouseholdService dpmsHouseholdService) {
		this.dpmsHouseholdService = dpmsHouseholdService;
	}
	

}
