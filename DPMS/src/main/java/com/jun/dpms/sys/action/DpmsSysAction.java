package com.jun.dpms.sys.action;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jun.dpms.util.SecurityCode;
import com.jun.dpms.util.SecurityImage;
import com.jun.dpms.util.SendMail;
import com.opensymphony.xwork2.ActionSupport;

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
	//计算时间差参数
	private Date timeStamp=null;//生成时间
	private Date useTime=null;//使用时间
	//传出内容
	private ByteArrayInputStream imageStream;
	private Map<String, String> sessionMap;
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
		if(operateType.equalsIgnoreCase("checkUser")){
				sql=sql+" and u.passWord=?";
				q=this.getCurrentSession().createQuery(sql);
				q.setString(0, userName);
				q.setString(1, passWord);
				Map<String, String> map = new HashMap<>();
				//如果密码和用户名不匹配则报此错
				if(q.list()==null||q.list().isEmpty()){	
					map.clear();
					map.put("up", "false");//密码和用户名不匹配
					flag=false;
				}else if(!securityCode.equalsIgnoreCase(securityCodeInput)){ //如果用户名和密码匹配则判断验证码
					map.clear();
					map.put("sc","false");//验证码不匹配	
					flag=false;
				}else{
					flag=true;
				}
				this.setSessionMap(map);

				return "login";
		}
		return SUCCESS;
			
	}
	
	/*
	 * 登录
	 */
	public String logIn(){
		if(flag){
			flag=false;
			return SUCCESS;
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
	 * 检查邮箱是否存在
	 */
	public String checkEmail(){
		String sql ="from DpmsSysUser u where u.email=?";
		Query q =this.getCurrentSession().createQuery(sql);
		Map<String, String> map = new HashMap<>();
		q.setString(0, email);
		if(q.list()==null||q.list().isEmpty()){
			map.put("mail","邮箱不存在");
			this.setSessionMap(map);
		}
		return "fail";
	}
	/**
	 * 系统自动生成密码
	 */
	public String setSysPass(){
		String newPass=SecurityCode.getSecurityCode();
		SendMail.send(email, "<p>您正在使用小区物业管理系统的找回密码服务，下面是由系统为您生成的随机密码，请注意保管并及时修改</p><br/>"+"<Strong>"+newPass+"</Strong>");
		Query q = this.getCurrentSession().createQuery("update DpmsSysUser u set u.passWord=? where u.email=?");
		q.setString(0, newPass);
		q.setString(1, email);
		q.executeUpdate();
		return "setSysPass";
		
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Map<String, String> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, String> sessionMap) {
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

	
}
