package com.jun.dpms.park.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Map sessionMap;
	
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
	/**
	 * 查询停车记录
	 * @return
	 */
	public String search(){
		if(dpmsParks!=null&&!dpmsParks.isEmpty()){
			dpmsParks.clear();
		}		dpmsParks.add(dpmsParkService.searchByPlateNumber(dpmsPark.getPlateNumber()));
		return SUCCESS;
	}
	/**
	 * 离场
	 * @return
	 */
	public String leave(){
		if(dpmsParkService.updateLeave(dpmsPark.getPlateNumber())){
			Map<String, String> map = new HashMap<>();
			map.put("msg", "已成功离场");
			map.put("result", "true");
			setSessionMap(map);
		}else{
			Map<String, String> map = new HashMap<>();
			map.put("msg", "离场失败");
			map.put("result", "false");
			setSessionMap(map);
		}
		return SUCCESS;
	}
	/**
	 * 收费跳转控制
	 * @return
	 */
	public String chargeB(){
		dpmsPark=dpmsParkService.searchByPlateNumber(dpmsPark.getPlateNumber());
		return SUCCESS;
	}
	/**
	 * 收费
	 * @return
	 */
	public String charge(){
		dpmsParkService.updateCharge(dpmsPark);
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
	public Map getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(Map sessionMap) {
		this.sessionMap = sessionMap;
	}
}
