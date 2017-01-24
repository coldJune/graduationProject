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

	//ҳ���ȡ����
	private String userName;
	private String passWord;
	private String securityCodeInput;//�������֤��
	private String operateType;
	private String email;
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
		if(operateType.equalsIgnoreCase("checkUser")){
				sql=sql+" and u.passWord=?";
				q=this.getCurrentSession().createQuery(sql);
				q.setString(0, userName);
				q.setString(1, passWord);
				Map<String, String> map = new HashMap<>();
				//���������û�����ƥ���򱨴˴�
				if(q.list()==null||q.list().isEmpty()){	
					map.clear();
					map.put("up", "false");//������û�����ƥ��
					flag=false;
				}else if(!securityCode.equalsIgnoreCase(securityCodeInput)){ //����û���������ƥ�����ж���֤��
					map.clear();
					map.put("sc","false");//��֤�벻ƥ��	
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
	 * ��¼
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
	 * ��������Ƿ����
	 */
	public String checkEmail(){
		String sql ="from DpmsSysUser u where u.email=?";
		Query q =this.getCurrentSession().createQuery(sql);
		Map<String, String> map = new HashMap<>();
		q.setString(0, email);
		if(q.list()==null||q.list().isEmpty()){
			map.put("mail","���䲻����");
			this.setSessionMap(map);
		}
		return "fail";
	}
	/**
	 * ϵͳ�Զ���������
	 */
	public String setSysPass(){
		String newPass=SecurityCode.getSecurityCode();
		SendMail.send(email, "<p>������ʹ��С����ҵ����ϵͳ���һ����������������ϵͳΪ�����ɵ�������룬��ע�Ᵽ�ܲ���ʱ�޸�</p><br/>"+"<Strong>"+newPass+"</Strong>");
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
