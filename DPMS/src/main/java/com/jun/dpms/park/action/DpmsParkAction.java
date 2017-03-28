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
	 * ��ѯͣ������Ϣ
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
	 * ����ͣ����ʷ��¼
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
	 * ��ѯͣ����¼
	 * @return
	 */
	public String search(){
		if(dpmsParks!=null&&!dpmsParks.isEmpty()){
			dpmsParks.clear();
		}		dpmsParks.add(dpmsParkService.searchByPlateNumber(dpmsPark.getPlateNumber()));
		return SUCCESS;
	}
	/**
	 * �볡
	 * @return
	 */
	public String leave(){
		if(dpmsParkService.updateLeave(dpmsPark.getPlateNumber())){
			Map<String, String> map = new HashMap<>();
			map.put("msg", "�ѳɹ��볡");
			map.put("result", "true");
			setSessionMap(map);
		}else{
			Map<String, String> map = new HashMap<>();
			map.put("msg", "�볡ʧ��");
			map.put("result", "false");
			setSessionMap(map);
		}
		return SUCCESS;
	}
	/**
	 * �շ���ת����
	 * @return
	 */
	public String chargeB(){
		dpmsPark=dpmsParkService.searchByPlateNumber(dpmsPark.getPlateNumber());
		return SUCCESS;
	}
	/**
	 * �շ�
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
