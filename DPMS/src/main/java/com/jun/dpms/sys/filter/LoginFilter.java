package com.jun.dpms.sys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;


public class LoginFilter extends HttpServlet implements Filter{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8508188945890283404L;
	private String excludePages;
	private String[] excludePageArray;
	private String rootPages;
	private String[] rootPageArray;
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		boolean isExcludePage=false;
		for (String page : excludePageArray) {
			if(((HttpServletRequest)servletRequest).getServletPath().equals(page)){
				isExcludePage=true;
				break;
			}
		}
		
		boolean isRootPage=false;
		for (String root : rootPageArray) {
			if(((HttpServletRequest)servletRequest).getServletPath().equals(root)){
				isRootPage=true;
				break;
			}
			
		}
		// TODO Auto-generated method stub
		if(isExcludePage){
			filterChain.doFilter(servletRequest, servletResponse);
		}else{
			if(((HttpServletRequest)servletRequest).getServletPath().contains(".css")||((HttpServletRequest)servletRequest).getServletPath().contains(".js")){
				filterChain.doFilter(servletRequest, servletResponse);
			}else{
				HttpServletRequest request= (HttpServletRequest)servletRequest;
				HttpServletResponse response =(HttpServletResponse)servletResponse;
				HttpSession session =request.getSession();
				String userName= (String)session.getAttribute("USERNAME");
				
				if(userName==null){
					response.sendRedirect("/DPMS/signIn.jsp");
				}else if(!userName.equals("root")){
					if(isRootPage){
						response.sendRedirect("/DPMS/sys/error404.jsp");
					}else{
						filterChain.doFilter(servletRequest,servletResponse);
					}
				}else{
					filterChain.doFilter(servletRequest,servletResponse);

				}
			}
			
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		excludePages =filterConfig.getInitParameter("excludePage");
		if(StringUtils.isNotEmpty(excludePages)){
			excludePageArray=excludePages.split(",");
		}
		rootPages = filterConfig.getInitParameter("rootPage");
		if(StringUtils.isNotEmpty(rootPages)){
			rootPageArray=rootPages.split(",");
		}
	}

}
