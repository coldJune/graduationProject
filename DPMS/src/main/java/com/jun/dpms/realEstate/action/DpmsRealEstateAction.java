package com.jun.dpms.realEstate.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.jun.dpms.realEstate.bean.DpmsRealEstate;
import com.jun.dpms.realEstate.service.IDpmsRealEstateService;
import com.jun.dpms.util.pagecut.bean.Page;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * @author coldJune
 * 楼盘信息管理的action
 */
public class DpmsRealEstateAction extends ActionSupport implements ModelDriven{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8253299766924585909L;
	
	private IDpmsRealEstateService dpmsRealEstateService;
	private DpmsRealEstate dpmsRealEstate= new DpmsRealEstate();
	private Page page = new Page();
	private List<DpmsRealEstate> dpmsRealEstates;
	private int[] estateNos;
	private Map<String, String> sessionMap;
	/*
	 * 查询所有数据
	 */
	public String findAll(){
		page.setEachPage(5);
		page.setTotalItem(dpmsRealEstateService.getTotalItem());
		page.setTotalPage(page.getTotalItem()/page.getEachPage()+(page.getTotalItem()%page.getEachPage()>0?1:0));
		
		try{
			page.setCurrentPage(Integer.valueOf((ServletActionContext.getRequest().getParameter("currentPage"))).intValue());
		}catch (Exception e) {
			// TODO: handle exception
			page.setCurrentPage(1);
		}
		dpmsRealEstates=dpmsRealEstateService.findAll(page.getEachPage(), page.getCurrentPage());
		
		return SUCCESS;
	}
	
	/*
	 *添加跳转动作 
	 */
	public String addB(){
		return SUCCESS;
	}
	
	/**
	 * 显示详情页面
	 * @return
	 */
	public String showDetail(){
		dpmsRealEstate=dpmsRealEstateService.searchByEstateNo(dpmsRealEstate.getEstateNo());
		return SUCCESS;
	}
	
	/**
	 * 通过楼栋编号查找
	 * @return
	 */
	public String searchByEstateNo(){
		dpmsRealEstates.clear();
		dpmsRealEstates.add(dpmsRealEstateService.searchByEstateNo(((DpmsRealEstate)getModel()).getEstateNo()));
		return SUCCESS;
	}
	/**
	 * 检查楼栋是否存在
	 * @return
	 */
	public String checkByEstateNo(){
		DpmsRealEstate dpmsRealEstate = dpmsRealEstateService.searchByEstateNo(((DpmsRealEstate)getModel()).getEstateNo());
		Map<String,String> map= new HashMap<String,String>();
		if(dpmsRealEstate==null){
			map.put("msg", "true");
		}else{
			map.put("msg", "false");
		}
		this.setSessionMap(map);
		return SUCCESS;
	}
	/**
	 * 添加楼盘信息
	 * @return
	 */
	public String add(){
		DpmsRealEstate dpmsRealEstate =(DpmsRealEstate)getModel();
		int roomOnSaleNo = dpmsRealEstate.getRoomNo()-dpmsRealEstate.getRoomInNo();
		dpmsRealEstate.setRoomOnSaleNo(roomOnSaleNo);
		dpmsRealEstateService.addRealEstat(dpmsRealEstate);
		return SUCCESS;
	}
	
	public String update(){
		dpmsRealEstateService.updateRealEstat(dpmsRealEstate);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	public IDpmsRealEstateService getDpmsRealEstateService() {
		return dpmsRealEstateService;
	}

	public void setDpmsRealEstateService(IDpmsRealEstateService dpmsRealEstateService) {
		this.dpmsRealEstateService = dpmsRealEstateService;
	}

	public DpmsRealEstate getDpmsRealEstate() {
		return dpmsRealEstate;
	}

	public void setDpmsRealEstate(DpmsRealEstate dpmsRealEstate) {
		this.dpmsRealEstate = dpmsRealEstate;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<DpmsRealEstate> getDpmsRealEstates() {
		return dpmsRealEstates;
	}

	public void setDpmsRealEstates(List<DpmsRealEstate> dpmsRealEstates) {
		this.dpmsRealEstates = dpmsRealEstates;
	}

	public int[] getEstateNos() {
		return estateNos;
	}

	public void setEstateNos(int[] estateNos) {
		this.estateNos = estateNos;
	}

	public Map<String, String> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, String> sessionMap) {
		this.sessionMap = sessionMap;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return dpmsRealEstate;
	}

}
