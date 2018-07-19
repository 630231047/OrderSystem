package com.jisheng.controller;

import com.jisheng.po.User;
import com.jisheng.service.AdminService;
import com.jisheng.service.UserService;
import com.jisheng.service.impl.AdminServiceImpl;
import com.jisheng.service.impl.ServiceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * 用户注册
 * 
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userServ = ServiceFactory.UserServ.INSTANCE.getUserServ();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 判断验证码输入是否正确
		String checkcode = request.getParameter("checkcode");
		String checkcode_session = (String) request.getSession().getAttribute("checkcodeSession");
		// 删除session中验证码
		request.getSession().removeAttribute("checkcodeSession");

		if (checkcode_session == null || !checkcode_session.equals(checkcode)) {
			// 验证码无效 -- 跳回login.jsp
			// response.sendRedirect("/day07/session/demo3/login.jsp");

			// 传递错误信息给jsp
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}

		// 1 从请求获得数据
		User user = new User();
		String rePassword = null;
		try {
			BeanUtils.populate(user, request.getParameterMap());
			rePassword = request.getParameter("rePassword");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2 判断用户信息是否正确
		if (!userServ.usernameIsExist(user)) {
			// 如果用户名不存在
			if (user.getPassword().equals(rePassword)) {
				// 密码确认一致
				boolean result = userServ.addUser(user);
				if (result)
				// 跳转登陆主页
				{
					user = userServ.getUserInfo(user);
					AdminService adminServ = new AdminServiceImpl();
					if (adminServ.addCusRole(user))
						request.setAttribute("msg", "注册成功");
					else
						request.setAttribute("msg", "注册失败");
				} else
					request.setAttribute("msg", "注册失败");
			} else {
				// 密码不一致
				// response.sendRedirect("/day07/session/demo3/login.jsp");
				request.setAttribute("msg", "密码输入不一致");
			}
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} else {
			// 用户名已存在
			// response.sendRedirect("/day07/session/demo3/login.jsp");
			request.setAttribute("msg", "用户名已存在");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
