package com.jun.dpms.sys.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * ��ӵ�¼��ݵ�������
 * @author ����
 *
 */
public class Authentication extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		//ȡ��������ص�ActionContextʵ��
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		String userName = (String) session.get("USERNAME");
		
		//�����¼Ϊroot
		if(userName!=null &&userName.equalsIgnoreCase("root")){
			
		}
		//����û��Ѿ���¼
		if(userName!=null){
			return invocation.invoke();
		}
		
		return Action.LOGIN;
	}

}
