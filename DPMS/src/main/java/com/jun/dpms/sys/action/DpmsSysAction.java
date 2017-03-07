package com.jun.dpms.sys.action;

import java.io.ByteArrayInputStream;
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

	//ҳ���ȡ����
	private String userName;
	private String passWord;
	private String securityCodeInput;//�������֤��
	private String operateType;
	private String email;
	private String syspass;
	//����ʱ������
	private Date timeStamp=null;//����ʱ��
	private Date useTime=null;//ʹ��ʱ��
	//��������
	private ByteArrayInputStream imageStream;
	private Map<String, String> sessionMap;
	//�ڲ�ʹ�ò���
	private String securityCode;//���ɵ���֤��
	private boolean flag=false;//�Ƿ���֤ͨ��
	
	/**
	 * ��¼ҳ�� �Ĳ���
	 * @return
	 */
	public String check(){
		//��ȡ��Ҫ��֤������
		String sql ="from DpmsSysUser u where u.userName=?";
		Query q =null;
		this.setSessionMap(null);
		//��֤�û����Ƿ����
		if(operateType.equalsIgnoreCase("checkUserName")){
				q=this.getCurrentSession().createQuery(sql);
				q.setString(0,userName);
				Map<String, String> map = new HashMap<>();
				if(q.list()==null||q.list().isEmpty()){
					map.put("msg", "�û���������");
					this.setSessionMap(map);
					flag=false;
				}
				return "CHECKUSERNAME";
		}
		//��֤������û��Ƿ�ƥ��
		if(operateType.equalsIgnoreCase("checkUser")){
				sql=sql+" and u.passWord=?";
				passWord=MD5Util.encode2hex(passWord);
				q=this.getCurrentSession().createQuery(sql);
				q.setString(0, userName);
				q.setString(1, passWord);
				Map<String, String> map = new HashMap<>();
				//���������û�����ƥ���򱨴˴�
				if(q.list()==null||q.list().isEmpty()){	
					map.clear();
					map.put("up", "false");//������û�����ƥ��
					flag=false;
				}else if(securityCode!=null&&securityCode.equalsIgnoreCase(securityCodeInput)){ //����û���������ƥ�����ж���֤��
					flag=true;
				}else{
					map.clear();
					map.put("sc","false");//��֤�벻ƥ��	
					flag=false;
				}
				this.setSessionMap(map);

				return "login";
		}
		
		//��֤ϵͳ�������Ƿ���ȷ
		if(operateType.equalsIgnoreCase("checkSysPass")){
			String user=(String) ActionContext.getContext().getSession().get("USERNAME");
			sql=sql+" and u.passWord=?";
			System.out.println(syspass+":"+user);
			syspass=MD5Util.encode2hex(syspass);
			q=this.getCurrentSession().createQuery(sql);
			q.setString(0, user);
			q.setString(1, syspass);
			Map<String, String> map = new HashMap<>();
			//�������
			if(q.list()==null||q.list().isEmpty()){	
				map.clear();
				map.put("sp", "�������");//�������
			}
			this.setSessionMap(map);

			return "checkSysPass";
		}
		//��������Ƿ����
		if(operateType.equalsIgnoreCase("checkEmail")){
			sql ="from DpmsSysUser u where u.email=?";
			q =this.getCurrentSession().createQuery(sql);
			Map<String, String> map = new HashMap<>();
			q.setString(0, email);
			if(q.list()==null||q.list().isEmpty()){
				map.put("mail","���䲻����");
				this.setSessionMap(map);
			}
			return "checkEmail";
		}
		return SUCCESS;
			
	}
	
	/*
	 * ��¼
	 */
	@SuppressWarnings("unchecked")
	public String logIn(){
		if(flag){
			flag=false;
			//�����ϵͳ������������ת�޸�����ҳ��
			Query q = this.getCurrentSession().createQuery("select u.isSysPass from DpmsSysUser u where u.userName=?");
			q.setString(0, userName);
			int isSys= (int) q.list().get(0);
			ActionContext.getContext().getSession().put("USERNAME", userName);
			if(isSys==1){
				
				return "changeSysPass";
			}else{
				if(userName=="root"){
					return "root";
				}else{
					return SUCCESS;
				}
			}
		}else{
			return "fail";
		}
	}
	/*
	 * ������֤��
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
	 * ϵͳ�Զ���������
	 */
	public String setSysPass(){
		String newPass=SecurityCode.getSecurityCode();
		
		Query q = this.getCurrentSession().createQuery("update DpmsSysUser u set u.passWord=?,u.isSysPass=1 where u.email=?");
		String md5pass = MD5Util.encode2hex(newPass);
		q.setString(0, md5pass);
		q.setString(1, email);
		q.executeUpdate();
		SendMail.send(email, "<p>������ʹ��С����ҵ����ϵͳ���һ����������������ϵͳΪ�����ɵ�������룬��ע�Ᵽ�ܲ���ʱ�޸�</p><br/>"+"<Strong>"+newPass+"</Strong>");
		return "setSysPass";
		
	}
	/**
	 * �޸�����
	 */
	public String changePass(){
		userName=(String) ActionContext.getContext().getSession().get("USERNAME");
		Query q = this.getCurrentSession().createQuery("update DpmsSysUser u set u.passWord=?,u.isSysPass=0 where u.userName=?");
		q.setString(0, MD5Util.encode2hex(passWord));
		q.setString(1, userName);
		q.executeUpdate();
		return "changePass";
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


	public void setSyspass(String syspass) {
		this.syspass = syspass;
	}

	
}
