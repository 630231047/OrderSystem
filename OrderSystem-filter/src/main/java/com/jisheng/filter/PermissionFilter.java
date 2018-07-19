package com.jisheng.filter;

import com.jisheng.service.AdminService;
import com.jisheng.service.impl.ServiceFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 进行权限控制
 * 
 * @author 63023
 *
 */
@WebFilter("/PermissionFilter")
public class PermissionFilter implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// 获得当前请求访问资源路径
		String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
		AdminService adminServ = ServiceFactory.AdminServ.INSTANCE.getAdminServ();
		String roleName = adminServ.getPermRole(path);//在数据库中获取与该URL对应的角色名
		if (roleName == null) {
			chain.doFilter(httpServletRequest, response);
			return;
		}
			String getRoleName = (String) httpServletRequest.getSession().getAttribute("role");
			// 如果该URL符合该角色的权限,则放行
			if (roleName.equals(getRoleName)) {
				chain.doFilter(httpServletRequest, response);
			} else {
				httpServletRequest.setAttribute("msgPerError","您的权限不足");
				switch(getRoleName) {
				case "admin":
					httpServletRequest.getRequestDispatcher("/admin.jsp").forward(request, response);
					break;
				case "storer":
					httpServletRequest.getRequestDispatcher("/storerPage.jsp").forward(request, response);
					break;
				case "customer":
					httpServletRequest.getRequestDispatcher("/customerPage.jsp").forward(request, response);
					break;
				default:
					httpServletRequest.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				return;
			}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
