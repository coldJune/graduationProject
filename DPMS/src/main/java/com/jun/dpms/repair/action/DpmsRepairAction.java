package com.jun.dpms.repair.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.jun.dpms.repair.bean.DpmsRepair;
import com.jun.dpms.repair.service.IDpmsRepairService;
import com.jun.dpms.util.pagecut.bean.Page;
import com.opensymphony.xwork2.ActionSupport;

public class DpmsRepairAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3946794357926185068L;
	private IDpmsRepairService dpmsRepairService;
	private List<DpmsRepair> dpmsRepairs;
	private DpmsRepair dpmsRepair;
	private Page page=new Page();
	private int[] ids;
	
	/**
	 * 分页查找
	 * @return
	 */
	public String findAll(){
		page.setEachPage(5);
		page.setTotalItem(dpmsRepairService.getTotalItem());
		page.setTotalPage(page.getTotalItem()/page.getEachPage()+(page.getTotalItem()%page.getEachPage()>0?1:0));
		try {
			page.setCurrentPage(Integer.valueOf(ServletActionContext.getRequest().getParameter("currentPage")).intValue());
		} catch (Exception e) {
			// TODO: handle exception
			page.setCurrentPage(1);
		}
		dpmsRepairs=dpmsRepairService.findAll(page.getEachPage(), page.getCurrentPage());
		return SUCCESS;
	}
	
	/**
	 * 通过住户名查询
	 * @return
	 */
	public String searchByHoldName(){
		dpmsRepairs=dpmsRepairService.searchByHoldName(dpmsRepair.getDpmsHousehold().getHoldName());
		return SUCCESS;
	}
	/**
	 * 添加页面跳转
	 * @return
	 */
	public String addB(){
		return SUCCESS;
	}
	/**
	 * 添加报修信息
	 * @return
	 */
	public String add(){
		dpmsRepairService.addRepair(dpmsRepair);
		return SUCCESS;
	}
	/**
	 * 删除报修信息
	 * @return
	 */
	public String del(){
		dpmsRepairService.delRepair(ids);
		return SUCCESS;
	}
	/**
	 * 显示详情页面
	 * @return
	 */
	public String showDetail(){
		dpmsRepair = dpmsRepairService.searchById(dpmsRepair.getId());
		return SUCCESS;
	}
	
	public String update(){
		dpmsRepairService.updateRepair(dpmsRepair);
		return SUCCESS;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<DpmsRepair> getDpmsRepairs() {
		return dpmsRepairs;
	}
	public void setDpmsRepairs(List<DpmsRepair> dpmsRepairs) {
		this.dpmsRepairs = dpmsRepairs;
	}
	public IDpmsRepairService getDpmsRepairService() {
		return dpmsRepairService;
	}
	public void setDpmsRepairService(IDpmsRepairService dpmsRepairService) {
		this.dpmsRepairService = dpmsRepairService;
	}


	public DpmsRepair getDpmsRepair() {
		return dpmsRepair;
	}


	public void setDpmsRepair(DpmsRepair dpmsRepair) {
		this.dpmsRepair = dpmsRepair;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}
}
