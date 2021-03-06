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
	private int[] ids;
	
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
		}		
		dpmsParks=dpmsParkService.searchByPlateNumber(dpmsPark.getPlateNumber());
		return SUCCESS;
	}
	/**
	 * 离场
	 * @return
	 */
	public String leave(){
		if(dpmsParkService.updateLeave(dpmsPark.getId())){
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
		DpmsPark dpmsPar =dpmsParkService.searchById(dpmsPark.getId());
			if(dpmsPar.getIsCharge().equals("否")){
				dpmsPark=dpmsPar;
				return SUCCESS;
			}
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
	/**
	 * 显示详情页面
	 * @return
	 */
	public String showDetail(){
		List<DpmsPark> results=dpmsParkService.searchByPlateNumber(dpmsPark.getPlateNumber());
		for (DpmsPark dpmsPar : results) {
			if(dpmsPar.getId()==dpmsPark.getId()){
				dpmsPark=dpmsPar;
				return SUCCESS;
			}
		}
		return SUCCESS;
	}
	/**
	 * 入科前跳转
	 */
	public String addB(){
		return SUCCESS;
	}
	/***
	 * 入库
	 * @return
	 */
	public String add(){
		dpmsParkService.addPark(dpmsPark);
		return SUCCESS;
	}
	
	public String checkPark(){
		List<DpmsPark> results=dpmsParkService.searchByPlateNumber(dpmsPark.getPlateNumber());
		if(results!=null&&!results.isEmpty()){
			for (DpmsPark dpmsPar : results) {
				if(dpmsPar!=null){
					if(!dpmsPar.getIsCharge().equals("是")&&(dpmsPar.getEndTime().equals(""))||dpmsPar.getEndTime()==null){
						Map<String, String> map = new HashMap<>();
						map.put("result", "false");
						map.put("msg", "该车已经在库中");
						setSessionMap(map);
						return SUCCESS;
					}	
				}
			}
		}
		
		return SUCCESS;
	}
	
	public String del(){
		dpmsParkService.delPark(ids);
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
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
}
