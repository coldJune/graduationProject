
package com.jun.dpms.sysUser.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.http.client.support.HttpAccessor;

import com.jun.dpms.sysUser.bean.DpmsSysUser;
import com.jun.dpms.sysUser.service.IDpmsSysUserService;
import com.jun.dpms.util.MD5Util;
import com.jun.dpms.util.SecurityCode;
import com.jun.dpms.util.SendMail;
import com.jun.dpms.util.pagecut.bean.Page;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * @author coldJune
 * �û������Action
 */
public class DpmsSysUserAction extends ActionSupport implements ModelDriven{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7357031286250160066L;
	private IDpmsSysUserService dpmsSysUserService;
	private DpmsSysUser dpmsSysUser=new DpmsSysUser();
	private Page page = new Page();
	private List<DpmsSysUser> dpmsSysUsers;
	private String userNames[];
	private File imgHead;
	private String imgHeadFileName;
	private String imgHeadContentType;
	private InputStream imageStream;
	private Map sessionMap;
	public List<DpmsSysUser> getDpmsSysUsers() {
		return dpmsSysUsers;
	}

	public void setDpmsSysUsers(List<DpmsSysUser> dpmsSysUsers) {
		this.dpmsSysUsers = dpmsSysUsers;
	}

	public IDpmsSysUserService getDpmsSysUserService() {
		return dpmsSysUserService;
	}

	public void setDpmsSysUserService(IDpmsSysUserService dpmsSysUserService) {
		this.dpmsSysUserService = dpmsSysUserService;
	}
	/*
	 * ��ѯ���е�����
	 */
	public String findAll(){
		page.setEachPage(3);
		page.setTotalItem(dpmsSysUserService.getTotalItem());
		page.setTotalPage(page.getTotalItem()/page.getEachPage()+(page.getTotalItem()%page.getEachPage()>0?1:0));
		try{
			page.setCurrentPage(Integer.valueOf((ServletActionContext.getRequest().getParameter("currentPage"))).intValue());
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		dpmsSysUsers=dpmsSysUserService.findAll(page.getEachPage(),page.getCurrentPage());
		return SUCCESS;
	}
	/**
	 * ͨ���û�������
	 * @return
	 */
	public String searchByUserName(){
		dpmsSysUsers.clear();
		dpmsSysUsers.add(dpmsSysUserService.searchByUserName(((DpmsSysUser)getModel()).getUserName()));
		return SUCCESS;
	}
	
	/**
	 * ��ʽ��ϸ��Ϣҳ��
	 */
	public String showDetail(){
		dpmsSysUser=dpmsSysUserService.searchByUserName(dpmsSysUser.getUserName());
		return SUCCESS;
	}
	/**
	 * ����ϵͳ�û���Ϣ
	 */
	public String update(){
		System.out.println(ServletActionContext.getRequest().getParameter("type"));
		if(ServletActionContext.getRequest().getParameter("type").equals("personal")){
			dpmsSysUserService.updateSysUser(dpmsSysUser);
			Map<String, String> map= new HashMap<>();
			map.put("msg", "�޸ĳɹ�");
			setSessionMap(map);
			return "personal";
		}else{
			dpmsSysUserService.updateSysUser(dpmsSysUser);
			return SUCCESS;
		}
		
	}
	
	/*
	 * ��ת�����ҳ��
	 */
	public String addB(){
		return SUCCESS;
	}
	/**
	 * ���ϵͳ�û���Ϣ
	 * @return
	 */
	public String add(){
		DpmsSysUser dpmsSysUser = (DpmsSysUser)getModel();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createDate=df.format(new Date());
		String passWord=SecurityCode.getSecurityCode();
		String md5pass=MD5Util.encode2hex(passWord);
		dpmsSysUser.setCreateDate(createDate);
		dpmsSysUser.setIsUse(1);
		dpmsSysUser.setIsSysPass(1);
		dpmsSysUser.setPassWord(md5pass);
		dpmsSysUser.setLastLogin(null);
		dpmsSysUserService.addSysUser(dpmsSysUser);
		SendMail.send(dpmsSysUser.getEmail(), "DPMS<br>��������Ϊ<strong>"+passWord+"</strong>,�뾡���¼ϵͳ����");
		return SUCCESS;
	}
	/**
	 * �߼�ɾ���û���Ϣ
	 * @return
	 */
	public String del(){
		dpmsSysUserService.delSysUser(userNames);
		return SUCCESS;
	}
	
	/**
	 * �ϴ�ͼƬ
	 */
	
	public String uploadImg(){
		try {
			InputStream is = new FileInputStream(imgHead);
			String userName="root";//(String)ServletActionContext.getRequest().getAttribute("USERNAME");
			String fileName=userName+imgHeadFileName.substring(imgHeadFileName.lastIndexOf('.'), imgHeadFileName.length());
			String savePath=this.getClass().getClassLoader().getResource("").getPath();
			savePath=savePath.split("WEB-INF/classes")[0]+"head/";
			File myPath=new File(savePath);
			if(!myPath.exists()){
				myPath.mkdir();
			}
			String imgPath=savePath+fileName;
			OutputStream os = new FileOutputStream(imgPath);
			byte[] buffer = new byte[1024];
			int count=0;
			while((count = is.read(buffer)) > 0){
				os.write(buffer, 0, count);
			}
			os.flush();
			os.close();
			is.close();
			dpmsSysUser.setImgPath(imgPath);
			dpmsSysUser.setUserName(userName);
			dpmsSysUserService.updateImg(dpmsSysUser);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> map = new HashMap<>();
			map.put("false", "�ϴ�ʧ��");
			setSessionMap(map);
		}
		return SUCCESS;
	}
	/**
	 * ��ʾͼƬ
	 * @return
	 */
	public String showHead(){
		try {
			String userName=(String) ServletActionContext.getRequest().getAttribute("USERNAME");
			imageStream=new FileInputStream(new File(dpmsSysUserService.searchByUserName("root").getImgPath()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String showPersonal(){
		dpmsSysUser = dpmsSysUserService.searchByUserName(dpmsSysUser.getUserName());
		return SUCCESS;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return dpmsSysUser;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		
		this.page=page;
	}

	public DpmsSysUser getDpmsSysUser() {
		return dpmsSysUser;
	}

	public void setDpmsSysUser(DpmsSysUser dpmsSysUser) {
		this.dpmsSysUser = dpmsSysUser;
	}

	public String[] getUserNames() {
		return userNames;
	}

	public void setUserNames(String[] userNames) {
		this.userNames = userNames;
	}
	@JSON(serialize=false)
	public File getImgHead() {
		return imgHead;
	}

	public void setImgHead(File imgHead) {
		this.imgHead = imgHead;
	}

	public Map getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getImgHeadContentType() {
		return imgHeadContentType;
	}

	public void setImgHeadContentType(String imgHeadContentType) {
		this.imgHeadContentType = imgHeadContentType;
	}

	public String getImgHeadFileName() {
		return imgHeadFileName;
	}

	public void setImgHeadFileName(String imgHeadFileName) {
		this.imgHeadFileName = imgHeadFileName;
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}


	
	
}
