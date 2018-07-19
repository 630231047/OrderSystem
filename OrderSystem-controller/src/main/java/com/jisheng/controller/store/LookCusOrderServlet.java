package com.jisheng.controller.store;

import com.jisheng.po.Order;
import com.jisheng.po.Storer;
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
 * 获得顾客购买本店商品的信息
 * @author 63023
 *
 */
@WebServlet("/LookCusOrderServlet")
public class LookCusOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService orderServ = ServiceFactory.OrderServ.INSTANCE.getOrderService();
		Storer storer = (Storer) request.getSession().getAttribute("storer");
		Order order = new Order();
		order.setStore_id(storer.getStore_id());
		// 获得顾客购买本店商品的信息
		List<Object[]> orderPaidList = orderServ.lookCusPaidOrder(order);
		request.getSession().setAttribute("orderPaidList", orderPaidList);
		request.getRequestDispatcher("/lookOrder.jsp").forward(request, response);
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
