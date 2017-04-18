package com.jun.dpms.sys.action;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;

import com.jun.dpms.household.bean.DpmsHousehold;
import com.jun.dpms.sysUser.bean.DpmsSysUser;
import com.jun.dpms.util.MD5Util;
import com.jun.dpms.util.SecurityCode;
import com.jun.dpms.util.SecurityImage;
import com.jun.dpms.util.SendMail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Context;

//import net.sf.json.JSONObject;

public class DpmsSysAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1667562767129187236L;
	private SessionFactory sessionFactory;

	//页面获取参数
	private String userName;
	private String passWord;
	private String securityCodeInput;//输入的验证码
	private String operateType;
	private String email;
	private String syspass;
	private String searchOperate;
	private DpmsHousehold dpmsHousehold;
	//计算时间差参数
	private Date timeStamp=null;//生成时间
	private Date useTime=null;//使用时间
	//传出内容
	private ByteArrayInputStream imageStream;
	private Map sessionMap;
	//内部使用参数
	private String securityCode;//生成的验证码
	private boolean flag=false;//是否验证通过
	
	/**
	 * 登录页面 的操作
	 * @return
	 */
	public String check(){
		//获取需要验证的类型
		String sql ="from DpmsSysUser u where u.userName=?";
		Query q =null;
		this.setSessionMap(null);
		//验证用户名是否存在
		if(operateType.equalsIgnoreCase("checkUserName")){
				q=this.getCurrentSession().createQuery(sql);
				q.setString(0,userName);
				Map<String, String> map = new HashMap<>();
				if(q.list()==null||q.list().isEmpty()){
					map.put("msg", "用户名不存在");
					this.setSessionMap(map);
					flag=false;
				}
				return "CHECKUSERNAME";
		}
		//验证密码和用户是否匹配
		if(operateType.equalsIgnoreCase("checkUser")){
				sql=sql+" and u.passWord=?";
				passWord=MD5Util.encode2hex(passWord);
				q=this.getCurrentSession().createQuery(sql);
				q.setString(0, userName);
				q.setString(1, passWord);
				Map<String, String> map = new HashMap<>();
				//如果密码和用户名不匹配则报此错
				if(q.list()==null||q.list().isEmpty()){	
					map.clear();
					map.put("up", "false");//密码和用户名不匹配
					flag=false;
				}else if(securityCode!=null&&securityCode.equalsIgnoreCase(securityCodeInput)){ //如果用户名和密码匹配则判断验证码
					flag=true;
				}else{
					map.clear();
					map.put("sc","false");//验证码不匹配	
					flag=false;
				}
				this.setSessionMap(map);

				return "login";
		}
		
		//验证系统的密码是否正确
		if(operateType.equalsIgnoreCase("checkSysPass")){
			String user=(String) ActionContext.getContext().getSession().get("USERNAME");
			sql=sql+" and u.passWord=?";
			System.out.println(syspass+":"+user);
			syspass=MD5Util.encode2hex(syspass);
			q=this.getCurrentSession().createQuery(sql);
			q.setString(0, user);
			q.setString(1, syspass);
			Map<String, String> map = new HashMap<>();
			//密码错误
			if(q.list()==null||q.list().isEmpty()){	
				map.clear();
				map.put("sp", "密码错误");//密码错误
			}
			this.setSessionMap(map);

			return "checkSysPass";
		}
		//检查邮箱是否存在
		if(operateType.equalsIgnoreCase("checkEmail")){
			sql ="from DpmsSysUser u where u.email=?";
			q =this.getCurrentSession().createQuery(sql);
			Map<String, String> map = new HashMap<>();
			q.setString(0, email);
			if(q.list()==null||q.list().isEmpty()){
				map.put("mail","邮箱不存在");
				this.setSessionMap(map);
			}
			return "checkEmail";
		}
		return SUCCESS;
			
	}
	
	/*
	 * 登录
	 */
	@SuppressWarnings("unchecked")
	public String logIn(){
		if(flag){
			flag=false;
			//如果是系统生成密码则跳转修改密码页面
			Query q = this.getCurrentSession().createQuery("select u.isSysPass from DpmsSysUser u where u.userName=?");
			q.setString(0, userName);
			int isSys= (int) q.list().get(0);
			ActionContext.getContext().getSession().put("USERNAME", userName);
			if(isSys==1){
				
				return "changeSysPass";
			}else{
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
					String lastLogin=df.format(new Date());
					q=this.getCurrentSession().createQuery("update DpmsSysUser u set u.lastLogin=? where u.userName=?");
					q.setString(0, lastLogin);
					q.setString(1, userName);
					q.executeUpdate();
					return SUCCESS;
			}
		}else{
			return "fail";
		}
	}
	/*
	 * 创建验证码
	 * 
	 */
	public String createSecurityCode(){
		securityCode= SecurityCode.getSecurityCode();
		imageStream =SecurityImage.getImageAsInputStream(securityCode);
		Map<String ,String> map = new HashMap<>();
		map.put("securityCode", securityCode);
		this.setSessionMap(map);
		return "securitycode";
	}
	
	/**
	 * 系统自动生成密码
	 */
	public String setSysPass(){
		String newPass=SecurityCode.getSecurityCode();
		
		Query q = this.getCurrentSession().createQuery("update DpmsSysUser u set u.passWord=?,u.isSysPass=1 where u.email=?");
		String md5pass = MD5Util.encode2hex(newPass);
		q.setString(0, md5pass);
		q.setString(1, email);
		q.executeUpdate();
		SendMail.send(email, "<p>您正在使用小区物业管理系统的找回密码服务，下面是由系统为您生成的随机密码，请注意保管并及时修改</p><br/>"+"<Strong>"+newPass+"</Strong>");
		return "setSysPass";
		
	}
	/**
	 * 修改密码
	 */
	public String changePass(){
		userName=(String) ActionContext.getContext().getSession().get("USERNAME");
		Query q = this.getCurrentSession().createQuery("update DpmsSysUser u set u.passWord=?,u.isSysPass=0 where u.userName=?");
		q.setString(0, MD5Util.encode2hex(passWord));
		q.setString(1, userName);
		q.executeUpdate();
		if(ServletActionContext.getRequest().getParameter("type").equals("personal")){
			Map<String,String> map = new HashMap<>();
			map.put("msg", "修改成功");
			setSessionMap(map);
			return "personal";
		}else{
			return "changePass";
		}
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 查找所属楼栋信息
	 * @return
	 */
	public String searchRelate(){
		if(searchOperate=="searRealEstate"||searchOperate.equalsIgnoreCase("searRealEstate")){
			Map<String, List> map= new HashMap<>();
			map.put("estateNos",this.getCurrentSession().createQuery("select r.estateNo from DpmsRealEstate r ").list());
			this.setSessionMap(map);
			return SUCCESS;
		}
		if(searchOperate=="searchUnitAndFloor"||searchOperate.equalsIgnoreCase("searchUnitAndFloor")){
			Map<String, List> map= new HashMap<>();
			Query q =this.getCurrentSession().createQuery("select r.unitNo,r.floorNo from DpmsRealEstate r where r.estateNo=?");
			q.setInteger(0, Integer.valueOf(ServletActionContext.getRequest().getParameter("relateRealEstate")).intValue());
			map.put("unitAndfloor", q.list());
			this.setSessionMap(map);
			return SUCCESS;
		}
		return SUCCESS;
	}
	
	public String checkHousehold(){
		Query q=this.getCurrentSession().createQuery("from DpmsHousehold h where h.relateRealEstate=? and h.relateFloor=? and h.relateUnit=? and h.relateNo=?");
		q.setInteger(0, dpmsHousehold.getRelateRealEstate());
		q.setInteger(1, dpmsHousehold.getRelateFloor());
		q.setInteger(2, dpmsHousehold.getRelateUnit());
		q.setInteger(3, dpmsHousehold.getRelateNo());
		List<DpmsHousehold> dpmsHouseholds = q.list();
		Map<String,String> map = new HashMap<>();
		if(dpmsHouseholds!=null&&!dpmsHouseholds.isEmpty()){
			for (DpmsHousehold d: dpmsHouseholds) {
				if(d!=null){
					map.put("holdName", d.getHoldName());
					map.put("holdPhone", d.getHoldPhone());
					map.put("holdId", d.getId()+"");
					map.put("holdArea", d.getArea()+"");
					setSessionMap(map);
					return SUCCESS;
				}else{
					map.put("msg", "false");
					setSessionMap(map);
					return SUCCESS;
				}
			}
		}else{
			map.put("msg", "false");
			setSessionMap(map);
			return SUCCESS;
		
		}
		map.put("msg", "false");
		setSessionMap(map);
		return SUCCESS;
		
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	private Session getCurrentSession(){
		return this.sessionFactory.openSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Map getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map sessionMap) {
		this.sessionMap = sessionMap;
	}

	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}



	public void setSecurityCodeInput(String securityCodeInput) {
		this.securityCodeInput = securityCodeInput;
	}



	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public void setSyspass(String syspass) {
		this.syspass = syspass;
	}

	public String getSearchOperate() {
		return searchOperate;
	}

	public void setSearchOperate(String searchOperate) {
		this.searchOperate = searchOperate;
	}

	public DpmsHousehold getDpmsHousehold() {
		return dpmsHousehold;
	}

	public void setDpmsHousehold(DpmsHousehold dpmsHousehold) {
		this.dpmsHousehold = dpmsHousehold;
	}

	
}
