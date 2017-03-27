package com.jun.dpms.park.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.jun.dpms.park.bean.DpmsPark;
import com.jun.dpms.park.service.IDpmsParkService;
import com.jun.dpms.util.pagecut.bean.Page;
import com.opensymphony.xwork2.ActionSupport;

public class DpmsParkAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -11550161583420607L;
	private IDpmsParkService dpmsParkService;
	private List<DpmsPark> dpmsParks;
	private Page page=new Page();
	private DpmsPark dpmsPark;
	
	/**
	 * 查询停车场信息
	 * @return
	 */
	public String findAll(){
		if(dpmsParks!=null&&!dpmsParks.isEmpty()){
			dpmsParks.clear();
		}
		page.setTotalItem(dpmsParkService.getTotalItem());
		page.setEachPage(5);
		page.setTotalPage(page.getTotalItem()/page.getEachPage()+(page.getTotalItem()%page.getEachPage()>0?1:0));
		try {
			page.setCurrentPage((Integer.valueOf(ServletActionContext.getRequest().getParameter("currentPage"))).intValue());
		} catch (Exception e) {
			// TODO: handle exception
			page.setCurrentPage(1);
		}
		dpmsParks=dpmsParkService.findAll(page.getEachPage(),page.getCurrentPage());
		return SUCCESS;
	}
	/**
	 * 查找停车历史记录
	 * @return
	 */
	public String findHisAll(){
		if(dpmsParks!=null&&!dpmsParks.isEmpty()){
			dpmsParks.clear();
		}		page.setTotalItem(dpmsParkService.getHisTotalItem());
		page.setEachPage(5);
		page.setTotalPage(page.getTotalItem()/page.getEachPage()+(page.getTotalItem()%page.getEachPage()>0?1:0));
		try {
			page.setCurrentPage((Integer.valueOf(ServletActionContext.getRequest().getParameter("currentPage"))).intValue());
		} catch (Exception e) {
			// TODO: handle exception
			page.setCurrentPage(1);
		}
		dpmsParks=dpmsParkService.findHisAll(page.getEachPage(),page.getCurrentPage());
		return SUCCESS;
	}
	public String search(){
		if(dpmsParks!=null&&!dpmsParks.isEmpty()){
			dpmsParks.clear();
		}		dpmsParks.add(dpmsParkService.searchByPlateNumber(dpmsPark.getPlateNumber()));
		return SUCCESS;
	}
	public List<DpmsPark> getDpmsParks() {
		return dpmsParks;
	}
	public void setDpmsParks(List<DpmsPark> dpmsParks) {
		this.dpmsParks = dpmsParks;
	}
	public IDpmsParkService getDpmsParkService() {
		return dpmsParkService;
	}
	public void setDpmsParkService(IDpmsParkService dpmsParkService) {
		this.dpmsParkService = dpmsParkService;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	public DpmsPark getDpmsPark() {
		return dpmsPark;
	}
	public void setDpmsPark(DpmsPark dpmsPark) {
		this.dpmsPark = dpmsPark;
	}
}
