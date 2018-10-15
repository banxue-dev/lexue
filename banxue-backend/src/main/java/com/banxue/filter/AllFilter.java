package com.banxue.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;

import com.banxue.utils.Constants;
import com.banxue.utils.log.FileLog;

/**
作者：fengchase
时间：2018年9月27日
文件：AllFilter.java
项目：banxue-interface
*/
@Configuration
@WebFilter(filterName="myFilter",urlPatterns="/*")
public class AllFilter implements Filter {

	@Override
	public void destroy() {
		// TODO 此处为方法主题
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO 此处为方法主题
		 HttpServletRequest request = (HttpServletRequest) servletRequest;
	     HttpServletResponse response = (HttpServletResponse) servletResponse;
	     FileLog.debugLog("经过了过滤器");
	     //检查用户是否登录
	     checkLogin(request, response);
	     filterChain.doFilter(request, response);
	}

	/**
	 * 检查用户登录
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = request.getRequestURL().toString();
		System.err.println(url);
		
		if (url.contains("login")) {
			return;
		}
		
		// 检查用户是否登录
		HttpSession session = request.getSession();
        if (session.getAttribute(Constants.SESSION_KEY) == null) {
        	url = "/login";
        	response.sendRedirect(url);
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO 此处为方法主题
		
	}

}

