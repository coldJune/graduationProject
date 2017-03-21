package com.jun.dpms.complain.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

import com.jun.dpms.complain.bean.DpmsComplain;
import com.jun.dpms.complain.service.IDpmsComplainService;
import com.jun.dpms.util.pagecut.bean.Page;
import com.opensymphony.xwork2.ActionSupport;

public class DpmsComplainAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6352282289007185565L;
	private IDpmsComplainService dpmsComplainService;
	private List<DpmsComplain> dpmsComplains;
	private Page page=new Page();
	private DpmsComplain dpmsComplain;	
	private int[] ids;
	/**
	 * 投诉信息分页查询
	 * @return
	 */
	public String findAll(){
		page.setEachPage(5);
		page.setTotalItem(dpmsComplainService.getTotalItem());
		page.setTotalPage(page.getTotalItem()/page.getEachPage()+(page.getTotalItem()%page.getEachPage()>0?1:0));
		try {
			page.setCurrentPage((Integer.valueOf(ServletActionContext.getRequest().getParameter("currentPage"))).intValue());
		} catch (Exception e) {
			page.setCurrentPage(1);
			// TODO: handle exception
		}
		dpmsComplains=dpmsComplainService.findAll(page.getEachPage(), page.getCurrentPage());
		return SUCCESS;
	}
	/**
	 * 显示详情
	 * @return
	 */
	public String showDetail(){
		dpmsComplain=dpmsComplainService.searchById(dpmsComplain.getId());
		return SUCCESS;
	}
	/**
	 * 更新投诉信息
	 * @return
	 */
	public String update(){
		dpmsComplainService.updateComplain(dpmsComplain);
		return SUCCESS;
	}
	/**
	 * 查找住户的投诉信息
	 * @return
	 */
	public String searchByHoldName(){
		dpmsComplains=dpmsComplainService.searchByHoldName(dpmsComplain.getDpmsHousehold().getHoldName());
		return SUCCESS;
	}
	
	public String del(){
		dpmsComplainService.delComplaine(ids);
		return SUCCESS;
	}
	public IDpmsComplainService getDpmsComplainService() {
		return dpmsComplainService;
	}
	public void setDpmsComplainService(IDpmsComplainService dpmsComplainService) {
		this.dpmsComplainService = dpmsComplainService;
	}
	public List<DpmsComplain> getDpmsComplains() {
		return dpmsComplains;
	}
	public void setDpmsComplains(List<DpmsComplain> dpmsComplains) {
		this.dpmsComplains = dpmsComplains;
	}


	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}
	public DpmsComplain getDpmsComplain() {
		return dpmsComplain;
	}
	public void setDpmsComplain(DpmsComplain dpmsComplain) {
		this.dpmsComplain = dpmsComplain;
	}
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
}
