package com.jun.dpms.complain.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.jun.dpms.complain.bean.DpmsComplain;
import com.jun.dpms.complain.service.IDpmsComplainService;
import com.jun.dpms.household.bean.DpmsHousehold;
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
	private DpmsHousehold dpmsHousehold;
	private int[] ids;
	private Map<String,String> sessionMap;
	/**
	 * Ͷ����Ϣ��ҳ��ѯ
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
	 * ��ʾ����
	 * @return
	 */
	public String showDetail(){
		dpmsComplain=dpmsComplainService.searchById(dpmsComplain.getId());
		return SUCCESS;
	}
	/**
	 * ����Ͷ����Ϣ
	 * @return
	 */
	public String update(){
		dpmsComplainService.updateComplain(dpmsComplain);
		return SUCCESS;
	}
	/**
	 * ����ס����Ͷ����Ϣ
	 * @return
	 */
	public String searchByHoldName(){
		dpmsComplains=dpmsComplainService.searchByHoldName(dpmsComplain.getDpmsHousehold().getHoldName());
		return SUCCESS;
	}
	/**
	 * ɾ��Ͷ����Ϣ
	 * @return
	 */
	public String del(){
		dpmsComplainService.delComplaine(ids);
		return SUCCESS;
	}
	
	public String addB(){
		return SUCCESS;
	}
	/**
	 * ����˻��Ϸ���
	 * @return
	 */
	public String checkHousehold(){
		Map<String,String> map = new HashMap<>();
		map.put("msg", dpmsComplainService.checkHousehold(dpmsHousehold));
		setSessionMap(map);
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
	public Map<String,String> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(Map<String,String> sessionMap) {
		this.sessionMap = sessionMap;
	}
	public DpmsHousehold getDpmsHousehold() {
		return dpmsHousehold;
	}
	public void setDpmsHousehold(DpmsHousehold dpmsHousehold) {
		this.dpmsHousehold = dpmsHousehold;
	}
}
