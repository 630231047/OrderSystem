package com.jisheng.controller.customer;

import com.jisheng.po.Customer;
import com.jisheng.po.User;
import com.jisheng.service.CustomerService;
import com.jisheng.service.impl.ServiceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/CustomerServlet")
/**
 * 用来修改或增加顾客信息
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerService cusServ = ServiceFactory.CusServ.INSTANCE.getCusService();
		User user = (User) request.getSession().getAttribute("user");
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		if (customer == null) {
			try {
				customer = new Customer();
				BeanUtils.populate(customer, request.getParameterMap());
				customer.setUser_id(user.getUser_id());

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (cusServ.addCustomer(customer)) {
				request.setAttribute("msg2", "顾客添加成功");
				List<Customer> cus = cusServ.lookSomeOne(customer);
				if (cus.size() != 0)
					request.getSession().setAttribute("customer", cus.get(0));
				else
					request.getSession().setAttribute("customer", null);
				request.getRequestDispatcher("/customerregister.jsp").forward(request, response);
			} else {
				request.setAttribute("msg2", "顾客添加失败");
				request.getRequestDispatcher("/customerregister.jsp").forward(request, response);
			}
		} else {
			try {
				BeanUtils.populate(customer, request.getParameterMap());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (cusServ.updateCustomer(customer)) {
				request.setAttribute("msg3", "顾客修改成功");
				request.getSession().setAttribute("customer", customer);
				request.getRequestDispatcher("/customerregister.jsp").forward(request, response);
			} else {
				request.setAttribute("msg3", "顾客修改失败");
				request.getRequestDispatcher("/customerregister.jsp").forward(request, response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
