package com.jun.dpms.sys.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 添加登录身份的拦截器
 * @author 笨蛋
 *
 */
public class Authentication extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		//取得请求相关的ActionContext实例
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		String userName = (String) session.get("USERNAME");
		
		//如果登录为root
		if(userName!=null &&userName.equalsIgnoreCase("root")){
			
		}
		//如果用户已经登录
		if(userName!=null){
			return invocation.invoke();
		}
		
		return Action.LOGIN;
	}

}
