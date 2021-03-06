package com.jun.dpms.propertyCharge.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.jun.dpms.propertyCharge.bean.DpmsPropertyCharge;
import com.jun.dpms.propertyCharge.bean.DpmsPropertyChargeHis;
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
	private List<DpmsPropertyChargeHis> dpmsPropertyChargeHiss;
	private DpmsPropertyChargeHis dpmsPropertyChargeHis;
	private Map sessionMap;
	private int[] ids;
	
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
	/**
	 * 添加收费项目
	 * @return
	 */
	public String add(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createDate = df.format(new Date());
		String createPerson=(String)ServletActionContext.getRequest().getSession().getAttribute("USERNAME");
		dpmsPropertyCharge.setCreateDate(createDate);
		dpmsPropertyCharge.setCreatePerson(createPerson);
		dpmsPropertyChargeService.addPropertyName(dpmsPropertyCharge);
		return SUCCESS;
	}
	public String showDetail(){
		dpmsPropertyCharge=dpmsPropertyChargeService.searchByPropertyName(dpmsPropertyCharge.getPropertyName());
		return SUCCESS;
	}
	/**
	 * 检查项目名是否已经存在
	 * @return
	 */
	public String checkPropertyName(){
		dpmsPropertyCharge=dpmsPropertyChargeService.searchByPropertyName(dpmsPropertyCharge.getPropertyName());
		if(dpmsPropertyCharge!=null){
			Map<String, String> map = new HashMap<>();
			map.put("msg", "该项目已经存在");
			setSessionMap(map);
		}
		return SUCCESS;
	}
	/**
	 * 更新
	 * @return
	 */
	public String update(){
		String modifyPerson=(String)ServletActionContext.getRequest().getSession().getAttribute("USERNAME");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String modifyDate = df.format(new Date());
		if(dpmsPropertyCharge.getIsNecessary().equals("否")){
			dpmsPropertyCharge.setCycle(-1);
		}
		dpmsPropertyCharge.setModifyPerson(modifyPerson);
		dpmsPropertyCharge.setModifyDate(modifyDate);
		dpmsPropertyChargeService.updatePropertyCharge(dpmsPropertyCharge);
		return SUCCESS;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String del(){
		dpmsPropertyChargeService.delPropertyCharge(ids);
		return SUCCESS;
	}
	/**
	 * 必交项目的人员列表显示
	 * @return
	 */
	public String showChargeList(){
		try {
			dpmsPropertyChargeHiss=dpmsPropertyChargeService.searchByPropertyCharge(dpmsPropertyCharge);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			dpmsPropertyChargeHiss=null;
		}
		return SUCCESS;
	}
	/**
	 *显示必要收费项收费详情
	 * @return
	 */
	public String chargeDetailNecessary(){
		dpmsPropertyChargeHis=dpmsPropertyChargeService.searchChargeDetail(dpmsPropertyChargeHis);
		return SUCCESS;
	}
	/**
	 * 添加收费记录
	 * @return
	 */
	public String addHis(){
		DateFormat df =new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String chargeDate = df.format(new Date());
		String opPerson=(String)ServletActionContext.getRequest().getSession().getAttribute("USERNAME");
		System.out.println(opPerson);
		dpmsPropertyChargeHis.setChargeTime(chargeDate);
		dpmsPropertyChargeHis.setOpPerson(opPerson);
		System.out.println(dpmsPropertyChargeHis.getDpmsPropertyCharge().getIsNecessary());
		if(dpmsPropertyChargeHis.getDpmsPropertyCharge().getIsNecessary().equals("是")){
			dpmsPropertyChargeService.addChargeHis(dpmsPropertyChargeHis);
			return "necessary";
		}else{
			dpmsPropertyChargeService.addChargeHis(dpmsPropertyChargeHis);
			
			return "nonecessary";
		}
	}
	/**
	 * 分页查询缴费记录
	 * @return
	 */
	public String findChargeHis(){
		page.setEachPage(5);
		page.setTotalItem(dpmsPropertyChargeService.getHisTotalItem());
		page.setTotalPage(page.getTotalItem()/page.getEachPage()+(page.getTotalItem()%page.getEachPage()>0?1:0));
		try {
			page.setCurrentPage(Integer.valueOf(ServletActionContext.getRequest().getParameter("currentPage")).intValue());
		} catch (Exception e) {
			// TODO: handle exception
			page.setCurrentPage(1);
		}
		dpmsPropertyChargeHiss=dpmsPropertyChargeService.findAllHis(page.getEachPage(), page.getCurrentPage());

		return SUCCESS;
	}
	
	/**
	 *查询历史记录
	 * @return
	 */
	public String searchByHoldName(){
		dpmsPropertyChargeHiss=dpmsPropertyChargeService.searchByHoldName(dpmsPropertyChargeHis.getDpmsHousehold().getHoldName());
		return SUCCESS;
	}
	/**
	 * 显示收费记录详情
	 * @return
	 */
	public String showHisDetail(){
		dpmsPropertyChargeHis=dpmsPropertyChargeService.searchHisById(dpmsPropertyChargeHis.getId());
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
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public List<DpmsPropertyChargeHis> getDpmsPropertyChargeHiss() {
		return dpmsPropertyChargeHiss;
	}
	public void setDpmsPropertyChargeHiss(List<DpmsPropertyChargeHis> dpmsPropertyChargeHiss) {
		this.dpmsPropertyChargeHiss = dpmsPropertyChargeHiss;
	}
	public DpmsPropertyChargeHis getDpmsPropertyChargeHis() {
		return dpmsPropertyChargeHis;
	}
	public void setDpmsPropertyChargeHis(DpmsPropertyChargeHis dpmsPropertyChargeHis) {
		this.dpmsPropertyChargeHis = dpmsPropertyChargeHis;
	}
}
