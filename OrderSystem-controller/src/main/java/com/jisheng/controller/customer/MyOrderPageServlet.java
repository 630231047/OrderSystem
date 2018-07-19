package com.jisheng.controller.customer;

import com.jisheng.po.Customer;
import com.jisheng.po.Order;
import com.jisheng.service.OrderService;
import com.jisheng.service.impl.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 获得不同状态的订单
 * @author 63023
 *
 */
@WebServlet("/MyOrderPageServlet")
public class MyOrderPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义pageSize为每页显示的件数
		int pageSize = 3;
		String operation = request.getParameter("operation");
		// 得到最新的不同状态的订单List
		OrderService orderServ = ServiceFactory.OrderServ.INSTANCE.getOrderService();
		Order order = new Order();
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		if(customer==null) {
			request.setAttribute("msg3", "请先完善个人信息");
			request.getRequestDispatcher("myOrderPage.jsp").forward(request, response);
		}
		order.setCustomer_id(customer.getId());
		List<Object[]> paidOrders = orderServ.lookCusStatusOrder(order, "已付款");// 得到状态为"已付款"的List
		List<Object[]> sendOrders = orderServ.lookCusStatusOrder(order, "已送达");// 得到状态为"已送达"的List
		List<Object[]> assessOrders = orderServ.lookCusStatusOrder(order, "已评价");// 得到状态为"已评价"的List
		// 将数据存到session中以便于在前端获取
		request.getSession().setAttribute("pageSize", pageSize);
		List<Object[]> orders = null;
		if (operation == null)
			operation = "";
		switch (operation) {
		case "1":
			orders = paidOrders;
			request.getSession().setAttribute("paidOrders", paidOrders);
			break;
		case "2":
			orders = sendOrders;
			request.getSession().setAttribute("sendOrders", sendOrders);
			break;
		case "3":
			orders = assessOrders;
			request.getSession().setAttribute("assessOrders", assessOrders);
			break;
		default:
			request.setAttribute("msg3", "请选择正确的操作");
			request.getRequestDispatcher("myOrderPage.jsp").forward(request, response);
			return;
		// List<Object[]>allOrders=(List<Object[]>)request.getSession().getAttribute("allOrders");
		}
		// 获取当前页的页数并转为int类型,最终将数据存到session中
		int pageNos;
		if (request.getParameter("pageNos") == null || Integer.parseInt(request.getParameter("pageNos")) < 1) {
			pageNos = 1;
		} else {
			pageNos = Integer.parseInt(request.getParameter("pageNos"));
		}
		request.getSession().setAttribute("pageNos", pageNos);
		int typeall = orders.size();
		int countPage = (typeall % pageSize == 0) ? (typeall / pageSize) : typeall / pageSize + 1;
		// 根据sql语句得到查询到的总条数，然后用总条数除每页的条数得到总页数,countPage为总页数
		request.getSession().setAttribute("countPage", countPage);
		switch (operation) {
		case "1":
			request.getRequestDispatcher("paidPage.jsp").forward(request, response);
			break;
		case "2":
			request.getRequestDispatcher("sentPage.jsp").forward(request, response);
			break;
		case "3":
			request.getRequestDispatcher("assessedPage.jsp").forward(request, response);
			break;
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
