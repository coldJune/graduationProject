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
	//计算时间差参数
	private Date timeStamp=null;//生成时间
	private Date useTime=null;//使用时间
	//传出内容
	private ByteArrayInputStream imageStream;
	private Map<String, String> sessionMap;
	//内部使用参数
	private String securityCode;//生成的验证码
	/**
	 * 登录页面 的操作
	 * @return
	 */
	public String logIn(){
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
				}
				return "CHECKUSERNAME";
		}
		if(operateType.equalsIgnoreCase("checkUser")){
				sql=sql+" and u.passWord=?";
				q=this.getCurrentSession().createQuery(sql);
				q.setString(0, userName);
				q.setString(1, passWord);
				Map<String, String> map = new HashMap<>();
				System.out.println(securityCode);
				System.out.println(securityCodeInput);
				//如果密码和用户名不匹配则报此错
				if(q.list()==null||q.list().isEmpty()){	
					map.put("msg", "false");//密码和用户名不匹配
				}else if(!securityCode.equalsIgnoreCase(securityCodeInput)){ //如果用户名和密码匹配则判断验证码
					map.put("sc","false");//验证码不匹配	
				}
				this.setSessionMap(map);

				return "login";
		}
		return SUCCESS;
			
	}
	
	public String createSecurityCode(){
		securityCode= SecurityCode.getSecurityCode();
		imageStream =SecurityImage.getImageAsInputStream(securityCode);
		Map<String ,String> map = new HashMap<>();
		map.put("securityCode", securityCode);
		this.setSessionMap(map);
		return "securitycode";
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

	
}
