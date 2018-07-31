package com.jisheng.controller;

import com.jisheng.po.Customer;
import com.jisheng.po.Food;
import com.jisheng.po.Storer;
import com.jisheng.po.User;
import com.jisheng.service.*;
import com.jisheng.service.impl.ServiceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户登陆
 * 
 */
@WebServlet("/login123")
public class LoginServlet1 extends HttpServlet {
	/**
	 * 用户登陆
	 */
	private static final long serialVersionUID = 1L;
	private UserService userServ = ServiceFactory.UserServ.INSTANCE.getUserServ();
	private StorerService stoServ=ServiceFactory.StorerServ.INSTANCE.getStoreServ();
	private AdminService adminServ=ServiceFactory.AdminServ.INSTANCE.getAdminServ();
	private CustomerService cusServ = ServiceFactory.CusServ.INSTANCE.getCusService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 判断验证码输入是否正确
		String checkcode = request.getParameter("checkcode");
		String checkcode_session = (String) request.getSession().getAttribute("checkcodeSession");
		// 删除session中验证码
		request.getSession().removeAttribute("checkcodeSession");
		if (checkcode_session == null || !checkcode_session.equals(checkcode)) {
			// 传递错误信息给jsp
			request.setAttribute("username", request.getParameter("username"));
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		// 1 从请求获得数据
		User user = new User();
		boolean isTrue = false;
		String role = request.getParameter("roles");
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2 判断用户信息是否正确
		if (userServ.usernameIsExist(user)) {
			// 如果用户名存在
			if (userServ.checkLoginInfo(user)) {
				// 密码正确 --- 登陆成功
				user = userServ.getUserInfo(user);// 获得user完整信息
				List<String> roles = adminServ.lookRole(user);// 一个user可能有多个角色
				for (String rol : roles) {
					if (rol.equals(role))
						isTrue = true;
				}
				request.getSession().setAttribute("role", role);
				if (isTrue) {
					// 将用户信息 保存session
					request.getSession().setAttribute("user", user);
					request.getSession().setAttribute("username", user.getUsername());
					request.getSession().setAttribute("storers", stoServ.lookAll());
					switch (role) {
					// 如果为顾客，则将顾客信息存入session
					case "customer": {
						Customer customer = new Customer();
						customer.setUser_id(user.getUser_id());
						List<Customer> cus = cusServ.lookSomeOne(customer);
						if (cus == null)
							cus = new ArrayList<Customer>();// 防止cus为null
						if (cus.size() != 0)
							request.getSession().setAttribute("customer", cus.get(0));
						else
							//需要完善顾客信息才能真正拥有顾客角色
							request.getSession().setAttribute("customer", null);
					}
						response.sendRedirect("/CustomerPageServlet");
						// request.getRequestDispatcher("CustomerPageServlet").forward(request,
						// response);
						break;
					case "storer": {
						Storer storer = new Storer();
						storer.setUser_id(user.getUser_id());
						Storer sto = stoServ.lookSomeOne1(storer);
						FoodService foodServ = ServiceFactory.FoodServ.INSTANCE.getFoodService();
						Food food = new Food();
						if (sto != null) {
							food.setStore_id(sto.getStore_id());
							// 获得店铺中食物信息
							List<Food> foods = foodServ.lookSomeOne(food);
							request.getSession().setAttribute("foods", foods);
							request.getSession().setAttribute("storer", sto);
						}
					}
						response.sendRedirect("/StorerPageServlet");
						break;
					case "admin": {
						response.sendRedirect("/GetApplyServlet");
						return;
					}
					default:
					}
					// 跳转登陆成功系统主页
				} else {
					// 该用户无此角色
					request.setAttribute("msg", "该用户无此角色");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			} else {
				// 密码错误
				request.setAttribute("msg", "密码输入错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}

		} else {
			// 用户名不存在
			request.setAttribute("msg", "用户名不存在");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
