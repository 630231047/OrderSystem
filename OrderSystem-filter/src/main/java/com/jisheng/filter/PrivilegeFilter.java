package com.jisheng.filter;

import com.jisheng.po.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 进行用户登陆的拦截
 * 
 * @author 63023
 * 
 */
public class PrivilegeFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 权限控制
		// 1、获得当前请求访问资源路径
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		// 拦截未登陆的页面
		if (user == null) {
			if (path.equals("/checkcode") || path.equals("/register.jsp") || path.equals("/login.jsp")
					|| path.equals("/error.jsp") || path.equals("/login") || path.equals("/register")) {
				chain.doFilter(httpServletRequest, response);
				return;
			}
			// 未登陆--- 没有权限 --- 跳转到登陆页面
			request.setAttribute("msg", "您还没有登陆！");
			request.getRequestDispatcher("/login.jsp").forward(httpServletRequest, response);
			return;
		}
		// 存储上一个页面的URL,以便权限不足时可以跳回原来的页面
		chain.doFilter(httpServletRequest, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
