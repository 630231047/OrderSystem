package com.jisheng.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoCacheFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		httpServletRequest.setCharacterEncoding("UTF-8");
		httpServletResponse.setContentType("text/html;charset=UTF-8");
		httpServletResponse.setHeader("Cache-control", "no-cache");
		httpServletResponse.setDateHeader("Expires", -1);
		httpServletResponse.setHeader("progma", "nocache");
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
