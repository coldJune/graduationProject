package com.jun.dpms.propertyCharge.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;
import com.jun.dpms.propertyCharge.service.IDpmsPropertyChargeService;
import com.jun.dpms.util.pagecut.bean.Page;
import com.opensymphony.xwork2.ActionSupport;

public class DpmsPropertyChargeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7062031402001361984L;
	private IDpmsPropertyChargeService dpmsPropertyChargeService;
	private Page page=new Page();
	private DpmsPropertyCharge dpmsPropertyCharge;
	private List<DpmsPropertyCharge> dpmsPropertyCharges;
	private Map sessionMap;
	
	/**
	 * 分页查询
	 * @return
	 */
	public String findAll(){
		page.setEachPage(5);
		page.setTotalItem(dpmsPropertyChargeService.getTotalItem());
		page.setTotalPage(page.getTotalItem()/page.getEachPage()+(page.getTotalItem()%page.getEachPage()>0?1:0));
		try {
			page.setCurrentPage(Integer.valueOf(ServletActionContext.getRequest().getParameter("currentPage")).intValue());
		} catch (Exception e) {
			// TODO: handle exception
			page.setCurrentPage(1);
		}
		dpmsPropertyCharges=dpmsPropertyChargeService.findAll(page.getEachPage(), page.getCurrentPage());
		return SUCCESS;
	}
	/**
	 * 添加前跳转
	 * @return
	 */
	public String addB(){
		return SUCCESS;
	}
	
	public String checkPropertyName(){
		dpmsPropertyCharge=dpmsPropertyChargeService.searchByPropertyName(dpmsPropertyCharge.getPropertyName());
		if(dpmsPropertyCharge!=null){
			Map<String, String> map = new HashMap<>();
			map.put("msg", "该项目已经存在");
			setSessionMap(map);
		}
		return SUCCESS;
	}
	public IDpmsPropertyChargeService getDpmsPropertyChargeService() {
		return dpmsPropertyChargeService;
	}
	public void setDpmsPropertyChargeService(IDpmsPropertyChargeService dpmsPropertyChargeService) {
		this.dpmsPropertyChargeService = dpmsPropertyChargeService;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public DpmsPropertyCharge getDpmsPropertyCharge() {
		return dpmsPropertyCharge;
	}
	public void setDpmsPropertyCharge(DpmsPropertyCharge dpmsPropertyCharge) {
		this.dpmsPropertyCharge = dpmsPropertyCharge;
	}
	public List<DpmsPropertyCharge> getDpmsPropertyCharges() {
		return dpmsPropertyCharges;
	}
	public void setDpmsPropertyCharges(List<DpmsPropertyCharge> dpmsPropertyCharges) {
		this.dpmsPropertyCharges = dpmsPropertyCharges;
	}
	public Map getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(Map sessionMap) {
		this.sessionMap = sessionMap;
	}
}
