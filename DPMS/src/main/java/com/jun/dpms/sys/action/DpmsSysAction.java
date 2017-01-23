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

	//ҳ���ȡ����
	private String userName;
	private String passWord;
	private String securityCodeInput;//�������֤��
	private String operateType;
	//����ʱ������
	private Date timeStamp=null;//����ʱ��
	private Date useTime=null;//ʹ��ʱ��
	//��������
	private ByteArrayInputStream imageStream;
	private Map<String, String> sessionMap;
	//�ڲ�ʹ�ò���
	private String securityCode;//���ɵ���֤��
	/**
	 * ��¼ҳ�� �Ĳ���
	 * @return
	 */
	public String logIn(){
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
				//���������û�����ƥ���򱨴˴�
				if(q.list()==null||q.list().isEmpty()){	
					map.put("msg", "false");//������û�����ƥ��
				}else if(!securityCode.equalsIgnoreCase(securityCodeInput)){ //����û���������ƥ�����ж���֤��
					map.put("sc","false");//��֤�벻ƥ��	
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
