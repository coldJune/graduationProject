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
		}		
		dpmsParks=dpmsParkService.searchByPlateNumber(dpmsPark.getPlateNumber());
		return SUCCESS;
	}
	/**
	 * �볡
	 * @return
	 */
	public String leave(){
		if(dpmsParkService.updateLeave(dpmsPark.getId())){
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
		DpmsPark dpmsPar =dpmsParkService.searchById(dpmsPark.getId());
			if(dpmsPar.getIsCharge().equals("��")){
				dpmsPark=dpmsPar;
				return SUCCESS;
			}
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
	/**
	 * ��ʾ����ҳ��
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
	 * ���ǰ��ת
	 */
	public String addB(){
		return SUCCESS;
	}
	/***
	 * ���
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
					if(!dpmsPar.getIsCharge().equals("��")&&(dpmsPar.getEndTime().equals(""))||dpmsPar.getEndTime()==null){
						Map<String, String> map = new HashMap<>();
						map.put("result", "false");
						map.put("msg", "�ó��Ѿ��ڿ���");
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
